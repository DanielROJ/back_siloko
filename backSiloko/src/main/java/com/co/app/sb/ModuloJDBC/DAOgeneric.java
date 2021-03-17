package com.co.app.sb.ModuloJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOgeneric<T> {

	private Connection con;
	private PreparedStatement prepareStm;
	private String nombreTabla;
	private Class<T> classObject;
	
	

	public DAOgeneric(String nombreTabla, Class<T> classObject) {
		super();
		this.nombreTabla = nombreTabla;
		this.classObject = classObject;
	}



	public T findElementByColumn(long id, String nameColumn) {
		try {
			this.con = ConnectionJdbc.GenerateConnection();
			try {

				prepareStm = con.prepareStatement("select * from " + nombreTabla + " where " + nameColumn + " = ?");
				prepareStm.setLong(1, id);
				ResultSet rel = prepareStm.executeQuery();
				while(rel.next()) {
					System.out.println(rel.getString("correo"));
				}
				return null;
			} finally {
				if (con != null)
					con.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception Occured "+e.getMessage());
			return null;
		}
	}

}
