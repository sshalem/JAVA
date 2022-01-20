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
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px> |[push]()   | 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[pop]()  |   
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[peek]()  |  
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[empty]() |   

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

------------------------------------------------------------------------------------------------------------------------------------
###### ___

<img src="https://img.shields.io/badge/-Queue implement by CircularArray%20-blue" height=35px>  

### I implement of Stack class from Scratch , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) enqueue
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) dequeue
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) peek
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) isEmpty
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) isFull

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
		rear = (rear + 1) % array.length;
		count++;
	}

	public int dequeue() {
		int item = array[front];
		array[front] = 0;
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

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)
