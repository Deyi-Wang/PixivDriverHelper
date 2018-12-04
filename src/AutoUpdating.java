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
		Process p=Runtime.getRuntime().exec("cmd /c del Auto-Updater\\tmp\\nginx.conf && del Auto-Updater\\tmp\\hosts");
		if(!oldmd5nginx.equals(newmd5nginx)) {
			if(new ConfReader().readConf("autoupdate.txt",1).equals("true")) {
			new UpdateTip().Tip();	
			}else if(new ConfReader().readConf("autoupdate.txt",1).equals("false")) {
			new AutoUpdating().upngi();
			}
		}
		if(!oldmd5hosts.equals(newmd5hosts)) {
			new AutoUpdating().uphos();
		}
	}
	public void upngi() throws Exception {
		Process p=Runtime.getRuntime().exec("cmd /c start update-ngconf.bat");
	}
	public void uphos() throws Exception {
		Process p=Runtime.getRuntime().exec("cmd /c Auto-Updater\\aria2c -d \"Auto-Updater\\hos\" https://raw.githubusercontent.com/swsk33/PixivDriverHelper/master/Nginx/Set-up/hosts && move /y \"Auto-Updater\\hos\\hosts\" \"Nginx\\Set-up\\\" && copy /y \"Nginx\\Set-up\\hosts\" \"C:\\Windows\\System32\\drivers\\etc\\hosts\"");
	}
}
