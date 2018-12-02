import java.io.*;
public class ConfReader {
	public String readConf(String path,int line) throws Exception {
		String result = null;
		File f=new File(path);
		FileInputStream fis=new FileInputStream(f);
		InputStreamReader isr=new InputStreamReader(fis);
		BufferedReader br=new BufferedReader(isr);
		for(int i=0;i<line;i++) {
			result=br.readLine();
		}
		return result;
	}
}
