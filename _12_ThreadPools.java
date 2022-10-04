package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

public class _12_ThreadPools extends Thread{
    
    String threadName;
    
    public _12_ThreadPools(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println("Starting thread: "+threadName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(_12_ThreadPools.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Ending thread: "+threadName);
    }
    
    
        
    public static void main(String[] args) {
        
        ExecutorService es = Executors.newFixedThreadPool(2);
        
        _12_ThreadPools thread1 = new _12_ThreadPools("Thread1");
        _12_ThreadPools thread2 = new _12_ThreadPools("Thread2");
        _12_ThreadPools thread3 = new _12_ThreadPools("Thread3");
        _12_ThreadPools thread4 = new _12_ThreadPools("Thread4");
        
//       thread1.start();
//       thread2.start();
//       thread3.start();
//       thread4.start();
        es.execute(thread1);
        es.execute(thread2);
        es.execute(thread3);
        es.execute(thread4);
        
        es.shutdown();
    }
}
