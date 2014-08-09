package Leetcode_evalRPN;
import java.util.*;
public class Solution {
    public int evalRPN(String[] tokens) {
    	 int res = 0;
         if(tokens.length == 0) return res;
          
         // build a stack for this kind of problem
         String operators = "+-*/";
         Stack<String> stack = new Stack<String>();
          
         for(String s : tokens) {
             // if s is not an valid operator, then s is a num, push in stack
             if(!operators.contains(s)) {
                 stack.push(s);
             } 
             // if s is an valid operator, pop two nums, calculate, push back
             else {
                 int a = Integer.valueOf(stack.pop());
                 int b = Integer.valueOf(stack.pop());
                  
                 // caculate
                 switch(s) {
                     case "+" : stack.push(String.valueOf(a + b)); break;
                     case "-" : stack.push(String.valueOf(b - a)); break;
                     case "*" : stack.push(String.valueOf(a * b)); break;
                     case "/" : stack.push(String.valueOf(b / a)); break;
                 }
             }
         }
          
         // after loop, pop the last num as res
         res = Integer.valueOf(stack.pop());
          
         return res;
    }
}
