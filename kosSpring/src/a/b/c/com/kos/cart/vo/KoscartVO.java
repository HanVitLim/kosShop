package a.b.c.com.kos.cart.vo;

public class KoscartVO {

	   private String kcnum;
	   private String kpid;
	   private String kpname;
	   private String kpfile;
	   private String kpcnt;
	   private String kpprice;
	   private String kppricesum;
	   private String kpnum;
	   private String kmnum;
	   private String deleteyn;
	   private String insertdate;
	   private String updatedat;
	   private String mid;
	   private String kcnumarr[];
	   private String mnum;

	public KoscartVO() {
		// TODO Auto-generated constructor stub
	}



	public KoscartVO(String kcnum, String kpid, String kpname, String kpfile, String kpcnt, String kpprice,
			String kppricesum, String kpnum, String kmnum, String deleteyn, String insertdate, String updatedat,
			String[] kcnumarr) {
		this.kcnum = kcnum;
		this.kpid = kpid;
		this.kpname = kpname;
		this.kpfile = kpfile;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kppricesum = kppricesum;
		this.kpnum = kpnum;
		this.kmnum = kmnum;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedat = updatedat;
		this.kcnumarr = kcnumarr;
	}


	public KoscartVO(String kcnum, String kpid, String kpname, String kpfile, String kpcnt, String kpprice,
			String kppricesum, String kpnum, String kmnum, String deleteyn, String insertdate, String updatedat,
			String mid, String[] kcnumarr) {
		super();
		this.kcnum = kcnum;
		this.kpid = kpid;
		this.kpname = kpname;
		this.kpfile = kpfile;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kppricesum = kppricesum;
		this.kpnum = kpnum;
		this.kmnum = kmnum;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedat = updatedat;
		this.mid = mid;
		this.kcnumarr = kcnumarr;
	}

	public KoscartVO(String kcnum, String kpid, String kpname, String kpfile, String kpcnt, String kpprice,
			String kppricesum, String kpnum, String kmnum, String deleteyn, String insertdate, String updatedat,
			String mid, String[] kcnumarr, String mnum) {
		super();
		this.kcnum = kcnum;
		this.kpid = kpid;
		this.kpname = kpname;
		this.kpfile = kpfile;
		this.kpcnt = kpcnt;
		this.kpprice = kpprice;
		this.kppricesum = kppricesum;
		this.kpnum = kpnum;
		this.kmnum = kmnum;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedat = updatedat;
		this.mid = mid;
		this.kcnumarr = kcnumarr;
		this.mnum = mnum;
	}

	public String getKcnum() {
		return kcnum;
	}

	public String getKpid() {
		return kpid;
	}

	public String getKpname() {
		return kpname;
	}

	public String getKpfile() {
		return kpfile;
	}

	public String getKpcnt() {
		return kpcnt;
	}

	public String getKpprice() {
		return kpprice;
	}

	public String getKppricesum() {
		return kppricesum;
	}

	public String getKpnum() {
		return kpnum;
	}

	public String getKmnum() {
		return kmnum;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public String getUpdatedat() {
		return updatedat;
	}

	public String[] getKcnumarr() {
		return kcnumarr;
	}

	public void setKcnum(String kcnum) {
		this.kcnum = kcnum;
	}

	public void setKpid(String kpid) {
		this.kpid = kpid;
	}

	public void setKpname(String kpname) {
		this.kpname = kpname;
	}

	public void setKpfile(String kpfile) {
		this.kpfile = kpfile;
	}

	public void setKpcnt(String kpcnt) {
		this.kpcnt = kpcnt;
	}

	public void setKpprice(String kpprice) {
		this.kpprice = kpprice;
	}

	public void setKppricesum(String kppricesum) {
		this.kppricesum = kppricesum;
	}

	public void setKpnum(String kpnum) {
		this.kpnum = kpnum;
	}

	public void setKmnum(String kmnum) {
		this.kmnum = kmnum;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public void setUpdatedat(String updatedat) {
		this.updatedat = updatedat;
	}

	public void setKcnumarr(String[] kcnumarr) {
		this.kcnumarr = kcnumarr;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}	
	
	public String getMnum() {
		return mnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}
	
}
