
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
            balance -= withdrawAmount; //Calculates balance after withdrawal.
        }
    }

    /**
     * The deposit method deposits an amount.
     *
     * @param depositAmount of type double.
     */
    public void deposit(double depositAmount) {
        if (depositAmount > 0) //Checks if the deposit amount is positive.
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
     * The setOverdraftAmount method sets overdraft to an amount.
     *
     * @param overdraft of type double.
     */
    public void setOverdraftAmount(double overdraft) {
        overdraftAmount = overdraft; //Sets new overdraft amount.
    }

    /**
     * The getCustomer returns the customer information.
     *
     * @return customerInfo data type.
     */
    public Customer getCustomer() {
        return customerInfo;
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
