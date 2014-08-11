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
	            if(prices[i] < prices[i-1]){ // 因为第i天的价钱就下降了，因此把从startIndex到i-1的利润积累到总利润中  
	                totalProfit += prices[i-1] - prices[startIndex];  
	                startIndex = i;     // 更新startIndex  
	            }  
	        }  
	        // 记得要处理最后一次的利润  
	        if(prices[i-1] > prices[startIndex]){  
	            totalProfit += prices[i-1] - prices[startIndex];  
	        }  
	          
	        return totalProfit;  
	    }  
}
