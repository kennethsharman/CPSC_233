
/**
 *              Assignment 2, CPSC 233
 * Class:       BankAccount.java
 * Purpose:     Class creates objects of type BankAccount which are used
 *              to store individual bank account information- balance and
 *              overdraft amount.
 *
 * @author      T01-3
 * Date:        January 30, 2018
 */
public class BankAccount {

    private double balance; // Bank account balance.
    private double overdraftAmount = 100; // max negative balance allowed.

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

    /**
     * Retrieve the value of balance.
     *
     * @return balance type double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Set the value of overdraftAmount
     *
     * @param overdraft type double
     */
    public void setOverdraftAmount(double overdraft) {
        this.overdraftAmount = overdraft;
    }

} // end BankAccount
