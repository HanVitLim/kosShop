package a.b.c.com.common;

public abstract class ChabunUtil {
	
	public static final String BIZ_GUBUN_M = "M";
	public static final String BIZ_GUBUN_B = "B";
	public static final String BIZ_GUBUN_R = "R";
	public static final String BIZ_GUBUN_P = "P";
	public static final String BIZ_GUBUN_C = "C";
	public static final String BIZ_GUBUN_O = "O";
	
	public static String numPad(String t, String c) {
		
		for (int i =c.length(); i< 4; i++) {
			c = "0" + c;
			
		}
		String ymd = DateFormatUtil.ymdFormats(t);
	return ymd.concat(c);
	}
	
	public static String getMemberChabun (String type, String num) {
		return BIZ_GUBUN_M.concat(ChabunUtil.numPad(type, num));
	}
	
	public static String getBoardChabun (String type, String num) {
		
		return BIZ_GUBUN_B.concat(ChabunUtil.numPad(type, num));
	}
	
	public static String getRboardChabun (String type, String num) {
		
		return BIZ_GUBUN_R.concat(ChabunUtil.numPad(type, num));
	}
	
	public static String getProductChabun (String type, String num) {
		
		return BIZ_GUBUN_P.concat(ChabunUtil.numPad(type, num));
	}
	
	public static String getCartChabun (String type, String num) {
		
		return BIZ_GUBUN_C.concat(ChabunUtil.numPad(type, num));
	}
	
	public static String getOrderChabun (String type, String num) {
		
		return BIZ_GUBUN_O.concat(ChabunUtil.numPad(type, num));
	}
	
}

