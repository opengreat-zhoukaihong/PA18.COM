<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<table width="778" border="0" cellspacing="0" cellpadding="0" height="64">
  <tr> 
    <td width="167"><img src="images/topl.gif" width="240" height="64"></td>
    <td width="611">
      <table width="540" border="0" cellspacing="0" cellpadding="0" height="64">
        <tr> 
          <td height="46"><img src="images/topright.gif" width="540" height="46"></td>
        </tr>
      
      </table>
    </td>
  </tr>
</table>
<%@ page language="java" import="utility.*,exceptions.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
   response.setHeader("Pragma","No-Cache");
   response.setDateHeader("Expires",0);
   response.setHeader("Cache-Control","no-Cache");
%>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>

<%
   if(!Init.isInit())
   {
       boolean isOk = false;
       isOk = Init.initAll();
       if(!isOk)
            throw NormalExceptionHandler.Handle(ExceptionCode.SYS_INIT_FAILURE);       
       
   }    
   String Remote = (String)request.getAttribute("REMOTE");   
   boolean IsRemote = true;
System.out.println("now you are in Login.jsp:"+Remote);   
   if(Remote == null)
   {
       IsRemote = false;
       ob.setRemoteOperType("");
       ob.setRemoteData(null);
   }
%>

<table border="0" width="100%" height="381" bordercolordark="#006633" bordercolorlight="#339966">
  <tr> 
    <td width="11%" height="391">　 
    </td>
    <td width="21%" height="391">　
<FORM METHOD="POST" ACTION="ProcessLogin.jsp"  onSubMit="return (ValidNull(USER,false) && ValidNull(PSWD,false));" >
        <p align="left">用户名/User name:
          <input type="text" name="USER" size="15" maxlength="20">*
        </p>
        <p align="left">密码/password:&nbsp;&nbsp;&nbsp;
          <input type="password" name="PSWD" size="15" maxlength="8">*
        </p>
        <p align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" value="登录/Login" name="SubmitLog">
        </p>
        <p align="center">&nbsp;</p>
</form>
<%if(!IsRemote){%>
    <p><a href="request.htm">忘记密码怎么办？</a></p>
      <p>新会员注册 (
		<span onmouseover="this.className='bigChange'" onmouseout="this.className='start'" class="start">
		<a href="AcceptPrsnCust.jsp">个人</a></span>或
		<span onmouseover="this.className='bigChange'" onmouseout="this.className='start'" class="start">
		<a href="AcceptOrgnCust.jsp">机构</a></span>或
		<span onmouseover="this.className='bigChange'" onmouseout="this.className='start'" class="start">
		<a href="agent_register.jsp">代理</a></span>)</p>
<%}%>		
    </td>
<%if(!IsRemote){%>    
    <td width="79%" height="391"> 
      <p align="center">
		<!--font size="5"-->
			<strong>平安简介</strong>
	        <!--%@ include file="/images/jj.txt" %-->
		<!--/font--></p>
 </td>
<%}%>		
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
