
import static java.lang.Math.abs;


/**
 *              Team Assignment 3, CPSC 233
 * Class:       BankAccount.java
 * Purpose:     Allows for deposits, withdrawals, retrieving a balance
 * 				and setting the overdraft amount for a bank account and
 * 				creating an instance of the Customer class.
 *
 * @author      T01-3
 * Date:        February 6, 2018
 */
public class BankAccount {
    //Declaring values for the balance and initializing the overdraft amount.

    private double balance;
    private double overdraftAmount = 100.0;
    private Customer customerInfo;

    /**
     * Default BankAccount constructor method.
     */
    public BankAccount() {
    }

    /**
     * The BankAccount constructor method that takes customer information and
     * the balance amount.
     *
     * @param info of type Customer.
     * @param amount of type double.
     */
    public BankAccount(Customer info, double amount) {
        customerInfo = info;
        balance = amount;
    }

    /**
     * Constructor is passed a double and the balance is initialized to this
     * amount. New Customer is created, with empty String as name.
     *
     * @param intialBalance of type double.
     */
    public BankAccount(double intialBalance) {
        balance = intialBalance;
        this.customerInfo = new Customer("", 0);
    }

    /**
     * The withdraw method withdraws an amount.
     *
     * @param withdrawAmount of type double.
     */
    public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= (balance + overdraftAmount)) //Checks if the withdraw is less than the balance.
        {
            if (abs(withdrawAmount) <= Double.MAX_VALUE) {
                balance -= withdrawAmount; //Calculates balance after withdrawal.
            }
        }
    }

    /**
     * The deposit method deposits a positive amount than is less than or
     * equal to the maximum double allowed.
     *
     * @param depositAmount of type double.
     */
    public void deposit(double depositAmount) {
        //Checks if the deposit amount is positive and less than max double.
        if ((depositAmount > 0) && (depositAmount <= Double.MAX_VALUE))
        {
            balance += depositAmount; //Calculates balance after deposit.
        }
    }

    /**
     * The getBalance method returns the account balance.
     *
     * @return balance of type double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Initializes the balance to parameter.
     *
     * @param balance
     */
    public final void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * The setOverdraftAmount method sets overdraft to an amount that is less
     * than or equal to the maximum allowed double.
     *
     * @param overdraft of type double.
     */
    public void setOverdraftAmount(double overdraft) {
        if (abs(overdraft) <= Double.MAX_VALUE)  {
            if (this.balance >= -overdraft) {
                overdraftAmount = overdraft;   
            }
        } //Sets new overdraft amount.
    }

    /**
     * The getCustomer creates a new Customer and initializes the instance
     * variables to this customer. The reference to the copy is returned.
     *
     * @return customerInfo data type.
     */
    public Customer getCustomer() {
        Customer clone = 
                new Customer(this.customerInfo.getName(), this.customerInfo.getID());
        return clone;
    }

    /**
     * Sets the customerInfo variable to the Customer parameter.
     *
     * @param customerInfo of type Customer
     */
    public final void setCustomerInfo(Customer customerInfo) {
        this.customerInfo = customerInfo;
    }

}//End of BankAccount class
