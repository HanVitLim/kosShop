package a.b.c.com.kos.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oreilly.servlet.MultipartRequest;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileRename;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.K_Session;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.board.service.KosBoardService;
import a.b.c.com.kos.board.vo.KosBoardVO;

@Controller
public class KosBoardController {
	
	Logger log = LogManager.getLogger(KosBoardController.class);
	
	
	@Autowired(required = false)
	private KosChabunService kosChabunService;
	
	@Autowired(required = false)
	private KosBoardService kosBoardService;
	
	
	@GetMapping("kosBoardInsertForm")
	public String kosBoardInsertForm() {
		
		return "board/boardForm";
	}
	
	
	@PostMapping("kosBoardInsert")
	public String kosBoardInsert(HttpServletRequest req, KosBoardVO kvo) {
	
		String bnum = ChabunUtil.getBoardChabun("Y",kosChabunService.getKosBoardChabun().getBnum());
		
		FileUploadUtil fu = new FileUploadUtil(CommonUtils.BOARD_IMG_UPLOAD_PATH,CommonUtils.BOARD_IMG_FILE_SIZE, CommonUtils.BOARD_EN_CODE);
		
		boolean bool = fu.imgfileUpload(req);
		
		KosBoardVO kbvo = new KosBoardVO();
		
		kbvo.setBnum(bnum);
		kbvo.setBname(fu.getParameter("bname"));
		kbvo.setBpw(fu.getParameter("bpw"));
		kbvo.setBfile(fu.getFileName("bfile"));
		kbvo.setBcontent(fu.getParameter("bcontent"));
		kbvo.setBsubject(fu.getParameter("bsubject"));
		
		int nCnt = kosBoardService.kosBoardInsert(kbvo);
		
		if(nCnt > 0 ) {
			
			return "board/boardInsert";
		}
		
		return "board/boardForm.jsp";
	}
	
	@GetMapping("kosBoardSelectAll")
	public String kosBoardSelectAll(KosBoardVO kbvo, Model model, HttpServletRequest req) {
		
		int pageSize = CommonUtils.BOARD_PAGE_SIZE;
		int groupSize = CommonUtils.BOARD_GROUP_SIZE;
		int curPage = CommonUtils.BOARD_CUR_PAGE;
		int totalCount = CommonUtils.BOARD_TOTAL_COUNT;
		
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		log.info(">>>>: " + kID);
		
		if(kbvo.getCurPage() != null) {
			curPage = Integer.parseInt(kbvo.getCurPage());
		}

		kbvo.setPageSize(String.valueOf(pageSize));
		kbvo.setCurPage(String.valueOf(curPage));
		kbvo.setGroupSize(String.valueOf(groupSize));
		kbvo.setTotalCount(String.valueOf(totalCount));

		List<KosBoardVO> selectAllList = kosBoardService.kosBoardSelectAll(kbvo);
		
		int nCnt = selectAllList.size();
		
		if(nCnt > 0) {
			
			model.addAttribute("selectAllList", selectAllList);
			model.addAttribute("pagingKbvo", kbvo);
			
			
			return "board/boardSelectAll";
		}
		
		return "board/boardForm";
	}
	
	@GetMapping("kosBoardContents")
	public String kosBoardContents(KosBoardVO kbvo, Model model) {
		
			List<KosBoardVO> list = kosBoardService.kosBoardSelectContents(kbvo);
			
			int nCnt = list.size();
			
			if(nCnt == 1) {
				
				int bhit = kosBoardService.kosBoardBhit(kbvo);
				
				if(bhit > 0) {
					
				model.addAttribute("select", list);
				
				return "board/boardSellectContents";
				
				}
			}
		
			return "board/boardSelectAll";
	}
	
	@GetMapping("kosBoardSelect")
	public String kosBoardSelect(KosBoardVO kbvo, Model model) {
		
			List<KosBoardVO> list = kosBoardService.kosBoardSelectContents(kbvo);
			int nCnt = list.size();
			
			if(nCnt > 0 ) {
				
				model.addAttribute("selectlist", list);
				
				return "board/boardSelect";
			}
			
		return "board/boardSelectAll";
	}
	
	
	@PostMapping("kosBoardPwCheck")
	@ResponseBody
	public String kosBoardPwCheck(KosBoardVO kbvo) {
			
		List<KosBoardVO> list = kosBoardService.kosBoardPwCheck(kbvo);
		
		int nCnt = list.size();
		String pw = "";
		
		if(nCnt == 1) {
			pw = "PW_OK";
		}else {
			pw = "PW_NO";
		}
		
		return pw;
	}
	
	@GetMapping	("boardUpdat")
	public String kosBoardUpdate(KosBoardVO kbvo) {
		
		int nCnt = kosBoardService.kosBoardUpdate(kbvo);
		
		if(nCnt > 0 ) {
			
			return "board/boardUpdate";
		}
		
		return "board/boardSelect";
	}
}
