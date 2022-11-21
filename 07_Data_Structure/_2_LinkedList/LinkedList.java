package demo;

import java.util.NoSuchElementException;

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

	/**
	 * removeFirst element
	 */
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

	/**
	 * removeLast Element
	 */
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

	/**
	 * 
	 * @return Size 
	 */
	public int size() {
		return this.size;		
	}
	
	/**
	 * 
	 * @return Convert LinkedList to Array 
	 */
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
	
	/**
	 * My Implementation for printing the Data
	 */
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
}
