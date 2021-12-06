package comprehensive;

import java.util.ArrayList;

public class Terminal {
	
//	private ArrayList<String> nonTermNames = new ArrayList<>();
	private ArrayList<String> parsedTerm = new ArrayList<>();
	private boolean nonTermFirst;
	
	public Terminal(String terminalString) {
		StringBuilder nonTermName;// = new StringBuilder();
		StringBuilder termString;// = new StringBuilder();
		
		for (int index = 0; index < terminalString.length(); ) {
			//
			if( terminalString.charAt(index) == '<' ) {
				nonTermName = new StringBuilder();
				while( terminalString.charAt(index) != '>') {
					nonTermName.append(terminalString.charAt(index));
					
					index++;
				}
				nonTermName.append(terminalString.charAt(index));
				index++;
				String name1 = nonTermName.toString();
//				nonTermNames.add(name1);
				parsedTerm.add(name1);
			} else {
				//
				if( index < 1) {
					nonTermFirst = false;
				} else {
					nonTermFirst = true;
				}
				
				termString = new StringBuilder();
				
				while( index < terminalString.length() && terminalString.charAt(index) != '<' ) {
					termString.append(terminalString.charAt(index));
					
					index++;
				}
				String name1 = termString.toString();
				parsedTerm.add(name1);
			}
		}
//		System.out.println(name1);
//		System.out.println(nonTermNames);
		System.out.println(parsedTerm);
	}
	
	public String getString() {
//		for()
		return null;
	}

}
