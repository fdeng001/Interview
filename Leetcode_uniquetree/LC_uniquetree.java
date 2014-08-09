package Leetcode_uniquetree;

public class LC_uniquetree {
	public static void main(String[] args){
		System.out.println(numTrees(8));

	}
	static int numTrees(int n) {
		if(n<1)
			return 0;
		else if (n < 3)
			return n;
		else if (n == 3)
			return 5;
		else;

		int[] numNodes = new int[n+1];
		numNodes[0] = 1;

		for(int i = 1; i <= n; i++) 
			for (int j = 0; j < i; j++) 
				numNodes[i] += numNodes[j] * numNodes[i-j-1];
		return numNodes[n];

	}

}
