package getMappingDp;

public class Solution {
	public static void main(String[] args){
		getMappingDp("111");
	}
	public static void getMappingDp(String str)
	{
		int arr[]=new int[str.length()];
		long Dp[]=new long[str.length()];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=Integer.parseInt(""+str.charAt(i));
		}
	
		Dp[0]=1;
		if(arr[0]*10+arr[1]<27)
			Dp[1]=2;
		else
			Dp[1]=1;
		
		for(int i=2;i<arr.length;i++)
		{
			long combinedLast2didgits=0;
			if(arr[i-1]*10+arr[i]<27)
				combinedLast2didgits=Dp[i-2];
			Dp[i]=Dp[i-1]+combinedLast2didgits;	
		}
		System.out.println("Total mapping are:"+Dp[Dp.length-1]);
	}
}
