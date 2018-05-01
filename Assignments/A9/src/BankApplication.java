
/**
 *              Team Assignment 9, CPSC 233
 * Class:       BankApplication.java
 * Purpose:     Make deposits and withdraws  from a Customer SavingsAccount
 *              using a GUI interface. Loads customer info from a file or
 *              user is prompted to create new account.
 *
 * @author      T01-3
 * Date:        March 28, 2018
 */
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BankApplication extends Application {

    private Customer customer;
    private BankAccount account;

    public static void main(String[] args) {
        launch(args);
    } // end main

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Array will hold Customer and BankAccount
        ArrayList<Object> custInfo;
        // Array holds account information loaded from file.
        // If file cannot be read then it is empty
        ArrayList<String> list = loadFile();

        // If list is empty then create a new customer and account
        if (list.isEmpty()) {

            CreateNew a = new CreateNew();
            a.newAccount();
            list = loadFile();
            custInfo = loadCustomerInfo(list);
            this.customer = (Customer) custInfo.get(0);
            this.account = (BankAccount) custInfo.get(1);

        } else { // otherwise point reference to Customer/ BankAccount instances

            custInfo = loadCustomerInfo(list);
            this.customer = (Customer) custInfo.get(0);
            this.account = (BankAccount) custInfo.get(1);

        } // end else

        // Create VBox for vertical ordering of Labels and Text Fields
        VBox root = new VBox();
        root.setSpacing(8); // Set vertical spacing between elements in the VBox

        // Declare Labels and Text fields
        Label customerNameLabel, customerIDLabel, balanceLabel, typeLabel;
        TextField depositTextField, withdrawTextField;
        Button excButton = new Button("Execute");
        Button exitButton = new Button("Save & Exit");

        // Assign Labels
        customerNameLabel = new Label("Customer name: " + customer.getName());
        customerIDLabel = new Label("Account ID: " + customer.getID());
        typeLabel = new Label("Account Type: " + list.get(2));

        // Display balance with 2 decimal places
        DecimalFormat df = new DecimalFormat("#.00");
        String balancef = df.format(account.getBalance());
        balanceLabel = new Label("Current balance: $" + balancef);

        // Set Label Text font and size
        customerNameLabel.setFont(Font.font("Times New Roman", 16));
        customerIDLabel.setFont(Font.font("TImes New Roman", 16));
        typeLabel.setFont(Font.font("TImes New Roman", 16));
        balanceLabel.setFont(Font.font("TImes New Roman", 16));

        // Assign Text fields.
        // depositTextField will be highlighted initially
        depositTextField = new TextField("Amt to deposit");
        withdrawTextField = new TextField();
        withdrawTextField.setPromptText("Amt to withdraw");

        //Create an HBox for the TextFields to align horizontally
        HBox textGroup = new HBox();
        // Set horizontal spacing between the textFields
        textGroup.setSpacing(5);

        // Add Text Fields to HBox and set width
        depositTextField.setPrefWidth(135);
        textGroup.getChildren().add(depositTextField);
        withdrawTextField.setPrefWidth(135);
        textGroup.getChildren().add(withdrawTextField);

        // Set the event handler when the execute button is clicked
        excButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try { // Attempt to convert text to a double and deposit value
                    double deposit = Double.parseDouble(depositTextField.getText());
                    account.deposit(deposit);
                } catch (NumberFormatException e) {
                }
                try { // Attempt to convert text to a double and withdraw value
                    double withdraw = Double.parseDouble(withdrawTextField.getText());
                    account.withdraw(withdraw);
                } catch (NumberFormatException e) {
                }

                // Display balance with 2 decimal places
                DecimalFormat df = new DecimalFormat("#.00");
                String balancef = df.format(account.getBalance());
                balanceLabel.setText("Current balance: $" + balancef);

                // Reset TextField text
                // No textField will be highlighted after first use of execute
                depositTextField.clear();
                depositTextField.setPromptText("Amt to deposit.");
                withdrawTextField.clear();
                withdrawTextField.setPromptText("Amt to withdraw");

            } // end handle
        }
        ); // end EventHandler

        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // Write information to file
                save();
                // Close Application
                primaryStage.close();

            } // end handle
        }
        ); // end EventHandler

        // Add Labels and HBox containing Text Fields to VBox Pane
        root.getChildren().add(customerNameLabel);
        root.getChildren().add(customerIDLabel);
        root.getChildren().add(typeLabel);

        // If Chequing Account, display relevant information
        if (this.account instanceof ChequingAccount) {
            ChequingAccount account = (ChequingAccount) this.account;
            Label feeLabel = new Label("Overdraft fee: " + account.getOverdraftFee());
            Label overdraftLabel = new Label("Overdraft: " + account.getOverdraftAmount());
            feeLabel.setFont(Font.font("TImes New Roman", 16));
            overdraftLabel.setFont(Font.font("TImes New Roman", 16));
            root.getChildren().add(feeLabel);
            root.getChildren().add(overdraftLabel);
        } else { // If SavingsAccount display relevant information
            SavingsAccount account = (SavingsAccount) this.account;
            Label interestLabel = new Label("Annual Interest Rate: " + account.getAnnualInterestRate());
            interestLabel.setFont(Font.font("TImes New Roman", 16));
            root.getChildren().add(interestLabel);
        }

        root.getChildren().add(textGroup);
        root.getChildren().add(excButton);
        root.getChildren().add(balanceLabel);
        root.getChildren().add(exitButton);

        // Display Graphics
        Scene scene = new Scene(root, 350, 260);
        primaryStage.setTitle("Bank Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    } // end start

    /**
     * Uses a BufferedRead to read text file. If successful the contents are
     * manipulated and stored in the return list. If unsuccessful error message
     * is displayed
     *
     * @return ArrayList
     */
    public ArrayList loadFile() {

        ArrayList<String> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("Data/accountInfo.txt"))) {

            while (br.ready()) {

                // Read line and extract information in question
                String s = br.readLine();
                int mark = s.indexOf(':') + 1;
                s = s.substring(mark);
                s = s.trim();
                // Add information to return list
                list.add(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("That is okay though- let's create a new account");
        }

        return list;

    } // end loadFile

    /**
     * Arraylist containing information from file that was read is assigned to
     * an instance of Customer and BankAccount. A check is made to see if the
     * account is a Savings or Chequing account
     *
     * @param info of type ArrayList - String
     * @return ArrayList - Object
     */
    public ArrayList loadCustomerInfo(ArrayList<String> info) {

        ArrayList<Object> custInfo = new ArrayList<>();
        int id = Integer.parseInt(info.get(1));
        double balance = Double.parseDouble(info.get(6));

        Customer cust = new Customer(info.get(0), id);
        custInfo.add(cust);

        // If Chequing Account assign overdraft fee and overdraft amount
        if (info.get(2).equalsIgnoreCase("Chequing")) {

            double fee = Double.parseDouble(info.get(4));
            double overdraft = Double.parseDouble(info.get(5));

            ChequingAccount acnt = new ChequingAccount(cust, balance, fee);
            acnt.setOverdraftAmount(overdraft);

            custInfo.add(acnt);
            // If Savings Account assign annual interest rate    
        } else if (info.get(2).equalsIgnoreCase("Savings")) {

            double interestRate = Double.parseDouble(info.get(3));
            SavingsAccount acnt = new SavingsAccount(cust, balance, interestRate);

            custInfo.add(acnt);
        }

        return custInfo;

    } // end loadCustomerInfo

    /**
     * Method writes over original load file with current values
     */
    public void save() {

        // If successful the file is rewritten
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Data/accountInfo.txt"))) {

            bw.write("Name:\t\t" + customer.getName());
            bw.newLine();
            bw.write("Customer ID:\t" + Integer.toString(customer.getID()));
            bw.newLine();

            // If Chequing Account write the appropriat information
            if (this.account instanceof ChequingAccount) {
                bw.write("Account Type:\tChequing");
                bw.newLine();
                bw.write("Interest Rate:\tN/A");
                bw.newLine();
                ChequingAccount account = (ChequingAccount) this.account;
                bw.write("Overdraft Fee:\t" + Double.toString(account.getOverdraftFee()));
                bw.newLine();
                bw.write("Overdraft:\t" + Double.toString(account.getOverdraftAmount()));
                bw.newLine();
                // If Savings Account write the appropriate information
            } else {
                bw.write("Account Type:\tSavings");
                bw.newLine();
                SavingsAccount account = (SavingsAccount) this.account;
                bw.write("Interest Rate:\t" + Double.toString(account.getAnnualInterestRate()));
                bw.newLine();
                bw.write("Overdraft Fee:\tN/A");
                bw.newLine();
                bw.write("Overdraft\tN/A");
                bw.newLine();
            }

            bw.write("Balance:\t" + Double.toString(account.getBalance()));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } // end save

} // end BankApplication
