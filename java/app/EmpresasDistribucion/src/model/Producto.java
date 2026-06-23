package model;

import java.math.BigDecimal;

public class Producto {
	private int proid;
	private int fabid; // Clave foránea de Fabricante
	private String pronom;
	private String prodes;
	private BigDecimal propre;
	private int prosto;
	private int catid; // Clave foránea de Categoria
	private String prounimed; // Clave foránea de UnidadMedida 
	private String proestreg;

	public Producto() {
	}

	public Producto(int proid, int fabid, String pronom, String prodes, BigDecimal propre, int prosto, int catid,
			String prounimed, String proestreg) {
		this.proid = proid;
		this.fabid = fabid;
		this.pronom = pronom;
		this.prodes = prodes;
		this.propre = propre;
		this.prosto = prosto;
		this.catid = catid;
		this.prounimed = prounimed;
		this.proestreg = proestreg;
	}

	public int getProid() {
		return proid;
	}

	public void setProid(int proid) {
		this.proid = proid;
	}

	public int getFabid() {
		return fabid;
	}

	public void setFabid(int fabid) {
		this.fabid = fabid;
	}

	public String getPronom() {
		return pronom;
	}

	public void setPronom(String pronom) {
		this.pronom = pronom;
	}

	public String getProdes() {
		return prodes;
	}

	public void setProdes(String prodes) {
		this.prodes = prodes;
	}

	public BigDecimal getPropre() {
		return propre;
	}

	public void setPropre(BigDecimal propre) {
		this.propre = propre;
	}

	public int getProsto() {
		return prosto;
	}

	public void setProsto(int prosto) {
		this.prosto = prosto;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getProunimed() {
		return prounimed;
	}

	public void setProunimed(String prounimed) {
		this.prounimed = prounimed;
	}

	public String getProestreg() {
		return proestreg;
	}

	public void setProestreg(String proestreg) {
		this.proestreg = proestreg;
	}
}
