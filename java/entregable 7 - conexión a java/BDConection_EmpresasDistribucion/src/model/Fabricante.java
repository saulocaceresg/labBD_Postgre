package model;

public class Fabricante {
	private int fabid;
	private String fabnom;
	private int tipid; // Clave foránea de TipoEmpresa
	private String fabestreg;

	public Fabricante() {
	}

	public Fabricante(int fabid, String fabnom, int tipid, String fabestreg) {
		this.fabid = fabid;
		this.fabnom = fabnom;
		this.tipid = tipid;
		this.fabestreg = fabestreg;
	}

	public int getFabid() {
		return fabid;
	}

	public void setFabid(int fabid) {
		this.fabid = fabid;
	}

	public String getFabnom() {
		return fabnom;
	}

	public void setFabnom(String fabnom) {
		this.fabnom = fabnom;
	}

	public int getTipid() {
		return tipid;
	}

	public void setTipid(int tipid) {
		this.tipid = tipid;
	}

	public String getFabestreg() {
		return fabestreg;
	}

	public void setFabestreg(String fabestreg) {
		this.fabestreg = fabestreg;
	}
}
