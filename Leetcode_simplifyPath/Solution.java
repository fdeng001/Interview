package Leetcode_simplifyPath;
import java.util.*;

public class Solution {
	public static void main(String[] args){
		System.out.println(simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/"));
	}
    public static String simplifyPath(String path) {
        if(path.length()<1 || path == null){
        	return path;
        }
        String[] splits = path.split("/");
        LinkedList<String> list = new LinkedList<String>();
        for(String s:splits){
        	if(s.length()==0||s.equals("."))
        		continue;
        	else if(s.equals("..")){
        		if(!list.isEmpty())
        			list.removeLast();
        	}
        	else
        		list.add(s);
        }
        if(list.isEmpty())
        	list.add("");
        String result = "";
        while(!list.isEmpty()){
        	result+="/"+list.remove();
        }
        return result;
    }
}
