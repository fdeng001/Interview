package LL_validParentheses;

import java.util.Stack;

public class Solution {
	public static void main(String[] args){
		System.out.println(isValid("([)]"));
	}
    public static boolean isValid(String s) {
        Stack st = new Stack();
        int Length = s.length();
        for(int i = 0; i<Length; i++){
        	char c = s.charAt(i);
        	if((c == '(') ||(c == '[')||(c == '{')){
        		st.push(c);
        	}
        	else{
        		if(st.size()==0)
        			return false;
        		char top = (char) st.pop();
        		if(c == ')'){
        			if(top != '(') return false;
        		}
        		else if(c == ']'){
        			if(top != '[') return false;
        		}
        		else if(c == '}'){
        			if(top != '{') return false;
        		}
        	}
        	
        }
        return st.size()== 0;
    }
}
