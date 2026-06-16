package main;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.*;

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
