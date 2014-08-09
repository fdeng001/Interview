package Leetcode_findSubstring;
import java.util.*;
public class Solution {
	public static void main(String[] args){
		String S="sheateateseatea";
		String[] L = {"sea","tea","ate"};
		System.out.println(findSubstring(S,L));
	}
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if(S==null || S.length()==0 || L==null || L.length==0)
	        return res;
	    HashMap<String,Integer> map = new HashMap<String,Integer>();
	    for(int i = 0;i<L.length;i++){
	    	if(map.containsKey(L[i]))
	    		map.put(L[i],map.get(L[i])+1);
	    	else 
	    		map.put(L[i], 1);
	    }
	    
	    for(int i = 0;i<L[0].length();i++){
	    	HashMap<String,Integer> curmap = new HashMap<String,Integer>();
	    	int count = 0;
	    	int left = i;
	    	for(int j = i;j<=S.length()-L[0].length();j+=L[0].length()){
	    		
	    		String str =S.substring(j, j+L[0].length());
	    		
	    		if(map.containsKey(str)){
	    			
	    			if(curmap.containsKey(str)){
	    				curmap.put(str, curmap.get(str)+1);
	    			}
	    			else
	    				curmap.put(str, 1);
	    			if(curmap.get(str)<=map.get(str))
	    				count++;
	    			else{
	    				
	    				while(curmap.get(str)>map.get(str)){
	    					String temp = S.substring(left, left+L[0].length());
	    					curmap.put(temp, curmap.get(temp)-1);
	    					 if(curmap.get(temp)<map.get(temp))  
	                             count--; 
	    					left+=L[0].length();
	    				}
	    			}
	    			if(count==L.length){
	    				
	    				res.add(left);
	    				String temp = S.substring(left, left+L[0].length());
    					curmap.put(temp, curmap.get(temp)-1);
    					count--;
    					left+=L[0].length();
	    			}
	    		}
	    		else{
	    			curmap.clear();
	    			count=0;
	    			left=j+L[0].length();
	    		}
	    	}
	    }
	    return res;
	}
}
