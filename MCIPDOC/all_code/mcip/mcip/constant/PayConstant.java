////////////////////////////////////////////////////////
// Author:     Yi JinFeng
// Function:   Pay Constant
// Update Date:2001/04/27
////////////////////////////////////////////////////////
package constant;

public class PayConstant
{
    public static final long PAYDAEMON_SLEEPTIME=1*3600000;   //Hours*1000*3600

    ////////////////////////////////////////////////////////
    // Pay Log Constant
    ////////////////////////////////////////////////////////
    public static final String LOGPATH="/log";       //Pay Log Path
    public static final String LOGFILENAME="PayException";  //Pay Log File Name
    public static final String LOGFILTER="log";     //Pay Log Filter

    public static final String LOGERROR ="Pay_Error  ";   //Pay Log Filter
    public static final String LOGWARN  ="Pay_Warning";   //Pay Log Filter
    public static final String LOGNORMAL="Pay_Normal ";   //Pay Log Filter

    ////////////////////////////////////////////////////////
    // Pay Daemon status code
    ////////////////////////////////////////////////////////

    public static final int PAYDAEMON_ERROR=-1;    //Can't continue for next pay
    public static final int PAYDAEMON_WARNING=-2;  //Ignore Current payment status checking processing,Can continue for next checking
    public static final int PAYDAEMON_SUCCESS=0;   //Succeed in updateing the payment status

    ////////////////////////////////////////////////////////
    // Pay status code
    ////////////////////////////////////////////////////////

    public static final String PAY_INVALID="0";
    public static final String PAY_SUCCFAIL="1";
    public static final String PAY_UNKNOWN="2";

    public static final String PAY_SUCC_STS="101";
    public static final String PAY_FAIL_STS="102";
    public static final String PAY_WAIT_STS="103";
    public static final String PAY_NULL_STS="103";

    public static final String PAY_SUCC_FLG="1";
    public static final String PAY_FAIL_FLG="2";
    public static final String PAY_WAIT_FLG="3";
    public static final String PAY_NULL_FLG="0";
}
