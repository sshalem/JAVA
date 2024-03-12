###### _

<img src="https://img.shields.io/badge/-JAVA Design Patterns%20-blue" height=70px>

### [link for creating UML</br>](#_)

<img src="https://img.shields.io/badge/Note-Repository%20must%20be%20PUBLIC%20in%20order%20to%20be%20able%20to%20use%20plantuml%20Proxy-brown" height=35px>

```
http://www.plantuml.com/plantuml/proxy
```



[1. PlantUml Home Page](https://plantuml.com/) </br>
[2. Create UML for JAVA](https://plantuml.com/class-diagram) </br>
[2. Blog of UML with GitHub](https://blog.anoff.io/2018-07-31-diagrams-with-plantuml/) </br>
[3. GitHub repo explained of GitHub usage with PlantUml](https://github.com/jonashackt/plantuml-markdown) </br>
[4. Design Patterns from Digital Ocean](https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial) </br>

|     |             |
|:---:|:------------------------------| 
|     |[UML](https://github.com/sshalem/JAVA/blob/master/_8_Design_Patterns/UML/README.md)|
|     |[<img src="https://img.shields.io/badge/-Creational%20-blue" height=30px>](https://github.com/sshalem/JAVA/tree/master/_10_Design_Patterns/Behavioural)  |
|  1  |[Singleton]()   | 
|  2  |[Factory]()   | 
|  3  |[Abstract Factory]()   | 
|  4  |[Builder](#4_builder)   | 
|  5  |[Prototype]()   | 
|     |[<img src="https://img.shields.io/badge/-Structural%20-blue" height=30px>](https://github.com/sshalem/JAVA/tree/master/_10_Design_Patterns/Behavioural)  |
|  1  |[Adapter]()   | 
|  2  |[Composite]()   | 
|  3  |[Proxy]()   | 
|  4  |[Flyweight]()   | 
|  5  |[Facade]()   | 
|  6  |[Bridge]()   | 
|  7  |[Decorator]()   | 
|     |[<img src="https://img.shields.io/badge/-Behavioural%20-blue" height=30px>](https://github.com/sshalem/JAVA/tree/master/10_Design_Patterns/Behavioural)  |
|  1  |[Template Method]()   |
|  2  |[Mediator]()   | 
|  3  |[Chain of Responsibility]()   | 
|  4  |[Observer]()   | 
|  5  |[Strategy]()   | 
|  6  |[Command]()   | 
|  7  |[State]()   | 
|  8  |[Visitor]()   | 
|  9  |[Interpreter]()   | 
|  10  |[Iterator]()   | 
|  11  |[Mamento (used for undo mechanism)](https://github.com/sshalem/JAVA/tree/master/10_Design_Patterns/Behavioural/Mamento)   | 


------------------------------------------------------------------------------------------------------

###### 4_builder

<img src="https://img.shields.io/badge/- 4. builder %20-blue" height=40px>

- Let's create a Builder for Window class. 
- In Window class I have 3 fields of : name, type, price.
- If I create an Instance of WIndow , then I need to set each field with data.
- With `Builder` I can do that with 1 line of code, which I set the name and type of Window



I do the the following:
1. create private fields in Window 
2. create 2 constructors , one public for creating a regular instance , second private constructor so I could use it in the `builder class` (must assign the private fileds with the Builder private fields).
3. create  getters/setter in Window class
4. create a inner class `public static class Builder` inside Window class , with private fields , same as in Window class
5. define a static method In WIndow class to return a `Builder instance`
6. generate set methods , whic returns the Builder Objcet (this)
7. define a `build` method which return a constructed instance of Window.

```java
public class Window {

	private String name;
	private String type;
	private int price;

	public Window() {
		super();
	}

	private Window(Builder builder) {
		super();
		this.name = builder.name;
		this.type = builder.type;
		this.price = builder.price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// static method which returns a Builder instance
	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "Window [name=" + name + ", type=" + type + "]";
	}

	/**
	 * static inner class Builder
	 */
	public static class Builder {

		private String name;
		private String type;
		private int price;

		public Builder() {
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setType(String type) {
			this.type = type;
			return this;
		}

		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}

		public Window build() {
			return new Window(this);
		}
	}
}
```

### [Example 2](#-)

- In this example , I will show that , that theier must be a sequence of methods.
- I created 3 interfaces which each one returns the next Interface in chain.
- I redefine the static method `builder` to return at first the `NameSetter` interface.
- Each interface in chain , returns the next interface in the chain , till we add  the `builder()` .

```java
public class Car {

	private String name;
	private String type;
	private int price;

	public Car() {
		super();
	}

	private Car(Builder builder) {
		super();
		this.name = builder.name;
		this.type = builder.type;
		this.price = builder.price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", type=" + type + ", price=" + price + "]";
	}

	// static method which returns a Builder instance
	public static NameSetter builder() {
		return new Builder();
	}

	public interface NameSetter {
		TypeSetter setName(String name);
	}

	public interface TypeSetter {
		PriceSetter setType(String type);
	}

	public interface PriceSetter {
		Builder setPrice(int price);

		Car build();
	}

	/**
	 * static inner class Builder
	 */
	public static class Builder implements NameSetter, TypeSetter, PriceSetter {

		private String name;
		private String type;
		private int price;

		public Builder() {
		}

		@Override
		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		@Override
		public Builder setType(String type) {
			this.type = type;
			return null;
		}

		@Override
		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}

		@Override
		public Car build() {
			return new Car(this);
		}
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------

