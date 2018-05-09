package v1.ch06;

/**
 * 
 * @author niuzhihuan
 */
public class CloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Employee original=new Employee("john", 5000);
			original.setHireDay(2000, 1, 1);
			Employee copy=original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 31);
			System.out.println("orgin="+original);
			System.out.println("copy="+copy);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
