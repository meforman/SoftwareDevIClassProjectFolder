package SpellChecker;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Michael Forman
 * date 10/31/2018 
 * JUnit Test Cless for methods in SpellCheckGUI
 *
 */
public class FillArrayList {

	/**
	 * First test is to see of the fillArrayList() method properly reads a test file and fill the array with
	 * it's contents.
	 */
	@Test
	public void testFillArray() {
		File testwordfile = new File("testfile.txt");
		ArrayList<String> wordArray = new ArrayList<String>();
		ArrayList<String> filledArray = new ArrayList<String>();
		filledArray = SpellCheckerGUI.fillArrayList(testwordfile, wordArray);
		assertEquals(filledArray.toString(),"[Here, We, Go]");
		System.out.println("Array filled from test file: " + filledArray.toString() + "\n");
	}
	
	/**
	 * Second test checks the checkForTheWord() method to see if it finds a word in the array list.
	 * It creates a new arrayList and sends it and a word to be found. checks to see the returned stringbuilder
	 * is empty, as it should be.
	 */
	@Test
	public void testWordExists() {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("Tom");
		words.add("Dick");
		words.add("Harry");
		String word1 = "Dick";
				
		System.out.println("Words reference list: " + words);
		StringBuilder badwords = new StringBuilder();
		StringBuilder checkedWords = new StringBuilder(SpellCheckerGUI.checkForTheWord(word1, words, badwords));
		assert(checkedWords.toString().equals(""));
		System.out.println("Word tested : '" + word1 + "' -- Found in list. " + checkedWords.toString());
	}
	
	/**
	 * Third test checks to see if checkForTheWord() method properly documents words not found. It builds an array
	 * of words, then sends it and a word not on the list to ensure the return stringbuilder has the word in it.
	 */
	@Test
	public void testWordNotExists() {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("Tom");
		words.add("Dick");
		words.add("Harry");
		String word2 = "Bob";
		
		System.out.println("Words reference list: " + words);
		StringBuilder badwords = new StringBuilder();
		StringBuilder checkedWords = new StringBuilder(SpellCheckerGUI.checkForTheWord(word2, words, badwords));
		System.out.println("Word tested : '" + word2 + "' -- Not found in list. " + checkedWords.toString());
		assert(checkedWords.toString().contains(word2));
	}

}
