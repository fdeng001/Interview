package threadSafe;

import java.util.Queue;

public class BlockingQueue implements Queue{
	private java.util.Queue queue = new java.util.LinkedList();
	public synchronized Object dequeue(){
		Object msg = null;
		while(queue.isEmpty()){
			try{
				wait();
			}
			catch(InterruptedException e){
				return msg;
			}
		}
		msg = queue.remove();
		return msg;
	}
	public synchronized void enqueue(Object o){
		queue.add(o);
		notifyAll();
	}

}
