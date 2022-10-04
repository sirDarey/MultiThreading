package multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

public class _13_CountDownLatch {
    
    private static class SomeThread extends Thread {
        private final CountDownLatch latch;
        
        public SomeThread(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("Running Thread: "+Thread.currentThread().getName());
            latch.countDown();
        }   
    }
    
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        
        SomeThread thread0 = new SomeThread(latch);
        SomeThread thread1 = new SomeThread(latch);
        SomeThread thread2 = new SomeThread(latch);
        SomeThread thread3 = new SomeThread(latch);
        
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        
        try {
            latch.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(_13_CountDownLatch.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("I am the Main Thread: "+Thread.currentThread().getName());
    }    
}
