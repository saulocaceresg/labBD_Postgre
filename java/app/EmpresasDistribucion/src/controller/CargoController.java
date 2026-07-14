package controller;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.*;
import dao.CargoDAO;
import model.*;
import view.*;
import java.util.ArrayList;

public class CargoController {
	
	// varaibles para conectar con las consultas SQL
	private static final String ADD = "ADD";
	private static final String MODIFY = "MODIFY";
	private static final String DELETE = "DELETE";
	private static final String INACTIVATE = "INACTIVATE";
	private static final String REACTIVATE = "REACTIVATE";
	
	private CargoForm cargoForm;
	private CargoDAO cargoDAO;
	private Cargo cargo;
	private byte carflaact = 0;
	private String pendingAction = "";
	
	public CargoController(CargoForm form) {
		this.cargoForm = form;
		this.cargoDAO = new CargoDAO();
	}
	
	public Cargo createCargo() {
		Cargo cargo = new Cargo();
		BigDecimal carsue = new BigDecimal(cargoForm.getCarsue());
		
		if (!cargoForm.getCarid().isEmpty()) {
			cargo.setCarid(Integer.parseInt(cargoForm.getCarid()));
		}
		
		if (carsue.abs().compareTo(new BigDecimal("99999.99")) > 0) {
			JOptionPane.showMessageDialog(cargoForm,
					"El sueldo debe ser menor a 100000",
					"Validación",
					JOptionPane.WARNING_MESSAGE
			);
			return null;
		}
		
		cargo.setCarnom(cargoForm.getCarnom());
		cargo.setCardes(cargoForm.getCardes());
		cargo.setCarsue(new BigDecimal(cargoForm.getCarsue()));
		cargo.setCarestreg(cargoForm.getCarestreg());
		
		return cargo;
	}
	
	public void add() {
		//cargo = createCargo();
		pendingAction = ADD;
		carflaact = 1;
	}
	
	public void modify() {
		//cargo = createCargo();
		pendingAction = MODIFY;
		carflaact = 1;
	}
	
	public void delete() {
		cargo = createCargo();
		pendingAction = DELETE;
		carflaact = 1;
	}
	
	public void inactivate() {
		cargo = createCargo();
		pendingAction = INACTIVATE;
		carflaact = 1;
	}
	
	public void reactivate() {
		cargo = createCargo();
		pendingAction = REACTIVATE;
		carflaact = 1;
	}
	
	// método para actualizar los registros. Si la bandera está en 0 no hace nada, si no, según la acción pendiente interactúa con la BD
	public void update() {
		if (carflaact == 0) {
			aviso();
			return;
		}
		
		try {
			cargo = createCargo();
			
			switch (pendingAction) {
				case ADD: 
					cargoDAO.add(cargo);
					break;
				case MODIFY:
					cargoDAO.modify(cargo);
					break;
				case DELETE:
					cargoDAO.delete(cargo.getCarid());
					break;
				case INACTIVATE:
					cargoDAO.inactivate(cargo.getCarid());
					break;
				case REACTIVATE:
					cargoDAO.reactivate(cargo.getCarid());
					break;
			}
			
			carflaact = 0;
			pendingAction = "";
			cargo = null;
			
			JOptionPane.showMessageDialog(
					cargoForm,
					"Registro actualizado exitosamente"
					);
			loadTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(cargoForm, "ERROR AL ACTUALIZAR REGISTRO: " + e.getMessage());
		}
		
	}
	
	public void cancel() {
		cargo = null;
		pendingAction = "";
		carflaact = 0;
	}
	
	private void aviso() {
	    JOptionPane.showOptionDialog(
	            cargoForm,
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
			ArrayList<Cargo> cargos = CargoDAO.list(); // carga los cargos con el arraylist
			cargoForm.loadTable(cargos);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(
					cargoForm,
					"Error al cargar registros de la base de datos",
					"Error",
					JOptionPane.ERROR_MESSAGE
			);
//			
//			e.printStackTrace();
		}
	}
	
}
