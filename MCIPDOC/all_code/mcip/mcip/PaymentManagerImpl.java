////////////////////////////////////////////////////////
// Author:       Maintained by YiJF
// Function:     Payment Management Module Implement
// Update Date:  2001/02/22
////////////////////////////////////////////////////////
//package com.paol.b2b.application;
import com.paol.banking.payment.beimpl.PaymentInfoImpl;
import com.paol.banking.payment.beimpl.OrderInfoImpl;
import com.paol.banking.payment.beimpl.PaymentLogInfoImpl;

import java.text.*;
import java.lang.reflect.*;
import java.sql.*;
import java.util.*;
import utility.*;
import constant.*;
import jtoc.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.pay.orb.*;
import com.mcip.mail.orb.*;
//import com.paol.b2b.ps.PsB2BService;
//import com.paol.b2b.ps.PsB2BServiceHelper;

import com.paol.banking.payment.bs.BsInfoQuery;
import com.paol.banking.payment.bs.BsInfoQueryHelper;
import com.i2w.icore.bs.BsException;
import java.util.Date;


public class PaymentManagerImpl extends _PaymentManagerImplBase {
    private static PoolManager r_pm;
    private static PoolManager l_pm;
    private static String r_dbname=Constant.BACKEND_DBNAME;
    private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
    private CoExceptionHandler exHandler;
    private static BsInfoQuery bsinfo;
    private static EmailManager emanager;

////////////////////////////////////////////////////////
// Function:     Constructor
////////////////////////////////////////////////////////
    public PaymentManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
        super(name);
// connect Remote DB (BackEnd System)
        r_pm = r_poolManager;
//        r_conn = r_pm.getConnection(r_dbname);
// connect Local DB (PA18.COM System)
        l_pm = l_poolManager;
//        l_conn = l_pm.getConnection(l_dbname);

//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PaymentManagerImpl get db connection");
        exHandler = new CoExceptionHandler();

//Add connection with PA18.com CORBA Server for querying Payment result info

        String hostname = Constant.BsInfo_HOSTNAME;
        String servername = Constant.BsInfo_SERVERNAME;
        org.omg.CORBA.ORB orb = ORBManager.getORBForPaymentResult();
        bsinfo = BsInfoQueryHelper.bind( orb, servername , hostname, null);

//        ps.testing();
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PaymentManagerImpl get connection with PA18.com CORBA SERVER");
    }


////////////////////////////////////////////////////////
// Function:     Error Handling Module
////////////////////////////////////////////////////////
    private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PaymentManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,null,"PaymentManagerImpl");
    }

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PaymentManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"PaymentManagerImpl");
    }

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc,String ExceptionField)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection(r_dbname,r_conn);
//        l_pm.freeConnection(l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PaymentManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,ExceptionField);
    }

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc,String ExceptionField,String ExceptionSeverity)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection(r_dbname,r_conn);
//        l_pm.freeConnection(l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PaymentManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,ExceptionField,ExceptionSeverity);
    }


//Business Logic for customer login operation

////////////////////////////////////////////////////////
// Use Case 1 :query Last Payment information
////////////////////////////////////////////////////////

    public String[][] queryLastPayment(String in_order_no, String tran_type, String user_id, String pay_amt, String order_tm)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean main_flag=true;
        String[][] ReturnResult = null;

//Login in PA18.COM for get payment result info
System.out.println(" Connect PA18.COM for getting payment information Now! ");
        try{
            int int_tran_type = new Integer(tran_type).intValue();
            java.util.Date in_tran_tm = null;
            String dateFormat = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            in_tran_tm = formatter.parse(order_tm);
            double in_pay_amt = Double.parseDouble(pay_amt);

            OrderInfoImpl orderinfo = new OrderInfoImpl();
            orderinfo.setOrderRef(in_order_no);
            orderinfo.setTransactTypeId(int_tran_type);
            orderinfo.setUserName(user_id);
            orderinfo.setAmount(in_pay_amt);
            orderinfo.setTime(in_tran_tm);
//            orderinfo.setTime(new Date());
            PaymentInfoImpl payinfo = (PaymentInfoImpl) bsinfo.getLastPayment(orderinfo);

            ReturnResult = new String[2][8];
            ReturnResult[0][0]="m_id";
            ReturnResult[0][1]="m_amount";
            ReturnResult[0][2]="m_time";
            ReturnResult[0][3]="m_user";
            ReturnResult[0][4]="m_orderRef";
            ReturnResult[0][5]="m_sequenceNo";
            ReturnResult[0][6]="m_merchantId";
            ReturnResult[0][7]="m_statusId";

            long tmp_id = payinfo.getId();
            ReturnResult[1][0] = String.valueOf(tmp_id);
            double tmp_amount = payinfo.getAmount();
            ReturnResult[1][1] = String.valueOf(tmp_amount);
            java.util.Date tmp_time = payinfo.getTime();
            ReturnResult[1][2] = formatter.format(tmp_time);
            ReturnResult[1][3] = payinfo.getUserName();
            ReturnResult[1][4] = payinfo.getOrderRef();
            long tmp_seq_no = payinfo.getSequenceNo();
            ReturnResult[1][5] = String.valueOf(tmp_seq_no);
            int tmp_mrchnt_id = payinfo.getMerchantId();
            ReturnResult[1][6] = String.valueOf(tmp_mrchnt_id);
            int tmp_sts_id = payinfo.getStatusId();
            ReturnResult[1][7] = String.valueOf(tmp_sts_id);

//System.out.println(bsinfo.getLastPayment(orderinfo));
//System.out.println(" return from PA18.COM Successfully! "+payinfo.getOrderRef());

        }catch(Exception e){
            e.printStackTrace();
System.out.println(" getting payment information from PA18.COM FAIL! "+ e.getMessage());
//            new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "customerLogin() --- customer Login in PA18.COM Fail! CUST_LOGIN_FAIL!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
//            ErrorHandling(ExceptionCode.CUST_LOGIN_FAIL);
            ErrorHandling(ExceptionCode.PAY_LASTPAYNOTFOUND);
        }

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


////////////////////////////////////////////////////////
// Use Case 2 :query Payment info List
////////////////////////////////////////////////////////

    public String[][] queryPaymentList(String in_order_no, String tran_type, String user_id, String pay_amt, String order_tm)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean main_flag=true;
        String[][] ReturnResult = null;

//Login in PA18.COM for get payment result info
System.out.println(" Connect PA18.COM for getting payment information List Now! ");
        try{
            int int_tran_type = new Integer(tran_type).intValue();
            java.util.Date in_tran_tm = null;
            String dateFormat = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
            in_tran_tm = formatter.parse(order_tm);
            double in_pay_amt = Double.parseDouble(pay_amt);

            OrderInfoImpl orderinfo = new OrderInfoImpl();
            orderinfo.setOrderRef(in_order_no);
            orderinfo.setTransactTypeId(int_tran_type);
            orderinfo.setUserName(user_id);
            orderinfo.setAmount(in_pay_amt);
            orderinfo.setTime(in_tran_tm);
//            orderinfo.setTime(new Date());
            //PaymentInfoImpl[] payinfo = (PaymentInfoImpl[]) bsinfo.getPaymentList(orderinfo);
            java.lang.Object[] payinfo = bsinfo.getPaymentList(orderinfo);

            int payarray_len = payinfo.length;
            if (payarray_len == 0) {
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.PAY_PAYLISTNOTFOUND);
            }

            ReturnResult = new String[payarray_len+1][8];
            ReturnResult[0][0]="m_id";
            ReturnResult[0][1]="m_amount";
            ReturnResult[0][2]="m_time";
            ReturnResult[0][3]="m_user";
            ReturnResult[0][4]="m_orderRef";
            ReturnResult[0][5]="m_sequenceNo";
            ReturnResult[0][6]="m_merchantId";
            ReturnResult[0][7]="m_statusId";

            for (int i=0; i<payarray_len; i++) {
              long tmp_id = ((PaymentInfoImpl)payinfo[i]).getId();
              ReturnResult[i+1][0] = String.valueOf(tmp_id);
              double tmp_amount = ((PaymentInfoImpl)payinfo[i]).getAmount();
              ReturnResult[i+1][1] = String.valueOf(tmp_amount);
              java.util.Date tmp_time = ((PaymentInfoImpl)payinfo[i]).getTime();
              ReturnResult[i+1][2] = formatter.format(tmp_time);
              ReturnResult[i+1][3] = ((PaymentInfoImpl)payinfo[i]).getUserName();
              ReturnResult[i+1][4] = ((PaymentInfoImpl)payinfo[i]).getOrderRef();
              long tmp_seq_no = ((PaymentInfoImpl)payinfo[i]).getSequenceNo();
              ReturnResult[i+1][5] = String.valueOf(tmp_seq_no);
              int tmp_mrchnt_id = ((PaymentInfoImpl)payinfo[i]).getMerchantId();
              ReturnResult[i+1][6] = String.valueOf(tmp_mrchnt_id);
              int tmp_sts_id = ((PaymentInfoImpl)payinfo[i]).getStatusId();
              ReturnResult[i+1][7] = String.valueOf(tmp_sts_id);
            }
//System.out.println(bsinfo.getLastPayment(orderinfo));
//System.out.println(" return from PA18.COM Successfully! "+payinfo.getOrderRef());

        }catch(Exception e){
            e.printStackTrace();
System.out.println(" getting payment information List from PA18.COM FAIL! "+ e.getMessage());
//            new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "customerLogin() --- customer Login in PA18.COM Fail! CUST_LOGIN_FAIL!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
//            ErrorHandling(ExceptionCode.CUST_LOGIN_FAIL);
            ErrorHandling(ExceptionCode.PAY_PAYLISTNOTFOUND);
        }

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


////////////////////////////////////////////////////////
// Use Case 3 :query Payment Log List
////////////////////////////////////////////////////////

    public String[][] queryPaymentLog(String in_p_id)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean main_flag=true;
        String[][] ReturnResult = null;

//Login in PA18.COM for get payment log info
System.out.println(" Connect PA18.COM for getting payment log list Now! ");
        try{
            int int_p_id = new Integer(in_p_id).intValue();
            java.util.Date in_tran_tm = null;
            String dateFormat = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

            //PaymentLogInfoImpl[] payloginfo = (PaymentLogInfoImpl[]) bsinfo.getPaymentLogs(int_p_id);
            java.lang.Object[] payloginfo = bsinfo.getPaymentLogs(int_p_id);

            int paylogarray_len = payloginfo.length;
            if (paylogarray_len == 0) {
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.PAY_PAYLOGNOTFOUND);
            }

            ReturnResult = new String[paylogarray_len+1][5];
            ReturnResult[0][0]="m_id";
            ReturnResult[0][1]="m_paymentId";
            ReturnResult[0][2]="m_logTime";
            ReturnResult[0][3]="m_operator";
            ReturnResult[0][4]="m_content";

            for (int i=0; i<paylogarray_len; i++) {
              long tmp_id = ((PaymentLogInfoImpl)payloginfo[i]).getId();
              ReturnResult[i+1][0] = String.valueOf(tmp_id);
              long tmp_pay_id = ((PaymentLogInfoImpl)payloginfo[i]).getPaymentId();
              ReturnResult[i+1][1] = String.valueOf(tmp_pay_id);
              java.util.Date tmp_time = ((PaymentLogInfoImpl)payloginfo[i]).getLogTime();
              ReturnResult[i+1][2] = formatter.format(tmp_time);
              ReturnResult[i+1][3] = ((PaymentLogInfoImpl)payloginfo[i]).getOperator();
              ReturnResult[i+1][4] = ((PaymentLogInfoImpl)payloginfo[i]).getContent();
            }
//System.out.println(bsinfo.getLastPayment(orderinfo));
//System.out.println(" return from PA18.COM Successfully! "+payinfo.getOrderRef());

        }catch(Exception e){
            e.printStackTrace();
System.out.println(" getting payment log list from PA18.COM FAIL! "+ e.getMessage());
//            new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "customerLogin() --- customer Login in PA18.COM Fail! CUST_LOGIN_FAIL!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
//            ErrorHandling(ExceptionCode.CUST_LOGIN_FAIL);
            ErrorHandling(ExceptionCode.PAY_PAYLOGNOTFOUND);
        }

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


/////////////////////////////////////////////////////////////////
// Use Case 4 :Accept Payment Log information from Web server
/////////////////////////////////////////////////////////////////

  public boolean acceptPaymentLog(com.mcip.pay.orb.PaymentLog paymentlogobj)
        throws com.mcip.orb.CoException{

        if (paymentlogobj.c_cur_typ.length()==0
            || paymentlogobj.t_pay_tm.length()==0
            || paymentlogobj.c_order_no.length()==0
            || paymentlogobj.t_order_tm.length()==0
            || paymentlogobj.c_status_id.length()==0
            || paymentlogobj.c_user_id.length()==0
            ) {
            ErrorHandling(ExceptionCode.PAY_INVALIDID);
        }

        Connection l_conn = l_pm.getConnection(l_dbname);
        Connection r_conn = r_pm.getConnection(r_dbname);
        boolean ReturnResult =false;
System.out.println("Receive payment log information from Web Server.");

        String sqlString1 =Sqlstmt.SELECTCURRCENM2;
        String [][] sqlParameters1= {{"c_cur_no",paymentlogobj.c_cur_typ,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryCurInfo= new ConnectDB (r_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);
        switch (QueryCurInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  break;
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  paymentlogobj.c_cur_sbl = QueryCurInfo.GetReturnArray()[1][4];
                  paymentlogobj.c_cur_cnm = QueryCurInfo.GetReturnArray()[1][1];
                  break;
             default:
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_paylog
        String sqlString2 =Sqlstmt.INSERT_PAYMENTLOG;
        String [][] sqlParameters2=
              {{"c_trans_id",     paymentlogobj.c_trans_id,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cde",     paymentlogobj.c_bank_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cnm",     paymentlogobj.c_bank_cnm,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_accnt",   paymentlogobj.c_bank_accnt,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_got_prm",      String.valueOf(paymentlogobj.n_got_prm),    String.valueOf(Constant.BIGDECIMAL_TYPE)},
               {"c_cur_typ",      paymentlogobj.c_cur_typ,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_cur_sbl",      paymentlogobj.c_cur_sbl,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_cur_cnm",      paymentlogobj.c_cur_cnm,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_pay_tm",       paymentlogobj.t_pay_tm,         String.valueOf(Constant.DATETIME_TYPE)},
               {"c_pay_typ",      paymentlogobj.c_pay_typ,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_cde",      paymentlogobj.c_pay_cde,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_order_no",     paymentlogobj.c_order_no,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_order_tm",     paymentlogobj.t_order_tm,       String.valueOf(Constant.DATETIME_TYPE)},
               {"c_type_id",      paymentlogobj.c_type_id,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_payment_id",   paymentlogobj.c_payment_id,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_seq_no",   paymentlogobj.c_pay_seq_no,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_status_id",    paymentlogobj.c_status_id,      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",      paymentlogobj.c_user_id,        String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertPayLog= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (InsertPayLog.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }


///////////////////////////////////////////////////////////////////////////
// Use Case 5 : Update policy form's address table for setting c_pay_flag
///////////////////////////////////////////////////////////////////////////
  public boolean updatePayFlag(String policy_no, String pay_flag, String in_session_id, String bank_cde, String bank_nme, String bank_accnt,
        String in_got_prm, String in_cur_typ, String pay_tm, String pay_type, String pay_cde, String app_typ)
        throws com.mcip.orb.CoException{

        boolean ReturnResult = false;
        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);

        if ((policy_no==null) || (app_typ == null) || (policy_no.length()==0) || (app_typ.length()==0) ) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"updatePayFlag() NULL POLICY APPLY FORM NUMBER or NULL APPLICANT CODE! NIA_INVALID_DOC_NO");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALID_DOC_NO);
        }

        if ((pay_flag==null) || (pay_flag.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"updatePayFlag() NULL Payment flag!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALID_PAYFLAG);
        }

//Update t_policy_net
        String sqlString = null;
        if (app_typ.equals(Constant.POLICY_TYPE)){
            sqlString = Sqlstmt.UPDATE_POLICYPAYFLAG;             //SQL
        }else{
            sqlString = Sqlstmt.UPDATE_EDRPLYPAYFLAG;             //SQL
        }
        String [][] sqlParameters =
              {{"c_pay_flag",   pay_flag,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_session_id", in_session_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cde",   bank_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_nme",   bank_nme,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_accnt", bank_accnt,   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_got_prm",    in_got_prm,   String.valueOf(Constant.BIGDECIMAL_TYPE)},
               {"c_cur_typ",    in_cur_typ,   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_pay_tm",     pay_tm,       String.valueOf(Constant.DATETIME_TYPE)},
               {"c_pay_typ",    pay_type,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_cde",    pay_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_doc_no",     policy_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB UpdatePayFlag = new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
        switch (UpdatePayFlag.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        ReturnResult = true;
        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.SUCCESS_EVENT,"updatePayFlag() update policy payment flag Successful! ");

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }



//////////////////////////////////////////////////////////////////////////////
// Use Case 6 : Get payment log List for Summary statictics          //
//////////////////////////////////////////////////////////////////////////////

  public java.lang.String[][] getPaymentLogList(String frm_pay_tm, String to_pay_tm, java.lang.String[] owned_dpt,
                                               String in_trans_id, String in_order_no, String in_payment_id,
                                               String in_cur_typ, String in_user_id)
        throws com.mcip.orb.CoException {

        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean input_frm_tm = true;
        boolean input_to_tm = true;
        boolean input_trans_id = true;
        boolean input_order_no = true;
        boolean input_payment_id = true;
        boolean input_cur_typ = true;
        boolean input_user_id = true;

        if ((frm_pay_tm==null) || (frm_pay_tm.length()==0))
            input_frm_tm = false;

        if ((to_pay_tm==null) || (to_pay_tm.length()==0))
            input_to_tm = false;

        if ((in_trans_id==null) || (in_trans_id.length()==0))
            input_trans_id = false;

        if ((in_order_no==null) || (in_order_no.length()==0))
            input_order_no = false;

        if ((in_payment_id==null) || (in_payment_id.length()==0))
            input_payment_id = false;

        if ((in_cur_typ==null) || (in_cur_typ.length()==0))
            input_cur_typ = false;

        if ((in_user_id==null) || (in_user_id.length()==0))
            input_user_id = false;

        String sqlString = Sqlstmt.SELECT_PAYLOGLIST;

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_pay_tm >= TO_DATE('"+frm_pay_tm+"', 'YYYY-MM-DD')";
              sqlString = sqlString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_pay_tm <= TO_DATE('"+to_pay_tm+"', 'YYYY-MM-DD')+1";
              sqlString = sqlString + tmp_sqlString;
          }
        }

        if (input_trans_id) {
            String tmp_sqlString = " AND A.c_trans_id = '"+in_trans_id+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        if (input_order_no) {
            String tmp_sqlString = " AND A.c_order_no = '"+in_order_no+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        if (input_payment_id) {
            String tmp_sqlString = " AND A.c_payment_id = '"+in_payment_id+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        if (input_user_id) {
            String tmp_sqlString = " AND A.c_user_id = '"+in_user_id+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        if (input_cur_typ) {
            String tmp_sqlString = " AND A.c_cur_typ = '"+in_cur_typ+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        if (owned_dpt[0].length() > 0){
            int dptarray_len = owned_dpt.length;
            String dpt_sqlString = " AND B.c_dpt_cde IN (";

            for (int i = 0; i < dptarray_len ; i++){
               if ((i-dptarray_len+1)==0)
                  dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "'";
               else
                  dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "', ";
            }
            sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
        }

        sqlString = sqlString + " ORDER BY B.c_dpt_cde, A.t_pay_tm ";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

        ConnectDB QueryPayLogList= new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryPayLogList.GetReturnCode()) {
           case Constant.ConnectDB_SelectNone:
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
           case Constant.ConnectDB_SelectMulti:
           case Constant.ConnectDB_SelectOne:
                break;
           default:
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getPaymentLogList() --- SUCCESSFULLY! ");
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryPayLogList.GetReturnArray ();
  }


//////////////////////////////////////////////////////////////////////////////
// Use Case 7 : Get payment List for Summary statictics by banking          //
//////////////////////////////////////////////////////////////////////////////

  public java.lang.String[][] getBankPayList(String frm_pay_tm, String to_pay_tm, java.lang.String[] owned_dpt,
                                               String frm_insrnc_cde, String to_insrnc_cde, String in_bank_cde)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean input_frm_tm = true;
        boolean input_to_tm = true;
        boolean input_frm_ins_cde = true;
        boolean input_to_ins_cde = true;
        boolean input_bank_cde = true;

        if ((frm_pay_tm==null) || (frm_pay_tm.length()==0))
            input_frm_tm = false;

        if ((to_pay_tm==null) || (to_pay_tm.length()==0))
            input_to_tm = false;

        if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
            input_frm_ins_cde = false;

        if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
            input_to_ins_cde = false;

        if ((in_bank_cde==null) || (in_bank_cde.length()==0))
            input_bank_cde = false;

        String sqlString = Sqlstmt.SELECT_BANKPAYLIST;

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_pay_tm >= TO_DATE('"+frm_pay_tm+"', 'YYYY-MM-DD')";
              sqlString = sqlString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_pay_tm <= TO_DATE('"+to_pay_tm+"', 'YYYY-MM-DD')+1";
              sqlString = sqlString + tmp_sqlString;
          }
        }

        if (input_bank_cde) {
            String tmp_sqlString = " AND A.c_bank_cde = '"+in_bank_cde+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        if (input_frm_ins_cde || input_to_ins_cde) {
          if (input_frm_ins_cde) {
              String tmp_sqlString = " AND B.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
              sqlString = sqlString + tmp_sqlString;
          }
          if (input_to_ins_cde) {
              String tmp_sqlString = " AND B.c_insrnc_cde <= '"+to_insrnc_cde+"'";
              sqlString = sqlString + tmp_sqlString;
          }
        }

        if (owned_dpt[0].length() > 0){
            int dptarray_len = owned_dpt.length;
            String dpt_sqlString = " AND B.c_dpt_cde IN (";

            for (int i = 0; i < dptarray_len ; i++){
               if ((i-dptarray_len+1)==0)
                  dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "'";
               else
                  dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "', ";
            }
            sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
        }

        sqlString = sqlString + " ORDER BY A.t_pay_tm ";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

        ConnectDB GetBankPay= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (GetBankPay.GetReturnCode()) {
           case Constant.ConnectDB_SelectNone:
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
           case Constant.ConnectDB_SelectMulti:
           case Constant.ConnectDB_SelectOne:
                break;
           default:
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getBankPayList() --- SUCCESSFULLY! ");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return GetBankPay.GetReturnArray ();
  }


//////////////////////////////////////////////////////////////////////////////
// Use Case 8 : Get payment List for Summary statictics by department       //
//////////////////////////////////////////////////////////////////////////////

  public java.lang.String[][] getDptPayList(String frm_undr_tm, String to_undr_tm, java.lang.String[] owned_dpt,
                                               String frm_insrnc_cde, String to_insrnc_cde, String in_bank_cde)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean input_frm_tm = true;
        boolean input_to_tm = true;
        boolean input_frm_ins_cde = true;
        boolean input_to_ins_cde = true;
        boolean input_bank_cde = true;

        if ((frm_undr_tm==null) || (frm_undr_tm.length()==0))
            input_frm_tm = false;

        if ((to_undr_tm==null) || (to_undr_tm.length()==0))
            input_to_tm = false;

        if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
            input_frm_ins_cde = false;

        if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
            input_to_ins_cde = false;

        if ((in_bank_cde==null) || (in_bank_cde.length()==0))
            input_bank_cde = false;

        String sqlString = Sqlstmt.SELECT_DPTPAYLIST;

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_undr_tm >= TO_DATE('"+frm_undr_tm+"', 'YYYY-MM-DD')";
              sqlString = sqlString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_undr_tm <= TO_DATE('"+to_undr_tm+"', 'YYYY-MM-DD')+1";
              sqlString = sqlString + tmp_sqlString;
          }
        }

        if (input_frm_ins_cde || input_to_ins_cde) {
          if (input_frm_ins_cde) {
              String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
              sqlString = sqlString + tmp_sqlString;
          }
          if (input_to_ins_cde) {
              String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
              sqlString = sqlString + tmp_sqlString;
          }
        }

        if (owned_dpt[0].length() > 0){
            int dptarray_len = owned_dpt.length;
            String dpt_sqlString = " AND A.c_dpt_cde IN (";

            for (int i = 0; i < dptarray_len ; i++){
               if ((i-dptarray_len+1)==0)
                  dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "'";
               else
                  dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "', ";
            }
            sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
        }

        if (input_bank_cde) {
            String tmp_sqlString = " AND B.c_bank_cde = '"+in_bank_cde+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        sqlString = sqlString + " AND B.c_pay_flag = '"+ Constant.PAY_SUCC_FLAG +"' ORDER BY A.t_undr_tm ";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

        ConnectDB GetDptPay= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (GetDptPay.GetReturnCode()) {
           case Constant.ConnectDB_SelectNone:
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
           case Constant.ConnectDB_SelectMulti:
           case Constant.ConnectDB_SelectOne:
                break;
           default:
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getBankPayList() --- SUCCESSFULLY! ");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return GetDptPay.GetReturnArray ();
  }


/////////////////////////////////////////////////////////////////////////////////
// Use Case 9 : Update Payment Log information from Web server for payment status
/////////////////////////////////////////////////////////////////////////////////

  public boolean updatePaymentLog(com.mcip.pay.orb.PaymentLog paymentlogobj)
        throws com.mcip.orb.CoException{

        if (paymentlogobj.c_cur_typ.length()==0
            || paymentlogobj.t_pay_tm.length()==0
            || paymentlogobj.c_order_no.length()==0
            || paymentlogobj.t_order_tm.length()==0
            || paymentlogobj.c_status_id.length()==0
            || paymentlogobj.c_user_id.length()==0
            ) {
            ErrorHandling(ExceptionCode.PAY_INVALIDID);
        }

        Connection l_conn = l_pm.getConnection(l_dbname);
        Connection r_conn = r_pm.getConnection(r_dbname);
        boolean ReturnResult =false;
System.out.println("Receive payment log information from Web Server.");

        String sqlString1 =Sqlstmt.SELECTCURRCENM2;
        String [][] sqlParameters1= {{"c_cur_no",paymentlogobj.c_cur_typ,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryCurInfo= new ConnectDB (r_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);
        switch (QueryCurInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  break;
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  paymentlogobj.c_cur_sbl = QueryCurInfo.GetReturnArray()[1][4];
                  paymentlogobj.c_cur_cnm = QueryCurInfo.GetReturnArray()[1][1];
                  break;
             default:
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_paylog
        String sqlString2 =Sqlstmt.UPDATE_PAYMENTLOG;
        String [][] sqlParameters2=
              {{"c_trans_id",     paymentlogobj.c_trans_id,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cde",     paymentlogobj.c_bank_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cnm",     paymentlogobj.c_bank_cnm,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_accnt",   paymentlogobj.c_bank_accnt,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_got_prm",      String.valueOf(paymentlogobj.n_got_prm),    String.valueOf(Constant.BIGDECIMAL_TYPE)},
               {"c_cur_typ",      paymentlogobj.c_cur_typ,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_cur_sbl",      paymentlogobj.c_cur_sbl,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_cur_cnm",      paymentlogobj.c_cur_cnm,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_pay_tm",       paymentlogobj.t_pay_tm,         String.valueOf(Constant.DATETIME_TYPE)},
               {"c_pay_typ",      paymentlogobj.c_pay_typ,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_cde",      paymentlogobj.c_pay_cde,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_order_no",     paymentlogobj.c_order_no,       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_order_tm",     paymentlogobj.t_order_tm,       String.valueOf(Constant.DATETIME_TYPE)},
               {"c_type_id",      paymentlogobj.c_type_id,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_payment_id",   paymentlogobj.c_payment_id,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_seq_no",   paymentlogobj.c_pay_seq_no,     String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_status_id",    paymentlogobj.c_status_id,      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",      paymentlogobj.c_user_id,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_order_no",     paymentlogobj.c_order_no,       String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB UpdatePayLog= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (UpdatePayLog.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }


//////////////////////////////////////////////////////////////////////////////////////////////
// Use Case 10 : Get payment status List from t_pa18_paylog for checking Daemon to process  //
//////////////////////////////////////////////////////////////////////////////////////////////

  public java.lang.String[][] getPayStatusList()
        throws com.mcip.orb.CoException {

        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString = Sqlstmt.SELECT_PAYSTATUSLIST;

//add for debug
System.out.println("after prepare SQL statement : "+ sqlString);

        ConnectDB QueryPayStsList= new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryPayStsList.GetReturnCode()) {
           case Constant.ConnectDB_SelectNone:
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
           case Constant.ConnectDB_SelectMulti:
           case Constant.ConnectDB_SelectOne:
                break;
           default:
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getPayStatusList() --- SUCCESSFULLY! ");
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryPayStsList.GetReturnArray ();
  }


//////////////////////////////////////////////////////////////////////////////////////////////
// Use Case 11 : Set payment status flag on t_policy_net and t_pa18_paylog after checking Daemon to process  //
//////////////////////////////////////////////////////////////////////////////////////////////

  public boolean setPayFlag(java.lang.String[][] payinfo)
        throws com.mcip.orb.CoException {

        Connection l_conn = l_pm.getConnection(l_dbname);
        Connection r_conn = r_pm.getConnection(r_dbname);
        boolean ReturnResult =false;
        int plLength=payinfo.length;

        if ((plLength == 0) || payinfo[0][0].length() == 0){
            l_pm.freeConnection (l_dbname,l_conn);
            r_pm.freeConnection (r_dbname,r_conn);
            return ReturnResult;
        }

// update payment status flag and related info on t_policy_net
        String sqlString1[]=new String[plLength];
        String parm1 [][][]=new String[plLength][3][11];

        for (int i=0;i<plLength;i++){

           sqlString1[i] = Sqlstmt.UPDATE_POLICYPAYFLAG;
           String tmp_pay_sts = payinfo[i][15].substring(payinfo[i][15].length()-1, payinfo[i][15].length());
           String [][] subparm=
              {{"c_pay_flag",     tmp_pay_sts,         String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_session_id",   payinfo[i][13],      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cde",     payinfo[i][2],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cnm",     payinfo[i][3],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_accnt",   payinfo[i][4],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_got_prm",      payinfo[i][5],       String.valueOf(Constant.BIGDECIMAL_TYPE)},
               {"c_cur_typ",      payinfo[i][6],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_pay_tm",       payinfo[i][7],       String.valueOf(Constant.DATETIME_TYPE)},
               {"c_pay_typ",      payinfo[i][8],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_cde",      payinfo[i][9],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_ply_no",       payinfo[i][10],       String.valueOf(Constant.VARCHAR2_TYPE)}};
           parm1[i]= subparm;
        }

        ConnectDB SetFePayFlag1= new ConnectDB (r_conn,sqlString1,Constant.executeBatchPrepUpdate,parm1);
        switch (SetFePayFlag1.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

// update payment status flag and related info on t_pa18_paylog
        String sqlString2[]=new String[plLength];
        String parm2 [][][]=new String[plLength][3][17];

        for (int i=0;i<plLength;i++){

           sqlString2[i] = Sqlstmt.UPDATE_FEPAYFLAG;
           String [][] subparm=
              {{"c_trans_id",     payinfo[i][1],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cde",     payinfo[i][2],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_cnm",     payinfo[i][3],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_bank_accnt",   payinfo[i][4],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_got_prm",      payinfo[i][5],       String.valueOf(Constant.BIGDECIMAL_TYPE)},
               {"c_cur_typ",      payinfo[i][6],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_pay_tm",       payinfo[i][7],       String.valueOf(Constant.DATETIME_TYPE)},
               {"c_pay_typ",      payinfo[i][8],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_cde",      payinfo[i][9],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_order_no",     payinfo[i][10],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"t_order_tm",     payinfo[i][11],       String.valueOf(Constant.DATETIME_TYPE)},
               {"c_type_id",      payinfo[i][12],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_payment_id",   payinfo[i][13],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_seq_no",   payinfo[i][14],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_status_id",    payinfo[i][15],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",      payinfo[i][16],       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pay_log_no",   payinfo[i][0],       String.valueOf(Constant.VARCHAR2_TYPE)}};
           parm2[i]= subparm;
        }

        ConnectDB SetFePayFlag2= new ConnectDB (l_conn,sqlString2,Constant.executeBatchPrepUpdate,parm2);
        switch (SetFePayFlag2.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        ReturnResult =true;
        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "setPayFlag() --- SUCCESSFULLY! ");
        l_pm.freeConnection (l_dbname,l_conn);
        r_pm.freeConnection (r_dbname,r_conn);
        return ReturnResult;
  }


  }


