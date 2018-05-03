package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       Drawables.java 
 * Purpose:     This class is used to place and relocate images and anything 
 *              that has been drawn for the stages.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import static GUI_Package.GUIHandler.WIN_HEIGHT;
import static GUI_Package.GUIHandler.WIN_WIDTH;

public abstract class Drawables {

    private double xPosition;
    private double yPosition;

    /**
     * Constructor initializes x and y positions of the object. Setters check
     * the validity of the parameters.
     *
     * @param xcoor of type double
     * @param ycoor of type double
     */
    public Drawables(double xcoor, double ycoor) {

        setXPosition(xcoor);
        setYPosition(ycoor);

    } // end constructor

    /**
     * Retrieves values of xPosition
     *
     * @return xPosition of type double
     */
    public final double getxPosition() {

        return xPosition;

    } // end getxPosition

    /**
     * Retrieves the value of yPosition
     *
     * @return yPosition of type double
     */
    public final double getyPosition() {

        return yPosition;

    } // end getyPosition

    /**
     * Sets the value of xPosition
     *
     * @param xPosition of type double
     */
    public final void setXPosition(double xPosition) {

        // If x-coordinate is in the bounds of the game window
        if ((xPosition > -0.95 * WIN_WIDTH) && (xPosition < 1.33 * WIN_WIDTH)) {
            this.xPosition = xPosition;
        }

    } // end setXPosition

    /**
     * Sets the value of yPosition
     *
     * @param yPosition of type double
     */
    public final void setYPosition(double yPosition) {

        // If y-coordinate is in the bounds of the game window
        if ((yPosition > 0) && (yPosition < WIN_HEIGHT)) {
            this.yPosition = yPosition;
        }

    } // end setYPosition

} // end abstract class Drawables
