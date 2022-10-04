package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Sir Darey
 * 
 */
// DeadLock can be prevented using the Reentrant Lock

public class _17_DeadLock2{
    
    public static void main(String[] args) throws InterruptedException{
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        
        Thread thread1 = new Thread(()-> {   
            lock1.lock();
            try {
                System.out.println("Inside thread1 on lock1");
                lock2.lock();
                try {
                    System.out.println("Inside thread1 on lock2");
                } finally {
                    lock2.unlock();
                }
            } finally {
                lock1.unlock();
            }
        });
                
        Thread thread2 = new Thread(()-> { 
            lock2.lock();
            try {
                System.out.println("Inside thread2 on lock2");
                lock1.lock();
                try {
                    System.out.println("Inside thread2 on lock1");
                } finally {
                    lock2.unlock();
                }
            } finally {
                lock1.unlock();
            }
        });
        
        thread1.start(); 
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        System.out.println("Inside Main Thread");
    }
}
