////////////////////////////////////////////////////////
// Changed by: ZhanYB
// Function:   Provide interface to databse and application server
// Used Class: ConnectionPool, LogWrite
// Update Date:2000/7/20
// Updated by cidy Long for two connection pool connnections
// Last updated date: 22/11/2000
////////////////////////////////////////////////////////
package utility;

import java.io.*;
import java.sql.*;
import java.util.*;
import constant.*;

public class PoolManager
{
    //    static PoolManager instance;
////////////////////////////////////////////////////////
//Create Drivers and Pools for multiple connection
////////////////////////////////////////////////////////

    private static PoolManager instanceLocal,instanceRemote;
    private static int clients;
    private LogWriter logWriter;
    private PrintWriter pw;
    private Vector drivers;
    public Hashtable pools;

    /*    private PoolManager()
    {
        drivers = new Vector();
        pools = new Hashtable();
        init();
	}*/

    private PoolManager(String whichpool)
    {
        drivers = new Vector();
        pools = new Hashtable();
        init(whichpool);
    }

////////////////////////////////////////////////////////
// Add a connection
////////////////////////////////////////////////////////
    public static synchronized PoolManager getInstance(String whichpool)
    {

      if (whichpool.equals(Constant.LOCAL_POOL)){
        if (instanceLocal == null)
            instanceLocal = new PoolManager(whichpool);
        clients++;
        return instanceLocal;
      }

      if (whichpool.equals(Constant.BACKEND_POOL)){
        if (instanceRemote == null)
            instanceRemote = new PoolManager(whichpool);
        clients++;
        return instanceRemote;
      }
      return null;
    }


////////////////////////////////////////////////////////
//1:Load all jdbc and connection parm from properties file
//2:Init the logwriter
//3.Call loadDrivers to loads and registers all JDBC drivers
//4.Call createPools to create connectionpool object and put into hashtable
////////////////////////////////////////////////////////
    private void init(String whichpool){
        pw = new PrintWriter(System.err, true);
        logWriter = new LogWriter("PoolManager", 2, pw);
	java.io.InputStream inputstream=null;
	//System.out.println("befor get property file;");
	if (whichpool.equals(Constant.LOCAL_POOL)){  //for local db connection
	    inputstream = getClass().getResourceAsStream("/db.properties");
	    //System.out.println("local db property file loaded");
	}
	if (whichpool.equals(Constant.BACKEND_POOL)){  //backend db connection situation
	    inputstream = getClass().getResourceAsStream("/backenddb.properties");
	    //System.out.println("backend db property file loaded");
	}
        Properties properties = new Properties();

        try{
            properties.load(inputstream);
	    //System.out.println("load property passed.");
        }
        catch(Exception _ex){
	    System.out.println("load property exception occured.");
            logWriter.log("Can't read the properties file. Make sure db.properties is in the CLASSPATH", 1);
            return;
        }

        String s = properties.getProperty("logfile");
        if(s != null)
            try
            {
                pw = new PrintWriter(new FileWriter(s, true), true);
                logWriter.setPrintWriter(pw);
            }
            catch(IOException _ex)
            {
                logWriter.log("Can't open the log file: " + s + ". Using System.err instead", 1);
            }
        loadDrivers(properties);
        createPools(properties);
    }

////////////////////////////////////////////////////////
//Register Dirver and add one driver in driver array
////////////////////////////////////////////////////////

    private void loadDrivers(Properties properties)
    {
        String s = properties.getProperty("drivers");
        for(StringTokenizer stringtokenizer = new StringTokenizer(s); stringtokenizer.hasMoreElements();)
        {
            String s1 = stringtokenizer.nextToken().trim();
            try
            {
                Driver driver = (Driver)Class.forName(s1).newInstance();
                DriverManager.registerDriver(driver);
                drivers.addElement(driver);
                logWriter.log("Registered JDBC driver " + s1, 2);
            }
            catch(Exception exception)
            {
                logWriter.log(exception, "Can't register JDBC driver: " + s1, 1);
            }
        }
    }

////////////////////////////////////////////////////////
// Create connection according to jdbc parm from ijput properties
// put new pool into the hash table
// s1:connection name -"test"
// s2:url name        -"jdbc:oracle:thin:@oracle8i:1521:paonline"
// s3:user name       -system
// s4:user name       -manager
// s5:max connection  -10
// s6:init connection -10
// s7:login timeout   -10
// s8:log level       -
////////////////////////////////////////////////////////
    private void createPools(Properties properties)
    {
        for(Enumeration enumeration = properties.propertyNames(); enumeration.hasMoreElements();)
        {
            String s = (String)enumeration.nextElement();
            if(s.endsWith(".url"))
            {
                String s1 = s.substring(0, s.lastIndexOf("."));
                String s2 = properties.getProperty(s1 + ".url");

                if(s2 == null)
                {
                    logWriter.log("No URL specified for " + s1, 1);
                }
                else
                {
                    String s3 = properties.getProperty(s1 + ".user");
                    String s4 = properties.getProperty(s1 + ".password");
                    String s5 = properties.getProperty(s1 + ".maxconns", "0");

                    int i;
                    try
                    {
                        i = Integer.valueOf(s5).intValue();
                    }
                    catch(NumberFormatException _ex)
                    {
                        logWriter.log("Invalid maxconns value " + s5 + " for " + s1, 1);
                        i = 0;
                    }

                    String s6 = properties.getProperty(s1 + ".initconns", "0");
                    int j;
                    try
                    {
                        j = Integer.valueOf(s6).intValue();
                    }
                    catch(NumberFormatException _ex)
                    {
                        logWriter.log("Invalid initconns value " + s6 + " for " + s1, 1);
                        j = 0;
                    }

                    String s7 = properties.getProperty(s1 + ".logintimeout", "5");
                    int k;
                    try
                    {
                        k = Integer.valueOf(s7).intValue();
                    }
                    catch(NumberFormatException _ex)
                    {
                        logWriter.log("Invalid logintimeout value " + s7 + " for " + s1, 1);
                        k = 5;
                    }

                    String s8 = properties.getProperty(s1 + ".loglevel", String.valueOf(1));
                    byte byte0 = 2;
                    if(s8.equalsIgnoreCase("none"))
                        byte0 = 0;
                    else
                    if(s8.equalsIgnoreCase("error"))
                        byte0 = 1;
                    else
                    if(s8.equalsIgnoreCase("debug"))
                        byte0 = 3;
		    ConnectionPool connectionpool = new ConnectionPool(s1, s2, s3, s4, i, j, k, pw, byte0);
                    pools.put(s1, connectionpool);
		}
	    }
	}
    }

////////////////////////////////////////////////////////
//
////////////////////////////////////////////////////////
    public void freeConnection(String s, Connection connection)
    {
        ConnectionPool connectionpool = (ConnectionPool)pools.get(s);
        if(connectionpool != null)
            connectionpool.freeConnection(connection);
    }

////////////////////////////////////////////////////////
// Get a connection
////////////////////////////////////////////////////////
    public Connection getConnection(String s)
    {
        Connection connection = null;
        ConnectionPool connectionpool = (ConnectionPool)pools.get(s);
        if(connectionpool != null)
            try
            {
                connection = connectionpool.getConnection();
            }
            catch(SQLException sqlexception)
            {
            	System.out.println("PoolManager sql error  Clarkrao:"+sqlexception.toString());
                logWriter.log(sqlexception, "Exception getting connection from " + s, 1);
            }
        return connection;
    }


    //add by clarkrao
    public static synchronized PoolManager getInstanceByUser(String user){
    	   if(user.equals("HNVHL")){
    	   	  return instanceLocal;
    	   }else{
    	          return instanceRemote;
    	   } 
    	}

////////////////////////////////////////////////////////
// if still have more than one connection can't release
// if no more connection release all connection in connection pool
//                       deregister all drivers
////////////////////////////////////////////////////////
    public synchronized void release()
    {
        if(--clients != 0)
            return;
        ConnectionPool connectionpool;
        for(Enumeration enumeration = pools.elements(); enumeration.hasMoreElements(); connectionpool.release())
            connectionpool = (ConnectionPool)enumeration.nextElement();

        for(Enumeration enumeration1 = drivers.elements(); enumeration1.hasMoreElements();)
        {
            Driver driver = (Driver)enumeration1.nextElement();
            try
            {
                DriverManager.deregisterDriver(driver);
                logWriter.log("Deregistered JDBC driver " + driver.getClass().getName(), 2);
            }
            catch(SQLException sqlexception)
            {
                logWriter.log(sqlexception, "Couldn't deregister JDBC driver: " + driver.getClass().getName(), 1);
            }
        }
    }
}
