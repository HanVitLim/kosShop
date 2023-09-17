package a.b.c.com.kos.product.vo;

public class KosProductVO {


	private String kpnum;
	private String kpid;
	private String kpname;
	private String kpcompany;
	private String kpfile;
	private int kpcnt;
	private int kpprice;
	private String kpdesc;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	private String mid;
	
	
	public KosProductVO() {
		// TODO Auto-generated constructor stub
	}

	public KosProductVO(String kpnum, String kpid, String kpname, String kpcompany, String kpfile, int kpcnt,
			int kpprice, String kpdesc, String deleteyn, String insertdate, String updatedate) {
		this.kpnum = kpnum;
		this.kpid = kpid;
		this.kpname = kpname;
		this.kpcompany = kpcompany;
		this.kpfile = kpfile;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kpdesc = kpdesc;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	public KosProductVO(String kpnum, String kpid, String kpname, String kpcompany, String kpfile, int kpcnt,
			int kpprice, String kpdesc, String deleteyn, String insertdate, String updatedate, String pageSize,
			String groupSize, String curPage, String totalCount) {
		this.kpnum = kpnum;
		this.kpid = kpid;
		this.kpname = kpname;
		this.kpcompany = kpcompany;
		this.kpfile = kpfile;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kpdesc = kpdesc;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public KosProductVO(String kpnum, String kpid, String kpname, String kpcompany, String kpfile, int kpcnt,
			int kpprice, String kpdesc, String deleteyn, String insertdate, String updatedate, String pageSize,
			String groupSize, String curPage, String totalCount, String mid) {
		this.kpnum = kpnum;
		this.kpid = kpid;
		this.kpname = kpname;
		this.kpcompany = kpcompany;
		this.kpfile = kpfile;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kpdesc = kpdesc;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
		this.mid = mid;
	}

	public String getKpnum() {
		return kpnum;
	}

	public String getKpid() {
		return kpid;
	}

	public String getKpname() {
		return kpname;
	}

	public String getKpcompany() {
		return kpcompany;
	}

	public String getKpfile() {
		return kpfile;
	}

	public int getKpcnt() {
		return kpcnt;
	}

	public int getKpprice() {
		return kpprice;
	}

	public String getKpdesc() {
		return kpdesc;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setKpnum(String kpnum) {
		this.kpnum = kpnum;
	}

	public void setKpid(String kpid) {
		this.kpid = kpid;
	}

	public void setKpname(String kpname) {
		this.kpname = kpname;
	}

	public void setKpcompany(String kpcompany) {
		this.kpcompany = kpcompany;
	}

	public void setKpfile(String kpfile) {
		this.kpfile = kpfile;
	}

	public void setKpcnt(int kpcnt) {
		this.kpcnt = kpcnt;
	}

	public void setKpprice(int kpprice) {
		this.kpprice = kpprice;
	}

	public void setKpdesc(String kpdesc) {
		this.kpdesc = kpdesc;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getPageSize() {
		return pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
	
	
	
	
}
