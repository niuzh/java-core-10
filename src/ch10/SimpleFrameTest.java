package ch10;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * 
 * @author niuzhihuan
 */
public class SimpleFrameTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*所有的 Swing 组件必须由事件分派线程 ( event dispatch thread ) 进行配置, 线程将
		鼠标点击和按键控制转移到用户接口组件 。*/
		EventQueue.invokeLater(() -> {
			SimpleFrame frame = new SimpleFrame();
			/*定义一个用户关闭这个框架时的响应动作 。*/
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			/*显示框架*/
			frame.setVisible(true);
		});
	}
	/*在初始化语句结束后 , main 方法退出 。 需要注意, 退出 main 并没有终止程序, 终止的
只是主线程 。 事件分派线程保持程序处于激活状态, 直到关闭框架或调用 SyStem.exit 方法终
止程序 。*/
}

class SimpleFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public SimpleFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		/*可以让窗口系统控制窗口的位置*/
		setLocationByPlatform(true);
	}
}