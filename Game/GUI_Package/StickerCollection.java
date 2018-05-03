package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       StickerCollection.java 
 * Purpose:     This class creates stickers for the text, objectives, and 
 *              multiple "speeches" made throughout the game.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import static GUI_Package.Illustration.*;

public class StickerCollection {

    // Define the three Stickers used throughout the game
    private final Sticker textOutput;
    private final Sticker objectiveLabel;
    private final Sticker speechLabel;

    /**
     * Constructor initializes the Stickers and sets their x-y coordinates
     */
    public StickerCollection() {

        this.textOutput = new Sticker(TEXTX, TEXTY);
        this.objectiveLabel = new Sticker(ORIGIN, ORIGIN);
        this.speechLabel = new Sticker(SPEACHX, SPEACHY);

    } // end constructor

    /**
     * Retrieves the Sticker object - "textOutput"
     *
     * @return textOuput of type Sticker
     */
    public Sticker getTextOutput() {

        return textOutput;

    } // end getTextOutput

    /**
     * Retrieve the Sticker object - "objectLabel"
     *
     * @return type Sticker
     */
    public Sticker getObjectiveSticker() {
        return objectiveLabel;
    }

    /**
     * Retrieves the Sticker object - "speechLabel"
     *
     * @return
     */
    public Sticker getSpeechSticker() {
        return speechLabel;
    }

} // end StickerCollection class
