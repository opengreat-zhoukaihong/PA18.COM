////////////////////////////////////////////////////////
// Change by:ZhanYB
// Function:   Common data function
// Used Class:
// Update Date:2000/7/20
////////////////////////////////////////////////////////
// Updated by YiJF for Customer management with PA18.com CORBA connection on Dec 10.2000
// Updated by YiJF for Payment Result Info Querying with PA18.com CORBA connection on Feb 23.2001

package utility;

import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ORBManager {

    protected static org.omg.CORBA.ORB _orb_for_client = null;
    protected static org.omg.CORBA.ORB _orb_for_server = null;
    protected static org.omg.CORBA.ORB _orb_for_customer_manage = null;
    protected static org.omg.CORBA.ORB _orb_for_payment_result = null;

    public ORBManager() {}

    public static org.omg.CORBA.ORB getORBForClient() {
        if (_orb_for_client == null) {
             String[] args = null;

             _orb_for_client = org.omg.CORBA.ORB.init(args, ORBManager.getProperties("ORBForClientConfig.prop"));
        }
        return _orb_for_client;
    }

    public static org.omg.CORBA.ORB getORBForServer() {
        if (_orb_for_server == null) {
             String[] args = null;
             _orb_for_server = org.omg.CORBA.ORB.init(args, ORBManager.getProperties("ORBForServerConfig.prop"));
        }
        return _orb_for_server;
    }

    public static org.omg.CORBA.ORB getORBForCustomerManage() {
        if (_orb_for_customer_manage == null) {
             String[] args = null;
             _orb_for_customer_manage = org.omg.CORBA.ORB.init(args, ORBManager.getProperties("ORBForPsB2BConfig.prop"));
        }
        return _orb_for_customer_manage;
    }

    public static org.omg.CORBA.ORB getORBForPaymentResult() {
        if (_orb_for_payment_result == null) {
             String[] args = null;
             _orb_for_payment_result = org.omg.CORBA.ORB.init(args, ORBManager.getProperties("ORBForBsInfoConfig.prop"));
        }
        return _orb_for_payment_result;
    }

    private static Properties getProperties(String propertiesFile) {
        Properties props = null;
        try{
            FileInputStream in = new FileInputStream(propertiesFile);
            props = new Properties();
            props.load(in);
        }catch(FileNotFoundException fe){
            //exHandler.handle(fe, this.getClass().getName(), "EnquiryBean");
            //throw new Exception("ORBconfig.prop not found.  Enquiry bean is not initialized.");
            throw new RuntimeException(propertiesFile + " not found.  ORB init failed.");
        }catch(IOException ie){
            //exHandler.handle(ie, this.getClass().getName(), "EnquiryBean");
            //throw new Exception("IO exception.  Enquiry bean is not initialized.");
            throw new RuntimeException("IO exception.  ORB init failed.");
        }

        //System.out.println(props.toString());
        return props;
    }
}
