###### _

<img src="https://img.shields.io/badge/-8. Generics %20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Lambda](#-)   | 
|  2  |[Method Reference](#-) |   
|  3  |[Functional Interfaces](#3)  |   
|  4  |[Generic Method, Interface , Class](#4) |
|     |[4.1. generic method](#4_1_generic_method) | 
|     |[4.2. generic interface](#4_2_generic_interface) | 
|     |[4.3. generic class](#4_3_generic_class) | 
|  5  |[Generic with Wildcard](#5) |   
|  6  |[Stream](#-) |   
|     |[Java 8 Interview Questions](https://javaconceptoftheday.com/java-8-interview-questions-and-answers/) | 


--------------------------------------------------------------------------------------------------

###### 1

<img src="https://img.shields.io/badge/-1.  %20-blue" height=40px>

```java
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

###### 6

<img src="https://img.shields.io/badge/-5.  %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
