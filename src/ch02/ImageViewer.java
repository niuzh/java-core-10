package ch02;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 图片查看器
 * @author niuzhihuan
 */
public class ImageViewer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(()->{
			JFrame frame=new ImageViewerFrame();
			frame.setTitle("ImageViewer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}

}

class ImageViewerFrame extends JFrame{
	private JLabel label;
	private JFileChooser chooser;
	private static final int default_width=300;
	private static final int default_height=400;
	
	public ImageViewerFrame() {
		setSize(default_width, default_height);
		
		//use a label to display the images
		label=new JLabel();
		add(label);
		//set up the file chooser
		chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		//set up the menu bar
		JMenuBar menuBar=new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu=new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem=new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(event->{
			//show file chooser dialog
			int result=chooser.showOpenDialog(null);
			if(result==JFileChooser.APPROVE_OPTION){
				String name=chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		});
		JMenuItem exitItem=new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(event->{
			System.exit(0);
		});
	}
}
