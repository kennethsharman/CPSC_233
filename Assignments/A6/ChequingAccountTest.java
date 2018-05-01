import static org.junit.Assert.*;

import org.junit.Test;

public class ChequingAccountTest
{
    @Test
    public void test_constr1()
    {
        ChequingAccount b = new ChequingAccount(1.0);
        assertEquals(0.0, b.getBalance(), 0.00001);
    }
    
    @Test
    public void test_constr2()
    {
        Customer c = new Customer("John Doe", 321);
        ChequingAccount b = new ChequingAccount(c, 50.0, 1.3);
        assertEquals(50.0, b.getBalance(), 0.00001);
        assertEquals("John Doe", b.getCustomer().getName());
        assertEquals(1.3, b.getOverdraftFee(), 0.00001);
    }
    
    @Test
    public void test_deposit1() 
    {
        ChequingAccount b = new ChequingAccount(1.3);
        b.deposit(11.3);
        assertEquals(11.3, b.getBalance(), 0.000001);
    }
    
    @Test
    public void test_withdraw1() 
    {
        Customer c = new Customer("John Doe", 321);
        ChequingAccount b = new ChequingAccount(c, 100, 10);
        b.withdraw(10);
        assertEquals(90, b.getBalance(), 0.000001);
    }
    
    @Test
    public void test_withdraw2() 
    {
        Customer c = new Customer("John Doe", 321);
        ChequingAccount b = new ChequingAccount(c, 1000, 13);
        b.setOverdraftAmount(50);
        b.withdraw(1030);
        assertEquals(-43.0, b.getBalance(), 0.000001);
    }
    
    @Test
    public void test_withdraw3() 
    {
        Customer c = new Customer("John Doe", 321);
        ChequingAccount b = new ChequingAccount(c, 1000, 13);
        b.setOverdraftAmount(50);
        b.withdraw(1050);
        assertEquals(-63.0, b.getBalance(), 0.000001);
    }

    @Test
    public void test_withdraw4() 
    {
        Customer c = new Customer("John Doe", 321);
        ChequingAccount b = new ChequingAccount(c, 1000, 13);
        b.setOverdraftAmount(50);
        b.withdraw(1051);
        assertEquals(1000.0, b.getBalance(), 0.000001);
    }
        
	@Test
	public void test_transfer_overdraft() {
		ChequingAccount b = new ChequingAccount(new Customer("temp",1),1000.0,10.0);
		b.setOverdraftAmount(100.0);
		BankAccount b2 = new BankAccount(new Customer("temp2",2),500.0);
		b.transfer(1001,b2);
        assertEquals("Transfered 1001 from account with 1000 balance, 100 overdraft amount and 10.0 fee to account with 500 balance.  Testing from account", -11.0, b.getBalance(), 0.000001);
        assertEquals("Transfered 1001 from account with 1000 balance to account with 500 balance.  Testing to account", 1501.0, b2.getBalance(), 0.000001);
		
	}
    

}


