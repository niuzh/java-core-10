package v1.ch04;

import java.time.LocalDate;

/**
 * 
 * @author niuzhihuan
 */
public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("carl crecker", 7500, 1987, 12, 15);
		staff[1]=new Employee("Harry hacker", 5000, 1989, 10, 1);
		staff[2]=new Employee("Tony Tester", 4000, 1990, 3, 15);
		
		for (Employee employee : staff) {
			employee.raiseSalary(5);
		}
		for (Employee employee : staff) {
			System.out.println("name="+employee.getName()+",salary="+employee.getSalary()+",hireDay="+employee.getHireDay());
		}
	}

}

class Employee{
	private String name;
	private double salary;
	private LocalDate hireDay;
	public Employee(String nString,double d,int year,int month,int day) {
		name=nString;
		salary=d;
		hireDay=LocalDate.of(year, month, day);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @return the hireDay
	 */
	public LocalDate getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary+=raise;
	}
}
