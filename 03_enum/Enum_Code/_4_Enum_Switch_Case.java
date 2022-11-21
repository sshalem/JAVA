package demo;

//A Java program to demonstrate working on enum
//in switch case 

//An Enum class
enum Day {
	SUNDAY, 
	MONDAY, 
	TUESDAY, 
	WEDNESDAY, 
	THURSDAY, 
	FRIDAY, 
	SATURDAY;
}

// Class that uses the ENUM as a field with getter/setter
class DaysOfWeek {

	private Day day;

	public DaysOfWeek(Day day) {
		this.day = day;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	// Prints a line about Day using switch
	public void dayIsLike() {
		switch (day) {
		case MONDAY:
			System.out.println("Mondays are bad.");
			break;
		case FRIDAY:
			System.out.println("Fridays are better.");
			break;
		case SATURDAY:
		case SUNDAY:
			System.out.println("Weekends are best.");
			break;
		default:
			System.out.println("Midweek days are so-so.");
			break;
		}
	}
}

public class _4_Enum_Switch_Case {

	public static void main(String[] args) {

		String str = "MONDAY";
		DaysOfWeek chosenDay = new DaysOfWeek(Day.valueOf(str));
		chosenDay.dayIsLike();
	}

}
