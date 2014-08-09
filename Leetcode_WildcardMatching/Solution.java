package Leetcode_WildcardMatching;

public class Solution {
	public static void main(String[] args){
		System.out.println(isMatch("foobarbar","foo*bar"));
	}
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int star = -1;
		int mark = -1;
		while(i<s.length()){
			if(j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))){
				i++;
				j++;
			}
			else if(j<p.length() && p.charAt(j) == '*'){
				star = j++;
				mark = i;
			}
			else if(star !=-1){
				j = star+1;
				i = ++mark;
			}
			else{
				return false;
			}
		}
		while(j<p.length()&& p.charAt(j) =='*'){
			++j;
		}
		return j == p.length();
	}
}
