package BitMap;
import java.util.BitSet;
public class Solution {

	public static void main(String[] args) {
		int [] array = new int [] {1,2,3,22,0,3};
		BitSet bitSet  = new BitSet(6);
		//������������bitmap
		for(int i=0;i<array.length;i++)
		{
			bitSet.set(array[i], true);
		}
		System.out.println(bitSet.size());
		System.out.println(bitSet.get(3));
	}

}
