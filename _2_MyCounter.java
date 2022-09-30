package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 * Creating a Thread By Implementing the Runnable Interface
 */
public class _2_MyCounter extends Thread{
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
    
    public static void main(String[] args) throws InterruptedException {
        _2_MyCounter count1 = new _2_MyCounter(1);
        _2_MyCounter count2 = new _2_MyCounter(2);
        
        
        Long startTime = System.currentTimeMillis();
        count1.start();
        System.out.println("***************");
        count2.start();
        
        sleep(2505);
        
        Long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: "+ (endTime-startTime));
        System.out.println();
    }
    
}
