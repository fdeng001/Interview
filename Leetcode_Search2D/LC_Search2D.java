package Leetcode_Search2D;

public class LC_Search2D {
	public static void main(String[] args){
		int[][] matrix = {{1,4},{5,6}};
		System.out.println(searchMatrix(matrix,6));
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[] colFirst =new int[m];
		for(int col = 0; col < m; col++)
    	{
    		colFirst[col] = matrix[col][0];
    	}
       
        int getLevel = rank(target,colFirst);
        int getNum = 0;
        if(matrix[getLevel][0] ==  target) return true;
        else{
        	getNum = rank(target,matrix[getLevel]);
        }
        if(matrix[getLevel][getNum] == target)
        	return true;
        else
        	return false;
    }
	 public static int rank(int key, int[] a) {
	        int low = 0;
	        int high = a.length - 1;
	        int mid = 0;
	        while (low <= high) {
	            mid = (int) Math.ceil(low + (high - low) / 2);
	            if((mid == a.length-1)||(key >a[mid] && key<a[mid+1]))
	            	return mid;
	            else if(key < a[mid]) 
	            	high = mid - 1;
	            else if(key > a[mid]) 
	            	low = mid + 1;
	            else 
	            	return mid;
	        }
	        return mid;
	    }
}
