package DAOs_JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.Map;


public class SolicitudCreditoDAO {
	
private static Connection con;

	 
	private static void GetConnection() throws SQLException {
		if(con == null) {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","admin_siloko","admin");;
		}
		
	}
	
	
	
	public static Long GenerarSolicitudCreditoCliente(long idCliente, long idFuncionario, long idProducto,String codigoCredito) throws SQLException, Exception {
				GetConnection();
				long idEstadoCredito = 0;
				long status = 0;
				
				CallableStatement call_stm = con.prepareCall("{call ADMIN_SILOKO.GENERAR_SOLICITUD(?,?,?,?,?)}"); 
				call_stm.setLong(1, idCliente);
				call_stm.setLong(2, idFuncionario);
				call_stm.setLong(3, idProducto);
				call_stm.setString(4, codigoCredito);
				
				call_stm.registerOutParameter(5,2);
				call_stm.executeUpdate();
				idEstadoCredito = call_stm.getLong(5);
				call_stm.close();
				
				return idEstadoCredito;
			
		
	}

}
