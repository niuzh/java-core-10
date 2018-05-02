package ch06;

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
public class InnerClassTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TalkingClock clock=new TalkingClock(1000, true);
		clock.start();
		JOptionPane.showConfirmDialog(null, "Quit program?");
		System.exit(0);
	}

}
class TalkingClock{
	private int interval;
	private boolean beep;
	public TalkingClock(int interval,boolean beep) {
		this.interval=interval;
		this.beep=beep;
	}
	public void start() {
		ActionListener listener=new TimePrintInner();
		Timer timer=new Timer(interval, listener);
		timer.start();
	}
	public class TimePrintInner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("At the tone, the time is "+new Date());
			if(beep){
				Toolkit.getDefaultToolkit().beep();
			}
		}
		
	}
}
