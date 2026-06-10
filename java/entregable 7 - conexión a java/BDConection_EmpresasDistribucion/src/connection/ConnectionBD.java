package connection;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionBD {

	public static void main(String[] args) {
		
		Connection connect = null;
		
		final String url = "jdbc:postgresql://localhost:5432/"; // 5432: puerto por defecto de postgresql
		final String dbName = "BD_EMPRESAS_DISTRIBUCION";
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
	
	public static void insercion(Connection connect) throws SQLException {
		String sql = "INSERT INTO region (regnom, regestreg) VALUES (?, ?)";
		PreparedStatement stmt = connect.prepareStatement(sql);
		stmt.setString(1, "Arequipa");
		stmt.setCh
	}

}
