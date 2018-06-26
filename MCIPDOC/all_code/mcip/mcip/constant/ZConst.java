/*

==================================================================

=== 	 Author£º 			zlx												===

===	 Function£º			For policyManager interface				===

===	 Create date£º		2000/09/10										===

===    Update date:		2000/10/27										===
==================================================================

*/




package constant;


public class ZConst

{

    

    //FOR TABLE COL NUM

    public static final int CUSTORGN_LEN = 34;

    public static final int CUSTPRSN_LEN = 34;

    public static final int CUSTENTITY_LEN = 10;

    public static final int POLICYINFO_LEN = 104;    

    public static final int CASERPTINFO_LEN = 47;    

    //for policymanager interface function:

    

    public static final int ACCEPT_CASERPT = 1;  //"acceptCaseRPT";

    //for usermanager interface function:

    

    public static final int OPERATOR_LOGIN = 1;  //"";

    public static final int QUERY_SYSFUNCLIST = 2;  //"";

    public static final int UPDATE_SYSFUNC = 3;  //"";

    public static final int ACCEPT_SYSFUNC = 4;  //"";

    public static final int ACCEPT_OPERATOR= 5;  //"";

    public static final int UPDATE_OPERATOR= 6;  //"";

    public static final int DELETE_OPERATOR= 7;  //"";

    public static final int QUERY_OPTRINFO= 8;  //"";

    public static final int QUERY_OPTRLIST= 9;  //"";

    public static final int QUERY_AUTHLIST= 10;  //"";

    public static final int ACCEPT_OPTRAUTH= 11;  //"";

    public static final int UPDATE_OPTRAUTH= 12;  //"";

    public static final int DELETE_OPTRAUTH= 13;  //"";

    public static final int QUERY_OPTRDPTLIST =14 ;//original 14



    public static final int QUERY_PAGESLIST= 15;  //original 14"";

    public static final int UPDATE_PAGESINFO= 16;  //original 15"";

    public static final int ACCEPT_PAGESINFO= 17;  //original 16"";

    public static final int QUERY_ABLEDPTLIST= 18;  //""

	 public static final int CHECK_OPTRAUTH = 19;    //""   

	 public static final int QUERY_CUSTENTTLIST= 20;    //""   

	 public static final int QUERY_SAMECUSTLIST= 21;    //""   

	 public static final int ACCEPT_USERVERIFY= 22;    //""   

	 public static final int DELETE_PAGESINFO= 23;    //""   

	 public static final int DELETE_SYSFUNC= 24;    //""   


	//add by zlx 2000/10/30
	 public static final int QUERY_CLNTMAPLIST= 25;    //"queryClntMapList
	 public static final int ACCEPT_CLNTMAPINFO= 26;    // acceptClntMapInfo   

	 public static final int DELETE_CLNTMAPINFO= 27;    // deleteClntMapInfo  

	//add by zlx 2000/12/27
	 public static final int QUERY_SUPPEMAILLIST= 28;  //query

	 public static final int ACCEPT_SUPPEMAIL= 29;   // accept 

	 public static final int UPDATE_SUPPEMAIL= 30;    //  
	 public static final int DELETE_SUPPEMAIL= 31;    //  
//	 public static final int = 2;    //""   
//	 public static final int = 2;    //""   
    //end usermanager interface 

    //for bussinessmanager interface function:

    

    public static final int QUERY_PLYNETLIST = 1;  //"";

    public static final int QUERY_PLYNETINFO = 2;  //"";

    public static final int UPDATE_PRINTINFO = 3;  //"";



	 public static final int QUERY_GUIDELIST= 4;    //add by zlx 2000/10/19""   

	 public static final int QUERY_GUIDEINFO= 5;    //add by zlx 2000/10/19""   

	 public static final int QUERY_FAQLIST= 6;    //add by zlx 2000/10/19""   

	 public static final int QUERY_FAQINFO= 7;    //add by zlx 2000/10/19""   

	 public static final int ACCEPT_FAQINFO= 8;    //add by zlx 2000/10/24""   

	 public static final int QUERY_CONSULTLIST= 9;    //add by zlx 2000/10/25""   
	 public static final int QUERY_CONSULTINFO= 10;    //add by zlx 2000/10/25""   


    public static final int  GET_CUSTPLYAPPLIST= 11;  ////add by zlx 2001/1/3;

//    public static final int  = 3;  //"";

//    public static final int  = 3;  //"";

   //end  bussinessmanager interface function: 

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



    public static final int GET_POLICYAPPLIST = 12;//";getPolicyAppList";;

    public static final int GET_POLICYAPPINFO = 13;//";getPolicyAppInfo";;

    public static final int GET_POLICYLIST = 14;//";getPolicyList";;

    public static final int GET_POLICYINFO = 15;//";getPolicyInfo";;

    public static final int GET_PROPOSALINFO = 16;//";getProposalInfo";;

    public static final int GET_ENDORSEPROPOSALINFO = 17;//";getEndorseProposalInfo";;

    public static final int GET_ENDORSEPOLICYINFO = 18;//";getEndorsePolicyInfo";;

    public static final int GET_CASEREPORT = 19;//";getCaseReport";;

    public static final int GET_APPLICATIONFORMINFO = 20;//";getApplicationFormInfo";;

	  public static final int GET_PLYAPPRDRINFO =21;  //getPlyapprdrInfo

	  public static final int GET_CASERPTLIST=22;  //get

	  public static final int GET_CASECLMLIST=23;  //get

	  public static final int GET_CLAIMLIST=24;  //get

	  public static final int GET_CLMDGSTLIST =25;  //get



    public static final int EXECUTE_OPTRAUTH = 26;

    public static final int QUERY_EVENTTYPELIST = 27;

    public static final int QUERY_EVENTCOUNTLIST = 28;

    public static final int QUERY_SUBDPTLIST = 29;

    public static final int REPPLACEAUTHOPTR = 30;




    public static final int GET_CLAUSELIST = 31; //by zlx ,getClauseList
    public static final int GET_CASERPTINFO = 32; //by zlx ,2000/11/09

	

}

