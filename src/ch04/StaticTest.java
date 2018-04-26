package ch04;

import java.time.LocalDate;

/**
 * 
 * @author niuzhihuan
 */
public class StaticTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee1[] staff=new Employee1[3];
		staff[0]=new Employee1("carl crecker", 7500, 1987, 12, 15);
		staff[1]=new Employee1("Harry hacker", 5000, 1989, 10, 1);
		staff[2]=new Employee1("Tony Tester", 4000, 1990, 3, 15);
		
		for (Employee1 employee : staff) {
			employee.raiseSalary(5);
		}
		for (Employee1 employee : staff) {
			System.out.println("name="+employee.getName()+",id="+employee.getId()+",salary="
								+employee.getSalary()+",hireDay="+employee.getHireDay());
		}
	}

}

class Employee1 {
	private static int nextId=1;
	private int id;
	private String name;
	private double salary;
	private LocalDate hireDay;
	public Employee1(String nString,double d,int year,int month,int day) {
		name=nString;
		salary=d;
		hireDay=LocalDate.of(year, month, day);
		setId(0);
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

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = nextId;
		nextId++;
	}
	public static int getNextId() {
		return nextId;
	}
}
