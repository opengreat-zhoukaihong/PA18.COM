// This file is used to pass some string to corba server
// for OPERATOR MANAGEMENT MODULE, and get a string[][] back.
// this return value more like one string table ARRAY or BOOLEAN.

import org.omg.CORBA.*;
import com.mcip.bus.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class busiClient {

  public static void main(String[] args) {
      try{
          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  BusinessManager businessmanager =
	               BusinessManagerHelper.bind(orb, "businessmanager");

 	     	  String[][] res = null;

     	    String in_deal_type = "1";
  	    	String in_deal_cde = "0";

     	    String in_opr_cde = "admin";
     	    String in_emp_cde = "2150100003";
     	  	String in_auth_opr_cde = "test";
     	  	String in_auth_dpt_cde = "215";
     	  	String in_clnt_cnm = "YIJINFENG";
//     	  	String in_clnt_cnm = "";

     	  	String in_user_id = "21";
     	  	String in_clnt_cde = "";
     	  	String in_cmpny_agt_cde = "";
     	  	String in_vrfy_desc = "";

     	    String in_verify_flg = "0";
     	    String in_dpt_cde = "";
     	  	String in_ply_no = "";
     	    String frm_plyapp_tm = "2000-11-01 00:00:01";
     	    String to_plyapp_tm = "2000-12-31 23:59:59";
     	    String frm_insrnc_cde = "";
     	    String to_insrnc_cde = "";

//     	  	String in_rpt_no = "9150000020100000099";
     	  	String in_rpt_no = "";
     	    String frm_rtp_tm = "2000-11-01 01:01:01";
     	    String to_rtp_tm = "";
     	    String in_emp_nme = "YIJINFENG";

     	    String in_assign_tm = "2000-10-06 21:21:21";
     	    String in_sended_tm = "2000-10-07 21:21:21";
     	    String in_feedbk_tm = "2000-10-08 21:21:21";
// 	     	  String[] plynoarray = {"1158600020100000001",
//                                 "1158600020100000002",
//                                 "1158600020100000003",
//                                 "1158600020100000004",
//                                 "1158600020100000006"};
 	     	  String[] plynoarray = {""};

     	    String frm_log_tm = "2000-10-15";
     	    String to_log_tm = "2000-10-17";
     	    String in_event_type = "0";
     	    String in_event_cde = "";

          com.mcip.bus.orb.InsrncGuideInfo guideinfoobj= new InsrncGuideInfo();
          guideinfoobj.c_info_no = "0000000003";
          guideinfoobj.c_title_no = "01001";
          guideinfoobj.c_title_cnm = "Ò×½õ·å²âÊÔ";
          guideinfoobj.c_title_enm = "YIJINFENG Test FOR SERVER IMPLEMENT";
          guideinfoobj.c_content_cnm = "Ò×½õ·å²âÊÔ0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
          guideinfoobj.c_content_enm = "0123456789abcdefghijklmnopq~!@#$%^&*()_+<>?:";
          guideinfoobj.t_crt_tm = "";

          com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj= new InsrncFaqInfo();
          insrncfaqinfoobj.c_faq_no = "0000000003";
          insrncfaqinfoobj.c_faq_emp = "YIJINFENG";
          insrncfaqinfoobj.c_faq_title = "PA MCIP Ò×½õ·å²âÊÔ";
          insrncfaqinfoobj.c_faq_content = "Ò×½õ·å²âÊÔ0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+<>?:ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          insrncfaqinfoobj.t_faq_tm = "";
          insrncfaqinfoobj.c_topic_no = "0000100001";

          com.mcip.bus.orb.CustFaqInfo custfaqinfoobj= new CustFaqInfo();
          custfaqinfoobj.c_faq_no = "0000000003";
          custfaqinfoobj.c_faq_psn = "Ò×½õ·å";
          custfaqinfoobj.c_faq_email = "jf_yi@ctil.com";
          custfaqinfoobj.c_faq_title = "How are You! PA MCIP Ò×½õ·å²âÊÔ";
          custfaqinfoobj.c_faq_content = "Ò×½õ·å²âÊÔ0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+<>?:ABCDEFGHIJKLMNOPQRSTUVWXYZ";
          custfaqinfoobj.t_faq_tm = "";
          custfaqinfoobj.c_reply_cont = "I'm fine. I got it, C&T SZ for PA18 MCIP Test!!";
          custfaqinfoobj.c_reply_emp = "YiJinFeng";
          custfaqinfoobj.t_reply_tm = "";

          com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj= new ClmDgstInfo();
          clmdgstinfoobj.c_ply_no = "N0523194EXP132-34";
          clmdgstinfoobj.c_rpt_no = "9158600020200000001";
          clmdgstinfoobj.c_info_no = "00000012";
          clmdgstinfoobj.c_digest = "ÐÅÏ¢ÕªÒª(¶þ)";
          clmdgstinfoobj.c_content = "ÄÚÈÝ(¶þ)";
          clmdgstinfoobj.t_input_tm = "";

    	    String in_info_no = "";
//    	    String in_info_no = "";
     	    String frm_tm = "2001-01-01";
     	    String to_tm = "2001-12-31";
     	    String frm_ins = "";
     	    String to_ins = "";
     	    String frm_dpt = "";
     	    String to_dpt = "";
     	    String in_cur_no = "";
     	    String in_site_cde = "";
     	    String in_stat_type = "2";

 	     	  String[] insrnc_array = {"B01", "B02", "B13", "B23", "B33", "B43"};
 	     	  String[] dptarray = {"215",
                               "202",
                               "205",
                               "203",
                               "20101",
                               "20486",
                               "20586",
                               "201",
                               "204"};
 	     	  String[] chatarray = {"How are you !",
                               "Fine !",
                               "MY Dear ! It is too Expendsive",
                               "How are You! PA MCIP Ò×½õ·å²âÊÔ",
                               "I'm fine. I got it, C&T SZ for PA18 MCIP Test!!",
                               "department 20486",
                               "Ò×½õ·å²âÊÔ0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+<>?:ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                               "changed to 201",
                               "5453 -- Ò×½õ·å²âÊÔ0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+<>?:ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                               "Good bye !!",
                               "see you !! "};
//	     	  String[] dptarray = {""};
        res = businessmanager.getPlyAppStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,frm_ins,to_ins,
                                                  in_cur_no,in_site_cde,
                                                  in_stat_type,in_opr_cde);

/*
        res = businessmanager.getEdrPlcyStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,frm_ins,to_ins,
                                                  in_cur_no,in_site_cde,in_opr_cde);

        res = businessmanager.getCaseRptStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,frm_ins,to_ins,
                                                  in_cur_no,in_site_cde,in_opr_cde);

        res = businessmanager.getPlyAppStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,frm_ins,to_ins,
                                                  in_cur_no,in_site_cde,
                                                  in_stat_type,in_opr_cde);

        res = businessmanager.getPolicyStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,frm_ins,to_ins,
                                                  in_cur_no,in_site_cde,in_opr_cde);

        res = businessmanager.getProposalStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,frm_ins,to_ins,
                                                  in_cur_no,in_site_cde,in_opr_cde);

        res = businessmanager.getCustStatictics(frm_tm,to_tm,dptarray,
                                                  frm_dpt,to_dpt,in_opr_cde);
*/
//        res = businessmanager.getCustPlySum("clarkrao", insrnc_array, "2000-12");
//        res = businessmanager.getCustPlyAppList("rewterw");
//        res = businessmanager.queryChatCntnt("5048600020100000268", "1");
//        res = businessmanager.queryClmDgstInfo(clmdgstinfoobj.c_rpt_no,clmdgstinfoobj.c_ply_no, in_opr_cde);

//        res = businessmanager.queryGuideList(in_info_no,in_clnt_cnm);
//        res = businessmanager.queryGuideInfo(in_info_no,in_clnt_cnm);
//        res = businessmanager.queryConsultList(in_info_no,in_clnt_cnm);
//        res = businessmanager.queryConsultInfo(in_info_no,in_clnt_cnm);
//        res = businessmanager.queryFaqList(in_info_no,in_clnt_cnm);
//        res = businessmanager.queryFaqInfo(in_info_no,in_clnt_cnm);

//        res = businessmanager.queryEventCountList(frm_log_tm,to_log_tm,in_event_type,in_event_cde,in_opr_cde);
//        res = businessmanager.queryEventTypeList("12");
//        res = businessmanager.queryPlyNetInfo(plynoarray);
//        res = businessmanager.queryPlyNetAbleEmp(in_dpt_cde,in_opr_cde);
//          res = businessmanager.queryPlyNetList(in_opr_cde, in_deal_cde, in_ply_no,
//                          frm_plyapp_tm, to_plyapp_tm, frm_insrnc_cde, to_insrnc_cde, dptarray );
//          res = businessmanager.queryPlyDealList(in_deal_type, in_deal_cde, in_ply_no,
//                          frm_plyapp_tm, to_plyapp_tm, frm_insrnc_cde, to_insrnc_cde, dptarray, in_opr_cde);
//          res = businessmanager.queryRptFlwUpList(in_deal_type, in_deal_cde, in_ply_no, in_rpt_no,
//                          frm_rtp_tm, to_rtp_tm, frm_insrnc_cde, to_insrnc_cde, dptarray, in_opr_cde);

          System.out.println("Begin!");

//          if (businessmanager.acceptPlyAssign("1158600020100000006", in_opr_cde, in_assign_tm, in_sended_tm, in_feedbk_tm)){
//          if (businessmanager.acceptPlySended("1158600020100000006", in_sended_tm)){
//          if (businessmanager.acceptPlyFreebk("1158600020100000006", in_feedbk_tm)){
//          if (businessmanager.updatePrintInfo(plynoarray, in_opr_cde)){
//          if (businessmanager.acceptRptFlwUpEmp(in_rpt_no, in_emp_nme, in_opr_cde)){

//          if (businessmanager.deleteFaqInfo(in_info_no, in_clnt_cnm)){
//          if (businessmanager.updateFaqInfo(custfaqinfoobj, in_clnt_cnm)){
//          if (businessmanager.acceptFaqInfo(custfaqinfoobj, in_clnt_cnm)){

//          if (businessmanager.deleteConsultInfo(in_info_no, in_clnt_cnm)){
//          if (businessmanager.updateConsultInfo(insrncfaqinfoobj, in_clnt_cnm)){
//          if (businessmanager.acceptConsultInfo(insrncfaqinfoobj, in_clnt_cnm)){

//          if (businessmanager.deleteGuideInfo(in_info_no, in_clnt_cnm)){
//          if (businessmanager.updateGuideInfo(guideinfoobj, in_clnt_cnm)){
//          if (businessmanager.acceptGuideInfo(guideinfoobj, in_clnt_cnm)){

//          if (businessmanager.acceptClmDgst(clmdgstinfoobj, in_opr_cde)){
//          if (businessmanager.updateClmDgst(clmdgstinfoobj, in_opr_cde)){
//          if (businessmanager.deleteClmDgst(clmdgstinfoobj.c_rpt_no,clmdgstinfoobj.c_ply_no,clmdgstinfoobj.c_info_no, in_opr_cde)){
/*          if (businessmanager.acceptChatCntnt("2000-12-27 18:30:30", "2000-12-27 18:50:30", "5048600020100000266", chatarray, "YiJF", "1")){
             System.out.println(" Business Module Action Successful!");
          }else{
             System.out.println(" Business Module Action Fail!");
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
       	  System.err.println("SYSTEM Exception:\n" +e.getMessage ());
//       	  System.err.println("SYSTEM Exception:\n" +e.toString());
      }
  }
}
