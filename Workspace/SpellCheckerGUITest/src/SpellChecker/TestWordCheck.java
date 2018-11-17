package SpellChecker;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class TestWordCheck {
	
	@Test
	public void testOne() {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("Tom");
		words.add("Dick");
		words.add("Harry");
		String word1 = "Dick";
				
		System.out.println("Words reference list: " + words);
		StringBuilder badwords = new StringBuilder();
		TestWordCheck checkTest = new TestWordCheck();
		StringBuilder checkedWords = new StringBuilder(SpellCheckerGUI.checkForTheWord(word1, words, badwords));
		assert(checkedWords.toString().equals(""));
		System.out.println("Word tested : '" + word1 + "' -- Found in list. " + checkedWords.toString());
	}
	
	@Test
	public void testTwo() {
		
		ArrayList<String> words = new ArrayList<String>();
		words.add("Tom");
		words.add("Dick");
		words.add("Harry");
		String word2 = "Bob";
		
		TestWordCheck checkTestTwo = new TestWordCheck();
		StringBuilder badwords = new StringBuilder();
		StringBuilder checkedWords = new StringBuilder(SpellCheckerGUI.checkForTheWord(word2, words, badwords));
		System.out.println("Word tested : '" + word2 + "' -- Not found in list. " + checkedWords.toString());
		assert(checkedWords.toString().contains(word2));
	}

}
