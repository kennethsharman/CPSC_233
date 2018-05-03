package Data_Package;
/**
 *              Final Project, CPSC 233 
 * Class:       EnemyTest.java 
 * Purpose:     This class contains test cases for Enemy class to make sure the
 *              constructors and methods are working properly.
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class EnemyTest {

    //Test constructor
    @Test
    public void test_creation() {

        Enemy enemy = new Enemy();
        assertEquals("Expected initial health to be 100", 100, enemy.getHealth(), 130);

    } // end test_creation

    /**
     * Tests damageRat with a finite, positive argument
     */
    @Test
    public void test_damageRat() {

        Enemy enemy = new Enemy();
        int prevHealth = enemy.getHealth();
        int damage = 1;
        enemy.damageRat(damage);
        assertEquals("Unexpected Health", (prevHealth - damage), enemy.getHealth(), 0.00001);

    } // end test_damageRat

    /**
     * Tests damageRat with a zero argument
     */
    @Test
    public void test_damageRat_zero() {

        Enemy enemy = new Enemy();
        int prevHealth = enemy.getHealth();
        int damage = 0;
        enemy.damageRat(damage);
        assertEquals("Unexpected Health", (prevHealth - damage), enemy.getHealth(), 0.00001);

    } // end test_damageRat_zero

    /**
     * Tests damageRat with a finite, negative argument
     */
    @Test
    public void test_damageRat_negative() {

        Enemy enemy = new Enemy();
        int prevHealth = enemy.getHealth();
        int damage = -50;
        enemy.damageRat(damage);
        assertEquals("Unexpected Health", prevHealth, enemy.getHealth(), 0.00001);

    } // end test_damageRat_negative

} // end class EnemyTest
