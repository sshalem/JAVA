<img src="https://img.shields.io/badge/-JSON data binding (Serialization) %20-blue" height=60px>

###### _

|     | Subject                                              |
| :-: | :--------------------------------------------------- |
|     | [JSON data binding (JACKSON)](#JSON_data_binding)    |
|  1  | [Convert JSON to POJO](#1_Convert_JSON_to_POJO)      |
|  2  | [Convert POJO to JSON](#2_Convert_POJO_to_JSON)      |


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


- Example of a Simple JSON object: </br>

```json
{
    "id" : 2058,
    "title" : "JAVA Title",
    "description" : "Many to many",
    "published": true
    "courses" : null
}
```

- Example of Nested JSON object : /br>

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

- Example JON Arrays  : /br>

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


1. JSON to JAVA POJO:
* Convert JSON to JAVA POJO 
* Jackson project calls setter methods on POJO. 
* It doesn't access internal private fields directly.

2. JAVA POJO to JSON:
* Convert JAVA POJO to JSON
* Jackson project calls getter methods on POJO. 
		

### Spring and Jackson Support

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
	1. Sample-lite.json
	2. Sample-full.json


#### [Sample-lite.json](#-)

```json
{
	"id": 14,
	"firstName": "Mario",
	"lastName": "Rossi",
	"active": true
}
```

#### [Sample-full.json](#-)

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

#### [Main App](#-)

```java
import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

	public static void main(String[] args) {

		try {
			// create ObjectMapper
			ObjectMapper mapper = new ObjectMapper();

			// 1. read JSON file data/sample-lite.json
			// 2. Create new Student Instance
			// 3. map/convert to Java POJO:
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println(student);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
```


[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------


###### 2_Convert_POJO_to_JSON

<img src="https://img.shields.io/badge/- 2. Convert_POJO_to_JSON %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------




## [```Example Convert JSON to POJO```](#-)


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

######

<img src="https://img.shields.io/badge/- X %20-blue" height=40px>

[<img src="https://img.shields.io/badge/-Back to top%20-brown" height=22px>](#_)

------------------------------------------------------------------------------------------------------
