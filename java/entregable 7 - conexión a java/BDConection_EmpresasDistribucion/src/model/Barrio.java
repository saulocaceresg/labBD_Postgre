package model;

public class Barrio {
	
	private int barid;
	private String barnom;
	private String bardes;
	private String barestreg;
	
	public Barrio() {
	}
	
	public Barrio (int barid, String barnom, String bardes, String barestreg) {
		this.barid = barid;
		this.barnom = barnom;
		this.bardes = bardes;
		this.barestreg = barestreg;
	}

	public int getBarid() {
		return barid;
	}

	public void setBarid(int barid) {
		this.barid = barid;
	}

	public String getBarnom() {
		return barnom;
	}

	public void setBarnom(String barnom) {
		this.barnom = barnom;
	}

	public String getBardes() {
		return bardes;
	}

	public void setBardes(String bardes) {
		this.bardes = bardes;
	}

	public String getBarestreg() {
		return barestreg;
	}

	public void setBarestreg(String barestreg) {
		this.barestreg = barestreg;
	}
	
	
}
