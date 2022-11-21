# [```JSON data binding```](#-)

* Data Binding is the process of converting JSON data to a JAVA POJO
* Also known as : mapping, Serialization/Deserialization , Marshalling/Unmarshalling
* Spring uses the JACKSON Project behind the scene.
* JACKSON handles data binding between JSON and JAVA POJO.

JACKSON data Binding API:
* Package:  com.fasterxml.jackson.databind
* Supports XML and JSON
* By default JACKSON calls appropriate getter/setter methods


#### Question:
What is JSON?

#### Answer:
JSON - JavaScript Object Notation

JSON object are key/value pairs : </br>
* key (or name) - on the left side ,is always in double quotes.
* value - String value always in double quotes </br>
		Number w/o quotes </br>
		null w/o quotes </br>
		boolen true/false w/o quotes </br>

- Simple JSON object

```json
{
	"id" : 2058,
    "title" : "JAVA Title",
    "description" : "Many to many",
    "published": true
	"courses" : null
}
```

- Nested JSON object
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

- Nested JSON Arrays

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


## [```Example Convert JSON to POJO```](#-)

In order to do so, I have made 2 JSON objects.
1. Sample-lite.json
2. Sample-full.json


#### Sample-lite.json

```json
{
	"id": 14,
	"firstName": "Mario",
	"lastName": "Rossi",
	"active": true
}
```

#### Sample-full.json

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

#### Java Code

I created new MAVEN project (Not SPring, with SPring Boot (WEB) Jackson is already downloaded thus no need to add it to project)

```java
public class Student {

	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	
	// G/S/toString
```

Main App
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
