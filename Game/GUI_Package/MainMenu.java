package GUI_Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Data_Package.ButtonsAndText;
/**
 *              Final Project, CPSC 233
 * Class:       MainMenu.java
 * Purpose:     Creates the GUI for the main menu which is calls the GameGUI 
 *              class to start the game. Allows user to load their progress as 
 *              well as quitting the program.
 * 
 *              Menu picture source location:
 *              https://englishiscoolsite.wordpress.com/2017/03/20/story-the-pied-piper-of-hamelin/
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import Data_Package.PiedPiperGame;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainMenu extends Application {

	private MediaPlayer music;
	
    /**
     * Launches the start method and creates the new window for start.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The start method is the main structure of the program and calls on the
     * other methods in this class and the GameGUI class.
     *
     * @param primaryStage of type Stage.
     * @throws Exception if image is not found.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Sets background image for the pause menu
        InputStream is = Files.newInputStream(Paths.get("Game/Pictures/piedPiperBackground.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.toBack();
        imgView.setFitHeight(768);
        imgView.setFitWidth(1368);
        
        //plays music for the main part of the game.
        //Music from: https://youtu.be/8_5m4Q4rL1Q
        MediaPlayer player = musicPlayer("Game/MainMusic.mp3"); 
        setMusic(player);
        
        //Text displayed on the main menu
        Text title = ButtonsAndText.getText("Pied Piper: The Game", 3);

        //Buttons for the main menu
        //(Name, type, xCoordinate, yCoordinate)
        Button newGame = ButtonsAndText.getButton("NEW GAME", 1, 0, 0);
        Button loadGame = ButtonsAndText.getButton("LOAD GAME", 1, 0, 0);
        Button help = ButtonsAndText.getButton("HELP", 1, 0, 0);
        Button credits = ButtonsAndText.getButton("CREDITS", 1, 0, 0);
        Button quit = ButtonsAndText.getButton("QUIT", 1, 0, 0);

        //Back buttons for the help and credits sub-menus
        Button back1 = ButtonsAndText.getButton("BACK", 0, 380, 25);
        Button back2 = ButtonsAndText.getButton("BACK", 0, 300, 175);

        //Contains main menu buttons
        VBox vBox = new VBox(25, newGame, loadGame, help, credits, quit);
        vBox.relocate(1150, 465);

        //Contains main menu title
        VBox vBox2 = new VBox(25, title);
        vBox2.setTranslateX(10);

        //Contains help info and button
        VBox vBox3 = new VBox(50, Help(), back1);
        vBox3.setVisible(false);
        vBox3.relocate(260, 65);

        //Contains credits info and button
        VBox vBox4 = new VBox(50, Credits(), back2);
        vBox4.setVisible(false);
        vBox4.relocate(350, 0);

        Group root = new Group();
        root.getChildren().addAll(imgView, vBox, vBox2, vBox3, vBox4);
        Scene scene = new Scene(root, 1368, 768);

        //Starts the main section of the game
        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PiedPiperGame game = new PiedPiperGame();
                PauseMenu.setPiperGame(game);
                BattleWindow.setMusic(music);
                GUIHandler.setMusic(music);
                GUIHandler gameGraphics = new GUIHandler(game, true);
                gameGraphics.mainGame();

            } // end handle
        });

        //Sends it to the sub-menu for the load game feature
        loadGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                try {

                    FileChooser loadFile = new FileChooser();
                    FileChooser.ExtensionFilter extFilter
                            = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                    loadFile.getExtensionFilters().add(extFilter);
                    loadFile.setTitle("Load Game File");
                    
                    //Opens the window directly to game file location
                    //loadFile.setInitialDirectory(new File("C:/Users/bking/OneDrive/Documents/School 2017-2018/CPSC 233/FinalProject(FINAL)"));
                    File file = loadFile.showOpenDialog(primaryStage);

                    // Create new Game and GameGUI
                    PiedPiperGame game = new PiedPiperGame(file);
                    PauseMenu.setPiperGame(game);
                    BattleWindow.setMusic(music);
                    GUIHandler.setMusic(music);
                    GUIHandler gameGraphics = new GUIHandler(game, false);
                    gameGraphics.mainGame();

                } catch (FileNotFoundException e) {
                	System.out.println("File not found, please select a different file");
                }

            } // end handle
        });

        //Sends it to the sub-menu for the help info
        help.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {

                    vBox.setVisible(false);
                    vBox2.setVisible(false);
                    vBox3.setVisible(true);

                    imgView.setEffect(new GaussianBlur());
                    imgView.setOpacity(0.5);

                } catch (Exception e) {
                }

            } // end handle
        });

        //Sends it to the sub-menu for the credits info
        credits.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {

                    vBox.setVisible(false);
                    vBox2.setVisible(false);
                    vBox4.setVisible(true);

                    imgView.setEffect(new GaussianBlur());
                    imgView.setOpacity(0.5);

                } catch (Exception e) {
                }

            } // end handle
        });

        //Closes the program
        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });

        //Returns to the main menu from help
        back1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                vBox.setVisible(true);
                vBox2.setVisible(true);
                vBox3.setVisible(false);

                imgView.setEffect(null);
                imgView.setOpacity(1);

            } // end handle
        });

        //Returns to the main menu from credits
        back2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                vBox.setVisible(true);
                vBox2.setVisible(true);
                vBox4.setVisible(false);

                imgView.setEffect(null);
                imgView.setOpacity(1);

            } // end handle
        });

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }//End of start

    /**
     * The Help method that displays the text and back button for the help
     * section of the menu.
     *
     * @return of type VBox
     * @throws Exception
     *
     */
    public static VBox Help() throws Exception {

        //Creates the text for the help screen so that it can be added with Text.
        String note = ("CONTROLS/OBJECTIVES\n");
        String note2 = ("Use the arrow keys to move around.\n\n"
                + "Gain objectives by progressing and interacting with characters.\n\n"
                + "Choose one of multiple attacks, heal or run away from the rats.\n"
                + "Each attack deals different amounts of damage.\n\n"
                + "Press the escape (esc) key to access the pause menu at any time.\n"
                + "Press the Q key to quit the game at any time.\n\n"
                + "Load or save your game progress at any time from the pause menu.");

        Text line1 = ButtonsAndText.getText(note, 0);
        Text line2 = ButtonsAndText.getText(note2, 1);

        VBox vBox = new VBox(25, line1, line2);
        vBox.setAlignment(Pos.CENTER);
        vBox.relocate(75, 65);

        return vBox;

    }//End of Help

    /**
     * The Credits method that displays the text and back button for the credits
     * section of the menu.
     *
     * @return vBox of type VBox
     * @throws java.lang.Exception
     */
    public VBox Credits() throws Exception {

        String title = "CREDITS\n";
        String creditInfo = ("DEVELOPERS: Garrett D. || Bruin K. || Ken S.\n\n"
                + "GROUP: T01-3\n\n" + "CLASS: COMPUTER SCIENCE 233\n\n"
                + "UNIVERSITY OF CALGARY");

        Text line1 = ButtonsAndText.getText(title, 0);
        Text line2 = ButtonsAndText.getText(creditInfo, 4);

        VBox vBox = new VBox(25, line1, line2);
        vBox.setTranslateY(50);
        vBox.setAlignment(Pos.CENTER);

        return vBox;

    }//End of Credits
    
    /**
     * Creates the player for the music for the entire game except for the battles.
     *
     * @return player of type MediaPlayer
     */
    public static MediaPlayer musicPlayer(String music)
    {
    	File source = new File(music);
    	Media media = new Media(source.toURI().toString());
    	MediaPlayer player = new MediaPlayer(media);
    	player.setCycleCount(MediaPlayer.INDEFINITE);
    	player.setAutoPlay(true);
    	
		return player;  			
    }//End musicPlayer
    
    /**
     * Sets the music for the different parts of the game.
     *
     * @param music of type MediaPlayer
     */
    public void setMusic(MediaPlayer music)
    {
    	this.music = music;
    }

}//End of MainMenu
