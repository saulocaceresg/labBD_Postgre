package main;


import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import util.Configuration;
//import javax.swing.*;

public class ConnectionDB {

	// Obtención de datos de conexión (ocultos :D)
	private static final String URL = Configuration.getProperties("URL");
	private static final String USER = Configuration.getProperties("USER");
	private static final String PASSWORD = Configuration.getProperties("PASSWORD");
	
	public static void main(String[] args) {
		
		Connection cn = null;
		
		try {
			cn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("CONEXIÓN LOGRADA.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			if (connect != null) {
//				try {
//					connect.close();
//				} catch (SQLException e2) {
//					e2.printStackTrace();
//				}
//			}
			
		}

	}
	
}
