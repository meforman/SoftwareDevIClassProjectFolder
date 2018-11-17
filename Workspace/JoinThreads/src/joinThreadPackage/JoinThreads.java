package joinThreadPackage;



import java.util.InputMismatchException;
import java.util.LinkedList;

import java.util.Scanner;


public class JoinThreads {
	private static StringBuilder mainString = new StringBuilder();
	private static LinkedList<String> firstString = new LinkedList<String>();
	private static LinkedList<String> secondString = new LinkedList<String>();
	
	private static String songString = "Is this the real life is this just fantasy? Caught in a landslide with no"
			+ " escape from reality. Open your eyes look up to the sky and see. I'm just a poor boy I need no"
			+ " sympathy, because I'm easy come, easy go, little high, little low. Any way the wind blows, doesn't"
			+  " really matter to me, to me. Mama, just killed a man. Put my gun against his head, pulled my"
			+ " trigger now he's dead. Mama, life had just begun, but now I've gone and thrown it all away."
			+ " Mama oh-oh 'any way the wind blows' I didn't mean to make you cry. If I'm not back this time tomorrow"
			+ " carry on, carry on as if nothing really matters."; 
	static int countWords = 0;
	static boolean syncFlag = true;
	

	
			
	public static void main(String[] args) {
		int userPrompt = 0;
		loadStrings();
		System.out.println("Strings after parsing: \n" + firstString.toString() + "\n" 
		+ secondString.toString() + "\n");
		
		Thread t1 = new Thread (new Runnable(){

			@Override
			public void run() {
				
				for (int i = 0; i <= firstString.size() -1; i++)
				{
					String foundWordOne = firstString.get(i).toString();
					
					 if (syncFlag == true) {
						 addToMainString(foundWordOne);
					 }
					 else 
					 {
						unsyncAddToMainString(foundWordOne);
					 }
				}
				
			}
			
		});
		
		Thread t2 = new Thread (new Runnable(){

			@Override
			public void run() {
				
				for (int i = 0; i <= secondString.size() -1; i++)
				{
					 String foundWordTwo = secondString.get(i).toString();
					
					 if (syncFlag == true) {
						 addToMainString(foundWordTwo);
					 }
					 else
					 {
						 unsyncAddToMainString(foundWordTwo);
					 }
				}
				
			}
			
		});
		
			userPrompt = displayMenu();
			if (userPrompt == 1){
				syncFlag = false;
				String syncString = "unsychronized";
				runThreads(t1, t2, syncString);
				}
			
			if (userPrompt == 2) {
				syncFlag = true;
				String syncString = "sychronized";
				runThreads(t1, t2, syncString);
				}
			
			System.exit(0);
	
		
		
}// end main
	
	public static void runThreads(Thread t1, Thread t2, String syncString) {
		t2.start();
		t1.start();
		
		try {
			t1.join();
			t2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("This verse is from "+ syncString + " threads.\n");
		System.out.println(mainString.toString());
		System.out.println("\nExiting Program, please re-run to start new threads.");
		System.exit(0);
		
		}
	
	public static synchronized void addToMainString(String wordToAdd) {
	try {
		countWords++;
		mainString.append(wordToAdd);
		mainString.append(" ");
		if (countWords == 20) {
			mainString.append("\n");
			countWords = 0;
		}
	} catch (ArrayIndexOutOfBoundsException e) {
		return;
	}
	}
	
	public static void unsyncAddToMainString(String wordToAdd) {
		try {
			countWords++;
			mainString.append(wordToAdd);
			mainString.append(" ");
			if (countWords == 20) {
				mainString.append("\n");
				countWords = 0;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		}
	
	public static void loadStrings() {
		int spaceChar = 0;
		int startIndex = 0;
		while (startIndex <= songString.length()) 
		{
		spaceChar = songString.indexOf(" ", startIndex);
		
		try {
			firstString.add(songString.substring(startIndex, spaceChar));
		startIndex = spaceChar + 1;
			if (startIndex >= songString.length() -1){
			break;
			} 
		}catch (StringIndexOutOfBoundsException e) {
			break;
			}
		
		spaceChar = songString.indexOf(" ", startIndex);
		
		try {
			secondString.add(songString.substring(startIndex, spaceChar));
			startIndex = spaceChar + 1;
			if (startIndex >= songString.length() -1) {
			break;
			} 
		}catch (StringIndexOutOfBoundsException e) {
			break;
			}
		
			
		}//end while
		}//end loadStrings
	public static int displayMenu() {// My home-grown menu display method
		int badMenu = 0;
		int userChoice = 0;
	do {
		System.out.println("Enter your choice: \n 1. Select Unsynced Threading "
				+ "\n 2. Select Synced Threading "
				+ "\n 3. Exit\n ");
		try {
	Scanner minput = new Scanner(System.in);
	userChoice = minput.nextInt();
		if (userChoice < 1 || userChoice > 3) {
		System.out.println("Please choose a number between 1 and 3.");
		badMenu = 1;
		}//End if
		else 
			badMenu = 0;
			return userChoice;
		}//End try
		catch (InputMismatchException f) {
		System.out.println("Menu choice must be a number between 1 and 3. Please re-enter.");
		badMenu = 1;
		}//end catch
	}//End do
	while (badMenu == 1);
	return userChoice;
	}//end displayMenu
}//end class

