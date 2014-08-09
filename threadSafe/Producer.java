package threadSafe;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue queue = null;
    
    public void run() {
        // Binds to socket, reads messages in
        // packages message calls doSomething()
        // doSomething(Object msg);
    }
 
    public void doSomething(Object msg) {
        queue.enqueue(msg);
    }
}
