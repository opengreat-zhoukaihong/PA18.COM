<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<% 
        if (!Init.isInit())
        {
            Init.initAll();
        }
    //del old user info
    String OperType = request.getParameter("Logout");
    System.out.println("you are in index.jsp:"+OperType);
    if(OperType == null || OperType.equals("0"))
    {
      HttpSession https = request.getSession(true);
      String sessionId = https.getId();

	    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
	    sessionbuffer.ProcessSession(Const.SESSDEL,sessionId);
    }
    
%>    

<table width="778" border="0" cellspacing="0" cellpadding="0" height="64">
  <tr> 
    <td width="167"><img src="images/topl.gif" width="240" height="64"></td>
    <td width="611">
      <table width="540" border="0" cellspacing="0" cellpadding="0" height="64">
        <tr>
          <td height="46"><img src="images/topright.gif" width="540" height="46"></td>
        </tr>
        <tr>
          <td><script language="JavaScript"><%out.println(MenuMake.TopMenu(""));%></script></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<form action="test.jsp" method="post">
  <p align="center">User:<input type="text" name="user">
  <p align="center">Message:<input type="text" name="message">
  <p align="center"><input type="submit" name="submit1" value="Send">
</form>



<%@ include file="public/PublicBottom.html" %>

</body>
</html>
