package main;

import java.util.StringTokenizer;

public class ReverseSentenceByWords {
	
	/*
	 * ����java��utilʵ����������  
	 */
	   public String reverseWords1(String s) {
	        if (s == null || s.length() == 0)
				return "";

			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(s, " ");
			while(st.hasMoreElements()){
				sb.insert(0, st.nextElement()+" ");
			}
			// ȥ�����һ���ո�
			String result = sb.toString();
	    if(result.length() <= 0)
				return "";
			else return result.substring(0, result.length() - 1);
	    }
	   
	   
	   
	   
	   public static void main(String[] args) {
		
	}

}
