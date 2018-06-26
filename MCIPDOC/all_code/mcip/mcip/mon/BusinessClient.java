/**
*This class is the client for the Business Manager Service<br>
*You can use this class to test if the Business Manage Service is alive.<br>
*Most of the methods and members are static ,so that the class can be used in multi-thread way
*/
package mon;
import org.omg.CORBA.*;
import com.mcip.bus.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class BusinessClient {
  public static BusinessManager bManager;//server side object

  private static void initClient() throws Exception//initialization of the class
	{
		try{
			org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
			bManager = BusinessManagerHelper.bind(orb, "businessmanager");
		}catch(Exception e){
			throw new Exception("绑定CORBA服务出错:"+e.toString());
		}
	}

  private BusinessClient() throws Exception
  {
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
  public static void main(String[] args) {

	  if  (BusinessClient.isAlive().length()==0)
	  {
		  System.out.println("Business Manager Service is alive!");
	  }else{
		  System.out.println("Business Manager Service is down!");
	  }
	 
  }
}
