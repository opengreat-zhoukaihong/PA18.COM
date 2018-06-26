package mon;
import java.sql.*;
import java.util.*;
import utility.*;
import java.io.*;
import constant.*;
import jtoc.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.cus.orb.*;
import com.mcip.mail.orb.*;
import com.paol.b2b.ps.PsB2BService;
import com.paol.b2b.ps.PsB2BServiceHelper;
public class PsB2BClient 
{
	private static PsB2BService ps;
	private static void initClient() throws Exception//initialization of the class
	{
		try{
			org.omg.CORBA.ORB orb = ORBManager.getORBForCustomerManage();
			ps = PsB2BServiceHelper.bind(orb, "PsB2BService_localhost");
		}catch(Exception e){
			throw new Exception("绑定CORBA服务出错:"+e.toString());
		}
	}

  public static String  isAlive(){
	  String returnStr = "";
	 try{
		initClient();
	 }catch(Exception e){
		return returnStr = e.toString();
	 }
	 finally
	{
		 return returnStr;
	 }
  }
	public static void main(String[] args) throws Exception
	{
	  if  (PsB2BClient.isAlive().length()==0)
	  {
		  System.out.println("PsB2B Service is alive!");
	  }else{
		  System.out.println("PsB2B Service is down!");
	  }
	}
}
