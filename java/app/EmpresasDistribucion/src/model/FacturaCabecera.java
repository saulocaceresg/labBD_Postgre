package model;

import java.time.LocalDate;

public class FacturaCabecera {
	private int facid;
	private int cliid; // Clave foránea de Cliente
	private int repid; // Clave foránea de RepVenta
	private int ciuid; // Clave foránea de Ciudad
	private LocalDate facfec;
	private String facestreg;

	public FacturaCabecera() {
	}

	public FacturaCabecera(int facid, int cliid, int repid, int ciuid, LocalDate facfec, String facestreg) {
		this.facid = facid;
		this.cliid = cliid;
		this.repid = repid;
		this.ciuid = ciuid;
		this.facfec = facfec;
		this.facestreg = facestreg;
	}

	public int getFacid() {
		return facid;
	}

	public void setFacid(int facid) {
		this.facid = facid;
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

	public int getCiuid() {
		return ciuid;
	}

	public void setCiuid(int ciuid) {
		this.ciuid = ciuid;
	}

	public LocalDate getFacfec() {
		return facfec;
	}

	public void setFacfec(LocalDate facfec) {
		this.facfec = facfec;
	}

	public String getFacestreg() {
		return facestreg;
	}

	public void setFacestreg(String facestreg) {
		this.facestreg = facestreg;
	}
}
