import java.sql.*;
import java.util.*;
import java.io.*;
public class  DBClient
{
	public static final int LOCAL_DB = 0;
	public static final int REMOTE_DB = 1;
	public static boolean isAlive(int _db)
	{
		return DBConnect(_db);
	}

	private static boolean DBConnect(int _db)
	{
		Properties dbProp = null ;
		Driver driver = null;
		Connection conn = null;
		switch (_db)
		{
		case LOCAL_DB:
			try{
				dbProp = new Properties();
				dbProp.load(new FileInputStream("db.properties"));
				String url = dbProp.getProperty("paonline.url");
				String user = dbProp.getProperty("paonline.user");
				String password = dbProp.getProperty("paonline.password");

				System.out.println("url:"+url);
				DriverManager.getConnection(url,user,password);
			}catch(FileNotFoundException e){
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}catch(SQLException e){
				System.out.println(e);
			}

		}
		if (conn != null)
		{
			return true;
		}
		else{
			return false;
		}
	}

	private static Driver loadDrivers(Properties properties)
    {
        String s = properties.getProperty("drivers");
		Driver driver = null;
        for(StringTokenizer stringtokenizer = new StringTokenizer(s); stringtokenizer.hasMoreElements();)
        {
            String s1 = stringtokenizer.nextToken().trim();
            try
            {
                driver = (Driver)Class.forName(s1).newInstance();
            }
            catch(Exception exception)
            {
				System.out.println("Can't load drivers:"+s);
            }
        }
		return driver;
    }
	public static void main(String[] args) 
	{
		System.out.println(DBClient.isAlive(DBClient.LOCAL_DB));
	}
}
