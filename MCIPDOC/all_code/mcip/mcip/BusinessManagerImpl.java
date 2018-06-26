////////////////////////////////////////////////////////
// Author:       Maintained by YiJF
// Function:     Operator Management Module Implement
// Update Date:  2000/9/20
//*****************
//Modified Date:2001-11-2
//By:L.K
//Ref:LK0001
//Purpose:creat a new method to answer the monitor request
////////////////////////////////////////////////////////

import java.sql.*;
import java.util.*;
import utility.*;
import constant.*;
import jtoc.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.bus.orb.*;


public class BusinessManagerImpl extends _BusinessManagerImplBase {
		private static PoolManager r_pm;
		private static PoolManager l_pm;
		private static String r_dbname=Constant.BACKEND_DBNAME;
		private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
		private CoExceptionHandler exHandler;
/**
*this method to answer the monitor's request
*/
public boolean isAlive(){
	return true;
}
////////////////////////////////////////////////////////
// Function:     Constructor
////////////////////////////////////////////////////////
		public BusinessManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
				super(name);
// connect Remote DB (BackEnd System)
				r_pm = r_poolManager;
//        r_conn = r_pm.getConnection(r_dbname);
// connect Local DB (PA18.COM System)
				l_pm = l_poolManager;
//        l_conn = l_pm.getConnection(l_dbname);

//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"BusinessManagerImpl get db connection");
				exHandler = new CoExceptionHandler();
		}

////////////////////////////////////////////////////////
// Function:     Error Handling Module
////////////////////////////////////////////////////////
		private void ErrorHandling(String ExceptionCode)
					 throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"BusinessManagerImp1 free db connection");
				this.exHandler.raiseCoException(ExceptionCode,null,"BusinessManagerImpl");
		}

		private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
					 throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"BusinessManagerImp1 free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"BusinessManagerImpl");
		}

		private void ErrorHandling(String ExceptionCode,String ExceptionDesc,String ExceptionField,String ExceptionSeverity)
					 throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"BusinessManagerImp1 free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"BusinessManagerImpl",ExceptionSeverity);
		}


//Business Logic for PingAn internal operator login
//////////////////////////////////////////////////////////////////////////////////////
// Common Routine for all case
// Get the department code of new operator with employee code
// return string -- employee Department code
//////////////////////////////////////////////////////////////////////////////////////
	public String getEmployeeDpt(String in_emp_cde)
				throws com.mcip.orb.CoException{

				String ReturnResult = new String("");

				Connection r_conn = r_pm.getConnection(r_dbname);
				String sqlString =Sqlstmt.SELECT_EMPLOYEEDPT;          // SQL
				String [][] sqlParameters= {{"c_emp_cde",in_emp_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB getemployeedpt = new ConnectDB(r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (getemployeedpt.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","getEmployeeDpt",Constant.ERROR);
						 case Constant.ConnectDB_SelectMulti:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC,"","getEmployeeDpt",Constant.ERROR);
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				ReturnResult = getemployeedpt.GetReturnArray()[1][0];
				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;

		}


////////////////////////////////////////////////////////
// Common Routine for all case
// set parameters values for executeOptrAuth()
// return string array [][]
////////////////////////////////////////////////////////
		String [][] set_parameter_value(String c_field_name1, String c_field_value1, String c_field_type1,
																		String c_field_name2, String c_field_value2, String c_field_type2)
				throws com.mcip.orb.CoException{
				String [][] sqlParameters={{c_field_name1,c_field_value1,c_field_type1},
																	 {c_field_name2,c_field_value2,c_field_type2}};
				return sqlParameters;
		}


//////////////////////////////////////////////////////////////////////////////
// Use Case 1 : Get policy Net information List for Printing policy form //
//////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryPlyNetList(String in_opr_cde, String in_prnt_flg, String in_ply_no,
									 String frm_plyapp_tm,String to_plyapp_tm, String frm_insrnc_cde, String to_insrnc_cde, java.lang.String[] dpt_array)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYPRINT, Constant.FAIL_EVENT, "queryPlyNetList() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_prnt_flg==null) || (in_prnt_flg.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYPRINT, Constant.FAIL_EVENT, "queryPlyNetList() --- BSNS_INVALIDPRNTFLG");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPRNTFLG);         //  Modify Exceoption
				}

				boolean print_flg = true;
				boolean input_ply_no = true;
				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;

				String sqlString = Sqlstmt.SELECT_PLYNET;
				String Plus_sqlString = " ORDER BY A.c_ply_no ";
				String NoPrnt_sqlString = " AND A.c_prt_emp_cde IS NULL AND A.t_print_tm IS NULL ORDER BY A.c_ply_no";
				String Prnt_sqlString = " AND A.c_prt_emp_cde IS NOT NULL AND A.t_print_tm IS NOT NULL ORDER BY A.c_ply_no";

				if ((in_prnt_flg.equals(Constant.NOT_PRINT_MRK)) ||
						(in_prnt_flg.equals(Constant.PRINTED_MRK)) ||
						(in_prnt_flg.equals(Constant.ALL_PRINT_MRK))){
					print_flg = true;
				}else{
					print_flg = false;
				}

				if (!print_flg){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYPRINT, Constant.FAIL_EVENT, "queryPlyNetList() --- BSNS_INVALIDPRNTFLG");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPRNTFLG);         //  Modify Exceoption
				}

				if ((in_ply_no==null) || (in_ply_no.length()==0))
						input_ply_no=false;

				if ((frm_plyapp_tm==null) || (frm_plyapp_tm.length()==0))
						input_frm_tm=false;

				if ((to_plyapp_tm==null) || (to_plyapp_tm.length()==0))
						input_to_tm=false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins=false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins=false;

// Construct the SQL statement for Query DB
				if (input_ply_no) {
						String tmp_sqlString = " AND B.c_ply_no = '"+in_ply_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND B.t_undr_tm >= TO_DATE('"+frm_plyapp_tm+"', 'YYYY-MM-DD hh24:mi:ss')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND B.t_undr_tm <= TO_DATE('"+to_plyapp_tm+"', 'YYYY-MM-DD hh24:mi:ss')";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND B.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND B.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (dpt_array[0].length() > 0){
						int dptarray_len = dpt_array.length;
						String dpt_sqlString = " AND B.c_dpt_cde IN (";

						for (int i = 0; i < dptarray_len ; i++){
							 if ((i-dptarray_len+1)==0)
									dpt_sqlString = dpt_sqlString + "'" + dpt_array[i] + "'";
							 else
									dpt_sqlString = dpt_sqlString + "'" + dpt_array[i] + "', ";
						}
						sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
				}

				if (in_prnt_flg.equals(Constant.ALL_PRINT_MRK))
						sqlString = sqlString + Plus_sqlString;  //SQL
				if (in_prnt_flg.equals(Constant.NOT_PRINT_MRK))
						sqlString = sqlString + NoPrnt_sqlString;  //SQL
				if (in_prnt_flg.equals(Constant.PRINTED_MRK))
						sqlString = sqlString + Prnt_sqlString;    //SQL

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryPlyNetList= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);

				switch (QueryPlyNetList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYPRINT, Constant.SUCCESS_EVENT, "queryPlyNetList() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPlyNetList.GetReturnArray ();
		}


/////////////////////////////////////////////////////////////////////////
// Use Case 2 : Query address detail info to print for deliverying Policy
/////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryPlyNetInfo(java.lang.String[] ply_no_array)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				int plyarray_len = ply_no_array.length;
				if (plyarray_len==0){
					 new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYPRINT, Constant.FAIL_EVENT, "queryPlyNetInfo() --- BSNS_INVALIDPLYNO");

					 r_pm.freeConnection (r_dbname,r_conn);

					 l_pm.freeConnection (l_dbname,l_conn);
					 ErrorHandling(ExceptionCode.BSNS_INVALIDPLYNO);     // Modify Exception CODE

				}

				String sqlString ="";
				String Ply_sqlString = " AND A.c_ply_no IN (";
				String tmp_sqlString ="";
				String[][] sqlParameters = new String [plyarray_len][3];

				for (int i = 0; i < plyarray_len ; i++){
					 if ((i-plyarray_len+1)==0)
							tmp_sqlString = tmp_sqlString + " ?";
					 else
							tmp_sqlString = tmp_sqlString + " ?,";

					 sqlParameters[i][0] = "c_ply_no";
					 sqlParameters[i][1] = ply_no_array[i];
					 sqlParameters[i][2] = String.valueOf(Constant.VARCHAR2_TYPE);
				}

				sqlString = Sqlstmt.SELECT_PLYNETINFO + Ply_sqlString + tmp_sqlString + " ) ";    //SQL
				ConnectDB QueryPlyNetInfo= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

				switch (QueryPlyNetInfo.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYPRINT, Constant.SUCCESS_EVENT, "queryPlyNetInfo() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPlyNetInfo.GetReturnArray ();
		}


////////////////////////////////////////////////////////
// Use Case 3 : Update Policy Print Flag
////////////////////////////////////////////////////////

	public boolean updatePrintInfo(java.lang.String[] ply_no_array, String in_opr_cde)
				throws com.mcip.orb.CoException {

				boolean ReturnResult = false;
				int plyarray_len = ply_no_array.length;

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if (plyarray_len==0){
					 new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYPRINT, Constant.FAIL_EVENT, "updatePrintInfo() --- BSNS_INVALIDPLYNO");

					 r_pm.freeConnection (r_dbname,r_conn);

					 l_pm.freeConnection (l_dbname,l_conn);
					 ErrorHandling(ExceptionCode.BSNS_INVALIDPLYNO);     // Modify Exception CODE

				}

				String statement_plynet[]=new String[plyarray_len];
				String parm_plynet [][][]=new String[plyarray_len][3][2];
				for (int i = 0; i < plyarray_len ; i++){
				statement_plynet[i]=Sqlstmt.UPDATE_PLYNET;
				parm_plynet[i] = set_parameter_value("c_prt_emp_cde", in_opr_cde,       String.valueOf(Constant.VARCHAR2_TYPE),
																						 "c_ply_no",      ply_no_array[i],  String.valueOf(Constant.VARCHAR2_TYPE));
				}

				ConnectDB UpdatePrintInfo = new ConnectDB (r_conn,statement_plynet,Constant.executeBatchPrepUpdate,parm_plynet);
				switch (UpdatePrintInfo.GetReturnCode()) {

						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
//add for debug
//System.out.println("after update t_policy_net in updatePrintInfo function call.");

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYPRINT, Constant.SUCCESS_EVENT, "updatePrintInfo() --- SUCCESSFULLY!");
				ReturnResult = true;
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 4 : Update t_policy_net for assign action
////////////////////////////////////////////////////////

	public boolean acceptPlyAssign(String in_ply_no, String in_assign_emp, String in_assign_tm, String in_sended_tm, String in_feedbk_tm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				boolean input_sended_tm = true;
				boolean input_feedbk_tm = true;

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_ply_no==null) || (in_ply_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlyAssign() --- BSNS_INVALIDPLYNO");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPLYNO);         //  Modify Exceoption
				}

				if ((in_assign_emp==null) || (in_assign_emp.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlyAssign() --- BSNS_INVALIDSENDEMP");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDSENDEMP);         //  Modify Exceoption
				}

				if ((in_assign_tm==null) || (in_assign_tm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlyAssign() --- BSNS_INVALIDASSNTM");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDASSNTM);         //  Modify Exceoption
				}

				if ((in_sended_tm==null) || (in_sended_tm.length()==0))
						input_sended_tm=false;

				if ((in_feedbk_tm==null) || (in_feedbk_tm.length()==0))
						input_feedbk_tm=false;

				String sqlString ="";
				String[][] sqlParameters = new String [6][3];

//Update t_policy_net
				if (!input_sended_tm && !input_feedbk_tm){
					 sqlString =Sqlstmt.UPDATE_ASSIGNTM;             //SQL
					 String [][] sqlParameters1 =
							{{"c_send_emp_cde",   in_assign_emp,  String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"t_send_tm",        in_assign_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"c_ply_no",         in_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)}};
					 sqlParameters = sqlParameters1;
				}

				if (input_sended_tm && !input_feedbk_tm){
					 sqlString =Sqlstmt.UPDATE_ASSNSENDTM;             //SQL
					 String [][] sqlParameters2 =
							{{"c_send_emp_cde",   in_assign_emp,  String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"t_send_tm",        in_assign_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"t_sended_tm",      in_sended_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"c_ply_no",         in_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)}};
					 sqlParameters = sqlParameters2;
				}

				if (!input_sended_tm && input_feedbk_tm){
							new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlyAssign() --- BSNS_INVALIDSENDTM");

							r_pm.freeConnection (r_dbname,r_conn);

							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDSENDTM);         //  Modify Exceoption

				}

				if (input_sended_tm && input_feedbk_tm){
					 sqlString =Sqlstmt.UPDATE_ASSNSENDFDBKTM;             //SQL
					 String [][] sqlParameters3 =
							{{"c_send_emp_cde",   in_assign_emp,  String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"t_send_tm",        in_assign_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"t_sended_tm",      in_sended_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"t_feedback_tm",    in_feedbk_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"c_ply_no",         in_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)}};
					 sqlParameters = sqlParameters3;
				}

				ConnectDB UpdateAssignTm = new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateAssignTm.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.SUCCESS_EVENT, "acceptPlyAssign() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 5 : Update t_policy_net for Policy Sended action
////////////////////////////////////////////////////////

	public boolean acceptPlySended(String in_ply_no, String in_sended_tm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_ply_no==null) || (in_ply_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlySended() --- BSNS_INVALIDPLYNO");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPLYNO);         //  Modify Exceoption
				}

				if ((in_sended_tm==null) || (in_sended_tm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlySended() --- BSNS_INVALIDSENDTM");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDSENDTM);         //  Modify Exceoption
				}

//Update t_policy_net
				String sqlString =Sqlstmt.UPDATE_SENDEDTM;             //SQL
				String [][] sqlParameters =
							{{"t_sended_tm",      in_sended_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"c_ply_no",         in_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateSendedTm = new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateSendedTm.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.SUCCESS_EVENT, "acceptPlySended() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 6 : Update t_policy_net for Freeback action
////////////////////////////////////////////////////////

	public boolean acceptPlyFreebk(String in_ply_no, String in_freebk_tm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_ply_no==null) || (in_ply_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlyFreebk() --- BSNS_INVALIDPLYNO");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPLYNO);         //  Modify Exceoption
				}

				if ((in_freebk_tm==null) || (in_freebk_tm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "acceptPlyFreebk() --- BSNS_INVALIDFDBKTM");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFDBKTM);         //  Modify Exceoption
				}

//Update t_policy_net
				String sqlString =Sqlstmt.UPDATE_FREEBKTM;             //SQL
				String [][] sqlParameters =
							{{"t_feedback_tm",    in_freebk_tm,   String.valueOf(Constant.DATETIME_TYPE)},
							 {"c_ply_no",         in_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateFreebkTm = new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateFreebkTm.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.SUCCESS_EVENT, "acceptPlyFreebk() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


///////////////////////////////////////////////////////////////////////
// Use Case 7 : Query Available employee Name List of owned Department
///////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryPlyNetAbleEmp(String in_dpt_cde, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyNetAbleEmp() --- BSNS_INVALIDDPTCDE");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDPTCDE);     // Modify Exception CODE
				}

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyNetAbleEmp() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);     // Modify Exception CODE
				}

				String sqlString =Sqlstmt.SELECT_PLYNETABLEEMP;       //SQL    Select from t_emp_cde
				String [][] sqlParameters= {{"c_dpt_cde",in_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryPlyNetAbleEmp= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (QueryPlyNetAbleEmp.GetReturnCode()) {
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
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYDELIVEY, Constant.SUCCESS_EVENT, "queryPlyNetAbleEmp() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPlyNetAbleEmp.GetReturnArray();
		}


//////////////////////////////////////////////////////////////////////////////////////
// Use Case 8 : Get policy Net information List for View policy form Handling Status//
//////////////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryPlyDealList(String in_deal_type, String in_deal_flg, String in_ply_no,
																							 String frm_plyapp_tm,String to_plyapp_tm,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 java.lang.String[] dpt_array, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyDealList() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_deal_type==null) || (in_deal_type.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyDealList() --- BSNS_INVALIDDEALTYPE");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDEALTYPE);         //  Modify Exceoption
				}
				boolean deal_flg = true;
				boolean input_ply_no = true;
				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;

				String sqlString = Sqlstmt.SELECT_PLYDEAL;
				String NoAssn_sqlString = " AND A.c_send_emp_cde IS NULL AND A.t_send_tm IS NULL ";
				String Assn_sqlString = " AND A.c_send_emp_cde IS NOT NULL AND A.t_send_tm IS NOT NULL ";
				String NoSend_sqlString = " AND A.t_sended_tm IS NULL ";
				String Send_sqlString = " AND A.t_sended_tm IS NOT NULL ";
				String NoFrbk_sqlString = " AND A.t_feedback_tm IS NULL ";
				String Frbk_sqlString = " AND A.t_feedback_tm IS NOT NULL ";

				if ((in_deal_type.equals(Constant.ASSN_MRK)) ||
						(in_deal_type.equals(Constant.SEND_MRK)) ||
						(in_deal_type.equals(Constant.FRBK_MRK))){

					if ((in_deal_flg==null) || (in_deal_flg.length()==0)){
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyDealList() --- BSNS_INVALIDDEALFLAG");
							r_pm.freeConnection (r_dbname,r_conn);
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDDEALFLAG);         //  Modify Exceoption
					}

					if ((in_deal_flg.equals(Constant.NOTDEAL_MRK)) ||
							(in_deal_flg.equals(Constant.ALREADY_MRK)) ||
							(in_deal_flg.equals(Constant.ALLDEAL_MRK))){
						deal_flg = true;
					}else{
						deal_flg = false;
					}
					if (!deal_flg) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyDealList() --- BSNS_INVALIDDEALFLAG");
							r_pm.freeConnection (r_dbname,r_conn);
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDDEALFLAG);         //  Modify Exceoption
					}
				}else{
					if (!(in_deal_type.equals(Constant.DEAL_MRK))){
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYDELIVEY, Constant.FAIL_EVENT, "queryPlyDealList() --- BSNS_INVALIDDEALTYPE");
							r_pm.freeConnection (r_dbname,r_conn);
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDDEALTYPE);         //  Modify Exceoption
					}
				}

				if ((in_ply_no==null) || (in_ply_no.length()==0))
						input_ply_no=false;

				if ((frm_plyapp_tm==null) || (frm_plyapp_tm.length()==0))
						input_frm_tm=false;

				if ((to_plyapp_tm==null) || (to_plyapp_tm.length()==0))
						input_to_tm=false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins=false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins=false;

// Construct the SQL statement for Query DB
				if (in_deal_type.equals(Constant.ASSN_MRK)){
						if (in_deal_flg.equals(Constant.NOTDEAL_MRK))
								sqlString = sqlString + NoAssn_sqlString;  //SQL
						if (in_deal_flg.equals(Constant.ALREADY_MRK))
								sqlString = sqlString + Assn_sqlString;    //SQL
				}
				if (in_deal_type.equals(Constant.SEND_MRK)){
						if (in_deal_flg.equals(Constant.NOTDEAL_MRK))
								sqlString = sqlString + NoSend_sqlString;  //SQL
						if (in_deal_flg.equals(Constant.ALREADY_MRK))
								sqlString = sqlString + Send_sqlString;    //SQL
				}
				if (in_deal_type.equals(Constant.FRBK_MRK)){
						if (in_deal_flg.equals(Constant.NOTDEAL_MRK))
								sqlString = sqlString + NoFrbk_sqlString;  //SQL
						if (in_deal_flg.equals(Constant.ALREADY_MRK))
								sqlString = sqlString + Frbk_sqlString;    //SQL
				}

				if (input_ply_no) {
						String tmp_sqlString = " AND A.c_ply_no = '"+in_ply_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND D.t_undr_tm >= TO_DATE('"+frm_plyapp_tm+"', 'YYYY-MM-DD hh24:mi:ss')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND D.t_undr_tm <= TO_DATE('"+to_plyapp_tm+"', 'YYYY-MM-DD hh24:mi:ss')";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND D.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND D.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (dpt_array[0].length() > 0){
						int dptarray_len = dpt_array.length;
						String dpt_sqlString = " AND D.c_dpt_cde IN (";

						for (int i = 0; i < dptarray_len ; i++){
							 if ((i-dptarray_len+1)==0)
									dpt_sqlString = dpt_sqlString + "'" + dpt_array[i] + "'";
							 else
									dpt_sqlString = dpt_sqlString + "'" + dpt_array[i] + "', ";
						}
						sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
				}

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryPlyDealNetList= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);

				switch (QueryPlyDealNetList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_PLCYDELIVEY, Constant.SUCCESS_EVENT, "queryPlyDealList() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPlyDealNetList.GetReturnArray ();

		}


///////////////////////////////////////////////////////////////////////////////////////////////////
// Use Case 9 : Get Case Report Following Up information List for assign employee to follow case //
///////////////////////////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryRptFlwUpList(String in_deal_type, String in_deal_flg,
																							 String in_ply_no, String in_rpt_no,
																							 String frm_rpt_tm,String to_rpt_tm,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 java.lang.String[] dpt_array, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "queryRptFlwUpList() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_deal_type==null) || (in_deal_type.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "queryRptFlwUpList() --- BSNS_INVALIDDEALTYPE");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDEALTYPE);         //  Modify Exceoption
				}

				boolean deal_flg = true;
				boolean input_ply_no = true;
				boolean input_rpt_no = true;
				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;

				String sqlString = Sqlstmt.SELECT_RPTFLWUP;
				String Plus_sqlString = " AND (B.t_adb_tm is null or B.t_adb_tm >= SYSDATE) AND (C.t_adb_tm is null or C.t_adb_tm >= SYSDATE) AND (D.t_adb_tm is null or D.t_adb_tm >= SYSDATE) ";
				String NoRcvr_sqlString = " AND A.c_contact_name IS NULL AND (B.t_adb_tm is null or B.t_adb_tm >= SYSDATE) AND (C.t_adb_tm is null or C.t_adb_tm >= SYSDATE) AND (D.t_adb_tm is null or D.t_adb_tm >= SYSDATE) ";
				String Rcvr_sqlString = " AND A.c_contact_name IS NOT NULL AND (B.t_adb_tm is null or B.t_adb_tm >= SYSDATE) AND (C.t_adb_tm is null or C.t_adb_tm >= SYSDATE) AND (D.t_adb_tm is null or D.t_adb_tm >= SYSDATE) ";
				String NoRgst_sqlString = " AND A.c_clm_rgst_mrk = '0' AND (B.t_adb_tm is null or B.t_adb_tm >= SYSDATE) AND (C.t_adb_tm is null or C.t_adb_tm >= SYSDATE) AND (D.t_adb_tm is null or D.t_adb_tm >= SYSDATE) ";
				String Rgst_sqlString = " AND A.c_clm_rgst_mrk = '1' AND (B.t_adb_tm is null or B.t_adb_tm >= SYSDATE) AND (C.t_adb_tm is null or C.t_adb_tm >= SYSDATE) AND (D.t_adb_tm is null or D.t_adb_tm >= SYSDATE) ";

				if ((in_deal_type.equals(Constant.RCVR_MRK)) ||
						(in_deal_type.equals(Constant.RGST_MRK))){

					if ((in_deal_flg==null) || (in_deal_flg.length()==0)){
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "queryRptFlwUpList() --- BSNS_INVALIDDEALFLAG");
							r_pm.freeConnection (r_dbname,r_conn);
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDDEALFLAG);         //  Modify Exceoption
					}

					if ((in_deal_flg.equals(Constant.NOTDEAL_MRK)) ||
							(in_deal_flg.equals(Constant.ALREADY_MRK)) ||
							(in_deal_flg.equals(Constant.ALLDEAL_MRK))){
						deal_flg = true;
					}else{
						deal_flg = false;
					}
					if (!deal_flg) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "queryRptFlwUpList() --- BSNS_INVALIDDEALFLAG");
							r_pm.freeConnection (r_dbname,r_conn);
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDDEALFLAG);         //  Modify Exceoption
					}

				}else{
					if (!(in_deal_type.equals(Constant.DEAL_MRK))){
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "queryRptFlwUpList() --- BSNS_INVALIDDEALTYPE");
							r_pm.freeConnection (r_dbname,r_conn);
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDDEALTYPE);         //  Modify Exceoption
					}
				}

				if ((in_rpt_no==null) || (in_rpt_no.length()==0))
						input_rpt_no=false;

				if ((in_ply_no==null) || (in_ply_no.length()==0))
						input_ply_no=false;

				if ((frm_rpt_tm==null) || (frm_rpt_tm.length()==0))
						input_frm_tm=false;

				if ((to_rpt_tm==null) || (to_rpt_tm.length()==0))
						input_to_tm=false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins=false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins=false;

// Construct the SQL statement for Query DB
				if (input_ply_no) {
						String tmp_sqlString = " AND A.c_ply_no = '"+in_ply_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_rpt_no) {
						String tmp_sqlString = " AND A.c_rpt_no = '"+in_rpt_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND A.t_rtp_tm >= TO_DATE('"+frm_rpt_tm+"', 'YYYY-MM-DD hh24:mi:ss')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND A.t_rtp_tm <= TO_DATE('"+to_rpt_tm+"', 'YYYY-MM-DD hh24:mi:ss')";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (dpt_array[0].length() > 0){
						int dptarray_len = dpt_array.length;
						String dpt_sqlString = " AND A.c_dpt_cde IN (";

						for (int i = 0; i < dptarray_len ; i++){
							 if ((i-dptarray_len+1)==0)
									dpt_sqlString = dpt_sqlString + "'" + dpt_array[i] + "'";
							 else
									dpt_sqlString = dpt_sqlString + "'" + dpt_array[i] + "', ";
						}
						sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
				}

				if (in_deal_type.equals(Constant.DEAL_MRK)){
						sqlString = sqlString + Plus_sqlString;       //SQL
				}
				if (in_deal_type.equals(Constant.RCVR_MRK)){
						if (in_deal_flg.equals(Constant.ALLDEAL_MRK))
								sqlString = sqlString + Plus_sqlString;    //SQL
						if (in_deal_flg.equals(Constant.NOTDEAL_MRK))
								sqlString = sqlString + NoRcvr_sqlString;  //SQL
						if (in_deal_flg.equals(Constant.ALREADY_MRK))
								sqlString = sqlString + Rcvr_sqlString;    //SQL
				}
				if (in_deal_type.equals(Constant.RGST_MRK)){
						if (in_deal_flg.equals(Constant.ALLDEAL_MRK))
								sqlString = sqlString + Plus_sqlString;    //SQL
						if (in_deal_flg.equals(Constant.NOTDEAL_MRK))
								sqlString = sqlString + NoRgst_sqlString;  //SQL
						if (in_deal_flg.equals(Constant.ALREADY_MRK))
								sqlString = sqlString + Rgst_sqlString;    //SQL
				}

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryRptFlwUpList= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);

				switch (QueryRptFlwUpList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.SUCCESS_EVENT, "queryRptFlwUpList() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryRptFlwUpList.GetReturnArray ();

		}


///////////////////////////////////////////////////////////////////////////////
// Use Case 10 : Update t_clmrpt for employee assignment to Following up action
///////////////////////////////////////////////////////////////////////////////

	public boolean acceptRptFlwUpEmp(String in_rpt_no, String in_emp_cde, String auth_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((auth_opr_cde==null) || (auth_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "acceptRptFlwUpEmp() --- OPR_INVALIDAUTH");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);         //  Modify Exceoption
				}

				if ((in_rpt_no==null) || (in_rpt_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "acceptRptFlwUpEmp() --- BSNS_INVALIDRPTNO");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDRPTNO);         //  Modify Exceoption
				}

				if ((in_emp_cde==null) || (in_emp_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "acceptRptFlwUpEmp() --- OPR_INVALIDPARM");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);         //  Modify Exceoption
				}

//Update t_clmrpt
				String sqlString =Sqlstmt.UPDATE_FLWUPEMP;             //SQL
				String [][] sqlParameters =
							{{"c_contact_name",   in_emp_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_rpt_no",         in_rpt_no,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateFlwUpEmp = new ConnectDB (r_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateFlwUpEmp.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_CASEFLLWUP, Constant.SUCCESS_EVENT, "acceptRptFlwUpEmp() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}



///////////////////////////////////////////////////////////////////////
// Use Case 11 : Query Event Type List for PA System Log query
///////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryEventTypeList(String in_event_cde)
				throws com.mcip.orb.CoException {

				String [][] ReturnResult = new String [2][2];

				String SqlStatement=new String("");

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_event_cde==null) || (in_event_cde.length()==0)){

					SqlStatement=Sqlstmt.SELECT_EVENLIST1;
					ConnectDB QueryEventTypInfo1 = new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QueryEventTypInfo1.GetReturnCode()) {
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
					ReturnResult = QueryEventTypInfo1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECT_EVENLIST2;
					String [][] sqlParameters= {{"c_event",in_event_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryEventTypInfo2 = new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
					switch (QueryEventTypInfo2.GetReturnCode()) {
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
					ReturnResult = QueryEventTypInfo2.GetReturnArray ();
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CODETABLE, Constant.SUCCESS_EVENT, "queryEventTypeList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


/////////////////////////////////////////////////////////////////////////
// Query Event Log Count ALL List for PA System Log summary
/////////////////////////////////////////////////////////////////////////

	public java.lang.String EventCount(String count_type, String frm_log_tm, String to_log_tm, String in_event_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				boolean count_flg = false;
				String ReturnResult = new String("");
				String SqlStatement = new String("");

				if (count_type.equals(Constant.TOTAL_EVENT))
				SqlStatement = Sqlstmt.SELECT_EVENTCOUNTALL;

				if (count_type.equals(Constant.SUCCESS_EVENT))
				SqlStatement = Sqlstmt.SELECT_EVENTCOUNTSUCC;

				if (count_type.equals(Constant.FAIL_EVENT))
				SqlStatement = Sqlstmt.SELECT_EVENTCOUNTFAIL;

				String [][] sqlParameters= {{"frm_log_tm",frm_log_tm,String.valueOf(Constant.DATE_TYPE)},
																		{"to_log_tm",to_log_tm,String.valueOf(Constant.DATE_TYPE)},
																		{"c_event",in_event_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryEventCount = new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryEventCount.GetReturnCode()) {
					 case Constant.ConnectDB_SelectNone:
								count_flg = false;
								break;
					 case Constant.ConnectDB_SelectMulti:
					 case Constant.ConnectDB_SelectOne:
								count_flg = true;
								break;
					 default:
								l_pm.freeConnection (l_dbname,l_conn);
								ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				};

				if (!count_flg){
				ReturnResult = "0";
				}else{
				String[][] Res = QueryEventCount.GetReturnArray ();
				ReturnResult = Res[1][1];
				}

				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


/////////////////////////////////////////////////////////////////////////
// Use Case 12 : Query Event Log Count List for PA System Log summary
/////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryEventCountList(String frm_log_tm,
				String to_log_tm, String in_event_type, String in_event_cde, String in_opr_cde)
				throws com.mcip.orb.CoException {
                System.out.println("liuyn debug 0704--frm_log_tm"+frm_log_tm);
				System.out.println("liuyn debug 0704--to_log_tm"+to_log_tm);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_BUSIMANAGE, Constant.FAIL_EVENT, "queryEventCountList() --- BSNS_INVALIDOPRID");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_event_type==null) || (in_event_type.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_BUSIMANAGE, Constant.FAIL_EVENT, "queryEventCountList() --- BSNS_INVALIDEVENTTYP");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDEVENTTYP);         //  Modify Exceoption
				}

				if ((frm_log_tm==null) || (frm_log_tm.length()==0) ||
						(to_log_tm==null) || (to_log_tm.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_BUSIMANAGE, Constant.FAIL_EVENT, "queryEventCountList() --- BSNS_INVALIDLOGTIME");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDLOGTIME);         //  Modify Exceoption
				}

//Check query condition type
				if (in_event_type.equals(Constant.SINGLE_EVENT)){

					if ((in_event_cde==null) || (in_event_cde.length()==0)){
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_BUSIMANAGE, Constant.FAIL_EVENT, "queryEventCountList() --- BSNS_INVALIDEVENTTYP");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDEVENTTYP);         //  Modify Exceoption
					}
				}else{
					if (!(in_event_type.equals(Constant.ALL_EVENT))){
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_BUSIMANAGE, Constant.FAIL_EVENT, "queryEventCountList() --- BSNS_INVALIDEVENTTYP");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.BSNS_INVALIDEVENTTYP);         //  Modify Exceoption
					}
				}

				String tmp_variable = new String("");
				String [][] EventTypeRes = new String [2][2];

				if (in_event_type.equals(Constant.SINGLE_EVENT)){
					EventTypeRes = queryEventTypeList(in_event_cde);
				}else{
					EventTypeRes = queryEventTypeList(tmp_variable);
				}

				int EventTypeRes_len = EventTypeRes.length;

				if (EventTypeRes_len < 2) {
					new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_BUSIMANAGE, Constant.FAIL_EVENT, "queryEventCountList() --- DB_FINDNOREC! WARNING!");
					l_pm.freeConnection (l_dbname,l_conn);
					ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
				}

				String[][] ReturnResult = new String [EventTypeRes_len][5];

				for (int i = 0; i < EventTypeRes_len ; i++){
					 if (i==0) {
					 ReturnResult[i][0] = EventTypeRes[i][0];
					 ReturnResult[i][1] = EventTypeRes[i][1];
					 ReturnResult[i][2] = "TOTAL LOG";
					 ReturnResult[i][3] = "SUCCESSFUL LOG";
					 ReturnResult[i][4] = "FAIL LOG";
					 }else{

					 ReturnResult[i][0] = EventTypeRes[i][0];
					 ReturnResult[i][1] = EventTypeRes[i][1];
					 ReturnResult[i][2] = EventCount(Constant.TOTAL_EVENT, frm_log_tm, to_log_tm, EventTypeRes[i][0]);
					 ReturnResult[i][3] = EventCount(Constant.SUCCESS_EVENT, frm_log_tm, to_log_tm, EventTypeRes[i][0]);
					 ReturnResult[i][4] = EventCount(Constant.FAIL_EVENT, frm_log_tm, to_log_tm, EventTypeRes[i][0]);
					 }
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_BUSIMANAGE, Constant.SUCCESS_EVENT, "queryEventCountList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////////
// Use Case 13 :Accept New Insurance Policy Apply Guide Info
////////////////////////////////////////////////////////////

	public boolean acceptGuideInfo(com.mcip.bus.orb.InsrncGuideInfo guideinfoobj, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "acceptGuideInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((guideinfoobj.c_title_no==null) || (guideinfoobj.c_title_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "acceptGuideInfo() --- BSNS_INVALIDTTLNO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDTTLNO);         //  Modify Exceoption
				}

				if ((guideinfoobj.c_title_cnm==null) || (guideinfoobj.c_title_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "acceptGuideInfo() --- BSNS_INVALIDTTLCNM! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDTTLCNM);         //  Modify Exceoption
				}

//Insert into t_insrnc_guide
				String sqlString =Sqlstmt.INSERT_GUIDEINFO;             //SQL
				String [][] sqlParameters =
							{{"c_title_no",       guideinfoobj.c_title_no,         String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_title_cnm",      guideinfoobj.c_title_cnm,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_title_enm",      guideinfoobj.c_title_enm,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_content_cnm",    guideinfoobj.c_content_cnm,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_content_enm",    guideinfoobj.c_content_enm,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertGuideInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertGuideInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.SUCCESS_EVENT, "acceptGuideInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 14 : Update Insurance Policy Apply Guide Info
////////////////////////////////////////////////////////

	public boolean updateGuideInfo(com.mcip.bus.orb.InsrncGuideInfo guideinfoobj, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "updateGuideInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((guideinfoobj.c_info_no==null) || (guideinfoobj.c_info_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "updateGuideInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

				if ((guideinfoobj.c_title_no==null) || (guideinfoobj.c_title_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "acceptGuideInfo() --- BSNS_INVALIDTTLNO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDTTLNO);         //  Modify Exceoption
				}

				if ((guideinfoobj.c_title_cnm==null) || (guideinfoobj.c_title_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "acceptGuideInfo() --- BSNS_INVALIDTTLCNM! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDTTLCNM);         //  Modify Exceoption
				}

//Update t_insrnc_guide
				String sqlString =Sqlstmt.UPDATE_GUIDEINFO;             //SQL
				String [][] sqlParameters =
							{{"c_title_no",       guideinfoobj.c_title_no,         String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_title_cnm",      guideinfoobj.c_title_cnm,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_title_enm",      guideinfoobj.c_title_enm,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_content_cnm",    guideinfoobj.c_content_cnm,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_content_enm",    guideinfoobj.c_content_enm,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_info_no",        guideinfoobj.c_info_no,          String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateGuideInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateGuideInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.SUCCESS_EVENT, "updateGuideInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 15 : Delete Insurance Policy Apply Guide Info
////////////////////////////////////////////////////////

	public boolean deleteGuideInfo(String in_info_no, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "deleteGuideInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_info_no==null) || (in_info_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.FAIL_EVENT, "deleteGuideInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

//Delete from t_insrnc_guide
				String sqlString = Sqlstmt.DELETE_GUIDEINFO;             //SQL
				String [][] sqlParameters =
							{{"c_info_no",    in_info_no,   String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteGuideInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeleteGuideInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCGUIDE, Constant.SUCCESS_EVENT, "deleteGuideInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 16 : Query Insurance Policy Apply Guide List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryGuideList(String in_info_no, String in_opr_cnm)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCGUIDE, Constant.FAIL_EVENT, "queryGuideList() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				String [][] ReturnResult = new String [2][6];
				String SqlStatement=new String("");

				if ((in_info_no==null) || (in_info_no.length()==0)){

					SqlStatement=Sqlstmt.SELECT_GUIDELIST1;
					ConnectDB QueryGuideList1= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QueryGuideList1.GetReturnCode()) {
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
					ReturnResult = QueryGuideList1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECT_GUIDELIST2;
					String [][] sqlParameters= {{"c_info_no",    in_info_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryGuideList2= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

					switch (QueryGuideList2.GetReturnCode()) {
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
					ReturnResult = QueryGuideList2.GetReturnArray ();
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_INSRNCGUIDE, Constant.SUCCESS_EVENT, "queryGuideList() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 17 : Query Insurance Policy Apply Guide Info
////////////////////////////////////////////////////////

	public java.lang.String[][] queryGuideInfo(String in_info_no, String in_opr_cnm)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCGUIDE, Constant.FAIL_EVENT, "queryGuideInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_info_no==null) || (in_info_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_INSRNCGUIDE, Constant.FAIL_EVENT, "queryGuideInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

				String SqlStatement=Sqlstmt.SELECT_GUIDEINFO;
				String [][] sqlParameters= {{"c_info_no",    in_info_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryGuideInfo= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryGuideInfo.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_INSRNCGUIDE, Constant.SUCCESS_EVENT, "queryGuideInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryGuideInfo.GetReturnArray ();
		}


////////////////////////////////////////////////////////////
// Use Case 18 :Accept New Insurance Consult Info
////////////////////////////////////////////////////////////

	public boolean acceptConsultInfo(com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptConsultInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((insrncfaqinfoobj.c_faq_emp==null) || (insrncfaqinfoobj.c_faq_emp.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptConsultInfo() --- BSNS_INVALIDFAQEMP! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQEMP);         //  Modify Exceoption
				}

				if ((insrncfaqinfoobj.c_faq_title==null) || (insrncfaqinfoobj.c_faq_title.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptConsultInfo() --- BSNS_INVALIDFAQTITLE! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQTITLE);         //  Modify Exceoption
				}

//Insert into t_faq_info
				String sqlString =Sqlstmt.INSERT_CONSULTINFO;             //SQL
				String [][] sqlParameters =
							{{"c_faq_emp",      insrncfaqinfoobj.c_faq_emp,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_title",    insrncfaqinfoobj.c_faq_title,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_content",  insrncfaqinfoobj.c_faq_content,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_topic_no",     insrncfaqinfoobj.c_topic_no,       String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertConsultInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertConsultInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "acceptConsultInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 19 : Update Insurance Consult Info
////////////////////////////////////////////////////////

	public boolean updateConsultInfo(com.mcip.bus.orb.InsrncFaqInfo insrncfaqinfoobj, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "updateConsultInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((insrncfaqinfoobj.c_faq_no==null) || (insrncfaqinfoobj.c_faq_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "updateConsultInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

				if ((insrncfaqinfoobj.c_faq_emp==null) || (insrncfaqinfoobj.c_faq_emp.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "updateConsultInfo() --- BSNS_INVALIDFAQEMP! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQEMP);         //  Modify Exceoption
				}

				if ((insrncfaqinfoobj.c_faq_title==null) || (insrncfaqinfoobj.c_faq_title.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "updateConsultInfo() --- BSNS_INVALIDFAQTITLE! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQTITLE);         //  Modify Exceoption
				}

//Update t_faq_info
				String sqlString =Sqlstmt.UPDATE_CONSULTINFO;             //SQL
				String [][] sqlParameters =
							{{"c_faq_emp",      insrncfaqinfoobj.c_faq_emp,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_title",    insrncfaqinfoobj.c_faq_title,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_content",  insrncfaqinfoobj.c_faq_content,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_topic_no",     insrncfaqinfoobj.c_topic_no,       String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_no",       insrncfaqinfoobj.c_faq_no,         String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateConsultInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateConsultInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "updateConsultInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


//////////////////////////////////////////////////////////////////////////////////////
// Common Routine for all case
// Check the department code of new operator in Authority operator department scale //
// False -- not in authority Department or employee not exist; True -- employee exist and in authority Department
//////////////////////////////////////////////////////////////////////////////////////
	public boolean checkTopicSub(String in_faq_no)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				String sqlString =Sqlstmt.SELECT_CHKTOPICSUB;          // SQL
				String [][] sqlParameters= {{"c_topic_no",   in_faq_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB chktopicsub = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (chktopicsub.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = true;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult =false;
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 20 : Delete Insurance Consult Info
////////////////////////////////////////////////////////

	public boolean deleteConsultInfo(String in_faq_no, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "deleteConsultInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_faq_no==null) || (in_faq_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "deleteConsultInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

				if (!checkTopicSub(in_faq_no)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "deleteConsultInfo() --- Topic with detail content ! BSNS_WITHSUBCONTENT! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_WITHSUBCONTENT);         //  Modify Exceoption
				}

//Delete from t_faq_info
				String sqlString = Sqlstmt.DELETE_CONSULTINFO;             //SQL
				String [][] sqlParameters =
							{{"c_faq_no",    in_faq_no,   String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteConsultInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeleteConsultInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "deleteConsultInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 21 : Query Insurance Consult List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryConsultList(String in_topic_no, String in_opr_cnm)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "queryConsultList() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");

				if ((in_topic_no==null) || (in_topic_no.length()==0)){

					SqlStatement=Sqlstmt.SELECT_CONSULTLIST1;
					ConnectDB QueryConsultList1= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QueryConsultList1.GetReturnCode()) {
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
					ReturnResult = QueryConsultList1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECT_CONSULTLIST2;
					String [][] sqlParameters= {{"c_topic_no",    in_topic_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryConsultList2= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
					switch (QueryConsultList2.GetReturnCode()) {
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
					ReturnResult = QueryConsultList2.GetReturnArray ();
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_INSRNCFAQ, Constant.SUCCESS_EVENT, "queryConsultList() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 22 : Query Insurance Consult Info
////////////////////////////////////////////////////////

	public java.lang.String[][] queryConsultInfo(String in_faq_no, String in_opr_cnm)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "queryConsultInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_faq_no==null) || (in_faq_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "queryConsultInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

				String SqlStatement=Sqlstmt.SELECT_CONSULTINFO;
				String [][] sqlParameters= {{"c_faq_no",    in_faq_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryConsultInfo= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryConsultInfo.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_INSRNCFAQ, Constant.SUCCESS_EVENT, "queryConsultInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryConsultInfo.GetReturnArray ();
		}


////////////////////////////////////////////////////////////
// Use Case 23 :Accept New Insurance FAQ Info
////////////////////////////////////////////////////////////

	public boolean acceptFaqInfo(com.mcip.bus.orb.CustFaqInfo custfaqinfoobj, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptFaqInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((custfaqinfoobj.c_faq_psn==null) || (custfaqinfoobj.c_faq_psn.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptFaqInfo() --- BSNS_INVALIDFAQPSN! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQPSN);         //  Modify Exceoption
				}

				if ((custfaqinfoobj.c_faq_email==null) || (custfaqinfoobj.c_faq_email.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptFaqInfo() --- BSNS_INVALIDFAQEMAIL! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQEMAIL);         //  Modify Exceoption
				}

				if ((custfaqinfoobj.c_faq_title==null) || (custfaqinfoobj.c_faq_title.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptFaqInfo() --- no faq title ! BSNS_INVALIDFAQPTTL! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDFAQPTTL);         //  Modify Exceoption
				}

//Insert into t_faq
				String sqlString =Sqlstmt.INSERT_FAQINFO;             //SQL
				String [][] sqlParameters =
							{{"c_faq_psn",      custfaqinfoobj.c_faq_psn,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_email",    custfaqinfoobj.c_faq_email,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_title",    custfaqinfoobj.c_faq_title,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_content",  custfaqinfoobj.c_faq_content,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertFaqInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertFaqInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "acceptFaqInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 24 : Update Insurance FAQ Info
////////////////////////////////////////////////////////

	public boolean updateFaqInfo(com.mcip.bus.orb.CustFaqInfo custfaqinfoobj, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "updateFaqInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((custfaqinfoobj.c_faq_no==null) || (custfaqinfoobj.c_faq_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "acceptFaqInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

//Update t_faq
				String sqlString =Sqlstmt.UPDATE_FAQINFO;             //SQL
				String [][] sqlParameters =
							{{"c_reply_cont",   custfaqinfoobj.c_reply_cont,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_reply_emp",    custfaqinfoobj.c_reply_emp,     String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_faq_no",       custfaqinfoobj.c_faq_no,        String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateFaqInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateFaqInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "updateFaqInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 25 : Delete Insurance FAQ Info
////////////////////////////////////////////////////////

	public boolean deleteFaqInfo(String in_faq_no, String in_opr_cnm)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "deleteFaqInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_faq_no==null) || (in_faq_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "deleteFaqInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

//Delete from t_faq
				String sqlString = Sqlstmt.DELETE_FAQINFO;             //SQL
				String [][] sqlParameters =
							{{"c_faq_no",    in_faq_no,   String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteFaqInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeleteFaqInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "deleteFaqInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 26 : Query Insurance FAQ List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryFaqList(String in_faq_no, String in_opr_cnm)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "queryFaqList() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				String [][] ReturnResult = new String [2][7];
				String SqlStatement=new String("");

				if ((in_faq_no==null) || (in_faq_no.length()==0)){

					SqlStatement=Sqlstmt.SELECT_FAQLIST1;
					ConnectDB QueryFaqList1= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QueryFaqList1.GetReturnCode()) {
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
					ReturnResult = QueryFaqList1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECT_FAQLIST2;
					String [][] sqlParameters= {{"c_faq_no",    in_faq_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryFaqList2= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

					switch (QueryFaqList2.GetReturnCode()) {
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
					ReturnResult = QueryFaqList2.GetReturnArray ();
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "queryFaqList() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 27 : Query Insurance FAQ Info
////////////////////////////////////////////////////////

	public java.lang.String[][] queryFaqInfo(String in_faq_no, String in_opr_cnm)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cnm==null) || (in_opr_cnm.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "queryFaqInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_faq_no==null) || (in_faq_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.FAIL_EVENT, "queryFaqInfo() --- BSNS_INVALIDINFONO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDINFONO);         //  Modify Exceoption
				}

				String SqlStatement=Sqlstmt.SELECT_FAQINFO;
				String [][] sqlParameters= {{"c_faq_no",    in_faq_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryFaqInfo= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryFaqInfo.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cnm, Constant.LOG_MINSRNCFAQ, Constant.SUCCESS_EVENT, "queryFaqInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryFaqInfo.GetReturnArray ();
		}


//////////////////////////////////////////////////////////////////////////////
// Use Case 28 : Get policy Apply Form List for Summary statictics          //
//////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getPlyAppStatictics(String frm_plyapp_tm, String to_plyapp_tm, java.lang.String[] owned_dpt,
																							 String frm_dpt,String expand,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 String in_cur_cde, String in_site_cde,
																							 String in_stat_type, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getPlyAppStatictics() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((in_stat_type==null) || (in_stat_type.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getPlyAppStatictics() --- BSNS_INVALIDDEALTYPE");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDEALFLAG);         //  Modify Exceoption
				}

				boolean input_stat_type = true;
				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;
				boolean input_frm_dpt = true;
				boolean input_expand = true;
				boolean input_cur_cde = true;
				boolean input_site_cde = true;

				if ((in_stat_type.equals(Constant.NOT_UDR_MRK)) ||
						(in_stat_type.equals(Constant.UDR_MRK)) ||
						(in_stat_type.equals(Constant.PRPSL_MRK)) ||
						(in_stat_type.equals(Constant.ALL_MRK))){
						input_stat_type = true;
				}else{
						input_stat_type = false;
				}

				if (!input_stat_type) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getPlyAppStatictics() --- BSNS_INVALIDDEALFLAG");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDEALFLAG);         //  Modify Exceoption
				}

				if ((frm_plyapp_tm==null) || (frm_plyapp_tm.length()==0))
						input_frm_tm = false;

				if ((to_plyapp_tm==null) || (to_plyapp_tm.length()==0))
						input_to_tm = false;

				if ((frm_dpt==null) || (frm_dpt.length()==0))
						input_frm_dpt = false;

				if ((expand==null) || (expand.length()==0))
						input_expand = false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins = false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins = false;

				if ((in_cur_cde==null) || (in_cur_cde.length()==0))
						input_cur_cde = false;

				if ((in_site_cde==null) || (in_site_cde.length()==0))
						input_site_cde = false;

				String sqlString = new String("");

				if (in_stat_type.equals(Constant.NOT_UDR_MRK))
						sqlString=Sqlstmt.SELECT_PLYAPPSTA_NOTUDR;

				if (in_stat_type.equals(Constant.UDR_MRK))
						sqlString=Sqlstmt.SELECT_PLYAPPSTA_UDR;

				if (in_stat_type.equals(Constant.PRPSL_MRK))
						sqlString=Sqlstmt.SELECT_PLYAPPSTA_PRPSL;

				if (in_stat_type.equals(Constant.ALL_MRK))
						sqlString=Sqlstmt.SELECT_PLYAPPSTA_ALL;

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND A.t_crt_tm >= TO_DATE('"+frm_plyapp_tm+"', 'YYYY-MM-DD')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND A.t_crt_tm <= TO_DATE('"+to_plyapp_tm+"', 'YYYY-MM-DD')+1";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_cur_cde) {
						String tmp_sqlString = " AND A.c_prm_cur = '"+in_cur_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}
					System.out.println("from depart code:"+frm_dpt+"\ninput_frm_dpt:"+input_frm_dpt);
				if (input_frm_dpt) {
							String tmp_sqlString = " AND A.c_dpt_cde like '"+frm_dpt+expand+"'";
							sqlString = sqlString + tmp_sqlString;
				}else{
					if (owned_dpt[0].length() > 0){
							 int dptarray_len = owned_dpt.length;
							 String dpt_sqlString = " ";
							 for (int i = 0; i < dptarray_len ; i++){
											dpt_sqlString = dpt_sqlString + " AND A.c_dpt_cde like '" + owned_dpt[i] + expand+"' ";
								}
								sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
					}
				}

				if (input_site_cde) {
						String tmp_sqlString = " AND B.c_site_cde = '"+in_site_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (in_stat_type.equals(Constant.PRPSL_MRK)) {
//            sqlString = sqlString + " GROUP BY A.c_ply_app_no,A.c_dpt_cde,A.c_insrnc_cde,A.n_amt,A.c_amt_cur,A.n_rate,A.n_prm,A.c_prm_cur,A.c_undr_prsn, A.t_undr_tm, B.c_site_cde,C.c_dpt_cnm,D.c_insrnc_cnm ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_ply_app_no";
						sqlString = sqlString + " GROUP BY A.c_ply_app_no,A.c_dpt_cde,A.c_insrnc_cde,A.c_insrnt_nme,A.n_amt,A.c_amt_cur,A.n_rate,A.n_prm,A.c_prm_cur,A.c_undr_prsn, A.t_crt_tm, B.c_site_cde,C.c_dpt_abr,D.c_insrnc_cnm,E.c_cur_cnm,F.c_cur_cnm ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_ply_app_no";
				}else{
						sqlString = sqlString + " ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_ply_app_no";
				}

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryPlyAppStatictics= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryPlyAppStatictics.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getPlyAppStatictics() --- SUCCESSFULLY! ");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPlyAppStatictics.GetReturnArray ();
	}


//////////////////////////////////////////////////////////////////////////////
// Use Case 29 : Get policy List for Summary statictics          //
//////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getPolicyStatictics(String frm_plyapp_tm, String to_plyapp_tm, java.lang.String[] owned_dpt,
																							 String frm_dpt,String expand,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 String in_cur_cde, String in_site_cde, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getPolicyStatictics() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;
				boolean input_frm_dpt = true;
				boolean input_expand = true;
				boolean input_cur_cde = true;
				boolean input_site_cde = true;

				if ((frm_plyapp_tm==null) || (frm_plyapp_tm.length()==0))
						input_frm_tm = false;

				if ((to_plyapp_tm==null) || (to_plyapp_tm.length()==0))
						input_to_tm = false;

				if ((frm_dpt==null) || (frm_dpt.length()==0))
						input_frm_dpt = false;

				if ((expand==null) || (expand.length()==0))
						input_expand = false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins = false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins = false;

				if ((in_cur_cde==null) || (in_cur_cde.length()==0))
						input_cur_cde = false;

				if ((in_site_cde==null) || (in_site_cde.length()==0))
						input_site_cde = false;

				String sqlString = Sqlstmt.SELECT_POLICYSTA;

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND A.t_undr_tm >= TO_DATE('"+frm_plyapp_tm+"', 'YYYY-MM-DD')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND A.t_undr_tm <= TO_DATE('"+to_plyapp_tm+"', 'YYYY-MM-DD')+1";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_cur_cde) {
						String tmp_sqlString = " AND A.c_prm_cur = '"+in_cur_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_frm_dpt) {
							String tmp_sqlString = " AND A.c_dpt_cde like '"+frm_dpt+expand+"'";
							sqlString = sqlString + tmp_sqlString;
				}else{
					if (owned_dpt[0].length() > 0){
							 int dptarray_len = owned_dpt.length;
							 String dpt_sqlString = " ";
							 for (int i = 0; i < dptarray_len ; i++){
											dpt_sqlString = dpt_sqlString + " AND A.c_dpt_cde like '" + owned_dpt[i] + expand+"' ";
								}
								sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
					}
				}

				if (input_site_cde) {
						String tmp_sqlString = " AND C.c_site_cde = '"+in_site_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				sqlString = sqlString + " ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_ply_no";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryPlyStatictics= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryPlyStatictics.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getPolicyStatictics() --- SUCCESSFULLY! ");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPlyStatictics.GetReturnArray ();
	}


//////////////////////////////////////////////////////////////////////////////
// Use Case 30 : Get PolicyApp proposal List for Summary statictics          //
//////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getProposalStatictics(String frm_plyapp_tm, String to_plyapp_tm, java.lang.String[] owned_dpt,
																							 String frm_dpt,String expand,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 String in_cur_cde, String in_site_cde, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getProposalStatictics() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;
				boolean input_frm_dpt = true;
				boolean input_expand = true;
				boolean input_cur_cde = true;
				boolean input_site_cde = true;

				if ((frm_plyapp_tm==null) || (frm_plyapp_tm.length()==0))
						input_frm_tm = false;

				if ((to_plyapp_tm==null) || (to_plyapp_tm.length()==0))
						input_to_tm = false;

				if ((frm_dpt==null) || (frm_dpt.length()==0))
						input_frm_dpt = false;

				if ((expand==null) || (expand.length()==0))
						input_expand = false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins = false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins = false;

				if ((in_cur_cde==null) || (in_cur_cde.length()==0))
						input_cur_cde = false;

				if ((in_site_cde==null) || (in_site_cde.length()==0))
						input_site_cde = false;

				String sqlString = Sqlstmt.SELECT_PROPOSALSTA;

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_cur_cde) {
						String tmp_sqlString = " AND A.c_prm_cur = '"+in_cur_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}
					System.out.println("from depart code:"+frm_dpt+"\ninput_frm_dpt:"+input_frm_dpt);
				if (input_frm_dpt) {
							String tmp_sqlString = " AND A.c_dpt_cde like '"+frm_dpt+expand+"'";
							sqlString = sqlString + tmp_sqlString;
				}else{
					if (owned_dpt[0].length() > 0){
							 int dptarray_len = owned_dpt.length;
							 String dpt_sqlString = " ";
							 for (int i = 0; i < dptarray_len ; i++){
											dpt_sqlString = dpt_sqlString + " AND A.c_dpt_cde like '" + owned_dpt[i] + expand+"' ";
								}
								sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
					}
				}

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND B.t_upd_tm >= TO_DATE('"+frm_plyapp_tm+"', 'YYYY-MM-DD')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND B.t_upd_tm <= TO_DATE('"+to_plyapp_tm+"', 'YYYY-MM-DD')+1";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_cur_cde) {
						String tmp_sqlString = " AND B.c_prm_cur = '"+in_cur_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_site_cde) {
						String tmp_sqlString = " AND C.c_site_cde = '"+in_site_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				sqlString = sqlString + " ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_ply_app_no";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryPrpslStatictics= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryPrpslStatictics.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getProposalStatictics() --- SUCCESSFULLY! ");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPrpslStatictics.GetReturnArray ();
	}


////////////////////////////////////////////////////////////////////////
// Use Case 31 : Get Case Report List for Summary statictics          //
////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getCaseRptStatictics(String frm_rpt_tm, String to_rpt_tm, java.lang.String[] owned_dpt,
																							 String frm_dpt,String expand,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 String in_cur_cde, String in_site_cde, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getCaseRptStatictics() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;
				boolean input_frm_dpt = true;
				boolean input_expand = true;
				boolean input_cur_cde = true;
				boolean input_site_cde = true;

				if ((frm_rpt_tm==null) || (frm_rpt_tm.length()==0))
						input_frm_tm = false;

				if ((to_rpt_tm==null) || (to_rpt_tm.length()==0))
						input_to_tm = false;

				if ((frm_dpt==null) || (frm_dpt.length()==0))
						input_frm_dpt = false;

				if ((expand==null) || (expand.length()==0))
						input_expand = false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins = false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins = false;

				if ((in_cur_cde==null) || (in_cur_cde.length()==0))
						input_cur_cde = false;

				if ((in_site_cde==null) || (in_site_cde.length()==0))
						input_site_cde = false;

				String sqlString = Sqlstmt.SELECT_CASERPTSTA;

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND A.t_rtp_tm >= TO_DATE('"+frm_rpt_tm+"', 'YYYY-MM-DD')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND A.t_rtp_tm <= TO_DATE('"+to_rpt_tm+"', 'YYYY-MM-DD')+1";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_dpt) {
							String tmp_sqlString = " AND A.c_dpt_cde like '"+frm_dpt+expand+"'";
							sqlString = sqlString + tmp_sqlString;
				}else{
					if (owned_dpt[0].length() > 0){
							 int dptarray_len = owned_dpt.length;
							 String dpt_sqlString = " ";
							 for (int i = 0; i < dptarray_len ; i++){
											dpt_sqlString = dpt_sqlString + " AND A.c_dpt_cde like '" + owned_dpt[i] + expand+"' ";
								}
								sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
					}
				}

				if (input_cur_cde) {
						String tmp_sqlString = " AND A.c_cur_typ = '"+in_cur_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_site_cde) {
						String tmp_sqlString = " AND B.c_site_cde = '"+in_site_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				sqlString = sqlString + " ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_rpt_no";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryClmRptStatictics= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryClmRptStatictics.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getCaseRptStatictics() --- SUCCESSFULLY! ");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryClmRptStatictics.GetReturnArray ();
	}


//////////////////////////////////////////////////////////////////////////////////////
// Common Routine for all case
// Get customer detail information
// return string array -- customer detail information from t_client
//////////////////////////////////////////////////////////////////////////////////////
	java.lang.String[][] getClntInfo(String in_clnt_cde)
				throws com.mcip.orb.CoException{

				Connection r_conn = r_pm.getConnection(r_dbname);
				String [][] ReturnResult = null;
				String sqlString =Sqlstmt.SELECT_CLNTSTAINFO;          // SQL
				String [][] sqlParameters= {{"c_clnt_cde",     in_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB getclntinfo = new ConnectDB(r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (getclntinfo.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = getclntinfo.GetReturnArray();
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////////////////////
// Use Case 32 : Get Customer Register List for Summary statictics    //
////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getCustStatictics(String frm_crt_tm, String to_crt_tm, java.lang.String[] owned_dpt,
																							 String frm_dpt,String expand,String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getCustStatictics() --- BSNS_INVALIDOPRID");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_dpt = true;
				boolean input_expand = true;

				if ((frm_crt_tm==null) || (frm_crt_tm.length()==0))
						input_frm_tm = false;

				if ((to_crt_tm==null) || (to_crt_tm.length()==0))
						input_to_tm = false;

				if ((frm_dpt==null) || (frm_dpt.length()==0))
						input_frm_dpt = false;

				if ((expand==null) || (expand.length()==0))
						input_expand = false;

				String sqlString = Sqlstmt.SELECT_CUSTSTA;

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND t_crt_tm >= TO_DATE('"+frm_crt_tm+"', 'YYYY-MM-DD')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND t_crt_tm <= TO_DATE('"+to_crt_tm+"', 'YYYY-MM-DD')+1";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_dpt) {
							String tmp_sqlString = " AND A.c_dpt_cde like '"+frm_dpt+expand+"'";
							sqlString = sqlString + tmp_sqlString;
				}else{
					if (owned_dpt[0].length() > 0){
							 int dptarray_len = owned_dpt.length;
							 String dpt_sqlString = " ";
							 for (int i = 0; i < dptarray_len ; i++){
											dpt_sqlString = dpt_sqlString + " AND A.c_dpt_cde like '" + owned_dpt[i] + expand+"' ";
								}
								sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
					}
				}

				sqlString = sqlString + " ORDER BY c_dpt_cde, c_clnt_cde";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryCustStatictics= new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryCustStatictics.GetReturnCode()) {
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

				String [][] custsta_Res = QueryCustStatictics.GetReturnArray();
//ConnectDB.dispArray (custsta_Res);
//System.out.println('\n'+"Query Department Code successfully");
				int custsta_len = custsta_Res.length;
				String [][] ReturnResult = new String [custsta_len][13];
				ReturnResult[0][0] = custsta_Res[0][1];
				ReturnResult[0][1] = "C_CLNT_CDE";
				ReturnResult[0][2] = "C_DPT_CDE";
				ReturnResult[0][3] = "C_CLNT_NME";
				ReturnResult[0][4] = "C_TEL";
				ReturnResult[0][5] = "C_EMAIL";
				ReturnResult[0][6] = "C_RGST_NO";
				ReturnResult[0][7] = "C_PROVINCE";
				ReturnResult[0][8] = "C_CITY";
				ReturnResult[0][9] = "C_PLACE";
				ReturnResult[0][10] = "C_DPT_CNM";
				ReturnResult[0][11] = "C_PROVINCE_CNM";
				ReturnResult[0][12] = "C_CITY_CNM";

//System.out.println("The length of custsta_Res: " + custsta_len);
				for (int i = 1; i < custsta_len ; i++){
					ReturnResult[i][0] = custsta_Res[i][1];
					String [][] tmp_Res = getClntInfo(custsta_Res[i][0]);
						if ((tmp_Res == null) || (tmp_Res[0][0].length() == 0)){
								for (int j = 0; j < 12 ; j++){
									ReturnResult[i][j+1] = "";
								}
						}else{
								for (int j = 0; j < 12 ; j++){
									ReturnResult[i][j+1] = tmp_Res[1][j];
								}
						}
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getCustStatictics() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
	}



///////////////////////////////////////////////////////////////////////
// Use Case 33 : Get Edr policy List for Summary statictics          //
///////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getEdrPlcyStatictics(String frm_edrapp_tm, String to_edrapp_tm, java.lang.String[] owned_dpt,
																							 String frm_dpt,String expand,
																							 String frm_insrnc_cde, String to_insrnc_cde,
																							 String in_cur_cde, String in_site_cde, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_STATICTICS, Constant.FAIL_EVENT, "getEdrPlcyStatictics() --- BSNS_INVALIDOPRID");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_frm_tm = true;
				boolean input_to_tm = true;
				boolean input_frm_ins = true;
				boolean input_to_ins = true;
				boolean input_frm_dpt = true;
				boolean input_expand = true;
				boolean input_cur_cde = true;
				boolean input_site_cde = true;

				if ((frm_edrapp_tm==null) || (frm_edrapp_tm.length()==0))
						input_frm_tm = false;

				if ((to_edrapp_tm==null) || (to_edrapp_tm.length()==0))
						input_to_tm = false;

				if ((frm_dpt==null) || (frm_dpt.length()==0))
						input_frm_dpt = false;

				if ((expand==null) || (expand.length()==0))
						input_expand = false;

				if ((frm_insrnc_cde==null) || (frm_insrnc_cde.length()==0))
						input_frm_ins = false;

				if ((to_insrnc_cde==null) || (to_insrnc_cde.length()==0))
						input_to_ins = false;

				if ((in_cur_cde==null) || (in_cur_cde.length()==0))
						input_cur_cde = false;

				if ((in_site_cde==null) || (in_site_cde.length()==0))
						input_site_cde = false;

				String sqlString = Sqlstmt.SELECT_EDRPLYSTA;

				if (input_frm_tm || input_to_tm) {
					if (input_frm_tm) {
							String tmp_sqlString = " AND A.t_undr_tm >= TO_DATE('"+frm_edrapp_tm+"', 'YYYY-MM-DD')";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_tm) {
							String tmp_sqlString = " AND A.t_undr_tm <= TO_DATE('"+to_edrapp_tm+"', 'YYYY-MM-DD')+1";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_frm_ins || input_to_ins) {
					if (input_frm_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde >= '"+frm_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
					if (input_to_ins) {
							String tmp_sqlString = " AND A.c_insrnc_cde <= '"+to_insrnc_cde+"'";
							sqlString = sqlString + tmp_sqlString;
					}
				}

				if (input_cur_cde) {
						String tmp_sqlString = " AND A.c_prm_cur = '"+in_cur_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_frm_dpt) {
							String tmp_sqlString = " AND A.c_dpt_cde like '"+frm_dpt+expand+"'";
							sqlString = sqlString + tmp_sqlString;
				}else{
					if (owned_dpt[0].length() > 0){
							 int dptarray_len = owned_dpt.length;
							 String dpt_sqlString = " ";
							 for (int i = 0; i < dptarray_len ; i++){
											dpt_sqlString = dpt_sqlString + " AND A.c_dpt_cde like '" + owned_dpt[i] + expand+"' ";
								}
								sqlString = sqlString + dpt_sqlString + " ) ";    //SQL
					}
				}

				if (input_site_cde) {
						String tmp_sqlString = " AND C.c_site_cde = '"+in_site_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				sqlString = sqlString + " ORDER BY A.c_dpt_cde, A.c_insrnc_cde, A.c_edr_no ";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryEdrPlyStatictics= new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryEdrPlyStatictics.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_STATICTICS, Constant.SUCCESS_EVENT, "getEdrPlcyStatictics() --- SUCCESSFULLY! ");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryEdrPlyStatictics.GetReturnArray ();
	}


////////////////////////////////////////////////////////////
// Use Case 34 :Accept New Claim Degist Info
////////////////////////////////////////////////////////////

	public boolean acceptClmDgst(com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj, String in_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "acceptClmDgst() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((clmdgstinfoobj.c_rpt_no==null) || (clmdgstinfoobj.c_rpt_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "acceptClmDgst() --- BSNS_INVALIDDGSTRPTNO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDGSTRPTNO);         //  Modify Exceoption
				}

				if ((clmdgstinfoobj.c_ply_no==null) || (clmdgstinfoobj.c_ply_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "acceptClmDgst() --- BSNS_INVALIDDGSTPLYNO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDGSTPLYNO);         //  Modify Exceoption
				}

//Insert into t_clmdgst
				String sqlString =Sqlstmt.INSERT_CLMDGST;             //SQL
				String [][] sqlParameters =
							{{"c_ply_no",       clmdgstinfoobj.c_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_rpt_no",       clmdgstinfoobj.c_rpt_no,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_digest",       clmdgstinfoobj.c_digest,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_content",      clmdgstinfoobj.c_content,     String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertClmDgst = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertClmDgst.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.SUCCESS_EVENT, "acceptClmDgst() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 35 : Update Insurance Claim Degist Info
////////////////////////////////////////////////////////

	public boolean updateClmDgst(com.mcip.bus.orb.ClmDgstInfo clmdgstinfoobj, String in_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "updateClmDgst() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				if ((clmdgstinfoobj.c_rpt_no==null) || (clmdgstinfoobj.c_rpt_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "updateClmDgst() --- BSNS_INVALIDDGSTRPTNO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDGSTRPTNO);         //  Modify Exceoption
				}

				if ((clmdgstinfoobj.c_ply_no==null) || (clmdgstinfoobj.c_ply_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "updateClmDgst() --- BSNS_INVALIDDGSTPLYNO! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDDGSTPLYNO);         //  Modify Exceoption
				}

				if ((clmdgstinfoobj.c_info_no==null) || (clmdgstinfoobj.c_info_no.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "updateClmDgst() --- BSNS_INVALIDPLYCLMRPT! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPLYCLMRPT);         //  Modify Exceoption
				}

//Update t_clmdgst
				String sqlString =Sqlstmt.UPDATE_CLMDGST;             //SQL
				String [][] sqlParameters =
							{{"c_digest",       clmdgstinfoobj.c_digest,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_content",      clmdgstinfoobj.c_content,     String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_ply_no",       clmdgstinfoobj.c_ply_no,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_rpt_no",       clmdgstinfoobj.c_rpt_no,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_info_no",       clmdgstinfoobj.c_info_no,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateClmDgst = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateClmDgst.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.SUCCESS_EVENT, "updateClmDgst() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 36 : Delete Insurance Claim Degist Info
////////////////////////////////////////////////////////

	public boolean deleteClmDgst(String in_rpt_no, String in_ply_no, String in_info_no, String in_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "deleteClmDgst() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_rpt = true;
				boolean input_ply = true;
				boolean input_info = true;
				if ((in_rpt_no==null) || (in_rpt_no.length()==0))
						input_rpt = false;

				if ((in_ply_no==null) || (in_ply_no.length()==0))
						input_ply = false;

				if ((in_info_no==null) || (in_info_no.length()==0))
						input_info = false;

				String sqlString = Sqlstmt.DELETE_CLMDGST;

				if (!input_rpt && !input_ply && !input_info) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "deleteClmDgst() --- BSNS_INVALIDPLYCLMRPT! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDPLYCLMRPT);         //  Modify Exceoption
				}

				if (input_rpt) {
						String tmp_sqlString = " AND c_rpt_no = '"+in_rpt_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_ply) {
						String tmp_sqlString = " AND c_ply_no = '"+in_ply_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_info) {
						String tmp_sqlString = " AND c_info_no = '"+in_info_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

//Delete from t_clmdgst
				ConnectDB DeleteClmDgst = new ConnectDB (l_conn,sqlString,Constant.executeSqlUpdate);
				switch (DeleteClmDgst.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.SUCCESS_EVENT, "deleteClmDgst() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 37 : Query Insurance Claim Degist Info
////////////////////////////////////////////////////////

	public java.lang.String[][] queryClmDgstInfo(String in_rpt_no, String in_ply_no, String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CASEFLLWUP, Constant.FAIL_EVENT, "queryClmDgstInfo() --- BSNS_INVALIDOPRID! ");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.BSNS_INVALIDOPRID);         //  Modify Exceoption
				}

				boolean input_rpt = true;
				boolean input_ply = true;
				if ((in_rpt_no==null) || (in_rpt_no.length()==0))
						input_rpt = false;

				if ((in_ply_no==null) || (in_ply_no.length()==0))
						input_ply = false;

				String sqlString = Sqlstmt.SELECT_CLMDGST;

				if (input_rpt) {
						String tmp_sqlString = " AND c_rpt_no = '"+in_rpt_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_ply) {
						String tmp_sqlString = " AND c_ply_no = '"+in_ply_no+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				ConnectDB QueryClmDgst = new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryClmDgst.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CASEFLLWUP, Constant.SUCCESS_EVENT, "queryClmDgstInfo() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryClmDgst.GetReturnArray ();
		}


//////////////////////////////////////////////////////////////////////////////////////
// Use Case 38 : Accept Chat Content between customer and underwrited person via Cyber
//////////////////////////////////////////////////////////////////////////////////////

	public boolean acceptChatCntnt(String in_bgn_tm, String in_end_tm, String in_chat_title, java.lang.String[] chat_cntnt, String in_chat_nme, String in_chat_mrk)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				boolean input_chat_mrk =false;
				int chat_len = chat_cntnt.length;
				Connection l_conn = l_pm.getConnection(l_dbname);

				if ((in_chat_nme==null) || (in_chat_nme.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "acceptChatCntnt() --- OPR_INVALID_ACTION!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_ACTION);     // Modify Exception CODE
				}

				if ((in_chat_title==null) || (in_chat_title.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "acceptChatCntnt() --- OPR_INVALID_ACTION!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_ACTION);     // Modify Exception CODE
				}

				if ((in_chat_mrk.equals(Constant.CUSTOMER_MRK)) || (in_chat_mrk.equals(Constant.UNDR_PRSN_MRK)))
						input_chat_mrk = true;

				if (!input_chat_mrk) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "acceptChatCntnt() --- OPR_INVALID_ACTION!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_ACTION);     // Modify Exception CODE
				}

// Insert into t_pa18_chat
/*
				String statement_auth[]=null;
				String parm_auth [][][]=new String[4][3][2];
*/
				String statement_chat[]=new String[chat_len];
				String parm_chat [][][]=new String[chat_len][3][2];
				for (int i = 0; i < chat_len ; i++){
				statement_chat[i]=Sqlstmt.INSERT_PA18CHAT;
				parm_chat[i] = set_parameter_value6("c_chat_nme",    in_chat_nme,    String.valueOf(Constant.VARCHAR2_TYPE),
																						"c_chat_mrk",    in_chat_mrk,    String.valueOf(Constant.VARCHAR2_TYPE),
																						"c_chat_cntnt",  chat_cntnt[i],  String.valueOf(Constant.VARCHAR2_TYPE),
																						"c_chat_ttl",    in_chat_title,  String.valueOf(Constant.VARCHAR2_TYPE),
																						"t_begin_tm",    in_bgn_tm,      String.valueOf(Constant.DATETIME_TYPE),
																						"t_end_tm",      in_end_tm,      String.valueOf(Constant.DATETIME_TYPE));
				}

				ConnectDB InsertPa18Chat = new ConnectDB (l_conn,statement_chat,Constant.executeBatchPrepUpdate,parm_chat);
				switch (InsertPa18Chat.GetReturnCode()) {

						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.SUCCESS_EVENT, "acceptChatCntnt() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Common Routine for all case
// set parameters values for executeOptrAuth()
// return string array [][]
////////////////////////////////////////////////////////
		String [][] set_parameter_value6(String c_field_name1, String c_field_value1, String c_field_type1,
																		 String c_field_name2, String c_field_value2, String c_field_type2,
																		 String c_field_name3, String c_field_value3, String c_field_type3,
																		 String c_field_name4, String c_field_value4, String c_field_type4,
																		 String c_field_name5, String c_field_value5, String c_field_type5,
																		 String c_field_name6, String c_field_value6, String c_field_type6)
				throws com.mcip.orb.CoException{
				String [][] sqlParameters={{c_field_name1,c_field_value1,c_field_type1},
																	 {c_field_name2,c_field_value2,c_field_type2},
																	 {c_field_name3,c_field_value3,c_field_type3},
																	 {c_field_name4,c_field_value4,c_field_type4},
																	 {c_field_name5,c_field_value5,c_field_type5},
																	 {c_field_name6,c_field_value6,c_field_type6}};
				return sqlParameters;
		}


/////////////////////////////////////////////////////////////////////////////////////
// Use Case 39 : Query Chat Content between customer and underwrited person via Cyber
/////////////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryChatCntnt(String in_chat_ttl, String in_chat_mrk)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				boolean input_chat_mrk =false;
				if ((in_chat_ttl==null) || (in_chat_ttl.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "queryChatCntnt() --- OPR_INVALID_ACTION!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_ACTION);     // Modify Exception CODE
				}

				if ((in_chat_mrk.equals(Constant.CUSTOMER_MRK)) || (in_chat_mrk.equals(Constant.UNDR_PRSN_MRK)))
						input_chat_mrk = true;

				if (!input_chat_mrk) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "queryChatCntnt() --- OPR_INVALID_ACTION!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_ACTION);     // Modify Exception CODE
				}

				String SqlStatement=Sqlstmt.SELECT_PA18CHAT;
				String [][] sqlParameters= {{"c_chat_ttl",   in_chat_ttl,   String.valueOf(Constant.VARCHAR2_TYPE)},
																		{"c_chat_mrk",   in_chat_mrk,   String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryPa18Chat = new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryPa18Chat.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.SUCCESS_EVENT, "queryChatCntnt() --- SUCCESSFULLY! ");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryPa18Chat.GetReturnArray ();
		}



//////////////////////////////////////////////////////////////////////
// Use Case 40 : get Customer's Policy Applicant Form List for business summary   //
//////////////////////////////////////////////////////////////////////
		public java.lang.String[][] getCustPlyAppList(String in_user_id)
				throws com.mcip.orb.CoException {

				if ((in_user_id==null) || (in_user_id.length()==0))
						ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
// get related customer type and client code from t_pa18_user;
				String SqlStatement1=Sqlstmt.SELECT_CUSTENTT;
				String [][] sqlParameters1= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryClntInfo= new ConnectDB (l_conn,SqlStatement1,Constant.executePrepQuery,sqlParameters1);
				switch (QueryClntInfo.GetReturnCode()) {
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
				String in_cust_typ = QueryClntInfo.GetReturnArray()[1][7];
				boolean input_cust_typ=false;
// Check customer type --- "agent type" "Open Cover type" "normal type"
				if ((in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) ||
						(in_cust_typ.equals(Constant.OPNCVR_CUST_MRK)) ||
						(in_cust_typ.equals(Constant.NORMAL_CUST_MRK)) )
						input_cust_typ=true;

				if (!input_cust_typ) {
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.CUST_INVRF_EXPIRE);
				}

				String in_cmpny_agt_cde = new String("");
				String [][] clnt_Res = null;
				if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
						in_cmpny_agt_cde=QueryClntInfo.GetReturnArray()[1][8];
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
				String sqlString =Sqlstmt.SELECT_CUSTPLYAPPLIST;    //SQL
				String Plus_String = " GROUP BY A.c_ply_app_no,A.c_ply_no,A.c_insrnc_cde,A.t_app_tm,A.n_rate,A.c_undr_prsn,B.c_crgo_cde,B.c_crgo_name,C.c_insrnc_cnm,D.c_emp_cnm ORDER BY A.t_app_tm DESC";


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
				ConnectDB QueryCustPlyAppList = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryCustPlyAppList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn,in_user_id,Constant.LOG_PLCYQUERY,Constant.SUCCESS_EVENT,"getCustPlyAppList() Query Customer's Policy apply form List for Business Summary Successful!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryCustPlyAppList.GetReturnArray();
		}


//////////////////////////////////////////////////////////////////////
// Use Case 41 : get Customer's Policy premium and amount summary                 //
//////////////////////////////////////////////////////////////////////
		public java.lang.String[][] getCustPlySum(String in_user_id, java.lang.String[] in_insrnc_cde, String in_sum_tm)
				throws com.mcip.orb.CoException {

				if ((in_user_id==null) || (in_user_id.length()==0))
						ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM);

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				boolean input_sum_tm=false;
				boolean input_insrnc_cde=false;
				if ((in_sum_tm==null) || (in_sum_tm.length()==0)){
						input_sum_tm=false;
				}else{
						input_sum_tm=true;
				}

				if ((in_insrnc_cde==null) || (in_insrnc_cde[0].length()==0)){
						input_insrnc_cde=false;
				}else{
						input_insrnc_cde=true;
				}

// get related customer type and client code from t_pa18_user;
				String SqlStatement1=Sqlstmt.SELECT_CUSTENTT;
				String [][] sqlParameters1= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryClntInfo= new ConnectDB (l_conn,SqlStatement1,Constant.executePrepQuery,sqlParameters1);
				switch (QueryClntInfo.GetReturnCode()) {
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
				String in_cust_typ = QueryClntInfo.GetReturnArray()[1][7];
				boolean input_cust_typ=false;
// Check customer type --- "agent type" "Open Cover type" "normal type"
				if ((in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) ||
						(in_cust_typ.equals(Constant.OPNCVR_CUST_MRK)) ||
						(in_cust_typ.equals(Constant.NORMAL_CUST_MRK)) )
						input_cust_typ=true;

				if (!input_cust_typ) {
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.CUST_INVRF_EXPIRE);
				}

				String in_cmpny_agt_cde = new String("");
				String [][] clnt_Res = null;
				if (in_cust_typ.equals(Constant.AGENCY_CUST_MRK)) {
						in_cmpny_agt_cde=QueryClntInfo.GetReturnArray()[1][8];
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
				String arguString = new String("");    //SQL
				String arguString1 = new String("");    //SQL
				String arguString2 = new String("");    //SQL
				String sqlString1 = Sqlstmt.SELECT_CUSTPLYSUM1;    //SQL
				String sqlString2 = Sqlstmt.SELECT_CUSTPLYSUM2;    //SQL

				String Plus_String = " GROUP BY A.c_insrnc_cde ORDER BY A.c_insrnc_cde ";


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

				if (input_insrnc_cde){
						int insrncarray_len = in_insrnc_cde.length;
						String insrnc_sqlString = " AND A.c_insrnc_cde IN (";

						for (int i = 0; i < insrncarray_len ; i++){
								if ((i-insrncarray_len+1)==0)
										insrnc_sqlString = insrnc_sqlString + "'" + in_insrnc_cde[i] + "'";
								else
										insrnc_sqlString = insrnc_sqlString + "'" + in_insrnc_cde[i] + "', ";
						}
						arguString = arguString + insrnc_sqlString + " )";    //SQL
				}

				if (input_sum_tm){
						arguString1 = " AND TO_CHAR(A.t_app_tm, 'YYYY') = '" + in_sum_tm.substring(0,4) + "' ";
						arguString2 = " AND TO_CHAR(A.t_app_tm, 'YYYY-MM') = '" + in_sum_tm + "' ";
				}else{
						arguString1 = " AND TO_CHAR(A.t_app_tm, 'YYYY') = TO_CHAR(SYSDATE, 'YYYY') ";
						arguString2 = " AND TO_CHAR(A.t_app_tm, 'YYYY-MM') = TO_CHAR(SYSDATE, 'YYYY-MM') ";
				}

				sqlString1 = sqlString1 + arguString + arguString1 + Plus_String;
// get related Policy Totle Summary from t_policy
				ConnectDB QueryCustPlySum1 = new ConnectDB (r_conn,sqlString1,Constant.executeSqlQuery);
				switch (QueryCustPlySum1.GetReturnCode()) {
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
				String[][] Sum_Res1 = QueryCustPlySum1.GetReturnArray();

				String[][] Sum_Res2 = null;
				sqlString2 = sqlString2 + arguString + arguString2 + Plus_String;
// get related Policy One Month Summary from t_policy
				ConnectDB QueryCustPlySum2 = new ConnectDB (r_conn,sqlString2,Constant.executeSqlQuery);
				switch (QueryCustPlySum2.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									Sum_Res2 = new String [1][1];
									Sum_Res2[0][0] = "";
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									Sum_Res2 = QueryCustPlySum2.GetReturnArray();
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				};

//ConnectDB.dispArray (Sum_Res1);
//ConnectDB.dispArray (Sum_Res2);
//System.out.println("After Get two SUM_RES Array");
				int Res1_len = Sum_Res1.length;
				int Res2_len = Sum_Res2.length;
				int k = 1;
				String[][] ReturnResult = new String [Res1_len][9];
				ReturnResult[0][0] = Sum_Res1[0][0];
				ReturnResult[0][1] = Sum_Res1[0][1];
				ReturnResult[0][2] = Sum_Res1[0][2];
				ReturnResult[0][3] = Sum_Res1[0][3];
				ReturnResult[0][4] = Sum_Res1[0][4];
				ReturnResult[0][5] = "CURR_AMT";
				ReturnResult[0][6] = "CURR_PRM";
				ReturnResult[0][7] = "CURR_AVG";
				ReturnResult[0][8] = "CURR_COUNT";
				for (int i = 1; i < Res1_len ; i++){
						ReturnResult[i][0] = Sum_Res1[i][0];
						ReturnResult[i][1] = Sum_Res1[i][1];
						ReturnResult[i][2] = Sum_Res1[i][2];
						ReturnResult[i][3] = Sum_Res1[i][3];
						ReturnResult[i][4] = Sum_Res1[i][4];
//System.out.println("in Return Result Array Loop " + String.valueOf(i));
						if (Sum_Res2[0][0].length()==0){
								ReturnResult[i][5] = "0";
								ReturnResult[i][6] = "0";
								ReturnResult[i][7] = "0";
								ReturnResult[i][8] = "0";
						}else{
								if ((k < Res2_len) && (Sum_Res1[i][0].equals(Sum_Res2[k][0]))){
//System.out.println("in Res1 with Res2 Array Loop " + String.valueOf(k));
										ReturnResult[i][5] = Sum_Res2[k][1];
										ReturnResult[i][6] = Sum_Res2[k][2];
										ReturnResult[i][7] = Sum_Res2[k][3];
										ReturnResult[i][8] = Sum_Res2[k][4];
										k=k+1;
								}else{
//System.out.println("in Res1 with Res2 Array Loop : not match" );
										ReturnResult[i][5] = "0";
										ReturnResult[i][6] = "0";
										ReturnResult[i][7] = "0";
										ReturnResult[i][8] = "0";
								}
						}
				}

//ConnectDB.dispArray (ReturnResult);
				new ConnectDB(l_conn).WriteDBLog(l_conn,in_user_id,Constant.LOG_PLCYQUERY,Constant.SUCCESS_EVENT,"getCustPlySum() Query Customer's Policy Summary Successful!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}



/////////////////////////////////////////////////////////////////////////////////////
// Use Case 42 : get underwriting person's insurance type for Cyber Chat
/////////////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] getChatRight(String in_emp_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_emp_cde==null) || (in_emp_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.FAIL_EVENT, "getChatRight() --- OPR_INVALID_ACTION!");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_ACTION);     // Modify Exception CODE
				}

				String SqlStatement=Sqlstmt.SELECT_CHATRIGHT;
				String [][] sqlParameters= {{"c_emp_cde",   in_emp_cde,   String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryChatRight = new ConnectDB (r_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryChatRight.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_INSRNCFAQ, Constant.SUCCESS_EVENT, "getChatRight() --- SUCCESSFULLY! ");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryChatRight.GetReturnArray ();
		}



	}






