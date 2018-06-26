////////////////////////////////////////////////////////
// Author：L.K
// Function：for Policy print 
// Create date：2001-11-27
// Update date：2001-11-27
///////////////////////////////////////////////////////
package beans;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.beans.Beans;
import exceptions.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import constant.*;
import utility.*;


public class PolicyPrintBean
{
    //for orb initial using
    org.omg.CORBA.ORB orb  ;
    PolicyInfoManager PolicyInfo;    
	private String conditionString;// used to store _inString
    public PolicyPrintBean()
    {
       	  // Initialize the ORB.

          try
          {
	         orb = ORBManager.getORBForClient();
		 PolicyInfo = PolicyInfoManagerHelper.bind(orb, "pmanager");//to be
	  }
          catch (Exception e)
          {
 	        throw  NormalExceptionHandler.Handle(e);
          }

    }

	private String getDocPrintString (int _StringType) throws Exception{
		  String retString = null;

		  switch (_StringType)
		  {
			case 0://get print format case
				retString = PolicyInfo.getPrintFormat(conditionString);
				break;
			case 1://get policy content case
				retString = PolicyInfo.getPrintPolicy(conditionString);
				break;
			default:
				throw new Exception(this.getClass().getName()+".getDOcPrintString(int _StringType):错误的参数_StringType="+_StringType);
		  }
			return retString;
	  }
	/**This public method is to get a single print policy content 
	  *via the java call c mehtod in PolicyInfoManagerImpl<br>
	  *NOTE:if successful, the result will be returned else only a null String will be returned
	  **/
	public String getPrintPolicy(String _inString) throws Exception{
		String retString = null;
		if (_inString == null)
		{
			throw new Exception(this.getClass().getName()+".getDOcPrintString(int _inString):错误的参数_inString="+_inString);
		}

		this.conditionString = _inString;
		try{
			retString = this.getDocPrintString(1);// parameter 1 means get print policy content
		}catch(Exception e){
			retString = null;
		}
		return retString;
	 }

	/**This public method is to get a single print format 
	  *via the java call c mehtod in PolicyInfoManagerImpl<br>
	  *NOTE:if successful, the result will be returned else only a null String will be returned
	  **/
	public String getPrintFormat(String _inString) throws Exception{
		String retString = null;
		if (_inString == null)
		{
			throw new Exception(this.getClass().getName()+".getDOcPrintString(int _inString):错误的参数_inString="+_inString);
		}

		this.conditionString = _inString;
		try{
			retString = this.getDocPrintString(0);// parameter 0 means get print format
		}catch(Exception e){
			retString = null;
		}
		return retString;
	 }

	 /** This public method is to all the printformat<br>
	 **  Known Problem:call this function will cause times java call c operation,so the response time may be extremly long<br>
	 */
	 public String[] getPrintFormats(String[] _inStrings){
		 String[] retStrings = null;
			 if (_inStrings == null)
			 {
				return retStrings;
			 }
			 try{
				 retStrings = new String[_inStrings.length];
				 for (int i=0;i<_inStrings.length ;i++ )
				 {
					retStrings[i] = getPrintFormat(_inStrings[i]);
				 }
			 }catch(Exception e){
				 return null;
			 }
			 return retStrings;
	 }
	 /** this static main method just for self test */
	 public static void main(String args[]) throws Exception{
		 PolicyPrintBean pb = new PolicyPrintBean();
		  }
}