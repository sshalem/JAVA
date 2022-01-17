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
	
	/**
	* Here I make a dynamic array 
	* If array reached it's last element , 
	* I create new array with twice the length of previous one
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


[Back_to_top](#_)

