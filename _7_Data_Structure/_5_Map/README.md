###### _
<img src="https://img.shields.io/badge/-%20Map : Data Structure%20-blue" height=50px>

* Map is a Key,Value  --> Map<K,V>

(Note :	Set has also Hash implemented --> HashSet, but it only has a key)

<img src="https://img.shields.io/badge/-Examples of Map implementations%20-brightgreen" height=30px>

1. HashMap (Can have key as null, can have value as null)
2. HashTable (Thread safe)

|       |    <img src="https://img.shields.io/badge/-Table of Content%20-blue" height=30px>         |
|:-----:|:------------------------------| 
|   1   |[Runtime Complexity](#_)   | 
|   2   |[Interview question : Find the first Non repeated character](#__) | 




------------------------------------------------------------------------------------------------------------------------------------
###### __

<img src="https://img.shields.io/badge/-Runtime Complexity%20-blue" height=35px>

|  <img src="https://img.shields.io/badge/-O(x)%20-blue" height=30px>  |             |
|:-----:|:------------------------------| 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px> |[enqueue]()   | 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[dequeue]()  |   
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[peek]()  |  
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[empty]() |   
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px>  |[full]() |   

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)


-----------------------------------------------------------------

###### __ 

<img src="https://img.shields.io/badge/-Interview question : Find the first Non repeated character%20-blue" height=35px> 


```java
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
```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)

-----------------------------------------------------------------

###### ______ 

<img src="https://img.shields.io/badge/-Interview question : %20-blue" height=35px> 


```java

```
[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=25px>](#_)
