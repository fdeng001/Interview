package PrimeNumber;

public class Solution {
	public static void main(String[] args){
		method3(100);
	}
	private static void method3(int num) {  
		long start = System.currentTimeMillis();  
		label1: for (int n = 1;; n++) {  
			label2: for (int m = 0; m <= 1; m++) {  
				int tmp = (3 * n + m)<< 1 - 1;    //������λ��"<<1"����"*2" ��Ч�ʻ����������
				if (tmp > num)  
					break label1;  
				for (int k = 2; k * k <= tmp; k++)  
					if (tmp % k == 0)  
						if (m == 0)  
							continue label2;  
						else  
							continue label1;  
				System.out.print(tmp + " ");  
			}  
		}  
		System.out.println("��ʱ��"+(System.currentTimeMillis()-start));  
	}  
}
