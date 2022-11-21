# [`JSON data binding`](#-)

* Data Binding is the process of converting JSON data to a JAVA POJO
* Also known as : mapping, Serialization/Deserialization , Marshalling/Unmarshalling
* Spring uses the JACKSON Project behind the scene.
* JACKSON handles data binding between JSON and JAVA POJO.

JACKSON data Binding API:
* Package:  com.fasterxml.jackson.databind
* Supports XML and JSON
* By default JACKSON calls appropriate getter/setter methods


Question:
What is JSON?
Answer:
JSON - JavaScript Object Notation </br>

JSON object are key/value pairs
key (or name) - on the left side ,is always in double quotes.
value - String value always in double quotes
		Number w/o quotes
		null w/o quotes
		boolen true/false w/o quotes

- Simple JSON object

{
	"id" : 2058,
    "title" : "JAVA Title",
    "description" : "Many to many",
    "published": true
	"courses" : null
}


- Nested JSON object

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


- Nested JSON Arrays

{
	"id" : 2058,
    "title" : "JAVA Title",
    "description" : "Many to many",
    "published": true
	"courses" : [
					{
						"courseName" : "100 begin ",
						"courseNumber" : "holon"
					},
					{
						"courseName" : "200 begin ",
						"courseNumber" : "holon"
					}					
				]
}


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


```java

```
