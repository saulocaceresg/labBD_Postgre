package model;

public class OficinaRepresentante {
	private int ofiid; 
	private int ofirepid; // Clave foránea de Oficina
	private String ofirepnom;
	private String ofirepestreg;

	public OficinaRepresentante() {
	}

	public OficinaRepresentante(int ofiid, int ofirepid, String ofirepnom, String ofirepestreg) {
		this.ofiid = ofiid;
		this.ofirepid = ofirepid;
		this.ofirepnom = ofirepnom;
		this.ofirepestreg = ofirepestreg;
	}


	public int getOfiid() {
		return ofiid;
	}

	public void setOfiid(int ofiid) {
		this.ofiid = ofiid;
	}

	public int getOfirepid() {
		return ofirepid;
	}
	
	public void setOfirepid(int ofirepid) {
		this.ofirepid = ofirepid;
	}
	
	public String getOfirepnom() {
		return ofirepnom;
	}

	public void setOfirepnom(String ofirepnom) {
		this.ofirepnom = ofirepnom;
	}

	public String getOfirepestreg() {
		return ofirepestreg;
	}

	public void setOfirepestreg(String ofirepestreg) {
		this.ofirepestreg = ofirepestreg;
	}
}
