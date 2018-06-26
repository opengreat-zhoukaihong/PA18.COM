<%
/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 11:16:18
*Modify id : 0001
*Modifier : WuYan
*Reason : I.Modify Html Style(format、Color 、table) of page 
*		II. process logic of code
***********************************************************************************************
*/
%>
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/NoLoginPublic.html" %>


<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="obj_buss"  scope="session" class="beans.Zbussbean"/>

<%
	String username = "test";
//	String username = request.getParameter("username");
	String[] formpara=new String[2];
	String[][] info=null;
	try
	{
		formpara[0]="";
		formpara[1]=username;
		obj_buss.setFormPara(ZConst.QUERY_GUIDELIST,formpara);
		info=obj_buss.getRetValueArra();
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  // end try

	int i=0;
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
   <tr>
	<%@ include file="public/PublicConsultLeft.html" %> 
	<td valign="top"> 
	    <a name="top"></a>
	    <p>
	       <img src="images/con_guide.gif" width="150" height="31" alt="投保指南">
	    </p>
	    <p align="left">
	     <font color="#CC33CC" size="3">投保指南</font>提供周详内容，助您更好地了解和使用本网站。
	    </p>

<%
	if(info!=null)
	{
%>
	<table  border="0" cellpadding="0" cellspacing="6" width="90%">

<%		for(i=1;i<info.length;i++)
		{	
//			if( ((i-1)%3)==0)
//				out.println("<tr>");
%>
		     <tr>
			<td width="33%" bgcolor="#FFFFFF" height="30">
			   <a href="Zguide_detail.jsp?no=<%=i%>">
			     <%=Objects.getValue(i,"c_title_no",info)+"、"%>
			     <%=Objects.getValue(i,"c_title_cnm",info)%>
			   </a>  
			</td>
		     </tr>
<%
//			if( (i%3)==0)
//				out.println("</tr><p></p>");
		}
	}
%>
	</table>

	 </td>
	</tr>
</table>
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
