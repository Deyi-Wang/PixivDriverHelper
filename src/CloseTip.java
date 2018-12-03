import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import javax.swing.*;
public class CloseTip{
	static int mouseAtX;
	static int mouseAtY;
	static JCheckBox jcb=new JCheckBox("不再提示");
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Tip() {
		JFrame jf=new JFrame();
		jf.setSize(395,180);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension sc=kit.getScreenSize();
		jf.setLocation(sc.width/3,sc.height/4);
		jf.setUndecorated(true);
        JLabel bl = new JLabel(new ImageIcon("res\\TipFrame.png"));
        bl.setBounds(0, 0,jf.getWidth(), jf.getHeight());
        JPanel imagePanel = (JPanel) jf.getContentPane();
        imagePanel.setOpaque(false);
        jf.getLayeredPane().add(bl, new Integer(Integer.MIN_VALUE));  
        jf.addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
               mouseAtX = e.getPoint().x;
               mouseAtY= e.getPoint().y;
            }
         });      
          jf.addMouseMotionListener(new MouseMotionAdapter()
          {
              public void mouseDragged(MouseEvent e) 
              {
                  jf.setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));
              }
          });
          JLabel tip1=new JLabel("您关闭控制台窗口后，服务仍然会在后台运行!不影响正常使用！");
          tip1.setForeground(Color.MAGENTA);
          tip1.setFont(new Font("微软雅黑", Font.BOLD, 13));
          tip1.setBounds(12, 36, 379, 36);
          JLabel tip2=new JLabel("可以稍后再重新打开该软件停止服务！");
          tip2.setForeground(Color.BLUE);
          tip2.setFont(new Font("微软雅黑", Font.BOLD, 13));
          tip2.setBounds(80, 70, 241, 23);
          jcb.setBounds(6, 151, 100, 23);
          jcb.setOpaque(false);
          JPanel jp=new JPanel();
          jp.setOpaque(false);
          jp.setLayout(null);
          jp.add(tip1);
          jp.add(tip2);
          jp.add(jcb);
          JButton jb=new JButton("知道了");
          jb.setForeground(new Color(0, 128, 128));
          jb.setFont(new Font("幼圆", Font.BOLD, 18));
          jb.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		if(jcb.isSelected()) {
          			File f=new File("frame.txt");
          			try {
						FileOutputStream fos=new FileOutputStream(f);
						OutputStreamWriter osw=new OutputStreamWriter(fos);
						BufferedWriter bw=new BufferedWriter(osw);
						bw.write("false");
						bw.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
          		}
          		System.exit(0);
          	}
          });
          jb.setContentAreaFilled(false);
          jb.setBounds(137, 108, 110, 51);
          jp.add(jb);
          jf.getContentPane().add(jp);
          jf.show();
	}
}