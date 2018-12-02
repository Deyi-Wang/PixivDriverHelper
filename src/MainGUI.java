import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.util.*;
public class MainGUI extends NginxIsRunning{
	static int mouseAtX;
	static int mouseAtY;
	static JLabel run=new JLabel("");
	/**
	 * @wbp.parser.entryPoint
	 */
	public void GUI() {
		JFrame jf=new JFrame();
		jf.setBackground(Color.GRAY);
		jf.setSize(450,337);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension sc=kit.getScreenSize();
		jf.setLocation((sc.width/3),sc.height/3);
		jf.setUndecorated(true);
		int bgpic=new Random().nextInt(6);
		String picpath="res\\bg\\"+bgpic+".png";
        JLabel bl = new JLabel(new ImageIcon(picpath));
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
                  jf.setLocation((e.getXOnScreen()-mouseAtX),(e.getYOnScreen()-mouseAtY));		//设置拖拽后，窗口的位置
              }
          });
          JLabel title=new JLabel("p站司机助手 v1.0 控制台");
          title.setForeground(new Color(255, 20, 147));
          title.setFont(new Font("Dialog", Font.BOLD, 12));
          title.setBounds(10, 5, 159, 15);
          run.setFont(new Font("幼圆", Font.BOLD, 18));
          run.setBounds(25, 278, 177, 36);
          JLabel main=new JLabel("主要");
          main.setForeground(Color.WHITE);
          main.setFont(new Font("宋体", Font.BOLD, 15));
          main.setBounds(25, 47, 48, 23);
          JLabel setup=new JLabel("初次配置");
          setup.setForeground(Color.WHITE);
          setup.setFont(new Font("Dialog", Font.BOLD, 15));
          setup.setBounds(244, 47, 84, 23);
          JLabel other=new JLabel("其它");
          other.setForeground(Color.WHITE);
          other.setFont(new Font("Dialog", Font.BOLD, 15));
          other.setBounds(244, 192, 48, 28);
          JButton close=new JButton(new ImageIcon("res\\close.png"));
          close.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		System.exit(0);
          	}
          });
          close.setBounds(412, 5, 28, 28);
          close.setContentAreaFilled(false);
  		  close.setBorderPainted(false);
  		  JButton start=new JButton("启动服务");
  		  start.addActionListener(new ActionListener() {
  		  	public void actionPerformed(ActionEvent arg0) {
  		  		try {
					Process p=Runtime.getRuntime().exec("cmd /c cd Nginx\\ && start nginx.exe");
				} catch (IOException e) {
					e.printStackTrace();
				}
  		  	}
  		  });
  		  start.setForeground(Color.GREEN);
  		  start.setFont(new Font("幼圆", Font.BOLD, 24));
  		  start.setBounds(25, 96, 154, 68);
  		  start.setContentAreaFilled(false);
  		  JButton stop=new JButton("终止服务");
  		  stop.addActionListener(new ActionListener() {
  		  	public void actionPerformed(ActionEvent e) {
  		  	try {
				Process p=Runtime.getRuntime().exec("cmd /c taskkill /f /im nginx.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
  		  	}
  		  });
  		  stop.setForeground(Color.RED);
  		  stop.setFont(new Font("幼圆", Font.BOLD, 24));
  		  stop.setBounds(25, 185, 154, 68);
  		  stop.setContentAreaFilled(false);
  		  JButton cer=new JButton("安装证书");
  		  cer.addActionListener(new ActionListener() {
  		  	public void actionPerformed(ActionEvent e) {
  		  	try {
				Process p=Runtime.getRuntime().exec("cmd /c start Nginx\\Set-up\\ca.cer");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
  		  	}
  		  });
  		  cer.setForeground(Color.CYAN);
  		  cer.setFont(new Font("Dialog", Font.BOLD, 14));
  		  cer.setBounds(244, 230, 98, 36);
  		  cer.setContentAreaFilled(false);
  		  JButton hos=new JButton("修改hosts文件");
  		  hos.addActionListener(new ActionListener() {
  		  	public void actionPerformed(ActionEvent e) {
  		  	try {
				Process p=Runtime.getRuntime().exec("cmd /c start Nginx\\Set-up");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
  		  	}
  		  });
  		  hos.setForeground(Color.PINK);
  		  hos.setFont(new Font("Dialog", Font.BOLD, 16));
  		  hos.setBounds(244, 88, 183, 42);
  		  hos.setContentAreaFilled(false);
  		  JButton update=new JButton("更新配置文件");
  		  update.addActionListener(new ActionListener() {
  		  	public void actionPerformed(ActionEvent e) {
  		  		
  		  	}
  		  });
  		  update.setForeground(Color.PINK);
  		  update.setFont(new Font("Dialog", Font.BOLD, 16));
  		  update.setBounds(244, 140, 183, 42);
  		  update.setContentAreaFilled(false);
  		  JButton about=new JButton("关于");
  		  about.addActionListener(new ActionListener() {
  		  	public void actionPerformed(ActionEvent e) {
  		  		
  		  	}
  		  });
  		  about.setForeground(Color.MAGENTA);
  		  about.setFont(new Font("Dialog", Font.BOLD, 14));
  		  about.setBounds(352, 231, 75, 34);
  		  about.setContentAreaFilled(false);
  		  JPanel jp=new JPanel();
  		  jp.setOpaque(false);
  		  jp.setLayout(null);
  		  jp.add(title);
  		  jp.add(run);
  		  jp.add(main);
  		  jp.add(setup);
  		  jp.add(other);
  		  jp.add(close);
  		  jp.add(start);
  		  jp.add(stop);
  		  jp.add(cer);
  		  jp.add(hos);
  		  jp.add(update);
  		  jp.add(about);
  		  jf.getContentPane().add(jp);
          jf.show();
          int ii=0;
          while(ii<1) {
        	  NginxIsRunning nir=new NginxIsRunning();
        	  nir.Judge();
        	  if(i==1) {
        		  run.setText("服务正在运行！");
        		  run.setForeground(Color.GREEN);
        		  start.setEnabled(false);
        		  stop.setEnabled(true);
        	  }else if(i==0) {
        		  run.setText("服务已停止！");
        		  run.setForeground(Color.RED);
        		  start.setEnabled(true);
        		  stop.setEnabled(false);
        	  }
          }
	}
}