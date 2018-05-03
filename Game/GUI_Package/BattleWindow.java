package GUI_Package;

/**
 * 		Final Project, CPSC 233
 * Class:       BattleWindow.java
 * Purpose:     The purpose of this class is to create an environment for the 
 *              main character (the Pied Piper) to fight against an enemy  
 *              (The rat or mayor).
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import Data_Package.ButtonsAndText;
import Data_Package.Enemy;
import Data_Package.PiedPiper;
import Data_Package.PiedPiperGame;
import GUI_Package.MainMenu;
import javafx.scene.shape.Rectangle;
import javafx.stage.StageStyle;

public class BattleWindow {

    // "Cooldown" is used so your special attack can only be used every three turns.
    private int cooldown = 0;
    private ImageView sprite = new ImageView();
    private static MediaPlayer battleMusic;
    
    /**
     * Sets the media player the same as the one created in the MainMenu class.
     *
     * @param player of type MediaPlayer
     */
    public static void setMusic(MediaPlayer player)
    {
    	battleMusic = player;
    }

    /**
     * Method draws the enemy depending if it is the rat or mayor.
     *
     * @param pic of type Image.
     * @param fight of type int.
     * @return of type ImageView
     */
    public ImageView drawEnemySprite(Image pic, int fight) {

        ImageView sprite = new ImageView(pic);

        if (fight == 1)//Rat sprite
        {
            sprite.setTranslateX(500);
            sprite.setTranslateY(95);
            sprite.setScaleX(-1);
            return sprite;
        } else //Mayor sprite
        {
            sprite.setTranslateX(500);
            sprite.setTranslateY(85);
            sprite.setScaleX(-1.5);
            sprite.setScaleY(1.5);
            return sprite;
        }

    } // end drawEnemySprite

    /**
     * Method is responsible for the GUI display for the fight with the rat.
     *
     * @param fight of type int.
     * @param GUIStage of type Stage
     * @param game of type PiedPiperGame
     */
    public void fight(int fight, Stage GUIStage, PiedPiperGame game) {
        
    	//plays music for the battles.
    	//Music from: https://youtu.be/R_uv35rKyFY
        battleMusic = MainMenu.musicPlayer("Game/BattleMusic.mp3"); 

        Stage primaryStage = new Stage();
        Stage stage_GUI = GUIStage;

        // Creating the Pied Piper object to p track of inventory/health/cooldowns
        PiedPiper piedPiper = new PiedPiper();
        piedPiper.updateHealth(game.getHealth());

        // Creating the Enemy Rat object for the same reason.
        Enemy enemy = new Enemy();
        GameOverAnimation gameOver = new GameOverAnimation();

        // IMAGES
        // Background image (Sky+Clouds)
        Image backdropImage = new Image("Pictures/backDropLarge.png");
        ImageView backdrop = new ImageView(backdropImage);
        backdrop.toBack();
        backdrop.setFitHeight(400);
        backdrop.setFitWidth(1366);
        backdrop.setScaleX(2);
        backdrop.setScaleY(2);
        backdrop.setTranslateY(-150);

        // Pied Piper Sprite (The little guy that runs around)
        Image piperImage = new Image("Pictures/piper.png");
        ImageView piperSprite = new ImageView(piperImage);
        piperSprite.setTranslateX(-500);
        piperSprite.setTranslateY(100);
        piperSprite.setScaleX(1.5);
        piperSprite.setScaleY(1.5);

        if (fight == 1) {

            // Enemy Rat Sprite (Ugly rat on the right side of the screen)
            Image ratImage = new Image("Pictures/rat.png");
            sprite = drawEnemySprite(ratImage, fight);

        } else {

            // Mayor Enemy Sprite
            Image mayorImage = new Image("Pictures/mayor.png");
            sprite = drawEnemySprite(mayorImage, fight);

        } // end if-else

        // TEXT OBJECTS
        // Enemy Health Text
        Text enemyHealth = ButtonsAndText.getText("Health: " + enemy.getHealth(), 5);
        enemyHealth.setTranslateX(455);
        enemyHealth.setTranslateY(260);

        // Pied Piper Health Text
        Text piperHealth = ButtonsAndText.getText("Health: " + piedPiper.getHealth(), 5);
        piperHealth.setTranslateX(-445);
        piperHealth.setTranslateY(260);

        // "Fight" Banner Text
        Text fightText = ButtonsAndText.getText("Fight!", 6);
        fightText.setTranslateX(0);
        fightText.setTranslateY(-305);

        // Run Away Text
        Text runAwayText = ButtonsAndText.getText("", 5);
        runAwayText.setVisible(false);

        // Potion Amount Text
        Text potionText = ButtonsAndText.getText("You have " + piedPiper.getPotions()
                + " potions.", 7);
        potionText.setTranslateX(-80);
        potionText.setTranslateY(260);

        // Winning Banner Text
        Text winningText = ButtonsAndText.getText("You are victorious!", 8);
        winningText.setVisible(false);

        // RECTANGLES FOR HEALTH AND HUD
        Rectangle fightRectangle = ButtonsAndText.getRectangle(0, 300, 80, 0, -300);
        Rectangle healthRectangle = ButtonsAndText.getRectangle(1, 375, 50, -445, 260);
        Rectangle potionRectangle = ButtonsAndText.getRectangle(1, 300, 50, -80, 260);
        Rectangle enemyHealthRectangle = ButtonsAndText.getRectangle(1, 375, 50, 445, 260);
        Rectangle grassBlock = ButtonsAndText.getRectangle(2, 1366, 50, 0, 200);
        Rectangle hudBlock = ButtonsAndText.getRectangle(3, 1380, 175, 0, 296);

        // FIGHT BUTTONS
        Button fightButton = ButtonsAndText.getButton("Fight", 2, 0, 0);
        Button quickButton = ButtonsAndText.getButton("Quick Attack", 2, 0, 0);
        Button heavyButton = ButtonsAndText.getButton("Heavy Attack", 2, 0, 0);
        Button specialButton = ButtonsAndText.getButton("Special Attack", 2, 0, 0);
        Button inventoryButton = ButtonsAndText.getButton("Inventory", 2, 0, 0);

        Button potionButton = ButtonsAndText.getButton("Use Potion", 2, -310, 331);
        potionButton.setVisible(false);

        // EXIT BUTTON
        Button exitButton = ButtonsAndText.getButton("Exit", 2, 500, 330);
        exitButton.setVisible(false);

        // HBOX AND VBOX
        // "Main" HBox (Contains the fight, inventory, and run buttons)
        HBox mainHBox = new HBox(120, fightButton, inventoryButton); //, runButton);
        mainHBox.setTranslateX(100);
        mainHBox.setTranslateY(700);

        // Specific Attacks (Contains the quick attack, heavy, and special buttons)
        HBox fightHBox = new HBox(110, quickButton, heavyButton, specialButton);
        fightHBox.setTranslateX(750);
        fightHBox.setTranslateY(700);
        fightHBox.setVisible(false);

        // Putting it all together
        StackPane root = new StackPane();
        root.getChildren().addAll(backdrop, grassBlock, hudBlock, piperSprite,
                sprite, mainHBox, fightHBox, fightRectangle, healthRectangle,
                enemyHealthRectangle, fightText, runAwayText, piperHealth,
                enemyHealth, exitButton, winningText, potionRectangle,
                potionText, potionButton);

        // BUTTON ACTIONS
        // INVENTORY Button Action - This button will open up the Pied Piper's 
        // inventory so that he can heal using a health potion.
        inventoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                potionText.setText("You have " + piedPiper.getPotions()
                        + " potions.");
                mainHBox.setVisible(false);
                potionButton.setVisible(true);

            } // end handle
        });

        // POTIONS Button Action  -  This button uses Piper's turn to heal himself 
        // but that means he will still be hit by the enemy. On click, it first 
        // checks if you have any potions left. Then if you do have potions it 
        // will heal and take One away from the total (that number is stored in 
        // the Pied Piper Class)
        potionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                potionText.setText("You have " + piedPiper.getPotions()
                        + " potions.");

                if (piedPiper.getPotions() > 0) {

                    piedPiper.healPiper();
                    piperHealth.setText("Health: " + piedPiper.getHealth());
                    potionText.setText("You have " + piedPiper.getPotions()
                            + " potions.");
                    piedPiper.damagePiper(enemy.ratATK(1));
                    piperHealth.setText("Health: " + piedPiper.getHealth());
                    potionText.setText("You have " + piedPiper.getPotions()
                            + " potions.");

                }
                potionButton.setVisible(false);
                mainHBox.setVisible(true);

            } // end handle
        });

        // EXIT Button Action - Pretty straight forward, when you click it will 
        // just close the battle.
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            	battleMusic.stop();
                primaryStage.close();
                game.setHealth(piedPiper.getHealth());

            } // end handle
        });

        // FIGHT Action Button - This buttons will close all other buttons and 
        // bring up the 3 options you will have for attacking.
        fightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                fightHBox.setVisible(true);
                mainHBox.setVisible(false);
                game.setHealth(piedPiper.getHealth());

            } // end handle
        });

        // QUICK ATTACK Button Action - This button makes Pied Piper do a quick 
        // attack. In short, this attack does less damage but you will also be 
        // less vulnerable to an attack from the enemy.
        quickButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (cooldown > 0) {
                    cooldown--;
                }

                enemy.damageRat(piedPiper.piperATK(1));
                enemyHealth.setText("Health:" + enemy.getHealth());

                if (enemy.isAlive() == true) {

                    piedPiper.damagePiper(enemy.ratATK(1));

                    if (piedPiper.isAlive() == false) {

                    	battleMusic.stop();
                        gameOver.gameOver();
                        primaryStage.close();
                        stage_GUI.close();

                    } else {
                        piperHealth.setText("Health: " + piedPiper.getHealth());
                    } // end nested if-else

                } else {

                    winningText.setVisible(true);
                    exitButton.setVisible(true);
                    root.getChildren().remove(mainHBox);

                } // end if-else

                mainHBox.setVisible(true);
                fightHBox.setVisible(false);
                game.setHealth(piedPiper.getHealth());

            } // end handle
        });

        // HEAVY ATTACK Button Action - This button makes Pied Piper do a heavy 
        // attack. That means you will do more damage but will be vulnerable to 
        // more damage. Same as quick attack in regards to cooldown.
        heavyButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (cooldown > 0) {
                    cooldown--;
                }

                enemy.damageRat(piedPiper.piperATK(2));
                enemyHealth.setText("Health:" + enemy.getHealth());

                if (enemy.isAlive() == true) {

                    piedPiper.damagePiper(enemy.ratATK(2));

                    if (piedPiper.isAlive() == false) {

                    	battleMusic.stop();
                        gameOver.gameOver();
                        primaryStage.close();
                        stage_GUI.close();

                    } else {
                        piperHealth.setText("Health: " + piedPiper.getHealth());
                    } // end nested if-else

                } else {
                	
                    winningText.setVisible(true);
                    exitButton.setVisible(true);
                    root.getChildren().remove(mainHBox);

                } // end if-else

                mainHBox.setVisible(true);
                fightHBox.setVisible(false);
                game.setHealth(piedPiper.getHealth());

            } // end handle
        });

        // SPECIAL ATTACK Button Action - This attack does a lot more damage 
        // than the other two types but will leave you open to taking more damage
        // like the heavy attack. This move may only be used once every three 
        // turns. This is managed through the use of the cooldown instance variable.
        specialButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (cooldown == 0) {

                    enemy.damageRat(piedPiper.piperATK(3));
                    enemyHealth.setText("Health:" + enemy.getHealth());

                    if (enemy.isAlive() == true) {

                        piedPiper.damagePiper(enemy.ratATK(3));
                        if (piedPiper.isAlive() == false) {

                        	battleMusic.stop();
                            gameOver.gameOver();
                            primaryStage.close();
                            stage_GUI.close();

                        } else {
                            piperHealth.setText("Health: " + piedPiper.getHealth());
                        } // end nested if-else

                    } else {

                        winningText.setVisible(true);
                        exitButton.setVisible(true);
                        root.getChildren().remove(mainHBox);

                    } // end if-else

                    cooldown = 3;
                } // end if

                mainHBox.setVisible(true);
                fightHBox.setVisible(false);
                game.setHealth(piedPiper.getHealth());

            } // end handle
        });

        primaryStage.setScene(new Scene(root, 1366, 768));
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    } // end fight

} // end BattleWindow
