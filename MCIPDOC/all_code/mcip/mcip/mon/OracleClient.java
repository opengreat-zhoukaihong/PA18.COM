package mon;
import java.util.*;
import java.io.*;
import java.sql.*;
public class OracleClient 
{
	public static final int LOCAL = 0;//indicator for local db
	public static final int REMOTE = 1;//indicator for remote db
	private static String driverName;
	private static final String LOCAL_DB_PROP_FILE="db.properties";
	private static final String REMOTE_DB_PROP_FILE="backenddb.properties";
	
	/** use this method to test if current application can connect to the database(ORACLE)
	* NOTE: this method is simply try to connect the database is successful then return true else false
	*			  You SHOULD NOT expect this method can monit  the existing connection status 
	*/
	public static boolean isAlive(int _db)
	{
		return isConnectable(getDBProperties(_db));
	}

	/** get the properties*/
	private static Properties getDBProperties(int _db){
		Properties p = new Properties();
		try
		{
			switch (_db)
			{
			case LOCAL:
				p.setProperty("prefix","paonline.");
				p.load(new FileInputStream(LOCAL_DB_PROP_FILE));
				break;
			case REMOTE:
				p.setProperty("prefix","backend.");
				p.load(new FileInputStream(REMOTE_DB_PROP_FILE));
				break;
			}
		}
		catch(java.io.IOException e)
		{
			System.out.println("读取数据库配置文件出错!");
		}
		return p;
	}
	
	//establish the connection
	private static boolean isConnectable(Properties _p){
		boolean ret = false;
		String prefix = _p.getProperty("prefix");
		Connection c = null;
		Statement stat = null;
		driverName = _p.getProperty("drivers");
		try
		{
			Class.forName(driverName);
			c = DriverManager.getConnection(_p.getProperty(prefix+"url"),_p.getProperty(prefix+"user"),_p.getProperty(prefix+"password"));
			stat = c.createStatement();
		}
		catch(java.lang.ClassNotFoundException e)
		{
			System.out.println("无法注册JDBC驱动程序:"+driverName);
			return ret;
		}
		catch(java.sql.SQLException e)
		{
			System.out.println("无法建立JDBC连接:"+e);
			return ret;
		}
		finally
		{
			try
			{
				stat.close();
				c.close();
			}
			catch(java.sql.SQLException ex)//do nothing
			{
			}
			catch(Exception ex){
			}
		}
		ret = true;
		return ret;
	}
	public static void main(String[] args) 
	{
		OracleClient o = new OracleClient();
		System.out.println("isAlive:"+o.isAlive(Integer.parseInt(args[0])));
	}
}
