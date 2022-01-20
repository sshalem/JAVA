###### _
<img src="https://img.shields.io/badge/-%20Queue Data Structure%20-brightgreen" height=50px>

Queue is a **FIFO**  **_First In First Out_** </br>
Internally , Queue uses an **_Array_** or a **_LinkedList_** or **_Stack_**. </br>

<img src="https://img.shields.io/badge/-Examples of Queue implementations%20-brightgreen" height=30px>

1. Queue
2. PriorityQueue
3. BlockingQueue
4. PriorityBlockingQueue
5. ...

|       |             |
|:-----:|:------------------------------| 
|   1   |[Runtime Complexity](#__)   | 
|   2   |[Queue implement by CircularArray](#___)   |
|   3   |[PriorityQueue](#____)   | 
|   4   |[Interview question : implement Queue with 2 stacks](#_____)  | 


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

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)



-----------------------------------------------------------------
###### _____ 

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
