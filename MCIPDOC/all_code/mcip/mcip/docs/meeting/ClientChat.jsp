<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<% 
String subject  = request.getParameter("sub");
String refresh = request.getParameter("refresh");
subject = (String)request.getAttribute("sub");
if(subject == null || subject ==""){
	
	subject = "Have no subject";
}

if(refresh == null || refresh == ""){
	refresh = "0";
}
System.out.println("============ClientChat.jsp get subject is:" + subject);
%>

<html>
<head>
<title>平安保险在线沟通</title>

<frameset frameborder="1" border="0" rows="400,0,*" >
  <frame target="up" name="up" src="Content.jsp?sub=<%=subject%>&refresh=<%=refresh%>">
  <frame target="rhm" name="rhm" src="GetClientContent.jsp">
  <frame src="AddClientMsg.jsp" name="down" marginwidth="4">
  <noframes>
  </noframes>
</frameset>
</head>
</html>
<script language=JavaScript>
function window_close(){
 /*url ="ClientClose.jsp";
 newwin =  "&";
 //window.open(url,newwin,"toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizeable=no,width=0,height=0");
 window.location = url;*/
 if(!confirm("Do you want to close?")){
     return false;
 }else{
   return true;
 }
}
</script>
