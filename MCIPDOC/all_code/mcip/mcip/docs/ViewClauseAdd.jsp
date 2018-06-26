<%@ page language="java" import="java.lang.*,java.io.*,java.util.*,utility.*,exceptions.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%
   String ClausePath = request.getParameter("ClausePath");
   String FileContent = "";
   ClausePath = Code.Decrypt(ClausePath);
  try
  {
     FileContent = Servlets.GetFileContent(ClausePath);
  }
  catch(NormalException e)
  {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
  }   

%>    
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>附加险条款</title>
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0' marginheight="0">

<img src="images/art_topline.gif" width="560" height="36" border="0" alt="货运保险网">
<table border="0" width="80%" bordercolordark="#006633" bordercolorlight="#339966" align="center">
  <tr> 
    <td width="89%" height="306"> 
        <div align="center">
	   <font color="#00656a">条款内容</font>
	</div>
	<br>
        <textarea name="T9" cols="70" rows="18" onkeydown="return false;"><%=FileContent%></textarea>
      </td>
  </tr>
</table>
<form>
<p align="center">
  <input align="center" type="button" value="关闭窗口" name="B44" onclick='javascript:window.close();'>
</p>
</form>
 <p align="center">
    <font color="00656a">
       CopyRight&copy; 中国平安保险股份有限公司版权所有
    </font>
 </p>

</body>
</html>
