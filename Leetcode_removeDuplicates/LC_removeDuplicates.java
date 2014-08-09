package Leetcode_removeDuplicates;

public class LC_removeDuplicates {
	public static void main(String[] args){
		int[] A = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(A));
	}
	public static int removeDuplicates(int[] A) {
		int n = A.length;
		if (n <= 2) return n;       // no need to deal with n<=2 case.
		int len = 2, itor = 2;
		while (itor < n) {
			if (A[itor] != A[len-2]) 
				A[len++] = A[itor];
			itor++;
		}
		return len;
	}
}
