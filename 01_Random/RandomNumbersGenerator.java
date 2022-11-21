package sort;

import java.util.Random;

public class RandomNumbersGenerator {

	public static void main(String[] args) {

		// randomize number between 0-9
		Random random = new Random();
		int r1 = random.nextInt(10);
		System.out.println(r1);

		// randomize number between 20-49
		int r2 = 20 + random.nextInt(30);
		System.out.println(r2);

		/*********************************
		 * Using the Math.random() method
		 **********************************/

		// randomize number between 0-100
		int r3 = (int) (Math.random() * 101);
		System.out.println(r3);
	}
}
