<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE="text/css" href=index.css>

</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/Public.jsp" %>
<%
   String clientflag = sessionbuffer.getClientFlag(Locate);
   String userid = sessionbuffer.getClientId(Locate);   
//	String Result[] = sessionbuffer.getClientAddInfo(Locate);
	
//	String	temp = Result[5];
//	out.println("temp="+temp);
//		clientflag="3";

 if (clientflag!=null)
 {
	clientflag=clientflag.trim();
  	if (clientflag.equals("1") )
   {	%>
		<jsp:forward page="edit_prsn.jsp" /> 
<%	}else
//   if ( clientflag.equals("0") ||clientflag.equals("2"))
   {
%>
		<jsp:forward page="edit_orgn.jsp" /> 
<% }
 }
%>
Testing  debug:clientflag==null!   

 <%=clientflag%><br> <%=userid%>
  <%@ include file="public/PublicBottom.html" %>   

</body> 
</html>
   