package LCS;

public class Solution {
	/** 字符串X的字符数组 */
	private char[] charArrayX = null;
	/** 字符串Y的字符数组 */
	private char[] charArrayY = null;

	public Solution(String sa, String sb) {
		charArrayX = new char[sa.length() + 1];
		System.arraycopy(sa.toCharArray(), 0, charArrayX, 1, sa.length());
		charArrayY = new char[sb.length() + 1];
		System.arraycopy(sb.toCharArray(), 0, charArrayY, 1, sb.length());
	}

	/**
	 * 得到最长公共子序列的长度
	 */
	public void getLCS() {

		int[][] length = new int[charArrayX.length + 1][charArrayY.length + 1];

		for (int m = 1; m < charArrayX.length; m++) {
			for (int n = 1; n < charArrayY.length; n++) {
				if (charArrayX[m] == charArrayY[n]) {
					length[m][n] = length[m - 1][n - 1] + 1;
				} else
					length[m][n] = max(length[m - 1][n], length[m][n - 1]);
//					length[m][n] = max(length[m][n], length[m-1][n-1]);
			}
		}

		for (int m = 0; m < charArrayX.length; m++) {
			for (int n = 0; n < charArrayY.length; n++) {
				System.out.print(length[m][n] + " ");
			}
			System.out.println();
		}

		// 打印最长公共子序列
		String lcstr = "";
		int x = charArrayX.length - 1;
		int y = charArrayY.length - 1;
		while (x >= 1 && y >= 1) {
			if (charArrayX[x] == charArrayY[y]) {
				lcstr = charArrayX[x] + lcstr;
				x--;
				y--;
			} else {
				if (length[x - 1][y] <= length[x][y - 1])	// 往值较大的路径走
					y--;
				else
					x--;
			}
		}
		System.out.println("最长公共子序列为：" + lcstr + " [length=" + lcstr.length()
				+ "]");
	}

	/**
	 * 取最大值
	 */
	private int max(int m, int n) {
		return m > n ? m : n;
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		Solution lcs = new Solution("GTTCCTAATA", "CGATAATTGAGA");
		lcs.getLCS();
	}
}
