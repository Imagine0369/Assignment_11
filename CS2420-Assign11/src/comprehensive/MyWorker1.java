package comprehensive;

public class MyWorker1 implements Runnable {

	@Override
	public void run() {
		for(int phrase = 0; phrase < (RandomPhraseGenerator.firstHalfNumberOfPhrases); phrase++) {
			String returnPhrase = RandomPhraseGenerator.nonTermHM.get("<start>").randomTerminal();
			RandomPhraseGenerator.phrases.add(returnPhrase);
		}
		
	}

}
