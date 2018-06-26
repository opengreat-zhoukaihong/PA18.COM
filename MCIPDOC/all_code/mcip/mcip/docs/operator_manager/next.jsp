<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="../ErrOut.jsp"%>
<%
response.setHeader("Location","BackManage.html");
   response.setHeader("Pragma","No-Cache");
   response.setDateHeader("Expires",0);
   response.setHeader("Cache-Control","no-Cache");
%>

<%
/*
	HttpSession s = request.getSession (true);
	String a="zzzzz";
	a=(String) s.getValue("counter");
	a=a+"$";
	s.putValue("counter",a);
	String[][] testa=new String[5][6];
	int strLen=testa[0].length;
	testa[0][0]="Operator Name";
	testa[0][1]="Operator Name";
	testa[0][2]="Operator Name";
	testa[0][3]="Operator Name";
	testa[0][4]="Operator Name";
	testa[0][5]="Operator Name";
	testa[1][0]="Clief";
	testa[2][0]="Mike";
	testa[3][0]="JOnney";
	testa[4][0]="j";


//	ival=s.getValue ("counter");
//        if (ival == null) ival = "a";
//        else ival = ival+"c";
//        s.putValue ("counter", ival);
*/
%>
<%
SessionUser sessionuser = SessionUser.getSessionUser();
//String sessionId = new String(sessionuser.getNewSessionId());
String user=sessionuser.getuserId(1);
String dept=sessionuser.getdepartId(1);

%>

<html>
<head>
</head>
<body>
user:<%=user%><br>
dept:<%=dept%><br>
</body>
</html>