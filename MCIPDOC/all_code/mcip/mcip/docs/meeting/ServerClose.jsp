
<html>
<head>
</head>
<body bgcolor="#0088ee">
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
MessageBean mb = MessageBean.instance;
try{
    String clientName = request.getParameter("clientName");
    String sessionId = mb.GetSessionId(clientName);
    if(sessionId!=null){
     System.out.println("window server exit java");
     mb.ClientExit(sessionId, clientName);
    } 
   }catch(Exception e){
    e.printStackTrace();
 }

 %>
 <script language="JavaScript">
   window.close();
 </script>
</body>
</html>




