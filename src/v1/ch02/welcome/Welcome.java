package v1.ch02.welcome;

public class Welcome {

	/**
	 * [niu@localhost src]$ javac v1/ch02/welcome/Welcome.java
	 * [niu@localhost src]$ java v1.ch02.welcome.Welcome
	 * @param args
	 */
	public static void main(String[] args) {
		String greeting = "Welcome to Core Java";
		System.out.println(greeting);
		for (int i = 0; i < greeting.length(); i++) {
			System.out.print("=");
		}
		System.out.println();
	}
}
