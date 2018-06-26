<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="../art_open.js"></SCRIPT>
<body bgcolor="#e1fbc1" leftmargin="0" topmargin="0"  onunload="JavaScript:window_close()">
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%

   String clientName ="";
   String serverName ="";
   String clientMsgStr ="";
   String serverMsgStr ="";
   boolean succ =false;
   MessageBean mb = MessageBean.instance;

   String isNoSub = (String)session.getAttribute("noSub");
   if(isNoSub == null){
	   isNoSub = "no";	
   }

   String sessionId=request.getParameter("sessionId");
   String subject = request.getParameter("subject");
   int j= sessionId.indexOf("_");
   if(j>0){
     clientName = sessionId.substring(0,j);
     serverName = sessionId.substring(j+1);
   }else{
       NormalException e1 = new NormalException("数据出错！");
       throw NormalExceptionHandler.Handle(e1);
   }
   String transfter = request.getParameter("transfter");
   if(transfter.equalsIgnoreCase("yes")){
      LinkedList clientMessages, serverMessages;
      clientMessages = mb.GetClientMessages(sessionId);
      serverMessages = mb.GetServerMessages(sessionId);
      Message message;
      String temp;
      int size;
      if(clientMessages!=null){
         size = clientMessages.size();
         for(int i=(size-1); i>=0 ;i--){
           message = (Message)(clientMessages.get(i));
           temp = message.body;
           clientMsgStr = clientMsgStr+ "\n"+ temp;
        }
      }
      if(serverMessages!=null){
         size = serverMessages.size();
         for(int i=(size-1); i>=0 ;i--){
           message = (Message)(serverMessages.get(i));
           temp = message.body;
           serverMsgStr = serverMsgStr+ "\n"+ temp;
        }
      }
   }

%>

<div align="center">
<p align="center">主题:<%=subject%></p>
<form name="form1">
<input type="hidden" name="sub" value="<%=subject%>">
<input type="hidden" name="clientName" value="<%=clientName%>">
<input type="hidden" name="serverName" value="<%=serverName%>">
<input type="hidden" name="isTransfer" value="no">

<input type="hidden" name="isDisable" value="no">

<table border=1 width="98%">
<tr> <td width=50%>客户 :<%=clientName%></td>
     <td width=50%>核保人:<%=serverName%>  &nbsp;<input type="button" name="submit3" value="保存" <%if(subject.equals("Have no subject")){%> disabled <%}%> onClick="Save()">
     &nbsp;<input type="button" name="submit1" value="转发"  <%if(subject.equals("Have no subject")){%> disabled <%}%> onClick="transfer('<%=sessionId%>','<%=clientName%>')">
     &nbsp;<input type="button" name="submit2" value="查看历史" <%if(subject.equals("Have no subject")){%> disabled <%}%> onclick="ViewHistory()">
     </td>
</tr>
<tr><td width=50%><textarea name="clientMsgs" cols=35 rows=20 onkeydown="return false;"><%=clientMsgStr%></textarea></td>
    <td width=50%><textarea name="serverMsgs" cols=35 rows=20 onkeydown="return false;"><%=serverMsgStr%></textarea></td>
</tr>
</table>
</form>
</div>

</body>
</html>
<script language=JavaScript>
function ViewHistory(){
     js_openMeetingSmallPageI("ViewHistory.jsp?ct=<%=clientName%>&sub=<%=subject%>","<%=clientName%>2");
     return;
}
function Save(){
  var subject = "<%=subject%>"
  if(!parent.down.document.form1){
     return;
  }
  if(subject == "Have no subject"){
	return;
  }
     clientMsgs = parent.down.document.form1.clientMsgs;
     serverMsgs = parent.down.document.form1.serverMsgs;
     clientMsgs0 = clientMsgs.value;
     serverMsgs0 = serverMsgs.value;
     clientMsgs1 =  document.form1.clientMsgs.value;
     serverMsgs1 =  document.form1.serverMsgs.value;
     clientMsgs.value = document.form1.clientMsgs.value;
     serverMsgs.value = document.form1.serverMsgs.value;
     if(clientMsgs0!="" && clientMsgs1!=""){
          p = clientMsgs1.indexOf(clientMsgs0);
          parent.down.document.form1.addClientMsgs.value  = clientMsgs1.substring(0,p);
     }else{
          parent.down.document.form1.addClientMsgs.value = clientMsgs1;
     }

     if((serverMsgs0!="") && (serverMsgs1!="")){
          p = serverMsgs1.indexOf(serverMsgs0);
          parent.down.document.form1.addServerMsgs.value  = serverMsgs1.substring(0,p);
     }else{
        //alert("ServerContent.jsp :Yes, I'm saving .");
        parent.down.document.form1.addServerMsgs.value = serverMsgs1;
     }
     parent.down.document.form1.save.value ="1";

	 if(parent.up.document.form1.isDisable.value == "yes"){
		parent.down.document.form1.isDisable.value = "yes";
		//parent.up.document.form1.submit3.disabled = true;
	 }
     parent.down.document.form1.submit();
	 
	 
	 
	 
}

function transfer(sessionId, clientName){
   //alert(sessionId);
   //document.form1.submit1.disabled = true;
   url = "Transfer.jsp?sessionId="+sessionId;
   newwin =  sessionId+"_"+clientName+"1";
   p=window.open(url,newwin,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizeable=no,width=250,height=50");
  //p=window.showModalDialog(url,"dialogWidth=20,dialogHeight=5,dialogTop=0,dialogLeft=0");

   
}

function window_close(){
//	alert(document.form1.isTransfer.value);
if(document.form1.isTransfer.value != "yes"){
 url ="ServerClose.jsp?clientName="+"<%=clientName%>";
 newwin =  "123";

 parent.location = url;
}

}

</script>
