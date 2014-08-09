package decode;

import java.math.BigInteger;

public class Solution {

	public static void main(String[] args){
		String str = "abc";  // or anything else

	    StringBuilder sb = new StringBuilder();
	    for (char c : str.toCharArray())
	    sb.append((int)c);

	    BigInteger mInt = new BigInteger(sb.toString());
	    System.out.println(mInt);
	}
}
