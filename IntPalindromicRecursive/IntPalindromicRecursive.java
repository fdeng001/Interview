package IntPalindromicRecursive;

public class IntPalindromicRecursive {
	public static void main(String[] args){
		System.out.print(isIntPalindromicRecursive(12321));
	}
	public static boolean isIntPalindromicRecursive(int num) {
		return isIntPalindromicRecursive(num, num);
	}
	
	public static boolean isIntPalindromicRecursive(int x, int y) {
		if(x < 0 ) return false;
		if (x == 0 ) return true;
		if (isIntPalindromicRecursive(x/10, y) && (x%10 == y%10)) {
			return isIntPalindromicRecursive(x,y/10);
		}
		else return false;
	}

}
