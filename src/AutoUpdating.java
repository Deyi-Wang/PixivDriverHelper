import java.io.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class AutoUpdating extends MainGUI {
	static String oldmd5nginx;
	static String newmd5nginx;
	static String oldmd5hosts;
	static String newmd5hosts;
	public void updateexa() throws Exception {
		oldmd5nginx=new getFileMD5().getMD5("Nginx\\conf\\nginx.conf");
		oldmd5hosts=new getFileMD5().getMD5("Nginx\\Set-up\\hosts");
		newmd5nginx=new getFileMD5().getMD5("Auto-Updater\\tmp\\nginx.conf");
		newmd5hosts=new getFileMD5().getMD5("Auto-Updater\\tmp\\hosts");
		System.out.println(newmd5hosts);
		System.out.println(oldmd5hosts);
		System.out.println(newmd5nginx);
		System.out.println(oldmd5nginx);
		if(!oldmd5nginx.equals(newmd5nginx)) {
			new AutoUpdating().upngi();
		}
		if(!oldmd5hosts.equals(newmd5hosts)) {
			new AutoUpdating().uphos();;
		}
	}
	public void upngi() {
		
	}
	public void uphos() {
		
	}
}
