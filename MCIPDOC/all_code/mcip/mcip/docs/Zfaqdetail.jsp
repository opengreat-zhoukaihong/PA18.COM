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
<jsp:useBean id="obj"  scope="page" class="beans.Zbussbean"/>
<%
	String username=null;
	String[] formpara=new String[2];
	formpara[0]=request.getParameter("no");
	formpara[1] = request.getParameter("username");
	String[][] info=null;
	try
	{
		obj.setFormPara(ZConst.QUERY_CONSULTINFO,formpara);
		info=obj.getRetValueArra();
	}
   catch(NormalException e)
   {
		out.println("for debug:NormalException err ocur in jsp");
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  // end try

	int i=1;
	if(info!=null)
	{
%>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
	  <tr>
	     <%@ include file="public/PublicConsultLeft.html" %> 
	     <td  valign="top">
     	       <p>
                 <img src="images/consul_1.gif" width="150" height="31" alt="险种咨询">
	       </p>
		<table border="0" width="95%" cellpadding="4">
		  <tr> 
		    <td bgcolor="#7CA3E9">
			<p>
			  <font color="#FFFFFF">
			    <%=Objects.getValue(1,"c_faq_title",info)%>
			  </font>&nbsp;&nbsp;的内容
			</p>
		     </td>
		  </tr>
		  <tr> 
		    <td bgcolor="#F6F6F6">
		        <p>&nbsp;&nbsp;<%=Objects.getValue(1,"c_faq_content",info)%></p>
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
