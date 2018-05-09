package v1.ch10;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.*;

/**
 * @version 1.34 2015-06-16
 * @author Cay Horstmann
 */
public class SizedFrameTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
         {
            JFrame frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
         });
   }
}

class SizedFrame extends JFrame
{
   public SizedFrame()
   {
      // get screen dimensions

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
      int screenHeight = screenSize.height;
      int screenWidth = screenSize.width;

      // set frame width, height and let platform pick screen location

      setSize(screenWidth / 2, screenHeight / 2);
      setLocationByPlatform(true);

      // set frame icon
      String filePath="/home/niu/workspace/java-core-fundamentals/bin/icon.gif";
      System.out.println(new File(filePath).exists());
      Image img = new ImageIcon(filePath).getImage();
      setIconImage(img);      
   }
}
