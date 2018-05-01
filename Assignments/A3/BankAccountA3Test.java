import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountA3Test
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
    public void test_withdraw_overdraft() {
        BankAccount b = new BankAccount();
        b.deposit(5.00);
        b.withdraw(5.01);
        assertEquals("Withdrew 5.01 after depositing 5.00", -0.01, b.getBalance(), 0.000001);
    }
	
	@Test
	public void test_setOverdraftAmount_setToZero() {
		BankAccount b = new BankAccount();
		b.setOverdraftAmount(0.0);
		b.withdraw(1.0);
        assertEquals("Withdrew 1.0 from account with zero balance and zero overdraftAmount", 0.0, b.getBalance(), 0.000001);
		
	}
}