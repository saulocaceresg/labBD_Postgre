package main;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
		
		System.out.println("+----------------- CONEXIÓN A LA BASE DE DATOS -----------------+");
		try {
			System.out.println("Conectando...");
			cn = DriverManager.getConnection(URL, USER, PASSWORD);
			DatabaseMetaData metaData = cn.getMetaData();
			
			System.out.println("¡CONEXIÓN LOGRADA!");
			String bd = cn.getCatalog();
			
			System.out.println("Base de datos: " + bd + "\nMotor: " + metaData.getDatabaseProductName());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			
		}

	}
	
}
