/**
*This class is the client for the Policy Manager Service<br>
*You can use this class to test if the Policy Manage Service is alive.<br>
*Most of the methods and members are static ,so that the class can be used in multi-thread way
*/
package mon;
import org.omg.CORBA.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class PolicyClient {
  public static PolicyManager pManager;//server side object

  private static void initClient() throws Exception//initialization of the class
	{
		try{
			org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
			pManager = PolicyManagerHelper.bind(orb, "plymanager");
		}catch(Exception e){
			throw new Exception("绑定CORBA服务出错:"+e.toString());
		}
	}

  private PolicyClient() throws Exception
  {
  }

  /** this static function to test if policy corba service is alive*/
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
		  System.out.println("Policy Manager Service is alive!");
	  }else{
		  System.out.println("Policy Manager Service is down!");
	  }
	 
  }
}
