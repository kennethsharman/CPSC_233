package GUI_Package;

/**
 * 		Final Project, CPSC 233 
 * Class:       IllustrationTest.java
 * Purpose:     Basic GUI "test-run" for objects of type Illustration. Intent
 *              was to mimic JUnit tests for GUI component, while simultaneously
 *              using the component to display the results of the test.
 *
 * @author      T01-3
 * Date:        April 9, 2018
 */
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IllustrationTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Constructor Test");

        // Setup app in order to display results of test
        StackPane root = new StackPane();
        VBox vbox = new VBox();
        vbox.setSpacing(20.0);
        vbox.setPadding(new Insets(30, 0, 0, 50));

        // Instantiate Stickers to be used as test result display
        Sticker s1 = new Sticker(10.0, -20.0);
        Sticker s2 = new Sticker(10.0, -20.0);

        // Instantiate Illustration
        Illustration l1 = new Illustration("Pictures/piperPic.png", 250.0, 200.0, 1, 1);
        l1.setVisible(true);

        // Add components to GUI
        vbox.getChildren().addAll(l1.getPic(), s1.getLabel(), s2.getLabel());
        root.getChildren().add(vbox);

        // Constructor expected to initilalize(x,y) to (250.0, 200.0)
        // Boolean comparison is used as it should be exact
        boolean xPos = l1.getxPosition() == 250.0;
        boolean yPos = l1.getyPosition() == 200.0;

        // Utilize some of the Sticker methods to give test more content
        s1.setFont("Courier New", 18);
        s2.setFont("Courier New", 18);
        s1.setText("x Position initialized correctly: " + String.valueOf(xPos));
        s2.setText("y Position initialized correctly: " + String.valueOf(yPos));

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    } // end start

} // end IllustrationTest
