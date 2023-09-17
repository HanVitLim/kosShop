package a.b.c.com.kos.order.controller;

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
import a.b.c.com.common.Duplication;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.cart.service.KoscartService;
import a.b.c.com.kos.cart.vo.KoscartVO;
import a.b.c.com.kos.order.service.KosOrderService;
import a.b.c.com.kos.order.vo.KosOrderVO;
@Controller
public class KosOrderController {
	
	Logger log = LogManager.getLogger(KosOrderController.class);
	
	@Autowired(required = false)
	private KosChabunService kosChabunService;
	
	@Autowired(required = false)
	private KosOrderService kosOrderService;
	
	@Autowired(required = false)
	private KoscartService koscartService;
	
	@GetMapping("kosOrderInsertForm")
	public String kosOrderInsertForm(KoscartVO kcvo, HttpServletRequest req, Model model) {
		
		String kcnumV[] = req.getParameterValues("kcnum");
		
		ArrayList<KoscartVO> aList = new ArrayList<KoscartVO>();
		
		for (int i = 0 ; i < kcnumV.length; i++) {
			KoscartVO _kcvo = new KoscartVO();
			_kcvo.setKcnum(kcnumV[i]);
			aList.add(_kcvo);
		}
		
		List<KoscartVO> list = koscartService.koscartorderSelectAll(aList);
		
		if(list.size() > 0) {
		
			model.addAttribute("list", list);
		
		}
		
		return "order/kosOrderInsertForm";
	}
	
	@GetMapping("kosOrderInsert")
	public String kosOrderInsert(KosOrderVO kovo, Model model){
		
		String konum = ChabunUtil.getOrderChabun("D", kosChabunService.getKosOrderChabun().getKonum());
		
		log.info(kovo.getKpcnt());
		log.info(kovo.getKpprice());
		log.info(kovo.getKppricesum());
		
		String kpprice = "";
		String kpid = "";
		String kpnum = "";
		String kpname = "";
		ArrayList<String> aListprice = Duplication.duplicationStr(kovo.getKpprice().split(","));
		ArrayList<String> aListnum = Duplication.duplicationStr(kovo.getKpnum().split(","));
		ArrayList<String> aListpid = Duplication.duplicationStr(kovo.getKpid().split(","));
		ArrayList<String> aListpname = Duplication.duplicationStr(kovo.getKpname().split(","));
		
		for (int i = 0; i < aListprice.size(); i++) {
			kpprice += aListprice.get(i).concat(",");
		}
		
		for (int i = 0; i < aListnum.size(); i++) {
			kpnum += aListnum.get(i).concat(",");
		}
		
		for (int i = 0; i < aListpid.size(); i++) {
			kpid += aListpid.get(i).concat(",");
		}
		
		for (int i = 0; i < aListpname.size(); i++) {
			kpname += aListpname.get(i).concat(",");
		}
		
		System.out.println("kpprice1 >>> : " + kpprice);
		System.out.println("kpnum >>> : " + kpnum);
		System.out.println("kpid >>> : " + kpid);
		System.out.println("kpname >>> : " + kpname);
		
		kovo.setKpid(kpid);
		kovo.setKpnum(kpnum);
		kovo.setKpprice(kpprice);
		kovo.setKonum(konum);
		kovo.setKpname(kpname);
		
		int nCnt = kosOrderService.kosOrderInsert(kovo);
		
		if (nCnt > 0) {
			
			model.addAttribute("nCnt", nCnt);
		}
		
		return "";
	}

}
