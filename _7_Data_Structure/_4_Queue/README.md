###### _
<img src="https://img.shields.io/badge/-%20Queue Data Structure%20-brightgreen" height=50px>

Queue is a **FIFO**  **_First In First Out_** </br>
Internally , Queue uses an **_Array_** or a **_LinkedList_** or **_Stack_**. </br>

|       |             |
|:-----:|:------------------------------| 
|   1   |[Runtime Complexity](#__)   | 
|   2   |[Queue implement by CircularArray](#___)   | 
|   3   |[Queue implement by 2 stacks](#____)  | 


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

<img src="https://img.shields.io/badge/-Queue implement by 2 stacks%20-blue" height=35px> 


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
