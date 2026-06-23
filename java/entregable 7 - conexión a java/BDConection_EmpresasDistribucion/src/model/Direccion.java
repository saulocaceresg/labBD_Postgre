package model;

public class Direccion {
	private int dirid;
	private int cliid; // Clave foránea de Cliente
	private int calid; // Clave foránea de Calle
	private String dircalnum;
	private int barid; // Clave foránea de Barrio
	private String direstreg;

	public Direccion() {
	}

	public Direccion(int dirid, int cliid, int calid, String dircalnum, int barid, String direstreg) {
		this.dirid = dirid;
		this.cliid = cliid;
		this.calid = calid;
		this.dircalnum = dircalnum;
		this.barid = barid;
		this.direstreg = direstreg;
	}

	public int getDirid() {
		return dirid;
	}

	public void setDirid(int dirid) {
		this.dirid = dirid;
	}

	public int getCliid() {
		return cliid;
	}

	public void setCliid(int cliid) {
		this.cliid = cliid;
	}

	public int getCalid() {
		return calid;
	}

	public void setCalid(int calid) {
		this.calid = calid;
	}

	public String getDircalnum() {
		return dircalnum;
	}

	public void setDircalnum(String dircalnum) {
		this.dircalnum = dircalnum;
	}

	public int getBarid() {
		return barid;
	}

	public void setBarid(int barid) {
		this.barid = barid;
	}

	public String getDirestreg() {
		return direstreg;
	}

	public void setDirestreg(String direstreg) {
		this.direstreg = direstreg;
	}
}
