package model;

public class Oficina {
	private int ofiid; // Clave foránea de Oficina
	private int empid; 
	private String ofinom;
	private String ofirepestreg;

	public Oficina() {
	}

	public Oficina(int ofiid, int empid, String ofinom, String ofirepestreg) {
		this.ofiid = ofiid;
		this.empid = empid;
		this.ofinom = ofinom;
		this.ofirepestreg = ofirepestreg;
	}

	public int getOfiid() {
		return ofiid;
	}

	public void setOfiid(int ofiid) {
		this.ofiid = ofiid;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getOfinom() {
		return ofinom;
	}

	public void setOfinom(String ofinom) {
		this.ofinom = ofinom;
	}

	public String getOfirepestreg() {
		return ofirepestreg;
	}

	public void setOfirepestreg(String ofirepestreg) {
		this.ofirepestreg = ofirepestreg;
	}
}
