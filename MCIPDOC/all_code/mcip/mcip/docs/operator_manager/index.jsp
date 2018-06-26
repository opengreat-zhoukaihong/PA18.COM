<%@ page language="java" import="java.lang.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
String errCde = request.getParameter("errCde");
if (errCde == null)
	errCde = "";
 System.out.println(request.getParameter("sessionId")); 
 String sessionId=Code.Decrypt(request.getParameter("sessionId"));
 if (sessionId != null && sessionId.length() > 0){
	//request.getSession(true).putValue("sessionId",Code.Encrypt(sessionId));
 }else{
	sessionId = Code.Decrypt((String)request.getSession(false).getValue("sessionId"));
 }
 SessionUser sessionuser = SessionUser.getSessionUser();
 int Locate = -1;
	try
	{
		Locate = sessionuser.ProcessSession(Const.SESSAUTH,sessionId);
	}
	catch (Exception e)
	{
		Locate = -1;
	}
  System.out.println("SessionId:"+sessionId);
  System.out.println("Locate:"+Locate);
  if(request.getParameter("logout")!=null){
    if(Locate>0){
     String myName= sessionuser.getuserId(Locate);
     if(request.getParameter("logout").equals("1")){
      System.out.println("This is SEverExit in index.jsp ");
      MessageBean mb = MessageBean.instance;
      mb.ServerExit("", myName);
     }
    }
  }  
 %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style/backStyle.css">
</head>
<script language="JavaScript" src="check.js">
</script>
<body bgcolor="#007B78">

<form method="post" action="PreLogin.jsp" OnSubmit="return (ValidNull(C_OPR_CDE,false) && ValidNull(C_OPR_PW,false));" name="f">
<table width="80%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr valign="top"> 
    <td height="211"> 
      <div align="center"><br>
        <br>
        <br>
        <img src="images/homepage.gif" width="301" height="88" alt="平安货运险/后台管理系统" border="0"></div>
    </td>
  </tr>
  <tr valign="top"> 
    <td height="103"> 
      <table width="65%" border="0" cellspacing="3" cellpadding="2" align="right" class="td">
		  <%if (errCde.equals("0001")){%>
		  <tr> 
			<td height=20 align="center" colspan="2"> 
			  <font color= "#FFCC00" size=2>服务器忙，请稍后再试！ </font>
			</td>
		  </tr>
		  <%}%>
		  <%if (errCde.equals("0002")){%>
		  <tr> 
			<td height=20 align="center" colspan="2"> 
			  <font color= "#FFCC00" size=2>登录失败，请检查用户/密码，并确定该用户已经被授权！</font>
			</td>
		  </tr>
		  <%}%>
        <tr> 
          <td width="34%" height="15"> 
            <div align="right"><font color="#FFFFFF">帐 号：</font></div>
          </td>
          <td height="15" colspan="2"> 
            <input type="text" name="C_OPR_CDE" style="background-color:#00A8A8" size="15" maxlength="10">
          </td>
        </tr>
        <tr> 
          <td width="34%"> 
            <div align="right"><font color="#FFFFFF">密 码：</font></div>
          </td>
          <td colspan="2"> 
            <input type="password" name="C_OPR_PW" style="background-color:#00A8A8" size="15" maxlength="6">
          </td>
        </tr>
        <tr> 
          <td width="34%">&nbsp;</td>
          <td width="27%"> 
            <div align="right"><input type="submit" value="登录"></div>
          </td>
          <td width="39%">&nbsp;</td>
        </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
