package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       Illustration.java 
 * Purpose:     This class creates all the image variables for the game.This 
 *              gets the images, draws the images, moves them, sets the scale 
 *              and changes visibility.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import static GUI_Package.GUIHandler.WIN_HEIGHT;
import static GUI_Package.GUIHandler.WIN_WIDTH;
import javafx.scene.image.ImageView;

public class Illustration extends Drawables {

    // // ImageView object is the base of the class
    private final ImageView pic;

    // File location of the picture used as image
    private final String fileLocation;

    // Define all locations of the images as constants
    protected static final double RATX = 0.7 * WIN_WIDTH;
    protected static final double RATY = 0.67 * WIN_HEIGHT;
    protected static final double PEASX = 0.8 * WIN_WIDTH;
    protected static final double PEASY = 0.65 * WIN_HEIGHT;
    protected static final double VILLAGERX = -0.4 * WIN_WIDTH;
    protected static final double VILLAGERY = 0.63 * WIN_HEIGHT;
    protected static final double MAYORX = 0.04 * WIN_WIDTH;
    protected static final double MAYORY = 0.65 * WIN_HEIGHT;
    protected static final double SML_RAT1X = RATX - 0.68 * WIN_WIDTH;
    protected static final double SML_RAT1Y = RATY + 0.20 * WIN_HEIGHT;
    protected static final double SML_RAT2X = RATX - 0.48 * WIN_WIDTH;
    protected static final double SML_RAT2Y = RATY + 0.19 * WIN_HEIGHT;
    protected static final double SML_RAT3X = RATX - 0.35 * WIN_WIDTH;
    protected static final double SML_RAT3Y = RATY + 0.16 * WIN_HEIGHT;
    protected static final double SML_RAT4X = RATX + 0.20 * WIN_WIDTH;
    protected static final double SML_RAT4Y = RATY + 0.17 * WIN_HEIGHT;
    protected static final double SML_RAT5X = RATX + 0.10 * WIN_WIDTH;
    protected static final double SML_RAT5Y = RATY + 0.17 * WIN_HEIGHT;
    protected static final double CHILDX = 0.5 * WIN_WIDTH;
    protected static final double CHILDY = 0.70 * WIN_HEIGHT;
    protected static final double CHILD2X = 0.1 * WIN_WIDTH;
    protected static final double CHILD2Y = 0.72 * WIN_HEIGHT;
    protected static final double FLOWER1X = 0.3 * WIN_WIDTH;
    protected static final double FLOWER1Y = 0.62 * WIN_HEIGHT;
    protected static final double FLOWER2X = 0.5 * WIN_WIDTH;
    protected static final double FLOWER2Y = 0.73 * WIN_HEIGHT;
    protected static final double BUBBLEX = 0.06 * WIN_WIDTH;
    protected static final double BUBBLEY = 0.32 * WIN_HEIGHT;
    protected static final double SINGLE_SCALE = 1.0;
    protected static final double DOUBLE_SCALE = 2.0;
    protected static final double SMALL_SCALE = 0.3;
    protected static final double TEXTX = 0.12 * WIN_WIDTH;
    protected static final double TEXTY = 0.48 * WIN_HEIGHT;
    protected static final double SPEACHX = 0.72 * WIN_WIDTH;
    protected static final double SPEACHY = 0.31 * WIN_HEIGHT;
    protected static final double ORIGIN = 0.0;

    /**
     * Constructor initializes the instance variables of the Illustration
     *
     * @param file of type String
     * @param xcoor of type double
     * @param ycoor of type double
     * @param xScale of type double
     * @param yScale of type double
     */
    public Illustration(String file, double xcoor, double ycoor,
            double xScale, double yScale) {

        // Call to super class sets x-y coordinates
        super(xcoor, ycoor);

        // Object is created from a picture file
        this.fileLocation = file;
        this.pic = new ImageView(fileLocation);

        // Relocate the object to x-y coordinates
        this.pic.relocate(xcoor, ycoor);

        // Set scale and visibility of object
        pic.setScaleX(xScale);
        pic.setScaleY(yScale);
        pic.setVisible(false);

    } // end constructor

    /**
     * Retrieves the ImageView object
     *
     * @return pic of type ImageView
     */
    public ImageView getPic() {

        return pic;

    } // end getPic

    /**
     * Sets the visibility of the Illustration
     *
     * @param visible of type boolean
     */
    public void setVisible(boolean visible) {

        pic.setVisible(visible);

    } // end setVisible

    /**
     * Sets the scale of the illustration
     *
     * @param scale
     */
    public void setScale(double scale) {

        // Check to see if the scale is reasonable
        if (scale < 10.0) {
            pic.setScaleX(scale);
        }

    } // end setScale

    /**
     * Sets the x-y coordinates and visibility of the Illustrations
     *
     * @param xcoor of type double
     * @param ycoor of type double
     * @param visible of type boolean
     */
    public void drawPic(double xcoor, double ycoor, boolean visible) {

        this.setXPosition(xcoor);
        this.setYPosition(ycoor);
        this.setVisible(visible);
        this.pic.relocate(this.getxPosition(), this.getyPosition());

    } // end drawPic

    /**
     * Sets the x position of the Illustration
     *
     * @param xcoor of type double
     */
    public void movePic(double xcoor) {

        this.pic.relocate(xcoor, this.getyPosition());
        this.setXPosition(xcoor);

    } // end movePic

} // end class Illustration
