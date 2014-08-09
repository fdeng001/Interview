package FindsubString;

import java.util.ArrayList;

public class FindSubString {
	public static void main(String[] args){
		String s = "abcabc";
		System.out.println(s.substring(1,s.length()));
		System.out.println(findSub("abcbc","abc"));
	}
	public static int findSub(String S,String T){
		if(S.length() == 0){
			return 0;
		}
		ArrayList<String> results = new ArrayList<String>();
		int sum = 0;
		sum = dfs(results,S,T,sum);
		return sum;
	}
	public static int dfs(ArrayList<String> results,String tmpS,String tmpT,int Sum){
		if(tmpT.equals("")){
			Sum = Sum+1;
			return Sum;
		}
		for(int i = 0;i<tmpS.length();i++){
			for(int j = 0;j<tmpT.length();j++){
				if(tmpS.charAt(i) == tmpT.charAt(j)){
					Sum = dfs(results,tmpS.substring(i+1, tmpS.length()),tmpT.substring(j+1, tmpT.length()),Sum);		
				}
				else
					break;
			}
			 
		}
		return Sum;
	}
}
