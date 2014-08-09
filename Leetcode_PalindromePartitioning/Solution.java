package Leetcode_PalindromePartitioning;

import java.util.ArrayList;

public class Solution {
	static boolean[][] table;
	public static void main(String[] args){
		System.out.println(partition("abas"));
	}
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        table = buildTable(s);
        partition(s,0 ,new ArrayList<String>(),result);
        return result;
    }
         
    public static void partition(String s,int from, ArrayList<String> re,ArrayList<ArrayList<String>> result) {
        if(from == s.length()){
            result.add(new ArrayList<String>(re));
            return;
        }
             
        for(int i=1; i<=s.length()-from; i++){
            String part = s.substring(from,from+i);
           // if(isPalindrome(part)){
            if(table[from][from+i-1]){
                re.add(part);
                partition(s,from+i,re,result);
                re.remove(re.size()-1);
            }
        }
    }
         
    public static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
         
    public static boolean[][] buildTable(String s){
        int length = s.length();
        boolean[][] result = new boolean[length][length];
        for(int i=0;i<length;i++){
            result[i][i] = true;
            if(i>0){
                result[i-1][i] = s.charAt(i)==s.charAt(i-1);
            }
        }
             
        for(int i=0;i<length;i++){
            int k=i-1;
            int m=i+1;
            while(k>=0&&m<length){
                result[k][m] = result[k+1][m-1]&&s.charAt(k)==s.charAt(m);
                k--;
                m++;
            }
                 
            if(i>0){
                k = i-2;
                m = i+1;
                while(k>=0&&m<length){
                    result[k][m] = result[k+1][m-1]&&s.charAt(k)==s.charAt(m);
                    k--;
                    m++;
                }
            }
        }
        return result;
    }
}
