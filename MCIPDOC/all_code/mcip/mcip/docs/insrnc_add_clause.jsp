<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/NoLoginPublic.html" %>

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
	String filename = request.getParameter("filename");
%>

<%=filename%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
     <%@ include file="public/PublicConsultLeft.html" %> 
     <td  valign="top">
       <p>
         <img src="images/con_art.gif" width="150" height="31" alt="保险条款">
       </p>
	<table width="95%" border="0" cellpadding="0" cellspacing="0">
	  <tr>
	    <td height="35">
		<%@ include file=filename%> 
	    </td>
	  </tr>
	</table>
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
