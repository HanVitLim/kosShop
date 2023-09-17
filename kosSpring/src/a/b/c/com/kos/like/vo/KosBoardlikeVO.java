package a.b.c.com.kos.like.vo;

public class KosBoardlikeVO {

	private String blnum;
	private String mnum;
	private String bnum;
	private String mid;
	private String like_cnt_1;
	private String like_cnt_2;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	public KosBoardlikeVO() {

		// TODO Auto-generated constructor stub
	}

	public KosBoardlikeVO(String blnum, String mnum, String bnum, String mid, String like_cnt_1, String like_cnt_2,
			String deleteyn, String insertdate, String updatedate) {
		this.blnum = blnum;
		this.mnum = mnum;
		this.bnum = bnum;
		this.mid = mid;
		this.like_cnt_1 = like_cnt_1;
		this.like_cnt_2 = like_cnt_2;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}

	public String getBlnum() {
		return blnum;
	}

	public String getMnum() {
		return mnum;
	}

	public String getBnum() {
		return bnum;
	}

	public String getMid() {
		return mid;
	}

	public String getLike_cnt_1() {
		return like_cnt_1;
	}

	public String getLike_cnt_2() {
		return like_cnt_2;
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

	public void setBlnum(String blnum) {
		this.blnum = blnum;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setLike_cnt_1(String like_cnt_1) {
		this.like_cnt_1 = like_cnt_1;
	}

	public void setLike_cnt_2(String like_cnt_2) {
		this.like_cnt_2 = like_cnt_2;
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
	
	
	
}
