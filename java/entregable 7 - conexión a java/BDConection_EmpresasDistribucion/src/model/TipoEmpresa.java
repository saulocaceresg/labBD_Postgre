package model;

public class TipoEmpresa {
	private int tipid;
	private String tipnom;
	private String tipestreg;
	
	public TipoEmpresa() {
	}
	
	public TipoEmpresa(int tipid, String tipnom, String tipestreg) {
		this.tipid = tipid;
		this.tipnom = tipnom;
		this.tipestreg = tipestreg;
	}

	public int getTipid() {
		return tipid;
	}

	public void setTipid(int tipid) {
		this.tipid = tipid;
	}

	public String getTipnom() {
		return tipnom;
	}

	public void setTipnom(String tipnom) {
		this.tipnom = tipnom;
	}

	public String getTipestreg() {
		return tipestreg;
	}

	public void setTipestreg(String tipestreg) {
		this.tipestreg = tipestreg;
	}
	
}
