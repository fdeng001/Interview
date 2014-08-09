package CalculateMN;

public class Calculate {
	//Caclulate (m^n)%(10^k). Keep the k integer numbers in an array.
	//Note: the integer numbers are in reversed in the array
	//Assume: m>0, n>0, k>0
	//Need to check validity outside of this function.
	//call calculate(5, 1234566789893943, 1000) to get result.
	//Time complexity: O((log n) * k * k)
	//Space complexity: O((log n) * k)
	public static int[] calculate(long m, long n, long k) {
		if (k == 0) {
			return new int[0];
		}
		if (n == 0) {
			int[] res = {1};
			return res;
		}
		if (n == 1) {
			return toIntArray(m);
		}
		if (n % 2 == 1) {
			int[] temp = toIntArray(m);
			int[] result = calculate(m, n - 1, k);
			return multiply(result, temp, k);
		} else {
			int[] result = calculate(m, n/2, k);
			return multiply(result, result, k);
		}
	}
	public static int[] multiply(int[] a, int[] b, long k) {
		int len = (int) Math.min(a.length + b.length, k);
		int[] res = new int[len];
		for (int i = 0; i < Math.min(a.length, k); i++) {
			int carry = 0;
			for (int j = 0; j < Math.min(b.length, k); j++) {
				if (i + j + 1 > k) {
					break;
				}
				int m = a[i] * b[j] + carry;
				res[i + j] += m;
				carry = res[i + j] / 10;
				res[i + j] %= 10;
			}
			if (carry > 0 && i + Math.min(b.length, k) < len) {
				res[(int) (i + Math.min(b.length, k))] += carry;
			}
		}
		return res;
	}
	public static int[] toIntArray(long m) {
		int digits = 0;
		long n = m;
		while (n > 0) {
			n /= 10;
			digits++;
		}
		int[] res = new int[digits];
		for (int i = 0; i < digits; i++) {
			res[i] = (int) (m % 10);
			m /= 10;
		}
		return res;
	}
	public static void main(String[] args) {
		print(calculate(5, 15, 20));
	}
	public static void print(int[] a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
