////////////////////////////////////////////////////////
// Author:     YiJF
// Update Date:2000/8/10
// ##############
//Ref:LK0001
//Purpose: add policy print function
//Date: 2001-11-27 10:28:56
////////////////////////////////////////////////////////

import java.sql.*;
import java.util.*;
import utility.*;
import constant.*;
import jtoc.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.nia.orb.*;


public class PolicyInfoManagerImpl extends _PolicyInfoManagerImplBase {
    private static PoolManager r_pm;
    private static PoolManager l_pm;
    private static String r_dbname=Constant.BACKEND_DBNAME;
    private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
    private CoExceptionHandler exHandler;

    public PolicyInfoManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
        super(name);
// connect Remote DB (BackEnd System)
        r_pm = r_poolManager;
//        r_conn = r_pm.getConnection(r_dbname);
// connect Local DB (PA18.COM System)
        l_pm = l_poolManager;
//        l_conn = l_pm.getConnection(l_dbname);

//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyInfoManagerImpl get db connection");
        exHandler = new CoExceptionHandler();
    }

// Errorhandling
    private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection(r_dbname,r_conn);
//        l_pm.freeConnection(l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyInfoManagerImpl free db connection");
        this.exHandler.raiseCoException(ExceptionCode,null,"PolicyInfoManagerImpl",Constant.WARNING);
    }

// Errorhandling
    private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection(r_dbname,r_conn);
//        l_pm.freeConnection(l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyInfoManagerImpl free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"PolicyInfoManagerImpl",Constant.WARNING);
    }

// Errorhandling
    private void ErrorHandling(String ExceptionCode,String ExceptionDesc,String ExceptionField)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection(r_dbname,r_conn);
//        l_pm.freeConnection(l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyInfoManagerImpl free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,ExceptionField,Constant.WARNING);
    }

// Errorhandling
    private void ErrorHandling(String ExceptionCode,String ExceptionDesc,String ExceptionField,String ExceptionSeverity)
           throws com.mcip.orb.CoException   {
//        r_pm.freeConnection(r_dbname,r_conn);
//        l_pm.freeConnection(l_dbname,l_conn);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"PolicyInfoManagerImpl free db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,ExceptionField,ExceptionSeverity);
    }


//Business Logic for cyber insurance information query

////////////////////////////////////////////////////////
// Get Open Cover List                                //
////////////////////////////////////////////////////////
    public String[][] getOCList(String in_user_id,String in_insrnc_cde)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
// get related c_clnt_cde list from t_clnt_map
        String SqlStatement=Sqlstmt.SELECT_CLNTMAP;
        String [][] sqlParameters= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryClntMapList= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
        switch (QueryClntMapList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getOCList",Constant.ERROR);
        };

// Construct the SQL statement for query OC List
        String sqlString =Sqlstmt.SELECT_OPENCOVLIST;    //SQL
        String Plus_String = " ORDER BY A.t_crt_tm DESC";

        int clntarray_len = QueryClntMapList.GetReturnArray().length-1;
        String clnt_sqlString = " AND A.c_clnt_cde IN (";

        for (int i = 0; i < clntarray_len ; i++){
            if ((i-clntarray_len+1)==0)
                clnt_sqlString = clnt_sqlString + "'" + QueryClntMapList.GetReturnArray()[i+1][1] + "'";
            else
                clnt_sqlString = clnt_sqlString + "'" + QueryClntMapList.GetReturnArray()[i+1][1] + "', ";
        }
        sqlString = sqlString + clnt_sqlString + " ) ";    //SQL

        if (in_insrnc_cde.length() > 0) {
            String tmp_sqlString = " AND B.c_insrnc_cde = '"+in_insrnc_cde+"'";
            sqlString = sqlString + tmp_sqlString;
        }

        sqlString = sqlString + Plus_String;
// get related OC list from t_open_cover & t_oc_crgo
        ConnectDB QueryOpenCovList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryOpenCovList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getOCList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryOpenCovList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Open Cover Info                                //
////////////////////////////////////////////////////////
    public String[][] getOCInfo(String in_open_cover_no,String in_insrnc_cde,String in_crgo_cde)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_OPENCOVINFO;

        if ((in_open_cover_no==null) || (in_open_cover_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_insrnc_cde==null) || (in_insrnc_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_crgo_cde==null) || (in_crgo_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_open_cover_no",in_open_cover_no,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                    {"c_insrnc_cde",   in_insrnc_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
                                    {"c_crgo_cde",     in_crgo_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryOpenCovInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryOpenCovInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC,"","getOCInfo",Constant.ERROR);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getOCInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryOpenCovInfo.GetReturnArray ();
    }

////////////////////////////////////////////////////////
// Get Print Format                                //
//LK0001
////////////////////////////////////////////////////////
    public String getPrintFormat(String _inCondStr)
        throws com.mcip.orb.CoException {
		String retStr = null;
		//input parameter validation
        if (_inCondStr==null)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
		try{
			PrintObj pb = new PrintObj(_inCondStr);//construct the input query conditon string
			jtoc.PacketHead ph= new jtoc.PacketHead(jtoc.JCConstant.GETPRINTFMT_PACKET_ID);//construct packet header
			//call c function
			jtoc.JavaC jc=new jtoc.JavaC(ph,pb);
			jc.init();
			jc.JavaCMain();
			retStr = ((PrintObj)jc.GetReturnObj()).condStr;
			//get return object and return
		}catch (Exception e){
			System.out.println(new java.util.Date()+"Error occus when calling c to get print format:"+e);
		}
		return retStr;		
   }
////////////////////////////////////////////////////////
// Get Print Policy                                //
//LK0001
////////////////////////////////////////////////////////
    public String getPrintPolicy(String _inCondStr)
        throws com.mcip.orb.CoException {
		String retStr = null;
		//input parameter validation
        if (_inCondStr==null)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
		try{
			PrintObj pb = new PrintObj(_inCondStr);//construct the input query conditon string
			jtoc.PacketHead ph= new jtoc.PacketHead(jtoc.JCConstant.GETPRINTINFO_PACKET_ID);//construct packet header
			//call c function
			jtoc.JavaC jc=new jtoc.JavaC(ph,pb);
			jc.init();
			jc.JavaCMain();
			retStr = ((PrintObj)jc.GetReturnObj()).condStr;
			//get return object and return
		}catch (Exception e){
			System.out.println(new java.util.Date()+"Error occus when calling c to get print format:"+e);
		}
		return retStr;		
   }

////////////////////////////////////////////////////////
// Get Agency contract List                           //
////////////////////////////////////////////////////////
    public String[][] getAgencyList(String in_clnt_cde,String in_insrnc_cde)
        throws com.mcip.orb.CoException {

        if ((in_clnt_cde==null) || (in_insrnc_cde==null))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_clnt_cde.length()==0) || (in_insrnc_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String sqlString =Sqlstmt.SELECT_AGENCYLIST;
        String [][] sqlParameters= {{"c_clnt_cde",in_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
                                   {"c_insrnc_cde",in_insrnc_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryAgencyList= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryAgencyList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getAgencyList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryAgencyList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get agency contract Information                    //
////////////////////////////////////////////////////////
    public String[][] getAgencyInfo(String in_agt_agr_no,String in_insrnc_cde,String in_crgo_cde, String in_crgo_typ)
        throws com.mcip.orb.CoException {

        boolean input_crgo_cde = true;
        boolean input_crgo_typ = true;

        if ((in_agt_agr_no==null) || (in_agt_agr_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_insrnc_cde==null) || (in_insrnc_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_crgo_cde==null) || (in_crgo_cde.length()==0))
            input_crgo_cde = false;

        if ((in_crgo_typ==null) || (in_crgo_typ.length()==0))
            input_crgo_typ = false;

        if (!input_crgo_cde && !input_crgo_typ)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        String sqlString =Sqlstmt.SELECT_AGENCYINFO + " AND A.c_agt_agr_no = '"+in_agt_agr_no+"' AND B.c_insrnc_cde = '"+in_insrnc_cde+"'";
        if (input_crgo_cde && input_crgo_typ) {
            String tmp_sqlString = " AND( B.c_crgo_cde = '"+in_crgo_cde+"' OR B.c_crgo_cde = '"+in_crgo_typ+"') ORDER BY B.c_crgo_cde";
            sqlString = sqlString + tmp_sqlString;
        }else{
          if (input_crgo_cde) {
              String tmp_sqlString = " AND B.c_crgo_cde = '"+in_crgo_cde+"'";
              sqlString = sqlString + tmp_sqlString;
          }else{
              String tmp_sqlString = " AND B.c_crgo_cde = '"+in_crgo_typ+"'";
              sqlString = sqlString + tmp_sqlString;
          }
        }

        Connection r_conn = r_pm.getConnection(r_dbname);
        ConnectDB QueryAgencyInfo= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryAgencyInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getAgencyInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryAgencyInfo.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Agency Policy Info                             //
////////////////////////////////////////////////////////
    public String[][] getAgencyPlcyList(String in_agt_agr_cde,String in_insrnc_cde, String in_credit_id)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_AGENTPLCYLIST;

        if ((in_agt_agr_cde==null) || (in_insrnc_cde==null))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_agt_agr_cde.length()==0) || (in_insrnc_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_agt_agr_no",in_agt_agr_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
                                    {"c_insrnc_cde",in_insrnc_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
                                    {"c_credit_cde",in_credit_id,String.valueOf(Constant.VARCHAR2_TYPE)}
								   };

//Modify by YJF 2000-Sep 5th as below
/*
        String sqlString =Sqlstmt.SELECT_AGENTPLCYLIST;

        if (in_agt_agr_cde==null)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if (in_agt_agr_cde.length()==0)
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);

        String [][] sqlParameters= {{"c_agt_agr_no",in_agt_agr_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
*/
        ConnectDB QueryAgencyPlcyList= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryAgencyPlcyList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getAgencyPlcyList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryAgencyPlcyList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Cust Policy List                               //
////////////////////////////////////////////////////////
    public String[][] getCustPlcyList(String in_user_id,String in_insrnc_cde, String in_credit_id)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
       // get related c_clnt_cde list from t_clnt_map
        String SqlStatement=Sqlstmt.SELECT_CLNTMAP;
        String [][] sqlParameters= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryClntMapList= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
        switch (QueryClntMapList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCustPlcyList",Constant.ERROR);
        };

// Construct the SQL statement for query customer policy List
        String sqlString =Sqlstmt.SELECT_CUSTPLCYLIST;    //SQL

        int clntarray_len = QueryClntMapList.GetReturnArray().length-1;
        String clnt_sqlString = " AND A.c_app_cde IN (";

        for (int i = 0; i < clntarray_len ; i++){
            if ((i-clntarray_len+1)==0)
                clnt_sqlString = clnt_sqlString + "'" + QueryClntMapList.GetReturnArray()[i+1][1] + "'";
            else
                clnt_sqlString = clnt_sqlString + "'" + QueryClntMapList.GetReturnArray()[i+1][1] + "', ";
        }
        sqlString = sqlString + clnt_sqlString + " )";    //SQL
        sqlString = sqlString +"  AND c_open_cover_no is null ";// added by rao
        if (in_insrnc_cde.length() > 0) {
            String tmp_sqlString = " AND A.c_insrnc_cde = '"+in_insrnc_cde+"'";
            sqlString = sqlString + tmp_sqlString;
        }
		if(in_insrnc_cde.equals(Const.C_EXPORT_CDE)){
		    if(in_credit_id.length()>0){
			  String tmp_sqlString = "  AND B.c_credit_id = '"+in_credit_id+"' ";
              sqlString = sqlString + tmp_sqlString;
			}else{
              sqlString = sqlString + " AND B.c_credit_id = '0' ";
			}
		}

        sqlString = sqlString + " ORDER BY A.t_app_tm DESC";
// get related OC list from t_open_cover & t_oc_crgo
        ConnectDB QueryCustPlcyList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryCustPlcyList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCustPlcyList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryCustPlcyList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Policy Application List                        //
////////////////////////////////////////////////////////
    public String[][] getPolicyAppList(String in_user_id,String in_ply_app,String in_from_tm,String in_to_tm, String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_ply_app=true;
        boolean input_frm_tm=true;
        boolean input_to_tm=true;
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyAppList",Constant.ERROR);
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyAppList",Constant.ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query customer policy List
        String arguString =new String("");    //SQL
//      String sqlString =Sqlstmt.SELECT_PLCYAPPLIST;    //SQL
        String sqlString =Sqlstmt.SELECT_PLCYAPPLIST_UNDR;    //SQL
        //String Plus_String = " GROUP BY A.c_app_cde,A.c_ply_app_no,A.c_insrnc_cde,A.n_amt,A.c_amt_cur,A.t_app_tm,A.c_open_cover_no,B.c_crgo_cde,B.c_crgo_desc,B.c_from_prt,B.c_to_prt,B.c_sail_no,C.c_insrnc_cnm, D.c_cur_sbl, S.c_read_flag ORDER BY A.t_app_tm DESC";
		String Plus_String = " GROUP BY A.c_app_cde,A.c_ply_app_no,A.c_insrnc_cde,A.n_amt,A.c_amt_cur,A.t_upd_tm,A.c_open_cover_no,B.c_crgo_cde,B.c_crgo_desc,B.c_from_prt,B.c_to_prt,B.c_sail_no,B.c_invc_no,B.c_receipt_no,C.c_insrnc_cnm, D.c_cur_sbl, S.c_read_flag ORDER BY A.t_upd_tm DESC";
        if ((in_ply_app==null) || (in_ply_app.length()==0))
            input_ply_app=false;

        if ((in_from_tm==null) || (in_from_tm.length()==0))
            input_frm_tm=false;

        if ((in_to_tm==null) || (in_to_tm.length()==0))
            input_to_tm=false;

        if (input_ply_app) {
            String tmp_sqlString = " AND A.c_ply_app_no = '"+in_ply_app+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_app_tm >= TO_DATE('"+in_from_tm+"', 'YYYY-MM-DD')";
              arguString = arguString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_app_tm <= TO_DATE('"+in_to_tm+"', 'YYYY-MM-DD')+1";
              arguString = arguString + tmp_sqlString;
          }
        }

        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND A.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND A.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString + Plus_String;
// get related Policy application form list from t_plyapp & t_plyappcrgo
        ConnectDB QueryPlyAppList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryPlyAppList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyAppList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryPlyAppList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Policy Application Form Info                   //
////////////////////////////////////////////////////////
    public String[][] getPolicyAppInfo(String in_ply_app_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_PLCYAPPINFO;

        if ((in_ply_app_no==null) ||  (in_ply_app_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_ply_app_no",in_ply_app_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryPolicyAppInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryPolicyAppInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyAppInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryPolicyAppInfo.GetReturnArray ();
    }


////////////////////////////////////////////
// Get Policy List                        //
////////////////////////////////////////////
    public String[][] getPolicyList(String in_user_id,String in_ply_no,String in_from_tm,String in_to_tm, String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_ply_no=true;
        boolean input_frm_tm=true;
        boolean input_to_tm=true;
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyList",Constant.ERROR);
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyList",Constant.ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query customer policy List
        String arguString =new String("");    //SQL
        String sqlString =Sqlstmt.SELECT_PLCYLIST_LATEST;    //SQL
		//String sqlString = Sqlstmt.SELECT_PLCYLIST;
        //String Plus_String = " ORDER BY A.t_app_tm DESC";
		//modified by rao 05/29/2001
		String Plus_String = " ORDER BY A.t_undr_tm DESC";

        if ((in_ply_no==null) || (in_ply_no.length()==0))
            input_ply_no=false;

        if ((in_from_tm==null) || (in_from_tm.length()==0))
            input_frm_tm=false;

        if ((in_to_tm==null) || (in_to_tm.length()==0))
            input_to_tm=false;

        if (input_ply_no) {
            String tmp_sqlString = " AND A.c_ply_no = '"+in_ply_no+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_app_tm >= TO_DATE('"+in_from_tm+"', 'YYYY-MM-DD')";
              arguString = arguString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_app_tm <= TO_DATE('"+in_to_tm+"', 'YYYY-MM-DD')+1";
              arguString = arguString + tmp_sqlString;
          }
        }

        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND A.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND A.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString + Plus_String;
// get related Policy form list from t_policy & t_plycrgo
        ConnectDB QueryPlcyList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryPlcyList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyList",Constant.ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn, in_user_id, Constant.LOG_PLCYQUERY, Constant.SUCCESS_EVENT, "getPolicyList() --- SUCCESSFULLY! ");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryPlcyList.GetReturnArray ();
    }


//////////////////////////////////////////////////
// Get Policy Info                             //
/////////////////////////////////////////////////
    public String[][] getPolicyInfo(String in_ply_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_PLCYINFO;

        if ((in_ply_no==null) ||  (in_ply_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_ply_no",in_ply_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryPolicyInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryPolicyInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryPolicyInfo.GetReturnArray ();
    }
//////////////////////////////////////////////////
// Get Policy Info Latest                             //
/////////////////////////////////////////////////
    public String[][] getPolicyInfoLatest(String in_ply_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_PLCYINFO_LATEST;

        if ((in_ply_no==null) ||  (in_ply_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_ply_no",in_ply_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryPolicyInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryPolicyInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPolicyInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryPolicyInfo.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Proposal Info                                  //
////////////////////////////////////////////////////////
    public String[][] getProposalInfo(String in_plyapp_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_PROPOSALINFO;

        if ((in_plyapp_no==null) ||  (in_plyapp_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_doc_no",in_plyapp_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryProposalInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryProposalInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getProposalInfo",Constant.ERROR);
        };

        String[][] Res= QueryProposalInfo.GetReturnArray ();
        String[][] ReturnResult = new String[2][26];
 	      for (int j=0;j <25;j++){
             ReturnResult[0][j+1]=Res[0][j];
             ReturnResult[1][j+1]=Res[1][j];
             }

        ReturnResult[0][0]="c_rtrn_cde";
        ReturnResult[1][0]="6";

        updatePrpslReadFlag(in_plyapp_no);
        r_pm.freeConnection (r_dbname,r_conn);
        return ReturnResult;
    }


////////////////////////////////////////////////////////
// Get endorsed policy Proposal Info                  //
////////////////////////////////////////////////////////
    public String[][] getEndorseProposalInfo(String in_edrapp_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_EDRPROPSINFO;

        if ((in_edrapp_no==null) ||  (in_edrapp_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_doc_no",in_edrapp_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryEdrPropsInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryEdrPropsInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEndorseProposalInfo",Constant.ERROR);
        };

        updatePrpslReadFlag(in_edrapp_no);
        r_pm.freeConnection (r_dbname,r_conn);
        return QueryEdrPropsInfo.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get policy Application RDR Info                    //
////////////////////////////////////////////////////////
    public String[][] getPlyAppRdrInfo(String in_ply_app_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_PLYAPPRDRINFO;

        if ((in_ply_app_no==null) ||  (in_ply_app_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_ply_app_no",in_ply_app_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryPlyAppRdrInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryPlyAppRdrInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC,"PLYAPP RDR INFO NOT EXIST","PolicyInfoManagerImpl",Constant.ERROR);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPlyAppRdrInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryPlyAppRdrInfo.GetReturnArray ();

    }

////////////////////////////////////////////////////////
// Get policy RDR Info                    //
////////////////////////////////////////////////////////
    public String[][] getPlyRdrInfo(String in_ply_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.SELECT_PLYRDRINFO;

        if ((in_ply_no==null) ||  (in_ply_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_ply_no",in_ply_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryPlyRdrInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryPlyRdrInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC,"POLICY RDR INFO NOT EXIST","PolicyInfoManagerImpl",Constant.ERROR);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPlyRdrInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryPlyRdrInfo.GetReturnArray ();

    }


////////////////////////////////////////////////////////
// Get Claim Case Report List                        //
////////////////////////////////////////////////////////
    public String[][] getCaseRptList(String in_user_id,String in_rpt_no,String in_from_tm,String in_to_tm,String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_rpt_no=true;
        boolean input_frm_tm=true;
        boolean input_to_tm=true;
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCaseRptList",Constant.ERROR);
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCaseRptList",Constant.ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query customer policy List
        String arguString =new String("");    //SQL
        String sqlString =Sqlstmt.SELECT_CASERPTLIST;    //SQL
        String Plus_String = " ORDER BY A.t_rtp_tm DESC";

        if ((in_rpt_no==null) || (in_rpt_no.length()==0))
            input_rpt_no=false;

        if ((in_from_tm==null) || (in_from_tm.length()==0))
            input_frm_tm=false;

        if ((in_to_tm==null) || (in_to_tm.length()==0))
            input_to_tm=false;

        if (input_rpt_no) {
            String tmp_sqlString = " AND A.c_rpt_no = '"+in_rpt_no+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_rtp_tm >= TO_DATE('"+in_from_tm+"', 'YYYY-MM-DD')";
              arguString = arguString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_rtp_tm <= TO_DATE('"+in_to_tm+"', 'YYYY-MM-DD')+1";
              arguString = arguString + tmp_sqlString;
          }
        }

        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND C.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND C.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString + Plus_String;
// get related case Report list from t_clmrpt & t_policy
        ConnectDB QueryCaseRptList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryCaseRptList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCaseRptList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryCaseRptList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Case Reprot Info                               //
////////////////////////////////////////////////////////
    public String[][] getCaseRptInfo(String in_rpt_no)
        throws com.mcip.orb.CoException {

        if ((in_rpt_no==null) || (in_rpt_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String sqlString =Sqlstmt.SELECT_CASERPTINFO;                //SQL
        String [][] sqlParameters= {{"c_rpt_no",in_rpt_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryCaseRptInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryCaseRptInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCaseRptInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryCaseRptInfo.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Case Reprot Claim List                         //
////////////////////////////////////////////////////////
    public String[][] getCaseClmList(String in_rpt_no, String in_status_mrk)
        throws com.mcip.orb.CoException {

        if ((in_rpt_no==null) || (in_rpt_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_status_mrk==null) || (in_status_mrk.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String sqlString ="";

        if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
          sqlString =Sqlstmt.SELECT_CASECLMLIST1;                  //SQL
        }else{
          sqlString =Sqlstmt.SELECT_CASECLMLIST2;                  //SQL
        }
        String [][] sqlParameters = {{"c_rpt_no",in_rpt_no,String.valueOf(Constant.VARCHAR2_TYPE)},
                                     {"c_clm_status_mrk",Constant.CLAIM_SETTLE_STATUS,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryCaseClmList= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryCaseClmList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getCaseClmList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryCaseClmList.GetReturnArray ();
    }

////////////////////////////////////////////////////////
// Get Claim List                                     //
////////////////////////////////////////////////////////
    public String[][] getClaimList(String in_clnt_cde, String in_rpt_no, String in_clm_no,
    String in_from_tm,String in_to_tm, String in_status_mrk)
        throws com.mcip.orb.CoException {

        if ((in_clnt_cde==null) || (in_clnt_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((in_status_mrk==null) || (in_status_mrk.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        boolean input_rpt_no=true;
        boolean input_clm_no=true;
        boolean input_tm=true;
        String sqlString ="";
        String[][] sqlParameters = new String [7][3];

        if ((in_rpt_no==null) || (in_rpt_no.length()==0))
            input_rpt_no=false;

        if ((in_clm_no==null) || (in_clm_no.length()==0))
            input_clm_no=false;

        if ((in_from_tm==null) || (in_to_tm==null) ||
           (in_from_tm.length()==0) || (in_to_tm.length()==0))
            input_tm=false;

        if (!input_rpt_no && !input_tm && !input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST0;                 //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST1;                  //SQL
          }
            String[][] sqlParameters1 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters1;
        }

        if (input_rpt_no && !input_tm && !input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_RPT0;             //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_RPT1;             //SQL
          }
            String[][] sqlParameters2 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_rpt_no",         in_rpt_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters2;
        }

        if (!input_rpt_no && !input_tm && input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_CLM0;             //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_CLM1;             //SQL
          }
            String[][] sqlParameters3 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_no",         in_clm_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters3;
        }

        if (!input_rpt_no && input_tm && !input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TM0;              //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TM1;              //SQL
          }
            String[][] sqlParameters4 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"t_from",           in_from_tm,   String.valueOf(Constant.DATE_TYPE)},
                                         {"t_to",             in_to_tm,     String.valueOf(Constant.DATE_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters4;
        }

        if (input_rpt_no && !input_tm && input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_RPTCLM0;             //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_RPTCLM1;             //SQL
          }
            String[][] sqlParameters5 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_no",         in_clm_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_rpt_no",         in_rpt_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters5;
        }

        if (input_rpt_no && input_tm && !input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TMRPT0;           //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TMRPT1;           //SQL
          }
            String[][] sqlParameters6 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_rpt_no",         in_rpt_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"t_from",           in_from_tm,   String.valueOf(Constant.DATE_TYPE)},
                                         {"t_to",             in_to_tm,     String.valueOf(Constant.DATE_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters6;
        }

        if (!input_rpt_no && input_tm && input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TMCLM0;           //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TMCLM1;           //SQL
          }
            String[][] sqlParameters7 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_no",         in_clm_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"t_from",           in_from_tm,   String.valueOf(Constant.DATE_TYPE)},
                                         {"t_to",             in_to_tm,     String.valueOf(Constant.DATE_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters7;
        }

        if (input_rpt_no && input_tm && input_clm_no){
          if (in_status_mrk.equals(Constant.NOT_CLAIM_MRK)){         //Constant
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TMCLMRPT0;           //SQL
          }else{
            sqlString =Sqlstmt.SELECT_CLAIMLIST_TMCLMRPT1;           //SQL
          }
            String[][] sqlParameters8 = {{"c_clnt_cde",       in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_cmpny_agt_cde",  in_clnt_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_clm_no",         in_clm_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_rpt_no",         in_rpt_no,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"t_from",           in_from_tm,   String.valueOf(Constant.DATE_TYPE)},
                                         {"t_to",             in_to_tm,     String.valueOf(Constant.DATE_TYPE)},
                                         {"c_clm_status_mrk", Constant.CLAIM_SETTLE_STATUS, String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters8;
        }

        ConnectDB QueryClaimList= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryClaimList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getClaimList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryClaimList.GetReturnArray ();
    }


////////////////////////////////////////////////////////
// Get Claim Digest List                              //
////////////////////////////////////////////////////////
    public String[][] getClmDgstList(String in_rpt_no, String in_ply_no)
        throws com.mcip.orb.CoException {

        boolean input_rpt_no=true;
        boolean input_ply_no=true;
        String sqlString ="";
        String[][] sqlParameters = new String [3][3];

        if ((in_rpt_no==null) || (in_rpt_no.length()==0))
            input_rpt_no=false;

        if ((in_ply_no==null) || (in_ply_no.length()==0))
            input_ply_no=false;

        if (!input_rpt_no && !input_ply_no)
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if (input_rpt_no && !input_ply_no){
            sqlString =Sqlstmt.SELECT_CLMDGSTLIST_RPT;             //SQL
            String[][] sqlParameters1 = {{"c_rpt_no",in_rpt_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters1;
        }

        if (!input_rpt_no && input_ply_no){
            sqlString =Sqlstmt.SELECT_CLMDGSTLIST_PLY;              //SQL
            String[][] sqlParameters3 = {{"c_ply_no",in_ply_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters3;
        }

        if (input_rpt_no && input_ply_no){
            sqlString =Sqlstmt.SELECT_CLMDGSTLIST_PLYRPT;           //SQL
            String[][] sqlParameters5 = {{"c_ply_no",in_ply_no,String.valueOf(Constant.VARCHAR2_TYPE)},
                                         {"c_rpt_no",in_rpt_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
            sqlParameters = sqlParameters5;
        }

        Connection l_conn = l_pm.getConnection(l_dbname);
        ConnectDB QueryClaimdgstList= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryClaimdgstList.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getClaimDgstList",Constant.ERROR);
        };

        l_pm.freeConnection (l_dbname,l_conn);
        return QueryClaimdgstList.GetReturnArray ();
    }

/////////////////////////////////////////////////////////////////
//  Get insurrance Quotation via WEB                          //
/////////////////////////////////////////////////////////////////

  public java.lang.String[][] getQuotation(com.mcip.nia.orb.QuotaCndtn in_quotacndtnobj, String in_rdr_type)
        throws com.mcip.orb.CoException{

        if ((in_rdr_type == null) || (in_rdr_type.length()==0))
            ErrorHandling(ExceptionCode.NIA_INVALIDRDRTYPE);

        if ((in_quotacndtnobj.c_dpt_cde == null) || (in_quotacndtnobj.c_dpt_cde.length()==0) ||
            (in_quotacndtnobj.c_insrnc_cde == null) || (in_quotacndtnobj.c_insrnc_cde.length()==0) ||
            (in_quotacndtnobj.c_rdr_cde == null) || (in_quotacndtnobj.c_rdr_cde.length()==0) ||
            (in_quotacndtnobj.c_crgo_cde == null) || (in_quotacndtnobj.c_crgo_cde.length()==0) ||
            (in_quotacndtnobj.c_carriage_cde == null) || (in_quotacndtnobj.c_carriage_cde.length()==0) ||
            (in_quotacndtnobj.c_frm_prt_ara == null) || (in_quotacndtnobj.c_frm_prt_ara.length()==0) ||
            (in_quotacndtnobj.c_to_prt_ara == null) || (in_quotacndtnobj.c_to_prt_ara.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        String [][] ReturnResult = null;

        if ((in_quotacndtnobj.c_insrnc_cde.equals(Constant.EXPORT_INSRNC)) || (in_quotacndtnobj.c_insrnc_cde.equals(Constant.IMPORT_INSRNC))) {

          boolean rdr_type=true;
          if ((in_rdr_type.equals(Constant.NULL_RDR)) || (in_rdr_type.equals(Constant.WITH_RDR))){
              if (in_rdr_type.equals(Constant.NULL_RDR)){
                  rdr_type=true;                  // NO additional insurance
              }else{
                  rdr_type=false;                 // Additional insurance
              }
          }else{
              r_pm.freeConnection (r_dbname,r_conn);
              l_pm.freeConnection (l_dbname,l_conn);
              ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
          }

          if (in_quotacndtnobj.c_rdr_cde.equals(Constant.ICCA_RDR))
              in_quotacndtnobj.c_rdr_cde = Constant.OCN_ALL_RDR;
          if (in_quotacndtnobj.c_rdr_cde.equals(Constant.ICCB_RDR))
              in_quotacndtnobj.c_rdr_cde = Constant.OCN_WTR_RDR;
          if (in_quotacndtnobj.c_rdr_cde.equals(Constant.ICCC_RDR))
              in_quotacndtnobj.c_rdr_cde = Constant.OCN_PA_RDR;

          boolean main_add_type=true;
          if ((in_quotacndtnobj.c_rdr_cde.equals(Constant.OCN_ALL_RDR)) ||
              (in_quotacndtnobj.c_rdr_cde.equals(Constant.LAND_ALL_RDR)) ||
              (in_quotacndtnobj.c_rdr_cde.equals(Constant.AIR_ALL_RDR))){
              main_add_type=true;              // only ALL insurance
          }else{
              if ((in_quotacndtnobj.c_rdr_cde.equals(Constant.OCN_PA_RDR)) ||
                  (in_quotacndtnobj.c_rdr_cde.equals(Constant.OCN_WTR_RDR)) ||
                  (in_quotacndtnobj.c_rdr_cde.equals(Constant.LAND_RDR)) ||
                  (in_quotacndtnobj.c_rdr_cde.equals(Constant.AIR_RDR))){
                  main_add_type=false;             // only SUB insruance
              }else{
                  r_pm.freeConnection (r_dbname,r_conn);
                  l_pm.freeConnection (l_dbname,l_conn);
                  ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
              }
          }

          if (!rdr_type && !main_add_type){
              if ((in_quotacndtnobj.c_rdr_cde.equals(Constant.OCN_PA_RDR)) ||
                  (in_quotacndtnobj.c_rdr_cde.equals(Constant.OCN_WTR_RDR)))
                  in_quotacndtnobj.c_rdr_cde = Constant.OCN_ALL_RDR;

              if (in_quotacndtnobj.c_rdr_cde.equals(Constant.LAND_RDR))
                  in_quotacndtnobj.c_rdr_cde = Constant.LAND_ALL_RDR;

              if (in_quotacndtnobj.c_rdr_cde.equals(Constant.AIR_RDR))
                  in_quotacndtnobj.c_rdr_cde = Constant.AIR_ALL_RDR;
          }

          String sqlString1 = Sqlstmt.SELECT_CRGORATE;                //SQL
          String [][] sqlParameters1 = {{"c_dpt_cde",      in_quotacndtnobj.c_dpt_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_insrnc_cde",   in_quotacndtnobj.c_insrnc_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_rdr_cde",      in_quotacndtnobj.c_rdr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_carriage_cde", in_quotacndtnobj.c_carriage_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_frm_prt_ara",  in_quotacndtnobj.c_frm_prt_ara, String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_frm_prt_ara",  in_quotacndtnobj.c_frm_prt_ara, String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_to_prt_ara",   in_quotacndtnobj.c_to_prt_ara,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                       {"c_to_prt_ara",   in_quotacndtnobj.c_to_prt_ara,  String.valueOf(Constant.VARCHAR2_TYPE)}};
          ConnectDB QueryCrgoRate = new ConnectDB (r_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);

          switch (QueryCrgoRate.GetReturnCode()) {
               case Constant.ConnectDB_SelectNone:
                    new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_QUOTATION, Constant.FAIL_EVENT, "getQuotation() --- NIA_CRGORATE_NOREC!");
                    r_pm.freeConnection (r_dbname,r_conn);
                    l_pm.freeConnection (l_dbname,l_conn);
                    ErrorHandling(ExceptionCode.NIA_CRGORATE_NOREC);
               case Constant.ConnectDB_SelectMulti:
               case Constant.ConnectDB_SelectOne:
                    break;
               default:
                    r_pm.freeConnection (r_dbname,r_conn);
                    l_pm.freeConnection (l_dbname,l_conn);
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getQuotation",Constant.ERROR);
          };
          ReturnResult = QueryCrgoRate.GetReturnArray();
// added for Debug
//System.out.println("The main rate : "+ReturnResult[1][7]);
//System.out.println("The main c_nclm_desc : "+ReturnResult[1][8]);

          String [][] Res = null;
          String sqlString2 = Sqlstmt.SELECT_CRGORATEADD;                //SQL
          String [][] sqlParameters2 = {{"c_dpt_cde",     in_quotacndtnobj.c_dpt_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
                                        {"c_crgo_cde",    in_quotacndtnobj.c_crgo_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};
          ConnectDB QueryCrgoRateAdd = new ConnectDB (r_conn,sqlString2,Constant.executePrepQuery,sqlParameters2);

          switch (QueryCrgoRateAdd.GetReturnCode()) {
               case Constant.ConnectDB_SelectNone:
                    new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_QUOTATION, Constant.FAIL_EVENT, "getQuotation() --- NIA_CRGORATEADD_NOREC!");
                    r_pm.freeConnection (r_dbname,r_conn);
                    l_pm.freeConnection (l_dbname,l_conn);
                    ErrorHandling(ExceptionCode.NIA_CRGORATEADD_NOREC);
               case Constant.ConnectDB_SelectMulti:
               case Constant.ConnectDB_SelectOne:
                    break;
               default:
                    r_pm.freeConnection (r_dbname,r_conn);
                    l_pm.freeConnection (l_dbname,l_conn);
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getQuotation",Constant.ERROR);
          };
          Res = QueryCrgoRateAdd.GetReturnArray();
// added for Debug
//System.out.println("The crgo add rate : "+Res[1][2]);
//System.out.println("The crgo add c_nclm_desc : "+Res[1][3]);

          double sum_rate = 0;
          if (!rdr_type && !main_add_type){
//              sum_rate = Double.parseDouble(ReturnResult[1][7]) * Constant.ADD_VRATE;
              sum_rate = Double.parseDouble(ReturnResult[1][7]) * Constant.ADD_VRATE + Double.parseDouble(Res[1][2]);
              ReturnResult[1][8] = ReturnResult[1][8] + Res[1][3];
          }else{
              if (rdr_type && !main_add_type){
                  sum_rate = Double.parseDouble(ReturnResult[1][7]) * Constant.ADD_VRATE;
              }else{
//              sum_rate = Double.parseDouble(ReturnResult[1][7]) * Constant.ALL_VRATE;
                  sum_rate = Double.parseDouble(ReturnResult[1][7]) * Constant.ALL_VRATE + Double.parseDouble(Res[1][2]);
                  ReturnResult[1][8] = ReturnResult[1][8] + Res[1][3];
              }
          }
              ReturnResult[1][7] = Double.toString(sum_rate);

        }else{
            if ((in_quotacndtnobj.c_insrnc_cde.equals(Constant.HOME_INSRNC)) ||
                (in_quotacndtnobj.c_insrnc_cde.equals(Constant.HOME_RAILWAY_INSRNC)) ||
                (in_quotacndtnobj.c_insrnc_cde.equals(Constant.HOME_ROAD_INSRNC)) ||
                (in_quotacndtnobj.c_insrnc_cde.equals(Constant.HOME_SHIP_INSRNC)) ||
                (in_quotacndtnobj.c_insrnc_cde.equals(Constant.HOME_AIR_INSRNC))){

                String sqlString3 = Sqlstmt.SELECT_CRGORATEHOME;                //SQL
                String [][] sqlParameters3 = {{"c_dpt_cde",     in_quotacndtnobj.c_dpt_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
                                             {"c_insrnc_cde",   in_quotacndtnobj.c_insrnc_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
                                             {"c_rdr_cde",      in_quotacndtnobj.c_rdr_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
                                             {"c_carriage_cde", in_quotacndtnobj.c_carriage_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
                                             {"c_crgo_cde",     in_quotacndtnobj.c_crgo_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
                                             {"c_crgo_cde",     in_quotacndtnobj.c_crgo_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
                ConnectDB QueryCrgoRatehome = new ConnectDB (r_conn,sqlString3,Constant.executePrepQuery,sqlParameters3);

                switch (QueryCrgoRatehome.GetReturnCode()) {
                     case Constant.ConnectDB_SelectNone:
                          new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_QUOTATION, Constant.FAIL_EVENT, "getQuotation() --- NIA_CRGORATE_NOREC!");
                          r_pm.freeConnection (r_dbname,r_conn);
                          l_pm.freeConnection (l_dbname,l_conn);
                          ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
                     case Constant.ConnectDB_SelectMulti:
                     case Constant.ConnectDB_SelectOne:
                          break;
                     default:
                          r_pm.freeConnection (r_dbname,r_conn);
                          l_pm.freeConnection (l_dbname,l_conn);
                          ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getQuotation",Constant.ERROR);
                };
                ReturnResult = QueryCrgoRatehome.GetReturnArray();
// added for Debug
//System.out.println("The HOME rate : "+ReturnResult[1][7]);
//System.out.println("The HOME c_nclm_desc : "+ReturnResult[1][8]);

            }else{
              new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_QUOTATION, Constant.FAIL_EVENT, "getQuotation() --- NIA_INVALIDINSRNCCDE!");
              r_pm.freeConnection (r_dbname,r_conn);
              l_pm.freeConnection (l_dbname,l_conn);
              ErrorHandling(ExceptionCode.NIA_INVALIDINSRNCCDE);
            }
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_QUOTATION, Constant.SUCCESS_EVENT, "getQuotation() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }


////////////////////////////////////////////////////////
// Get Cyber Insurance Applicant's address            //
////////////////////////////////////////////////////////
    public String[][] getPlyAppNetAddress(String cust_typ, String in_clnt_cde)
        throws com.mcip.orb.CoException {

        if ((in_clnt_cde==null) || (in_clnt_cde.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        if ((cust_typ==null) || (cust_typ.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean OCNET_ADDRESS_NOT_FOUND = false;
        if ((cust_typ.equals(Constant.NORMAL_CUST_MRK)) ||
            (cust_typ.equals(Constant.AGENCY_CUST_MRK)) ||
            (cust_typ.equals(Constant.OPNCVR_CUST_MRK))) {
        }else{
            ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
        }

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] ReturnResult = new String[2][10];

        if (cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
          String sqlString2 =Sqlstmt.SELECT_AGNTPLYAPPNET;
          String [][] sqlParameters2= {{"c_cmpny_agt_cde",in_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
          ConnectDB QueryAgntNet= new ConnectDB (r_conn,sqlString2,Constant.executePrepQuery,sqlParameters2);

          switch (QueryAgntNet.GetReturnCode()) {
               case Constant.ConnectDB_SelectNone:
                    r_pm.freeConnection (r_dbname,r_conn);
                    ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
               case Constant.ConnectDB_SelectMulti:
               case Constant.ConnectDB_SelectOne:
                    break;
               default:
                    r_pm.freeConnection (r_dbname,r_conn);
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPlyAppNetAddress",Constant.ERROR);
          };
          ReturnResult = QueryAgntNet.GetReturnArray ();
        }

        if (cust_typ.equals(Constant.OPNCVR_CUST_MRK)) {
          String sqlString3 =Sqlstmt.SELECT_OPCVPLYAPPNET;
          String [][] sqlParameters3 = {{"c_clnt_cde",in_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
          ConnectDB QueryOCNet= new ConnectDB (r_conn,sqlString3,Constant.executePrepQuery,sqlParameters3);

          switch (QueryOCNet.GetReturnCode()) {
               case Constant.ConnectDB_SelectNone:
                    OCNET_ADDRESS_NOT_FOUND = true;
                    break;
               case Constant.ConnectDB_SelectMulti:
               case Constant.ConnectDB_SelectOne:
                    break;
               default:
                    r_pm.freeConnection (r_dbname,r_conn);
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPlyAppNetAddress",Constant.ERROR);
          };
          if (!OCNET_ADDRESS_NOT_FOUND)
            ReturnResult = QueryOCNet.GetReturnArray ();
        }

        if (OCNET_ADDRESS_NOT_FOUND || (cust_typ.equals(Constant.NORMAL_CUST_MRK))) {
          String sqlString1 =Sqlstmt.SELECT_GENLPLYAPPNET;
          String [][] sqlParameters1= {{"c_clnt_cde",in_clnt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
          ConnectDB QueryGenlNet= new ConnectDB (r_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);

          switch (QueryGenlNet.GetReturnCode()) {
               case Constant.ConnectDB_SelectNone:
                    r_pm.freeConnection (r_dbname,r_conn);
                    ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
               case Constant.ConnectDB_SelectMulti:
               case Constant.ConnectDB_SelectOne:
                    break;
               default:
                    r_pm.freeConnection (r_dbname,r_conn);
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPlyAppNetAddress",Constant.ERROR);
          };
          ReturnResult = QueryGenlNet.GetReturnArray ();
        }

        r_pm.freeConnection (r_dbname,r_conn);
        return ReturnResult;
    }



//////////////////////////////////////////

// Added By YiJF Oct-18

// For Insurance Clause Introduce Via Web

///////////////////////////////////////////

    public String[][] getClauseList(String in_insrnc_cde, String in_clause_cde, String in_clnt_cnm)
        throws com.mcip.orb.CoException {

        Connection r_conn = r_pm.getConnection(r_dbname);
        Connection l_conn = l_pm.getConnection(l_dbname);
        if ((in_clnt_cnm==null) || (in_clnt_cnm.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CLSINTRDC, Constant.FAIL_EVENT, "getClauseList() --- NIA_NULLQUERYPARM!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);
        }

        if (in_clause_cde.length() > 0) {
          if ((in_insrnc_cde==null) || (in_insrnc_cde.length()==0)) {
            new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CLSINTRDC, Constant.FAIL_EVENT, "getClauseList() --- clause code with no insurance code! NIA_NULLQUERYPARM!");
            r_pm.freeConnection (r_dbname,r_conn);
            l_pm.freeConnection (l_dbname,l_conn);
            ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
          }
        }

        boolean input_insrnc_cde = true;
        boolean input_clause_cde = true;

        if ((in_insrnc_cde==null) || (in_insrnc_cde.length()==0))
            input_insrnc_cde=false;

        if ((in_clause_cde==null) || (in_clause_cde.length()==0))
            input_clause_cde=false;

        String sqlString = new String("");
        String [][] sqlParameters = new String [2][3];
        String [][] ReturnResult = new String [2][5];

        if (!input_insrnc_cde && !input_clause_cde){

          sqlString=Sqlstmt.SELECT_CLAUSELIST1;
          ConnectDB QueryInsrClauseList1= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
          switch (QueryInsrClauseList1.GetReturnCode()) {
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
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getClauseList",Constant.ERROR);
          };
          ReturnResult = QueryInsrClauseList1.GetReturnArray();

        }else{

          if (input_insrnc_cde && !input_clause_cde){
                sqlString = Sqlstmt.SELECT_CLAUSELIST2;                  //SQL
                String[][] sqlParameters1 = {{"c_insrnc_cde",     in_insrnc_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
                sqlParameters = sqlParameters1;
          }
          if (!input_insrnc_cde && input_clause_cde){
                new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CLSINTRDC, Constant.FAIL_EVENT, "getClauseList() --- clause code with no insurance code! NIA_NULLQUERYPARM!");
                r_pm.freeConnection (r_dbname,r_conn);
                l_pm.freeConnection (l_dbname,l_conn);
                ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM);
          }
          if (input_insrnc_cde && input_clause_cde){
                sqlString = Sqlstmt.SELECT_CLAUSELIST3;                  //SQL
                String[][] sqlParameters2 = {{"c_insrnc_cde",     in_insrnc_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
                                             {"c_claus_cde",      in_clause_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
                sqlParameters = sqlParameters2;
          }

          ConnectDB QueryInsrClauseList2 = new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

          switch (QueryInsrClauseList2.GetReturnCode()) {
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
                    ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getClauseList",Constant.ERROR);
          };
          ReturnResult = QueryInsrClauseList2.GetReturnArray();
        }

        new ConnectDB(l_conn).WriteDBLog(l_conn, in_clnt_cnm, Constant.LOG_CLSINTRDC, Constant.SUCCESS_EVENT, "getClauseList() --- SUCCESSFULLY!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return ReturnResult;
    }



////////////////////////////////////////////////////////

// Get Policy Application Proposal List                        //
////////////////////////////////////////////////////////
    public String[][] getProposalList(String in_user_id,String in_ply_app,String in_from_tm,String in_to_tm, String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_ply_app=true;
        boolean input_frm_tm=true;
        boolean input_to_tm=true;
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getProposalList",Constant.ERROR);
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getProposalList",Constant.ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query customer policy List
        String arguString =new String("");    //SQL
        String sqlString =Sqlstmt.SELECT_PROPOSALIST;    //SQL
        String Plus_String = " ORDER BY A.t_app_tm DESC";

        if ((in_ply_app==null) || (in_ply_app.length()==0))
            input_ply_app=false;

        if ((in_from_tm==null) || (in_from_tm.length()==0))
            input_frm_tm=false;

        if ((in_to_tm==null) || (in_to_tm.length()==0))
            input_to_tm=false;

        if (input_ply_app) {
            String tmp_sqlString = " AND A.c_ply_app_no = '"+in_ply_app+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_app_tm >= TO_DATE('"+in_from_tm+"', 'YYYY-MM-DD')";
              arguString = arguString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_app_tm <= TO_DATE('"+in_to_tm+"', 'YYYY-MM-DD')+1";
              arguString = arguString + tmp_sqlString;
          }
        }

        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND A.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND A.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString + Plus_String;
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getProposalList",Constant.ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn,in_user_id,Constant.LOG_PRPSLCNFM,Constant.SUCCESS_EVENT,"getProposalList() Policy apply form's Proposal Inquiry Successful!");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryProposaList.GetReturnArray ();
    }

// Added By YiJF Nov-15,2000
////////////////////////////////////////////////////////

// Get Policy Endorsement Application Form List       //
////////////////////////////////////////////////////////
    public String[][] getEdrAppList(String in_user_id,String in_edr_app,String in_ply_no,String in_from_tm,String in_to_tm, String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_edr_app=true;
        boolean input_ply_no=true;
        boolean input_frm_tm=true;
        boolean input_to_tm=true;
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrAppList",Constant.ERROR);
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrAppList",Constant.ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query Endorsement Application Form List
        String arguString =new String("");    //SQL
//        String sqlString =Sqlstmt.SELECT_EDRAPPLIST;    //SQL
        String sqlString =Sqlstmt.SELECT_EDRAPPLIST_UNDR;    //SQL
        String Plus_String = " GROUP BY A.c_app_cde,A.c_edr_app_no,A.c_ply_no,A.c_insrnc_cde,A.c_dpt_cde,A.n_amt,A.c_amt_cur,A.t_upd_tm,A.c_open_cover_no,B.c_crgo_cde,B.c_crgo_desc,B.c_from_prt,B.c_to_prt,B.c_sail_no,B.c_invc_no,B.c_receipt_no,C.c_insrnc_cnm, D.c_cur_sbl, S.c_read_flag ORDER BY A.t_upd_tm DESC";

        if ((in_edr_app==null) || (in_edr_app.length()==0))
            input_edr_app=false;

        if ((in_ply_no==null) || (in_ply_no.length()==0))
            input_ply_no=false;

        if ((in_from_tm==null) || (in_from_tm.length()==0))
            input_frm_tm=false;

        if ((in_to_tm==null) || (in_to_tm.length()==0))
            input_to_tm=false;

        if (input_edr_app) {
            String tmp_sqlString = " AND A.c_edr_app_no = '"+in_edr_app+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_ply_no) {
            String tmp_sqlString = " AND A.c_ply_no = '"+in_ply_no+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_edr_app_tm >= TO_DATE('"+in_from_tm+"', 'YYYY-MM-DD')";
              arguString = arguString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_edr_app_tm <= TO_DATE('"+in_to_tm+"', 'YYYY-MM-DD')+1";
              arguString = arguString + tmp_sqlString;
          }
        }

        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND A.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND A.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString + Plus_String;
// get related Policy application form list from t_plyapp & t_plyappcrgo
        ConnectDB QueryEdrAppList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryEdrAppList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrAppList",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryEdrAppList.GetReturnArray ();
    }


////////////////////////////////////////////

// Get Endorsement Policy List            //
////////////////////////////////////////////
    public String[][] getEdrsmtList(String in_user_id,String in_edr_no,String in_ply_no,String in_from_tm,String in_to_tm, String in_cust_typ)
        throws com.mcip.orb.CoException {

        if ((in_user_id==null) || (in_user_id.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean input_edr_no=true;
        boolean input_ply_no=true;
        boolean input_frm_tm=true;
        boolean input_to_tm=true;
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrsmtList",Constant.ERROR);
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
                      ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrsmtList",Constant.ERROR);
            };
            clnt_Res=QueryClntMapList2.GetReturnArray();
        }

// Construct the SQL statement for query customer policy List
        String arguString =new String("");    //SQL
        String sqlString =Sqlstmt.SELECT_EDRLIST;    //SQL
		//modified by rao 6/1/2001
        String Plus_String = " ORDER BY A.t_undr_tm DESC";

        if ((in_edr_no==null) || (in_edr_no.length()==0))
            input_edr_no=false;

        if ((in_ply_no==null) || (in_ply_no.length()==0))
            input_ply_no=false;

        if ((in_from_tm==null) || (in_from_tm.length()==0))
            input_frm_tm=false;

        if ((in_to_tm==null) || (in_to_tm.length()==0))
            input_to_tm=false;

        if (input_edr_no) {
            String tmp_sqlString = " AND A.c_edr_no = '"+in_edr_no+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_ply_no) {
            String tmp_sqlString = " AND A.c_ply_no = '"+in_ply_no+"'";
            arguString = arguString + tmp_sqlString;
        }

        if (input_frm_tm || input_to_tm) {
          if (input_frm_tm) {
              String tmp_sqlString = " AND A.t_edr_app_tm >= TO_DATE('"+in_from_tm+"', 'YYYY-MM-DD')";
              arguString = arguString + tmp_sqlString;
          }
          if (input_to_tm) {
              String tmp_sqlString = " AND A.t_edr_app_tm <= TO_DATE('"+in_to_tm+"', 'YYYY-MM-DD')+1";
              arguString = arguString + tmp_sqlString;
          }
        }

        if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
            String tmp_sqlString = " AND A.c_cmpny_agt_cde = '"+in_cmpny_agt_cde+"'";
            arguString = arguString + tmp_sqlString;
        }else{
            int clntarray_len = clnt_Res.length-1;
            String clnt_sqlString = " AND A.c_app_cde IN (";

            for (int i = 0; i < clntarray_len ; i++){
                if ((i-clntarray_len+1)==0)
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "'";
                else
                    clnt_sqlString = clnt_sqlString + "'" + clnt_Res[i+1][1] + "', ";
            }
            arguString = arguString + clnt_sqlString + " )";    //SQL
        }

        sqlString = sqlString + arguString + Plus_String;
// get related Policy form list from t_policy & t_plycrgo
        ConnectDB QueryEdrList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
        switch (QueryEdrList.GetReturnCode()) {
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
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrsmtList",Constant.ERROR);
        };

        new ConnectDB(l_conn).WriteDBLog(l_conn, in_user_id, Constant.LOG_PLCYQUERY, Constant.SUCCESS_EVENT, "getEdrsmtList() --- SUCCESSFULLY! ");
        r_pm.freeConnection (r_dbname,r_conn);
        l_pm.freeConnection (l_dbname,l_conn);
        return QueryEdrList.GetReturnArray ();
    }


//////////////////////////////////////////////////
// Get Endorse Policy Info                             //
/////////////////////////////////////////////////
    public String[][] getEdrsmtInfo(String in_edr_no)
        throws com.mcip.orb.CoException {

        if ((in_edr_no==null) ||  (in_edr_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String sqlString =Sqlstmt.SELECT_EDRINFO;
        String [][] sqlParameters= {{"c_edr_no",in_edr_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryEdrsmtInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryEdrsmtInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getEdrsmtInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryEdrsmtInfo.GetReturnArray ();
    }


//////////////////////////////////////////////////
// Get Endorse Policy Info                      //
//////////////////////////////////////////////////
    public String[][] getPreEdrInfo(String in_edr_app_no)
        throws com.mcip.orb.CoException {

        if ((in_edr_app_no==null) ||  (in_edr_app_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String sqlString =Sqlstmt.SELECT_PREEDRINFO;
        String [][] sqlParameters= {{"c_edr_app_no",in_edr_app_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB QueryPreEdrInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (QueryPreEdrInfo.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.NIA_QUERYNOREC);
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","getPreEdrInfo",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return QueryPreEdrInfo.GetReturnArray ();
    }



//////////////////////////////////////////////////////////////////////////////////

// Check Endorse Apply Form existing or not: true -- not exist; false --- exist //
//////////////////////////////////////////////////////////////////////////////////
    public boolean checkEdrApp(String in_ply_no)
        throws com.mcip.orb.CoException {

        if ((in_ply_no==null) ||  (in_ply_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        boolean ReturnResult = false;
        Connection r_conn = r_pm.getConnection(r_dbname);
        String sqlString =Sqlstmt.SELECT_CHECKEDRAPP;
        String [][] sqlParameters= {{"c_ply_no",in_ply_no,String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB ChkEdrApp= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

        switch (ChkEdrApp.GetReturnCode()) {
             case Constant.ConnectDB_SelectNone:
                  ReturnResult = true;
                  break;
             case Constant.ConnectDB_SelectMulti:
             case Constant.ConnectDB_SelectOne:
                  ReturnResult = false;
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,"","checkEdrApp()",Constant.ERROR);
        };

        r_pm.freeConnection (r_dbname,r_conn);
        return ReturnResult;
    }



//////////////////////////////////////////////////////////
// update proposal reading flag : set c_read_flag = "0" //
//////////////////////////////////////////////////////////
    public void updatePrpslReadFlag(String in_doc_no)
        throws com.mcip.orb.CoException {

        String sqlString =Sqlstmt.UPDATE_PRPSLREADFLAG;

        if ((in_doc_no==null) ||  (in_doc_no.length()==0))
            ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

        Connection r_conn = r_pm.getConnection(r_dbname);
        String [][] sqlParameters= {{"c_read_flag",   Constant.PRPSL_READ_FLAG,      String.valueOf(Constant.VARCHAR2_TYPE)},
                                    {"c_doc_no",      in_doc_no,                     String.valueOf(Constant.VARCHAR2_TYPE)}};
        ConnectDB UpdatePrpslRdFlg= new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);

        switch (UpdatePrpslRdFlg.GetReturnCode()) {
             case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
                  break;
             default:
                  r_pm.freeConnection (r_dbname,r_conn);
                  ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
        }

        r_pm.freeConnection (r_dbname,r_conn);
        return;
    }



  }

//throw new CoException("0001", "User does not have the right to view agent's info", "", "");
//this.exHandler.raiseCoException(ExceptionCode.NOT_SUBORDINATE);

