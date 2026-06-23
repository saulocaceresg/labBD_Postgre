package model;

public class Detalle {
	private int detid;
	private int proid; // Clave foránea de Producto
	private int facid; // Clave foránea de FacturaCabecera
	private int detcan;
	private String detestreg;

	public Detalle() {
	}

	public Detalle(int detid, int proid, int facid, int detcan, String detestreg) {
		this.detid = detid;
		this.proid = proid;
		this.facid = facid;
		this.detcan = detcan;
		this.detestreg = detestreg;
	}

	public int getDetid() {
		return detid;
	}

	public void setDetid(int detid) {
		this.detid = detid;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public int getFacid() {
		return facid;
	}

	public void setFacid(int facid) {
		this.facid = facid;
	}

	public int getDetcan() {
		return detcan;
	}

	public void setDetcan(int detcan) {
		this.detcan = detcan;
	}

	public String getDetestreg() {
		return detestreg;
	}

	public void setDetestreg(String detestreg) {
		this.detestreg = detestreg;
	}
}
