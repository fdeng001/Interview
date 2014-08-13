package maxProfit3;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {  
//      int[] prices = {3,3,5,0,0,3,1,4};  
        int[] prices = {2,1,2,0,1};  
        System.out.println(maxProfit(prices));  
    }  
      
    // ����˼���Ƿֳ�����ʱ��Σ�Ȼ�����ĳһ�죬����֮ǰ�����ֵ��֮������ֵ  
    public static int maxProfit(int[] prices) {  
        if(prices.length == 0){  
            return 0;  
        }  
          
        int max = 0;  
        // dp���鱣����ߺ��ұߵ��������ֵ  
        int[] left = new int[prices.length];        // ����[0,i]��������ֵ  
        int[] right = new int[prices.length];   // ����[i,len-1]��������ֵ  
          
        process(prices, left, right);  
          
        // O(n)�ҵ����ֵ  
        for(int i=0; i<prices.length; i++){  
            max = Math.max(max, left[i]+right[i]);  
        }  
          
        return max;  
    }  
      
    public static void process(int[] prices, int[] left, int[] right){  
        left[0] = 0;  
        int min = prices[0];        // ��������  
          
        // ��ߵ��ƹ�ʽ  
        for(int i=1; i<left.length; i++){  
            left[i] = Math.max(left[i-1], prices[i]-min);   // i���������Ϊ��i-1�����󣩺ͣ���ǰ�����ۺ�֮ǰ�����֮��Ľϴ��Ǹ�  
            min = Math.min(min, prices[i]);     // ������С�����  
        }  
          
        right[right.length-1] = 0;  
        int max = prices[right.length-1];       // ���������  
        // �ұߵ��ƹ�ʽ  
        for(int i=right.length-2; i>=0; i--){  
            right[i] = Math.max(right[i+1], max-prices[i]); // i���������Ϊ��i+1�����󣩺ͣ���������ۺ͵�ǰ�����֮��Ľϴ��Ǹ�  
            max = Math.max(max, prices[i]);     // �������������  
        }  
          
      System.out.println(Arrays.toString(left));  
      System.out.println(Arrays.toString(right));  
    }  
}
