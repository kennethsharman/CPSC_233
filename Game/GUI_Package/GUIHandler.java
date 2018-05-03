package GUI_Package;

/**
 * 		Final Project, CPSC 233
 * Class:       GameGUI.java 
 * Purpose:     Handles the in-game graphics with the exception of the fight and
 *              menu display. In-class event handling is included to alow the 
 *              user to move the Pied Piper character in order to complete the 
 *              game objectives.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import Data_Package.PiedPiperGame;
import GUI_Package.MainMenu;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUIHandler {

	private static MediaPlayer music;
    protected static final double WIN_WIDTH = 1368.0;
    protected static final double WIN_HEIGHT = 768.0;
    private static double canvasLayout = -WIN_WIDTH;

    private static final String INTROSPEACH = "Welcome to Hamelin, Germany!"
            + " You are known as the \"Pied Piper\".\nUpon your arrival to the "
            + "town, you notice a massive infestation of rats.\nIt would be wise"
            + " to ask one of the townsfolk what in the world is going on.\n";

    private static final String RATSSPEACH = "\nRATS RATS RATS!\nGOTTA GET RID"
            + "\nOF THE RATS!\nIt is rumoured that the mayor\nhas a bag of gold,"
            + " for anyone\nwho can get rid of the rats.";

    private static final String GOLDSPEACH = "\nWe must get rid of the rats!\n\n"
            + "This bag of gold is yours if\nyou can rid the town of rats.";

    private static final String CRAZYSPEACH = "You want a bag of gold??\nHA! "
            + "You crazy LOON!\nAll you did was pipe a TUNE.\nThere is no gold "
            + "for you.";

    // Instance of PiedPiperGame, GUIElements and DigitalClock
    PiedPiperGame game;
    GuiElements e;
    protected DigitalClock clock;
    
    /**
     * Sets the media player the same as the one created in the MainMenu class.
     *
     * @param player of type MediaPlayer
     */
    public static void setMusic(MediaPlayer player)
    {
    	music = player;
    }

    /**
     * Constructor is passed PiedPiperGame. The boolean parameter allows either
     * a new game to be created or load a saved game.
     *
     * @param game of type PiedPiperGame
     * @param newGame of type boolean
     */
    public GUIHandler(PiedPiperGame game, boolean newGame) {

        this.game = game;
        clock = new DigitalClock(game);

        if (newGame == true) {
            // If new game set piper to starting point of the game
            game.setPiperXLocation(0.07 * WIN_WIDTH);
        }
        // All games have piper at same y location
        game.setPiperYLocation(0.69 * WIN_HEIGHT);
        this.e = new GuiElements(game);

    } // end Constructor

    /**
     * Method is responsible for drawing each level. If load game is used, GUI
     * cannot rely on sequential addition/ subtraction of GUI elements therefore
     * each level has its own state, as defined here.
     */
    public void drawLevel() {

        // Switch evaluates the game level and displays the appropriate GUI
        switch (game.getLevel()) {
            case (0):
                e.getIC().setSmallRatVisible(true);
                e.getSC().getObjectiveSticker().setText("\tOBJECTIVES");
                e.getSC().getTextOutput().setText(INTROSPEACH);
                break;
            case (1):
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().setSmallRatVisible(true);
                e.getSC().getObjectiveSticker().setText("\tOBJECTIVES");
                e.getSC().getTextOutput().setText("");
                break;
            case (2):
                e.getIC().getPeasantImg().setVisible(true);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().setSmallRatVisible(true);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.TALK_TOWNSFOLK));
                break;
            case (3):
                e.getIC().getPeasantImg().setVisible(true);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().setSmallRatVisible(true);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.TALK_TOWNSFOLK));

                if (game.getPiperXLocation() > 0.7 * WIN_WIDTH) {
                    e.getIC().getTextBubbleImg().setVisible(true);
                    e.getIC().getTextBubbleImg().getPic().relocate(
                            0.70 * WIN_WIDTH, 0.3 * WIN_HEIGHT);
                    e.getSC().getSpeechSticker().setText(RATSSPEACH);
                }
                break;
            case (4):
                e.getIC().getPeasantImg().setVisible(true);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().setSmallRatVisible(true);
                e.getIC().getTextBubbleImg().setVisible(true);
                e.getIC().getTextBubbleImg().getPic().relocate(
                        0.70 * WIN_WIDTH, 0.3 * WIN_HEIGHT);
                e.getSC().getSpeechSticker().setText(RATSSPEACH);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.TALK_MAYOR));
                break;
            case (5):
                e.getIC().getMayorImg().setVisible(true);
                e.getIC().getPeasantImg().setVisible(false);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().setSmallRatVisible(true);
                e.getIC().getTextBubbleImg().setVisible(false);
                e.getSC().getSpeechSticker().setText("");
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.TALK_MAYOR));

                if (game.getPiperXLocation() < 0.12 * WIN_WIDTH) {
                    e.getIC().getPeasantImg().setVisible(false);
                    e.getIC().getTextBubbleImg().setVisible(true);
                    e.getIC().getTextBubbleImg().setScale(-1);
                    e.getIC().getTextBubbleImg().getPic().relocate(
                            Illustration.BUBBLEX, Illustration.BUBBLEY);
                    e.getIC().getRatImg().setVisible(true);
                    e.getSC().getObjectiveSticker().setText(
                            game.objectiveString(PiedPiperGame.Task.CATCH_RATS));
                    e.getSC().getSpeechSticker().setText(GOLDSPEACH);
                    e.getSC().getSpeechSticker().relocateSticker(
                            0.09 * WIN_WIDTH, 0.35 * WIN_HEIGHT);
                }
                break;
            case (6):
            case (7):
                e.getIC().getMayorImg().setVisible(true);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().getRatImg().setVisible(true);
                e.getIC().setSmallRatVisible(true);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.CATCH_RATS));
                e.getIC().getTextBubbleImg().setVisible(true);
                e.getIC().getTextBubbleImg().setScale(-1);
                e.getIC().getTextBubbleImg().getPic().relocate(
                        Illustration.BUBBLEX, Illustration.BUBBLEY);
                e.getSC().getSpeechSticker().setText(GOLDSPEACH);
                e.getSC().getSpeechSticker().relocateSticker(
                        0.09 * WIN_WIDTH, 0.35 * WIN_HEIGHT);

                if (game.getPiperXLocation() > 0.615 * WIN_WIDTH) {
                    e.getIC().getTextBubbleImg().setVisible(false);
                    e.getSC().getSpeechSticker().setText("");
                    e.getSC().getTextOutput().setText("YOU CAUGHT THE RATS!!");
                    e.getSC().getObjectiveSticker().setText(
                            game.objectiveString(PiedPiperGame.Task.TALK_MAYOR));
                }
                break;
            case (8):
                e.getIC().getMayorImg().setVisible(true);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().getRatImg().drawPic(
                        game.getPiperXLocation() + 0.085 * WIN_WIDTH,
                        0.67 * WIN_HEIGHT, true);
                e.getIC().setSmallRatVisible(true);
                e.getIC().relocateSmallRats();
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.TALK_MAYOR));
                e.getSC().getTextOutput().setText("YOU CAUGHT THE RATS!!");

                if (game.getPiperXLocation() < 0.12 * WIN_WIDTH) {
                    e.getIC().setSmallRatVisible(false);
                    e.getIC().getRatImg().setVisible(false);
                    e.getIC().getTextBubbleImg().setScale(-1);

                    e.getIC().getTextBubbleImg().setVisible(true);
                    e.getIC().getTextBubbleImg().getPic().relocate(
                            Illustration.BUBBLEX, Illustration.BUBBLEY);
                    e.getSC().getSpeechSticker().setText(CRAZYSPEACH);
                    e.getSC().getSpeechSticker().relocateSticker(
                            0.08 * WIN_WIDTH, 0.38 * WIN_HEIGHT);
                    e.getSC().getObjectiveSticker().setText(
                            game.objectiveString(PiedPiperGame.Task.GET_CHILDREN));
                    e.getSC().getTextOutput().setText(
                            "Revenge is in order. Move back to fight the mayor.\n"
                            + "Then continue to lead the children away");
                    e.getSC().getTextOutput().relocateSticker(
                            0.35 * WIN_WIDTH, 0.32 * WIN_HEIGHT);
                }
                break;
            case (9):
                e.getIC().getMayorImg().setVisible(true);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().getTextBubbleImg().setScale(-1);
                e.getIC().getTextBubbleImg().setVisible(true);
                e.getIC().getTextBubbleImg().getPic().relocate(
                        Illustration.BUBBLEX, Illustration.BUBBLEY);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.GET_CHILDREN));
                e.getSC().getSpeechSticker().setText(CRAZYSPEACH);
                e.getSC().getSpeechSticker().relocateSticker(
                        0.08 * WIN_WIDTH, 0.38 * WIN_HEIGHT);
                e.getSC().getTextOutput().setText(
                        "Revenge is in order. Move back to fight the mayor.\n"
                        + "Then continue to lead the children away");
                e.getSC().getTextOutput().relocateSticker(
                        0.35 * WIN_WIDTH, 0.32 * WIN_HEIGHT);
                if ((game.getPiperXLocation() > 0.33 * WIN_WIDTH)
                        || (game.getPiperXLocation() < -0.2 * WIN_WIDTH)) {
                    e.getIC().getMayorImg().setVisible(false);
                    e.getIC().getTextBubbleImg().setVisible(false);
                    e.getSC().getSpeechSticker().setText("");
                    e.getSC().getTextOutput().setText("");
                }
                break;
            case (10):
                e.getIC().getMayorImg().setVisible(false);
                e.getIC().getVillagerImg().setVisible(true);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.GET_CHILDREN));

                if (game.getPiperXLocation() > 1.2 * WIN_WIDTH) {
                    e.getIC().getChild1Img().setVisible(true);
                    e.getIC().getChild2Img().setVisible(true);
                }
                break;
            case (11):
                e.getIC().getMayorImg().setVisible(false);
                e.getIC().getVillagerImg().setVisible(true);
                e.getIC().getChild1Img().setVisible(true);
                e.getIC().getChild2Img().setVisible(true);
                e.getSC().getObjectiveSticker().setText(
                        game.objectiveString(PiedPiperGame.Task.GET_CHILDREN));

                if (game.getPiperXLocation() < -1100) {
                    e.getSC().getTextOutput().setText("You got your revenge\n "
                            + "Lead the children away from the town?\nPRESS 'y' "
                            + "for YES \n\nTHIS IS GAMEOVER");
                    e.getSC().getTextOutput().relocateSticker(
                            -0.5 * WIN_WIDTH, 0.30 * WIN_HEIGHT);
                }
                break;

        } // end switch

    } // end drawLevel

    /**
     * Adds all the "fixed "GUI components to a group and sets the theme
     *
     * @param group of type Group
     * @param gc of type GraphicsContext
     */
    public void initializeBackGround(Group group, GraphicsContext gc) {
        group.getChildren().add(e.getIC().getPeasantImg().getPic());
        group.getChildren().add(e.getIC().getVillagerImg().getPic());
        group.getChildren().add(e.getIC().getMayorImg().getPic());
        group.getChildren().add(e.getIC().getFlower1Img().getPic());
        group.getChildren().add(e.getIC().getPiperImg().getPic());
        group.getChildren().add(e.getIC().getRatImg().getPic());
        group.getChildren().add(e.getIC().getSmallRat1Img().getPic());
        group.getChildren().add(e.getIC().getSmallRat2Img().getPic());
        group.getChildren().add(e.getIC().getSmallRat3Img().getPic());
        group.getChildren().add(e.getIC().getSmallRat4Img().getPic());
        group.getChildren().add(e.getIC().getSmallRat5Img().getPic());
        group.getChildren().add(e.getIC().getTextBubbleImg().getPic());
        group.getChildren().add(e.getIC().getChild1Img().getPic());
        group.getChildren().add(e.getIC().getChild2Img().getPic());
        group.getChildren().add(e.getIC().getFlower2Img().getPic());

        e.getIC().getPiperImg().setVisible(true);
        e.getIC().getFlower1Img().setVisible(true);
        e.getIC().getFlower2Img().setVisible(true);

        // Insert background image with graphics context
        gc.drawImage(e.getIC().getBackGround(), 0, 0, 3.0 * WIN_WIDTH,
                WIN_HEIGHT, 0, 0, 4290, 768);
        // Draw rectangle representing a field of green grass
        gc.setFill(Color.FORESTGREEN);
        gc.fillRect(0, 0.85 * WIN_HEIGHT, WIN_WIDTH * 3.0,
                0.2 * WIN_HEIGHT);
        // Add Labels to Group and set font/ font size
        e.getSC().getTextOutput().setFont("TImes New Roman", 24);
        group.getChildren().add(e.getSC().getTextOutput().getLabel());
        e.getSC().getSpeechSticker().setFont("TImes New Roman", 16);
        group.getChildren().add(e.getSC().getSpeechSticker().getLabel());

    } // end initializeBackGround

    /**
     * This method sets the Scene, depending on the level of the Pied Piper
     * Game. At this stage of our project, the event handling is embedded here.
     * Future versions will define the event handling separately.
     */
    public void mainGame() {

        Stage primaryStage = new Stage();

        // Set StackPane, Group, Canvas, and Graphics Context
        StackPane root = new StackPane();

        Group background = new Group();
        Canvas canvas1 = new Canvas(WIN_WIDTH * 3.0, WIN_HEIGHT);
        canvas1.setLayoutX(-WIN_WIDTH);
        background.getChildren().add(canvas1);
        GraphicsContext gc = canvas1.getGraphicsContext2D();
        initializeBackGround(background, gc);
        root.getChildren().add(background); // Add Group to StackPane.

        // Add Display of current objective at top of screen
        HBox topBar = new HBox();
        topBar.getChildren().add(e.getSC().getObjectiveSticker().getLabel());
        e.getSC().getObjectiveSticker().setFont("Arial", 32);
        e.getSC().getObjectiveSticker().getLabel().setTextFill(Color.RED);
        root.getChildren().add(topBar);

        // Add clock to the stackpane
        Group clockHolder = new Group();
        clockHolder.getChildren().add(clock);
        root.getChildren().add(clockHolder);
        clockHolder.setTranslateX(0.465 * WIN_WIDTH);
        clockHolder.setTranslateY(-0.47 * WIN_HEIGHT);

        // Set Scene
        Scene scene = new Scene(root, WIN_WIDTH, WIN_HEIGHT);

        // At the start of the game the GIU is displayed based on game level.
        drawLevel();

        // Clock is started from specified count as per the constructor
        clock.runClock();

        // EventHandler evaluates level variable which in turn dictates what
        // is displayed in the Scene. Keyboard input changes the position of 
        // piperImg and allows user to exit the program.
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {

                // Switch draws and updates levels based on progress of player
                // Current 11 levels or "checkpoints"
                switch (game.getLevel()) {
                    case (0):
                        drawLevel();
                        if (game.getPiperXLocation() > 0.2 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (1):
                        drawLevel();
                        if (game.getPiperXLocation() > 0.33 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (2):
                        drawLevel();
                        if (game.getPiperXLocation() > 0.4 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (3):
                        drawLevel();
                        if (game.getPiperXLocation() > 0.7 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (4):
                        drawLevel();
                        if (game.getPiperXLocation() < 0.5 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (5):
                        drawLevel();
                        if (game.getPiperXLocation() < 0.12 * WIN_WIDTH) {
                            //canvas1.setLayoutX(-WIN_WIDTH);
                            game.nextLevel();
                        }
                        break;
                    case (6):
                        drawLevel();
                        if (game.getPiperXLocation() > 0.20 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (7):
                        drawLevel();
                        if (game.getPiperXLocation() > 0.615 * WIN_WIDTH) {
                            game.nextLevel();
                            BattleWindow battle = new BattleWindow();
                            battle.fight(1, primaryStage, game);
                            music.pause();
                        }
                        break;
                    case (8):
                        drawLevel();
                    	music.play();
                        if (game.getPiperXLocation() < 0.12 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (9):
                        drawLevel();
                        if ((game.getPiperXLocation() > 0.33 * WIN_WIDTH)
                                || (game.getPiperXLocation() < -0.2 * WIN_WIDTH)) {
                            BattleWindow battle = new BattleWindow();
                            battle.fight(2, primaryStage, game);
                            game.nextLevel();
                            music.pause();
                        }
                        break;
                    case (10):
                        drawLevel();
                    	music.play();
                        if (game.getPiperXLocation() > 1.2 * WIN_WIDTH) {
                            game.nextLevel();
                        }
                        break;
                    case (11):
                        drawLevel();
                        if (game.getPiperXLocation() < 0.67 * WIN_WIDTH) {
                            e.getIC().getChild1Img().getPic().relocate(
                                    game.getPiperXLocation()
                                    + 0.05 * WIN_WIDTH, Illustration.CHILDY);
                        }
                        if (game.getPiperXLocation() < 0.25 * WIN_WIDTH) {
                            e.getIC().getChild2Img().getPic().relocate(
                                    game.getPiperXLocation()
                                    + 0.10 * WIN_WIDTH, Illustration.CHILD2Y);
                        }
                        if (game.getPiperXLocation() < - 1100) {
                            switch (event.getCode()) {
                                case Y:
                                    EndAnimation animation = new EndAnimation();
                                    animation.endAnimation();
                                    primaryStage.close();
                            }
                        }

                } // end switch

                // Switch handles the keyboard input, which changes the position
                // of piperImg. Game can be ended with the Escape key.
                double xAdjust = 0.015 * WIN_WIDTH;
                switch (event.getCode()) {

                    case LEFT:
                        // Start clock if it isn't running
                        if (clock.isRunning() == false) {
                            clock.resumeClock();
                        }

                        if (game.getPiperXLocation() > -1299) {
                            game.setPiperXLocation(game.getPiperXLocation() - xAdjust);
                            e.getIC().getPiperImg().movePic(game.getPiperXLocation());
                            e.getIC().getPiperImg().setScale(-Illustration.DOUBLE_SCALE);

                            // If the canvas isn't max left and the piper moves
                            // to left then shift canvas to the left
                            if ((canvasLayout > -2736)
                                    && (game.getPiperXLocation() < 90)) {

                                canvasLayout -= xAdjust;
                                canvas1.setLayoutX(canvasLayout);
                            }

                            // If the canvas is shifted to the right and moves 
                            // toward the center then shift canvas to the left
                            if ((canvasLayout > -1348)
                                    && (game.getPiperXLocation() < 2000)) {

                                canvasLayout -= xAdjust;
                                canvas1.setLayoutX(canvasLayout);
                            }

                        }
                        break;
                    case RIGHT:
                        // Start clock if it isn't running
                        if (clock.isRunning() == false) {
                            clock.resumeClock();
                        }
                        if (game.getPiperXLocation() < 1800) {
                            game.setPiperXLocation(game.getPiperXLocation() + xAdjust);
                            e.getIC().getPiperImg().movePic(game.getPiperXLocation());
                            e.getIC().getPiperImg().setScale(Illustration.DOUBLE_SCALE);

                            // If the canvas isn't max right and the piper moves 
                            // into right part of screen --> shift canvas to right
                            if ((canvasLayout < -100)
                                    && (game.getPiperXLocation() > 1224)) {

                                canvasLayout += xAdjust;
                                canvas1.setLayoutX(canvasLayout);
                            }

                            // If the canvas is shifted to the left and moves 
                            // toward the center shift canvas to the right
                            if ((canvasLayout < -1368)
                                    && (game.getPiperXLocation() > -800)) {

                                canvasLayout += xAdjust;
                                canvas1.setLayoutX(canvasLayout);
                            }
                        }
                        break;
                    case ESCAPE:
                        PauseMenu pause = new PauseMenu();
                        //PauseMenu pause = new PauseMenu(clock);
                         {
                            try {
                                clock.setRunning(false);
                                pause.pauseMenu();
                            } catch (Exception ex) {
                            }
                        }
                        break;
                    case Q:
                        primaryStage.close();

                        clock.setRunning(false);
                        Thread.currentThread().interrupt();

                } // end switch

            } // end handle

        }); // end EventHandler

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    } // end MainGame

} // end GUIHandler

