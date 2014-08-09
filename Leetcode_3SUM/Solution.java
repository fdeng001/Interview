package Leetcode_3SUM;

import java.util.*;
public class Solution {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(num.length<3)
			return result;
		Arrays.sort(num);
		for(int i = 0;i<num.length-2;i++){
			if(i == 0||num[i] >num[i-1]){
				int j = i+1, k = num.length-1;
				while(j<k){
					if(num[j]+num[k]==-num[i]){
						ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        result.add(temp);
                        j++;k--;
                        while(k>j && num[k]==num[k+1]) k--;//avoid duplicate solutions 
                        while(j<k && num[j]==num[j-1]) j++;//avoid duplicate solutions 
					}
					else if(num[j]+num[k]>-num[i]){
						k--;
					}
					else{
						j++;
					}
				}
			}
		}
		return result;
	}
}
