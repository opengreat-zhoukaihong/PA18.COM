/* Client.java. This file is used to pass some string to corba server, and
get a string[][] back. this return value more like one string table.
 */
import org.omg.CORBA.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;
import jtoc.*;


public class wClient {

  public static void main(String[] args) {
      try{
          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  PolicyAppManager amanager =
	               PolicyAppManagerHelper.bind(orb, "amanager");

          System.out.println("Begin!");

//          String[][] proposal_rtrn = amanager.confirmPolicyAppProposal("B15000099000800070","","");
/*          if (amanager.acceptUserRemark("5018600020200000006", "1234567890","Too expensive ! YiJF")){
             System.out.println("accept user remark Operation Successful!");
          }else{
             System.out.println("accept user remark Operation Fail!");
          }
*/
//          ConnectDB.dispArray (proposal_rtrn);
          String plyapp_no = "5048600020100000508";
          if (amanager.withdrawalPolicyApp(plyapp_no)){
             System.out.println("withdrawal Policy Application Form Operation Successful!");
          }else{
             System.out.println("withdrawal Policy Application Form Operation Fail!");
          }

          if (amanager.deletePolicyApp(plyapp_no)){
             System.out.println("withdrawal Policy Application Form Operation Successful!");
          }else{
             System.out.println("withdrawal Policy Application Form Operation Fail!");
          }

          System.out.println("End!");
      }
      catch(CoException e){
       	  System.err.println("CORBAR Exception:" +
                 "\nMessagee Code:"+e.errCode+
                 "\nMessagee Desc:"+e.errDescription+
                 "\nError in:"+e.errFieldName+
                 "\nError severity:"+e.severity);
      }
      catch (Exception e){
       	  System.err.println("SYSTEM Exception:\n" +e.toString ());
      }
  }
}
