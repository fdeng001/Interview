package Leetcode_JumGame2;

public class Solution {
	public static void main(String[] args){
		int[] A = {2,3,1,1,4};
		System.out.println(jump(A));
	}
	public static int jump(int[] A) {
		int result = 0;
		int last = 0;
		int cur = 0;
		for(int i = 0;i<A.length;i++){
			if(i>last){
				if(cur == last && last < A.length-1){
					return -1;
				}
				last = cur;
				result++;
			}
			cur = Math.max(cur, i+A[i]);
		}
		return result;
	}
}
