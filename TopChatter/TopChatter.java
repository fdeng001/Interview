package TopChatter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class TopChatter {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("log"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String tmp = ""; tmp != null; tmp = br.readLine()) {
			if (tmp.length() != 0) {
				String chatter = tmp.split(":")[0].trim().toLowerCase();
				map.put(chatter,
						map.containsKey(chatter) ? map.get(chatter) + 1 : 1);
			}
		}
		int i = 0;
		while(i < 3) {
			int max = (Collections.max(map.values()));
			Entry maxEntry = null;
			for(Entry en : map.entrySet()) {
				if((Integer)en.getValue() == max) {
					maxEntry = en;
					System.out.println(en.getKey());
					i++;
					break;
				}
			}
			map.remove(maxEntry.getKey());
		}
	}
}
