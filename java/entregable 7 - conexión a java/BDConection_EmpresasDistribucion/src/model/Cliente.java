package model;

public class Cliente {
	private int cliid;
	private int repid; // Clave foránea de RepVenta
	private int creid; // Clave foránea de Credito
	private String clinom;
	private String cliapepat;
	private String cliapemat;
	private String clicor;
	private String cliestreg;

	public Cliente() {
	}

	public Cliente(int cliid, int repid, int creid, String clinom, String cliapepat, String cliapemat,
			String clicor, String cliestreg) {
		this.cliid = cliid;
		this.repid = repid;
		this.creid = creid;
		this.clinom = clinom;
		this.cliapepat = cliapepat;
		this.cliapemat = cliapemat;
		this.clicor = clicor;
		this.cliestreg = cliestreg;
	}

	public int getCliid() {
		return cliid;
	}

	public void setCliid(int cliid) {
		this.cliid = cliid;
	}

	public int getRepid() {
		return repid;
	}

	public void setRepid(int repid) {
		this.repid = repid;
	}

	public int getCreid() {
		return creid;
	}

	public void setCreid(int creid) {
		this.creid = creid;
	}

	public String getClinom() {
		return clinom;
	}

	public void setClinom(String clinom) {
		this.clinom = clinom;
	}

	public String getCliapepat() {
		return cliapepat;
	}

	public void setCliapepat(String cliapepat) {
		this.cliapepat = cliapepat;
	}

	public String getCliapemat() {
		return cliapemat;
	}

	public void setCliapemat(String cliapemat) {
		this.cliapemat = cliapemat;
	}

	public String getClicor() {
		return clicor;
	}

	public void setClicor(String clicor) {
		this.clicor = clicor;
	}

	public String getCliestreg() {
		return cliestreg;
	}

	public void setCliestreg(String cliestreg) {
		this.cliestreg = cliestreg;
	}
}
