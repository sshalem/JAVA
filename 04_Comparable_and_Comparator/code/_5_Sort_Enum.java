package Sort_Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum EmployeeType {
	EMPLOYEE, MANAGER, VP
}

// Employee Class implements comparable
class Employee implements Comparable<Employee> {

	private int id;
	private EmployeeType employeeType;

	public Employee(int id, EmployeeType employeeType) {
		super();
		this.id = id;
		this.employeeType = employeeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeType getTypeEmployee() {
		return employeeType;
	}

	public void setTypeEmployee(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeType=" + employeeType + "] \n";
	}

	@Override
	public int compareTo(Employee o) {
		/**
		 * This compares the ENUM value by using the ordinal() method of the enum
		 */
		return this.employeeType.ordinal() - o.employeeType.ordinal();
	}
}

// Implementing Comparator to compare by Id (which is used later by Collections.sort
class CompareById implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.getId() - arg1.getId();
	}

}

public class _5_Sort_Enum {

	public static void main(String[] args) {

		/**
		 * In this exercise we will use both: 
		 * 1. Comparator to sort Employee List the by Id
		 * 2. Comparable to sort Employee List by the ENUM
		 */
		
		
		Employee shabtay = new Employee(2345, EmployeeType.VP);
		Employee karin = new Employee(1234, EmployeeType.MANAGER);
		Employee avigail = new Employee(5468, EmployeeType.EMPLOYEE);
		Employee ariel = new Employee(5689, EmployeeType.EMPLOYEE);
		Employee odel = new Employee(7895, EmployeeType.EMPLOYEE);
		Employee father = new Employee(159, EmployeeType.MANAGER);
		Employee mother = new Employee(853, EmployeeType.MANAGER);

		ArrayList<Employee> emp = new ArrayList<>();

		emp.add(father);
		emp.add(mother);
		emp.add(shabtay);
		emp.add(ariel);
		emp.add(avigail);
		emp.add(karin);
		emp.add(odel);

		// printing the list
		System.out.println("List before sorting :\n" + emp);

		// Using Comparator to Sort ID
		Collections.sort(emp, new CompareById());

		// printing the list after sorting by ID
		System.out.println("List after sorting by ID : \n" + emp);

		/**
		 * Sort the ENUM Using Comparable method in the Employee class 
		 */
		Collections.sort(emp);

		// printing the list after sorting by EmployeeType
		System.out.println("List after sorting by ENUM EmployeeType : \n" + emp);

	}
}

/**
 Output:
 
	 List before sorting :
	 ----------------------
	[Employee [id=159, employeeType=MANAGER] 
	, Employee [id=853, employeeType=MANAGER] 
	, Employee [id=2345, employeeType=VP] 
	, Employee [id=5689, employeeType=EMPLOYEE] 
	, Employee [id=5468, employeeType=EMPLOYEE] 
	, Employee [id=1234, employeeType=MANAGER] 
	, Employee [id=7895, employeeType=EMPLOYEE]]
	
	List after sorting by ID : 
	--------------------------
	[Employee [id=159, employeeType=MANAGER] 
	, Employee [id=853, employeeType=MANAGER] 
	, Employee [id=1234, employeeType=MANAGER] 
	, Employee [id=2345, employeeType=VP] 
	, Employee [id=5468, employeeType=EMPLOYEE] 
	, Employee [id=5689, employeeType=EMPLOYEE] 
	, Employee [id=7895, employeeType=EMPLOYEE] ]
	
	List after sorting by ENUM EmployeeType :
	------------------------------------------ 
	[Employee [id=5468, employeeType=EMPLOYEE] 
	, Employee [id=5689, employeeType=EMPLOYEE] 
	, Employee [id=7895, employeeType=EMPLOYEE] 
	, Employee [id=159, employeeType=MANAGER] 
	, Employee [id=853, employeeType=MANAGER] 
	, Employee [id=1234, employeeType=MANAGER] 
	, Employee [id=2345, employeeType=VP] ]

 */
