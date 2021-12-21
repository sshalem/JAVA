package sort;

import java.util.Arrays;

public class MainSortArray {

	public static void main(String[] args) {

		int[] arr = { 2, 7, 4, 5, 11, -4, -2, 0, -7, 10 };
		int[] sortedArr = sort(arr);

		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] sort(int[] arr) {

		int temp;

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}
}
