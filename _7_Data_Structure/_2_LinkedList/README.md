###### _
<img src="https://img.shields.io/badge/-%20LinkedList Data Structure%20-brightgreen" height=50px>

### we have 2 types of linked list:

#### 1. Singly Linked List
#### 2. Doubly Linked List

<img src="https://img.shields.io/badge/-Singly Linked List%20-blue" height=35px>

with singly Linked List Each time we insert new Node (at begin or end) to LinkedList , we set a reference to next Node.</br>
Example :</br>
	
	Step1: When we add new element and its the first one we insert , it’s the head element and Head=last. (Because it's first Element in the List), and it points to Null.</br>
	Step2: When we add second Elemnt , (we update the data ) and assign refrence for the next node: </br>
	
```java
Node node = new Node();
last.next = node;
last = node;
```
	
	
![singly_Linked_List](https://user-images.githubusercontent.com/36256986/150023770-8a88d115-efda-4ccc-9e31-dfcd015fca34.PNG)




<img src="https://img.shields.io/badge/-Doubly Linked List%20-blue" height=35px>

![Doubly_Linked_List](https://user-images.githubusercontent.com/36256986/150023766-bde4fb5e-2f7e-498e-8394-5f165929edbb.PNG)


### implementation of simple ArrayList Class from Scratch , with following methods:

- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) insert
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) removeAt
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) indexOf
- ![#c5f015](https://via.placeholder.com/10/c5f015/000000?text=+) print 


|  <img src="https://img.shields.io/badge/-O(x)%20-blue" height=35px>  |  <img src="https://img.shields.io/badge/-Runtime Complexity%20-blue" height=35px>           |
|:-----:|:------------------------------| 
| <img src="https://img.shields.io/badge/-O(1)%20-orange" height=25px> |[Lookup by index --> array[3]]()    | 
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[Lookup by value --> we itterate over an arrary with max length on N elements ]()  |   
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[Insert --> we itterate over an arrary with max length on N elements]() |   
| <img src="https://img.shields.io/badge/-O(n)%20-orange" height=25px>  |[Delete --> we itterate over an arrary with max length on N elements]() |   


```java
	

```

<img src="https://img.shields.io/badge/-Test the LinkedList %20-blue" height=40px> 

```java

```

[Back_to_top](#_)

