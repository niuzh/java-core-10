package v1.ch06;

import java.util.Arrays;


/**
 * 
 * @author niuzhihuan
 */
public class EmployeeSortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("carl crecker", 7500);
		staff[1]=new Employee("Harry hacker", 5000);
		staff[2]=new Employee("Tony Tester", 4000);
		
		for (Employee employee : staff) {
			employee.raiseSalary(5);
		}
		Arrays.sort(staff);
		for (Employee employee : staff) {
			System.out.println("name="+employee.getName()+",salary="+employee.getSalary()+",hireDay="+employee.getHireDay());
		}

	}

}
