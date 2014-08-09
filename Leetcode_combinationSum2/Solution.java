package Leetcode_combinationSum2;

import java.util.*;

public class Solution {
	public static void main(String[] args){
		int[] num ={10,1,2,7,6,1,5};
		int target = 8;
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		 result = combinationSum2(num,target);
		 System.out.println(result);
	}
    public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int sum = 0,step = 0;
        dfs(result,tmp,num,target,step,sum);
        return result;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> result,
    		ArrayList<Integer> tmp,int[] num, int target, int step, int sum){
    	if(sum == target){
			if(!result.contains(tmp)){
				result.add(new ArrayList<Integer>(tmp));
				return;
			}
    	}
    	for(int i = step;i<num.length;i++){
    		if(num[i] + sum <= target){
    			tmp.add(num[i]);
    			dfs(result,tmp,num,target,i+1,num[i] + sum);
    			tmp.remove(tmp.size()-1);
    		}
    	}
    	return;
    }
}
