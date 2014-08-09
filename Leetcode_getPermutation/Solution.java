package Leetcode_getPermutation;

public class Solution {
	public static void main(String[] args){
		System.out.println(getPermutation(3,4));
	}
    public static String getPermutation(int n, int k) {
    	int[] nums = new int[n+10];  
        int permCount = 1;  
          
        for(int i=0; i<n; i++){  
            nums[i] = i+1;              // numsװ��1,2,3,4,...,n  
            permCount *= (i+1);     // �������permCount = n!  
        }  
          
        k--;        // ��k��һ����Ϊ����index�Ǵ�[0,n-1]������[1,n]  
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<n; i++){  
            permCount = permCount / (n-i);  
            int idx = k / permCount;    // ��λӦ��ѡ����±�  
            sb.append(nums[idx]);  
            // �ؽ�nums������һλ  
            for(int j=idx; j<n-i; j++){  
                nums[j] = nums[j+1];  
            }  
            k %= permCount;  
        }  
        return sb.toString();  
    }
}
