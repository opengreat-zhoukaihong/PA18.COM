package mon;
import org.omg.CORBA.*;
import com.mcip.bus.orb.*;
import com.mcip.orb.*;
import utility.*;
import com.paol.banking.payment.bs.BsInfoQuery;
import com.paol.banking.payment.bs.BsInfoQueryHelper;
import com.i2w.icore.bs.BsException;
public class BsInfoQueryClient 
{
	private static BsInfoQuery bsinfo;
	private static void initClient() throws Exception//initialization of the class
	{
		try{
			org.omg.CORBA.ORB orb = ORBManager.getORBForPaymentResult();
			bsinfo = BsInfoQueryHelper.bind(orb, "BsInfoQuery_localhost");
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
		  System.out.println("BsInfoQuery Service is alive!");
	  }else{
		  System.out.println("BsInfoQuery Service is down!");
	  }
	}
}
