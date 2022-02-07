###### _

<img src="https://img.shields.io/badge/-JAVA Design Patterns%20-blue" height=70px>

### [link for creating UML</br>](#_)

<img src="https://img.shields.io/badge/Note-Repository%20must%20be%20PUBLIC%20in%20order%20to%20be%20able%20to%20use%20plantuml%20Proxy-red" height=35px>

```
http://www.plantuml.com/plantuml/proxy
```



[1. PlantUml Home Page](https://plantuml.com/) </br>
[2. Creat UML for JAVA](https://plantuml.com/class-diagram) </br>
[2. Blog of UML with GitHub](https://blog.anoff.io/2018-07-31-diagrams-with-plantuml/) </br>
[3. GitHub repo explained of GitHub usage with PlantUml](https://github.com/jonashackt/plantuml-markdown) </br>


|     |             |
|:---:|:------------------------------| 
|     |<img src="https://img.shields.io/badge/-UML fondamentals%20-blue" height=30px>  | 
|     |[Class, Inheritance, Interface , Composition, Dependency](#__)   |
|     |<img src="https://img.shields.io/badge/-Creational%20-blue" height=30px>  | 
|  1  |[Random](#)   | 
|  2  |[Random](#)   | 
|     |<img src="https://img.shields.io/badge/-Structural%20-blue" height=30px>  | 
|  3  |[Random](#)   | 
|  4  |[Random](#)   |  
|  5  |[Random](#)   | 
|     |<img src="https://img.shields.io/badge/-Behavioural%20-blue" height=30px>  | 
|  6  |[Random](#)   | 
|  7  |[Random](#)   | 
|  8  |[Random](#)   | 


------------------------------------------------------------------------------------------------------------------------------------
###### __

<img src="https://img.shields.io/badge/-UML Class, Inheritance, Interface , Composed , Dependency%20-blue" height=30px> 

![uml_diagram](https://user-images.githubusercontent.com/36256986/152887402-6b594459-0015-4e5d-9a0c-6b7f99888464.jpg)

### [Class UML](#__) 
```java
public class Animal {

	private int id;
	private String name;
	private int age;

	public Animal() {

	}

	public void printAnimalName() {
		System.out.println(this.name);
	}

	public int getYearOfBirth(int currentYear) {
		return currentYear - this.age;
	}
}
```

### [Inheritance (Extends)](#__)
```java
public class Shape {
}

public class Circle extends Shape{	
}
```

### [Interface(Implements)](#__)

```java
public interface orderDao {
}

public class OrderDaoImpl implements orderDao {
}
```

### [Composition](#__)

```java
public class Heart {
}

public class Hands {
}

public class Legs {
}

public class Person {
	private Heart heart;
	private Legs legs;
	private Hands hands;
}
```



[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)



------------------------------------------------------------------------------------------------------------------------------------
