package ch03;

import java.io.Console;
import java.util.Scanner;

/**
 * 
 * @author niuzhihuan
 */
public class InputTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("what is your name?");
		String name=in.nextLine();
		System.out.println("How old are you?");
		int age=in.nextInt();
		System.out.println("Hello , "+name+", next year you'll be "+(age+1));
		//读取密码 使用Eclipse等IDE运行以上代码时Console中将会为null。 
		Console console=System.console();
		/*String userName=console.readLine("userName:","");
		char[] password=console.readPassword("password:");
		System.out.println(password.toString());*/
	}

}
