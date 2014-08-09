package Leetcode_WordSearch;

public class Solution {
	public static void main(String[] args){
		char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		System.out.println(exist2(board,"AAB"));
	}
	public static boolean exist2(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
             
        boolean res = false;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    char[][] tmp = board;
                    tmp[i][j] = 0;
                    if(ifFound(tmp, i, j, word, 1)) 
                    return true;
                }
            }
        }
         
        return res;
    }
     
    public static boolean ifFound(char[][] b, int i, int j, String s, int idx) {
        boolean res = false;
        if(idx == s.length()) return true;
         
        char c = s.charAt(idx);
        // top
        if(i- 1 >= 0 && b[i - 1][j] == c) {
            if(idx == s.length() - 1) return true;
             
            char[][] tmp = b;
            tmp[i - 1][j] = 0;
            if(ifFound(tmp, i - 1, j, s, idx + 1))  return true;
        }
        // bottom
        if(i + 1 < b.length && b[i + 1][j] == c) {
            if(idx == s.length() - 1) return true;
             
            char[][] tmp = b;
            tmp[i + 1][j] = 0;
            if(ifFound(tmp, i + 1, j, s, idx + 1))    return true;
        }
        // left
        if(j - 1 >= 0 && b[i][j - 1] == c) {
            if(idx == s.length() - 1) return true;
             
            char[][] tmp = b;
            tmp[i][j - 1] = 0;
            if(ifFound(tmp, i, j - 1, s, idx + 1))    return true;
        }
        // right
        if(j + 1 < b[0].length && b[i][j + 1] == c) {
            if(idx == s.length() - 1) return true;
             
            char[][] tmp = b;
            tmp[i][j + 1] = 0;
            if(ifFound(tmp, i, j + 1, s, idx + 1))    return true;
        }
         
        return res;
    }
	public static boolean exist(char[][] board, String word) {
        if (board==null||board.length==0||word==null||word.length()==0){
            return false;
        }
        boolean [][] checker=new boolean[board.length][board[0].length];
       
        for (int row=0; row<board.length; row++){
            for (int col=0; col<board[0].length; col++){
                if (isFind(checker, board, word, 0, row, col)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isFind(boolean[][] checker, char[][] board, String word, int i, int row, int col){
        
        if (board[row][col]!=word.charAt(i)|| checker[row][col]){
            return false;
        }
        checker[row][col]=true;
        if (i==word.length()-1){
            return true;
        }
        if (row-1>=0 && isFind(checker, board, word, i+1, row-1, col)){
            return true;
        }
        if (row+1<board.length && isFind(checker, board, word, i+1,row+1, col )){
            return true;
        }
        if (col-1>=0 && isFind(checker, board, word, i+1, row, col-1)){
            return true;
        }
        if (col+1<board[0].length && isFind(checker, board, word, i+1, row, col+1)){
            return true;
        }
        checker[row][col]=false;
        
        return false;
    }
}
