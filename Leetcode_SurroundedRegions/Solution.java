package Leetcode_SurroundedRegions;
import java.util.*;

public class Solution {
    public void solve(char[][] board) {
    	 if (board==null||board.length==0){
             return;
         }
         Queue<Integer> rowQueue=new LinkedList<Integer>();
         Queue<Integer> colQueue=new LinkedList<Integer>();
         
         
         for (int row=0; row<board.length; row++){
             if (board[row][0]=='O'){
                 rowQueue.offer(row);
                 colQueue.offer(0);
             }
             
             if (board[row][board[0].length-1]=='O'){
                 rowQueue.offer(row);
                 colQueue.offer(board[0].length-1);
             }
         }
         
         for(int col=1; col<=board[0].length-2; col++){
             
             if (board[0][col]=='O'){
                 rowQueue.offer(0);
                 colQueue.offer(col);
             }
             
             if (board[board.length-1][col]=='O'){
                 rowQueue.offer(board.length-1);
                 colQueue.offer(col);
             }
         }
         
         while(!rowQueue.isEmpty()){
             int row=rowQueue.poll();
             int col=colQueue.poll();
             board[row][col]='y';
             
             if (row>=1&&board[row-1][col]=='O') {
                 rowQueue.offer(row-1);
                 colQueue.offer(col);
             }
             
             if (row<=board.length-2 &&board[row+1][col]=='O'){
                 rowQueue.offer(row+1);
                 colQueue.offer(col);
             }
             
             if (col>=1 && board[row][col-1]=='O'){
                 rowQueue.offer(row);
                 colQueue.offer(col-1);
             }
             
             if (col<=board[0].length-2 && board[row][col+1]=='O'){
                 rowQueue.offer(row);
                 colQueue.offer(col+1);
             }
             
             
         }
         
         for (int i=0; i<board.length; i++){
             for (int j=0; j<board[0].length; j++){
                 if (board[i][j]=='y'){
                     board[i][j]='O';
                 }
                 else if (board[i][j]=='O'){
                     board[i][j]='X';
                 }
             }
         }
    }


}