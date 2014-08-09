package Leetcode_isPalindrome;

public class Solution {
	public static void main(String[] args){
		String res = "1a1";
		System.out.println(isPalindrome(res));
	}
    public static boolean isPalindrome(String s) {
        if(s == null ||s.length()<1)
        	return true;
        s = s.toLowerCase();
        int i =0,j =s.length()-1;
        while(i<j){
        	if(!Character.isLetterOrDigit(s.charAt(i))){
        		i++;
        		continue;
        	}
        	if(!Character.isLetterOrDigit(s.charAt(j))){
        		j--;
        		continue;
        	}
        	if(s.charAt(i)!=s.charAt(j))
        		return false;
        	i++;
        	j--;
        }
        return true;
        	
    }
}
 