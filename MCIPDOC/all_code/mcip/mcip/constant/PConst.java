///////////////////////////////////////////////////////////////////////
// Author£ºKang Jin
// Function:   for payment manager
// Create date 2001-4-23
// Update Date:2001-4-23
///////////////////////////////////////////////////////////////////////
package constant;
public interface PConst{
	public static final int ACCEPT_PAYMENT_LOG = 1;//write payment log
	public static final int GET_PAYMENT_LOG_LIST = 2;//query the local pay log list
	public static final int QUERY_LAST_PAYMENT = 3;//query the last payment info
	public static final int QUERY_PAYMENT_LIST= 4;//query the payment list info
	public static final int QUERY_PAYMENT_LOG = 5;//query the payment log list
	public static final int UPDATE_PAY_FLAG = 6;//update the payment result to the policy net
	public static final int UPDATE_PAY_LOG = 7;//update the payment result
	public static final int GET_DPT_PAY_LIST = 8;//get bill list for  branches
	public static final int GET_BANK_PAY_LIST = 9;//get bill list for bank
}
