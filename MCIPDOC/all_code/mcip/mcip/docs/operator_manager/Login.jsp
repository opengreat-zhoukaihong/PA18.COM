<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
String errCde = request.getParameter("errCde");
if (errCde == null)
	errCde = "";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>
<title>后台管理登录</title>
<link rel="stylesheet" href="style.css">
<body>
<script language=javascript src="../check.js">
</script>
<div align="right">

<address>
  平安保险
</address>
</div>
<form method="post" action="PreLogin.jsp" OnSubmit="return (ValidNull(C_OPR_CDE,false) && ValidNull(C_OPR_PW,false));">
<table border="0" width="375" bgcolor="#d8f0ff" align="center" height="238">
  <tr> 
    <td bgcolor="#99ccff" height=20> 
      <p align="center">后台管理登录 </p>
    </td>
  </tr>
  <%if (errCde.equals("0001")){%>
  <tr> 
    <td bgcolor="#99ccff" height=20 align="center"> 
      <font color= "red" size=2>服务器忙，请稍后再试！ </font>
    </td>
  </tr>
  <%}%>
  <%if (errCde.equals("0002")){%>
  <tr> 
    <td bgcolor="#99ccff" height=20 align="center"> 
      <font color= "red" size=2>登录失败，请检查用户/密码，并确定该用户已经被授权！</font>
    </td>
  </tr>
  <%}%>
  <tr> 
    <td valign="top"> 
		<table align=center border=0>
		  <tr>
			<td height=50>
				&nbsp;
			</td>
		  </tr>

			<tr>
			  <td>
				帐&nbsp;&nbsp;号&nbsp;/&nbsp;Account： 
			    &nbsp;</td>
				<td>
				<input type="text" name="C_OPR_CDE" size="15" maxlength="10">*
			  </td>
		  </tr>
		  <tr>
			  <td >密&nbsp;&nbsp;码&nbsp;/&nbsp;password：
			  </td>
			  <td>
				    <input type="password" name="C_OPR_PW" size="15" maxlength="6">*
		      </td>
		</tr>
		<tr>
		  <td align="center" colspan=2> 
			<input type="submit" value="登录/Login" name="SubmitLog">
	      </td>
		 </tr>
		</table>
      </td>
  </tr>
</table>
</form>
</body>
</html>
