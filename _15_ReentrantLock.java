package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Sir Darey
 * 
 */
// The Reentrant Lock can be used instead of Synchronization to prevent multiple threads from operating concurrently
//on a function
public class _15_ReentrantLock{
    
    static Lock lock = new ReentrantLock();
    
    static void generate () {  
        lock.lock();
        try {
            for (int i=1; i<=10; i++) {
                if (i<=5)
                    System.out.print("[");
                else
                    System.out.print("]");
            }
            System.out.println();
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args){
        
        new Thread(()-> {   
            for (int i=0; i<5; i++) 
                generate();
        }).start();
        
        new Thread(()-> { 
            for (int i=0; i<5; i++) 
                generate();
        }).start();
    }
}
