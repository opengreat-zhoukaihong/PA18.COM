 <%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
 <%  HttpSession https = request.getSession(true);
    String sessionIdCurr = https.getId();
    int Locate =0;
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionIdCurr);
    if (Locate < 0)
    {
           throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
    }
    String clientName = sessionbuffer.getuserId(Locate);
    String serverName="核保人";
    boolean connected = true;

    MessageBean mb= MessageBean.instance;
    if(!mb.IsClientLogged(clientName)){
      connected = false ;
    }
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<% if(connected){%>
<meta http-equiv="Refresh" Content="2" URL="GetClientContent.jsp">
<%}%>  
</head>
<body>



<%

    String serverMsgStr ="";
    if(!mb.IsClientConnected(clientName)){
       System.out.println("GetClientContent.jsp :Not Connected");
    }
    if(!connected){ 
    %>
      <script  language="JavaScript">
       //alert("核保人已经结束谈话！");
        //  dml= window.parent.up.document.form1;
         // if(dm1){
         //  dm1.Connected.value = "0";
         // }
         /* len = dml.elements.length;
          var i=0;
          var x = dml.clientMsgs.value;
          var y = dml.serverMsgs.value;
          var clientName = dml.clientName.value;
          var serverName = dml.serverName.value;
          var subject = dml.sub.value;
       var str = "<html><head><title>平安保险网上沟通_客户关闭</title></head><body bgcolor='#e1fbc1'><form name='form1'>";
       str = str + "<p align=center>主题:"+subject;
       str = str + "<table width=100%><tr><td width=50%>客户 :";
       str = str + clientName + "</td><td width=50%>核保人:"+serverName+"</td></tr><tr><td width=50%>";
       str = str + "<textarea name='clientMsg' cols=30 rows=15>";
       str = str + x ;
       str = str +"</textarea></td><td><textarea name='yy' cols=30 rows=15>"
       y = "核保人已经结束谈话！"+"\n"+y;
       str = str+y;
       str = str + "</textarea></td></tr></table>";
       str = str + "<input type='hidden' name='clientName' value='"+ clientName +"'>";
       str = str + "<input type='hidden' name='serverName' value='"+ serverName +"'>";
       str = str + "</form></body></html>";
       */
      // parent.document.clear();
      // parent.document.write(str);
       //parent.close();
      </script>
     <%}
    if(mb.IsClientConnected(clientName)){ %>
     <script language=Javascript>
       //dm2= window.parent.up.document.form1;
       //if(dm2){
       // dm2.Connected.value = "1";
       //}
     </script>
     <%System.out.println("Yes connected");
     try {
      String sessionId ="" ;
      sessionId = mb.GetSessionId(clientName);
      System.out.println("sessionId in GetClientChat.jsp:"+ sessionId);
      if(sessionId==null){
        System.out.println("sessionId==null");
      }
      int j = sessionId.indexOf("_");
      serverName = sessionId.substring(j+1);
      LinkedList serverMessages = mb.GetServerNewMsgs(sessionId);
      String temp;
      int size;

      Message message;

      if(serverMessages!=null){
        size = serverMessages.size();
        for(int i=(size-1); i>=0; i--){
          message = (Message)(serverMessages.get(i));
          temp = message.body;
          serverMsgStr = serverMsgStr +"\n" + temp;
        }
     }
    }catch(Exception e1){
      e1.printStackTrace();
    }
   }
   if(!connected){
      serverMsgStr =  "核保人已经结束谈话！";  %>
      <script language=JavaScript>
       parent.down.location ="disableClient.jsp";
      </script>
  <%}

%>

<form name=form1>
<textarea name="message" cols=30 rows=20><%=serverMsgStr%></textarea>
</form>
<% if(serverMsgStr.length()>0){%>
 <script lanaguage=JavaScript>
    if(navigator.appName=="Microsoft Internet Explorer"){
      if(parent.up.form1.serverMsgs){
        parent.up.form1.serverMsgs.value = document.form1.message.value +"\n"+ parent.up.form1.serverMsgs.value;
      }
      if(parent.up.form1.clientName){
       parent.up.form1.clientName.value="<%=clientName%>";
      }
      if(parent.up.form1.serverName){
        parent.up.form1.serverName.value="<%=serverName%>";
      }


    }else{
      
      dml= window.parent.up.document.form1;
      len = dml.elements.length;
      var i=0;
      message = document.form1.message;
      for( i=0 ; i<len ; i++) {
        if (dml.elements[i].name=="serverMsgs") {
         dml.elements[i].value = message.value +"\n"+ dml.elements[i].value;
        }
        if (dml.elements[i].name=="clientName") {
         dml.elements[i].value = "<%=clientName%>";
        }
        if (dml.elements[i].name=="serverName") {
         dml.elements[i].value = "<%=serverName%>"
        }

      } 
   }

 </script>
<%}%>
</body>
</html>
