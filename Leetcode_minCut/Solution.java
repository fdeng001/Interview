package Leetcode_minCut;

public class Solution {
	 public int minCut(String s) {
		    int min = 0;
		    int len = s.length();
		    boolean[][] matrix = new boolean[len][len];
		    int cuts[] = new int[len+1];
		    
		    if (s == null || s.length() == 0)
		      return min;
		    //初始化cuts里面的值为最坏情况的值
		    for (int i=0; i<len; ++i){
		      cuts[i] = len - i;
		    }
		    //dp过程
		    for (int i=len-1; i>=0; --i){
		      for (int j=i; j<len; ++j){
		        if ((s.charAt(i) == s.charAt(j) && (j-i<2))
		            || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))
		        {
		          matrix[i][j] = true;
		          cuts[i] = getMinValue(cuts[i], cuts[j+1]+1);
		        }
		      }
		    }
		    min = cuts[0];
		    return min-1;
		  }
		  
		  public int getMinValue(int a, int b){
		    return a > b ? b : a;
		  }
		  
		  public static void main(String[] args) {
		   
		  }
}
