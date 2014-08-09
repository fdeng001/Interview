package Leetcode_findMedianSortedArrays;

public class Solution {
	public double findMedianSortedArrays(int A[], int B[]) {
		int aLen = A.length;
		int bLen = B.length;
		int k = aLen+bLen;
		if(k%2==0)
			return (getKthElement(A,0,aLen-1,B,0,bLen-1,k/2+1)+getKthElement(A,0,aLen-1,B,0,bLen-1,k/2))/2;
		else
			return getKthElement(A,0,aLen-1,B,0,bLen-1,k/2+1);
	}
	public int getKthElement(int A[], int aBeg, int aEnd, int B[], int bBeg, int bEnd, int k){
		if(aBeg>aEnd)
			return B[bBeg+k-1];
		if(bBeg>bEnd)
			return A[aBeg+k-1];
		int aMid = (aBeg+aEnd)/2;
		int bMid = (bBeg+bEnd)/2;
		int Len = aMid-aBeg+bMid-bBeg+2;
		if(Len>k){
			if(A[aMid]<B[bMid]){
				return getKthElement(A,aBeg,aEnd,B,bBeg,bMid-1,k);
			}
			else
				return getKthElement(A, aBeg, aMid - 1, B, bBeg, bEnd, k);
		}
		else{
			if(A[aMid]<B[bMid])
				return getKthElement(A, aMid + 1, aEnd, B, bBeg, bEnd, k - (aMid - aBeg + 1));
			else
				return getKthElement(A, aBeg, aEnd, B, bMid + 1, bEnd, k - (bMid - bBeg + 1));
		}
	}
}
