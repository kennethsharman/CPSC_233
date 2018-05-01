import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class VowelsTest {

	//Check the submission file for the words "for" and "while"
	@Test
	public void testCheckWords(){
		Scanner scan = null;
		try {
			scan = new Scanner (new FileInputStream("Vowels.java"));
		} catch (FileNotFoundException e){
			fail("Vowels.java not found");
		}
		
		while (scan.hasNext()){
			String line = scan.nextLine();
			
			if (line.contains("for") || line.contains("while")){
				fail("Found word \"for\" or \"while\": " + line);
			}
		}
		
		scan.close();
	}
	
	@Test
	public void containsInstanceOrClassVariables(){
		Scanner scan = null;
		try {
			scan = new Scanner (new FileInputStream("Vowels.java"));
		} catch (FileNotFoundException e){
			fail("Vowels.java not found");
		}
		
		boolean atClassLevel = false;
		boolean inMethod = false;
		boolean inDocumentation = false;
		int match = 0;
		
		while (scan.hasNext()){
			String line = scan.nextLine();
			
			if (line.contains("{") && !inDocumentation){
				if (inMethod){
					match++;
				} else if (atClassLevel) {
					inMethod = true;
				} else {
					atClassLevel = true;
					line = scan.nextLine();
				}
			} else if (line.contains("}") && !inDocumentation){
				if (match == 0){
					if (inMethod){
						inMethod = false;
					} else {
						atClassLevel = false;
					}
				} else {
					match--;
				}
			} else if (line.contains("/*")) {
				inDocumentation = true;
			} else if (line.contains("*/")) {
				inDocumentation = false;
			} 
				
			if (atClassLevel && !inMethod && !inDocumentation) {
				if (line.contains("=")) {
					fail("There appears to be an instance or class variable, which is not allowed.");
				}	
				if (!line.contains("(")) {
					for (int index = 0; index < line.length(); index++){
						if (Character.isLetter(line.charAt(index))){
							fail("There appears to be an instance or class variable, which is not allowed.");
						}
					}
				}
			}
		}
		
		scan.close();
	}
	
	
	@Test
	public void test_emptyString() {
		//Test list for mix of odds and evens
		testCheckWords();
		containsInstanceOrClassVariables();
		
		int count = Vowels.numOfVowels("");
		
		assertEquals("EmptyString has no vowels", 0, count);
		
	}
	
	@Test
	public void test_noVowelString() {
		//Test list for mix of odds and evens
		testCheckWords();
		containsInstanceOrClassVariables();
		
		int count = Vowels.numOfVowels("hq trpl nmb");
		
		assertEquals("'hq trpl nmb' has no vowels", 0, count);
		
	}
	
	@Test
	public void test_oneVowelString() {
		//Test list for mix of odds and evens
		testCheckWords();
		containsInstanceOrClassVariables();
		
		int count = Vowels.numOfVowels("crunch");
		
		assertEquals("'crunch' has 1 vowels", 1, count);
		
	}
	
	@Test
	public void test_firstLetterOnlyVowel() {
		//Test list for mix of odds and evens
		testCheckWords();
		containsInstanceOrClassVariables();
		
		int count = Vowels.numOfVowels("astrx psst");
		
		assertEquals("'astrx psst' has 1 vowels", 1, count);
		
	}
	
	@Test
	public void test_lastLetterOnlyVowel() {
		//Test list for mix of odds and evens
		testCheckWords();
		containsInstanceOrClassVariables();
		
		int count = Vowels.numOfVowels("strx pss to");
		
		assertEquals("'strx pss to' has 1 vowels", 1, count);
		
	}
	
	@Test
	public void test_manyVowel() {
		//Test list for mix of odds and evens
		testCheckWords();
		containsInstanceOrClassVariables();
		
		int count = Vowels.numOfVowels("This is a string with many vowels put inside it");
		
		assertEquals("'strx pss to' has 13 vowels (ignoring the y as a vowel)", 13, count);
		
	}
	
	
}
