import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class Launcher {
	public static void main(String[] args) {
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
            new MainGUI().GUI();
        } },new Random().nextInt(3800)+200);
	}

}
