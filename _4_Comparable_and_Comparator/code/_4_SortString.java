package comparator;

import java.util.ArrayList;
import java.util.Collections;

public class _4_SortString {

	public static void main(String[] args) {

		// Sorting by String
		// There is importance for sorting with Capital letters to small letters
		// String with capital letters will be printed first when sorting
		// for example: 'Shabtay' will be printed before 'avigail' even though 'avigail'
		// starts with an 'a'
		// since 'Shabtay' starts with a capital letter

		ArrayList<String> names = new ArrayList<>();

		names.add("shabtay");
		names.add("shalem");
		names.add("karin");
		names.add("avigail");

		Collections.sort(names);
		
		/**
		 * Question:
		 * 	how can we compare Strings if we didn't implement the Comparable or Comparator?
		 * 
		 * Answer:
		 * 	the String class already implements the comparable interface thus we are able to 
		 *  sort the List numbers
		 *  
		 *  " public final class String implements java.io.Serializable, Comparable<String>, CharSequence { "
		 */
	}

}
