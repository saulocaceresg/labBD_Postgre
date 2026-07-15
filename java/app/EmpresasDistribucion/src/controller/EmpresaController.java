package controller;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.EmpresaDAO;
import model.Empresa;
import view.EmpresaForm;

public class EmpresaController {
// varaibles para conectar con las consultas SQL
	private static final String ADD = "ADD";
	private static final String MODIFY = "MODIFY";
	private static final String DELETE = "DELETE";
	private static final String INACTIVATE = "INACTIVATE";
	private static final String REACTIVATE = "REACTIVATE";
	
	private EmpresaForm empresaForm;
	private EmpresaDAO empresaDAO;
	private Empresa empresa;
	private byte empflaact = 0;
	private String pendingAction = "";
	private int selectId;
	
	public EmpresaController(EmpresaForm form) {
		this.empresaForm = form;
		this.empresaDAO = new EmpresaDAO();
	}
	
	public Empresa createEmpresa() {
		Empresa empresa = new Empresa();
		
		if (!empresaForm.getEmpid().isEmpty()) {
			empresa.setEmpid(Integer.parseInt(empresaForm.getEmpid()));
		}
		
		empresa.setTipid(empresaForm.getTipId());
		empresa.setEmpnom(empresaForm.getEmpnom());
		empresa.setEmpestreg(empresaForm.getEmpestreg());
		
		return empresa;
	}
	
	public void add() {
		//empresa = createCargo();
		pendingAction = ADD;
		empflaact = 1;
	}
	
	public void modify() {
		//empresa = createCargo();
		pendingAction = MODIFY;
		empflaact = 1;
	}
	
	public void delete(int id) {
		this.selectId = id;
		pendingAction = DELETE;
		empflaact = 1;
	}
	
	public void inactivate(int id) {
		this.selectId = id;
		pendingAction = INACTIVATE;
		empflaact = 1;
	}
	
	public void reactivate(int id) {
		this.selectId = id;
		pendingAction = REACTIVATE;
		empflaact = 1;
	}
	
	// método para actualizar los registros. Si la bandera está en 0 no hace nada, si no, según la acción pendiente interactúa con la BD
	public void update() {
		if (empflaact == 0) {
			aviso();
			return;
		}
		
		try {
			if (pendingAction == ADD || pendingAction == MODIFY) {
				empresa = createEmpresa();
			}
			switch (pendingAction) {
				case ADD: 
					empresaDAO.add(empresa);
					break;
				case MODIFY:
					empresaDAO.modify(empresa);
					break;
				case DELETE:
					empresaDAO.delete(selectId);
					break;
				case INACTIVATE:
					empresaDAO.inactivate(selectId);
					break;
				case REACTIVATE:
					empresaDAO.reactivate(selectId);
					break;
			}
			
			empflaact = 0;
			pendingAction = "";
			empresa = null;
			selectId = 0;
			
			JOptionPane.showMessageDialog(
					empresaForm,
					"Registro actualizado exitosamente"
					);
			loadTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(empresaForm, "ERROR AL ACTUALIZAR REGISTRO: " + e.getMessage());
		}
		
	}
	
	public void cancel() {
		empresa = null;
		pendingAction = "";
		empflaact = 0;
	}
	
	private void aviso() {
	    JOptionPane.showOptionDialog(
	            empresaForm,
	            "No se ha seleccionado un comando para actualizar un registro de la BD",
	            "Actualizar",
	            JOptionPane.DEFAULT_OPTION,
	            JOptionPane.WARNING_MESSAGE,
	            null,
	            new Object[] { "Cancelar" },
	            "Cancelar"
	    );
	}
	
	public void loadTable() {
		try {
			ArrayList<Empresa> cargos = EmpresaDAO.list(); // carga los cargos con el arraylist
			empresaForm.loadTable(cargos);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					empresaForm,
					"Error al cargar registros de la base de datos",
					"Error",
					JOptionPane.ERROR_MESSAGE
			);
//			
//			e.printStackTrace();
		}
	}
}
