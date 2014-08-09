package Leetcode_PascalTriangle;

import java.util.ArrayList;

public class LC_getrow {
	public static void main(String[] args){

		ArrayList<Integer> result = new ArrayList<Integer>();
		result = getRow(24);
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i));
		}
	}
	public static ArrayList<Integer> getRow(int rowIndex) {
		double num = 1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int col = 0; col <= rowIndex; col++) {
			if (col > 0) {
				num = num * (rowIndex+1 - col) / col; 
			}
			result.add((int)num);
		}
		return result;
	}
}
