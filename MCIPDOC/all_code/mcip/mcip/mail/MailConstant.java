////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Mail Constant
// Update Date:2000/7/20
////////////////////////////////////////////////////////
package mail;

public class MailConstant
{
    public static final long MAILDAEMON_SLEEPTIME=1*3600000;   //Hours*1000*3600

    ////////////////////////////////////////////////////////
    // Mail Log Constant
    ////////////////////////////////////////////////////////
    public static final String LOGPATH="/log";       //Mail Log Path
    public static final String LOGFILENAME="MailException";  //Mail Log File Name
    public static final String LOGFILTER="log";     //Mail Log Filter

    public static final String LOGERROR ="Mail_Error  ";   //Mail Log Filter
    public static final String LOGWARN  ="Mail_Warning";   //Mail Log Filter
    public static final String LOGNORMAL="Mail_Normal ";   //Mail Log Filter

    ////////////////////////////////////////////////////////
    // Mail Daemon status code
    ////////////////////////////////////////////////////////

    public static final int MAILDAEMON_ERROR=-1;    //Can't continue for next mail
    public static final int MAILDAEMON_WARNING=-2;  //Ignore Current mail processing,Can continue for next mail
    public static final int MAILDAEMON_SUCCESS=0;   //Succeed in sending out the mail

    ////////////////////////////////////////////////////////
    // Mail status code
    ////////////////////////////////////////////////////////

    public static final String MAIL_INVALID="0";
    public static final String MAIL_SENDED="1";
    public static final String MAIL_UNSENDED="2";

    ////////////////////////////////////////////////////////
    // Mail use case 1
    ////////////////////////////////////////////////////////
/*
    public static final String APPLICATION_ACCEPT_MAILCDE = "0";
    public static final String APPLICATION_ACCEPT_SUBJECT = "Subject";
    public static final String APPLICATION_ACCEPT_CONTENT="Content";
*/

    public static final String APPLICATION_ACCEPT_MAILCDE = "0";
    public static final String APPLICATION_ACCEPT_SUBJECT = "新客户会员申请已批准";
    public static final String APPLICATION_ACCEPT_CONTENT="恭喜，恭喜，您已成为平安货运保险网站的会员啦。\n您可以享受到我们为您提供的多功能客户服务，快来试一试吧。";

    ////////////////////////////////////////////////////////
    // Mail use case 2
    ////////////////////////////////////////////////////////
    public static final String PROPOSAL_SEND_MAILCDE = "1";
    public static final String PROPOSAL_SEND_SUBJECT = "离线客户建议书已发出";
    public static final String PROPOSAL_SEND_CONTENT="货物的投保单我们已经收到。\n我们为您拟定了承保条件，您可以打开建议书阅读。\n您也可以进入我们的网站:http://cargo.pa18.com进行查询。";

    public static final String XML_SITECODE = "002";    
}
