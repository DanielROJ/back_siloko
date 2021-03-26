package DAOs_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CupoCreditoDAO {
	
	private static Connection con;

	
	private static void GetConnection() throws SQLException {
		if(con == null) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin_siloko","admin");;
		}
		
	}
	
	
	
	public static int GenerarCupoCreditoCliente(long idCliente) {
		try {
				GetConnection();
				int response = 0;
				
				CallableStatement call_stm = con.prepareCall("{call ADMIN_SILOKO.CALCULO_CUPO(?,?)}"); 
				call_stm.setLong(1, idCliente);
				call_stm.registerOutParameter(2,2);
				call_stm.executeUpdate();
				response = call_stm.getInt(2);
				call_stm.close();
				
				return response;
			
		} catch (SQLException e) {
			System.out.println("Exception Occured "+e.getMessage());
			return 0;
		}
	}
	
	
	
	

}
