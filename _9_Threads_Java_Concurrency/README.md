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
|  6  |[synchronize, Lock](#6)  | 
|  7  |[wait, notify, notify all](#7)  | 
|  8  |[join()](#8)   | 
|  9  |[interrupt()](#9)   | 
|  10 |[Semaphore](#10)   | 
|  11 |[Lock , ReentrantLock](#11)   | 
|  12 |[Lock , ReadWriteLock](#12)   | 
|  13 |[DeadLock ,Yield](#13)   | 
|  14 |[Volatile](#14)   | 
|  15 |[Atomic (Integer , Long, Boolean, Reference)](#15)   | 
|  16 |[Priority of Threads](#16)   | 
|  17 |[ThreadPoolExecutor](#17)   | 
|  18 |[Executer Interface, ExecutorService Interface, Executers Class](#18)   | 
|  19 |[Future , CompletableFuture](#19)   | 
|  20 |[BlockingQueue](#20)   | 
|  21 |[ThreadPoolExecutor](#21)   | 
|  22 |[ConcurrentMap](#22)   | 


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

Code w/o static field

```java
public class Counter {

	private volatile int count = 0;

	public Counter() {
		super();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean increment() {
		if (this.count == 10) {
			return false;
		}
		this.count++;
		return true;
	}
}

public class IncrementThread implements Runnable {

	private Counter counter;

	public IncrementThread(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		int local_counter = counter.getCount();

		while (local_counter < 10) {
			System.out.println("[T2] incremented counter to " + (local_counter + 1));
			counter.setCount(++local_counter);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class CheckThread implements Runnable {

	private Counter counter;

	public CheckThread(Counter counter) {
		super();
		this.counter = counter;
	}

	@Override
	public void run() {
		int local_counter = counter.getCount();

		while (local_counter < 10) {
			if (local_counter != counter.getCount()) {
				System.out.println("[T1] local counter is changed ");
				local_counter = counter.getCount();
			}
		}
	}
}

public class Main {
	public static void main(String[] args) {

		Counter counter = new Counter();

		CheckThread checkThread = new CheckThread(counter);
		Thread t1 = new Thread(checkThread);

		IncrementThread incrementThread = new IncrementThread(counter);
		Thread t2 = new Thread(incrementThread);

		t1.start();
		t2.start();
	}
}

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

<img src="https://img.shields.io/badge/-18.Executer Interface, ExecutorService Interface, Executers Class %20-blue" height=40px>

https://www.youtube.com/watch?v=6Oo-9Can3H8&ab_channel=DefogTech

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

###### 21

<img src="https://img.shields.io/badge/-21 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 22

<img src="https://img.shields.io/badge/-22 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------

###### 23

<img src="https://img.shields.io/badge/-23 %20-blue" height=40px>

```java
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

--------------------------------------------------------------------------------------------------
