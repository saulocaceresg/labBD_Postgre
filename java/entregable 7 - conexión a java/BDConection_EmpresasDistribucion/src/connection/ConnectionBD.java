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
			System.out.println("CONEXIÓN LOGRADA.");
			
			// consulta de inserción
			//	insercion(connect);
			// insercionTablaM(connect);
			updateTablaR(connect);
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
		String sql = "INSERT INTO region (regnom, regestreg) VALUES (?, ?)"; // consulta plantilla
		PreparedStatement stmt = connect.prepareStatement(sql); // statement para la conexión
		// Valores insertados		
		stmt.setString(1, "Lima");
		stmt.setString(2, String.valueOf('A')); // se convierte el string a su valor UNICODE para guardarlo como CHAR
		
		int count = stmt.executeUpdate();
		
		System.out.println("Inserción completada: " + count);
		
		stmt.close();
	}
	
	public static void insercionTablaM(Connection connect) throws SQLException {
		String sql = "INSERT INTO empresa (empnom, emptip, empestreg) VALUES (?, ?, ?)"; // consulta plantilla
		PreparedStatement stmt = connect.prepareStatement(sql); // statement para la conexión
		// Valores insertados
		stmt.setString(1, "Jandy");
		stmt.setInt(2, 1);
		stmt.setString(3, String.valueOf('A')); // se convierte el string a su valor UNICODE para guardarlo como CHAR
		
		int count = stmt.executeUpdate();
		
		System.out.println("Inserción completada: " + count);
		
		stmt.close();
	}
	
	public static void updateTablaR(Connection connect) throws SQLException {
		String sql = "UPDATE tipo_empresa SET tipnom = ? WHERE tipid = ?"; // consulta plantilla
		PreparedStatement stmt = connect.prepareStatement(sql); // statement para la conexión
		
		// Valores actualizados
		stmt.setString(1, "Juguetes");
		stmt.setInt(2, 2);
		
		int count = stmt.executeUpdate();
		
		System.out.println("REGISTROS ACTUALIZADOS: " + count);
		
		stmt.close();
	}

}
