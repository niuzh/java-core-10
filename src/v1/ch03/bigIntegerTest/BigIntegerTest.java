package v1.ch03.bigIntegerTest;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("how many numbers do you need to draw?");
		int k = in.nextInt();
		System.out.println("what is the hightest number you can draw?");
		int n = in.nextInt();
		BigInteger lotteryOlds = BigInteger.valueOf(1);
		for (int i = 1; i < k; i++) {
			lotteryOlds = lotteryOlds.multiply(BigInteger.valueOf(n - i + 1)).divide(BigInteger.valueOf(i));
		}
		System.out.println("your odds are 1 in " + lotteryOlds + ".good luck!");
	}

}
