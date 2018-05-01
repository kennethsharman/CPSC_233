
import static java.lang.Math.abs;

/**
 *              Team Assignment 6, CPSC 233 
 * Class:       BankAccount.java 
 * Purpose:     Creates a BackAccount for a corresponding Customer, with a 
 *              specified balance. Allows for withdraws, deposits, and transfers
 *              to another BankAccount object.
 * 
 * @author      T01-3
 * Date:        February 12, 2018
 */
public class BankAccount {

    //Declare balance and Customer variables.
    private double balance;
    private Customer accountHolder;

    /**
     * Default BankAccount constructor method.
     */
    public BankAccount() {
    }

    /**
     * The BankAccount constructor method that takes customer information and
     * the the initial balance.
     *
     * @param accountHolder of type Customer
     * @param startBalance of type double
     */
    public BankAccount(Customer accountHolder, double startBalance) {
        this.accountHolder = accountHolder;
        this.balance = startBalance;
    }

    /**
     * Constructor is passed a double and the balance is initialized to this
     * amount. New Customer is created, with empty String as name.
     *
     * @param startBalance of type double
     */
    public BankAccount(double startBalance) {
        this.balance = startBalance;
        this.accountHolder = new Customer("", 0);
    }

    /**
     * Retrieves the value of balance variable.
     *
     * @return balance of type double
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * The deposit method deposits a positive amount that is less than or equal
     * to the maximum double allowed. Only positive deposited amounts are
     * processed.
     *
     * @param amount of type double.
     */
    public void deposit(double amount) {

        //Checks if the deposit amount is positive and less than max double.
        if ((amount > 0) && (amount <= Double.MAX_VALUE)) {
            this.balance += amount;
        }
    } // end deposit

    /**
     * The withdraw method lowers the balance by the value of the parameter.
     *
     * @param amount of type double.
     */
    public void withdraw(double amount) {

        //Checks if the withdraw is less than the balance and max double.
        if ((amount <= (balance)) && (abs(amount) <= Double.MAX_VALUE)) {
            this.balance -= amount;

        }
    } // end withdraw

    /**
     * Transfers an amount from the account the method is invoked, to the
     * account provided as an argument. The success of the transfer depends on
     * if the account has enough funds to complete the withdraw/ deposit
     * sequence.
     *
     * @param amount
     * @param toAccount
     */
    public void transfer(double amount, BankAccount toAccount) {

        // Save initial balance in a temp variable
        double temp = this.balance;
        // Assign error value used to compare equality of floating point numbers
        double delta = 0.000001;

        this.withdraw(amount);
        // Withdraw has been completed if balance is now different from amount
        // stored in the temp variable. Compare using the delta variable.
        if ((this.balance <= temp + delta) && (this.balance >= temp - delta)) {
            return; // End method if balance is within error of intial value.
        } else { // If balance has been changed, complete the transfer.
            toAccount.deposit(amount);
        }
    } // end transfer

    /**
     * Initializes the balance to parameter.
     *
     * @param amount of type double
     */
    protected void setBalance(double amount) {
        this.balance = amount;
    }

    /**
     * The getCustomer creates a new Customer and initializes the instance
     * variables to this customer. The reference to the copy is returned.
     *
     * @return customerInfo data type.
     */
    public Customer getCustomer() {
        Customer clone
                = new Customer(this.accountHolder.getName(), this.accountHolder.getID());
        return clone;
    }

    /**
     * Sets the customerInfo variable to the Customer parameter.
     *
     * @param customerInfo of type Customer
     */
    public void setCustomerInfo(Customer customerInfo) {
        this.accountHolder = customerInfo;
    }

}//End of BankAccount
