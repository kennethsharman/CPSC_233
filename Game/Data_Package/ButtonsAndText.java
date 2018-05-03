package Data_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       ButtonsAndText.java 
 * Purpose:     Assigns variables and creates Buttons and Text for the 
 *              MainMenu, PauseMenu and BattleWindow classes.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class ButtonsAndText {

    /**
     * The getButton method sets the size and scale of all the buttons.
     *
     * @param name of type String
     * @param type of type int
     * @param xValue of type int
     * @param yValue of type int
     * @return button of type Button.
     */
    public static Button getButton(String name, int type, int xValue, int yValue) {

        Button button = new Button(name);
        button.setAlignment(Pos.CENTER);
        button.setTranslateX(xValue);
        button.setTranslateY(yValue);

        //Buttons for main and pause menus.
        if ((type == 0) || (type == 1)) {
            button.setPrefSize(120, 30);
        } else //Buttons on the fight window (type 2).
        {
            button.setPrefSize(100, 30);
        }

        //Buttons on sub-menus, pause menu, and fight window.
        if ((type == 0) || (type == 2)) {
            button.setScaleX(2);
            button.setScaleY(2);
        } else//Buttons on the main menu
        {
            button.setScaleX(1.5);
            button.setScaleY(1.5);
        }
        return button;

    }//End of getButton

    /**
     * The getText method sets the alignment, color, font, and size of all the
     * text.
     *
     * @param words of type String.
     * @param title of type int.
     * @return text of type Text.
     */
    public static Text getText(String words, int title) {

        Text text = new Text(words);

        if ((title >= 0) && (title <= 4)) {
            text.setTextAlignment(TextAlignment.CENTER);
            text.setFill(Color.RED);

            switch (title) {
                //Pause menu and Help titles
                case 0:
                    text.setFont(Font.font("Verdana", 65));
                    break;
                //Help text
                case 1:
                    text.setFont(Font.font("Verdana", 25));
                    break;
                //Load and save prompts
                case 2:
                    text.setFont(Font.font("Verdana", 40));
                    text.toFront();
                    text.setLayoutY(35);
                    break;
                //Main menu title
                case 3:
                    text.setFont(Font.font("Verdana", 60));
                    break;
                //Credits text
                case 4:
                    text.setFont(Font.font("Verdana", 30));
                    break;
                default:
                    break;

            } // end switch

        } else {
            text.setFill(Color.BLACK);

            switch (title) {
                //Health text
                case 5:
                    text.setFont(Font.font("Verdana", 40));
                    break;
                //Fight buttons text
                case 6:
                    text.setFont(Font.font("Verdana", 60));
                    break;
                //Potions text
                case 7:
                    text.setFont(Font.font("Verdana", 27));
                    break;
                //Victory text
                case 8:
                    text.setFill(Color.RED);
                    text.setFont(Font.font("Verdana", 80));
                    break;
                case 9:
                    text.setFont(Font.font("Verdana", 250));
                    text.setFill(Color.GOLD);
                    text.setStroke(Color.GOLDENROD);
                    text.setStrokeWidth(5);
                    break;
                case 10:
                    text.setFont(Font.font("Verdana", 200));
                    text.setStroke(Color.DARKRED);
                    text.setStrokeWidth(5);
                    break;
                default:
                    break;
            } // end switch
        } // end if-else

        return text;
    }//End of getText

    /**
     * The getRectangle method sets the size and color of the rectangles
     *
     * @param type of type int.
     * @param width of type int
     * @param height of type int
     * @param xTranslate of type int
     * @param yTranslate of type int
     * @return rectangle of type Rectangle.
     */
    public static Rectangle getRectangle(int type, int width, int height, int xTranslate, int yTranslate) {

        Rectangle rectangle = new Rectangle();
        rectangle.setStrokeWidth(5);
        rectangle.setWidth(width);
        rectangle.setHeight(height);
        rectangle.setTranslateX(xTranslate);
        rectangle.setTranslateY(yTranslate);

        switch (type) {
            //"Fight" banner rectangle
            case 0:
                rectangle.setFill(Color.ALICEBLUE);
                rectangle.setStroke(Color.LIGHTBLUE);
                break;
            //Health and potion rectangles
            case 1:
                rectangle.setFill(Color.LIGHTGREY);
                rectangle.setStroke(Color.DARKGREY);
                break;
            //Grass rectangle
            case 2:
                rectangle.setStrokeWidth(3);
                rectangle.setFill(Color.GREEN);
                rectangle.setStroke(Color.DARKGREEN);
                break;
            //Hud block rectangle
            case 3:
                rectangle.setFill(Color.GREY);
                rectangle.setStroke(Color.DARKGREY);
                break;
            case 4:
                rectangle.setFill(Color.WHITE);
                break;
            case 5:
                rectangle.setFill(Color.BLACK);
                break;
            default:
                break;
        } // end switch

        return rectangle;

    }//End of getRectangle

}//End of ButtonsAndText
