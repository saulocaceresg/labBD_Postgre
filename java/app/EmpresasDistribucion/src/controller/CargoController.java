package controller;

import java.math.BigDecimal;

import dao.*;
import model.*;
import view.*;

public class CargoController {
	
	private CargoForm cargoForm;
	private CargoDAO cargoDAO;
	
	public CargoController(CargoForm form) {
		this.cargoForm = form;
		this.cargoDAO = new CargoDAO();
	}
	
	public void add() {
		try {
			Cargo cargo = new Cargo();
			
			cargo.setCarnom(cargoForm.getCarnom());
			cargo.setCardes(cargoForm.getCardes());
			cargo.setCarsue(new BigDecimal(cargoForm.getCarsue()));
			cargo.setCarestreg(cargoForm.getCarestreg());
			
			cargoDAO.add(cargo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		try {
			Cargo cargo = new Cargo();
			
			cargo.setCarnom(cargoForm.getCarnom());
			cargo.setCardes(cargoForm.getCardes());
			cargo.setCarsue(new BigDecimal(cargoForm.getCarsue()));
			
			cargoDAO.update(cargo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete() {
		try {
			
			Cargo cargo = new Cargo();
			
			cargo.setCarestreg(cargoForm.getCarestreg());
			
			cargoDAO.delete(cargo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
