package GUI_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       ImageCollection.java 
 * Purpose:     This class creates all the images for the game and organizes the
 *              movement for the rats after you defeat the big rat.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import Data_Package.PiedPiperGame;
import static GUI_Package.GUIHandler.WIN_HEIGHT;
import static GUI_Package.GUIHandler.WIN_WIDTH;
import static GUI_Package.Illustration.*;
import javafx.scene.image.Image;

public class ImageCollection {

    // Define game variable passed into constructor as a parameter
    private final PiedPiperGame gme;

    // Define all Illustrations used in GUI
    private final Illustration piperImg;
    private final Illustration peasantImg;
    private final Illustration villagerImg;
    private final Illustration textBubbleImg;
    private final Illustration ratImg;
    private final Illustration smallRat1Img;
    private final Illustration smallRat2Img;
    private final Illustration smallRat3Img;
    private final Illustration smallRat4Img;
    private final Illustration smallRat5Img;
    private final Illustration mayorImg;
    private final Illustration child1Img;
    private final Illustration child2Img;
    private final Illustration flower1Img;
    private final Illustration flower2Img;
    private final Image backGround = new Image("Pictures/backDropLarge.png");

    /**
     * Constructor initializes each of the Illustration objects used in GUI.
     *
     * @param game of type PiedPiperGame
     */
    public ImageCollection(PiedPiperGame game) {

        this.gme = game;

        // Set the Illustrations to appropriate picture, set x-y coordinates
        // and set scale
        this.piperImg = new Illustration("Pictures/piperPic.png", game.getPiperXLocation(),
                game.getPiperYLocation(), DOUBLE_SCALE, DOUBLE_SCALE);
        this.peasantImg = new Illustration("Pictures/townsfolk.png", PEASX,
                PEASY, DOUBLE_SCALE, DOUBLE_SCALE);
        this.villagerImg = new Illustration("Pictures/villager.png", VILLAGERX,
                VILLAGERY, DOUBLE_SCALE, DOUBLE_SCALE);
        this.textBubbleImg = new Illustration("Pictures/textBubble.png", BUBBLEX,
                BUBBLEY, SINGLE_SCALE, SINGLE_SCALE);
        this.ratImg = new Illustration("Pictures/angryRat.png", RATX, RATY,
                SINGLE_SCALE, SINGLE_SCALE);
        this.smallRat1Img = new Illustration("Pictures/rat_small.png", SML_RAT1X,
                SML_RAT1Y, SINGLE_SCALE, SINGLE_SCALE);
        this.smallRat2Img = new Illustration("Pictures/rat_small.png", SML_RAT2X,
                SML_RAT2Y, SINGLE_SCALE, SINGLE_SCALE);
        this.smallRat3Img = new Illustration("Pictures/rat_small.png", SML_RAT3X,
                SML_RAT3Y, -SINGLE_SCALE, SINGLE_SCALE);
        this.smallRat4Img = new Illustration("Pictures/rat_small.png", SML_RAT4X,
                SML_RAT4Y, -SINGLE_SCALE, SINGLE_SCALE);
        this.smallRat5Img = new Illustration("Pictures/rat_small.png", SML_RAT5X,
                SML_RAT5Y, SINGLE_SCALE, SINGLE_SCALE);
        this.mayorImg = new Illustration("Pictures/mayor.png", MAYORX,
                MAYORY, DOUBLE_SCALE, DOUBLE_SCALE);
        this.child1Img = new Illustration("Pictures/kid1.png", CHILDX,
                CHILDY, DOUBLE_SCALE, DOUBLE_SCALE);
        this.child2Img = new Illustration("Pictures/kid2.png", CHILD2X,
                CHILD2Y, DOUBLE_SCALE, DOUBLE_SCALE);
        this.flower1Img = new Illustration("Pictures/flower.png", FLOWER1X,
                FLOWER1Y, SMALL_SCALE, SMALL_SCALE);
        this.flower2Img = new Illustration("Pictures/flower.png", FLOWER2X,
                FLOWER2Y, SMALL_SCALE, SMALL_SCALE);

    } // end constructor

    /**
     * Retrieves the piperImg Illustration
     *
     * @return of type Illustration
     */
    public Illustration getPiperImg() {

        return piperImg;

    } // end getPiperImg

    /**
     * Retrieves the peasantImg Illustration
     *
     * @return of type Illustration
     */
    public Illustration getPeasantImg() {

        return peasantImg;

    } // end getPeasantImg

    /**
     * Retrieves the villagerImg Illustration
     *
     * @return of type Illustration
     */
    public Illustration getVillagerImg() {

        return villagerImg;

    } // end getVIllagerImg

    /**
     * Retrieves the textBubbleImg Illustration
     *
     * @return of type Illustration
     */
    public Illustration getTextBubbleImg() {

        return textBubbleImg;

    } // end getTextBubbleImg

    /**
     * Retrieves the ratImg Illustration
     *
     * @return of type Illustration
     */
    public Illustration getRatImg() {

        return ratImg;

    } // end getRatImg

    /**
     * Retrieves the smallRat1Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getSmallRat1Img() {

        return smallRat1Img;

    } // getSmallRat1Img

    /**
     * Retrieves the smallRat2Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getSmallRat2Img() {

        return smallRat2Img;

    } // getSmallRat2Img

    /**
     * Retrieves the smallRat3Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getSmallRat3Img() {

        return smallRat3Img;

    } // getSmallRat3Img

    /**
     * Retrieves the smallRat4Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getSmallRat4Img() {

        return smallRat4Img;

    } // getSmallRat4Img

    /**
     * Retrieves the smallRat5Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getSmallRat5Img() {

        return smallRat5Img;

    } // getSmallRat5Img

    /**
     * Retrieves the mayorImg Illustration
     *
     * @return of type Illustration
     */
    public Illustration getMayorImg() {

        return mayorImg;

    } // end getMayorImg

    /**
     * Retrieves the child1Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getChild1Img() {

        return child1Img;

    } // end getChild1Img

    /**
     * Retrieves the child2Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getChild2Img() {

        return child2Img;

    } // end getCHild2Img

    /**
     * Retrieves the flower1Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getFlower1Img() {

        return flower1Img;

    } // end getFlower1Img

    /**
     * Retrieves the flower2Img Illustration
     *
     * @return of type Illustration
     */
    public Illustration getFlower2Img() {

        return flower2Img;

    } // end getFlower2Img

    /**
     * Retrieves the BackGround Illustration
     *
     * @return of type Illustration
     */
    public Image getBackGround() {

        return backGround;

    } // end getBackGround

    /**
     * Set visibility of all the small rats to same value
     *
     * @param visible of type boolean
     */
    public void setSmallRatVisible(boolean visible) {

        this.smallRat1Img.setVisible(visible);
        this.smallRat2Img.setVisible(visible);
        this.smallRat3Img.setVisible(visible);
        this.smallRat4Img.setVisible(visible);
        this.smallRat5Img.setVisible(visible);

    } // end setSmallRatVisible

    /**
     * Move all the small rats at the same time. To be used when the Piper
     * defeats the queen rat and all the small rats follow him.
     */
    public void relocateSmallRats() {

        smallRat1Img.getPic().relocate(gme.getPiperXLocation() + 0.03 * WIN_WIDTH,
                gme.getPiperYLocation() + 0.16 * WIN_HEIGHT);
        smallRat1Img.setScale(-1.0);
        smallRat2Img.getPic().relocate(gme.getPiperXLocation() + 0.075 * WIN_WIDTH,
                gme.getPiperYLocation() + 0.1867 * WIN_HEIGHT);
        smallRat2Img.setScale(-1.0);
        smallRat3Img.getPic().relocate(gme.getPiperXLocation() + 0.06 * WIN_WIDTH,
                gme.getPiperYLocation() + 0.16 * WIN_HEIGHT);
        smallRat3Img.setScale(-1.0);
        smallRat4Img.getPic().relocate(gme.getPiperXLocation() + 0.09 * WIN_WIDTH,
                gme.getPiperYLocation() + 0.173 * WIN_HEIGHT);
        smallRat4Img.setScale(-1.0);
        smallRat5Img.getPic().relocate(gme.getPiperXLocation() + 0.095 * WIN_WIDTH,
                gme.getPiperYLocation() + 0.1667 * WIN_HEIGHT);
        smallRat5Img.setScale(-1.0);

    } // end relocateSmallRats

} // end class ImageCollection
