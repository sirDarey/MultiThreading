package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

public class _9_WaitAndNotify {
    public static int balance = 0;
    
    public void withdraw (int amount) {
        synchronized (this){
            if (balance <= 0) {
                System.out.println("Waiting for balance update");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(_9_WaitAndNotify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println("Initial Amount: "+balance);
        System.out.println("Withdrawal Amount: "+amount);
        balance -= amount;
        System.out.println("New Balance: "+balance);
    }
    
    public void deposit(int amount) {
        System.out.println("Depositing the amount: "+amount);
        balance +=amount;
        synchronized (this){
            notify();
        }
    }
    
    public static void main(String[] args) {
        _9_WaitAndNotify obj = new _9_WaitAndNotify();
        
        new Thread(()->{
            obj.withdraw(2000);
        }).start();
        
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(_9_WaitAndNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            obj.deposit(5000);
        }).start(); 
    }
}
