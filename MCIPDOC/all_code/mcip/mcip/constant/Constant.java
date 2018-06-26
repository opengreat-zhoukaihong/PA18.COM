////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Provide const define in all module
// Update Date:2000/7/20
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb: 09/26 Add BatchUpdate Constant
//     Zhanyb: 10/10 Add TIME_TYPE Constant
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
// Change Log
//     YiJF: 10/13 Add Case Report Constant
//     YiJF: 10/16 Add Event Log Constant
//     YiJF: 11/23 Add PsB2B Login Hostname & servername Constant
//     YiJF: 12/26 Add PA18 CHAT Mark Constant
//     kangjin 2001-09-17 add PolicyInfo constant
////////////////////////////////////////////////////////
package constant;

public class Constant
{

    public static final String SYS_USERDIR=System.getProperty("user.dir");
    public static final String SYS_FILESEPARATOR=System.getProperty("file.separator");

    /////////////////////////////////////////////////////////
    // connection pool constant for different connection
    ////////////////////////////////////////////////////////
    public static final String LOCAL_POOL="NATIVE";
    public static final String BACKEND_POOL="REMOTE";

    ////////////////////////////////////////////////////////
    // DB process return code
    // updated by cidy on 23/11/2000
    ////////////////////////////////////////////////////////

    public static final  String DBNAME="paonline";
    public static final  String DBNAME2="paonline2";
    public static final  String BACKEND_DBNAME="backend";

    //Return by ConnectDB
    //if QueryReturn>1 get result
    //if SQLReturn>=0 No error
    public static final int ConnectDB_Error=-1;
    public static final int ConnectDB_Warning=-2;
    public static final int ConnectDB_SelectNone=0;
    public static final int ConnectDB_SelectOne=1;
    public static final int ConnectDB_SelectMulti=2;
    public static final int ConnectDB_Success=3;


    ////////////////////////////////////////////////////////
    // DB operation type
    ////////////////////////////////////////////////////////
    public static final int executeSqlQuery=10;
    public static final int executeSqlUpdate=11;
    public static final int executeSqlUpdateNoCommit=12;
    public static final int executePrepQuery=20;
    public static final int executePrepUpdate=21;
    public static final int executePrepUpdateNoCommit=22;
    public static final int executeBatchPrepUpdate=31;
    public static final int executeBatchPrepUpdateNoCommit=32;

    ////////////////////////////////////////////////////////
    // DB field data type
    ////////////////////////////////////////////////////////
    public static final int VARCHAR2_TYPE=1;
    public static final int CHAR_TYPE=2;
    public static final int DATE_TYPE=3;
    public static final int TIME_TYPE=4;
    public static final int DATETIME_TYPE=5;
    public static final int INT_TYPE=6;
    public static final int SHORT_TYPE=7;
    public static final int BIGDECIMAL_TYPE=8;

    ////////////////////////////////////////////////////////
    // Data Time format type
    ////////////////////////////////////////////////////////
    public static final String LONG_DATE_FORMAT="yyyy-MM-dd HH:mm:ss";
    public static final String SHORT_DATE_FORMAT="yyyy-MM-dd";
    public static final String CLONG_DATE_FORMAT="yyyy年MM月dd日HH时mm分ss秒";
    public static final String CSHORT_DATE_FORMAT="yyyy年MM月dd日";

    ////////////////////////////////////////////////////////
    // CORBA error severity
    ////////////////////////////////////////////////////////
    public static final String WARNING="30";
    public static final String ERROR="90";

    ////////////////////////////////////////////////////////
    // CURRENCY EXCHANGE RATE FOR USD$
    ////////////////////////////////////////////////////////
    public static final String USD_EXCHANGE_RATE="03";

    ////////////////////////////////////////////////////////
    // CUSTOMER NET ID FOR PA18
    ////////////////////////////////////////////////////////
    public static final String PA18_NET_CDE="001";

    ////////////////////////////////////////////////////////
    // CUSTOMER VERIFY STATUS FLAG
    ////////////////////////////////////////////////////////
    public static final char USER_NOT_VERIFY ='0';
    public static final char NORMAL_VERIFIED ='1';
    public static final char AGENT_VERIFIED ='2';
    public static final char OPENCVR_VERIFIED ='3';

    public static final String USER_NOTVERIFY = "0";
    public static final String USER_CANCEL = "9";

    public static final String VERIFYING_FLAG = "0";
    public static final String VERIFIED_FLAG = "1";
    public static final String VERIFY_ALL_FLAG = "2";

    ////////////////////////////////////////////////////////
    // INSURRANCE TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String EXPORT_INSRNC="B01";
    public static final String IMPORT_INSRNC="B02";
    public static final String HOME_INSRNC="B03";
    public static final String HOME_RAILWAY_INSRNC="B13";
    public static final String HOME_ROAD_INSRNC="B23";
    public static final String HOME_SHIP_INSRNC="B33";
    public static final String HOME_AIR_INSRNC="B43";
    public static final double ALL_VRATE = 1;
    public static final double ADD_VRATE = 0.8;

    ////////////////////////////////////////////////////////
    // INSURRANCE RDR TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String OCN_PA_RDR = "06";
    public static final String OCN_WTR_RDR = "05";
    public static final String OCN_ALL_RDR = "02";
    public static final String ICCA_RDR = "07";
    public static final String ICCB_RDR = "08";
    public static final String ICCC_RDR = "09";
    public static final String LAND_RDR = "36";
    public static final String LAND_ALL_RDR = "37";
    public static final String AIR_RDR = "39";
    public static final String AIR_ALL_RDR = "40";

    public static final String NULL_RDR = "0";
    public static final String WITH_RDR = "1";

    ////////////////////////////////////////////////////////
    // INSURRANCE CLAUSE TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String MAIN_INSRNC_CLAUSE="0";
    public static final String LIST_INSRNC_CLAUSE="1";
    public static final String ADD_INSRNC_CLAUSE_CDE="03";

    ////////////////////////////////////////////////////////
    // INSURRANCE CLAIM TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String NOT_CLAIM_MRK = "0";
    public static final String CLAIM_MRK = "1";
    public static final String CLAIM_SETTLE_STATUS="3";

    ////////////////////////////////////////////////////////
    // CUSTOMER TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String NORMAL_CUST_MRK = "1";
    public static final String AGENCY_CUST_MRK = "2";
    public static final String OPNCVR_CUST_MRK = "3";

    ////////////////////////////////////////////////////////
    // CUSTOMER TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String ACCEPT_OPRAUTH_MRK = "1";
    public static final String DELETE_OPRAUTH_MRK = "2";
    public static final String UPDATE_OPRAUTH_MRK = "3";

    public static final String NO_RCSV_DEL_MRK = "0";
    public static final String YES_RCSV_DEL_MRK = "1";

    ////////////////////////////////////////////////////////
    // POLICY Print TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String NOT_PRINT_MRK = "0";
    public static final String PRINTED_MRK = "1";
    public static final String ALL_PRINT_MRK = "2";

    ////////////////////////////////////////////////////////
    // POLICY Process TYPE CODE For Deliverying Policy
    ////////////////////////////////////////////////////////
    public static final String DEAL_MRK = "0";
    public static final String ASSN_MRK = "1";
    public static final String SEND_MRK = "2";
    public static final String FRBK_MRK = "3";

    public static final String NOTDEAL_MRK = "0";
    public static final String ALREADY_MRK = "1";
    public static final String ALLDEAL_MRK = "2";

    ////////////////////////////////////////////////////////
    // POLICY Process Type CODE For Case Report
    ////////////////////////////////////////////////////////
    public static final String RCVR_MRK = "1";
    public static final String RGST_MRK = "2";

    ////////////////////////////////////////////////////////
    // Event Proccess Type CODE For Event Log Summary List
    ////////////////////////////////////////////////////////
    public static final String SUCCESS_EVENT = "0";
    public static final String FAIL_EVENT = "1";
    public static final String TOTAL_EVENT = "2";

    public static final String ALL_EVENT = "0";
    public static final String SINGLE_EVENT = "1";

    ////////////////////////////////////////////////////////
    // Statictics Proccess Type CODE For Summary List
    ////////////////////////////////////////////////////////
    public static final String NOT_UDR_MRK = "0";
    public static final String UDR_MRK = "1";
    public static final String PRPSL_MRK = "2";
    public static final String ALL_MRK = "3";

    ////////////////////////////////////////////////////////
    // Event LOG TYPE CODE
    ////////////////////////////////////////////////////////
    public static final String LOG_CUSTREGIST = "00";
    public static final String LOG_CUSTLOGIN = "01";
    public static final String LOG_CODETABLE = "02";
    public static final String LOG_PLCYAPPLY = "03";
    public static final String LOG_PLCYQUERY = "04";
    public static final String LOG_PLCYAPPUPD = "05";
    public static final String LOG_PRPSLCNFM = "06";
    public static final String LOG_CASEREPORT = "07";
    public static final String LOG_CLMRPTQUERY = "08";
    public static final String LOG_OPERTRLOGIN = "09";
    public static final String LOG_PLCYDELIVEY = "10";
    public static final String LOG_PLCYPRINT = "11";
    public static final String LOG_CASEFLLWUP = "12";
    public static final String LOG_OPRAUTHRTY = "13";
    public static final String LOG_OPTRMANAGE = "14";
    public static final String LOG_PAGEMANAGE = "15";
    public static final String LOG_FUNCMANAGE = "16";
    public static final String LOG_BUSIMANAGE = "17";
    public static final String LOG_CUSTMANAGE = "18";
    public static final String LOG_STATICTICS = "19";
    public static final String LOG_QUOTATION = "20";
    public static final String LOG_CLSINTRDC = "21";
    public static final String LOG_INSRNCGUIDE = "23";
    public static final String LOG_INSRNCFAQ = "25";
    public static final String LOG_MCLSINTRDC = "22";
    public static final String LOG_MINSRNCGUIDE = "24";
    public static final String LOG_MINSRNCFAQ = "26";
    public static final String LOG_PLCYENDORSE = "27";

    ////////////////////////////////////////////////////////
    // Main Account MARK For Client CODE Map
    ////////////////////////////////////////////////////////
    public static final String MAIN_MRK = "1";
    public static final String NRML_MRK = "0";

    ////////////////////////////////////////////////////////
    // HOSTNAME & SERVERNAME For PSB2B Portal Connection
    ////////////////////////////////////////////////////////
    public static final String PsB2B_HOSTNAME = "";
    public static final String PsB2B_SERVERNAME = "PsB2BService_localhost";

    ////////////////////////////////////////////////////////
    // HOSTNAME & SERVERNAME For PSB2B Portal Connection
    ////////////////////////////////////////////////////////
    public static final String BsInfo_HOSTNAME = "";
    public static final String BsInfo_SERVERNAME = "BsInfoQuery_localhost";

    ////////////////////////////////////////////////////////
    // Department chinese / English name Flag
    ////////////////////////////////////////////////////////
    public static final String DPT_ABRNAME = "0";
    public static final String DPT_CHNNAME = "1";

    ////////////////////////////////////////////////////////
    // Personal / Enterprise Customer Flag
    ////////////////////////////////////////////////////////
    public static final String ORGN_FLG = "0";
    public static final String PRSN_FLG = "1";

    ////////////////////////////////////////////////////////
    // THE FLAG OF CUSTOMER REGISTERED OR NOT IN PA18.COM
    ////////////////////////////////////////////////////////
    public static final String NOREGISTER_MRK = "0";
    public static final String REGISTERED_MRK = "1";

    ////////////////////////////////////////////////////////
    // THE FLAG OF TRUE/FALSE OR YES/NO IN PA18.COM
    ////////////////////////////////////////////////////////
    public static final String TRUE_YES = "1";
    public static final String FALSE_NO = "0";

    ////////////////////////////////////////////////////////
    // THE Mark OF CHAT Between underwriter and customr
    ////////////////////////////////////////////////////////
    public static final String UNDR_PRSN_MRK = "0";
    public static final String CUSTOMER_MRK = "1";

    ////////////////////////////////////////////////////////
    // THE BackEnd Support Person Type Code for Application System
    ////////////////////////////////////////////////////////
    public static final String CUST_UNDR = "1";
    public static final String PLCY_UNDR = "2";
    public static final String PLCY_ASSN = "3";
    public static final String CASE_UNDR = "4";

    ////////////////////////////////////////////////////////
    // THE E-Mail Static Code for Application System
    ////////////////////////////////////////////////////////
    public static final String WEBSITE_ADDRESS = " http://cargo.pa18.com/operator_manager/";
    public static final String ORG_EMAIL_ADDRESS = "mcip@pa18.com";
/*    public static final String EMAIL_TITLE_1 = " New customer's membership apply !";
    public static final String EMAIL_CNTNT_1 = " New customer's membership apply Form is comming, Pls Verify it ! The Client Code : ";
    public static final String EMAIL_TITLE_2 = " New Policy apply Form!";
    public static final String EMAIL_CNTNT_2 = " New Policy apply Form is comming, Pls Underwrite it ! The Policy Apply Form Number : ";
    public static final String EMAIL_TITLE_3 = " New Policy Form !";
    public static final String EMAIL_CNTNT_3 = " New Policy Form is comming, Pls send it to customer ! The Policy Form Number : ";
    public static final String EMAIL_TITLE_4 = " New Case Report !";
    public static final String EMAIL_CNTNT_4 = " New Case Report is comming, Pls Check it ! The Case Report Number : ";
    public static final String EMAIL_TITLE_5 = " New Policy Endorsement Apply Form !";
    public static final String EMAIL_CNTNT_5 = " New Policy Endorsement Apply Form is comming, Pls Underwrite it ! The Policy Endorsement Apply Form Number : ";
*/
    public static final String EMAIL_TITLE_1 = " 新会员资格申请表来了！";
    public static final String EMAIL_CNTNT_1 = " 新会员资格申请表来了，请尽快审核！ 新会员编码是： ";
    public static final String EMAIL_TITLE_2 = " 新的投保申请单来了！";
    public static final String EMAIL_CNTNT_2 = " 新的投保申请单来了，请尽快核保！ 新的投保申请单号是： ";
    public static final String EMAIL_TITLE_3 = " 新的保单来了！";
    public static final String EMAIL_CNTNT_3 = " 新的保单来了，请尽快调度送单员将新保单送往投保人！ 新保单号是： ";
    public static final String EMAIL_TITLE_4 = " 新的报案报告来了！";
    public static final String EMAIL_CNTNT_4 = " 新的报案报告来了，请尽快调度跟进人跟进该新报案！ 报案号是： ";
    public static final String EMAIL_TITLE_5 = " 新的保单批改申请单来了！";
    public static final String EMAIL_CNTNT_5 = " 新的保单批改申请单来了，请尽快核保！ 新的保单批改申请单号是： ";

    ////////////////////////////////////////////////////////
    // THE FLAG OF Policy Apply Form / Policy Endorse Apply Form
    ////////////////////////////////////////////////////////
    public static final String PLYAPP_TYPE = "0";
    public static final String PLYEDRAPP_TYPE = "1";

    public static final String POLICY_TYPE = "0";
    public static final String PLYEDR_TYPE = "1";

    public static final String PRPSL_READ_FLAG = "0";
    public static final String PRPSL_NOREAD_FLAG = "1";

    public static final String PAY_SUCC_FLAG = "1";
    public static final String PAY_FAIL_FLAG = "2";
    public static final String PAY_WAIT_FLAG = "3";

	/////////////////////////////////////////////////////
	//The name of policy XML tags
	/////////////////////////////////////////////////////
  public static final String[] POLICY_FIELDS_LIST= {"C_PLY_NO",
  "C_ORIG_PLY_NO",
  "C_DPT_CDE",
  "C_BSNS_TYP",
  "C_BSNS_TYP",
  "C_CMPNY_AGT_CDE",
  "C_OPEN_COVER_NO",
  "C_AGT_AGR_NO",
  "N_SUB_CO_NO",
  "C_BRKR_CDE",
  "C_SLS_CDE",
  "C_INSRNC_CMPNY_CDE",
  "C_INSRNT_CDE",
  "C_INSRNT_NME",
  "C_INSRNT_ADDR",
  "C_BNFC_CDE",
  "C_BNFC_NME",
  "C_APP_CDE",
  "C_APP_NME",
  "C_APP_ADDR",
  "C_APP_TEL",
  "C_INSRNC_CDE",
  "C_CLAUS_CDE",
  "T_APP_TM",
  "T_INSRNC_BGN_TM",
  "T_INSRNC_END_TM",
  "T_SIGN_TM",
  "C_AMT_CUR",
  "N_INSRNC_VLU",
  "N_AMT",
  "N_RATE",
  "N_PRM",
  "N_RDR_PRM",
  "N_SUM_PRM",
  "C_PRM_CUR",
  "N_NCLM_PROP",
  "N_APPNT_PROP",
  "N_CMM_PROP",
  "N_BRK_PROP",
  "N_PAY_TMS",
  "C_APPNT",
  "C_REMARK",
  "C_CRT_PRSN",
  "C_UNDR_PRSN",
  "T_UNDR_TM",
  "C_RINSRNC_MRK",
  "C_COINSRNC_MRK",
  "T_INPUT_TM",
  "C_UNDR_DPT",
  "C_OPR_TYP",
  "C_EDR_PRJ_NO",
  "T_NEXT_EDR_UNDR_TM",
  "C_UDR_MRK",
  "C_AGELONG_MRK",
  "C_CEPRN_MRK",
  "C_SALEGRP_CDE",
  "C_CRGO_CDE",
  "C_CRGO_DESC",
  "C_INVC_NO",
  "C_SAIL_NO",
  "C_PRN_FRM",
  "C_CARRIAGE_CDE",
  "C_VSL_LVL_CDE",
  "C_FROM_PRT",
  "C_TO_PRT",
  "C_FRM_PRT_ARA",
  "C_TO_PRT_ARA",
  "C_PASS_PRT",
  "C_SRVY_CDE",
  "C_SRVY_CNM",
  "C_UNDR_CNDTN",
  "C_PAY_ADDR",
  "C_RECEIPT_NO",
  "C_CRGO_CLS",
  "C_CRGO_NAME",
  "C_AMOUNT",
  "C_PACK_CDE",
  "C_PACK_CNM",
  "C_MARK",
  "N_INVC_AMT",
  "C_INVC_AMT_CUR",
  "C_NO_REPAY",
  "C_CREDIT_ID",
  "C_LOST_DESC",
  "C_CONTAINER",
  "C_ADD_RISK",
  "C_SRVY_ADDR",
  "C_EDR_INFO",
  "C_PROVINCE",
  "C_CITY",
  "C_PLACE",
  "C_CONTACT_NAME",
  "C_CONTACT_PHONE",
  "C_CONTACT_FAX",
  "C_CONTACT_EMAIL",
  "C_ZIP_CDE",
  "C_ADD_INSURANCE7"
  };
  }
