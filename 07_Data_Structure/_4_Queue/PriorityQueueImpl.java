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
