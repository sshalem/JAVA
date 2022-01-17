package demo;

public class MainArrayDataStructure {

	public static void main(String[] args) {
		
		Array arr = new Array(3);
		
		arr.insert(10);
		arr.insert(20);
		arr.insert(30);
		arr.insert(40);
		arr.insert(50);
		
		arr.removeAt(3);
		
		arr.print();
		
		int indexOfNumberInArray= arr.indexOf(20);
		System.out.println(indexOfNumberInArray);
		
	}

}
