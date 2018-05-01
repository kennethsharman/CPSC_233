
public class BankAccountDemo {
    
    public static void main(String[] args) {
        
        // BALANCE = 100
        // OVERDRAFT = 100
        // REQUESTED WITHDRAW = 200
        // DOES IT GO THROUGH OR NOT CAUSE OF THE OVERDRAFT FEE?
        
        Customer c = new Customer("John Doe", 321);
        BankAccount b1 = new BankAccount(c, 100.0);
        ChequingAccount b2 = new ChequingAccount(c, 200.0, 12.0);
        
        b2.setOverdraftAmount(150.0);
        
        BankAccount b3 = b2;
        
        System.out.println(b1.getBalance() + ", " + b3.getBalance());
        
        b1.withdraw(110);
        System.out.println(b1.getBalance() + ", " + b3.getBalance());
        
        b2.withdraw(300.0);
        System.out.println(b1.getBalance() + ", " + b3.getBalance());
        
        b1.transfer(50.0, b2);
        System.out.println(b1.getBalance() + ", " + b3.getBalance());
        
        b2.transfer(88, b1);
        System.out.println(b1.getBalance() + ", " + b3.getBalance());
        
    } // end main
    
} // end BankAccountDemo
