package a.b.c.com.kos.rboard.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.rboard.serivce.KosRboardService;
import a.b.c.com.kos.rboard.vo.KosRboardVO;


@Controller
public class KosRboardController {
	
	Logger log = LogManager.getLogger(KosRboardController.class);
	
	@Autowired(required = false)
	private KosRboardService kosRboardService; 
	
	@Autowired(required = false)
	private KosChabunService kosChabunService;
	
	@GetMapping("rboardForm")
	public String rboardForm() {
		
		return "rboard/rboardForm";
	}
	
	@PostMapping(value = "kosRboardSelectAll", produces = "application/x-www-form-urlencoded; charset=utf-8")
	@ResponseBody
	public String  kosRboardSelectAll(KosRboardVO krvo) {
		
		log.info("krvo >>> : " + krvo.getBnum());
		List<KosRboardVO> aList = kosRboardService.kosRboardSelectAll(krvo);
		
		String ss ="";
		String listStr = "";
		
		for (int i = 0; i < aList.size(); i++) {
			KosRboardVO _rbvo = aList.get(i);
			
			String s0 = _rbvo.getRbnum();
			String s1 = _rbvo.getRbcontent();
			String s2 = _rbvo.getRbname();
			String s3 = _rbvo.getInsertdate();
			
			ss = s0 + "," + s2 + "," + s1 + "," + s3;
			listStr += ss + "&";
		}
		
		return listStr;
	}
	
	@PostMapping("kosRboardInsert")
	@ResponseBody
	public String kosRboardInsert(KosRboardVO krvo) {
		
		String rbnum = ChabunUtil.getRboardChabun("Y", kosChabunService.getKosRboardChabun().getRbnum());
		
		krvo.setRbnum(rbnum);
		
		int nCnt = kosRboardService.kosRboardInsert(krvo);
		
		
		String msg = "";
		if (nCnt > 0) {
			
			msg = "GOOD";
			
			
		}else {
			
			msg = "NO";
			
		}
		
		return msg;
	}
	
	
	@PostMapping("kosRboardDelete")
	@ResponseBody
	public String kosRboardDelete(KosRboardVO krvo) {
		
		String msg = "";
		
		
		log.info(">>>> : " + krvo.getRbnum());
		log.info(">>>> : " + krvo.getBnum());
		log.info(">>>> : " + krvo.getRbname());
		log.info(">>>> : " + krvo.getRbcontent());
		log.info(">>>> : " + krvo.getDeleteyn());
		log.info(">>>> : " + krvo.getInsertdate());
		
		int nCnt = kosRboardService.kosRboardDelete(krvo);
		
		if(nCnt > 0) {
			
			msg = "OK";
			
		}else {
			
			msg = "NO";
		}
		
		return msg;
	}

}
