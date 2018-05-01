
/**
 *              Team Assignment 7, CPSC 233
 * Class:       ChequingAccount.java
 * Purpose:     Extends BankAccount. Includes an overdraft amount, along with
 *              a fee is the overdraft is used when making a withdraw.
 *
 * @author      T01-3
 * Date:        March 12, 2018
 */

import static java.lang.Math.abs;

public class ChequingAccount extends BankAccount {

    private double overdraftFee;
    private double overdraftAmount;

    /**
     * ChequingAccount constructor initializes overdraft fee.
     *
     * @param transactionFee of type double
     */
    public ChequingAccount(double transactionFee) {
        this.overdraftFee = transactionFee;
    }

    /**
     * ChequingAccount constructor initializes Customer, balance, and overdraft
     * fee.
     *
     * @param accountHolder of type Customer
     * @param startBalance of type double
     * @param transactionFee of type double
     */
    public ChequingAccount(Customer accountHolder, double startBalance, double transactionFee) {

        super.setCustomerInfo(accountHolder);
        super.setBalance(startBalance);
        this.overdraftFee = transactionFee;

    } // end Constructor

    /**
     * Returns the value for the overdraft fee.
     *
     * @return overdraftFee of type double
     */
    public double getOverdraftFee() {
        return this.overdraftFee;
    }

    /**
     * Sets the value for the overdraft fee.
     *
     * @param transactionFee of type double
     */
    public void setOverdraftFee(double transactionFee) {
        this.overdraftFee = transactionFee;
    }

    /**
     * Returns the overdraft fee.
     *
     * @return overdraftAmount of type double
     */
    public double getOverdraftAmount() {
        return this.overdraftAmount;
    }

    /**
     * The setOverdraftAmount method sets overdraft to an amount that is less
     * than or equal to the maximum allowed double.
     *
     * @param amount of type double
     */
    public void setOverdraftAmount(double amount) {

        if (abs(amount) <= Double.MAX_VALUE) {
            if (this.getBalance() >= -amount) {
                this.overdraftAmount = amount;
            } // Sets new overdraft amount.
        }

    } // end setOverdraftAmount

    /**
     * The withdraw method withdraws an amount if the balance and overdraft
     * amount permits it.
     *
     */
    @Override
    public void withdraw(double amount) {

        if (amount > this.getBalance()) {

            if (amount <= (this.getBalance() + this.overdraftAmount)) {

                //Sets a new balance from the original balance minus the amount and fee.
                this.setBalance(this.getBalance() - amount - this.overdraftFee);

            }
        }

        //Checks if the withdraw is less than the balance.
        if (amount <= this.getBalance()) {
            this.setBalance(this.getBalance() - amount);
        }
        
    } // end withdraw

    /**
     * Method return zero if there is a positive balance and 20% of the balance
     * otherwise (may be negative).
     *
     * @return double
     */
    @Override
    public double getMonthlyFeesAndInterest() {

        if (this.getBalance() > 0) {
            return 0.0;
        } else {
            double percent = 0.20;
            return getBalance() * percent;
        }

    }//End of getMonthlyFeesAndInterest

} // end class ChequingAccount
