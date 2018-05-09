package v1.ch06;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 
 * @author niuzhihuan
 */
public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ActionListener listener=new TimePrinter();
		Timer timer=new Timer(10000, listener);
		timer.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}

}
class TimePrinter implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("at the tone, the time is "+new Date());
		Toolkit.getDefaultToolkit().beep();
	}
	
}
