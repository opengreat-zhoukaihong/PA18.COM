
<html>
<head>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<body bgcolor="#0088ee">
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
MessageBean mb = MessageBean.instance;
try{
    String clientName = request.getParameter("clientName");
    String sessionId = mb.GetSessionId(clientName);
    mb.ClientExit(sessionId, clientName);
   }catch(Exception e){
    e.printStackTrace();
 }

 %>
 <script language="JavaScript">
    /*   var x = parent.up.document.form1.clientMsgs.value;
       var y = parent.up.document.form1.serverMsgs.value;
       var clientName = parent.up.document.form1.clientName.value;
       var serverName = parent.up.document.form1.serverName.value;
       var str = "<html><head><title>平安保险网上沟通</title></head><body bgcolor='#e1fbc1'><form name='form1'><table width=100%><tr><td width=50%>客户 :";
       str = str + clientName + "</td><td width=50%>核保人:"+serverName+"</td></tr><tr><td width=50%>";
       str = str + "<textarea name='clientMsg' cols=30 rows=15>";
       str = str + x ;
       str = str +"</textarea></td><td><textarea name='yy' cols=30 rows=15>"
       y = "已经结束谈话！"+"\n"+y;
       str = str+y;
       str = str + "</textarea></td></tr></table>";
       str = str + "<input type='hidden' name='clientName' value='"+clientName+"'>";
       str = str + "<input type='hidden' name='serverName' value='"+serverName+"'>";
       str = str +"</form></body></html>";
       parent.document.clear();
       parent.document.write(str);*/
       parent.window.close();
 </script>
</body>
</html>




