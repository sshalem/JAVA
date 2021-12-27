package comparator;

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
