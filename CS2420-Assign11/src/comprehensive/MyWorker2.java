package comprehensive;

public class MyWorker2 implements Runnable {

	@Override
	public void run() {
		for (int phrase = 0; phrase < (RandomPhraseGenerator.secondHalfNumberOfPhrases); phrase++) {
			String returnPhrase = RandomPhraseGenerator.nonTermHM.get("<start>").randomTerminal();
			RandomPhraseGenerator.phrases.add(returnPhrase);

		}

	}
}
