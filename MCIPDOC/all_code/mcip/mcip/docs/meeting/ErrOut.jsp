<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<!---link REL=STYLESHEET TITLE=text TYPE=text/css href=../index.css--->
<link REL=STYLESHEET TITLE=text TYPE=text/css href=../table.css>
</head>
<body bgcolor="#ffffff" leftmargin="0" topmargin="0">
<%@ page language="java" isErrorPage="true" import="java.util.*,beans.*,exceptions.*,utility.*" contentType= "text/html; charset=gb2312" %>

<% String ErrDesc = "";
   String ErrModu = "";
   String ErrCode = "";
   if(exception instanceof NormalException)
   {
      NormalException ne = (NormalException) exception;
      //ErrDesc = Tools.ConvertCN(ne.getErrDesc());
      ErrDesc = ne.getErrDesc();
      ErrCode = ne.getErrCode();
      ErrModu = ne.getErrModu();      
   }
   else
   {
     ErrDesc = new String(Tools.ConvertCN(exception.getMessage()));
   }
%>


<table  border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

    <td width="613"  valign="top">

<table border="0"
    width="80%" cellpadding="4">
      <tr>
<td width="5%">&nbsp;　　</td>
        <td><p align="center"><img src="error.gif">　

<p>　　　　　<%=ErrDesc%></p>

</td>
      </tr>
    </table>
  <form>
  <div>
	<center><input type="button" value="关闭" name="B44" onclick='javascript:window.close();'></center>
  </div>
  </form>
 </td>
  </tr>
</table>


</body>
</html>
