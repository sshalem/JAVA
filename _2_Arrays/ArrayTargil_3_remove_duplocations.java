package sort;

import java.util.Arrays;
import java.util.Random;

public class ArrayTargil_3_remove_duplocations {

	public static void main(String[] args) {

		/**
		 * Write a class that remove duplications of integer numbers. example: If I get
		 * receive a array of [1 ,2 ,5 ,1 ,6 ,1 ,5 ,4 ,8] I should return [1 ,2 ,5 ,6,
		 * 4, 8]
		 * 
		 * Need to create a dynamic array
		 */

		ArrayManipulation am = new ArrayManipulation();
		int[] generateRandomArray = am.generateRandomArray(10);
		int[] removeDuplications = am.removeDuplications(generateRandomArray);
		System.out.println(Arrays.toString(removeDuplications));
	}

}

class ArrayManipulation {

	public int[] generateRandomArray(int size) {

		int[] array = new int[size];
		Random random = new Random();

		// Generate an Array with Random numbers between 1 to 10
		for (int i = 0; i < size; i++) {
			array[i] = 1 + random.nextInt(10);
		}
		System.out.println(Arrays.toString(array));
		return array;
	}

	public int[] removeDuplications(int[] array) {

		int randomeSize = array.length;
		int duplicated = 0;

		// check for duplicated numbers.
		// If duplication is found, the randomSize of new array is subtracted by 1
		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; 0 <= j; j--) {
				if (array[i] == array[j])
					duplicated++;
			}
			if (0 < duplicated) {
				randomeSize--;
			}
			duplicated = 0;
		}

		// define new array with the size of the randomSize number
		int[] newSize = new int[randomeSize];
		int index = 1;
		newSize[0] = array[0];

		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; 0 <= j; j--) {
				if (array[i] == array[j])
					duplicated++;
			}
			if (duplicated == 0) {
				newSize[index] = array[i];
				index++;
			}
			duplicated = 0;
		}

		return newSize;

	}
}
