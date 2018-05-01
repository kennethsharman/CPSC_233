/**
 *              Team Assignment 3, CPSC 233
 * Class:       Customer.java
 * Purpose:     Creates methods to allow the name and ID number
 * 				of customers of a bank to store information. 
 *
 * @author      T01-3
 * Date:        February 6, 2018
 */
public class Customer 
{
	private String name;
	private int customerID = 0;
	
	/**
	 * Default Customer constructor method.
	 */
	public Customer()
	{	
	}
	
	/**
	 * The Customer constructor method that takes in the name 
	 * and customer ID.
	 * 
	 * @param name of type String
	 * @param customerID of type int.
	 */
	public Customer(String customerName, int ID)
	{
		name = customerName;
		customerID = ID;
		
	}
	
	/**
	 * Copy of Customer constructor class.
	 * 
	 * @param name of type String.
	 * @param customerID of type int.
	 */
	public Customer(Customer newCustomer)
	{
		name = newCustomer.name;
		customerID = newCustomer.customerID;
	}
	
	/**
	 * The getName method returns the customer's name.
	 * 
	 * @return name of type String.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * The setName method sets the customer's name.
	 * 
	 * @param customerName of type String
	 */
	public void setName(String customerName)
	{
		name = customerName;
	}
	
	/**
	 * The getCustomerID method returns the customer's ID number.
	 * 
	 * @return customerID of type int.
	 */
	public int getID()
	{
		return customerID;
	}
	
	/**
	 * The setName method sets the customer's name.
	 * 
	 * @param ID of type int.
	 */
	public void setID(int ID)
	{
		customerID = ID;
	}
	
	/**
	 * The toString method returns the customer's name and ID.
	 * 
	 * @return String
	 */
	public String toString()
	{
		return ("Name of Customer: " + name + "\nCustomerID: " + customerID + "\n");
	}
}//End of Customer class
