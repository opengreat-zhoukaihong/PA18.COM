////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Funciton: init system(web server application)
// Create date£º2000/08/10
// UPdate date£º2000/08/10
////////////////////////////////////////////////////////

package utility;


import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;
import java.net.*;
import exceptions.*;

public class Init 
{

	synchronized public void Init() 
	{
	}
	public synchronized static boolean initAll() {
		int i;
		try {
			//stop sessionthread
			if (!SessionThread.isObjectExist()) 
			{
				SessionThread st = SessionThread.getSessionThread();
				if (st.isObjectInit())
					st.setWillstop(true);
			}
	
			Thread.sleep(1000);
	
			SessionBuffer.setObjectExist(false);
			SessionThread.setObjectExist(false);
	
			//initSession;
			/*---------------hidden by clark rao
      SessionBuffer sb = SessionBuffer.getSessionBuffer();
			sb.initSb();
			System.out.println("init sessionbuffer if not init");
	    */
			//initSessionThread if not init
			SessionThread st = SessionThread.getSessionThread();
			st.initSt();
			System.out.println("init sessionthread if not init");

			//initMessageReader if not init		
			MessageReader mr = MessageReader.getInstance();	
			System.out.println("init MessageReader if not init");                        
			return true;
		   }
		   catch (Exception e) 
		   {
			return false;
		   }
	}
	public static boolean isInit() 
	{
		if (SessionBuffer.isObjectExist()) 
		{
			SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
			if (!sessionbuffer.isObjectInit())
				return false;
		}
		 else
			return false;
		return true;
	}

}
