package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       GuiElements.java 
 * Purpose:     Class is responsible for providing an element of organization to
 *              the drawable objects used in the GUI.
 *              "The GUI has elements. The elements can be separated into 2
 *              groups; a collection of Images and a collection of Stickers."
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import Data_Package.PiedPiperGame;

public class GuiElements {

    // Define the collections
    private final ImageCollection img_collection;
    private final StickerCollection stkr_collection;

    /**
     * Constructor initializes the image and sticker collection objects
     *
     * @param game of type PiedPiper
     */
    public GuiElements(PiedPiperGame game) {

        this.img_collection = new ImageCollection(game);
        this.stkr_collection = new StickerCollection();

    } // end construstor

    /**
     * Retrieves the Image collection object
     *
     * @return of type ImageCollection
     */
    public ImageCollection getIC() {

        return img_collection;

    } // end getIC

    /**
     * Retrieves the Sticker collection object
     *
     * @return of type StickerCollection
     */
    public StickerCollection getSC() {

        return stkr_collection;

    } // end getSC

} // end GuiElements
