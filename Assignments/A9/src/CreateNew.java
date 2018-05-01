
/**
 *              Team Assignment 9, CPSC 233
 * Class:       CreateNew.java
 * Purpose:     Creates a text file with Customer and BankAccount information
 *              that is to be used by the BankApplication class
 *
 * @author      T01-3
 * Date:        March 28, 2018
 */
import java.io.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class CreateNew {

    public void newAccount() {

        Stage primaryStage = new Stage();
        // Create VBox for vertical ordering of Labels and Text Fields
        VBox root = new VBox();
        root.setSpacing(8); // Set vertical spacing between elements in the VBox

        // Declare TextFields and Save Button
        TextField typeField = new TextField("Enter \"Savings\" or \"Chequing\"");
        TextField nameField = new TextField("Enter Your Name");
        Button saveButton = new Button("Save");

        // Generate random number between 1000 and 9999
        Random rand = new Random();
        int id = rand.nextInt(9000) + 1000;

        root.getChildren().add(typeField);
        root.getChildren().add(nameField);
        root.getChildren().add(saveButton);

        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try { // If Account type is valid
                    if ((typeField.getText().equalsIgnoreCase("Savings"))
                            || (typeField.getText().equalsIgnoreCase("Chequing"))) {

                        // Retrieve input from TextFields
                        String type = typeField.getText();
                        String name = nameField.getText();

                        // Write information to file
                        save(type, name, id);
                        // Close Application
                        primaryStage.close();

                    } else {
                        System.out.println("You have entered in invalid information");
                        System.out.println("Exiting...");
                        System.exit(0);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You have entered in invalid information");
                    System.out.println("Exiting...");
                    System.exit(0);
                }

            } // end handle
        }
        ); // end EventHandler

        // Display Graphics
        Scene scene = new Scene(root, 350, 260);
        primaryStage.setTitle("Create New Account");
        primaryStage.setScene(scene);
        primaryStage.showAndWait();

    } // end start

    /**
     * Method writes a file with declared/ default values
     *
     * @param type of type String
     * @param name of type String
     * @param id of type int
     */
    public void save(String type, String name, int id) {

        // If successful the file is rewritten
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Data/accountInfo.txt"))) {

            bw.write("Name:\t\t" + name);
            bw.newLine();
            bw.write("Customer ID:\t" + id);
            bw.newLine();

            // If Chequing Account write the appropriat information
            if (type.equalsIgnoreCase("Chequing")) {

                bw.write("Account Type:\tChequing");
                bw.newLine();
                bw.write("Interest Rate:\tN/A");
                bw.newLine();
                bw.write("Overdraft Fee:\t" + Double.toString(10.0));
                bw.newLine();
                bw.write("Overdraft:\t" + Double.toString(100.0));
                bw.newLine();

                // If Savings Account write the appropriate information
            } else {
                bw.write("Account Type:\tSavings");
                bw.newLine();
                bw.write("Interest Rate:\t" + Double.toString(0.05));
                bw.newLine();
                bw.write("Overdraft Fee:\tN/A");
                bw.newLine();
                bw.write("Overdraft\tN/A");
                bw.newLine();
            }

            bw.write("Balance:\t" + Double.toString(0.0));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    } // end save

} // end CreateNew
