# Table of contents


|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Enum Basic](#1_enum-basic)    | 
|  2  |[Enum methods](#2_Enum_methods)  |   
|  3  |[Enum_constructor](#3_Enum_constructor) |   
|  4  |[Enum_Switch_Case](#4_Enum_Switch_Case)   |   
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


## 3_Enum_constructor

[Back_to_top](#Table-of-contents)
```js
//Java program to demonstrate that enums can have constructor
//and concrete methods.

//An enum (Note enum keyword inplace of class keyword)
enum Colors {
	RED,
	GREEN,
	BLUE;

	// enum constructor called separately for each
	// constant
	private Colors() {
		System.out.println("Constructor called for : " + this.toString());
	}

	public void colorInfo() {
		System.out.println("Universal Color");
	}
}


public class _3_Enum_constructor {

	public static void main(String[] args) {
		Colors c1 = Colors.RED;
		System.out.println(c1);
		c1.colorInfo();
	}
}

/**
	Output: 
		Constructor called for : RED
		Constructor called for : GREEN
		Constructor called for : BLUE
		RED
		Universal Color
*/
```
----------------------------------------------------------------------------------------------------------


## 4_Enum_Switch_Case

[Back_to_top](#Table-of-contents)
```js

//A Java program to demonstrate working on enum
//in switch case 

//An Enum class
enum Day {
	SUNDAY, 
	MONDAY, 
	TUESDAY, 
	WEDNESDAY, 
	THURSDAY, 
	FRIDAY, 
	SATURDAY;
}

// Class that uses the ENUM as a field with getter/setter
class DaysOfWeek {

	private Day day;

	public DaysOfWeek(Day day) {
		this.day = day;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	// Prints a line about Day using switch
	public void dayIsLike() {
		switch (day) {
		case MONDAY:
			System.out.println("Mondays are bad.");
			break;
		case FRIDAY:
			System.out.println("Fridays are better.");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;
		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	}
}

public class _4_Enum_Switch_Case {

	public static void main(String[] args) {

		String str = "MONDAY";
		DaysOfWeek chosenDay = new DaysOfWeek(Day.valueOf(str));
		chosenDay.dayIsLike();
	}

}
```
----------------------------------------------------------------------------------------------------------

