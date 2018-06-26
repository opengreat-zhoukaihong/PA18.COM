////////////////////////////////////////////////////////
// Author:     YI JIN FENG
// Update Date:2000/8/16
// Update Date:2000/12/26 Add acceptUserRemark() and deletePolicyApp() function
// Update Date:2000/12/27 update acceptPolicyApp() and updatePolicyApp()
//                        function for return additional underwriting opinion message
// Update Date:2001/01/11 update all connection statement for Dynamically get DB connection BY YiJF
////////////////////////////////////////////////////////

import java.sql.*;
import java.util.*;
import utility.*;
import jtoc.*;
import constant.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.nia.orb.*;
import com.mcip.mail.orb.*;


public class PolicyAppManagerImpl extends _PolicyAppManagerImplBase {
    private static PoolManager r_pm;
    private static PoolManager l_pm;
    private static String r_dbname=Constant.BACKEND_DBNAME;
    private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
    private CoExceptionHandler exHandler;
    private static EmailManager emanager;

    public PolicyAppManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
        super(name);
// connect Remote DB (BackEnd System)
        r_pm = r_poolManager;
//        r_conn = r_pm.getConnection(r_dbname);
// connect Local DB (PA18.COM System)
        l_pm = l_poolManager;
//        l_conn = l_pm.getConnection(l_dbname);

//Add connection with EMAIL CORBA Server
        org.omg.CORBA.ORB email_orb = ORBManager.getORBForClient();
        emanager = EmailManagerHelper.bind(email_orb, "emanager");

//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyAppManagerImp1 get db connection");
        exHandler = new CoExceptionHandler();
    }

    private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyAppManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,null,"PolicyAppManagerImp1");
    }

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyAppManagerImp1 free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"PolicyAppManagerImp1");
    }

//Business Logic for cyber insurance information Application

/////////////////////////////////////////////////////////////////
// Use Case 1 : Accept Policy Application Form or delivery form //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] acceptPolicyApp(com.mcip.nia.orb.PlcyAppInfo in_plcyappinfoobj,java.lang.String[][] in_rdrinfo)
        throws com.mcip.orb.CoException{
 System.out.println("***************************************");
 System.out.println("Begin Accept Policy Application Form");
 System.out.println("***************************************");
        if (in_rdrinfo==null)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
// JavaC.DisplayFields(in_plcyappinfoobj);

        String [][] ReturnResult = new String[2][2];
        String sqlString =Sqlstmt.SELECT_PLYAPPINVC;
        String [][] sqlParameters1= {{"c_invc_no",in_plcyappinfoobj.c_invc_no,String.valueOf(Constant.VARCHAR2_TYPE)},
                                     {"c_receipt_no",in_plcyappinfoobj.c_receipt_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB CheckUnique= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters1);
        switch (CheckUnique.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  break;
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPLY,Constant.FAIL_EVENT,"acceptPolicyApp() InVOICE ALREADY EXIST ----- NIA_INVCEXIST !");
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_INVCEXIST);
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

System.out.println("Begin call JACA USING C.");
//Add by Y.J.F 2000-08-28
//conmented by Y.J.F 2000-11-15
//        in_plcyappinfoobj.c_prm_cur = in_plcyappinfoobj.c_amt_cur;
        in_plcyappinfoobj.c_pay_mde_cde = "01";          // waiting for modify the hard code in the future
//Add by Y.J.F 2000-09-19
        in_plcyappinfoobj.t_app_tm = ConnectDB.GetCurrentTS(2);
//add by kangjin 2001-09-09
		in_plcyappinfoobj.c_mdfy_tm = ConnectDB.GetCurrentTS(2);
		System.out.println("&&&&&&&&&&&&&"+in_plcyappinfoobj.c_mdfy_tm+"&&&&&&&");

//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.ACCEPTPOLICYAPP_PACKET_ID);
            JavaC jc=new JavaC(ph,in_plcyappinfoobj,in_rdrinfo);
            jc.init(in_rdrinfo.length);
            jc.JavaCMain(jc.GetInvctor());
//          ReturnResult=DataUtility.ObjToStringArray(jc.GetReturnvctor().elementAt(3));

// 	      	  	  System.out.println("The Return table have: "+tbr+" Rows!");

            java.lang.Object tempobj=jc.GetReturnvctor().elementAt(2);
            Class tempclass=jc.GetObjClass(tempobj);
            String returncde=tempclass.getField("c_udr_mrk").get(tempobj).toString();

            if (returncde.equals("0")){
                ReturnResult = new String[2][3];
                ReturnResult[0][1]="c_ply_app_no";
                ReturnResult[1][1]=tempclass.getField("c_ply_app_no").get(tempobj).toString();
                ReturnResult[0][2]="c_undr_opn";
                ReturnResult[1][2]=tempclass.getField("c_undr_opn").get(tempobj).toString();
            }

            if (returncde.equals("1")){
                ReturnResult[0][1]="c_ply_no";
                ReturnResult[1][1]=tempclass.getField("c_ply_no").get(tempobj).toString();
            }

            if (returncde.equals("6")){
                String[][] Res= null;
                Res=DataUtility.ObjToStringArray(jc.GetReturnvctor().elementAt(3));
                ReturnResult = new String[2][25];
    	  	      for (int j=0;j <24;j++){
                     ReturnResult[0][j+1]=Res[0][j+4];
                     ReturnResult[1][j+1]=Res[1][j+4];
                }
            }

            ReturnResult[0][0]="c_rtrn_cde";
            ReturnResult[1][0]=returncde;

//Add for debug
//ConnectDB.dispArray (ReturnResult);
System.out.println('\n'+"Java call c successfully");
//jc.DisplayFields(jc.GetReturnvctor().elementAt(0));
//jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPLY,Constant.FAIL_EVENT,"acceptPolicyApp() Java Call C ERROR !");
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPLY,Constant.FAIL_EVENT,"acceptPolicyApp() Java Call C SYSTEM ERROR !");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

        if (ReturnResult[1][0].equals("1")){
            sendMailToUndr(in_plcyappinfoobj.c_dpt_cde, Constant.PLCY_ASSN, ReturnResult[1][1]);
        }else{
            sendMailToUndr(in_plcyappinfoobj.c_dpt_cde, Constant.PLCY_UNDR, ReturnResult[1][1]);
        }
        new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPLY,Constant.SUCCESS_EVENT,"acceptPolicyApp() Policy Successful! Policy Apply No. : "+ReturnResult[1][1]);
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }

/////////////////////////////////////////////////////////////////
// Use Case 2 : Update Policy Application Form                 //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] updatePolicyApp(com.mcip.nia.orb.PlcyAppInfo in_plcyappinfoobj,java.lang.String[][] in_rdrinfo)
        throws com.mcip.orb.CoException{

//        String [][] ReturnResult = null;
        String [][] ReturnResult = new String[2][2];

        if (in_rdrinfo==null)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String sqlString =Sqlstmt.SELECT_PLYAPPENDTM;

        String [][] sqlParameters = {{"c_ply_app_no",in_plcyappinfoobj.c_ply_app_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB PlyAppEndTm = new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (PlyAppEndTm.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC,sqlString);
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        };

// pass values of PlyAppEndTm.GetReturnArray ()[0][1] to in_plcyappinfoobj.t_insrnc_end_tm;
        in_plcyappinfoobj.t_insrnc_end_tm = PlyAppEndTm.GetReturnArray ()[1][0];

System.out.println("Begin call JACA USING C.");
//Add by Y.J.F 2000-08-28
//conmented by Y.J.F 2000-11-15
//        in_plcyappinfoobj.c_prm_cur = in_plcyappinfoobj.c_amt_cur;
        in_plcyappinfoobj.c_pay_mde_cde = "01";          // waiting for modify the hard code in the future

//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.ACCEPTPOLICYAPP_PACKET_ID);
            JavaC jc=new JavaC(ph,in_plcyappinfoobj,in_rdrinfo);
            jc.init(in_rdrinfo.length);
            jc.JavaCMain(jc.GetInvctor());
//          ReturnResult=DataUtility.ObjToStringArray(jc.GetReturnvctor().elementAt(3));

// 	      	  	  System.out.println("The Return table have: "+tbr+" Rows!");

            java.lang.Object tempobj=jc.GetReturnvctor().elementAt(2);
            Class tempclass=jc.GetObjClass(tempobj);
            String returncde=tempclass.getField("c_udr_mrk").get(tempobj).toString();

            if (returncde.equals("0")){
                ReturnResult = new String[2][3];
                ReturnResult[0][1]="c_ply_app_no";
                ReturnResult[1][1]=tempclass.getField("c_ply_app_no").get(tempobj).toString();
                ReturnResult[0][2]="c_undr_opn";
                ReturnResult[1][2]=tempclass.getField("c_undr_opn").get(tempobj).toString();
            }

            if (returncde.equals("1")){
                ReturnResult[0][1]="c_ply_no";
                ReturnResult[1][1]=tempclass.getField("c_ply_no").get(tempobj).toString();
            }

            if (returncde.equals("6")){
                String[][] Res= null;
                Res=DataUtility.ObjToStringArray(jc.GetReturnvctor().elementAt(3));
                ReturnResult = new String[2][25];
    	  	      for (int j=0;j <24;j++){
                     ReturnResult[0][j+1]=Res[0][j+4];
                     ReturnResult[1][j+1]=Res[1][j+4];
                }
            }

            ReturnResult[0][0]="c_rtrn_cde";
            ReturnResult[1][0]=returncde;

//Add for debug
//ConnectDB.dispArray (ReturnResult);
System.out.println('\n'+"Java call c successfully");
//jc.DisplayFields(jc.GetReturnvctor().elementAt(0));
//jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"updatePolicyApp() Java Call C ERROR !");
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"updatePolicyApp() Java Call C ERROR !");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

        if (ReturnResult[1][0].equals("1")){
            sendMailToUndr(in_plcyappinfoobj.c_dpt_cde, Constant.PLCY_ASSN, ReturnResult[1][1]);
        }else{
            sendMailToUndr(in_plcyappinfoobj.c_dpt_cde, Constant.PLCY_UNDR, ReturnResult[1][1]);
        }
        new ConnectDB(l_conn).WriteDBLog(l_conn,in_plcyappinfoobj.c_app_cde,Constant.LOG_PLCYAPPUPD,Constant.SUCCESS_EVENT,"updatePolicyApp() Policy apply form update Successful! Policy Apply No. : "+ReturnResult[1][1]);
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }

/////////////////////////////////////////////////////////////////
// Use Case 3 : Withdrawal Policy Application Form                 //
/////////////////////////////////////////////////////////////////

  public boolean withdrawalPolicyApp(String policyapp_no)
        throws com.mcip.orb.CoException{

        boolean ReturnResult =false;
        Connection l_conn = l_pm.getConnection(l_dbname);

        if (policyapp_no==null) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"withdrawalPolicyApp() NULL POLCILY NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if (policyapp_no.length()==0) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"withdrawalPolicyApp() INVALID POLCILY NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
        }

        plyAppPolyGridStru plyAppPolyGridStruobj = new plyAppPolyGridStru(policyapp_no);
        plyAppPolyGridStruobj.c_ply_app_no = policyapp_no;

        String returncde = null;
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.WITHDRAWALPOLICYAPP_PACKET_ID);

            JavaC jc=new JavaC(ph,plyAppPolyGridStruobj);
            jc.init("0");

            jc.JavaCMain(jc.GetInvctor());
//          java.lang.Object tempobj=jc.GetReturnvctor().elementAt(0);
//          Class tempclass=jc.GetObjClass(tempobj);
//          String returncde=tempclass.getField("cRetCode").get(tempobj).toString();
//          returncde=tempclass.getField("cRetCode").get(tempobj).toString();

//Add for debug
//ConnectDB.dispArray (ReturnResult);
System.out.println('\n'+"Java call c successfully");
//jc.DisplayFields(jc.GetReturnvctor().elementAt(0));
//jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"withdrawalPolicyApp() Java Call C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"withdrawalPolicyApp() Java Call C SYSTEM ERROR !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

        ReturnResult = true;
        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.SUCCESS_EVENT,"withdrawalPolicyApp() Policy withdrawal Successful! ");
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }


/////////////////////////////////////////////////////////////////
// Use Case 4 : Confirm Policy Application Proposal            //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] confirmPolicyAppProposal(String policyapp_no, String dpt_cde, String insrnc_cde, String undr_prsn)
        throws com.mcip.orb.CoException{

        String [][] ReturnResult = new String[2][2];
        Connection l_conn = l_pm.getConnection(l_dbname);

        if ((policyapp_no==null) || (dpt_cde == null) || (insrnc_cde == null)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmPolicyAppProposal() NULL POLICY NUMBER or NULL INSURRANCE TYPE CODE or NULL DEPARTMENT CODE!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if ((policyapp_no.length()==0) || (dpt_cde.length()==0) || (insrnc_cde.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmPolicyAppProposal() INVALID POLICY NUMBER or INVALID INSURRANCE TYPE CODE or INVALID DEPARTMENT CODE!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
        }

// pass values of PlyAppCfmInfo.GetReturnArray () to plyCheckGridStru Object;
        plyCheckGridStru plyCheckGridStruobj = new plyCheckGridStru();
//modified by YJF 0901-2000
        plyCheckGridStruobj.c_ply_app_no = policyapp_no;
        plyCheckGridStruobj.c_insrnc_cde = insrnc_cde;
        plyCheckGridStruobj.c_dpt_cde = dpt_cde;
		//the  following line is created by Kang Jin 2001-08-23
		//for fix the missing undr persion bug
		plyCheckGridStruobj.c_undr_prsn = undr_prsn;
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.CONFIRMPOLICYAPP_PACKET_ID);

            JavaC jc=new JavaC(ph,plyCheckGridStruobj);
            jc.init("0");
            jc.JavaCMain(jc.GetInvctor());
            java.lang.Object tempobj=jc.GetReturnvctor().elementAt(1);
            Class tempclass=jc.GetObjClass(tempobj);
            String returncde=tempclass.getField("c_udr_mrk").get(tempobj).toString();

            ReturnResult[0][0]="c_rtrn_cde";
            ReturnResult[1][0]=returncde;

            ReturnResult[0][1]="c_ply_no";
            ReturnResult[1][1]=tempclass.getField("c_ply_no").get(tempobj).toString();


//Add for debug
//ConnectDB.dispArray (ReturnResult);
System.out.println('\n'+"Java call c successfully");
//jc.DisplayFields(jc.GetReturnvctor().elementAt(0));
//jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmPolicyAppProposal() Java Call C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmPolicyAppProposal() Java Call C SYSTEM ERROR !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.SUCCESS_EVENT,"confirmPolicyAppProposal() Policy apply form's Proposal confirmation Successful! "+ReturnResult[1][1]);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }


///////////////////////////////////////////////////////////////////////////
// Use Case 5 : Accept Customer's advices and remark as confirming proposal
///////////////////////////////////////////////////////////////////////////

  public boolean acceptUserRemark(String policyapp_no, String app_cde, String user_remark, String app_typ)
        throws com.mcip.orb.CoException{

        boolean ReturnResult = false;
        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);

        if ((policyapp_no==null) || (app_cde == null) || (policyapp_no.length()==0) || (app_cde.length()==0) ) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"acceptUserRemark() NULL POLICY APPLY FORM NUMBER or NULL APPLICANT CODE! NIA_INVALID_DOC_NO");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALID_DOC_NO);
        }

        if ((user_remark==null) || (user_remark.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,app_cde,Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"acceptUserRemark() NIA_NULL_USER_REMARK!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULL_USER_REMARK);
        }

//Update t_proposal
        String sqlString =Sqlstmt.UPDATE_USERREMARK;             //SQL
        String [][] sqlParameters =
              {{"c_user_id",    app_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_user_remark",user_remark,  String.valueOf(Constant.VARCHAR2_TYPE)},
               {"c_doc_no",     policyapp_no, String.valueOf(Constant.VARCHAR2_TYPE)}};

        ConnectDB UpdateUserRemark = new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);

        switch (UpdateUserRemark.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        String[][] in_dpt_cde = null;
//Select From T_plyapp for DPT_CDE
        if (app_typ.equals(Constant.PLYAPP_TYPE)) {
            String sqlString1 =Sqlstmt.SELECT_DOCDPTCDE1;             //SQL
            String [][] sqlParameters1 =
              {{"c_ply_app_no",     policyapp_no, String.valueOf(Constant.VARCHAR2_TYPE)}};

            ConnectDB queryDocDptCde1 = new ConnectDB (r_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);

            switch (queryDocDptCde1.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
            }
            in_dpt_cde = queryDocDptCde1.GetReturnArray();
        }else{
            String sqlString2 =Sqlstmt.SELECT_DOCDPTCDE2;             //SQL
            String [][] sqlParameters2 =
              {{"c_edr_app_no",     policyapp_no, String.valueOf(Constant.VARCHAR2_TYPE)}};

            ConnectDB queryDocDptCde2 = new ConnectDB (r_conn,sqlString2,Constant.executePrepQuery,sqlParameters2);

            switch (queryDocDptCde2.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
            }
            in_dpt_cde = queryDocDptCde2.GetReturnArray();
        }

        sendMailToUndr(in_dpt_cde[1][0], Constant.PLCY_UNDR, policyapp_no);
        ReturnResult = true;
        new ConnectDB(l_conn).WriteDBLog(l_conn,app_cde,Constant.LOG_PRPSLCNFM,Constant.SUCCESS_EVENT,"acceptUserRemark() Accept Customer's advices and remark Successful! ");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }


/////////////////////////////////////////////////////////////////
// Use Case 6 : delete Policy Application Form                 //
/////////////////////////////////////////////////////////////////

  public boolean deletePolicyApp(String policyapp_no)
        throws com.mcip.orb.CoException{

        boolean ReturnResult =false;
        Connection l_conn = l_pm.getConnection(l_dbname);

        if (policyapp_no==null) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"deletePolicyApp() NULL POLCILY Apply Form NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if (policyapp_no.length()==0) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"deletePolicyApp() INVALID POLCILY Apply Form NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
        }

        plyAppPolyGridStru plyAppPolyGridStruobj = new plyAppPolyGridStru(policyapp_no);
        plyAppPolyGridStruobj.c_ply_app_no = policyapp_no;

        String returncde = null;
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.DELETEPOLICYAPP_PACKET_ID);

            JavaC jc=new JavaC(ph,plyAppPolyGridStruobj);
            jc.init("0");

            jc.JavaCMain(jc.GetInvctor());
//          java.lang.Object tempobj=jc.GetReturnvctor().elementAt(0);
//          Class tempclass=jc.GetObjClass(tempobj);
//          String returncde=tempclass.getField("cRetCode").get(tempobj).toString();
//          returncde=tempclass.getField("cRetCode").get(tempobj).toString();

//Add for debug
//ConnectDB.dispArray (ReturnResult);
System.out.println('\n'+"Java call c successfully");
//jc.DisplayFields(jc.GetReturnvctor().elementAt(0));
//jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"deletePolicyApp() Java Call C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.FAIL_EVENT,"deletePolicyApp() Java Call C SYSTEM ERROR !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }

        ReturnResult = true;
        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYAPPUPD,Constant.SUCCESS_EVENT,"deletePolicyApp() Policy apply form delete Successful! ");
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
        String tmp_string = new String("");
        if (in_emp_type.equals(Constant.PLCY_UNDR)){
            tmp_string = Constant.EMAIL_CNTNT_2 + "\n\n" + doc_no + "\n\n" + Constant.WEBSITE_ADDRESS;
        }else{
            tmp_string = Constant.EMAIL_CNTNT_3 + "\n\n" + doc_no + "\n\n" + Constant.WEBSITE_ADDRESS;
        }
        Mail omail = null;
	      try{
	          for (int i = 1; i < mailarray_len ; i++){
              if (in_emp_type.equals(Constant.PLCY_UNDR)){
		              omail=new Mail(Constant.ORG_EMAIL_ADDRESS,undr_email[i][6],Constant.EMAIL_TITLE_2,tmp_string);
              }else{
		              omail=new Mail(Constant.ORG_EMAIL_ADDRESS,undr_email[i][6],Constant.EMAIL_TITLE_3,tmp_string);
              }
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


///////////////////////////////////////////////////////////////////////////
// Use Case 15 : Update policy form's address table for setting c_pay_flag
///////////////////////////////////////////////////////////////////////////
  public boolean updatePayFlag(String policy_no, String pay_flag, String app_typ)
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


  }
//throw new CoException("0001", "User does not have the right to view agent's info", "", "");
//this.exHandler.raiseCoException(ExceptionCode.NOT_SUBORDINATE);

