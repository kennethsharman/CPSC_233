package GUI_Package;

/**
 *              Final Project, CPSC 233
 * Class:       GameOverAnimation.java
 * Purpose:     Creates an animation that is shown if the player has been
 * 		defeated in one the battles.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import javafx.animation.FadeTransition;
import javafx.scene.transform.Rotate;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import Data_Package.ButtonsAndText;
import javafx.stage.StageStyle;

public class GameOverAnimation {

    /**
     * Responsible for displaying an animation when the player looses a fight.
     * Indicates to the player that the game has been lost.
     */
    public void gameOver() {

        Stage stage = new Stage();

        //Setting the backdrop image
        Image backdropImage = new Image("Pictures/backDropLarge_blackAndWhite.png");
        ImageView backdrop = new ImageView(backdropImage);
        backdrop.toBack();

        //Setting up the Grass
        Rectangle grassBlock = ButtonsAndText.getRectangle(3, 1366, 400, 0, 300);

        // Create the Pied Piper IMAGE AND SPRITE
        Image piperImage = new Image("Pictures/piper_dead.png");
        ImageView piper = new ImageView(piperImage);
        piper.setScaleX(4);
        piper.setScaleY(4);
        piper.getTransforms().add(new Rotate(-90, 60, 60));

        // TEXT	
        Text goText = ButtonsAndText.getText("GAME OVER", 10); // THE END text.      

        // FADING RECTANGLES FOR FADE IN / FADE OUT
        // FADE IN
        Rectangle fadeRec1 = ButtonsAndText.getRectangle(5, 1366, 768, 0, 0);
        // FADE OUT
        Rectangle fadeRec2 = ButtonsAndText.getRectangle(4, 1366, 768, 0, 0);

        // QUIT BUTTON FOR THE END SCREEN AND ACTION THAT GOES WITH IT
        Button quit = ButtonsAndText.getButton("Click to close.", 0, 0, 0);
        quit.setPrefSize(150, 30);

        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.close();
            } // end handle

        });

        // StackPane so we may overlay images.
        StackPane root = new StackPane();
        root.getChildren().addAll(backdrop, grassBlock, piper, fadeRec1,
                fadeRec2, goText, quit);

        // Create the Scene
        Scene scene = new Scene(root);

        // Add the Scene to the Stage
        stage.setScene(scene);
        stage.setHeight(768);
        stage.setWidth(1366);

        // Display the Stage
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        // ALL THE TRANSITIONS FADING -> PATH -> SEQUENTIAL
        FadeTransition fade1 = new FadeTransition(Duration.seconds(3),
                fadeRec1); // FADE IN transition
        fade1.setFromValue(0);
        fade1.setToValue(1.0);

        FadeTransition fade5 = new FadeTransition(Duration.seconds(0.5),
                fadeRec2); // FADE IN transition
        fade5.setFromValue(1.0);
        fade5.setToValue(0);

        FadeTransition fade2 = new FadeTransition(Duration.seconds(2),
                goText); // FADE IN transition
        fade2.setFromValue(0);
        fade2.setToValue(1.0);

        FadeTransition fade3 = new FadeTransition(Duration.seconds(1),
                goText); // FADE IN transition
        fade3.setFromValue(1.0);
        fade3.setToValue(0);

        FadeTransition fade4 = new FadeTransition(Duration.seconds(2),
                quit); // FADE IN transition
        fade4.setFromValue(0);
        fade4.setToValue(1.0);

        SequentialTransition s = new SequentialTransition(fade5, fade1,
                fade2, fade3, fade4);
        s.play();

    }//end gameOver

}//end GameOverAnimation
