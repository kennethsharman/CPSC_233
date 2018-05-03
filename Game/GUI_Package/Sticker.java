package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       Sticker.java 
 * Purpose:     Class is responsible for defining the objects that contain the
 *              text output in the GUIHandler class.
 *              The class is a wrapper for Label objects..
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Sticker extends Drawables {

    // Label object is the base of the class 
    private final Label label;

    /**
     * Constructor initializes Label object and sets the x and y positions.
     *
     * @param xcoor of type double
     * @param ycoor of type double
     */
    public Sticker(double xcoor, double ycoor) {

        // Call to super class sets x-y positions
        super(xcoor, ycoor);
        this.label = new Label();
        this.label.relocate(xcoor, ycoor);

    } // end constructor

    /**
     * Method uses setter methods defined in parent class to set x-y positions.
     * Validity of the parameters are checked in the setter method itself.
     *
     * @param xcoor of type double
     * @param ycoor of type double
     */
    public void relocateSticker(double xcoor, double ycoor) {

        this.setXPosition(xcoor);
        this.setYPosition(ycoor);
        this.label.relocate(xcoor, ycoor);

    } // end relocateSticker

    /**
     * Method sets the value of the text associated with the Sticker object.
     *
     * @param text of type String
     */
    public void setText(String text) {

        this.label.setText(text);

    } // end setText

    /**
     * Method is used to either hide, or show, the text associated with the
     * Sticker. Used extensively when level changes occur in the game.
     *
     * @param visible of type boolean
     */
    public void setVisible(boolean visible) {

        this.label.setVisible(visible);

    } // end SetVisible

    /**
     * Method sets the font style and size for the text displayed by the
     * Sticker. No action if size is less than or equal to zero.
     *
     * @param font of type String
     * @param size of type int
     */
    public void setFont(String font, int size) {

        if (size > 0) {
            this.label.setFont(Font.font(font, size));
        }

    } // end setFont

    /**
     * Retrieves the Label object associated with this Sticker.
     *
     * @return type Label
     */
    public Label getLabel() {

        return label;

    } // end getLabel

} // end class Sticker
