import static org.junit.Assert.*;

import org.junit.Test;



public class BankAccountTest
{
	// test constructors
	@Test
    public void test_creation(){
        BankAccount b = new BankAccount();
        assertEquals("Expected initial balance to be 0.0", 0.0, b.getBalance(), 0.00001);
    }
	
	@Test
	public void test_constructorWithCustomerAndBalance()
	{
		Customer c = new Customer("John Doe", 321);
		BankAccount b = new BankAccount(c, 50.0);
		assertEquals("Unexpected balance",50.0,b.getBalance(), 0.00001);
	}
	
	@Test
	public void test_constructorWithBalance()
	{
		Customer c = new Customer("John Doe", 321);
		BankAccount b = new BankAccount(c, 50.0);
		assertEquals("Unexpected balance", 50.0, b.getBalance(), 0.00001);
		assertEquals("Not expected customer", "John Doe", b.getCustomer().getName());
	}
	
	// Testing deposit
	@Test
    public void test_deposit() {
        BankAccount b = new BankAccount();
        b.deposit(10.25);
        assertEquals("Deposited 10.25.", 10.25, b.getBalance(), 0.000001);
    }
    
	@Test
    public void test_deposit_negativeAmount() {
        BankAccount b = new BankAccount();
        b.deposit(-10.25);
        assertEquals("Tried to deposit a negative amount", 0.00, b.getBalance(), 0.000001);
    }
        
    // testing withdraw
	@Test
    public void test_withdraw_sufficientBalance() {
        BankAccount b = new BankAccount();
        b.deposit(500.00);
        b.withdraw(44.25);
        assertEquals("Withdrew 44.25 after depositing 500.00", 455.75, b.getBalance(), 0.000001);
    }
    
	@Test
    public void test_withdraw_insufficientBalance() {
        BankAccount b = new BankAccount();
        b.deposit(5.00);
        b.withdraw(5.01);
        assertEquals("Withdrew 5.01 after depositing 5.00, nothing should have happened", 5.0, b.getBalance(), 0.000001);
    }
	
	@Test
	public void test_transfer_sufficientFunds() {
		BankAccount b = new BankAccount(new Customer("temp",1),1000.0);
		BankAccount b2 = new BankAccount(new Customer("temp2",2),500.0);
		b.transfer(1000,b2);
        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing from account", 0.0, b.getBalance(), 0.000001);
        assertEquals("Transfered 1000 from account with 1000 balance to account with 500 balance.  Testing to account", 1500.0, b2.getBalance(), 0.000001);
		
	}
	@Test
	public void test_transfer_insufficientFunds() {
		BankAccount b = new BankAccount(new Customer("temp",1),1000.0);
		BankAccount b2 = new BankAccount(new Customer("temp2",2),500.0);
		b.transfer(1001,b2);
        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing from account", 1000.0, b.getBalance(), 0.000001);
        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing to account", 500.0, b2.getBalance(), 0.000001);
		
	}
}
