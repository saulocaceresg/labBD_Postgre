package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.TipoEmpresaDAO;
import model.TipoEmpresa;
import view.TipoForm;

public class TipoEmpresaController {
	// varaibles para conectar con las consultas SQL
	private static final String ADD = "ADD";
	private static final String MODIFY = "MODIFY";
	private static final String DELETE = "DELETE";
	private static final String INACTIVATE = "INACTIVATE";
	private static final String REACTIVATE = "REACTIVATE";
	
	private TipoForm tipoForm;
	private TipoEmpresaDAO tipoDAO;
	private TipoEmpresa tipo;
	private byte tipflaact = 0;
	private String pendingAction = "";
	private int selectId;
	
	public TipoEmpresaController(TipoForm form) {
		this.tipoForm = form;
		this.tipoDAO = new TipoEmpresaDAO();
	}
	
	public TipoEmpresa createTipo() {
		TipoEmpresa cargo = new TipoEmpresa();
		
		if (!tipoForm.getTipid().isEmpty()) {
			cargo.setTipid(Integer.parseInt(tipoForm.getTipid()));
		}
		
//		if (carsue.abs().compareTo(new BigDecimal("99999.99")) > 0) {
//			JOptionPane.showMessageDialog(cargoForm,
//					"El sueldo debe ser menor a 100000",
//					"Validación",
//					JOptionPane.WARNING_MESSAGE
//			);
//			return null;
//		}
		
		cargo.setTipnom(tipoForm.getTipnom());
		cargo.setTipestreg(tipoForm.getTipestreg());
		
		return cargo;
	}
	
	public void add() {
		//cargo = createCargo();
		pendingAction = ADD;
		tipflaact = 1;
	}
	
	public void modify() {
		//cargo = createCargo();
		pendingAction = MODIFY;
		tipflaact = 1;
	}
	
	public void delete(int id) {
		this.selectId = id;
		pendingAction = DELETE;
		tipflaact = 1;
	}
	
	public void inactivate(int id) {
		this.selectId = id;
		pendingAction = INACTIVATE;
		tipflaact = 1;
	}
	
	public void reactivate(int id) {
		this.selectId = id;
		pendingAction = REACTIVATE;
		tipflaact = 1;
	}
	
	// método para actualizar los registros. Si la bandera está en 0 no hace nada, si no, según la acción pendiente interactúa con la BD
	public void update() {
		if (tipflaact == 0) {
			aviso();
			return;
		}
		
		try {
			if (pendingAction == ADD || pendingAction == MODIFY) {
				tipo = createTipo();
			}
			switch (pendingAction) {
				case ADD: 
					tipoDAO.add(tipo);
					break;
				case MODIFY:
					tipoDAO.modify(tipo);
					break;
				case DELETE:
					tipoDAO.delete(selectId);
					break;
				case INACTIVATE:
					tipoDAO.inactivate(selectId);
					break;
				case REACTIVATE:
					tipoDAO.reactivate(selectId);
					break;
			}
			
			tipflaact = 0;
			pendingAction = "";
			tipo = null;
			selectId = 0;
			
			JOptionPane.showMessageDialog(
					tipoForm,
					"Registro actualizado exitosamente"
					);
			loadTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(tipoForm, "ERROR AL ACTUALIZAR REGISTRO: " + e.getMessage());
		}
		
	}
	
	public void cancel() {
		tipo = null;
		pendingAction = "";
		tipflaact = 0;
	}
	
	private void aviso() {
	    JOptionPane.showOptionDialog(
	            tipoForm,
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
			ArrayList<TipoEmpresa> tipos = TipoEmpresaDAO.list(); // carga los cargos con el arraylist
			tipoForm.loadTable(tipos);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					tipoForm,
					"Error al cargar registros de la base de datos",
					"Error",
					JOptionPane.ERROR_MESSAGE
			);
//				
//				e.printStackTrace();
		}
	}
}
