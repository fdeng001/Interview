package Leetcode_Anagrams;

import java.util.*;

public class Solution {
	public static void main(String[] args){
		String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		System.out.print(anagrams(strs));
	}
	public static ArrayList<String> anagrams(String[] strs) {
	    ArrayList<String> res = new ArrayList<String>();
	    if(strs == null || strs.length == 0)
	        return res;
	    HashMap<String, ArrayList<String>> hashList = new HashMap<String,ArrayList<String>>();
	    for(int i = 0;i<strs.length;i++){
	    	char[] tmp = strs[i].toCharArray();
	    	Arrays.sort(tmp);
	    	String cur = new String(tmp);
	    	if(hashList.containsKey(cur)){
	    		hashList.get(cur).add(strs[i]);
	    	}
	    	else{
	    		ArrayList<String> list = new ArrayList<String>();
	    		list.add(strs[i]);
	    		hashList.put(cur, list);
	    	}
	    }
	    Iterator iter = hashList.values().iterator();
	    while(iter.hasNext()){
	    	ArrayList<String> item = (ArrayList<String>) iter.next();
	    	if(item.size()>1){
	    		res.addAll(item);
	    	}
	    }
	    return res;
	   
	}
}
