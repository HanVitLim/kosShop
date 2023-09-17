package a.b.c.com.kos.rboard.vo;

public class KosRboardVO {

	private String rbnum;
	private String bnum;
	private String rbname;
	private String rbcontent;
	private String deleteyn;
	private String insertdate;
	
	public KosRboardVO() {

		// TODO Auto-generated constructor stub
	}


	public KosRboardVO(String rbnum, String bnum, String rbname, String rbcontent, String deleteyn, String insertdate) {
		super();
		this.rbnum = rbnum;
		this.bnum = bnum;
		this.rbname = rbname;
		this.rbcontent = rbcontent;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
	}


	public String getRbnum() {
		return rbnum;
	}

	public String getBnum() {
		return bnum;
	}

	public String getRbname() {
		return rbname;
	}

	public String getRbcontent() {
		return rbcontent;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setRbnum(String rbnum) {
		this.rbnum = rbnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public void setRbname(String rbname) {
		this.rbname = rbname;
	}

	public void setRbcontent(String rbcontent) {
		this.rbcontent = rbcontent;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}


	public String getDeleteyn() {
		return deleteyn;
	}


	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

}