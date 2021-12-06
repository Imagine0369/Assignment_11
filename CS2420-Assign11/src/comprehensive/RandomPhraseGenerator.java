package comprehensive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RandomPhraseGenerator {
	
	private HashMap<String, NonTerminal> nonTermHM;

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
		File inputFile = new File(fileLocation);
		BufferedReader bf;
		try {
			bf = new BufferedReader( new FileReader( inputFile ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			bf = null;
		}
		String line;
		while ((line = bf.readLine()) != null) {
			boolean inputBegin = line.equals("{");
			if( inputBegin ) {
				String nonTerminalName = bf.readLine();
//				nonTermHM.put(nonTerminalName,8);
				String innerLine;
				while ((innerLine = bf.readLine()) != "}") {
					
				}
			}
			System.out.println(line);
//	        content.append(line);
//	        content.append(System.lineSeparator());
	    }
	}

}
