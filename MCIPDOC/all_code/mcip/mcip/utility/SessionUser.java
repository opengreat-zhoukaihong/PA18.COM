////////////////////////////////////////////////////////
// Author£ºZhangJinQuan
// Funciton: Global user session manager buffer
// Create date£º2000/08/10
// UPdate date£º2000/08/10
////////////////////////////////////////////////////////
package utility;

import java.util.*;
import java.lang.*;
import java.io.*;
import constant.*;


public class SessionUser
{
 
    ////////////////////////////////////////////////////
	private static int NEW_LENGTH=1000;
    private String sessionId[] = new String[NEW_LENGTH];    // sessionId
    private long accessTime[] = new long[NEW_LENGTH];       // access time nearst
    private boolean busy[] = new boolean[NEW_LENGTH]; 
    private String temparray[] = new String[NEW_LENGTH]; 

    private String userId[] = new String[NEW_LENGTH];       // login Userid
    private String departId[] = new String[NEW_LENGTH];       // Department id
    private String funcCode[][] = new String[NEW_LENGTH][NEW_LENGTH];// functions code array
    private String funcName[][] = new String[NEW_LENGTH][NEW_LENGTH];// functions name array
    private String employeCode[] = new String[NEW_LENGTH];       // employes code
    private String authorCode[] = new String[NEW_LENGTH];       // Author code
    private String adminFlag[] = new String[NEW_LENGTH];       // is administrator flag
    private String clientVerifyFlag[] = new String[NEW_LENGTH];       // Client falg    
	
    private    boolean                isInited;
    private static boolean isSessionUserInited = false;
    private static volatile SessionUser sessionuser;
    private int TotalSes = 0;    // current connectin session num
    private int TotalBusy = 0;   // current connectint number 
    private long CountSessId = 0;
        
//    private int MaxUsers = Const.MAX_USERS;
//    private int MaxSess = Const.MAX_SESS;
    private int MaxUsers = NEW_LENGTH;
    private int MaxSess = NEW_LENGTH;
    private int TimeOut = Const.TIMEOUT;
    private int LongTimeOut = Const.LONGTIMEOUT;

    private int j=0;
 
    private void ClearSession(int i)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
        // clear session
        sessionId[i] = Const.INIT_NULL;
        userId[i] = Const.INIT_NULL;
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
        if (i < 0 || i > NEW_LENGTH)
        {
            return false;
        }
        return busy[i];
    }     

    public static SessionUser getSessionUser() 
    {
        if (SessionUser.isSessionUserInited) 
        {
            return sessionuser;
        }
        sessionuser = new SessionUser();
        SessionUser.isSessionUserInited = true;
        return sessionuser;
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
        if (i < 0 || i > NEW_LENGTH)
        {
            return "";
        }
        return userId[i];
    }     

    public String getdepartId(int i)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return "";
        }

		return departId[i];
    }     

    public String[] getfuncCode(int i)
    {
		for (j=0;j<NEW_LENGTH ;j++ )
		{
				temparray[j]=null;
		}

        if (i < 0 || i > NEW_LENGTH)
        {
            return null;
        }

		for (j=0;j<NEW_LENGTH && funcCode[i][j]!=null;j++ )
		{
				temparray[j]=funcCode[i][j];
		}

        return temparray;
    }     

    public String[] getfuncName(int i)
    {
		for (j=0;j<NEW_LENGTH ;j++ )
		{
				temparray[j]=null;
		}

        if (i < 0 || i >= NEW_LENGTH)
        {
            return null;
        }

		for (j=0;j<NEW_LENGTH && funcName[i][j]!=null;j++ )
		{
				temparray[j]=funcName[i][j];
		}

        return temparray;
    }     

    public String getemployeCode(int i)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return "";
        }
        return employeCode[i];
    }     

    public String getauthorCode(int i)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return "";
        }
        return authorCode[i];
    }     
    public String getadminFlag(int i)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return "";
        }
        return adminFlag[i];
    }     

    public String getClientVerifyFlag(int i)
    {
        if (i < 0 || i > NEW_LENGTH)
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
        return SessionUser.isSessionUserInited;
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
                for (int i=0;i<=NEW_LENGTH-1;i++)
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
                for (int i=0;i<= NEW_LENGTH - 1; i++)
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
				
                for (int i=0;i<=NEW_LENGTH - 1;i++)
                {
                    if (sessionId[i]==null || (accessTime[i] + getTimeOut() < d.getTime() ))    // get free space
                    {
						ClearSession(i);
                        sessionId[i] = SessionId;
                        accessTime[i] = d.getTime();
                        busy[i] = false;
 
                        TotalSes ++;
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
                for (int i=0;i<= NEW_LENGTH - 1; i++)
                {
                    if (sessionId[i].compareTo(SessionId) == 0)
                    {
						if (accessTime[i]==0)
							return -1;
						if (accessTime[i] + getTimeOut() > d.getTime())
						{
	                        accessTime[i] = d.getTime();
		                    return i;
						}
						else
						{
							return -1;
						}
                    }
                }
            
                return -1;    // this session has already been removed
            }
     
            case Const.SESSDEL:    // del (String SessionId)
            {
                if (SessionId == null)
                    return -1;
                    
                for (int i = 0;i<= NEW_LENGTH - 1; i++)
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
        if (i < 0 || i > NEW_LENGTH)
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
        SessionUser.isSessionUserInited=existflag;
    }
    
      
    public void setUserId(int i,String s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
        userId[i] = s;
    }     

    public void setdepartId(int i,String s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
        departId[i] = s;
    }     
    public void setfuncCode(int i,String[] s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
		if (s.length>NEW_LENGTH)
		{
			return;
		}
		for (j=0;j<s.length ;j++ )
		{
			funcCode[i][j]=s[j];
		}
		for (j=s.length;j<NEW_LENGTH ;j++ )
		{
			funcCode[i][j]=null;
		}
    }     

    public void setfuncName(int i,String[] s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
		if (s.length>NEW_LENGTH)
		{
			return;
		}
		for (j=0;j<s.length ;j++ )
		{
			funcName[i][j]=s[j];
		}
		for (j=s.length;j<NEW_LENGTH ;j++ )
		{
			funcName[i][j]=null;
		}
    }     


    public void setemployeCode(int i,String s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
        employeCode[i] = s;
    }     

    public void setauthorCode(int i,String s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
        authorCode[i] = s;
    }     
    public void setadminFlag(int i,String s)
    {
        if (i < 0 || i > NEW_LENGTH)
        {
            return;
        }
        adminFlag[i] = s;
    }     

    public void setClientVerifyFlag(int i,String s)
    {
        if (i < 0 || i > NEW_LENGTH)
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

    public int getlength(String[] s) 
    {
		int i;
		for (i=0;i<s.length && s[i]!=null ;i++ )
		{
		}
		return i;
    }

}