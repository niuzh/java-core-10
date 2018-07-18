package v1.ch06.clone;

public class CloneTest {

	public static void main(String[] args) {
		try {
			Employee original=new Employee("John Q.Public", 5000);
			original.setHireDay(2000, 1, 1);
			Employee copy=original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 31);
			System.out.println("origin="+original);
			System.out.println("copy="+copy);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
