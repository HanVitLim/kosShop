package a.b.c.com.flask.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FlaskController {
	
	Logger log = LogManager.getLogger(FlaskController.class);
	
	@GetMapping("flask_test")
	public ModelAndView flask_test(HttpServletRequest q) {
		
		ModelAndView mav = new ModelAndView();
		
		String url = "http://192.168.0.54:5000/";
		String sb = "";
		
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			
			String line = null;
			
			
			while ((line = br.readLine()) != null) {
				sb = sb + line + "\n";
				
			}
			
			log.info(">>> : " + sb.toString());
			
			if(sb.toString().contains("ok")) {
				log.info("test");
			}
			
			br.close();
			
			log.info(">>> : " + sb.toString());
		} catch (Exception e) {
			// TODO: handle exception
			log.info("error >>> : " + e.getMessage());
		}
		
		mav.addObject("test1", sb.toString());
		mav.addObject("fail", false);
		mav.setViewName("flask/jsp_flask");
		
		
		
		return mav;
	}
}
