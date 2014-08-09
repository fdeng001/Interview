package Leetcode_countAndSay;

public class LC_countAndSay {
	public static void main(String[] args){
		System.out.println(countAndSay2(11));
	}
	public static String countAndSay(int i) {
		int n = 1;
		for(int k =1;k<i;k++){
			int rest = n/10;
			int oldPos = n%10;
			int time = 1;
			String numlist = "";
			while(rest>=0){
				int curPos = rest%10;
				if(oldPos == curPos){
					time++;
				}
				else{
					numlist=Integer.toString(time)+Integer.toString(oldPos)+numlist;
					time = 1;
					oldPos = curPos;
					if(rest == 0)
						break;
				}
				rest = rest/10;

			}
			n=Integer.parseInt(numlist);
		}
		return Integer.toString(n);
	}
	public static String countAndSay2(int n) {
        if (n<1){
            return null;
        }
        int i=2;
        String current="1";
        while (i<=n){
            current=say(current);
            i++;
        }
        
        return current;
    }
    
    // count each char in given input string
    private static String say(String input){
        char last=input.charAt(0);
        
        String result="";
        
        int i=1;// index
        
        int count=1;// count for each char
        while (i<input.length()){
            if (input.charAt(i)==last){
                count++;
            }
            else{
                result+=count;
                result+=last;
                
                last=input.charAt(i);
                count=1;
                
            }
            
            i++;
            
        }
        
        result+=count;
        result+=last;
        
        return result;
        
    }
}
