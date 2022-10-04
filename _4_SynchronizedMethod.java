package multithreading;

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
public class _4_SynchronizedMethod {
    
    // Marking this method as synchronized helps to give us a consistent output even if multiple threads 
    // are operating on it as long as the threads are using the same object of this class
     public void generate () {       
        for (int i=1; i<=10; i++) {
            if (i<=5)
                System.out.print("[");
            else
                System.out.print("]");
        }
        System.out.println();
    }
    
    public static void main(String[] args){
        _4_SynchronizedMethod obj1 = new _4_SynchronizedMethod();
        
        new Thread(()-> {   // 1st thread calling the synchronized generate method
            for (int i=0; i<5; i++) 
                obj1.generate();
        }).start();
        
        new Thread(()-> {   // 2nd thread calling the synchronized generate method
            for (int i=0; i<5; i++) 
                obj1.generate();
        }).start();
        
        /* Uncommenting this part means you are creating a new object of this class
        * Synchronization will have NO EFFECT here as it only creates a new restriction (or lock) 
           * for each object created
        
        *Try and see
        _4_SynchronizedMethod obj2 = new _4_SynchronizedMethod();
        
        new Thread(()-> {
            for (int i=0; i<5; i++) 
                obj2.generate();
        }).start();
        * 
        */
    }
}
