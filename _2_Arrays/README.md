## Content Table

1. [Array Defenition](#arr-define)

##Array Defenition
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
