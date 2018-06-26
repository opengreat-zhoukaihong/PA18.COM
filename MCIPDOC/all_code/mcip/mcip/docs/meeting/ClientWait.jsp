<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<body bgcolor="#0088ee" leftmargin="0" topmargin="0">

<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%

      MessageBean  mb = MessageBean.instance;
      HttpSession https = request.getSession(true);
      String sessionId = https.getId();
      SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
      int Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
      if (Locate < 0)
      {
            throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
      }
      String clientName = sessionbuffer.getClientName(Locate);%>
<jsp:forward page="ClientChat.jsp?clientName=<%=clientName%>"/>
</body>
</html>
