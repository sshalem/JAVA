package stackDemo;

import java.util.Arrays;

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
