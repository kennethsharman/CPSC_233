
/**
 *              Team Assignment 4, CPSC 233
 * Class:       SavingsAccount.java
 * Purpose:     Class extends BankAccount. Annual interest is earned and can be
 *              deposited into bank account.
 *
 * @author      T01-3
 * Date:        February 12, 2018
 */
public class SavingsAccount extends BankAccount { // Subclass of BankAccount class

    private double annualInterestRate; // Represented as a percent - always positive.

    /**
     * Default constructor.
     */
    public SavingsAccount() {
    }

    /**
     * Initializes balance and interest rate to parameters. Instance of customer
     * is created and the name variable is set to an empty string.
     *
     * @param initialBalance of type double.
     * @param interestRate of type double.
     */
    public SavingsAccount(double initialBalance, double interestRate) {
        Customer c = new Customer("", 0); // Create instance of Customer
        setCustomerInfo(c); // Set customerInfo to this Customer
        setBalance(initialBalance); // Set balance
        annualInterestRate = interestRate;
    }

    /**
     * Initializes customerInfo and balance to parameters.
     *
     * @param info of type Customer.
     * @param initialBalance of type double.
     */
    public SavingsAccount(Customer info, double initialBalance) {
        setCustomerInfo(info); // Set customerInfo
        setBalance(initialBalance); // set balance
    }

    /**
     * Getter method for annualInterestRate variable
     *
     * @return type double
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Setter method for annualInterestRate variable
     *
     * @param annualInterestRate of type double.
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Calculate and deposit monthly interest. The interest rate is divided by
     * 12 and multiplied by the balance.
     */
    public void depositMonthlyInterest() {
        double monthlyInterest = ((annualInterestRate/100) * (this.getBalance())) / 12.0;
        this.deposit(monthlyInterest);
    } // end depositMonthlyInterest
}
