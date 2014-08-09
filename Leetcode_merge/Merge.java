package Leetcode_merge;

public class Merge {
	public static void merge(int A[], int m, int B[], int n) {
		for (int idx = m + n - 1; idx >= 0; idx--) {
	        if (m <= 0) {
	            A[idx] = B[--n]; 
	        } else if (n <= 0) {
	            break;
	        } else if (A[m-1] < B[n-1]) {
	            A[idx] = B[--n];
	        } else {
	            A[idx] = A[--m];
	        }
	    }
	}
	public static void main(String[] args){
		int[] B = {1};
		int[] A = {};
		merge(A,0,B,1);
		/*	for(int d = 0;d<B.length;d++){
			System.out.println(B[d]);
		}*/
		for(int i = 0;i<A.length;i++){
			System.out.println(A[i]);
		}
	}
}
