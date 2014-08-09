package Leetcode_isInterleave;

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3 == null)
        	return false;
        if(s1.length()+s2.length()!=s3.length())
        	return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i = 1;i<s1.length()+1;i++){
        	if(s1.charAt(i-1) ==s3.charAt(i-1) &&dp[i-1][0])
        		dp[i][0] = true;
        }
        for(int i = 1;i<s2.length()+1;i++){
        	if(s2.charAt(i-1) ==s3.charAt(i-1) &&dp[0][i-1])
        		dp[0][i] = true;
        }
        for(int i = 1;i<s1.length()+1;i++)
        	for(int j = 1;j<s2.length()+1;j++){
        		if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) {  
                    dp[i][j] = true;  
                }  
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]) {  
                    dp[i][j] = true;  
                }  	
        	}
        return dp[s1.length()][s2.length()];
        
    }
    public boolean isInterleave2(String s1, String s2, String s3) {  
        if (s1.length()+s2.length()!=s3.length()) return false;  
        return rec(s1,0,s2,0,s3,0);  
    }  
      
    public boolean rec(String s1, int p1, String s2, int p2, String s3, int p3){  
        if (p3==s3.length()) return true;  
        if (p1==s1.length()) return s2.substring(p2).equals(s3.substring(p3));  
        if (p2==s2.length()) return s1.substring(p1).equals(s3.substring(p3));  
        if (s1.charAt(p1)==s3.charAt(p3)&&s2.charAt(p2)==s3.charAt(p3))  
            return rec(s1,p1+1,s2,p2,s3,p3+1) || rec(s1,p1,s2,p2+1,s3,p3+1);  
        else if (s1.charAt(p1)==s3.charAt(p3))  
            return rec(s1,p1+1,s2,p2,s3,p3+1);  
        else if (s2.charAt(p2)==s3.charAt(p3))  
            return rec(s1,p1,s2,p2+1,s3,p3+1);  
        else return false;  
    }  
}
