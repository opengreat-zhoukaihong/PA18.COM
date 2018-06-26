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
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
     <%@ include file="public/PublicConsultLeft.html" %> 
     <td  valign="top">
	<p><img src="images/sysinfo.gif" width="150" height="31" alt="系统信息"></p>
<% 
	int i=0;
	String info[] = new String[9];
	String formparaPre[] = new String[1];
	boolean IsAccept = false;
	String Para[]={"c_faq_no","c_faq_psn","c_faq_email","c_faq_title","c_faq_content","t_faq_tm","c_reply_cont","c_reply_emp","t_reply_tm"};
	//begin process

	for(i=0;i<Para.length;i++)
	{
		info[i]=request.getParameter(Para[i]);
		if(info[i]==null)info[i]="";
	}
	
	formparaPre[0]=request.getParameter("username");
	if(formparaPre[0]==null)formparaPre[0]="guest";
	try
    {
        obj.setFormParaPre(ZConst.ACCEPT_FAQINFO,formparaPre);
        obj.setFormPara(ZConst.ACCEPT_FAQINFO,info);
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
    IsAccept = obj.getRetValueBool();
    if(IsAccept)  
    { %>
       <p><font color="#FF0000">提交成功!</font></p>
		 <% if(request.getParameter("feedback")!=null){	%>
			<p align="left">我们会及时处理或考虑您的建议。<br>非常感谢您的支持与合作！<br>
		 <% } %>
 <% }
    else {  %>
       <p> 提交失败 !   </p>
    <%   }    %>
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  
      </td>
    </tr>
 </table>   
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
