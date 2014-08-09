package Leetcode_restoreIpAddresses;
import java.util.*;
public class Solution {
	public static void main(String[] args){
		System.out.println(restoreIpAddresses("25525511135"));
	}
    public static ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(s == null || s.length()<4 || s.length()>12)
    		return result;
    	dfs(result,s,"",0);
    	return result;
    }

	private static void dfs(ArrayList<String> result, String s, String tmp, int count) {
		// TODO Auto-generated method stub
		if(count == 3&& isValid(s)){
			result.add(tmp+s);
			return;
		}
		for(int i =1;i<4 && i<s.length();i++){
			String sub = s.substring(0, i);
			if(isValid(sub)){
				dfs(result,s.substring(i),tmp+sub+".",count+1);
			}
		}
		
	}

	private static boolean isValid(String tmp) {
		// TODO Auto-generated method stub
		if(tmp.charAt(0)=='0')
			return tmp.equals("0");
		int num = Integer.parseInt(tmp);
		return num<=255&&num>0;
	}
}
