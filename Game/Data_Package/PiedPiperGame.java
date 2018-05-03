package Data_Package;

/**
 * 		Final Project, CPSC 233 
 * Class:       PiedPiperGame.java
 * Purpose:     Class specifies an instance of the Pied Piper game. The position
 *              of the main character is stored here, along with the level of the
 *              game. The goal is to use the information in this class alone, to
 *              create a save game file, as well as in the load game option.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class PiedPiperGame {

    // Level, or progress, of the game
    private int level;
    private int health;
    private int potions;

    // x-y coordinates of Pied Piper character
    private double piperXLocation;
    private double piperYLocation;

    private int count;

    /**
     * List of possible objectives throughout entirety of game.
     */
    public enum Task {

        CATCH_RATS,
        FIND_ITEMS,
        TALK_TOWNSFOLK,
        TALK_MAYOR,
        GET_CHILDREN

    } // end Task

    /**
     * Default constructor for new game.
     */
    public PiedPiperGame() {

        this.level = 0;
        this.health = 100;
        this.potions = 2;
        this.piperXLocation = 0;
        this.count = 0;

    } // end constructor

    /**
     * Constructor that reads a file and sets instance variables.
     *
     * @param file of type File.
     * @throws FileNotFoundException if file does not exist or can't be found.
     */
    public PiedPiperGame(File file) throws FileNotFoundException {

        Scanner items = new Scanner(file);

        int levelNum = items.nextInt();
        setLevel(levelNum);

        int health = items.nextInt();
        setHealth(health);
        PiedPiper.setHealth(health);

        int time = items.nextInt();
        setCount(time);

        int potions = items.nextInt();
        setPotions(potions);
        PiedPiper.setPotions(potions);

        double xLocation = items.nextDouble();
        this.piperXLocation = xLocation;

        if (items.nextLine().contains("#")) {
            items.skip("#");
        }

    } // end Constructor

    /**
     * Retrieve current level of the game.
     *
     * @return level of type int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level number from the save file.
     *
     * @param levelNum of type int.
     */
    public void setLevel(int levelNum) {

        if (levelNum >= 0) {
            this.level = levelNum;
        } else {
            this.level = 0;
        }

    } // end setLevel

    /**
     * Retrieve the health of Pied Piper.
     *
     * @return health of type int.
     */
    public int getHealth() {
        return (this.health);
    }

    /**
     * Sets the health from the save file.
     *
     * @param amount of type int.
     */
    public void setHealth(int amount) {

        if (amount > 0) {
            this.health = amount;
        } else {
            this.health = 75;
        }

    }
    // end setHealth

    /**
     * Retrieve the amount of potions.
     *
     * @return potions of type int.
     */
    public int getPotions() {
        return this.potions;
    }

    /**
     * Sets the amount of potions from the save file.
     *
     * @param numPotions of type int.
     */
    public void setPotions(int numPotions) {

        if (numPotions >= 0) {
            this.potions = numPotions;
        } else {
            this.potions = 2;
        }

    } // end setPotions

    /**
     * Retrieve the x coordinate of the Pied Piper character.
     *
     * @return piperXLocation of type double.
     */
    public double getPiperXLocation() {
        return piperXLocation;
    }

    /**
     * Retrieve the y coordinate of the Pied Piper character.
     *
     * @return piperYLocation of type double.
     */
    public double getPiperYLocation() {
        return piperYLocation;
    }

    /**
     * Set the x coordinate of the Pied Piper character.
     *
     * @param piperXLocation of type double
     */
    public void setPiperXLocation(double piperXLocation) {
        this.piperXLocation = piperXLocation;
    }

    /**
     * Set the y coordinate of the Pied Piper character.
     *
     * @param piperYLocation of type double
     */
    public void setPiperYLocation(double piperYLocation) {
        this.piperYLocation = piperYLocation;
    }

    /**
     * Set to the next level of the game.
     */
    public void nextLevel() {
        this.level += 1;
    }

    /**
     * Retrieves the value of count, which is state of the game clock.
     *
     * @return clock count of type int
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the value of count, which is state of the game clock.
     *
     * @param count of type int
     */
    public void setCount(int count) {
        if (count < 0) {
            this.count = 0;
        } else {
            this.count = count;
        }
    }

    /**
     * Purpose of method is to provide formatted output, corresponding to each
     * enumerated type Task.
     *
     * @param obj enumerated type Task.
     * @return String representation of enum.
     */
    public String objectiveString(Task obj) {

        StringBuilder sb = new StringBuilder();

        switch (obj) {

            case CATCH_RATS:
                sb.append("\tGO CATCH SOME RATS!!");
                break;

            case FIND_ITEMS:
                sb.append("\tSEARCH FOR FOOD AND TREASURE");
                break;

            case TALK_TOWNSFOLK:
                sb.append("\tSPEAK WITH THE TOWNSFOLK");
                break;

            case TALK_MAYOR:
                sb.append("\tSPEAK WITH THE MAYOR");
                break;

            case GET_CHILDREN:
                sb.append("\tGATHER THE CHILDREN");
                break;

            default:
                break;

        } //End of switch

        return sb.toString();

    } //End of printObjective

    /**
     * Generates the random amounts of damage of the different attacks.
     *
     * @param attackType of type int.
     * @return of type int
     */
    public int piperATK(int attackType) {

        Random rand = new Random();

        switch (attackType) {
            case 1:
                int quickATK = rand.nextInt(15) + 1;
                return (quickATK);
            case 2:
                int heavyATK = rand.nextInt(25) + 10;
                return (heavyATK);
            case 3:
                int specialATK = rand.nextInt(50) + 1;
                return (specialATK);
            default:
                return (0); //Placeholder so i could compile

        } // end switch

    } // end piperATK

    /**
     * Calculates the damage the Pied Piper takes and sets the new health.
     *
     * @param damage of type int.
     */
    public void damagePiper(int damage) {

        int prevHealth = getHealth();
        int newHealth = prevHealth - damage;
        setHealth(newHealth);

    } // end damagePiper

    /**
     * Calculates the new health for the Pied Piper and removing one potion from
     * the inventory.
     */
    public void healPiper() {

        int prevHealth = getHealth();
        int newHealth = prevHealth + 25;
        setHealth(newHealth);
        this.potions--;

    } // end healPiper

    /**
     * Checks to see if the Pied Piper is alive.
     *
     * @return boolean
     */
    public boolean isAlive() {

        if (getHealth() > 0) {
            return (true);
        } else {
            return (false);
        }

    } // end isAlive

} //End of PiedPiperGame
