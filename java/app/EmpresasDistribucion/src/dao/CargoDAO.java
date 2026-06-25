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
	
	public ArrayList<Cargo> list() throws SQLException {
		ArrayList<Cargo> items = new ArrayList<Cargo>();
		
//		String sql = LIST;
		
		try (
				Connection cn = getConnection(); // Se conecta a la BD con el método de ConnectionFactory
				PreparedStatement ps = prepareStatement(cn, LIST); // PreparedStatement para la consulta
				ResultSet rs = ps.executeQuery(); // Almacena datos consultados
				) {
			// Añade todos los registros consultados al ArrayList
			while (rs.next()) {
				Cargo cargo = new Cargo();
				
				cargo.setCarid(rs.getInt("carid"));
				cargo.setCarnom(rs.getString("carnom"));
				cargo.setCardes(rs.getString("cardes"));
				cargo.setCarsue(rs.getBigDecimal("carsue"));
				cargo.setCarestreg(rs.getString("carestreg"));
				
				items.add(cargo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
}
