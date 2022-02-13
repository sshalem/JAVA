###### _

<img src="https://img.shields.io/badge/-Threads Java Concurrency%20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Create Thread](#__)   | 


--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-Create Thread%20-blue" height=40px>

```java
public class MyRunnableThread implements Runnable {

	@Override
	public void run() {

		System.out.println("hello My Id is  : " + Thread.currentThread().getId());
		System.out.println("hello My Id is  : " + Thread.currentThread().getName());
		System.out.println("Thread Execution is finished");
	}
}


public class Main {
	public static void main(String[] args) {
		
		// Create an Instance of MyRunnableThread class
		Runnable myRunnable = new MyRunnableThread();
		
		// Create a Thread Instance , I gave it the name of `MyRunnable-Thread`
		Thread thread = new Thread(myRunnable, "MyRunnable-Thread");

		// activate the Trace
		thread.start();
		
		System.out.println("Main Thread is finished :" + Thread.currentThread().getName());
	}
}
```

The Output in console is follows:

```
Main Thread is finished :main
hello My Id is  : 13
hello My Id is  : MyRunnable-Thread
Thread Execution is finished
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------



###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------


###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)


--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)


--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-Create Thread%20-brightgreen" height=40px>

<img src="https://img.shields.io/badge/-application.properties : eureka discovery server%20-blue" height=25px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

