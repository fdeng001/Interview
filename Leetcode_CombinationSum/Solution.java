package Leetcode_CombinationSum;
import java.util.*;

public class Solution {
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		if(candidates.length == 0)
			return res;
		Arrays.sort(candidates);
		dfs(res,tmp,candidates,target,0,0);
		return res;
    }
	public void dfs(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tmp, 
			int[] candidates, int target, int step, int sum){
		if(sum == target){
			if(!result.contains(tmp)){
				result.add(new ArrayList<Integer>(tmp));
			}
			return;
		}
		if(sum > target){
			return;
		}
		for(int i = step; i< candidates.length;i++){
			tmp.add(candidates[i]);
			dfs(result,tmp,candidates,target,i,sum+candidates[i]);
			tmp.remove(tmp.size()-1);
		}
		return;
	}
}
