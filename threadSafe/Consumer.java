package threadSafe;

import java.util.Queue;

public class Consumer implements Runnable{
	private Queue queue = null;
	public void process(Object msg){
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	public void dostuff(){
		Object msg = queue.dequeue();
		process(msg);
	}
	public void run(){
		while(true){
			dostuff();
		}
	}
}
