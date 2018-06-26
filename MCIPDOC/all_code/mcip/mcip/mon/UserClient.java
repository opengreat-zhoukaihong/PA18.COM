/**
*This class is the client for the User Manager Service<br>
*You can use this class to test if the User Manage Service is alive.<br>
*Most of the methods and members are static ,so that the class can be used in multi-thread way
*/
package mon;
import org.omg.CORBA.*;
import com.mcip.bus.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class UserClient {
  public static UserManager pManager;//server side object

  private static void initClient() throws Exception//initialization of the class
	{
		try{
			org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
			pManager = UserManagerHelper.bind(orb, "usermanager");
		}catch(Exception e){
			throw new Exception("绑定CORBA服务出错:"+e.toString());
		}
	}

  private UserClient() throws Exception
  {
  }

  /** this static function to test if user corba service is alive*/
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
		  System.out.println("User Manager Service is alive!");
	  }else{
		  System.out.println("User Manager Service is down!");
	  }
	 
  }
}
