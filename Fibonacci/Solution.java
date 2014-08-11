package Fibonacci;

public class Solution {
	public int Fibonacci(int n){
		if(n<=1)
			return 1;
		if(n==2)
			return 2;
		int i =3;
		int First = 1;
		int Second = 2;
		int res = 0;
		while(i<=n){
			res = First+Second;
			First = Second;
			Second = res;
			i++;
		}
		return res;
		
	}

}
