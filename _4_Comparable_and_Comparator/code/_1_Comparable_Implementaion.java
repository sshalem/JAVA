package demo;

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