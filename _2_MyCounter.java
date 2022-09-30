package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 * Creating a Thread By Implementing the Runnable Interface
 */
public class _2_MyCounter implements Runnable{
    int threadNo;
    
    public _2_MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException ex) {
            Logger.getLogger(_2_MyCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void countMe () throws InterruptedException {
        for (int i=1; i<=5; i++) {
            Thread.sleep(500); 
            System.out.println("Thread Value: "+i+" from Thread " +threadNo);
        }            
    }
    
    public static void main(String[] args){
        Thread thread1 = new Thread(new _2_MyCounter(1));
        Thread thread2 = new Thread(new _2_MyCounter(2));
       
        thread1.start();
        thread2.start();
    }
    
}
