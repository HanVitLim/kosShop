package a.b.c.com.kos.like.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.K_Session;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.like.service.KosBoardlikeService;
import a.b.c.com.kos.like.vo.KosBoardlikeVO;

@Controller
public class KosBoardlikeController {

	Logger log = LogManager.getLogger(KosBoardlikeController.class);
	
	@Autowired(required = false)
	private KosBoardlikeService kosBoardlikeService;
	
	@Autowired(required = false)
	private KosChabunService kosChabunService;
	
	@PostMapping("like_cnt_1click")
	@ResponseBody
	public String like_cnt_1click (KosBoardlikeVO klvo, HttpServletRequest req){
		
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		String str = "";
		
		if(kID != null ) {
		klvo.setMid(kID);
			
		List<KosBoardlikeVO> list = kosBoardlikeService.kosBoardLikeSelect(klvo);
		
		int nCnt = list.size();
		
		if(list != null && nCnt > 0) {
			
			int upnCnt = kosBoardlikeService.kosBoardLikeUpdate(klvo);
			
			List<KosBoardlikeVO> listsall = kosBoardlikeService.kosBoardLikeSelectAll(klvo);
			
			KosBoardlikeVO _klvo = listsall.get(0);
			
			str = _klvo.getLike_cnt_1().concat(",").concat(_klvo.getLike_cnt_2());
			
			
		}else {
			
			KosBoardlikeVO blnum = kosChabunService.getKosBoardlikeChabun();
			klvo.setBlnum(blnum.getBlnum());
			
			int insnCnt = kosBoardlikeService.kosBoardLikeInsert(klvo);
			
			if(insnCnt > 0) {
				
				int upnCnt2 = kosBoardlikeService.kosBoardLikeUpdate(klvo);
				
				List<KosBoardlikeVO> listsall = kosBoardlikeService.kosBoardLikeSelectAll(klvo);
				
				KosBoardlikeVO _klvo = listsall.get(0);
				
				str = _klvo.getLike_cnt_1().concat(",").concat(_klvo.getLike_cnt_2());
				
			}
		}
		
		}else {
			
			str = "NO";
		}
		
		return str;
		
	}
	
	@PostMapping("kosBoardLikeSelectAll")
	@ResponseBody
	public String kosBoardLikeSelectAll(KosBoardlikeVO klvo) {
		
		String str = " ";
		
		List<KosBoardlikeVO> listsall = kosBoardlikeService.kosBoardLikeSelectAll(klvo);
		
		
		int nCnt = listsall.size();
		
		if(nCnt > 0 && listsall != null) {
		
		KosBoardlikeVO _klvo = listsall.get(0);
		
		str = _klvo.getLike_cnt_1().concat(",").concat(_klvo.getLike_cnt_2());
		
		return str;	
		}
		
		return str;
	}

	@PostMapping("like_cnt_2click")
	@ResponseBody
	public String like_cnt_2click(KosBoardlikeVO klvo, HttpServletRequest req) {
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		
		String str = "";
		
		
		if(kID != null ) {
		klvo.setMid(kID);
			
		List<KosBoardlikeVO> list = kosBoardlikeService.kosBoardLikeSelect(klvo);
		
		int nCnt = list.size();
		
		if(list != null && nCnt > 0) {
			
			int upnCnt = kosBoardlikeService.kosBoardLikeUpdate2(klvo);
			
			List<KosBoardlikeVO> listsall = kosBoardlikeService.kosBoardLikeSelectAll(klvo);
			
			KosBoardlikeVO _klvo = listsall.get(0);
			
			str = _klvo.getLike_cnt_1().concat(",").concat(_klvo.getLike_cnt_2());
			
			
		}else {
			
			KosBoardlikeVO blnum = kosChabunService.getKosBoardlikeChabun();
			klvo.setBlnum(blnum.getBlnum());
			
			int insnCnt = kosBoardlikeService.kosBoardLikeInsert(klvo);
			
			if(insnCnt > 0) {
				
				int upnCnt2 = kosBoardlikeService.kosBoardLikeUpdate2(klvo);
				
				List<KosBoardlikeVO> listsall = kosBoardlikeService.kosBoardLikeSelectAll(klvo);
				
				KosBoardlikeVO _klvo = listsall.get(0);
				
				str = _klvo.getLike_cnt_1().concat(",").concat(_klvo.getLike_cnt_2());
				
			}
		}
		
		}else {
			
			str = "NO";
		}
		
		return str;
	}

}
