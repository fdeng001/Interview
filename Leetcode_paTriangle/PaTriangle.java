package Leetcode_paTriangle;

import java.util.ArrayList;

public class PaTriangle {
	public static ArrayList<ArrayList<Integer>> generate(int numRows) {

		ArrayList<Integer> rowList = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> paTriangle = new ArrayList<ArrayList<Integer>>();
		if(numRows>=1){
			rowList.add(1);
			paTriangle.add(rowList);
			for(int i=1;i<numRows;i++){
				ArrayList<Integer> List = new ArrayList<Integer>();
				List.add(1);
				for(int j = 0;j<(i-1);j++){
					ArrayList<Integer> oldList = paTriangle.get(i-1);
					List.add(oldList.get(j)+oldList.get(j+1));
				}
				List.add(1);

				paTriangle.add(List);
			}
		}
		return paTriangle;
	}
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> paTriangle = generate(0);
		for(int i =0;i<1;i++){
			System.out.println(paTriangle.get(i));
		}
	}
}
