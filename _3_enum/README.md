# Table of contents


|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Enum Basic](#1_enum-basic)    | 
|  2  |[Enum methods](#2_Enum_methods)  |   
|  3  |[Sort Array](#3_sort-array)    |   
|  4  |[ArrayTargil_1](#4_ArrayTargil_1)   |   
|  5  |[ArrayTargil_2](#5_ArrayTargil_2) |
|  6  |[ArrayTargil_3_remove_duplocations](#6_ArrayTargil_3_remove_duplocations) |
|  7  |[ArrayTargil_4](#7_ArrayTargil_4) |
|  8  |[ArrayTargil_5](#8_ArrayTargil_5) |




## 1_enum-basic

[Back_to_top](#Table-of-contents)

```java
enum Color {
	RED,
	GREEN, 
	BLUE;
}

public class _1_EnumBasic {

	public static void main(String[] args) {
		Color c1 = Color.RED; 
		System.out.println(c1);
	}

}

```
----------------------------------------------------------------------------------------------------------

## 2_Enum_methods

[Back_to_top](#Table-of-contents)
```js
enum Days {
	SUNDAY, 
	MONDAY, 
	TUESDAY, 
	WEDNESDAY, 
	THURSDAY, 
	FRIDAY, 
	SATURDAY;
}


public class _2_Enum_methods {

	/**
	 * values(), ordinal() and valueOf() methods :
	• These methods are present inside java.lang.Enum.
	
	• values() method can be used to return all values present inside enum.
	• ordinal() method - Order is important in enums. By using ordinal() method, 
	  each enum constant index can be found, just like array index.
	• valueOf() method returns the enum constant of the specified string value, if exists.
		From <https://www.geeksforgeeks.org/enum-in-java/> 
	 */
	
	public static void main(String[] args) {
		
		//ordinal() -  returns the index of the enum in the Enum class
		Days days = Days.FRIDAY;
		System.out.println(days.ordinal());
		
		//values() - return all values present inside enum 
		Days[] values = Days.values();		
		for (Days day : values) {
			System.out.println(day);
		}
		
		// valueOf() - returns the enum constant of the specified string value, if exists
		Days day = Days.valueOf("FRIDAY");
		System.out.println(day);
	}

}
```
----------------------------------------------------------------------------------------------------------



