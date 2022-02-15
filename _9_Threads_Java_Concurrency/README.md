###### _

<img src="https://img.shields.io/badge/-Threads Java Concurrency%20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Thread Life Cycle](#__)   | 
|  2  |[How to Create Thread](#___)   | 
|  3  |[sleep](#__)   | 
|  4  |[Race Condition](#__)   | 
|  5  |[synchronize, Lock, wait, notify, notify all](#__)   | 
|  6  |[DeadLock ,Yield](#__)   | 
|  7  |[Semaphore](#__)   | 
|  8  |[CountDownLatch](#__)   | 
|  9  |[ReadWriteLock](#__)   | 
|  10  |[Volatile](#__)   | 
|  11 |[AtomicInteger](#__)   | 
|  12 |[AtomicLong](#__)   | 
|  13 |[ThreadPoolExecutor](#__)   | 
|  14 |[Executer Interface, ExecutorService Interface, Executers Class](#__)   | 
|  15 |[Executer Interface, ExecutorService Interface, Executers Class](#__)   | 
|  16 |[Future , CompletableFuture](#__)   | 
|  17 |[BlockingQueue](#__)   | 
|  18 |[ThreadPoolExecutor](#__)   | 
|  19 |[ConcurrentMap](#__)   | 


--------------------------------------------------------------------------------------------------

###### ___

<img src="https://img.shields.io/badge/-1. How to Create Thread%20-blue" height=40px>

## [There are 2 ways to create a Thread:]()

<img src="https://img.shields.io/badge/-1.1. Create Class That extends Thread Class%20-brightgreen" height=27px>

```java
public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Thread Name : " + Thread.currentThread().getName());
		System.out.println("Thread " + Thread.currentThread().getName() + "Execution is finished");
	}
}


public class Main {
	public static void main(String[] args) {

		// Create an Instance of MyThread class
		MyThread myThread = new MyThread();

		// Create a Thread Instance , I gave it the name of `MyThread`
		Thread thread = new Thread(myThread, "MyThread");

		// activate the Trace
		thread.start();

		System.out.println("Main Thread is finished :" + Thread.currentThread().getName());
	}
}
```


<img src="https://img.shields.io/badge/-1.2. Creating Class that Implements the Runnable Interface%20-brightgreen" height=27px>

```java
public class MyRunnableThread implements Runnable {

	@Override
	public void run() {

		System.out.println("Thread Id : " + Thread.currentThread().getId());
		System.out.println("Thread Name : " + Thread.currentThread().getName());
		System.out.println("Thread "  + Thread.currentThread().getName() + "Execution is finished");
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

### The Output in console is follows:

```
Main Thread is finished :main
Thread Id : 13
Thread Name : MyRunnable-Thread
Thread MyRunnable-Thread Execution is finished
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

### Lets create Multiple Threads for the same Object:

```java
public class Main {
	public static void main(String[] args) {
		
		MyRunnableThread myRunnable = new MyRunnableThread();

		Thread t1 = new Thread(myRunnable, "<first>");
		Thread t2 = new Thread(myRunnable, "<second>");
		Thread t3 = new Thread(myRunnable, "<third>");
		Thread t4 = new Thread(myRunnable, "<forth>");

		// activate the Trace
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println("Main Thread is finished :" + Thread.currentThread().getName());
	}
}
```

### Console output shows : 
#### * they statred to run , but ```not at a chronical order```
#### * they finished to run, but  **_not at a chronical order_**

```
Thread Id : 13
Thread Name : <first>
Thread Id : 15
Thread Id : 16
Main Thread is finished :main
Thread Id : 14
Thread Name : <second>
Thread <second> Execution is finished
Thread Name : <forth>
Thread Name : <third>
Thread <first> Execution is finished
Thread <third> Execution is finished
Thread <forth> Execution is finished
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------



###### __

<img src="https://img.shields.io/badge/-2 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-3 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-4 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-5 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-6 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-7 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-8 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-9 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-10 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-11 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-12 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-13 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-14 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-15 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-16 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-17 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-18 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-19 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-20 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### __

<img src="https://img.shields.io/badge/-21 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
