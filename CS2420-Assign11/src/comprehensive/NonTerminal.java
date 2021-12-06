package comprehensive;

import java.util.ArrayList;
import java.util.Random;

public class NonTerminal {
	
	private ArrayList<Terminal> termArray;
	Random rand = new Random();
	
	public NonTerminal() {
		termArray = new ArrayList<>();
	}
	
	public void add(String terminalString) {
//		System.out.println(terminalString);
		
		termArray.add(new Terminal(terminalString) );
	}
	
	public void printFun(String terminalString) {
		System.out.println("The line of one terminal is: "+terminalString);
	}
	
	public String randomTerminal() {
		int termNumber = rand.nextInt( termArray.size() );
		return termArray.get(termNumber).getString();
	}

}
