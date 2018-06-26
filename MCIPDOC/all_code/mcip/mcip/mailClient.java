/* Client.java. This file is used to pass some string to corba server, and 
get a string[][] back. this return value more like one string table.
 */
import org.omg.CORBA.*;
import com.mcip.mail.orb.*;
import com.mcip.orb.*;
import java.lang.*;
import utility.*;

public class mailClient {
    
    private static Mail inmail=null;
    private static boolean result=false;

    public static void init(){
	Mail omail=new Mail("cidyl@cheerful.com","cidyl@ctil.com","mail test","This is a mail test that from pa18");
	System.out.println("in argues initial");
	inmail=omail;
    }

    public static void main(String[] args) {
	try{
	    long begin=System.currentTimeMillis();
	    org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
	    EmailManager emanager =
		EmailManagerHelper.bind(orb, "emanager");
	    
	    init();
	    long orbtake=System.currentTimeMillis()-begin;
	    System.out.println("Initialise Orb taken "+orbtake+"milliseconds.");
	    System.err.println("begin invoke corba");
	    int times=2;
	    long totaltime=0;
	    long average=0;
	    for(int i=0;i<times;i++){
		long start=System.currentTimeMillis();
		result = emanager.OnlineMail(inmail);
		if (result)
		    System.err.println("mail sending successful");
		else
		    System.err.println("mail sending fail");
		long mailtake=System.currentTimeMillis()-start;
		System.out.println("This mail taken "+mailtake+" milliseconds");
		totaltime=totaltime+mailtake;
	    }
	    average=totaltime/times;
	    System.out.println("Sent "+times+" mails taken "+totaltime+"milliseconds.\nThe average is: "+average+" milliseconds.");
	}
	catch(CoException e){
	    System.err.println("CORBAR Exception:" +
			       "\nMessagee Code:"+e.errCode+
			       "\nMessagee Desc:"+e.errDescription+
			       "\nError in:"+e.errFieldName+
			       "\nError severity:"+e.severity);
	}
	catch (Exception e){
	    e.printStackTrace ();
	}
    }
}
