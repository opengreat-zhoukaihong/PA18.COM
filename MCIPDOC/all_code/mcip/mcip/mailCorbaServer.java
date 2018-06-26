////////////////////////////////////////////////////////
// Author: zhanyb
// Usage:  mail corba server connect with mail daemon on
//         web server site and oracle db server
// Create: 2000/10/13
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb: 
//     cidy: 23/11/2000 add two connection pools
////////////////////////////////////////////////////////

import com.mcip.mail.orb.*;
import com.mcip.orb.*;
import java.sql.*;
import org.omg.CORBA.*;
import utility.*;
import exceptions.*;
import constant.*;

public class mailCorbaServer{

    public static void main(String[] args) {
        try{
            org.omg.CORBA.ORB orb = ORBManager.getORBForServer();
            System.out.println("Initialize the ORB...");

	    BOA boa = ((com.visigenic.vbroker.orb.ORB)orb).BOA_init();
            System.out.println("Initialize the BOA...");

            MessageReader.getInstance();
            System.out.println("Initialize the Message Reader...");

	    //local pool
	    PoolManager l_poolManager = PoolManager.getInstance(Constant.LOCAL_POOL);
	    System.out.println("Initialize the local ConnectionPool...");

	    //back end pool
	    PoolManager r_poolManager = PoolManager.getInstance(Constant.BACKEND_POOL);
	    System.out.println("Initialize the backend ConnectionPool...");

	    EmailManager emanager =
		new EmailManagerImpl("emanager",l_poolManager,r_poolManager);
	    boa.obj_is_ready(emanager);
	    System.out.println("Object <Email Manager:emmanager> implementation ready");
	    
	    boa.impl_is_ready();
	    
        }catch (Exception e){
	    System.err.println(e);
       	}
    }
}
