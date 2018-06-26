////////////////////////////////////////////////////////
// Author:     ZhanYB
// Function:   Used to connect db and perform sql operation
// Used Class: ConnectionPool,PoolManager
// Create Date:2000/08/06
////////////////////////////////////////////////////////
// Change Log
//     Zhanyb: 09/25 Chg getcurrentts() interface
//     Zhanyb: 09/26 Add non-autocommit,rollback interface
//     Zhanyb: 09/27 Add batch update interface
//     Zhanyb: 09/27 Add log interface
//     Zhanyb: 09/30 Change WriteDBLog
//     Zhanyb: 10/10 Add timestamp type for pre statement processing
//     Zhanyb: 11/06 Add comment for javadoc
////////////////////////////////////////////////////////
package utility;

import java.sql.*;
import java.util.*;
import java.net.URL;
import constant.*;
import exceptions.*;
import java.io.*;


/**
 * ConnectDB is used to connect db and perform sql operation
 * <HR>
 * Some important thing must be mentioned,if you want to add a new user case for this.
 * How to perform sql operation<br>
 *     1.executeBatchPrepUpdate<br>
 *     2.executePrepQuery<br>
 *     3.executePrepUpdate<br>
 *     4.executeSQLQuery<br>
 *     5.executeSQLUpdate<br>
 *     6.Add processing in JavaCMain if return multi obj<br>
 * <p>
 * <HR>
 * @author 	  Jeb Zhan
 * @version 	%I%, %G%
 * @since     JDK1.3
 * <HR>
 */

public final class ConnectDB
{

////////////////////////////////////////////////////////
// Constant in this
// Update: 2000/08/01
////////////////////////////////////////////////////////
   private static final int size = 10;
   private CoExceptionHandler exHandler;

////////////////////////////////////////////////////////
// input parm
// Update: 2000/08/01
////////////////////////////////////////////////////////
   private String SqlStmt;
   private int SqlOperation=0;

////////////////////////////////////////////////////////
// output result
// Update: 2000/08/01
////////////////////////////////////////////////////////
   private String[][] ReturnArray=null;
   private int ReturnCode=0;
   private int ReturnRowCnt=0;
   private int ReturnColCnt=0;

////////////////////////////////////////////////////////
// Assessor and matutor
// Update: 2000/08/01
////////////////////////////////////////////////////////
  /**
   * Get counter of query result rows
   * @return                 int
   */

   public  Connection newConnection(String URL,String user, String password)
        throws SQLException
    {   
    	//System.out.println("Create new connection clarkrao");
        Connection connection = null;
        try
            {
             Driver driver = (Driver)Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
             DriverManager.registerDriver(driver);
             }catch(Exception e){ System.out.println("DRVIE;"+e.toString());}
        if(user == null)
            connection = DriverManager.getConnection(URL);
        else
            connection = DriverManager.getConnection(URL, user, password);        
        return connection;
    }
   public int GetRowCnt (){
        return ReturnRowCnt;
   }

  /**
   * Set counter of query result rows
   * @param                  affectedrows
   * @return                 void
   */

   private void SetRowCnt (int affectedrows){
        ReturnRowCnt=affectedrows;
   }

  /**
   * Get counter of query result cols
   * @return                 int
   */

   public int GetColCnt (){
        return ReturnColCnt;
   }

  /**
   * Set counter of query result cols
   * @param                  affectedcols
   * @return                 void
   */

   private void SetColCnt (int affectcols){
        ReturnColCnt=affectcols;
   }

  /**
   * Get query result by 2-dime array
   * @return                 String[][]
   */

   public String[][] GetReturnArray (){
        return ReturnArray;
   }

  /**
   * Get sql operation return code
   * @return                 int
   */

   public int GetReturnCode (){
        return ReturnCode;
   }

  /**
   * Set sql operation return code
   * @param                  rtncode
   * @return                 void
   */

   private void SetReturnCode (int rtncode){
        ReturnCode=rtncode;
   }


////////////////////////////////////////////////////////
// Get specified field from a row;
// Update: 2000/08/01
////////////////////////////////////////////////////////
//Attention : the first row is table haeader
  /**
   * Get the specified item of 2-dime array by index
   * @param                  row
   * @param                  col
   * @param                  Array
   * @return                 String
   */

   public String GetFromArray (int row, int col,String[][] Array){
        return Array[row][col];
   }

  /**
   * Get the specified item of 2-dime array by name
   * @param                  row
   * @param                  fieldname
   * @param                  Array
   * @return                 String
   */

   public String GetFromArray (int row, String fieldname, String[][] Array){
      	for (int j=0;j<(Array[0].length);j++){
      	    if (fieldname.trim().equalsIgnoreCase(Array[0][j].trim()))
   	           return Array[row][j];
      	}
   	   return null;
   }


////////////////////////////////////////////////////////
// Used for return result Handling
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Error Handling for CORBA server side exception
   * @param  String ExceptionCode(the code of exception)
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   private void ErrorHandling(String ExceptionCode)
           throws com.mcip.orb.CoException   {
        this.exHandler.raiseCoException(ExceptionCode,null,"ConnectDB");
   }

  /**
   * Error Handling for CORBA server side exception
   * @param  String ExceptionCode(the code of exception)
   * @param  String ExceptionDesc(the additional description of exception)
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   private void ErrorHandling(String ExceptionCode,String ExceptionDesc)
           throws com.mcip.orb.CoException   {
        this.exHandler.raiseCoException(ExceptionCode,ExceptionDesc,"ConnectDB");
   }

////////////////////////////////////////////////////////
// Perform db operation in current connection
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Constructor
   * @param  conn   database connection
   */

   public ConnectDB (Connection conn)
          throws com.mcip.orb.CoException   {
        if (conn == null){
            ErrorHandling(ExceptionCode.DB_FAILTOCONN);
        }

   }

  /**
   * Constructor
   * @param      conn   database connection
   * @param      String sql statement
   * @param      type   ddl or dml type
   * @exception  com.mcip.orb.CoException
   */


   public ConnectDB (Connection conn, String sqlStatement, int type)
          throws com.mcip.orb.CoException   {

        SqlStmt=sqlStatement;
        SqlOperation=type;
        exHandler = new CoExceptionHandler();
        SetReturnCode(Constant.ConnectDB_Error);
//Add for dubuging
System.out.println("~~~~~~~~Input Sql Statement~~~~~~~~~~");
System.out.println(sqlStatement);
System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//End debug
        if (conn == null){
            ErrorHandling(ExceptionCode.DB_FAILTOCONN);
        }

        if (SqlOperation==Constant.executeSqlQuery)
            executeSQLQuery(conn,SqlStmt);

        if (SqlOperation==Constant.executeSqlUpdate)
            executeSQLUpdate(conn,SqlStmt);

        if (SqlOperation==Constant.executeSqlUpdateNoCommit)
            executeSQLUpdateNoCommit(conn,SqlStmt);

   }

  /**
   * Constructor
   * @param  conn   database connection
   * @param  string sql statement
   * @param  type   ddl or dml type
   * @param  inParameters   Used for prepare sql
   */

   public ConnectDB (Connection conn, String sqlStatement, int type,String[][] inParameters)
          throws com.mcip.orb.CoException   {

        SqlStmt=sqlStatement;
        SqlOperation=type;
        exHandler = new CoExceptionHandler();
        SetReturnCode(Constant.ConnectDB_Error);
//Add for dubuging
System.out.println("______________Input sql_______________");
System.out.println(sqlStatement);
System.out.println("______________Input parm_______________");
System.out.println("I am here,baby!");
System.out.println("____name_______value_______type________");
dispArray(inParameters);
//end debug
        if (conn == null){
            //System.out.println("conndb obj is  null clarkrao");  	 
            ErrorHandling(ExceptionCode.DB_FAILTOCONN);
        }else{
	    //System.out.println("conndb obj is not null clarkrao");
        }

        if (SqlOperation==Constant.executePrepQuery){
	    //System.out.println("prepare state in conndb clarkrao"); 	 
            executePrepQuery(conn,SqlStmt,inParameters);
        }    

        if (SqlOperation==Constant.executePrepUpdate)
            executePrepUpdate(conn,SqlStmt,inParameters);

        if (SqlOperation==Constant.executePrepUpdateNoCommit)
            executePrepUpdateNoCommit(conn,SqlStmt,inParameters);

   }

  /**
   * Constructor
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  type   ddl or dml type
   * @param  inParameters   Used for prepare sql
   */

//Add for batch sql operation
   public ConnectDB (Connection conn, String[] sqlStatement, int type,String[][][] inParameters)
          throws com.mcip.orb.CoException   {

        SqlOperation=type;
        exHandler = new CoExceptionHandler();
        SetReturnCode(Constant.ConnectDB_Error);
//Add for dubuging
System.out.println("______________Input sql_______________");
dispArray(sqlStatement);

System.out.println("______________Input parm_______________");
for (int i=0;i<inParameters.length;i++){
   System.out.println(i);
   System.out.println("____name_______value_______type________");
   dispArray(inParameters[i]);
}
//End debug
        if (conn == null){
            ErrorHandling(ExceptionCode.DB_FAILTOCONN);
        }

        if (SqlOperation==Constant.executeBatchPrepUpdate)
            executeBatchPrepUpdate(conn,sqlStatement,inParameters);

        if (SqlOperation==Constant.executeBatchPrepUpdateNoCommit)
            executeBatchPrepUpdateNoCommit(conn,sqlStatement,inParameters);

   }

////////////////////////////////////////////////////////
// Perform SELECT sql operation
// Update: 2000/08/01
////////////////////////////////////////////////////////
  /**
   * execute SQL query operation
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executeSQLQuery (Connection conn, String sqlStatement)
        throws com.mcip.orb.CoException{

        Statement stmt = null;
        ResultSet rs = null;

        try {
            try {
                stmt = conn.createStatement ();
                rs = stmt.executeQuery(sqlStatement);
                ResultSetMetaData rsmd = rs.getMetaData();
                ReturnColCnt = rsmd.getColumnCount();
                if (rs != null){
                   ReturnArray=setReturnArray(rs);
                }else{
                   ErrorHandling(ExceptionCode.DB_NODATADEFINE);
                }

                if (ReturnArray.length==1) {
                    SetReturnCode(Constant.ConnectDB_SelectNone);
                }

                if (ReturnArray.length==2) {
                    SetReturnCode(Constant.ConnectDB_SelectOne);
                }

                if (ReturnArray.length>2) {
                    SetReturnCode(Constant.ConnectDB_SelectMulti);
                }
            }catch (SQLException e){
                ErrorHandling(ExceptionCode.DB_SQLQUERY_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());

            }finally{
                if (rs != null) rs.close ();
                stmt.close ();
            }
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_SQLQUERY_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch (Exception e){
            ErrorHandling(ExceptionCode.DB_SQLQUERY_ERROR,e.toString ());
        }
        return;
   }

////////////////////////////////////////////////////////
// Perform Update,Insert,Delete sql operation
// Update: 2000/08/01
////////////////////////////////////////////////////////
  /**
   * execute SQL Update operation with auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executeSQLUpdate (Connection conn, String sqlStatement)
        throws com.mcip.orb.CoException{
        executeSQLUpdate (conn,sqlStatement,true);
   }

  /**
   * execute SQL Update operation without auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executeSQLUpdateNoCommit (Connection conn, String sqlStatement)
        throws com.mcip.orb.CoException{
        executeSQLUpdate (conn,sqlStatement,false);
   }

  /**
   * execute SQL Update operation
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  ifcommit if auto commit
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executeSQLUpdate (Connection conn, String sqlStatement,boolean ifcommit)
        throws com.mcip.orb.CoException{
        int rowsAffected = 0;
        Statement stmt = null;

        try {
            try {
                conn.setAutoCommit (false);
                stmt = conn.createStatement ();
                rowsAffected = stmt.executeUpdate(sqlStatement);

                if (ifcommit) conn.commit ();

            }catch (SQLException e){
                conn.rollback ();
                ErrorHandling(ExceptionCode.DB_SQLUPDATE_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
            }finally{
                stmt.close();
            }
            SetReturnCode(Constant.ConnectDB_Success);
            SetRowCnt(rowsAffected);
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_SQLUPDATE_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch (Exception e) {
            ErrorHandling(ExceptionCode.DB_SQLUPDATE_ERROR,e.toString ());
        }
        return;
   }

////////////////////////////////////////////////////////
// Perform prepared select sql operation
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * execute SQL Prepared Query operation
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executePrepQuery(Connection conn,String spStatement, String[][] inParameters)
        throws com.mcip.orb.CoException{
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            try{
                pstmt = conn.prepareStatement(spStatement);
                setStmtInputParameter(pstmt, inParameters);
                rs = pstmt.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                ReturnColCnt = rsmd.getColumnCount();
                if (rs != null){
                    ReturnArray=setReturnArray(rs);
                }else{
                    ErrorHandling(ExceptionCode.DB_NODATADEFINE);
                }

                if (ReturnArray.length==1) {
                    SetReturnCode(Constant.ConnectDB_SelectNone);
                }

                if (ReturnArray.length==2) {
                    SetReturnCode(Constant.ConnectDB_SelectOne);
                }

                if (ReturnArray.length>2) {
                    SetReturnCode(Constant.ConnectDB_SelectMulti);
                }
            }catch (SQLException e){
            	/*try{
            	 Runtime.getRuntime().exec("mcipsv.sh restart");
            	}catch(IOException e2){
            		  e2.printStackTrace();
            		} */
            	
            	 /* if(conn.isClosed()){
            	  	  System.out.println("conn is close in clarkrao");
            	  	  System.out.println("conn user:"+conn.getMetaData().getUserName());
            	  	  System.out.println("conn driver:"+conn.getMetaData().getDriverName());
            	  	  System.out.println("conn url:"+ conn.getMetaData().getURL());              
            	         	}
            	         	else{
            	         	  System.out.println("conn is connected calrkrao");
            	         	  System.out.println("conn is close in clarkrao");
            	  	          System.out.println("conn user:"+conn.getMetaData().getUserName());
            	  	          System.out.println("conn driver:"+conn.getMetaData().getDriverName());
            	  	          System.out.println("conn url:"+ conn.getMetaData().getURL());
            	  	          String URL = conn.getMetaData().getURL();
            	  	          String user = conn.getMetaData().getUserName();
            	  	          String password = user;  
            	  	          try{
            	  	              System.out.println("starting close conn");
            	  	              //conn = null;
            	  	              System.out.println("Start create new db ....");
            	  	              conn =  newConnection(URL,user, password);
            	  	              PoolManager  pManager = PoolManager.getInstanceByUser(user);
            	  	               Enumeration ext= pManager.pools.keys();
            	  	               for ( ; ext.hasMoreElements() ;) {
                                         System.out.println(ext.nextElement());
                                       }
                                      
            	  	              if(user.equals("HNVHL")){
            	  	               pManager.pools.remove("paonline");	
            	  	               pManager.pools.put("paonline",conn);
            	  	              }else{
            	  	               pManager.pools.remove("backend");
            	  	               pManager.pools.put("backend",conn);
            	  	              } 
            	  	              executePrepQuery(conn,spStatement,inParameters);
            	  	              System.out.println("GetReturnCode():"+GetReturnCode());
            	  	                 
            	         	     }catch(SQLException e1){
            	         	     	  System.out.println("eeeeeeeee:");
            	         	     	  e1.printStackTrace();
            	         	         } 	  
            	         	     	}*/
            	/*System.out.println(e.getErrorCode());  
            	System.out.println("GetState:"+ e.getSQLState());
            	System.out.println(e.toString());
            	e.printStackTrace();
            	
                System.out.print("Message--"+e.toString()+
	                       "SQLState--"+e.getSQLState ());
            	ErrorHandling(ExceptionCode.DB_PREQUERY_ERROR, "Message--"+e.toString()+
	                       "SQLState--");*/

                ErrorHandling(ExceptionCode.DB_PREQUERY_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
            }finally{
                if (rs != null) rs.close ();
                pstmt.close ();
            }
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_PREQUERY_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch(Exception e){
            ErrorHandling(ExceptionCode.DB_PREQUERY_ERROR,e.toString());
        }

        return;
   }

////////////////////////////////////////////////////////
// Perform prepared update sql operation
// Update: 2000/08/01
////////////////////////////////////////////////////////
  /**
   * execute SQL Prepared Update with auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executePrepUpdate(Connection conn,String spStatement, String[][] inParameters)
        throws com.mcip.orb.CoException{
        executePrepUpdate (conn,spStatement,inParameters,true);
   }

  /**
   * execute SQL Prepared Update without auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executePrepUpdateNoCommit (Connection conn, String spStatement,String[][] inParameters)
        throws com.mcip.orb.CoException{
        executePrepUpdate (conn,spStatement,inParameters,false);
   }

  /**
   * execute SQL Prepared Update without auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @param  ifcommit if auto commit
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executePrepUpdate(Connection conn,String spStatement, String[][] inParameters, boolean ifcommit)
        throws com.mcip.orb.CoException{

        PreparedStatement pstmt = null;
        int rowsAffected = 0;

        try {
            try {
                conn.setAutoCommit (false);
                pstmt = conn.prepareStatement(spStatement);
                setStmtInputParameter(pstmt, inParameters);
                rowsAffected = pstmt.executeUpdate();
                if (ifcommit) conn.commit ();
            }catch (SQLException e){

                conn.rollback ();
                ErrorHandling(ExceptionCode.DB_PREUPDATE_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
            }finally{

                pstmt.close();
            }
            SetReturnCode(Constant.ConnectDB_Success);
            SetRowCnt(rowsAffected);
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_PREUPDATE_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch (Exception e) {
            ErrorHandling(ExceptionCode.DB_PREUPDATE_ERROR,e.toString ());
        }
        return;
   }

////////////////////////////////////////////////////////
// Perform batch prepared update sql operation
// Update: 2000/09/26
////////////////////////////////////////////////////////
  /**
   * execute SQL Batch Prepared Update with auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */
   public void executeBatchPrepUpdate(Connection conn,String[] spStatement, String[][][] inParameters)
        throws com.mcip.orb.CoException{
        executeBatchPrepUpdate (conn,spStatement,inParameters,true);
   }

  /**
   * execute SQL Batch Prepared Update without auto commit
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executeBatchPrepUpdateNoCommit (Connection conn, String[] spStatement,String[][][] inParameters)
        throws com.mcip.orb.CoException{
        executeBatchPrepUpdate (conn,spStatement,inParameters,false);
   }

  /**
   * execute SQL Batch Prepared Update
   * @param  conn   database connection
   * @param  sqlStatement sql statement array
   * @param  inParameters   Used for prepare sql
   * @param  ifcommit if auto commit
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   public void executeBatchPrepUpdate(Connection conn,String[] spStatement, String[][][] inParameters,boolean ifcommit)
        throws com.mcip.orb.CoException{

        PreparedStatement pstmt = null;
        int rowsAffected = 0;
        int excCount=spStatement.length;

        try {
            try {
                conn.setAutoCommit (false);

                for (int i=0;i<excCount;i++){
                    pstmt = conn.prepareStatement(spStatement[i]);
                    setStmtInputParameter(pstmt, inParameters[i]);
                    rowsAffected = pstmt.executeUpdate();
                    pstmt.close();
                }
                if (ifcommit) conn.commit ();
            }catch (SQLException e){
                conn.rollback ();
                ErrorHandling(ExceptionCode.DB_PREUPDATE_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
            }finally{
                pstmt.close();
            }
            SetReturnCode(Constant.ConnectDB_Success);
            SetRowCnt(rowsAffected);
        }catch (com.mcip.orb.CoException e) {
                throw e;
        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_BATPREUPDATE_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch (Exception e) {
            ErrorHandling(ExceptionCode.DB_BATPREUPDATE_ERROR,e.toString ());
        }
        return;
   }


////////////////////////////////////////////////////////
// Set input paraeter for preparedstatement
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Set parameter of SQL Prepared Operation
   * @param  PreparedStatement prepare sql statement array
   * @param  inParameters   Used for prepare sql
   * @return                 void
   * @exception              com.mcip.orb.CoException
   */

   private void setStmtInputParameter(PreparedStatement pstmt, String[][] inParameters)
        throws com.mcip.orb.CoException{

        int numInParameters = inParameters.length;
        String tempStr = "";

       	try{
            for (int i = 0; i < numInParameters ; i++){
                 String tempFieldName = inParameters[i][0];
                 String tempFieldValue = inParameters[i][1];
                 int tempFieldType = Integer.parseInt(inParameters[i][2]);

                 switch (tempFieldType){
                     case Constant.VARCHAR2_TYPE:
                          pstmt.setString(i+1, tempFieldValue);
                          break;
                     case Constant.DATE_TYPE:
                          java.sql.Date tempDate = DataUtility.instance().stringToSQLDate(tempFieldValue, Constant.SHORT_DATE_FORMAT);
                          pstmt.setDate(i+1, tempDate);
                          break;
                     case Constant.TIME_TYPE:
                          java.sql.Time tempTime = DataUtility.instance().stringToSQLTime(tempFieldValue, Constant.LONG_DATE_FORMAT);
                          pstmt.setTime(i+1, tempTime);
                          break;
                     case Constant.DATETIME_TYPE:
                          java.sql.Timestamp tempDatetime = DataUtility.instance().stringToSQLTimestamp(tempFieldValue, Constant.LONG_DATE_FORMAT);
                          pstmt.setTimestamp(i+1, tempDatetime);
                          break;
                     case Constant.INT_TYPE:
                          pstmt.setInt(i+1, Integer.parseInt(tempFieldValue));
                          break;
                     case Constant.SHORT_TYPE:
                          pstmt.setShort(i+1, Short.parseShort(tempFieldValue));
                          break;
                     case Constant.BIGDECIMAL_TYPE:
                          pstmt.setBigDecimal(i+1, DataUtility.instance().stringToBigDecimal(tempFieldValue));
                          break;
                     default:
                          pstmt.setString(i+1, tempFieldValue);
                          break;
                 }
            }
            return;
        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_PRESETPARM_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch (Exception e){
            ErrorHandling(ExceptionCode.DB_PRESETPARM_ERROR,e.toString ());
        }

   }


////////////////////////////////////////////////////////
// Convert Resultset to Array List
// Update: 2000/08/01
////////////////////////////////////////////////////////

  /**
   * Set SQL query result set to 2-dime array
   * @param  rs   sql query result
   * @return                 String[][]
   * @exception              com.mcip.orb.CoException
   */

   public String[][] setReturnArray(ResultSet rs)
        throws com.mcip.orb.CoException{

        int columnCount=0;
        int rowCount = 0;
        Vector tmpRows = new Vector();
        Vector tmpRow = new Vector();
        String[] row = null;
        String[][] al=null;


       	try{
      	     ResultSetMetaData md = null;
 	     	    md=rs.getMetaData();
 	     	    columnCount=md.getColumnCount();

           // retrieve name of each column
 	     	    for(int i = 1 ; i <= columnCount ; i++) {
 	      	     		tmpRow.addElement(md.getColumnName(i));
 	     	    }
 	      	       tmpRows.addElement(tmpRow);

           // retrieve data
            int k=0;
 	     	    while (rs.next()) {
 	      	     		tmpRow = new Vector();
                String result = null;
 	      	     		for(int i = 1 ; i <= columnCount ; i++) {
                    result = rs.getString(i);
 	         // limitation of CORBA. null cannot be passed through IIOP

                    if (result == null){
 	      	      	     			tmpRow.addElement(new String());
                    }else{
 	      	      	     			tmpRow.addElement(result);
                    }

 	      	     		}

//System.out.println(String.valueOf(k++)+":"+result);
 	      	     		tmpRows.addElement(tmpRow);
 	     	    }

 	         // Convert  Vector to 2-d String Array
 	     	    rowCount = tmpRows.size();
 	     	    al = new String[rowCount][columnCount];

 	     	    int i, j;
 	     	    for(i = 0; i < rowCount; i++) {
 	           		for(j = 0; j < columnCount; j++) {
 	      	     	    al[i][j] = (String) ((Vector)(tmpRows.elementAt(i))).elementAt(j);
 	      	     	}
 	     	    }

        }catch (SQLException e){
            ErrorHandling(ExceptionCode.DB_SETRETARRAY_ERROR, "Message--"+e.getMessage()+
	                       "SQLState--"+e.getSQLState ());
        }catch (Exception e){
            ErrorHandling(ExceptionCode.DB_SETRETARRAY_ERROR,e.toString ());
        }
        SetRowCnt(rowCount);
        SetColCnt(columnCount);
        return al;

   }

////////////////////////////////////////////////////////
// Write Operation Log into DB
// Update: 2000/09/26
////////////////////////////////////////////////////////
  /**
   * Write db log
   * @param  conn           database connection
   * @param  user_id        user id
   * @param  event          event name
   * @param  event_rslt     event result
   * @param  rtn_msg        return message
   * @return                void
   * @exception             com.mcip.orb.CoException
   */

    public void WriteDBLog(Connection conn,String user_id,String event,
        String event_rslt,String rtn_msg)
        throws com.mcip.orb.CoException {
        String[][] inParameters={{"c_user_id",user_id,String.valueOf(Constant.VARCHAR2_TYPE)},
                                 {"c_event",event,String.valueOf(Constant.VARCHAR2_TYPE)},
                                 {"c_event_rslt",event_rslt,String.valueOf(Constant.VARCHAR2_TYPE)},
                                 {"c_rtn_msg",rtn_msg,String.valueOf(Constant.VARCHAR2_TYPE)}};

        String spStatement=Sqlstmt.WRITE_DBLOG;
       	try{
           executePrepUpdate(conn,spStatement, inParameters);
        }catch(com.mcip.orb.CoException e){
            ErrorHandling(ExceptionCode.DB_WRITEDBLOG_ERROR,e.toString ());
        }
    }


////////////////////////////////////////////////////////
// by:  ZhanYB
// Function Perform Get Sysdate Operation
// Update: 2000/09/07
// Input FormatFlag: 1(Long Format)
// Input FormatFlag: 2(Short Format)
// Input FormatFlag: 3(Long Format in Chinese)
// Input FormatFlag: 4(Short Format in Chinese)
////////////////////////////////////////////////////////
  /**
   * Get current timestamp according with different format id
   * @param  iFormatFlag    Datetime Format id
   * @return                String
   * @exception             com.mcip.orb.CoException
   */

    public static String GetCurrentTS(int iFormatFlag) throws com.mcip.orb.CoException {
        CoExceptionHandler exHandler=new CoExceptionHandler();

        String dateFormat="";
        switch (iFormatFlag) {
             case 1:
                  dateFormat=Constant.LONG_DATE_FORMAT;break;
             case 2:
                  dateFormat=Constant.SHORT_DATE_FORMAT ;break;
             case 3:
                  dateFormat=Constant.CLONG_DATE_FORMAT;break;
             case 4:
                  dateFormat=Constant.CSHORT_DATE_FORMAT;break;
             default:
                  exHandler.raiseCoException(ExceptionCode.STATIC_GETTSINPUTERR,"Flag:"+String.valueOf(iFormatFlag),"ConnectDB");

       };

       return DataUtility.GetCurrentTS(dateFormat);
}
/*
        String sqlString="";
        switch (iFormatFlag) {
             case 1:
                  sqlString=Sqlstmt.SELECTHP_LONGTS;break;
             case 2:
                  sqlString=Sqlstmt.SELECTHP_SHORTTS;break;
             case 3:
                  sqlString=Sqlstmt.SELECTHP_CLONGTS;break;
             case 4:
                  sqlString=Sqlstmt.SELECTHP_CSHORTTS;break;
             default:
                  exHandler.raiseCoException(ExceptionCode.STATIC_GETTSINPUTERR,"Flag:"+String.valueOf(iFormatFlag),"ConnectDB");

       };

       PoolManager pm=PoolManager.getInstance();
       Connection conn=pm.getConnection(Constant.DBNAME);
       ConnectDB QueryCurrentTs = new ConnectDB (conn,sqlString,Constant.executeSqlQuery);

      if (QueryCurrentTs.GetReturnCode()!=Constant.ConnectDB_SelectOne)
          exHandler.raiseCoException(ExceptionCode.STATIC_GETTSCONDBERR,"","ConnectDB");

      return QueryCurrentTs.GetReturnArray ()[1][0];

    }                       */
/*
       try{
           String url   = "jdbc:oracle:thin:@10.16.102.1:1521:pty211";
           Class.forName ("oracle.jdbc.driver.OracleDriver");
           Connection conn = DriverManager.getConnection (url, "hnvhl", "hnvhl");

           ConnectDB QueryCurrentTs = new ConnectDB (conn,sqlString,Constant.executeSqlQuery);

       }catch (Exception e){
System.out.println("error3:"+e.toString ());
exHandler.raiseCoException(ExceptionCode.STATIC_GETTSCONDBERR,"","ConnectDB");
           return null;
       }

exHandler.raiseCoException(ExceptionCode.STATIC_GETTSCONDBERR,"","ConnectDB");
System.out.println("error2:"+QueryCurrentTs.GetReturnCode());

           if (QueryCurrentTs.GetReturnCode()!=Constant.ConnectDB_SelectOne){
exHandler.raiseCoException(ExceptionCode.STATIC_GETTSCONDBERR,"","ConnectDB");
System.out.println("error2:"+QueryCurrentTs.GetReturnCode());
           };
           return QueryCurrentTs.GetReturnArray ()[1][0];
*/




////////////////////////////////////////////////////////
// Debug Code
//dispResultSet (ResultSet rs)
//dispArray (String[][] array)
////////////////////////////////////////////////////////

  /**
   * Debug Code:Main Method
   * @param                 String [] args
   * @return                void
   */

   public static void main (String [] args){
 	     	try {
            System.out.println("begin");
          String url   = "jdbc:oracle:thin:@10.16.102.1:1521:pty211";
//            String url   = "jdbc:oracle:thin:@10.2.1.161:1521:mcip";
            Class.forName ("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection (url, "hnvhl", "hnvhl");

//        new ConnectDB(conn).WriteDBLog(conn,"1","1","1","3");
//          System.out.println(GetCurrentTS(1));
// test batch opr
/*          String statement[]=new String[4];
            String parm [][][]=new String[4][3][2];
            statement[0]="insert into test1 values(?,?)";
            statement[1]="insert into test1 values(?,?)";
            statement[2]="insert into test1 values(?,?)";
            statement[3]="insert into test1 values(?,?)";
            String [][] sqlParameters1= {{"1","1_name",String.valueOf(Constant.VARCHAR2_TYPE)},
                                        {"2","2_name",String.valueOf(Constant.VARCHAR2_TYPE)}};
            parm[0]= sqlParameters1;
            String [][] sqlParameters2= {{"a","a_name",String.valueOf(Constant.VARCHAR2_TYPE)},
                                        {"b","b_name",String.valueOf(Constant.VARCHAR2_TYPE)}};
            parm[1]= sqlParameters2;
            String [][] sqlParameters3= {{"A","A_name",String.valueOf(Constant.VARCHAR2_TYPE)},
                                        {"B","B_name",String.valueOf(Constant.VARCHAR2_TYPE)}};
            parm[2]= sqlParameters3;
            String [][] sqlParameters4= {{"x","x_name",String.valueOf(Constant.VARCHAR2_TYPE)},
                                        {"y","y_name",String.valueOf(Constant.VARCHAR2_TYPE)}};
            parm[3]= sqlParameters4;

            ConnectDB conndb = new ConnectDB (conn,statement,Constant.executeBatchPrepUpdate,parm);
*/


/*
	   	      String[][] a=conndb.GetReturnArray ();
            dispArray(a);
*/
/*
            String statement="insert into test values(?)";
            String [][] parm= {{"sys_date","2000-10-09 01:02:03",String.valueOf(Constant.DATETIME_TYPE)}};
            ConnectDB conndb = new ConnectDB (conn,statement,Constant.executePrepUpdate,parm);
*/

          String sqlString[]=new String[3];
          String parm [][][]=new String[3][3][2];
/*
          sqlString[0]="UPDATE t_pa18_user set c_email_flag='1',c_email_sender=?  ";
          sqlString[1]="UPDATE t_pa18_user set c_email_flag='1',c_email_sender=?  ";
          sqlString[2]="UPDATE t_pa18_user set c_email_flag='1',c_email_sender=?  ";
*/

          sqlString[0]="insert into test2 values(sysdate,?)  ";
          sqlString[1]="insert into test2 values(sysdate,?)  ";
          sqlString[2]="insert into test2 values(1,?)  ";

          String [][] subparm1= {{"user_id","1",String.valueOf(Constant.VARCHAR2_TYPE)}};
          parm[0]= subparm1;
          String [][] subparm2= {{"user_id","2",String.valueOf(Constant.VARCHAR2_TYPE)}};
          parm[1]= subparm2;
          String [][] subparm3= {{"user_id","3",String.valueOf(Constant.VARCHAR2_TYPE)}};
          parm[2]= subparm3;


          ConnectDB SetMailFlag= new ConnectDB (conn,sqlString,Constant.executeBatchPrepUpdate,parm);


        }catch(com.mcip.orb.CoException e){
         	  System.err.println("CORBAR Exception:" +
                 "\nMessagee Code:"+e.errCode+
                 "\nMessagee Desc:"+e.errDescription+
                 "\nError in:"+e.errFieldName+
                 "\nError severity:"+e.severity);
        }catch(Exception e){
         	  System.err.println("System Exception:" + e.toString ());
        }

   }

  /**
   * Debug Code:Display conntent of resultset
   * @param                 ResultSet rs
   * @return                void
   * @exception             SQLException
   */

   public static void dispResultSet (ResultSet rs)	throws SQLException 	     {
 	     	int i;

 	     	ResultSetMetaData rsmd = rs.getMetaData ();

 	     	int numCols = rsmd.getColumnCount ();

 	     	for (i=1; i<=numCols; i++) {
 	         		if (i > 1) System.out.print(",");
 	         		System.out.print(rsmd.getColumnLabel(i));
 	      }
 	      System.out.println("");

 	      boolean more = rs.next ();
 	      while (more) {
 	         		for (i=1; i<=numCols; i++) {
 	     	 	     		if (i > 1) System.out.print(",");
 	             		System.out.print(rs.getString(i));
 	         		}
 	         		System.out.println("");
 	         		more = rs.next ();
 	     }
   }

  /**
   * Debug Code:Display conntent of array
   * @param                 String[] array
   * @return                void
   */

   public static void dispArray (String[] array){
  	     String[] tab=array;
  	     int length=tab.length;

         for (int i=0;i <length;i++){
     		     System.out.println(i+":"+tab[i]);

	       }
   }

  /**
   * Debug Code:Display conntent of 2-dime array
   * @param                 String[][] array
   * @return                void
   */

   public static void dispArray (String[][] array){
  	     String[][] a=array;
  	     int tbr=a.length;

	      for (int j=0;j <tbr;j++){
	          String[] tablecolumn = a[j];
	          int tbc=tablecolumn.length;
	          for (int i=0;i<tbc;i++){
		             String str=tablecolumn[i];
        		     System.out.print(str+"\t");
	         }
	         System.out.print("\n");
	     }

   }


}

