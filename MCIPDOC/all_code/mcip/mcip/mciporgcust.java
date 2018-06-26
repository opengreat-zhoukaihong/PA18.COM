/* Client.java. This file is used to pass some string to corba server, and
get a string[][] back. this return value more like one string table.
 */
import org.omg.CORBA.*;
import com.mcip.cus.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class mciporgcust {

  public static void main(String[] args) {
      try{
          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  CustManager cmanager =
	      CustManagerHelper.bind(orb, "cmanager");

	  String[][] res = null;
	  
	  String in_usr_name = "1";
	  String in_pass_word= "1";
	  String in_usr_id= "1";
	  String in_clnt_id= "11a";
          String in_user_mrk= "2";
          String in_register_id = "didididid_No";
//        cmanager.customerLogin("1","1");
//        res = cmanager.requireCust(in_user_mrk,in_usr_name,in_register_id);
//        res = cmanager.queryCustEntt(in_usr_id);
//        res = cmanager.queryCustOrgn(in_usr_id);
//        res = cmanager.queryCustPrsn(in_usr_id);

          com.mcip.cus.orb.CustOrgn custorgnobj=new CustOrgn();
          com.mcip.cus.orb.CustEntity custentityobj=new CustEntity();

          custorgnobj.c_clnt_cde = "";
          custorgnobj.c_dpt_cde = "205";
          custorgnobj.n_clnt_grp_cde=1;
          custorgnobj.c_clnt_mrk = "0";
          custorgnobj.c_clnt_nme = "科联公司广州办事处";
          custorgnobj.c_chn_abr = "科联公司广州";
          custorgnobj.c_auth_mrk = "";
          custorgnobj.c_scale_cde="3";
          custorgnobj.c_clnt_scle_cde="";
          custorgnobj.c_orgz_typ_cde="1";
          custorgnobj.c_brd_enm="C&T GZ";
          custorgnobj.c_eng_abr = "C&T GZ";
          custorgnobj.c_ownership_cde="4";
          custorgnobj.c_rgst_no = "gz0123456789";
          custorgnobj.c_tax_no="gz01234567890";
          custorgnobj.n_rgst_mny=60000;
          custorgnobj.c_chief="Walter";
          custorgnobj.n_emly_num=40;
          custorgnobj.c_trd_cde="01";
          custorgnobj.c_upr_dpt_cde="";
          custorgnobj.c_impt_clnt_cde = "";
          custorgnobj.c_cntct_prsn_nme="易锦峰先生";
          custorgnobj.c_tel = "0755-4321533";
          custorgnobj.c_fax = "0755-6543654";
          custorgnobj.c_email = "jf_yi@ctil.com";
          custorgnobj.c_clnt_addr = "0123456789abcdefghijklmnopqrstuvwxyz";
          custorgnobj.c_ara_cde = "1001";
          custorgnobj.c_province = "0400";
          custorgnobj.c_city = "0501";
          custorgnobj.c_place = "广州市环市东375号";
	        custorgnobj.c_zip_cde = "510080";
          custorgnobj.c_accnt_no = "";
          custorgnobj.c_bank = "";
          custorgnobj.c_remark = "";
          custorgnobj.t_upd_tm = "";

          custentityobj.c_clnt_cde = "";
          custentityobj.c_net_id = "001";
          custentityobj.c_pw_question = "How are you?";
          custentityobj.c_pw_result = "I'm fine, Thank you!";
          custentityobj.c_user_id = "yjf1620842319";
          custentityobj.c_user_name = "STRESS_TEST";
          custentityobj.c_user_pw = "12345678";
          custentityobj.c_verify = '0';
          custentityobj.c_cmpny_agt_cde="05000001";
          custentityobj.n_user_seq_no = 23;

          System.out.println("Begin!");

          if (cmanager.acceptAGCust("0", custorgnobj, custentityobj)){
             System.out.println("Accept Person cust Successful!");
          }else{
             System.out.println("Accept Person cust Fail!");
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
       	  System.err.println("SYSTEM Exception:\n" +e.getMessage ());
      }
  }
}
