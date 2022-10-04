package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 * Synchronization helps to restrict multiple threads from operating simultaneously on an object or a variable 
 * 
 * Types of Synchronization
 * 
 * 1. SynchronizedMethod
 * 2. Synchronized Block
 * 3. Static Synchronization
 */

//The Synchronized block is used when we want to synchronize part of our function or method, thus making the operation faster
public class _5_SynchronizedBlock {
    
     public void generate () { 
        synchronized(this){  //The Synchronized Block
            for (int i=1; i<=10; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(_5_SynchronizedBlock.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (i<=5)
                    System.out.print("[");
                else
                    System.out.print("]");
            }
            System.out.println();
        }
        
        for (int i=0; i<10; i++) { //This is excluded from the synchronizatio, which makes operation faster
            //Instead of havinng to synchronize the whole "generate() method"
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                Logger.getLogger(_5_SynchronizedBlock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        _5_SynchronizedBlock obj1 = new _5_SynchronizedBlock();
        
        new Thread(()-> {   // 1st thread calling the synchronized generate method
            long startTime = System.currentTimeMillis();
            for (int i=0; i<5; i++) 
                obj1.generate();
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for thread1: "+(endTime - startTime));
        }).start();
        
        new Thread(()-> {   // 2nd thread calling the synchronized generate method
            long startTime = System.currentTimeMillis();
            for (int i=0; i<5; i++) 
                obj1.generate();
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for thread2: "+(endTime - startTime));
        }).start();
    }
}
