###### _
<img src="https://img.shields.io/badge/-%20Array Data Structure%20-brightgreen" height=50px>



### I will implement ArrayList Class from Scratch , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) insert
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) removeAt
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) indexOf
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) print 

### Also will see the Run time Complexity

![Array_Runttime_Complexity](https://user-images.githubusercontent.com/36256986/149771830-270a1188-eb1e-49e0-b2ff-747cd805a857.png)



|     |  <img src="https://img.shields.io/badge/-Runtime Complexity%20-blue" height=40px>           |
|:---:|:------------------------------| 
|  1  |[Array]()    | 
|  2  |[LinkedList]()  |   
|  3  |[Stack]() |   
|  4  |[Queue]() |   
|  5  |[HashTable]() |  
|  6  |[Binary Tree]()    | 
|  7  |[AVL Tree]()  |   
|  8  |[Heaps]() |   
|  9  |[Tries]() |   
|  10  |[Graphs]() |  
|  11  |[Undirected Graphs]() |  
|  12  |[Sorting Algorithms]() |  
|  13  |[Searching Algorithms]() |  
|  14  |[String Manipulation Algorithms]() |  





```java
	public class Array {

	private int[] array;
	private int count = 0;

	public Array(int length) {
		super();
		this.array = new int[length];
	}
	
	/**
	* Here I make a dynamic array 
	* Why?
	* If array reached it's last element , I want to extend the array
	* Thus, I create new array with twice the length of previous one
	* Then copy the content fo Old Array to new one
	*/
	public void insert(int number) {
		if (count == array.length) {
			int[] newArray = new int[count * 2];
			for (int i = 0; i < count; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[count] = number;
		count++;
	}

	/**
	* To remove an element at specific Index
	* I am acutally need to Shift Left all the elemnts 
	* from the specific index position.
	* I start the loop from ->  int i = index
	*/
	public void removeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IllegalArgumentException();
		}
		for (int i = index; i < count; i++) {
			array[i] = array[i + 1];
		}
		count--;
	}

	public int indexOf(int number) {
		for (int i = 0; i < count; i++) {
			if (array[i] == number) {
				return i;
			}
		}
		return -1;
	}

	/**
	* this method prints to console only the
	* number of elements inside the array 
	*/
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(array[i]);
		}
	}

}

```


[Back_to_top](#_)

