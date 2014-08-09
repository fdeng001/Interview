package Leetcode_numDistinct;

public class Solution {
	public static void main(String[] args){
		String S = "abcbc";
		String T ="abc";
		System.out.println(numDistinct(S,T));
	}
    public static int numDistinct(String S, String T) {
       int sLen = S.length();
       int tLen = T.length();
       int[][] dp = new int[sLen+1][tLen+1];
       dp[0][0] = 1;
       for(int i = 1; i<=tLen;i++)
    	   dp[0][i] = 0;
       for(int j=1;j<=sLen;j++)
    	   dp[j][0] = 1;
       
       for(int i=1;i<=sLen;i++){
    	   for(int j=1;j<=tLen;j++){
    		   dp[i][j] = dp[i-1][j];
    		   if(S.charAt(i-1) == T.charAt(j-1))
    			   dp[i][j] += dp[i-1][j-1];
    	   }
       }
       return dp[sLen][tLen];
    }
}
