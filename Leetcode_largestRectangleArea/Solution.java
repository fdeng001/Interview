package Leetcode_largestRectangleArea;

import java.util.*;

public class Solution {
	public static void main(String[] args){
		int[] num = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(num));
	}
	public static int largestRectangleArea(int[] height) {
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
