public class Main {

	public static final String STRING = "Hello World!";
	public static final char[] CHARACTERS = STRING.toCharArray();
	public static final int NUMBER_OF_CHARACTERS = CHARACTERS.length;

	public static void main(String[] args) {
		// Start the clock.
		long start = System.currentTimeMillis();

		// Run the genetic algorithm.
		GeneticAlgorithm g = new GeneticAlgorithm();
		g.run();

		// Run the hill climbing algorithm.
		// HillClimber h = new HillClimber();
		// h.run();

		// Run the random algorithm.
		// RandomStringer r = new RandomStringer();
		// r.run3();

		// Stop the clock.
		long stop = System.currentTimeMillis();

		// Print how long it took.
		System.out.println(stop - start + " ms to find the string \"" + STRING + "\"");
	}

}
