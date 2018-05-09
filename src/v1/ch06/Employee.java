package v1.ch06;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>, Cloneable{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(String name,double d) {
		this.name=name;
		salary=d;
		hireDay=new Date();
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

	public void setHireDay(int year,int month,int day) {
		Date newHireDay=new GregorianCalendar(year, month, day).getTime();
		hireDay.setTime(newHireDay.getTime());
	}
	/**
	 * @return the hireDay
	 */
	public Date getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent) {
		double raise=salary*byPercent/100;
		salary+=raise;
	}
	@Override
	public int compareTo(Employee o) {
		return Double.compare(salary, o.getSalary());
	}
	@Override
	public Employee clone() throws CloneNotSupportedException {
		Employee cloned=(Employee)super.clone();
		cloned.hireDay=(Date)hireDay.clone();
		return cloned;
		
	}
	public String toString() {
		return "Employee[name="+name+" ,salary="+salary+" ,hireDay="+hireDay+"]";
	}
}
