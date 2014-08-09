package Leetcode_isScramble;

public class Solution {
	public static void main(String[] args){
		System.out.println(isScramble("aa","aa"));
	}
    public static boolean isScramble(String s1, String s2) {
        int len =s1.length();
        if(len!=s2.length())
        	return false;
        if(len<1)
        	return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        boolean[][][] dp = new boolean[len][len][len];
        for(int i = 0;i<len;i++){
        	for(int j = 0;j<len;j++){
        		dp[0][i][j] = c1[i] == c2[j];
        	}
        }
        for(int k = 2;k<=len;k++){
        	for(int i = len-k;i>=0;i--){
        		for(int j = len-k;j>=0;j--){
        			boolean result = false;
        			
        			for(int m=1;m<k;m++){
        				result = (dp[m-1][i][j] && dp[k-m-1][i+m][j+m]) ||    // 前前后后匹配  
                                (dp[m-1][i][j+k-m] && dp[k-m-1][i+m][j]);
        				
        				if(result){
            				break;
            			}
        			}
        			dp[k-1][i][j] = result;
        		}
        	}
        }
        return dp[len-1][0][0];
        
    }
}
