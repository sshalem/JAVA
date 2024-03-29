###### _

<img src="https://img.shields.io/badge/-Threads : Java Concurrency%20-blue" height=70px>

|     |  Subject           |              |
|:---:|:------------------------------|:-----| 
|     |[Top 50 Java Thread Interview Questions](https://javarevisited.blogspot.com/2014/07/top-50-java-multithreading-interview-questions-answers.html?m=1#ixzz7JncfbQkM)   |     |
|  1  |[Thread Life Cycle](#1)   |     |
|  2  |[Thread vs Process vs Task](#2)   |     |
|  3  |[How to Create Thread](#3)   | 		|
|  4  |[sleep](#4)   |  		|
|  5  |[Race Condition](#5)   |  		|
|  6  |[synchronize, Lock](#6)  |  		|
|  7  |[wait, notify, notify all](#7)  |  		|
|  8  |[join()](#8)   |  		|
|  9  |[interrupt()](#9)   |  		|
|  10 |[Semaphore](#10)   |  		|
|  11 |[Lock , ReentrantLock](#11)   |  		|
|  12 |[Lock , ReadWriteLock](#12)   |  		|
|  13 |[DeadLock ,Yield](#13)   |  		|
|  14 |[Volatile](#14)   |  		|
|  15 |[Atomic (Integer, Long, Boolean, Reference)](#15)   |  		|
|  16 |[Thread Scheduler](#16)   |  		|
|  17 |[BlockingQueue](#17)   |  		|
|  18 |[ThreadPoolExecutor - Executor framework](#18)   |  		|
|  19 |[Callable/Runnable](#19)   |  		|
|  20 |[Future](#20)   |  		|
|  21 |[CompletableFuture](#21)   |  		|
|     |	21.1		   |[Callback CompletableFuture](#21-1)	|
|     |	21.2		   |[Compose Dependent CompletableFuture](#21-2)	|
|     |	21.3		   |[Combine Independent CompletableFuture](#21-3)	|
|     |	21.4		   |[allOf() & anyOf() CompletableFuture](#21-4)	|
|  22 |[Fork/Join framework](#22)   |  		|
|  23 |[ConcurrentMap](#23)   |  		|




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

In a multi-threaded environment, a thread after executing few steps may be preempted by another thread. That may leave the shared data in an inconsistent state. For example take the simple task of incrementing a counter– **counter++**  </br>
This simple task of incrementing a counter is actually comprised of three steps

1. Read the value of counter variable.
2. Increment the value by 1.
3. Store the value of counter variable.
If there are two threads sharing this variable then the following scenario may happen-

```java
	int counter = 0;
	counter = counter + 1; // Thread 1
	counter = counter + 1; // Thread 2 started before thread 1 could save the new 
        	              //value of counter, so Thread 2 also got the initial value of counter as 0.
	store counter value // Thread 1
	store counter value // Thread 2
```

So you end up with the counter value as 1 rather than the correct value 2 because of the interleaving threads. </br>
That’s what race condition can do to a shared object in a multi-threaded environment.

### [Two Types of Race Conditions](#-) </br>

Race conditions can occur when two or more threads read and write the same variable according to one of these two patterns:

[Race Condition link](#-) : https://knpcode.com/java/multi-threading/race-condition-in-java/

1. **[Read-modify-write](#-)**</br>
The read-modify-write pattern means, that two or more threads first read a given variable, then modify its value and write it back to the variable. For this to cause a problem, the new value must depend one way or another on the previous value. The problem that can occur is, if two threads read the value (into CPU registers) then modify the value (in the CPU registers) and then write the values back. This situation is explained in more detail later.

```java
public class RaceConditionCounter implements Runnable {

	public int counter = 0;

	public void incrementCounter() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter++;
	}

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		incrementCounter();
		System.out.println(Thread.currentThread().getName() + " - " + getCounter());
	}
}

public class Main {

	public static void main(String[] args) {

		RaceConditionCounter rcc = new RaceConditionCounter();

		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(rcc, "state-" + i);
			thread.start();
		}
	}
}
```

### Console output shows : </br>
#### As we can see Thread 7, 9, 6 ,8 have got the same value 4, Thread 3 ,4 got the same value 7.

```java
Thread-7 - 4
Thread-5 - 5
Thread-9 - 4
Thread-4 - 7
Thread-6 - 4
Thread-8 - 4
Thread-1 - 9
Thread-2 - 8
Thread-3 - 7
Thread-0 - 10
```

2. **[Check-then-act](#-)**</br>
The **check-then-act** pattern means, that two or more threads check a given condition, for instance if a Map contains a given value, and then go on to act based on that information, e.g. taking the value from the Map.</br>
The problem may occur if **two or more threads** check the Map for a given value at the same time - see that the value is present - and then both threads try to take (remove) that value.</br>
However, only one of the threads can actually take the value. </br>
The other thread will get a null value back. This could also happen if a Queue was used instead of a Map.

[Solution : use **synchronized** medthod (see section 6)](#-)

Code example of **Check-On-Act** (method not synchronized)

```java
public class BuyBook implements Runnable {

	private Map<String, Integer> products = new HashMap<>();

	public BuyBook() {
		products.put("BOOK", new Integer(1));
	}

	public String buyProduct(String key) {
		if (products.containsKey(key)) {
			Integer quantity = products.get(key);
			if (!quantity.equals(new Integer(0))) {
				quantity--;
				products.put(key, quantity);
				return "Processing Succsessful. " + Thread.currentThread().getName();
			}
		}
		return "Oops!! out of stock" + Thread.currentThread().getName();
	}

	@Override
	public void run() {
		System.out.println("Buy Book --> " + buyProduct("BOOK"));
	}
}

public class Main {
	public static void main(String[] args) {

		BuyBook buyBook = new BuyBook();

		Thread student1 = new Thread(buyBook, "Student-1");
		Thread student2 = new Thread(buyBook, "Student-2");
		Thread student3 = new Thread(buyBook, "Student-3");

		student1.start();
		student2.start();
		student3.start();
	}
}
```

### Console output shows : 

```java
Buy Book --> Processing Succsessful. Student-1
Buy Book --> Processing Succsessful. Student-2
Buy Book --> Processing Succsessful. Student-3

or

Buy Book --> Processing Succsessful. Student-1
Buy Book --> Oops!! out of stockStudent-3
Buy Book --> Processing Succsessful. Student-2
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 6

<img src="https://img.shields.io/badge/-6. synchronize, Lock%20-blue" height=40px>

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
public class PrintIndexLoop implements Runnable {

	public void printIndex() {
		for (int i = 0; i < 5; i++) {
			System.out.print(Thread.currentThread().getName() + ":" + i + " ,");
		}
		System.out.println();
	}

	@Override
	public void run() {
		printIndex();
	}
}

public class Main {

	public static void main(String[] args) {

		PrintIndexLoop printIndexLoop = new PrintIndexLoop();

		for (int i = 1; i <= 5; i++) {
			Thread thread = new Thread(printIndexLoop, "[th-" + i + "]");
			thread.start();
		}
	}
}
```

### Console output shows a mess: 
### a thread after executing few steps may be preempted by another thread
### Thats why wee see a mess

```java
[th-1]:0 ,[th-1]:1 ,[th-1]:2 ,[th-1]:3 ,[th-1]:4 ,
[th-2]:0 ,[th-3]:0 ,[th-3]:1 ,[th-2]:1 ,[th-3]:2 ,[th-2]:2 ,[th-3]:3 ,[th-2]:3 ,[th-3]:4 ,
[th-2]:4 ,
[th-4]:0 ,[th-5]:0 ,[th-4]:1 ,[th-5]:1 ,[th-4]:2 ,[th-4]:3 ,[th-4]:4 ,
[th-5]:2 ,[th-5]:3 ,[th-5]:4 ,
```

Lets add the **synchronized** keyword a see if the a Thread holds a key, what console will show.

```java
public class PrintIndexLoop implements Runnable {

	public synchronized void printIndex() {
		for (int i = 0; i < 5; i++) {
			System.out.print(Thread.currentThread().getName() + ":" + i + " ,");
		}
		System.out.println();
	}

	@Override
	public void run() {
		printIndex();
	}
}
```

### Console output shows : 
#### Once a Thread starts execution, it holds a Lock. 
#### The Thread doesn't release the Lock till it finishes running, then Next THread holds the Lock, and realeases the Lock flag only it finishes , etc...

```java
[th-1]:0 ,[th-1]:1 ,[th-1]:2 ,[th-1]:3 ,[th-1]:4 ,
[th-3]:0 ,[th-3]:1 ,[th-3]:2 ,[th-3]:3 ,[th-3]:4 ,
[th-2]:0 ,[th-2]:1 ,[th-2]:2 ,[th-2]:3 ,[th-2]:4 ,
[th-4]:0 ,[th-4]:1 ,[th-4]:2 ,[th-4]:3 ,[th-4]:4 ,
[th-5]:0 ,[th-5]:1 ,[th-5]:2 ,[th-5]:3 ,[th-5]:4 ,
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 7

<img src="https://img.shields.io/badge/-7. wait, notify, notify all%20-blue" height=40px>

The Object class in Java has three final methods that allow threads to communicate about the locked status of a resource.

1. [wait()](#-) </br>
It tells the calling thread to give up the **_lock_** and go to sleep until some other thread enters the same monitor and calls **_notify()_**. 
The **_wait()_** method releases the **_lock_** prior to waiting and reacquires the **_lock_** prior to returning from the **_wait()_** method. 
The **_wait()_** method is actually tightly integrated with the **_synchronization lock_**, using a feature not available directly from the **_synchronization mechanism_**.


2. [notify()](#-) </br>
It wakes up one **_single thread_** that called **_wait()_** on the same object. 
It should be noted that calling **_notify()_** does not actually give up a **_lock_** on a resource. 
It tells a waiting thread that that thread can wake up. 
However, the **_lock_** is not actually given up until the **_notifier’s synchronized block has completed_**.</br>
So, if a notifier calls **_notify()_** on a resource but the notifier still needs to perform 10 seconds of actions on the resource within its **_synchronized block_**, 
the thread that had been waiting will need to wait at least another additional 10 seconds for the notifier to release the lock on the object, even though notify() had been called.

3. [notifyAll()](#-) </br>
It wakes up **_all the threads_** that called **_wait()_** on the same object. 
The highest priority thread will run first in most of the situation, though not guaranteed. 
Other things are same as notify() method above.

The threads can communicate with each other through wait(), notify() and notifyAll() methods in Java. </br>
These are final methods defined in the Object class and can be called only from within a synchronized context. </br>
The wait() method causes the current thread to wait until another thread invokes the notify() or notifyAll() methods for that object. </br>
The notify() method wakes up a single thread that is waiting on that object’s monitor. </br>
The notifyAll() method wakes up all threads that are waiting on that object’s monitor. </br>
A thread waits on an object’s monitor by calling one of the wait() method. </br>
These methods can throw **_IllegalMonitorStateException_** if the current thread is not the owner of the object’s monitor.</br>

### [Example using wait() & notifyAll()](#-)

In the following code I use the wait() and notifyAll() methods.
I created a class of **_HospitalRunnable_** .
In the class constructor , I initialize a Queue with number from 1 till 30.
In main() method I create 5 Threads of **_HospitalRunnable_**.
Once code runs, each Thread comes to **_bloodCheck()_** method.

* Gets anumber from the Queue
* Sleeps for a random time (Max sleep time 3000 ms)
* then gets a test with Doctor.

At the Doctor, each patient will be get diagnose according to the number he got from the queue.
See the result of Console with explanation.

```java
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class HospitalRunnable implements Runnable {

	public int nextInLine = 1;

	private Queue<Integer> numberInLine;

	public HospitalRunnable() {
		this.numberInLine = new ArrayDeque<Integer>();
		for (int i = 1; i <= 100; i++) {
			this.numberInLine.add(i);
		}
	}

	private synchronized void doDoctortest(int currentPatientNumber, String patientNumber) throws InterruptedException {
		while (currentPatientNumber != nextInLine) {
			print(" at Doctor : " + patientNumber + "--> waiting");
			wait();
		}
		print(" at Doctor : " + patientNumber + ", finished ");
		nextInLine++;
		notifyAll();
	}

	private void bloodCheck() throws InterruptedException {

		Integer patientNumber = numberInLine.remove();
		print("at blood Check patient: " + patientNumber);

		Random random = new Random();
		int sleepTime = random.nextInt(3000);

		Thread.sleep(sleepTime);

		print("Finished Blood Checked, patient :" + patientNumber);

		doDoctortest(patientNumber, "patient number : " + patientNumber);

	}

	private void print(String message) {
		System.out.println(message);
	}

	@Override
	public void run() {
		try {
			bloodCheck();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Main {
	public static void main(String[] args) {

		HospitalRunnable hospitalRunnable = new HospitalRunnable();

		for (int i = 1; i <= 5; i++) {
			Thread thread = new Thread(hospitalRunnable);
			thread.start();
		}
	}
}
```

### Console output shows : 
#### (note that the output may vary each time we run the code)

Once the program runs ,each Thread starts: 
* Once each Thread gets to the bloodCheck() method, The Current Thread takes a number from the queue
* Sleeps for a random time (Each Thread sleeps for a Different Time)
* Console shows all Threads arrived and got anumber from the Queue
* (No always arrive in the same order)
* It doesnn't matter who finishes the bloodCheck() first
* What matters is who is the next In Line
* SO , to implement it , I use wait() method
* Each patient that the comes to the Doctor , will wait() till he is next in line (The Monitor releases the Lock)
* Once he is done, the code will notifyAll threads , and the next Thread will acuire the LOck if he is NextInLine </br>
  If not , he will wait() and release the Lock
* Once a patient is finished with the doctor , the next Patient In line will be with the doctor

```java
at blood Check patient: 1
at blood Check patient: 3
at blood Check patient: 2
at blood Check patient: 4
at blood Check patient: 5
Finished Blood Checked, patient :5
 at Doctor : patient number : 5--> waiting
Finished Blood Checked, patient :3
 at Doctor : patient number : 3--> waiting
Finished Blood Checked, patient :2
 at Doctor : patient number : 2--> waiting
Finished Blood Checked, patient :1
 at Doctor : patient number : 1, finished 
 at Doctor : patient number : 2, finished 
 at Doctor : patient number : 3, finished 
 at Doctor : patient number : 5--> waiting
Finished Blood Checked, patient :4
 at Doctor : patient number : 4, finished 
 at Doctor : patient number : 5, finished 
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 8

<img src="https://img.shields.io/badge/-8. join() %20-blue" height=40px>

**java.lang.Thread** class provides the **join()** method which allows one thread to wait until another thread completes its execution.</br>
* [**join():**](#-) It will put the current thread on wait until the thread on which it is called is dead. If thread is interrupted then it will throw InterruptedException.
* [**join(long millis) :**](#-) It will put the current thread on wait until the thread on which it is called is dead or wait for specified time (milliseconds).
* [**join(long millis, int nanos):**](#-) It will put the current thread on wait until the thread on which it is called is dead or wait for specified time (milliseconds + nanos).

### [Example w/o join() method](#-)

In the following example I have 2 classes that Implement the Runnable interface.</br>
I invoke the MyThread thread from the run() method of MyCalculate class.</br>
From main method I invoke MyCalculation Thread.</br>
Scroll down to see the console out

```java
public class MyThread implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is running");
		for (int i = 0; i < 3; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Finished running");
	}
}

public class MyCalculate implements Runnable {

	MyThread myThread = new MyThread();

	private void printMessage(String msg) {
		System.out.println(Thread.currentThread().getName() + msg);
	}

	@Override
	public void run() {
		printMessage(" is running");

		Thread myThread = new Thread(myThread, "MyThread-run");
		thread.start();

		printMessage(" invoked MyThread");
		printMessage(" Finished Running");
	}
}

public class Main {
	public static void main(String[] args) {

		MyCalculate myCalc = new MyCalculate();
		Thread tCalc = new Thread(myCalc, "Calculate-thread");

		tCalc.start();
	}
}
```

### Console output shows : 

* **Calculate-thread** started to run, Invoked MyThread thread, Finished running , while **MyThread** still running.
* This is where the **join()** method comes to the picture.
* with **join()** method , I can tell the running thread , to wait till it will be termninted , then continue with the processing of the code.

```java
Calculate-thread is running
Calculate-thread invoked MyThread
Calculate-thread Finished Running
MyThread-run is running
MyThread-run 0
MyThread-run 1
MyThread-run 2
MyThread-run Finished running
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

### [Implement join() method](#-)

In the following example I have 2 classes that Implement the Runnable interface.</br>
I invoke the MyThread thread from the run() method of MyCalculate class.</br>
I invoke **thread.join()** method from **MyCalculate class run() method** . I put it in a try/catch block since it throws **InterruptedException**</br> 
From main method I invoke MyCalculation Thread.</br>
Scroll down to see the console out

```java
public class MyThread implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is running");
		for (int i = 0; i < 3; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Finished running");
	}
}

public class MyCalculate implements Runnable {

	MyThread myThread = new MyThread();

	private void printMessage(String msg) {
		System.out.println(Thread.currentThread().getName() + msg);
	}

	@Override
	public void run() {
		printMessage(" is running");
		try {
			Thread thread = new Thread(myThread, "MyThread-run");
			thread.start();
			printMessage(" invoked MyThread");
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		printMessage(" Finished Running");
	}
}

public class Main {
	public static void main(String[] args) {

		MyCalculate myCalc = new MyCalculate();
		Thread tCalc = new Thread(myCalc, "Calculate-thread");

		tCalc.start();
	}
}
```

### Console output shows : 

* **Calculate-thread** started to run, Invoked MyThread thread , did not continue with it's execution , becuase we invoke the **join()** method
* **MyThread** started running, and finished it's execution.
* after **MyThread** terminated , **Calculate-thread** continue to run and finished it's execution .

```java
Calculate-thread is running
Calculate-thread invoked MyThread
MyThread-run is running
MyThread-run 0
MyThread-run 1
MyThread-run 2
MyThread-run Finished running
Calculate-thread Finished Running
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 9

<img src="https://img.shields.io/badge/-9. interrupt() %20-blue" height=40px>

* The [interrupt()](#-) method of thread class is used to interrupt the thread. 
* If any thread is in :
	1. [sleeping](#-) or 
	2. [waiting](#-) state (i.e. sleep() or wait() is invoked) </br>
then using the [interrupt()](#-) method, we can interrupt the thread execution by throwing [InterruptedException](#-).

* ### [**interrupt()**](#-) method only works on Thread that is in [sleep()](#-) or [wait()](#-)

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

### [1. Interrupting a thread that doesn't stop working](#-)

```java
public class MyThread implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is running");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " Finished running");
	}
}

public class Main {
	public static void main(String[] args) {

		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread, "MyThread");
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
```

### Console output shows : 

In this example, after interrupting the thread, we handle the exception in the catch clause, so it will break out from the sleeping state but it will [continue to run](#-).

```java
MyThread is running
MyThread 0
MyThread 1
java.lang.InterruptedException: sleep interrupted
	at java.lang.Thread.sleep(Native Method)
	at demo.MyThread.run(MyThread.java:12)
	at java.lang.Thread.run(Thread.java:748)
MyThread 2
MyThread 3
MyThread 4
MyThread Finished running
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

### [2. Interrupting a thread that stops working](#-)

```java
public class MyThread implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is running");
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		System.out.println(Thread.currentThread().getName() + " Finished running");
	}
}

public class Main {
	public static void main(String[] args) {

		MyThread myThread = new MyThread();
		Thread thread = new Thread(myThread, "MyThread");
		thread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
```

### Console output shows : 

In this example, after interrupting the thread, we handle the exception in the catch clause, **But** we throw **RuntimeException** in the catch clause will [NOT continue to run](#-).

```java
MyThread is running
MyThread 0
MyThread 1
Exception in thread "MyThread" java.lang.RuntimeException: sleep interrupted
	at demo.MyThread.run(MyThread.java:14)
	at java.lang.Thread.run(Thread.java:748)
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 10

<img src="https://img.shields.io/badge/-10.Semaphore %20-blue" height=40px>

### [Semaphore in Java](#-)

* A Semaphore in Java is a Thread Synchronization construct that controls access to the shared resource with the help of counters.
* We can use a semaphore to avoid race conditions (when semaphore(1) its like  Synchronized keyword). 
* Semaphore is JAVA class from **_java.util.concurrent_** package
* With Semaphore we can define number of Threads (permits) that can run at the same time. 
* For example :
	* if we have [**MyThread**](#-) class that Implement runnable. We create 5 Threads  of MyThread and run all 5 of them [thread.start()](#-). </br>
but we want to allow only 3 threads at the same time.</br>
with Semaphore we can define it as Semaphore(3) , and only 3 Threads of the MyThread will run at the same time. (see example 2).</br>
This means, the first 3 Threads will [**aquire() a Lock**](#-). </br>
If another Thread that comes will try to [**aquire() a lock**](#-) , he will be at [**wait()**](#-) state, till one of the 3 Threads will [**relase() the lock**](#-) .</br>

https://www.youtube.com/watch?v=w92-evgmKxU

1. When we define [Semaphore(1)](#-) ```Semaphore semaphore = new Semaphore(1)``` , its like we use the [Synchronized](#-) keyword , because only 1 thread exclusively wants to execute a code at the same time.
2. If number of concurrent threads executing the same piece of code is >1 , then [Semaphore](#-) is the only choice.


### [1. Example semaphore(1)](#-)

With **semaphore(1)** there is only 1 lock. thus it's like synchronized keyword. </br>
In order to acquire the lock , we use the [acquire()](#-) method from [Semaphore](#-) Class.</br>
In order to release the lock, we use the [release()](#-) method from [Semaphore](#-) Class.</br>


```java
public class MyThread implements Runnable {

	Semaphore semaphore = new Semaphore(1);

	@Override
	public void run() {

		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " is running");
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + " " + i);
				Thread.sleep(1000);
			}
			System.out.println(Thread.currentThread().getName() + " Finished running");
			semaphore.release();
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}

public class Main {
	public static void main(String[] args) {

		MyThread myThread = new MyThread();

		Thread thread1 = new Thread(myThread, "Thread-1");
		Thread thread2 = new Thread(myThread, "Thread-2");
		Thread thread3 = new Thread(myThread, "Thread-3");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}
```

### Console output shows : 

each Thread runs at a time , just like we add synchronized keyword. (Semaphore(1) = synchronized keyword )

```java
Thread-1 is running
Thread-1 0
Thread-1 1
Thread-1 2
Thread-1 Finished running
Thread-2 is running
Thread-2 0
Thread-2 1
Thread-2 2
Thread-2 Finished running
Thread-3 is running
Thread-3 0
Thread-3 1
Thread-3 2
Thread-3 Finished running
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

### [2. Example semaphore(3)](#-)

In this example I dedfine **Semaphore(3)** , which means only 3 Threds can run at the same time. </br>
I also add a random delay time betwee 0-2000[ms]. </br>
I create 5 Threads for of MyThread. </br>
Check console output with explaination. </br>

```java
import java.util.concurrent.Semaphore;

public class MyThread implements Runnable {

	Semaphore semaphore = new Semaphore(3);
	Random random = new Random();

	@Override
	public void run() {

		try {
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName() + " is running");
			for (int i = 0; i < 3; i++) {
				System.out.println(Thread.currentThread().getName() + ": i = " + i);
				int sleepTime = random.nextInt(2000);
				Thread.sleep(sleepTime);
			}
			System.out.println(Thread.currentThread().getName() + " Finished running");
			semaphore.release();
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}

public class Main {
	public static void main(String[] args) {

		MyThread myThread = new MyThread();

		Thread thread1 = new Thread(myThread, "Thread-1");
		Thread thread2 = new Thread(myThread, "Thread-2");
		Thread thread3 = new Thread(myThread, "Thread-3");
		Thread thread4 = new Thread(myThread, "Thread-4");
		Thread thread5 = new Thread(myThread, "Thread-5");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}
}
```

### Console output shows : 

Since we define semaphore(3) , hence we have always will have 3 Threads at the Same time.</br>
3 Threads have permitition so they started to run : Thread-1, Thread-4, Thread-3. </br>
Once they run they hold a lock. </br>
If another Thread tries to get permmit, it is blocked, because we need to wait till realse() is invoked.</br>
We can see , once Thread-1 finished, now we have 2 Threads running, thus another Thread can aquire() permit , which is Thread-2.

```java
Thread-1 is running
Thread-4 is running
Thread-3 is running
Thread-4: i = 0
Thread-1: i = 0
Thread-3: i = 0
Thread-1: i = 1
Thread-4: i = 1
Thread-1: i = 2
Thread-4: i = 2
Thread-1 Finished running
Thread-2 is running
Thread-2: i = 0
Thread-3: i = 1
Thread-3: i = 2
Thread-4 Finished running
Thread-5 is running
Thread-5: i = 0
Thread-3 Finished running
Thread-2: i = 1
Thread-2: i = 2
Thread-5: i = 1
Thread-5: i = 2
Thread-2 Finished running
Thread-5 Finished running

```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 11

<img src="https://img.shields.io/badge/-11. ReentrantLock %20-blue" height=40px>

[Lock Interface, ReentrantLock Class,  you tube link , well explained](https://www.youtube.com/watch?v=ahBC69_iyk4&ab_channel=DefogTech)

[Lock](#-) - Lock is an Interface</br>
[ReentrantLock](#-) - Java Class that Implemenets Lock interface</br>

[ReentrantLock](#-) class implements the [Lock](#-) interface. It offers the same concurrency and memory semantics, as the implicit monitor lock accessed using synchronized methods and statements, with [extended capabilities](#-).

We know that when we use synchronization on a block/method it holds a lock.</br>
With ReentrantLocks - the Locks are provided in Java to provide synchronization with greater flexibility. </br>

We need to make sure that we are wrapping the [lock()](#-) and the [unlock()](#-) calls in the try-finally block to avoid the [deadlock](#-) situations.

### [Need to make the code example more clear , last update 01-03-2022](#-)

```java
import java.util.concurrent.locks.ReentrantLock;

public class SharedObject implements Runnable {

	ReentrantLock reentrantLock = new ReentrantLock();

	int counter = 0;

	public void perform() {
		reentrantLock.lock();
		printMessage(": lock aquired");

		try {
			counter++;
		} finally {
			reentrantLock.unlock();
			printMessage(": lock relesed");
		}
	}

	private void printMessage(String message) {
		System.out.println(Thread.currentThread().getName() + message);
	}

	@Override
	public void run() {
		perform();
	}
}

public class Main {

	public static void main(String[] args) {

		SharedObject sharedObject = new SharedObject();

		Thread thread1 = new Thread(sharedObject, "Thread-1");
		Thread thread2 = new Thread(sharedObject, "Thread-2");
		Thread thread3 = new Thread(sharedObject, "Thread-3");
		Thread thread4 = new Thread(sharedObject, "Thread-4");

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
	}
}
```

### Console output shows : 


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 12

<img src="https://img.shields.io/badge/-12 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 13

<img src="https://img.shields.io/badge/-13. DeadLock ,Yield %20-blue" height=40px>

https://www.javatpoint.com/deadlock-in-java


[1. What is deadlock and when it can occur?](#-)

* DeadLock describes a situation where 2 or more threads are blocked forever , waiting for each other. (Since the depend on each other , it's called circular Dependency) (Example like "No, you hang up first" situation)
* DeadLocks can occur in java when the synchronized keyword causes the executing htread to block while waiting to get the lock , associated with specified object.

[2. How to prevent DeadLocks?](#-)

* Don't use locks.
* Acquire the locks in the same order.
* Release the locks after a tiomeout period

### [Let's see Implemented example of a DeadLock](#-)


```java
public class ThreadDemo1 implements Runnable {

	private Object obj1;
	private Object obj2;

	public ThreadDemo1(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		synchronized (obj1) {
			try {
				System.out.println("Aquire lock on obj 1, waiting for obj 2");
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (obj2) {
				System.out.println("Aquire lock on obj 1 & obj2");
			}
		}
	}
}

public class ThreadDemo2 implements Runnable {

	private Object obj1;
	private Object obj2;

	public ThreadDemo2(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		synchronized (obj2) {
			try {
				System.out.println("Aquire lock on obj 2, waiting for obj 1");
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			synchronized (obj1) {
				System.out.println("Aquire lock on obj 1 & obj2");
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();

		ThreadDemo1 threadDemo1 = new ThreadDemo1(obj1, obj2);
		Thread demo1 = new Thread(threadDemo1);
		demo1.start();

		ThreadDemo2 threadDemo2 = new ThreadDemo2(obj1, obj2);
		Thread demo2 = new Thread(threadDemo2);
		demo2.start();
	}
}
```

### Console output shows : 

```java
Aquire lock on obj 1, waiting for obj 2
Aquire lock on obj 2, waiting for obj 1
```

If we take a look ad the code of both Synchronized block we wiil see the DeadLock .</br>
In the class of [**_ThreadDemo1_**](#-), **_synchronized (obj1)_** locks the Object of **obj1**, and then tries to lock the Object of **obj2** , but it can't because **obj2** is already locked in class of [**_ThreadDemo2_**](#-). 

In the class of [**_ThreadDemo2_**](#-), **_synchronized (obj2)_** locks the Object of **obj2**, and then tries to lock the Object of **obj1** , but it can't because **obj1** is alreday locked in class of [**_ThreadDemo1_**](#-). 

This is a circular situation of acquiring the lock, whrere none of the Threads release the lock , this is why we get a [**_DeadLock_**](#-)

```java
synchronized (obj1) {
	synchronized (obj2) {
			...
	}
}

synchronized (obj2) {
	synchronized (obj1) {
			...
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 14

<img src="https://img.shields.io/badge/-14. volatile %20-blue" height=40px>

### [Questions:](#-) </br>
1. What is a volatile keyword in Java?
2. when to use the volatile keyword on a variable in Java?

### [Answers:](#-) </br>
1. The [**_volatile_**](#-) keyword in Java is used as an indicator to Java compiler and Thread that do not [cache](#-) (L1, L2, L3) the value of this variable and always read it from the [**_main memory_**](#-) (RAM memory). </br>
2. Volatile used to solve [**VISIBILITY**](#-) problems </br>

### Background for RAM (Main Memory) and CACHE Memory

In a multi-threaded application where the threads operate on _**non-volatile**_ variables, each thread may copy variables from </br>
[**Main Memory (RAM)**](#-) into a [**CPU CACHE Memory**](#-) while working on them, for performance reasons. </br>
If your computer contains more than one CPU, each thread may run on a different CPU. </br>
That means, that each thread may copy the variables into the CPU CACHE of **_different_** CPUs.

RAM memory is located on a seperate chip on the Mother Board, so CPU takes some time to access the shared variables. </br>
In order to reduce this time (and Improving the performance , CHIP Designeres add extra memory layer between the CPU and the RAM , with a smaller size , but with very small access time. This is the [**CACHE Memory**](#-).

![Memory_Cache](https://user-images.githubusercontent.com/36256986/157329141-b3459c9f-edb9-497f-b6b9-afce374b99b8.PNG)

[**CACHE Memory**](#-) is embedded in the CPU Chip, it has multiple layers (L1, L2 ,L3) 

### [Compared access time of RAM and Cache:](#-) </br>
1. RAM   : Usually, the access time of CPU is around ~100ns
2. CACHE : Usually, The access time of CPU is around ~7ns 


****

In this example we have a [shared variable](#-) that is Stored in the RAM (int, string), and both Threads are trying to Read that variable. </br>
If they are doing multiple Read operations in a very extensive way (like [while(true)](#-) loop) of read operations , </br>
that is invoked on a CPU level, the [CPU will try to **optimze** that operation by storing that shared variable in the **CACHE Memory** of the CPU](#-). </br>
That way it will reduce the acess time.

<img src="https://user-images.githubusercontent.com/36256986/157331981-0287662a-1f82-495b-9306-bd7e9249a7d8.PNG" height=350px width=700px>


On the other hand, if one Thread is trying to [Write](#-) data into that variable, the visibility of that [Write](#-) for a specific amount of time, </br>
will be done only on the [CACHE](#-) level. </br>
So if Thread 2 wants to [Read/Modify](#-) that variable ,the new value will be seen only by the Thread 2 because it will be stored in the [CACHE](#-) level.</br>
This change will be propagated to the [RAM](#-) at some point, BUT this doesn't happen immidiatly.</br>
There is a delay between the [CACHE](#-) and the [Memory](#-) update.

<img src="https://user-images.githubusercontent.com/36256986/157331694-119956ed-05e2-43f4-a0af-784b9da74069.PNG" height=350px width=700px>

If thread 1 is continuously trying to read that variable in a hot loop, it will not see the updated value for that variable, </br>
hence , Thread 1 continuously reads it's own value from the [Cache](#-), and the shared variable is not [VISIBLE](#-). </br>
Thats the main problem , [**VISIBILITY**](#-) across Threads. </br>
So , Thread 1 cannot see the updated value for that shared variable , because it continuously reads it's own value from the Cache in which it's run. </br>

### [**VOLATILE**](#-)

For that reason , the [**VOLATILE**](#-) keyword has been introduced.

If we have a variable that is marked with the [**volatile**](#-) keyword and you want to Read data from it, </br>
the Read will be done directly from the [RAM](#-) (main memory). </br>
The [CACHE](#-) will not impact this read operation at all. </br>
and also if you want to [write](#-) data into the variable , the [write](#-) will be [stored directly in the RAM](#-) . </br>
In this way, we have a predictable output of our program and we don't risk having this cache level inconsistency. </br>

<img src="https://user-images.githubusercontent.com/36256986/157331730-440c3d6a-e317-4612-8669-cf227c19e9f6.PNG" height=350px width=700px>

This doesn't come without a cost. </br>
If we get consistency we loose on performance, because if we decalre all our shared variables as volatile,  </br>
the perfromance of our application will suffer. </br>

****

https://www.youtube.com/watch?v=V2hC-g6FoGc&ab_channel=VisualComputerScience </br>

### [I will show 2 situations:](#-) </br>
1. Shared variable is a boolean (**with** and **w/o** volatile)	
2. Shared variable is int number inside while for loop (**with** and **w/o** volatile). Synchronization - where a int number is shared and used as a counter (Read-Modify-Write operation)

### [Shared variable as boolean](#-)

see at the bottom of the section the output of the code when:
1. boolean is not volatile
2. boolean is volatile


```java
public class BooleanThreadOne implements Runnable {

	@Override
	public void run() {
		try {
			execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void execute() throws InterruptedException {

		print(" running = false, waiting");

		while (!SharedResource.running) {
		}

		print(" : started");

		Thread.sleep(randomSleepTime());

		while (SharedResource.running) {
		}

		print(" : stopped");

	}

	private int randomSleepTime() {
		Random random = new Random();
		int sleepTime = 2000 + random.nextInt(3000);
		return sleepTime;
	}

	private void print(String message) {
		System.out.println(LocalTime.now() + " : " + Thread.currentThread().getName() + message);
	}

}


public class BooleanThreadTwo implements Runnable {

	@Override
	public void run() {
		try {
			execute();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void execute() throws InterruptedException {

		print(" running = false, waiting");

		while (!SharedResource.running) {
		}

		print(" : started");

		Thread.sleep(randomSleepTime());

		while (SharedResource.running) {
		}

		print(" : stopped");

	}

	private int randomSleepTime() {
		Random random = new Random();
		int sleepTime = 2000 + random.nextInt(3000);
		return sleepTime;
	}

	private void print(String message) {
		System.out.println(LocalTime.now() + " : " + Thread.currentThread().getName() + message);
	}
}

public class MainVolatileBoolean {

	public static void main(String[] args) throws InterruptedException {

		BooleanThreadOne booleanThreadOne = new BooleanThreadOne();
		BooleanThreadTwo booleanThreadTwo = new BooleanThreadTwo();

		Thread t1 = new Thread(booleanThreadOne, "[T1]");
		Thread t2 = new Thread(booleanThreadTwo, "[T2]");

		t1.start();
		t2.start();

		print(" : running = " + SharedResource.running);

		Thread.sleep(randomSleepTime());

		print(" : Started");
		print(" : set running = true");

		SharedResource.running = true;

		Thread.sleep(randomSleepTime());

		if (SharedResource.running) {
			SharedResource.running = false;
			print(" : set running = false");
		}

		print(" : stopped");

	}

	private static int randomSleepTime() {
		Random random = new Random();
		int sleepTime = 2000 + random.nextInt(3000);
		return sleepTime;
	}

	private static void print(String message) {
		System.out.println(LocalTime.now() + " : " + Thread.currentThread().getName() + message);
	}
}
```

### SharedResourece running is [**NOT volatile**](#-)

```java
public class SharedResource {

	public static boolean running = false;
}
```

### Console output shows : 

```java
10:44:54.470020 : [T2] : running = false, waiting
10:44:54.470020 : [T1] : running = false, waiting
10:44:54.469022300 : main : running = false
10:44:56.484864500 : main : Started
10:44:56.484864500 : main : set running = true
10:44:59.802543900 : main : set running = false
10:44:59.802543900 : main : stopped
```

### the SharedResourece running is [**volatile**](#-)

```java
public class SharedResource {

	public static volatile boolean running = false;
}
```

### Console output shows : 

```java
11:41:32.659859100 : [T1] : running = false, waiting
11:41:32.659859100 : [T2] : running = false, waiting
11:41:32.659859100 : main : running = false
11:41:35.122331700 : main : Started
11:41:35.122331700 : main : set running = true
11:41:35.122331700 : [T2] : started
11:41:35.122331700 : [T1] : started
11:41:39.478382500 : main : set running = false
11:41:39.478382500 : main : stopped
11:41:39.478382500 : [T1] : stopped
11:41:39.478382500 : [T2] : stopped
```

### [Shared variable as int number](#-)

```java
public class Main {

	private static volatile int counter = 0;

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {

			int local_counter = counter;

			while (local_counter < 10) {
				if (local_counter != counter) {
					System.out.println("[T1] local counter is changed " + local_counter);
					local_counter = counter;
				}
			}
		});

		Thread t2 = new Thread(() -> {
			int local_counter = counter;

			while (local_counter < 10) {
				System.out.println("[T2] incremented counter to " + (local_counter + 1));
				counter = ++local_counter;

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();

	}
}
```


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 15

<img src="https://img.shields.io/badge/-15. Atomic (Integer, Long, Boolean, Reference) %20-blue" height=40px>

* [Question:](#-)</br>
	* What is Atomic?

* [Answer:](#-)</br>
	* from [Oracle](https://docs.oracle.com/javase/tutorial/essential/concurrency/atomic.html) documentation , In programming, an **_Atomic_** action is one that effectively happens all at once</br>
	* An atomic action cannot stop in the middle:
		* it either happens completely,
		* or it doesn't happen at all


Let's have a look at the class (example from [www.baeldung.com](https://www.baeldung.com/java-atomic-variables) ):

```java
public class Counter {
    int counter; 
 
    public void increment() {
        counter++;
    }
}
```

* In the case of a single-threaded environment, this works perfectly. </br>
However, as soon as we allow more than one thread to write, we start getting inconsistent results.
* This is because the simple increment operation [**(counter++)**](#-), is [**NOT ATOMIC**](#-) operation (even if it may look like an [**atomic**](#-) operation) </br>
* It is a combination of three operations:
	1. obtaining (reading) the value, 
	2. incrementing (Modifing), 
	3. and writing the updated value back.

**_If two threads try to get and update the value at the same time, it may result in lost updates._**

1. One of the ways to manage access to an object is to use :
	* make the [synchronized](#-) method
	* and make the counter variable as [volatile](#-)
2. Seconed way is to use Atomic variables like [AtomicInteger](#-), [AtomicLong](#-), [AtomicBoolean](#-) 

### [**Atomic classes**](#-) allow us to perform atomic operations, which are [**_thread-safe_**](#-), [**_without_**](#-) using [**synchronization**](#-). </br>

### [Example with sunchronize (w/o AtomicInteger) ](#-)</br>

In this example , I use Synchronized , next example I will use only AtomicInteger , to show that it is Thread-safe as well (Even if we don't use synchronized) </br>

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {

	int count = 0;

	public synchronized void run() {

		for (int i = 0; i < 1_000_000; i++) {
			count.addAndGet(1);
		}
	}

}

public class Main {
	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();

		Thread first = new Thread(c, "First");
		Thread second = new Thread(c, "Second");

		first.start();
		second.start();

		first.join();
		second.join();

		System.out.println(c.count);
	}
}
```

### Console output shows : 

we can see we got 2000000 , meaning each Thread hold th lock till his finished.</br>
**first** Thread waits till his finished then other thread starts to 


```java
2000000
```


### [Example AtomicInteger ](#-)</br>

In this example , I use AtomicInteger , and the outcome is same as in previous example where I used [synchronized](#-)</br>

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {

	AtomicInteger count;

	public Counter() {
		count = new AtomicInteger();
	}

	public void run() {

		for (int i = 0; i < 1_000_000; i++) {
			count.addAndGet(1);
		}
	}

}

public class Main {
	public static void main(String[] args) throws InterruptedException {

		Counter c = new Counter();

		Thread first = new Thread(c, "First");
		Thread second = new Thread(c, "Second");

		first.start();
		second.start();

		first.join();
		second.join();

		System.out.println(c.count);
	}
}
```

### Console output shows : 

```java
2000000
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 16

<img src="https://img.shields.io/badge/-16. Thread Scheduler & Priority of Threads %20-blue" height=40px>

### [JavaPoint explaination for Thread-Scheduler](https://www.javatpoint.com/thread-scheduler-in-java)

* [Question](#-):
	* What is a [Thread Scheduler](#-)?

* [Answer](#-) :
	* [Thread Scheduler](#-) in Java is A component of Java that decides which thread to run or execute and which thread to wait 
	* [Thread Scheduler](#-) is part of the processor which executes Multiple-Threads on a single processor, randomly.
	* thread is only chosen by a [Thread Scheduler](#-) if it is in the [Runnable state](#-).
	* If there is more than one thread in the [Runnable state](#-), it is up to the [Thread Scheduler](#-) to pick one of the threads and ignore the other ones.
	* There are two factors for scheduling a thread i.e. [Priority](#-) and [Time of Arrival](#-).
		* [Priority](#-): Priority of each thread lies between 1 to 10. If a thread has a higher priority, it means that thread has got a better chance of getting picked up by the thread scheduler.
		* [Time of Arrival](#-): Suppose two threads of the same priority enter the runnable state, then priority cannot be the factor to pick a thread from these two threads. In such a case, arrival time of thread is considered by the thread scheduler. A thread that arrived first gets the preference over the other threads.

A scheduler is implementation of scheduling algorithm that manages access of processes and Threads to some limited resource like the processor or some I/O channel. </br>

### [JavaPoint explaination for Thread-Priority](https://www.javatpoint.com/priority-of-a-thread-in-java)

* Question:
	* What is a [Priority Of Threads](#-)?

* Answer :
	* Each thread has a priority. 
	* Priorities are represented by a number between 1 and 10. In most cases, the [Thread Scheduler](#-) schedules the threads according to their priority (known as preemptive scheduling). But it is not guaranteed because it depends on JVM specification that which scheduling it chooses. 
	* Note that not only JVM decides that, But also a Java programmer can also assign the priorities of a thread explicitly in a Java program.

<img src="https://img.shields.io/badge/-3 constants defined in Thread class:%20-green" height=30px>

```java
public static int MIN_PRIORITY
public static int NORM_PRIORITY
public static int MAX_PRIORITY
```

* Default priority of a thread is 5 ([NORM_PRIORITY](#-)). The value of [MIN_PRIORITY](#-) is 1 and the value of [MAX_PRIORITY](#-) is 10. </br>
* The default priority for the main thread is always 5, it can be changed later. </br>
* The default priority for all other threads depends on the priority of the parent thread </br>
 * If two threads have the same priority then we can’t expect which thread will execute first. </br>
It depends on the thread scheduler’s algorithm([Round-Robin](#-), [First Come First Serve](#-), etc)

```java
class MyThread implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + " Inside the run() , priority :"
				+ Thread.currentThread().getPriority());
	}
}

public class Main {

	public static void main(String[] args) throws InterruptedException {

		MyThread myThread = new MyThread();

		Thread t1 = new Thread(myThread, "[T1]");
		Thread t2 = new Thread(myThread, "[T2]");
		Thread t3 = new Thread(myThread, "[T3]");
		Thread t4 = new Thread(myThread, "[T4]");

		Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
		t1.setPriority(7);
		t2.setPriority(Thread.NORM_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(6);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		System.out.println(
				Thread.currentThread().getName() + " is finished , priority :" + Thread.currentThread().getPriority());
	}
}
```
### Console output shows  [results are not as expected](#-)

```java
[T2] Inside the run() , priority :5
[T4] Inside the run() , priority :6
main is finished , priority :1
[T3] Inside the run() , priority :10
[T1] Inside the run() , priority :7
```

* [Question](#-)
	* Why Priority in JAVA not working as expected?

* [Answer](#-) :
	* Thread priority is only a hint to OS task scheduler. Task scheduler will only try to allocate more resources to a thread with higher priority, however there are no explicit guarantees.
A lot depends on the OS and JVM. (see [StackOverflow](https://stackoverflow.com/questions/27142551/thread-priority-does-not-work-as-expected) for answer)

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 17

<img src="https://img.shields.io/badge/-17. BlockingQueue %20-blue" height=40px>

http://tutorials.jenkov.com/java-util-concurrent/blockingqueue.html

The Java BlockingQueue interface, represents a queue which is [thread safe](#-) to put elements into, and take elements out of from. In other words, multiple threads can be inserting and taking elements concurrently from a Java BlockingQueue, without any concurrency issues arising.

The term blocking queue comes from the fact that the Java BlockingQueue is capable of **_blocking_** the threads that try to insert or take elements from the queue. For instance, if a thread tries to take an element and there are none left in the queue, the thread can be blocked until there is an element to take. Whether or not the calling thread is blocked depends on what methods you call on the BlockingQueue.

#### [BlockingQueue Implementations](#-) </br>
Since BlockingQueue is an interface, you need to use one of its implementations to use it. </br>

following implementations of the BlockingQueue interface:

1. ArrayBlockingQueue
2. DelayQueue
3. LinkedBlockingQueue
4. LinkedBlockingDeque
5. LinkedTransferQueue
6. PriorityBlockingQueue
7. SynchronousQueue

[**BlockingQueue Usage**](#-) - A BlockingQueue is typically used to have one thread produce objects, which another thread consumes. Here is a diagram that illustrates this principle. </br>
A BlockingQueue with one thread putting into it, and another thread taking from it.

![BlockingQueue](https://user-images.githubusercontent.com/36256986/161400566-980ef765-da69-4c92-8bb2-0c29fcd198fd.PNG)

The producing thread will keep producing new objects and insert them into the BlockingQueue, until the queue reaches some upper bound on what it can contain. It's limit, in other words. If the blocking queue reaches its upper limit, the producing thread is blocked while trying to insert the new object. It remains blocked until a consuming thread takes an object out of the queue.

The consuming thread keeps taking objects out of the BlockingQueue to processes them. If the consuming thread tries to take an object out of an empty queue, the consuming thread is blocked until a producing thread puts an object into the queue.


```java
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.put("1");
			System.out.println("add to queue 1");
			Thread.sleep(1000);
			queue.put("2");
			System.out.println("add to queue 2");
			Thread.sleep(1000);
			queue.put("3");
			System.out.println("add to queue 3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Consumer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			System.out.println("take from queue " + queue.take());
			System.out.println("take from queue " + queue.take());
			System.out.println("take from queue " + queue.take());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainBlockingQueue {

	public static void main(String[] args) throws InterruptedException {

		BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);

		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();

		Thread.sleep(4000);
	}
}
```

### Console output shows (#-)

The moment a Producer add task to a queue , the consumer takes it from the Q.

```java
add to queue 1
take from queue 1
add to queue 2
take from queue 2
add to queue 3
take from queue 3
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 18

<img src="https://img.shields.io/badge/-18. ThreadPoolExecutor/Executor framework %20-blue" height=40px>

* [ThreadPoolExecutor](#-) 
	* creates Thread pool </br>
* [Executor framework](#-) 
	* Java provides the Executor framework which is centered around the :
		* [Executor interface](#-)
		* its sub-interface – [ExecutorService interface](#-)
		* and the class-[ThreadPoolExecutor](#-) , which implements both of these interfaces.
		* or [Executors Class](#-) with factory methods , which is more common to use.


### [Types of Thread Pool](#-) </br>
1. [**newFixedThreadPool**](#-)
2. [**newScheduledThreadPool**](#-)
3. [**newSingleThreadExecutor**](#-)
4. [**newSingleThreadScheduledExecutor**](#-)
5. [**newCachedThreadPool**](#-)

![image](https://user-images.githubusercontent.com/36256986/161449547-a4185b46-534a-4e38-9dde-e8c2084dbc04.png)

* [Question:](#-) 
	* What is the Ideal number for a thread pool?

* [Answer:](#-) 
	* there are 2 factors to answer this question:
		* Number of CPU (Cores)
		* The type of the Tasks (CPU/IO)
	* Othe factors:
		* Are there other applications running on CPU?
		* Are there other executer services or threads running in same JVM/Application?
		* Threads are heavy weight (1-2MB). cannot create thousands of them. Even if a task's IO operation allows space for thousand threads.
		* Too many threads will also have added complexity/time -taken for thread switching.
		* Too many threads also affect data locality (i.e. L1/L2 etc need to be flushed during thread switch).


link to [Thread Pool Executor work in Java](#-)

Defog Tech links: </br>
[Defog Tech 1](https://www.youtube.com/watch?v=6Oo-9Can3H8&ab_channel=DefogTech) </br>
[Defog Tech 2](https://www.youtube.com/watch?v=sIkG0X4fqs4&ab_channel=DefogTech) </br>
[Defog Tech 3](https://www.youtube.com/watch?v=Dma_NmOrp1c&ab_channel=DefogTech) </br>
[Defog Tech 4](https://www.youtube.com/watch?v=NEZ2ASoP_nY&ab_channel=DefogTech) </br>

Jacob Jenkov links: </br>
[Jacob Jenkov](https://www.youtube.com/watch?v=mTGdtC9f4EU&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4&ab_channel=JakobJenkov) </br>
[Jacob Jenkov - ThreadPoolExecutor](https://www.youtube.com/watch?v=ZcKt5FYd3bU&ab_channel=JakobJenkov) </br>
[Jacob Jenkov part1 - ExecuterService](https://www.youtube.com/watch?v=Nb85yJ1fPXM&list=RDCMUCkiRZdcuNF7aiT4sQ9MJt-Q&index=3&ab_channel=JakobJenkov) </br>
[Jacob Jenkov part2 - ExecuterService](https://www.youtube.com/watch?v=MB_qCXBSgK0&list=RDCMUCkiRZdcuNF7aiT4sQ9MJt-Q&start_radio=1&ab_channel=JakobJenkov) </br>


I will show exapmles of the following:
1. write a code for Thread Pool
2. use **_ThreadPoolExecutor_** class [link in youtube](https://www.youtube.com/watch?v=-hs5rWz6T6k&ab_channel=AlmightyJava)
3. Use **_Executor_** interface and **_Executors_** Class with 
	1. [newFixedThreadPool(x)](#-)  -->  **_ExecutorService executor = Executors.newFixedThreadPool(2)_**
4. Use **_ScheduledExecutorService_** interface **_Executors_** Class with
	1. [newScheduledThreadPool(x)](#-) --> **_ScheduledExecutorService executor = Executors.newScheduledThreadPool(2)_**


### 1. write my own code for Thread Pool

```java
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

	private BlockingQueue<Runnable> taskQueue = null;
	private List<PoolThreadRunnable> runnables = new ArrayList<>();
	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNoOfTasks) {

		taskQueue = new ArrayBlockingQueue<Runnable>(maxNoOfTasks);

		for (int i = 0; i < noOfThreads; i++) {
			PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(taskQueue);
			runnables.add(poolThreadRunnable);
		}
		for (PoolThreadRunnable runnable : runnables) {
			new Thread(runnable).start();
		}
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");

		this.taskQueue.offer(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		for (PoolThreadRunnable runnable : runnables) {
			runnable.doStop();
		}
	}

	public synchronized void waitUntilAllTasksFinished() {
		while (this.taskQueue.size() > 0) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class PoolThreadRunnable implements Runnable {

	private Thread thread = null;
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;

	public PoolThreadRunnable(BlockingQueue<Runnable> queue) {
		taskQueue = queue;
	}

	public void run() {

		this.thread = Thread.currentThread();

		while (!isStopped()) {
			try {
				Runnable runnable = (Runnable) taskQueue.take();
				runnable.run();
			} catch (Exception e) {
				// log or otherwise report exception,
				// but keep pool thread alive.
			}
		}
	}

	public synchronized void doStop() {
		isStopped = true;
		// break pool thread out of dequeue() call.
		this.thread.interrupt();
	}

	public synchronized boolean isStopped() {
		return isStopped;
	}
}

public class TaskRunnable implements Runnable {

	private int taskNo;

	public TaskRunnable(int i) {
		this.taskNo = i;
	}

	@Override
	public void run() {
		String message = Thread.currentThread().getName() + ": Task " + taskNo;
		System.out.println(message);
	}
}

public class Main {

	public static void main(String[] args) throws Exception {

		// I pass noOfThreads and maxNoOfTasks
		ThreadPool threadPool = new ThreadPool(3, 10);

		for (int i = 0; i < 10; i++) {
			Runnable taskRunnable = new TaskRunnable(i);
			threadPool.execute(taskRunnable);
		}

		threadPool.waitUntilAllTasksFinished();
		threadPool.stop();
	}
}
```

### Console output shows (#-)

```java
Thread-2: Task 0
Thread-1: Task 2
Thread-1: Task 4
Thread-0: Task 1
Thread-0: Task 6
Thread-0: Task 7
Thread-0: Task 8
Thread-0: Task 9
Thread-1: Task 5
Thread-2: Task 3
```

### 2. use [**_ThreadPoolExecutor_**](#-) class

[video link well explained](https://www.youtube.com/watch?v=Dma_NmOrp1c&ab_channel=DefogTech)

![image](https://user-images.githubusercontent.com/36256986/161449245-4ac96258-88aa-4b1b-bed2-d8a0e99f3bab.png)


```java
public class Worker implements Runnable {

	private Integer count;

	public Worker(Integer count) {
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start : " + count);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " end : " + count);
	}

	@Override
	public String toString() {
		return count.toString();
	}
}

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(Thread.currentThread().getName() + " " + r.toString() + " is rejected");
	}
}

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainThreadPoolDemo {

	public static void main(String[] args) {

		int corePoolSize = 2;
		int maximumPoolSize = 5;
		long keepAliveTime = 10;
		int queueSize = 3;
		
		// ArrayBlockingQueue - Bounded Queue
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(queueSize);
		
		// LinkedBlockingQueue - UnBounded Queue , no need to give an queueSize
		// BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();
		
		ThreadFactory threadFactory = Executors.defaultThreadFactory();
		RejectedExecutionHandler handler = new RejectionHandler();

		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
				corePoolSize, 
				maximumPoolSize, 
				keepAliveTime,
				TimeUnit.SECONDS,
				workQueue,
				threadFactory,
				handler);

		for (int i = 1; i <= 10; i++) {
			Runnable worker = new Worker(i);
			poolExecutor.execute(worker);
		}
		
		poolExecutor.shutdown();
	}
}
```

### Console output shows (#-)

[question:](#-) : why we have 2 rejects </br>
[answer:](#-) It is because we used a [**ArrayBlockingQueue**](#-) (Which is **bounded**). If we were using a [**LinkedBlockingQueue**](#-) (Unbounded) we wouldn't got rejects</br>
also , if using ArrayBlockingQueue , change the **queueSize** to 3 scenarios below and examine the results, and see how it affects the program.
also change the maximumPoolSize & corePoolSize and analyze the results. </br>
also change the number of tasks of worker we run (From 10 to 20) and analyze the results.

* **queueSize** > **maximumPoolSize**
* **queueSize** < **maximumPoolSize**
* **queueSize** = **maximumPoolSize**

```java
pool-1-thread-3 start : 6
pool-1-thread-2 start : 2
pool-1-thread-1 start : 1
pool-1-thread-5 start : 8
pool-1-thread-4 start : 7
main 9 is rejected
main 10 is rejected
pool-1-thread-3 end : 6
pool-1-thread-4 end : 7
pool-1-thread-1 end : 1
pool-1-thread-2 end : 2
pool-1-thread-5 end : 8
pool-1-thread-1 start : 5
pool-1-thread-3 start : 3
pool-1-thread-4 start : 4
pool-1-thread-1 end : 5
pool-1-thread-3 end : 3
pool-1-thread-4 end : 4
```

### 3. Use [**_Executors.newFixedThreadPool(2)_**](#-)

```java
import java.time.LocalTime;

public class MessageProcessor implements Runnable {

	private int message;

	public MessageProcessor(int message) {
		this.message = message;
	}

	@Override
	public void run() {
		String thread = Thread.currentThread().getName();
		System.out.println(LocalTime.now() + " " + thread + " [STARTED] Message = " + message);
		respondToMessage();
		System.out.println(LocalTime.now() + " " + thread + " [ENDED] processing message = " + message);
	}

	private void respondToMessage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {			
			System.out.println(LocalTime.now() + " " + "Unable to process the message" + message);
		}
	}
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		/**
		 * The following 2 lines :
		 * Thread thread = new Thread(processor); 
		 * thread.start();
		 * 
		 * is been replaced by 1 line of 
		 * executor.execute(processor);
		 */

		/**
		 * When we set Executors.newFixedThreadPool(2) , 
		 * we will have 2 threads executing the tasks
		 * at the same time
		 */
		
		Runnable processor1 = new MessageProcessor(10);
		executor.execute(processor1);
		
		Runnable processor2 = new MessageProcessor(20);
		executor.execute(processor2);
		
		Runnable processor3 = new MessageProcessor(30);
		executor.execute(processor3);
		
		Runnable processor4 = new MessageProcessor(40);
		executor.execute(processor4);
		
		Runnable processor5 = new MessageProcessor(50);
		executor.execute(processor5);
				
		executor.shutdown();
		
		while(!executor.isTerminated()) {
			// this will make the main thread to wait till all tasks are finished
			// Then it will continue with next line
		}
		
		System.out.println("submitted all tasks");		
	}
}
```

### Console output shows  

we can see that 2 threads are executed in the same time.
thread-2 runs message 20, thread-1 runs message 10 </br>
Once they are ENDED , the executer utilizes the Threads to perform other task. </br>
Now, thread-2 runs message 30, thread-1 runs message 40 </br>
Once they are ENDED , the executer utilizes again the Thread to perform the next task. </br>
Last task is message 50. </br>
Then we need to shutdown the execution by calling method shutdown() to gracefully terminate the ExecutorService. </br>

```java
18:32:30.561 pool-1-thread-2 [STARTED] Message = 20
18:32:30.561 pool-1-thread-1 [STARTED] Message = 10
18:32:33.580 pool-1-thread-2 [ENDED] processing message = 20
18:32:33.580 pool-1-thread-1 [ENDED] processing message = 10
18:32:33.581 pool-1-thread-2 [STARTED] Message = 30
18:32:33.581 pool-1-thread-1 [STARTED] Message = 40
18:32:36.593 pool-1-thread-2 [ENDED] processing message = 30
18:32:36.593 pool-1-thread-1 [ENDED] processing message = 40
18:32:36.594 pool-1-thread-2 [STARTED] Message = 50
18:32:39.595 pool-1-thread-2 [ENDED] processing message = 50
submitted all tasks
```

### 4. Use [**_Executors.newScheduledThreadPool(2)_**](#-)

```java
import java.time.LocalTime;

public class MyRunnable implements Runnable {

	private String name;

	public MyRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		String thread = Thread.currentThread().getName();
		System.out.println(thread + " " + LocalTime.now() + " : task " + name + " is running");
	}
}

import java.time.LocalTime;

public class MyTestRunnable implements Runnable {

	private String name;

	public MyTestRunnable(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		String thread = Thread.currentThread().getName();
		System.out.println(thread + " " + LocalTime.now() + " task " + name + "is running");
	}
}

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainScheduledThreadPool {

	public static void main(String[] args) {

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

		Runnable myTestRunnable = new MyTestRunnable("[MyTestRunnable]");
		
		/** Runnable command - myTestRunnable
		  * long initialDelay
		  * long period
		  * TimeUnit unit
		  */                                                  
		executor.scheduleAtFixedRate(myTestRunnable, 2, 4, TimeUnit.SECONDS);

		Runnable runnable1 = new MyRunnable("[FIRST]");
		executor.scheduleAtFixedRate(runnable1, 1, 5, TimeUnit.SECONDS);

		Runnable runnable2 = new MyRunnable("[SECOND]");
		executor.scheduleAtFixedRate(runnable2, 3, 5, TimeUnit.SECONDS);

		Runnable runnable3 = new MyRunnable("[THIRD]");
		executor.scheduleAtFixedRate(runnable3, 2, 5, TimeUnit.SECONDS);
	}
}
```

### Console output shows  

Since it is scheduled , then it will run at scheduleAtFixedRate <br>

[MyTestRunnable](#-) after initial delay of 2 sec will run at fix rate of every 4 seconds  </br>
[FIRST](#-) after initial delay of 1 sec will run at fix rate of every 5 seconds </br>
[SECOND](#-) after initial delay of 3 sec will run at fix rate of every 5 seconds  </br>
[THIRD](#-) after initial delay of 2 sec will run at fix rate of every 5 seconds  </br>


```java
pool-1-thread-1 00:13:00.356549900 : task [FIRST] is running
pool-1-thread-1 00:13:01.329912200 : task [THIRD] is running
pool-1-thread-2 00:13:01.329912200 task [MyTestRunnable]is running
pool-1-thread-1 00:13:02.329678100 : task [SECOND] is running
pool-1-thread-2 00:13:05.332095100 task [MyTestRunnable]is running
pool-1-thread-1 00:13:05.332095100 : task [FIRST] is running
pool-1-thread-2 00:13:06.335057300 : task [THIRD] is running
pool-1-thread-1 00:13:07.336885400 : task [SECOND] is running
pool-1-thread-2 00:13:09.338450200 task [MyTestRunnable]is running
pool-1-thread-1 00:13:10.325735700 : task [FIRST] is running
.
.
.
.
.
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 19

<img src="https://img.shields.io/badge/-19. Callable/Runnable %20-blue" height=40px>

As we know **Runnable** is a Functional Interface , and we use it to implement a code for the task that we want to execute. </br>
Then we pass the Class to a Thread object that will invoke the **run** method of Runnable.</br>

1. as we can see the run() method doesn't return any value.
2. once thread.start() method is called, the Thread starts to run , and Interanlly  will invoke the run() method of Runnable Interface.
3. run() method doesn't return any value.

```java
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
```

### [Questions:](#-) </br>
1. What is [Callable](#-) interface?
2. How it's used?
3. What are the differences between Runabble and Callable?

### [Answers:](#-) </br>

1. [Callable](#-) is a Functional Interface that : </br>
	a. return a value </br>
	b. throws exception </br>

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```

2.  To use [Callable](#-) , a utility method in [Executors](#-) class must be used in order to convert The [Callable](#-) into [Runnable](#-). </br>
following methods in [Executors](#-) class make this happen. </br>
It must be executed from [Executors](#-) class and not from [Thread](#-) class. </br>
We must return a [Future](#-) Object (or [CompletableFuture](#-)) </br>

```java
public static <T> Callable<T> callable(Runnable task, T result) {
    if (task == null)
        throw new NullPointerException();
    return new RunnableAdapter<T>(task, result);
}

public static Callable<Object> callable(Runnable task) {
    if (task == null)
        throw new NullPointerException();
    return new RunnableAdapter<Object>(task, null);
}
```

### Let's take a look in the following example:

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 20

<img src="https://img.shields.io/badge/-20.Future  %20-blue" height=40px>

[video link Future ](https://www.youtube.com/watch?v=NEZ2ASoP_nY&ab_channel=DefogTech) </br>

we will se that [**callable**](#-) is in combination with [**Future**](#-) . </br>
Since [**callable**](#-) returns a value, the [**Future**](#-) will wait for that value at a certain time in the FUTURE. </br>

[Future](#-) is a place holder for a value that will arrive in some time in the FUTURE, based on how long the call() operations takes		
		
```java
import java.util.Random;
import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(2000);
		return new Random().nextInt();
	}
}

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(10);

		Callable<Integer> callable = new TaskCallable();

		// Future is a place holder for a value that will arrive
		// in some time in the FUTURE, based on how long the call() operations takes
		Future<Integer> future = executor.submit(callable);

		// future.get() -> this line is a blocking operation because it makes the code
		// to wait till it finishes its call() operation
		Integer result = future.get();

		System.out.println(result);

		executor.shutdown();
	}
}
```

#### Console output shows : return random value after a delayed time

```java
684313888
```

### Let's see another example with a List<Future>
	
```java
import java.util.Random;
import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		Thread.sleep(2000);
		return new Random().nextInt();
	}
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executor = Executors.newFixedThreadPool(10);

		List<Future<Integer>> futureList = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Callable<Integer> callable = new TaskCallable();
			Future<Integer> future = executor.submit(callable);
			futureList.add(future);
		}

		for (Future<Integer> future : futureList) {
			Integer result = future.get();
			System.out.println(result);
		}

		executor.shutdown();
	}
}
```

#### Console output shows : return random value after a delayed time	

```java
1408390107
789322731
220696880
159765549
-669818430
1693243855
1137387210
1088773547
275204021
-1226892934
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 21
	
<img src="https://img.shields.io/badge/-21. CompletableFuture %20-blue" height=40px>

1. https://www.youtube.com/watch?v=217XaErWYJE&ab_channel=TechRecipes
2. https://www.youtube.com/watch?v=2ddCC6R5u0E&ab_channel=TechRecipes
	
[CompletableFuture JavaTechie - part 1](https://www.youtube.com/watch?v=GJ5Tx43q6KM) </br>
[CompletableFuture JavaTechie - part 2](https://www.youtube.com/watch?v=oFRtBuRviHM&ab_channel=JavaTechie) </br>
[Video link CompletableFuture JavaTechie Spring](https://www.youtube.com/watch?v=3rJBLFA95Io&ab_channel=JavaTechie) </br>

* [Question:](#-)
	* what is [**CompletableFuture**](#-)?

* [Answer:](#-)
	* [**CompletableFuture**](#-) : a new era of [**_Asynchronus_**](#-) programming
	* using [**_Asynchronus_**](#-) programming , you can write **_Non-Blocking_**  code where concurrently you can run N num of task in seperate thread w/o blocking main thread.
	* When the task is complete, it notifies to the main thread (whether the task was completed of failed)
	

* [Question:](#-)
	* Why to use [**CompletableFuture**](#-)?
* [Answer:](#-)
	* There are different ways to implement [**_Asynchronus_**](#-) programming in JAVA using any of the below mechanisms for example , we can use Futures, ExecutorService, Callable interfaces , Thread pools, etc. </br>

With **Future** we hav the following **_DisAdvantages_**:
1. it cannot be manually completed. (we have to wait till Future.get()  retruns a value)
2. Multiple Futures cannot be chained together. (We cannot Pass Future.get() to another Thread for execution)
3. We cannot combine multiple Futures together. (Like Future1 + Future2...)
4. No prper Exception Handling Mechanism
	
Thus we need CompletableFuture.

## [runAsync() Vs supplyAsync()](#-)

![image](https://user-images.githubusercontent.com/36256986/162591471-e7cef0ba-905e-4e84-b5d9-c4750426375e.png)

* If we want to run some background task asynchronously and **_do not want to return_** anything from that task, the use **_CompletableFuture.runAsync()_** method.
</br> It takes [Runnable](#-) Object and returns [CompletableFuture<Void>](#-).
1. CompletableFuture.runAsunc(Runnable)
2. CompletableFuture.runAsunc(Runnable, Executor)

* If we want to run some background task asynchronously and **_want to return_** anything from that task, we should use **_CompletableFuture.supplyAsync()_** method. It takes a **_Supplier<T>_** Object and returns **_CompletableFuture<T>_** where T is the type of the value obtained by calling the givewn supplier.
3. CompletableFuture.supplyAsync(Supplier<T>)
4. CompletableFuture.supplyAsync(Supplier<T>, Executor)


### 1. [CompletableFuture.runAsunc(Runnable)](#-)
	
```java
public class AsyncExample {

	public static void main(String[] args) {

		Runnable runnable = () -> {
			delay(1);
			System.out.println("I am in Runnable - " + Thread.currentThread().getName());
		};

		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);
		System.out.println("I am in " + Thread.currentThread().getName() + " Thread");
		completableFuture.join();
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

Runnable is been used by framwork of **_ForkJoinPool.commonPool_**
	
```java
I am in main Thread
I am in Runnable - ForkJoinPool.commonPool-worker-3
```

### 2. [CompletableFuture.runAsunc(Runnable, Executor)](#-)
	
```java
public class AsyncExample {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Runnable runnable = () -> {
			delay(1);
			System.out.println("I am in Runnable - " + Thread.currentThread().getName());
		};

		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, executorService);

		System.out.println("I am in " + Thread.currentThread().getName() + " Thread");

		completableFuture.join();
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

Runnable is been used by ExecutorService of **_pool-1-thread-1_**
	
```java
I am in main Thread
I am in Runnable - pool-1-thread-1
```

### 3. [CompletableFuture.supplyAsync(Supplier<T>)](#-)
	
```java
public class SupplyAsyncExample {

	public static void main(String[] args) {

		Supplier<String> supplier = () -> {
			delay(1);
			System.out.println("I am in Supplier - " + Thread.currentThread().getName());
			return "hello from supllier";
		};

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
		System.out.println("I am in " + Thread.currentThread().getName() + " Thread");
		String value = completableFuture.join();

		System.out.println("value : " + value);
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

Runnable is been used by ExecutorService of **_ForkJoinPool.commonPool-worker-3_**
	
```java
I am in main Thread
I am in Supplier - ForkJoinPool.commonPool-worker-3
value : hello from supllier
```

### 4. [CompletableFuture.supplyAsync(Supplier<T>, Executor)](#-)
	
```java
public class SupplyAsyncExample {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(5);

		Supplier<String> supplier = () -> {
			delay(1);
			System.out.println("I am in Supplier - " + Thread.currentThread().getName());
			return "hello from supllier";
		};

		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier, executorService);
		System.out.println("I am in " + Thread.currentThread().getName() + " Thread");
		String value = completableFuture.join();

		System.out.println("value : " + value);
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

Runnable is been used by ExecutorService of **_pool-1-thread-1_**
	
```java
I am in main Thread
I am in Supplier - pool-1-thread-1
value : hello from supllier
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 21-1

<img src="https://img.shields.io/badge/-21.1. Callback CompletableFuture %20-blue" height=40px>
	
![image](https://user-images.githubusercontent.com/36256986/162241235-b9b6d238-48a3-485d-a5e5-6937f34a65d1.png)

### Let's look in examples where we can use these methods

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallbackExample {

	public static void main(String[] args) {

		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
			delay(2);
			return "Tech recipes";
		}).thenApply(s -> {
			return "Hello " + s;
		}).thenAccept(s -> {
			System.out.println(s);
		});

		completableFuture.join();
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

```
	
#### Console output shows :

```java
Hello Tech recipes
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
	
###### 21-2

<img src="https://img.shields.io/badge/-21.1. Compse Dependent CompletableFuture %20-blue" height=40px>

Consider 2 Asynchronuos operations , where second operation is dependent on the output of the first operation. In this case both operations are dependent on each other. </br>
* For example
	* we need to get a wishList of a user, however, before we call a getWishList Async method, we need to get userDetails first. </br>
[getWishList()](#-) depends upon [getUserDetails()](#-).</br>
If we want make these calls Asynchronuosly on different Threads, what we can do with [CompletableFuture](#-) , is to use the [thenCompse()](#-) method.</br>
[thenCompse()](#-) allows us to chain asynchronous operations (CompletableFutures). </br>
It allows us to run them sequentially.

![image](https://user-images.githubusercontent.com/36256986/162592356-f9288faa-46c1-4d09-92a1-c26c7f04eb0e.png)

```java
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompseExample {

	public static void main(String[] args) {

		System.out.println(LocalTime.now() + " : start Operation");

		CompletableFuture<String> future = getUserDetails().thenCompose(s -> getWishList(s));

		System.out.println(LocalTime.now() + " : Doing something");
		delay(4);
		System.out.println(LocalTime.now() + " : " + future.join());

		System.out.println(LocalTime.now() + " : end Operation");
	}

	public static CompletableFuture<String> getUserDetails() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " : getUserDetails() STARTED " + Thread.currentThread().getName());
			delay(2);
			System.out.println(LocalTime.now() + " : getUserDetails() ENDED " + Thread.currentThread().getName());
			return "UserDetails";
		});
	}

	public static CompletableFuture<String> getWishList(String user) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " : getWishList() STARTED " + user + " - " + Thread.currentThread().getName());
			delay(3);
			System.out.println(LocalTime.now() + " : getWishList() ENDED " + user + " - " + Thread.currentThread().getName());
			return "User WishList";
		});
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

According the code, we have  2 + 3 + 4 delay time  = 9sec </br>
what we got is 5 sec for total time. </br>
We can see that different Threads started to work Sequencilay (Not simultaniuosly), because they are dependent on each other </br>

```java
00:53:26.854786900 : start Operation
00:53:26.866756100 : getUserDetails() STARTED ForkJoinPool.commonPool-worker-3
00:53:26.866756100 : Doing something
00:53:28.878508800 : getUserDetails() ENDED ForkJoinPool.commonPool-worker-3
00:53:28.882117700 : getWishList() STARTED UserDetails - ForkJoinPool.commonPool-worker-5
00:53:31.891124100 : getWishList() ENDED UserDetails - ForkJoinPool.commonPool-worker-5
00:53:30.871991300 : User WishList
00:53:31.891124100 : end Operation
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 21-3

<img src="https://img.shields.io/badge/-21.3. Combine Independent CompletableFuture %20-blue" height=40px>


![image](https://user-images.githubusercontent.com/36256986/162592976-1b59c75a-ffa7-4a0b-9791-0f7cde5029f2.png)


```java
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineExample {

	public static void main(String[] args) {

		CompletableFuture<String> future = getUserEmail().thenCombine(getWeatherReport(), (email, weather) -> {
			System.out.println(LocalTime.now() + " " + "Sending email to " + email + " with report " + weather);
			delay(1);
			return email + weather;
		});

		System.out.println(LocalTime.now() + " Do Something " + Thread.currentThread().getName());
		delay(3);
		System.out.println(LocalTime.now() + " FUTURE : " + future.join());
	}

	public static CompletableFuture<String> getUserEmail() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " " + "getUserEmail() " + Thread.currentThread().getName());
			delay(3);
			return "shabtay.shalem@gmail.com ";
		});
	}

	public static CompletableFuture<String> getWeatherReport() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " " + "getWeatherReport() " + Thread.currentThread().getName());
			delay(3);
			return " Weather report of the city is - Rainy";
		});
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

log shows both CompletableFuture's getWeatherReport() & getUserEmail() , started at the same time with differetn Thread. </br>
we thenCombine() the results of both Independent Threads , to a single response. </br>
check the time line difference.

```java
15:42:37.890689100 getWeatherReport() ForkJoinPool.commonPool-worker-5
15:42:37.890689100 getUserEmail() ForkJoinPool.commonPool-worker-3
15:42:37.890689100 Do Something main
15:42:40.899343100 Sending email to shabtay.shalem@gmail.com  with report  Weather report of the city is - Rainy
15:42:40.899343100 FUTURE : shabtay.shalem@gmail.com  Weather report of the city is - Rainy
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 21-4

<img src="https://img.shields.io/badge/-21.4. allOf() & anyOf() CompletableFuture %20-blue" height=40px>

![image](https://user-images.githubusercontent.com/36256986/162620994-2d5fbf71-37ac-46e7-a400-3aad8d43815b.png)


## example using [CompletableFuture.allOf(x, x, x...)](#-)
	
```java
public class AnyAllOfExample {

	public static void main(String[] args) {

		CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(future1(), future2(), future3());

		System.out.println(LocalTime.now() + " Do Something " + Thread.currentThread().getName());

		delay(3);

		System.out.println(LocalTime.now() + " FUTURE : " + allOfFuture.join());
	}

	public static CompletableFuture<String> future1() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " future-1 " + Thread.currentThread().getName());
			delay(2);
			return "future-1";
		});
	}

	public static CompletableFuture<String> future2() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " future-2 " + Thread.currentThread().getName());
			delay(4);
			return "future-2";
		});
	}

	public static CompletableFuture<String> future3() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " future-3 " + Thread.currentThread().getName());
			delay(1);
			return "future-3";
		});
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

All Threads started at the sametime (Including main Thread). </br>
Each Thread finished at differetn time (Because of it's delay time). </br>
allOf() returns Void , thus we get NULL.
	
```java
16:57:06.816632200 Do Something main
16:57:06.816632200 future-1 STARTED ForkJoinPool.commonPool-worker-3
16:57:06.816632200 future-2 STARTED ForkJoinPool.commonPool-worker-5
16:57:06.815634500 future-3 STARTED ForkJoinPool.commonPool-worker-7
16:57:07.833576500 future-3 ENDED ForkJoinPool.commonPool-worker-7
16:57:08.826339700 future-1 ENDED ForkJoinPool.commonPool-worker-3
16:57:10.833705100 future-2 ENDED ForkJoinPool.commonPool-worker-5
16:57:09.828411100 FUTURE : null
```

## example using [CompletableFuture.anyOf(x, x, x...)](#-)

```java
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AnyAllOfExample {

	public static void main(String[] args) {

		CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(future1(), future2(), future3());

		System.out.println(LocalTime.now() + " Do Something " + Thread.currentThread().getName());

		delay(3);

		System.out.println(LocalTime.now() + " FUTURE : " + anyOfFuture.join());
	}

	public static CompletableFuture<String> future1() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " future-1 STARTED " + Thread.currentThread().getName());
			delay(2);
			System.out.println(LocalTime.now() + " future-1 ENDED " + Thread.currentThread().getName());
			return "future-1";
		});
	}

	public static CompletableFuture<String> future2() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " future-2 STARTED " + Thread.currentThread().getName());
			delay(4);
			System.out.println(LocalTime.now() + " future-2 ENDED " + Thread.currentThread().getName());
			return "future-2";
		});
	}

	public static CompletableFuture<String> future3() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println(LocalTime.now() + " future-3 STARTED " + Thread.currentThread().getName());
			delay(1);
			System.out.println(LocalTime.now() + " future-3 ENDED " + Thread.currentThread().getName());
			return "future-3";
		});
	}

	public static void delay(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
```

#### Console output shows :

All Threads started at the same time (Including main Thread). </br>
Each Thread finished at differetn time (Because of it's delay time). </br>
[anyOf()](#-) returns the first Future that finishes (Which is Future-3). </br>
	Question : why future-2 is not ENDED? </br>
	Answer : Because of it's delay Time is 4 , and does not have enough time to finish. anyOfFuture.join() finish execution , but Future-2 doesn't END. </br>
	if we change the Delay Time we of Future-2 , or the main Thread delay (make it 3 for example) , Future-2 will END as well.

```java
17:15:04.459730500 Do Something main
17:15:04.460728200 future-1 STARTED ForkJoinPool.commonPool-worker-3
17:15:04.459730500 future-3 STARTED ForkJoinPool.commonPool-worker-7
17:15:04.459730500 future-2 STARTED ForkJoinPool.commonPool-worker-5
17:15:05.465097600 future-3 ENDED ForkJoinPool.commonPool-worker-7
17:15:06.466269100 future-1 ENDED ForkJoinPool.commonPool-worker-3
17:15:07.474717800 FUTURE : future-3
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
	
###### 22

<img src="https://img.shields.io/badge/-22. Fork/Join framework %20-blue" height=40px>
	
https://www.youtube.com/watch?v=GJ5Tx43q6KM
	
```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 23

<img src="https://img.shields.io/badge/-24. ConcurrentMap %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)



