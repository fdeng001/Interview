package Leetcode_EncodingString;
import java.util.*;
/*
 * home -> 4, h3, h2e, h1m1, 3e, 2me, 2m1, � * hide -> 4, h3, h2e, h1d1, 3e, 2de, 2d1, � * show up all the possible strings.
 */
public class Solution {
	public static void main(String[] args){
		String Str = new String("hello");
		int Length = Str.length();
		System.out.println(Length);
		//int n = Character.getNumericValue(Str.charAt(0))+1;
		//char c = '5';
		//n = Integer.parseInt(c+"");
	   // System.out.println(n);
		System.out.println(encoding(Str));
	}
	public static ArrayList<String> encoding(String input){
		if(input.length() == 0){
			return null;
		}
		ArrayList<String> results = new ArrayList<String>();
		String tmp="";
		dfs(results,tmp,input,0);
		return results;
	}
	public static void dfs(ArrayList<String> results, String tmp, String input,int sum){
		int Length = tmp.length();
		int newNum = 0;
		String oldtmp = tmp;

		if(sum == input.length()){
			if(!results.contains(tmp)){
				results.add(tmp);
				return;
			}
		}
		if(sum < input.length()){
			if(sum > 0 && 1<= Character.getNumericValue(oldtmp.charAt(Length-1)) && Character.getNumericValue(oldtmp.charAt(Length-1))<input.length()){
				newNum = Character.getNumericValue(oldtmp.charAt(Length-1)) + 1;
				tmp = oldtmp.substring(0, Length-1) + newNum;
			}
			else{
				tmp = oldtmp.substring(0, Length) + 1;
			}
			dfs(results,tmp,input,sum+1);
			tmp = oldtmp + input.charAt(sum);
			dfs(results,tmp,input,sum+1);
		}
	}
}
