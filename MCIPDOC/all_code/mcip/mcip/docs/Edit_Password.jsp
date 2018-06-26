<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<%@ page language="java" import="java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="epb"  scope="request" class="beans.EditPasswordBean"/>

<!-- Get Para-->
<%
	String userMark = request.getParameter("USER_MARK");
	String cUserID = request.getParameter("C_USER_ID");
	String cRgstNo = request.getParameter("C_RGST_NO");
	//out.println("USER_MARK"+userMark);
	String ret[][] = null;
	
	try
	{
		epb.setFormPara(userMark,cUserID,cRgstNo);
		ret = epb.getRetValueArra();
	}
	catch(NormalException e)
    	{
 		if(NormalExceptionHandler.IsSevere(e))
 	    		throw NormalExceptionHandler.Handle(e);
    	}
    	
    	 //---- 不匹配 ----
    	if (ret == null)
    	{
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>错误</title>
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<!---link rel="stylesheet" href="style.css"--->
<!---link rel="stylesheet" href="TableStyle.css"--->
</head>

<body>
<div align="right">
<table width="778" border="0" cellspacing="0" cellpadding="0" height="270">
  <tr>
    <td><img src="images/toptable.gif" width="778" height="36" border="0"></td>
  </tr>
</table>

<p><img src="images/bline.gif" width="778" height="1"><br></p>
<p>
  <script language="JavaScript" src="bottom.js"> </script>
</p>
</body>
</html>
<%
	}
	// ---- 显示问题界面 ----
	else
	{
%>
<html>
<head>
<title>更新密码</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<style type="text/css"></style>
</head>

<body>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<table border="0" cellpadding="0" cellspacing="0" width="100%"><tr>
  <tr>
    <td><img src="images/toptable.gif" width="778" height="36" border="0"></td>
  </tr>
  <tr>
    <td height="270"> 
      <table width="778" border="0" cellspacing="0" cellpadding="0" >
        <tr>
          <td width="102" >&nbsp;</td>
          <td width="563" valign="top" > 
           
            <p><img src="images/xgmm.gif" width="150" height="35"></p>
            <table width="96%" border="0" cellspacing="0" cellpadding="0" height="13">
              <tr>
                <td width="55%" class="title"><p><h3><b>请重设密码 </b></h3></p></td>
                <td width="45%"> 
                  <div align="right"><font color="#FF0000">打*的项目必须填写</font></div>
                </td>
              </tr>
            </table>
            <br>
            <table width="96%" border="0" cellspacing="0" cellpadding="0" height="129" bgcolor="#FFFFFF" bordercolor="#999999">
		<form name="EntAnswerForm" method="post" action="ChangePassword.jsp" onsubmit="return(
			ValidNull(C_User_pw,false) &&
			ValidNull(ConfirmPassword2,false) &&
			ValidSame(C_User_pw,ConfirmPassword2));">
		
		<input type="hidden" name="C_USER_ID" value=<%=ret[1][0]%> >
		<input type="hidden" name="C_USER_NAME" value=<%=ret[1][1]%> >
		<input type="hidden" name="C_PW_QUESTION" value=<%=ret[1][2]%> >
		<input type="hidden" name="C_PW_RESULT_REALLY" value=<%=ret[1][3]%> >
	      <!--tr--> 
      		<!--td width="25%" >问&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：</td--> 
        	<!--td width="75%" ><%=ret[1][2]%></td-->
      	      <!--/tr-->
      	      <!--tr-->
        	<!--td width="25%" >回&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;答(*)：</td--> 
        	<!--td width="75%" ><input type="text" name="C_PW_RESULT" size="20" maxlength="50">（上述问题之答案）<font color="#FF0000">（字母分大小写）</font></td-->
      	      <!--/tr-->
              <tr>
        	<td width="25%" >输入新密码(*)：</td> 
        	<td width="75%" ><input type="password" maxlength="16" name="C_User_pw" size="20">（新的密码与前密码无关）</td>
      	      </tr>
      	      <tr>
        	<td width="25%" >确认新密码(*)：</td> 
        	<td width="75%" ><input type="password" maxlength="16" name="ConfirmPassword2" size="20">（必须与以上输入的新密码一致）</td>
      	      </tr>
    	    </table>
    	  </td>
    	</tr>
      </table>
    </td>  
  </tr>
</table>
  <div align="center">
  <p>
  <input type="submit" value="确定" name="B1">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
  <input type="reset" value="清除" name="B2">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input type="button" value="返回" onclick="history.back()">
  </p>
  </div>
  
</form>
<p><img src="images/bline.gif" width="778" height="1"><br></p>
<p>
  <script language="JavaScript" src="bottom.js"> </script>
</p>
</body>
</html>
<%
	}
%>
