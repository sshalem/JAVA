###### _
<img src="https://img.shields.io/badge/-%20Queue : Data Structure%20-brightgreen" height=50px>

Queue is a **FIFO**  **_First In First Out_** </br>
Internally , Queue uses an **_Array_** or a **_LinkedList_** or **_Stack_**. </br>

<img src="https://img.shields.io/badge/-Examples of Queue implementations%20-brightgreen" height=30px>

1. Queue
2. PriorityQueue
3. BlockingQueue
4. PriorityBlockingQueue
5. ...

|       |    <img src="https://img.shields.io/badge/-Table of Content%20-blue" height=30px>         |
|:-----:|:------------------------------| 
|   1   |[Runtime Complexity](#__)   | 
|   2   |[Queue implement by CircularArray](#___)   |
|   3   |[PriorityQueue](#____)   | 
|   4   |[Interview question : Reverse Queue](#_____)  | 
|   5   |[Interview question : implement Queue with 2 stacks](#______)  | 
|   6   |[Interview question : implement Queue using LinkedList](#_______)  | 



------------------------------------------------------------------------------------------------------------------------------------
###### __

<img src="https://img.shields.io/badge/-Runtime Complexity%20-blue" height=35px>

|  <img src="https://img.shields.io/badge/-O(x)%20-blue" height=30px>  |             |
|:-----:|:------------------------------| 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px> |[enqueue]()   | 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[dequeue]()  |   
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[peek]()  |  
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[empty]() |   
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[full]() |   

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

------------------------------------------------------------------------------------------------------------------------------------
###### ___

<img src="https://img.shields.io/badge/-Queue implement by CircularArray%20-blue" height=35px>  

### Implement Queue by Circular Array , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) enqueue
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) dequeue
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) peek
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) isEmpty
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) isFull

Queue Implementation using **Circular Array**.</br>
* We **_add_** to the **_rear_** of the array.
* We **_remove_** from the **_front_** of the array.

Let's add to queue 3 items : </br>
	**[10, 20, 30, 0, 0]**

If we remove 2 items from Queue we get the following array:</br>
	**[0, 0, 30, 0, 0]**
	
Let's now add 4 items to Queue:</br>
	**[60, 70, 30, 40, 50]**
	
We can see it's in a Circular.</br>

Let's say we add 1 more items what will happen?</br>
	**[60, 70, 30, 40, 50]**

We will get IllegalStateException


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

```java
public class ArrayQueue {

	private int[] array = new int[5];
	private int front;
	private int rear;
	private int count;

	public void enqueue(int item) {
		if (count == array.length) {
			throw new IllegalStateException();
		}
		array[rear] = item;
		/**
		* This is to make the Array Circular
		*/
		rear = (rear + 1) % array.length;
		count++;
	}

	public int dequeue() {
		int item = array[front];
		array[front] = 0;
		/**
		* This is to make the Array Circular
		*/
		front = (front + 1) % array.length;
		count--;
		return item;
	}

	public int peek() {
		if (isEmpty())
			throw new IllegalStateException();
		return array[front];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public boolean isFull() {
		return count == array.length;
	}

	@Override
	public String toString() {
		return Arrays.toString(array);
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------
###### ____ 

<img src="https://img.shields.io/badge/-PriorityQueue%20-blue" height=35px> 

A PriorityQueue is used when the objects are supposed to be processed based on the **priority**. </br>
It is known that a Queue follows the **First-In-First-Out** algorithm, but sometimes the elements of the queue are needed to be processed according to the priority, that’s when the PriorityQueue comes into play.</br>
The PriorityQueue is based on the priority heap.</br>
The elements of the priority queue are ordered according to the natural ordering, or, by a Comparator provided at queue construction time, depending on which constructor is used.  

<img src="https://user-images.githubusercontent.com/36256986/150425164-d7ed397c-9ca3-4043-a7b7-5cda942c782b.PNG" width="600" height="600" />


```java
import java.util.Arrays;

public class PriorityQueueImpl {

	/**
	 * assume we have the following PriorityQueue [1, 3, 4, 7]. Now we want to
	 * Insert (2). After we insert the number (2) to the Queue , it's position needs
	 * to be at [1, 2, 3, 4, 7] because it's order in a priority manner
	 */

	private int[] items = new int[5];
	private int count;

	public void add(int item) {

		/**
		 * assume we have the following PriorityQueue [1, 3, 4, 7]. Now we want to
		 * Insert (2). After we insert the number (2) to the Queue , it's position needs
		 * array[1] to be at [1, 2, 3, 4, 7] because it's order in a priority manner. SO
		 * first we SHIFT RIGTH all elements from position array[1]. then I insert the
		 * value of the to the position array[1].
		 */

		if (count == items.length)
			throw new IllegalStateException();

		/*
		 * Shifting Items to the Right
		 */
		int i = shiftItemsToRight(item);
		items[i + 1] = item;
		count++;

	}

	private int shiftItemsToRight(int item) {
		int i;
		for (i = count - 1; 0 <= i; i--) {
			if (items[i] > item) {
				items[i + 1] = items[i];
			} else {
				break;
			}
		}
		return i;
	}

	public int remove() {
		if (count == 0)
			throw new IllegalStateException();

		int returnItem = items[0];
		count--;
		shiftItemsToLeft();

		return returnItem;
	}

	private void shiftItemsToLeft() {
		for (int i = 0; i < count; i++) {
			items[i] = items[i + 1];
		}
	}

	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public String toString() {
		int[] copyOfArray = Arrays.copyOf(items, count);
		return Arrays.toString(copyOfArray);
	}

}

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)



-----------------------------------------------------------------
###### _____ 

<img src="https://img.shields.io/badge/-Interview question : Reverse Queue%20-blue" height=35px> 


```java
import java.util.Stack;

public class QueueImplWith2Stacks {

	/**
	 * Q [10, 20, 30, 40] 
	 * S1 --> enqueue 
	 * S2 --> dequeue
	 */
	public Stack<Integer> stack1 = new Stack<Integer>();
	public Stack<Integer> stack2 = new Stack<Integer>();

	public void enqueue(int item) {
		stack1.push(item);
	}

	public int dequeue() {
		if (stack1.isEmpty() && stack2.isEmpty())
			throw new IllegalStateException();
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int peek() {
		if (stack1.isEmpty() && stack2.isEmpty())
			throw new IllegalStateException();
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
}
```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------

###### ______ 

<img src="https://img.shields.io/badge/-Interview question : implement Queue with 2 stacks%20-blue" height=35px> 


```java
import java.util.Stack;

public class QueueImplWith2Stacks {

	/**
	 * Q [10, 20, 30, 40] 
	 * S1 --> enqueue 
	 * S2 --> dequeue
	 */
	public Stack<Integer> stack1 = new Stack<Integer>();
	public Stack<Integer> stack2 = new Stack<Integer>();

	public void enqueue(int item) {
		stack1.push(item);
	}

	public int dequeue() {
		if (stack1.isEmpty() && stack2.isEmpty())
			throw new IllegalStateException();
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int peek() {
		if (stack1.isEmpty() && stack2.isEmpty())
			throw new IllegalStateException();
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
}
```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------

###### _______ 

<img src="https://img.shields.io/badge/-Interview question : implement Queue using LinkedList%20-blue" height=35px> 


```java
import java.util.ArrayList;

public class LinkedListQueue {

	private class Node {
		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	private Node head;
	private Node tail;
	private int count;

	// O(1)
	public void enqueue(int item) {
		Node node = new Node(item);

		if (isEmpty())
			head = tail = node;
		else {
			tail.next = node;
			tail = node;
		}

		count++;
	}

	// O(1)
	public int dequeue() {
		if (isEmpty())
			throw new IllegalStateException();

		int value;
		if (head == tail) {
			value = head.value;
			head = tail = null;
		} else {
			value = head.value;
			Node second = head.next;
			head.next = null;
			head = second;
		}

		count--;

		return value;
	}

	// O(1)
	public int peek() {
		if (isEmpty())
			throw new IllegalStateException();

		return head.value;
	}

	// O(1)
	public int size() {
		return count;
	}

	// O(1)
	public boolean isEmpty() {
		return head == null;
	}

	// O(n)
	public String toString() {
		ArrayList<Integer> list = new ArrayList<>();

		Node current = head;
		while (current != null) {
			list.add(current.value);
			current = current.next;
		}

		return list.toString();
	}
}
```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------

###### ______ 

<img src="https://img.shields.io/badge/-Interview question : %20-blue" height=35px> 


```java

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------

###### ______ 

<img src="https://img.shields.io/badge/-Interview question : %20-blue" height=35px> 


```java

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------

###### ______ 

<img src="https://img.shields.io/badge/-Interview question : %20-blue" height=35px> 


```java

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)
