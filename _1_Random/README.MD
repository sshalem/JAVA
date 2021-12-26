# Table of contents

|     |  Subject top                                            |
|-----|:--------------------------------------------------------| 
|  1  |[Random numbers generator](#1_Random-Numbers-Generator)    | 
|  2  |[Random String Generator](#2_Random-String-Generator)      |   
|  3  |                                                         |   


## 1_Random numbers generator

[TOP](#top)
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
## 2_Random String Generator

[TOP](#top)
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



--------------------------------------------------------------------------------------

# spring-security 

* this is an  example
* markdown is fast
* pretty cool

# link example
1. [israel hayom](https://www.israelhayom.co.il/)
2. [hidavroot](https://www.hidabroot.org/)

# List example
1. item one
2. item two
3. item three

# Blockquotes :
> Dorothy followed her through many of the beautiful rooms in her castle.


### Blockquotes with Other Elements  :
> ### The quarterly results look great!
>
> - Revenue was off the chart.
> - Profits were higher than ever.
>
>  *Everything* is going according to **plan**.

### Blockquotes another example:
*   This is the first list item.
*   Here's the second list item.

    > A blockquote would look great below the second list item.

*   And here's the third list item.


# Code Blocks
To create code blocks, indent every line of the block by at least four spaces or one tab.

    <html>
      <head>
      </head>
    </html>

### Code Blocks
Code blocks are normally indented four spaces or one tab. When they’re in a list, indent them eight spaces or two tabs.

1.  Open the file.
2.  Find the following code block on line 21:

        <html>
          <head>
            <title>Test</title>
          </head>
		  

```
code fences
```

```js
codeFences.withLanguage()
```

```java
codeFences.withLanguage()
```

# checkbox

- [ ] Checkbox off
- [x] Checkbox on

# Add Inline HTML

<dl>
  <dt>Definition list</dt>
  <dd>Is something people use sometimes.</dd>

  <dt>Markdown in HTML</dt>
  <dd>Does *not* work **very** well. Use HTML <em>tags</em>.</dd>
</dl>

# Add Tables
Colons can be used to align columns.

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |

There must be at least 3 dashes separating each header cell.
The outer pipes (|) are optional, and you don't need to make the 
raw Markdown line up prettily. You can also use inline Markdown.

Markdown | Less | Pretty
--- | --- | ---
*Still* | `renders` | **nicely**
1 | 2 | 3

# Add image from current repository
Dependencies.JPG

# Add Image as url
![Image](https://images.unsplash.com/photo-1528132032628-89493baa1e29?ixid=MXwxMjA3fDB8MHxzZWFyY2h8M3x8Z3JlYXR8ZW58MHx8MHw%3D&ixlib=rb-1.2.1&w=1000&q=80)
