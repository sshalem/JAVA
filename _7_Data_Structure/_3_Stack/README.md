###### _
<img src="https://img.shields.io/badge/-%20Stack Data Structure%20-brightgreen" height=50px>

Stack is a **LIFO** (Last In first Out) </br>
Internally , Stack uses an **_Array_** or a **_LinkedList_**. </br>
* We don’t have lookups (Stack are not meant for that)
* Stack Extends Vector Class

|       |             |
|:-----:|:------------------------------| 
|   1   |[Runtime Complexity](#__)   | 
|   2   |[Stack implement from scratch](#___)   | 
|   3   |[Interview Question - Reverse String](#____)  | 


------------------------------------------------------------------------------------------------------------------------------------
###### __

<img src="https://img.shields.io/badge/-Runtime Complexity%20-blue" height=35px>

|  <img src="https://img.shields.io/badge/-O(x)%20-blue" height=30px>  |             |
|:-----:|:------------------------------| 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px> |[push]()   | 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[pop]()  |   
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[peek]()  |  
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[empty]() |   

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

------------------------------------------------------------------------------------------------------------------------------------
###### ___

<img src="https://img.shields.io/badge/-Stack implement from scratch%20-blue" height=35px>  

### I implement of Stack class from Scratch , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) push
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) pop - Return the Object & **_Remove_** it from Stack
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) peek - Return the Object but **_Keep_** it in Stack
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) isEmpty
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) toString

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

```java
public class Stack {

	private int size = 0;
	private int length = 5;
	private Object[] array = new Object[length];

	public void push(Object obj) {
		if (size == length) {
			throw new StackOverflowError();
		}
		this.array[size++] = obj;
	}

	public Object pop() {
		if (size == length)
			throw new ArrayIndexOutOfBoundsException();
		Object obj = this.array[--size];
		return obj;
	}

	public Object peek() {
		Object obj = this.array[size - 1];
		return obj;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public String toString() {
		Object[] arr = Arrays.copyOfRange(array, 0, size);
		return Arrays.toString(arr);
	}
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------
###### ____ 

<img src="https://img.shields.io/badge/-Interview Question Reverse String%20-blue" height=35px> 

Reverse a String , for example : if I have a String of  **"abcdefg"** </br>
I want to have an algorithm to reverse the string to get **"gfedcba"** </br>

```java
public String reverse(String str) {
 
	if (str == null)
		throw new IllegalArgumentException();

	Stack<Character> stack = new Stack<Character>();

	for (int i = 0; i < str.length(); i++) {
		stack.push(str.charAt(i));
	}

	StringBuffer reverse = new StringBuffer();
	for (int i = 0; i < str.length(); i++) {
		Character pop = stack.pop();
		reverse.append(pop);
	}
	return reverse.toString();
}
```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)
