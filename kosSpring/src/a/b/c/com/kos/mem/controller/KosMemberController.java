package a.b.c.com.kos.mem.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;

import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.TestValidation;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.mem.service.KosMemberService;
import a.b.c.com.kos.mem.vo.KosMemberVO;

@Controller
public class KosMemberController {

	Logger log = LogManager.getLogger(KosMemberController.class);
	
	@Autowired(required = false)
	private KosChabunService kosChabunService;
	
	@Autowired(required = false)
	private KosMemberService kosMemberService;
	
	@RequestMapping(value="memForm")
	public String memForm() {
		
		return "mem/memForm";
	}
	
	@GetMapping("Idcheck")
	@ResponseBody
	public Object Idcheck(KosMemberVO kvo) {
		
		List<KosMemberVO> list = kosMemberService.Idcheck(kvo);		
		
		int i = list.size();
		String msg = "";
		log.info(i);
		
		if( i > 0 ) {
			msg = "ID_NO";
		}else {
			msg = "ID_YES";
		}
		
		log.info(msg);
		return msg;
	}
	
	
	
	@PostMapping(value="memInsert")
	public String kosMemberInsert(HttpServletRequest req) {
		
		String mnum = ChabunUtil.getMemberChabun("Y", kosChabunService.getKosMemberChabun().getMnum());
		
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.MEM_IMG_UPLOAD_PATH, 
												CommonUtils.MEM_IMG_FILE_SIZE,
												CommonUtils.MEM_EN_CODE);

		boolean bool = fu.imgfileUpload(req);
		log.info(">>>> : " + bool);
		log.info(">>>> : " + fu.getParameter("mname"));
		log.info(">>>> : " + fu.getParameter("mid"));
		log.info(">>>> : " + fu.getParameter("mpw"));
		log.info(">>>> : " + fu.getParameter("mgender"));
		log.info(">>>> : " + fu.getParameter("mbirth"));
		log.info(">>>> : " + fu.getParameter("mhp"));
		log.info(">>>> : " + fu.getParameter("mhp1"));
		log.info(">>>> : " + fu.getParameter("mhp2"));
		log.info(">>>> : " + fu.getParameter("mtel"));
		log.info(">>>> : " + fu.getParameter("mtel1"));
		log.info(">>>> : " + fu.getParameter("mtel2"));
		log.info(">>>> : " + fu.getParameter("memail"));
		log.info(">>>> : " + fu.getParameter("memail1"));
		log.info(">>>> : " + fu.getFileName("mphoto"));
		log.info(">>>> : " + fu.getParameterValues("mhobby"));
		log.info(">>>> : " + fu.getParameter("mzonecode"));
		log.info(">>>> : " + fu.getParameter("mroadaddr"));
		log.info(">>>> : " + fu.getParameter("mroaddetail"));
		log.info(">>>> : " + fu.getParameter("mjibunaddr"));
		log.info(">>>> : " + fu.getParameter("minfo"));
		
		String mhp = fu.getParameter("mhp").concat(fu.getParameter("mhp1")).concat(fu.getParameter("mhp2"));
		String tel = fu.getParameter("mtel").concat(fu.getParameter("mtel1")).concat(fu.getParameter("mtel2"));
		String email = fu.getParameter("memail").concat("@").concat(fu.getParameter("memail1"));
		String file = fu.getFileName("mphoto");
		
		String mhobby = "";
		String[] hobby = fu.getParameterValues("mhobby");
		for(int i =0; i < hobby.length; i++) {
			mhobby += hobby[i] + ",";
		}
		
		KosMemberVO kvo = new KosMemberVO();
		
		kvo.setMnum(mnum);
		kvo.setMname(fu.getParameter("mname"));
		kvo.setMid(fu.getParameter("mid"));
		kvo.setMpw(fu.getParameter("mpw"));
		kvo.setMgender(fu.getParameter("mgender"));
		kvo.setMbirth(fu.getParameter("mbirth"));
		kvo.setMhp(mhp);
		kvo.setMtel(tel);
		kvo.setMemail(email);
		kvo.setMzonecode(fu.getParameter("mzonecode"));
		kvo.setMroadaddr(fu.getParameter("mroadaddr"));
		kvo.setMroaddetail(fu.getParameter("mroaddetail"));
		kvo.setMjibunaddr(fu.getParameter("mjibunaddr"));
		kvo.setMhobby(mhobby);
		kvo.setMinfo(fu.getParameter("minfo"));
		kvo.setMphoto(file);
		
		int nCnt = kosMemberService.kosMemberInsert(kvo);
		if (nCnt > 0 ) {
			
			return "mem/memInsert";
		}
		return "mem/memForm";
	}
	
	@GetMapping("pwCheck")
	@ResponseBody
	public Object pwCheck(KosMemberVO kvo) {
				
		String sV = kvo.getMpw();
		log.info(sV);
		String msg ="";
		boolean bool = TestValidation.testValidation(sV);
		
		log.info(bool);
		if(bool) {
			msg = "PW_YES";
		}else {
			msg = "PW_NO";
		}
		
		log.info(msg);
		return msg;
	}
	
	@GetMapping("kosMemberSelectAll")
	public String kosMemberSelectAll(HttpServletRequest req,KosMemberVO kvo, Model model) {
		// 페이징 정보 가져오기
		int pageSize = CommonUtils.KOS_PAGE_SIZE;
		int groupSize = CommonUtils.KOS_GROUP_SIZE;
		int curPage = CommonUtils.KOS_CUR_PAGE;
		int totalCount = CommonUtils.KOS_TOTAL_COUNT;
		// 검색 키워드 가져오기
		String keyword = req.getParameter("keyword");
		String searchFilter = req.getParameter("searchFilter");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		
		KosMemberVO _kvo = new KosMemberVO();
		
		_kvo.setKeyword(keyword);
		_kvo.setSearchFilter(searchFilter);
		_kvo.setStartDate(startDate);
		_kvo.setEndDate(endDate);
		
		
		
		log.info(keyword);
		log.info(searchFilter);
		log.info(startDate);
		log.info(endDate);
		
		if(kvo.getCurPage() != null) {
			curPage = Integer.parseInt(kvo.getCurPage());
		}
		
		kvo.setPageSize(String.valueOf(pageSize));
		kvo.setGroupSize(String.valueOf(groupSize));
		kvo.setCurPage(String.valueOf(curPage));
		kvo.setTotalCount(String.valueOf(totalCount));
		
		List<KosMemberVO> selectAll = kosMemberService.kosMemberSelectAll(kvo);
		
		
		
		int nCnt = selectAll.size();
		
		log.info(">>>> : " + kvo.getTotalCount());
		log.info(">>>> : " + kvo.getPageSize());
		log.info(">>>> : " + kvo.getCurPage());
		log.info(">>>> : " + kvo.getGroupSize());
		
		
		if(nCnt > 0) {
			model.addAttribute("paging", kvo);
			model.addAttribute("selectAll", selectAll);
			model.addAttribute("search", _kvo);
			return "mem/memSelectAll"; 
		}
		
		
		return "mem/memForm";
	}
	
	@GetMapping("kosMemberSelect")
	public String kosMemberSelect(KosMemberVO kvo, Model model) {
		
		List<KosMemberVO> select = kosMemberService.kosMemberSelect(kvo);
		
		int nCnt = select.size();
				
		if(nCnt > 0) {
			
			model.addAttribute("select", select);
			
			return "mem/memSelect";
		}
		
		return "mem/memSelectAll"; 
	}
	
	@PostMapping("kosMemberUpdate")
	public String kosMemberUpdate(HttpServletRequest req, Model model) {
		
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.MEM_IMG_UPLOAD_PATH, CommonUtils.MEM_IMG_FILE_SIZE, CommonUtils.MEM_EN_CODE);
		
		fu.imgfileUpload(req);
		
		String mhp = fu.getParameter("mhp").concat(fu.getParameter("mhp1")).concat(fu.getParameter("mhp2"));
		String tel = fu.getParameter("mtel").concat(fu.getParameter("mtel1")).concat(fu.getParameter("mtel2"));
		String email = fu.getParameter("memail").concat("@").concat(fu.getParameter("memail1"));
		String file = fu.getFileName("mphoto1");
		String file1 = fu.getParameter("mphoto");

		log.info(fu.getParameter("mphoto"));
		log.info(fu.getFileName("mphoto1"));
			


		String mhobby = "";
		String[] hobby = fu.getParameterValues("mhobby");
		for(int i =0; i < hobby.length; i++) {
			mhobby += hobby[i] + ",";
		}
		
		KosMemberVO kvo = new KosMemberVO();
		
		kvo.setMnum(fu.getParameter("mnum"));
		kvo.setMname(fu.getParameter("mname"));
		kvo.setMgender(fu.getParameter("mgender"));
		kvo.setMbirth(fu.getParameter("mbirth"));
		kvo.setMhp(mhp);
		kvo.setMtel(tel);
		kvo.setMemail(email);
		kvo.setMzonecode(fu.getParameter("mzonecode"));
		kvo.setMroadaddr(fu.getParameter("mroadaddr"));
		kvo.setMroaddetail(fu.getParameter("mroaddetail"));
		kvo.setMjibunaddr(fu.getParameter("mjibunaddr"));
		kvo.setMhobby(mhobby);
		kvo.setMinfo(fu.getParameter("minfo"));
		
		if(file == null || file == "") {
			kvo.setMphoto(file1);
		}else {
			kvo.setMphoto(file);
		}
		
		int nCnt = kosMemberService.kosMemberUpdate(kvo);
		
		if(nCnt > 0) {
			
			return "mem/memUpdate";
		}
		
		return "mem/memSelectAll"; 
	}
}
