package com.co.app.sb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.app.sb.repository.FuncionarioAlmacenRepository;

@Service
public class FuncionarioAlmacenService {
	
	
	@Autowired
	private FuncionarioAlmacenRepository funcionarioAlmRep;
	
	
	
	
	public String getCorreoFuncionarioAlmacen(long codigo) throws Exception {
		return this.funcionarioAlmRep.findEmail(codigo).orElseThrow();
	}

}
