/**
*This class is the client for the Policy App Manager Service<br>
*You can use this class to test if the Policy App Manage Service is alive.<br>
*Most of the methods and members are static ,so that the class can be used in multi-thread way
*/
package mon;
import org.omg.CORBA.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class PolicyAppClient {
  public static PolicyAppManager pManager;//server side object

  private static void initClient() throws Exception//initialization of the class
	{
		try{
			org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
			pManager = PolicyAppManagerHelper.bind(orb, "amanager");
		}catch(Exception e){
			throw new Exception("绑定CORBA服务出错:"+e.toString());
		}
	}

  private PolicyAppClient() throws Exception
  {
  }

  /** this static function to test if policy app corba service is alive*/
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

	  if  (EmailClient.isAlive().length()==0)
	  {
		  System.out.println("Policy App Manager Service is alive!");
	  }else{
		  System.out.println("Policy App Manager Service is down!");
	  }
	 
  }
}
