package Leetcode_Permutations;

import java.util.ArrayList;

public class LC_Permutations {
	public static void main(String[] args){
		int[] n={1,1,2};
		ArrayList<ArrayList<Integer>> paTriangle = permuteUnique(n);
		for(int i =0;i<paTriangle.size();i++){
			System.out.println(paTriangle.get(i));
		}
	}
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		permuteHelper(result, list, num);
		return result;
	}


	private static void permuteHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] num) {

		if (list.size() == num.length) {
			result.add(new ArrayList<Integer>(list));
			return;
		}	

		for (int i = 0; i < num.length; i++) {
			if (list.contains(num[i])) {
				continue;
			}

			list.add(num[i]);
			permuteHelper(result, list, num);		
			list.remove(list.size() - 1);
		}
	}

	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0) {
			return list;
		}
		int len = num.length;
		int visit[] = new int[len];
		ArrayList<Integer> numList = new ArrayList<Integer>();
		dfs(list, numList, num, visit, len);
		return list;
	}

	public static void dfs(ArrayList<ArrayList<Integer>> list,
			ArrayList<Integer> numList, int[] num, int[] visit, int len) {
		if (numList.size() == len) {
			list.add(new ArrayList<Integer>(numList));
			return;
		}
		ArrayList<Integer> usedList = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			if (visit[i] == 0) { 
				if(usedList.contains(num[i])){
					continue;
				}else{
					usedList.add(num[i]);
				}
				visit[i] = 1;
				numList.add(num[i]);
				dfs(list, numList, num, visit, len);
				numList.remove(numList.size()-1);
				visit[i] = 0;
			}
		}
	}

}
