<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<%@ include file="public/Public.jsp" %>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicMemLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/In_PlyTotal.gif" width="150" height="31" alt="业务统计查询">
  <form name="form2" action="Userplytotal.jsp" onsubmit="return(ValidYear(form2.year) && ValidMonth(form2.month));"method="post">
	<table border="0" width="70%" bgcolor="#F6F6F6" align="left" height="200">
	  <tr> 
	    <td bgcolor="#F6F6F6" valign="top" height="227"> 
	      <p>请选择您要统计的业务类型：</p>
	      <blockquote> 
		<p> 
		  <input type="checkbox" name="type0" value="B01">
		  进口货运 
		  <input type="checkbox" name="type1" value="B02">
		  出口货运 </p>
		<p> 
        <input type="checkbox" name="type2" value="B23">
         国内铁路 
        <input type="checkbox" name="type3" value="B33">
         国内公路 
        <input type="checkbox" name="type4" value="B13">
         国内水路 
        <input type="checkbox" name="type5" value="B43">
			国内航空
		</p>
	      </blockquote>
	      <p> 请输入您要统计的时间： </p>
	      <blockquote> 
		<p> 
		  <input type="text" name="year" size="4" maxlength="4" value="<%=new java.util.GregorianCalendar().get(java.util.GregorianCalendar.YEAR)%>">
		  年 
		  <input type="text" name="month" size="2" maxlength="2" value="<%= new java.util.GregorianCalendar().get(java.util.GregorianCalendar.MONTH)+1%>">
		  月 </p>
	      </blockquote>
		<br>
		<p align="center"> &nbsp;&nbsp; 
		  <input type="submit" value="查询" name="B1"  onClick="">
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		  <input type="reset" value="清除" name="B22">
		</p>
	    </td>
	  </tr>
	</table>
</form>
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   

</body>
</html>

