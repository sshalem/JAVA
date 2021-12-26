package sort;

import java.util.Random;

public class ArrayTargil_1 {

	public static void main(String[] args) {

		/**
		 * Write a class that creates an array of 10 numbers with Random numbers between
		 * 0-100 and prints the total sum and the avarage
		 */

		int[] array = new int[10];
		float sum = 0;
		float avg = 0;

		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			sum = random.nextInt(101) + sum;
			System.out.println(sum);
		}

		avg = sum / array.length;

		System.out.println("Sum of number : " + sum);
		System.out.println("Average of number : " + avg);
	}

}
