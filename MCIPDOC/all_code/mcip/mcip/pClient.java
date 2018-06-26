/* Client.java. This file is used to pass some string to corba server, and
get a string[][] back. this return value more like one string table.
 */
import org.omg.CORBA.*;
import com.mcip.nia.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class pClient {

  public static void main(String[] args) {
      try{
          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  PolicyInfoManager pmanager =
	               PolicyInfoManagerHelper.bind(orb, "pmanager");

 	     	  String[][] res = null;

//     	    String in_clnt_cde = "150000005366";
//     	    String in_clnt_cde = "";
//    	    String in_clnt_cde = "15990041708";      // for agent
//      	    String in_clnt_cde = "150000005364";   // for oc
//       	    String in_clnt_cde = "150000005366";   // for oc
//       	    String in_clnt_cde = "86000056719";   // for oc
       	    String in_clnt_cde = "86000056762";   // for oc
    	  	  String in_insrnc_cde= "B23";
    	  	  String in_crgo_cde= "3100";
            String in_crgo_typ= "3101";
//    	  	  String in_insrnc_cde= "B02";
//              String in_open_cover_no= "1500000050009";
              String in_open_cover_no= "0100000050005";
    	  	  String in_plyapp_no= "5158800020100000039";   // for plyapp rdr info

    	  	  String in_ply_no= "2150000510201000012";      // for case report & rdr info
    	  	  String in_cmpny_agt_cde= "05000019";
    	  	  String in_agt_agr_no= "0500000000003";
//    	  	  String in_agt_agr_no= "0100000000006";
//       	    String in_clnt_cde = "15980000891";        //for case rpt or using '15980004226'

            com.mcip.nia.orb.QuotaCndtn quotacndtnobj=new QuotaCndtn();

            quotacndtnobj.c_dpt_cde = "204";
            quotacndtnobj.c_insrnc_cde = "B01";
//            quotacndtnobj.c_rdr_cde = "06";
            quotacndtnobj.c_rdr_cde = "36";
//            quotacndtnobj.c_crgo_cde = "1408";
            quotacndtnobj.c_crgo_cde = "2507";
            quotacndtnobj.c_carriage_cde = "02";
            quotacndtnobj.c_frm_prt_ara = "3100";
            quotacndtnobj.c_to_prt_ara = "1001";
            quotacndtnobj.c_crgo_cls = "";
            quotacndtnobj.c_pack_cde = "";
            quotacndtnobj.n_rate = "";
            quotacndtnobj.c_nclm_desc = "";

//            res = pmanager.getClauseList("B01", "06", "YIJF");
//            res = pmanager.getPlyAppNetAddress("3", "86000057014");
//            res = pmanager.getOCList(in_clnt_cde,in_insrnc_cde);
//            res = pmanager.getOCList("yijf",in_insrnc_cde);
//            res = pmanager.getAgencyPlcyList("11a","B02");
//            res = pmanager.getAgencyList(in_cmpny_agt_cde,in_insrnc_cde);
//            res = pmanager.getOCInfo(in_open_cover_no,in_insrnc_cde,in_crgo_cde);
//            res = pmanager.getAgencyInfo(in_agt_agr_no,in_insrnc_cde,in_crgo_cde,in_crgo_typ);
//            res = pmanager.getCustPlcyList("yijf",in_insrnc_cde);
//            res = pmanager.getPolicyInfo("1150000020100001035");
//            res = pmanager.getPolicyAppInfo(in_plyapp_no);
//            res = pmanager.getProposalInfo("5058600020201000021");
//            res = pmanager.getEndorseProposalInfo("7058600020101000005");
//            res = pmanager.getPlyAppRdrInfo("5158800020100000034");
//            res = pmanager.getPlyRdrInfo(in_ply_no);
//            res = pmanager.getAgencyList(in_cmpny_agt_cde,in_insrnc_cde);
//            res = pmanager.getAgencyPlcyList(in_agt_agr_no,in_insrnc_cde);
//            res = pmanager.getPolicyAppList("15980001663","","","","3");
//            res = pmanager.getPolicyAppList("zs1998","","","","3");  // for OC or Normal
//            res = pmanager.getProposalList("yijf","","","","3");  // for OC or Normal
//            res = pmanager.getPolicyAppList("15000051","6150000510201000018","1999-09-06","2000-09-30","2");     // for Agent
//            res = pmanager.getPolicyAppList("yijf","","2000-10-31","2000-11-30","1");
//            res = pmanager.getPolicyList("150000005366","","2000-09-26","2000-11-30","3");         // for OC or Normal
//            res = pmanager.getPolicyList("yijf","","2000-10-10","2000-11-30","3");
//            res = pmanager.getQuotation(quotacndtnobj,"1");
//            res = pmanager.getCaseRptList("yijf", "", "2000-11-01","2000-11-30","3");
//            res = pmanager.getCaseClmList("9150000040399000001", "0");
//            res = pmanager.getClaimList("15980001533", "9150000020100000073", "","","", "1");
//            res = pmanager.getCaseRptInfo("9048600020100000009");
//            res = pmanager.getClmDgstList("9158600020200000001","");
            res = pmanager.getEdrAppList("clarkrao","","","","","3");
//            res = pmanager.getEdrsmtList("yijf","","","2000-10-31","2000-11-14","3");
//            res = pmanager.getEdrsmtInfo("3050000020200000001");
//            res = pmanager.getPreEdrInfo("7028600020100000003");

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
/*
          if (pmanager.checkEdrApp("2050000010223010004")){
             System.out.println("This Endorsement Policy Apply Form Not exist!");
          }else{
             System.out.println("This Endorsement Policy Apply Form already exist!");
          }
*/

      }
      catch(CoException e){
       	  System.err.println("CORBAR Exception:" +
                 "\nMessagee Code:"+e.errCode+
                 "\nMessagee Desc:"+e.errDescription+
                 "\nError in:"+e.errFieldName+
                 "\nError severity:"+e.severity);
      }
      catch (Exception e){
       	  System.err.println("SYSTEM Exception:\n" +e.getMessage ());
      }
  }
}
