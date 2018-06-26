<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>


<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
form1.checkply.focus();
form1.checkdate.focus();
</SCRIPT>
<%
   String SdateFrom[] = Servlets.DivideMultiStr(ServTool.getSysDate(-30),"-");
   String SdateTo[] = Servlets.DivideMultiStr(ServTool.getSysDate(0),"-");
   
%>


<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
<%
if(MenuRef.equals("MENU_REPORT"))
{
%>
<td width="165" height="288" valign="top">
<img src="images/rep_rep.gif" width="190" height="54"><br>
<br>　<a href="index.jsp?Logout=0"><img src="images/hback.gif" width="80" height="50" alt="返回首页" border="0"></a>
</td>
<%
}
else
{
%>
<%@ include file="public/PublicInquireLeft.jsp" %>      
<%
}
%>
    <td width="613" height="288" valign="top"> <br>
      <img src="images/m_inq2.gif" width="150" height="31" alt="保单查询">

 <table border="0" width="70%" cellpadding="4" >
 
  <tr> 
<td width="5%">　</td>
    <td bgcolor="#F6F6F6">
    
<form name="form1" METHOD="POST" action="PolicyList.jsp" onsubmit="return(
   IsChecked(checkdate) ||
   (ValidDateNew(tempdatefr,year_fr)&&
   ValidDateNew(tempdateto,year_to))
);">
        <p>请输入您的查询条件：(可按保单号或时间范围进行查询)</p>
        <p > 
          <input type="checkbox" name="checkply" value="1" onclick="PlyDisable(checkply,C_PLY_APP_NO);" onfocus="PlyDisable(checkply,C_PLY_APP_NO);">
          保单号: 
          <input type="text" name="C_PLY_APP_NO" size="25" maxlength="20">
          </p>
        <p> 
          <input type="checkbox" name="checkdate" value="1" onclick="DateDisable(checkdate,
          year_fr,month_fr,day_fr,year_to,month_to,day_to);" onfocus="DateDisable(checkdate,
          year_fr,month_fr,day_fr,year_to,month_to,day_to);">
          时间范围:
&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
	</p>
        <p>　　从：
          <input type="text" name="year_fr" size="5" maxlength="4" value="<%=SdateFrom[0]%>">
          年 
          <input type="text" name="month_fr" size="3" maxlength="2" value="<%=SdateFrom[1]%>">
          月 
          <input type="text" name="day_fr" size="3" maxlength="2" value="<%=SdateFrom[2]%>">
          日</p>
        <p>　　到：
          <input type="text" name="year_to" size="5" maxlength="4" value="<%=SdateTo[0]%>">
          年 
          <input type="text" name="month_to" size="3" maxlength="2" value="<%=SdateTo[1]%>">
          月 
          <input type="text" name="day_to" size="3" maxlength="2" value="<%=SdateTo[2]%>">
          日</p>
           <input type="hidden" name="tempdatefr" value="2000-08-28">
           <input type="hidden" name="tempdateto" value="2000-08-28">           
          <div align="left"><br>
            &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="确定" name="B1" onclick="change(year_fr,month_fr,day_fr,tempdatefr);change(year_to,month_to,day_to,tempdateto);">
            <input type="reset" value="清除" name="B2">
          </div>
    <input type="hidden" name="<%=Const.C_AGENCY_NO%>" value="<%=Const.CASE%>">      
    <input type="hidden" name="<%=MenuMake.MENU_REF%>" value="<%=MenuRef%>">      
</form>

         </td>
    </tr>
  </table>
    
       
        </div>
   
      
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
