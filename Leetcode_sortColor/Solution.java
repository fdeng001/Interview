package Leetcode_sortColor;

public class Solution {
	public static void main(String[] args){
		int[] A = {1,2,1,1,0};
		A=sort(A);
		for(int i=0;i<A.length;i++){
			System.out.print(A[i]+" ");
		}
		
	}
	public static int[] sort(int[] A){
		int i = -1,j=-1,k=-1;
		for(int p = 0; p<A.length;p++){
	        if(A[p] == 0)
	        {
	            A[++k]=2;
	            A[++j]=1;
	            A[++i]=0;
	        }
	        else if (A[p] == 1)
	        {
	            A[++k]=2;
	            A[++j]=1;

	        }
	        else if (A[p] == 2)
	        {
	            A[++k]=2;
	        }
		}
		return A;
	}

}
