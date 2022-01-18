###### _
<img src="https://img.shields.io/badge/-%20LinkedList Data Structure%20-brightgreen" height=50px>

### we have 2 types of linked list:

#### 1. Singly Linked List
#### 2. Doubly Linked List

<img src="https://img.shields.io/badge/-Singly Linked List%20-blue" height=35px>

with singly Linked List Each time we insert new Node (at begin or end) to LinkedList , we set a reference to next Node.</br>
Example :</br>
	
	add First Element: 
		When we add new element and its the first one we insert , it’s the head element and Head=last. 
		(Because it's first Element in the List), and it points to Null.
	add second element:
		When we add second Elemnt , (we update the data ) and assign refrence for the next node
		and so on...
	
```java
Node node = new Node();
last.next = node;
last = node;
```
	
	
![singly_Linked_List](https://user-images.githubusercontent.com/36256986/150023770-8a88d115-efda-4ccc-9e31-dfcd015fca34.PNG)


------------------------------------------------------------------------------------------------------------------------------------

<img src="https://img.shields.io/badge/-Doubly Linked List%20-blue" height=35px>

![Doubly_Linked_List](https://user-images.githubusercontent.com/36256986/150023766-bde4fb5e-2f7e-498e-8394-5f165929edbb.PNG)

------------------------------------------------------------------------------------------------------------------------------------

### I implement of singly LinkedList Class from Scratch , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) insertLast
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) insertFirst
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) indexOf
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) contains
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) removeFirst
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) removeLast
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) size
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) toArray
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) reverse
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) getDataOfNodeFromEndOfLinkedList
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) print 

------------------------------------------------------------------------------------------------------------------------------------

<img src="https://img.shields.io/badge/-Runtime Complexity%20-blue" height=35px>

|  <img src="https://img.shields.io/badge/-O(x)%20-blue" height=30px>  |             |
|:-----:|:------------------------------| 
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px> |[Lookup by index/value]()   | 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[Insert begin/end]()  |   
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[Insert middle]()  |  
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[Delete begin]() |   
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[Delete middle]() |   
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[Delete End]() |   
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[Delete End Doubly Linked List]() |   

------------------------------------------------------------------------------------------------------------------------------------
### The LinkedList class (Before adding all the methods) has following with :
1. private class Node
2. three fields 

```java	
public class LinkedList {

	private class Node {
		private Object data;
		private Node next;

		@Override
		public String toString() {
			return "" + data;
		}
	}

	public Node first;
	public Node last;
	public int size;
}
```

### Insert item at last of Linked List
```java
public void insertLast(Object data) {

	Node node = new Node();
	node.data = data;
	node.next = null;

	if (first == null) {
		first = node;
		last = node;			
	} else {
		last.next = node;
		last = node;			
	}
	size++;
}
```

### Insert item at first of Linked List
```java
public void insertFirst(Object data) {
	Node node = new Node();
	node.data = data;

	if (first == null) {
		first = node;
		last = node;
	} else {
		node.next = first;
		first = node;
	}
	size++;
}
```

### indexOf
```java
	public int indexOf(Object data) {
		int index = 0;
		for (Node x = first; x != null; x = x.next) {
			if (x.data == data) {
				return index;
			}
			index++;
		}
		return -1;
	}
```

### contains
```java
	public boolean contains(Object data) {
		Node x = first;
		while (x != null) {
			if (x.data == data) {
				return true;
			}
			x = x.next;
		}
		return false;
	}

```

### removeFirst
```java
	public void removeFirst() {
		/**
		 * [(Odel shabtayRef), (shabtay shalemRef), (shalem nextRef), ...] 
		 * 1. Saving the reference of second Node in the LinkedList ---> 'Second = (shabtay shalemRef)' 
		 * 2. Breaking the LinkedList between First to Second ---> First = null , Which make (Odel null) 
		 * 3. Assign second to first ---> first = (shabtay shalemRef)
		 */
		if (first == null)
			throw new NoSuchElementException();
		if (first == last) {
			first = null;
			last = null;
			size--;
			return;			
		}
		Node second = first.next;
		first = null;
		first = second;
		size--;
	}
```

### remove Last
```java
	public void removeLast() {
		
		Node current = first;
		
		if (first == null)
			throw new NoSuchElementException();
		if (first == last) {
			first = last = null;
			size--;
			return;
		}
					
		while (current != null) {	
			if(current.next == last) {
				break;
			}
			current = current.next;
		}
		last = current;
		last.next = null;
		size--;
	}

```

### size
```java
	public int size() {
		return this.size;		
	}
```

### toArray
```java
	public Object[] toArray() {
		Object[] obj = new Object[size];
		int length = 0;
		for (Node x = first; x != null; x = x.next) {
			if(length == size)
				break;
			obj[length++] = x.data;			
		}
		return obj;
	}
```

### (Interview Question) : reverse 
```java
	/**
	 * This method is a very popular Interview question:
	 * 
	 * In this method we reverse the order of the LinkedList:
	 * first will be last
	 * last will be first
	 * we need to change the direction of the reference
	 * Legend: p-Previous , c-Current, c-Next
	 * If we have LinkedList as [10 -> 20 -> 30 -> 40]
	 * 		first iteration		  p <-  c	  n
	 * 		second iteration		  	p <-  c	 	n
	 * 		third iteration		  			  p <-  c	 n
	 * 		forth iteration	'C' 					p    c	  n
	 * 		not going to point at anything	  		
	 * 	  						[10 <- 20 <- 30 <- 40]
	 *  After we change the pointer Of C, from N to P ,we will loose track Of N
	 *  Thus we keep at N the initial value of 'n=c.next' 
	 */
	public void reverse() {
		
		Node previous = first;
		Node current = first.next;
		Node next = null;
						
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;			
		}
		
		last = first;
		last.next = null;
		first = previous;
	}
```

### (Interview Question) : Find the K'th number from the END of the LinkedList in one Pass
```java
	/**
	 * This method is a very popular Interview question:
	 * 
	 * Find the Kth number from the END of the LinkedList in one Pass?
	 * 
	 * For Example:  if we have the LinkedList [10 -> 20 -> 30 -> 40 -> 50]
	 * the K = 1 (50)
	 * the K = 2 (40)
	 * the K = 3 (30)
	 * ...
	 * 
	 *  To solve this:
	 *  	use 2 pointers.
	 *  the distance between the pointers should be (k-1) nodes apart.
	 *  For example we want to know the number of the third 3 from the End
	 *  this means we want to know the position of 30.
	 *  SO , the distance between the last node to the third node form the end:
	 *   is (K-1)=2
	 *   The distance between 50 to 30 is (k-1)=2
	 *   Illustration:
	 *   [10 -> 20 -> 30 -> 40 -> 50]
	 *     T           E
	 *     		 T           E
	 *     			   T           E
	 */	
	public Object getDataOfNodeFromEndOfLinkedList(int k) {
		
		if(first == null)
			throw new IllegalStateException();
		if(k <= 0) {
			throw new NoSuchElementException();
		}			
		if(k == 1) {
			return last.data;
		}else {
			
			Node endPointer = first;
			Node targetPointer = first;
			
			for (int i = 0; i < k-1; i++) {
				endPointer = endPointer.next;
			}
			if(endPointer == null)
				throw new IllegalArgumentException("k=" + k + " is greater then size of LinkedList");
			
			while(endPointer != last) {
				endPointer = endPointer.next;
				targetPointer = targetPointer.next;
			}
			return targetPointer.data;
		}
	}
```

### print
```java
	public void print() {

		Node currentNode = first;
		System.out.print("[");
		while (currentNode != null) {
			System.out.print(currentNode.toString());
			currentNode = currentNode.next;
			System.out.print(" ,");
		}
		System.out.print("]");
		System.out.println();
	}
```

<img src="https://img.shields.io/badge/-Test the LinkedList %20-blue" height=40px> 


```java

```

[Back_to_top](#_)

