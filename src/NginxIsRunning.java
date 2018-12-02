import java.io.BufferedReader;
import java.io.InputStreamReader;
public class NginxIsRunning{
	static String processName="nginx.exe";
	static int i;
	public void Judge(){
		BufferedReader bufferedReader = null;
        try {
            Process proc = Runtime.getRuntime().exec("tasklist -fi " + '"' + "imagename eq " + processName +'"');
            bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.contains(processName)) {
                	i=1;
                }else {
                	i=0;
                }
            }
        }catch (Exception e) {
            e.getStackTrace();
        }   
    }
}