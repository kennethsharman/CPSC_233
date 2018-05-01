/**
 *              Team Assignment 8, CPSC 233
 * Class:       BankAccount.java
 * Purpose:     Creates an abstract BackAccount for a corresponding Customer,
 *              with a specified balance. Allows for withdraws, deposits, and
 *              transfers to another BankAccount object.
 *
 * @author      T01-3
 * Date:        March 16, 2018
 */

import static java.lang.Math.abs;

public abstract class BankAccount {

    //Declaring values for the balance and initializing the overdraft amount.
    private double balance;
    private Customer accountHolder;

    /**
     * Default BankAccount constructor method.
     */
    public BankAccount() {
    }

    /**
     * The BankAccount constructor method that takes customer information and
     * the balance amount.
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
     * @param intialBalance of type double.
     */
    public BankAccount(double intialBalance) {
        this.balance = intialBalance;
        this.accountHolder = new Customer("", 0);
    }

    /**
     * The withdraw method withdraws an amount.
     *
     * @param amount of type double
     */
    public void withdraw(double amount) {
        if (amount <= this.balance) //Checks if the withdraw is less than the balance.
        {
            if (abs(amount) <= Double.MAX_VALUE) {
                this.balance -= amount; //Calculates balance after withdrawal.
            }
        }
        else {
            InvalidAmount error = new InvalidAmount();
            error.message();
        }
    } // end withdraw

    /**
     * The deposit method deposits a positive amount than is less than or equal
     * to the maximum double allowed.
     *
     * @param amount of type double
     */
    public void deposit(double amount) {
        //Checks if the deposit amount is positive and less than max double.
        if ((amount > 0) && (amount <= Double.MAX_VALUE)) {
            this.balance += amount; //Calculates balance after deposit.
        }
        else {
            InvalidAmount error = new InvalidAmount();
            error.message();
        }
    } // end deposit

    /**
     * The getBalance method returns the account balance.
     *
     * @return balance of type double.
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Initializes the balance to parameter.
     *
     * @param amount of type double
     */
    public final void setBalance(double amount) {
        this.balance = amount;
    }

    /**
     * The getCustomer creates a new Customer and initializes the instance
     * variables to this customer. The reference to the copy is returned.
     *
     * @return customerInfo of type Customer.
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
    public final void setCustomerInfo(Customer customerInfo) {
        this.accountHolder = customerInfo;
    }

    /**
     * Transfers an amount from the account the method is invoked, to the
     * account provided as an argument. The success of the transfer depends on
     * if the account has enough funds to complete the withdraw/ deposit
     * sequence.
     *
     * @param amount of type double.
     * @param toAccount of type BankAccount.
     */
    public void transfer(double amount, BankAccount toAccount) {

        // Save initial balance in a temp variable
        double temp = this.balance;
        // Assign arbitrary delta value used to compare equality of floating 
        // point numbers
        double delta = 0.000001;

        this.withdraw(amount);

        // Withdraw has been completed if balance is now different from amount
        // stored in the temp variable. Compare using the delta variable.
        if ((this.balance <= temp + delta) && (this.balance >= temp - delta)) {

            return; // End method if balance is within error of intial value.

        } else {
            // If balance has been changed, complete the transfer.
            toAccount.deposit(amount);
        }
    } // end transfer

    /**
     * Abstract method.
     *
     * @return sum of the monthly fees and interest of type double
     */
    protected abstract double getMonthlyFeesAndInterest();

    /**
     * Method is to be called at the end of the month. Monthly fees and interest
     * are added to the account balance.
     */
    public void monthEndUpdate() {

        this.setBalance(this.getBalance() + this.getMonthlyFeesAndInterest());

    } //End of monthEndUpdate

} //End of BankAccount class
