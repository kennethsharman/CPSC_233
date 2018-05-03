package Data_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       Enemy.java 
 * Purpose:     This class is used to contain and manipulate the enemy 
 * 		(rat and mayor) health and attacks.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import java.util.Random;

public class Enemy {

    private int health;

    /**
     * Constructor initializes the rats health to a random number.
     */
    public Enemy() {

        Random rand = new Random();
        int ratHealth = rand.nextInt(75) + 30;
        this.health = ratHealth;

    } // end constructor

    /**
     * Retrieves the value of health
     *
     * @return type int
     */
    public int getHealth() {
        return (this.health);
    }

    /**
     * Lowers the value of health by amount passed as parameter
     *
     * @param damage of type int
     */
    public void damageRat(int damage) {

        if (damage >= 0) {
            int prevHealth = this.health;
            this.health = prevHealth - damage;
        }
    } // end damageRat

    /**
     * This method is used to calculate the damage the rat does.
     *
     * @param piperAtkType of type int
     * @return type int
     */
    public int ratATK(int piperAtkType) {

        Random rand = new Random();

        // If Piper uses a quick attack the rat has a lower chance of critical 
        // strike and will do less damage overall.
        if (piperAtkType == 1) {

            int chance = rand.nextInt(100) + 0;

            // 10% Critical Hit Chance (Max 30 damage, Min 15 damage)
            if (chance <= 10) {
                int critATK = rand.nextInt(30) + 15;
                return (critATK);
            } else { // 90% Normal Hit Chance (Max 15 damage, Min 1 damage)
                int normalATK = rand.nextInt(15) + 1;
                return (normalATK);
            }
        } else if ((piperAtkType == 2) || (piperAtkType == 3)) {

            //If Piper uses a heavy attack or special attack the rat can do MORE damage.
            int chance = rand.nextInt(100) + 0;
            // 20% Critical Hit Chance (Max 30 damage, Min 15 damage)
            if (chance <= 20) {
                int critATK = rand.nextInt(30) + 15;
                return (critATK);
            } else { // 80% Normal Hit Chance (Max 20 damage, Min 5 damage)
                int normalATK = rand.nextInt(20) + 5;
                return (normalATK);
            }
        } else {
            return (0);
        }

    } // end ratATK

    /**
     * A simple method to check if rats health is above 0.
     *
     * @return boolean
     */
    public boolean isAlive() {
        if (this.health > 0) {
            return (true);
        } else {
            return (false);
        }
    } // end isAlive

}// end Enemy
