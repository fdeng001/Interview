package Leetcode_insertPos;

public class LC_insertPos {
	public static void main(String[] args){
		int[] A = {1,3,5};
		int target = 4;
		int result = searchInsert(A,target);
		System.out.println(result);
	}
	public static int searchInsert(int[] A, int target) {
		int l=0, r=A.length-1;  
		while(l<=r)  
		{  
			int mid = (l+r)/2;  
			if(A[mid] == target) 
				return mid;  
			if(mid>l && A[mid]>target && A[mid-1]<target ) 
				return mid;  
			if(A[mid] > target)  
				r= mid-1;  
			else
				l=mid+1;    
		}  
		return l;  
	}  


}
