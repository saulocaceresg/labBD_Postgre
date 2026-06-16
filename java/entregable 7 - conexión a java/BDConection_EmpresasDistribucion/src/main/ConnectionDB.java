package main;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {

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
			 insercion(connect);
			// insercionTablaM(connect);
			
			// consulta de actualización
			// updateTablaR(connect);
			// updateTablaM(connect);
			
			// consulta de selección
			// selectTablaR(connect);
			// selectTablaM(connect);
			
			// consulta de eliminación
			// delete(connect);
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
	
	public static void updateTablaM(Connection connect) throws SQLException {
		String sql = "UPDATE empresa SET empestreg = ? WHERE empid = ?"; // consulta plantilla
		PreparedStatement stmt = connect.prepareStatement(sql); // statement para la conexión
		
		// Valores actualizados
		stmt.setString(1, "I"); // registro inactivo
		stmt.setInt(2, 1); // la primera fila
		
		int count = stmt.executeUpdate();
		
		System.out.println("REGISTROS ACTUALIZADOS: " + count);
		
		stmt.close();
	}
	
	public static void selectTablaR(Connection connect) throws SQLException {
		String sql = "SELECT * FROM region";

		PreparedStatement ps = connect.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

		    int regid = rs.getInt("regid");
		    String regnom = rs.getString("regnom");
		    String regdes = rs.getString("regdes");
		    String regestreg = rs.getString("regestreg");

		    System.out.println(
		        regid + " - " +
		        regnom + " - " +
		        regdes + " - " +
		        regestreg
		    );
		}

		rs.close();
		ps.close();
	}
	
	public static void selectTablaM(Connection connect) throws SQLException {
		String sql = "SELECT * FROM empresa";

		PreparedStatement ps = connect.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

		    int empid = rs.getInt("empid");
		    String empnom = rs.getString("empnom");
		    String emptip = rs.getString("emptip");
		    String empestreg = rs.getString("empestreg");

		    System.out.println(
		        empid + " - " +
		        empnom + " - " +
		        emptip + " - " +
		        empestreg
		    );
		}

		rs.close();
		ps.close();
	}
	
	public static void delete(Connection connect) throws SQLException {
		String sql = "TRUNCATE TABLE empresa CASCADE";

		PreparedStatement ps = connect.prepareStatement(sql);

		int filas = ps.executeUpdate();

		System.out.println("Registros eliminados: " + filas);

		ps.close();
	}
}
