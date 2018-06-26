<%@ page language="java" contentType= "text/html; charset=gb2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>后台管理主页</title>
</head>
<% 
//   String sessionId = (String)request.getAttribute("sessionId");
   String sessionId = request.getParameter("sessionId");
%>

<frameset cols="165,1*" border="0" framespacing="0"> 
  <frame name="contents" target="main" src="FuncList.jsp?sessionId=<%=sessionId%>">
  <frame name="main" src="Back_Welcom.jsp">
  <noframes> 
  <body>
  <p>This page uses frames, but your browser doesn't support them.</p>
  </body>
  </noframes>
 </frameset>
</html>

