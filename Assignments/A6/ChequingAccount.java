
import static java.lang.Math.abs;

/**
 *              Team Assignment 6, CPSC 233 
 * Class:       ChequingAccount.java
 * Purpose:     Subclass of BankAccount. Includes an overdraft amount, along
 *              with a fee is the overdraft is used when making a withdraw.
 *
 * @author      T01-3
 * Date:        March 3, 2018
 */
public class ChequingAccount extends BankAccount {

    private double overdraftFee;
    private double overdraftAmount;

    /**
     * Constructor initializes the overdraft fee.
     *
     * @param transactionFee of type double
     */
    public ChequingAccount(double transactionFee) {
        this.overdraftFee = transactionFee;
    }

    /**
     * Constructor initializes the Customer, balance, and overdraft fee
     *
     * @param accountHolder of type Customer
     * @param startBalance of type double
     * @param transactionFee of type double
     */
    public ChequingAccount(Customer accountHolder, double startBalance, double transactionFee) {
        super.setBalance(startBalance);
        super.setCustomerInfo(accountHolder);
        this.overdraftFee = transactionFee;
    }

    /**
     * Retrieves the value of overdraftFee.
     *
     * @return overdraftFee of type double
     */
    public double getOverdraftFee() {
        return this.overdraftFee;
    }

    /**
     * Sets the value of overdraftFee.
     *
     * @param fee of type double
     */
    public void setOverdraftFee(double fee) {
        this.overdraftFee = fee;
    }

    /**
     * Retrieve the value of overdraftAmount
     *
     * @return overdraftAmount of type double
     */
    public double getOverdraftAmount() {
        return this.overdraftAmount;
    }

    /**
     * The setOverdraftAmount method sets overdraftAmount if the parameter is
     * less than or equal to the maximum allowed double. If the overdraft fee
     * is set to a negative value, a check is made to ensure the balance is
     * large enough to not immediately violate this setting.
     *
     * @param overdraft of type double.
     */
    public void setOverdraftAmount(double overdraft) {
        if (abs(overdraft) <= Double.MAX_VALUE) {
            if (this.getBalance() >= -overdraft) {
                overdraftAmount = overdraft;
            }
        }
    }

    /**
     * The withdraw method changes the value of balance. If the amount is
     * greater than the balance, and less than balance and overdraftAmount the
     * amount and overdraftFee are subtracted from the balance. If the amount is
     * less than the balance, only the amount is subtracted.
     *
     * @param amount of type double.
     */
    @Override
    public void withdraw(double amount) {

        if (amount > this.getBalance()) {
            if (amount <= this.getBalance() + this.overdraftAmount) {
                this.setBalance(this.getBalance() - amount - this.overdraftFee);
            }
        }

        if (amount < this.getBalance()) {
            this.setBalance(this.getBalance() - amount);
        }
    } // end withdraw

} // end ChequingAccount
