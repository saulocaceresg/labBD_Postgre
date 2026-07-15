package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Empresa;
import model.Empresa;

public class EmpresaDAO extends BaseDAO {
	
	private static final String LIST = """
			SELECT * FROM empresa
			ORDER BY emptip
			""";
	private static final String ADD = """
			INSERT INTO empresa (emptip, empnom, empestreg) VALUES (?, ?, ?)
			""";
	private static final String MODIFY = """
			UPDATE empresa
			SET emptip = ?, empnom = ?
			WHERE emptip = ?
			""";
	private static final String CHANGE_STATUS = """
			UPDATE empresa
			SET empestreg = ?
			WHERE emptip = ?
			""";
//	private static final String DELETE = """
//			
//			""";
	
	// list para listar los ítemes en la app
	public static ArrayList<Empresa> list() throws SQLException {
		ArrayList<Empresa> items = new ArrayList<Empresa>();
		
		try (
				Connection cn = getConnection(); // Se conecta a la BD con el método de ConnectionFactory
				PreparedStatement ps = prepareStatement(cn, LIST); // PreparedStatement para la consulta
				ResultSet rs = ps.executeQuery(); // Almacena datos consultados
				) {
			// Añade todos los registros consultados al ArrayList
			while (rs.next()) {
				Empresa empresa = new Empresa();
				
				empresa.setEmpid(rs.getInt("emptip"));
				empresa.setEmpnom(rs.getString("empnom"));
				empresa.setEmpestreg(rs.getString("empestreg"));
				
				items.add(empresa);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return items;
	}
	
	public void add(Empresa empresa) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, ADD);
				) {
                    ps.setInt(1, empresa.getTipid());
                    ps.setString(2, empresa.getEmpnom());
                    ps.setString(3, empresa.getEmpestreg());
			
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void modify(Empresa empresa) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, MODIFY)
				) {
			
			ps.setString(1, empresa.getEmpnom());
			ps.setString(2, empresa.getEmpnom());
            ps.setString(3, empresa.getEmpestreg());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void delete(int emptip) throws SQLException {
		changeStatus(emptip, "*");
	}
	
	public void inactivate(int emptip) throws SQLException {
		changeStatus(emptip, "I");
	}
	
	public void reactivate(int emptip) throws SQLException {
		changeStatus(emptip, "A");
	}
	
	// Método para modifica el estado de registro
	private void changeStatus(int emptip, String empestreg) throws SQLException {
		try (
				Connection cn = getConnection();
				PreparedStatement ps = prepareStatement(cn, CHANGE_STATUS);
				) {
			
			ps.setString(1, empestreg);
			ps.setInt(2, emptip);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void close() {
		
	}
}
