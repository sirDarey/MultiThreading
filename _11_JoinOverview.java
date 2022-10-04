package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

public class _11_JoinOverview {
    static int counter = 0;
    
    public static void main(String[] args) {
        Thread thread1 = new Thread (()->{
            try {
                Thread.sleep(5000); // Thread1 executes after 5seconds. It was meant to execute first, 
                //but because it has slept more than 2seconds before thread2 executes, after which main thread executes;
                //thus, it executes last;
            } catch (InterruptedException ex) {
                Logger.getLogger(_11_JoinOverview.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i=0; i<1000; i++)
                counter ++;
            System.out.println("From thread 1, the value of counter is :" +counter);
        });
        thread1.start();
        
        
        Thread thread2 = new Thread (()->{
            try {
                thread1.join(2000);  // Thread2 executes after waiting 2seconds for thread1
            } catch (InterruptedException ex) {
                Logger.getLogger(_11_JoinOverview.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i=0; i<1000; i++)
                counter ++;
            System.out.println("Thread 2 is done");
        });
        thread2.start();
        
        try {
            thread2.join();  //Main thread executes immediately thread 2 completes its task
        } catch (InterruptedException ex) {
            Logger.getLogger(_11_JoinOverview.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("From Main Thread, The value of counter is :" +counter);
    }
}
