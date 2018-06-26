////////////////////////////////////////////////////////
// Author:     YI JIN FENG
// Create Date:2000/09/11 for Policy Case Report
//             2000/10/26 Added for Policy Endorsement
//Modified Date:2001-10-31
//				Ref:LK0001
//				Purpose:wipe the unnecessary "System.out.println()"
//Modified Date:2001-10-31
//				Ref:LK0002
//				Purpose:add the time stamp information to the output
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


public class PolicyManagerImpl extends _PolicyManagerImplBase {
    private static PoolManager r_pm;
    private static PoolManager l_pm;
    private static String r_dbname=Constant.BACKEND_DBNAME;
    private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
    private CoExceptionHandler exHandler;
    private static EmailManager emanager;

    public PolicyManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
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
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyManagerImpl get db connection");
        exHandler = new CoExceptionHandler();
    }

    private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyManagerImpl free db connection");
        this.exHandler.raiseCoException(ExceptionCode,null,"PolicyManagerImp1");
    }

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyManagerImpl free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"PolicyManagerImp1");
    }

//Business Logic for cyber insurance information Application

/////////////////////////////////////////////////////////////////
// Use Case 1 : Accept Policy Case Report via WEB              //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] acceptCaseRpt(com.mcip.nia.orb.CaseRptInfo in_caserptinfoobj)
        throws com.mcip.orb.CoException{
        Connection l_conn = l_pm.getConnection(l_dbname);
        String [][] ReturnResult = new String[2][1];
        String s_caserpt_no;

//Add by Y.J.F 2000-09-11
        in_caserptinfoobj.t_rpt_mdfy_tm = "";
        in_caserptinfoobj.c_internet_typ = "1";          // waiting for modify the hard code in the future
//Add by Y.J.F 2000-09-18
        in_caserptinfoobj.t_rtp_tm = ConnectDB.GetCurrentTS(1);
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.ACCEPTCASEREPORT_PACKET_ID);
            JavaC jc=new JavaC(ph,in_caserptinfoobj);
            jc.init();
            jc.JavaCMain();
            s_caserpt_no=jc.GetReturnClass().getField("c_rpt_no").get(jc.GetReturnObj()).toString();
            ReturnResult[0][0]="c_rpt_no";
            ReturnResult[1][0]=s_caserpt_no;
        }catch (com.mcip.orb.CoException e) {
			/*LK0002+B*/
			StringTool.errorDetail(e);
			/*LK0002+E*/
            new ConnectDB(l_conn).WriteDBLog(l_conn,in_caserptinfoobj.c_rpt_nme, Constant.LOG_CASEREPORT, Constant.FAIL_EVENT, "acceptCaseRpt() --- Java call C ERROR");
            l_pm.freeConnection (l_dbname,l_conn);
            throw e;
        }catch(Exception e){
			/*LK0002+B*/
			StringTool.errorDetail(e);
			/*LK0002+E*/
            new ConnectDB(l_conn).WriteDBLog(l_conn,in_caserptinfoobj.c_rpt_nme, Constant.LOG_CASEREPORT, Constant.FAIL_EVENT, "acceptCaseRpt() --- Java call C SYSTEM ERROR");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }


        sendMailToUndr(in_caserptinfoobj.c_dpt_cde, Constant.CASE_UNDR, ReturnResult[1][0]);

        new ConnectDB(l_conn).WriteDBLog(l_conn,in_caserptinfoobj.c_rpt_nme,Constant.LOG_CASEREPORT,Constant.SUCCESS_EVENT,"acceptCaseRpt() --- Case Report Successful! Case Report No. : "+ReturnResult[1][0]);

        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
      }



/////////////////////////////////////////////////////////////////
// Use Case 2 : Accept Policy Endorsement Application Form //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] acceptPolicyEdr(com.mcip.nia.orb.PlyEdrAppInfo in_plyedrappinfoobj, com.mcip.nia.orb.PlyEdrAppCrgoInfo in_plyedrappcrgoinfoobj,
               java.lang.String[][] in_rdrinfo, com.mcip.nia.orb.PlyEdrAppPayInfo in_plyedrapppayinfoobj, com.mcip.nia.orb.PlyPlyAppNetInfo in_plyplyappnetinfoobj)
        throws com.mcip.orb.CoException{

        Connection l_conn = l_pm.getConnection(l_dbname);
        String [][] ReturnResult = new String[2][2];

//Add by Y.J.F 2000-10-26
        in_plyedrappinfoobj.t_edr_app_tm = ConnectDB.GetCurrentTS(2);
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.ADDPOLICYEDR_PACKET_ID);
            JavaC jc=new JavaC(ph, in_plyedrappinfoobj, in_plyedrappcrgoinfoobj, in_rdrinfo, in_plyedrapppayinfoobj, in_plyplyappnetinfoobj);
            jc.init(in_rdrinfo.length,0);
            jc.JavaCMain(jc.GetInvctor());
            java.lang.Object tempobj=jc.GetReturnvctor().elementAt(2);
            Class tempclass=jc.GetObjClass(tempobj);
            String returncde=tempclass.getField("c_udr_mrk").get(tempobj).toString();

            if (returncde.equals("0")){
                ReturnResult = new String[2][3];
                ReturnResult[0][1]="c_edr_app_no";
                ReturnResult[1][1]=tempclass.getField("c_edr_app_no").get(tempobj).toString();
                ReturnResult[0][2]="c_undr_opn";
                ReturnResult[1][2]=tempclass.getField("c_undr_opn").get(tempobj).toString();
            }

            if (returncde.equals("1")){
                ReturnResult[0][1]="c_edr_no";
                ReturnResult[1][1]=tempclass.getField("c_edr_no").get(tempobj).toString();
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
        }catch (com.mcip.orb.CoException e) {
			/*LK0002+B*/
			StringTool.errorDetail(e);
			/*LK0002+E*/
                new ConnectDB(l_conn).WriteDBLog(l_conn,in_plyedrappinfoobj.c_app_cde,Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"acceptPolicyEdr() Java call c ERROR !!");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
			/*LK0002+B*/
			StringTool.errorDetail(e);
			/*LK0002+E*/
            new ConnectDB(l_conn).WriteDBLog(l_conn,in_plyedrappinfoobj.c_app_cde,Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"acceptPolicyEdr() Java call c ERROR ERROR !!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }
        sendMailToUndr(in_plyedrappinfoobj.c_dpt_cde, Constant.PLCY_UNDR, ReturnResult[1][0]);

        new ConnectDB(l_conn).WriteDBLog(l_conn,in_plyedrappinfoobj.c_app_cde,Constant.LOG_PLCYENDORSE,Constant.SUCCESS_EVENT,"acceptPolicyEdr() Policy Endorse Apply Successful! Policy EDR Apply No. : "+ReturnResult[1][0]);

        l_pm.freeConnection (l_dbname,l_conn);

        return ReturnResult;
      }



/////////////////////////////////////////////////////////////////////
// Use Case 3 : Get Policy Information for Endorsement Application //
/////////////////////////////////////////////////////////////////////

  public void getPolicyEdr(com.mcip.nia.orb.PlyGetDocInfo in_plygetdocinfoobj, org.omg.CORBA.AnyHolder plyedrappHolder, org.omg.CORBA.AnyHolder plyedrappcrgoHolder,
                           org.omg.CORBA.AnyHolder plyedrapprdrHolder, org.omg.CORBA.AnyHolder plyedrapppayHolder, org.omg.CORBA.AnyHolder plyplyappnetHolder)
        throws com.mcip.orb.CoException{
        Connection l_conn = l_pm.getConnection(l_dbname);
//Add by Y.J.F 2000-10-26
        in_plygetdocinfoobj.c_prn_typ = "1";
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.GETPOLICYFOREDR_PACKET_ID);
            JavaC jc=new JavaC(ph, in_plygetdocinfoobj);
            jc.init();
            jc.JavaCMain(jc.GetInvctor());
//          ReturnResult=DataUtility.ObjToStringArray(jc.GetReturnvctor().elementAt(3));
/*
            java.lang.Object tempobj=jc.GetReturnvctor().elementAt(2);
            Class tempclass=jc.GetObjClass(tempobj);
            String returncde=tempclass.getField("c_udr_mrk").get(tempobj).toString();
            ReturnResult[0][0]="c_rtrn_cde";
            ReturnResult[1][0]=returncde;
*/

// get & return Policy main Information Object
            PlyEdrAppInfo plyedrappinfoobj = new PlyEdrAppInfo();
            jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(2), plyedrappinfoobj);
            Any outPlyEdrAppInfo = _orb().create_any();
            plyedrappHolder.value = outPlyEdrAppInfo;
            PlyEdrAppInfoHelper.insert(outPlyEdrAppInfo, plyedrappinfoobj);

// get & return Policy cargo Information Object
            PlyEdrAppCrgoInfo plyedrappcrgoinfoobj = new PlyEdrAppCrgoInfo();
            jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(3), plyedrappcrgoinfoobj);
            Any outPlyEdrAppCrgoInfo = _orb().create_any();
            plyedrappcrgoHolder.value = outPlyEdrAppCrgoInfo;
            PlyEdrAppCrgoInfoHelper.insert(outPlyEdrAppCrgoInfo, plyedrappcrgoinfoobj);
// get & return Policy payment Information Object
            PlyEdrAppPayInfo plyedrapppayinfoobj = new PlyEdrAppPayInfo();
            jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(4), plyedrapppayinfoobj);
            Any outPlyEdrAppPayInfo = _orb().create_any();
            plyedrapppayHolder.value = outPlyEdrAppPayInfo;
            PlyEdrAppPayInfoHelper.insert(outPlyEdrAppPayInfo, plyedrapppayinfoobj);
// get & return Policy deliverying Information Object
            PlyPlyAppNetInfo plyplyappnetinfoobj = new PlyPlyAppNetInfo("","","","","","","","","","","","","","","","","","",
                                                                        "","","","","","","","","","","","","","","");
            if (jc.GetNetObjFlag())
              jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(5), plyplyappnetinfoobj);
            Any outPlyPlyAppNetInfo = _orb().create_any();
            plyplyappnetHolder.value = outPlyPlyAppNetInfo;
            PlyPlyAppNetInfoHelper.insert(outPlyPlyAppNetInfo, plyplyappnetinfoobj);
// get & return Policy rdr Information Array
            PlyEdrAppRdrInfo plyedrapprdrinfoobj = new PlyEdrAppRdrInfo();
// get return Policy Rdr Array
            plyedrapprdrinfoobj.edrapprdr = jc.GetReturnRdr();
            Any outPlyEdrAppRdrInfo = _orb().create_any();
            plyedrapprdrHolder.value = outPlyEdrAppRdrInfo;
            PlyEdrAppRdrInfoHelper.insert(outPlyEdrAppRdrInfo, plyedrapprdrinfoobj);

//Add for debug
//ConnectDB.dispArray (plyedrapprdrinfoobj.edrapprdr);
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"getPolicyEdr() Java call c ERROR !!");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"getPolicyEdr() Java call c ERROR ERROR !!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString());
        }


        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.SUCCESS_EVENT,"getPolicyEdr() Get Policy Info for Endorse Apply Successful! Policy Number :"+in_plygetdocinfoobj.c_doc_no);

        l_pm.freeConnection (l_dbname,l_conn);

        return;

      }


/////////////////////////////////////////////////////////////////
// Use Case 4 : Withdrawal Policy endorsement application Form //
/////////////////////////////////////////////////////////////////

  public boolean withdrawalEdrApp(String edr_app_no)
        throws com.mcip.orb.CoException{

        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult =false;

        if (edr_app_no==null) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"withdrawalEdrApp() NULL Endorse Apply NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if (edr_app_no.length()==0) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"withdrawalEdrApp() INVALID endorse Apply NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
        }

        plyEdrGridStru plyEdrGridStruobj = new plyEdrGridStru(edr_app_no);
        plyEdrGridStruobj.c_edr_app_no = edr_app_no;

        String returncde = null;
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.WITHDRAWALPLYFOREDR_PACKET_ID);

            JavaC jc=new JavaC(ph,plyEdrGridStruobj);
            jc.init("0");

            jc.JavaCMain(jc.GetInvctor());
//          java.lang.Object tempobj=jc.GetReturnvctor().elementAt(0);
//          Class tempclass=jc.GetObjClass(tempobj);
//          String returncde=tempclass.getField("cRetCode").get(tempobj).toString();
//          returncde=tempclass.getField("cRetCode").get(tempobj).toString();
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"withdrawalEdrApp() Java Call C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"withdrawalEdrApp() Java Call C SYSTEM ERROR !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }


        ReturnResult = true;
        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.SUCCESS_EVENT,"withdrawalEdrApp() Endorse Apply Form withdrawal Successful! ");
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }


//////////////////////////////////////////////////////////////////////////////////////////////
// Use Case 5 : Get updating Policy Endorsement Application information from BackEnd System //
//////////////////////////////////////////////////////////////////////////////////////////////

  public void getEdrAppInfo(com.mcip.nia.orb.PlyEdrGridInfo in_plyedrgridinfoobj, org.omg.CORBA.AnyHolder plyedrappHolder, org.omg.CORBA.AnyHolder plyedrappcrgoHolder,
                           org.omg.CORBA.AnyHolder plyedrapprdrHolder, org.omg.CORBA.AnyHolder plyedrapppayHolder, org.omg.CORBA.AnyHolder plyplyappnetHolder)
        throws com.mcip.orb.CoException{
        Connection l_conn = l_pm.getConnection(l_dbname);
//Add by Y.J.F 2000-11-15
//        in_plyedrgridinfoobj.c_prn_typ = "1";
        try{

            PacketHead ph = new PacketHead(JCConstant.GETEDRAPPINFO_PACKET_ID);
            JavaC jc=new JavaC(ph, in_plyedrgridinfoobj);
            jc.init("0");                         // for init Body Info Object
            jc.JavaCMain(jc.GetInvctor());
// get & return Policy main Information Object
            PlyEdrAppInfo plyedrappinfoobj = new PlyEdrAppInfo();
            jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(3), plyedrappinfoobj);
            Any outPlyEdrAppInfo = _orb().create_any();
            plyedrappHolder.value = outPlyEdrAppInfo;
            PlyEdrAppInfoHelper.insert(outPlyEdrAppInfo, plyedrappinfoobj);


// get & return Policy cargo Information Object
            PlyEdrAppCrgoInfo plyedrappcrgoinfoobj = new PlyEdrAppCrgoInfo();
            jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(4), plyedrappcrgoinfoobj);
            Any outPlyEdrAppCrgoInfo = _orb().create_any();
            plyedrappcrgoHolder.value = outPlyEdrAppCrgoInfo;
            PlyEdrAppCrgoInfoHelper.insert(outPlyEdrAppCrgoInfo, plyedrappcrgoinfoobj);
// get & return Policy rdr Information Array
            PlyEdrAppRdrInfo plyedrapprdrinfoobj = new PlyEdrAppRdrInfo();
// get return Policy Rdr Array
            plyedrapprdrinfoobj.edrapprdr = jc.GetReturnRdr();
            Any outPlyEdrAppRdrInfo = _orb().create_any();
            plyedrapprdrHolder.value = outPlyEdrAppRdrInfo;
            PlyEdrAppRdrInfoHelper.insert(outPlyEdrAppRdrInfo, plyedrapprdrinfoobj);
// get & return Policy payment Information Object
            PlyEdrAppPayInfo plyedrapppayinfoobj = new PlyEdrAppPayInfo();
            jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(5), plyedrapppayinfoobj);
            Any outPlyEdrAppPayInfo = _orb().create_any();
            plyedrapppayHolder.value = outPlyEdrAppPayInfo;
            PlyEdrAppPayInfoHelper.insert(outPlyEdrAppPayInfo, plyedrapppayinfoobj);
// get & return Policy deliverying Information Object
            PlyPlyAppNetInfo plyplyappnetinfoobj = new PlyPlyAppNetInfo("","","","","","","","","","","","","","","","","","",
                                                                        "","","","","","","","","","","","","","","");
            if (jc.GetNetObjFlag())
              jc.SetRefobj_Mapto_inobj(jc.GetReturnvctor().elementAt(6), plyplyappnetinfoobj);
            Any outPlyPlyAppNetInfo = _orb().create_any();
            plyplyappnetHolder.value = outPlyPlyAppNetInfo;
            PlyPlyAppNetInfoHelper.insert(outPlyPlyAppNetInfo, plyplyappnetinfoobj);
//Add for debug
//ConnectDB.dispArray (plyedrapprdrinfoobj.edrapprdr);
//jc.DisplayFields(jc.GetReturnvctor().elementAt(1));
        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"getEdrAppInfo() Java call c ERROR !!");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"getEdrAppInfo() Java call c ERROR ERROR !!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString());
        }


        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.SUCCESS_EVENT,"getEdrAppInfo() Get Endorse Apply Info for Update Successful! EdrApp Number :"+in_plyedrgridinfoobj.c_edr_app_no);

        l_pm.freeConnection (l_dbname,l_conn);


        return;

      }



/////////////////////////////////////////////////////////////////
// Use Case 6 : Confirm endorsement Application Proposal       //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] confirmEdrAppProposal(String edrapp_no, String dpt_cde, String insrnc_cde)
        throws com.mcip.orb.CoException{

        Connection l_conn = l_pm.getConnection(l_dbname);
        String [][] ReturnResult = new String[2][2];

        if ((edrapp_no==null) || (dpt_cde == null) || (insrnc_cde == null)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmEdrAppProposal() NULL EDR APP NUMBER or NULL INSURRANCE TYPE CODE or NULL DEPARTMENT CODE!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if ((edrapp_no.length()==0) || (dpt_cde.length()==0) || (insrnc_cde.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmEdrAppProposal() INVALID EDR APP NUMBER or INVALID INSURRANCE TYPE CODE or INVALID DEPARTMENT CODE!");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
        }

// pass values of PlyAppCfmInfo.GetReturnArray () to plyCheckGridStru Object;
        plyCheckGridStru plyCheckGridStruobj = new plyCheckGridStru();
//modified by YJF 0901-2000
        plyCheckGridStruobj.c_ply_app_no = edrapp_no;
        plyCheckGridStruobj.c_insrnc_cde = insrnc_cde;
        plyCheckGridStruobj.c_dpt_cde = dpt_cde;

//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.CONFIRMPOLICYAPP_PACKET_ID);

            JavaC jc=new JavaC(ph,plyCheckGridStruobj);
            jc.SetConfirmEdr();             // different from plyapp proposal confirm situation
            jc.init("0");
            jc.JavaCMain(jc.GetInvctor());
            java.lang.Object tempobj=jc.GetReturnvctor().elementAt(1);
            Class tempclass=jc.GetObjClass(tempobj);
            String returncde=tempclass.getField("c_udr_mrk").get(tempobj).toString();

            ReturnResult[0][0]="c_rtrn_cde";
            ReturnResult[1][0]=returncde;

            ReturnResult[0][1]="c_edr_no";
            ReturnResult[1][1]=tempclass.getField("c_edr_no").get(tempobj).toString();


        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmEdrAppProposal() Java Call C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.FAIL_EVENT,"confirmEdrAppProposal() Java Call C SYSTEM ERROR !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }


        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PRPSLCNFM,Constant.SUCCESS_EVENT,"confirmEdrAppProposal() Edr apply form's Proposal confirmation Successful! "+ReturnResult[1][1]);

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
        if (in_emp_type.equals(Constant.CASE_UNDR)){
            tmp_string = Constant.EMAIL_CNTNT_4 + "\n\n" + doc_no + "\n\n" + Constant.WEBSITE_ADDRESS;
        }else{
            tmp_string = Constant.EMAIL_CNTNT_5 + "\n\n" + doc_no + "\n\n" + Constant.WEBSITE_ADDRESS;
        }
	      try{
            Mail omail = null;
	          for (int i = 1; i < mailarray_len ; i++){
              if (in_emp_type.equals(Constant.CASE_UNDR)){
		              omail=new Mail(Constant.ORG_EMAIL_ADDRESS,undr_email[i][6],Constant.EMAIL_TITLE_4,tmp_string);
              }else{
		              omail=new Mail(Constant.ORG_EMAIL_ADDRESS,undr_email[i][6],Constant.EMAIL_TITLE_5,tmp_string);
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


/////////////////////////////////////////////////////////////////
// Use Case 15 : Cancel or delete Policy endorsement application Form //
/////////////////////////////////////////////////////////////////

  public boolean deleteEdrApp(String edr_app_no)
        throws com.mcip.orb.CoException{

        Connection l_conn = l_pm.getConnection(l_dbname);
        boolean ReturnResult =false;

        if (edr_app_no==null) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"deleteEdrApp() NULL Endorse Apply NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if (edr_app_no.length()==0) {
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"deleteEdrApp() INVALID endorse Apply NUMBER !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
        }

        plyEdrGridStru plyEdrGridStruobj = new plyEdrGridStru(edr_app_no);
        plyEdrGridStruobj.c_edr_app_no = edr_app_no;

        String returncde = null;
//Add call jni interface here
        try{

            PacketHead ph = new PacketHead(JCConstant.DELETEPLYFOREDR_PACKET_ID);

            JavaC jc=new JavaC(ph,plyEdrGridStruobj);
            jc.init("0");
            jc.JavaCMain(jc.GetInvctor());

//          java.lang.Object tempobj=jc.GetReturnvctor().elementAt(0);
//          Class tempclass=jc.GetObjClass(tempobj);
//          String returncde=tempclass.getField("cRetCode").get(tempobj).toString();
//          returncde=tempclass.getField("cRetCode").get(tempobj).toString();

        }catch (com.mcip.orb.CoException e) {
                new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"deleteEdrApp() Java Call C ERROR !");
                l_pm.freeConnection (l_dbname,l_conn);
                throw e;
        }catch(Exception e){
            new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.FAIL_EVENT,"deleteEdrApp() Java Call C SYSTEM ERROR !");
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.JC_GENERAL_ERROR,e.toString ());
        }


        ReturnResult = true;
        new ConnectDB(l_conn).WriteDBLog(l_conn,"system",Constant.LOG_PLCYENDORSE,Constant.SUCCESS_EVENT,"deleteEdrApp() Endorse Apply Form withdrawal Successful! ");
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;

      }






  }

