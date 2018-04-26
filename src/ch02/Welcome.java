package ch02;

/**
 * 注意：
 * Java类名以大写字母开头
 * 编译是需要文件名
 * 执行时只需要类名
 * @author niuzhihuan
 */
public class Welcome {

	/**
	 * 进入src目录
	 * 编译代码
	 * [niu@localhost src]$ javac ch02/Welcome.java
	 * 执行代码
	 * [niu@localhost src]$ java ch02.Welcome
	 * @param args
	 */
	public static void main(String[] args) {
		String greeting = "Welcome to Core Java!";
		System.out.println(greeting);
		for (int i = 0; i < greeting.length(); i++) {
			System.out.print("=");

		}
		System.out.println();
		//\_u表示转义 Java™
		System.out.println("Java\u2122");
	}

}
