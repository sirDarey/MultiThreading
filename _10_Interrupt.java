package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @Sir Darey
 * 
 */

public class _10_Interrupt {
    public static int balance = 0;
    
    public void withdraw (int amount) {
        synchronized (this){
            if (balance <= 0) {
                System.out.println("Waiting for balance update");
                try {
                    wait();
                } catch (InterruptedException ex) {
                    System.out.println("Initial Amount: "+balance);
                    System.out.println("Withdrawal Amount: "+amount);
                    balance -= amount;
                    System.out.println("New Balance: "+balance);
                }
            }
        }
    }
    
    public void deposit(int amount) {
        System.out.println("Depositing the amount: "+amount);
        balance +=amount;
    }
    
    public static void main(String[] args) {
        _10_Interrupt obj = new _10_Interrupt();
        
        Thread withdraw = new Thread(()->{
            obj.withdraw(2000);
        });
        withdraw.start();
        
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(_10_Interrupt.class.getName()).log(Level.SEVERE, null, ex);
            }
            obj.deposit(5000);
            withdraw.interrupt();
        }).start(); 
    }
}
