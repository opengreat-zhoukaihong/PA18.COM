<%
/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 10:46:18
*Modify id : 0001
*Modifier : WuYan
*Reason : I.Modify Html Style(format、Color 、table) of page 
*		II. process logic of code
***********************************************************************************************
*/
/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-11-02
*Time : 20:36:45
*Modify id : 0002
*Modifier : WuYan
*Reason : I.Modify Html Style of new desgin;
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

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312" %>
<jsp:useBean id="obj"  scope="page" class="beans.Zbussbean"/>
<%
//	String[][] info=obj_data.getdataArra();
	String[][] info=null;
	String[] formpara=new String[2];

	formpara[1] = request.getParameter("username");
	formpara[0] = request.getParameter("begin");


//	int i=Integer.parseInt(request.getParameter("begin"));

	try
	{
		obj.setFormPara(ZConst.QUERY_CONSULTLIST,formpara);
		info=obj.getRetValueArra();
	}
	catch(NormalException e)
	{			
		out.println("for debug:NormalException err ocur in jsp");
		if(NormalExceptionHandler.IsSevere(e))
 			throw NormalExceptionHandler.Handle(e);
	}  // end try

%>
   <table border="0" cellpadding="0" cellspacing="0" width="90%">
     <tr>
       <%@ include file="public/PublicConsultLeft.html" %> 
       <td valign="top">
	<p>&nbsp;</p>	
<%
	if(info!=null)
	{
%>
	<table width="90%" border="0" cellspacing="0">
	   <tr>
	     <td align="right">
	        <font color="#EFB281">■</font>
		<a href="Input_FAQ.jsp?username=<%=formpara[1]%>">我有疑问</a>
	     </td>
	   </tr>	
	   <tr bgcolor="#9C9DFE" >
	     <td align="left">
	     </td>
	   </tr>
<%
		for(int i=1;i<info.length;i++)
		{
%>
	   <tr bgcolor="#F9F9FF"> 
	      <td align="left" height="20">
                <font color="#EFB281">◆</font>
	        <a href="Zfaqdetail.jsp?username=<%=formpara[1]%>&no=<%=Objects.getValue(i,"c_faq_no",info)%>"> 
		   <%=Objects.getValue(i,"c_faq_title",info)%>&nbsp;
	        </a>
	      </td>
	   </tr>
<%
		}
%>
	</table><BR>
	<input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  
<%
	}
%>
     </td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
