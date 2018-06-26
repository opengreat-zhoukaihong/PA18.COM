package beans;
import java.util.*;
public class  MonitorBean
{
	public static final int LOCAL_DB = 0;
	public static final int REMOTE_DB = 1;
	public static final int PSBB2B_CORBA = 2;
	public static final int BSINFO_CORBA = 3;
	public static final int BUSINESS_CORBA = 4;
	public static final int EMAIL_CORBA = 5;
	public static final int PAYMENT_CORBA = 6;
	public static final int POLICY_CORBA = 7;
	public static final int STATIC_CORBA = 8;
	public static final int CUST_CORBA = 9;
	public static final int POLICYAPP_CORBA = 10;
	public static final int POLICYINFO_CORBA = 11;
	public static final int USR_CORBA = 12;
	public static final int C_SOCKET = 13;
	public static final int MAX_OPERATION = 14;
	private Properties result;

	public Object test(int _type)
	{
		String monitorName = "";
		result = new Properties();
		long startTime = new Date().getTime();
		String testResult = "";
		switch (_type)
		{
			case LOCAL_DB:
				monitorName = "本地数据库";
				if (mon.OracleClient.isAlive(mon.OracleClient.LOCAL))
				{
					testResult = "";
				}
				else
				{
					testResult = "Can't link to local db";
				}
				break;
			case REMOTE_DB:
				monitorName = "产险数据库";
				if (mon.OracleClient.isAlive(mon.OracleClient.REMOTE))
				{
					testResult = "";
				}
				else
				{
					testResult = "Can't link to remote db";
				}
				break;

			case PSBB2B_CORBA:
				monitorName = "PA18用户验证";
				testResult = mon.PsB2BClient.isAlive();
				break;
			case BSINFO_CORBA:
				monitorName = "PA18付费查询";
				testResult = mon.BsInfoQueryClient.isAlive();
				break;
			case BUSINESS_CORBA:
				monitorName = "Business CORBA Service";
				testResult = mon.BusinessClient.isAlive();
				break;
			case EMAIL_CORBA:
				monitorName = "Email CORBA Service";
				testResult = mon.EmailClient.isAlive();
				break;
			case PAYMENT_CORBA:
				monitorName = "Payment CORBA Service";
				testResult = mon.PaymentClient.isAlive();
				break;
			case POLICY_CORBA:
				monitorName = "Policy CORBA Service";
				testResult = mon.PolicyClient.isAlive();
				break;
			case STATIC_CORBA:
				monitorName = "Static Information CORBA Service";
				testResult = mon.StaticInfoClient.isAlive();
				break;
			case CUST_CORBA:
				monitorName = "Customer CORBA Service";
				testResult = mon.CustClient.isAlive();
				break;
			case POLICYAPP_CORBA:
				monitorName = "Policy Application CORBA Service";
				testResult = mon.PolicyAppClient.isAlive();
				break;
			case POLICYINFO_CORBA:
				monitorName = "Policy Information CORBA Service";
				testResult = mon.PolicyInfoClient.isAlive();
				break;
			case USR_CORBA:
				monitorName = "User CORBA Service";
				testResult = mon.UserClient.isAlive();
				break;
			case C_SOCKET:
				monitorName = "Backend C Socket Service";
				testResult = mon.JavaCClient.isAlive();
		}
		long endTime = new Date().getTime();
		result.setProperty("resume_time",Long.toString(endTime - startTime));
		result.setProperty("test_result",testResult);
		result.setProperty("operation_type",Integer.toString(_type));
		result.setProperty("monitor_name",monitorName);
		return result;
		//return("This is the message from the MonitorBean.");
	}

	/**for self test*/
	public static void main(String args[]){
		MonitorBean mb = new MonitorBean();
		for (int i=0;i< MAX_OPERATION;i++ )
		{
			System.out.println(mb.test(i));
		}
	}

}
