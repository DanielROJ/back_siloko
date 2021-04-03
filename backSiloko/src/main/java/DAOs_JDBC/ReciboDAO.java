package DAOs_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReciboDAO {
	
	
private static Connection con;

	 
	private static void GetConnection() throws SQLException {
		if(con == null) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin_siloko","admin");;
		}
		
	}
	
	
	public static int ProcesoMasivoGenerarRecibos()throws SQLException, Exception{
		GetConnection();
		int response = 0;
		CallableStatement call_stm = con.prepareCall("{call ADMIN_SILOKO.BULLK_GENERA_RECIBOS(?)}"); 
		call_stm.registerOutParameter(1,2);
		call_stm.executeUpdate();
		response = call_stm.getInt(1);
		call_stm.close();
		
		return response;
	}

}
