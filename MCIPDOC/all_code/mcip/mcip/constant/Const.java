///////////////////////////////////////////////////////////////////////
// Author：ZhangJinQuan
// Function:   for function of interface,sessionbuffer and interface
// Create date 2000/8/4
// Update Date:2000/8/8
///////////////////////////////////////////////////////////////////////

package constant;

public class Const
{

    //FOR TABLE COL NUM
    public static final int CUSTORGN_LEN = 35;
    public static final int CUSTPRSN_LEN = 35;
    public static final int CUSTENTITY_LEN = 10;
    public static final int POLICYINFO_LEN = 109;
    //for custmanager interface function:

    public static final int CUSTOMER_LOGIN  = 1;//";customerLogin";;  //is to value ";C01";
    public static final int ACCEPT_ORGACUST = 2;//";acceptOrgaCust";;
    public static final int ACCEPT_PRSNCUST = 3;//";acceptPrsnCust";;
    public static final int UPDATE_ORGACUST = 4;//";updateOrgaCust";;
    public static final int UPDATE_PRSNCUST = 5;//";updatePrsnCust";;
    public static final int UPDATE_ENTTCUST = 6;//";updateEnttCust";;
    public static final int QUERY_CUSTENTT  = 7;//";queryCustEntt";;
    public static final int QUERY_CUSTORGN  = 8;//";queryCustOrgn";;
    public static final int QUERY_CUSTPRSN  = 9;//";queryCustPrsn";;
    public static final int ACCEPT_AGNTCUST = 10;//";acceptAgntCust";;
    public static final int REQUIRECUST  = 11;//requireCust;
    public static final int QUERY_CUSTAGNT  = 12;//";queryCustAgnt";;
    public static final int DELETE_ILLEGAL_USER = 30;//add by kangji for 2001091401
//    public static final int QUERY_CUSTENTTLIST  = 12;//";queryCustEnttList";;
//    public static final int QUERY_SAMECUSTLIST  = 13;//";querySameCustList";;

    //for staticinfomanager interface function:

    public static final int GET_NATIONAL = 1;//";getNational";;//is to ";S01";
    public static final int GET_AREA = 2;//";getArea";;
    public static final int GET_PROVINCE = 3;//";getProvince";;
    public static final int GET_EDU = 4;//";getEdu";;
    public static final int GET_TITILE = 5;//";getNational";;
    public static final int GET_DUTY = 6;//";getDuty";;
    public static final int GET_TRADETYPE = 7;//";getTradeType";;
    public static final int GET_ORGTYPE = 8;//";getOrgType";;
    public static final int GET_OWNERSHIP = 9;//";getOwnerShip";;
    public static final int GET_SCALE = 10;//";getScale";;
    public static final int GET_PREMIUMSCALE = 11;//";getPremiumScale";;
    public static final int GET_CURRENCY = 12;//";getCurrency";;

    public static final int GET_BIGCARGOTYPE = 13;//";getBigCargoType";;
    public static final int GET_SMALLCARGOTYPE = 14;//";getSmallCargoType";;
    public static final int GET_PACK = 15;//";getPack";;
    public static final int GET_EXCHANGERATE = 16;//";getExchangeRate";;
    public static final int GET_PAYMODE = 17;//";getPayMode";;
    public static final int GET_INSURANCECLASS = 18;//";getInsuranceClass";;
    public static final int GET_INSURANCEDEFINE = 19;//";getInsuranceDefine";;
    public static final int GET_INSURANCETYPE = 20;//";getInsuranceType";;
    public static final int GET_CLAUSE = 21;//";getClause";;
    public static final int GET_ENDORSEREASON = 22;//";getEndorseReason";;
    public static final int GET_DEPARTMENT = 23;//";getDepartment";;

    public static final int GET_AGENTCHARACTER = 24;//";getAgentCharacter";;
    public static final int GET_SURVEYAGENT = 25;//";getSurveyAgent";;
    public static final int GET_CARRIAGE = 26;//";getCarriage";;
    public static final int GET_VSLLEVEL = 27;//";getVslLevel";;
    public static final int GET_CERTIFICATE = 28;//";getCertificate";;
    public static final int GET_MAJOR = 29;//";getMajor";;
    public static final int GET_MARRIAGE = 30;//";getMarriage";;
    public static final int GET_SEX = 31;//";getSex";;
    public static final int GET_EMPLOYEECODE = 32;//";getEmployeeCode";;
    public static final int GET_CITY = 33;//";getCity";;
    public static final int GET_NETCODELIST = 34;//";getNetCodeList";;        ;

    public static final int GET_CURRENCY_INFO = 35;//get currency infomataion

    //for policyinfomanager interface function:

    public static final int GET_OCLIST = 1;//";getOCList";;
    public static final int GET_OCINFO = 2;//";getOCInfo";;
    public static final int GET_AGENCYLIST = 3;//";getAgencyList";;
    public static final int GET_AGENCYINFO = 4;//";getAgencyInfo";;
    public static final int GET_AGENCYPLCYLIST = 5;//";getAgencyPlcyList";;
    public static final int GET_CUSTPLCYLIST = 6;//";getCustPlcyList";;

    public static final int GET_APPLICATIONFORMLIST = 7;//";getApplicationFormList";;
    public static final int ACCEPT_POLICYAPP = 8;//";acceptPolicyApp";;
    public static final int WITHDRAWAL_POLICYAPP = 9;//";withdrawalPolicyApp";;
    public static final int UPDATE_POLICYAPP = 10;//";updatePolicyApp";;
    public static final int CONFIRM_POLICYAPPPROPOSAL = 11;//";confirmPolicyAppProposal";;
    public static final int ACCEPT_USERREMARK = 12;
    public static final int DELETE_POLICYAPP = 13;

    public static final int GET_POLICYAPPLIST = 12;//";getPolicyAppList";;
    public static final int GET_POLICYAPPINFO = 13;//";getPolicyAppInfo";;
    public static final int GET_POLICYLIST = 14;//";getPolicyList";;
    public static final int GET_POLICYINFO = 15;//";getPolicyInfo";;
    public static final int GET_PROPOSALINFO = 16;//";getProposalInfo";;
    public static final int GET_ENDORSEPROPOSALINFO = 17;//";getEndorseProposalInfo";;
    public static final int GET_ENDORSEPOLICYINFO = 18;//";getEndorsePolicyInfo";;
    public static final int GET_CASEREPORT = 19;//";getCaseReport";;
    public static final int GET_APPLICATIONFORMINFO = 20;//";getApplicationFormInfo";;
    public static final int GET_PLYAPPRDRINFO = 21;//getPlyAppRdrInfo
    public static final int GET_PLYAPPNETADDRESS = 22;//getPlyAppNetAddress
    public static final int GET_CASERPTINFO = 23;//getCaseRptInfo
    public static final int GET_PROPOSALLIST = 24;//";getProposalList";;
    public static final int GET_EDRAPPLIST = 25 ;// 批单申请查询
    public static final int GET_EDRSMTLIST = 26 ; //批单查询
    public static final int GET_EDRSMTINFO = 27 ; // 批单明细
    public static final int GET_PREEDRINFO = 28 ; // 批单预览
    public static final int CHECK_PROPOSAL = 29;
	public static final int GET_PLYRDRINFO = 30;//getPlyRdrInfo
	public static final int QUERY_AGENCY_INFO = 31;//get agency infomation
	public static final int QUERY_OC_CUST_INFO= 32;//get Open Cover infomation
	public static final int ACCEPT_AG_CUST = 33;//accept agent user
	public static final int ACCEPT_OC_CUST= 34;//accept open cover user
	public static final int CHECK_EDRAPP = 35;
	public static final int GET_POLICYINFO_LATEST = 36;
    //for sessionbuffer
    public static final int ARRAY_LEN = 2500;                    // session length of array
    public static final int MAX_USERS = 2500;                    // session length of array
    public static final int MAX_SESS = 2500;                    // session length of array
    public  static final int TIMEOUT = 2*60*60*1000;             // session overtime
    public static final int LONGTIMEOUT = 2*60*60*1000;       // session with busy overtime
    public static final int MINSESSID = 1;                 // SessionIdMin
    public static final long MAXSESSID = 268435456 - 100;  // SessionIdMax
    public final static int CLIENT_ADD_LEN = 10;   //client addinfo len

    public static final String INIT_NULL = "";             // String init value
    public static final int INIT_ZERO = 0;                      // int type initvalue

    public static final int SESSID_LEN = 10;                // from int type sessionid to String

    public static final int SLEEPTIME = 30*1000;              // SessionThread sleeptime

    public static final int SESSBUFINIT = 1;                  // ProcessSession ， init session buffer
    public static final int SESSOVERTIME = 2;                 // ProcessSession ，overtime check session
    public static final int SESSNEW = 3;                      // ProcessSession ，new session
    public static final int SESSAUTH = 4;                     // ProcessSession ，confirm session
    public static final int SESSDEL = 5;                      // ProcessSession ，del session

//    public static final String SYS_NOT_INIT = "System not init or connect overtime or not Login,please reLogin or contact System Administrator";
    public static final String SYS_NOT_INIT = "系统没有初始化";
    public static final String SYS_NOT_INIT_CDE = "0001";
    public static final String SYS_LOGIN_ERR = "系统访问错误(WebServer因故重新启动或登录超时),请重新登录,多谢合作!!!";
    public static final String SYS_LOGIN_ERR_CDE = "0002";
    public static final String SYS_USER_ERR = "您的用户暂时还没有开通，不能做本业务，我们将尽快审核您的用户资料并与您联系";
    public static final String SYS_USER_ERR_CDE = "0003";
    public static final String SYS_USER_OC_ERR = "预约保险指与我公司签订预约合同，每次货物起运前进行申报的一种方式。这种方式，对长期有货物运送的投保人，能减少其投保手续，提高投保效率。<br>您如果有预约保险的需要，可打免费电话95511与我们联系。";
    public static final String SYS_USER_ERR_OC_CDE = "0004";

    //for custtype from login info
    public static final String CUST_CM = "1";//Common user
    public static final String CUST_AG = "2";//agent user
    public static final String CUST_OC = "3";    //openCover user

    public static final int MAXROWNUM = 10;//The max length for displaying data in list
    //for operationselect item:tranType(Export and Import)
    //B01:import B02:outPort B03:home
    //H01:credit B02:Nocredit

/*    public static final int B11 = 0;//parcel post
    public static final int B13 = 1;//water ocean
    public static final int B23 = 2;//railway
    public static final int B33 = 3;//road
    public static final int B43 = 4;//airport trip

    public static final int C1 = 0;//railway
    public static final int C2 = 1;//ocean
    public static final int C3 = 2;//airport
    public static final int C4 = 3;//parcel post
*/

    //for inputPolicy form
    public static final String SELECT = "请选择";
    public static final String PROVINCE = "省市";
    public static final String AREA = "国家";
    public static final String CHINA_CDE = "1001";
    public static final String CHINA_CNM = "中国";
    public static final String PLY_CNM = "保单";
    public static final String PLYAPP_CNM = "投保单";
    public static final String PRP_CNM = "建议书";
    public static final String[] RMB = {"01","人民币"};
    public static final String[] USA = {"03","美元"};

    //for policyinput&notice
    public static final String REP = "rep";
    public static final String SUB = "sub";
    public static final String AGR = "agr";
    public static final String MOD = "mod";
    public static final String PRE = "pre";
    public static final String UNAGR ="unagr";
    public static final String UNDRAW = "undraw";  //删除
    public static final int STEP_BEG = 0;
    public static final int STEP_REP = 1;
    public static final int STEP_SUB = 2;
    public static final int STEP_MOD = 3;    //modify after submit ply and get plyno
    public static final int STEP_NEWMOD = 4; //modify by select plyno
    //operation select
    public static final String C_AGENCY_NO = "C_AGENCY_NO";
    public static final String CLAUSE = "CLAUSE";
    public static final String FIND = "FIND";
    public static final String PRP = "PRP";  //Proposal
    public static final String CASE = "CASE";
    public static final String MODIFY = "MODIFY";
	public static final String EDRSMTAPP = "EDRSMTAPP";
	public static final String EDRSMT ="EDRSMT";
    public static final String OPENCOVER = "OpenCover";
    public static final String AGENT = "Agent";
    public static final String OTHER = "Other";

    //import,export,home C_insrnc_cde
    public static final String C_IMPORT_CDE = "B01";
    public static final String C_IMPORT_CNM  = "进口货运";
    public static final String C_EXPORT_CDE = "B02";
    public static final String C_EXPORT_CNM = "出口货运";
    public static final String C_HOME_CDE = "B03";
    public static final String C_HOME_CNM = "国内货运";

    public static final String C_NOCREDIT_CDE = "0";
    public static final String C_CREDIT_CDE = "1";
    //home's carriage C_insrnc_cde
    public static final int HOME_TRANSIT_LEN = 4;
    public static final int PORT_TRANSIT_LEN = 3;
    //home
//    public static final int N_POST_CDE_H = 0;//no use
    public static final int N_RAILAGE_CDE = 0;
    public static final int N_ROAD_CDE = 1;
    public static final int N_WATER_CDE = 2;
    public static final int N_H_AVIATION_CDE = 3;
    //port
    public static final int N_LANDWAY_CDE = 0;
    public static final int N_SEA_CDE = 1;
    public static final int N_AVIATION_CDE = 2;
//    public static final int N_POST_CDE_P = 3;//no use

    //CARRIGE_cde for policyapp submit,direct to dimension of array
    public static final String[] PORT_CARRIAGE_CDE = {"02","01","03"};
    public static final String[] HOME_CARRIAGE_CDE = {"06","07","05","08"};
    /*01 国际海运 02 国际陆运 03 国际空运 05 国内水路 06 国内铁路 07 国内公路 08 国内航空 */
    //home
    public static final String[][] CARRIAGE =
    {{"01","02","03","06","07","05","08"},
    {"国际海运","国际陆运","国际空运","国内铁路","国内公路","国内水路","国内航空"}};

    public static final String C_RAILAGE_CDE = "B23";
    public static final String C_RAILAGE_CNM  = "铁路";
    public static final String C_ROAD_CDE = "B33";
    public static final String C_ROAD_CNM  = "公路";
    public static final String C_WATER_CDE  = "B13";
    public static final String C_WATER_CNM  = "水路";
    public static final String C_H_AVIATION_CDE  = "B43";
    public static final String C_H_AVIATION_CNM  = "航空";

    //port
    public static final String C_LANDWAY_CDE = "B01";
    public static final String C_LANDWAY_CNM  = "陆路";
    public static final String C_SEA_CDE = "B31";//VALUE IS B01
    public static final String C_SEA_CNM  = "海洋";
    public static final String C_AVIATION_CDE  = "B21";//VALUE IS B01
    public static final String C_AVIATION_CNM  = "航空";

    public static final String C_POST_CDE = "B11"; //is to be no use
    public static final String C_POST_CNM  = "邮包";

    public static final String HOME_TRANSIT[][] =
    {{"B23","B33","B13","B43"},{"铁路","公路","水路","航空"}};
    public static final String PORT_TRANSIT[][] =
    {{"0","1","2"},{"陆路","海洋","航空"}};
   // ";B13";B23,B33,B43
    public static final String C_H_B03_CDE[] ={"01","02","03","04"};
    public static final String C_H_B03_CNM[] ={"基本险","综合险","航空运输险","航空运输一切险"};
   //import&export
    public static final String C_H_B0102_CDE[] ={"06","05","02","07","08","09","36","37","39",
    "40","42"};
    public static final String C_H_B0102_CNM[] ={"平安险","水渍险","一切险","I.C.C.(A)",
    "I.C.C.(B)","I.C.C.(C)","陆运险","陆运一切险","航空险","航空一切险","邮包险"};
//addtional insrnc
    public static final String C_H_ADD_CDE[] ={"18","20","23","24","25","27","28","29","30","31",
    "32","33","34"};
    public static final String C_H_ADD_CNM[] ={"罢工险","战争险","偷窃、提货不着险",
    "碰损、破碎险","渗漏险","短量险","包装破裂险","淡水、雨淋险","混杂、沾污险","串味险",
    "受潮受热险","钩损险","锈损险"};

    public static final String PORT_INSRNC_CDE = "&06&05&02&07&08&09&36&37&39&40&42";

//for operationSelect clause got
    public static final String  CLAUSE01 = "01";
    public static final String  CLAUSE02 = "02";
    public static final String  CLAUSE03 = "03";

//for remotelogin dataaccepte parameter
    public static final String  REMOTE_PLY = "01";
    public static final String  REMOTE_PRP = "03";
    public static final String  REMOTE_PLY_SEND = "02";
    public static final String  REMOTE_PRP_SEND = "04";

//    public static final String  REMOTE_USERNAME = "LoginName";
    public static final String  REMOTE_OPERTYPE = "TRAN_TYPE";

    public static final String[]  REMOTE_PLY_PARA_HR =
    {"C_NET_ID","PA18_NET_ID","CRE_PLYAPP_NO","TRAN_TYPE",
    "C_INSRNT_NME","C_CONTACT_NAME","C_CONTACT_PHONE","C_CONTACT_FAX","C_REMARK",
    "C_CONTACT_EMAIL","C_CRGO_NAME","C_PACK_CNM",
    "C_AMOUNT","C_CRGO_DESC","C_FROM_PRT","C_TO_PRT"};//policyApp input
    public static final String[]  REMOTE_PRP_PARA_HR =
    {"C_NET_ID","PA18_NET_ID","CRE_PLYAPP_NO","TRAN_TYPE",
    "C_PLY_APP_NO"};//proposale find

    public static final String  XMLMETHOD_STATUS_HR = "SEND_STATUS_INTERFACE.SEND_STATUS_INTERFACE";
    public static final String  XMLMETHOD_POLICY_HR = "SEND_POLICY_INTERFACE.SEND_POLICY_INTERFACE";

    public static final String  XMLCONTENT_STATUS_HR = "SEND_STATUS_INTERFACE";
    public static final String  XMLCONTENT_POLICY_HR = "SEND_POLICY_INTERFACE";

    public static final String  XMLKEY_STATUS_HR = "PA";
    public static final String  XMLKEY_POLICY_HR = "CRE";
    //public static final String  XMLURL_HR = "https://www.chinaresources.com/ai/insurance/JSPHub.jsp";
    public static final String  XMLURL_HR = "https://sittwww.chinaresources.com/ai/insurance/JSPHub.jsp";
//for site cde constant
    public static final String  PA_SITE_CDE = "001";
    public static final String  HR_SITE_CDE = "002";

	public static final int GET_RPTTELNUM = 36;
}
