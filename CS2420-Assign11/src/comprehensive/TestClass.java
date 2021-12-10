package comprehensive;

import java.util.ArrayList;


public class TestClass {
	
	
	public static void main(String[] args) throws InterruptedException {
	    // Do 10000 lookups and use the average running time.
	    int timesToLoop = 1000;
	    
	    // For each problem size n . . .
	    for (int n = 100; n <= 2000; n += 100) {


	    	int[] arguments = {5, n}; //in this case there will be 5 non terminals, and the number of rules will be growing n
	    	//writes changes to file
	    	GrammerWriter.main(arguments);

	      long startTime, midpointTime, stopTime;

	      // First, spin computing stuff until one second has gone by.
	      // This allows this thread to stabilize.
	      startTime = System.nanoTime();
	      while (System.nanoTime() - startTime < 1000000000) { // empty block 
	      }
 
	
	      // Now, run the test.  
	      startTime = System.nanoTime();

	      for (int i = 0; i < timesToLoop; i++) {
	    	  RandomPhraseGenerator.main(arguments);
	      }

	      midpointTime = System.nanoTime();

	      // Run a loop to capture the cost of running the "timesToLoop" loop and 
	      // generating a random ISBN.
	      for (int i = 0; i < timesToLoop; i++) { 
	  
	      }

	      stopTime = System.nanoTime();

	      // Compute the time, subtract the cost of running the loop
	      // from the cost of running the loop and doing the lookups.
	      // Average it over the number of runs.
	      double averageTime = (((midpointTime - startTime) - (stopTime - midpointTime))
	          / (double) timesToLoop);

	      System.out.println(n + "\t" + averageTime);
	  }

	}
	

}
