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

public class _6_SynchronizedBlockOnObject {
    
    //Whenever we make use of synchronized block, Java creates an intrinsic locikng mechanism based on the
    //object calling the method where the synchronized block is present.
    //Now, to prevent external access to this lock, we can create a private object which would be used in the synchronized block
    
    private final Object lock = "lock";
    
     public void generate () { 
        synchronized(lock){  //The Synchronized Block with a private lock object
            for (int i=1; i<=10; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(_6_SynchronizedBlockOnObject.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(_6_SynchronizedBlockOnObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException{
        _6_SynchronizedBlockOnObject obj1 = new _6_SynchronizedBlockOnObject();
        
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
