package mon;
import jtoc.*;
import java.io.*;
import java.net.*;
import java.util.*;
public class JavaCClient 
{
	private static Socket s;
	private static String host;
	private static int port;
	private static Properties jProp;
	private static String filename = "monitor.prop";
  /** this static function to test if backend service is alive*/
  public static String  isAlive(){
	 jProp = new Properties();
	 try{
		jProp.load(new FileInputStream(filename));
	 }
	 catch(FileNotFoundException e){
		 System.out.println("没有找到配置文件:"+filename);
	 }catch(IOException e){
		 System.out.println("无法读取配置文件:"+filename);
	 }
	String returnStr = "";
	host = jProp.getProperty("RemoteHost");
	port = Integer.parseInt(jProp.getProperty("RemotePort"));
	  try{
		s = new Socket(host,port);
	  }catch(UnknownHostException e){
		  returnStr = e.toString();
	  }
	  catch(IOException e){
		  returnStr = e.toString();
	  }
	  catch(Exception e){
		  returnStr = e.toString();
	  }
	 finally
	{
		 try{
			s.close();
		 }catch(Exception e){
		 }
		 return returnStr;
	 }

  }

  public static void main(String[] args) {

	  if  (JavaCClient.isAlive().length()==0)
	  {
		  System.out.println("Backend Socket Service is alive!");
	  }else{
		  System.out.println("Backend Socket Service is down!");
	  }
	  System.out.println(JavaCClient.isAlive());
  }
}

