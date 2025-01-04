###### _

<img src="https://img.shields.io/badge/-JAVA 8 advance %20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Lambda](#1_lambda)   | 
|  2  |[Method Reference](#-) |   
|  3  |[Functional Interfaces](#3)  |   
|  4  |[Stream](#-) |   
|     |[Java 8 Interview Questions](https://javaconceptoftheday.com/java-8-interview-questions-and-answers/) | 


--------------------------------------------------------------------------------------------------

###### 1_lambda

<img src="https://img.shields.io/badge/- 1. Lambda Expression  %20-blue" height=40px>

### Functionalities of Lambda Expression in Java

* See great eplanation in link https://www.geeksforgeeks.org/lambda-expressions-java-8/ 

* Lambda Expressions implement the only abstract function and therefore implement functional interfaces lambda expressions are added in Java 8 and provide the below functionalities.
* Functional Interfaces: Lambda expressions implement single abstract methods of functional interfaces.
* Code as Data: Treat functionality as a method argument.
* Class Independence: Create functions without defining a class.
* A lambda expression is a short block of code which takes in parameters and returns a value.
* Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

* Java lambda functions can be only used with `functional interfaces` (Functional Interface have only one method).
* How to make a Labmda Expression shoreter

![image](https://github.com/user-attachments/assets/126609cd-280d-40c6-acf9-7b95da0b768f)



### [Exapmles 1](#-)

- This lambda has no parameters and returns void.
- It’s similar to a method with an empty body: public void run() { }.
 
```java
@FunctionalInterface
public interface Temp {
	public void app();
}

// Implementation
Temp temp = new Temp() {
	@Override
	public void app() {
	}
};

// Short writing Implementaion , which is used
Temp temp = () -> {};
```

### [Exapmles 2](#-)

This lambda has no parameters and returns a String as an expression.
```java
@FunctionalInterface
public interface Temp {
	public String app();
}

// Implementation
Temp temp = new Temp() {
	@Override
	public String app() {
		return "lambda expression";
	}
};

// Short writing Implementaion
// using an explicit return statement, within a block
// We use this If we have more than 1 line of code in the method ,
// Thus, We add curly braces , and add the return statement
Temp temp = () -> {
	return "lambda expression";
};

// shorter way , since we have only one line of code
// We remove the return word , and set it all as 1 line of code
Temp temp = () -> "lambda expression";
```

### [Exapmles 3](#-)

This lambda has 1 paremeter and retruns none
```java
public interface Temp<T> {
	public void app(T t);
}

// Implementation
Temp<String> temp = new Temp<String>() {
	@Override
	public void app(String t) {
		System.out.println(t);
	}
};

// Short writing Implementaion
// using an explicit return statement, within a block
// We use this If we have more than 1 line of code in the method ,
// Thus, We add curly braces , and add the return statement
Temp<String> temp = (t) -> {
	System.out.println(t);
};


// shorter way , since we have only one line of code
// We remove the return word , and set it all as 1 line of code
Temp<String> temp = (t) -> System.out.println(t);
```

### [Exapmles 4](#-)

This FunctionalInterface `Predicate` has 1 parameter , and returns a boolean

```java
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}

// Implementation
Predicate<String> p = new Predicate<String>() {
	@Override
	public boolean test(String t) {
		return t == "shabtay" ? true : false;
	}
};

// Short writing Implementaion
Predicate<String> p = (t) -> {
	return t == "shabtay" ? true : false;
};

// SInce we have only 1 line of code,
// We can write it even shorter
Predicate<String> p = (t) -> t == "shabtay" ? true : false;
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 2

<img src="https://img.shields.io/badge/-2.  %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 3

<img src="https://img.shields.io/badge/-3. Functional Interfaces %20-blue" height=40px>

Below is the list of new functional interfaces introduced in Java 8. </br>
They have kept in **_java.util.function package_**

```java
@FunctionalInterface
public interface Predicate<T> {
	boolean test(T t);
}

@FunctionalInterface
public interface BiPredicate<T, U> {
	boolean test(T t, U u);
}

@FunctionalInterface
public interface Supplier<T> {
	T get();
}

@FunctionalInterface
public interface Consumer<T> {
	void accept(T t);
}

@FunctionalInterface
public interface BiConsumer<T, U> {
	void accept(T t, U u);
}

@FunctionalInterface
public interface Function<T, R> {
	// T t - Function argument 
	// R - result
	R apply(T t);
}

@FunctionalInterface
public interface BiFunction<T, U, R> {
	R apply(T t, U u);
}

@FunctionalInterface
public interface UnaryOperator<T> extends Function<T, T> {
	// Same as Function , But , Argument and Result should be the same Type (T)
	// UnLike in Function , That takes T as Argument and returns R 
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 4

<img src="https://img.shields.io/badge/-4.  %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 5

<img src="https://img.shields.io/badge/-5.  %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
