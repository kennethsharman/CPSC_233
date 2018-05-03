package Data_Package;
/**
 *              Final Project, CPSC 233 
 * Class:       PiedPiperTest.java 
 * Purpose:     This class contains test cases for PiedPiper class to make sure 
 *              the constructors are working properly.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class PiedPiperTest {

    //Test constructor
    @Test
    public void test_creation() {

        PiedPiper player = new PiedPiper();
        assertEquals("Expected initial health to be 100", 100, player.getHealth(), 0.00001);
        assertEquals("Expected initial potions to be 2", 2, player.getPotions(), 0.00001);

    } // end test_creation

    /**
     * Test updateHealth with a finite, positive argument
     */
    @Test
    public void test_updateHealth() {

        PiedPiper player = new PiedPiper();
        player.updateHealth(80);
        assertEquals("Unexpected Health", 80, player.getHealth(), 0.00001);

    } // end test_updateHealth

    /**
     * Test updateHealth with a zero argument
     */
    @Test
    public void test_updateHealth_zero() {

        PiedPiper player = new PiedPiper();
        player.updateHealth(0);
        assertEquals("Unexpected Health", 0, player.getHealth(), 0.00001);

    } // end test_updateHealth_zero

    /**
     * Test updateHealth with a finite, negative argument
     */
    @Test
    public void test_updateHealth_negative() {

        PiedPiper player = new PiedPiper();

        int health = player.getHealth();
        player.updateHealth(-10);
        assertEquals("Unexpected Health", health, player.getHealth(), 0.00001);

    } // end test_updateHealth_zero

    /**
     * Tests damagePiper with a finite, positive argument
     */
    @Test
    public void test_damagePiper() {

        PiedPiper player = new PiedPiper();
        int prevHealth = player.getHealth();
        int damage = 1;
        player.damagePiper(damage);
        assertEquals("Unexpected Health", (prevHealth - damage), player.getHealth(), 0.00001);

    } // end test_damagePiper

    /**
     * Tests damagePiper with a zero argument
     */
    @Test
    public void test_damagePiper_zero() {

        PiedPiper player = new PiedPiper();
        int prevHealth = player.getHealth();
        int damage = 0;
        player.damagePiper(damage);
        assertEquals("Unexpected Health", (prevHealth - damage), player.getHealth(), 0.00001);

    } // end test_damagePiper_zero

    /**
     * Tests damagePiper with a finite, negative argument
     */
    @Test
    public void test_damagePiper_negative() {

        PiedPiper player = new PiedPiper();
        int prevHealth = player.getHealth();
        int damage = -50;
        player.damagePiper(damage);
        assertEquals("Unexpected Health", prevHealth, player.getHealth(), 0.00001);

    } // end test_damagePiper_negative

    /**
     * Tests getPotions using the default value of potions (2)
     */
    @Test
    public void test_getPotions() {

        PiedPiper player = new PiedPiper();
        assertEquals("Unexpected Health", 2, player.getPotions(), 0.00001);

    } // end test_getPotions

} // end class PiedPiperTest
