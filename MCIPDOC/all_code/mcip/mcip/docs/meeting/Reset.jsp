
<body bgcolor="#e1fbc1" leftmargin="0" topmargin="0">

<%@ page language="java" import="java.beans.Beans,java.math.*,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="ub"  scope="session" class="beans.UserManagerBean"/>
<jsp:setProperty name="ub" property="*"/>

<%
   int Locate ;
   MessageBean mb = MessageBean.instance;
   Server server;
   Client client;
   Vector queue;
   String sessionId=Code.Decrypt(request.getParameter("sessionId"));
   if (sessionId != null && sessionId.length() > 0){
	 request.getSession(true).putValue("sessionId",Code.Encrypt(sessionId));
   }else{
	   sessionId = Code.Decrypt((String)request.getSession(false).getValue("sessionId"));
    }

    if ((sessionId == null) || (sessionId.equals("")))
    {
          throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
     }

     SessionUser sessionuser = SessionUser.getSessionUser();
	   try
	   {
		   Locate = sessionuser.ProcessSession(Const.SESSAUTH,sessionId);
	   }
	   catch (Exception e)
	  {
		   Locate = -1;
  	}

    if (Locate<0)
    {
       throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
     }
     //out.println("Locate:"+ Locate);
     String myName= sessionuser.getuserId(Locate);


 %>
  <jsp:forward page="../operator_manager/ServerMeeting.jsp"/>









