<%  HttpSession https = request.getSession(true);
    String sessionIdCurr = https.getId();
    int Locate =0;
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
    //out.println("sessionIdCurr:"+sessionIdCurr);
    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionIdCurr);
    if (Locate < 0)
    {
          throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
    }
    String clientName = sessionbuffer.getuserId(Locate);
    String serverName="繁忙";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>

<body bgcolor="#56930f" leftmargin=0 rightmargin=0 topmargin=0 marginwidth=0 marginheight=0 onload="javascript:document.form1.message.focus()" >



<%@ include file="ServerPre.jsp" %>
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
    System.out.println("addclientmsg.jsp:clientName:"+clientName);
    MessageBean mb= MessageBean.instance;
    if(!mb.IsClientConnected(clientName)){
       System.out.println("addclientmsg.jsp:Not Connected");
       String mess = request.getParameter("message");
       if(mess!=null){
         mess = mess.trim();
         if(mess.length()>0){
           System.out.println("Yes I am to add client message! in AddClientMessage.jsp");
           mb.AddClientPreMessage(clientName,mess);
         }
       }
       
    }
    if(mb.IsClientConnected(clientName)){
      System.out.println("Yes connected");

     try {
       String sessionId ="" ;
       sessionId = mb.GetSessionId(clientName);
       System.out.println("AddClientMsg.jsp sessionId in ClientChat.jsp:"+ sessionId);
       if(sessionId==null){
        System.out.println("sessionId==null");
       }
       int j = sessionId.indexOf("_");
       serverName = sessionId.substring(j+1); 
       String mess = request.getParameter("message");
       if(mess!=null){
         mess = mess.trim();
         if(mess.length()>0){
           Message message = new Message("",1,"subject",mess);
           mb.AddClientMessage(sessionId, message);
         }
       }
    }catch(Exception e1){
      e1.printStackTrace();
    }
   }

%>

<form name="form1" action="AddClientMsg.jsp" method="post" onSubmit="return addmessage(message)" >
<input type="hidden" name="clientName" value="<%=clientName%>">
<input type="hidden" name="serverName" value="<%=serverName%>">


<table border=0 width="98%">
<tr><td colspan=2 width=100%>
   <select name="premessage" onChange="PreSelected(this.form)">
     <option value="none" >您可以选择
     <% for( int j = 0 ; j< clientpremsgs.length; j++){%>
        <option value="<%=clientpremsgs[j]%>"> <%=clientpremsgs[j]%>
     <%}%>
     </select>
   <input type="text" name="message" size=60 onkeydown="return checkEdit();">
   <input type="submit" name="submit1" value="发送">&nbsp;<input type="button" name="submit2" value="退出" onClick="Exit(this.form)"> </td>
</tr>
</table>
</form>

</body>
</html>
<script language="JavaScript">

function  Exit_Force(theForm){  //非正常退出执行的函数 （Liuxy added on 2001.4.5)
   theForm.action= "ClientExit.jsp";
   theForm.submit();
   //parent.window.close();
   //return;
}

function  Exit(theForm){
   if(confirm("你真的想离开吗?")){
    theForm.action= "ClientExit.jsp";
    theForm.submit();
    parent.window.close();
   }
   return;
}
function PreSelected(theForm){
     i = theForm.premessage.options.selectedIndex ;
     if(i==0)return;
     str = theForm.premessage.options[i].value;
     theForm.message.value  = str;
     parent.up.document.form1.clientMsgs.value =  str + "\n" + parent.up.document.form1.clientMsgs.value;
     theForm.submit();
}
function addmessage(message){
    if(message.value=="")return false;
    str = message.value;
    newstr ="";
    empty = true;
    for(i=0 ; i< str.length; i++)
     if(str.substring(i,i+1)!=" "){
        empty = false;
        newstr= newstr+str.substring(i,i+1);
     }else{
        if(!empty)
        newstr= newstr+" ";
     }
     if(newstr=="")return false;
    if(navigator.appName=="Microsoft Internet Explorer"){
      clientMsgs = parent.up.form1.clientMsgs;
      clientMsgs.value = newstr + "\n"+ clientMsgs.value;
    }else{

      dml= window.parent.up.document.form1;
      len = dml.elements.length;

      var i=0;
      for( i=0 ; i<len ; i++) {
       if (dml.elements[i].name=="clientMsgs") {
         dml.elements[i].value = newstr +"\n"+dml.elements[i].value;
       }

     }

  }
   return true;
}
function checkEdit(){
   /*var  serverMsgs = parent.up.document.form1.serverName;
    if(serverMsgs.value=="请稍侯!") return false;
    else return true;*/
    return true;
}

function window_close(){
 url ="ClientClose.jsp";
 newwin =  "<%=clientName%>"+"_"+"close";
 p=window.open(url,newwin,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizeable=no,width=250,height=50");
  /*alert("document content close ....");
  if(document.form1){
   alert("document content close doing ....");
   document.form1.submit();
  } */
}


</script>

