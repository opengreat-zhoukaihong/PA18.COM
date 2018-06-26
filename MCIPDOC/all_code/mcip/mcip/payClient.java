/* Client.java. This file is used to pass some string to corba server, and
get a string[][] back. this return value more like one string table.
 */
import org.omg.CORBA.*;
import com.mcip.pay.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;
import jtoc.*;


public class payClient {

  public static void main(String[] args) {
      try{
          org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
       	  PaymentManager paymanager =
	               PaymentManagerHelper.bind(orb, "paymanager");

 	     	  String[][] res = null;
          boolean cntnt_flg = true;
 	     	  String[] dptarray = {"201","202","203","204","205","206","212","207",
                               "20186","20286","20386","20486","20586"};
          String frm_pay_tm= "2000-10-31";
          String to_pay_tm= "2001-10-31";
          String in_trans_id= "";
          String in_order_no= "";
          String in_payment_id= "";
          String in_cur_typ= "";
          String in_user_id= "";
          String frm_insrnc_cde= "B01";
          String to_insrnc_cde= "B13";
          String bank_cde= "01";

          com.mcip.pay.orb.PaymentLog paylogobj=new PaymentLog();

          paylogobj.c_trans_id = "1234567890";
          paylogobj.c_bank_cde = "01";
          paylogobj.c_bank_cnm = "BANK OF CHINA";
          paylogobj.c_bank_accnt = "4893215-547835";
          paylogobj.n_got_prm = 305.45;
          paylogobj.c_cur_typ = "01";
          paylogobj.c_cur_sbl = "RMB";
          paylogobj.c_cur_cnm = "»À√Ò±“";
          paylogobj.t_pay_tm = "2001-04-26 16:28:13";
          paylogobj.c_pay_typ = "4567";
          paylogobj.c_pay_cde = "12345678900987654321";
          paylogobj.c_order_no = "2050000010223010040";
          paylogobj.t_order_tm = "2001-05-10 09:45:22";
          paylogobj.c_type_id = "1";
          paylogobj.c_payment_id = "12345678901234567890";
          paylogobj.c_pay_seq_no = "162";
          paylogobj.c_status_id = "103";
          paylogobj.c_user_id = "";

    System.out.println("Begin!");

          System.out.println("Connect PA18.com for Payment result Info Successful!");
//          res = paymanager.queryPaymentResult("5018600020100000014");

//          boolean accpt_flg = paymanager.acceptPaymentLog(paylogobj);
//          boolean accpt_flg = paymanager.updatePaymentLog(paylogobj);

//          boolean accpt_flg = paymanager.updatePayFlag("2050000010223010020","1", paylogobj.c_trans_id, paylogobj.c_bank_cde,paylogobj.c_bank_cnm,paylogobj.c_bank_accnt,
//          "9873.123",paylogobj.c_cur_typ,paylogobj.t_pay_tm,paylogobj.c_pay_typ,paylogobj.c_pay_cde,"0");

          res = paymanager.queryLastPayment(paylogobj.c_order_no, paylogobj.c_type_id, paylogobj.c_user_id, "0.01", paylogobj.t_order_tm);
//          res = paymanager.queryPaymentList(paylogobj.c_order_no, paylogobj.c_type_id, paylogobj.c_user_id, "0.24", paylogobj.t_order_tm);
//          res = paymanager.queryPaymentLog(paylogobj.c_pay_seq_no);

          System.out.println("Payment log Info Operates Successful!");

//          res = paymanager.getPayStatusList();
//          res = paymanager.getPaymentLogList(frm_pay_tm,to_pay_tm,dptarray,in_trans_id,in_order_no,in_payment_id,in_cur_typ,in_user_id);
//          res = paymanager.getBankPayList(frm_pay_tm,to_pay_tm,dptarray,frm_insrnc_cde,to_insrnc_cde,bank_cde);
//          res = paymanager.getDptPayList(frm_pay_tm,to_pay_tm,dptarray,frm_insrnc_cde,to_insrnc_cde,bank_cde);

          if ((res.length == 0) || (res == null))
            cntnt_flg = false;

          if (cntnt_flg){
             System.out.println("get payment result information Operation Successful!");
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
          }else{
             System.out.println("get payment result information Operation Fail!");
          }

//          ConnectDB.dispArray (proposal_rtrn);
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
