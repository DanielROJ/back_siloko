package com.co.app.sb.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.CupoCreditoDto;
import com.co.app.sb.Mappers.CupoCreditoMapper;
import com.co.app.sb.controllers.LoginController;
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
	
	private Logger log = Logger.getLogger(CupoCreditoService.class.getName());
	
	public CupoCreditoDto BloquearCupo(long idCliente, long idFuncionario) throws Exception {
		CupoCredito cupo = this.cupoCreditoRe.CupoCreditoCliente(idCliente).orElseThrow();
		EstadoCupo  estadoCupo = this.estadoCupoRep.findByestado("Bloqueado").orElseThrow();
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
	
	
	public List<CupoCredito> listCupoCredito(){
		return this.cupoCreditoRe.findAll();
	};

}
