// This file is used to pass some string to corba server
// for OPERATOR MANAGEMENT MODULE, and get a string[][] back.
// this return value more like one string table ARRAY or BOOLEAN.

import org.omg.CORBA.*;
import com.mcip.bus.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class oprClient {

  public static void main(String[] args) {
      try{
          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  UserManager usermanager =
	               UserManagerHelper.bind(orb, "usermanager");

 	     	  String[][] res = null;

//     	    String in_opr_cde = "admin";
     	    String in_opr_cde = "";
  	    	String in_opr_pwd= "test";
     	    String in_emp_cde = "";
     	  	String in_auth_opr_cde = "admin";
     	  	String in_auth_dpt_cde = "215";
     	  	String in_func_cde = "00005";
     	  	String in_clnt_cnm = "刘忠";
//     	  	String in_clnt_cnm = "test";

     	  	String in_clnt_agt_flg = "3";
     	  	String in_main_flg = "0";
     	  	String new_user_id = "2";
     	  	String new_clnt_cde = "15000056854";

//     	  	String in_user_id = "yijf";
//     	  	String in_clnt_cde = "86000056984";
//     	  	String in_clnt_cde = "15980001533";
     	  	String in_user_id = "";
     	  	String in_clnt_cde = "86000057014";
     	  	String in_cmpny_agt_cde = "";
     	  	String in_vrfy_desc = "YIJF TEST";

     	    String in_verify_flg = "1";
     	    String[] in_dpt_cde = {"215","204","203","202","205","201","20486"};
//     	    String[] in_dpt_cde = {"220"};
     	    String frm_crt_tm = "";
     	    String to_crt_tm = "";
     	    String frm_vrf_tm = "";
     	    String to_vrf_tm = "";
     	    int frm_ltimes = 0;
     	    int to_ltimes = 1000;

     	    String org_opr_cde = "test";         // for compareAuthDptOptr
     	    String trgt_opr_cde = "饶汉敏";          // for compareAuthDptOptr
//     	    String org_opr_cde = "YIJF";
//     	    String trgt_opr_cde = "test";

        res = usermanager.querySuppEmailList("YiJinFeng", in_dpt_cde,"2");
//        res = usermanager.queryClntMapList(in_opr_cde, new_user_id);
//        res = usermanager.querySubDptList(in_dpt_cde);
//        res = usermanager.operatorLogin(in_opr_cde,in_opr_pwd);
//        res = usermanager.queryOptrInfo(in_opr_cde);
//        res = usermanager.queryOptrList(in_opr_cde, in_emp_cde, in_auth_opr_cde, in_auth_dpt_cde);
//        res = usermanager.queryAuthList(in_opr_cde, in_emp_cde, in_auth_opr_cde, in_auth_dpt_cde);
//        res = usermanager.queryOptrDptList(in_opr_cde);
//        res = usermanager.getDptCEnm("20101","1");
//        res = usermanager.queryAbleDptList(in_opr_cde, in_auth_opr_cde);
//        res = usermanager.querySysFuncList(in_func_cde);
//        res = usermanager.queryPagesList(in_func_cde);
//        res = usermanager.querySameCustList(in_clnt_cnm);
//          res = usermanager.queryCustEnttList(in_opr_cde, in_verify_flg, in_dpt_cde,
//                          frm_crt_tm, to_crt_tm, frm_vrf_tm, to_vrf_tm, frm_ltimes, to_ltimes, in_user_id);
/*
          com.mcip.bus.orb.OperatorInfo operatorinfoobj=new OperatorInfo();
          operatorinfoobj.c_opr_cde = "test";
          operatorinfoobj.c_opr_pw = "test";
          operatorinfoobj.c_emp_cde = "2468";
          operatorinfoobj.c_dpt_cde = "";
          operatorinfoobj.c_acredt_cde = "sysadm";
          operatorinfoobj.c_sys_admin = "0";

          com.mcip.bus.orb.SysFuncInfo sysfuncinfoobj=new SysFuncInfo();
          sysfuncinfoobj.c_func_cde = "";
          sysfuncinfoobj.c_func_cnm = "网上投保";
          sysfuncinfoobj.c_func_enm = "Cyber Insurance Apply";

          com.mcip.bus.orb.PagesInfo pagesinfoobj=new PagesInfo();
          pagesinfoobj.c_page_no = "";
          pagesinfoobj.c_page_title = "网上投保";
          pagesinfoobj.c_file_enm = "Cyber Insurance Apply";
          pagesinfoobj.c_func_cde = "00001";
          pagesinfoobj.t_edit_tm = "";

 	     	  String[][] dptarray = {{"test","21500","215"},
                                 {"test","21586","215"},
                                 {"test","21503","215"},
                                 {"test","20486","204"},
                                 {"test","20122","201"},
                                 {"test","20121","201"},
                                 {"test","20186","201"},
                                 {"test","20105","201"},
                                 {"test","20101","201"},
                                 {"test","20301","203"}};
 	     	  String[][] autharray = {{"test","00001"},
                                  {"test","00002"},
                                  {"test","00003"},
                                  {"test","00004"},
                                  {"test","00005"},
                                  {"test","00016"},
                                  {"test","00018"},
                                  {"test","00023"}};
*/
          System.out.println("Begin!");

//          if (usermanager.deleteOperator(in_auth_dpt_cde, in_auth_opr_cde, "test", "1")){
//          if (usermanager.executeSysadmAuth("3", "admin", "admin", "")){
//          if (usermanager.executeOptrAuth("1", "test", "java20", autharray, dptarray)){
//          if (usermanager.checkOptrAuth("test", "00009")){
//          if (usermanager.acceptOperator(operatorinfoobj)){
//          if (usermanager.acceptUserVerify(in_user_id, in_clnt_cde, in_cmpny_agt_cde, in_verify_flg, in_vrfy_desc, in_opr_cde)){

//          if (usermanager.compareAuthDptOptr(org_opr_cde,trgt_opr_cde)){
//          if (usermanager.replaceAuthOptr(org_opr_cde,trgt_opr_cde)){
//          if (usermanager.acceptClntMapInfo(in_opr_cde, in_clnt_agt_flg, in_user_id, in_clnt_cde,in_main_flg)){
//          if (usermanager.updateClntMapInfo(in_opr_cde, in_clnt_agt_flg, new_user_id, new_clnt_cde,in_main_flg, in_user_id, in_clnt_cde)){
//          if (usermanager.deleteClntMapInfo(in_opr_cde, new_user_id, new_clnt_cde, in_clnt_agt_flg)){
//          if (usermanager.acceptSuppEmail("20486001", "YiJinFeng", "204", "0010000000","abc@pa18.com")){
//          if (usermanager.updateSuppEmail("20486001", "YiJinFeng", "20486", "0101000000","abc@pa18.com","0000000002")){
//          if (usermanager.deleteSuppEmail("0000000003")){
/*             System.out.println("Operation Successful!");
          }else{
             System.out.println("Operation Fail!");
          }
*/

// Modify by yjf Sep 21 2000.   Start

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

          System.out.println("End!");
// Modify by yjf Sep 21 2000.   END
      }
      catch(CoException e){
       	  System.err.println("CORBAR Exception:" +
                 "\nMessagee Code:"+e.errCode+
                 "\nMessagee Desc:"+e.errDescription+
                 "\nError in:"+e.errFieldName+
                 "\nError severity:"+e.severity);
      }
      catch (Exception e){
//       	  System.err.println("SYSTEM Exception:\n" +e.getMessage ());
       	  e.printStackTrace ();
       	  System.err.println("SYSTEM Exception:\n" +e.toString());
      }
  }
}
