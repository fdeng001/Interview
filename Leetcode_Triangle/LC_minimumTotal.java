package Leetcode_Triangle;
import java.util.*;

public class LC_minimumTotal {
	public static void main(String[] args){
		List<List<Integer>> list = asList(
                asList(1)
              );
		System.out.println(minimumTotal(list));
	}
	public static <T> List<T> asList(T ... items) {
        List<T> list = new ArrayList<T>();
        for (T item : items) {
            list.add(item);
        }

        return list;
    }
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle == null) return 0;
		int n = triangle.size();
		int[] minresult = new int[n];
		for(int k = 0;k < triangle.get(n-1).size();k++){
			minresult[k]=triangle.get(n-1).get(k);
		}
		for(int layer = n-2; layer>=0; layer--){
			for(int i = 0;i<=layer;i++){
				minresult[i] = Math.min(minresult[i],minresult[i+1])+triangle.get(layer).get(i);
			}
		}
        return minresult[0];
    }
}
