package model;

public class Categoria {
	private int catid;
	private String catnom;
	private String catestreg;
	
	public Categoria() {
	}
	
	public Categoria(int catid, String catnom, String catestreg) {
		this.catid = catid;
		this.catnom = catnom;
		this.catestreg = catestreg;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public String getCatnom() {
		return catnom;
	}

	public void setCatnom(String catnom) {
		this.catnom = catnom;
	}

	public String getCatestreg() {
		return catestreg;
	}

	public void setCatestreg(String catestreg) {
		this.catestreg = catestreg;
	}
	
}
