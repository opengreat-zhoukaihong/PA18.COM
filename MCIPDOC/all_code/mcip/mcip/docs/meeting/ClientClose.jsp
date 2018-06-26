
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%
   System.out.println("window close.jsp exec");
    HttpSession https = request.getSession(true);
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
    if(sessionId!=null){
      System.out.println("window client exit java");
      mb.ClientExit(sessionId, clientName);
    }  

 }catch(Exception e){
    e.printStackTrace();
 }  %>
   <script language="JavaScript">
    window.close();
 </script>

