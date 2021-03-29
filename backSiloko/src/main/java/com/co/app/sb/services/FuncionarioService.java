package com.co.app.sb.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.FuncionarioDto;
import com.co.app.sb.Mappers.FuncionarioMapper;
import com.co.app.sb.model.Funcionario;
import com.co.app.sb.repository.FuncionarioRepository;
import com.co.app.sb.util.LoginException;

/**
 * 
 * Clase de servicio, encargada de la gestion de los funcionarios Siloko
 * 
 * @author German Daniel Rojas
 *
 */

@Service
public class FuncionarioService {

	
	@Autowired
	private FuncionarioRepository funcionarioRep;
	
	@Autowired
	private FuncionarioMapper funcionarioMapper;
	
	
	/**
	 * Metodo  que permite traer todos los funcionarios de la BD !!CIUDADO!!
	 * @return List<FuncionarioDto>
	 * @throws Exception
	 */
	public List<FuncionarioDto> getListFuncionarios() throws Exception{
		return this.funcionarioMapper.entityListToDtoList(this.funcionarioRep.findAll());
	}
	
	
	/**
	 * Metodo que retorna y busca un Funcionario
	 * @param idFuncionario long // id tipo identity en la base de datos
	 * @return FuncionarioDto
	 * @throws NoSuchElementException
	 */
	public FuncionarioDto getFuncionario(long idFuncionario) throws NoSuchElementException, Exception{
		Funcionario funcionarioTmp  = this.funcionarioRep.findById(idFuncionario).orElseThrow();
		if(funcionarioTmp.equals(null)) {
			return null;
		}else {
			FuncionarioDto funcionarioDtoTmp = this.funcionarioMapper.toDto(funcionarioTmp);
			return funcionarioDtoTmp;
		}
	}
	
	public FuncionarioDto getFuncionarioByCodigoEmpleado(long codigoFuncionario) throws Exception{
		Funcionario funcionarioTmp  = this.funcionarioRep.findBycodigoEmpleado(codigoFuncionario).orElseThrow();
		if(funcionarioTmp.equals(null)) {
			return null;
		}else {
			FuncionarioDto funcionarioDtoTmp = this.funcionarioMapper.toDto(funcionarioTmp);
			return funcionarioDtoTmp;
		}
	}
	
	
	
	public boolean getExistFuncionario(long idFuncionario) throws Exception{
		return this.funcionarioRep.existsById(idFuncionario);
	}
	
	
	/**
	 * Metodo que permite encontrar el email del funcionario basado en su codigo_empleado
	 * @param codigoFuncionario long // codigo unico empleado 
	 * @return String
	 * @throws Exception
	 */
	public String getCorreoFuncionario(long codigoFuncionario) throws Exception{
		return this.funcionarioRep.findEmail(codigoFuncionario).orElseThrow(()-> new LoginException());
	}
	
	
	
	
}
