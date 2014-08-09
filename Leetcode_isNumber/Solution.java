package Leetcode_isNumber;

public class Solution {
	public static void main(String[] args){
		String s = "  12  ";
		while(s.charAt(0)==' '){
    		s = s.substring(1);
    	}
		
		while(s.charAt(s.length()-1)==' '){
    		s=s.substring(0,s.length()-1);
    	}
		System.out.println(isNumber3(s));
	}
  
    public static boolean isNumber2(String s) {
        s = s.trim();
       s = s.replaceAll("e", "/");
       s = s.replaceAll("[a-zA-Z]", "x");
       s = s.replaceAll("/", "e");
       try {
           Double.parseDouble(s);
       } catch (Exception e) {
         return false;
       }
       return true;
   }
    public static boolean isNumber3(String s) {  
        if(s.trim().isEmpty()){  
            return false;  
        }  
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";  
        if(s.trim().matches(regex)){  
            return true;  
        }else{  
            return false;  
        }  
    }  
}
