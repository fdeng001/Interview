package Leetcode_maximalRectangle;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public static void main(String[] args){
		char[][] matrix = new char[4][4];
		for(int i = 0;i<4;i++)
			for(int j = 0;j<4;j++)
				matrix[i][j] = '0';
		matrix[0][0] ='1';
		matrix[0][1] ='1';
		matrix[0][2] ='1';
		matrix[1][3] ='1';
		matrix[1][0] ='1';
		matrix[1][1] ='1';
		matrix[2][0] ='1';
		matrix[2][1] ='1';
		matrix[2][2] ='1';
		matrix[2][3] ='1';
		matrix[3][2] ='1';
		matrix[3][3] ='1';
		print(matrix);
		System.out.print(maximalRectangle(matrix));
	}
	public static void print(char[][] matrix){
		for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = m == 0 ? 0 : matrix[0].length;
        int[][] height = new int[m][n + 1];
        //actually we know that height can just be a int[n+1], 
        //however, in that case, we have to write the 2 parts together in row traverse,
        //which, leetcode just doesn't make you pass big set
        //所以啊，leetcode是喜欢分开写循环的，即使时间复杂度一样，即使可以节约空间
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '0'){
                    height[i][j] = 0;
                }else {
                    height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                }
            }
        }
        System.out.println("--------------------------------");
        for(int i = 0;i<4;i++){
			for(int j = 0;j<4;j++){
				System.out.print(height[i][j]+" ");
			}
			System.out.println();
		}
        for(int i = 0; i < m; i++){
            int area = maxAreaInHist(height[i]);
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
     }
     
     private static int maxAreaInHist(int[] height){
    	 Stack<Integer> stack = new Stack<Integer>();
         int i = 0;
         int maxArea = 0;
         int[] h = new int[height.length + 1];
         h = Arrays.copyOf(height, height.length + 1);
         while(i < h.length){
             if(stack.isEmpty() || h[stack.peek()] <= h[i]){
                 stack.push(i++);
             }else {
                 int t = stack.pop();
                 maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
             }
         }
         return maxArea;
     }
}
