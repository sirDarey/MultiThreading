package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 * Creating a Thread By Implementing the Runnable Interface in an anonymous Thread Object
 */
public class _3_MyCounter{
    int threadNo;
    
    public _3_MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    public void countMe () throws InterruptedException {
        for (int i=1; i<=5; i++) {
            Thread.sleep(500); 
            System.out.println("Thread Value: "+i+" from Thread " +threadNo);
        }            
    }
    
    public static void main(String[] args){
        new Thread(() -> {   //This is a lambda expression equivalent to "new Thread(new Runnable() {"
            try {
                new _3_MyCounter(3).countMe();
            } catch (InterruptedException ex) {
                Logger.getLogger(_3_MyCounter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
}
