package Leetcode_firstMissingPositive;

public class Solution {
	public int firstMissingPositive(int[] A) {

		if(A == null){
			return 0;
		}
		int n = A.length+1;
		for (int i=0; i<n; i++)
		{
			if (A[i] > 0 && A[i] < n)
			{
				//if (A[i]-1 != i && A[A[i]-1] != A[i])不用那么多条件就可以了。
				//因为只要是已经到位了的元素即：A[i]-1==i了，那么判断如果有重复元素
				//两个位置交换就最好考虑好两个位置出现的可能情况。考虑问题全面，两个条件都考虑好。
				//update:增加i!=A[i]表示i位置没到位，A[A[i]-1] != A[i]表示A[i]-1位置没到位，两个位置都判断也很好的。
				if (A[A[i]-1] != A[i])
				{
					swap(A, A[A[i]-1], A[i]);
					i--;
				}
			}
		}

		for (int j=0; j<n; ++j)
			if (A[j]-1 != j)
				return j+1;

		return n+1; 

	}
	public void swap(int[] A, int x, int y){
		assert(A!=null && x>=0 && x<A.length && y>=0 && y<A.length);
		int temp = A[x];
		A[x]=A[y];
		A[y]=temp;
	}
}
