package a.b.c.com.kos.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.K_Session;
import a.b.c.com.common.NumUtill;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.cart.service.KoscartService;
import a.b.c.com.kos.cart.vo.KoscartVO;

@Controller
public class KoscartController {

	Logger log = LogManager.getLogger(KoscartController.class);
	
	
	
	@Autowired(required = false)
	private KoscartService koscartService;
	
	@Autowired(required = false)
	private KosChabunService kosChabunService;
	
	@GetMapping("koscartInsert")
	public String koscartInsert(KoscartVO kcvo, HttpServletRequest req, Model model) {
		
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		
		if(kID != null) {
		kcvo.setKcnum(ChabunUtil.getCartChabun("D", kosChabunService.getKosCartChabun().getKcnum()));
		kcvo.setKppricesum(NumUtill.comma_replace(kcvo.getKppricesum()));
		
		int nCnt = koscartService.koscartInsert(kcvo);
		
		if(nCnt > 0 ) {
			
			return "cart/kosCartInsert";
		}
		
		}
		
		return "product/kosProductSelectAll";
	}
	
	@GetMapping("koscartSelectAll")
	public String koscartSelectAll(KoscartVO kcvo, Model model, HttpServletRequest req) {
		
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		
		if(kID != null) {
		kcvo.setMid(kID);}

		
		List<KoscartVO> listcart = koscartService.koscartSelectAll(kcvo);
	
		if(listcart.size() > 0 ) {
			
			model.addAttribute("listcart", listcart);
			
			return "cart/kosCartSelectAll";
			
		}else {
			
			model.addAttribute("kid", kID);
			
			return "product/kosProductInsert";
		}
	}
	
	@GetMapping("koscartDelete")
	public String koscartDelete(KoscartVO kcvo, Model model) {
		
		int del =  koscartService.koscartDelete(kcvo);
		
		if(del > 0 ) {
			
			return "cart/kosCartDelete";
		}
		
		return "cart/kosCartSelectAll";
	}
	
	@GetMapping("kosmoCartDeleteArray")
	public String kosmoCartDeleteArray(KoscartVO kcvo, Model model, HttpServletRequest req) {
		
		String kcnumV[] = req.getParameterValues("kcnum");
		
		ArrayList<KoscartVO> aList = new ArrayList<KoscartVO>();
		
		for (int i = 0 ; i < kcnumV.length; i++) {
			KoscartVO _kcvo = new KoscartVO();
			_kcvo.setKcnum(kcnumV[i]);
			aList.add(_kcvo);
		
		}
		
		int nCnt = koscartService.kosmoCartDeleteArray(aList);
		
		if(nCnt == -1) {
			
			log.info("kosmoCartDeleteArray 함수 진입 nCnt >>> : " + nCnt);
		}
		
		return "cart/kosCartDelete";
	}
	
}
