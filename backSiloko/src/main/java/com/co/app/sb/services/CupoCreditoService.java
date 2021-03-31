package com.co.app.sb.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.CupoCreditoDto;
import com.co.app.sb.Mappers.CupoCreditoMapper;
import com.co.app.sb.model.CupoCredito;
import com.co.app.sb.model.EstadoCupo;
import com.co.app.sb.model.Funcionario;
import com.co.app.sb.model.FuncionarioLog;
import com.co.app.sb.model.TipoLog;
import com.co.app.sb.repository.CupoCreditoRepository;
import com.co.app.sb.repository.EstadoCupoRepository;
import com.co.app.sb.repository.FuncionarioLogRepository;
import com.co.app.sb.repository.FuncionarioRepository;
import com.co.app.sb.repository.TipoLogRepository;
import com.co.app.sb.util.GeneracionCupoException;

import DAOs_JDBC.CupoCreditoDAO;

@Service
public class CupoCreditoService {

	@Autowired
	private CupoCreditoRepository cupoCreditoRe;

	@Autowired
	private EstadoCupoRepository estadoCupoRep;

	@Autowired
	private CupoCreditoMapper cupoCreditoMapper;

	@Autowired
	private FuncionarioLogRepository funcionarioLogRep;

	@Autowired
	private TipoLogRepository tipoLogRep;

	@Autowired
	private FuncionarioRepository funcionarioRep;

	@Autowired
	private ClienteService clienteService;

	private Logger log = Logger.getLogger(CupoCreditoService.class.getName());

	public CupoCreditoDto BloquearCupo(long idCliente, long idFuncionario) throws Exception {
		CupoCredito cupo = this.cupoCreditoRe.CupoCreditoCliente(idCliente).orElseThrow();
		EstadoCupo estadoCupo = this.estadoCupoRep.findByestado("Bloqueado").orElseThrow();
		TipoLog tipoLog = this.tipoLogRep.findById(1).orElseThrow();
		Funcionario funcionario = this.funcionarioRep.findById(idFuncionario).orElseThrow();
		cupo.setEstadoCupo(estadoCupo);
		cupo = this.cupoCreditoRe.save(cupo);
		this.cupoCreditoRe.flush();

		FuncionarioLog funLog = new FuncionarioLog();
		funLog.setCupoCredito(cupo);
		funLog.setFuncionario(funcionario);
		funLog.setTipoLog(tipoLog);
		this.funcionarioLogRep.save(funLog);
		this.funcionarioLogRep.flush();

		return this.cupoCreditoMapper.toDto(cupo);
	}

	public CupoCreditoDto DesbloquearCupo(long idCliente, long idFuncionario) throws Exception {
		CupoCredito cupo = this.cupoCreditoRe.CupoCreditoCliente(idCliente).orElseThrow();
		EstadoCupo estadoCupo = this.estadoCupoRep.findByestado("Activo").orElseThrow();
		TipoLog tipoLog = this.tipoLogRep.findById(3).orElseThrow();
		Funcionario funcionario = this.funcionarioRep.findById(idFuncionario).orElseThrow();
		cupo.setEstadoCupo(estadoCupo);
		cupo = this.cupoCreditoRe.save(cupo);
		this.cupoCreditoRe.flush();

		FuncionarioLog funLog = new FuncionarioLog();
		funLog.setCupoCredito(cupo);
		funLog.setFuncionario(funcionario);
		funLog.setTipoLog(tipoLog);
		this.funcionarioLogRep.save(funLog);
		this.funcionarioLogRep.flush();

		return this.cupoCreditoMapper.toDto(cupo);
	}

	/**
	 * Metodo que invoca el proceso PLSQL, para generar el cupo creticio de un cliente 
	 * @param idCliente id en base de datos de un cliente
	 * @param idFuncionario id en base de datos del funcionario
	 * @return CupoCreditoDto
	 * @throws Exception
	 */
	public CupoCreditoDto GenerarCupoCliente(long idCliente, long idFuncionario) throws Exception {

		boolean existClient = this.clienteService.getExistClient(idCliente);
		if (existClient) {
			int execute = CupoCreditoDAO.GenerarCupoCreditoCliente(idCliente);

			if (execute < 1) {
				throw new GeneracionCupoException();
			} else {
				CupoCredito cupo = this.cupoCreditoRe.CupoCreditoCliente(idCliente).orElseThrow();
				Funcionario funcionario = this.funcionarioRep.findById(idFuncionario).orElseThrow();
				TipoLog tipoLog = this.tipoLogRep.findById(4).orElseThrow();
				this.funcionarioLogRep.save(new FuncionarioLog(tipoLog, funcionario, cupo));
				this.funcionarioLogRep.flush();
				return this.cupoCreditoMapper.toDto(cupo);
			}

		} else {

			throw new NoSuchElementException();

		}
	}
	
	
	
	/**
	 * Meotod que permite actualizar el cupo asignado a un cliente de forma manual.
	 * @param idFuncionario
	 * @param idCupoCredito
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public CupoCreditoDto AsignarCupoCreditoManual(long idFuncionario, long idCupoCredito, BigDecimal valor) throws Exception {
		if(this.cupoCreditoRe.existsById(idCupoCredito)) {
			this.cupoCreditoRe.UpdateCupoAsignado(valor, idCupoCredito);
			CupoCredito cupo = this.cupoCreditoRe.findById(idCupoCredito).orElseThrow();
			Funcionario funcionario = this.funcionarioRep.findById(idFuncionario).orElseThrow();
			TipoLog tipoLog = this.tipoLogRep.findById(2).orElseThrow();
			this.funcionarioLogRep.save(new FuncionarioLog(tipoLog, funcionario, cupo));
			this.funcionarioLogRep.flush();
			return this.cupoCreditoMapper.toDto(cupo);
			
		}else {
			
			throw new NoSuchElementException();
			
		}
	
	}
	
	
	/**
	 * Meotodo que permite actualizar el cupo de credito utlizado.
	 * @param idCupoCredito
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public boolean UpdateCupoUso(long idCupoCredito, BigDecimal valor)  throws Exception{
		if(this.cupoCreditoRe.existsById(idCupoCredito)) {
			this.cupoCreditoRe.UpdateValorUsoCupo(valor, idCupoCredito);
			this.cupoCreditoRe.flush();
			return true;
		}else {
			
			throw new NoSuchElementException();
			
		}
	}
	
	
	

	/**
	 * Metodo que retorna todos los cupos de credito dentro e l abse de datos !!cuidado!!!
	 * @return
	 */
	public List<CupoCredito> listCupoCredito() {
		return this.cupoCreditoRe.findAll();
	};

}
