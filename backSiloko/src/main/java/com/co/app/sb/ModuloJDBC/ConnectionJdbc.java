package com.co.app.sb.ModuloJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionJdbc {
	
	public static Connection GenerateConnection() {
		try {
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin_siloko","admin");
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
}
