import java.util.Arrays;
import java.util.Random;

public class RandomStringer {

	private final Random random;

	public RandomStringer() {
		random = new Random();
	}

	/*
	 * Generates random strings. Not good enough.
	 */
	public void run() {
		char[] characters;
		int i = 1;
		boolean terminate = false;
		while (!terminate) {
			characters = new char[Main.NUMBER_OF_CHARACTERS];
			for (int j = 0; j < Main.NUMBER_OF_CHARACTERS; j++) {
				characters[j] = (char) (random.nextInt(95) + 32);
			}
			if (Arrays.equals(characters, Main.CHARACTERS)) {
				terminate = true;
			} else {
				i++;
			}
			System.out.println(i + " " + String.valueOf(characters));
		}
		System.out.print("If you're reading this, a miracle has happened in ");
	}

	/*
	 * Generates random strings but restarts as soon as a wrong character is
	 * generated. Still not good enough.
	 */
	public void run2() {
		char[] characters;
		int i = 1;
		boolean terminate = false;
		while (!terminate) {
			characters = new char[Main.NUMBER_OF_CHARACTERS];
			for (int j = 0; j < Main.NUMBER_OF_CHARACTERS; j++) {
				char character = (char) (random.nextInt(95) + 32);
				if (character == Main.CHARACTERS[j]) {
					characters[j] = character;
				} else {
					break;
				}
			}
			if (Arrays.equals(characters, Main.CHARACTERS)) {
				terminate = true;
			} else {
				i++;
			}
			System.out.println(i + " " + String.valueOf(characters));
		}
		System.out.print("If you're reading this, a miracle has happened in ");
	}

	/*
	 * Generates random strings by generating random characters one at a time
	 * until the right character is generated.
	 */
	public void run3() {
		char[] characters;
		int i = 1;
		characters = new char[Main.NUMBER_OF_CHARACTERS];
		for (int j = 0; j < Main.NUMBER_OF_CHARACTERS; j++) {
			boolean terminate = false;
			while (!terminate) {
				char character = (char) (random.nextInt(95) + 32);
				System.out.println(i + " " + String.valueOf(characters).trim() + character);
				if (character == Main.CHARACTERS[j]) {
					characters[j] = character;
					terminate = true;
				} else {
					i++;
				}
			}
		}
		System.out.print("The random string generator took " + i + " characters and ");
	}

}
