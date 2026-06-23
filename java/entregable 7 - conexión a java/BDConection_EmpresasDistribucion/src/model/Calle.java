package model;

public class Calle {
	private int calid;
	private String calnom;
	private String caldes;
	private String calestreg;
	
	public Calle() {
	}
	
	public Calle(int calid, String calnom, String caldes, String calestreg) {
		this.calid = calid;
		this.calnom = calnom;
		this.caldes = caldes;
		this.calestreg = calestreg;
	}

	public int getCalid() {
		return calid;
	}

	public void setCalid(int calid) {
		this.calid = calid;
	}

	public String getCalnom() {
		return calnom;
	}

	public void setCalnom(String calnom) {
		this.calnom = calnom;
	}

	public String getCaldes() {
		return caldes;
	}

	public void setCaldes(String caldes) {
		this.caldes = caldes;
	}

	public String getCalestreg() {
		return calestreg;
	}

	public void setCalestreg(String calestreg) {
		this.calestreg = calestreg;
	}
	
}
