package model;

public class Empresa {
	private int empid;
	private String empnom;
	private int tipid; // Clave foránea de TipoEmpresa
	private String empestreg;

	public Empresa() {
	}

	public Empresa(int empid, String empnom, int tipid, String empestreg) {
		this.empid = empid;
		this.empnom = empnom;
		this.tipid = tipid;
		this.empestreg = empestreg;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpnom() {
		return empnom;
	}

	public void setEmpnom(String empnom) {
		this.empnom = empnom;
	}

	public int getTipid() {
		return tipid;
	}

	public void setTipid(int tipid) {
		this.tipid = tipid;
	}

	public String getEmpestreg() {
		return empestreg;
	}

	public void setEmpestreg(String empestreg) {
		this.empestreg = empestreg;
	}
}
