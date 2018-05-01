
/**
 *              Team Assignment 9, CPSC 233
 * Class:       InvalidAmount.java
 * Purpose:     Displays error message when attempting to withdraw/ deposit
 *              invalid amounts
 *
 * @author      T01-3
 * Date:        March 28, 2018
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InvalidAmount {

    public void message() {

        Stage primaryStage = new Stage();
        VBox root = new VBox();
        root.setSpacing(20);

        // Declare and assign label and button
        Label errorMessage = new Label("INVALID AMOUNT");
        errorMessage.setFont(Font.font("TImes New Roman", 16));
        Button exitButton = new Button("Got it!");

        root.getChildren().add(errorMessage);
        root.getChildren().add(exitButton);

        // Event handler closes the pop-up window when button is clicked
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            } // end handle
        }
        ); // end EventHandler

        // Display Graphics
        Scene scene = new Scene(root, 350, 260);
        primaryStage.setTitle("Invalid Amount");
        primaryStage.setScene(scene);
        primaryStage.show();

    } // end start

} // end InvalidAmount
