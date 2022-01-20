package demoQueue;

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
		/*
		 * iterate the array from End to beginning
		 */
		if (count == items.length)
			throw new IllegalStateException();
		int i;
		for (i = count - 1; 0 <= i; i--) {
			if (items[i] > item) {
				items[i + 1] = items[i];
			} else {
				break;
			}
		}
		items[i + 1] = item;
		count++;
	}

	public int remove() {
		if (count == 0)
			throw new IllegalStateException();
		return items[--count];
	}

	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(items);
	}

}
