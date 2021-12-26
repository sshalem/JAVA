package demo;

enum Days {
	SUNDAY, 
	MONDAY, 
	TUESDAY, 
	WEDNESDAY, 
	THURSDAY, 
	FRIDAY, 
	SATURDAY;
}


public class _2_Enum_methods {

	/**
	 * values(), ordinal() and valueOf() methods :
	• These methods are present inside java.lang.Enum.
	
	• values() method can be used to return all values present inside enum.
	• ordinal() method - Order is important in enums. By using ordinal() method, 
	  each enum constant index can be found, just like array index.
	• valueOf() method returns the enum constant of the specified string value, if exists.

		From <https://www.geeksforgeeks.org/enum-in-java/> 
	 */
	
	public static void main(String[] args) {
		
		//ordinal() -  returns the index of the enum in the Enum class
		Days days = Days.FRIDAY;
		System.out.println(days.ordinal());
		
		//values() - return all values present inside enum 
		Days[] values = Days.values();		
		for (Days day : values) {
			System.out.println(day);
		}
		
		// valueOf() - returns the enum constant of the specified string value, if exists
		Days day = Days.valueOf("FRIDAY");
		System.out.println(day);
	}

}
