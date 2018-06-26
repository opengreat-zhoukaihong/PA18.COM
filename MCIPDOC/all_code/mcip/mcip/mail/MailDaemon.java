////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Mail Daemon
// Create Date:2000/10/05
////////////////////////////////////////////////////////
// Change Log
//    ZhanYB  2000/10/20  Add mail log processing
//    ZhanYB  2000/11/09  Add Comment for javadoc
//    cidy: update mail content for more detail to users on 02/01/2001
////////////////////////////////////////////////////////

package mail;

import java.lang.Thread;
import utility.*;
import constant.*;

/**
 * This class is a Mail Daemon used to send mail
 * according with the return list of mailCorbaServer
 * So it is also a mailCorba Client.
 * <p>
 * <HR>
 * How to Run it
 * <ul>
 * <li> First run the mailCorbaServer by type :vbj mailCorbaServer cmd in the main dir of pgm
 * <li> Then run MailDaemon by type: java mail.MailDaemon in above dir
 * <li> The Mail Daemon will fall into sleep after it check,send and update mail each times
 * <li> Admin can set parm in mail.properties
 * </ul>
 * <p>
 * <HR>
 * About mail.properties
 * <ul>
 * <li> smtpserver=192.168.10.52  (smtp server address)
 * <li> smtpserver_user=mcip   (smtp server valid user)
 * <li> smtpserver_pass=mcipmcip  (smtp server pass for above user)
 * <li> admin_email=mcip@pa18.com (sender email address)
 * <li> admin_name=cidy&cary  (sender alias)
 * <li> sleeping_hours=1  (mail daemon check frequency)
 * <li> send_xml_flag=true  (if sending xml)
 * <li> mail_log=true  (if writing log in mail daemon processing)
 * </ul>
 * MailDaemon must be restarted after changing mail.properties file
 *
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 */


public class MailDaemon implements Runnable{

    private static volatile MailDaemon maildaemon;
    private Thread mailthread;
    public  boolean isMailThreadInited;
    private static boolean isMailDaemonInited;
    private boolean RunningFlag;
    private static String  mdSmtpHost="";
    private static String  mdSmtpHost_user="";
    private static String  mdSmtpHost_pass="";
    private static String  mdAdmin_Email="";
    private static long    mdSleeping_Time=0;
    private static boolean mdSend_Xml_Flag=false;
    private static boolean mdMail_Log=false;

////////////////////////////////////////////////////////
// Constructor
// Update: 2000/10/05
////////////////////////////////////////////////////////

    public MailDaemon(){
        super();
        init();
    }

////////////////////////////////////////////////////////
// Error Handling for mail daemon
// Update: 2000/10/05
////////////////////////////////////////////////////////

  /**
   * Error Handling for MailDaemon
   * @param    String errmsg
   * @return   void
   */

   private void ErrorHandling(String errmsg){
        WriteMailLog(MailConstant.LOGERROR,errmsg);
        System.out.println(errmsg);
        System.exit (1);
   }

  /**
   * Error Handling for MailDaemon
   * @param    Exception e
   * @return   void
   */

   private void ErrorHandling(Exception e){
        WriteMailLog(MailConstant.LOGERROR,e.toString ());
        System.out.println(e.toString());
        System.exit (1);
   }

////////////////////////////////////////////////////////
// Write Log
// Update: 2000/10/20
////////////////////////////////////////////////////////

  /**
   * Write MailDaemon info log
   * @param    String Severity
   * @param    String Content
   * @return   void
   */

   private static void WriteMailLog(String Severity,String Content){
       exceptions.LogWriter lw=new exceptions.LogWriter(MailConstant.LOGPATH,MailConstant.LOGFILENAME,
							MailConstant.LOGFILTER,Severity);
       if (mdMail_Log) lw.Writelog(Content);
   }

////////////////////////////////////////////////////////
// Init: get smtp host and other parm from property file
// Update: 2000/09/05
////////////////////////////////////////////////////////

  /**
   * Initialize maildaemon by read parm from property file
   * @return   void
   */

   public void init(){
       System.out.println("Mail Daemon initializing ...");
       WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon initializing ...");

       java.io.InputStream inputstream = getClass().getResourceAsStream("mail.properties");
       java.util.Properties properties = new java.util.Properties();
       try{
           properties.load(inputstream);

       }catch(Exception e){
           System.out.println("Read mail.properties file error:"+e.toString ());
           ErrorHandling(e);
       }

// get smtp server address
       String s = properties.getProperty("smtpserver");
       if(s== null){
           ErrorHandling("Can't not read smtpserver address from properties file");
       }
       mdSmtpHost=s;

// get smtp server user
       s = properties.getProperty("smtpserver_user");
       if(s== null){
           ErrorHandling("Can't not read smtpserver user from properties file");
       }
       mdSmtpHost_user=s;

// get smtp server password
       s = properties.getProperty("smtpserver_pass");
       if(s== null){
           ErrorHandling("Can't not read smtpserver password from properties file");
       }
       mdSmtpHost_pass=s;

// get admin's email address
       s = properties.getProperty("admin_email");
       if (!ChkEmailAddr(s)){
           ErrorHandling("Invalid admin_email address from properties file:"+s);
       }
       mdAdmin_Email = s;
// get mail daemon sleeping hour,if less than 0 hours,default is one hours
       s = properties.getProperty("sleeping_seconds");
       long sleeping_seconds=0;
       try{
	   sleeping_seconds=Long.parseLong(s);
	   mdSleeping_Time=sleeping_seconds*1000;
       }catch(Exception e){
	   mdSleeping_Time=MailConstant.MAILDAEMON_SLEEPTIME;
       }
       if (sleeping_seconds<=0) mdSleeping_Time=MailConstant.MAILDAEMON_SLEEPTIME;

// get xml send flag
       s = properties.getProperty("send_xml_flag");
       if (s.equalsIgnoreCase("true"))
           mdSend_Xml_Flag=true;

// get mail log flag
       s = properties.getProperty("mail_log");
       if (s.equalsIgnoreCase("true"))
           mdMail_Log=true;
   }

////////////////////////////////////////////////////////
// Get/Set status
// Update: 2000/10/05
////////////////////////////////////////////////////////

  /**
   * Get the status of MailDaemon
   * @return   boolean
   */

    public boolean isRunning()    {
        return RunningFlag;
    }


////////////////////////////////////////////////////////
// Checking  email address
// Update: 2000/10/17
////////////////////////////////////////////////////////

  /**
   * Check if input mail format is valid
   * @param    String emailaddr
   * @return   boolean
   */

   public static boolean ChkEmailAddr(String emailaddr) {
       boolean result=true;
       if ((emailaddr.indexOf ('.')==-1) ||
	   (emailaddr.indexOf ('@')==-1)){
	   result= false;
       }
       return result;
   }


////////////////////////////////////////////////////////
// Calling Method
// Update: 2000/10/05
////////////////////////////////////////////////////////

  /**
   * Start MailDaemon
   * @return   MailDaemon Class
   */

    public static MailDaemon getMailDaemon()    {
        if (MailDaemon.isMailDaemonInited){
	    return maildaemon;
        }
        maildaemon = new MailDaemon();
        maildaemon.isMailDaemonInited = true;
        return maildaemon;
    }

  /**
   * Get MailDaemon main thread
   * @return   Thread
   */

    public java.lang.Thread getMailThread()    {
        return mailthread;
    }

  /**
   * Init MailDaemon main thread
   * @return   void
   */

    public void initMailThread()    {
        mailthread = new Thread(maildaemon);
        RunningFlag=true;
        mailthread.start();
        isMailThreadInited = true;
    }

  /**
   * if MailDaemon Inited
   * @return   boolean
   */

    public static boolean isMailDaemonInit()    {
        return maildaemon.isMailDaemonInited;
    }

  /**
   * if MailDaemon main thread Inited
   * @return   boolean
   */

    public boolean isMailThreadInit()    {
        return isMailThreadInited;
    }

////////////////////////////////////////////////////////
// Run
// Update: 2000/10/05
////////////////////////////////////////////////////////
  /**
   * the main part of MailDaemon thread
   * @return   void
   */

    public void run()  {
        while(true){
	    try {
		System.out.println("Mail Daemon begin checking t_pa18_user on:"+ConnectDB.GetCurrentTS(1)+"...");
		WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon begin checking t_pa18_user ...");
		
		CheckMail(MailConstant.APPLICATION_ACCEPT_MAILCDE);
		System.out.println("Mail Daemon end checking t_pa18_user on:"+ConnectDB.GetCurrentTS(1)+"...");
		WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon end checking t_pa18_user ...");
		
		System.out.println("Mail Daemon begin checking t_proposal on:"+ConnectDB.GetCurrentTS(1)+"...");
		WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon begin checking t_proposal ...");
		
		CheckMail(MailConstant.PROPOSAL_SEND_MAILCDE);
		System.out.println("Mail Daemon end checking t_proposal on:"+ConnectDB.GetCurrentTS(1)+"...");
		WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon end checking t_proposal ...");
		

		System.out.println("Mail Daemon going to sleep on:"+ConnectDB.GetCurrentTS(1)+"...");
		WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon going to sleep...");
		Thread.sleep(mdSleeping_Time);
		String wkt=ConnectDB.GetCurrentTS(1);
		System.out.println("Mail Daemon wake up on:"+wkt+"...");
		WriteMailLog(MailConstant.LOGNORMAL,wkt);
		
	    }catch(InterruptedException ex){
		WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon InterruptedExceptioned ..."+ex.toString ());
		RunningFlag=false;
	    }catch(Exception ex){
		RunningFlag=false;
		ErrorHandling(ex);
	    }
        }
    }

////////////////////////////////////////////////////////
// Check Mail logic
// Update: 2000/10/05
////////////////////////////////////////////////////////

  /**
   * Check Mail logic
   * @parm     String CheckTypeCode
   * @return   void
   */

    public void CheckMail(String TypeCode) {

        try{
//Bind Corba Object
            org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
	    com.mcip.mail.orb.EmailManager emanager =
		com.mcip.mail.orb.EmailManagerHelper.bind(orb, "emanager");

//Get Mail List through Corba
            String[][] ml = emanager.GetMailList(TypeCode);
            int mlCounter=ml.length;
            WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon Get Mail List total: "+(mlCounter-1)+" ...");

//Debug Code
System.out.println("Return Await Mail List");
utility.ConnectDB.dispArray(ml);
//End Debug

//Loop Sending Mail
            int sendCounter=0;
            String MailStatus[]=new String[mlCounter];
            String s="";

            if (TypeCode.equalsIgnoreCase(MailConstant.APPLICATION_ACCEPT_MAILCDE)){
///////////
//Control 1
///////////

//MailList[][0]:a.c_user_id
//MailList[][1]:a.c_clnt_cde
//MailList[][2]:a.c_email_flag
//MailList[][3]:b.c_clnt_nme
//MailList[][4]:b.c_email

	    loop:   for (int i=1;i<mlCounter;i++){
		String clnt_name="";
		clnt_name=ml[i][3];
		String mail_content=clnt_name+" 先生/女士:\n\n"+MailConstant.APPLICATION_ACCEPT_CONTENT;
		s=ml[i][4];
		if (!ChkEmailAddr(s)){
		    System.out.println("Invald receiver address from data base:"+i+"-"+s);
		    MailStatus[i]=MailConstant.MAIL_INVALID;
		    WriteMailLog(MailConstant.LOGWARN,"Invald receiver address from data base: "+i+"-"+s);
		}else{
		    try{
			SendMail sm= new SendMail(mdAdmin_Email,     //Sender
						  s,                                      //Receiver
						  MailConstant.APPLICATION_ACCEPT_SUBJECT,//Subject
						  mail_content,//MailConstant.APPLICATION_ACCEPT_CONTENT,//Content
						  mdSmtpHost,                             //Smtp Server address
						  mdSmtpHost_user,                        //Smtp Server user
						  mdSmtpHost_pass);                       //Smtp Server password
			sm.Send ();
			MailStatus[i]=MailConstant.MAIL_SENDED;
			sendCounter++;
			System.out.println("The No. "+i+" mail to:"+s);
			WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon send out  No. "+i+" mail to:"+s);
			//Add error serivity control
		    }catch (Exception e) {
			MailStatus[i]=MailConstant.MAIL_UNSENDED;
			System.out.println("Error Sending No."+i+" mail to "+s+" for:"+e.toString ());
			WriteMailLog(MailConstant.LOGWARN,"Error Sending No."+i+" mail to "+s+" for:"+e.toString ());
			continue loop;
		    }//end of catch
		}//end of else
	    }//end of for
	    
            }else{
///////////
//Control 2
///////////
//MailList[][0]:c_ply_app_no
//MailList[][1]:c_site_cde
//MailList[][2]:c_send_flag
//MailList[][3]:c_contact_name
//MailList[][4]:c_contact_email
//MailList[][5]:c_crgo_name

	    loop2:  for (int i=1;i<mlCounter;i++){
		String clnt_name="";
		clnt_name=ml[i][3];
		String plyapp_no="";
		plyapp_no=ml[i][0];
		String crgo_name="";
		crgo_name=ml[i][5];
		String mail_content=clnt_name+" 先生/女士:\n\n您的:"+plyapp_no+"号运送"+crgo_name+MailConstant.PROPOSAL_SEND_CONTENT;
		String sitecode=ml[i][1];
		if ((mdSend_Xml_Flag)&&(sitecode.equals(MailConstant.XML_SITECODE))){
//Sending out XML processing
                       
		    if (beans.XMLSend.XmlStatus(ml[i][0])!=0){
			System.out.println("Send XML error:"+i+"-"+ml[i][0]);
			WriteMailLog(MailConstant.LOGWARN,"Send XML error:"+i+"-"+ml[i][0]);
			MailStatus[i]=MailConstant.MAIL_INVALID;
			continue loop2;
		    }else{
			System.out.println("Send XML Successfully:"+i+"-"+ml[i][0]);
			WriteMailLog(MailConstant.LOGNORMAL,"Send XML Successfully:"+i+"-"+ml[i][0]);
		    }
		}

		s=ml[i][4];
		if (!ChkEmailAddr(s)){
		    System.out.println("Invald receiver address from data base:"+i+"-"+s);
		    MailStatus[i]=MailConstant.MAIL_INVALID;
		    WriteMailLog(MailConstant.LOGWARN,"Invald receiver address from data base: "+i+"-"+s);
		}else{
		    try{
			SendMail sm= new SendMail(mdAdmin_Email,     //Sender
						  s,                                      //Receiver
						  MailConstant.PROPOSAL_SEND_SUBJECT,     //Subject
						  mail_content,//MailConstant.PROPOSAL_SEND_CONTENT,     //Content
						  mdSmtpHost,                             //Smtp Server address
						  mdSmtpHost_user,                        //Smtp Server user
						  mdSmtpHost_pass);                       //Smtp Server password
			sm.Send ();
			MailStatus[i]=MailConstant.MAIL_SENDED;
			sendCounter++;
			System.out.println("The No. "+i+" mail to:"+s);
			WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon send out  No. "+i+" mail to:"+s);
			//Add error serivity control
		    }catch (Exception e) {
			MailStatus[i]=MailConstant.MAIL_UNSENDED;
			System.out.println("Error Sending No."+i+" mail to "+s+" for:"+e.toString ());
			WriteMailLog(MailConstant.LOGWARN,"Error Sending No."+i+" mail to "+s+" for:"+e.toString ());
			continue loop2;
		    }//end of catch
		}//end of else
	    }//end of for

            }//end of else


//Generate the new mail list which have sended out
            if (sendCounter<=0){
                System.out.println("No valid email address found and no email sended out ...");
                WriteMailLog(MailConstant.LOGWARN ,"No valid email address found and no email sended out ...");
                return;
            }
            String[] newml=new String[sendCounter];
            for (int i=1,j=0;i<mlCounter;i++){
                if (MailStatus[i].equals(MailConstant.MAIL_SENDED)){
		    newml[j]=ml[i][0];
		    j++;
                }
            }

//Debug Code Begin
	    System.out.println("Sended Out Mail List need to Update");
	    utility.ConnectDB.dispArray(newml);
//Debug Code End

//Update the email flag

	    emanager.SetMailFlag (TypeCode,newml);
	    WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon Set Mail Send out Flag total: "+newml.length+" ...");
	    
        }catch (com.mcip.orb.CoException e) {
            ErrorHandling("CORBAR Exception:" +
			  "\nMessagee Code:"+e.errCode+
			  "\nMessagee Desc:"+e.errDescription+
			  "\nError in:"+e.errFieldName+
			  "\nError severity:"+e.severity);
        }catch (Exception e){
            ErrorHandling(e);
        }
    }


////////////////////////////////////////////////////////
// Main Method
// Update: 2000/10/13
////////////////////////////////////////////////////////

  /**
   * MailDaemon Main Method
   * @parm     String[] args
   * @return   void
   */

    public static void main(String[] args) {
	try{
	    MailDaemon md=MailDaemon.getMailDaemon();
	    WriteMailLog(MailConstant.LOGNORMAL,"Mail Daemon Start ...");
	    Thread mdtd=new Thread(md);//set the service as thread by cidy
	    mdtd.setDaemon(true);//set the thread as daemon to keep the thread always alive by cidy
	    mdtd.run();
	}catch (Exception e){
	    String errmsg="Mail Daemon Main Method error:  "+e.toString ();
	    WriteMailLog(MailConstant.LOGERROR,errmsg);
	    System.out.println(errmsg);
	}
    }
}
