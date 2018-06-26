<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
   String sessionId=request.getParameter("sessionId");

   out.println(sessionId);
   String clientName ="";
   String serverName ="";
   String clientMsgStr ="";
   boolean succ =false;
   boolean connected = true;
   MessageBean mb = MessageBean.instance;
   if(sessionId==null){
     throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
   }
   int j= sessionId.indexOf("_");
   if(j>0){
     clientName = sessionId.substring(0,j);
     serverName = sessionId.substring(j+1);
   }else{
       NormalException e1 = new NormalException("数据出错！");
       throw NormalExceptionHandler.Handle(e1);
   }

   if(!mb.IsClientLogged(clientName)){
     connected = false;
   }else{
	 connected = true;
   }
 %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<% if(connected){%>
<meta http-equiv="Refresh" Content="2" URL="GetServerContent.jsp?sessionId=<%=sessionId%>">
<%
System.out.println("sessionid is " + sessionId);
}%>
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<body bgcolor="#0088ee" leftmargin="0" topmargin="0">

<%
   try{
     if(!connected){%>
      <script  language="JavaScript">
      //parent.up.document.form1.submit1.disabled = true;
      // alert("<%=clientName%>"+"已经结束谈话！");
       /*
	   var x = parent.up.document.form1.clientMsgs.value;
       var y = parent.up.document.form1.serverMsgs.value;
       var subject = parent.up.document.form1.sub.value;
       var clientName = "<%=clientName%>";
       var serverName = "<%=serverName%>";

       var str = "<html><head><title>平安保险网上沟通</title></head><body bgcolor='#e1fbc1'><form name='form1'>";
       str = str + "<p align=center>主题:"+subject;
       str = str + "<table width=100%><tr><td width=50%>客户 :";
       str = str + clientName + "</td><td width=50%>核保人:"+serverName+"</td><tr><td width=50%>";
       str = str + "<textarea name='clientMsg' cols=30 rows=15>";
       str = str + x ;
       str = str +"</textarea></td><td><textarea name='yy' cols=30 rows=15>"
       y = "客户已经结束谈话！"+"\n"+y;
       str = str+y;
       str = str + "</textarea></td></tr></table>";
       str = str + "<input type='hidden' name='clientName' value='"+ clientName +"'>";
       str = str + "<input type='hidden' name='serverName' value='"+ serverName +"'>";
       str = str+ "</form></body></html>";
       //parent.document.clear();

       //parent.document.write(str);
       //parent.window.close();
       parent.down.location = "disableServer.jsp";
	*/
      </script>
     <%}
     String mess = request.getParameter("message");
     LinkedList clientMessages;
    
     clientMessages = mb.GetClientNewMsgs(sessionId);
     Message message;
     String temp;
     int size;
     if(clientMessages!=null){
         size = clientMessages.size();
         System.out.println("GetServerContent.jsp clientmessages size :"+size);
         for(int i=(size-1); i>=0 ;i--){
           message = (Message)(clientMessages.get(i));
           temp = message.body;
           clientMsgStr = clientMsgStr+ "\n"+ temp;
        }
      }
   }catch(Exception e1){
    e1.printStackTrace();
   }

   System.out.println("is connected " + connected);

   if(!connected){
     clientMsgStr =  "客户已经结束谈话！";

%>
<script language=JavaScript>
    //parent.down.location ="disableServer.jsp";
	parent.up.document.form1.submit1.disabled = true; //禁止转发
	
	//禁止聊天功能
	parent.down.document.form1.premessage.disabled = true;
	parent.down.document.form1.message.disabled = true;
	parent.down.document.form1.submit1.disabled = true;

	parent.down.document.form1.isDisable.value = "yes";
	parent.up.document.form1.isDisable.value = "yes";

</script>
<%
   }

%>


<form name="form1">

<textarea name="message" cols=10 rows=20><%=clientMsgStr%></textarea>
</form>
<% if(clientMsgStr.length()>0){%>
  <script lanaguage=JavaScript>
    
    if(navigator.appName=="Microsoft Internet Explorer"){
      if(parent.up.form1.clientMsgs){
        parent.up.form1.clientMsgs.value = document.form1.message.value +"\n"+parent.up.form1.clientMsgs.value;
      }
    }else{

      dml= window.parent.up.document.form1;
      len = dml.elements.length;
      var i=0;
      message = document.form1.message;
      for( i=0 ; i<len ; i++){
        if (dml.elements[i].name=="clientMsgs") {
         dml.elements[i].value = message.value +"\n"+ dml.elements[i].value;
        }
      }
   }

 </script>
<%}%>


</body>
</html>
