package Mycalculator;

import java.util.*;

public class MyCalculator {
	public static void main(String[] args){
		Scanner keybord = new Scanner (System.in);
		System.out.println("plz input first num:");
		String num1String = keybord.nextLine();
		while(num1String == null ||isInteger(num1String)!=true){
			System.out.println("plz input first num again:");
			num1String = keybord.nextLine();
		}
		System.out.println("plz input operator:");
		String operator = keybord.nextLine();
		while(operator == null ||isOperator(operator)!=true){
			System.out.println("plz input Operator again:");
			operator = keybord.nextLine();
		}
		System.out.println("plz input second num:");
		String num2String = keybord.nextLine();
		while(num2String == null ||isInteger(num2String)!=true){
			System.out.println("plz input second num again:");
			num2String = keybord.nextLine();
		}
		System.out.println(num1String+operator+num2String+"=");
		String result = "";
		if(operator.equals("+")){
			result = ""+(Integer.parseInt(num1String)+Integer.parseInt(num2String));
		}
		else if(operator.equals("-")){
			result = ""+(Integer.parseInt(num1String)-Integer.parseInt(num2String));
		}
		else if(operator.equals("*")){
			result = ""+(Integer.parseInt(num1String)*Integer.parseInt(num2String));
		}
		else if(operator.equals("/")){
			result = ""+(Integer.parseInt(num1String)/Integer.parseInt(num2String));
		}
		else{
			result= "plz check exp.";
		}
		System.out.println(result);
		keybord.close();
	}
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    }
	    // only got here if we didn't return false
	    return true;
	}
	public static boolean isOperator(String s) {
	   if(s.equals("+") ||s.equals("-")||s.equals("*")||s.equals("/"))
		   return true;
	   return false;
	}
	private static int add(int a,int b){
		int sum = a^b;
		int carry = a&b;
		while(carry!=0){
			a=sum;
			b=carry<<1;
			sum = a^b;
			carry = a&b;
		}
		return sum;
	}
	private static int subtract(int a, int b){
		while(b!=0){
			int sameBits = a&b;
			a^=sameBits;
			b^=sameBits;
			a|=b;
			b<<=1;
		}
		return a;
	}
}
