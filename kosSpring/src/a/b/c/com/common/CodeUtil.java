package a.b.c.com.common;

public class CodeUtil {

	public static final String[] gender_value = {"여자","남자"};
	
	public static final String[] hp_value = {"010","011","016","017","019"};
	
	public static final String[] tel_value = {"02","031","032","033","041",
											  "042","043","044","051","052",
											  "053","054","055","061","062",
											  "063","064"};
	public static final String[] hobby_lavel = {"운동","여행","독서","음악감상"};
	public static final String[] hobby_value = {"01","02","03","04"};
	
	public static String birth(String s) {
		
		String ss ="";
		
		if(s !=null & s.length()>0) {
			if(s.length() == 8) {
				
				ss = s.substring(2);
			}
			
		}
		
		return ss;
	}
	
	public static String gender(String s) {
		String a = "";
		
		if("F".equals(s.toUpperCase())) {
			a = gender_value[0];
		}else {
			a = gender_value[1];
		}
		
		return a;
	}
	
	public static String tel(String s) {
		
		int sLen = s.length();
		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if(sLen == 9) {
			s0 = s.substring(0,2);
			s1 = s.substring(2,5);
			s2 = s.substring(5);
			ss = s0.concat("-").concat(s1).concat("-").concat(s2);
		}else {
			s0 = s.substring(0,3);
			s1 = s.substring(3,6);
			s2 = s.substring(6);
			ss = s0.concat("-").concat(s1).concat("-").concat(s2);
			
		}
		
		return ss;
	}
	
	public static String hp(String s) {
		
		int sLen = s.length();
		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if(sLen == 10) {
			s0 = s.substring(0,3);
			s1 = s.substring(3,6);
			s2 = s.substring(6);
			ss = s0.concat("-").concat(s1).concat("-").concat(s2);
		}else {
			s0 = s.substring(0,3);
			s1 = s.substring(3,7);
			s2 = s.substring(7);
			ss = s0.concat("-").concat(s1).concat("-").concat(s2);
			
		}
		
		return ss;
	}
	
	public static String hobby(String s) {
		String h = "";
		for (int i = 1; i<hobby_lavel.length; i++) {
			if(("0" + i).equals(s)) {
				h = CodeUtil.hobby_lavel[i-1];
			}
		}
		
		return h;
	}
	
	public static String hobbys(String s) {
		String h = "";
		String ss[] = s.split(",");
		
		for (int i=0; i<ss.length; i++) {
			h += hobby(ss[i]) + " ";
		}
		
		return h;
	}
	
	
	public static void main(String[] args) {
		
		String a = CodeUtil.birth("19920215");
		
		System.out.println("a >>> : " + a);
		
		
		String b = CodeUtil.gender("M");
		System.out.println("b >>> : " + b);
		
		System.out.println(">>>> : " + CodeUtil.tel("021231234"));
		System.out.println(">>>> : " + CodeUtil.tel("0311231234"));
		System.out.println(">>>> : " + CodeUtil.hp("0101234567"));
		System.out.println(">>>> : " + CodeUtil.hp("01012345678"));
		
		System.out.println(">>>> : " + CodeUtil.hobby("02"));
		System.out.println(">>>> : " + CodeUtil.hobbys("01,02,03,"));
	}
}