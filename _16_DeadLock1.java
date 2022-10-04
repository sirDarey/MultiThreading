package multithreading;

/**
 *
 * @Sir Darey
 * 
 */
// DeadLock occurs as a result of the inability of a thread to receive a needed resource from another thread
//In this scenario, the program gets halted infinitely unless being terminated manually

public class _16_DeadLock1{
    
    public static void main(String[] args) throws InterruptedException{
        String lock1 = "lock1";
        String lock2 = "lock2";
        
        Thread thread1 = new Thread(()-> {   
            synchronized(lock1) {
                System.out.println("Inside thread1 on lock1");
                synchronized(lock2) { // DeadLock occurs here as LOCK2 is being held by Thread2
                    System.out.println("Inside thread1 on lock2");
                }
            }
        });
                
        Thread thread2 = new Thread(()-> { 
            synchronized(lock2) {
                System.out.println("Inside thread2 on lock2");
                synchronized(lock1) { // DeadLock occurs here as LOCK1 is being held by Thread1
                    System.out.println("Inside thread2 on lock1");
                }
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        System.out.println("Inside Main Thread");
    }
}
