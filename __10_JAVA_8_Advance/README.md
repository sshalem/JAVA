###### _

<img src="https://img.shields.io/badge/-JAVA 8 advance %20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Lambda](#-)   | 
|  2  |[Method Reference](#-) |   
|  3  |[Functional Interfaces](#3)  |   
|  4  |[temp](#-) |   
|  5  |[Java 8 Interview Questions](https://javaconceptoftheday.com/java-8-interview-questions-and-answers/) | 


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
		R apply(T t);
	}

	@FunctionalInterface
	public interface BiFunction<T, U, R> {
		R apply(T t, U u);
	}

	@FunctionalInterface
	public interface UnaryOperator<T> extends Function<T, T> {
		static <T> UnaryOperator<T> identity() {
			return t -> t;
		}
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
