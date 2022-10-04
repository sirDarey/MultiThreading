package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

public class _8_VolatileKeyword {
    
    //The Volatile Keyword helps to prevent caching by a thread; though this scenario is very rare
    
    public static int flag = 0;
    
    public static void main(String[] args) throws InterruptedException{        
        new Thread(()-> { 
            while (flag == 0) 
                System.out.println("Running");
        }).start();
        
        new Thread(()-> {   
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(_8_VolatileKeyword.class.getName()).log(Level.SEVERE, null, ex);
            }
            flag = 1; //The volatile keyword helps this thread to recoginse the change in value of 
                //flag from 0 to 1; else, the program will keep on running on the previous value
                //Again, the chances of this occuring is rare, but it's a good practice to use the "Volatile Keyword"
                
            System.out.println("Flag Updated to 1");
        }).start();
    }
}
