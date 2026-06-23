package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cargo;
import util.ConnectionFactory;


public class CargoDAO extends BaseDAO {
	
	private static final String LIST = """
			SELECT * FROM cargo
			ORDER BY carid
			""";
	private static final String ADD = """
			INSERTO INTO cargo (carnom, cardes, carsue, carestreg) VALUES (?, ?, ?, ?)
			""";
	private static final String MODIFY = """
			UPDATE cargo
			SET carnom = ?, cardes = ?, carsue = ? , carestreg = ?
			WHERE carid = ?
			""";
//	private static final String DELETE = """
//			
//			""";
	
	public static void list() throws SQLException {
		ArrayList<Cargo> items = new ArrayList<Cargo>();
		
//		String sql = LIST;
		
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, LIST);
				ResultSet rSet = ps.executeQuery();
				) {
			
			
		} catch (SQLException e) {
			
		}
	}
	
}
