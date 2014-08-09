package Leetcode_lengthOfLastWord;

public class LC_lengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		int length= s.length();
		for(int i = length-1;i>=0;i--){
			if(s.charAt(i)== ' '){
				return length-(i+1);
			}
		}
	}
}
