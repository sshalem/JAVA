<img src="https://img.shields.io/badge/-JSON data binding (Serialization) %20-blue" height=60px>

###### _

|     | Subject                                              |
| :-: | :--------------------------------------------------- |
|     | [JSON data binding (JACKSON)](#JSON_data_binding)    |
|  1  | [Convert JSON to POJO (ObjectMapper)](#1_Convert_JSON_to_POJO)      |
|  2  | [Convert POJO to JSON (ObjectMapper)](#2_Convert_POJO_to_JSON)      |
|  3  | [Spring Convert JSON to POJO (ObjectMapper)](#3_spring_convert_json_to_pojo)      |


------------------------------------------------------------------------------------------------------

###### JSON_data_binding

<img src="https://img.shields.io/badge/- JSON data binding (JACKSON) %20-blue" height=40px>

* Data Binding is the process of converting JSON data to a JAVA POJO
* Also known as : mapping, Serialization/Deserialization , Marshalling/Unmarshalling
* Spring uses the JACKSON Project behind the scene.
* JACKSON handles data binding between JSON and JAVA POJO.

JACKSON data Binding API:
* Package:  com.fasterxml.jackson.databind
* Supports XML and JSON
* By default JACKSON calls appropriate getter/setter methods


[Question:](#-) </br>
What is JSON?

[Answer:](#-) </br>
JSON - JavaScript Object Notation

### [JSON object are key/value pairs :](#-) </br>
* key (or name) - on the left side ,is always in double quotes.
* value - String value always in double quotes </br>
		Number w/o quotes </br>
		null w/o quotes </br>
		boolen true/false w/o quotes </br>


1. Example of a Simple JSON object: </br>

```json
{
    "id" : 2058,
    "title" : "JAVA Title",
    "description" : "Many to many",
    "published": true
    "courses" : null
}
```

2. Example of Nested JSON object : </br>

```json
{
    "id" : 2058,
    "title" : "JAVA Title",
    "description" : "Many to many",
    "published": true
    "address" : {
    			"street" : "100 begin ",
			"city" : "holon"
		}
}
```

3. Example JON Arrays  : </br>

```json
{
	"id": 14,
	"firstName": "Mario",
	"lastName": "Rossi",
	"active": true,
	"address": {
		"street": "100 Main St",
		"city": "Philadelphia",
		"state": "Pennsylvania",
		"zip": "19103",
		"country": "USA"
	},
	"languages" : ["Java", "C#", "Python", "Javascript"]
}
```


### [JSON to JAVA POJO:](#-)
* Convert JSON to JAVA POJO 
* Jackson project calls setter methods on POJO. 
* It doesn't access internal private fields directly.

### [JAVA POJO to JSON:](#-)
* Convert JAVA POJO to JSON
* Jackson project calls getter methods on POJO. 

### [Spring and Jackson Support](#-)

The following things are done automatically , behind the scene by Jackson project ,When building Spring REST applications :
* Spring will automatically handle Jackson Integration
* JSON data being passed to REST controller is converted to POJO
* JAVA object being returned from REST controller is converted to JSON

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------

###### 1_Convert_JSON_to_POJO

<img src="https://img.shields.io/badge/- 1. Convert_JSON_to_POJO %20-blue" height=40px>

In order to do so:
1. I created a new MAVEN project (Not Spring Boot WEB which has by default the JACKSON API).
2. add the dependency of JACKSON binding from maven repository.
3. I have made 2 JSON objects, which I will read from and convert it to POJO  : 
	1. simple-object.json
	2. nested-object-array.json


#### [simple-object.json](#-)

```json
{
	"id": 14,
	"firstName": "Mario",
	"lastName": "Rossi",
	"active": true
}
```

#### [nested-object-array.json](#-)

```json
{
	"id": 14,
	"firstName": "Mario",
	"lastName": "Rossi",
	"active": true,
	"address": {
		"street": "100 Main St",
		"city": "Philadelphia",
		"state": "Pennsylvania",
		"zip": "19103",
		"country": "USA"
	},
	"languages" : ["Java", "C#", "Python", "Javascript"]
}
```

#### [Java Code](#-)

I created new MAVEN project (Not SPring, with SPring Boot (WEB) Jackson is already downloaded thus no need to add it to project)

```java
public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	
	// G/S/toString
```

#### [Main App convert a `simple-object.json`](#-)

- Let's Convert the JSON from the file `simple-object.json` a POJO and sysout the Object in console.
- console shows as expected

```java
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {
		// create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		try {

			// 1. open File 'data/simple-object.json'
			// 2. Create new Student Instance
			// 3. read from FIle and apply it on new Instance of Student using the setter methods
			Student student = mapper.readValue(new File("data/simple-object.json"), Student.class);
			
			//Convert object to JSON string and pretty print
			String _student = mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(student);			
			
			System.out.println(_student);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

#### [Main App convert a `nested-object-array.json`](#-)

- Let's Convert the JSON from the file `nested-object-array.json` a POJO and sysout the Object in console.


```java
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {
	
		// create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		try {

			// 1. open File 'nested-objects-array.json'
			// 2. Create new Student Instance
			// 3. read from FIle and apply it on new Instance of Student using the setter methods
			Student student = mapper.readValue(new File("data/nested-objects-array.json"), Student.class);
			
			//Convert object to JSON string and pretty print
			// Takes an POJO Object and then:
			// .writerWithDefaultPrettyPrinter() - convert to a JSON pattern
			// .writeValueAsString(student) - this will write the value as String
			String _student = mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(student);			
			
			// Here I sysout to console the POJO as JSON
			System.out.println(_student);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

- console shows as an error , because we need to specify the Entities at correspong to the fileds of the new JSON:

![image](https://user-images.githubusercontent.com/36256986/203153234-72577bca-170d-45b6-a5f2-53a73780c967.png)

Lets refactor our Entities classes as follows:

```java
public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	private Address address;
	private String[] languages;
	
	// G/S/toString
```

```java
public class Address {

	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
```

Now when we run the code console will show us the expecte result.

![image](https://user-images.githubusercontent.com/36256986/203160997-4216737e-7850-4741-8987-d77ce98fb8fb.png)

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------


###### 2_Convert_POJO_to_JSON

<img src="https://img.shields.io/badge/- 2. Convert_POJO_to_JSON %20-blue" height=40px>

```java

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
	public static void main(String[] args) {
		
		/************************
		 * Convert POJO to JSON
		 ************************/
		
		// create ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		// Create 
		
		String [] languages = {"hebrew" , "english", "spanish"};
		
		Student newStudent = new Student(101, "shabtay", "shalem", true, new Address(),  languages);
		
		//Convert POJO to JSON  
		try {
			// This will convert POJO to JSON and save it in the file `create-object.json`
			mapper.writeValue(new File("data/create-object.json"), newStudent);
			
			// This Convert POJO to 
			// 1. Pretty JSON format
			// 2. write value as String
			String _student = mapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(newStudent);			
			
			System.out.println(_student);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```

If we check in the data folder we will see new file with name of 'create-object.json' and JSON inside is:



[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------




## [```Example Convert JSON to POJO```](#-)


------------------------------------------------------------------------------------------------------

###### 3_spring_convert_json_to_pojo

<img src="https://img.shields.io/badge/- 3. spring_convert_json_to_pojo %20-blue" height=40px>

https://stackabuse.com/converting-json-array-to-a-java-array-or-list/

Lets see how to convert :
- an array of objects inside a JSON file for example : `jsonData.json`  
- to a JAVA POJO

```js
[
  {
    "id": "658883448115356f9a2cd83b",
    "name": "Carol Marshall",
    "salary": "$3,272.90"
  },
  {
    "id": "658883442dafc9a09349fe0b",
    "name": "Spencer Patel",
    "salary": "$3,657.34"    
  },
  {
    "id": "6588834453693a145d905100",
    "name": "Holloway Bernard",
    "salary": "$1,722.10"    
  }  
]
```

1. create a JAVA POJO with the fields of the JSON file
2. I created a RestController to get the data 

#### [Option 1 retrun as Array](#-)

```java
@GetMapping(path = "/getUsers")
public ResponseEntity<?> getData() throws StreamReadException, DatabindException, IOException {

	ObjectMapper objectMapper = new ObjectMapper();
	File file = ResourceUtils.getFile("classpath:jsonData.json");		
	User[] userList = objectMapper.readValue(file, User[].class);

	for (int i = 0; i < userList.length; i++) {
		System.out.println(userList[i]);
	}		

	return ResponseEntity.ok(userList);
}	
```

#### [Option 2 return as List](#-)

```java
@GetMapping(path = "/getUsers")
public ResponseEntity<?> getData() throws StreamReadException, DatabindException, IOException {
	// (1) Using ObjectMappaer
	ObjectMapper objectMapper = new ObjectMapper();

	// (2) I place the file inside src/main/resources
	// thus getting it from `classpath`
	File file = ResourceUtils.getFile("classpath:jsonData.json");

	// (3) 
	List<User> userList = objectMapper.readValue(file, new TypeReference<List<User>>() {
	});

	userList.forEach(user -> System.out.println(user));	
	return ResponseEntity.ok(userList);
}
```

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------

######

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------

######

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------

######

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------
