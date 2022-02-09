###### _

<img src="https://img.shields.io/badge/-MAMENTO %20-blue" height=70px>


|     |             |
|:---:|:------------------------------| 
|  1  |[UML_of_Mamento (used for undo mechanism)](#__)   | 
|  2  |[Java_Code_of_Mamento](#___)   | 
|  3  |[plantuml Mamento](#____)   | 




------------------------------------------------------------------------------------------------------------------------------------
###### __

<img src="https://img.shields.io/badge/-UML_of_Mamento%20-blue" height=30px> 

* We use **MAMENTO Pattern** for undo mechanism. </br>
 The memento pattern is a software design pattern that provides the ability to restore an object to its previous state (UNDO via rollback)

![UML_MEMENTO](https://user-images.githubusercontent.com/36256986/153154289-5e62c553-f98d-47d1-b65f-a2e42e8e3267.PNG)


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)


------------------------------------------------------------------------------------------------------------------------------------

###### ___

<img src="https://img.shields.io/badge/-Java Code of Mamento%20-blue" height=30px> 

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


```java
```


```java
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
