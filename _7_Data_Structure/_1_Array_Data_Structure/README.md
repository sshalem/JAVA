<img src="https://img.shields.io/badge/-%20Array Data Structure%20-brightgreen" height=50px>

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) C-Customer
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) O-Order
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) E-Eureka
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) G-Gateway 
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) MI-Multiple Instances 


In this project I have 4 microservices:

|     |  micro-services           |
|:---:|:------------------------------| 
|  1  |[customer-service](#_)    | 
|  2  |[order-service](#_) |  
|  3  |[eureka-discovery-server-service](#_) |
|  4  |[spring-cloud-gateway](#_) |

**_Spring-Cloud-Gateway_** is responsible for:
	1. routing
	2. load balancing

I create 3 instances for **customer MS** and 2 instances for **order MS**. </br>
I added to **CustomerController** and **OrderController** the following lines ,in order to see that Load Blanaced is working.</br>
This way we can see which instance is processing the Request.</br>

```java
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Value("${server.port}")
	int port;
	
	@PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity) {

		log.info("port number : --> " + port);
		CustomerEntity returnedValue = customerDaoImpl.createCustomer(customerEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnedValue);
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



[Back_to_top](#Table-of-contents)

```java

```
