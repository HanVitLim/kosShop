package a.b.c.com.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestValidation {
	
	public static boolean testValidation(String sV) {
		
		Logger log = LogManager.getLogger(TestValidation.class);
		
		boolean bool =false;
		
		int nCnt = 0;
		int nCnt_A = 0;
		int nCnt_a = 0;
		int nCnt_x = 0;
		int nCnt_n = 0;
		log.info("sV >>> : " + sV);
		if(sV != null && sV.length() > 0) {
			
			int sVlen = sV.length();
			log.info("svlen >>> : " + sVlen);

			if(sVlen <=12) {
				
				for(int i = 0; i<sVlen; i++) {
					
					char cS = sV.charAt(i);
					log.info("char >>>> : " + cS);
					
					if(0x41 <= cS && cS<=0x5A) {
						nCnt_A++;
					}
					
					if(0x61 <= cS && cS <=0x7A) {
						nCnt_a++;
					}
					if(0x21 <= cS && cS<=0x27) {
						nCnt_x++;
					}
					if(0x30 <= cS && cS <= 0x39) {
						nCnt_n++;
					}
					
					nCnt++;
				}
			}
		
			log.info("대문자 " + nCnt_A);
			log.info("소문자 " + nCnt_a);
			log.info("특수문자 " + nCnt_x);
			log.info("숫자 " + nCnt_n);
			log.info(nCnt);
			

			if(nCnt_A > 0 && nCnt_a > 0 && nCnt_x >0 && nCnt_n > 0 && 8<=nCnt && nCnt<=12) {
				
				if(nCnt == nCnt_A + nCnt_a + nCnt_n + nCnt_x) {
					
					bool = true;
				}
			}
			
		}
		
		return bool;
	}
	
	public static void main(String[] args) {
		String sV = "1";
		
		boolean bool = TestValidation.testValidation(sV);

		
		System.out.println("bool >>>> :" + bool);

		
	}

}
