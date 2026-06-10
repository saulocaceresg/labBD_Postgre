package connection;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {

	public static void main(String[] args) {
		
		Connection connect = null;
		String jdbc = "jdbc:postgresql://localhost:3306/BD_EMPRESAS_DISTRIBUCION";
		
		final String url = "jdbc:postgresql://localhost:5432/"; // 5432: puerto por defecto de postgresql
		final String dbName = "BD_EMPRESAS_DISTRIBUCION";
		final String drive = "com.postgres.Driver";
		final String userName = "postgres";
		final String password = "deuX?49mAR";
		
		try {
			connect = DriverManager.getConnection(url + dbName, userName, password);
			System.out.println("Estoy dentro.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connect != null) {
				try {
					connect.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		}

	}

}
