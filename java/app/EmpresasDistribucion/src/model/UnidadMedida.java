package model;

public class UnidadMedida {
	private String uniid;
	private String uninom;
	private String uniestreg;
	
	public UnidadMedida() {
	}
	
	public UnidadMedida(String unid, String uninom, String uniestreg) {
		this.uniid = unid;
		this.uninom = uninom;
		this.uniestreg = uniestreg;
	}

	public String getUniid() {
		return uniid;
	}

	public void setUniid(String uniid) {
		this.uniid = uniid;
	}

	public String getUninom() {
		return uninom;
	}

	public void setUninom(String uninom) {
		this.uninom = uninom;
	}

	public String getUniestreg() {
		return uniestreg;
	}

	public void setUniestreg(String uniestreg) {
		this.uniestreg = uniestreg;
	}
	
}
