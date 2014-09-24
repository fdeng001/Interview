package LongestSubstringWithoutRepeating;

public class Solution {

	public int lengthOfLongestSubstring(String s){
		if(s.length()<=1){
			return s.length();
		}
		int prev = 0;
		boolean[] check =new boolean[256];
		int max = 0;
		for (int i = 0; i < s.length(); i++){
			if(!check[s.charAt(i)]){
				check[s.charAt(i)]=true;
			}
			else{
				while(s.charAt(prev)!=s.charAt(i)){
					check[s.charAt(i)]=false;
					prev++;
				}
				prev++;
			}
			max = Math.max(max, i - prev + 1);
		}
		return max;
	}
}
