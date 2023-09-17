package a.b.c.com.kos.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.CommonUtils;
import a.b.c.com.common.FileUploadUtil;
import a.b.c.com.common.K_Session;
import a.b.c.com.common.NumUtill;
import a.b.c.com.common.chabun.service.KosChabunService;
import a.b.c.com.kos.product.service.KosProductService;
import a.b.c.com.kos.product.vo.KosProductVO;

@Controller
public class KosProductController {
	Logger log = LogManager.getLogger(KosProductController.class);
	
	@Autowired(required = false)
	private KosProductService kosProductService;
	
	@Autowired(required = false)
	private KosChabunService kosChabunService; 

	@GetMapping("kosProductInsertForm")
	public String kosProductInsertForm() {
		
		return "product/kosProductInsertForm";
	}
	
	@PostMapping("kosProductInsert")
	public String kosProductInsert(KosProductVO kpvo, HttpServletRequest req) {
		
		FileUploadUtil fp = new FileUploadUtil(CommonUtils.PRODUCT_IMG_UPLOAD_PATH, CommonUtils.PRODUCT_IMG_FILE_SIZE, CommonUtils.PRODUCT_EN_CODE);
		
		boolean bool = fp.imgfileUpload(req);
		
		kpvo.setKpnum(ChabunUtil.getProductChabun("Y", kosChabunService.getKosProductChabun().getKpnum()));
		kpvo.setKpname(fp.getParameter("kpname"));
		kpvo.setKpid(fp.getParameter("kpid"));
		kpvo.setKpcnt(Integer.parseInt(fp.getParameter("kpcnt")));
		kpvo.setKpcompany(fp.getParameter("kpcompany"));
		kpvo.setKpdesc(fp.getParameter("kpdesc"));
		kpvo.setKpprice(Integer.parseInt(fp.getParameter("kpprice")));
		kpvo.setKpfile(fp.getFileName("kpfile"));
		
		int nCnt = kosProductService.kosProductInsert(kpvo);
		
		if(nCnt > 0) {
			
			return "product/kosProductInsert";
		}
		
		return "product/kosProductInsertForm";
	}
	
	
	@GetMapping("kosProductSelectAll")
	public String kosProductSelectAll(KosProductVO kpvo, Model model, HttpServletRequest req) {
		
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		
		
		log.info(kpvo.getCurPage());
		
		
		if(kpvo.getCurPage() == null) {
		
		kpvo.setCurPage(Integer.toString(CommonUtils.PRODUCT_CUR_PAGE));
		log.info(kpvo.getCurPage());
		
		}
		
		kpvo.setPageSize(Integer.toString(CommonUtils.PRODUCT_PAGE_SIZE));
		kpvo.setGroupSize(Integer.toString(CommonUtils.PRODUCT_GROUP_SIZE));
		kpvo.setTotalCount(Integer.toString(CommonUtils.PRODUCT_TOTAL_COUNT));
		
		List<KosProductVO> listpro = kosProductService.kosProductSelectAll(kpvo);
		
		if(listpro.size() > 0) {
						
		
			model.addAttribute("_kpvo",kpvo);
			model.addAttribute("listpro", listpro);
			
			return "product/kosProductSelectAll";
		}
		
		return "product/kosProductInsertForm";
	}
	
	@GetMapping("kosProductSelect")
	public String kosProductSelect(KosProductVO kpvo, Model model, HttpServletRequest req) {
		
		
		String kID = req.getParameter("kid");
		
		log.info(kID);
		
		if(kID != null) {
		String kpnum = req.getParameter("kpnum");
		log.info(kpnum);
		kpvo.setKpnum(kpnum);
		}
		
		
		List<KosProductVO> listS = kosProductService.kosProductSelect(kpvo);
		
		if(listS.size() > 0) {
			model.addAttribute("listS",listS);
			if(kID == null) {
				kID = "0";
				model.addAttribute("kid",kID);
			}else {
				model.addAttribute("kid",kID);
			}
			return "product/kosProductSelect";
		}
		
		return "product/kosProductSelectAll";
	}
	
}
