////////////////////////////////////////////////////////
// Author:       Maintained by ZhanYB,YiJF
// Function:     Cust Management Module Implement
// Update Date:  2000/8/20
////////////////////////////////////////////////////////
//package com.paol.b2b.application;

import java.sql.*;
import java.util.*;
import utility.*;
import constant.*;
import jtoc.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.cus.orb.*;
import com.mcip.mail.orb.*;
import com.paol.b2b.ps.PsB2BService;
import com.paol.b2b.ps.PsB2BServiceHelper;


public class CustManagerImpl extends _CustManagerImplBase {
    private static PoolManager r_pm;
    private static PoolManager l_pm;
    private static String r_dbname=Constant.BACKEND_DBNAME;
    private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
    private CoExceptionHandler exHandler;
    private static PsB2BService ps;
    private static EmailManager emanager;

////////////////////////////////////////////////////////
// Function:     Constructor
////////////////////////////////////////////////////////
    public CustManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
        super(name);
// connect Remote DB (BackEnd System)
        r_pm = r_poolManager;
//        r_conn = r_pm.getConnection(r_dbname);
// connect Local DB (PA18.COM System)
        l_pm = l_poolManager;
//        l_conn = l_pm.getConnection(l_dbname);

//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"CustManagerImpl get db connection");
        exHandler = new CoExceptionHandler();

//Add connection with EMAIL CORBA Server
        org.omg.CORBA.ORB email_orb = ORBManager.getORBForClient();
        emanager = EmailManagerHelper.bind(email_orb, "emanager");

//Add connection with PA18.com CORBA Server
        String hostname = Constant.PsB2B_HOSTNAME;
        String servername = Constant.PsB2B_SERVERNAME;
        org.omg.CORBA.ORB orb = ORBManager.getORBForCustomerManage();
        ps = PsB2BServiceHelper.bind( orb, servername , hostname, null);
		try{
         ps.testing();
        }catch(Throwable e){ e.printStackTrace();}
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"CustManagerImpl get connection with PA18.com CORBA SERVER");
    }


////////////////////////////////////////////////////////
// Function:     Error Handling Module
////////////////////////////////////////////////////////
    private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"CustManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,null,"CustManagerImpl");
    }

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"CustManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"CustManagerImpl");
    }

//Business Logic for customer login operation

////////////////////////////////////////////////////////
// Common Routine for all case
// Check the unique of  input user id
////////////////////////////////////////////////////////
  public boolean checkUnique(String in_c_user_id)
        throws com.mcip.orb.CoException{

        boolean ReturnResult =false;

        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_UNIQUEUSERID;
        String [][] sqlParameters1= {{"c_user_id",in_c_user_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB CheckUnique= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters1);
        switch (CheckUnique.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  ReturnResult =true;
                  break;
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  ReturnResult =false;
                  break;
             default:
                  ReturnResult =false;
                  break;
        }
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


////////////////////////////////////////////////////////
// Use Case 1 :Customer Login
////////////////////////////////////////////////////////

    public String[][] customerLogin(String in_usr_name,String in_pass_word)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean main_flag=true;

//Login in PA18.COM
        try{
            ps.logon(in_usr_name, in_pass_word);
System.out.println(" Login in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Login in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "customerLogin() --- customer Login in PA18.COM Fail! CUST_LOGIN_FAIL!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
//            ErrorHandling(ExceptionCode.CUST_LOGIN_FAIL);
            ErrorHandling(ExceptionCode.CUST_ERRORIDORPW);
        }

//check login user account & password in t_pa18_user.
        String sqlString1 =Sqlstmt.SELECT_CUSTLOGIN_1;
//        String [][] sqlParameters1= {{"c_user_id",in_usr_name,String.valueOf(Constant.VARCHAR2_TYPE)},
//                                     {"c_user_pw",in_pass_word,String.valueOf(Constant.VARCHAR2_TYPE)}};
        String [][] sqlParameters1= {{"c_user_id",in_usr_name,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryUser= new ConnectDB (l_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);

        switch (QueryUser.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- invalid account or password, CUST_ERRORIDORPW!");
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_ERRORIDORPW);
             case Constant.ConnectDB_SelectMulti:
                  new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- duplicate account, DB_NOTUNIQUEREC!");
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Update login time and login info
        String sqlString3 =Sqlstmt.UPDATE_LOGINTIME;         //SQL
        String [][] sqlParameters3= {{"c_user_id",in_usr_name,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB UpdateLogin= new ConnectDB (l_conn,sqlString3,Constant.executePrepUpdate,sqlParameters3);

        switch (UpdateLogin.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

// Checinking
//QueryUser.GetReturnArray ()[1][0]   ---> c_clnt_cde
//QueryUser.GetReturnArray ()[1][1]   ---> c_cmpny_agt_cde
//QueryUser.GetReturnArray ()[1][2]   ---> c_net_cde
//QueryUser.GetReturnArray ()[1][3]   ---> c_verify

        String c_cust_typ = QueryUser.GetReturnArray()[1][3];
        if ( c_cust_typ.equals(Constant.USER_CANCEL) ){
            new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- customer account expired, CUST_LOGINREFUSE!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_LOGINREFUSE);
        }

        if ((QueryUser.GetReturnArray ()[1][0]==null) || (QueryUser.GetReturnArray ()[1][0].length()==0)) {
          if ( !(c_cust_typ.equals(Constant.AGENCY_CUST_MRK)) ) {
              new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- customer client code invalid, CUST_CLNTAGTCDENULL!");
              r_pm.freeConnection (r_dbname,r_conn);
              l_pm.freeConnection (l_dbname,l_conn);
              ErrorHandling(ExceptionCode.CUST_CLNTAGTCDENULL);
          }
        }

        if ((QueryUser.GetReturnArray ()[1][1]==null) || (QueryUser.GetReturnArray ()[1][1].length()==0)) {
          if ( c_cust_typ.equals(Constant.AGENCY_CUST_MRK) ) {
              new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- customer client code invalid, CUST_CLNTAGTCDENULL!");
              r_pm.freeConnection (r_dbname,r_conn);
              l_pm.freeConnection (l_dbname,l_conn);
              ErrorHandling(ExceptionCode.CUST_CLNTAGTCDENULL);
          }
        }

//get login user's main account in t_clnt_map.
/*
        String sqlString4 = new String("");
        if ( c_cust_typ.equals(Constant.AGENCY_CUST_MRK) ){
            sqlString4 = Sqlstmt.SELECT_AGNTMAINACC;
        }else{
            sqlString4 = Sqlstmt.SELECT_CLNTMAINACC;
        }
        String [][] sqlParameters4= {{"c_user_id",    in_usr_name,      String.valueOf(Constant.VARCHAR2_TYPE)},
                                     {"c_main_flg",   Constant.MAIN_MRK,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryClntMap = new ConnectDB (conn, sqlString4, Constant.executePrepQuery, sqlParameters4);

        switch (QueryClntMap.GetReturnCode()) {
           case Constant.ConnectDB_SelectNone:
                new ConnectDB(conn).WriteDBLog(conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- Main Account Not Found CUST_MAINACCNOTEXIST!");
                ErrorHandling(ExceptionCode.CUST_MAINACCNOTEXIST);
           case Constant.ConnectDB_SelectMulti:
                new ConnectDB(conn).WriteDBLog(conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- Duplicate MAIN Account, CUST_MAINACCDUPICATE!");
                ErrorHandling(ExceptionCode.CUST_MAINACCDUPICATE);
           case Constant.ConnectDB_SelectOne:
                break;
           default:
                ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }
*/

//get login user's information in t_client/t_agent.
        String sqlString = new String("");
        String [][] sqlParameters2=null;
        if ( c_cust_typ.equals(Constant.AGENCY_CUST_MRK) ){
            sqlString = Sqlstmt.SELECT_CUSTLOGIN_3;
//            sqlParameters2=parameters_convert("c_cmpny_agt_cde",QueryClntMap.GetReturnArray()[1][1],String.valueOf(Constant.VARCHAR2_TYPE));
            sqlParameters2=parameters_convert("c_cmpny_agt_cde",QueryUser.GetReturnArray ()[1][1],String.valueOf(Constant.VARCHAR2_TYPE));
        }else{
            sqlString = Sqlstmt.SELECT_CUSTLOGIN_2;
//            sqlParameters2=parameters_convert("c_clnt_cde",     QueryClntMap.GetReturnArray()[1][1],String.valueOf(Constant.VARCHAR2_TYPE));
            sqlParameters2=parameters_convert("c_clnt_cde",     QueryUser.GetReturnArray ()[1][0],String.valueOf(Constant.VARCHAR2_TYPE));
        }

        ConnectDB QueryClient= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters2);
        switch (QueryClient.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.FAIL_EVENT, "customerLogin() --- invalid c_clnt_cde CUST_NOCLNTINFO!");
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_NOCLNTINFO);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        String [][] Res = QueryClient.GetReturnArray();
        String [][] ReturnResult = new String[2][13];

        ReturnResult[0][0]="c_cust_typ";
        ReturnResult[1][0]=c_cust_typ;

	      for (int j=0;j <10;j++){
            ReturnResult[0][j+1]=Res[0][j];
            ReturnResult[1][j+1]=Res[1][j];
        }
        ReturnResult[0][11]="c_verify";
        ReturnResult[1][11]=c_cust_typ;
        if ( c_cust_typ.equals(Constant.AGENCY_CUST_MRK) ){
            ReturnResult[0][12]="c_clnt_cde";
            ReturnResult[1][12]=QueryUser.GetReturnArray()[1][0];
        }else{
            ReturnResult[0][12]="c_cmpny_agt_cde";
            ReturnResult[1][12]=QueryUser.GetReturnArray()[1][1];
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_name, Constant.LOG_CUSTLOGIN, Constant.SUCCESS_EVENT, "customerLogin() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }

    String [][] parameters_convert(String c_field_name,String c_field_value, String c_field_type)
        throws com.mcip.orb.CoException{
        String [][] sqlParameters2={{c_field_name,c_field_value,c_field_type}};
        return sqlParameters2;
    }


////////////////////////////////////////////////////////
// Use Case 2 :Accept OrgCust
////////////////////////////////////////////////////////

  public boolean acceptOrgaCust(String in_register_mrk, com.mcip.cus.orb.CustOrgn custorgnobj,
                                com.mcip.cus.orb.CustEntity custentityobj)
        throws com.mcip.orb.CoException{

        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult =false;
        String s_clnt_code="";
//Check if unique
        if (!checkUnique(custentityobj.c_user_id)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
        }

System.out.println(" Organization Customer Register in PA18.COM Now.");
//Register in PA18.COM
        try{
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ps.logon(custentityobj.c_user_id, custentityobj.c_user_pw);
            }else{
              ps.register(custentityobj.c_user_id, custentityobj.c_user_pw,Constant.ORGN_FLG);
            }
System.out.println(" Organization Customer Register in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Organization Customer Register in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ErrorHandling(ExceptionCode.CUST_ERRORIDORPW);
            }else{
              ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
            }
        }

//Add call jni interface here
        try{
            PacketHead ph = new PacketHead(JCConstant.ACCEPTORGACUST_PACKET_ID);
            JavaC jc=new JavaC(ph,custorgnobj);
            jc.init();
            jc.JavaCMain();
            s_clnt_code=jc.GetReturnClass().getField("c_clnt_cde").get(jc.GetReturnObj()).toString();
//Add for debug
System.out.println('\n'+"Java call c successfully");
//jtoc.JavaC.DisplayFields(jc.GetReturnObj());
//jc.DisplayFields(jc.GetReturnObj());
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- JAVA CALL C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

//Insert into  t_clnt_map
        String sqlString1 = Sqlstmt.INSERT_CLNTMAP_CLNT;
        String [][] sqlParameters1 =
              {{"c_user_id",        custentityobj.c_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",       s_clnt_code,                String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_undr_cde",       "system",                   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_main_flg",       Constant.MAIN_MRK,          String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertClntMap= new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);

        switch (InsertClntMap.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_user
//  Modified by YiJF 2001-04-05 for user accept test, it should be original(USER_NOT_VERIFY)
//        custentityobj.c_verify = Constant.USER_NOT_VERIFY;
        custentityobj.c_verify = Constant.NORMAL_VERIFIED;
        custentityobj.c_net_id = Constant.PA18_NET_CDE;
        String sqlString2 =Sqlstmt.INSERT_ACPTCUST;
        String [][] sqlParameters2=
              {{"c_crt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_upd_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",custentityobj.c_user_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_name",custentityobj.c_user_name,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_question",custentityobj.c_pw_question,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_result",custentityobj.c_pw_result,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_user_seq_no",String.valueOf(custentityobj.n_user_seq_no),String.valueOf(Constant.INT_TYPE)},
               {"c_verify",String.valueOf(custentityobj.c_verify),String.valueOf(Constant.CHAR_TYPE)},
               {"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_net_cde",custentityobj.c_net_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_dpt_cde",custorgnobj.c_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_nme",custorgnobj.c_clnt_nme,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_mrk",Constant.ORGN_FLG,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_email",custorgnobj.c_email,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertUser= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (InsertUser.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        sendMailToUndr(custorgnobj.c_dpt_cde, Constant.CUST_UNDR, custentityobj.c_user_id);
        new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "acceptOrgaCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }


////////////////////////////////////////////////////////
// Use Case 3 :Accept PrsnCust
////////////////////////////////////////////////////////

  public boolean acceptPrsnCust(String in_register_mrk, com.mcip.cus.orb.CustPrsn custprsnobj,
                                com.mcip.cus.orb.CustEntity custentityobj)
        throws com.mcip.orb.CoException{

        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult =false;
        String s_clnt_code="";
//Check if unique
        if (!checkUnique(custentityobj.c_user_id)){
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptPrsnCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID,custentityobj.c_user_id);
        }

//Register in PA18.COM
        try{
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ps.logon(custentityobj.c_user_id, custentityobj.c_user_pw);
            }else{
              ps.register(custentityobj.c_user_id, custentityobj.c_user_pw,Constant.PRSN_FLG);
            }
System.out.println(" Personal Customer Register in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Personal Customer Register in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptPrsnCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ErrorHandling(ExceptionCode.CUST_ERRORIDORPW);
            }else{
              ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
            }
        }

//Add call jni interface here
        try{
            PacketHead ph = new PacketHead(JCConstant.ACCEPTPRSNCUST_PACKET_ID);
            JavaC jc=new JavaC(ph,custprsnobj);
            jc.init();
            jc.JavaCMain();
            s_clnt_code=jc.GetReturnClass().getField("c_clnt_cde").get(jc.GetReturnObj()).toString();
/*
            Object tempobj=jc.GetReturnvctor().elementAt(3);
            Class tempclass=jc.GetObjClass(tempobj);
            s_clnt_code=tempclass.getField("c_clnt_cde").get(tempobj).toString();
*/
//Add for debug
System.out.println('\n'+"Java call c successfully");
//jtoc.JavaC.DisplayFields(jc.GetReturnObj());
//jc.DisplayFields(jc.GetReturnObj());
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptPrsnCust() --- JAVA CALL C ERROR !");
                  l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptPrsnCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                  l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

//Insert into  t_clnt_map
        String sqlString1 = Sqlstmt.INSERT_CLNTMAP_CLNT;
        String [][] sqlParameters1 =
              {{"c_user_id",        custentityobj.c_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",       s_clnt_code,                String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_undr_cde",       "system",                   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_main_flg",       Constant.MAIN_MRK,          String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertClntMap= new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);

        switch (InsertClntMap.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_user
//  Modified by YiJF 2001-04-05 for user accept test, it should be original(USER_NOT_VERIFY)
//        custentityobj.c_verify = Constant.USER_NOT_VERIFY;
        custentityobj.c_verify = Constant.NORMAL_VERIFIED;
        custentityobj.c_net_id = Constant.PA18_NET_CDE;
        String sqlString2 =Sqlstmt.INSERT_ACPTCUST;
        String [][] sqlParameters2=
              {{"c_crt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_upd_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",custentityobj.c_user_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_name",custentityobj.c_user_name,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_question",custentityobj.c_pw_question,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_result",custentityobj.c_pw_result,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_user_seq_no",String.valueOf(custentityobj.n_user_seq_no),String.valueOf(Constant.INT_TYPE)},
               {"c_verify",String.valueOf(custentityobj.c_verify),String.valueOf(Constant.CHAR_TYPE)},
               {"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_net_cde",custentityobj.c_net_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_dpt_cde",custprsnobj.c_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_nme",custprsnobj.c_clnt_nme,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_mrk",Constant.PRSN_FLG,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_email",custprsnobj.c_email,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertUser= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (InsertUser.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        sendMailToUndr(custprsnobj.c_dpt_cde, Constant.CUST_UNDR, custentityobj.c_user_id);
        new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "acceptPrsnCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }

////////////////////////////////////////////////////////
// Use Case 4 :Accept AgntCust
////////////////////////////////////////////////////////

  public boolean acceptAgntCust(com.mcip.cus.orb.CustEntity custentityobj)
        throws com.mcip.orb.CoException{

        boolean ReturnResult =false;

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        if ((custentityobj.c_cmpny_agt_cde==null) || (custentityobj.c_cmpny_agt_cde.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptAgntCust() --- invalid agent number ! CUST_INVALIDQUERYPARM!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);
        }

//Check if unique
        if (!checkUnique(custentityobj.c_user_id)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptAgntCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
        }

//Register in PA18.COM
        try{
            ps.register(custentityobj.c_user_id, custentityobj.c_user_pw,Constant.ORGN_FLG);
System.out.println(" Agent Register in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Agent Register in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptAgntCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
        }

//Check if Agency
        String agt_sqlString = Sqlstmt.SELECT_VALIDAGENT;
        String [][] agt_sqlParameters = {{"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB ValidAgent = new ConnectDB (r_conn,agt_sqlString,Constant.executePrepQuery,agt_sqlParameters);
        switch (ValidAgent.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_clnt_map
        String sqlString1 = Sqlstmt.INSERT_CLNTMAP_AGNT;
        String [][] sqlParameters1 =
              {{"c_user_id",        custentityobj.c_user_id,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_cmpny_agt_cde",  custentityobj.c_cmpny_agt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_undr_cde",       "system",                       String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_main_flg",       Constant.MAIN_MRK,              String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertClntMap= new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);

        switch (InsertClntMap.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_user
// Oct-27 YJF update c_verify changed to agent_veried
//        custentityobj.c_verify = Constant.USER_NOT_VERIFY;
        custentityobj.c_verify = Constant.AGENT_VERIFIED;
        custentityobj.c_net_id = Constant.PA18_NET_CDE;
        String sqlString2 =Sqlstmt.INSERT_ACPTCUST;
        String [][] sqlParameters2=
              {{"c_crt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_upd_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",custentityobj.c_user_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_name",custentityobj.c_user_name,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_question",custentityobj.c_pw_question,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_result",custentityobj.c_pw_result,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",custentityobj.c_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_user_seq_no",String.valueOf(custentityobj.n_user_seq_no),String.valueOf(Constant.INT_TYPE)},
               {"c_verify",String.valueOf(custentityobj.c_verify),String.valueOf(Constant.CHAR_TYPE)},
               {"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_net_cde",custentityobj.c_net_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertUser= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (InsertUser.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "acceptAgntCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }


////////////////////////////////////////////////////////
// Use Case 5 :Update OrgCust
////////////////////////////////////////////////////////

  public boolean updateOrgaCust(com.mcip.cus.orb.CustOrgn custorgnobj,
                                String cust_user_id)
        throws com.mcip.orb.CoException{
        boolean ReturnResult =false;

System.out.println("update Organization Customer"+custorgnobj.c_clnt_nme);

        Connection l_conn = l_pm.getConnection(l_dbname);
/*
        String sqlString =Sqlstmt.SELECT_UNIQUEUSERID;
        String [][] sqlParameters1= {{"c_user_id",cust_user_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB CheckUnique= new ConnectDB (conn,sqlString,Constant.executePrepQuery,sqlParameters1);

        switch (CheckUnique.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  ReturnResult=true;
                  break;
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
             default:
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }
        pm.freeConnection (dbname,conn);
*/

//Add call jni interface here
        try{
            PacketHead ph = new PacketHead(JCConstant.UPDATEORGACUST_PACKET_ID);
            JavaC jc=new JavaC(ph,custorgnobj);
            jc.init();
            jc.JavaCMain();
//            s_clnt_code=jc.GetReturnClass().getField("c_clnt_cde").get(jc.GetReturnObj()).toString();
//Add for debug
System.out.println('\n'+"Java call c successfully");
//jtoc.JavaC.DisplayFields(jc.GetReturnObj());
//jc.DisplayFields(jc.GetReturnObj());
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, cust_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "updateOrgaCust() --- JAVA CALL C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, cust_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "updateOrgaCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

        String sqlString =Sqlstmt.UPDATE_PA18CLNTINFO;
        String [][] sqlParameters= {
               {"c_dpt_cde",    custorgnobj.c_dpt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_nme",   custorgnobj.c_clnt_nme,   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_mrk",   Constant.ORGN_FLG,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_email",      custorgnobj.c_email,      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",    cust_user_id,             String.valueOf(Constant.VARCHAR2_TYPE)}
            };

        ConnectDB UpdateEntt= new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
        switch (UpdateEntt.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  ReturnResult=true;
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, cust_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "updateOrgaCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
   }


////////////////////////////////////////////////////////
// Use Case 6 :Update PrsnCust
////////////////////////////////////////////////////////

  public boolean updatePrsnCust(com.mcip.cus.orb.CustPrsn custprsnobj,
                                String cust_user_id)
        throws com.mcip.orb.CoException{
        boolean ReturnResult =false;

System.out.println("update Organization Customer"+custprsnobj.c_clnt_nme);

        Connection l_conn = l_pm.getConnection(l_dbname);
/*
        String sqlString =Sqlstmt.SELECT_UNIQUEUSERID;
        String [][] sqlParameters1= {{"c_user_id",cust_user_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB CheckUnique= new ConnectDB (conn,sqlString,Constant.executePrepQuery,sqlParameters1);

        switch (CheckUnique.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  ReturnResult=true;
                  break;
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
             default:
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }
        pm.freeConnection (dbname,conn);
*/

//Add call jni interface here
        try{
            PacketHead ph = new PacketHead(JCConstant.UPDATEPRSNCUST_PACKET_ID);
            JavaC jc=new JavaC(ph,custprsnobj);
            jc.init();
            jc.JavaCMain();
//            s_clnt_code=jc.GetReturnClass().getField("c_clnt_cde").get(jc.GetReturnObj()).toString();
//Add for debug
System.out.println('\n'+"Java call c successfully");
//jtoc.JavaC.DisplayFields(jc.GetReturnObj());
//jc.DisplayFields(jc.GetReturnObj());
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, cust_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "updatePrsnCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, cust_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "updatePrsnCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString());
        }

        String sqlString =Sqlstmt.UPDATE_PA18CLNTINFO;
        String [][] sqlParameters= {
               {"c_dpt_cde",    custprsnobj.c_dpt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_nme",   custprsnobj.c_clnt_nme,   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_mrk",   Constant.PRSN_FLG,        String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_email",      custprsnobj.c_email,      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",    cust_user_id,             String.valueOf(Constant.VARCHAR2_TYPE)}
            };

        ConnectDB UpdateEntt= new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
        switch (UpdateEntt.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  ReturnResult=true;
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, cust_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "updatePrsnCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
   }


////////////////////////////////////////////////////////
// Use Case 7 :Update EnttCust
////////////////////////////////////////////////////////

   public boolean updateEnttCust(com.mcip.cus.orb.CustEntity custentityobj)
        throws com.mcip.orb.CoException{
        boolean ReturnResult =false;

        Connection l_conn = l_pm.getConnection(l_dbname);
//Register in PA18.COM
        try{
            ps.updatePassword(custentityobj.c_user_id, custentityobj.c_user_pw);
System.out.println(" Update customer password in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Update customer password in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "updateEnttCust() --- customer account & password update error! CUST_PWD_UPD_FAIL!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_PWD_UPD_FAIL);
        }

        custentityobj.c_verify = Constant.USER_NOT_VERIFY;
        custentityobj.c_net_id = Constant.PA18_NET_CDE;
        String sqlString =Sqlstmt.UPDATE_ENTTCUST;
        String [][] sqlParameters= {
            {"c_upd_cde",    custentityobj.c_user_id,                    String.valueOf(Constant.VARCHAR2_TYPE)},
            {"c_user_name",  custentityobj.c_user_name,                  String.valueOf(Constant.VARCHAR2_TYPE)},
            {"c_pw_question",custentityobj.c_pw_question,                String.valueOf(Constant.VARCHAR2_TYPE)},
            {"c_pw_result",  custentityobj.c_pw_result,                  String.valueOf(Constant.VARCHAR2_TYPE)},
            {"n_user_seq_no",String.valueOf(custentityobj.n_user_seq_no),String.valueOf(Constant.INT_TYPE)},
            {"c_user_id",    custentityobj.c_user_id,                    String.valueOf(Constant.VARCHAR2_TYPE)}
            };

        ConnectDB UpdateEntt= new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);

        switch (UpdateEntt.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  ReturnResult=true;
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "updateCustEntt() --- SUCCESSFULLY!");
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
   }


////////////////////////////////////////////////////////
// Use Case 8 :Query CustEntt
////////////////////////////////////////////////////////

    public java.lang.String[][] queryCustEntt(String in_usr_id) throws com.mcip.orb.CoException {

        if ((in_usr_id==null) || (in_usr_id.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_CUSTENTT;
        String [][] sqlParameters= {{"c_user_id",in_usr_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB QueryCustEntt= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryCustEntt.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_FINDNOREC);
             case Constant.ConnectDB_SelectMulti:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, in_usr_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "queryCustEntt() --- SUCCESSFULLY!");
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryCustEntt.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Use Case 9 :Query CustOrgn
////////////////////////////////////////////////////////

    public java.lang.String[][] queryCustOrgn(String in_usr_id) throws com.mcip.orb.CoException {

        if ((in_usr_id==null) || (in_usr_id.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_CUSTORGN;
        String [][] sqlParameters= {{"c_clnt_cde",in_usr_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB QueryCustOrgn= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryCustOrgn.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_FINDNOREC);
             case Constant.ConnectDB_SelectMulti:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "queryCustOrgn() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryCustOrgn.GetReturnArray ();

    }


////////////////////////////////////////////////////////
// Use Case 10 :Query CustPrsn
////////////////////////////////////////////////////////
    public java.lang.String[][] queryCustPrsn(String in_usr_id) throws com.mcip.orb.CoException {

        if ((in_usr_id==null) || (in_usr_id.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_CUSTPRSN;
        String [][] sqlParameters= {{"c_clnt_cde",in_usr_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB QueryCustPrsn= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryCustPrsn.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_FINDNOREC);
             case Constant.ConnectDB_SelectMulti:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "queryCustPrsn() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryCustPrsn.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Use Case 11 :Query CustAgnt
////////////////////////////////////////////////////////

    public java.lang.String[][] queryCustAgnt(String in_usr_id) throws com.mcip.orb.CoException {

        if ((in_usr_id==null) || (in_usr_id.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_CUSTAGNT;
        String [][] sqlParameters= {{"c_cmpny_agt_cde",in_usr_id,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB QueryCustPrsn= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryCustPrsn.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_FINDNOREC);
             case Constant.ConnectDB_SelectMulti:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "queryCustAgnt() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryCustPrsn.GetReturnArray ();
    }


/////////////////////////////////////////////////////////////////////////////////////////////////
// Use Case 12 : require Customer entity info (t_pa18_user) for processing forgetting password //
/////////////////////////////////////////////////////////////////////////////////////////////////

    public String[][] requireCust(String in_user_mrk, String in_user_id,String in_register_id)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_register_id==null))
            ErrorHandling(ExceptionCode.CUST_NULLQUERYPARM);

        if ((in_user_id.length()==0) || (in_register_id.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String [][] sqlParameters1= {{"c_user_id",    in_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)}};
        String sqlString1 = Sqlstmt.SELECT_REQUIRECUST_1;
        ConnectDB QueryCust= new ConnectDB (l_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);
        switch (QueryCust.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_IDRGSTAGTNOEXIST);
             case Constant.ConnectDB_SelectMulti:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_IDRGSTAGTDUPLICATE);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        String tmp_clnt_cde = QueryCust.GetReturnArray()[1][4];
        String [][] sqlParameters2= {{"c_clnt_cde",    tmp_clnt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                     {"c_register_id",in_register_id,   String.valueOf(Constant.VARCHAR2_TYPE)}};
        String sqlString2 = Sqlstmt.SELECT_REQUIRECUST_2;
        ConnectDB QueryClient= new ConnectDB (r_conn,sqlString2,Constant.executePrepQuery,sqlParameters2);
        switch (QueryClient.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_IDRGSTAGTNOEXIST);
             case Constant.ConnectDB_SelectMulti:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_IDRGSTAGTDUPLICATE);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        String [][] ReturnResult = new String[2][6];
        ReturnResult = QueryCust.GetReturnArray();
        ReturnResult[0][5]=QueryClient.GetReturnArray()[0][1];
        ReturnResult[1][5]=QueryClient.GetReturnArray()[1][1];

        new ConnectDB(l_conn).WriteDBLog(l_conn, in_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "requireCust() --- forget password, check user account SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


//////////////////////////////////////////////////////////////////////
// Use Case 13 : check Policy Application Proposal exist or not     //
//////////////////////////////////////////////////////////////////////
    public boolean checkProposal(String in_user_id, String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_cust_typ=false;
// Check customer type --- "agent type" "Open Cover type" "normal type"
        if ((in_cust_typ==null) || (in_cust_typ.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) ||
            (in_cust_typ.equals(Constant.OPNCVR_CUST_MRK)) ||
            (in_cust_typ.equals(Constant.NORMAL_CUST_MRK)) )
            input_cust_typ=true;

        if (!input_cust_typ)
            ErrorHandling(ExceptionCode.CUST_INVRF_EXPIRE);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult = false;
// get related c_clnt_cde list from t_clnt_map
        String in_cmpny_agt_cde = new String("");
        String [][] clnt_Res = null;
        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String SqlStatement1=Sqlstmt.SELECT_CUSTENTT;
            String [][] sqlParameters1= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
            ConnectDB QueryClntMapList1= new ConnectDB (l_conn,SqlStatement1,Constant.executePrepQuery,sqlParameters1);
            switch (QueryClntMapList1.GetReturnCode()) {
                case Constant.ConnectDB_SelectNone:
                      r_pm.freeConnection (r_dbname,r_conn);
                      l_pm.freeConnection (l_dbname,l_conn);
                      ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
                case Constant.ConnectDB_SelectMulti:
                case Constant.ConnectDB_SelectOne:
                      break;
                default:
                      r_pm.freeConnection (r_dbname,r_conn);
                      l_pm.freeConnection (l_dbname,l_conn);
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
            };
            in_cmpny_agt_cde=QueryClntMapList1.GetReturnArray()[1][8];
        }else{
            String SqlStatement2=Sqlstmt.SELECT_CLNTMAP;
            String [][] sqlParameters2= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
            ConnectDB QueryClntMapList2= new ConnectDB (l_conn,SqlStatement2,Constant.executePrepQuery,sqlParameters2);
            switch (QueryClntMapList2.GetReturnCode()) {
                case Constant.ConnectDB_SelectNone:
                      r_pm.freeConnection (r_dbname,r_conn);
                      l_pm.freeConnection (l_dbname,l_conn);
                      ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
                case Constant.ConnectDB_SelectMulti:
                case Constant.ConnectDB_SelectOne:
                      break;
                default:
                      r_pm.freeConnection (r_dbname,r_conn);
                      l_pm.freeConnection (l_dbname,l_conn);
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query customer policy List
        String arguString =new String("");    //SQL
        String sqlString =Sqlstmt.SELECT_PRPSLEXIST;    //SQL


        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND B.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND B.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString;
// get related Policy application form list from t_plyapp & t_plyappcrgo
        ConnectDB QueryProposaList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryProposaList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        String [][] Res_prpsl = QueryProposaList.GetReturnArray();
        if (Res_prpsl[1][0].equals(Constant.FALSE_NO)) {
            ReturnResult = false;
        }else{
            ReturnResult = true;
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn,in_user_id,Constant.LOG_CUSTLOGIN,Constant.SUCCESS_EVENT,"checkProposal() check Policy apply form's Proposal exist or not, Successful!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


/////////////////////////////////////////////////////////////
// Use Case 14 : Query support employee's email address List
/////////////////////////////////////////////////////////////

  public java.lang.String[][] getSuppEmailList(String in_dpt_cde, String in_emp_type)
        throws com.mcip.orb.CoException {

        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean input_emp_type = true;
        boolean input_dpt_cde = true;
        String [][] ReturnResult = new String[2][7];

        if ((in_dpt_cde == null) || (in_dpt_cde.length()==0)){
            input_dpt_cde=false;
        }else{
            input_dpt_cde=true;
        }

        if (in_emp_type.length()==1){
            input_emp_type=true;
        }else{
            input_emp_type=false;
        }

        String sqlString = new String("");
        String arguString = new String("");

        if (input_emp_type) {
            String tmp_sqlString = " AND SUBSTR(c_emp_type,"+in_emp_type+",1) = '"+Constant.TRUE_YES+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_dpt_cde) {
            String tmp_sqlString = " AND c_dpt_cde = '"+in_dpt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }

        sqlString = Sqlstmt.SELECT_SUPP_MAIL + arguString + " ORDER BY t_crt_tm DESC";     //SQL
        ConnectDB QuerySuppMailList= new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
        switch (QuerySuppMailList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  ReturnResult = new String[1][1];
                  ReturnResult[0][0] = "";
                  break;
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  ReturnResult = QuerySuppMailList.GetReturnArray();
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


    private void sendMailToUndr(String in_dpt_cde, String in_emp_type, String doc_no)
        throws com.mcip.orb.CoException {
        boolean result=false;

	      String[][] undr_email = getSuppEmailList(in_dpt_cde, in_emp_type);
	      if ((undr_email == null) || (undr_email[0][0].length()==0))
            return;

        Connection l_conn = l_pm.getConnection(l_dbname);
	      int mailarray_len = undr_email.length;
	      try{
	          for (int i = 1; i < mailarray_len ; i++){
              String tmp_string = Constant.EMAIL_CNTNT_1 + "\n\n" + doc_no + "\n\n" + Constant.WEBSITE_ADDRESS;
		          Mail omail=new Mail(Constant.ORG_EMAIL_ADDRESS,undr_email[i][6],Constant.EMAIL_TITLE_1,tmp_string);
	    	      result = emanager.OnlineMail(omail);
	    	      if (result)
			          System.err.println("mail sending successful");
	    	      else
			          System.err.println("mail sending fail");
	          }
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptCust() --- EMAIL ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptCust() --- EMAIL SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JM_SENDMAILLOOP_ERROR,e.toString ());
        }
        l_pm.freeConnection (l_dbname,l_conn);
	      return;
    }

// Added by YiJF 2001-04-06
// for allow agency & OpenCover user registering from PA18.System_Management
////////////////////////////////////////////////////////
// Use Case 15 :Query Agency Information
////////////////////////////////////////////////////////

    public java.lang.String[][] queryAgencyInfo(String in_agent_cde) throws com.mcip.orb.CoException {

        if ((in_agent_cde==null) || (in_agent_cde.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_AGCUSTINFO;
        String [][] sqlParameters= {{"c_cmpny_agt_cde",in_agent_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB QueryAgentInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryAgentInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_FINDNOREC);
             case Constant.ConnectDB_SelectMulti:
				 break;
				 /*
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
				  */
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "queryAgencyInfo() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryAgentInfo.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Use Case 16 :Query Open Cover User Information
////////////////////////////////////////////////////////

    public java.lang.String[][] queryOCcustInfo(String in_clnt_cde) throws com.mcip.orb.CoException {

        if ((in_clnt_cde==null) || (in_clnt_cde.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_OCCUSTINFO;
        String [][] sqlParameters= {{"c_clnt_cde",in_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB QueryOCcustInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryOCcustInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_FINDNOREC);
             case Constant.ConnectDB_SelectMulti:
				 /*
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC);
				  */
				  break;
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "queryOCcustInfo() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryOCcustInfo.GetReturnArray ();
    }


//////////////////////////////////////////////////////////////////////////
// Use Case 17 :Accept Open Cover user register from PA18.systemManagement
//////////////////////////////////////////////////////////////////////////

  public boolean acceptOCCust(String in_register_mrk, com.mcip.cus.orb.CustOrgn custorgnobj,
                                com.mcip.cus.orb.CustEntity custentityobj)
        throws com.mcip.orb.CoException{

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult =false;
        String s_clnt_code="";
//Check if unique
        if (!checkUnique(custentityobj.c_user_id)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
        }

//Check if Open Cover Customer
        String oc_sqlString = Sqlstmt.SELECT_VALIDOCCUST;
        String [][] oc_sqlParameters = {{"c_clnt_cde",custentityobj.c_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB ValidOC = new ConnectDB (r_conn,oc_sqlString,Constant.executePrepQuery,oc_sqlParameters);
        switch (ValidOC.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_AGT_CLNT_CDE_NOTEXIST);
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

System.out.println(" Open Cover Customer Register in PA18.COM Now.");
//Register in PA18.COM
        try{
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ps.logon(custentityobj.c_user_id, custentityobj.c_user_pw);
            }else{
              ps.register(custentityobj.c_user_id, custentityobj.c_user_pw,Constant.ORGN_FLG);
            }
System.out.println(" Open Cover Customer Register in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Open Cover Customer Register in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ErrorHandling(ExceptionCode.CUST_ERRORIDORPW);
            }else{
              ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
            }
        }

//Add call jni interface here
        try{
            PacketHead ph = new PacketHead(JCConstant.UPDATEORGACUST_PACKET_ID);
            JavaC jc=new JavaC(ph,custorgnobj);
            jc.init();
            jc.JavaCMain();
            s_clnt_code=jc.GetReturnClass().getField("c_clnt_cde").get(jc.GetReturnObj()).toString();
//Add for debug
System.out.println('\n'+"Java call c successfully");
//jtoc.JavaC.DisplayFields(jc.GetReturnObj());
//jc.DisplayFields(jc.GetReturnObj());
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- JAVA CALL C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

//Insert into  t_clnt_map
        String sqlString1 = Sqlstmt.INSERT_CLNTMAP_CLNT;
        String [][] sqlParameters1 =
              {{"c_user_id",        custentityobj.c_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",       s_clnt_code,                String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_undr_cde",       "system",                   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_main_flg",       Constant.MAIN_MRK,          String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertClntMap= new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);

        switch (InsertClntMap.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_user
//  Modified by YiJF 2001-04-05 for user accept test, it should be original(USER_NOT_VERIFY)
//        custentityobj.c_verify = Constant.USER_NOT_VERIFY;
        custentityobj.c_verify = Constant.OPENCVR_VERIFIED;
        custentityobj.c_net_id = Constant.PA18_NET_CDE;
        String sqlString2 =Sqlstmt.INSERT_ACPTCUST;
        String [][] sqlParameters2=
              {{"c_crt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_upd_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",custentityobj.c_user_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_name",custentityobj.c_user_name,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_question",custentityobj.c_pw_question,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_result",custentityobj.c_pw_result,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_user_seq_no",String.valueOf(custentityobj.n_user_seq_no),String.valueOf(Constant.INT_TYPE)},
               {"c_verify",String.valueOf(custentityobj.c_verify),String.valueOf(Constant.CHAR_TYPE)},
               {"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_net_cde",custentityobj.c_net_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_dpt_cde",custorgnobj.c_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_nme",custorgnobj.c_clnt_nme,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_mrk",Constant.ORGN_FLG,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_email",custorgnobj.c_email,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertUser= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (InsertUser.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//        sendMailToUndr(custorgnobj.c_dpt_cde, Constant.CUST_UNDR, custentityobj.c_user_id);
        new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "acceptOrgaCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }


//////////////////////////////////////////////////////////////////////////
// Use Case 18 :Accept Agent user register from PA18.systemManagement
//////////////////////////////////////////////////////////////////////////

  public boolean acceptAGCust(String in_register_mrk, com.mcip.cus.orb.CustOrgn custorgnobj,
                                com.mcip.cus.orb.CustEntity custentityobj)
        throws com.mcip.orb.CoException{

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult =false;
        String s_clnt_code="";
//Check if unique
        if (!checkUnique(custentityobj.c_user_id)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
        }

//Check if Agency
        String agt_sqlString = Sqlstmt.SELECT_VALIDAGENT;
        String [][] agt_sqlParameters = {{"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB ValidAgent = new ConnectDB (r_conn,agt_sqlString,Constant.executePrepQuery,agt_sqlParameters);
        switch (ValidAgent.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.CUST_AGT_CLNT_CDE_NOTEXIST);
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

System.out.println(" Agent Customer Register in PA18.COM Now.");
//Register in PA18.COM
        try{
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ps.logon(custentityobj.c_user_id, custentityobj.c_user_pw);
            }else{
              ps.register(custentityobj.c_user_id, custentityobj.c_user_pw,Constant.ORGN_FLG);
            }
System.out.println(" Agent Customer Register in PA18.COM Successfully! ");
        }catch(Exception e){
System.out.println(" Agent Customer Register in PA18.COM FAIL! "+ e.getMessage());
            new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- account already exist ! Duplicate ! CUST_DUPLICATECLNTID!");
            l_pm.freeConnection (l_dbname,l_conn);
            if (in_register_mrk.equals(Constant.REGISTERED_MRK)){
              ErrorHandling(ExceptionCode.CUST_ERRORIDORPW);
            }else{
              ErrorHandling(ExceptionCode.CUST_DUPLICATECLNTID);
            }
        }

//Add call jni interface here
        try{
            PacketHead ph = new PacketHead(JCConstant.ACCEPTORGACUST_PACKET_ID);
            JavaC jc=new JavaC(ph,custorgnobj);
            jc.init();
            jc.JavaCMain();
            s_clnt_code=jc.GetReturnClass().getField("c_clnt_cde").get(jc.GetReturnObj()).toString();
//Add for debug
System.out.println('\n'+"Java call c successfully");
//jtoc.JavaC.DisplayFields(jc.GetReturnObj());
//jc.DisplayFields(jc.GetReturnObj());
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- JAVA CALL C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
                new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.FAIL_EVENT, "acceptOrgaCust() --- AFTER JAVA CALL C, SYSTEM ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

//Insert into  t_clnt_map
        String sqlString1 = Sqlstmt.INSERT_CLNTMAP_CLNT;
        String [][] sqlParameters1 =
              {{"c_user_id",        custentityobj.c_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",       s_clnt_code,                String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_undr_cde",       "system",                   String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_main_flg",       Constant.MAIN_MRK,          String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertClntMap= new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);

        switch (InsertClntMap.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//Insert into  t_pa18_user
//  Modified by YiJF 2001-04-05 for user accept test, it should be original(USER_NOT_VERIFY)
//        custentityobj.c_verify = Constant.USER_NOT_VERIFY;
        custentityobj.c_verify = Constant.AGENT_VERIFIED;
        custentityobj.c_net_id = Constant.PA18_NET_CDE;
        String sqlString2 =Sqlstmt.INSERT_ACPTCUST;
        String [][] sqlParameters2=
              {{"c_crt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_upd_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_id",custentityobj.c_user_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_name",custentityobj.c_user_name,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_question",custentityobj.c_pw_question,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_pw_result",custentityobj.c_pw_result,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_cde",s_clnt_code,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"n_user_seq_no",String.valueOf(custentityobj.n_user_seq_no),String.valueOf(Constant.INT_TYPE)},
               {"c_verify",String.valueOf(custentityobj.c_verify),String.valueOf(Constant.CHAR_TYPE)},
               {"c_cmpny_agt_cde",custentityobj.c_cmpny_agt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_net_cde",custentityobj.c_net_id,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_dpt_cde",custorgnobj.c_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_nme",custorgnobj.c_clnt_nme,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_clnt_mrk",Constant.ORGN_FLG,String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_email",custorgnobj.c_email,String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB InsertUser= new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

        switch (InsertUser.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

//        sendMailToUndr(custorgnobj.c_dpt_cde, Constant.CUST_UNDR, custentityobj.c_user_id);
        new ConnectDB(l_conn).WriteDBLog(l_conn, custentityobj.c_user_id, Constant.LOG_CUSTREGIST, Constant.SUCCESS_EVENT, "acceptOrgaCust() --- SUCCESSFULLY!");
        ReturnResult =true;
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }


          //Author 康进
          //Purpose:删除用户功能
          //Date:2001-09-14
          //ID:2001091401
          /*begin of add 2001091401*/
/////////////////////////////////////////////////////////////////////////////////////////////////
// Use Case 19 : Delete the Illegal User                                                       //
/////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean deleteIllegalUser(String in_user_id)
        throws com.mcip.orb.CoException {
        boolean returnResult = false;
        if ((in_user_id==null))
            ErrorHandling(ExceptionCode.CUST_NULLQUERYPARM);

        if ((in_user_id.length()==0))
            ErrorHandling(ExceptionCode.CUST_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String [][] sqlParameters1= {{"c_user_id",    in_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)}};
        String sqlString1 = Sqlstmt.DELETE_ILLEGAL_USER;
        ConnectDB deleteUser= new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdate,sqlParameters1);
        switch (deleteUser.GetReturnCode()) {
             case Constant.ConnectDB_Success:
              returnResult =true;
              break;
             case Constant.ConnectDB_Warning:
              returnResult = true;
                  break;
             default:
              returnResult = false;
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
                  return false;
        }
          r_pm.freeConnection (r_dbname,r_conn);
          l_pm.freeConnection (l_dbname,l_conn);
          return returnResult;
          }
  }
          /*end of add 2001091401*/
//throw new CoException("0001", "User does not have the right to view agent's info", "", "");
//this.exHandler.raiseCoException(ExceptionCode.NOT_SUBORDINATE);

