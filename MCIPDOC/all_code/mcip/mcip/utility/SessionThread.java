////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Funciton: Global session manager buffer
// Create date£º2000/08/10
// UPdate date£º2000/08/10
////////////////////////////////////////////////////////
package utility;

import java.lang.*;
import constant.*;

public class SessionThread implements Runnable
{
    public boolean isInited;
    private static boolean isSessionThreadInited = false;
    private static volatile SessionThread sessionthread;
    private Thread st;

    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
    
    private boolean willstop=false;
    private boolean hasstop=false;
    
    public SessionThread() 
    {
        super();
    }
    
    public boolean isHasStop() 
    {
        return hasstop;
    }
    
    public boolean isWillStop() 
    {
        return willstop;
    }
    
    public void setWillstop(boolean newWillstop) 
    {
        willstop = newWillstop;
    }
    
    public static SessionThread getSessionThread() 
    {
        if (SessionThread.isSessionThreadInited) 
        {
             return sessionthread;
        }
        sessionthread = new SessionThread();
        SessionThread.isSessionThreadInited = true;
        return sessionthread;
    }
    
    public java.lang.Thread getSt() 
    {
        return st;
    }
    
    public void initSt() 
    {

        sessionbuffer.initSb(); // Added by Clark 
        st = new Thread(sessionthread);
        st.start();
        isInited = true;
        
	willstop=false;
	hasstop=false;
    }
    
    public static boolean isObjectExist() 
    {
        return SessionThread.isSessionThreadInited;
    }
    
    public boolean isObjectInit() 
    {
        return isInited;
    }
    
    public void run()
    {
        while (!willstop)
        {
            try
            {
                Thread.sleep(Const.SLEEPTIME);
            }
            catch(InterruptedException ex) 
            {
                hasstop = true;
            }

            sessionbuffer.ProcessSession(Const.SESSOVERTIME,"");    // Check session timeout
        }
        hasstop = true;
    }
    
    public static void setObjectExist(boolean existflag) 
    {
        SessionThread.isSessionThreadInited=existflag;
    }
    
}
