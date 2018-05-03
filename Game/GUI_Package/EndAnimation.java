package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       EndAnimation.java 
 * Purpose:     This class creates the end game animation once you have
 * 		pressed 'y' to end the game. Has a button that closes the 
 *              animation and returns to the MainMenu class.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.animation.ParallelTransition;
import Data_Package.ButtonsAndText;

public class EndAnimation {

    /**
     * Method is responsible for displaying the end game animation, which gives
     * the game a conclusion
     */
    public void endAnimation() {

        Stage stage = new Stage();

        //Setting the backdrop image
        Image backdropImage = new Image("Pictures/backDropLarge.png");
        ImageView backdrop = new ImageView(backdropImage);
        backdrop.toBack();

        //Setting up the Bridge
        Image bridgeImage = new Image("Pictures/bridge.png");
        ImageView bridge = new ImageView(bridgeImage);
        bridge.setTranslateY(90);
        bridge.setScaleX(1.1);
        bridge.setTranslateX(0);

        //Setting up the Grass
        Rectangle grassBlock = ButtonsAndText.getRectangle(2, 1366, 200, 0, 300);

        //Settings up the River
        Image riverImage = new Image("Pictures/river.png");
        ImageView river = new ImageView(riverImage);
        river.setTranslateY(10);
        river.setTranslateX(-100);
        river.setScaleY(0.75);

        // This is just for a delay so the children matchup with the other animation
        Rectangle r = new Rectangle();

        // Create the Pied Piper IMAGE AND SPRITE
        Image piperImage = new Image("Pictures/piperPic.png");
        ImageView piper = new ImageView(piperImage);
        piper.setScaleX(-1.25);
        piper.setScaleY(1.25);

        //Setting up the bushes
        Image bushImage1 = new Image("Pictures/bush1.png"); // BUSH FOR LEFT OF BRIDGE
        ImageView bush1 = new ImageView(bushImage1);
        bush1.setTranslateX(-160);
        bush1.setTranslateY(-30);
        bush1.setScaleX(0.75);
        bush1.setScaleY(0.75);

        Image bushImage2 = new Image("Pictures/bush1.png"); // BUSH FOR RIGHT OF BRIDGE 
        ImageView bush2 = new ImageView(bushImage2);
        bush2.setTranslateX(415);
        bush2.setTranslateY(-30);
        bush2.setScaleX(0.75);
        bush2.setScaleY(0.75);

        // TEXT		
        Text theEndText = ButtonsAndText.getText("THE END.", 9); // THE END text.
        theEndText.setText("THE END.");

        // PATHS (For animations to follow)
        // PIPER PATH
        Line pPath1 = new Line(900, 190, 350, 190);  // From off screen right to the right base of the bridge.
        Line pPath2 = new Line(350, 190, 150, 100);  // From base of bridge up slightly.
        Line pPath3 = new Line(150, 100, -50, 100);  // From top right of bridge to top left.
        Line pPath4 = new Line(-50, 100, -250, 190);  // From top left bridge to base left of bridge.
        Line pPath5 = new Line(-250, 190, -1000, 190); // From left base of bridge to off screen left.

        // CHILD1 PATH
        Line c1Path = new Line(950, 190, 350, 190);  // From off screen right to the right base of the bridge.
        Line c2Path = new Line(1000, 190, 350, 190);
        Line c3Path = new Line(1050, 190, 350, 190);

        // FADING RECTANGLES FOR FADE IN / FADE OUT
        Rectangle fadeRec1 = ButtonsAndText.getRectangle(4, 1366, 768, 0, 0);  // FADE IN 
        Rectangle fadeRec2 = ButtonsAndText.getRectangle(5, 1366, 768, 0, 0);  // FADE OUT

        // QUIT BUTTON FOR THE END SCREEN AND ACTION THAT GOES WITH IT
        Button quit = ButtonsAndText.getButton("Press SPACEBAR to close.", 0, 0, 0);
        quit.setPrefSize(150, 30);

        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.close();

            } // end handle
        });

        // Children Images
        Image childImage1 = new Image("Pictures/kid1.png");
        ImageView child1 = new ImageView(childImage1);
        child1.setScaleX(1.25);
        child1.setScaleY(1.25);

        Image childImage2 = new Image("Pictures/kid2.png");
        ImageView child2 = new ImageView(childImage2);
        child2.setScaleX(1.25);
        child2.setScaleY(1.25);

        // StackPane so we may overlay images.
        StackPane root = new StackPane();
        root.getChildren().addAll(backdrop, grassBlock, river, piper, child1,
                child2, bridge, bush1, bush2, fadeRec2, theEndText, quit, fadeRec1);

        // Create the Scene
        Scene scene = new Scene(root);

        // Add the Scene to the Stage
        stage.setScene(scene);
        stage.setHeight(768);
        stage.setWidth(1368);

        // Display the Stage
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

        // ALL THE TRANSITIONS FADING -> PATH -> SEQUENTIAL
        // FADE IN transition
        FadeTransition fade1 = new FadeTransition(Duration.seconds(3), fadeRec1);
        fade1.setFromValue(1.0);
        fade1.setToValue(0);

        // FADE OUT transition
        FadeTransition fade2 = new FadeTransition(Duration.seconds(3), fadeRec2);
        fade2.setFromValue(0);
        fade2.setToValue(1);

        // END GAME TEXT fade in transition
        FadeTransition fade3 = new FadeTransition(Duration.seconds(2), theEndText);
        fade3.setFromValue(0);
        fade3.setToValue(1.0);

        // Quit button FADE IN transition
        FadeTransition fade4 = new FadeTransition(Duration.seconds(1), quit);
        fade4.setFromValue(0);
        fade4.setToValue(1.0);

        // END GAME TEXT fade OUT transition
        FadeTransition fade5 = new FadeTransition(Duration.seconds(1), theEndText);
        fade5.setFromValue(1.0);
        fade5.setToValue(0);

        // Piper Transitions
        PathTransition pTrans1 = new PathTransition(Duration.seconds(3),
                pPath1, piper); //Path 1
        PathTransition pTrans2 = new PathTransition(Duration.seconds(1.5),
                pPath2, piper); //Path 2
        PathTransition pTrans3 = new PathTransition(Duration.seconds(1),
                pPath3, piper); //Path 3
        PathTransition pTrans4 = new PathTransition(Duration.seconds(1.5),
                pPath4, piper); //Path 4
        PathTransition pTrans5 = new PathTransition(Duration.seconds(3),
                pPath5, piper); //Path 5

        // These are transitions act as delays so the childrens animations dont 
        // fall behind the piper one because of fade in fade out
        PathTransition delayTrans = new PathTransition(Duration.seconds(3.5),
                pPath1, r);
        PathTransition delayTrans2 = new PathTransition(Duration.seconds(4),
                pPath1, r);

        // Child1 Transitions
        PathTransition c1Trans = new PathTransition(Duration.seconds(3),
                c1Path, child1); //Path 1
        PathTransition c1Trans2 = new PathTransition(Duration.seconds(1.5),
                pPath2, child1); //Path 2
        PathTransition c1Trans3 = new PathTransition(Duration.seconds(1),
                pPath3, child1); //Path 3
        PathTransition c1Trans4 = new PathTransition(Duration.seconds(1.5),
                pPath4, child1); //Path 4
        PathTransition c1Trans5 = new PathTransition(Duration.seconds(3),
                pPath5, child1); //Path 5

        // Child2 Transitions
        PathTransition c2Trans = new PathTransition(Duration.seconds(3),
                c2Path, child2); //Path1
        PathTransition c2Trans2 = new PathTransition(Duration.seconds(1.5),
                pPath2, child2); //Path 2
        PathTransition c2Trans3 = new PathTransition(Duration.seconds(1),
                pPath3, child2); //Path 3
        PathTransition c2Trans4 = new PathTransition(Duration.seconds(1.5),
                pPath4, child2); //Path 4
        PathTransition c2Trans5 = new PathTransition(Duration.seconds(3),
                pPath5, child2); //Path 5

        // All of Pipers transitions in sequential order
        // This is used to all animations play in the correct order
        SequentialTransition seqPiper = new SequentialTransition(
                fade1,
                pTrans1,
                pTrans2,
                pTrans3,
                pTrans4,
                pTrans5,
                fade2,
                fade3,
                fade5,
                fade4);

        // All of Child1's transitions in sequential order
        SequentialTransition seqChild1 = new SequentialTransition(
                delayTrans,
                c1Trans,
                c1Trans2,
                c1Trans3,
                c1Trans4,
                c1Trans5);

        // All of Child2's transitions in sequential order
        SequentialTransition seqChild2 = new SequentialTransition(
                delayTrans2,
                c2Trans,
                c2Trans2,
                c2Trans3,
                c2Trans4,
                c2Trans5);

        // This plays all four sequential transitions at the same time (In parallel)
        ParallelTransition pt = new ParallelTransition(seqPiper, seqChild1, seqChild2);
        pt.play();

    } // end endAnimation

} // end class EndAnimation
