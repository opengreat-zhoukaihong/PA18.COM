////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Funciton: Global session manager buffer
// Create date£º2000/08/10
// UPdate date£º2000/08/10
////////////////////////////////////////////////////////
package utility;

import java.util.*;
import java.lang.*;
import java.io.*;
import constant.*;


public class SessionBuffer
{
 
    ////////////////////////////////////////////////////
    private String sessionId[] = new String[Const.ARRAY_LEN];    // sessionId
    private String userId[] = new String[Const.ARRAY_LEN];       // login Userid
    private long accessTime[] = new long[Const.ARRAY_LEN];       // access time nearst
    private boolean busy[] = new boolean[Const.ARRAY_LEN]; 

    private String clientId[] = new String[Const.ARRAY_LEN];       // Client id
    private String clientType[] = new String[Const.ARRAY_LEN];       // Client id
    private String companyId[] = new String[Const.ARRAY_LEN];       // Client id
    private String clientName[] = new String[Const.ARRAY_LEN];       // Client name
    private String clientFlag[] = new String[Const.ARRAY_LEN];       // Client falg
    private String clientVerifyFlag[] = new String[Const.ARRAY_LEN];       // Client falg    
    private String RemoteUserType[]  = new String[Const.ARRAY_LEN];       // remote use oper tyep    
    private String clientAddInfo[][] = new String[Const.ARRAY_LEN][Const.CLIENT_ADD_LEN];       // ClientAddInfo    
            
    private    boolean                isInited;
    private static boolean isSessionBufferInited = false;
    private static volatile SessionBuffer sessionbuffer;
    private int TotalSes = 0;    // current connectin session num
    private int TotalBusy = 0;   // current connectint number 
    private long CountSessId = 0;
        
    private int MaxUsers = Const.MAX_USERS;
    private int MaxSess = Const.MAX_SESS;
    private int TimeOut = Const.TIMEOUT;
    private int LongTimeOut = Const.LONGTIMEOUT;
 
    private void ClearSession(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        // clear session
        sessionId[i] = Const.INIT_NULL;
        userId[i] = Const.INIT_NULL;
        clientId[i] = Const.INIT_NULL;
        clientType[i] = Const.INIT_NULL;
        companyId[i] = Const.INIT_NULL;
        clientName[i] = Const.INIT_NULL;
        clientFlag[i] = Const.INIT_NULL;
        clientVerifyFlag[i] = Const.INIT_NULL;
        
        accessTime[i] = Const.INIT_ZERO;
        busy[i] = false;
        
        if (TotalSes >0)
        {
            TotalSes--;
        }
    }        
    synchronized public String getNewSessionId()
    {
        CountSessId++;
        if (CountSessId > Const.MAXSESSID)
        {
            CountSessId = Const.MINSESSID;
        }
        
        String TmpSessId = String.valueOf(CountSessId);
        int j = TmpSessId.length();
        for (int i = 0; i < Const.SESSID_LEN - j; i++)
        {
            TmpSessId = "0" + TmpSessId;
        }
        return TmpSessId;
    }
       
    public boolean getBusy(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return false;
        }
        return busy[i];
    }     

    public static SessionBuffer getSessionBuffer() 
    {
        if (SessionBuffer.isSessionBufferInited) 
        {
            return sessionbuffer;
        }
        sessionbuffer = new SessionBuffer();
        SessionBuffer.isSessionBufferInited = true;
        return sessionbuffer;
    }     
     
    public String[] getSessionId() 
    {
        return sessionId;    // return the string[]
    }
   
    public int getTotalSes() 
    {
        return TotalSes;
    }
    
    public int getTotalBusy()
    {
        return TotalBusy;
    }
     
    public String getuserId(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return userId[i];
    }     

    public String getClientId(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return clientId[i];
    }     
    public String[] getClientAddInfo(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return null;
        }
        return clientAddInfo[i];
    }     

    public String getClientType(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return clientType[i];
    }     

    public String getCompanyId(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return companyId[i];
    }     

    public String getClientName(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return clientName[i];
    }     
    public String getClientFlag(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return clientFlag[i];
    }     
    public String getClientVerifyFlag(int i)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return "";
        }
        return clientVerifyFlag[i];
    }     

    public void initSb()
    {
        ProcessSession(Const.SESSBUFINIT,"");
    }    
     
    public static boolean isObjectExist() 
    {
        return SessionBuffer.isSessionBufferInited;
    }     
     
    public boolean isObjectInit() 
    {
        return isInited;
    }        
     
    synchronized public int ProcessSession(int ActionNo,String SessionId)
    {
        switch(ActionNo)
        {
            case Const.SESSBUFINIT:     // init 
            {
                for (int i=0;i<=Const.ARRAY_LEN-1;i++)
                {
                    sessionId[i] = Const.INIT_NULL;
                    userId[i] = Const.INIT_NULL;
                    accessTime[i] = Const.INIT_ZERO;
                    busy[i] = false;
                }
                isInited = true;
                return 0;
            }

            case Const.SESSOVERTIME:    // check overtime
            {
                java.util.Date d = new java.util.Date();
                for (int i=0;i<= Const.ARRAY_LEN - 1; i++)
                {
                     if (sessionId[i].compareTo(Const.INIT_NULL) !=0)
                     {
                         
                         if ( (accessTime[i] + getTimeOut() < d.getTime() && busy[i] == false)
                             ||(accessTime[i] + getLongTimeOut() < d.getTime())
                            )

                         {
 System.out.println("over time:"+d.getTime());
 System.out.println("timeout time:"+getTimeOut());
                              ClearSession(i);
                         }
                     }
                }    // end of for
                return 0;
            }
        
            case Const.SESSNEW:    // new(String SessionId)
            {
                java.util.Date d = new java.util.Date();
                for (int i=0;i<=Const.ARRAY_LEN - 1;i++)
                {
                    if (sessionId[i].compareTo(Const.INIT_NULL) == 0)    // get free space
                    {
                        sessionId[i] = SessionId;
                        accessTime[i] = d.getTime();
                        busy[i] = false;
 
                        TotalSes ++;
System.out.println("login time:"+accessTime[i]);
                        return i; //((new Integer(i)).toString());
                    }
                }
         
                return -1;    // no free space for new connection     
            }
        
            case Const.SESSAUTH:    // confirm(String SessionId)
            {
                if (SessionId == null)
                    return -1;

                java.util.Date d = new java.util.Date();
                for (int i=0;i<= Const.ARRAY_LEN - 1; i++)
                {
                    if (sessionId[i].compareTo(SessionId) == 0)
                    {
                        accessTime[i] = d.getTime();
                        return i;
                    }
                }
            
                return -1;    // this session has already been removed
            }
     
            case Const.SESSDEL:    // del (String SessionId)
            {
                if (SessionId == null)
                    return -1;
                    
                for (int i = 0;i<= Const.ARRAY_LEN - 1; i++)
                {
                    if (sessionId[i].compareTo(SessionId) == 0)
                    {
                        ClearSession(i);
                        return 0;
                    }
                }
                return -1;
            }
 
            default:
            {
                return -1;
            }
        }    // end of switch
    }    // end of the procedure: ProcessSession        

        
    public void setBusy(int i,boolean b)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        
        busy[i] = b;
        
        if (b)
        {
            TotalBusy ++;
        }
        else
        {
            if (TotalBusy>0)
            {
                TotalBusy --;
            }
        }
    }        
        
     
    public static void setObjectExist(boolean existflag) 
    { 
        SessionBuffer.isSessionBufferInited=existflag;
    }
    
      
    public void setUserId(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        userId[i] = s;
    }     

    public void setClientId(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        clientId[i] = s;
    }     
    public void setClientAddInfo(int i,String s[])
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        clientAddInfo[i] = s;
    }     
    public void setClientType(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        clientType[i] = s;
    }     

    public void setCompanyId(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        companyId[i] = s;
    }     

    public void setClientName(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        clientName[i] = s;
    }     
    public void setClientFlag(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        clientFlag[i] = s;
    }     

    public void setClientVerifyFlag(int i,String s)
    {
        if (i < 0 || i > Const.ARRAY_LEN)
        {
            return;
        }
        clientVerifyFlag[i] = s;
    }     
    
    public int getLongTimeOut() 
    {
	return LongTimeOut;
    }
	
    public int getMaxSess() 
    {
	return MaxSess;
    }
	
    public int getMaxUsers() 
    {
	return MaxUsers;
    }
	
    public int getTimeOut() 
    {
	return TimeOut;
    }
   
    public void setLongTimeOut(int newLongTimeOut) 
    {
	LongTimeOut = newLongTimeOut;
    }
	
    public void setMaxSess(int newMaxSess) 
    {
	MaxSess = newMaxSess;
    }
	
    public void setMaxUsers(int newMaxUsers) 
    {
	MaxUsers = newMaxUsers;
    }
	
    public void setTimeOut(int newTimeOut) 
    {
	TimeOut = newTimeOut;
    }

}