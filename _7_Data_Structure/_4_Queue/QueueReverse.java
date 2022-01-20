package demoQueue;

import java.util.Queue;
import java.util.Stack;

public class QueueReverse {

	public Queue<Integer> reverseQueue(Queue<Integer> queue) {

		/**
		 * Here we reverse the QUeue by using a Stack
		 * Queue [10, 20 ,30, 40] 
		 * queue.remove() till it's empty and move it to a stack [10, 20 , 30, 40]
		 * 
		 * Now, Move from stack to Queue
		 */
		Stack<Integer> stack = new Stack<Integer>();

		while (!queue.isEmpty()) {
			Integer removeFromQueue = queue.remove();
			stack.push(removeFromQueue);
		}
					
		while(!stack.empty()) {
			Integer pop = stack.pop();
			queue.add(pop);
		}
			
		return queue;
	}
}
