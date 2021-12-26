# Table of contents
* [1. Random numbers generator](#Random-Numbers-Generator)
* [2. Random String Generator](#Random-String-Generator)

# Add Tables
Colons can be used to align columns.

| 	  |                Subject                                   | Cool  |
| --------|:--------------------------------------------------------:| -----:|
|  1      | [Random numbers generator](#Random-Numbers-Generator)    | $1600 |
|  2      | [Random String Generator](#Random-String-Generator)      |   $12 |
|  3      | are neat          					     |    $1 |



There must be at least 3 dashes separating each header cell.
The outer pipes (|) are optional, and you don't need to make the 
raw Markdown line up prettily. You can also use inline Markdown.

Markdown | Less | Pretty
--- | --- | ---
*Still* | `renders` | **nicely**
1 | 2 | 3


## Random Numbers Generator
```java
import java.util.Random;

public class RandomNumbersGenerator {
	public static void main(String[] args) {

		// randomize number between 0-9
		Random random = new Random();
		int r1 = random.nextInt(10);
		System.out.println(r1);

		// randomize number between 20-49
		int r2 = 20 + random.nextInt(30);
		System.out.println(r2);

		/*********************************
		 * Using the Math.random() method
		 **********************************/

		// randomize number between 0-100
		int r3 = (int) (Math.random() * 101);
		System.out.println(r3);
	}
}
```
## Random String Generator
```js
import java.security.SecureRandom;
import java.util.Random;

public class RandomStringGenerator {

	public static void main(String[] args) {

		String generatedRandomString = randomStringGenerator(30);
		System.out.println(generatedRandomString);
	}

	public static String randomStringGenerator(int length) {

		Random random = new SecureRandom();
		String alphaBet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		StringBuilder randomString = new StringBuilder(length);

		int alphaBetStringLength = alphaBet.length();

		for (int i = 0; i < length; i++) {
			int nextInt = random.nextInt(alphaBetStringLength);
			char charAtAlphaBetString = alphaBet.charAt(nextInt);
			randomString.append(charAtAlphaBetString);
		}
		return new String(randomString);
	}
}
```
