<img src="https://img.shields.io/badge/-JAVA%20-brightgreen" height=70px>

###### _

|     |  Subject           |
|:---:|:------------------------------| 
|     |[General concepts](#General_Concepts)   | 
|     | 1. [JVM, JDK, JRE](#1_JVM_JDK_JRE)                   |
|     | 2. [Hash, Equals](#2_Hash_Equals)                                       |
|     | 3. [class ,Inner class , Interface](#3_class)                         |
|     | 4. [HEAP, STACK](#4_HEAP_Stack)                         |
|     | 5. [Reflection](#5_reflection) |
|     | 6. [Memory Analyzer](#6_memory_analyzer) |
|     | 7. [Garbage Collector](#7_garbage_collector) |
|  1  |[Random](https://github.com/sshalem/JAVA/tree/master/01_Random)   | 
|  2  |[Array](https://github.com/sshalem/JAVA/tree/master/02_Arrays)  |   
|  3  |[ENUM](https://github.com/sshalem/JAVA/tree/master/03_enum)  |   
|  4  |[Comparable & Comparator](https://github.com/sshalem/JAVA/tree/master/04_Comparable_and_Comparator)  |   
|  5  |[Exceptions](https://github.com/sshalem/JAVA/tree/master/05_Exceptions)  |   
|  6  |[IO](https://github.com/sshalem/JAVA/tree/master/06_IO)    | 
|  7  |[Data Structure](https://github.com/sshalem/JAVA/tree/master/07_Data_Structure)  |   
|  8  |[Generics](https://github.com/sshalem/JAVA/tree/master/08_Generics) | 
|  9  |[Threads (Concurrency)](https://github.com/sshalem/JAVA/tree/master/09_Threads_Java_Concurrency) | 
|  10  |[Design Patterns](https://github.com/sshalem/JAVA/tree/master/10_Design_Patterns) |   
|  11 |[Java 8 Advance](https://github.com/sshalem/JAVA/tree/master/11_JAVA_8_Advance) | 
|  12 |[JSON Jackson Serializations](https://github.com/sshalem/JAVA/tree/master/12_JSON_Jackson_Serializations) | 


------------------------------------------------------

######

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

<img src="https://img.shields.io/badge/- X %20- green" height=30px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

###### 2_Hash_Equals

<img src="https://img.shields.io/badge/- 2. Hash_Equals %20-blue" height=40px>

https://www.scaler.com/topics/hashcode-in-java/

What is hashing? </br>
* Hashing is the process of mapping the data to some representative integer value using the concept of hashing algorithms. 

What is hashcode in Java? </br>
* In Java, a hash code is an integer value that is linked with each object. 

<p align="center">
  <img src="https://user-images.githubusercontent.com/36256986/211196584-b5359cbf-714d-40a2-ba9d-b8d020915416.png" width="400px" height="150px"/>
</p>

### [The concept of hashCode in Java :](#-)

If two objects are equal, then their hashcode will be identical. </br>
However, the vice-versa is not always true. </br>
If there are two different objects at two different locations memory locations, they will have starkly different hashcodes. </br>

From <https://www.scaler.com/topics/hashcode-in-java/> 

<p align="center">
  <img src="https://user-images.githubusercontent.com/36256986/211196711-49aa202c-4757-4302-9fd6-1e9f96d0d047.png" width="400px" height="220px"/>
</p>

[1. Question:](#-) </br>
What is hashcode in Java?</br>
[Answer](#-): </br>
In Java, a hash code is an integer value that is linked with each object , it is a unique integer value. 

[2. Question:](#-) </br>
Why we need Hashcode?</br>
[Answer](#-): </br>
By using the Hashcode's unique number (Which is a Integer number) , </br>
We can uniquely identify an Object. </br>
So each Object has a unique hashcode. </br>


### [Note:](#-) </br>
Sometimes [2 different Objects](#-) can have the [same hashcode number](#-), Thus, we always have to override and implement the hashcode method by our self (We can generate the hashcode vie the IDE) in order to be in the safe side , that we will have a unique hashcode number.


[3. Question:](#-) </br>
Is the hashcode is the memory address of the object? </br>
[Answer](#-): </br>
NO.  (Objects Created in HEAP) </br>
But the hashCode algorithm uses the Objects memory address ,to generate the hashcode Integer number. </br>
In Java , we can never see the Objects memory address. That is managed by JVM </br>


[4. Question:](#-) </br>
Who creates the hashcode? </br>
[Answer](#-):  </br>
By default, all classes in Java inherit from the Object class provided by Java. </br>
Therefore, the Object class is the superclass to all other classes and it defines methods that all its subclasses share. </br>
This is the method that creates hashing. </br>

```java
public native int hashCode();
```

		As we can see the hashCode() method has no body in the method, there is no implementation. 
		How come it has no body in the method? Class Object is not an abstract class????
		It's because it is a declared as native method.
		
		A native method is a Java method, whose implementation is also written in another programming language such as C/C++
		Moreover, a method marked as native cannot have a body and should end with a semicolon.
		
		We can use them to:
			• implement an interface with system calls or libraries written in other programming languages
			• access system or hardware resources that are only reachable from the other language
			• integrate already existing legacy code written in C/C++ into a Java application
			• call a compiled dynamically loaded library with arbitrary code from Java
		
		(JNI - Java Native Interface )
		
		So where is the implementation of the hashCode() is?


[5. Question:](#-) </br>
What value the hashCode() method returns? </br>
Answer: </br>
The hashCode() method return an Integer value, created by Hashing Algorithm. </br>

[6. Question:](#-) </br>
Where the hashcode is stored? </br>
Answer: </br>
It's not store anywhere , because each time we need the hashcode, the native method will calculate it. </br>


### [Hash-Based Collections](#-)

An object’s hash code allows algorithms and data structures to put objects into compartments, just like letter types in a printer’s type case. </br>
The printer puts all “A” types into the compartment for “A”, and he looks for an “A” only in this one compartment.</br>
This simple system lets him find types much faster than searching in an unsorted drawer. </br>
That’s also the idea of hash-based collections, such as HashMap and HashSet. </br>

From <https://eclipsesource.com/blogs/2012/09/04/the-3-things-you-should-know-about-hashcode/> 

[Question:](#-) </br>
Why whenever we implement equals, we MUST also implement hashCode? </br>
[Answer:](#-) </br>
It is possible for 2 different Objects to share the same hashcode, like  “A“ and “µ” objects in the sketch below. </br>

<p align="center">
  <img src="https://user-images.githubusercontent.com/36256986/211197250-f4bad281-9133-4322-86f3-6404f92d6a60.png" width="300px" height="200px"/>
</p>

We know that number of possible hash codes (2^32) =  4,294,967,296. </br>
Also, the number of possible distinct objects is usually bigger than the number of possible hash codes </br>
Thus we need to check if Objects are equal and that there hashcode is same </br>


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

###### 3_class

<img src="https://img.shields.io/badge/- class ,Inner class, Annonymos class %20-blue" height=40px>

### [Member class](#-)

```java
public class Outer { 
	private int num; 
	public Outer(int num) {
		this.num = num;
	} 
	private int getNum() {
		return num;
	}
	 
	public class Inner { 
		public void show() {
			System.out.println("hello");
			System.out.println(getNum());
		} 
	} 
}
 

public class Main { 
	public static void main(String[] args) { 
		Outer.Inner obj = new Outer(7).new Inner();
		obj.show();
	}
}
```

### [Inner static class](#-)

```java
public class Outer { 
	public static int num; 
	public static int getNum() {
		return num;
	} 
	public static class Inner { 
		public void show() {
			System.out.println("hello");
			System.out.println(getNum());
		} 
	} 
}
 
public class Main { 
	public static void main(String[] args) { 
		Outer.Inner obj = new Outer.Inner();        
		obj.show(); 
	}
}
```

### [Inner static class](#-)

Here is an implementation of anonymous class, But It is MOSTLY used with an interface and not a class </br>

```java
public class Outer { 
	public void show() {
		System.out.println("class");
	} 
}
 
public class Main { 
	public static void main(String[] args) { 
		Outer obj = new Outer() {
			public void show() {
				System.out.println("override original class ");
			}
		}; 
		obj.show();
	}
}
```

Implementing with an interface:

```java
public interface Outer { 
	public void show(); 
}

public class Main { 
	public static void main(String[] args) { 
		Outer obj = new Outer() {
			public void show() {
				System.out.println("override original class ");
			}
		}; 
		obj.show();
	}
}
```

After Implementing with an interface , now we can use lambda expression , We cannot use lambda expression with a class:

```java
public interface Outer { 
	public void show(); 
}

public class Main { 
	public static void main(String[] args) { 
		Outer obj = () -> System.out.println("override original class ");
		obj.show();
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

###### 

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

<img src="https://img.shields.io/badge/- X %20- green" height=30px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

###### 

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

<img src="https://img.shields.io/badge/- X %20- green" height=30px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

###### 

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

<img src="https://img.shields.io/badge/- X %20- green" height=30px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

###### 

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

<img src="https://img.shields.io/badge/- X %20- green" height=30px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------
