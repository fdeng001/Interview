package Leetcode_reverseInt;

public class LC_reverseInt {
	public static void main(String[] args){
		int test = 10000007;
		System.out.println(reverse(test));
		int test2 = -1234;
		System.out.println(reverse(test2));
		
	}
	static int reverse(int x){
		String strX = Integer.toString(x);
		int len = strX.length();
		StringBuffer dest = new StringBuffer(len);
		if(x>=0){
			for(int i = len -1; i >= 0 ; i--){
				dest.append(strX.charAt(i));
			}
		}
		else{
			dest.append('-');
			for(int i = len -1; i >= 1 ; i--){
				dest.append(strX.charAt(i));
			}
		}return Integer.parseInt(dest.toString());
	}

}
