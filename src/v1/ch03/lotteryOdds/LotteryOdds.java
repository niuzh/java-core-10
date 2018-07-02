package v1.ch03.lotteryOdds;

import java.util.Scanner;

public class LotteryOdds {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("how many numbers do you need to draw");
		// 选择的个数
		int k = in.nextInt();
		System.out.println("what is the highest number you can draw?");
		// 总共的数量
		int n = in.nextInt();
		int lotteryOdds = 1;
		for (int i = 1; i <= k; i++) {
			lotteryOdds = lotteryOdds * (n - i + 1) / i;
		}
		System.out.println("your odds are 1 in " + lotteryOdds + ".Good luck!");
	}

}
