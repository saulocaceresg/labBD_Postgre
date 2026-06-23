package model;

import java.time.LocalDate;

public class RepVenta {
	private int repid;
	private int carid; // Clave foránea de Cargo
	private String repnom;
	private String repapepat;
	private String repapemat;
	private LocalDate repfecnac;
	private int ofiid; // Clave foránea de Oficina
	private LocalDate repcon;
	private int repcuo;
	private int repven;
	private String repestreg;

	public RepVenta() {
	}

	public RepVenta(int repid, int carid, String repnom, String repapepat, String repapemat, LocalDate repfecnac,
			int ofiid, LocalDate repcon, int repcuo, int repven, String repestreg) {
		this.repid = repid;
		this.carid = carid;
		this.repnom = repnom;
		this.repapepat = repapepat;
		this.repapemat = repapemat;
		this.repfecnac = repfecnac;
		this.ofiid = ofiid;
		this.repcon = repcon;
		this.repcuo = repcuo;
		this.repven = repven;
		this.repestreg = repestreg;
	}

	public int getRepid() {
		return repid;
	}

	public void setRepid(int repid) {
		this.repid = repid;
	}

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public String getRepnom() {
		return repnom;
	}

	public void setRepnom(String repnom) {
		this.repnom = repnom;
	}

	public String getRepapepat() {
		return repapepat;
	}

	public void setRepapepat(String repapepat) {
		this.repapepat = repapepat;
	}

	public String getRepapemat() {
		return repapemat;
	}

	public void setRepapemat(String repapemat) {
		this.repapemat = repapemat;
	}

	public LocalDate getRepfecnac() {
		return repfecnac;
	}

	public void setRepfecnac(LocalDate repfecnac) {
		this.repfecnac = repfecnac;
	}

	public int getOfiid() {
		return ofiid;
	}

	public void setOfiid(int ofiid) {
		this.ofiid = ofiid;
	}

	public LocalDate getRepcon() {
		return repcon;
	}

	public void setRepcon(LocalDate repcon) {
		this.repcon = repcon;
	}

	public int getRepcuo() {
		return repcuo;
	}

	public void setRepcuo(int repcuo) {
		this.repcuo = repcuo;
	}

	public int getRepven() {
		return repven;
	}

	public void setRepven(int repven) {
		this.repven = repven;
	}

	public String getRepestreg() {
		return repestreg;
	}

	public void setRepestreg(String repestreg) {
		this.repestreg = repestreg;
	}
}
