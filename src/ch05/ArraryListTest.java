package ch05;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * 
 * @author niuzhihuan
 */
public class ArraryListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Employee> staff = new ArrayList<>();
		staff.add(new Employee("carl crecker", 7500, 1987, 12, 15));
		staff.add(new Employee("Harry hacker", 5000, 1989, 10, 1));
		staff.add(new Employee("Tony Tester", 4000, 1990, 3, 15));

		for (Employee employee : staff) {
			employee.raiseSalary(5);
		}
		for (Employee employee : staff) {
			System.out.println("name=" + employee.getName() + ",salary=" + employee.getSalary() + ",hireDay="
					+ employee.getHireDay());
		}
	}
}
