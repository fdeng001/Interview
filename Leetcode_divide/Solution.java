package Leetcode_divide;

public class Solution {
	public static void main(String[] args){
		System.out.println(divide(256,7));
	}
	public static int divide(int dividend, int divisor) {
		// Start typing your Java solution below
		// DO NOT write main() function       
		int ans = 0;
		boolean sign = true;

		if ((dividend >0 && divisor <0)
				|| (dividend < 0 && divisor >0 )) sign = false;

		long a = dividend;
		long b = divisor;
		if (a < 0) a = -a;
		if (b < 0) b = - b;


		while (a >= b)
		{
			int multi = 1;
			long tmp = b;
			while (a >= tmp) {
				a -= tmp;
				ans += multi;
				tmp += tmp;
				multi += multi;
			}
		}
		if (!sign) return -ans;
		else return ans;
	}

}
