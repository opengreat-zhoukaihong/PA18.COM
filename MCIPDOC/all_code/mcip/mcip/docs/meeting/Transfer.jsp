<html>
<title>
 平安保险在线沟通
</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="../art_open.js"></SCRIPT>
<body bgcolor="#e1fbc1" leftmargin="0" topmargin="0">
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%

   String clientName ="";
   String serverName ="";
   Server server ;
   boolean succ =false;
   MessageBean mb = MessageBean.instance;
   String sessionId=request.getParameter("sessionId");
   
   int j= sessionId.indexOf("_");
   if(j>0){
     clientName = sessionId.substring(0,j);
     serverName = sessionId.substring(j+1); 
   }else{
       NormalException e1 = new NormalException("数据出错！");
       throw NormalExceptionHandler.Handle(e1);
   }
   if(!mb.IsClientLogged(clientName)){%>
     <script language=JavaScript>
       alert("<%=clientName%>"+"已经退出!");
       window.close();
     </script>

   <%}
   //out.println(request.getParameter("transfer"));
   if(request.getParameter("transfer")!=null){
      out.println("yes");
      String newServerName =  request.getParameter("newServerName");
      mb.TransferServer(sessionId, newServerName);%>
       <script lanaguage=JavaScript>
        opener.parent.up.document.form1.isTransfer.value = "yes";
	    opener.parent.close();
        window.close();
       </script>
   <%}

%>

<div align="center">


<form name="form1" method="post"  action="Transfer.jsp?transfer=1" >
<input type="hidden" name="sessionId" value="<%=sessionId%>">
<input type="hidden" name="clientName" value="<%=clientName%>">
<input type="hidden" name="serverName" value="<%=serverName%>">
<%
 //out.println(serverName);
   Vector queue = mb.GetAllServers();
   if(queue.size()>1){%>
      请选择转发人:
     <select name="newServerName">
    <%for(int i=0 ;i< queue.size() ;i++){
        server = (Server)(queue.get(i));
        if(!(server.GetServerName()).equalsIgnoreCase(serverName)){%>
        <option value="<%=server.GetServerName()%>"><%=server.GetServerName()%>
        <%}
        }
        %>
      </select> <input type="submit" name="submit1" value="确定">
  <%}else{%>
    No one server can transfer! 
  <%}%>
</form>
</div>

</body>
</html>

