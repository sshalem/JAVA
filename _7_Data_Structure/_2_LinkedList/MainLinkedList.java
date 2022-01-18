package demo;

public class MainLinkedList {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();

		list.insertLast("10");
		list.insertLast("20");
		list.insertLast("30");
		list.insertLast("40");
		list.insertLast("50");

//		list.print();
//		int indexOf = list.indexOf("test");
//		System.out.println(indexOf);
//
//		list.insertFirst("60");
//		list.print();
//
//		boolean contains = list.contains("karin");
//		System.out.println(contains);
//
//		list.removeFirst();
//		list.print();
		
//		list.removeLast();
		list.print();
		
//		System.out.println(list.size());

//		Object[] array = list.toArray();
		
//		System.out.println(Arrays.toString(array));
		
//		list.reverse();
		
		Object object = list.getDataOfNodeFromEndOfLinkedList(0);
		System.out.println(object);
		

	}
}
