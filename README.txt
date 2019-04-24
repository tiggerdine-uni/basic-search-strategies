To use the demo, run the main method (in the Main class) and see the console. You will see something like

	The genetic algorithm took 106 generations and 59 ms to find the string "Hello World!"

The demo runs the genetic algorithm by default. By commenting

	GeneticAlgorithm g = new GeneticAlgorithm();
	g.run();

and uncommenting either

	// HillClimber h = new HillClimber();
	// h.run();

or

	// RandomStringer r = new RandomStringer();
	// r.run3();

you can try the hill climber or the random stringer.

The probability of generating a given string randomly is, assuming all display characters (from ' ' to '~') can be generated, (1/95)^l, where l is the length of the string. For example, the probability of generating "Hello World!" randomly is 1.8506178e-24, or about one in half a septillion. Those aren't good odds. What the random stringer actually does is generate random characters until it generates "H", then generate random characters until it generates "e" and so on and so forth.

Things you can play with are

1 The string being searched for

By changing the STRING constant (in the Main class), the genetic algorithm, hill climber and random stringer can search for whatever string you want (not just "Hello World!"). It goes without saying that longer strings are more difficult to find.

2 The genetic algorithm's constants

The genetic algorithm has three constants, CROSSOVER_RATE (two parents' probability of crossing over), MUTATION_RATE (a character's probability of being mutated) and POPULATION_SIZE (you guessed it, the size of the population). Changing these affects its performance. I used the recommended values of 75% and 5% for the crossover and mutation rates and 1000 for the population size. I found increasing the population size helped the genetic algorithm to find longer strings. 100 is good enough for "Hello World!", but not for even slightly longer strings like "Martin Tiggerdine". This is something to bear in mind when changing either the string behind searched for or the population size.