//////////////////////////////////////////////////////////////////////////////
// Author:     YiJinFeng
// Function:   Payment Daemon for Checking the waiting status of Cyber Payment
// Create Date:2001/04/27
//////////////////////////////////////////////////////////////////////////////
// Change Log
//    YiJinFeng  2001/04/27  Add payment status log processing
//////////////////////////////////////////////////////////////////////////////

import java.lang.Thread;
import utility.*;
import constant.*;

/**
 * This class is a Daemon used to checking the waiting status of Payment and update it
 * according with the return list of PaymentServer via PA18 payment gateway
 * So it is also a mcipServer_payment Client.
 * <p>
 * <HR>
 * How to Run it
 * <ul>
 * <li> First run the mcipServer_payment by type :vbj mcipServer_payment cmd in the main dir of pgm
 * <li> Then run PayDaemon by type: java PayDaemon in above dir
 * <li> The Pay Daemon will fall into sleep after it check and update payment status each times
 * <li> Admin can set parm in payment.properties
 * </ul>
 * <p>
 * <HR>
 * About pay.properties
 * <ul>
 * <li> sleeping_seconds=600  (pay daemon check frequency)
 * <li> pay_log=true  (if writing log in pay daemon processing)
 * </ul>
 * PayDaemon must be restarted after changing payment.properties file
 *
 * @author 	  Yi JinFeng
 * @version 	%I%, %G%
 * @since     JDK1.3
 */


public class PayDaemon implements Runnable{

    private static volatile PayDaemon paydaemon;
    private Thread paythread;
    public  boolean isPayThreadInited;
    private static boolean isPayDaemonInited;
    private boolean RunningFlag;
    private static long    pdSleeping_Time=0;
    private static boolean pdPay_Log=false;

////////////////////////////////////////////////////////
// Constructor
// Update: 2001/04/27
////////////////////////////////////////////////////////

    public PayDaemon(){
        super();
        init();
    }

////////////////////////////////////////////////////////
// Error Handling for pay daemon
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Error Handling for PayDaemon
   * @param    String errmsg
   * @return   void
   */

   private void ErrorHandling(String errmsg){
        WritePayLog(PayConstant.LOGERROR,errmsg);
        System.out.println(errmsg);
//        System.exit (1);
   }

  /**
   * Error Handling for PayDaemon
   * @param    Exception e
   * @return   void
   */

   private void ErrorHandling(Exception e){
        WritePayLog(PayConstant.LOGERROR,e.toString ());
        System.out.println(e.toString());
//        System.exit (1);
   }

////////////////////////////////////////////////////////
// Write Log
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Write PayDaemon info log
   * @param    String Severity
   * @param    String Content
   * @return   void
   */

   private static void WritePayLog(String Severity,String Content){
       exceptions.LogWriter lw=new exceptions.LogWriter(PayConstant.LOGPATH,PayConstant.LOGFILENAME,
							PayConstant.LOGFILTER,Severity);
       if (pdPay_Log) lw.Writelog(Content);
   }

////////////////////////////////////////////////////////
// Init: get sleeping seconds parm from property file
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Initialize paydaemon by read parm from property file
   * @return   void
   */

   public void init(){
       System.out.println("Pay Daemon initializing ...");
       WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon initializing ...");

       java.io.InputStream inputstream = getClass().getResourceAsStream("payment.properties");
       java.util.Properties properties = new java.util.Properties();
       try{
           properties.load(inputstream);

       }catch(Exception e){
           System.out.println("Read payment.properties file error:"+e.toString ());
           ErrorHandling(e);
       }

// get pay daemon sleeping hour,if less than 0 hours,default is one hours
       String s = properties.getProperty("sleeping_seconds");
       long sleeping_seconds=0;
       try{
          sleeping_seconds=Long.parseLong(s);
          pdSleeping_Time=sleeping_seconds*1000;
       }catch(Exception e){
          pdSleeping_Time=PayConstant.PAYDAEMON_SLEEPTIME;
       }
       if (sleeping_seconds<=0) pdSleeping_Time=PayConstant.PAYDAEMON_SLEEPTIME;

// get pay log flag
       s = properties.getProperty("pay_log");
       if (s.equalsIgnoreCase("true"))
           pdPay_Log=true;
   }

////////////////////////////////////////////////////////
// Get/Set status
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Get the status of PayDaemon
   * @return   boolean
   */

    public boolean isRunning()    {
        return RunningFlag;
    }


////////////////////////////////////////////////////////
// Checking  pay address
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Check if input pay format is valid
   * @param    String order_no, order_tm,tran_type, pay_amt, user_id
   * @return   boolean
   */

   public static boolean ChkOrderData(String order_no, String order_tm,
   		String tran_type, String pay_amt, String user_id) {
       boolean result=true;
       if ((order_no == null) || (order_no.length()==0) ||
       	   (order_tm == null) || (order_tm.length()==0) ||
       	   (tran_type == null) || (tran_type.length()==0) ||
       	   (pay_amt == null) || (pay_amt.length()==0) ||
       	   (user_id == null) || (user_id.length()==0)){
           result= false;
       }
       return result;
   }


////////////////////////////////////////////////////////
// Calling Method
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Start PayDaemon
   * @return   PayDaemon Class
   */

    public static PayDaemon getPayDaemon()    {
        if (PayDaemon.isPayDaemonInited){
	    return paydaemon;
        }
        paydaemon = new PayDaemon();
        paydaemon.isPayDaemonInited = true;
        return paydaemon;
    }

  /**
   * Get PayDaemon main thread
   * @return   Thread
   */

    public java.lang.Thread getPayThread()    {
        return paythread;
    }

  /**
   * Init PayDaemon main thread
   * @return   void
   */

    public void initPayThread()    {
        paythread = new Thread(paydaemon);
        RunningFlag=true;
        paythread.start();
        isPayThreadInited = true;
    }

  /**
   * if PayDaemon Inited
   * @return   boolean
   */

    public static boolean isPayDaemonInit()    {
        return paydaemon.isPayDaemonInited;
    }

  /**
   * if PayDaemon main thread Inited
   * @return   boolean
   */

    public boolean isPayThreadInit()    {
        return isPayThreadInited;
    }

////////////////////////////////////////////////////////
// Run
// Update: 2001/04/27
////////////////////////////////////////////////////////
  /**
   * the main part of PayDaemon thread
   * @return   void
   */

    public void run()  {
        while(true){
          try {
              System.out.println("Pay Daemon begin checking t_pa18_paylog on:"+ConnectDB.GetCurrentTS(1)+"...");
              WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon begin checking t_pa18_paylog ...");

              CheckPay();
              System.out.println("Pay Daemon end checking t_pa18_user on:"+ConnectDB.GetCurrentTS(1)+"...");
              WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon end checking t_pa18_user ...");

              System.out.println("Pay Daemon going to sleep on:"+ConnectDB.GetCurrentTS(1)+"...");
              WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon going to sleep...");
              Thread.sleep(pdSleeping_Time);
              String wkt=ConnectDB.GetCurrentTS(1);
              System.out.println("Pay Daemon wake up on:"+wkt+"...");
              WritePayLog(PayConstant.LOGNORMAL,wkt);

          }catch(InterruptedException ex){
              WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon InterruptedExceptioned ..."+ex.toString ());
              RunningFlag=false;
          }catch(Exception ex){
              RunningFlag=false;
              ErrorHandling(ex);
	        }
        }
    }

////////////////////////////////////////////////////////
// Check Pay status logic
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * Check Pay status logic
   * @parm     null
   * @return   void
   */

    public void CheckPay() {

        try{
//Bind Corba Object
            org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
            com.mcip.pay.orb.PaymentManager paymanager =
            com.mcip.pay.orb.PaymentManagerHelper.bind(orb, "paymanager");

//Get Pay List through Corba
            String[][] pl = paymanager.getPayStatusList();
            int plCounter=pl.length;
            WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon Get Pay List total: "+(plCounter-1)+" ...");

//Debug Code
System.out.println("Return Await Pay List");
utility.ConnectDB.dispArray(pl);
//End Debug

//Loop Sending Pay
            int sendCounter=0;
            String[] PayStatus=new String[plCounter];

//PayList[][0]:c_pay_log_no
//PayList[][1]:c_trans_id
//PayList[][2]:c_bank_cde
//PayList[][3]:c_bank_cnm
//PayList[][4]:c_bank_accnt
//PayList[][5]:n_got_prm
//PayList[][6]:c_cur_typ
//PayList[][7]:t_pay_tm
//PayList[][8]:c_pay_typ
//PayList[][9]:c_pay_cde
//PayList[][10]:c_order_no
//PayList[][11]:t_order_tm
//PayList[][12]:c_type_id
//PayList[][13]:c_payment_id
//PayList[][14]:c_pay_seq_no
//PayList[][15]:c_status_id
//PayList[][16]:c_user_id

	    loop:   for (int i=1;i<plCounter;i++){
              if (!ChkOrderData(pl[i][10],pl[i][11],pl[i][12],pl[i][5],pl[i][16])){
                System.out.println("Invald payment log data from t_pa18_paylog data base: "+i+" - pay log number: "+pl[i][0]);
                PayStatus[i]=PayConstant.PAY_INVALID;
                WritePayLog(PayConstant.LOGWARN,"Invald payment log data from t_pa18_paylog data base: "+i+"- pay log number: "+pl[i][0]);
		          }else{
                try{
                  String[][] rtn_pay = paymanager.queryLastPayment(pl[i][10], pl[i][12], pl[i][16], pl[i][5], pl[i][11]);
//                    String[][] rtn_pay = paytest(i);
//rtn_pay[0][0]="m_id";
//rtn_pay[0][1]="m_amount";
//rtn_pay[0][2]="m_time";
//rtn_pay[0][3]="m_user";
//rtn_pay[0][4]="m_orderRef";
//rtn_pay[0][5]="m_sequenceNo";
//rtn_pay[0][6]="m_merchantId";
//rtn_pay[0][7]="m_statusId";

//			            pl[i][1] = rtn_pay[1][0];
			            pl[i][15] = rtn_pay[1][7];
			            pl[i][13] = rtn_pay[1][0];
			            pl[i][14] = rtn_pay[1][5];
			            if (rtn_pay[1][7].equals(PayConstant.PAY_SUCC_STS) ||
			                rtn_pay[1][7].equals(PayConstant.PAY_FAIL_STS)){	// status : '101' -- successful, '102' -- fail
         			        PayStatus[i]=PayConstant.PAY_SUCCFAIL;
				              sendCounter++;
			            }else{							// others statust, like '103', '104'...
         			        PayStatus[i]=PayConstant.PAY_UNKNOWN;
			            }
			                System.out.println("The No. "+i+" Pay Log Number:"+pl[i][0]+" Order Number:"+pl[i][10]);
			                WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon Checking No. "+i+" Pay Log Number:"+pl[i][0]+" Order Number:"+pl[i][10]);
			//Add error serivity control
		            }catch (Exception e) {
			            PayStatus[i]=PayConstant.PAY_UNKNOWN;
			            System.out.println("Error, No Reply Or No Record of it on PA18."+i+" Pay Log Number:"+pl[i][0]+" Order Number:"+pl[i][10]+" for:"+e.toString ());
			            WritePayLog(PayConstant.LOGWARN,"Error , No Reply Or No Record of it on PA18."+i+" Pay Log Number:"+pl[i][0]+" Order Number:"+pl[i][10]+" for:"+e.toString ());
			            continue loop;
		            }//end of catch
		          }//end of else
	          }//end of for

//Generate the new pay list which have sended out
            if (sendCounter<=0){
                System.out.println("No valid payment record found and no checking payment status from payment gateway...");
                WritePayLog(PayConstant.LOGWARN ,"No valid payment record found and no checking payment status from payment gateway...");
                return;
            }
            String[][] newpl=new String[sendCounter][17];
            for (int i=1,j=0;i<plCounter;i++){
                if (PayStatus[i].equals(PayConstant.PAY_SUCCFAIL)){
            	    for (int k=0;k<17;k++){
		    	            newpl[j][k]=pl[i][k];
		              }
		              j++;
                }
            }

//Debug Code Begin
	        System.out.println("Sended Out Pay List need to Update");
	        utility.ConnectDB.dispArray(newpl);
//Debug Code End

//Update the epay flag

	        paymanager.setPayFlag(newpl);
	        WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon Set Payment Flag total: "+newpl.length+" ...");

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


    String[][] paytest(int i) {
        String[][] rtn_pay = new String[2][8];
        rtn_pay[0][0]="m_id";
        rtn_pay[0][1]="m_amount";
        rtn_pay[0][2]="m_time";
        rtn_pay[0][3]="m_user";
        rtn_pay[0][4]="m_orderRef";
        rtn_pay[0][5]="m_sequenceNo";
        rtn_pay[0][6]="m_merchantId";
        rtn_pay[0][7]="m_statusId";
        rtn_pay[1][0]="1234567890";
        rtn_pay[1][1]="200.35";
        rtn_pay[1][2]="2001-04-28 15:00:00";
        rtn_pay[1][3]="yijf2001";
        rtn_pay[1][4]="500043214321649";
        rtn_pay[1][5]="123456";
        rtn_pay[1][6]="12345678900987654321";
        if (i%2 == 0){
          rtn_pay[1][7]="102";
        }else{
          rtn_pay[1][7]="103";
        }

        return rtn_pay;
    }

////////////////////////////////////////////////////////
// Main Method
// Update: 2001/04/27
////////////////////////////////////////////////////////

  /**
   * PayDaemon Main Method
   * @parm     String[] args
   * @return   void
   */

    public static void main(String[] args) {
	try{
	    PayDaemon pd=PayDaemon.getPayDaemon();
	    WritePayLog(PayConstant.LOGNORMAL,"Pay Daemon Start ...");
	    Thread pdtd=new Thread(pd);//set the service as thread by yijf
	    pdtd.setDaemon(true);//set the thread as daemon to keep the thread always alive by yijf
	    pdtd.run();
	}catch (Exception e){
	    String errmsg="Pay Daemon Main Method error:  "+e.toString ();
	    WritePayLog(PayConstant.LOGERROR,errmsg);
	    System.out.println(errmsg);
	}
    }
}
