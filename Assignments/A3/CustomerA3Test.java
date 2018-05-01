import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerA3Test
{
	// test constructors
	
	@Test
	public void testDefaultConstructor()
	{
		Customer c = new Customer();
		assertEquals("Expected initial ID to be 0", 0, c.getID(), 0.00001);
	}

	@Test
	public void testConstructorWithParams()
	{
		Customer c = new Customer("John Doe", 876);
		assertEquals("Expected name to be John Doe", "John Doe", c.getName());
		assertEquals("Expected id to be 876", 876, c.getID(), 0.0001);		
	}
	
	@Test
	public void testCopyConstructor()
	{
		Customer oldCustomer = new Customer("Alice Black", 314);
		Customer newCustomer = new Customer(oldCustomer);
		assertEquals("Expected name to be Alice Black", "Alice Black", newCustomer.getName());
		assertEquals("Expected id to be 314", 314, newCustomer.getID(), 0.0001);
	}
		
}