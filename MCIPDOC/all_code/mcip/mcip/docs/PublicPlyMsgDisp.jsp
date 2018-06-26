<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>
      
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 

<%@ include file="public/PublicPlyLeft.html" %>
<String Msg = (String)request.getAttribute("PLY_MSG");>
    <td width="613" height="288" valign="top"> <br>
    <%=Msg%>
  </tr>
  <tr>
   <input type="button" value="返  回" name="B44" onclick='javascript:history.back();'>                    
  </tr>
  </td>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
