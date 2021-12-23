# Content Table

1. [Array Defenition](#arr-define)
2. [Two Dimmension Array](#Two-Dimmension-Array)
3. [Sort](#sort-array)


## Array Defenition
```java
import java.util.Arrays;

public class ArraysDefenition {

	public static void main(String[] args) {

		/**
		 * ways to define array
		 */

		/**
		 * Array of int
		 */
		int[] arr1 = { 4, 5, 2, 7, 4, 10 };
		int[] arr2 = new int[20];

		/**
		 * Array of String
		 */
		String[] arr3 = { "shabtay", "karin", "avigail", "ariel", "odel", "itamar" };
		String[] arr4 = new String[10];

		/**
		 * Array of Objects
		 */
		Object[] arr5 = { new Integer(20), new Long(54654L), new Float(1654.4968f), new Double(5643623D),
				new String("Shabtay") };
		System.out.println(Arrays.toString(arr5));
	}
}

```
## Two Dimmension Array

```js
public class TwoDimmensionArray {

	public static void main(String[] args) {

		/*
		 * In this Array 3 - number of rows 7 - number of columns
		 */
		int[][] arr = new int[3][7];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(" A ");
			}
			System.out.println();
		}
	}
	
	/* This is how the output would look:
	 * 3 - rows
	 * 7- columns
	 * 
 	 *		A  A  A  A  A  A  A 
 	 *		A  A  A  A  A  A  A 
 	 *		A  A  A  A  A  A  A 
	 */

}
```

## Sort Array
```java
import java.util.Arrays;

public class SortArray {

	public static void main(String[] args) {

		int[] arr = { 2, 7, 4, 5, 11, -4, -2, 0, -7, 10 };
		int[] sortedArr = sort(arr);

		System.out.println(Arrays.toString(sortedArr));
	}

	public static int[] sort(int[] arr) {

		int temp;
		
		// This sorts the array in Ascending order
		// If I want to sort in Descending order , 
		// Need to chage the sign in the if statement  (arr[i] < arr[j])
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
```
