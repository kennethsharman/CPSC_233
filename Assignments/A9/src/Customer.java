/**
 *              Team Assignment 8, CPSC 233
 * Class:       Customer.java
 * Purpose:     This is an immutable class meaning you can't change instance variables
 * 				Creates methods to allow the name and ID number of customers of a bank 
 * 				to store information. 
 *
 * @author      T01-3
 * Date:        March 16, 2018
 */
public final class Customer {

    private final String name;
    private final int customerID;

    /**
     * The Customer constructor method that takes in the name and customer ID.
     *
     * @param customerName of type String.
     * @param ID of type int.
     */
    public Customer(String customerName, int ID) {
        name = customerName;
        customerID = ID;
    }

    /**
     * Copy of Customer constructor class.
     *
     * @param newCustomer of type Customer
     */
    public Customer(Customer newCustomer) {
        name = newCustomer.name;
        customerID = newCustomer.customerID;
    }

    /**
     * The getName method returns the customer's name.
     *
     * @return name of type String.
     */
    public String getName() {
        return name;
    }

    /**
     * The getCustomerID method returns the customer's ID number.
     *
     * @return customerID of type int.
     */
    public int getID() {
        return customerID;
    }

    /**
     * The toString method returns the customer's name and ID.
     *
     * @return String
     */
    @Override
    public String toString() {
        return ("Name of Customer: " + name + "\nCustomerID: " + customerID + "\n");
    }

}//End of Customer class
