<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>  


<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 

<%@ include file="public/PublicMemLeft.jsp" %>      
  <td width="613"  valign="top">

<table border="0"
    width="80%" cellpadding="4">
      <tr>
<td width="5%">　　</td>
        <td>　
<p>　　作为我们的会员，您有权享用平安货运保险网站的一切功能：网上投保、网上报案、综合查询......赶快试一试吧。</p>

	</td>
      </tr>
<%
String clientVerifyFlag = sessionbuffer.getClientVerifyFlag(Locate);
String flag = "0";
String flag1 = "9";
String LinkPlyApp = "href=\"Find_PlyApp.jsp?MENU_REF=FindPlyApp\"";
String LinkPrp = "href=\"Find_PlyApp.jsp?MENU_REF=FindPrp\"";
String LinkPly = "href=\"MenuMid.jsp?MENU_REF=MENU_INSURANCE\"";
String temp="1234567";
if(clientVerifyFlag.equals(flag) || clientVerifyFlag.equals(flag1))
{
   LinkPlyApp = "";
   LinkPrp = "";
   LinkPly = "";
}
%>      
      <tr>
      <td colspan="2">
      	<!-- wu yan add images and hplink-->
	<img src="images/liuc.gif" width="399" height="99" usemap="#Map2" border="0">
	<map name="Map2">
	  <area shape="rect" coords="36,39,95,67">
	  <area shape="rect" coords="122,39,201,67"  <%=LinkPly%>>
	  <area shape="rect" coords="228,39,299,67"  <%=LinkPlyApp%>>
	  <area shape="rect" coords="326,39,385,67"  href="ViewHelp.jsp?path=songdan.txt" onclick="return js_openSmallPage(this.href);">
	  <area shape="rect" coords="236,87,293,96"  <%=LinkPrp%>>
	</map> 
	   
	      
      </td>
      </tr>
      
    </table>

      
 </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
