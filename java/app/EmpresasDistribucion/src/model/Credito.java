package model;

public class Credito {
	private byte creid;
	private String crenom;
	private String credes;
	private String creestreg;
	
	public Credito() {
	}
	
	public Credito(byte creid, String crenom, String credes, String creestreg) {
		this.creid = creid;
		this.crenom = crenom;
		this.credes = credes;
		this.creestreg = creestreg;
	}

	public byte getCreid() {
		return creid;
	}

	public void setCreid(byte creid) {
		this.creid = creid;
	}

	public String getCrenom() {
		return crenom;
	}

	public void setCrenom(String crenom) {
		this.crenom = crenom;
	}

	public String getCredes() {
		return credes;
	}

	public void setCredes(String credes) {
		this.credes = credes;
	}

	public String getCreestreg() {
		return creestreg;
	}

	public void setCreestreg(String creestreg) {
		this.creestreg = creestreg;
	}
	
	
	
}
