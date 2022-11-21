###### _
<img src="https://img.shields.io/badge/-%20Array Data Structure%20-brightgreen" height=50px>



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
	public class Array {

	private int[] array;
	private int count = 0;

	public Array(int length) {
		super();
		this.array = new int[length];
	}
	

	/**
	 * If array reached it's last element , I want to extend the array.
	 * Check if Count  == array.length
	 * If(true)
	 * 1. create 'newArray' with the length of old 'array' multiplied by 2.
	 * 2. Loop thru old 'array' and copy each element to 'newArray'
	 * 3. assign following 'array = newArray' 
	 */
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

	/**
	* To remove an element at specific Index
	* I Shift to Left all the elements 
	* from the specific index position.
	* I start the loop from -->  int i = index
	* I loop till -->  i < count-1 
	*/
	public void removeAt(int index) {
		if (index < 0 || index >= count) {
			throw new IllegalArgumentException();
		}
		for (int i = index; i < count-1; i++) {
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

	/**
	* this method prints to console only the
	* number of elements inside the array 
	*/
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(array[i]);
		}
	}

}

```

<img src="https://img.shields.io/badge/-Lets test the Array Class%20-blue" height=40px> 

```java
public class MainDataStructure {

	public static void main(String[] args) {

		Array arr = new Array(3);
		arr.insert(10);
		arr.insert(20);
		arr.insert(30);
		arr.insert(40);
		arr.insert(50);
		arr.insert(60);
		
		arr.removeAt(1);

		arr.print();

		int indexOf = arr.indexOf(40);
		System.out.println(indexOf);
	}
}
```

[Back_to_top](#_)

