package ch03;

import java.util.Scanner;

/**
 * 
 * @author niuzhihuan
 */
public class Retirement2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);

		System.out.println("how much money will you contribute every year?");
		double payment=scanner.nextDouble();
		System.out.println("interest rate in %:");
		double interestRate=scanner.nextDouble();
		double balance=0;
		int years=0;
		String input;
		do {
			balance+=payment;
			double interest=balance*interestRate/100;
			balance+=interest;
			years++;
			System.out.printf("after year %d,you balance is %,.2f万%n",years,balance/10000);
			input=scanner.next();
		} while (!input.equals("Y"));
	}

}
