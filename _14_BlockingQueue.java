package multithreading;

import static java.lang.Thread.sleep;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

class Producer extends Thread {
    private ArrayBlockingQueue <Integer> queue;

    public Producer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(5000);
                queue.put(_14_BlockingQueue.counter++);
                System.out.println("Added to the queue: "+_14_BlockingQueue.counter);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Consumer extends Thread {
    private ArrayBlockingQueue <Integer> queue;

    public Consumer(ArrayBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(1000);
                queue.take();
                System.out.println("Removed from the queue: "+_14_BlockingQueue.counter);
                _14_BlockingQueue.counter--;
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

public class _14_BlockingQueue {
    static int counter = 0;
    
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        new Producer(queue).start();
        new Consumer(queue).start();
    }
}
