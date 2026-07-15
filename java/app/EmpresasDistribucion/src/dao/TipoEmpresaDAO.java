package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TipoEmpresa;


public class TipoEmpresaDAO extends BaseDAO {
	
	private static final String LIST = """
			SELECT * FROM tipo_empresa
			ORDER BY tipid
			""";
	private static final String ADD = """
			INSERT INTO tipo_empresa (tipnom, tipestreg) VALUES (?, ?)
			""";
	private static final String MODIFY = """
			UPDATE tipo_empresa
			SET tipnom = ?
			WHERE tipid = ?
			""";
	private static final String CHANGE_STATUS = """
			UPDATE tipo
			SET tipestreg = ?
			WHERE tipid = ?
			""";
//	private static final String DELETE = """
//			
//			""";
	
	// list para listar los ítemes en la app
	public static ArrayList<TipoEmpresa> list() throws SQLException {
		ArrayList<TipoEmpresa> items = new ArrayList<TipoEmpresa>();
		
		try (
				Connection cn = getConnection(); // Se conecta a la BD con el método de ConnectionFactory
				PreparedStatement ps = prepareStatement(cn, LIST); // PreparedStatement para la consulta
				ResultSet rs = ps.executeQuery(); // Almacena datos consultados
				) {
			// Añade todos los registros consultados al ArrayList
			while (rs.next()) {
				TipoEmpresa cargo = new TipoEmpresa();
				
				cargo.setTipid(rs.getInt("tipid"));
				cargo.setTipnom(rs.getString("tipnom"));
				cargo.setTipestreg(rs.getString("tipestreg"));
				
				items.add(cargo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
	public void add(TipoEmpresa tipo) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, ADD);
				) {
			ps.setString(1, tipo.getTipnom());
			ps.setString(2, tipo.getTipestreg());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void modify(TipoEmpresa tipo) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, MODIFY)
				) {
			
			ps.setString(1, tipo.getTipnom());
			ps.setInt(2, tipo.getTipid());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void delete(int tipid) throws SQLException {
		changeStatus(tipid, "*");
	}
	
	public void inactivate(int tipid) throws SQLException {
		changeStatus(tipid, "I");
	}
	
	public void reactivate(int tipid) throws SQLException {
		changeStatus(tipid, "A");
	}
	
	// Método para modifica el estado de registro
	private void changeStatus(int tipid, String tipestreg) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, CHANGE_STATUS);
				) {
			
			ps.setString(1, tipestreg);
			ps.setInt(2, tipid);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void close() {
		
	}
}
