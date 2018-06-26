
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css>
<title>平安保险在线沟通</title>
</head>
<body bgcolor="#e1fbc1" leftmargin="0" topmargin="0">
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>
<%

   String clientName = request.getParameter("ct");
   String subject = request.getParameter("sub");
   String[][] retArra = null;
%>

 <p>主题:<%=subject%>
 
<form name="form1">
<table border=1 width=98%>
<tr><td width=50%>客户</td>
    <td width=50%>核保人</td>
</tr>
<tr>

  <%
    try{
     String[] formPara={subject, "0"};
     bb.setFormPara(BConst.QUERY_CHAT_RECORD , formPara);
     retArra = bb.getRetValueArra();
    }catch (NormalException e){
       throw NormalExceptionHandler.Handle(e);
    }catch(Exception e1){
      e1.printStackTrace();
    }
    String content ="";
    for(int i=1 ;i< retArra.length ;i++){
      content = content+ retArra[i][4].trim()+"("+retArra[i][0]+")"+"\n";
    }

    %>
<td width=50%><textarea name="clientMsgs" cols=35 rows=20 onkeydown="return false;">
<%=content%>
</textarea></td>

  <%
    try{
     String[] formPara={subject, "1"};
     bb.setFormPara(BConst.QUERY_CHAT_RECORD , formPara);
     retArra = bb.getRetValueArra();
    }catch (NormalException e){
       throw NormalExceptionHandler.Handle(e);
    }catch(Exception e1){
      e1.printStackTrace();
    }
    content ="";
    for(int i=1 ;i< retArra.length ;i++){
        content = content+retArra[i][4].trim()+"("+retArra[i][0]+")"+"\n";
    }

    %>
 <td width=50%><textarea name="serverMsgs" cols=35 rows=20><%=content%></textarea></td>
</tr>
</table>
</form>


</body>
</html>
