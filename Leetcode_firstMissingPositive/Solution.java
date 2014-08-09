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
				//if (A[i]-1 != i && A[A[i]-1] != A[i])������ô�������Ϳ����ˡ�
				//��ΪֻҪ���Ѿ���λ�˵�Ԫ�ؼ���A[i]-1==i�ˣ���ô�ж�������ظ�Ԫ��
				//����λ�ý�������ÿ��Ǻ�����λ�ó��ֵĿ����������������ȫ�棬�������������Ǻá�
				//update:����i!=A[i]��ʾiλ��û��λ��A[A[i]-1] != A[i]��ʾA[i]-1λ��û��λ������λ�ö��ж�Ҳ�ܺõġ�
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
