package com.co.app.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.DTOs.FuncionarioAlmacenDto;
import com.co.app.sb.Mappers.FuncionarioAlmacenMapper;
import com.co.app.sb.model.FuncionarioAlmacen;
import com.co.app.sb.repository.FuncionarioAlmacenRepository;

@Service
public class FuncionarioAlmacenService {
	
	
	@Autowired
	private FuncionarioAlmacenRepository funcionarioAlmRep;
	
	@Autowired
	private FuncionarioAlmacenMapper funcionarioMapper;
	
	
	public String getCorreoFuncionarioAlmacen(long codigo) throws Exception {
		return this.funcionarioAlmRep.findEmail(codigo).orElseThrow();
	}
	
	
	public boolean getExistFuncionarioAlmacen(long idFuncionario) throws Exception{
		return this.funcionarioAlmRep.existsById(idFuncionario);
	}
	

	public FuncionarioAlmacenDto getFuncionarioByCodigo(long codigo) throws Exception{
		FuncionarioAlmacen funcionario = this.funcionarioAlmRep.findBycodigoEmpleado(codigo).orElseThrow();
		return this.funcionarioMapper.toDto(funcionario);
	}
	

}
