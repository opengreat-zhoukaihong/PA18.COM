////////////////////////////////////////////////////////
// Maintained by:  ZhanYB,YiJF
// Function:   Provide sqlstatement define in db processing
// Update Date:2000/8/08
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb: 09/15 Add connection log processing
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
// Change Log
//     YiJF: 10/11 Modify getOrgTypeList(); getPremiumScaleList();
//                        getScaleList(); getTitleList(); getTradeTypeList();
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
// Change Log
//     YiJF: 10/12 Add Cargo type code convertion processing from external to Pa18
////////////////////////////////////////////////////////
// Update by cidy on 10/01/2001 for db connection conflict
//     YiJF: 04/02 Add function for get reporting telephone number of related department
/////////////////////////////////////////////////////////
import java.sql.*;
import java.util.*;
import utility.*;
import constant.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.cdt.orb.*;
import com.mcip.cus.orb.*;


public class staticInfoManagerImpl extends _staticInfoManagerImplBase {
		private static PoolManager pm;
		//private static String dbname=Constant.DBNAME;
		private static String dbname=Constant.BACKEND_DBNAME;
		//changed by cidy for backend connection pool
		//private static Connection conn;
		private CoExceptionHandler exHandler;


		// Constructor
		public staticInfoManagerImpl(String name,PoolManager poolManager) {
				super(name);
				pm=poolManager;
				//conn = pm.getConnection(dbname);
				//Add connect in debug log
				//CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,
				//"StaticInfoManagerImpl get db connection");
				exHandler = new CoExceptionHandler();
				//System.out.println("constructor ok!");
		}

		// Errorhandling
		private void ErrorHandling(String ExceptionCode,Connection conn)
	throws com.mcip.orb.CoException   {
				pm.freeConnection (dbname,conn);
				//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,
						"StaticInfoManagerImpl free db connection");
				this.exHandler.raiseCoException(ExceptionCode,"","",Constant.WARNING);
		}

		// Errorhandling
		private void ErrorHandling(String ExceptionCode,String ExceptionDesc,Connection conn)
	throws com.mcip.orb.CoException   {
				pm.freeConnection (dbname,conn);
				//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,
						"StaticInfoManagerImpl free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"",Constant.WARNING);
		}

		// Errorhandling
		private void ErrorHandling(String ExceptionCode,String ExceptionDesc,
						 String ExceptionField,Connection conn)
	throws com.mcip.orb.CoException   {
				pm.freeConnection (dbname,conn);
				//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,
						"StaticInfoManagerImpl free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,ExceptionField,
					Constant.WARNING);
		}

		// Errorhandling
		private void ErrorHandling(String ExceptionCode,String ExceptionDesc,
						 String ExceptionField,String ExceptionSeverity,Connection conn)
	throws com.mcip.orb.CoException   {
				pm.freeConnection (dbname,conn);
				//Add connect in debug log
				CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,
						"StaticInfoManagerImpl free db connection");
				this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,
					ExceptionField,ExceptionSeverity);
		}


		//Interface to db
		public String[][] getStaticInfo(String SqlStatement,String[][] SqlParameters)
	throws com.mcip.orb.CoException {
				Connection conn = pm.getConnection(dbname);
				String [][] NullString={{"",""}};

				String sqlString=SqlStatement+DataUtility.SqlContact(SqlParameters);

	//Add for debug
	//        System.out.println("0:"+SqlParameters[0][0]);
	//        System.out.println("1:"+SqlParameters[0][1]);
	//        System.out.println(sqlString);

				ConnectDB QueryStaticInfo= new ConnectDB (conn,sqlString,Constant.executeSqlQuery);
				switch (QueryStaticInfo.GetReturnCode()) {
					case Constant.ConnectDB_SelectNone:{
								ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
							}
					case Constant.ConnectDB_SelectMulti:case Constant.ConnectDB_SelectOne:{
							break;
							}
					default:{
							ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,sqlString+"\nReturn code:"
										+QueryStaticInfo.GetReturnCode(),"",Constant.WARNING,conn);
					}
				};

				pm.freeConnection (dbname,conn);
				return QueryStaticInfo.GetReturnArray ();
		}

		/////////////////////////////////////////////////////////////////////
		//Get static info from db                                          //
		/////////////////////////////////////////////////////////////////////
		public String[][] getNationalList(String in_cnation_cde)
	throws com.mcip.orb.CoException {
	//Connection conn = pm.getConnection(dbname);
				String SqlStatement=Sqlstmt.SELECTNTNINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cnation_cde.length ()>0){
			SqlParameters[0][0]="c_nation_cde";
			SqlParameters[0][1]=in_cnation_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getAreaList(String in_carea_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTAREAINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_carea_cde.length ()>0){
		SqlParameters[0][0]="c_ara_cde";
		SqlParameters[0][1]=in_carea_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
	Connection conn = pm.getConnection(dbname);
				String [][] ReturnResult = new String [2][6];
				String SqlStatement=new String("");

				if ((in_carea_cde==null) || (in_carea_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTAREAINFO1;
			ConnectDB QueryAreaInfo1= new ConnectDB (conn,SqlStatement,
								 Constant.executeSqlQuery);
			switch (QueryAreaInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
						ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
						break;
			default:
						ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryAreaInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTAREAINFO2;
			String [][] sqlParameters= {{"c_ara_cde",in_carea_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryAreaInfo2= new ConnectDB (conn,SqlStatement,
								 Constant.executePrepQuery,sqlParameters);

			switch (QueryAreaInfo2.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
					};
					ReturnResult = QueryAreaInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getProvinceList(String in_cprovince_cde)
	throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTPRVNINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_cprovince_cde.length ()>0){
		SqlParameters[0][0]="c_province";
		SqlParameters[0][1]=in_cprovince_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_cprovince_cde==null) || (in_cprovince_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTPRVNINFO1;
			ConnectDB QueryProvInfo1= new ConnectDB (conn,SqlStatement,
								 Constant.executeSqlQuery);
			switch (QueryProvInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryProvInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTPRVNINFO2;
			String [][] sqlParameters= {{"c_province",in_cprovince_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryProvInfo2= new ConnectDB (conn,SqlStatement,
								 Constant.executePrepQuery,sqlParameters);

			switch (QueryProvInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryProvInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getCityList(String in_ccity_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTCITYINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_cprvn_cde.length ()>0){
		SqlParameters[0][0]="c_province";
		SqlParameters[0][1]=in_cprvn_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_ccity_cde==null) || (in_ccity_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTCITYINFO1;
			ConnectDB QueryCityInfo1 = new ConnectDB (conn,SqlStatement,
									Constant.executeSqlQuery);

			switch (QueryCityInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCityInfo1.GetReturnArray ();
				}else{

			SqlStatement=Sqlstmt.SELECTCITYINFO2;
			String [][] sqlParameters= {{"c_city",in_ccity_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCityInfo2 = new ConnectDB (conn,SqlStatement,
									Constant.executePrepQuery,sqlParameters);

			switch (QueryCityInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCityInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getEduList(String in_cedu_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTEDUINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cedu_cde.length ()>0){
			SqlParameters[0][0]="c_education_cde";
			SqlParameters[0][1]=in_cedu_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getTitleList(String in_cttl_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTTTLINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_cttl_cde.length ()>0){
		SqlParameters[0][0]="c_title_cde";
		SqlParameters[0][1]=in_cttl_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][3];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_cttl_cde==null) || (in_cttl_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTTTLINFO1;
			ConnectDB QueryTtlInfo1= new ConnectDB (conn,SqlStatement,
								Constant.executeSqlQuery);
			switch (QueryTtlInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryTtlInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTTTLINFO2;
			String [][] sqlParameters= {{"c_title_cde",in_cttl_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryTtlInfo2= new ConnectDB (conn,SqlStatement,
								Constant.executePrepQuery,sqlParameters);

			switch (QueryTtlInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryTtlInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getDutyList(String in_cduty_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTPRFSINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cduty_cde.length ()>0){
			SqlParameters[0][0]="c_profession_cde";
			SqlParameters[0][1]=in_cduty_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getTradeTypeList(String in_ctrd_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTTRDINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_ctrd_cde.length ()>0){
		SqlParameters[0][0]="c_trd_cde";
		SqlParameters[0][1]=in_ctrd_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][4];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_ctrd_cde==null) || (in_ctrd_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTTRDINFO1;
			ConnectDB QueryTrdInfo1= new ConnectDB (conn,SqlStatement,
								Constant.executeSqlQuery);
			switch (QueryTrdInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryTrdInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTTRDINFO2;
			String [][] sqlParameters= {{"c_trd_cde",in_ctrd_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryTrdInfo2= new ConnectDB (conn,SqlStatement,
								Constant.executePrepQuery,sqlParameters);

			switch (QueryTrdInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryTrdInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getOrgTypeList(String in_corgz_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTORGZINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_corgz_cde.length ()>0){
		SqlParameters[0][0]="c_orgz_typ_cde";
		SqlParameters[0][1]=in_corgz_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][3];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_corgz_cde==null) || (in_corgz_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTORGZINFO1;
			ConnectDB QueryOrgzInfo1= new ConnectDB (conn,SqlStatement,
								 Constant.executeSqlQuery);
			switch (QueryOrgzInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryOrgzInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTORGZINFO2;
			String [][] sqlParameters= {{"c_orgz_typ_cde",in_corgz_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryOrgzInfo2= new ConnectDB (conn,SqlStatement,
								 Constant.executePrepQuery,sqlParameters);

			switch (QueryOrgzInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryOrgzInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getOwnershipList(String in_cownr_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTOWNRINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cownr_cde.length ()>0){
			SqlParameters[0][0]="c_ownership_cde";
			SqlParameters[0][1]=in_cownr_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getScaleList(String in_cscl_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTSCALINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_cscl_cde.length ()>0){
		SqlParameters[0][0]="c_scale_cde";
		SqlParameters[0][1]=in_cscl_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][3];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_cscl_cde==null) || (in_cscl_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTSCALINFO1;
			ConnectDB QueryScleInfo1= new ConnectDB (conn,SqlStatement,
								 Constant.executeSqlQuery);
			switch (QueryScleInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryScleInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTSCALINFO2;
			String [][] sqlParameters= {{"c_scale_cde",in_cscl_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryScleInfo2= new ConnectDB (conn,SqlStatement,
								 Constant.executePrepQuery,sqlParameters);

			switch (QueryScleInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryScleInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getPremiumScaleList(String in_cclsc_cde)
	throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTCLSCINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_cclsc_cde.length ()>0){
		SqlParameters[0][0]="c_clnt_scle_cde";
		SqlParameters[0][1]=in_cclsc_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_cclsc_cde==null) || (in_cclsc_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTCLSCINFO1;
			ConnectDB QueryClscInfo1= new ConnectDB (conn,SqlStatement,
								 Constant.executeSqlQuery);
			switch (QueryClscInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryClscInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTCLSCINFO2;
			String [][] sqlParameters= {{"c_clnt_scle_cde",in_cclsc_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryClscInfo2= new ConnectDB (conn,SqlStatement,
								 Constant.executePrepQuery,sqlParameters);

			switch (QueryClscInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryClscInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getCurrencyList(String in_ccurr_cde) throws com.mcip.orb.CoException {
	/*String SqlStatement=Sqlstmt.SELECTCURRINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_ccurr_cde.length ()>0){
		SqlParameters[0][0]="c_cur_no";
		SqlParameters[0][1]=in_ccurr_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][8];
				String SqlStatement=new String("");
				String in_ccurr_cde_2 = Constant.USD_EXCHANGE_RATE;
	Connection conn = pm.getConnection(dbname);
				if ((in_ccurr_cde==null) || (in_ccurr_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTCURRINFO1;
			String [][] sqlParameters= {{"c_cur_no_2",in_ccurr_cde_2,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCurrInfo1 = new ConnectDB (conn,SqlStatement,
									Constant.executePrepQuery,sqlParameters);

			switch (QueryCurrInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCurrInfo1.GetReturnArray ();
				}else{

			SqlStatement=Sqlstmt.SELECTCURRINFO2;
			String [][] sqlParameters= {{"c_cur_no",in_ccurr_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)},
					{"c_cur_no_2",in_ccurr_cde_2,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCurrInfo2 = new ConnectDB (conn,SqlStatement,
									Constant.executePrepQuery,sqlParameters);

			switch (QueryCurrInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCurrInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getCargoClsList(String in_ccrgc_cde, String in_insrnc_cde)
	throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTCRGCINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_ccrgc_cde.length ()>0){
		SqlParameters[0][0]="c_crgo_cde";
		SqlParameters[0][1]=in_ccrgc_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
	Connection conn = pm.getConnection(dbname);
				if (in_insrnc_cde==null)
						ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM,conn);

				if (in_insrnc_cde.length()==0)
						ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM,conn);

				if (in_insrnc_cde.equals(Constant.EXPORT_INSRNC)){
						in_insrnc_cde = Constant.EXPORT_INSRNC;
				}else{
						if (in_insrnc_cde.equals(Constant.IMPORT_INSRNC)){
		in_insrnc_cde = Constant.IMPORT_INSRNC;
						}else{
		in_insrnc_cde = Constant.HOME_INSRNC;
						}
				}

				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");

				if ((in_ccrgc_cde==null) || (in_ccrgc_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTCRGCINFO1;
			String [][] sqlParameters= {{"c_crgo_typ",in_insrnc_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCrgoClsInfo1 =
		new ConnectDB (conn,SqlStatement,
						 Constant.executePrepQuery,sqlParameters);

			switch (QueryCrgoClsInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCrgoClsInfo1.GetReturnArray ();
				}else{

			SqlStatement=Sqlstmt.SELECTCRGCINFO2;
			String [][] sqlParameters= {{"c_crgo_cde",in_ccrgc_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)},
					{"c_crgo_typ",in_insrnc_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCrgoClsInfo2 =
		new ConnectDB (conn,SqlStatement,
						 Constant.executePrepQuery,sqlParameters);

			switch (QueryCrgoClsInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCrgoClsInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getCargoTypeList(String in_ccrgt_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTCRGTINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_ccrgt_cde.length ()>0){
		SqlParameters[0][0]="c_crgo_cde";
		SqlParameters[0][1]=in_ccrgt_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_ccrgt_cde==null) || (in_ccrgt_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTCRGTINFO1;
			ConnectDB QueryCrgoTypInfo1 = new ConnectDB (conn,SqlStatement,
							 Constant.executeSqlQuery);

			switch (QueryCrgoTypInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCrgoTypInfo1.GetReturnArray ();
				}else{

			SqlStatement=Sqlstmt.SELECTCRGTINFO2;
			String [][] sqlParameters= {{"c_crgo_cde",in_ccrgt_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCrgoTypInfo2 =
		new ConnectDB (conn,SqlStatement,
						 Constant.executePrepQuery,sqlParameters);

			switch (QueryCrgoTypInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryCrgoTypInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getPackList(String in_cpack_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTPACKINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cpack_cde.length ()>0){
					 SqlParameters[0][0]="c_pack_cde";
					 SqlParameters[0][1]=in_cpack_cde;
				}
				else{
					 SqlParameters[0][0]="1";
					 SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getExchangeRateList(String in_ccurno_1, String in_ccurno_2)
					throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTXCRTINFO;
		String SqlParameters[][]=new String[2][2];
		if (in_ccurno_1.length ()>0){
		SqlParameters[0][0]="c_cur_no_1";
		SqlParameters[0][1]=in_ccurno_1;
		}
		if (in_ccurno_2.length ()>0){
		SqlParameters[1][0]="c_cur_no_2";
		SqlParameters[1][1]=in_ccurno_2;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
				boolean input_cur1 = true;
				boolean input_cur2 = true;
	Connection conn = pm.getConnection(dbname);
				if ((in_ccurno_1==null) || (in_ccurno_1.length()==0))
						input_cur1 = false;

				if ((in_ccurno_2==null) || (in_ccurno_2.length()==0))
						input_cur2 = false;

				String sqlString = Sqlstmt.SELECTXCRTINFO;

				if (input_cur1 || input_cur2) {
			if (input_cur1) {
		String tmp_sqlString = " AND c_cur_no_1 = '"+in_ccurno_1+"'";
		sqlString = sqlString + tmp_sqlString;
			}
			if (input_cur2) {
		String tmp_sqlString = " AND c_cur_no_2 = '"+in_ccurno_2+"'";
		sqlString = sqlString + tmp_sqlString;
			}
				}

				sqlString = sqlString + " ORDER BY c_cur_no_1, c_cur_no_2";
	//add for debug
	//System.out.println("after prepare SQL statement : "+ sqlString);

				ConnectDB QueryExchangeRate= new ConnectDB (conn,sqlString,Constant.executeSqlQuery);
				switch (QueryExchangeRate.GetReturnCode()) {
	case Constant.ConnectDB_SelectNone:
			ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
	case Constant.ConnectDB_SelectMulti:
	case Constant.ConnectDB_SelectOne:
			break;
	default:
			ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,sqlString,conn);
				};

				pm.freeConnection (dbname,conn);
				return QueryExchangeRate.GetReturnArray ();
		}

		public String[][] getPayModeList(String in_cpaym_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTPAYMINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cpaym_cde.length ()>0){
			SqlParameters[0][0]="c_paymode_cde";
			SqlParameters[0][1]=in_cpaym_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getInsuranceClassList(String in_cicls_cde)
	throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTICLSINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cicls_cde.length ()>0){
			SqlParameters[0][0]="c_insrnc_cls";
			SqlParameters[0][1]=in_cicls_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getInsuranceDefineList(String in_cidfn_cde)
	throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTIDFNINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cidfn_cde.length ()>0){
			SqlParameters[0][0]="c_insrnc_cde";
			SqlParameters[0][1]=in_cidfn_cde;
				}
				else{
			//SqlParameters[0][0]="'1'";
			//SqlParameters[0][1]="1";
			SqlParameters = null;
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getInsuranceTypeList(String in_cityp_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTITYPINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cityp_cde.length ()>0){
			SqlParameters[0][0]="c_rdr_cde";
			SqlParameters[0][1]=in_cityp_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getClauseList(String in_insrnc_cde, String in_claus_cde,
																		String in_type_cde) throws com.mcip.orb.CoException {
	/*
		String SqlStatement=Sqlstmt.SELECTCLUSINFO;
		String SqlParameters[][]=new String[1][2];
		if (in_insrnc_cde.length ()>0){
		SqlParameters[0][0]="c_insrnc_cde";
		SqlParameters[0][1]=in_insrnc_cde;
		}
		else{
		SqlParameters[0][0]="1";
		SqlParameters[0][1]="1";
		}
		return  getStaticInfo(SqlStatement,SqlParameters);
	*/
	Connection conn = pm.getConnection(dbname);
				if ((in_insrnc_cde==null) || (in_type_cde==null))
						ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM,conn);

				if ((in_insrnc_cde.length()==0) || (in_type_cde.length()==0))
						ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM,conn);

				if (in_type_cde.equals(Constant.LIST_INSRNC_CLAUSE)){
						in_type_cde = Constant.LIST_INSRNC_CLAUSE;
				}else{
						if (in_type_cde.equals(Constant.MAIN_INSRNC_CLAUSE)){
		in_type_cde = Constant.MAIN_INSRNC_CLAUSE;
						}else{
		in_type_cde = Constant.LIST_INSRNC_CLAUSE;
						}
				}

				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");

				if (in_type_cde.equals(Constant.LIST_INSRNC_CLAUSE)){

			SqlStatement=Sqlstmt.SELECTCLUSINFO1;
			String [][] sqlParameters= {{"c_insrnc_cde",in_insrnc_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)},
					{"c_claus_cde",Constant.ADD_INSRNC_CLAUSE_CDE,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryClauseListInfo1 =
		new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

			switch (QueryClauseListInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryClauseListInfo1.GetReturnArray ();
				}else{

			if ((in_claus_cde==null) || (in_claus_cde.length()==0))
		ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM,conn);

			if ((in_claus_cde.length()==2)){
		SqlStatement=Sqlstmt.SELECTCLUSINFO2;
		String [][] sqlParameters= {{"c_insrnc_cde",in_insrnc_cde,
							 String.valueOf(Constant.VARCHAR2_TYPE)},
							{"c_claus_cde",in_claus_cde,
							 String.valueOf(Constant.VARCHAR2_TYPE)}};
		ConnectDB QueryClauseListInfo2 =
				new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

		switch (QueryClauseListInfo2.GetReturnCode()) {
		case Constant.ConnectDB_SelectNone:
				ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
		case Constant.ConnectDB_SelectMulti:
		case Constant.ConnectDB_SelectOne:
				break;
		default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
		};
		ReturnResult = QueryClauseListInfo2.GetReturnArray ();
			}

			if ((in_claus_cde.length()==4)){
		String in_claus_cde1 = in_claus_cde.substring(0,2);
		String in_claus_cde2 = in_claus_cde.substring(2,4);

		SqlStatement=Sqlstmt.SELECTCLUSINFO3;
		String [][] sqlParameters= {{"c_insrnc_cde",in_insrnc_cde,
							 String.valueOf(Constant.VARCHAR2_TYPE)},
							{"c_claus_cde",in_claus_cde1,
							 String.valueOf(Constant.VARCHAR2_TYPE)},
							{"c_claus_cde",in_claus_cde2,
							 String.valueOf(Constant.VARCHAR2_TYPE)}};
		ConnectDB QueryClauseListInfo2 =
				new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

		switch (QueryClauseListInfo2.GetReturnCode()) {
		case Constant.ConnectDB_SelectNone:
				ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
		case Constant.ConnectDB_SelectMulti:
		case Constant.ConnectDB_SelectOne:
				break;
		default:
				ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
		};
		ReturnResult = QueryClauseListInfo2.GetReturnArray ();
			}

			if ((in_claus_cde.length()==6)){
		String in_claus_cde1 = in_claus_cde.substring(0,2);
		String in_claus_cde2 = in_claus_cde.substring(2,4);
		String in_claus_cde3 = in_claus_cde.substring(4,6);

		SqlStatement=Sqlstmt.SELECTCLUSINFO4;
		String [][] sqlParameters= {{"c_insrnc_cde",in_insrnc_cde,
							 String.valueOf(Constant.VARCHAR2_TYPE)},
							{"c_claus_cde",in_claus_cde1,
							 String.valueOf(Constant.VARCHAR2_TYPE)},
							{"c_claus_cde",in_claus_cde2,
							 String.valueOf(Constant.VARCHAR2_TYPE)},
							{"c_claus_cde",in_claus_cde3,
							 String.valueOf(Constant.VARCHAR2_TYPE)}};
		ConnectDB QueryClauseListInfo2 =
				new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

		switch (QueryClauseListInfo2.GetReturnCode()) {
		case Constant.ConnectDB_SelectNone:
				ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
		case Constant.ConnectDB_SelectMulti:
		case Constant.ConnectDB_SelectOne:
				break;
		default:
				ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
		};
		ReturnResult = QueryClauseListInfo2.GetReturnArray ();
			}

				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getEndorseReasonList(String in_cedrr_cde)
	throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTEDRRINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cedrr_cde.length ()>0){
			SqlParameters[0][0]="c_edr_rsn";
			SqlParameters[0][1]=in_cedrr_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getDepartmentList(String in_dpt_cde) throws com.mcip.orb.CoException {
				Connection conn = pm.getConnection(dbname);
				String [][] ReturnResult = new String [2][14];
				String SqlStatement=new String("");

				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)){

					SqlStatement=Sqlstmt.SELECTDPTINFO1;
					ConnectDB QueryDptInfo1 = new ConnectDB (conn,SqlStatement,Constant.executeSqlQuery);

					switch (QueryDptInfo1.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
					};
					ReturnResult = QueryDptInfo1.GetReturnArray ();
				}else{

					SqlStatement=Sqlstmt.SELECTDPTINFO2;
					String [][] sqlParameters= {{"c_dpt_cde",in_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryDptInfo2 = new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

					switch (QueryDptInfo2.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
					};
					ReturnResult = QueryDptInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}

		public String[][] getAgentCharacterList(String in_cagtc_cde)
	throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTAGTCINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cagtc_cde.length ()>0){
			SqlParameters[0][0]="c_agt_chrctr_cde";
			SqlParameters[0][1]=in_cagtc_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getSurveyAgentList(String in_csrvy_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTSRVYINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_csrvy_cde.length ()>0){
			SqlParameters[0][0]="c_srvy_cde";
			SqlParameters[0][1]=in_csrvy_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getCarriageList(String in_ccrrg_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTCRRGINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_ccrrg_cde.length ()>0){
			SqlParameters[0][0]="c_carriage_cde";
			SqlParameters[0][1]=in_ccrrg_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getVslLevelList(String in_cvsll_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTVSLLINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cvsll_cde.length ()>0){
			SqlParameters[0][0]="c_vsl_lvl_cde";
			SqlParameters[0][1]=in_cvsll_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getCertificateList(String in_cctfc_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTCTFCINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cctfc_cde.length ()>0){
			SqlParameters[0][0]="c_certificate_cde";
			SqlParameters[0][1]=in_cctfc_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getMajorList(String in_cmjr_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTMJRINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cmjr_cde.length ()>0){
			SqlParameters[0][0]="c_major_cde";
			SqlParameters[0][1]=in_cmjr_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getMarriageList(String in_cmrrg_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTMRRGINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cmrrg_cde.length ()>0){
			SqlParameters[0][0]="c_marriage_cde";
			SqlParameters[0][1]=in_cmrrg_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getSexList(String in_csex_cde) throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTSEXINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_csex_cde.length ()>0){
			SqlParameters[0][0]="c_sex_cde";
			SqlParameters[0][1]=in_csex_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}

		public String[][] getEmployeeCodeList(String in_cempc_cde)
	throws com.mcip.orb.CoException {
				String SqlStatement=Sqlstmt.SELECTEMPCINFO;
				String SqlParameters[][]=new String[1][2];
				if (in_cempc_cde.length ()>0){
			SqlParameters[0][0]="c_emp_cde";
			SqlParameters[0][1]=in_cempc_cde;
				}
				else{
			SqlParameters[0][0]="1";
			SqlParameters[0][1]="1";
				}
				return  getStaticInfo(SqlStatement,SqlParameters);
		}


		// Added By YiJF Oct-08-2000 For External Internet Web Crgo Type Code convertion to PA18 Crgo Code
		public String[][] getPACrgoClsTypList(String in_ccrgc_cde, String in_site_cde)
	throws com.mcip.orb.CoException {
	Connection conn = pm.getConnection(dbname);
				if (in_site_cde==null)
						ErrorHandling(ExceptionCode.NIA_NULLQUERYPARM,conn);

				if (in_site_cde.length()==0)
						ErrorHandling(ExceptionCode.NIA_INVALIDQUERYPARM,conn);

				String [][] ReturnResult = new String [2][6];
				String SqlStatement=new String("");

				if ((in_ccrgc_cde==null) || (in_ccrgc_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTPACRGOINFO1;
			String [][] sqlParameters= {{"c_site_cde",in_site_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryPACrgoClsTypInfo1 =
		new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

			switch (QueryPACrgoClsTypInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryPACrgoClsTypInfo1.GetReturnArray ();
				}else{

			SqlStatement=Sqlstmt.SELECTPACRGOINFO2;
			String [][] sqlParameters= {{"c_crgo_cde",in_ccrgc_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)},
					{"c_site_cde",in_site_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryPACrgoClsTypInfo2 =
		new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

			switch (QueryPACrgoClsTypInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryPACrgoClsTypInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}


		public String[][] getNetCodeList(String in_net_cde) throws com.mcip.orb.CoException {
				String [][] ReturnResult = new String [2][2];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_net_cde==null) || (in_net_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTNETCODE1;
			ConnectDB QueryNetInfo1= new ConnectDB (conn,SqlStatement,
								Constant.executeSqlQuery);
			switch (QueryNetInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryNetInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTNETCODE2;
			String [][] sqlParameters= {{"c_net_cde",in_net_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryNetInfo2=
		new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

			switch (QueryNetInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
			};
			ReturnResult = QueryNetInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}


		public String[][] getCurrencyInfo(String in_curr_cde) throws com.mcip.orb.CoException {
				String [][] ReturnResult = new String [2][6];
				String SqlStatement=new String("");
	Connection conn = pm.getConnection(dbname);
				if ((in_curr_cde==null) || (in_curr_cde.length()==0)){

			SqlStatement=Sqlstmt.SELECTCURRCENM1;
			ConnectDB QueryCurrInfo1= new ConnectDB (conn,SqlStatement,
								 Constant.executeSqlQuery);
			switch (QueryCurrInfo1.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,conn);
			};
			ReturnResult = QueryCurrInfo1.GetReturnArray ();

				}else{

			SqlStatement=Sqlstmt.SELECTCURRCENM2;
			String [][] sqlParameters= {{"c_cur_no",in_curr_cde,
					 String.valueOf(Constant.VARCHAR2_TYPE)}};
			ConnectDB QueryCurrInfo2= new ConnectDB (conn,SqlStatement,
								 Constant.executePrepQuery,sqlParameters);

			switch (QueryCurrInfo2.GetReturnCode()) {
			case Constant.ConnectDB_SelectNone:
		ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
			case Constant.ConnectDB_SelectMulti:
			case Constant.ConnectDB_SelectOne:
		break;
			default:
		ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,conn);
			};
			ReturnResult = QueryCurrInfo2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}


// Add by YiJF 2001-04-02
// Get Report Telephone Number of Department
		public String[][] getRptTelNum(String in_dpt_cde) throws com.mcip.orb.CoException {
	Connection conn = pm.getConnection(dbname);
				String [][] ReturnResult = new String [2][5];
				String SqlStatement=new String("");

				if ((in_dpt_cde==null) || (in_dpt_cde.length()==0)){

					SqlStatement=Sqlstmt.SELECTRPTTELNUM1;
					ConnectDB QueryRptTelNum1 = new ConnectDB (conn,SqlStatement,Constant.executeSqlQuery);

					switch (QueryRptTelNum1.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
					};
					ReturnResult = QueryRptTelNum1.GetReturnArray ();
				}else{

					SqlStatement=Sqlstmt.SELECTRPTTELNUM2;
					String [][] sqlParameters= {{"c_dpt_cde",in_dpt_cde,String.valueOf(Constant.VARCHAR2_TYPE)}};
					ConnectDB QueryRptTelNum2 = new ConnectDB (conn,SqlStatement,Constant.executePrepQuery,sqlParameters);

					switch (QueryRptTelNum2.GetReturnCode()) {
						 case Constant.ConnectDB_SelectNone:
									ErrorHandling(ExceptionCode.DB_FINDNOREC,"","",Constant.WARNING,conn);
						 case Constant.ConnectDB_SelectMulti:
						 case Constant.ConnectDB_SelectOne:
									break;
						 default:
									ErrorHandling(ExceptionCode.DB_GENERAL_ERROR,SqlStatement,conn);
					};
					ReturnResult = QueryRptTelNum2.GetReturnArray ();
				}

				pm.freeConnection (dbname,conn);
				return ReturnResult;
		}






}


