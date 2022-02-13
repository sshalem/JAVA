###### _

<img src="https://img.shields.io/badge/-Threads Java Concurrency%20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[How to Create Thread](#__)   | 
|  2  |[Race Condition](#__)   | 
|  3  |[synchronize , sleep , wait, notify, notify all](#__)   | 
|  4  |[Lock](#__)   | 
|  5  |[Semaphore](#__)   | 
|  6  |[CountDownLatch](#__)   | 
|  7  |[ReadWriteLock](#__)   | 
|  8  |[Volatile](#__)   | 
|  9  |[AtomicInteger](#__)   | 
|  10  |[AtomicLong](#__)   | 
|  11  |[ThreadPoolExecutor](#__)   | 
|  12  |[Executer Interface, ExecutorService Interface, Executers Class](#__)   | 
|  13 |[Executer Interface, ExecutorService Interface, Executers Class](#__)   | 
|  14 |[Future , CompletableFuture](#__)   | 
|  15 |[BlockingQueue](#__)   | 
|  16 |[ThreadPoolExecutor](#__)   | 
|  17 |[ConcurrentMap](#__)   | 


--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-1. How to Create Thread%20-blue" height=40px>

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
		MyRunnableThread myRunnable = new MyRunnableThread();
		
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

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/- %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
