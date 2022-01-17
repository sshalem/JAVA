<img src="https://img.shields.io/badge/-%20Array Data Structure%20-brightgreen" height=50px>
_

### I will implement ArrayList Class from Scratch , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) insert
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) removeAt
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) indexOf
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) print 

### Also will see the Run time Complexity


```java
	public class Array {

	private int[] array;
	private int count = 0;

	public Array(int length) {
		super();
		this.array = new int[length];
	}

	public void insert(int number) {
		if (count == array.length) {
			int[] newArray = new int[count * 2];
			for (int i = 0; i < count; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		array[count] = number;
		count++;
	}

	public void removeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IllegalArgumentException();
		}
		for (int i = index; i < count; i++) {
			array[i] = array[i + 1];
		}
		count--;
	}

	public int indexOf(int number) {

		for (int i = 0; i < count; i++) {
			if (array[i] == number) {
				return i;
			}
		}
		return -1;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(array[i]);
		}
	}

}

```

# Run the projects
### Via Boot Dashboard we can see the number of instances running:

![Boot_Dashboard](https://user-images.githubusercontent.com/36256986/148125783-4f1e40e1-4d95-49ce-aeda-4c390785225c.PNG)

#### If we take a look at browse to **_erueka url_** we see all instaces created.

<img src="https://img.shields.io/badge/we%20can%20see%20that%20port%20number%20is%20-shown-brightgreen" height="30" />


![Eureka_assigned_Ports](https://user-images.githubusercontent.com/36256986/148130279-c8423d76-9775-4cc9-b38e-b6797e265596.PNG)


(I show how to use ZUUL gateway in another project)
**_ZUUL_** and **_Spring-Cloud-Gateway_** do the same , but there is difference between them:

**_NOTE_**:

	##### Zuul

		Zuul is built on servlet 2.5 (works with 3.x), using blocking APIs. </br>
		It doesn't support any long lived connections, like websockets.</br>
		From <https://stackoverflow.com/questions/47092048/how-is-spring-cloud-gateway-different-from-zuul> </br>

	##### Spring Cloud Routing (gateway) 

		Gateway is built on Spring Framework 5, Project Reactor and Spring Boot 2 using non-blocking APIs. </br>
		Websockets are supported and it's a much better developer experience since it's tightly integrated with Spring.</br>

		From <https://stackoverflow.com/questions/47092048/how-is-spring-cloud-gateway-different-from-zuul> </br>



[Back_to_top](#_)

```java

```
