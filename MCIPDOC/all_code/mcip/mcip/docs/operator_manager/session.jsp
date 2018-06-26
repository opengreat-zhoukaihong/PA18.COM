<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp"%>


<%
   response.setHeader("Pragma","No-Cache");
   response.setDateHeader("Expires",0);
   response.setHeader("Cache-Control","no-Cache");
%>

<%

SessionUser sessionuser = SessionUser.getSessionUser();
String sessionId = new String(sessionuser.getNewSessionId());
String[] Code={"aaa","bbb","ccc"};

   
   int Locate = sessionuser.ProcessSession(Const.SESSNEW,sessionId);

    if (Locate < 0)
    {
    
            throw NormalExceptionHandler.Handle(ExceptionCode.SYS_SESSION_INIT_FAILURE);
    }

    sessionuser.setUserId(Locate,"Lawrence");
    sessionuser.setfuncCode(Locate,Code);
    sessionuser.setdepartId(Locate,"abcdefg");
    String test=sessionuser.getuserId(Locate);
    String[] get=sessionuser.getfuncCode(Locate);

%>
<html>
<head>
</head>
<body>
<%=sessionId%><br>

<%=test%><br>
<%=Locate%>

<br>
<br>
<%
int i;
for (i=0;i<3;i++){%>
<h3><%=get[i]%></h3>
<%}%>
</body>
</html>