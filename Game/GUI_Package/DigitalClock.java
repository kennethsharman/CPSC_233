package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       DigitalClock.java 
 * Purpose:     This class creates the clock in the upper right corner of the
 *              screen. Has methods to check if the pause menu has been closed
 * 		and then it resumes the timer.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import Data_Package.PiedPiperGame;
import java.text.DecimalFormat;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

class DigitalClock extends Parent {

    private final int boxHeight = 10;
    private final int boxWidth = boxHeight * 5 / 8;
    private final int scale = 5;
    private final Font FONT = new Font(10 * scale);
    private final HBox hbox = new HBox();
    private final Text[] digits = new Text[3];
    private final Group[] digitsGroup = new Group[3];
    private boolean running = false;

    // Define game variable that is passed to constructor
    PiedPiperGame game;

    /**
     * Constructor calls two methods to initialize the GUI components of the
     * clock.
     *
     * @param pGame of type PiedPiperGame
     */
    public DigitalClock(PiedPiperGame pGame) {

        this.game = pGame;
        configureDigits();
        configureHBox();
        getChildren().add(hbox);

    } // end constructor

    /**
     * Retrieves the value of running which indicates if the clock is running.
     *
     * @return type boolean
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Sets the value of running, which decides if the clock is running or
     * paused.
     *
     * @param running of type boolean
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Method adds each of the clocks digits to an HBox
     */
    private void configureHBox() {

        hbox.getChildren().addAll(digitsGroup);
        hbox.setSpacing(0);

    } // end configureHBox

    /**
     * Method sets text, font, and positioning of each of the clocks digits
     */
    private void configureDigits() {

        for (int i = 0; i < digits.length; i++) {

            digits[i] = new Text("0");
            digits[i].setFont(FONT);
            digits[i].setTextOrigin(VPos.TOP);
            digits[i].setLayoutY(-10);

            // Add a rectangle background for each digit
            Rectangle bg = createBackground(Color.BLACK, Color.BLACK);

            // Color digit red
            digits[i].setFill(Color.RED);

            // add each digit to a group
            digitsGroup[i] = new Group(bg, digits[i]);

        } // end for block

    } // end configureDigits 

    /**
     * Method creates a rectangle to be used as background for a single digit of
     * the clock
     *
     * @param fill of type Color
     * @param stroke of type color
     * @return type Rectangle
     */
    private Rectangle createBackground(Color fill, Color stroke) {

        Rectangle bg = new Rectangle(boxWidth * scale, boxHeight * scale, fill);
        bg.setStroke(stroke);
        bg.setStrokeWidth(3);

        return bg;

    } // end createBackground

    /**
     * Method sets the digits to represent a specific number
     *
     * @param number of type String
     */
    public void refreshDigits(String number) {

        for (int i = 0; i < digits.length; i++) {

            digits[i].setText(number.substring(i, i + 1));

        }

    } // end refreshDigits

    /**
     * Method makes the clock run. This is done over the course of 1 second.
     */
    protected void runClock() {

        running = true;

        new Thread() {
            @Override
            public void run() {

                long last = System.nanoTime();
                double delta = 0;
                double ns = 1000000000.0;

                while (isRunning()) {

                    long now = System.nanoTime();
                    delta += (now - last) / ns;
                    last = now;

                    while (delta > 1) {

                        game.setCount(game.getCount() + 1);
                        DecimalFormat df = new DecimalFormat("000");
                        refreshDigits(df.format(game.getCount()));
                        delta--;

                    } // end inner while loop

                } // end outer while loop

            }// end run

        }.start();

    } // end runClock

    /**
     * Method resumes the running of the clock, after a period a pause.
     */
    public void resumeClock() {

        running = true;
        runClock();

    } // end resumeClock

} // end class DigitalClock
