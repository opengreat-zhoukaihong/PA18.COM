/*mcipServer.java This file that used to initialize infrastructure that
include corba orb initialize connectionpool initialize and so on. Also the
corba serviced are initialized here that used waiting for income request.
*/
import com.mcip.bus.orb.*;
import com.mcip.cus.orb.*;
import com.mcip.nia.orb.*;
import com.mcip.cdt.orb.*;
import com.mcip.orb.*;
import java.sql.*;
import org.omg.CORBA.*;
import utility.*;
import exceptions.*;
import constant.*;

public class mcipServer_static{

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

            staticInfoManager smanager =
                        new staticInfoManagerImpl("smanager",r_poolManager);
            boa.obj_is_ready(smanager);
            System.out.println("Object <smanager:staticinfoManager> implementation ready");

            boa.impl_is_ready();
	    
        }catch (Exception e){
	    System.err.println(e);
       	}
    }
}
