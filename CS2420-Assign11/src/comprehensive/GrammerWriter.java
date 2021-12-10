package comprehensive;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class GrammerWriter {
	
	public static void main (int[] args) {
		//[0] is number of non-terminals
		//[1] is number of rules per non-terminal
		
		try {
			FileWriter newFile = new FileWriter("mikesTestFile.g");
			newFile.write(NonTerminals(args[0],args[1]));
			newFile.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
//		System.out.println(NonTerminals(3, 3));
		
	}
	
	public static String produceGrammer(int numberOfRules, String nonTerminalName) {
		Random rand = new Random();
		String nTName = nonTerminalName;
		String test = "{\n" + "<" + nTName + ">\n";
		for(int i = 0; i < numberOfRules; i++) {
			test += (rand.nextInt(10) + "\n");
		}
		
		test += "}";
		
		return test;
		 
	}
	
	public static String NonTerminals(int numberOfProductions, int sizeOfEach) {
		if(numberOfProductions == 0) {
			return "";
		}
		
//		if(numberOfProductions == 1) {
//			return produceGrammer(sizeOfEach, "<start>");
//		}
		Random rand = new Random();
		String returnString = produceGrammer(sizeOfEach, "start") + "\n\n";
		for(int i = 1; i < numberOfProductions; i++) {
			Integer val = rand.nextInt(10);
			returnString+= produceGrammer(sizeOfEach, (val.toString()));
			returnString += "\n\n";
		}
		
		return returnString;
	}
	

}
