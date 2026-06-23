package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.ConnectionFactory;

public class BaseDAO {
	
	// Se sobreescribe los métodos Connection.getConnection y PreparedStatement.prepareStatement para adecuarse a la app
	protected Connection getConnection() throws SQLException {
		return ConnectionFactory.getConnection();
	}
	
	protected PreparedStatement prepareStatement(Connection cn, String sql) throws SQLException {
		return cn.prepareStatement(sql);
	}
	
}
