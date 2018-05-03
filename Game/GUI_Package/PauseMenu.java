package GUI_Package;

/**
 *              Final Project, CPSC 233
 * Class:       PauseMenu.java
 * Purpose:     Creates the GUI for the pause menu which is called
 * 				from the class GameGUI. Allows user to load and save
 * 				their progress as well as quitting the program.
 * 
 * 				Menu picture source location:
 *              https://englishiscoolsite.wordpress.com/2017/03/20/story-the-pied-piper-of-hamelin/
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import Data_Package.ButtonsAndText;
import Data_Package.PiedPiperGame;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PauseMenu {

    static PiedPiperGame game;

    /**
     * The setPiperGame method sets the game from the MainMenu class so that it
     * can call the values from the PiedPiperGame class for the saveFile method.
     *
     * @param piperGame of type PiedPiperGame
     */
    public static void setPiperGame(PiedPiperGame piperGame) {
        game = piperGame;
    }

    /**
     * The pauseMenu method is the main structure of the pause menu that
     * contains the sub-menus and incorporates load/save.
     *
     * @throws Exception if image is not found.
     */
    public void pauseMenu() throws Exception {

        Stage primaryStage = new Stage();

        //Sets background image for the pause menu
        InputStream is = Files.newInputStream(Paths.get("Game/Pictures/piedPiperBackground.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.toBack();
        imgView.setFitHeight(768);
        imgView.setFitWidth(1368);
        imgView.setEffect(new GaussianBlur());
        imgView.setOpacity(0.5);

        //Title displayed on pause menu
        Text title = ButtonsAndText.getText("PAUSED", 0);
        title.setTranslateX(370);

        //Buttons for the main part of the pause menu.
        //(Name, type, xCoordinate, yCoordinate)
        Button resume = ButtonsAndText.getButton("RESUME", 0, 0, 0);
        Button loadGame = ButtonsAndText.getButton("LOAD GAME", 0, 0, 0);
        Button saveGame = ButtonsAndText.getButton("SAVE GAME", 0, 0, 0);
        Button help = ButtonsAndText.getButton("HELP", 0, 0, 0);
        Button quit = ButtonsAndText.getButton("QUIT", 0, 0, 0);

        //Buttons in the sections of the pause menu.
        Button back = ButtonsAndText.getButton("BACK", 0, 450, 100);
        back.setTranslateX(400);

        //Contains the buttons for the pause menu
        VBox vBox = new VBox(50, resume, loadGame, saveGame, help, quit);
        vBox.setTranslateX(650);
        vBox.setTranslateY(200);

        //Contains the pause menu title
        VBox vBox2 = new VBox(25, title);
        vBox2.setTranslateX(205);
        vBox2.setTranslateY(15);

        //Contains the help info and button
        VBox vBox3 = new VBox(25, MainMenu.Help(), back);
        vBox3.setTranslateX(260);
        vBox3.setVisible(false);

        Group root = new Group();
        root.getChildren().addAll(imgView, vBox, vBox2, vBox3);
        Scene scene = new Scene(root, 1368, 768);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        //Returns back to the main game
        resume.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }

        });

        //Opens window for user to choose load game file location
        loadGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {

                    FileChooser loadFile = new FileChooser();
                    FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                    loadFile.getExtensionFilters().add(extFilter);
                    loadFile.setTitle("Load Game File");
                    
                    //Opens the window directly to game file location
                    //loadFile.setInitialDirectory(new File("C:/Users/bking/OneDrive/Documents/School 2017-2018/CPSC 233/FinalProject(FINAL)"));
                    File file = loadFile.showOpenDialog(primaryStage);

                    // Create new Game and GameGUI
                    PiedPiperGame game = new PiedPiperGame(file);
                    GUIHandler gameGraphics = new GUIHandler(game, false);
                    gameGraphics.mainGame();

                } catch (FileNotFoundException e) {
                	System.out.println("File not found, please select a different file");
                }

            } // end handle
        });

        //Opens window for user to choose save game file location
        saveGame.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                saveFile();
            }
        });

        //Sends it to the sub-menu for the help info
        help.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {

                    vBox.setVisible(false);
                    vBox2.setVisible(false);
                    vBox3.setVisible(true);

                } catch (Exception e) {
                }

            } // end handle
        });

        //Closes the program
        quit.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                // Thread used for clock is interrupted
                Thread.currentThread().interrupt();
                System.exit(0);

            } // end handle
        });

        //Returns to the pause menu
        back.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                vBox.setVisible(true);
                vBox2.setVisible(true);
                vBox3.setVisible(false);

            } // end handle
        });

    }//End of start

    /**
     * The saveFile method allows the user to save the information of the
     * current status of the game to a text file that can be used to load at a
     * later time. Takes the values and writes them to a text file. If the file
     * already exists, it deletes it and makes a new one.
     */
    public void saveFile() {

        try {

            File file = new File("SaveGame.txt");

            if (file.exists()) {
                file.delete();
            }

            BufferedWriter saveFile = new BufferedWriter(new FileWriter("SaveGame.txt"));

            saveFile.write(Integer.toString(game.getLevel()));
            saveFile.write(" ");
            saveFile.write(Integer.toString(game.getHealth()));
            saveFile.write(" ");
            saveFile.write(Integer.toString(game.getCount()));
            saveFile.write(" ");
            saveFile.write(Integer.toString(game.getPotions()));
            saveFile.write(" ");
            saveFile.write(Double.toString(game.getPiperXLocation()));

            saveFile.newLine();
            saveFile.write("#Level");
            saveFile.newLine();
            saveFile.write("#Health");
            saveFile.newLine();
            saveFile.write("#Time");
            saveFile.newLine();
            saveFile.write("#Potions");
            saveFile.newLine();
            saveFile.write("#XLocation");
            saveFile.close();

            System.out.println("GAME SAVED");
        } catch (IOException e) {
        }

    }// End of saveFile

} // End of PauseMenu
