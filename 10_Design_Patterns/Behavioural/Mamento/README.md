###### _

<img src="https://img.shields.io/badge/-MAMENTO %20-blue" height=70px>


|     |             |
|:---:|:------------------------------| 
|  1  |[UML_of_Memento (used for undo mechanism)](#__)   | 
|  2  |[Java_Code_of_Memento](#___)   | 
|  3  |[plantuml Mamento](#____)   | 


<img src="https://img.shields.io/badge/-Definition%20-brightgreen" height=40px> 

### We use **MEMENTO Pattern** for undo mechanism. </br>
### The memento pattern is a software design pattern that provides the ability to restore an object to its previous state (UNDO via rollback)

------------------------------------------------------------------------------------------------------------------------------------
###### __

<img src="https://img.shields.io/badge/-UML_of_Mamento%20-blue" height=30px> 

![UML_MEMENTO](https://user-images.githubusercontent.com/36256986/153154289-5e62c553-f98d-47d1-b65f-a2e42e8e3267.PNG)

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)


------------------------------------------------------------------------------------------------------------------------------------

###### ___

<img src="https://img.shields.io/badge/-Java Code of Memento%20-blue" height=30px> 

### [Memento]()

```java
public class Memento {

	private String content;
	private String name;

	public Memento(String content, String name) {
		super();
		this.content = content;
		this.name = name;
	}

	/**
	 * G/S of content & name
	 */	
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)


### [CareTaker]()

```java
public class CareTaker {

	private List<Memento> states = new ArrayList<>();
	
	public void push(Memento memento) {
		this.states.add(memento);
	}

	public Memento pop() {
		int lastIndex = this.states.size() - 1;
		Memento popLastState = this.states.get(lastIndex);
		this.states.remove(popLastState);
		return popLastState;
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

### [Originator]()

```java
public class Originator {

	private String content;
	private String name;

	public Originator() {
		super();
	}

	/**
	* G/S of content & name
	*/

	public Memento createState() {
		return new Memento(content, name);
	}

	public void undoState(Memento memento) {
		content = memento.getContent();
	}

}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

### [MainMemento]()

```java
public class MainMemento {

	public static void main(String[] args) {
	
		// (1) Create Instances of Originator & CareTaker
		Originator originator = new Originator();
		CareTaker careTaker = new CareTaker();
		
		// (2) set contnet & name 
		originator.setContent("shabtay");
		originator.setName("shalem");
		
		// (3) create a state --> which return a Memento Object from Originator class
		Memento createState = originator.createState();
		
		// (4) add the Memento to the Stack (In our example I used List for Simplicity , but Stack is more handy at this situation)
		careTaker.push(createState);

		originator.setContent("karin");
		originator.setName("shalem");
		Memento createState2 = originator.createState();
		careTaker.push(createState2);

		originator.setContent("avigail");
		originator.setName("shalem");
		Memento createState3 = originator.createState();
		careTaker.push(createState3);

		// (5) to Undo , just need to call careTaker.pop()
		// Then we update the current state in te undoState() method 		
		// And now we can chceck the Content & Name if the current state and see if it was rollback
		originator.undoState(careTaker.pop());
		System.out.println(originator.getContent() + " " + originator.getName());
		
		originator.undoState(careTaker.pop());
		System.out.println(originator.getContent() + " " + originator.getName());
		
		originator.undoState(careTaker.pop());
		System.out.println(originator.getContent() + " " + originator.getName());

	}

}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)


------------------------------------------------------------------------------------------------------------------------------------

###### ____

<img src="https://img.shields.io/badge/-plantuml Mamento%20-blue" height=30px> 

```java
@startuml

class Originator{
-content : String
-name : String
..
+ Originator() : ctor
===
+getContent() : String
+setContent(String) : void
+createMemento() : Memento
+undoState(Memento) : void
}

class Memento{
-content : String
-name : String
..
+Memento(String,String) : ctor
==
+getContent() : String
+getName() : String
}

class CareTaker{
- states : List<Memento>
==
+ push(Memento) : void
+ pop() : Memento
}


Originator ..> Memento
CareTaker *..> Memento

class MainMemento{

==(main mathod)==
+ originator : Originator
+ careTaker : CareTaker

}


MainMemento ..> Originator
MainMemento ..> CareTaker 

@enduml
```


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)


------------------------------------------------------------------------------------------------------------------------------------
