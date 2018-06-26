
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<body bgcolor="#e1fbc1" leftmargin="0" topmargin="0"  ><!--onUnload="JavaScript:window_close()" -->
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%  
	
	HttpSession https = request.getSession(true);
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
    String subject  = request.getParameter("sub");
	
%>

<%

//////////////// 这段代码用来获得客户和核保人的谈话信息 (Added by Liuxy on 2001.4.6)//////////////////

	String refresh = request.getParameter("refresh");
	MessageBean mb= MessageBean.instance;

	String serverMsgStr = "";
    String clientMsgStr = "";

if(refresh != null && refresh.equals("1")){
    
     try {
      String sessionId ="" ;
      sessionId = mb.GetSessionId(clientName);
      System.out.println("sessionId in GetClientChat.jsp:"+ sessionId);
      
	  if(sessionId==null){
        System.out.println("sessionId==null");
      }

      int j = sessionId.indexOf("_");
      serverName = sessionId.substring(j+1);
      
	  //LinkedList serverMessages = mb.GetServerMessages(sessionId); //获得服务端的消息
	  //LinkedList clientMessages = mb.GetClientMessages(sessionId); //获得客户端的消息
	  LinkedList serverMessages = mb.GetServerNewMsgs(sessionId); //获得服务端的消息
	  LinkedList clientMessages = mb.GetClientNewMsgs(sessionId); //获得客户端的消息
	  
      String temp;
      int size;

      Message message;

      if(serverMessages!=null){
        size = serverMessages.size();
        for(int i=(size-1); i>=0; i--){
          message = (Message)(serverMessages.get(i));
          temp = message.body;
          serverMsgStr = serverMsgStr +"\n" + temp;

        } //end for
     } //end if

	 if(clientMessages!=null){
        size = clientMessages.size();
        for(int i=(size-1); i>=0; i--){
          message = (Message)(clientMessages.get(i));
          temp = message.body;
          clientMsgStr = clientMsgStr +"\n" + temp;
        } //end for
     } //end if
    
	} catch(Exception e1){
         e1.printStackTrace();
    }

} // end if   

///////////////////////////////////////////////////////////////////////////
%>

<div align="center">
<p align="center">主题:<%=subject%></p>
<form name="form1">
<input type="hidden" name="Connected" value="0">
<input type="hidden" name="sub" value="<%=subject%>">
<table border=1 width="98%">
<tr> <td width=50%>客户 :<input type="text" disabled =true name="clientName" value="<%=clientName%>" onkeydown="return false;"></td>
     <td width=50%>核保人:<input type="text" disabled =true name="serverName" value="<%=serverName%>" onkeydown="return false;"></td>
</tr>
<tr><td width=50%><textarea name="clientMsgs" cols=35 rows=20 onkeydown="return false;"><%=clientMsgStr%></textarea></td>
    <td width=50%><textarea name="serverMsgs" cols=35 rows=20 onkeydown="return false;">欢迎你来到我们的网上沟通！<%=serverMsgStr%></textarea></td>
</tr>
</table>
</form>
</div>
</body>
</html>
<script language=JavaScript>
function window_close(){
  /*theForm = document.form1;
  if(theForm.Connected.value =="0"){
    window.close();
    return;
  } */
   url ="ClientClose.jsp";
   newwin =  "112";
   //window.open(url,newwin,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizeable=no,width=1,height=1");
   parent.location = url;

}
</script>

