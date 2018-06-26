<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Clause_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/
*URL : http://10.16.102.1:8800/Clause_List.jsp
*Previous Page : consult_List.jsp
*Next Page : ZView_Clause.jsp
*Author : Zhu Ling Xiang
*Created Date : 2000-10-26
*Last Updated : 
*Status : 
*Function : I.list all the title of the Clause
*			II.provide the link to the next pages
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 14:16:18
*Modify id : 0001
*Modifier : WuYan
*Reason : I.Modify Html Style of Clause list 
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
<jsp:useBean id="obj"  scope="page" class="beans.ZPolicyInfoBean"/>

<%
	String username = request.getParameter("username");
	if(username==null)username = "1";
	String[] formpara=new String[3];
	String[][] info=null;
	try
	{
		formpara[0]="";
		formpara[1]="";
		formpara[2]=username;
		obj.setFormPara(ZConst.GET_CLAUSELIST,formpara);
		info=obj.getRetValueArra();
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  // end try

	int i=0;
//debug
//	if(info!=null)out.println("infolen="+info.length);


%>

<%
	if(info!=null)
	{
%>
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
	  <tr>
	     <%@ include file="public/PublicConsultLeft.html" %> 
	     <td  valign="top">
     	       <p>
                 <img src="images/con_art.gif" width="150" height="31" alt="保险条款">
	       </p>
		请点击选择你要查看条款的项目：<br>
		<table width="100%" border="0" cellpadding="0" cellspacing="2">
<%
		for(i=1;i<info.length;i++)
		{
			if( ((i-1)%3)==0)
				out.println("<tr>");
%>
			<td height="30">
			  <a href="ZView_Clause.jsp?path=<%=Objects.getValue(i,"c_claus_path",info)%>&C_Title=<%=Objects.getValue(i,"c_claus_cnm",info)%>">
			    <font color="#EFB281">■</font><%=Objects.getValue(i,"c_claus_cnm",info)%>
			  </a>
			</td>				
<%			if( (i%3)==0)
				out.println("</tr>");
		}
%>
		</table>
<%
//		if( (info.length%3)==1)out.println("<td>&nbsp;</td> <td>&nbsp;</td></tr>");
//		if( (info.length%3)==2)
//		{
//			out.println("<td>ok &nbsp;</td> </tr>");
//		}
%>
		
<%
	}
	else
	{
%>
		<FONT SIZE="3" COLOR="#FF0066">没有找到条款。</FONT>
<%		
	}
%>
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  
      </td>
    </tr>
 </table>   
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
