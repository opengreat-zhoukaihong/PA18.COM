<%
/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 17:09:56
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
	String username=null;
	String[] formpara=new String[2];
	int i=Integer.parseInt(request.getParameter("no"));
	String[][] info=null;
		
	info=obj_buss.getRetValueArra();

	if(info!=null)
	{
%>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
	  <tr>
	     <%@ include file="public/PublicConsultLeft.html" %> 
	     <td  valign="top">
     	       <p>
                 <img src="images/con_guide.gif" width="150" height="31" alt="险种咨询">
	       </p>
		<table border="0" width="100%" cellpadding="4">
		  <tr> 
		    <td bgcolor="#7CA3E9">
			<p>
			  <font color="#FFFFFF">
			    <%=Objects.getValue(i,"c_title_no",info)+"、"%>
			    <%=Objects.getValue(i,"c_title_cnm",info)%>
			  </font>
			</p>
		     </td>
		  </tr>
		  <tr> 
		    <td bgcolor="#F6F6F6">
		        <p>&nbsp;&nbsp;&nbsp;&nbsp;<textarea cols="60" rows="12" onkeydown="return false;"><%=Objects.getValue(i,"c_content_cnm",info)%></textarea></p>
		     </td>
		   </tr>
		 </table>
		 <BR>
		  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>
	      </td>
	    </tr>
	 </table>   
<%
	}
%>
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
