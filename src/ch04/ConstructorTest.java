package ch04;

import java.time.LocalDate;
import java.util.Random;

/**
 * 
 * @author niuzhihuan
 */
public class ConstructorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmployeeC[] staff=new EmployeeC[3];
		staff[0]=new EmployeeC("harry",40000);
		staff[1]=new EmployeeC(60000);
		staff[2]=new EmployeeC();
		
		for (EmployeeC e : staff) {
			System.out.println("name="+e.getName()+" ,id="+e.getId()+",salary="+e.getSalary());
		}
	}

}


class EmployeeC{
	private static int nextId;
	private int id;
	private String name="";
	private double salary;
	
	//静态初始化块
	static{
		Random generator=new Random();
		nextId=generator.nextInt(10000);
	}
	//实例域初始化块
	{
		setId(nextId);
		nextId++;
	}
	
	public EmployeeC(String n,double d) {
		name=n;
		salary=d;
	}
	public EmployeeC(double s) {
		this("Employee #"+nextId, s);
	}
	public EmployeeC() {
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
		this.id = id;
	}
}