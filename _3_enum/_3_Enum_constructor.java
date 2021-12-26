package demo;

//Java program to demonstrate that enums can have constructor
//and concrete methods.

//An enum (Note enum keyword inplace of class keyword)
enum Colors {
	RED,
	GREEN,
	BLUE;

	// enum constructor called separately for each
	// constant
	private Colors() {
		System.out.println("Constructor called for : " + this.toString());
	}

	public void colorInfo() {
		System.out.println("Universal Color");
	}
}


public class _3_Enum_constructor {

	public static void main(String[] args) {
		Colors c1 = Colors.RED;
		System.out.println(c1);
		c1.colorInfo();
	}
}

/**
	Output: 

		Constructor called for : RED
		Constructor called for : GREEN
		Constructor called for : BLUE
		RED
		Universal Color
*/