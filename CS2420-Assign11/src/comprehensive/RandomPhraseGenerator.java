package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RandomPhraseGenerator {
	
	protected static int firstHalfNumberOfPhrases;
	protected static int secondHalfNumberOfPhrases;
	protected static ArrayList<String> phrases;
	
	//the visibilitty is public only to this package
	static HashMap<String, NonTerminal> nonTermHM = new HashMap<>();

	public static void main(String[] args) throws InterruptedException {
		//read in input stuff
		try {
			readInInput("src/comprehensive/"+args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int phraseAmount = Integer.parseInt( args[1] );  
		generatePhrase( phraseAmount );

	}
	
	private static void readInInput(String fileLocation) throws IOException {
		//create file from file location
		File inputFile = new File(fileLocation);
//		System.out.println("file is located at " + fileLocation);
		//initialize bufferedReader
		BufferedReader bf;
		
		//create the buffered reader
		try {
			bf = new BufferedReader( new FileReader( inputFile ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			bf = null;
		}
		
		//initialize line of the file document
		String line;
		
		String currentNT;
		String innerLine;
		//while there is a next line, parse the data into non terminal sections
		while ((line = bf.readLine()) != null) {
			//if a nonterminal section is beginning, create a NonTerminal Object
			boolean inputBegin = line.equals("{");
			if( inputBegin ) {
				String nonTerminalName = bf.readLine();
				currentNT = nonTerminalName;
//				System.out.println("NonTerminal's name is: " + nonTerminalName);
				//add to hashMap
				nonTermHM.put( nonTerminalName, new NonTerminal() );
				//read next line
				innerLine = bf.readLine();
				//add everything within the curly brackets to map (besides the name of the NT)
				while(!innerLine.equals("}")) {
					nonTermHM.get(currentNT).add(innerLine);
					//advance to next line
					innerLine = bf.readLine();
				}
				line = innerLine;
			}//end inside curly brackets
	    }//end while loop to read the input File
		
		bf.close();
	}

	public static void generatePhrase(int numOfPhrases) throws InterruptedException {
		firstHalfNumberOfPhrases = numOfPhrases/2;
		secondHalfNumberOfPhrases = numOfPhrases - firstHalfNumberOfPhrases;
		
		phrases = new ArrayList<>(numOfPhrases);
		
		Thread thread1 = new Thread(new MyWorker1());
		thread1.start();
		Thread thread2 = new Thread(new MyWorker2());
		thread2.start();
		thread2.join();
		
		//output each phrase
		for ( int index = 0; index < phrases.size(); index++ ) {
			System.out.println( phrases.get(index) );
		}//end print for loop
		
		
// 		for(int phrase = 0; phrase < numOfPhrases; phrase++) {
// 			String returnPhrase = nonTermHM.get("<start>").randomTerminal();
// 			System.out.println(returnPhrase);
// 		}
// //		String returnPhrase = nonTermHM.get("<start>").randomTerminal();
// //		return returnPhrase;
	}
}
