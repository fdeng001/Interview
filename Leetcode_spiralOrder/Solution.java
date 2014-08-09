package Leetcode_spiralOrder;
import java.util.*;

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	 if(matrix==null || matrix.length==0 || matrix[0].length==0) return new ArrayList<Integer>();
    	 ArrayList<Integer> res = new ArrayList<Integer>();
    	 int upper = 0, bottom =matrix.length-1;
    	 int left = 0, right = matrix[0].length-1;
    	 int i = 0,j=0;
    	 while(true){
    		 for(i = left;i<=right;i++)
    			 res.add(matrix[upper][i]);
    		 if(++upper>bottom)break;
    		 for(j = upper;j<=bottom;j++)
    			 res.add(matrix[j][right]);
    		 if(--right<left)break;
    		 for(i = right;i>=left;i--)
    			 res.add(matrix[bottom][i]);
    		 if(--bottom<upper)break;
    		 for(j = bottom;j>=upper;j--)
    			 res.add(matrix[j][left]);
    		 if(++left>right)break;
    	 }
    	 return res;
    }
}
