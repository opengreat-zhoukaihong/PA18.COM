////////////////////////////////////////////////////////
// Author:       Maintained by YiJF
// Function:     Operator Management Module Implement
// Update Date:  2000/9/20
// Update Date:  2000/11/28 YiJF modify for two DB connection pool
////////////////////////////////////////////////////////

import java.sql.*;
import java.util.*;
import utility.*;
import constant.*;
import jtoc.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.bus.orb.*;


public class UserManagerImpl extends _UserManagerImplBase {
		private static PoolManager r_pm;
		private static PoolManager l_pm;
		private static String r_dbname=Constant.BACKEND_DBNAME;
		private static String l_dbname=Constant.DBNAME;
//    private static Connection r_conn;
//    private static Connection l_conn;
		private CoExceptionHandler exHandler;

////////////////////////////////////////////////////////
// Function:     Constructor
////////////////////////////////////////////////////////
		public UserManagerImpl(String name,PoolManager r_poolManager,PoolManager l_poolManager) {
				super(name);
// connect Remote DB (BackEnd System)
				r_pm = r_poolManager;
//        r_conn = r_pm.getConnection(r_dbname);
// connect Local DB (PA18.COM System)
				l_pm = l_poolManager;
//        l_conn = l_pm.getConnection(l_dbname);
//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"UserManagerImpl get db connection");
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
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"UserManagerImp1 free db connection");
				this.exHandler.raiseCoException(ExceptionCode,"","UserManagerImpl");
		}

		private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
					 throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"UserManagerImp1 free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"UserManagerImpl");
		}

		private void ErrorHandling(String ExceptionCode,String ExceptionDesc,String ExceptionField,String ExceptionSeverity)
					 throws com.mcip.orb.CoException   {
//        r_pm.freeConnection (r_dbname,r_conn);
//        l_pm.freeConnection (l_dbname,l_conn);
//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"UserManagerImp1 free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"UserManagerImpl",ExceptionSeverity);
		}

//Business Logic for PingAn internal operator login

////////////////////////////////////////////////////////
// Common Routine for all case
// Check the unique of input operator code
// False -- not unique; True -- unique
////////////////////////////////////////////////////////
	public boolean checkUniqueOpr(String in_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_UNIQUEOPRCDE;          // SQL
				String [][] sqlParameters= {{"c_opr_cde",       in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkuniqueopr = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkuniqueopr.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult =true;
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
// Common Routine for all case
// Check the unique of input system function code
// False -- not unique; True -- unique
////////////////////////////////////////////////////////
	public boolean checkUniqueFunc(String in_func_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_UNIQUEFUNCCDE;          // SQL
				String [][] sqlParameters= {{"c_func_cde",      in_func_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkuniquefunc = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkuniquefunc.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult =true;
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
// Common Routine for all case
// Check the unique of input system Page Number
// False -- not unique; True -- unique
////////////////////////////////////////////////////////
	public boolean checkUniquePage(String in_page_no)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_UNIQUEPAGENO;          // SQL
				String [][] sqlParameters= {{"c_page_no",     in_page_no,     String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkuniquepage = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkuniquepage.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult =true;
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


//////////////////////////////////////////////////////////////////////////////////////
// Common Routine for all case
// Check the department code of new operator in Authority operator department scale //
// False -- not in authority Department or employee not exist; True -- employee exist and in authority Department
//////////////////////////////////////////////////////////////////////////////////////
	public boolean checkAuthDpt(String in_emp_cde, String in_auth_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString1 = Sqlstmt.SELECT_INAUTHDPT1;          // SQL
				String [][] sqlParameters1 = {{"c_emp_cde",   in_emp_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkempcde = new ConnectDB(r_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);
				switch (checkempcde.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult =true;
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				if (ReturnResult) {
						String tmp_dpt_cde = checkempcde.GetReturnArray()[1][1];
						String sqlString2 = Sqlstmt.SELECT_INAUTHDPT2;          // SQL
						String [][] sqlParameters2 = {{"c_opr_cde",   in_auth_opr_cde,  String.valueOf(Constant.VARCHAR2_TYPE)},
																					{"c_dpt_cde",   tmp_dpt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
						ConnectDB checkauthdpt = new ConnectDB(l_conn,sqlString2,Constant.executePrepQuery,sqlParameters2);
						switch (checkauthdpt.GetReturnCode()) {
								case Constant.ConnectDB_SelectNone:
										 ReturnResult = false;
										 break;
								case Constant.ConnectDB_SelectMulti:
								case Constant.ConnectDB_SelectOne:
										 ReturnResult =true;
										 break;
								default:
										 r_pm.freeConnection (r_dbname,r_conn);
										 l_pm.freeConnection (l_dbname,l_conn);
										 ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}
				}
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


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
				String [][] sqlParameters= {{"c_emp_cde",     in_emp_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

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
// Use Case 1 :Operator Login
////////////////////////////////////////////////////////

		public String[][] operatorLogin(String in_opr_cde,String in_pass_word)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_OPRLOGIN;            //SQL select from t_operator,t_opr_auth,t_department,t_sys_func
				String [][] sqlParameters = {{"c_opr_cde",    in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
																		 {"c_opr_pw",     in_pass_word,   String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryUser= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);

				switch (QueryUser.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.OPR_ERRORIDORPW);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				String [][] ReturnResult = QueryUser.GetReturnArray();
				if (ReturnResult[1][4].equals(Constant.TRUE_YES)) {
						try{
								boolean bln_tmp = executeSysadmAuth(Constant.UPDATE_OPRAUTH_MRK, "system", in_opr_cde, "");
								System.out.println("Super Operator's authority initialized successfully !");
						}catch (com.mcip.orb.CoException e) {
								System.out.println("Super Operator's authority initialized fail !");
						}

				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPERTRLOGIN, Constant.SUCCESS_EVENT, "operatorLogin() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
//        return QueryUser.GetReturnArray();
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 2 :Accept New Operator
////////////////////////////////////////////////////////

	public boolean acceptOperator(com.mcip.bus.orb.OperatorInfo operatorinfoobj)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection l_conn = l_pm.getConnection(l_dbname);
//Check if unique
				if (!checkUniqueOpr(operatorinfoobj.c_opr_cde)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, operatorinfoobj.c_opr_cde, Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "acceptOperator() --- OPR_DUPLICATEID!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_DUPLICATEID);
				}

//Check if emp_cde exist in t_emp_cde and his department in Authority department of auth_opr_cde
				if (!checkAuthDpt(operatorinfoobj.c_emp_cde, operatorinfoobj.c_acredt_cde)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, operatorinfoobj.c_opr_cde, Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "acceptOperator() --- OPR_EMPLOYEENOTEXIST!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_EMPLOYEENOTEXIST);
				}

// Get employee department code from t_emp_cde
				operatorinfoobj.c_dpt_cde = getEmployeeDpt(operatorinfoobj.c_emp_cde);

//Insert into t_operator
				String sqlString1 =Sqlstmt.INSERT_OPERATOR;             //SQL
				String [][] sqlParameters1 =
							{{"c_opr_cde",    operatorinfoobj.c_opr_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_opr_pw",     operatorinfoobj.c_opr_pw,     String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_cde",    operatorinfoobj.c_emp_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_dpt_cde",    operatorinfoobj.c_dpt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_acredt_cde", operatorinfoobj.c_acredt_cde, String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_sys_admin",  operatorinfoobj.c_sys_admin,  String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertOpr = new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);
				switch (InsertOpr.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//Insert into t_opr_dpt
/* // modified by YiJF Oct-18
				String sqlString2 =Sqlstmt.INSERT_OPRDPT;             //SQL
				String [][] sqlParameters2 =
							{{"c_opr_cde",operatorinfoobj.c_opr_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_dpt_cde",operatorinfoobj.c_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertOprDpt = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

				switch (InsertOprDpt.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
*/
				ReturnResult =true;

				new ConnectDB(l_conn).WriteDBLog(l_conn, operatorinfoobj.c_opr_cde, Constant.LOG_OPTRMANAGE, Constant.SUCCESS_EVENT, "acceptOperator() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;

			}


////////////////////////////////////////////////////////
// Use Case 3 :Update Operator
////////////////////////////////////////////////////////

	public boolean updateOperator(com.mcip.bus.orb.OperatorInfo operatorinfoobj)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Check if emp_cde exist in t_emp_cde and his department in Authority department of auth_opr_cde
				if (!checkAuthDpt(operatorinfoobj.c_emp_cde, operatorinfoobj.c_acredt_cde)){
						new ConnectDB(l_conn).WriteDBLog(l_conn, operatorinfoobj.c_opr_cde, Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "updateOperator() --- OPR_EMPLOYEENOTEXIST!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_EMPLOYEENOTEXIST);
				}

// Get employee department code from t_emp_cde
				operatorinfoobj.c_dpt_cde = getEmployeeDpt(operatorinfoobj.c_emp_cde);

//Update t_operator
				String sqlString1 =Sqlstmt.UPDATE_OPERATOR;         //SQL
				String [][] sqlParameters1 =
							{{"c_opr_pw",   operatorinfoobj.c_opr_pw,     String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_cde",  operatorinfoobj.c_emp_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_dpt_cde",  operatorinfoobj.c_dpt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_opr_cde",  operatorinfoobj.c_opr_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateOpr = new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);
				switch (UpdateOpr.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//detele from t_opr_dpt
/*
				String sqlString2 =Sqlstmt.DELETE_OPRDPT;           //SQL
				String [][] sqlParameters2 =
							{{"c_opr_cde",    operatorinfoobj.c_opr_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteOprDpt = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdateNoCommit,sqlParameters2);
				switch (DeleteOprDpt.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
*/
//insert into t_opr_dpt
/* // modified by YiJF Oct-18
				String sqlString3 =Sqlstmt.INSERT_OPRDPT;           //SQL
				String [][] sqlParameters3 =
							{{"c_opr_cde",    operatorinfoobj.c_opr_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_dpt_cde",    operatorinfoobj.c_dpt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertOprDpt = new ConnectDB (l_conn,sqlString3,Constant.executePrepUpdate,sqlParameters3);

				switch (InsertOprDpt.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
*/
				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, operatorinfoobj.c_opr_cde, Constant.LOG_OPTRMANAGE, Constant.SUCCESS_EVENT, "updateOperator() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 4 :delete Operator
////////////////////////////////////////////////////////

	public boolean deleteOperator(String auth_dpt_cde, String auth_opr_cde, String in_opr_cde, String rcsv_del_flg)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "deleteOperator() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);     // Modify Exception CODE
				}

				if (rcsv_del_flg.equals(Constant.NO_RCSV_DEL_MRK)){

					//detele from t_opr_dpt
					String sqlString1 =Sqlstmt.DELETE_OPRDPT;            //SQL
					String [][] sqlParameters1 =
								{{"c_opr_cde",      in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};

					ConnectDB DeleteOprDpt = new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);
					switch (DeleteOprDpt.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}

					//detele from t_opr_auth
					String sqlString2 =Sqlstmt.DELETE_OPRAUTH;            //SQL
					String [][] sqlParameters2 =
								{{"c_opr_cde",    in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};

					ConnectDB DeleteOprAuth = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdateNoCommit,sqlParameters2);
					switch (DeleteOprAuth.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}

					//Delete from t_operator
					String sqlString3 =Sqlstmt.DELETE_OPERATOR;         //SQL
					String [][] sqlParameters3 =
								{{"c_opr_cde",      in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)}};

					ConnectDB DeleteOpr = new ConnectDB (l_conn,sqlString3,Constant.executePrepUpdate,sqlParameters3);
					switch (DeleteOpr.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}

				}else{
					if (rcsv_del_flg.equals(Constant.YES_RCSV_DEL_MRK)){
// RECURSIVE DELETE RECORDS FROM t_opr_dpt,t_opr_auth,t_operator
						//detele from t_opr_dpt
						String sqlString4 =Sqlstmt.DELETE_OPRDPT_RCSV;            //SQL
						String [][] sqlParameters4 =
									{{"c_acredt_cde",     in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
									 {"c_opr_cde",        in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)}};

						ConnectDB DeleteOprDptRcsv = new ConnectDB (l_conn,sqlString4,Constant.executePrepUpdateNoCommit,sqlParameters4);
						switch (DeleteOprDptRcsv.GetReturnCode()) {
								 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
											break;
								 default:
											l_pm.freeConnection (l_dbname,l_conn);
											ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}

						//detele from t_opr_auth
						String sqlString5 =Sqlstmt.DELETE_OPRAUTH_RCSV;            //SQL
						String [][] sqlParameters5 =
									{{"c_acredt_cde",     in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
									 {"c_opr_cde",        in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)}};

						ConnectDB DeleteOprAuthRcsv = new ConnectDB (l_conn,sqlString5,Constant.executePrepUpdateNoCommit,sqlParameters5);
						switch (DeleteOprAuthRcsv.GetReturnCode()) {
								 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
											break;
								 default:
											l_pm.freeConnection (l_dbname,l_conn);
											ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}

						//Delete from t_operator
						String sqlString6 =Sqlstmt.DELETE_OPERATOR_RCSV;         //SQL
						String [][] sqlParameters6 =
									{{"c_acredt_cde",     in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
									 {"c_opr_cde",        in_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)}};

						ConnectDB DeleteOprRcsv = new ConnectDB (l_conn,sqlString6,Constant.executePrepUpdate,sqlParameters6);
						switch (DeleteOprRcsv.GetReturnCode()) {
								 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
											break;
								 default:
											l_pm.freeConnection (l_dbname,l_conn);
											ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}

					}else{
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "deleteOperator() --- invalid delete flag! OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);     // Modify Exception CODE
					}
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPTRMANAGE, Constant.SUCCESS_EVENT, "deleteOperator() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 5 : Query Operator Info
////////////////////////////////////////////////////////

	public java.lang.String[][] queryOptrInfo(String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "queryOptrInfo() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				String sqlString =Sqlstmt.SELECT_OPERATOR;             //SQL
				String [][] sqlParameters= {{"c_opr_cde",     in_opr_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryOptrInfo= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (QueryOptrInfo.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryOptrInfo",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC,"","queryOptrInfo",Constant.WARNING);
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPTRMANAGE, Constant.SUCCESS_EVENT, "queryOptrInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryOptrInfo.GetReturnArray ();
		}


//////////////////////////////////////////////////////////////////////////////////////
// Common Routine for all case
// Get employee's chinese name and English name of the employee code
// return string array -- employee's chinese name and english name
//////////////////////////////////////////////////////////////////////////////////////
	public java.lang.String[][] getEmpCEnm(String in_emp_cde)
				throws com.mcip.orb.CoException{

				Connection r_conn = r_pm.getConnection(r_dbname);
				String [][] ReturnResult = new String [2][2];
				String sqlString = Sqlstmt.SELECT_OPRLIST_EMP;
				String [][] sqlParameters= {{"c_emp_cde",     in_emp_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB getempcenm = new ConnectDB(r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (getempcenm.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult[0][0] = "C_EMP_CNM";         // c_dpt_abr as c_dpt_cnm
									ReturnResult[0][1] = "C_EMP_ENM";
									ReturnResult[1][0] = "";
									ReturnResult[1][1] = "";
//System.out.println("EMP CENM NOT FOUND ");
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult[0][0] = getempcenm.GetReturnArray()[0][0];
									ReturnResult[0][1] = getempcenm.GetReturnArray()[0][1];
									ReturnResult[1][0] = getempcenm.GetReturnArray()[1][0];
									ReturnResult[1][1] = getempcenm.GetReturnArray()[1][1];
//System.out.println("EMP CENM FOUND ");
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 6 : Query Operator List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryOptrList(String in_opr_cde, String in_emp_cde, String auth_opr_cde, String auth_dpt_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((auth_opr_cde==null) || (auth_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "queryOptrList() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((auth_dpt_cde==null) || (auth_dpt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPTRMANAGE, Constant.FAIL_EVENT, "queryOptrList() --- OPR_INVALIDDPTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDDPTCDE);    // Modify Exception Code
				}

				boolean input_opr_cde=true;
				boolean input_emp_cde=true;
				String sqlString = new String("");
				sqlString = Sqlstmt.SELECT_OPRLIST + " AND c_acredt_cde = '"+auth_opr_cde+"'";     //SQL

				if ((in_opr_cde==null) || (in_opr_cde.length()==0))
						input_opr_cde=false;

				if ((in_emp_cde==null) || (in_emp_cde.length()==0))
						input_emp_cde=false;

				if (input_opr_cde) {
						String tmp_sqlString = " AND c_opr_cde = '"+in_opr_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				if (input_emp_cde) {
						String tmp_sqlString = " AND c_emp_cde = '"+in_emp_cde+"'";
						sqlString = sqlString + tmp_sqlString;
				}

				sqlString = sqlString + " ORDER BY t_crt_tm DESC ";

//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryOptrList = new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryOptrList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryOptrList",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				String [][] Optr_Res = QueryOptrList.GetReturnArray ();
//ConnectDB.dispArray (Optr_Res);
//System.out.println('\n'+"Query SUB Employee Code successfully! ");
				int emp_len = Optr_Res.length;
				String [][] ReturnResult = new String [emp_len][9];
				ReturnResult[0][0] = Optr_Res[0][0];
				ReturnResult[0][1] = Optr_Res[0][1];
				ReturnResult[0][2] = Optr_Res[0][2];
				ReturnResult[0][3] = Optr_Res[0][3];
				ReturnResult[0][4] = Optr_Res[0][4];
				ReturnResult[0][5] = "C_EMP_CNM";
				ReturnResult[0][6] = "C_EMP_ENM";
				ReturnResult[0][7] = "C_DPT_CNM";
				ReturnResult[0][8] = "C_DPT_ENM";

//System.out.println("The length of OPTR LIST: " + emp_len);
				for (int i = 1; i < emp_len ; i++){
					ReturnResult[i][0] = Optr_Res[i][0];
					ReturnResult[i][1] = Optr_Res[i][1];
					ReturnResult[i][2] = Optr_Res[i][2];
					ReturnResult[i][3] = Optr_Res[i][3];
					ReturnResult[i][4] = Optr_Res[i][4];
					String [][] tmp_Res1 = getEmpCEnm(Optr_Res[i][1]);
					String [][] tmp_Res2 = getDptCEnm(Optr_Res[i][2],Constant.DPT_CHNNAME);
					ReturnResult[i][5] = tmp_Res1[1][0];
					ReturnResult[i][6] = tmp_Res1[1][1];
					ReturnResult[i][7] = tmp_Res2[1][0];
					ReturnResult[i][8] = tmp_Res2[1][1];
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPTRMANAGE, Constant.SUCCESS_EVENT, "queryOptrList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 7 : Query Operator Authority List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryAuthList(String in_opr_cde, String in_emp_cde, String auth_opr_cde, String auth_dpt_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((auth_opr_cde==null) || (auth_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryAuthList() --- OPR_INVALIDAUTH!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);    // Modify Exception Code
				}

				if ((auth_dpt_cde==null) || (auth_dpt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryAuthList() --- OPR_INVALIDDPTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDDPTCDE);    // Modify Exception Code
				}

				boolean input_opr_cde=true;
				boolean input_emp_cde=true;
				String sqlString ="";
				String[][] sqlParameters = new String [4][3];

				if ((in_opr_cde==null) || (in_opr_cde.length()==0))
						input_opr_cde=false;

				if ((in_emp_cde==null) || (in_emp_cde.length()==0))
						input_emp_cde=false;

				if (!input_opr_cde && !input_emp_cde){
/*
						sqlString =Sqlstmt.SELECT_AUTHLIST;                 //SQL
						String[][] sqlParameters1 = {{"c_acredt_cde",auth_opr_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters = sqlParameters1;
*/
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryAuthList() --- OPR_INVALIDOPREMP!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDOPREMP);    // Modify Exception Code
				}

				if (input_opr_cde && !input_emp_cde){
						sqlString =Sqlstmt.SELECT_AUTHLIST_OPR;             //SQL
						String[][] sqlParameters2 = {{"c_acredt_cde",   auth_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
																				 {"c_opr_cde",      in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters = sqlParameters2;
				}

				if (!input_opr_cde && input_emp_cde){
						sqlString =Sqlstmt.SELECT_AUTHLIST_EMP;              //SQL
						String[][] sqlParameters3 = {{"c_acredt_cde",   auth_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
																				 {"c_emp_cde",      in_emp_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters = sqlParameters3;
				}

				if (input_opr_cde && input_emp_cde){
						sqlString =Sqlstmt.SELECT_AUTHLIST_OPREMP;           //SQL
						String[][] sqlParameters4 = {{"c_acredt_cde",   auth_opr_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
																				 {"c_opr_cde",      in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
																				 {"c_emp_cde",      in_emp_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters = sqlParameters4;
				}

				ConnectDB QueryAuthList= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);

				switch (QueryAuthList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryAuthList",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "queryAuthList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryAuthList.GetReturnArray ();
		}


//////////////////////////////////////////////////////////////////////////////////////
// Common Routine for all case
// Get department chinese name and English name of the department code
// return string array -- employee Department chinese name and english name
//////////////////////////////////////////////////////////////////////////////////////
	public java.lang.String[][] getDptCEnm(String in_dpt_cde, String cenm_typ)
				throws com.mcip.orb.CoException{

				Connection r_conn = r_pm.getConnection(r_dbname);
				String [][] ReturnResult = new String [2][2];
				String sqlString = new String("");
				if (cenm_typ.equals(Constant.DPT_ABRNAME)) {
//            sqlString = Sqlstmt.SELECT_DPTCENM_ABR + " AND c_dpt_cde = '" + in_dpt_cde + "'";          // SQL
						sqlString = Sqlstmt.SELECT_DPTCENM_ABR;          // SQL
				}else{
//            sqlString = Sqlstmt.SELECT_DPTCENM + " AND c_dpt_cde = '" + in_dpt_cde + "'";          // SQL
						sqlString = Sqlstmt.SELECT_DPTCENM;          // SQL
				}

				String [][] sqlParameters= {{"c_dpt_cde",     in_dpt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB getdptcenm = new ConnectDB(r_conn,sqlString,Constant.executePrepQuery,sqlParameters);

//        ConnectDB getdptcenm = new ConnectDB(r_conn,sqlString,Constant.executeSqlQuery);
				switch (getdptcenm.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult[0][0] = "C_DPT_CNM";         // c_dpt_abr as c_dpt_cnm
									ReturnResult[0][1] = "C_DPT_ENM";
									ReturnResult[1][0] = "";
									ReturnResult[1][1] = "";
//System.out.println("DPT CENM NOT FOUND ");
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult[0][0] = getdptcenm.GetReturnArray()[0][0];
									ReturnResult[0][1] = getdptcenm.GetReturnArray()[0][1];
									ReturnResult[1][0] = getdptcenm.GetReturnArray()[1][0];
									ReturnResult[1][1] = getdptcenm.GetReturnArray()[1][1];
//System.out.println("DPT CENM FOUND ");
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 8 : Query Operator owned Department List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryOptrDptList(String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryOptrDptList() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

// Held By YiJF Oct-19 2000
//        boolean Auth_Dpt_Exist=true;
//        String [][] ReturnResult = null;

				String sqlString =Sqlstmt.SELECT_OPTRDPT;             //SQL    Select from t_opr_dpt
				String [][] sqlParameters= {{"c_opr_cde",   in_opr_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryOptrDptList= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);

				switch (QueryOptrDptList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryOptrDptList",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				String [][] OptrDpt_Res = QueryOptrDptList.GetReturnArray();
//ConnectDB.dispArray (OptrDpt_Res);
//System.out.println('\n'+"Query Department Code successfully");
				int dpt_len = OptrDpt_Res.length;
				String [][] ReturnResult = new String [dpt_len][7];
				ReturnResult[0][0] = OptrDpt_Res[0][0];
				ReturnResult[0][1] = OptrDpt_Res[0][1];
				ReturnResult[0][2] = OptrDpt_Res[0][2];
				ReturnResult[0][3] = "C_DPT_CNM";
				ReturnResult[0][4] = "C_DPT_ENM";
				ReturnResult[0][5] = "C_SNR_CNM";
				ReturnResult[0][6] = "C_SNR_ENM";

//System.out.println("The length of OPTR_DPT: " + dpt_len);
				for (int i = 1; i < dpt_len ; i++){
					ReturnResult[i][0] = OptrDpt_Res[i][0];
					ReturnResult[i][1] = OptrDpt_Res[i][1];
					ReturnResult[i][2] = OptrDpt_Res[i][2];
					String [][] tmp_Res1 = getDptCEnm(OptrDpt_Res[i][1],Constant.DPT_ABRNAME);
					String [][] tmp_Res2 = getDptCEnm(OptrDpt_Res[i][2],Constant.DPT_ABRNAME);
					ReturnResult[i][3] = tmp_Res1[1][0];
					ReturnResult[i][4] = tmp_Res1[1][1];
					ReturnResult[i][5] = tmp_Res2[1][0];
					ReturnResult[i][6] = tmp_Res2[1][1];
				}

				String[][] Res_array = null_rec_filter(ReturnResult,3);
// Held By YiJF Oct-19 2000
/*
				switch (QueryOptrDptList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									Auth_Dpt_Exist=false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									Auth_Dpt_Exist=true;
									ReturnResult = QueryOptrDptList.GetReturnArray();
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				if (!Auth_Dpt_Exist){
						String sqlString1 =Sqlstmt.SELECT_OPTRDPT_OPTR;          //SQL    Select from t_operator
						String[][] sqlParameters1 = {{"c_opr_cde",    in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};
						ConnectDB QueryOptrDptList1 = new ConnectDB (l_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);

						switch (QueryOptrDptList1.GetReturnCode()) {
							 case Constant.ConnectDB_SelectNone:
										ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryOptrDptList",Constant.WARNING);
							 case Constant.ConnectDB_SelectMulti:
										ErrorHandling(ExceptionCode.DB_NOTUNIQUEREC,"","queryOptrDptList",Constant.WARNING);
							 case Constant.ConnectDB_SelectOne:
										break;
							 default:
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}
						ReturnResult = QueryOptrDptList1.GetReturnArray();
				}
*/
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "queryOptrDptList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
// Held By YiJF Oct-19 2000
//        return ReturnResult;
				return Res_array;
		}


////////////////////////////////////////////////////////
// Use Case 9 :Accept New System Function
////////////////////////////////////////////////////////

	public boolean acceptSysFunc(com.mcip.bus.orb.SysFuncInfo sysfuncInfoobj)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Get SYSTEM FUNCTION SEQUENCE FROM MCIP_FUNCSEQ
				String SqlStatement=Sqlstmt.SELECT_FUNC_SEQ;       // SQL
				ConnectDB getFuncSeq= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
				switch (getFuncSeq.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);        // Modify Exception Later
						 case Constant.ConnectDB_SelectMulti:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);        // Modify Exception Later
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				};
				sysfuncInfoobj.c_func_cde = getFuncSeq.GetReturnArray ()[1][0];

//Check if unique
				if (!checkUniqueFunc(sysfuncInfoobj.c_func_cde)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_FUNCMANAGE, Constant.FAIL_EVENT, "acceptSysFunc() --- OPR_DUPLICATEFUNCCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_DUPLICATEFUNCCDE);        // Modify Exception Later
				}

//Insert into t_sys_func
				String sqlString =Sqlstmt.INSERT_SYSFUNC;             //SQL
				String [][] sqlParameters =
							{{"c_func_cde",sysfuncInfoobj.c_func_cde,String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_func_cnm",sysfuncInfoobj.c_func_cnm,String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_func_enm",sysfuncInfoobj.c_func_enm,String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertSysFunc = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertSysFunc.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_FUNCMANAGE, Constant.SUCCESS_EVENT, "acceptSysFunc() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 10 : Update System Function
////////////////////////////////////////////////////////

	public boolean updateSysFunc(com.mcip.bus.orb.SysFuncInfo sysfuncInfoobj)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Update t_sys_func
				String sqlString =Sqlstmt.UPDATE_SYSFUNC;             //SQL
				String [][] sqlParameters =
							{{"c_func_cnm",sysfuncInfoobj.c_func_cnm,String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_func_enm",sysfuncInfoobj.c_func_enm,String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_func_cde",sysfuncInfoobj.c_func_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateSysFunc = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateSysFunc.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_FUNCMANAGE, Constant.SUCCESS_EVENT, "updateSysFunc() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Common Routine for all case
// Check system function's home page exist or not
// False -- not exit; True -- exist
////////////////////////////////////////////////////////
	public boolean checkPagesExist(String in_func_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_PAGESEXIST;          // SQL
				String [][] sqlParameters= {{"c_func_cde",    in_func_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB checkpagesexist = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkpagesexist.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = true;
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 11 : Delete System Function
////////////////////////////////////////////////////////

	public boolean deleteSysFunc(String in_func_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Check if this system function contain some home pages.
				if (checkPagesExist(in_func_cde)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_FUNCMANAGE, Constant.FAIL_EVENT, "deleteSysFunc() --- OPR_FUNCWITHPAGES!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_FUNCWITHPAGES);        // Modify Exception Later
				}

//Delete from t_sys_func
				/*Add R20010927{*/
				{
				String sqlString = Sqlstmt.DELETE_SYSFUNC_PRE1;

				String [][] sqlParameters =
							{{"c_func_cde",       in_func_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
				
				ConnectDB DeleteSysFunc = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeleteSysFunc.GetReturnCode()) {
						 case Constant.ConnectDB_Success:
						case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				l_pm.freeConnection (l_dbname,l_conn);
				}
				/*}Add R20010927*/				
				String sqlString = Sqlstmt.DELETE_SYSFUNC;             //SQL
				String[][] sqlParameters =
							{{"c_func_cde",       in_func_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
				
				System.out.println("check ok");
				ConnectDB DeleteSysFunc = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeleteSysFunc.GetReturnCode()) {
						 case Constant.ConnectDB_Success:
						case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_FUNCMANAGE, Constant.SUCCESS_EVENT, "deleteSysFunc() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
	}


////////////////////////////////////////////////////////
// Use Case 12 : Query System Function List
////////////////////////////////////////////////////////

	public java.lang.String[][] querySysFuncList(String in_func_cde)
				throws com.mcip.orb.CoException {

				String [][] ReturnResult = new String [2][3];
				String SqlStatement=new String("");

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_func_cde==null) || (in_func_cde.length()==0)){

					SqlStatement=Sqlstmt.SELECT_SYSFUNC_1;
					ConnectDB QuerySysFuncList1= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QuerySysFuncList1.GetReturnCode()) {
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
					ReturnResult = QuerySysFuncList1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECT_SYSFUNC_2;
					String [][] sqlParameters= {{"c_func_cde",      in_func_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QuerySysFuncList2= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
					switch (QuerySysFuncList2.GetReturnCode()) {
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
					ReturnResult = QuerySysFuncList2.GetReturnArray ();
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_FUNCMANAGE, Constant.SUCCESS_EVENT, "querySysFuncList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 13 :Accept New Page Info
////////////////////////////////////////////////////////

	public boolean acceptPagesInfo(com.mcip.bus.orb.PagesInfo pagesinfoobj)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Get PAGES SEQUENCE FROM MCIP_PAGESEQ
				String SqlStatement=Sqlstmt.SELECT_PAGE_SEQ;                  //SQL
				ConnectDB getPageSeq= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
				switch (getPageSeq.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);        // Modify Exception Later
						 case Constant.ConnectDB_SelectMulti:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);        // Modify Exception Later
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				};
			 pagesinfoobj.c_page_no = pagesinfoobj.c_func_cde + getPageSeq.GetReturnArray ()[1][0];

//Check if unique
				if (!checkUniquePage(pagesinfoobj.c_page_no)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PAGEMANAGE, Constant.FAIL_EVENT, "acceptPagesInfo() --- OPR_DUPLICATEPAGENO!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_DUPLICATEPAGENO);        // Modify Exception Later
				}

//Insert into t_pages_manager
				String sqlString =Sqlstmt.INSERT_PAGEINFO;             //SQL
				String [][] sqlParameters =
							{{"c_page_no",      pagesinfoobj.c_page_no,       String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_page_title",   pagesinfoobj.c_page_title,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_file_enm",     pagesinfoobj.c_file_enm,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_func_cde",     pagesinfoobj.c_func_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertPageInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertPageInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PAGEMANAGE, Constant.SUCCESS_EVENT, "acceptPagesInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;

			}


////////////////////////////////////////////////////////
// Use Case 14 : Update System Function
////////////////////////////////////////////////////////

	public boolean updatePagesInfo(com.mcip.bus.orb.PagesInfo pagesinfoobj)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Update t_pages_manager
				String sqlString =Sqlstmt.UPDATE_PAGEINFO;             //SQL
				String [][] sqlParameters =
							{{"c_page_title",   pagesinfoobj.c_page_title,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_file_enm",     pagesinfoobj.c_file_enm,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_func_cde",     pagesinfoobj.c_func_cde,        String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_page_no",      pagesinfoobj.c_page_no,         String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdatePageInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdatePageInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PAGEMANAGE, Constant.SUCCESS_EVENT, "updatePagesInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 15 : Delete Page Info
////////////////////////////////////////////////////////

	public boolean deletePagesInfo(String in_page_no)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
//Delete from t_pages_manager
				String sqlString = Sqlstmt.DELETE_PAGEINFO;             //SQL
				String [][] sqlParameters =
							{{"c_page_no",    in_page_no,   String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeletePageInfo = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeletePageInfo.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PAGEMANAGE, Constant.SUCCESS_EVENT, "deletePagesInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 16 : Query Pages List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryPagesList(String in_func_cde)
				throws com.mcip.orb.CoException {

				String [][] ReturnResult = new String [2][3];
				String SqlStatement=new String("");

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_func_cde==null) || (in_func_cde.length()==0)){

					SqlStatement=Sqlstmt.SELECT_PAGES_1;
					ConnectDB QueryPagesList1= new ConnectDB (l_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QueryPagesList1.GetReturnCode()) {
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
					ReturnResult = QueryPagesList1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECT_PAGES_2;
					String [][] sqlParameters= {{"c_func_cde",    in_func_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryPagesList2= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
					switch (QueryPagesList2.GetReturnCode()) {
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
					ReturnResult = QueryPagesList2.GetReturnArray ();
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_PAGEMANAGE, Constant.SUCCESS_EVENT, "queryPagesList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 17 :Accept Operator Authority Info
////////////////////////////////////////////////////////

	public boolean acceptOptrAuth (String[][] optrauthinfo, String[][] optrdptinfo)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				ReturnResult =true;

				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 18 : Update Operator Authority Info
////////////////////////////////////////////////////////

	public boolean updateOptrAuth (String[][] optrauthinfo, String[][] optrdptinfo)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				ReturnResult =true;

				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 19 : Delete Operator Authority Info
////////////////////////////////////////////////////////

	public boolean deleteOptrAuth (String in_opr_cde, String in_func_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				ReturnResult =true;

				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 20 : Query Available Authority Department List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryAbleDptList(String in_opr_cde, String auth_opr_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((auth_opr_cde==null) || (auth_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryAbleDptList() --- OPR_INVALIDAUTH!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);     // Modify Exception CODE
				}

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryAbleDptList() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);     // Modify Exception CODE
				}

				String [][] tmp_Res1 = new String [2][2];
				String sqlString =Sqlstmt.SELECT_OPTRDPT_ABLE;          //SQL    Select from t_opr_dpt
				String[][] sqlParameters = {{"c_opr_cde",    auth_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
																		{"c_opr_cde",    in_opr_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryAbleDptList = new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (QueryAbleDptList.GetReturnCode()) {
						case Constant.ConnectDB_SelectNone:
								 l_pm.freeConnection (l_dbname,l_conn);
								 ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
						case Constant.ConnectDB_SelectMulti:
						case Constant.ConnectDB_SelectOne:
								 break;
						default:
								 l_pm.freeConnection (l_dbname,l_conn);
								 ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				String [][] able_Res = QueryAbleDptList.GetReturnArray();
				int dpt_len = able_Res.length;
				String [][] ReturnResult = new String [dpt_len][3];
				ReturnResult[0][0] = able_Res[0][0];
				ReturnResult[0][1] = "C_DPT_CNM";
				ReturnResult[0][2] = "C_DPT_ENM";

//System.out.println("The length of OPTR_DPT: " + dpt_len);
				for (int i = 1; i < dpt_len ; i++){
					ReturnResult[i][0] = able_Res[i][0];
					tmp_Res1 = getDptCEnm(able_Res[i][0],Constant.DPT_CHNNAME);
					ReturnResult[i][1] = tmp_Res1[1][0];
					ReturnResult[i][2] = tmp_Res1[1][1];
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "queryAbleDptList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 21 : Execute Operator Authority Action
////////////////////////////////////////////////////////

	public boolean executeOptrAuth (String act_typ, String auth_opr_cde, String in_opr_cde, java.lang.String[][] optrauthinfo, java.lang.String[][] optrdptinfo)
				throws com.mcip.orb.CoException{

//System.out.println("Begin executeOptrAuth function call ! ");

				Connection l_conn = l_pm.getConnection(l_dbname);
				boolean ReturnResult =false;
				int auth_len = optrauthinfo.length;
				int dpt_len = optrdptinfo.length;

				if ((auth_opr_cde==null) || (auth_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDAUTH!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);     // Modify Exception CODE
				}

				if ((act_typ==null) || (act_typ.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDACTTYP!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDACTTYP);     // Modify Exception CODE
				}

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);     // Modify Exception CODE
				}
//System.out.println("Valid executeOptrAuth function call ! ");
				if ((act_typ.equals(Constant.ACCEPT_OPRAUTH_MRK)) ||

						(act_typ.equals(Constant.UPDATE_OPRAUTH_MRK))){

					if ((auth_len==0) || (dpt_len==0)) {

						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_AUTHNULLARRAY!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_AUTHNULLARRAY);     // Modify Exception CODE
					}
				}else{

					 if (!(act_typ.equals(Constant.DELETE_OPRAUTH_MRK))) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDACTTYP!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDACTTYP);     // Modify Exception CODE
					 }
				}
//System.out.println("after checking in executeOptrAuth function call. ");

//detele from t_opr_dpt
				String sqlString1 =Sqlstmt.DELETE_OPRDPT;           //SQL
				String [][] sqlParameters1 =
							{{"c_opr_cde",      in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteOprDpt = new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);
				switch (DeleteOprDpt.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//System.out.println("after delete t_opr_dpt in executeOptrAuth function call.");

//detele from t_opr_auth
				String sqlString2 =Sqlstmt.DELETE_OPRAUTH;           //SQL
				String [][] sqlParameters2 =
							{{"c_opr_cde",in_opr_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

				if (act_typ.equals(Constant.DELETE_OPRAUTH_MRK)) {
					ConnectDB DeleteOprAuth = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

					switch (DeleteOprAuth.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}else{

					ConnectDB DeleteOprAuth = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdateNoCommit,sqlParameters2);
					switch (DeleteOprAuth.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}
//System.out.println("after delete t_opr_auth in executeOptrAuth function call.");

				if ((act_typ.equals(Constant.ACCEPT_OPRAUTH_MRK)) ||
						(act_typ.equals(Constant.UPDATE_OPRAUTH_MRK))){

// Insert into t_opr_dpt
/*
				String statement_dpt[]=new String[4];
				String parm_dpt [][][]=new String[4][3][2];
*/
				String statement_dpt[]=new String[dpt_len];
				String parm_dpt [][][]=new String[dpt_len][3][3];
				for (int i = 0; i < dpt_len ; i++){
				if (optrdptinfo[i][1].length() == 7) {
						optrdptinfo[i][2] = optrdptinfo[i][1].substring(0,5);
				}
				if (optrdptinfo[i][1].length() == 5) {
						optrdptinfo[i][2] = optrdptinfo[i][1].substring(0,3);
				}
				if (optrdptinfo[i][1].length() == 3) {
						optrdptinfo[i][2] = optrdptinfo[i][1].substring(0,1);
				}

				statement_dpt[i]=Sqlstmt.INSERT_OPRDPT;
				parm_dpt[i] = set_parameter_value3("c_opr_cde",optrdptinfo[i][0],String.valueOf(Constant.VARCHAR2_TYPE),
																					 "c_dpt_cde",optrdptinfo[i][1],String.valueOf(Constant.VARCHAR2_TYPE),
																					 "c_snr_dpt",optrdptinfo[i][2],String.valueOf(Constant.VARCHAR2_TYPE));
				}

				ConnectDB InsertOprDpt = new ConnectDB (l_conn,statement_dpt,Constant.executeBatchPrepUpdateNoCommit,parm_dpt);
				switch (InsertOprDpt.GetReturnCode()) {

						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//System.out.println("after insert t_opr_dpt in executeOptrAuth function call.");

// Insert into t_opr_auth
/*
				String statement_auth[]=null;
				String parm_auth [][][]=new String[4][3][2];
*/
				String statement_auth[]=new String[auth_len];
				String parm_auth [][][]=new String[auth_len][3][2];
				for (int i = 0; i < auth_len ; i++){
				statement_auth[i]=Sqlstmt.INSERT_OPRAUTH;
				parm_auth[i] = set_parameter_value2("c_opr_cde",     optrauthinfo[i][0],     String.valueOf(Constant.VARCHAR2_TYPE),
																					 "c_func_cde",    optrauthinfo[i][1],     String.valueOf(Constant.VARCHAR2_TYPE));
				}

				ConnectDB InsertOprAuth = new ConnectDB (l_conn,statement_auth,Constant.executeBatchPrepUpdate,parm_auth);
				switch (InsertOprAuth.GetReturnCode()) {

						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//System.out.println("after insert t_opr_auth in executeOptrAuth function call.");
				}                         // INSERT OR UPDATE ACTION

				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "executeOptrAuth() --- SUCCESSFULLY!");
				ReturnResult =true;
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}



////////////////////////////////////////////////////////
// Common Routine for all case
// set parameters values for executeOptrAuth()
// return string array [][]
////////////////////////////////////////////////////////
		String [][] set_parameter_value2(String c_field_name1, String c_field_value1, String c_field_type1,
																		String c_field_name2, String c_field_value2, String c_field_type2)
				throws com.mcip.orb.CoException{
				String [][] sqlParameters={{c_field_name1,c_field_value1,c_field_type1},
																	 {c_field_name2,c_field_value2,c_field_type2}};
				return sqlParameters;
		}

		String [][] set_parameter_value3(String c_field_name1, String c_field_value1, String c_field_type1,
																		String c_field_name2, String c_field_value2, String c_field_type2,
																		String c_field_name3, String c_field_value3, String c_field_type3)
				throws com.mcip.orb.CoException{
				String [][] sqlParameters={{c_field_name1,c_field_value1,c_field_type1},
																	 {c_field_name2,c_field_value2,c_field_type2},
																	 {c_field_name3,c_field_value3,c_field_type3}};
				return sqlParameters;
		}


////////////////////////////////////////////////////////
// Common Routine for all case
// Check the function access right of operator
// False -- no right ; True -- have right
////////////////////////////////////////////////////////
	public boolean checkOptrAuth(String in_opr_cde, String in_func_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_CHKOPTRAUTH;          // SQL
				String [][] sqlParameters= {{"c_opr_cde",     in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
																		{"c_func_cde",    in_func_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkoptrauth = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkoptrauth.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult =false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult =true;
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 22 : Query The Same Name Client List
////////////////////////////////////////////////////////

	public java.lang.String[][] querySameCustList(String in_clnt_cnm)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_clnt_cnm==null) || (in_clnt_cnm.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "querySameCustList() --- OPR_NOCLNTCNM!");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_NOCLNTCNM);    // Modify Exception Code
				}

				String sqlString = Sqlstmt.SELECT_SAMECUST;             //SQL    Select from t_opr_dpt
				String [][] sqlParameters = {{"c_clnt_nme",     in_clnt_cnm,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QuerySameCustList = new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (QuerySameCustList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTMANAGE, Constant.SUCCESS_EVENT, "querySameCustList() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QuerySameCustList.GetReturnArray();
		}


////////////////////////////////////////////////////////
// Use Case 23 : Get Customer List for verification   //
////////////////////////////////////////////////////////

	public java.lang.String[][] queryCustEnttList(String in_opr_cde, String in_verify_flg, java.lang.String[] owned_dpt,
																				String frm_crt_tm,String to_crt_tm,
																				String frm_verify_tm, String to_verify_tm,
																				int frm_ltimes, int to_ltimes, String in_user_id)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "queryCustEnttList() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);         //  Modify Exceoption
				}

				if ((in_verify_flg==null) || (in_verify_flg.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "queryCustEnttList() --- OPR_INVALIDVRFYFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDVRFYFLG);         //  Modify Exceoption
				}

				boolean vrf_flg = true;
				boolean input_frm_crt = true;
				boolean input_to_crt = true;
				boolean input_frm_vrf = true;
				boolean input_to_vrf = true;
				boolean input_frm_lt = true;
				boolean input_to_lt = true;
				boolean input_user_id = true;

				if ((in_verify_flg.equals(Constant.VERIFYING_FLAG)) ||
						(in_verify_flg.equals(Constant.VERIFIED_FLAG)) ||
						(in_verify_flg.equals(Constant.VERIFY_ALL_FLAG))){
					vrf_flg = true;
				}else{
					vrf_flg = false;
				}

				if (!vrf_flg) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "queryCustEnttList() --- OPR_INVALIDVRFYFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDVRFYFLG);         //  Modify Exceoption
				}

				if ((frm_crt_tm==null) || (frm_crt_tm.length()==0))
						input_frm_crt=false;

				if ((to_crt_tm==null) || (to_crt_tm.length()==0))
						input_to_crt=false;

				if ((frm_verify_tm==null) || (frm_verify_tm.length()==0))
						input_frm_vrf=false;

				if ((to_verify_tm==null) || (to_verify_tm.length()==0))
						input_to_vrf=false;

				if (frm_ltimes==0)
						input_frm_lt=false;

				if (to_ltimes==0)
						input_to_lt=false;

				if ((in_user_id==null) || (in_user_id.length()==0))
						input_user_id=false;

				String sqlString = new String("");
				String arguString = new String("");

				if (input_frm_crt || input_to_crt) {
					if (input_frm_crt) {
							String tmp_sqlString = " AND t_crt_tm >= TO_DATE('"+frm_crt_tm+"', 'YYYY-MM-DD')";
							arguString = arguString + tmp_sqlString;
					}
					if (input_to_crt) {
							String tmp_sqlString = " AND t_crt_tm <= TO_DATE('"+to_crt_tm+"', 'YYYY-MM-DD')+1";
							arguString = arguString + tmp_sqlString;
					}
				}

				if (input_user_id) {
						String tmp_sqlString = " AND c_user_id = '"+in_user_id+"'";
						arguString = arguString + tmp_sqlString;
				}

				if (input_frm_vrf || input_to_vrf) {
					if (input_frm_vrf) {
							String tmp_sqlString = " AND t_verify_tm >= TO_DATE('"+frm_verify_tm+"', 'YYYY-MM-DD')";
							arguString = arguString + tmp_sqlString;
					}
					if (input_to_vrf) {
							String tmp_sqlString = " AND t_verify_tm <= TO_DATE('"+to_verify_tm+"', 'YYYY-MM-DD')+1";
							arguString = arguString + tmp_sqlString;
					}
				}

				if (input_frm_lt || input_to_lt) {
					if (input_frm_lt) {
							String tmp_sqlString = " AND n_login >= "+String.valueOf(frm_ltimes);
							arguString = arguString + tmp_sqlString;
					}
					if (input_to_lt) {
							String tmp_sqlString = " AND n_login <= "+String.valueOf(to_ltimes);
							arguString = arguString + tmp_sqlString;
					}
				}

				if (owned_dpt[0].length() > 0){
						int dptarray_len = owned_dpt.length;
						//String dpt_sqlString = " AND c_dpt_cde IN (";
						String dpt_sqlString = " AND ( ";
						for (int i = 0; i < dptarray_len ; i++){
							 if ((i-dptarray_len+1)==0)
									dpt_sqlString = dpt_sqlString + " c_dpt_cde like '" + owned_dpt[i] + "%'";
							 else
									dpt_sqlString = dpt_sqlString + " c_dpt_cde like '" + owned_dpt[i] + "%' OR ";
						}
						arguString = arguString + dpt_sqlString + " )";    //SQL
				}

				if (in_verify_flg.equals(Constant.VERIFIED_FLAG))
						arguString = arguString + " AND c_verify != '"+Constant.USER_NOTVERIFY+"' AND c_verify != '"+Constant.USER_CANCEL+"'";

				if (in_verify_flg.equals(Constant.VERIFYING_FLAG))
						arguString = arguString + " AND c_verify = '"+Constant.USER_NOTVERIFY+"'";

				sqlString = Sqlstmt.SELECT_CLNTVERIFY + arguString + " ORDER BY t_crt_tm DESC ";     //SQL
//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryCustEnttList= new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
				switch (QueryCustEnttList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.SUCCESS_EVENT, "queryCustEnttList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryCustEnttList.GetReturnArray();
		}


////////////////////////////////////////////////////////
// Common Routine for all case
// Check agent code exist or not
// False -- not exit; True -- exist
////////////////////////////////////////////////////////
	public boolean checkAgent(String in_cmpny_agt_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection r_conn = r_pm.getConnection(r_dbname);
				String sqlString =Sqlstmt.SELECT_AGENTEXIST;          // SQL
				String [][] sqlParameters= {{"c_cmpny_agt_cde",   in_cmpny_agt_cde,   String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkagentexist = new ConnectDB(r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkagentexist.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = true;
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Common Routine for all case
// Check OC customer client code exist or not
// False -- not exit; True -- exist
////////////////////////////////////////////////////////
	public boolean checkOcust(String in_user_id)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
// Select c_clnt_cde from t_clnt_map
				String SqlStatement=Sqlstmt.SELECT_CLNTMAP;
				String [][] sqlParameters= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryClntMapList= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryClntMapList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = true;
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				};

				if (ReturnResult){
						int clntarray_len = QueryClntMapList.GetReturnArray().length-1;
						String clnt_sqlString = " AND c_clnt_cde IN (";

						for (int i = 0; i < clntarray_len ; i++){
							 if ((i-clntarray_len+1)==0)
									clnt_sqlString = clnt_sqlString + "'" + QueryClntMapList.GetReturnArray()[i+1][1] + "'";
							 else
									clnt_sqlString = clnt_sqlString + "'" + QueryClntMapList.GetReturnArray()[i+1][1] + "', ";
						}

						String sqlString =Sqlstmt.SELECT_OCUSTEXIST + clnt_sqlString + " ) ";    //SQL
						ConnectDB checkocustexist = new ConnectDB (r_conn,sqlString,Constant.executeSqlQuery);
						switch (checkocustexist.GetReturnCode()) {
								case Constant.ConnectDB_SelectNone:
											ReturnResult = false;
											break;
								case Constant.ConnectDB_SelectMulti:
								case Constant.ConnectDB_SelectOne:
											ReturnResult = true;
											break;
								default:
											r_pm.freeConnection (r_dbname,r_conn);
											l_pm.freeConnection (l_dbname,l_conn);
											ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}
				}
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Common Routine for all case
// Check customer code exist or not
// False -- not exit; True -- exist
////////////////////////////////////////////////////////
	public boolean checkNormalcust(String in_clnt_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection r_conn = r_pm.getConnection(r_dbname);
				String sqlString =Sqlstmt.SELECT_NORMLEXIST;          // SQL
				String [][] sqlParameters= {{"c_clnt_cde",    in_clnt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB checkcustexist = new ConnectDB(r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkcustexist.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = true;
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 24 :Accept Customer verify info
////////////////////////////////////////////////////////

	public boolean acceptUserVerify(String in_user_id, String in_clnt_cde, String in_cmpny_agt_cde,
																	String in_verify_flg, String in_vrfy_desc, String in_opr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;
				boolean vrf_flg = true;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((in_user_id==null) || (in_user_id.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((in_verify_flg.equals(Constant.AGENCY_CUST_MRK)) ||
						(in_verify_flg.equals(Constant.NORMAL_CUST_MRK)) ||
						(in_verify_flg.equals(Constant.OPNCVR_CUST_MRK)) ||
						(in_verify_flg.equals(Constant.USER_NOTVERIFY)) ||
						(in_verify_flg.equals(Constant.USER_CANCEL))){
					vrf_flg = true;
				}else{
					vrf_flg = false;
				}

				if (!vrf_flg) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_INVALIDVRFYFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDVRFYFLG);         //  Modify Exceoption
				}

				if (in_verify_flg.equals(Constant.AGENCY_CUST_MRK)){
					if ((in_cmpny_agt_cde==null) || (in_cmpny_agt_cde.length()==0)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_INVALIDAGNT!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_INVALIDAGNT);       // Modify Exception Code
					}
//Check cmpny_agt_cde valid or not
					if (!checkAgent(in_cmpny_agt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_AGNTNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_AGNTNOTEXIST);       // Modify Exception Code
					}
				}

				if (in_verify_flg.equals(Constant.OPNCVR_CUST_MRK)){
					if ((in_clnt_cde==null) || (in_clnt_cde.length()==0)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_INVALIDCLNT!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_INVALIDCLNT);       // Modify Exception Code
					}
//Check Open Cover clnt_cde valid or not
					if (!checkOcust(in_user_id)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_OPCVNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_OPCVNOTEXIST);       // Modify Exception Code
					}
				}

				if (in_verify_flg.equals(Constant.NORMAL_CUST_MRK)){
					if ((in_clnt_cde==null) || (in_clnt_cde.length()==0)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_INVALIDCLNT!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_INVALIDCLNT);       // Modify Exception Code
					}
//Check clnt_cde valid or not
					if (!checkNormalcust(in_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.FAIL_EVENT, "acceptUserVerify() --- OPR_CLNTNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_CLNTNOTEXIST);       // Modify Exception Code
					}
				}

				if (in_verify_flg.equals(Constant.AGENCY_CUST_MRK)){
					String sqlString1 =new String("");
					String[][] sqlParameters1 = new String [4][3];

					if ((in_vrfy_desc==null) || (in_vrfy_desc.length()==0)){
						sqlString1 =Sqlstmt.UPDATE_AGENTVERIFY1;             //SQL
						String [][] sqlParameters11 =
								{{"c_cmpny_agt_cde",    in_cmpny_agt_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_verify",           in_verify_flg,        String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_user_id",          in_user_id,           String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters1 = sqlParameters11;
					}else{
						sqlString1 =Sqlstmt.UPDATE_AGENTVERIFY2;             //SQL
						String [][] sqlParameters12 =
								{{"c_cmpny_agt_cde",    in_cmpny_agt_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_verify",           in_verify_flg,        String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_verify_desc",      in_vrfy_desc,         String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_user_id",          in_user_id,           String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters1 = sqlParameters12;
					}

					ConnectDB UpdateUserVerify1 = new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdate,sqlParameters1);
					switch (UpdateUserVerify1.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}

				if ((in_verify_flg.equals(Constant.NORMAL_CUST_MRK)) ||
						(in_verify_flg.equals(Constant.OPNCVR_CUST_MRK))) {
					String sqlString2 =new String("");
					String[][] sqlParameters2 = new String [4][3];

					if ((in_vrfy_desc==null) || (in_vrfy_desc.length()==0)){
						sqlString2 =Sqlstmt.UPDATE_OCNORVERIFY1;             //SQL
						String [][] sqlParameters21 =
								{{"c_clnt_cde",     in_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_verify",       in_verify_flg,    String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_user_id",      in_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters2 = sqlParameters21;
					}else{
						sqlString2 =Sqlstmt.UPDATE_OCNORVERIFY2;             //SQL
						String [][] sqlParameters22 =
								{{"c_clnt_cde",     in_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_verify",       in_verify_flg,    String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_verify_desc",  in_vrfy_desc,     String.valueOf(Constant.VARCHAR2_TYPE)},
								 {"c_user_id",      in_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters2 = sqlParameters22;
					}

					ConnectDB UpdateUserVerify2 = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);
					switch (UpdateUserVerify2.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}

				if ((in_verify_flg.equals(Constant.USER_NOTVERIFY)) ||
						(in_verify_flg.equals(Constant.USER_CANCEL))){
					String sqlString3 =new String("");
					String[][] sqlParameters3 = new String [4][3];

					if ((in_vrfy_desc==null) || (in_vrfy_desc.length()==0)){
						sqlString3 =Sqlstmt.UPDATE_OTHERVERIFY1;             //SQL
						String [][] sqlParameters31 =
							{{"c_verify",       in_verify_flg,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_user_id",      in_user_id,         String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters3 = sqlParameters31;
					}else{
						sqlString3 =Sqlstmt.UPDATE_OTHERVERIFY2;             //SQL
						String [][] sqlParameters32 =
							{{"c_verify",       in_verify_flg,      String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_verify_desc",  in_vrfy_desc,       String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_user_id",      in_user_id,         String.valueOf(Constant.VARCHAR2_TYPE)}};
						sqlParameters3 = sqlParameters32;
					}

					ConnectDB UpdateUserVerify3 = new ConnectDB (l_conn,sqlString3,Constant.executePrepUpdate,sqlParameters3);
					switch (UpdateUserVerify3.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_CUSTMANAGE, Constant.SUCCESS_EVENT, "acceptUserVerify() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 25 : Replace Authority Operator
////////////////////////////////////////////////////////

	public boolean replaceAuthOptr(String org_optr_cde, String trgt_optr_cde)
				throws com.mcip.orb.CoException{

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((trgt_optr_cde==null) || (trgt_optr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "replaceAuthOptr() --- OPR_INVALIDAUTH!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);    // Modify Exception Code
				}

				if ((org_optr_cde==null) || (org_optr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "replaceAuthOptr() --- OPR_INVALIDREPLC!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDREPLC);    // Modify Exception Code
				}

				if (!compareAuthDptOptr(org_optr_cde, trgt_optr_cde)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "replaceAuthOptr() --- OPR_AUTHNOTINSCALE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_AUTHNOTINSCALE);       // Modify Exception Code
				}

				boolean ReturnResult =false;

//Replace Authority Operator
				String sqlString =Sqlstmt.REPLACE_AUTHOPTR;             //SQL
				String [][] sqlParameters =
							{{"c_acredt_cde",   trgt_optr_cde,    String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_acredt_cde",   org_optr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateSysFunc = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateSysFunc.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "replaceAuthOptr() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;

			}


///////////////////////////////////////////////////////////////
// Common Routine for all case
// Compare orginal Operator with target Operator For Department
// False -- different; True -- same
///////////////////////////////////////////////////////////////

	public boolean compareDptOptr(String org_dpt_cde, String trgt_optr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_CMPRDPT;          // SQL
				String [][] sqlParameters= {{"c_opr_cde",    trgt_optr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
																		{"c_dpt_cde",    org_dpt_cde,       String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB comparedpt = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (comparedpt.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = true;
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


///////////////////////////////////////////////////////////////
// Common Routine for all case
// Compare orginal Operator with target Operator For Authority
// False -- different; True -- same
///////////////////////////////////////////////////////////////

	public boolean compareAuthOptr(String org_func_cde, String trgt_optr_cde)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString =Sqlstmt.SELECT_CMPRAUTH;          // SQL
				String [][] sqlParameters= {{"c_opr_cde",    trgt_optr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)},
																		{"c_func_cde",   org_func_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB compareauth = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (compareauth.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = true;
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 26 : Query Operator owned Authority List
////////////////////////////////////////////////////////

	public java.lang.String[][] queryOptrAuthList(String in_opr_cde)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryOptrAuthList() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				String sqlString =Sqlstmt.SELECT_OPTRAUTH;             //SQL    Select from t_opr_auth
				String [][] sqlParameters= {{"c_opr_cde",   in_opr_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryOptrAuthList= new ConnectDB (l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (QueryOptrAuthList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryOptrAuthList",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "queryOptrAuthList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryOptrAuthList.GetReturnArray();
		}


/////////////////////////////////////////////////////////////////////////////////////////
// Use Case 27 : Compare orginal Operator with target Operator For Authority & Department
/////////////////////////////////////////////////////////////////////////////////////////

	public boolean compareAuthDptOptr(String org_optr_cde, String trgt_optr_cde)
				throws com.mcip.orb.CoException{

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((trgt_optr_cde==null) || (trgt_optr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "compareAuthDptOptr() --- OPR_INVALIDAUTH!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);    // Modify Exception Code
				}

				if ((org_optr_cde==null) || (org_optr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "compareAuthDptOptr() --- OPR_INVALIDREPLC!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDREPLC);    // Modify Exception Code
				}

				boolean ReturnResult =false;
				String [][] Org_DptRes = new String [2][2];
				String [][] Org_AuthRes = new String [2][2];


//Check If Original Operator's Department In Target Operator's Department Scale
				Org_DptRes = queryOptrDptList(org_optr_cde);
				int dpt_len = Org_DptRes.length;

//System.out.println("DPT LENGTH OF ORG_OPR_CDE: " + dpt_len);
				for (int i = 1; i < dpt_len ; i++){
					if (!compareDptOptr(Org_DptRes[i][1], trgt_optr_cde)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "compareAuthDptOptr() --- OPR_DPTNOTINSCALE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_DPTNOTINSCALE);       // Modify Exception Code
					}
				}

//Check If Original Operator's Department In Target Operator's Department Scale
				Org_AuthRes = queryOptrAuthList(org_optr_cde);
				int auth_len = Org_AuthRes.length;

//System.out.println("AUTH LENGTH OF ORG_OPR_CDE: " + auth_len);
				for (int i = 1; i < auth_len ; i++){
					if (!compareAuthOptr(Org_AuthRes[i][1], trgt_optr_cde)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "compareAuthDptOptr() --- OPR_AUTHNOTINSCALE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_AUTHNOTINSCALE);       // Modify Exception Code
					}
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "compareAuthDptOptr() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 28 : Query Sub Department List
////////////////////////////////////////////////////////

	public java.lang.String[][] querySubDptList(String in_dpt_cde)
				throws com.mcip.orb.CoException {

				Connection r_conn = r_pm.getConnection(r_dbname);
				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "querySubDptList() --- OPR_INVALIDDPTCDE!");
						r_pm.freeConnection (r_dbname,r_conn);
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDDPTCDE);    // Modify Exception Code
				}

				String sqlString =Sqlstmt.SELECT_SUBDPT;             //SQL    Select from t_opr_auth
				String [][] sqlParameters= {{"c_snr_dpt",   in_dpt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QuerySubDptList= new ConnectDB (r_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (QuerySubDptList.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","queryOptrAuthList",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "querySubDptList() --- SUCCESSFULLY!");
				r_pm.freeConnection (r_dbname,r_conn);
				l_pm.freeConnection (l_dbname,l_conn);
				return QuerySubDptList.GetReturnArray();
		}


////////////////////////////////////////////////////////
// Common Routine for all case
// Check customer code exist or not
// False -- exit; True -- not exist
////////////////////////////////////////////////////////
	public boolean checkUniqueMap(String in_user_id, String in_clnt_cde, String in_clnt_agt_flg)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString = new String ("");
				if (in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)){
						sqlString =Sqlstmt.SELECT_AGNTMAPEXIST;          // SQL
				}else{
						sqlString =Sqlstmt.SELECT_CLNTMAPEXIST;          // SQL
				}
				String [][] sqlParameters= {{"c_user_id",    in_user_id,     String.valueOf(Constant.VARCHAR2_TYPE)},
																		{"c_clnt_cde",   in_clnt_cde,    String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB checkMapexist = new ConnectDB(l_conn,sqlString,Constant.executePrepQuery,sqlParameters);
				switch (checkMapexist.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = true;
									break;
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									ReturnResult = false;
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


//////////////////////////////////////////////////////////////////
// Common Routine for all case
// Check if unique of main account mark (主帐号标志是否唯一)
// if act_typ = "0" (Accept) False -- not unique; True -- unique
// if act_typ = "1" (Update) False -- not unique; True -- unique
//////////////////////////////////////////////////////////////////
	public boolean checkMainFlg(String in_user_id, String in_clnt_cde, String act_typ)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				String sqlString1 =Sqlstmt.SELECT_MAINFLGFORADD;          // SQL
				String [][] sqlParameters1 = {{"c_user_id",    in_user_id,            String.valueOf(Constant.VARCHAR2_TYPE)},
																			{"c_main_flg",   Constant.MAIN_MRK,     String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB checkmainflg1 = new ConnectDB(l_conn,sqlString1,Constant.executePrepQuery,sqlParameters1);
				switch (checkmainflg1.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ReturnResult = true;
									break;
						 case Constant.ConnectDB_SelectMulti:
									ReturnResult = false;
									break;
						 case Constant.ConnectDB_SelectOne:
									if (act_typ.equals("1")){      // update operation
										ReturnResult = true;         // only one record
									}else{
										ReturnResult = false;
									}
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				if ((act_typ.equals("1")) && ReturnResult) {
						String sqlString2 =Sqlstmt.SELECT_MAINFLGFORUPD;          // SQL
						String [][] sqlParameters2 = {{"c_user_id",       in_user_id,         String.valueOf(Constant.VARCHAR2_TYPE)},
																					{"c_clnt_cde",      in_clnt_cde,        String.valueOf(Constant.VARCHAR2_TYPE)},
																					{"c_cmpny_agt_cde", in_clnt_cde,        String.valueOf(Constant.VARCHAR2_TYPE)},
																					{"c_main_flg",      Constant.MAIN_MRK,  String.valueOf(Constant.VARCHAR2_TYPE)}};
						String [][] sqlParameters = sqlParameters2;
						ConnectDB checkmainflg2 = new ConnectDB(l_conn,sqlString2,Constant.executePrepQuery,sqlParameters2);
						switch (checkmainflg2.GetReturnCode()) {
									case Constant.ConnectDB_SelectNone:
											 ReturnResult = false;
											 break;
									case Constant.ConnectDB_SelectMulti:
											 ReturnResult = false;
											 break;
									case Constant.ConnectDB_SelectOne:
											 ReturnResult = true;         // only one record
											 break;
									default:
											 l_pm.freeConnection (l_dbname,l_conn);
											 ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
						}
				}

				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


/////////////////////////////////////////////////////////////////////////////////////
// Use Case 29 :Accept same Customer account with different c_clnt_cde or c_cmpnyInfo
/////////////////////////////////////////////////////////////////////////////////////

	public boolean acceptClntMapInfo(String in_opr_cde, String in_clnt_agt_flg, String in_user_id, String in_clnt_cde, String in_main_flg)
				throws com.mcip.orb.CoException{

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((in_user_id==null) || (in_user_id.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDUSERID!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDUSERID);    // Modify Exception Code
				}

				if ((in_clnt_cde==null) || (in_clnt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDCLNTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDCLNTCDE);    // Modify Exception Code
				}
/*
				if ((in_main_flg==null) || (in_main_flg.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDMAINFLG!");
						ErrorHandling(ExceptionCode.OPR_INVALIDMAINFLG);    // Modify Exception Code
				}
*/
				if ((in_clnt_agt_flg==null) || (in_clnt_agt_flg.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDOCAGFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDOCAGFLG);    // Modify Exception Code
				}

				boolean typ_flg = true;
/*
				if ((in_main_flg.equals(Constant.MAIN_MRK)) ||
						(in_main_flg.equals(Constant.NRML_MRK))){
					if (in_main_flg.equals(Constant.MAIN_MRK)) {
//Check unique main flag or not in t_clnt_map for user_id
						if (!checkMainFlg(in_user_id,in_clnt_cde,"0")) {
								new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_DUPLICATEMAINFLG!");
								ErrorHandling(ExceptionCode.OPR_DUPLICATEMAINFLG);       // Modify Exception Code
						}
					}
					typ_flg = true;
				}else{
					typ_flg = false;
				}
				if (!typ_flg) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDMAINFLG!");
						ErrorHandling(ExceptionCode.OPR_INVALIDMAINFLG);         //  Modify Exceoption
				}
*/
				if ((in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)) ||
						(in_clnt_agt_flg.equals(Constant.NORMAL_CUST_MRK)) ||
						(in_clnt_agt_flg.equals(Constant.OPNCVR_CUST_MRK))){
					typ_flg = true;
				}else{
					typ_flg = false;
				}
				if (!typ_flg) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_INVALIDOCAGFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDOCAGFLG);         //  Modify Exceoption
				}

//Check duplicate or not in t_clnt_map
				if (!checkUniqueMap(in_user_id,in_clnt_cde,in_clnt_agt_flg)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_DUPLICATEREC!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_DUPLICATEREC);       // Modify Exception Code
				}

				if (in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)){
//Check cmpny_agt_cde valid or not
					if (!checkAgent(in_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_AGNTNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_AGNTNOTEXIST);       // Modify Exception Code
					}
				}
/*
				if (in_clnt_agt_flg.equals(Constant.OPNCVR_CUST_MRK)){
//Check Open Cover clnt_cde valid or not
					if (!checkOcust(in_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_OPCVNOTEXIST!");
							ErrorHandling(ExceptionCode.OPR_OPCVNOTEXIST);       // Modify Exception Code
					}
				}
*/
				if ((in_clnt_agt_flg.equals(Constant.NORMAL_CUST_MRK)) ||
						(in_clnt_agt_flg.equals(Constant.OPNCVR_CUST_MRK))){
//Check clnt_cde valid or not
					if (!checkNormalcust(in_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_CLNTNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_CLNTNOTEXIST);       // Modify Exception Code
					}
				}

				boolean ReturnResult =false;
//Insert into t_clnt_map
				String sqlString = new String("");
				if (in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)){
					sqlString = Sqlstmt.INSERT_CLNTMAP_AGNT;             //SQL
				}else{
					sqlString = Sqlstmt.INSERT_CLNTMAP_CLNT;             //SQL
				}
				String [][] sqlParameters =
							 {{"c_user_id",    in_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_clnt_cde",   in_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_undr_cde",   in_opr_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_main_flg",   in_main_flg,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertClntMap_clnt = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (InsertClntMap_clnt.GetReturnCode()) {
						case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "acceptClntMapInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


//////////////////////////////////////////////////////////////////////////////////////
// Use Case 30 :Update same Customer account with different c_clnt_cde or c_cmpnyInfo
//////////////////////////////////////////////////////////////////////////////////////
	public boolean updateClntMapInfo(String in_opr_cde, String in_clnt_agt_flg,
																		String new_user_id, String new_clnt_cde, String in_main_flg,
																		String old_user_id, String old_clnt_cde)
				throws com.mcip.orb.CoException{

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((new_user_id==null) || (new_user_id.length()==0) || (old_user_id==null) || (old_user_id.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDUSERID!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDUSERID);    // Modify Exception Code
				}

				if ((new_clnt_cde==null) || (new_clnt_cde.length()==0) || (old_clnt_cde==null) || (old_clnt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDCLNTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDCLNTCDE);    // Modify Exception Code
				}

				if ((in_main_flg==null) || (in_main_flg.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDMAINFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDMAINFLG);    // Modify Exception Code
				}

				if ((in_clnt_agt_flg==null) || (in_clnt_agt_flg.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDOCAGFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDOCAGFLG);    // Modify Exception Code
				}

				boolean typ_flg = true;
				if ((in_main_flg.equals(Constant.MAIN_MRK)) ||
						(in_main_flg.equals(Constant.NRML_MRK))){
					if (in_main_flg.equals(Constant.MAIN_MRK)) {
//Check unique main flag or not in t_clnt_map for user_id
						if (!checkMainFlg(old_user_id,old_clnt_cde,"1")) {
								new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptClntMapInfo() --- OPR_DUPLICATEMAINFLG!");
								l_pm.freeConnection (l_dbname,l_conn);
								ErrorHandling(ExceptionCode.OPR_DUPLICATEMAINFLG);       // Modify Exception Code
						}
					}
					typ_flg = true;
				}else{
					typ_flg = false;
				}
				if (!typ_flg) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDMAINFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDMAINFLG);         //  Modify Exceoption
				}

				if ((in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)) ||
						(in_clnt_agt_flg.equals(Constant.NORMAL_CUST_MRK)) ||
						(in_clnt_agt_flg.equals(Constant.OPNCVR_CUST_MRK))){
					typ_flg = true;
				}else{
					typ_flg = false;
				}

				if (!typ_flg) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_INVALIDOCAGFLG!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDOCAGFLG);         //  Modify Exceoption
				}

//Check duplicate or not in t_clnt_map
				if ((new_user_id.equals(old_user_id)) ||
						(new_clnt_cde.equals(old_clnt_cde))){
					typ_flg = true;
				}else{
					typ_flg = false;
				}

				if (!typ_flg) {
					if (!checkUniqueMap(new_user_id,new_clnt_cde,in_clnt_agt_flg)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_DUPLICATEREC!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_DUPLICATEREC);       // Modify Exception Code
					}
				}

				if (in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)){
//Check cmpny_agt_cde valid or not
					if (!checkAgent(new_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_AGNTNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_AGNTNOTEXIST);       // Modify Exception Code
					}
				}

				if (in_clnt_agt_flg.equals(Constant.OPNCVR_CUST_MRK)){
//Check Open Cover clnt_cde valid or not
					if (!checkOcust(new_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_OPCVNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_OPCVNOTEXIST);       // Modify Exception Code
					}
				}

				if (in_clnt_agt_flg.equals(Constant.NORMAL_CUST_MRK)){
//Check clnt_cde valid or not
					if (!checkNormalcust(new_clnt_cde)) {
							new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateClntMapInfo() --- OPR_CLNTNOTEXIST!");
							l_pm.freeConnection (l_dbname,l_conn);
							ErrorHandling(ExceptionCode.OPR_CLNTNOTEXIST);       // Modify Exception Code
					}
				}

				boolean ReturnResult =false;

//Update t_clnt_map
				String sqlString = new String("");
				if (in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)){
					sqlString = Sqlstmt.UPDATE_CLNTMAP_AGNT;             //SQL
				}else{
					sqlString = Sqlstmt.UPDATE_CLNTMAP_CLNT;             //SQL
				}
				String [][] sqlParameters =
							 {{"c_user_id",    new_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_clnt_cde",   new_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_undr_cde",   in_opr_cde,       String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_main_flg",   in_main_flg,      String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_user_id",    old_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_clnt_cde",   old_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateClntMap_clnt = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateClntMap_clnt.GetReturnCode()) {
						case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "updatePagesInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


/////////////////////////////////////////////////////////////////////////////////////
// Use Case 31 :Detele same Customer account with different c_clnt_cde or c_cmpnyInfo
/////////////////////////////////////////////////////////////////////////////////////
	public boolean deleteClntMapInfo(String in_opr_cde, String in_user_id, String in_clnt_cde, String in_clnt_agt_flg)
				throws com.mcip.orb.CoException{

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "deleteClntMapInfo() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((in_user_id==null) || (in_user_id.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "deleteClntMapInfo() --- OPR_INVALIDUSERID!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDUSERID);    // Modify Exception Code
				}

				if ((in_clnt_cde==null) || (in_clnt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "deleteClntMapInfo() --- OPR_INVALIDCLNTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDCLNTCDE);    // Modify Exception Code
				}

				if ((in_clnt_agt_flg==null) || (in_clnt_agt_flg.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "deleteClntMapInfo() --- OPR_INVALIDDPTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDDPTCDE);    // Modify Exception Code
				}

				boolean ReturnResult =false;

//Delete from t_clnt_map
				String sqlString = new String("");
				if (in_clnt_agt_flg.equals(Constant.AGENCY_CUST_MRK)){
					sqlString = Sqlstmt.DISABLE_CLNTMAP_AGNT;             //SQL
				}else{
					sqlString = Sqlstmt.DISABLE_CLNTMAP_CLNT;             //SQL
				}
				String [][] sqlParameters =
							 {{"c_user_id",    in_user_id,       String.valueOf(Constant.VARCHAR2_TYPE)},
								{"c_clnt_cde",   in_clnt_cde,      String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB disableClntMap_clnt = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (disableClntMap_clnt.GetReturnCode()) {
						case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "deleteClntMapInfo() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


/////////////////////////////////////////////////////////////////////////////////////////
// Use Case 32 :Query same Customer account List with different c_clnt_cde or c_cmpnyInfo
/////////////////////////////////////////////////////////////////////////////////////////

	public java.lang.String[][] queryClntMapList(String in_opr_cde, String in_user_id)
				throws com.mcip.orb.CoException {

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryClntMapList() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

				if ((in_user_id==null) || (in_user_id.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "queryClntMapList() --- OPR_INVALIDUSERID!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDUSERID);    // Modify Exception Code
				}

				String SqlStatement=Sqlstmt.SELECT_CLNTMAP;
				String [][] sqlParameters= {{"c_user_id",    in_user_id,    String.valueOf(Constant.VARCHAR2_TYPE)}};
				ConnectDB QueryClntMapList= new ConnectDB (l_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
				switch (QueryClntMapList.GetReturnCode()) {
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

				new ConnectDB(l_conn).WriteDBLog(l_conn, in_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "queryClntMapList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return QueryClntMapList.GetReturnArray ();
		}


////////////////////////////////////////////////////////////////
// Use Case 33 : Execute System Administrator Authority Action
////////////////////////////////////////////////////////////////

	public boolean executeSysadmAuth(String act_typ, String auth_opr_cde, String in_opr_cde, String in_dpt_cde)
				throws com.mcip.orb.CoException{

//System.out.println("Begin executeSysadmAuth function call ! ");

				boolean ReturnResult = false;
				boolean input_act_typ = true;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((auth_opr_cde==null) || (auth_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDAUTH!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDAUTH);     // Modify Exception CODE
				}

				if ((act_typ==null) || (act_typ.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDACTTYP!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDACTTYP);     // Modify Exception CODE
				}

				if ((in_opr_cde==null) || (in_opr_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);     // Modify Exception CODE
				}

				if ((act_typ.equals(Constant.ACCEPT_OPRAUTH_MRK)) ||
						(act_typ.equals(Constant.UPDATE_OPRAUTH_MRK)) ||

						(act_typ.equals(Constant.DELETE_OPRAUTH_MRK))){

						input_act_typ = true;

				}else{

						input_act_typ = false;

				}


				if (!input_act_typ) {

						new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "executeOptrAuth() --- OPR_INVALIDACTTYP!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDACTTYP);     // Modify Exception CODE
				}

//System.out.println("after checking in executeOptrAuth function call. ");
				String [][] dpt_res = queryDptCodeList(in_dpt_cde);
				String [][] auth_res = querySysFuncList("");
				int dpt_len = dpt_res.length-1;
				int auth_len = auth_res.length-1;

//System.out.println("after get Department & Sysfunc code in executeOptrAuth function call. ");

//detele from t_opr_dpt
				String sqlString1 =Sqlstmt.DELETE_OPRDPT;           //SQL
				String [][] sqlParameters1 =
							{{"c_opr_cde",      in_opr_cde,     String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteOprDpt = new ConnectDB (l_conn,sqlString1,Constant.executePrepUpdateNoCommit,sqlParameters1);
				switch (DeleteOprDpt.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//System.out.println("after delete t_opr_dpt in executeOptrAuth function call.");

//detele from t_opr_auth
				String sqlString2 =Sqlstmt.DELETE_OPRAUTH;           //SQL
				String [][] sqlParameters2 =
							{{"c_opr_cde",in_opr_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};

				if (act_typ.equals(Constant.DELETE_OPRAUTH_MRK)) {
					ConnectDB DeleteOprAuth = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdate,sqlParameters2);

					switch (DeleteOprAuth.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}else{

					ConnectDB DeleteOprAuth = new ConnectDB (l_conn,sqlString2,Constant.executePrepUpdateNoCommit,sqlParameters2);
					switch (DeleteOprAuth.GetReturnCode()) {
							 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
										break;
							 default:
										l_pm.freeConnection (l_dbname,l_conn);
										ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					}
				}
//System.out.println("after delete t_opr_auth in executeOptrAuth function call.");

				if ((act_typ.equals(Constant.ACCEPT_OPRAUTH_MRK)) ||
						(act_typ.equals(Constant.UPDATE_OPRAUTH_MRK))){

// Insert into t_opr_dpt
/*
				String statement_dpt[]=new String[4];
				String parm_dpt [][][]=new String[4][3][2];
*/
				String statement_dpt[]=new String[dpt_len];
				String parm_dpt [][][]=new String[dpt_len][3][3];
				for (int i = 0; i < dpt_len ; i++){
				if (dpt_res[i+1][0].length() == 7) {
						dpt_res[i+1][2] = dpt_res[i+1][0].substring(0,5);
				}
				if (dpt_res[i+1][0].length() == 5) {
						dpt_res[i+1][2] = dpt_res[i+1][0].substring(0,3);
				}
				if (dpt_res[i+1][0].length() == 3) {
						dpt_res[i+1][2] = dpt_res[i+1][0].substring(0,1);
				}

				statement_dpt[i]=Sqlstmt.INSERT_OPRDPT;
				parm_dpt[i] = set_parameter_value3("c_opr_cde",in_opr_cde,String.valueOf(Constant.VARCHAR2_TYPE),
																					 "c_dpt_cde",dpt_res[i+1][0],String.valueOf(Constant.VARCHAR2_TYPE),
																					 "c_snr_dpt",dpt_res[i+1][2],String.valueOf(Constant.VARCHAR2_TYPE));
				}

				ConnectDB InsertOprDpt = new ConnectDB (l_conn,statement_dpt,Constant.executeBatchPrepUpdateNoCommit,parm_dpt);
				switch (InsertOprDpt.GetReturnCode()) {

						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//System.out.println("after insert t_opr_dpt in executeOptrAuth function call.");

// Insert into t_opr_auth
/*
				String statement_auth[]=null;
				String parm_auth [][][]=new String[4][3][2];
*/
				String statement_auth[]=new String[auth_len];
				String parm_auth [][][]=new String[auth_len][3][2];
				for (int i = 0; i < auth_len ; i++){
				statement_auth[i]=Sqlstmt.INSERT_OPRAUTH;
				parm_auth[i] = set_parameter_value2("c_opr_cde",    in_opr_cde,         String.valueOf(Constant.VARCHAR2_TYPE),
																						"c_func_cde",   auth_res[i+1][0],   String.valueOf(Constant.VARCHAR2_TYPE));
				}

				ConnectDB InsertOprAuth = new ConnectDB (l_conn,statement_auth,Constant.executeBatchPrepUpdate,parm_auth);
				switch (InsertOprAuth.GetReturnCode()) {

						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

//System.out.println("after insert t_opr_auth in executeOptrAuth function call.");
				}                         // INSERT OR UPDATE ACTION

				ReturnResult = true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, auth_opr_cde, Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "executeOptrAuth() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Common Routine for all case
// Query the department List from t_department
////////////////////////////////////////////////////////
		public String[][] queryDptCodeList(String in_dpt_cde)
				throws com.mcip.orb.CoException {

				String [][] ReturnResult = new String [2][3];
				String SqlStatement=new String("");

				Connection r_conn = r_pm.getConnection(r_dbname);
				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)){

					SqlStatement=Sqlstmt.SELECTDPTCODE1;
					ConnectDB QueryDptInfo1= new ConnectDB (r_conn,SqlStatement,Constant.executeSqlQuery);
					switch (QueryDptInfo1.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					};
					ReturnResult = QueryDptInfo1.GetReturnArray ();

				}else{

					SqlStatement=Sqlstmt.SELECTDPTCODE2;
					String [][] sqlParameters= {{"c_dpt_cde",in_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryDptInfo2= new ConnectDB (r_conn,SqlStatement,Constant.executePrepQuery,sqlParameters);
					switch (QueryDptInfo2.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									r_pm.freeConnection (r_dbname,r_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
					};
					ReturnResult = QueryDptInfo2.GetReturnArray ();
				}

				r_pm.freeConnection (r_dbname,r_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// Use Case 34 :Accept New support employee's email address
////////////////////////////////////////////////////////

	public boolean acceptSuppEmail(String in_emp_cde, String in_emp_nme, String in_dpt_cde, String in_emp_type, String in_emp_email)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_emp_nme==null) || (in_emp_nme.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptSuppEmail() --- OPR_INVALID_EMP_NAME!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_EMP_NAME);    // Modify Exception Code
				}

				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptSuppEmail() --- OPR_INVALIDDPTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDDPTCDE);    // Modify Exception Code
				}

				if ((in_emp_type==null) || (in_emp_type.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptSuppEmail() --- OPR_INVALID_EMP_NAME or OPR_INVALID_EMP_TYPE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_EMP_NAME);    // Modify Exception Code
				}

				if ((in_emp_email==null) || (in_emp_email.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "acceptSuppEmail() --- OPR_INVALID_EMP_MAIL!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_EMP_MAIL);    // Modify Exception Code
				}

//Insert into t_support_email
				String sqlString =Sqlstmt.INSERT_SUPP_MAIL;             //SQL
				String [][] sqlParameters =
							{{"c_emp_cde",  in_emp_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_nme",  in_emp_nme,   String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_dpt_cde",  in_dpt_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_type", in_emp_type,  String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_email",in_emp_email, String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB InsertSuppMail = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);

				switch (InsertSuppMail.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "acceptSuppEmail() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 35 : Update support employee's email address
////////////////////////////////////////////////////////

	public boolean updateSuppEmail(String in_emp_cde, String in_emp_nme, String in_dpt_cde, String in_emp_type, String in_emp_email, String in_supp_no)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_emp_nme==null) || (in_emp_nme.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateSuppEmail() --- OPR_INVALID_EMP_NAME!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_EMP_NAME);    // Modify Exception Code
				}

				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateSuppEmail() --- OPR_INVALIDDPTCDE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDDPTCDE);    // Modify Exception Code
				}

				if ((in_emp_type==null) || (in_emp_type.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateSuppEmail() --- OPR_INVALID_EMP_NAME or OPR_INVALID_EMP_TYPE!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_EMP_NAME);    // Modify Exception Code
				}

				if ((in_emp_email==null) || (in_emp_email.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateSuppEmail() --- OPR_INVALID_EMP_MAIL!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALID_EMP_MAIL);    // Modify Exception Code
				}

				if ((in_supp_no==null) || (in_supp_no.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "updateSuppEmail() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

//Update t_support_email
				String sqlString =Sqlstmt.UPDATE_SUPP_MAIL;             //SQL
				String [][] sqlParameters =
							{{"c_emp_cde",  in_emp_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_nme",  in_emp_nme,   String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_dpt_cde",  in_dpt_cde,   String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_type", in_emp_type,  String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_emp_email",in_emp_email, String.valueOf(Constant.VARCHAR2_TYPE)},
							 {"c_supp_no",  in_supp_no,   String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB UpdateSuppMail = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (UpdateSuppMail.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "updateSuppEmail() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 36 : Delete support employee's email address
////////////////////////////////////////////////////////

	public boolean deleteSuppEmail(String in_supp_no)
				throws com.mcip.orb.CoException{

				boolean ReturnResult =false;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_supp_no==null) || (in_supp_no.length()==0)) {
						new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.FAIL_EVENT, "deleteSuppEmail() --- OPR_INVALIDPARM!");
						l_pm.freeConnection (l_dbname,l_conn);
						ErrorHandling(ExceptionCode.OPR_INVALIDPARM);    // Modify Exception Code
				}

//Delete from t_support_email
				String sqlString = Sqlstmt.DELETE_SUPP_MAIL;             //SQL
				String [][] sqlParameters =
							{{"c_supp_no",       in_supp_no,       String.valueOf(Constant.VARCHAR2_TYPE)}};

				ConnectDB DeleteSuppMail = new ConnectDB (l_conn,sqlString,Constant.executePrepUpdate,sqlParameters);
				switch (DeleteSuppMail.GetReturnCode()) {
						 case Constant.ConnectDB_Success:case Constant.ConnectDB_Warning:
									break;
						 default:
									l_pm.freeConnection (l_dbname,l_conn);
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR);
				}

				ReturnResult =true;
				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "deleteSuppEmail() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
			}


////////////////////////////////////////////////////////
// Use Case 37 : Query support employee's email address List
////////////////////////////////////////////////////////

	public java.lang.String[][] querySuppEmailList(String in_emp_nme, java.lang.String[] owned_dpt, String in_emp_type)
				throws com.mcip.orb.CoException {

				boolean input_emp_nme = true;
				boolean input_emp_type = true;

				Connection l_conn = l_pm.getConnection(l_dbname);
				if ((in_emp_nme==null) || (in_emp_nme.length()==0))
						input_emp_nme=false;

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

				if (input_emp_nme) {
						String tmp_sqlString = " AND c_emp_nme = '"+in_emp_nme+"'";
						arguString = arguString + tmp_sqlString;
				}

				if (owned_dpt[0].length() > 0){
						int dptarray_len = owned_dpt.length;
						String dpt_sqlString = " AND c_dpt_cde IN (";

						for (int i = 0; i < dptarray_len ; i++){
							 if ((i-dptarray_len+1)==0)
									dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "'";
							 else
									dpt_sqlString = dpt_sqlString + "'" + owned_dpt[i] + "', ";
						}
						arguString = arguString + dpt_sqlString + " )";    //SQL
				}

				sqlString = Sqlstmt.SELECT_SUPP_MAIL + arguString + "ORDER BY t_crt_tm DESC";     //SQL
//add for debug
//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QuerySuppMailList= new ConnectDB (l_conn,sqlString,Constant.executeSqlQuery);
				switch (QuerySuppMailList.GetReturnCode()) {
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

				String [][] SuppMail_Res = QuerySuppMailList.GetReturnArray();
				int SuppMail_len = SuppMail_Res.length;
				String [][] ReturnResult = new String [SuppMail_len][9];
				ReturnResult[0][0] = SuppMail_Res[0][0];
				ReturnResult[0][1] = SuppMail_Res[0][1];
				ReturnResult[0][2] = SuppMail_Res[0][2];
				ReturnResult[0][3] = SuppMail_Res[0][3];
				ReturnResult[0][4] = SuppMail_Res[0][4];
				ReturnResult[0][5] = SuppMail_Res[0][5];
				ReturnResult[0][6] = SuppMail_Res[0][6];
				ReturnResult[0][7] = "C_DPT_CNM";
				ReturnResult[0][8] = "C_DPT_ENM";

//System.out.println("The length of OPTR_DPT: " + dpt_len);
				for (int i = 1; i < SuppMail_len ; i++){
					ReturnResult[i][0] = SuppMail_Res[i][0];
					ReturnResult[i][1] = SuppMail_Res[i][1];
					ReturnResult[i][2] = SuppMail_Res[i][2];
					ReturnResult[i][3] = SuppMail_Res[i][3];
					ReturnResult[i][4] = SuppMail_Res[i][4];
					ReturnResult[i][5] = SuppMail_Res[i][5];
					ReturnResult[i][6] = SuppMail_Res[i][6];
					String [][] tmp_Res1 = getDptCEnm(SuppMail_Res[i][4],Constant.DPT_ABRNAME);
					ReturnResult[i][7] = tmp_Res1[1][0];
					ReturnResult[i][8] = tmp_Res1[1][1];
				}

				new ConnectDB(l_conn).WriteDBLog(l_conn, "system", Constant.LOG_OPRAUTHRTY, Constant.SUCCESS_EVENT, "querySuppEmailList() --- SUCCESSFULLY!");
				l_pm.freeConnection (l_dbname,l_conn);
				return ReturnResult;
		}


////////////////////////////////////////////////////////
// internal function
////////////////////////////////////////////////////////

		String[][] null_rec_filter(String[][] in_array, int column_loc){

				int tbr1=in_array.length;
				String[] tablecolumn = in_array[0];
				int tbcl=tablecolumn.length;
				int null_row = 0;
				String[][] res_array = null;
//System.out.println("The input array have: "+tbr1+" Rows!");

				for (int j=0;j <tbr1;j++){
						if ((in_array[j][column_loc] == null) || (in_array[j][column_loc].length() == 0))
							null_row++;
				}

				if (null_row == 0){
						return in_array;
				}

				if (null_row == tbr1){
						res_array = new String[1][1];
						res_array[0][0] = "";
						return res_array;
				}

//System.out.println("The input array (not null row) have: "+(tbr1-null_row)+" Rows!");
				res_array = new String[tbr1-null_row][tbcl];
				int k = 0;
				for (int j=0;j <tbr1;j++){
						if ((in_array[j][column_loc] == null) || (in_array[j][column_loc].length() == 0)){
						}else{
							for (int i=0;i < tbcl;i++){
								res_array[k][i]=in_array[j][i];
							}
							k++;
						}
				}

				return res_array;
		}


	}






