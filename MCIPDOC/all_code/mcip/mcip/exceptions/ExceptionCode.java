///////////////////////////////////////////////////////////////////////////////
// Change Log
//     YiJF:   09/21 Add Operator Management module exception for Iteration Two
//     Zhanyb: 09/26 Add Operator Management module exception for Iteration Two
//     Zhanyb: 10/06 Add java main exception
//     YiJF:   10/25 Add Business management exception
//     YiJF:   11/03 Add operator management exception
//     YiJF:   11/08 Add policy info query exception
//     YiJF:   11/13 Add customer login exception
//     YiJF:   04/12 Add payment log exception
///////////////////////////////////////////////////////////////////////////////
package exceptions;

public class ExceptionCode {

    ///////////////////////////////////////////////////////////////////////////////
    //For WEB server:jsp bean,etc by zhanjq
    ///////////////////////////////////////////////////////////////////////////////

    public final static String SYS_INIT_FAILURE =                 "8000" + "00000";
    public final static String SYS_NOT_INIT =                     "8000" + "00001";
    public final static String SYS_SESSION_INIT_FAILURE =         "8000" + "00002";
    public final static String SYS_PARA_ERR =                     "8000" + "00003";
    public final static String NO_CLIENT_INFO =                   "8000" + "00004";
    public final static String SYS_NOT_LOGIN =                    "8000" + "00005";

    ///////////////////////////////////////////////////////////////////////////////
    //For DB control by zhanyb
    ///////////////////////////////////////////////////////////////////////////////

    public final static String DB_GENERAL_ERROR =                 "1000" + "00000";
    public final static String DB_FAILTOCONN =                    "1000" + "00001";
    public final static String DB_FINDNOREC =                     "1000" + "00002";
    public final static String DB_NOTUNIQUEREC =                  "1000" + "00003";
    public final static String DB_NODATADEFINE =                  "1000" + "00004";
    public final static String DB_SQLQUERY_ERROR =                "1000" + "00005";
    public final static String DB_SQLUPDATE_ERROR =               "1000" + "00006";
    public final static String DB_PREQUERY_ERROR =                "1000" + "00007";
    public final static String DB_PREUPDATE_ERROR =               "1000" + "00008";
    public final static String DB_PRESETPARM_ERROR =              "1000" + "00009";
    public final static String DB_SETRETARRAY_ERROR =             "1000" + "00010";
    public final static String DB_BATPREUPDATE_ERROR =            "1000" + "00011";

    ///////////////////////////////////////////////////////////////////////////////
    //For DB log control by zhanyb
    ///////////////////////////////////////////////////////////////////////////////

    public final static String DB_WRITEDBLOG_ERROR =              "1000" + "10001";

    ///////////////////////////////////////////////////////////////////////////////
    //For Java Mail control by zhanyb
    ///////////////////////////////////////////////////////////////////////////////

    public final static String JM_READMAILPROP_ERROR =            "1000" + "30001";
    public final static String JM_READSMTPSERVER_ERROR =          "1000" + "30002";
    public final static String JM_READADMINEMAIL_INVALID =        "1000" + "30003";
    public final static String JM_SENDINPUT_ERROR =               "1000" + "30004";
    public final static String JM_INPUTEMAIL_ERROR =              "1000" + "30005";
    public final static String JM_DBEMAIL_ERROR =                 "1000" + "30006";
    public final static String JM_GETDBMAILLIST_ERROR =           "1000" + "30007";
    public final static String JM_SENDMAILLOOP_ERROR =            "1000" + "30008";
    public final static String JM_UPATEMAILLIST_ERROR =           "1000" + "30009";

    ///////////////////////////////////////////////////////////////////////////////
    //For Java Call C control by zhanyb
    ///////////////////////////////////////////////////////////////////////////////

    public final static String JC_ERROR_CASENO =                  "1001" + "00000";
    public final static String JC_CERRORRETURN =                  "1001" + "00001";
    public final static String JC_ERROR_BODYLEN =                 "1001" + "00002";
    public final static String JC_GETHEADER_FAIL =                "1001" + "00003";
    public final static String JC_FINDFIELD_FAIL =                "1001" + "00004";
    public final static String JC_BUILDCSTYLE_FAIL =              "1001" + "00005";
    public final static String JC_SETINPUTBYTEARRAY_FAIL =        "1001" + "00006";
    public final static String JC_GETSTRARRAY_FAIL =              "1001" + "00007";
    public final static String JC_ERROR_INPUT =                   "1001" + "00008";
    public final static String JC_COMMON_ERROR =                  "1001" + "00009";
    public final static String JC_ERROR_MAPPING =                 "1001" + "00010";
    public final static String JC_GENERAL_ERROR =                 "1001" + "00011";
    public final static String JC_JAVACALLC_ERROR =               "1001" + "00012";
    public final static String JC_GETPKHEADSTRARRAY_FAIL =        "1001" + "00013";
    public final static String JC_BYTETOSTR_ERROR =               "1001" + "00014";
    public final static String JC_CNULLRETURN =                   "1001" + "00015";
    public final static String JC_SETCSTRING_FAIL =               "1001" + "00016";

    ///////////////////////////////////////////////////////////////////////////////
    //For Data Utility control by zhanyb
    ///////////////////////////////////////////////////////////////////////////////

    public final static String DU_INVALIDDATEFMT =                "1005" + "00001";
    public final static String DU_OBJTOARRAY_ERROR=               "1005" + "00002";


    ///////////////////////////////////////////////////////////////////////////////
    //For Static info control by yijf
    ///////////////////////////////////////////////////////////////////////////////

    public final static String STATIC_GETTSINPUTERR =             "1006" + "00001";
    public final static String STATIC_GETTSCONDBERR =             "1006" + "00001";

    ///////////////////////////////////////////////////////////////////////////////
    //For Cust Management control by yijf
    ///////////////////////////////////////////////////////////////////////////////

    public final static String CUST_DUPLICATECLNTID =             "2000" + "00001";
    public final static String CUST_ERRORIDORPW =                 "2000" + "00002";
    public final static String CUST_NOCLNTINFO =                  "2000" + "00003";
// add by YJF 08-18
    public final static String CUST_CLNTAGTCDENULL =              "2000" + "00004";
    public final static String CUST_CLNTCDENOTMATCH =             "2000" + "00005";
    public final static String CUST_AGTCDENOTMATCH =              "2000" + "00006";
    public final static String CUST_CLNTAGTCDEDUPLICATE =         "2000" + "00007";
    public final static String CUST_IDRGSTAGTNOEXIST =            "2000" + "00008";
    public final static String CUST_IDRGSTAGTDUPLICATE =          "2000" + "00009";
    public final static String CUST_NULLQUERYPARM =               "2000" + "00010";
    public final static String CUST_INVALIDQUERYPARM =            "2000" + "00011";
    public final static String CUST_QUERYNOREC =                  "2000" + "00012";
//     YiJF:   11/13 Add customer login exception
    public final static String CUST_MAINACCNOTEXIST =             "2000" + "00013";
    public final static String CUST_MAINACCDUPICATE =             "2000" + "00014";
    public final static String CUST_LOGINREFUSE =                 "2000" + "00015";
    public final static String CUST_INVRF_EXPIRE =                "2000" + "00016";
    public final static String CUST_PWD_UPD_FAIL =                "2000" + "00017";
    public final static String CUST_LOGIN_FAIL =                  "2000" + "00018";
    public final static String CUST_AGT_CLNT_CDE_NOTEXIST =       "2000" + "00019";


    ///////////////////////////////////////////////////////////////////////////////
    //For policy info control by yijf
    ///////////////////////////////////////////////////////////////////////////////

    public final static String NIA_NULLQUERYPARM =                "2001" + "00001";
    public final static String NIA_INVALIDQUERYPARM =             "2001" + "00002";
    public final static String NIA_QUERYNOREC =                   "2001" + "00003";

// add by YJF 08-15
    public final static String NIA_INVCEXIST =                    "2001" + "00004";
    public final static String NIA_APPLYTIMEOUT =                 "2001" + "00005";
    public final static String NIA_UPDATETIMEOUT =                "2001" + "00006";
    public final static String NIA_WITHDRAWALTIMEOUT =            "2001" + "00007";
    public final static String NIA_CONFIRMTIMEOUT =               "2001" + "00008";

// add by YJF 10-24
    public final static String NIA_CRGORATE_NOREC =               "2001" + "00009";
    public final static String NIA_CRGORATEADD_NOREC =            "2001" + "00010";
    public final static String NIA_INVALIDINSRNCCDE =             "2001" + "00011";
    public final static String NIA_INVALIDRDRTYPE =               "2001" + "00012";

// add by YJF 12-26
    public final static String NIA_INVALID_DOC_NO =               "2001" + "00013";
    public final static String NIA_NULL_USER_REMARK =             "2001" + "00014";

// add by YJF 04-12
    public final static String NIA_INVALID_PAYPARM =              "2001" + "00015";
    public final static String NIA_INVALID_PAYFLAG =              "2001" + "00016";


    ///////////////////////////////////////////////////////////////////////////////
    //For Operator info control by yijf
    ///////////////////////////////////////////////////////////////////////////////

//     YiJF: 09-21 Add Operator Management module exception for Iteration Two
    public final static String OPR_DUPLICATEID =                  "3000" + "00001";
    public final static String OPR_ERRORIDORPW =                  "3000" + "00002";
    public final static String OPR_EMPLOYEENOTEXIST =             "3000" + "00003";
    public final static String OPR_INVALIDPARM =                  "3000" + "00004";
    public final static String OPR_INVALIDAUTH =                  "3000" + "00005";
    public final static String OPR_DUPLICATEFUNCCDE =             "3000" + "00006";
    public final static String OPR_DUPLICATEPAGENO =              "3000" + "00007";
    public final static String OPR_INVALIDDPTCDE =                "3000" + "00008";
    public final static String OPR_INVALIDOPREMP =                "3000" + "00009";
    public final static String OPR_INVALIDACTTYP =                "3000" + "00010";
    public final static String OPR_AUTHNULLARRAY =                "3000" + "00011";
    public final static String OPR_NOCLNTCNM =                    "3000" + "00012";
    public final static String OPR_INVALIDVRFYFLG =               "3000" + "00013";
    public final static String OPR_INVALIDAGNT =                  "3000" + "00014";
    public final static String OPR_AGNTNOTEXIST =                 "3000" + "00015";
    public final static String OPR_INVALIDCLNT =                  "3000" + "00016";
    public final static String OPR_CLNTNOTEXIST =                 "3000" + "00017";
    public final static String OPR_OPCVNOTEXIST =                 "3000" + "00018";
    public final static String OPR_INVALIDREPLC =                 "3000" + "00019";
    public final static String OPR_DPTNOTINSCALE =                "3000" + "00020";
    public final static String OPR_AUTHNOTINSCALE =               "3000" + "00021";
    public final static String OPR_INVALIDUSERID =                "3000" + "00022";
    public final static String OPR_INVALIDCLNTCDE =               "3000" + "00023";
    public final static String OPR_INVALIDAGNTCDE =               "3000" + "00024";
    public final static String OPR_INVALIDMAINFLG =               "3000" + "00025";
    public final static String OPR_INVALIDOCAGFLG =               "3000" + "00026";
    public final static String OPR_DUPLICATEREC =                 "3000" + "00027";
    public final static String OPR_DUPLICATEMAINFLG =             "3000" + "00028";
    public final static String OPR_FUNCWITHPAGES =                "3000" + "00029";
    public final static String OPR_INVALID_EMP_MAIL =             "3000" + "00030";
    public final static String OPR_INVALID_EMP_NAME =             "3000" + "00031";
    public final static String OPR_INVALID_ACTION =               "3000" + "00032";


    ///////////////////////////////////////////////////////////////////////////////
    //For Policy Delivery Function Call of Business Management Module by yijf
    ///////////////////////////////////////////////////////////////////////////////

//     YiJF: 10-08 Add  Business Management module exception for Iteration Two

    public final static String BSNS_INVALIDOPRID =                "4000" + "00001";
    public final static String BSNS_INVALIDPRNTFLG =              "4000" + "00002";
    public final static String BSNS_INVALIDPLYNO =                "4000" + "00003";
    public final static String BSNS_INVALIDSENDEMP =              "4000" + "00004";
    public final static String BSNS_INVALIDASSNTM =               "4000" + "00005";
    public final static String BSNS_INVALIDSENDTM =               "4000" + "00006";
    public final static String BSNS_INVALIDFDBKTM =               "4000" + "00007";
    public final static String BSNS_INVALIDDPTCDE =               "4000" + "00008";
    public final static String BSNS_INVALIDDEALTYPE =             "4000" + "00009";
    public final static String BSNS_INVALIDDEALFLAG =             "4000" + "00010";
    public final static String BSNS_INVALIDRPTNO =                "4000" + "00011";
    public final static String BSNS_INVALIDEVENTTYP =             "4000" + "00012";
    public final static String BSNS_INVALIDLOGTIME =              "4000" + "00013";
    public final static String BSNS_INVALIDTTLNO =                "4000" + "00014";
    public final static String BSNS_INVALIDTTLCNM =               "4000" + "00015";
    public final static String BSNS_INVALIDINFONO =               "4000" + "00016";
    public final static String BSNS_INVALIDFAQEMP =               "4000" + "00017";
    public final static String BSNS_INVALIDFAQTITLE =             "4000" + "00018";
    public final static String BSNS_INVALIDFAQPSN =               "4000" + "00019";
    public final static String BSNS_INVALIDFAQEMAIL =             "4000" + "00020";
    public final static String BSNS_INVALIDFAQPTTL =              "4000" + "00021";
    public final static String BSNS_WITHSUBCONTENT =              "4000" + "00022";
    public final static String BSNS_INVALIDDGSTPLYNO =            "4000" + "00023";
    public final static String BSNS_INVALIDDGSTCLMNO =            "4000" + "00024";
    public final static String BSNS_INVALIDDGSTRPTNO =            "4000" + "00025";
    public final static String BSNS_INVALIDPLYCLMRPT =            "4000" + "00026";


    ///////////////////////////////////////////////////////////////////////////////
    //For Policy Payment Log Function Call of Payment Management Module by yijf
    ///////////////////////////////////////////////////////////////////////////////

//     YiJF: 04-18 Add Payment Management module exception for Iteration Two

    public final static String PAY_INVALIDID =                  "5000" + "00001";
    public final static String PAY_INVALIDORDERNO =             "5000" + "00002";
    public final static String PAY_LASTPAYNOTFOUND =            "5000" + "00003";
    public final static String PAY_PAYLISTNOTFOUND =            "5000" + "00004";
    public final static String PAY_PAYLOGNOTFOUND =             "5000" + "00005";





    ///////////////////////////////////////////////////////////////////////////////
    //No use for current system
    ///////////////////////////////////////////////////////////////////////////////


    public final static String GENERAL_SYS_ERROR =                "0000" + "00001";

    public final static String GENERAL_DB_ERROR =                 "0000" + "02000";

    public final static String DB_UNIQUE_KEY_ERROR =              "0000" + "02001";
    public final static String DB_USER_DEFINED_ERROR =            "0000" + "03000";
    public final static String DB_UNKNOWN_ERROR =                 "0000" + "49999";

    public final static String GENERAL_SYSTEM_EXCEPTION =         "0000" + "50000";
    public final static String INI_READ_ERROR =                   "0000" + "50001";
    public final static String INI_VALUE_ERROR =                  "0000" + "50002";
    public final static String INI_ARRAY_ERROR =                  "0000" + "50003";
    public final static String MSG_FILE_READ_ERROR =              "0000" + "50004";

    // General application error
    public final static String CLIENT_NO_ACCESS_RIGHT=            "0000" + "10001";
    public final static String ERR_NO_AGENT_CODE =                "0000" + "10002";
    public final static String ERR_NO_LOGON_ID =                  "0000" + "10003";
    public final static String ERR_NO_USER_TYPE =                 "0000" + "10004";
    public final static String ERR_NO_POL_PROP_NO =               "0000" + "10005";
    public final static String NOT_SUBORDINATE=                   "0000" + "10006";

    // enquiry bean
    public final static String ERR_MISS_AGENT_CD =                "0001" + "00010";
    public final static String ERR_INCOMPLETE_DOB =               "0001" + "00020";
    public final static String ERR_DOB =                          "0001" + "00030";
    public final static String ERR_LOGON_ID =                     "0001" + "00040";
    public final static String ERR_USER_TYPE =                    "0001" + "00050";

    // pending bean
    public final static String ERR_PARSE_RESULT =                 "0001" + "00410";
    public final static String ERR_LAST_UPD_DT =                  "0001" + "00420";
    public final static String ERR_ALL_RPT_SUB =                  "0001" + "00430";
    public final static String ERR_SORT_BY =                      "0001" + "00440";
    public final static String ERR_MVMT_NO =                      "0001" + "00450";
    public final static String ERR_REQ_CD =                       "0001" + "00460";
    public final static String ERR_PROP_POL_NO =                  "0001" + "00470";

    // proposal / policy bean
    public final static String ERR_INV_SUBMIT_DATE_FROM_FORMAT =  "0001" + "00310";
    public final static String ERR_INV_SUBMIT_DATE_TO_FORMAT =    "0001" + "00320";
    public final static String ERR_INV_DATE_RANGE =               "0001" + "00330";
    public final static String ERR_MISS_PROPOSAL_NO =             "0001" + "00340";
    public final static String ERR_MISS_POLICY_NO =               "0001" + "00350";
    public final static String ERR_MISS_VIEW_BY =                 "0001" + "00360";

    // ACL
    public final static String ERR_INVALID_AGENT_CODE =           "0001" + "00501";
    public final static String ERR_GET_SUBO =                     "0001" + "00502";

    // Logon
    public final static String ERR_NOT_FIND_AGENCY_DIVISION =     "0001" + "00601";
    public final static String ERR_SAME_NEW_OLD_PASSWORD =        "0001" + "00602";
    public final static String ERR_DIFF_NEW_CONFIRM_PASSWORD =    "0001" + "00603";
    public final static String ERR_INCORRECT_OLD_PASSWORD =       "0001" + "00604";
    public final static String ERR_CHANGE_PASSWORD_UNSUCCESS =    "0001" + "00605";

    // MyClient
    public final static String ERR_NO_CLIENT_CODE =               "0001" + "00701";
    public final static String ERR_CLIENT_DIFF_COVERAGE =         "0001" + "00702";
    public final static String ERR_CLIENT_RECORD_NOT_FOUND =      "0001" + "00703";
    public final static String ERR_COVERAGE_RECORD_NOT_FOUND =    "0001" + "00704";

    // Rule Manager
    public final static String ERR_INVALID_FORMAT_SURNAME =       "0001" + "00801";
    public final static String ERR_INVALID_FORMAT_FIRSTNAME =     "0001" + "00802";
    public final static String ERR_INVALID_FORMAT_OTHERNAME =     "0001" + "00803";
    public final static String ERR_INVALID_FORMAT_ID_NO =         "0001" + "00804";
    public final static String ERR_INVALID_FORMAT_SEX =           "0001" + "00805";
    public final static String ERR_INVALID_FORMAT_AGENT_CODE =    "0001" + "00806";
    public final static String ERR_INVALID_FORMAT_CLIENT_CODE =   "0001" + "00807";
    public final static String ERR_INVALID_FORMAT_POL_PROP_NO =   "0001" + "00808";
    public final static String ERR_INVALID_FORMAT_DSGN_CODE =     "0001" + "00809";
    public final static String ERR_INVALID_FORMAT_AGENCY_CODE =   "0001" + "00810";
    public final static String ERR_INVALID_FORMAT_DIVISION_CODE = "0001" + "00811";
    public final static String ERR_INVALID_FORMAT_BRANCH_CODE =   "0001" + "00812";
    public final static String ERR_INVALID_FORMAT_UNIT_CODE =     "0001" + "00813";
    public final static String ERR_INVALID_FORMAT_DOB_MONTH =     "0001" + "00814";
    public final static String ERR_INVALID_FORMAT_DOB_YEAR =      "0001" + "00815";
    public final static String ERR_INVALID_FORMAT_PASSWORD =      "0001" + "00816";
    
    //AMS Password
    public final static String ERR_MISS_DATE =                    "00001" + "00817";

    // Agent Production Detail
    public final static String ERR_MISS_PROD_PERIOD_FROM =        "0001" + "00901";
    public final static String ERR_INVALID_PROD_PERIOD_FROM =     "0001" + "00902";
    public final static String ERR_MISS_PROD_PERIOD_TO =          "0001" + "00903";
    public final static String ERR_INVALID_PROD_PERIOD_TO =       "0001" + "00904";
    public final static String ERR_PROD_PERIOD_OUT_RANGE =        "0001" + "00905";
    public final static String ERR_INVALID_PROD_PERIOD_RANGE =    "0001" + "00906";
    public final static String ERR_MISS_PROD_TYPE =               "0001" + "00907";

    // PruFigures
    public final static String ERR_MISS_PROD_PERIOD_MM =          "00001" + "01001";
    public final static String ERR_MISS_PROD_PERIOD_YYYY =        "00001" + "01002";
    public final static String ERR_MISS_QUERY_LEVEL =             "00001" + "01003";
    public final static String ERR_MISS_DISPLAY_BY =              "00001" + "01004";
    public final static String ERR_MISS_UNIT_CODE =               "00001" + "01005";
    public final static String ERR_MISS_ORDER_BY =                "00001" + "01006";



    public ExceptionCode() {

    }
}