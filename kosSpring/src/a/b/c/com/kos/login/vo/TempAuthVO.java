package a.b.c.com.kos.login.vo;

public class TempAuthVO {

	private String anum;
	private String authnum;
	private String memail;
	private String insertdate;
	
	public TempAuthVO() {
		// TODO Auto-generated constructor stub
	}

	public TempAuthVO(String anum, String authnum, String memail, String insertdate) {
		this.anum = anum;
		this.authnum = authnum;
		this.memail = memail;
		this.insertdate = insertdate;
	}

	public String getAnum() {
		return anum;
	}

	public String getAuthnum() {
		return authnum;
	}

	public String getMemail() {
		return memail;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setAnum(String anum) {
		this.anum = anum;
	}

	public void setAuthnum(String authnum) {
		this.authnum = authnum;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	
	
	
}
