<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/NoLoginPublic.html" %>

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
	String username=request.getParameter("username");
	if(username==null)username="2";
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr> 
    <%@ include file="public/PublicConsultLeft.html" %> 
    <td valign="top" height="363"> 
     <p>
       <img src="images/consul_1.gif" width="150" height="31" alt="险种咨询">
     </p>
      <form name="EntAnswerForm" method="POST" action="Zsubm_inputfaq.jsp" onsubmit="return(
ValidNull(c_faq_psn,false) &&
ValidNull(c_faq_title,false) &&
ValidNull(c_faq_content,false) &&
ValidNull(c_faq_email,false) &&
ValidEmail(c_faq_email) 
);">
		
	<input TYPE="hidden" NAME="username" VALUE="<%=username%>">

        <font color="#0000CC">在这里输入您的咨询问题</font><br>
	<table width="100%" border="0" cellspacing="4" cellpadding="0">
	  <tr bgcolor="#F9F9FF" height="30"> 
            <td> 
              <div align="left">咨询人： &nbsp; 
                <input type="text" name="c_faq_psn" value="" maxlength="30" size="30">
              </div>
            </td>
          </tr>
          <tr bgcolor="#F9F9FE"  height="30"> 
            <td>E-MAIL：&nbsp;&nbsp;
              <input type="text" name="c_faq_email" value="" maxlength="30" size="30">
            </td>
          </tr>
          <tr bgcolor="#F9F9FD"> 
            <td>咨询标题： 
              <input type="text" name="c_faq_title" value="" maxlength="30" size="30">
            </td>
          </tr>
          <tr bgcolor="#F9F9FC"  height="30"> 
            <td height="65"> 咨询内容： <br>
              <textarea name="c_faq_content" cols="70" rows="4"></textarea>
              <br>
            </td>
          </tr>
        </table>
        <p align="center"> 
          <input type="submit" value="提交" name="B1">
        </p>
      </form>
    </td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>
</body>
</html>
        
                                               
