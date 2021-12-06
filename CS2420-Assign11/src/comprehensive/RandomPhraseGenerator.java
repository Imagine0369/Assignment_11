package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RandomPhraseGenerator {
	
	private static HashMap<String, NonTerminal> nonTermHM = new HashMap<>();

	public static void main(String[] args) {
		//read in input stuff
		try {
			readInInput("src/comprehensive/"+args[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void readInInput(String fileLocation) throws IOException {
		//create file from file location
		File inputFile = new File(fileLocation);
		System.out.println("file is located at " + fileLocation);
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
		
		//while there is a next line, parse the data
		while ((line = bf.readLine()) != null) {
			//if a nonterminal section is beginning, create a NonTerminal Object
			boolean inputBegin = line.equals("{");
			if( inputBegin ) {
				String nonTerminalName = bf.readLine();
				System.out.println("NonTerminal's name is: " + nonTerminalName);
				//add to hashMap
				nonTermHM.put( nonTerminalName, new NonTerminal() );
				
				//while still inside the nonTerminal section
				String innerLine;
//				while ((innerLine = bf.readLine()) != "}") {
//					nonTermHM.get(nonTerminalName).add(innerLine);
//				}
			}//end inside curly brackets
	    }//end while loop to read the input File
	}

}
