package comprehensive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class RandomPhraseGenerator {

	public static void main(String[] args) {
		try {
			BufferedReader bf = new BufferedReader( new FileReader( args[0] ) );
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
