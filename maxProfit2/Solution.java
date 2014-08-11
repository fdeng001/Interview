package maxProfit2;

public class Solution {
	 public static int maxProfit(int[] prices) {  
	        if(prices.length == 0){  
	            return 0;  
	        }  
	        int totalProfit = 0;  
	        int startIndex = 0;  
	        int i;  
	          
	        for(i=1; i<prices.length; i++){  
	            if(prices[i] < prices[i-1]){ // ��Ϊ��i��ļ�Ǯ���½��ˣ���˰Ѵ�startIndex��i-1��������۵���������  
	                totalProfit += prices[i-1] - prices[startIndex];  
	                startIndex = i;     // ����startIndex  
	            }  
	        }  
	        // �ǵ�Ҫ�������һ�ε�����  
	        if(prices[i-1] > prices[startIndex]){  
	            totalProfit += prices[i-1] - prices[startIndex];  
	        }  
	          
	        return totalProfit;  
	    }  
}
