package Data_Package;

/**
 *              Final Project, CPSC 233 
 * Class:       PiedPiperGameTest.java 
 * Purpose:     This class contains test cases for load game feature of the
 * 		game to make sure that the methods and classes are working
 * 		properly (load properly with correct values).
 *
 * @author      T01-3
 * Date:        April 6, 2018
 */
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class PiedPiperGameTest {

    //Test constructors
    @Test
    public void test_creation() {

        PiedPiperGame game = new PiedPiperGame();
        assertEquals("Expected initial level to be 0", 0, game.getLevel(), 0.00001);

    } // end tes_creation

    @Test
    public void test_constructorTest1() throws FileNotFoundException {

        File test = new File("loadfiles/LoadLevel0.txt");
        PiedPiperGame game = new PiedPiperGame(test);
        assertEquals("Unexpected level", 0, game.getLevel(), 0.00001);
        assertEquals("Unexpected health", 100, game.getHealth(), 0.00001);
        assertEquals("Unexpected time", 8, game.getCount(), 0.00001);
        assertEquals("Unexpected potions", 3, game.getPotions(), 0.00001);
        assertEquals("Unexpected x location", 137.0, game.getPiperXLocation(), 0.00001);

    } // end test_constructorTest1()

    @Test
    public void test_constructorTest2() throws FileNotFoundException {

        File test = new File("loadfiles/LoadLevel1.txt");
        PiedPiperGame game = new PiedPiperGame(test);
        assertEquals("Unexpected level", 1, game.getLevel(), 0.00001);
        assertEquals("Unexpected health", 80, game.getHealth(), 0.00001);
        assertEquals("Unexpected time", 0, game.getCount(), 0.00001);
        assertEquals("Unexpected potions", 1, game.getPotions(), 0.00001);
        assertEquals("Unexpected x location", 301.0, game.getPiperXLocation(), 0.00001);

    } // end test_constructorTest2

    // Testing level   
    @Test
    public void test_level() {

        PiedPiperGame game = new PiedPiperGame();
        game.setLevel(7);
        assertEquals("Unexpected level", 7, game.getLevel(), 0.00001);

    } // end test_level

    @Test
    public void test_level_negativeAmount() {

        PiedPiperGame game = new PiedPiperGame();
        game.setLevel(-2);
        assertEquals("Unexpected level", 0, game.getLevel(), 0.00001);

    } // end testl_level_negativeAmount

    @Test
    public void test_level_zero() throws FileNotFoundException {

        PiedPiperGame game = new PiedPiperGame();
        game.setLevel(0);
        assertEquals("Unexpected level", 0, game.getLevel(), 0.00001);

    } // end test_level_zero

    // Testing health
    @Test
    public void test_health() {

        PiedPiperGame game = new PiedPiperGame();
        game.setHealth(85);
        assertEquals("Unexpected health", 85, game.getHealth(), 0.00001);

    } // end test_health

    @Test
    public void test_health_negativeAmount() {

        PiedPiperGame game = new PiedPiperGame();
        game.setHealth(-25);
        assertEquals("Unexpected health", 75, game.getHealth(), 0.00001);

    } // end test_health_negativeAmount

    @Test
    public void test_health_zero() {

        PiedPiperGame game = new PiedPiperGame();
        game.setHealth(0);
        assertEquals("Unexpected health", 75, game.getHealth(), 0.00001);

    } // end test_health_zero

    // Testing Time
    @Test
    public void test_time() {

        PiedPiperGame game = new PiedPiperGame();
        game.setCount(12);
        assertEquals("Unexpected time", 12, game.getCount(), 0.00001);

    } // end test_time

    @Test
    public void test_time_negativeAmount() {

        PiedPiperGame game = new PiedPiperGame();
        game.setCount(-5);
        assertEquals("Unexpected time", 0, game.getCount(), 0.00001);

    } // end test_time_negativeAmount

    @Test
    public void test_time_zero() {

        PiedPiperGame game = new PiedPiperGame();
        game.setCount(0);
        assertEquals("Unexpected time", 0, game.getCount(), 0.00001);

    } // end test_time_zero

    // Testing potions
    @Test
    public void test_numberOfPotions() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPotions(3);
        assertEquals("Unexpected potions", 3, game.getPotions(), 0.00001);

    } // end test_numberOfPotions

    @Test
    public void test_numberOfPotions_negativeAmount() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPotions(-5);
        assertEquals("Unexpected potions", 2, game.getPotions(), 0.00001);

    } // end test_numnberOfPotions_negativeAmount

    @Test
    public void test_numberOfPotions_zero() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPotions(0);
        assertEquals("Unexpected potions", 0, game.getPotions(), 0.00001);

    } // end test_numberOfPotions_zero

    // Testing x and y locations
    @Test
    public void test_xAndYLocations() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPiperXLocation(500.0);
        game.setPiperYLocation(400.0);
        assertEquals("Unexpected x location", 500.0, game.getPiperXLocation(), 0.00001);
        assertEquals("Unexpected y location", 400.0, game.getPiperYLocation(), 0.00001);

    } // end test_xAndYLocations

    @Test
    public void test_xAndYLocation_negativeAmount() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPiperXLocation(-250.0);
        game.setPiperYLocation(-300.5);
        assertEquals("Unexpected x location", -250.0, game.getPiperXLocation(), 0.00001);
        assertEquals("Unexpected y location", -300.5, game.getPiperYLocation(), 0.00001);

    } // end test_xAndYLocation_negativeAmount

    @Test
    public void test_xAndYLocation_zero() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPiperXLocation(0.0);
        game.setPiperYLocation(0.0);
        assertEquals("Unexpected x location", 0.0, game.getPiperXLocation(), 0.00001);
        assertEquals("Unexpected y location", 0.0, game.getPiperYLocation(), 0.00001);

    }// e nd test_xAndYLocation

    @Test
    public void test_xAndYLocation_neagtiveXAndPositiveY() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPiperXLocation(-375.0);
        game.setPiperYLocation(286.9);
        assertEquals("Unexpected x location", -375.0, game.getPiperXLocation(), 0.00001);
        assertEquals("Unexpected y location", 286.9, game.getPiperYLocation(), 0.00001);

    } // end test_xAndYLocation_negativeXAndPositiveY

    @Test
    public void test_xAndYLocation_positiveXAndNegativeY() {

        PiedPiperGame game = new PiedPiperGame();
        game.setPiperXLocation(887.7);
        game.setPiperYLocation(-698.4);
        assertEquals("Unexpected x location", 887.7, game.getPiperXLocation(), 0.00001);
        assertEquals("Unexpected y location", -698.4, game.getPiperYLocation(), 0.00001);

    } // end test_xAndYLocation_positiveXAndNegativeY

} // end PiedPierGameTest
