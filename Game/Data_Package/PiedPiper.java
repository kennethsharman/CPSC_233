package Data_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       PiedPiper.java 
 * Purpose:     This class is used to contain and manipulate the Pied Piper's
 *              health, healing potions, and attacks.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import java.util.Random;

public class PiedPiper {

    private static int health = 100;
    private static int healthPotions = 2;

    /**
     * Retrieves the value of health
     *
     * @return of type int
     */
    public int getHealth() {
        return PiedPiper.health;
    }

    /**
     * Sets the value of the health
     *
     * @param amount of type int
     */
    public static void setHealth(int amount) {

        if (amount >= 0) {
            PiedPiper.health = amount;
        }
    } // end setHealth

    /**
     * Sets the value of the health in non-static context
     *
     * @param amount
     */
    public void updateHealth(int amount) {

        if (amount >= 0) {
            PiedPiper.health = amount;
        }
    } // end updateHealth

    /**
     * Lowers the value of health by amount passed as parameter. Used when an
     * enemy damages piper.
     *
     * @param damage of type int
     */
    public void damagePiper(int damage) {

        if (damage >= 0) {
            int prevHealth = PiedPiper.health;
            PiedPiper.health = prevHealth - damage;
        }
    } // end damagePiper

    /**
     * used for when the player wishes to heal the Pied Piper.
     */
    public void healPiper() {

        int prevHealth = PiedPiper.health;
        PiedPiper.health = prevHealth + 25;
        PiedPiper.healthPotions--;

    } // end healPiper

    /**
     * Retrieves the value of health potions
     *
     * @return of type int
     */
    public int getPotions() {
        return (PiedPiper.healthPotions);
    }

    /**
     * Sets the value of health potions
     *
     * @param amount of type int
     */
    public static void setPotions(int amount) {

        if (amount >= 0) {
            healthPotions = amount;
        }
    } // end setPotions

    /**
     * This method is used to calculate the damage the piper does.
     *
     * @param attackType of type int
     * @return of type int
     */
    public int piperATK(int attackType) {

        Random rand = new Random();

        switch (attackType) {
            case 1:
                // Quick attack will do fewer damage but you will take less damage.
                // You will do a Max: 15 damage and Minimum: 5.
                int quickATK = rand.nextInt(15) + 5;
                return (quickATK);
            case 2:
                // Heavy attack will do more damage than quick attack but you 
                // will be vulnerable to more damage.
                // You will do a Max: 25 damage and a Minimum: 10.
                int heavyATK = rand.nextInt(25) + 10;
                return (heavyATK);
            case 3:
                // Special attack will do lots of damage but like the heavy 
                // attack you will be more vulnerable to taking more damage.
                // The exception for this attack is that you can only use it 
                // once every 3 turns. You will do a Max: 50 damage and Minimum: 20.
                int specialATK = rand.nextInt(50) + 20;
                return (specialATK);
            default:									// 
                return (0); // Placeholder so i could compile

        } // end switch

    } // end piperATK

    /**
     * A simple method to check if Piper's health is above 0.
     *
     * @return of type boolean
     */
    public boolean isAlive() {

        if (PiedPiper.health > 0) {
            return (true);
        } else {
            return (false);
        }

    } // end isAlive

} // end PiedPiper
