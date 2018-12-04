import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class Launcher {
	public static void main(String[] args) throws Exception{
		if(!new File("frame.txt").exists()) {
			Process p=Runtime.getRuntime().exec("cmd /c echo true>frame.txt");
		}
		if(!new File("autoupdate.txt").exists()) {
			Process p=Runtime.getRuntime().exec("cmd /c echo true>autoupdate.txt");
		}
		Process p=Runtime.getRuntime().exec("cmd /c del /f \"Auto-Updater\\tmp\\*.conf\" && del /f \"Auto-Updater\\tmp\\hosts\" && del /f \"Auto-Updater\\tmp\\hosts.*\"");
		JFrame jf=new JFrame();
		jf.setSize(385,264);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension sc=kit.getScreenSize();
		jf.setLocation(sc.width/3,sc.height/3);
		jf.setUndecorated(true);	  
        JLabel bl = new JLabel(new ImageIcon("res\\launch.gif"));
        bl.setBounds(0, 0,jf.getWidth(), jf.getHeight());
        JPanel imagePanel = (JPanel) jf.getContentPane();
        imagePanel.setOpaque(false);
        jf.getLayeredPane().add(bl, new Integer(Integer.MIN_VALUE));
        jf.show();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
			public void run() {	
            jf.dispose();
            try {
				new MainGUI().GUI();
			} catch (Exception e) {
				e.printStackTrace();
			}
        } },new Random().nextInt(4)*1000+200);
	}

}
