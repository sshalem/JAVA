package demoHash;

import java.util.HashMap;
import java.util.Map;

public class CharFinder {

	/**
	 * the String "A Green Apple" 
	 * has following characters:
	 * a - 2 char
	 * empty space - 2 char
	 * g -1 char
	 * r - 1 char
	 * e - 3 char
	 * n -1 char
	 * p -2 char
	 * l - 1char
	 * 
	 *  The first Non repeated Char is "G"
	 */

	public char nonReapetCharacter(String str) {

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char ch : str.toCharArray()) {
			if (map.containsKey(ch)) {
				Integer count = map.get(ch);
				map.put(ch, count + 1);
			} else {
				map.put(ch, 1);
			}

//			Integer count = map.containsKey(ch) ? map.get(ch) : 0;
//			map.put(ch, count + 1);
		}

		for (char ch : str.toCharArray()) {
			if (map.get(ch) == 1) {
				return ch;
			}
		}
		return Character.MIN_VALUE;
	}
}
