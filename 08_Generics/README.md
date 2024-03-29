###### _

<img src="https://img.shields.io/badge/-8. Generics %20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Lambda](#-)   | 
|  2  |[Method Reference](#-) |   
|  3  |[Functional Interfaces](#3)  |   
|  4  |[Generic Method, Interface , Class](#4_Generics) |
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

###### 4_Generics

<img src="https://img.shields.io/badge/-4_Generics  %20-blue" height=40px>

###### 4_1_generic_method

<img src="https://img.shields.io/badge/-4_1_generic_method  %20-green" height=35px>

In Generic method  show several examples:
1. [Before Generics](#Before_Generics)
2. [After Generics](#After_Generics)
3. [Example_2](#Example_2)
4. [Example_3](#Example_3)
5. [Example_4](#Example_4)
6. [Example_5](#Example_5)

In order to be able to use generic function, the attributes  must be Object (like Integer ,Float …) and not primitive types , for example:
* Generic can work with Object Integer[] arr_int = { 1, 2, 3 };
* Generic can't work with reference primitive  Int [] arr_int = { 1, 2, 3 };

###### Before_Generics

### [Before Generics](#Before_Generics)

```java
class MathClass {

	public void printArray(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public void printArray(Float[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public void printArray(Double[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

public class Main {

	public static void main(String[] args) {

		Integer[] arrInt = { 1, 2, 3 };
		Float[] arrFloat = { 1.1f, 1.7f, 1.9f, 2.9f };
		Double[] arrDouble = { 1.4, 2.5, 3.6 };

		MathClass mathClass = new MathClass();

		mathClass.printArray(arrInt);
		mathClass.printArray(arrFloat);
		mathClass.printArray(arrDouble);
	}
}
```

###### After_Generics

### [After Generics](#After_Generics)

```java
class MathClass {

	public <T> void printArray(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

public class Main {

	public static void main(String[] args) {

		Integer[] arrInt = { 1, 2, 3 };
		Float[] arrFloat = { 1.1f, 1.7f, 1.9f, 2.9f };
		Double[] arrDouble = { 1.4, 2.5, 3.6 };

		MathClass mathClass = new MathClass();

		mathClass.printArray(arrInt);
		mathClass.printArray(arrFloat);
		mathClass.printArray(arrDouble);
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

###### Example_2

### [Example 2](#Example_2)


In this Example I have a method:
* that take array  of generic `T[]`.
* I extend the generic `T` from `Number`
* I return a `Number`



```java
class MathClass {

	public <T extends Number> Number calcSum(T[] arr) {
		Double sum = 0d;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i].doubleValue();
		}
		return sum;
	}

//   In this Implementation which does the same I return `T` with casting.
//
//	@SuppressWarnings("unchecked")
//	public <T extends Number> T calcSum(T[] arr) {
//		Double sum = 0d;
//		for (int i = 0; i < arr.length; i++) {
//			sum = sum + arr[i].doubleValue();
//		}
//		return (T) sum;
//	}
}

public class Main {

	public static void main(String[] args) {

		Integer[] arrInt = { 1, 2, 3 };
		Float[] arrFloat = { 1.1f, 1.7f, 1.9f, 2.9f };
		Double[] arrDouble = { 1.4, 2.5, 3.6 };

		MathClass mathClass = new MathClass();

		Number calcSum = mathClass.calcSum(arrInt);
		Number calcSum2 = mathClass.calcSum(arrFloat);
		Number calcSum3 = mathClass.calcSum(arrDouble);
		
		System.out.println(calcSum + "," + calcSum2 + "," + calcSum3);		
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

###### Example_3

### [Example 3](#Example_3)

```java
class Person {
	private String name;
	private String age;

	Ctor/G/S/ToString
}

class Shape {
	private String color;
	private String shape;

	Ctor/G/S/ToString
}

class TemplateClass {

	public <T> Method[] checkInput(T t) {
		Method[] declaredMethods = t.getClass().getDeclaredMethods();		
		return declaredMethods;
	}

	public void displayMethods(Method[] methods) {
		for (Method method : methods) {
			System.out.println(method);
		}
	}
}

public class Main {

	public static void main(String[] args) {

		Shape shape = new Shape("green", "trianle");
		Person person = new Person("shabtay", "46");

		TemplateClass templateClass = new TemplateClass();

		Method[] checkInputShape = templateClass.checkInput(shape);
		Method[] checkInputPerson = templateClass.checkInput(person);
		
		templateClass.displayMethods(checkInputShape);
		templateClass.displayMethods(checkInputPerson);
		
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

###### Example_4

### [Example 4](#Example_4)

In this Example I have a method:
* that have 3 arguments as generic `T`.
* I return a Generic `T`
* I extend the generic `T` from `Comparable<T>`


```java
class TempClass {
	public <T extends Comparable<T>> T max(T a, T b, T c) {		
		T max = a;
		if (b.compareTo(a) > 0)
			max = b;
		if (c.compareTo(max) > 0)
			max = c;
		return max;
	}
}

public class Main {
	public static void main(String[] args) {

		TempClass tempClass = new TempClass();

		System.out.println(tempClass.max(23, 42, 1));
		System.out.println(tempClass.max("apples", "kiwi", " chicken"));
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

###### Example_5

### [Example 5](#Example_5)

Same example as before but using a Static method. </br>
Only for the example.

```java
public class Main {
	public static void main(String[] args) {
		System.out.println(max(23, 42, 1));
		System.out.println(max("apples", "kiwi", " chicken"));
	}

	public static <T extends Comparable<T>> T max(T a, T b, T c) {
		T max = a;
		if (b.compareTo(a) > 0)
			max = b;
		if (c.compareTo(max) > 0)
			max = c;
		return max;
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

###### 4_2_generic_interface

<img src="https://img.shields.io/badge/- 4_2_generic_interface %20-green" height=35px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

###### 4_3_generic_class

<img src="https://img.shields.io/badge/- 4_3_generic_class %20-green" height=35px>

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
