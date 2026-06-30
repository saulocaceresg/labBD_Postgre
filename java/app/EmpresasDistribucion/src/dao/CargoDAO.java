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
			INSERT INTO cargo (carnom, cardes, carsue, carestreg) VALUES (?, ?, ?, ?)
			""";
	private static final String MODIFY = """
			UPDATE cargo
			SET carnom = ?, cardes = ?, carsue = ?
			WHERE carid = ?
			""";
	private int carflaact = 1;
//	private static final String DELETE = """
//			
//			""";
	
	// list para listar los ítemes en la app
	public ArrayList<Cargo> list() throws SQLException {
		ArrayList<Cargo> items = new ArrayList<Cargo>();
		
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
	
	public void add(Cargo cargo) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, ADD);
				) {
			ps.setString(1, cargo.getCarnom());
			ps.setString(2, cargo.getCardes());
			ps.setBigDecimal(3, cargo.getCarsue());
			ps.setString(4, cargo.getCarestreg());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Cargo cargo) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, MODIFY)
				) {
			
			ps.setString(1, cargo.getCarnom());
			ps.setString(2, cargo.getCardes());
			ps.setBigDecimal(3, cargo.getCarsue());
			ps.setInt(4, cargo.getCarid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Cargo cargo) throws SQLException {
		try (
				Connection cn = getConnection();
				) {
			
			cargo.setCarestreg("*");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void inactivate(Cargo cargo) throws SQLException {
		try (
				Connection cn = getConnection()
				) {
			
			cargo.setCarestreg("I");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void reactivate(Cargo cargo) throws SQLException {
		try (
				Connection cn = getConnection();
				) {
			
			cargo.setCarestreg("A");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
