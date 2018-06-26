/*mcipServer.java This file that used to initialize infrastructure that
include corba orb initialize connectionpool initialize and so on. Also the
corba serviced are initialized here that used waiting for income request.
*/
import com.mcip.pay.orb.*;
import com.mcip.bus.orb.*;
import com.mcip.cus.orb.*;
import com.mcip.nia.orb.*;
import com.mcip.cdt.orb.*;
import com.mcip.mail.orb.*;
import com.mcip.orb.*;
import java.sql.*;
import org.omg.CORBA.*;
import utility.*;
import exceptions.*;
import constant.*;

public class mcipServer{

    public static void main(String[] args) {
        try{

            org.omg.CORBA.ORB orb = ORBManager.getORBForServer();
            System.out.println("Initialize the ORB...");

            BOA boa = ((com.visigenic.vbroker.orb.ORB)orb).BOA_init();
            System.out.println("Initialize the BOA...");

            MessageReader.getInstance();
            System.out.println("Initialize the Message Reader...");

            PoolManager l_poolManager = PoolManager.getInstance(Constant.LOCAL_POOL);
            System.out.println("Initialize the local ConnectionPool...");

            PoolManager r_poolManager = PoolManager.getInstance(Constant.BACKEND_POOL);
            System.out.println("Initialize the backend ConnectionPool...");

	        EmailManager emanager =
				new EmailManagerImpl("emanager",l_poolManager,r_poolManager);
			boa.obj_is_ready(emanager);
	        System.out.println("Object <Email Manager:emmanager> implementation ready");

            staticInfoManager smanager =
                        new staticInfoManagerImpl("smanager",r_poolManager);
            boa.obj_is_ready(smanager);
            System.out.println("Object <smanager:staticinfoManager> implementation ready");

            CustManager cmanager =
                        new CustManagerImpl("cmanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(cmanager);
            System.out.println("Object <cmanager:CustManager> implementation ready");

            PolicyInfoManager pmanager =
                        new PolicyInfoManagerImpl("pmanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(pmanager);
            System.out.println("Object <pmanager:PolicyInfoManager> implementation ready");

            PolicyAppManager amanager =
                        new PolicyAppManagerImpl("amanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(amanager);
            System.out.println("Object <amanager:PolicyAppManager> implementation ready");

            PolicyManager plymanager =
                        new PolicyManagerImpl("plymanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(plymanager);
            System.out.println("Object <plymanager:PolicyManager> implementation ready");

            UserManager usermanager =
                        new UserManagerImpl("usermanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(usermanager);
            System.out.println("Object <usermanager:UserManager> implementation ready");

            BusinessManager businessmanager =
                        new BusinessManagerImpl("businessmanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(businessmanager);
            System.out.println("Object <businessmanager:BusinessManager> implementation ready");

            PaymentManager paymanager =
                        new PaymentManagerImpl("paymanager",r_poolManager,l_poolManager);
            boa.obj_is_ready(paymanager);
            System.out.println("Object <Paymentmanager:PaymentManager> implementation ready");


            boa.impl_is_ready();

        }catch (Exception e){
	    System.err.println(e);
       	}
    }
}
