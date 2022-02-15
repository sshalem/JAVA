###### _

<img src="https://img.shields.io/badge/-Threads : Java Concurrency%20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|  1  |[Thread Life Cycle](#1)   | 
|  2  |[Multi-Threading VS MultiTasking VS MultiProcessing](#2)   | 
|  3  |[How to Create Thread](#3)   | 
|  4  |[sleep](#4)   | 
|  5  |[Race Condition](#5)   | 
|  6  |[synchronize, Lock, wait, notify, notify all](#6)   | 
|  7  |[DeadLock ,Yield](#7)   | 
|  8  |[Semaphore](#8)   | 
|  9  |[CountDownLatch](#9)   | 
|  10 |[ReadWriteLock](#10)   | 
|  11 |[Volatile](#11)   | 
|  12 |[AtomicInteger](#12)   | 
|  13 |[AtomicLong](#13)   | 
|  14 |[Priority of Threads](#14)   | 
|  15 |[ThreadPoolExecutor](#15)   | 
|  16 |[Executer Interface, ExecutorService Interface, Executers Class](#16)   | 
|  17 |[Executer Interface, ExecutorService Interface, Executers Class](#17)   | 
|  18 |[Future , CompletableFuture](#18)   | 
|  19 |[BlockingQueue](#19)   | 
|  20 |[ThreadPoolExecutor](#20)   | 
|  21 |[ConcurrentMap](#21)   | 


--------------------------------------------------------------------------------------------------

###### 1

<img src="https://img.shields.io/badge/-1. Thread Life Cycle %20-blue" height=40px>

https://www.javatpoint.com/life-cycle-of-a-thread

Threads can go through five different status in its life cycle as shown below.

1. [New](#__) : When the thread instance is created, it will be in “New” state.
2. [Runnable](#__) : When the thread is started, it is called “Runnable” state.
3. [Running](#__) : When the thread is running, it is called “Running” state.
4. [Waiting](#__) : When the thread is put on hold or it is waiting for the other thread to complete, then that state will be known as “waiting” state.
5. [Terminated](#__) : When the thread is dead, it will be known as “terminated” state.

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------


###### 2

<img src="https://img.shields.io/badge/-2 %20-blue" height=40px>

https://www.javatpoint.com/multithreading-in-java

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)


-------------------------------------------------------------------------------------------------

###### 3

<img src="https://img.shields.io/badge/-3. How to Create Thread%20-blue" height=40px>

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


###### 4

<img src="https://img.shields.io/badge/-4. sleep %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 5

<img src="https://img.shields.io/badge/-5 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 6

<img src="https://img.shields.io/badge/-6 %20-blue" height=40px>


```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 7

<img src="https://img.shields.io/badge/-7. DeadLock ,Yield %20-blue" height=40px>

https://www.javatpoint.com/deadlock-in-java

1. What is deadlock and when it can occur?
2. What is Yield?

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 8

<img src="https://img.shields.io/badge/-8 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 9

<img src="https://img.shields.io/badge/-9 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 10

<img src="https://img.shields.io/badge/-10 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 11

<img src="https://img.shields.io/badge/-11 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 12

<img src="https://img.shields.io/badge/-12 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 13

<img src="https://img.shields.io/badge/-13 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 14

<img src="https://img.shields.io/badge/-14 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 15

<img src="https://img.shields.io/badge/-15 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 16

<img src="https://img.shields.io/badge/-16 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 17

<img src="https://img.shields.io/badge/-17 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 18

<img src="https://img.shields.io/badge/-18 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 19

<img src="https://img.shields.io/badge/-19 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 20

<img src="https://img.shields.io/badge/-20 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
