# Table of contents


|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Array Defenition](#1_Array-Defenition)    | 
|  2  |[Two Dimmension Array](#2_Two-Dimmension-Array)  |   
|  3  |[Sort Array](#3_sort-array)    |   
|  4  |[ArrayTargil_1](#4_ArrayTargil_1)   |   
|  5  |[ArrayTargil_2](#5_ArrayTargil_2) |
|  6  |[ArrayTargil_3_remove_duplocations](#6_ArrayTargil_3_remove_duplocations) |
|  7  |[ArrayTargil_4](#7_ArrayTargil_4) |
|  8  |[ArrayTargil_5](#8_ArrayTargil_5) |




## 1_Array Defenition

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
----------------------------------------------------------------------------------------------------------

## 2_Two Dimmension Array

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
----------------------------------------------------------------------------------------------------------

## 3_Sort Array

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
----------------------------------------------------------------------------------------------------------

## 4_ArrayTargil_1 

[Back_to_top](#Table-of-contents)

### Question: <br /> 

write a class that creates an array of 10 numbers with Random numbers between 0-100,<br />
and prints the total sum and the avarage.

### Answer: <br /> 

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

----------------------------------------------------------------------------------------------------------

## 5_ArrayTargil_2 

[Back_to_top](#Table-of-contents)

### Question: <br /> 

Write a class that creates an array[50] numbers with Random numbers between 0-100 <br />
and prints the highest value and its index in the array


### Answer: <br /> 

```java

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

```

----------------------------------------------------------------------------------------------------------

## 6_ArrayTargil_3_remove_duplocations 

[Back_to_top](#Table-of-contents)

### Question: <br /> 

Write a class that remove duplications of integer numbers. <br />
example: If I get receive a array of [1 ,2 ,5 ,1 ,6 ,1 ,5 ,4 ,8] <br />
I should return [1 ,2 ,5 ,6, 4, 8] <br />
Need to create a dynamic array <br />

### Answer: <br /> 

```java

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

		/**
		 * check for duplications, and update the length on the dynamic array
		 */
		int dynamicArrayLength = calculateDynamicArrayLength(array);

		/**
		 * define new array with the length calculated in the above code
		 * dynamicArrayLength number. I copy The first element of the array
		 * dynamicArray[0] should be same as original array. I start to add to the
		 * dynamicArray from its index 1 --> dynamicArray[1].
		 */

		int[] arrayWithoutDuplication = createNewArrayWithoutDuplication(array, dynamicArrayLength);

		return arrayWithoutDuplication;

	}

	private int[] createNewArrayWithoutDuplication(int[] array, int dynamicArrayLength) {

		int[] dynamicArray = new int[dynamicArrayLength];
		dynamicArray[0] = array[0];
		int index = 1;

		boolean isDuplicated = false;

		for (int i = 1; i < array.length; i++) {
			for (int j = i - 1; 0 <= j; j--) {
				if (array[i] == array[j])
					isDuplicated = true;
			}
			if (isDuplicated == false) {
				dynamicArray[index] = array[i];
				index++;
			}
			isDuplicated = false;
		}
		return dynamicArray;

	}

	private int calculateDynamicArrayLength(int[] array) {
		/**
		 * this will store the length of new dynamicArray
		 */
		int dynamicArrayLength = array.length;
		boolean isDuplicated = false;

		/**
		 * check for duplicated numbers. If isDuplicated == true, the dynamicArrayLength
		 * is subtracted by 1
		 */
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j])
					isDuplicated = true;
			}
			if (isDuplicated == true) {
				dynamicArrayLength--;
			}
			isDuplicated = false;
		}
		return dynamicArrayLength;
	}
}

```


----------------------------------------------------------------------------------------------------------

## 7_ArrayTargil_4 

[Back_to_top](#Table-of-contents)

### Question: <br /> 

Create an Array that reverse a given array order <br />
For example: for input of {6,8,4,2,7,5} the result should be {5,7,2,4,8,6} <br />
Create an array[10] of numbers with Random values between 0-10 o be used as input <br />
print the array before and after reversing <br />


### Answer: <br /> 

```java

import java.util.Arrays;
import java.util.Random;

public class ArrayTargil_4 {

	public static void main(String[] args) {
		
		/**
		 * Create an Array that reverse a given array order
		 * For example: for input of {6,8,4,2,7,5} the result should be {5,7,2,4,8,6}
		 * Create an array[10] of numbers with Random values between 0-10 o be used as input
		 * print the array before and after reversing
		 */
		
		int size = 10;
		int array[] = new int[size];
		int reversedArray[] = new int[size];
		Random r = new Random();
		
		// Initialize the array with random numbers
		for (int i = 0; i < array.length; i++) {
			array[i] = 1 + r.nextInt(10);			
		}
		
		for (int i = 0; i < array.length; i++) {
			reversedArray[size-1-i]=array[i];
		}
		
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(reversedArray));		
		
	}

}


```

----------------------------------------------------------------------------------------------------------

## 8_ArrayTargil_5 

[Back_to_top](#Table-of-contents)

### Question: <br /> 

create a class that calculates student average year grade. <br /> 
create a matrix according to the following: <br /> 
there are 20 students in the class. <br /> 
there are 10 different grades per student (randomize values between 0-100 as input) <br /> 
print each student avg grade <br /> 
print the class avg grade <br /> 
		 
### Answer: <br /> 

```java

import java.util.Random;

public class ArrayTargil_5 {

	public static void main(String[] args) {
		
		/**
		 * create a class that calculates student average year grade.
		 * create a matrix according to the following:
		 * there are 20 students in the class.
		 * there are 10 different grades per student (randomize values between 0-100 as input)
		 * print each student avg grade
		 * print the class avg grade
		 */
		
		float calcAvarage;
		float classAvarageGrade = 0;
		
		String studentName[] = {"Avraham", "Itschack", "Jacob",
								"Reuevn", "Shimon", "Levi",
								"Juda", "Isachar", "Zvulun",
								"Dan", "Asher" , "Gad",
								"Naftali", "Yosef", "Ninyamin",
								"Moshe", "Aharon" , "David",
								"Shlomo", "Shmuel"};
		
		int studentGrades[][] = new int[20][10];
		
		Random r = new Random();
		
		for (int i = 0; i < studentGrades.length; i++) {
			calcAvarage = 0;
			System.out.println("Grades of " + studentName[i] + " : ");
			for (int j = 0; j < studentGrades[j].length; j++) {
				studentGrades[i][j] = 1 + r.nextInt(100);
				System.out.print(" " + studentGrades[i][j] + ", ");
				calcAvarage = calcAvarage + studentGrades[i][j];
			}
			System.out.println(" \n Average grade of " + studentName[i] + " is : " + (calcAvarage/10) + " \n");
			classAvarageGrade = classAvarageGrade + (calcAvarage/10);
		}
		
		System.out.println("\n " + " class average grade is : " + (classAvarageGrade/20));
	}

}


```

----------------------------------------------------------------------------------------------------------

