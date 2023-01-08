###### _


|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Enum Basic](#1_enum-basic)    | 
|  2  |[Enum methods](#2_Enum_methods)  |   
|  3  |[Enum_constructor](#3_Enum_constructor) |   
|  4  |[Enum_Switch_Case](#4_Enum_Switch_Case)   |   
|  5  |[Enum_Private_Field_Constructor_And_GetterSetter](#5_EnumPrivateFieldConstructorAndGetterSetter) |
|  6  |[Enum_Sort_Using_Compartor_and_Comparable](#6_Enum_Sort_Using_Compartor_and_Comparable) |





## 1_enum-basic

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

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

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

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

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

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

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

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

## 5_EnumPrivateFieldConstructorAndGetterSetter

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

```js

enum ErrorMessagesEnum {

    MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
    RECORD_ALREADY_EXISTS("Record already exists"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    NO_RECORD_FOUND("Record with provided id is not found"),
    AUTHENTICATION_FAILED("Authentication failed"),
    COULD_NOT_UPDATE_RECORD("Could not update record"),
    COULD_NOT_DELETE_RECORD("Could not delete record"),
    EMAIL_ADDRESS_NOT_VERIFIED("Email address could not be verified");

	private String errorMessage;

	private ErrorMessagesEnum(String errorMessage) {
		this.errorMessage = errorMessage;
		// Reminder : enum constructor called separately for each  constant
		// See the output
		System.out.println("Constructor called for : " + this.toString());
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

public class _5_EnumPrivateFieldConstructorAndGetterSetter {

	public static void main(String[] args) {
			
		String message = ErrorMessagesEnum.EMAIL_ADDRESS_NOT_VERIFIED.getErrorMessage();
		System.out.println(message);
		
		ErrorMessagesEnum.EMAIL_ADDRESS_NOT_VERIFIED.setErrorMessage("new EMAIL Error message to define in ENUM");
		String newMessage = ErrorMessagesEnum.EMAIL_ADDRESS_NOT_VERIFIED.getErrorMessage();
		System.out.println(newMessage);
	}

}

/**
	Output :
	
	Constructor called for : MISSING_REQUIRED_FIELD
	Constructor called for : RECORD_ALREADY_EXISTS
	Constructor called for : INTERNAL_SERVER_ERROR
	Constructor called for : NO_RECORD_FOUND
	Constructor called for : AUTHENTICATION_FAILED
	Constructor called for : COULD_NOT_UPDATE_RECORD
	Constructor called for : COULD_NOT_DELETE_RECORD
	Constructor called for : EMAIL_ADDRESS_NOT_VERIFIED
	Email address could not be verified
	new EMAIL Error message to define in ENUM
*/

```
----------------------------------------------------------------------------------------------------------

## 6_Enum_Sort_Using_Compartor_and_Comparable

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

```js

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum EmployeeType {
	EMPLOYEE, 
	MANAGER, 
	VP
}


// Employee Class implements comparable
class Employee implements Comparable<Employee> {

	private int id;
	private EmployeeType employeeType;

	public Employee(int id, EmployeeType employeeType) {
		super();
		this.id = id;
		this.employeeType = employeeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeType getTypeEmployee() {
		return employeeType;
	}

	public void setTypeEmployee(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeType=" + employeeType + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.employeeType.ordinal() - o.employeeType.ordinal();
	}
}


// Implementing Comparator to compare by Id (which is used later by Collections.sort
class CompareById implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getId() - arg1.getId();		
	}
	
}


// Main Class to run code
public class _6_Enum_Sort_Using_Compartor_and_Comparable {

	public static void main(String[] args) {

		Employee shabtay = new Employee(2345, EmployeeType.VP);
		Employee karin = new Employee(1234, EmployeeType.MANAGER);
		Employee avigail = new Employee(5468, EmployeeType.EMPLOYEE);
		Employee ariel = new Employee(5689, EmployeeType.EMPLOYEE);
		Employee odel = new Employee(7895, EmployeeType.EMPLOYEE);
		Employee father = new Employee(159, EmployeeType.MANAGER);
		Employee mother = new Employee(853, EmployeeType.MANAGER);
				
		ArrayList<Employee> emp = new ArrayList<>();
		
		emp.add(father);
		emp.add(mother);
		emp.add(shabtay);
		emp.add(ariel);
		emp.add(avigail);
		emp.add(karin);
		emp.add(odel);
		
		// printing the list
		System.out.println("List before sorting :\n"  + emp);
		
		Collections.sort(emp, new CompareById());
		
		// printing the list after sorting by ID
		System.out.println("List after sorting by ID : \n" +emp);
		
		Collections.sort(emp);
		
		// printing the list after sorting by EmployeeType
		System.out.println("List after sorting by EmployeeType : \n" + emp);

	}
}

```
----------------------------------------------------------------------------------------------------------

