package Leetcode_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC_subsets {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int[] S = {0,0,-1,0};
		//res = subsets(S);
		System.out.println(longestConsecutive(S));
		/*for(int i = 0; i<res.size();i++)
			System.out.println(res.get(i));*/
	}
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if(S==null) return null;
		int n = S.length;
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<n;i++){
			ArrayList<ArrayList<Integer>> cur = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> temp:res){
				cur.add(new ArrayList<Integer>(temp));
			}
			for(ArrayList<Integer> temp:cur){
				temp.add(S[i]);
			}
			ArrayList<Integer> temp1 = new ArrayList<Integer>();
			temp1.add(S[i]);
			cur.add(temp1);
			res.addAll(cur);
		}
		res.add(new ArrayList<Integer>());
		return res;

	}
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		if(m==0 ||n==0) return 0;
		int[] max = new int[n];
		max[0] =1;
		if(obstacleGrid[0][0]==1) return 0;
		for(int i = 0;i<m;i++){
			for(int j =0;j<n;j++){
				if(obstacleGrid[i][j] ==1) max[j] =0;
				else if(j>0)
					max[j] = max[j]+max[j-1];
			}
		}
		return max[n-1];
	}
	public static int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>(); 
		for(int i:num)
			set.add(i);
		int max = 0;
		for(int i = 0;i<num.length;i++){
			if(set.contains(num[i])){
				int next = num[i]-1;
				int count = 1;
				set.remove(num[i]);
				while(set.contains(next)){
					set.remove(next);
					next--;
					count++;
				}
				next =num[i]+1;
				
				while(set.contains(next)){
					set.remove(next);
					next++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}
}
