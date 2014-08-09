package interview;

import java.util.ArrayList;

public class interview implements Runnable {
	private ArrayList stringList = new ArrayList();
	public void pushString(String s){
		synchronized(this){
			stringList.add(s);
		}
	}
	public void savefiles(ArrayList str){
		int length = str.size();
		str[length-1]
	}
	public void write(){
		synchronized(this){
			savefiles(stringList);
		}
	}
	public void run(){
		this.write();
	}
}
