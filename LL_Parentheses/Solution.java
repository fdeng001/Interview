package LL_Parentheses;

import java.util.ArrayList;

public class Solution {
	public static void main(String[] args){
		ArrayList<String> result =generateParenthesis(3);
		System.out.println(result);
	}
	public static ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> result = new ArrayList<String>();
		dfs(result,"",n,n);
		return result;
	}
	public static void dfs(ArrayList<String> res, String tmp, int left, int right){
		if(left == 0 && right == 0){
			res.add(tmp);
			return;
		}
		if(left>0){
			String newTmp = tmp+"(";
			dfs(res,newTmp,left-1,right);
			tmp = newTmp.substring(0,newTmp.length()-1);
		}
		if(left<right){
			String newTmp = tmp+")";
			dfs(res,newTmp,left,right-1);
			tmp = newTmp.substring(0,newTmp.length()-1);
		}
	}
}
