////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Email Manager Implement
// Create Date:2000/10/13
////////////////////////////////////////////////////////
//    ZhanYB  2000/11/09  Add Comment for javadoc
//    changed by cidy on 24/11/2000 for two connection pool
//    add function getcustmail
//    updated by cidy add initial function to get smtp server info
//    added three attribute in private for smtp server on 20/12/2000
//    update by cidy on 11/01/2001 for localization connection
////////////////////////////////////////////////////////
import java.sql.*;
import java.util.*;
import utility.*;
import mail.*;
import constant.*;
import exceptions.*;
import org.omg.CORBA.*;
import com.mcip.mail.orb.*;

/**
 * This is a Implement of Corba Server used to
 * connect db server and mail daemon
 *
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 */


public class EmailManagerImpl extends _EmailManagerImplBase {
    private static PoolManager lpm;                //local Pool Manager
    private static PoolManager rpm;                //back end Pool Manager
    private static String ldbname=Constant.DBNAME; //local Database name in properties file
    private static String rdbname=Constant.BACKEND_DBNAME; //backend Database name in properties file
    //private static Connection lconn;               //local Database connection
    //private static Connection rconn;               //back Database connection
    private CoExceptionHandler exHandler;         //Corba Exception Handler
    private static String smtp_server;            //mail server for smtp added by cidy
    private static String smtp_user;              //mail server for smtp user added by cidy
    private static String smtp_passwd;            //mail server password added by cidy

////////////////////////////////////////////////////////
// Constructor
// Last updated :2000-10-13
////////////////////////////////////////////////////////

  /**
   * Error Handling for MailDaemon
   * @param    Exception e
   * @return   void
   */

    private void ErrorHandling(Exception e) throws com.mcip.orb.CoException{
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"EmailManagerImpl get db connection"+e.toString ());
	this.exHandler.raiseCoException(e.toString (),"","",Constant.ERROR);
    }

  /**
   * Error Handling for CORBA server side exception
   * @param  String ExceptionCode(the code of exception)
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

    private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"EmailManagerImpl get db connection");
        this.exHandler.raiseCoException(ExceptionCode,"","",Constant.WARNING);
    }

  /**
   * Error Handling for CORBA server side exception
   * @param  String ExceptionCode(the code of exception)
   * @param  String ExceptionDesc(the desc of exception)
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

    private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"EmailManagerImpl get db connection");
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"",Constant.WARNING);
    }

  /**
   * Write MailDaemon info log
   * @param    String Severity
   * @param    String Content
   * @return   void
   */

   private static void WriteMailLog(String Severity,String Content){
       exceptions.LogWriter lw=new exceptions.LogWriter(MailConstant.LOGPATH,MailConstant.LOGFILENAME,
							MailConstant.LOGFILTER,Severity);
       lw.Writelog(Content);
   }

  /**
   * Constructor
   * @param    String name
   * @param    PoolManager poolManager
   */

    public EmailManagerImpl(String name,PoolManager l_poolManager,PoolManager r_poolManager) throws com.mcip.orb.CoException {
        super(name);
        lpm=l_poolManager;
	rpm=r_poolManager;
        //lconn = lpm.getConnection(ldbname);
	//rconn = rpm.getConnection(rdbname);
//Add connect in debug log
        CoExceptionHandler.WriteLog(LogWriterConst.DEBUG_INFO,"EmailManagerImpl get db connection");
        exHandler = new CoExceptionHandler();
	init();            //added by cidy that used to get smtp server information
    }

    //this function used to get smtp server information that should be used by smtp server
    //added by cidy
    public void init() throws com.mcip.orb.CoException{

	java.io.InputStream inputstream = getClass().getResourceAsStream("mail/mail.properties");
	java.util.Properties properties = new java.util.Properties();

	try{
	    properties.load(inputstream);//load property from inputstream
	}
	catch(Exception e){
	    System.out.println("Read mail.properties file error:"+e.toString ());
	    ErrorHandling(e);
	}
	
	String s = properties.getProperty("smtpserver");// get smtp server address
	if(s== null){
           ErrorHandling("Can't not read smtpserver address from properties file");
	}
	smtp_server=s;

	s = properties.getProperty("smtpserver_user");// get smtp server user
	if(s== null){
	    ErrorHandling("Can't not read smtpserver user from properties file");
	}
	smtp_user=s;

	s = properties.getProperty("smtpserver_pass");// get smtp server password
	if(s== null){
	    ErrorHandling("Can't not read smtpserver password from properties file");
	}
	smtp_passwd=s;
    }

////////////////////////////////////////////////////////
// Error Handling of current Implement
// Last updated :2000-10-13
////////////////////////////////////////////////////////





////////////////////////////////////////////////////////
// Get Mail List from DB
// Last updated :2000-10-13
// Last updated 24/11/2000 for two connection pool by cidy
////////////////////////////////////////////////////////

    /**
     * Get Mail List from DB
     * @param      String TypeCde
     * @return     String[][]
     * @exception  com.mcip.orb.CoException
     */


    public String[][] GetMailList(String TypeCde) throws com.mcip.orb.CoException {
        int MailListLen=0;
        String [][] MailList=null;
        String sqlString="";

        if (TypeCde.equalsIgnoreCase(mail.MailConstant.APPLICATION_ACCEPT_MAILCDE)){
            sqlString =Sqlstmt.SELECT_EMAILFLAG;
	    Connection lconn = lpm.getConnection(ldbname);
	    try{
		ConnectDB QueryMailList= new ConnectDB (lconn,sqlString,Constant.executeSqlQuery);
		MailList=QueryMailList.GetReturnArray();
		MailListLen=MailList.length;
		System.out.println("the proposal mail list length: "+MailListLen);//debug only
	    }catch (Exception e){
		ErrorHandling(ExceptionCode.JM_GETDBMAILLIST_ERROR,e.toString ());
	    }finally{
		lpm.freeConnection (ldbname,lconn);
	    }
        }else{
            sqlString =Sqlstmt.SELECT_PROPOSALEMAIL;
	    Connection rconn = rpm.getConnection(rdbname);
	    try{
		ConnectDB QueryMailList= new ConnectDB (rconn,sqlString,Constant.executeSqlQuery);
		MailList=QueryMailList.GetReturnArray();
		MailListLen=MailList.length;
		System.out.println("the proposal mail list length: "+MailListLen);//debug only
	    }catch (Exception e){
		ErrorHandling(ExceptionCode.JM_GETDBMAILLIST_ERROR,e.toString ());
	    }finally{
		rpm.freeConnection (rdbname,rconn);
	    }
	}	    
        return MailList;
    }

////////////////////////////////////////////////////////
// Set Clnt Mail Flag into DB
// Last updated :2000-10-18
////////////////////////////////////////////////////////

  /**
   * Set Clnt Mail Flag into DB
   * @param      String TypeCde
   * @return     boolean
   * @exception  com.mcip.orb.CoException
   */

    public boolean SetMailFlag(String TypeCde,String[] Key) throws com.mcip.orb.CoException {
        boolean result=false;
        int mlLength=Key.length;
        String sqlStatement="";
        String sqlParmName="";
        String sqlString[]=new String[mlLength];

	PoolManager pm;
	String dbname;
	Connection conn;

        String parm [][][]=new String[mlLength][3][2];

        if (TypeCde.equalsIgnoreCase(mail.MailConstant.APPLICATION_ACCEPT_MAILCDE)){
            sqlStatement=Sqlstmt.UPDATE_EMAILFLAG;
            sqlParmName="c_user_id";
	    pm=lpm;
	    dbname=ldbname;
	    //conn=lconn;
	    conn = pm.getConnection(dbname);
        }else{
            sqlStatement=Sqlstmt.UPDATE_PROPOSALEMAIL;
            sqlParmName="C_PLY_APP_NO";
	    pm=rpm;
	    dbname=rdbname;
	    //conn=rconn;
	    conn = pm.getConnection(dbname);
        }

        for (int i=0;i<mlLength;i++){

           sqlString[i]=sqlStatement;
           String [][] subparm= {{sqlParmName,Key[i],String.valueOf(Constant.VARCHAR2_TYPE)}};
           parm[i]= subparm;
        }

        try{
            System.out.println("Begin Update Mail List Flag");
            ConnectDB.dispArray(Key);
            ConnectDB SetMailFlag= new ConnectDB (conn,sqlString,Constant.executeBatchPrepUpdate,parm);
            System.out.println("End Update Mail List Flag");
            if (SetMailFlag.GetReturnCode()==Constant.ConnectDB_Success){
                result=true;
            }
        }catch (Exception e){
            ErrorHandling(ExceptionCode.JM_UPATEMAILLIST_ERROR,e.toString ());
        }finally{
            pm.freeConnection (dbname,conn);
        }
        return result;
    }

////////////////////////////////////////////////////////
// used to send mail online for real time
// Last updated :20/12/2000 by cidy
////////////////////////////////////////////////////////

    public boolean OnlineMail(Mail inmail) throws com.mcip.orb.CoException {
	/*try{
	    SendMail sm= new SendMail(inmail.sender,     //Sender
				      inmail.receiver,   //Receiver
				      inmail.subject,    //Subject
				      inmail.content,    //Content
				      smtp_server,       //Smtp Server address
				      smtp_user,         //Smtp Server user
				      smtp_passwd);      //Smtp Server password
	    sm.Send ();
	    if (sm.GetReturnCode()==0){
		System.out.println("Online Sending mail to "+inmail.receiver+" for: "+inmail.subject+" Successful");
		WriteMailLog(MailConstant.LOGNORMAL,"Online Sending mail to "+inmail.receiver+" for: "+inmail.subject+" Successful");
		return true;
	    }
	}
	catch (Exception e) {
	    System.out.println("Online Error Sending mail to "+inmail.receiver+" for:"+e.toString ());
	    WriteMailLog(MailConstant.LOGWARN,"Online Error Sending mail to "+inmail.receiver+" for:"+e.toString ());
	    return false;
	}*/
	return false;
    }
}
