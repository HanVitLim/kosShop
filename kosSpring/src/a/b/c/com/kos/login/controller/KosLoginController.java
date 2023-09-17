package a.b.c.com.kos.login.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import a.b.c.com.common.K_Session;
import a.b.c.com.kos.login.service.KosLoginService;
import a.b.c.com.kos.mem.vo.KosMemberVO;
@Controller
public class KosLoginController {
	
	static Logger log = LogManager.getLogger(KosLoginController.class);
	
	@Autowired(required = false)
	private KosLoginService kosLoginService;

	@GetMapping("mainPage")
	public String mainPage() {
		return "main/mainPage";
	}
	
	
	@GetMapping("loginCart")
	public String kosLoginCart(HttpServletRequest req, Model model) {
		
		String kpnum = req.getParameter("kpnum");
		
		model.addAttribute("kpnum", kpnum);
		
		return "login/loginCartForm";
	}
	
	@PostMapping("loginCartCheck")
	public String kosLoginCartCheck(KosMemberVO kvo, HttpServletRequest req, Model model) {
		
		String kpnum = req.getParameter("kpnum");
		List<KosMemberVO> listlogin = kosLoginService.kosLoginCheck(kvo);

		if(listlogin.size() == 1) {
			
			K_Session ks = K_Session.getInstance();
			String kID = ks.getSession(req);
			
			if(kID != null && kID.equals(listlogin.get(0).getMid())) {
				
				model.addAttribute("listLogin", listlogin);
				model.addAttribute("kpnum", kpnum);
				return "login/loginCart";
				
			}else {
				
				ks.setSession(req, kvo.getMid());
				model.addAttribute("listLogin", listlogin);
				model.addAttribute("kpnum", kpnum);
			return "login/loginCart";
			}
			
		}
		
		return "login/loginCartForm";
	}
	
	
	@GetMapping("loginForm")
	public String kosLoginForm() {
		
		return "login/loginForm";
	}
	
	@PostMapping("loginCheck")
	public String kosLoginCheck(KosMemberVO kvo, HttpServletRequest req, Model model){
		
		List<KosMemberVO> listlogin = kosLoginService.kosLoginCheck(kvo);
		
		if(listlogin.size() == 1) {
			
			K_Session ks = K_Session.getInstance();
			String kID = ks.getSession(req);
			
			if(kID != null && kID.equals(listlogin.get(0).getMid())) {
				
				model.addAttribute("listLogin", listlogin);
					
				return "main/mainPage";
				
			}else {
				
				ks.setSession(req, kvo.getMid());
				model.addAttribute("listLogin", listlogin);
				
			return "login/login";
			}
			
		}
		
		return "login/loginForm";
	}
	
	@GetMapping("logout")
	public String kosLogout(HttpServletRequest req, KosMemberVO mvo, Model model) {
			
		K_Session ks = K_Session.getInstance();
		ks.killSession(req);
		
		return "login/logout";
	}
	
	@ResponseBody
	@PostMapping("loginCheckAjax")
	public String loginCheckAjax(HttpServletRequest req, Model model) {
		
		K_Session ks = K_Session.getInstance();
		String kID = ks.getSession(req);
		
		return kID;
		
	}
	
	@GetMapping("kakaoLogin")
	public String kakaoLogin(HttpServletRequest req, KosMemberVO kvo, Model model) {
		
		log.info("kakaoLogin 함수 진입 성공 >>>> : ");
		
		String snstype = req.getParameter("snstype");
		String snsid = req.getParameter("snsid");
		String snsemail = req.getParameter("snsemail");
		
		kvo.setSnstype(snstype);
		kvo.setSnsid(snsid);
		kvo.setSnsemail(snsemail);
		
		String mhp = "01012341234";
		String memail = "1111@abc.com";
		
		kvo.setMid(snsid);
		kvo.setMpw(snsid);
		kvo.setMhp(mhp);
		kvo.setMemail(snsemail);
		
		
		List<KosMemberVO> list = kosLoginService.kakaoLogin(kvo);
		
		log.info(">>>> : " + list.size());
		
		if(list.size() > 0 ) {
			
			log.info(">>>> : " + list.size());
			model.addAttribute("list", list);
			
			return "main/mainPage";
			
		} else {
			
			int nCnt = kosLoginService.kakaoInsert(kvo);
			
			if(nCnt > 0) {
				List<KosMemberVO> alist = kosLoginService.kakaoLogin(kvo);

				model.addAttribute("alist", alist);
				
				return "main/mainPage";
			}
			
		}
		
		return "login/login";
	}
	
	
	@GetMapping("naverCallback")
	public String naverCallback() {
		
		return "login/naverCallback";
	}
	
	@GetMapping("naverlogin")
	public String naverLogin(HttpServletRequest request, Model model) {
		log.info("naverLogin 함수 진입 성공 >>> : ");

		String access_token = (String) request.getAttribute("access_token");
		log.info("naverLogin access_token >>> : " + access_token);
		
		String token = access_token;
		String header = "Bearer " + token;
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("Authorization", header);
		String responseBody = get(apiURL, requestHeaders);
		log.info("responseBody >>> : " + responseBody);
				
		JSONObject jobj = new JSONObject();
		JSONParser parser = new JSONParser();

		try {
			jobj = (JSONObject)parser.parse(responseBody);
			
			// resultCode가 00이고 message가 success이면 실행
			String resultcode = (String)jobj.get("resultcode");
			String message = (String)jobj.get("message");
			
			jobj =(JSONObject)jobj.get("response"); 			//여기서 response가 json객체 안에 json객체
			String id =(String)jobj.get("id");					// 아이디 1x 
			String email =(String)jobj.get("email");			// 이메일 
			String name =(String)jobj.get("name");				// 이름 
			String nick = (String)jobj.get("nickname");			// 닉네임
			String phone = (String)jobj.get("mobile");			// 전화번호
			String photo = (String)jobj.get("profile_image");
			
			log.info("id >>> : " + id);
			log.info("email >>> : " + email);
			log.info("name >>> : " + name);
			log.info("nick >>> : " + nick);
			log.info("phone >>> : " + phone);
			log.info("photo >>> : " + photo);
	
			// VO 이용해서 로그인 루틴 만들기 
			
			KosMemberVO mvo = new KosMemberVO();
			
			mvo.setSnstype("02");
			mvo.setSnsid(id);
			mvo.setSnsemail(email);
			mvo.setMid(id);
			mvo.setMpw(id);
			mvo.setMemail(email);
			mvo.setMname(name);
			mvo.setMhp(phone);
			
			
			List<KosMemberVO> list = kosLoginService.kakaoLogin(mvo);
			
			if(list.size() > 0) {
				
				model.addAttribute("list", list);
				
				return "main/mainPage";

			}else {
				
				int nCnt = kosLoginService.kakaoInsert(mvo);
				
				if(nCnt > 0) {
					List<KosMemberVO> alist = kosLoginService.kakaoLogin(mvo);
					model.addAttribute("alist", alist);
				
				return "main/mainPage";
				}
			}
			
			
		} catch (Exception e) {
			System.out.println("json 객체 변환실패");		
			
		}
		
			return "login/loginForm";
	}
	
	public static String get(String apiUrl, Map<String, String> requestHeaders) {
		System.out.println(apiUrl + " : " + requestHeaders);
		
		HttpURLConnection con = connect(apiUrl);
		
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
				System.out.println(header.getKey() + " : " + header.getValue());
			}
			int responseCode = con.getResponseCode();
			System.out.println(">>>> " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 에러 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}
	
	public static HttpURLConnection connect(String apiUrl) {
		try {
			System.out.println(">>>>a " +apiUrl);
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다 >>> : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다 >>> : " + apiUrl, e);
		}
	}
	
	public static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);
		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();
			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			System.out.println(">>>> " + responseBody.toString());
			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는데 실패했습니다. >>> : ", e);
		}
	}
	

}
