package demoQueue;

import java.util.Arrays;

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
