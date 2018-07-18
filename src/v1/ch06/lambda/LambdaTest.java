package v1.ch06.lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaTest {

	public static void main(String[] args) {
		String[] planets=new String[]{"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};
		System.out.println(Arrays.toString(planets));
		System.out.println("sorted in dictionary order");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("sorted by length");
		Arrays.sort(planets,(first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(planets));
		
		Timer timer=new Timer(1000, event->System.out.println("the time is "+new Date()));
		timer.start();
		
		JOptionPane.showMessageDialog(null, "quit program?");
		System.exit(0);
	}

}
