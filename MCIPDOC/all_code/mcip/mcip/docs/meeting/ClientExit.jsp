
<html>
<head>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<body bgcolor="#0088ee">
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>


<%  HttpSession https = request.getSession(true);
    String sessionIdCurr = https.getId();
    int Locate =0;
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionIdCurr);
    if (Locate < 0)
    {
           throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
    }
    String clientName = sessionbuffer.getuserId(Locate);


MessageBean mb = MessageBean.instance;
try{
    String sessionId =  mb.GetSessionId(clientName);
    mb.ClientExit(sessionId, clientName);
 }catch(Exception e){
    e.printStackTrace();
 }
 %>
 <script language="JavaScript">
  //parent.location="index.jsp";
  //window.close();
  parent.window.close();
 </script>
</body>
</html>

 
