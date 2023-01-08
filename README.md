<img src="https://img.shields.io/badge/-JAVA%20-brightgreen" height=70px>

###### _

|     |  Subject           |
|:---:|:------------------------------| 
|     |[General concepts](#General_Concepts)   | 
|     | 1. [JVM, JDK, JRE](#1_JVM_JDK_JRE)                   |
|     | 2. [Hash, Equals](#2_Hash_Equals)                                       |
|     | 3. [Heap Stack](#3_HEAP_Stack)                         |
|     | 4. [Reflection](#4_reflection) |
|  1  |[Random](https://github.com/sshalem/JAVA/tree/master/_1_Random)   | 
|  2  |[Array](https://github.com/sshalem/JAVA/tree/master/_2_Arrays)  |   
|  3  |[ENUM](https://github.com/sshalem/JAVA/tree/master/_3_enum)  |   
|  4  |[Comparable & Comparator](https://github.com/sshalem/JAVA/tree/master/_4_Comparable_and_Comparator)  |   
|  5  |[Exceptions](https://github.com/sshalem/JAVA/tree/master/_5_Exceptions)  |   
|  6  |[IO](https://github.com/sshalem/JAVA/tree/master/_6_IO)    | 
|  7  |[Data Structure](https://github.com/sshalem/JAVA/tree/master/_7_Data_Structure)  |   
|  8  |[Generics](#-) | 
|  9  |[Threads (Concurrency)](https://github.com/sshalem/JAVA/tree/master/_8_Threads_Java_Concurrency) | 
|  10  |[Design Patterns](https://github.com/sshalem/JAVA/tree/master/10_Design_Patterns) |   
|  11 |[Java 8 Advance](https://github.com/sshalem/JAVA/tree/master/__10_JAVA_8_Advance) | 
|  12 |[JSON Jackson Serializations]() | 


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
![image](https://user-images.githubusercontent.com/36256986/211197075-42cbb6a5-27f2-4efd-aaac-61a2fcd974a9.png)







[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------

######

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

<img src="https://img.shields.io/badge/- X %20- green" height=30px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

---
