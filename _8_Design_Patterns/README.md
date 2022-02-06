###### _

<img src="https://img.shields.io/badge/-JAVA Design Patterns%20-blue" height=70px>

|     |             |
|:---:|:------------------------------| 
|     |<img src="https://img.shields.io/badge/-UML fondamentals%20-blue" height=30px>  | 
|     |[Class, Inheritance, Interface , Composed](#__)   | 
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

<img src="https://img.shields.io/badge/-UML Class, Inheritance, Interface , Composed %20-blue" height=30px> 

### [Class](#__)

![uml_diagram](https://user-images.githubusercontent.com/36256986/152701193-f2ed4b2d-a2c5-4948-9c1c-b82c6d4dc8f4.jpg)


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

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

------------------------------------------------------------------------------------------------------------------------------------
