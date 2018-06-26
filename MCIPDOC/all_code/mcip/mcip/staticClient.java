/* Client.java. This file is used to pass some string to corba server, and 
get a string[][] back. this return value more like one string table.
 */
import org.omg.CORBA.*;
import com.mcip.cus.orb.*;
import com.mcip.cdt.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class staticClient {

  public static void main(String[] args) {
      try{

          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  staticInfoManager smanager =
	               staticInfoManagerHelper.bind(orb, "smanager");
 	     	  String[][] res = null;//return value declare


//Change from here
        res = smanager.getDepartmentList("202");
//        res = smanager.getRptTelNum("");
//        res = smanager.getCurrencyInfo("02");
//        res = smanager.getNetCodeList("163");
//        res = smanager.getExchangeRateList("","03");
//        res = smanager.getInsuranceDefineList("");
//        res = smanager.getNationalList("04");
//          res = smanager.getProvinceList("1500");
//          res = smanager.getCityList("1500");
//          res = smanager.getAreaList("");
// 	        res = smanager.getTitleList("45");
//          res = smanager.getCurrencyList("01");
//          res = smanager.getInsuranceClassList("");
//          res = smanager.getCargoClsList("","B77");
//          res = smanager.getClauseList("B01","02","0");
// 	        res = smanager.getScaleList("2");
// 	        res = smanager.getPremiumScaleList("33");
// 	        res = smanager.getOrgTypeList("4");
// 	        res = smanager.getTradeTypeList("B001");
// 	        res = smanager.getPACrgoClsTypList("1234567890","001");
//Stop change

    	  	  int tbr=res.length;
 	      	  	  System.out.println("The Return table have: "+tbr+" Rows!");
 	  	     for (int j=0;j <tbr;j++){
	    	        String[] tablecolumn = res[j];
    	  	      int tbc=tablecolumn.length;
	       	     for (int i=0;i<tbc;i++){
 	   	      	  		  String str=tablecolumn[i];
		   	      	   	  System.out.print(str+"\t");
    	  	      }
	       	   	 System.out.print("\n");
 	  	     }
      }
      catch(CoException e){
       	  System.err.println("CORBAR Exception:" +
                 "\nMessagee Code:"+e.errCode+
                 "\nMessagee Desc:"+e.errDescription+
                 "\nError in:"+e.errFieldName+
                 "\nError severity:"+e.severity);
      }
      catch (Exception e){
          e.printStackTrace ();
      }
  }
}
