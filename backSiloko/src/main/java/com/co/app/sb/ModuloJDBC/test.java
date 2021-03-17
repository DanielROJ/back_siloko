package com.co.app.sb.ModuloJDBC;

import com.co.app.sb.model.Cliente;

public class test {

	public static void main(String[] args) {
		 DAOgeneric<Cliente> dao = new DAOgeneric<Cliente>("cliente", Cliente.class);
		dao.findElementByColumn(11, "id_cliente");
		 //System.out.println(cl.getNombres());
	}
}
