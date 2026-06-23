package model;

public class Ciudad {
	private int ciuid;
	private int regid; // Clave foránea de Region
	private String ciunom;
	private String ciudes;
	private String ciuestreg;
	
	public Ciudad() {
	}
	
	public Ciudad(int ciuid, int regid, String ciunom, String ciudes, String ciuestreg) {
		this.ciuid = ciuid;
		this.regid = regid;
		this.ciunom = ciunom;
		this.ciudes = ciudes;
		this.ciuestreg = ciuestreg;
	}

	public int getCiuid() {
		return ciuid;
	}

	public void setCiuid(int ciuid) {
		this.ciuid = ciuid;
	}

	public int getRegid() {
		return regid;
	}

	public void setRegid(int regid) {
		this.regid = regid;
	}

	public String getCiunom() {
		return ciunom;
	}

	public void setCiunom(String ciunom) {
		this.ciunom = ciunom;
	}

	public String getCiudes() {
		return ciudes;
	}

	public void setCiudes(String ciudes) {
		this.ciudes = ciudes;
	}

	public String getCiuestreg() {
		return ciuestreg;
	}

	public void setCiuestreg(String ciuestreg) {
		this.ciuestreg = ciuestreg;
	}
	
	
}
