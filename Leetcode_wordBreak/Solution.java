package Leetcode_wordBreak;
import java.util.*;

public class Solution {
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		if(s==null || s.length()==0)
			return res;
		helper(s,dict,0,"",res);
		return res;
	}
	private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res)
	{
		if(start>=s.length())
		{
			res.add(item);
			return;
		}
		StringBuilder str = new StringBuilder();
		for(int i=start;i<s.length();i++)
		{
			str.append(s.charAt(i));
			if(dict.contains(str.toString()))
			{
				String newItem = item.length()>0?(item+" "+str.toString()):str.toString();
				helper(s,dict,i+1,newItem,res);
			}
		}
	}

	public static ArrayList<String> wordBreak2(String s, Set<String> dict) {
		ArrayList<String> result = new ArrayList<String>();
		if (s == null || dict.size() <= 0) {
			return result;
		}
		int length = s.length();
		// seg(i, j) means substring t start from i and length is j can be
		// segmented into
		// dictionary words
		boolean[][] seg = new boolean[length][length + 1];
		for (int len = 1; len <= length; len++) {
			for (int i = 0; i < length - len + 1; i++) {
				String t = s.substring(i, i + len);
				if (dict.contains(t)) {
					seg[i][len] = true;
					continue;
				}
				for (int k = 1; k < len; k++) {
					if (seg[i][k] && seg[i + k][len - k]) {
						seg[i][len] = true;
						break;
					}
				}
			}
		}
		if (!seg[0][length]) {
			return result;
		}

		int depth = 0;
		dfs(s, seg, 0, length, depth, result, new StringBuffer(), dict);

		return result;
	}

	private static void dfs(String s, boolean[][] seg, int start, int length,
			int depth, ArrayList<String> result, StringBuffer sb, Set<String> dict) {
		if (depth == length) {
			String t = sb.toString();
			result.add(t.substring(0, t.length() - 1));
			return;
		}

		for (int len = 1; len <= length; len++) {
			if (seg[start][len]) {
				String t = s.substring(start, start + len);
				if(!dict.contains(t)){
					continue;
				}
				int beforeAddLen = sb.length();
				sb.append(t).append(" ");
				dfs(s, seg, start + len, length, start + len, result, sb, dict);
				sb.delete(beforeAddLen, sb.length());
			}
		}
	}

}
