## Table of contents
1. [General info](#general-info)
2. [Technologies](#technologies)
3. [Setup](#setup)
4. [Random numbers generator](#Random-numbers)
5. [Random String Generator](#Random-String-Generator)
## General info
This project is simple Lorem ipsum dolor generator.
	
## Technologies
Project is created with:
* Lorem version: 12.3
* Ipsum version: 2.33
* Ament library version: 999
	
## Setup
To run this project, install it locally using npm:

```
$ cd ../lorem
$ npm install
$ npm start
```

## Random

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
```java
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
