import java.util.Random;

/**
* A genetic algorithm.
*/
public class GeneticAlgorithm {

	private static final float CROSSOVER_RATE = 0.75f;
	private static final float MUTATION_RATE = 0.05f;
	// POPULATION_SIZE must be even because children are born in pairs.
	private static final int POPULATION_SIZE = 1000;

	private Chromosome[] population;
	private Random random;

	public GeneticAlgorithm() {
		population = new Chromosome[POPULATION_SIZE];
		random = new Random();
		initialise();
	}

	/**
	* Runs the algorithm.
	*/
	public void run() {
		int generations = 0;
		do {
			Chromosome[] population2 = new Chromosome[POPULATION_SIZE];
			for (int i = 0; i < POPULATION_SIZE / 2; i++) {
				Chromosome[] chromosomes = select();
				if (random.nextFloat() < CROSSOVER_RATE) {
					chromosomes = chromosomes[0].crossover(chromosomes[1]);
				}
				population2[i * 2] = chromosomes[0].mutate(MUTATION_RATE);
				population2[i * 2 + 1] = chromosomes[1].mutate(MUTATION_RATE);
			}
			population = population2;
			// Uncomment to watch each tick.
			// try {
			// Thread.sleep(100);
			// } catch (InterruptedException e) {
			// e.printStackTrace();
			// }
			generations++;
			System.out.print(generations + " ");
		} while (!terminate());
		System.out.print("The genetic algorithm took " + generations + " generations and ");
	}

	/**
	* Gets the fittest chromosome.
	*/
	private Chromosome getFittestChromosome() {
		Chromosome fittestChromosome = population[0];
		for (int i = 1; i < POPULATION_SIZE; i++) {
			if (population[i].fitness < fittestChromosome.fitness) {
				fittestChromosome = population[i];
			}
		}
		return fittestChromosome;
	}

	/**
	* Initialises the population with random chromosomes.
	*/
	private void initialise() {
		for (int i = 0; i < POPULATION_SIZE; i++) {
			population[i] = new Chromosome();
		}
	}

	/**
	* Selects a pair of chromosomes using tournament selection.
	*/
	private Chromosome[] select() {
		// Grab two random chromosomes.
		int i = random.nextInt(POPULATION_SIZE);
		// System.out.println("i = " + i + ", population[" + i + "].fitness = "
		// + population[i].fitness);
		int i2;
		do {
			i2 = random.nextInt(POPULATION_SIZE);
		} while (i2 == i);
		// System.out.println("i2 = " + i2 + ", population[" + i2 + "].fitness =
		// " + population[i2].fitness);
		// They fight.
		int j = (population[i].fitness < population[i2].fitness ? i : i2);
		// System.out.println("j = " + j);
		// Grab another two random chromosomes.
		do {
			i = random.nextInt(POPULATION_SIZE);
		} while (i == j);
		// System.out.println("i = " + i + ", population[" + i + "].fitness = "
		// + population[i].fitness);
		do {
			i2 = random.nextInt(POPULATION_SIZE);
		} while (i2 == i || i2 == j);
		// System.out.println("i2 = " + i2 + ", population[" + i2 + "].fitness =
		// " + population[i2].fitness);
		// They fight.
		int j2 = (population[i].fitness < population[i2].fitness ? i : i2);
		// System.out.println("j2 = " + j2);
		// Return the winners.
		return new Chromosome[] { population[j], population[j2] };
	}

	/**
	* Returns true when it's time to terminate the algorithm.
	*/
	private boolean terminate() {
		Chromosome fittestChromosome = getFittestChromosome();
		System.out.println(fittestChromosome.string);
		if (fittestChromosome.fitness == 0) {
			// The target string has been evolved.
			return true;
		}
		return false;
	}

}
