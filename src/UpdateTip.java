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
public class UpdateTip{
	static int mouseAtX;
	static int mouseAtY;
	static JCheckBox jcb=new JCheckBox("下次自动更新");
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
          JLabel tip1=new JLabel("发现配置文件需要更新，是否立即更新？");
          tip1.setForeground(Color.MAGENTA);
          tip1.setFont(new Font("微软雅黑", Font.BOLD, 17));
          tip1.setBounds(46, 32, 325, 36);
          JLabel tip2=new JLabel("不更新软件可能无法正常使用！");
          tip2.setForeground(Color.BLUE);
          tip2.setFont(new Font("微软雅黑", Font.BOLD, 15));
          tip2.setBounds(97, 71, 230, 23);
          jcb.setBounds(6, 151, 110, 23);
          jcb.setOpaque(false);
          JPanel jp=new JPanel();
          jp.setOpaque(false);
          jp.setLayout(null);
          jp.add(tip1);
          jp.add(tip2);
          jp.add(jcb);
          JButton jb0=new JButton("取消");
          jb0.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		jf.dispose();
          	}
          });
          jb0.setForeground(Color.RED);
          jb0.setFont(new Font("幼圆", Font.BOLD, 18));
          jb0.setBounds(206, 104, 93, 41);
          jb0.setContentAreaFilled(false);
          JButton jb=new JButton("确定");
          jb.setForeground(Color.BLUE);
          jb.setFont(new Font("幼圆", Font.BOLD, 18));
          jb.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent arg0) {
          		if(jcb.isSelected()) {
          			File f=new File("autoupdate.txt");
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
          		try {
					new AutoUpdating().upngi();
				} catch (Exception e) {
					e.printStackTrace();
				}
          		jf.dispose();
          	}
          });
          jb.setContentAreaFilled(false);
          jb.setBounds(77, 104, 93, 41);
          jp.add(jb0);
          jp.add(jb);
          jf.getContentPane().add(jp);
          jf.show();
	}
}