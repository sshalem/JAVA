package demo;

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
