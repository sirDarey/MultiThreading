package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 * Creating a Thread By Extending the Thread Class
 */
public class _1_MyCounter extends Thread{
    int threadNo;
    
    public _1_MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        try {
            countMe();
        } catch (InterruptedException ex) {
            Logger.getLogger(_1_MyCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void countMe () throws InterruptedException {
        for (int i=1; i<=5; i++) {
            Thread.sleep(500); // Sleeps each iteration by 0.5 seconds
            System.out.println("Thread Value: "+i+" from Thread " +threadNo);
        }            
    }
    
    public static void main(String[] args) throws InterruptedException {
        _1_MyCounter count1 = new _1_MyCounter(1);
        _1_MyCounter count2 = new _1_MyCounter(2);
        
        
        Long startTime = System.currentTimeMillis();
        count1.start();
        System.out.println("***************");
        count2.start();
        
        sleep(2505);    //Sleeps each iteration by about 2.5 seconds 
        //so that we can  be able to calculate the total time taken to execute both threads above
        
        Long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: "+ (endTime-startTime));
        System.out.println();
    }
    
}
