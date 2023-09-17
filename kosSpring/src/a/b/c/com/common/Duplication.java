package a.b.c.com.common;

import java.util.ArrayList;
import java.util.HashSet;

public class Duplication {

	public static ArrayList<String> duplicationStr(String[] s){
		
		ArrayList<String> arr = new ArrayList<String>();
		
		for (int i = 0; i < s.length; i++) {
			
			arr.add(s[i]);
		}		
		
		HashSet<String> arr2 = new HashSet<String>(arr);
		
		ArrayList<String> arr3 = new ArrayList<String>(arr2);
		
		return arr3;
	}
	
	public static ArrayList<Integer> duplicationInt(int[] i){
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int ii = 0; ii < i.length; ii++) {
			
			arr.add(i[ii]);
		}		
		
		HashSet<Integer> arr2 = new HashSet<Integer>(arr);
		
		ArrayList<Integer> arr3 = new ArrayList<Integer>(arr2);
		
		return arr3;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] i = new int[5];
		
		for (int j = 0; j < 3; j++) {
			i[j] = 1;
		}
		
		i[3] = 2;
		i[4] = 5;
		
		System.out.println(Duplication.duplicationInt(i));
		
		String a = "A,B,A,A,B,A,A,B,A,A,B,A,C,D";
		
		System.out.println("a >>>  " + a);
		String[] a1 = a.split(",");
		
		System.out.println(Duplication.duplicationStr(a1));  
		
		
		
	}

}
