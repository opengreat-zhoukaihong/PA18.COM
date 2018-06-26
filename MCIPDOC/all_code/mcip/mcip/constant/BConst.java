///////////////////////////////////////////////////////////////////////
// Author：Kang Jin
// Function:   for function of Business Manager
// Create date 2000/10/8
// Update Date:2000/10/8
///////////////////////////////////////////////////////////////////////

package constant;
/**
*This class difined the constant for the business management 
*/
public class BConst
{
	/**
	*For BusinessManagerBean,act as operation type
	*/
    public static final int QUERY_PLYDEALLIST = 1;
	public static final int QUERY_SEND_EMP_LIST = 2;
	public static final int ACCEPT_PLY_ASSIGN = 3;
	public static final int ACCEPT_PLY_SENDED = 4;
	public static final int ACCEPT_PLY_FEEDBACK = 5;
	public static final int QUERY_RPT_FLWUPLIST = 6;
	public static final int ACCEPT_RPT_FLWUPEMP = 7;
	public static final int QUERY_EVENT_TYPELIST = 8;
	public static final int QUERY_EVENT_COUNTLIST = 9; 
	public static final int QUERY_GUIDE_LIST = 10;
	public static final int QUERY_GUIDE_INFO = 11;
	public static final int UPDATE_GUIDE_INFO = 12;
	public static final int ACCEPT_GUIDE_INFO = 13;
	public static final int DELETE_GUIDE_INFO = 14;
	public static final int QUERY_CONSULT_LIST = 15;
	public static final int QUERY_CONSULT_INFO = 16;
	public static final int QUERY_FAQ_LIST = 17;
	public static final int QUERY_FAQ_INFO = 18;
	public static final int REPLY_FAQ = 19;
	public static final int DELETE_FAQ = 20;
	public static final int UPDATE_CONSULT_INFO = 21;
	public static final int DELETE_CONSULT_INFO = 22;
	public static final int ACCEPT_CONSULT_INFO = 23;
	public static final int GET_PROPOSAL_STATICS = 24;
	public static final int GET_POLICY_STATICS = 25;
	public static final int GET_CASE_RPT_STATICS = 26;
	public static final int GET_CUST_STATICS = 27;
	public static final int GET_PLYAPP_STATICS = 28;
	public static final int GET_EDR_PLCY_STATICTICS = 29;
	public static final int ACCEPT_CLMDGST = 30;
	public static final int UPDATE_CLMDGST = 31;
	public static final int DELETE_CLMDGST = 32;
	public static final int GET_CHATRIGHT = 36;
  // -------add by ClarkRao --------------------------------
  public static final int ACCEPT_CHAT_RECORD = 33;
  public static final int QUERY_CHAT_RECORD = 34;
 //----------end added by ClarkRao
 public static final int GET_CUST_PLY_SUM = 35;
    public static final String BASE_CURRENCY[][] ={{"01","02","03"},{"人民币","港币","美元"}};
	public static final String CUST_STATUS[][] ={{"0","1","2","3","9"},{"未审核","普通会员","代理人","Open Cover会员","已注销"}};
	public static final String CLAIM_STATUS[][] = {{"0","1","2","3"},{"未申请核赔","已申请核赔","已核赔","已结案"}};
    public static final String CARRIAGE_LIST[][] ={{"B13","B23","B33","B43","B01","B31","B21"},
									{"05","06","07","08","02","01","03"}};
	public static final String INSURANCE_CDE_CNM[][] = {
		{"B01","B02","B13","B23","B33","B43"},
		{"进口货运","出口货运","国内水路","国内铁路","国内公路","国内航空"}
																							};
	/**
	*For PageManagerBean
	*/
	public static final int PAGE_LENGTH = 10;
}
