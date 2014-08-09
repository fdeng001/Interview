package interview;

public class mainMessage {
	public static void main(String[] args){
		String msg = "Hello World!";
		interview m = new interview();
		Thread messageThread = new Thread(m);
		m.pushString(msg);
		messageThread.start();
		messageThread.join();

	}
}
