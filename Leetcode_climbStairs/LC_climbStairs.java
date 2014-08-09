package Leetcode_climbStairs;

import java.util.ArrayList;

public class LC_climbStairs {
	public static void main(String[] args){
		System.out.println(climbStairs(38));

	}
	static int climbStairs(int n) {
		ArrayList<Integer> map = new ArrayList<Integer>();
		if(n == 0 || n == 1 || n == 2){return n;}
		if(map.size() >= n) return (map.get(n-1)).intValue();
		if(map.size() < 2){
			map.add(0,new Integer(1));
			map.add(1,new Integer(2));
		}
		for(int i = map.size(); i < n; i++){
			map.add(i,map.get(i-1)+map.get(i-2));  
		}
		return (map.get(n-1)).intValue();
	}




}
