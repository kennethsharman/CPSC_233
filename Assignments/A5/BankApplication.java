
/**
 *              Team Assignment 5, CPSC 233
 * Class:       BankApplication.java
 * Purpose:     Make deposits and withdraws  from a Customer SavingsAccount
 *              using a GUI interface.
 *
 * @author      T01-3
 * Date:        February 26, 2018
 */
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BankApplication extends Application {

    // Create instances of Customer and SavingsAccount
    private Customer customer = new Customer("Charles Brown", 123456);
    private SavingsAccount s = new SavingsAccount(customer, 150.00);

    public static void main(String[] args) {
        launch(args);
    } // end main

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create VBox for vertical ordering of Labels and Text Fields
        VBox root = new VBox();
        root.setSpacing(8); // Set vertical spacing between elements in the VBox

        // Declare Labels and Text fields
        Label customerNameLabel, customerIDLabel, balanceLabel;
        TextField depositTextField, withdrawTextField;
        Button excButton = new Button("Execute");

        // Assign Labels
        customerNameLabel = new Label("Customer name: " + customer.getName());
        customerIDLabel = new Label("Account ID: " + customer.getID());
        // Display balance with 2 decimal places
        DecimalFormat df = new DecimalFormat("#.00");
        String balancef = df.format(s.getBalance());
        balanceLabel = new Label("Current balance: $" + balancef);

        // Set Label Text font and size
        customerNameLabel.setFont(Font.font("Times New Roman", 16));
        customerIDLabel.setFont(Font.font("TImes New Roman", 16));
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
                    s.deposit(deposit);
                } catch (NumberFormatException e) {
                }
                try { // Attempt to convert text to a double and withdraw value
                    double withdraw = Double.parseDouble(withdrawTextField.getText());
                    s.withdraw(withdraw);
                } catch (NumberFormatException e) {
                }

                // Display balance with 2 decimal places
                DecimalFormat df = new DecimalFormat("#.00");
                String balancef = df.format(s.getBalance());
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

        // Add Labels and HBox containing Text Fields to VBox Pane
        root.getChildren().add(customerNameLabel);
        root.getChildren().add(customerIDLabel);
        root.getChildren().add(textGroup);
        root.getChildren().add(excButton);
        root.getChildren().add(balanceLabel);

        // Display Graphics
        Scene scene = new Scene(root, 350, 200);
        primaryStage.setTitle("Bank Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    } // end start

} // end BankApplication
