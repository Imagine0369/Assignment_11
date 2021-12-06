package comprehensive;

import java.util.ArrayList;

public class NonTerminal {
	
	private ArrayList<Terminal> termArray;
	
	public NonTerminal() {
		termArray = new ArrayList<>();
	}
	
	public void add(String terminalString) {
		System.out.println(terminalString);
	}
	
	public void printFun(String terminalString) {
	System.out.println("The line of one terminal is: "+terminalString);
	}

}
