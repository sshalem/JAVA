# Table of contents


|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Array Defenition](#arr-define)    | 
|  2  |[Two Dimmension Array](#Two-Dimmension-Array)      |   
|  3  |[Sort Array](#sort-array)    |   
|  4  |[exercise 1](#excersize-1)   |   
|  5  |                             |   

## Array Defenition

[Back_to_top](#Table-of-contents)
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

[Back_to_top](#Table-of-contents)
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

[Back_to_top](#Table-of-contents)
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

## excersize-1 

[Back_to_top](#Table-of-contents)

 * Write a class that creates an array of 10 numbers with Random numbers between 0-100 and prints the total sum and the avarage
 
```java
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
```

------------------------------------------------------------------------------------------------------



--------------------------------------------------------------------------------------

# spring-security 

* this is an  example
* markdown is fast
* pretty cool

# link example
1. [israel hayom](https://www.israelhayom.co.il/)
2. [hidavroot](https://www.hidabroot.org/)

# List example
1. item one
2. item two
3. item three

# Blockquotes :
> Dorothy followed her through many of the beautiful rooms in her castle.


### Blockquotes with Other Elements  :
> ### The quarterly results look great!
>
> - Revenue was off the chart.
> - Profits were higher than ever.
>
>  *Everything* is going according to **plan**.

### Blockquotes another example:
*   This is the first list item.
*   Here's the second list item.

    > A blockquote would look great below the second list item.

*   And here's the third list item.


# Code Blocks
To create code blocks, indent every line of the block by at least four spaces or one tab.

    <html>
      <head>
      </head>
    </html>

### Code Blocks
Code blocks are normally indented four spaces or one tab. When they’re in a list, indent them eight spaces or two tabs.

1.  Open the file.
2.  Find the following code block on line 21:

        <html>
          <head>
            <title>Test</title>
          </head>
		  

```
code fences
```

```js
codeFences.withLanguage()
```

```java
codeFences.withLanguage()
```

# checkbox

- [ ] Checkbox off
- [x] Checkbox on

# Add Inline HTML

<dl>
  <dt>Definition list</dt>
  <dd>Is something people use sometimes.</dd>

  <dt>Markdown in HTML</dt>
  <dd>Does *not* work **very** well. Use HTML <em>tags</em>.</dd>
</dl>

# Add Tables
Colons can be used to align columns.

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |

There must be at least 3 dashes separating each header cell.
The outer pipes (|) are optional, and you don't need to make the 
raw Markdown line up prettily. You can also use inline Markdown.

Markdown | Less | Pretty
--- | --- | ---
*Still* | `renders` | **nicely**
1 | 2 | 3

# Add image from current repository
Dependencies.JPG

# Add Image as url
![Image](https://images.unsplash.com/photo-1528132032628-89493baa1e29?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8Z3JlYXR8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80)
