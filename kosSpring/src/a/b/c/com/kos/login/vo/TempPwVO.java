package a.b.c.com.kos.login.vo;

public class TempPwVO {

	private String pnum;
	private String ppw;
	private String mid;
	private String memail;
	private String insertdate;
	
	public TempPwVO() {
		// TODO Auto-generated constructor stub
	}

	public TempPwVO(String pnum, String ppw, String mid, String memail, String insertdate) {
		this.pnum = pnum;
		this.ppw = ppw;
		this.mid = mid;
		this.memail = memail;
		this.insertdate = insertdate;
	}

	public String getPnum() {
		return pnum;
	}

	public String getPpw() {
		return ppw;
	}

	public String getMid() {
		return mid;
	}

	public String getMemail() {
		return memail;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public void setPpw(String ppw) {
		this.ppw = ppw;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

}
