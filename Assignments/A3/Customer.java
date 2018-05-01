
/**
 *              Assignment 3, CPSC 233
 * Class:       Customer.java
 * Purpose:     Create a customer profile which is associated as the account
 *              holder in BanckAccount class. Instance variables include name
 *              and customerID.
 *
 * @author      T01-3
 * Date:        Feb 3, 2018
 */
public class Customer {

    private String name; // Name and customerID are instance variables
    private int customerID;

    /**
     * Default constructor.
     */
    public Customer() {
    }

    /**
     * Create instance of Customer. Name is initialized.
     *
     * @param newName of type String.
     * @param newCustomerID of type int.
     */
    public Customer(String newName, int newCustomerID) {
        name = newName;
        customerID = newCustomerID;
    }

    /**
     * Copy constructor. Customer's name and ID are copied from Customer object
     * that is passed as a parameter.
     *
     * @param aCustomer of type Customer.
     */
    public Customer(Customer aCustomer) {
        this(aCustomer.getName(), aCustomer.getID());
        // Set the customer's name and ID to match that of aCustomer.
    }

    /**
     * Retrieve the customer's name.
     *
     * @return name of type String.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieve the customer's ID number.
     *
     * @return customerID of type int.
     */
    public int getID() {
        return customerID;
    }

    /**
     * Set the customer's name.
     *
     * @param newName of type String
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Set the customer's ID number.
     *
     * @param newCustomerID of type int.
     */
    public void setCustomerID(int newCustomerID) {
        customerID = newCustomerID;
    }

    /**
     * Overrides default toString() method. 2 line output displays customer's
     * name and ID number, with formatting
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: ").append(name.toUpperCase()).append("\n");
        sb.append("Customer ID:   ").append(customerID);
        return sb.toString(); // to.String() method here is default java method 
        // that converts the Stringbuilder object to String type
    }

} // end class Customer
