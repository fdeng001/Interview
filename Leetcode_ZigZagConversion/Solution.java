package Leetcode_ZigZagConversion;

public class Solution {
	public static void main(String[] args){
		String s = "A";
		System.out.println(convert(s,1));
	}
	public static String convert(String s, int nRows) {
		if(nRows == 1){
			return s;
		}
		int len = s.length();
		String[] charList = new String[nRows];
		for(int i = 0;i<nRows;i++){
			charList[i] = "";
		}
		for(int i = 0, v_index=0; i < len; i++) {
			int x = i % (2*nRows-2);
			if (x<=nRows-1){
				v_index = x;
			} else {
				v_index = 2*nRows-2-x;
			}
			
			charList[v_index] += s.charAt(i);
		}
		String result = "";
		for(int i = 0;i<nRows;i++){
			result+=charList[i];
		}
		return result;
	}
}
