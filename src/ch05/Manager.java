package ch05;

/**
 * 
 * @author niuzhihuan
 */
public class Manager extends Employee {
	private double bonus;
	public Manager(String name,double d,int year,int month,int day) {
		super(name, d, year, month, day);
		bonus=0;
	}
	public double getSalary() {
		double baseSalary=super.getSalary();
		return baseSalary+bonus;
	}
	
	public void setBonus(double b) {
		bonus=b;
	}
}
