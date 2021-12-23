## Content Table(#main)

1. [Array Defenition](#arr-define)
2. [Two Dimmension Array](#2Dimenssion-array)


## Array Defenition [main content table](###Content-table)
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
