<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
</head>
<body bgcolor="#e1fbc1" leftmargin="0" topmargin="0" onload="javascript:beginLoad()">
<%@ include file="ServerPre.jsp" %>
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
    String clientName = "";
    String serverName = "";
	String isDisable = request.getParameter("isDisable");
	if(isDisable == null){
		isDisable = "";
	}
    boolean succ =false;
    MessageBean mb = MessageBean.instance;
	
	//String isNoSub = (String)session.getAttribute("noSub");//无主题交谈的标志

    String sessionId=request.getParameter("sessionId");
    String subject = request.getParameter("subject");
    String cmess="";
    String smess="";

    cmess = request.getParameter("clientMsgs");
    smess = request.getParameter("serverMsgs");
    if(cmess==null){
      cmess="";
    }
    if(smess==null){
      smess="";
    }
    
    int j= sessionId.indexOf("_");
    if(j>0){
     clientName = sessionId.substring(0,j);
     serverName = sessionId.substring(j+1);
    }else{
       NormalException e1 = new NormalException("数据出错！");
       throw NormalExceptionHandler.Handle(e1);
    }
    try{
     String mess = request.getParameter("message");
     if(mess!=null){
        mess = mess.trim();
        if(mess.length()>0){
          Message message = new Message("",1,subject,mess);
          if(message==null)out.println("message is false");
          mb.AddServerMessage(sessionId, message);
        }
     }
   }catch(Exception e1){
     System.out.println("((((");
    e1.printStackTrace();
   }


   String savestr = request.getParameter("save");
   try{
    if(savestr!=null && savestr.equals("1")){ //保存谈话内容
	   System.out.println("===============Save the content of this talk==========");
       String addClientMsgs = request.getParameter("addClientMsgs");
       String addServerMsgs = request.getParameter("addServerMsgs");
       String date = "2000-12-28 12:12:12";//(new Date()).toString();
       if(cmess!=null){
         StringTokenizer st = new StringTokenizer(addClientMsgs, "\n");
         while(st.hasMoreElements()){
           String ss[] = { (String)st.nextElement() } ;
           String para[]= {date, date, subject, clientName,"0"};
           bb.setFormParaPre(BConst.ACCEPT_CHAT_RECORD, ss);
           bb.setFormPara(BConst.ACCEPT_CHAT_RECORD,para);
        }
       }
	   System.out.println("===============Don't save the content of this talk==========");
       if(smess!=null){
         //out.println(smess);
         //out.println("\n");
         //out.println(addServerMsgs);
         StringTokenizer st = new StringTokenizer(addServerMsgs, "\n");
         while(st.hasMoreElements()){
           String ss[] = { (String)st.nextElement() } ;
           String para[]= {date, date, subject, serverName,"1"};
           bb.setFormParaPre(BConst.ACCEPT_CHAT_RECORD, ss);
           bb.setFormPara(BConst.ACCEPT_CHAT_RECORD,para);
        }
       }  
       
     }
   }catch(NormalException e)
    {
         throw NormalExceptionHandler.Handle(e);
    }
    catch(Exception e2){
     System.out.println(")))))))))))");
    e2.printStackTrace();
	
	}



%>

<div align="center">

<form  name="form1" action="AddServerMsg.jsp" method="post" onSubmit="return addmessage(message)">
<input type="hidden" name="clientName" value="<%=clientName%>">
<input type="hidden" name="serverName" value="<%=serverName%>">
<input type="hidden" name="sessionId" value="<%=sessionId%>">
<input type="hidden" name="subject" value="<%=subject%>">
<input type="hidden" name="clientMsgs" value="<%=cmess%>">
<input type="hidden" name="serverMsgs" value="<%=smess%>">
<input type="hidden" name="addClientMsgs">
<input type="hidden" name="addServerMsgs">

<input type="hidden" name="isDisable" value="no">

<input type="hidden" name="save" value="0">
<table border=1 width="98%">
<tr><td width=100%>
<select name="premessage" onChange="PreSelected(this.form)" <%if(isDisable.equals("yes")){%>disabled<%}%>>
     <option value="none" >您可以选择
     <% for(j = 0 ; j< premsgs.length; j++){%>
        <option value="<%=premsgs[j]%>"> <%=premsgs[j]%>
     <%}%>
     </select>
      <input type="text" name="message" size=50 <%if(isDisable.equals("yes")){%>disabled<%}%>> 
      <input type="submit" name="submit1" value="发送" <%if(isDisable.equals("yes")){%>disabled<%}%>>
      &nbsp;<input type="button" name="submit2" value="退出" onClick="Exit(this.form)" >
    </td>
</tr>

</table>

</form>
</div>

</body>
</html>
<script lanaguage=JavaScript>
function Exit(theForm){

	
	var isNoSub = "<%=subject%>"
	if(isNoSub != "Have no subject"){
		
   if(confirm("退出之前，您要保存谈话吗?")){
     /*
	 clientMsgs = document.form1.clientMsgs;
     serverMsgs = document.form1.serverMsgs;
     clientMsgs.value = parent.up.document.form1.clientMsgs.value;
     serverMsgs.value = parent.up.document.form1.serverMsgs.value;
*/
     ////////// Modified by Liuxy on 2001.4.10 /////////////////////
	 clientMsgs = document.form1.clientMsgs;
     serverMsgs = document.form1.serverMsgs;
     clientMsgs0 = clientMsgs.value;
     serverMsgs0 = serverMsgs.value;
     clientMsgs1 =  parent.up.document.form1.clientMsgs.value;
     serverMsgs1 =  parent.up.document.form1.serverMsgs.value;
     clientMsgs.value = parent.up.document.form1.clientMsgs.value;
     serverMsgs.value = parent.up.document.form1.serverMsgs.value;
     if(clientMsgs0!="" && clientMsgs1!=""){
          p = clientMsgs1.indexOf(clientMsgs0);
          document.form1.addClientMsgs.value  = clientMsgs1.substring(0,p);
     }else{
          document.form1.addClientMsgs.value = clientMsgs1;
     }

     if((serverMsgs0!="") && (serverMsgs1!="")){
          p = serverMsgs1.indexOf(serverMsgs0);
          document.form1.addServerMsgs.value  = serverMsgs1.substring(0,p);
     }else{
        //alert("ServerContent.jsp :Yes, I'm saving .");
        document.form1.addServerMsgs.value = serverMsgs1;
     }
     ////////////////////////////////////////////
	 if(parent.up.document.form1.isDisable.value == "yes"){
		document.form1.isDisable.value = "yes";
		//parent.up.document.form1.submit3.disabled = true;
	 }
     document.form1.save.value ="1";
     document.form1.submit();
   }else{
	  //do nothing  
	  
   }

	}

   if(confirm("你真的想离开吗?")){
		theForm.action= "ServerExit.jsp";
		theForm.submit();
		parent.window.close();
   }else{
	  return;
   }
   
}

function beginLoad(){
	document.form1.message.focus();
	if(parent.up.document.form1.isDisable.value == "yes"){
		document.form1.isDisable.value = "yes";
		document.form1.submit1.disabled = true;
		document.form1.premessage.disabled = true;
		document.form1.message.disabled = true;
		//parent.up.document.form1.submit3.disabled = true;
	}
}


function PreSelected(theForm){
     i = theForm.premessage.options.selectedIndex ;
     if(i==0)return;
     str = theForm.premessage.options[i].value;
     theForm.message.value  = str;
     parent.up.document.form1.serverMsgs.value =  str + "\n"+ parent.up.document.form1.serverMsgs.value;
     theForm.submit();
}

function addmessage(message){
    if(message.value=="" || message.value==null)return false;
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
      serverMsgs = parent.up.form1.serverMsgs;
      serverMsgs.value = newstr + "\n"+ serverMsgs.value;
    }else{

      dml= window.parent.up.document.form1;
      len = dml.elements.length;

      var i=0;
      for( i=0 ; i<len ; i++) {
       if (dml.elements[i].name=="serverMsgs") {
        dml.elements[i].value = newstr +"\n"+dml.elements[i].value;

       }
     }

  }      
   return true;
}

</script>
