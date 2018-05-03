package GUI_Package;

/**
 * 		Final Project, CPSC 233 
 * Class:       PiedPiperGame.java
 * Purpose:     Basic GUI "test-run" for objects of type Sticker. Intent was to
 *              mimic JUnit tests for GUI component, while simultaneously using
 *              the component to display the results of the test.
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

public class StickerTest extends Application {

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

        // Add components to GUI
        vbox.getChildren().addAll(s1.getLabel(), s2.getLabel());
        root.getChildren().add(vbox);

        // Constructor expected to initilalize(x,y) to (10.0, -20.0)
        // Boolean comparison is used as it should be exact
        boolean xPos = s1.getxPosition() == 10.0;
        boolean yPos = s1.getyPosition() == -20.0;

        // Utilize some of the Sticker methods to give test more content
        s1.setFont("Courier New", 18);
        s2.setFont("Courier New", 18);
        s1.setText("x Position initialized correctly: " + String.valueOf(xPos));
        s2.setText("y Position initialized correctly: " + String.valueOf(yPos));

        Scene scene = new Scene(root, 500, 130);
        primaryStage.setScene(scene);
        primaryStage.show();

    } // end start

} // end StickerTest class
