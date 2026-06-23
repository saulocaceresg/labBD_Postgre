package model;

public class Region {
	private byte regid;
	private String regnom;
	private String regdes;
	private String regestreg;
	
	public Region() {
	}
	
	public Region(byte regid, String regnom, String regdes, String regestreg) {
		this.regid = regid;
		this.regnom = regnom;
		this.regdes = regdes;
		this.regestreg = regestreg;
	}

	public byte getRegid() {
		return regid;
	}

	public void setRegid(byte regid) {
		this.regid = regid;
	}

	public String getRegnom() {
		return regnom;
	}

	public void setRegnom(String regnom) {
		this.regnom = regnom;
	}

	public String getRegdes() {
		return regdes;
	}

	public void setRegdes(String regdes) {
		this.regdes = regdes;
	}

	public String getRegestreg() {
		return regestreg;
	}

	public void setRegestreg(String regestreg) {
		this.regestreg = regestreg;
	}
	
	
	
}
