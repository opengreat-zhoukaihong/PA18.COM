<%@ page language="java" import="java.beans.Beans,java.lang.*,java.lang.reflect.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,com.jspsmart.upload.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%  

        if (!Init.isInit())
        {
            Init.initAll();
        }

    String sessionId = "";
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();    ;    
    int Locate = 0;

 System.out.println("B666666666666666&&&&****");
    HttpSession https = request.getSession(true);
    String sessionIdCurr = https.getId();

    sessionId = sessionIdCurr;
    
    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
    if (Locate < 0)
    {
            throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);            
    }

    String WarnMsg = "";

	 String MenuRef = (String)request.getAttribute(MenuMake.MENU_REF);
   if(MenuRef == null)
   {
	MenuRef =  request.getParameter(MenuMake.MENU_REF);
   }
   
   if(MenuRef == null)
       MenuRef = "";

  System.out.println("complete public.jsp");

%>    

<table width="778" border="0" cellspacing="0" cellpadding="0" height="64">
  <tr> 
    <td width="167"><img src="images/ntoplogo.gif" width="238" height="66"></td>
    <td width="611">
      <table width="540" border="0" cellspacing="0" cellpadding="0" height="64">
        <tr> 
          <td height="46"><img src="images/topright.gif" width="540" height="46"></td>
        </tr>
        <tr>
          <td><script language="JavaScript"><%out.println(MenuMake.TopMenu(""));%></script></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<% System.out.println("pass public"); %>


