
/**
 *              Team Assignment 7, CPSC 233
 * Class:       SavingsAccount.java
 * Purpose:     Class extends BankAccount. Annual interest is earned and can be
 *              deposited into bank account.
 *
 * @author      T01-3
 * Date:        March 12, 2018
 */
public class SavingsAccount extends BankAccount {

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

    } // end Constructor

    /**
     * Initializes customerInfo and balance to parameters.
     *
     * @param info of type Customer.
     * @param initialBalance of type double.
     */
    public SavingsAccount(Customer info, double initialBalance) {

        Customer clone = new Customer(info.getName(), info.getID());
        setCustomerInfo(clone); // Set customerInfo
        setBalance(initialBalance); // set balance

    } // end Constructor

    /**
     * Initializes customerInfo and balance to parameters.
     *
     * @param accountHolder of type Customer
     * @param startBalance of type double
     * @param annualInterestRate of type double
     */
    public SavingsAccount(Customer accountHolder, double startBalance, double annualInterestRate) {

        Customer clone = new Customer(accountHolder.getName(), accountHolder.getID());
        setCustomerInfo(clone); // Set customerInfo
        setBalance(startBalance); // set balance
        this.annualInterestRate = annualInterestRate;

    } // end Constructor

    /**
     * Getter method for annualInterestRate variable
     *
     * @return type double
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Setter method for annualInterestRate variable. Rate must be less than or
     * equal to the maximum double allowed.
     *
     * @param annualInterestRate of type double.
     */
    public void setAnnualInterestRate(double annualInterestRate) {

        if ((annualInterestRate <= Double.MAX_VALUE) && (annualInterestRate >= 0)) {
            this.annualInterestRate = annualInterestRate;
        }

    } // end setAnnualInterestRate

    /**
     * Calculate and deposit monthly interest. The interest rate is divided by
     * 12 and multiplied by the balance.
     */
    public void depositMonthlyInterest() {

        double monthlyInterest = ((annualInterestRate / 100) * (this.getBalance())) / 12.0;
        this.deposit(monthlyInterest);

    } // end depositMonthlyInterest

    /**
     * Method that checks if balance is lower than 1000, if so then subtract $5
     * fee and adds the interest
     *
     * @return (monthlyFee + interest) of type double
     */
    @Override
    public double getMonthlyFeesAndInterest() {

        double monthlyFee = 0.0;
        double interest = (this.getAnnualInterestRate() / 12);

        if (this.getBalance() < 1000.0) {
            monthlyFee -= 5.0;
            return (monthlyFee + interest);
        } else {
            double monthlyInterest = ((this.annualInterestRate / 100) * (this.getBalance())) / 12.0;
            return monthlyInterest;
        }

    }//End of getMonthlyFeesAndInterest

} // end SavingsAccount
