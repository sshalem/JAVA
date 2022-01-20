package demoQueue;

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
