
 # Sort using Comparable or Comparator

<dl>
  <dt>Question:</dt>
  <dd>How can we sort a list in JAVA</dd>  

  <dt>Answer:</dt>
	<dd>in order to <em>sort</em> a list in the JAVA ,</br>
	we need to know the strategy of sorting...</br >
	w/o a strategy the JAVA will not know if sort by id, height, name etc...</dd>
</dl>

		 (2) there are 2 ways to sort:
				1. implement comparable interface
				2. implement comparator interface
		
<dl>

  <dt>Comparable</dt>
  <dd>Comparable interface is implemented in the class itself - in the example its implemented in Person class.</br>
      Comparable :  is only suited for 1 Sort strategy implementation.</dd>  


  <dt>Comparator</dt>
	<dd>Comparator is implemented in an external class that leads to the multiple Sorting strategies Implementations</br>
	    For each Sort Strategy , we create a class that implements a suited Comparator implementation for that specific type</br>
	    Comparator : you can make as many as you like</dd>	
</dl>	




# Table of contents


|     |  Subjects                     |
|:---:|:------------------------------| 
|  1  |[Sort_Using Comparable](#1_Sort_Using_Comparable)    | 
|  2  |[Sort_Using Comparator](#2_Sort_Using_Comparator)  |   
|  3  |[Sort_Integer_Numbers](#3_Sort_Integer_Numbers) |   
|  4  |[Sort_String](#4_Sort_String)   |   
|  5  |[Sort_Enum](#5_Sort_Enum) |




## 1_Sort_Using_Comparable
[Back_to_top](#Table-of-contents)

Here the PErson Class Implements the Comparable which has only 1 method to implement :
- compareTo(Person o) 

And we cannot make more methods of compareTo(Person o) in the person Class</br>
thus we can have only strategy for Sorting.


[Back_to_top](#Table-of-contents)

```java
import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {

	private int id;
	private String name;
	private float height;
	private int age;

	public Person(int id, String name, float height, int age) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// (6) here we implement the sort strategy , we compare between this.id to 'o'
		// and return 1 , 0 , -1
		// 1 = means this.id is bigger ,
		// 0 = equals ,
		// -1 = smaller
		// below we compare by id

		// This way we compare each field in the object
		// if(this.id > o.id)
		// return 1;
		// if(this.id == o.id)
		// return 0;
		// return -1;

		// another way to do it
		return this.id - o.id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", height=" + height + ", age=" + age + "] \n";
	}

}

public class _1_Comparable_Implementaion {

	public static void main(String[] args) {

		// lets create array list of persons
		Person p1 = new Person(17, "shalem", 1.84f, 40);
		Person p2 = new Person(15, "karin", 1.63f, 35);
		Person p3 = new Person(20, "avigail", 1.2f, 5);
		Person p4 = new Person(11, "ariel", 1.5f, 5);

		// creating array list
		ArrayList<Person> listOfPersons = new ArrayList<Person>();

		// adding persons into the ArrayList
		listOfPersons.add(p1);
		listOfPersons.add(p2);
		listOfPersons.add(p3);
		listOfPersons.add(p4);

		// print before sorting
		System.out.println("before sorting");
		System.out.println(listOfPersons);

		// (1)
		// Question: How can we sort this list
		// answer : in order to sort a list in the JAVA
		// needs to know the strategy of sorting...
		// w/o a strategy the JAVA will not know if sort by id, height, name etc...

		// (2) there are 2 ways to sort:
		// 1. implement comparable interface
		// 2. implement comparator interface

		// (3) implement the comparable, we just pass the listOfPersons 
		// There is Only one strategy for Sorting which is: 
		// 1. Comparing By id  
		Collections.sort(listOfPersons);

		// print after sorting
		System.out.println("After sorting");
		System.out.println(listOfPersons);

	}

}

/**
 * Output:
 * 
 * Sorting done only on the id field which is an int type
 * 
 * before sorting [Person [id=17, name=shalem, height=1.84, age=40] , Person
 * [id=15, name=karin, height=1.63, age=35] , Person [id=20, name=avigail,
 * height=1.2, age=5] , Person [id=11, name=ariel, height=1.5, age=5] ]
 * 
 * After sorting [Person [id=11, name=ariel, height=1.5, age=5] , Person [id=15,
 * name=karin, height=1.63, age=35] , Person [id=17, name=shalem, height=1.84,
 * age=40] , Person [id=20, name=avigail, height=1.2, age=5] ]
 * 
 */

```
----------------------------------------------------------------------------------------------------------

## 2_Sort_Using_Comparator

[Back_to_top](#Table-of-contents)

Here we create 4 classes that Implement the Comparator, thus we will have 4 strategies for Sorting:
1. CompareByAge (int)
2. CompareByName (String)
3. CompareById (int)
4. CompareByHeight (float)
	

[Back_to_top](#Table-of-contents)
```java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// This Implementation Compares by name which is type "String"
class CompareByName implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

//This Implementation Compares by id which is type "int" 
class CompareById implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		// This way we compare each field in the object
		// if(o1.getId() > o2.getId())
		// return +1;
		// if(o1.getId() == o2.getId())
		// return 0;
		// return -1;

		// Shorter way to do it
		return o1.getId() - o2.getId();
	}
}

//This Implementation Compares by height which is type "float" 
class CompareByHeight implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getHeight() > o2.getHeight())
			return +1;
		if (o1.getHeight() == o2.getHeight())
			return 0;
		return -1;
	}
}

//This Implementation Compares a String
class CompareByAge implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getAge() - o2.getAge();
	}
}

class Person {

	private int id;
	private String name;
	private float height;
	private int age;

	public Person(int id, String name, float height, int age) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", height=" + height + ", age=" + age + "] \n";
	}

}

public class _2_Comparator_implementaion {

	public static void main(String[] args) {

		// lets create array list of persons
		Person p1 = new Person(17, "shalem", 1.84f, 40);
		Person p2 = new Person(15, "karin", 1.63f, 35);
		Person p3 = new Person(20, "avigail", 1.2f, 5);
		Person p4 = new Person(11, "ariel", 1.5f, 5);

		// creating array list
		ArrayList<Person> listOfPersons = new ArrayList<>();

		// adding persons into the ArrayList
		listOfPersons.add(p1);
		listOfPersons.add(p2);
		listOfPersons.add(p3);
		listOfPersons.add(p4);

		// print before sorting
		System.out.println("before sorting");
		System.out.println(listOfPersons);

		// (1)
		// We can see that we have 4 strategies to to Sorting:
		// 1. name (String)
		// 2. Age (int)
		// 3. height (float)
		// 4. id (int)

		// (2) there are 2 ways to sort:
		// implement comparator interface
		// In implement the comparator we need to pass to the Collections.sort() method
		// :
		// 1. the List we ant to sort (listOfPerson)
		// 2. the strategy ( CompareByAge , CompareByName , CompareByHeight ,
		// CompareById

		// (3) implement the comparator b Age
		Collections.sort(listOfPersons, new CompareByAge());
		System.out.println("After sorting By Age");
		System.out.println(listOfPersons);

		Collections.sort(listOfPersons, new CompareByName());
		System.out.println("After sorting by Name");
		System.out.println(listOfPersons);

		Collections.sort(listOfPersons, new CompareByHeight());
		System.out.println("After sorting by Height");
		System.out.println(listOfPersons);

		Collections.sort(listOfPersons, new CompareById());
		System.out.println("After sorting by Id");
		System.out.println(listOfPersons);

	}
}

/**
 
 Output:
 
	  before sorting
	  -------------------
	[Person [id=17, name=shalem, height=1.84, age=40] 
	, Person [id=15, name=karin, height=1.63, age=35] 
	, Person [id=20, name=avigail, height=1.2, age=5] 
	, Person [id=11, name=ariel, height=1.5, age=5] ]
	
	After sorting By Age
	-------------------
	[Person [id=20, name=avigail, height=1.2, age=5] 
	, Person [id=11, name=ariel, height=1.5, age=5] 
	, Person [id=15, name=karin, height=1.63, age=35] 
	, Person [id=17, name=shalem, height=1.84, age=40]]
	
	After sorting by Name
	-------------------
	[Person [id=11, name=ariel, height=1.5, age=5] 
	, Person [id=20, name=avigail, height=1.2, age=5] 
	, Person [id=15, name=karin, height=1.63, age=35] 
	, Person [id=17, name=shalem, height=1.84, age=40]]
	
	After sorting by Height
	-------------------
	[Person [id=20, name=avigail, height=1.2, age=5] 
	, Person [id=11, name=ariel, height=1.5, age=5] 
	, Person [id=15, name=karin, height=1.63, age=35] 
	, Person [id=17, name=shalem, height=1.84, age=40]]
	
	After sorting by Id
	-------------------
	[Person [id=11, name=ariel, height=1.5, age=5] 
	, Person [id=15, name=karin, height=1.63, age=35] 
	, Person [id=17, name=shalem, height=1.84, age=40] 
	, Person [id=20, name=avigail, height=1.2, age=5] 
	]
  
 */

```
----------------------------------------------------------------------------------------------------------


## 3_Sort_Integer_Numbers

[Back_to_top](#Table-of-contents)

```java
import java.util.ArrayList;
import java.util.Collections;

public class _3_SortIntegerNumbers {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<>();

		// Sorting by numbers
		numbers.add(3);
		numbers.add(-1);
		numbers.add(5);
		numbers.add(0);

		// execute sort
		Collections.sort(numbers);
		
		/**
		 * Question:
		 * 	how can we compare Integer numbers if we didn't implement the Comparable or Comparator?
		 * 
		 * Answer:
		 * 	the Integer class already implements the comparable interface thus we are able to 
		 *  sort the List numbers
		 *  
		 *  " public final class Integer extends Number implements Comparable<Integer> "
		 */
	}

}

```
----------------------------------------------------------------------------------------------------------


## 4_Sort_String

[Back_to_top](#Table-of-contents)
```java
import java.util.ArrayList;
import java.util.Collections;

public class _4_SortString {

	public static void main(String[] args) {

		// Sorting by String
		// There is importance for sorting with Capital letters to small letters
		// String with capital letters will be printed first when sorting
		// for example: 'Shabtay' will be printed before 'avigail' even though 'avigail'
		// starts with an 'a'
		// since 'Shabtay' starts with a capital letter

		ArrayList<String> names = new ArrayList<>();

		names.add("shabtay");
		names.add("shalem");
		names.add("karin");
		names.add("avigail");

		Collections.sort(names);
		
		/**
		 * Question:
		 * 	how can we compare Strings if we didn't implement the Comparable or Comparator?
		 * 
		 * Answer:
		 * 	the String class already implements the comparable interface thus we are able to 
		 *  sort the List numbers
		 *  
		 *  " public final class String implements java.io.Serializable, Comparable<String>, CharSequence { "
		 */
	}
}
```
----------------------------------------------------------------------------------------------------------

## 5_Sort_Enum

[Back_to_top](#Table-of-contents)
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum EmployeeType {
	EMPLOYEE, MANAGER, VP
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
		return "Employee [id=" + id + ", employeeType=" + employeeType + "] \n";
	}

	@Override
	public int compareTo(Employee o) {
		/**
		 * This compares the ENUM value by using the ordinal() method of the enum
		 */
		return this.employeeType.ordinal() - o.employeeType.ordinal();
	}
}

// Implementing Comparator to compare by Id (which is used later by Collections.sort
class CompareById implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getId() - arg1.getId();
	}

}

public class _5_Sort_Enum {

	public static void main(String[] args) {

		/**
		 * In this exercise we will use both: 
		 * 1. Comparator to sort Employee List the by Id
		 * 2. Comparable to sort Employee List by the ENUM
		 */
		
		
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
		System.out.println("List before sorting :\n" + emp);

		// Using Comparator to Sort ID
		Collections.sort(emp, new CompareById());

		// printing the list after sorting by ID
		System.out.println("List after sorting by ID : \n" + emp);

		/**
		 * Sort the ENUM Using Comparable method in the Employee class 
		 */
		Collections.sort(emp);

		// printing the list after sorting by EmployeeType
		System.out.println("List after sorting by ENUM EmployeeType : \n" + emp);

	}
}

/**
 Output:
 
	 List before sorting :
	 ----------------------
	[Employee [id=159, employeeType=MANAGER] 
	, Employee [id=853, employeeType=MANAGER] 
	, Employee [id=2345, employeeType=VP] 
	, Employee [id=5689, employeeType=EMPLOYEE] 
	, Employee [id=5468, employeeType=EMPLOYEE] 
	, Employee [id=1234, employeeType=MANAGER] 
	, Employee [id=7895, employeeType=EMPLOYEE]]
	
	List after sorting by ID : 
	--------------------------
	[Employee [id=159, employeeType=MANAGER] 
	, Employee [id=853, employeeType=MANAGER] 
	, Employee [id=1234, employeeType=MANAGER] 
	, Employee [id=2345, employeeType=VP] 
	, Employee [id=5468, employeeType=EMPLOYEE] 
	, Employee [id=5689, employeeType=EMPLOYEE] 
	, Employee [id=7895, employeeType=EMPLOYEE] ]
	
	List after sorting by ENUM EmployeeType :
	------------------------------------------ 
	[Employee [id=5468, employeeType=EMPLOYEE] 
	, Employee [id=5689, employeeType=EMPLOYEE] 
	, Employee [id=7895, employeeType=EMPLOYEE] 
	, Employee [id=159, employeeType=MANAGER] 
	, Employee [id=853, employeeType=MANAGER] 
	, Employee [id=1234, employeeType=MANAGER] 
	, Employee [id=2345, employeeType=VP] ]
 */

```
----------------------------------------------------------------------------------------------------------

