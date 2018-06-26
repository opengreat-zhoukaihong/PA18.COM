<%@ page language="java" import="java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%  //for get login para and to bean

        if (!Init.isInit())
        {
            Init.initAll();
        }
System.out.println("11111111111111111111111111111");    


    String[] MenuRef = MenuMake.MenuRef;
//{"MENU_MEMBER","MENU_CONSULTANT","MENU_INSURANCE","MENU_REPORT","MENU_INQUIRE","MENU_EVALUATE","MENU_FINDPLYAPP","MENU_FINDPRP","OpenCover"};
    String MenuRefStr = request.getParameter("MENU_REF");
    String UrlLogin = "PublicLogin.jsp";
    String UrlSucc[] = MenuMake.UrlSucc;

/*{"MemberSucc.jsp","Consultant.jsp","OperationSelect.jsp","Find_Ply.jsp",
"InquireSucc.jsp","OperationSelect1.jsp","FindPlyApp.jsp",
"FindPlyApp.jsp","OpenCoverList.jsp"};
*/    
    String UrlRedirect = "";
    int i = 0;

System.out.println("MenuRefStr:"+MenuRefStr);    

    for(i=0;i<MenuRef.length;i++)
    {
         if(MenuRefStr.equals(MenuRef[i]))
            break;
    }
System.out.println("i:"+i);    
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
    //----------Old--------
    String sessionIdCurr = request.getRequestedSessionId();
   // HttpSession https = request.getSession(false);
   // String sessionIdCurr = https.getId();
    int Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionIdCurr);

System.out.println("****Login Process sessionIdCurr***"+sessionIdCurr);  
System.out.println("*********Locate :"+Locate);      

    if(Locate < 0)
    {
	    UrlRedirect = UrlLogin;
    }
    else
    {
        
	    String clientVerifyFlag = sessionbuffer.getClientVerifyFlag(Locate);
	    String flag = "0";
	    String flag1 = "9";
	    if((clientVerifyFlag.equals(flag) || clientVerifyFlag.equals(flag1)) &
	       (MenuRefStr.equals("MENU_INSURANCE") || MenuRefStr.equals("MENU_REPORT") 
	       || MenuRefStr.equals("MENU_INQUIRE")))
	    {
                 throw NormalExceptionHandler.Handle(Const.SYS_USER_ERR_CDE,Const.SYS_USER_ERR);	        
            }
            else
            {
	    	UrlRedirect = UrlSucc[i];
                
            }        
    }

    //special for consult
    if(MenuRefStr.equals("MENU_CONSULTANT"))
    {
    	UrlRedirect = "Consultant.jsp";   
    }    	

    request.setAttribute("MENU_REF",MenuRef[i]);	        	 
System.out.println("MenuMid Begin to forward:"+UrlRedirect);        
%>   
<jsp:forward page="<%=UrlRedirect%>"/> 