package a.b.c.com.kos.mem.vo;

public class KosMemberVO {

	private String mnum;
	private String mname;
	private String mid;
	private String mpw;
	private String mgender;
	private String mbirth;
	private String mhp;
	private String mtel;
	private String memail;
	private String mzonecode;
	private String mroadaddr;
	private String mroaddetail;
	private String mjibunaddr;
	private String mhobby;
	private String minfo;
	private String mphoto;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	private String keyword;
	private String searchFilter;
	private String startDate;
	private String endDate;
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	private String snstype;
	private String snsid;
	private String snsemail;
	
	public KosMemberVO() {
		// TODO Auto-generated constructor stub
	}

	public KosMemberVO(String mnum, String mname, String mid, String mpw, String mgender, String mbirth, String mhp,
			String mtel, String memail, String mzonecode, String mroadaddr, String mroaddetail, String mjibunaddr,
			String mhobby, String minfo, String mphoto, String deleteyn, String insertdate, String updatedate,
			String keyword, String searchFilter, String startDate, String endDate) {
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.mgender = mgender;
		this.mbirth = mbirth;
		this.mhp = mhp;
		this.mtel = mtel;
		this.memail = memail;
		this.mzonecode = mzonecode;
		this.mroadaddr = mroadaddr;
		this.mroaddetail = mroaddetail;
		this.mjibunaddr = mjibunaddr;
		this.mhobby = mhobby;
		this.minfo = minfo;
		this.mphoto = mphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public KosMemberVO(String mnum, String mname, String mid, String mpw, String mgender, String mbirth, String mhp,
			String mtel, String memail, String mzonecode, String mroadaddr, String mroaddetail, String mjibunaddr,
			String mhobby, String minfo, String mphoto, String deleteyn, String insertdate, String updatedate,
			String keyword, String searchFilter, String startDate, String endDate, String pageSize, String groupSize,
			String curPage, String totalCount) {
		super();
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.mgender = mgender;
		this.mbirth = mbirth;
		this.mhp = mhp;
		this.mtel = mtel;
		this.memail = memail;
		this.mzonecode = mzonecode;
		this.mroadaddr = mroadaddr;
		this.mroaddetail = mroaddetail;
		this.mjibunaddr = mjibunaddr;
		this.mhobby = mhobby;
		this.minfo = minfo;
		this.mphoto = mphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public KosMemberVO(String mnum, String mname, String mid, String mpw, String mgender, String mbirth, String mhp,
			String mtel, String memail, String mzonecode, String mroadaddr, String mroaddetail, String mjibunaddr,
			String mhobby, String minfo, String mphoto, String deleteyn, String insertdate, String updatedate,
			String keyword, String searchFilter, String startDate, String endDate, String pageSize, String groupSize,
			String curPage, String totalCount, String snstype, String snsid, String snsemail) {
		this.mnum = mnum;
		this.mname = mname;
		this.mid = mid;
		this.mpw = mpw;
		this.mgender = mgender;
		this.mbirth = mbirth;
		this.mhp = mhp;
		this.mtel = mtel;
		this.memail = memail;
		this.mzonecode = mzonecode;
		this.mroadaddr = mroadaddr;
		this.mroaddetail = mroaddetail;
		this.mjibunaddr = mjibunaddr;
		this.mhobby = mhobby;
		this.minfo = minfo;
		this.mphoto = mphoto;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.keyword = keyword;
		this.searchFilter = searchFilter;
		this.startDate = startDate;
		this.endDate = endDate;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
		this.snstype = snstype;
		this.snsid = snsid;
		this.snsemail = snsemail;
	}

	public String getMnum() {
		return mnum;
	}

	public String getMname() {
		return mname;
	}

	public String getMid() {
		return mid;
	}

	public String getMpw() {
		return mpw;
	}

	public String getMgender() {
		return mgender;
	}

	public String getMbirth() {
		return mbirth;
	}

	public String getMhp() {
		return mhp;
	}

	public String getMtel() {
		return mtel;
	}

	public String getMemail() {
		return memail;
	}

	public String getMzonecode() {
		return mzonecode;
	}

	public String getMroadaddr() {
		return mroadaddr;
	}

	public String getMroaddetail() {
		return mroaddetail;
	}

	public String getMjibunaddr() {
		return mjibunaddr;
	}

	public String getMhobby() {
		return mhobby;
	}

	public String getMinfo() {
		return minfo;
	}

	public String getMphoto() {
		return mphoto;
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

	public String getKeyword() {
		return keyword;
	}

	public String getSearchFilter() {
		return searchFilter;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setMnum(String mnum) {
		this.mnum = mnum;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public void setMgender(String mgender) {
		this.mgender = mgender;
	}

	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}

	public void setMhp(String mhp) {
		this.mhp = mhp;
	}

	public void setMtel(String mtel) {
		this.mtel = mtel;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public void setMzonecode(String mzonecode) {
		this.mzonecode = mzonecode;
	}

	public void setMroadaddr(String mroadaddr) {
		this.mroadaddr = mroadaddr;
	}

	public void setMroaddetail(String mroaddetail) {
		this.mroaddetail = mroaddetail;
	}

	public void setMjibunaddr(String mjibunaddr) {
		this.mjibunaddr = mjibunaddr;
	}

	public void setMhobby(String mhobby) {
		this.mhobby = mhobby;
	}

	public void setMinfo(String minfo) {
		this.minfo = minfo;
	}

	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
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

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setSearchFilter(String searchFilter) {
		this.searchFilter = searchFilter;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPageSize() {
		return pageSize;
	}

	public String getGroupSize() {
		return groupSize;
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

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getCurPage() {
		return curPage;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public String getSnstype() {
		return snstype;
	}

	public String getSnsid() {
		return snsid;
	}

	public String getSnsemail() {
		return snsemail;
	}

	public void setSnstype(String snstype) {
		this.snstype = snstype;
	}

	public void setSnsid(String snsid) {
		this.snsid = snsid;
	}

	public void setSnsemail(String snsemail) {
		this.snsemail = snsemail;
	}

}
