package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	// Rehusado de ConnectionDB y obtenido de Configuration
	private static final String URL = Configuration.getProperties("URL");
	private static final String USER = Configuration.getProperties("USER");
	private static final String PASSWORD = Configuration.getProperties("PASSWORD");
	
	// Método para conectar con al BD. Será usado por los DAO.
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
}
