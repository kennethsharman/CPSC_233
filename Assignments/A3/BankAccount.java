
/**
 *              Assignment 3, CPSC 233
 * Class:       BankAccount.java
 * Purpose:     Class creates a BankAccount for a new account holder, with a
 *              balance and overdraft amount. Multiple constructors are
 *              provided, along with methods for depositing and withdrawing.
 *
 * @author      T01-3
 * Date:        Feb 3, 2018
 */
public class BankAccount {

    private Customer accountHolder; // Customer associated with account.
    private double balance; // Bank account balance.
    private double overdraftAmount = 100; // max negative balance allowed.

    /**
     * Create instance of BanckAocount object. Default constructor.
     */
    public BankAccount() {
    }

    /**
     * Create instance of BanckAocount object. Customer is initialized as
     * account holder.
     *
     * @param newCustomer is of type Customer.
     */
    public BankAccount(Customer newCustomer) {
        this.accountHolder = newCustomer;
    }

    /**
     * Create instance of BanckAocount object. Customer is initialized as
     * account holder. Balance is initialized.
     *
     * @param newCustomer is of type Customer.
     * @param startBalance type double.
     */
    public BankAccount(Customer newCustomer, double startBalance) {
        this.accountHolder = newCustomer;
        this.balance = startBalance;
    }

    /**
     * Create instance of BanckAocount object. Customer is initialized as
     * account holder. Balance and overdraft amount are initialized.
     *
     * @param newCustomer is of type Customer.
     * @param startBalance type double.
     * @param startOverdraft type double.
     */
    public BankAccount(Customer newCustomer, double startBalance,
            double startOverdraft) {
        this.accountHolder = newCustomer;
        this.balance = startBalance;
        this.overdraftAmount = startOverdraft;
    }

    /**
     * Set the value of overdraftAmount
     *
     * @param overdraft type double
     */
    public void setOverdraftAmount(double overdraft) {
        this.overdraftAmount = overdraft;
    }

    /**
     * Set the value of balance.
     *
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Retrieve name and customer ID for the customer linked to this account.
     *
     * @return Customer data type.
     */
    public Customer getCustomer() {
        return accountHolder;
    }

    /**
     * Retrieve the value of balance.
     *
     * @return balance type double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Increase balance by amount deposited. Method verifies that the deposit is
     * a positive number.
     *
     * @param depositAmount double data type representing increase to balance.
     */
    public void deposit(double depositAmount) {
        if (depositAmount > 0) {
            balance += depositAmount;
        } // Increase the balance of the specific object by deposit amount.
    } //end deposit

    /**
     * Decrease balance by amount withdrawn. Method verifies that the withdraw
     * is a positive number.
     *
     * @param wdAmount double data type representing decrease to balance.
     */
    public void withdraw(double wdAmount) {
        if ((wdAmount <= (balance + overdraftAmount)) && (wdAmount >= 0)) {
            balance -= wdAmount;
        } // Decrease the balance of the specific object by wdAmount
    } // end withdraw

} // end BankAccount

