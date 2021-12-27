package comparator;

import java.util.ArrayList;
import java.util.Collections;

public class _3_SortIntegerNumbers {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<>();

		// Sorting by numbers
		numbers.add(3);
		numbers.add(-1);
		numbers.add(5);
		numbers.add(0);

		// execute sort
		Collections.sort(numbers);
		
		/**
		 * Question:
		 * 	how can we compare Integer numbers if we didn't implement the Comparable or Comparator?
		 * 
		 * Answer:
		 * 	the Integer class already implements the comparable interface thus we are able to 
		 *  sort the List numbers
		 *  
		 *  " public final class Integer extends Number implements Comparable<Integer> "
		 */
	}

}
