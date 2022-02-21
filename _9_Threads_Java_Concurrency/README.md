###### _

<img src="https://img.shields.io/badge/-Threads : Java Concurrency%20-blue" height=70px>

|     |  Subject           |
|:---:|:------------------------------| 
|     |[Top 50 Java Thread Interview Questions](https://javarevisited.blogspot.com/2014/07/top-50-java-multithreading-interview-questions-answers.html?m=1#ixzz7JncfbQkM)   | 
|  1  |[Thread Life Cycle](#1)   | 
|  2  |[Thread vs Process vs Task](#2)   | 
|  3  |[How to Create Thread](#3)   | 
|  4  |[sleep](#4)   | 
|  5  |[Race Condition](#5)   | 
|  6  |[synchronize, Lock, wait, notify, notify all](#6)  | 
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

[Link to Life Cycle Of a Thread](https://www.javatpoint.com/life-cycle-of-a-thread)

Threads can go through **_five different status_** in its life cycle as shown below.

1. New
2. Active
3. Blocked / Waiting
4. Timed Waiting
5. Terminated

</br>

![Thread_Life_Cycle](https://user-images.githubusercontent.com/36256986/154082574-9662254e-23da-42fc-9f53-7ecd73a9a0ba.JPG)

1. [New](#__) : Whenever a new thread is created, it is always in the new state. For a thread in the new state, the code has not been run yet and thus has not begun its execution.
2. [Active](#__) : When a thread invokes the **start()** method, it moves from the new state to the active state. The active state contains two states within it:
	* **_Runnable_**: A thread, that is ready to run is then moved to the runnable state. In the runnable state, the thread may be running or may be ready to run at any given instant of time. It is the duty of the thread scheduler to provide the thread time to run, i.e., moving the thread the running state.</br>
A program implementing multithreading acquires a fixed slice of time to each individual thread. Each and every thread runs for a short span of time and when that allocated time slice is over, the thread voluntarily gives up the CPU to the other thread, so that the other threads can also run for their slice of time. Whenever such a scenario occurs, all those threads that are willing to run, waiting for their turn to run, lie in the runnable state. In the runnable state, there is a queue where the threads lie.
	* **_Running_**: When the thread gets the CPU, it moves from the runnable to the running state. Generally, the most common change in the state of a thread is from runnable to running and again back to runnable.
	
	
3. [Blocked / Waiting](#__) : Whenever a thread is inactive for a span of time (not permanently) then, either the thread is in the blocked state or is in the waiting state.
**For example** : a thread (let's say its name is A) may want to print some data from the printer. However, at the same time, the other thread (let's say its name is B) is using the printer to print some data. Therefore, thread A has to wait for thread B to use the printer. Thus, thread A is in the blocked state. A thread in the blocked state is unable to perform any execution and thus never consume any cycle of the Central Processing Unit (CPU). Hence, we can say that thread A remains idle until the **thread scheduler**  reactivates thread A, which is in the **waiting or blocked** state.</br>
When the main thread invokes the join() method then, it is said that the main thread is in the waiting state. The main thread then waits for the child threads to complete their tasks. When the child threads complete their job, a notification is sent to the main thread, which again moves the thread from waiting to the active state.</br>
If there are a lot of threads in the waiting or blocked state, then it is the duty of the thread scheduler to determine which thread to choose and which one to reject, and the chosen thread is then given the opportunity to run.

4. [Timed Waiting](#__) : Sometimes, waiting for leads to starvation. For example, a thread (its name is A) has entered the critical section of a code and is not willing to leave that critical section. In such a scenario, another thread (its name is B) has to wait forever, which leads to starvation. To avoid such scenario, a timed waiting state is given to thread B. Thus, thread lies in the waiting state for a **specific span of time**, and not forever.<br>
A real example of timed waiting is when we invoke the **sleep()** method on a specific thread. </br>
The **sleep()** method puts the thread in the timed wait state. After the time runs out, the thread wakes up and start its execution from when it has left earlier.

5. [Terminated](#__) : A thread reaches the termination state because of the following reasons: 
	* When a thread has finished its job, then it exists or terminates normally.
	* **Abnormal termination** : It occurs when some unusual events such as an unhandled exception or segmentation fault.
A terminated thread means the thread is no more in the system. In other words, the thread is dead, and there is no way one can respawn (active after kill) the dead thread.

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------


###### 2

<img src="https://img.shields.io/badge/-2. Thread vs Process vs Task %20-blue" height=40px>

[Process vs Thread vs Task](https://beginnersbook.com/2015/01/what-is-the-difference-between-a-process-and-a-thread-in-java/)

* [Question](#__):</br>
	* In Java : what is the difference between Process vs Task vs Thread?
	
* [Answer](#__):</br>
	* [Process](#__) : A program in execution 
	* [Thread](#__) : A thread is a subset(part) of the process.
	* [Task](#__) : A process is sometime referred as **task**

* New threads are easily created. However the creation of new processes require **duplication of the parent process**.

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)


-------------------------------------------------------------------------------------------------

###### 3

<img src="https://img.shields.io/badge/-3. How to Create Thread%20-blue" height=40px>

[There are two ways to create a thread:](#__)
1. By extending Thread class
2. By implementing Runnable interface.

By extending Thread class
By implementing Runnable interface.

### [1. Create Class That extends Thread Class](#__)

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


### [2. Creating Class that Implements the Runnable Interface](#__)

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

### [Multiple Threads for the same Object](#__)

```java
public class MyRunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println(" ---> Thread Name : " + Thread.currentThread().getName());
		System.out.println("Thread " + Thread.currentThread().getName() + " Execution is finished");
	}
}

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

		System.out.println("Main Thread is finished : " + Thread.currentThread().getName());
	}
}
```

### Console output shows : 
#### * they statred to run , but  ```not at a chronical order```
#### * they finished to run, but  ```not at a chronical order```

```
 ---> Thread Name : <first>
 ---> Thread Name : <third>
 ---> Thread Name : <forth>
Thread <forth> Execution is finished
Main Thread is finished : main
 ---> Thread Name : <second>
Thread <second> Execution is finished
Thread <first> Execution is finished
Thread <third> Execution is finished
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------


###### 4

<img src="https://img.shields.io/badge/-4. sleep %20-blue" height=40px>

**Thread.sleep()** in Java is being used to halt the working of a thread for a given amount of time.</br>
The time up to which the thread remains in the sleeping state is known as the **sleeping time of the thread**.</br>
After the sleeping time is over, the thread starts its execution from where it has left.

[Note:](#-) Sleep() method does not release the lock on object during Synchronization.

```java
public class MyRunnableThread implements Runnable {
	@Override
	public void run() {

		long startTime = LocalTime.now().toSecondOfDay();

		try {
			Thread.sleep(2000);
			System.out.println(" ---> Thread Name : " + Thread.currentThread().getName());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endTime = LocalTime.now().toSecondOfDay();
		long time = endTime - startTime;

		System.out.println("Thread Sleep " + time + " sec");
		System.out.println("Thread " + Thread.currentThread().getName() + " Execution is finished");
	}
}

public class Main {
	public static void main(String[] args) {

		MyRunnableThread myRunnable = new MyRunnableThread();

		Thread t1 = new Thread(myRunnable, "<first>");

		// activate the Trace
		t1.start();

		System.out.println("Main Thread is finished : " + Thread.currentThread().getName());
	}
}
```

### Console output shows : 

```
Main Thread is finished : main
 ---> Thread Name : <first>
Thread Sleep 2 sec
Thread <first> Execution is finished
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)


--------------------------------------------------------------------------------------------------


###### 5

<img src="https://img.shields.io/badge/-5. Race Condition %20-blue" height=40px>

**_Race conditions_** occur when two threads operate on the **_same object_** without proper synchronization </br>
and their operation interleaves on each other.

**[Two Types of Race Conditions](#-)** </br>

Race conditions can occur when two or more threads read and write the same variable according to one of these two patterns:

[1. Read-modify-write](#-)
[2. Check-then-act](#-)

	* The read-modify-write pattern means, that two or more threads first read a given variable, then modify its value and write it back to the variable. For this to cause a problem, the new value must depend one way or another on the previous value. The problem that can occur is, if two threads read the value (into CPU registers) then modify the value (in the CPU registers) and then write the values back. This situation is explained in more detail later.

	* The check-then-act pattern means, that two or more threads check a given condition, for instance if a Map contains a given value, and then go on to act based on that information, e.g. taking the value from the Map. The problem may occur if two threads check the Map for a given value at the same time - see that the value is present - and then both threads try to take (remove) that value. However, only one of the threads can actually take the value. The other thread will get a null value back. This could also happen if a Queue was used instead of a Map.

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 6

<img src="https://img.shields.io/badge/-6. synchronize, Lock, wait, notify, notify all %20-blue" height=40px>

### [synchronized](#-)

[See explanation of synchronization in link](https://github.com/sshalem/JAVA/blob/master/_9_Threads_Java_Concurrency/synchronization.md)

* [Question :](#-)
	*  What is a Monitor?

* [Answer:](#-)
	* in Java Concurrency, a [Monitor](#-) is a synchronization mechanism. [Monitor](#-) is a Method/block code, that is embedded with **synchronized** keyword.(The lock is implemented in the background automatically by JVM)


In the JVM, every object and class is logically associated with a Monitor. To implement the mutual exclusion capability of Monitors, a **Lock** (sometimes called a mutex) is associated with each object and class. (This is called a semaphore in operating systems) </br>

If one thread owns a **Lock** on some data, then **NO others** can obtain that **Lock** until the thread that owns the **Lock** releases it. It would be not convenient if we need to write a **[Semaphore](#8)** all the time when we do multi-threading programming.</br>
Luckily, we don't need to since JVM does that for us automatically.</br>

Each object/class is associated with a Monitor (beacuse it is with synchronized keyword), and following methods can only be invoked within a synchronized statement or synchronized method. (**wait(), notify(), notifyAll()** ) </br>

**[wait(), notify(), notifyAll()](#-)**

* These are final methods defined in the Object class and can be called **only from within a synchronized** context. </br>
	* **[wait](#-)** : **wait()** method causes the current thread to wait until another thread invokes the notify() or notifyAll() methods for that object.
	* **[notify()](#-)** : The notify() method wakes up a single thread that is waiting on that object’s **Monitor**.</br>
	* **[notifyAll()](#-)** : The notifyAll() method wakes up all threads that are waiting on that object’s **Monitor**. A thread waits on an object’s **Monitor** by calling one of the wait() method. These methods can throw **_IllegalMonitorStateException_** if the current thread is not the owner of the object’s **Monitor**.

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

<img src="https://img.shields.io/badge/-8. Semaphore %20-blue" height=40px>

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
