import java.util.Random;

/**
* A chromosome.
*/
public class Chromosome {

	public final int fitness;
	private static final Random random = new Random();
	public final String string;

	/**
	* Creates a random chromosome.
	*/
	public Chromosome() {
		char[] characters = new char[Main.NUMBER_OF_CHARACTERS];
		for (int i = 0; i < Main.NUMBER_OF_CHARACTERS; i++) {
			characters[i] = (char) (random.nextInt(95) + 32);
		}
		string = String.valueOf(characters);
		fitness = calculateFitness();
	}

	/**
	* Creates a chromosome.
	*/
	public Chromosome(String string) {
		this.string = string;
		fitness = calculateFitness();
	}

	/**
	* Calculates this chromosome's fitness.
	*/
	private int calculateFitness() {
		int fitness = 0;
		for (int i = 0; i < Main.NUMBER_OF_CHARACTERS; i++) {
			fitness += Math.abs(string.charAt(i) - Main.CHARACTERS[i]);
		}
		return fitness;
	}

	/**
	* Crosses this chromosome with another chromosome and returns two new
	* chromosomes.
	*/
	public Chromosome[] crossover(Chromosome parent) {
		char[] characters = string.toCharArray();
		char[] characters2 = parent.string.toCharArray();
		int crossoverPoint = random.nextInt(Main.NUMBER_OF_CHARACTERS - 1) + 1;
		char temp;
		for (int i = crossoverPoint; i < Main.NUMBER_OF_CHARACTERS; i++) {
			temp = characters[i];
			characters[i] = characters2[i];
			characters2[i] = temp;
		}
		return new Chromosome[] { new Chromosome(String.valueOf(characters)),
				new Chromosome(String.valueOf(characters2)) };
	}

	/**
	* Mutates this chromosome and returns a new chromosome.
	*/
	public Chromosome mutate(float mutationRate) {
		char[] characters = string.toCharArray();
		for (int i = 0; i < Main.NUMBER_OF_CHARACTERS; i++) {
			if (random.nextFloat() < mutationRate) {
				characters[i] = (char) (random.nextInt(95) + 32);
			}
		}
		return new Chromosome(String.valueOf(characters));
	}

}
