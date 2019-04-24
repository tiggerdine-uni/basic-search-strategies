public class Main {

	/*
	 * Disclaimer: I know global variables in Java are bad.
	 */
	public static final String STRING = "Hello World!";
	public static final char[] CHARACTERS = STRING.toCharArray();
	public static final int NUMBER_OF_CHARACTERS = CHARACTERS.length;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		/*
		 * Uncomment one pair of lines at a time to run the genetic algorithm,
		 * the hill climber or the random string generator.
		 */
		GeneticAlgorithm g = new GeneticAlgorithm();
		g.run();
		// HillClimber h = new HillClimber();
		// h.run();
		// RandomStringer r = new RandomStringer();
		// r.run3();
		long stop = System.currentTimeMillis();
		System.out.println(stop - start + " ms to find the string \"" + STRING + "\"");
	}

}
