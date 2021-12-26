package sort;

import java.util.Random;

public class ArrayTargil_2 {

	public static void main(String[] args) {

		/**
		 * Write a class that creates an array[50] numbers with Random numbers between
		 * 0-100 and prints , and prints the highest value and its index in the array
		 */

		int[] array = new int[50];
		int index = 0;
		int highestNum = 0;

		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(101);
			System.out.println(i + ":" + array[i]);
		}

		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				highestNum = array[i];
				index = i;
			}
			if (highestNum < array[i]) {
				highestNum = array[i];
				index = i;
			}
		}
		System.out.println(highestNum + " at index of " + index);

	}

}
