////////////////////////////////////////////////////////
// Author: zhanyb
// Usage:  Send out Mail
// Create: 2000/09/05
// Update: 2000/10/13
////////////////////////////////////////////////////////
// Change Log
//    ZhanYB  2000/11/09  Add Comment for javadoc
////////////////////////////////////////////////////////

package mail;

import javax.mail.*;
import javax.mail.internet.*;
import exceptions.*;

/**
 * This class is a common routine used to send email
 * which called by MailDaemon
 *
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 */

public class SendMail {
   private String smSmtpHost;               //smtp server address
   private String smSmtpHostUser;            //smtp server user
   private String smSmtpHostPass;           //smtp server password
   private String smFrom;                   //Sender email address
   private String smTo;                     //Receiver email address
   private String smSubject="";             //subject of email
   private String smContent="";             //content of email
   private int smReturnCode=
           MailConstant.MAILDAEMON_ERROR;   //return code
   private int smSendCount=0;               //counter for sender


////////////////////////////////////////////////////////
// Constructor
// Update: 2000/09/05
////////////////////////////////////////////////////////
//default constructor
   public SendMail() {
       super();
   }

//Fully input
  /**
   * @param                  sFrom
   * @param                  sTo
   * @param                  sSubject
   * @param                  sContent
   * @param                  sSmtpHost
   * @param                  sSmtpHostUser
   * @param                  sSmtpHostPass
   */

   public SendMail(String sFrom,String sTo,String sSubject,
       String sContent,String sSmtpHost,
       String sSmtpHostUser,String sSmtpHostPass){
       this.smFrom=sFrom;
       this.smTo=sTo;
       this.smSubject=sSubject;
       this.smContent=sContent;
       this.smSmtpHost=sSmtpHost;
       this.smSmtpHostUser=sSmtpHostUser;
       this.smSmtpHostPass=sSmtpHostPass;
   }

////////////////////////////////////////////////////////
// Accessor
// Update: 2000/10/05
////////////////////////////////////////////////////////

  /**
   * Get the return code of SendMail common routine
   * @return                 int
   */

   public int GetReturnCode() {
       return smReturnCode;
   }


  /**
   * Get the return Send Counter of SendMail common routine
   * @return                 int
   */

   public int GetSendCount() {
       return smSendCount;
   }

////////////////////////////////////////////////////////
// Error Handling for java send mail
// Update: 2000/10/05
////////////////////////////////////////////////////////

  /**
   * Error Handling for Send out mail common routine
   * @return                 void
   */

   private void ErrorHandling(){
        System.exit (1);
   }

  /**
   * Error Handling for Send out mail common routine
   * @param                  Exception e
   * @return                 void
   */


   private void ErrorHandling(Exception e){
        e.printStackTrace ();
        System.exit (1);
   }


////////////////////////////////////////////////////////
// Send mail
// Update: 2000/09/05
////////////////////////////////////////////////////////

  /**
   * Sending out mail main processing
   * @return               void
   * @exception            MessagingException
   * @exception            java.io.UnsupportedEncodingException
   */

   public void Send() throws MessagingException,java.io.UnsupportedEncodingException{
System.out.println("-------------------------");
System.out.println("Begin send:"+smSendCount);
System.out.println("1.From:"+smFrom);
System.out.println("2.To:"+smTo);
System.out.println("3.Subject:"+smSubject);
System.out.println("4.Content:"+smContent);
System.out.println("5.Smtp:"+smSmtpHost);
// Check input
      if ((smFrom==null) || (smFrom.length()==0) ||
          (smTo==null) || (smTo.length()==0) ||
          (smSmtpHost==null) || (smSmtpHost.length()==0)){
           System.out.println("Null value input when sending email"+
               smSmtpHost+'\n'+
               "FromAddress:"+smFrom +'\n'+
               "ToAddress"+smTo);
           ErrorHandling();
      }


// Start a session
System.out.println("Start a session");
      java.util.Properties properties = System.getProperties();
      Session session = Session.getInstance(properties, null);

// Construct a message
System.out.println("Construct a message");
      MimeMessage message = new MimeMessage(session);

      message.setFrom(new InternetAddress(smFrom));
      message.addRecipient(Message.RecipientType.TO,new InternetAddress(smTo));

      message.setSubject(smSubject,"GB2312");
      message.setText(smContent,"GB2312");

// Connect to the transport
System.out.println("Connect to the transport");
      Transport transport = session.getTransport("smtp");
      transport.connect(smSmtpHost, smSmtpHostUser, smSmtpHostPass);

// Send the message and close the connection
System.out.println("transport sendMessage");
      transport.sendMessage(message, message.getAllRecipients());
System.out.println("transport close");
      transport.close();
System.out.println("End send:"+smSendCount);
System.out.println("-------------------------");
      smSendCount++;
      smReturnCode=MailConstant.MAILDAEMON_SUCCESS;
   }

////////////////////////////////////////////////////////
// Debug Code
// Update: 2000/09/05
////////////////////////////////////////////////////////

  /**
   * Debug code: main method
   * @parm               String[] args
   * @return             void
   */

    public static void main(String[] args) {
       try{
           SendMail sm= new SendMail("mcip@pa18.com","mcip@pa18.com","Subject","Content","192.168.10.52","mcip","mcipmcip");
           sm.Send ();
           System.out.println("Return Code:"+sm.GetReturnCode());
           System.out.println("Return Counter:"+sm.GetSendCount());
       }catch (Exception e){
           System.out.println("Return error msg:"+e.toString ());
       }
    }
}


