package demo;

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
