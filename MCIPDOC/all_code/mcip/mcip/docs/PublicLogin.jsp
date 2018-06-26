<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<%
System.out.println("You are in publicLogin.jsp");
   String[] MenuRef = MenuMake.MenuRef;
      //{"MENU_MEMBER","MENU_CONSULTANT","MENU_INSURANCE","MENU_REPORT","MENU_INQUIRE"};
   String[][] ParaPub = 
 {{"images/m-member.gif","","",""},{"","","",""},{"images/ins_ins.gif","images/tblca.gif","images/art_cabotage.gif",""},{"images/rep_rep.gif","images/balc.gif","images/tblc.gif",""},{"images/m-inquire.gif","","",""},{"","","",""}
 ,{"images/m-inquire.gif","","",""},{"images/m-inquire.gif","","",""},{"images/m-member.gif","","",""}};   
//images/con_con.gif is evaluate of consultant
    String MenuRefStr = (String)request.getAttribute("MENU_REF");
    int i = 0;
    
    for(i=0;i<MenuRef.length;i++)
    {
         if(MenuRefStr.equals(MenuRef[i]))
            break;
    }
%>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="64">
  <tr> 
    <td width="167"><img src="images/ntoplogo.gif" width="238" height="66"></td>
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

<%
/*
<table width="778" border="0" cellspacing="0" cellpadding="0" height="64">
  <tr> 
    <td width="167"><img src="images/ntoplogo.gif" width="238" height="64"></td>
    <td width="611">
      <table width="540" border="0" cellspacing="0" cellpadding="0" height="64">
        <tr bgcolor="315E99"> 
          <td height="44">
            <div align="right"><img src="images/toplogo.gif" width="148" height="46"></div>
          </td>
        </tr>
        <tr>
          <td><script language="JavaScript"><%out.println(MenuMake.TopMenu(""));% ></script></td>
        </tr>
      </table>
    </td>
  </tr>
</table>
*/
%>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
    <td width="165" height="288" valign="top">
<%if(!(ParaPub[i][0].equals(""))){%>
<img src="<%=ParaPub[i][0]%>" width="190" height="54"><br>
<%}
if(i == 0 || i == 8)//member
{
%>
<img src="images/m-change1.gif" width="101" height="17" alt="会员资料" border="0"><br>
<img src="images/m-change2.gif" width="101" height="17" alt="修改密码" border="0"><br>
<img src='images/PlyTotal.gif' width='101' height='17' alt='业务统计' border='0'><br>
<img src="images/m_open.gif" width="101" height="17" alt="预约保险" border="0"><br>
<img src="images/baodpg-s.gif" width="101" height="17" alt="保单批改" border="0"><br>
<img src="images/zaixgt-s.gif" width="101" height="17" alt="在线沟通" border="0"><br>
<img src="images/m_pay.gif" width="101" height="17" alt="支付保费" border="0">
<%}
if(i == 4 || i==6 || i==7)//Inquire
{//maybe to dispaly LeftMenuInquire with no link
%>
<img src='images/m-tou.gif' width='101' height='17' alt='投保查询' border='0'><br>
<img src='images/m-jys.gif' width='101' height='17' alt='建议书查询' border='0'><br>
<img src='images/m-bao.gif' width='101' height='17' alt='保单查询' border='0'><br>
<img src='images/pidancx-s.gif' width='101' height='17' alt='批单查询' border='0'><br>
<img src='images/pigaicx-s.gif' width='134' height='17' alt='批改申请单查询' border='0'><br>
<img src='images/m-baoan.gif' width='134' height='17' alt='报案查询' border='0'><br>
<img src='images/m-lipei.gif' width='134' height='17' alt='理赔查询' border='0'>
<%}

if(i == 5)//evaluate
{%>
<script language="JavaScript" src="lmenu_consul.js"></script>
<%
}else
{
%>
<br>　<a href="index.jsp?Logout=0"><img src="images/hback.gif" width="80" height="50" alt="返回首页" border="0"></a>
<%}%>
    </td>
    <td width="613"  valign="top">
<%
if(i > 0)
{

   if(!(ParaPub[i][1].equals(""))){%>
    <br><br>
<img src="<%=ParaPub[i][1]%>" width="99" height="21">
   <%}
   if(!(ParaPub[i][2].equals(""))){%>
       
<img src="<%=ParaPub[i][2]%>" width="382" height="38">
<%   }
}%>
<table border="0"
    width="90%" cellpadding="4">
      <tr>
<td width="5%">　　</td>
        <td>　　
<p>　　作为本站的会员用户，可以享受到平安货运保险网站的一切功能，包括保费测算、网上投保、网上报案、综合查询等，在保费测算功能中，您可以了解各类货物、各种运输方式的保费信息，同时还可以在投保后第一时间内查询到承保条件。在保险理赔功能里，您可以调出以前曾经买过的保单，直接进行理赔报案和结果查询。一切原本必须经过多次传统通信方式处理的工作，现在通过网络不仅免除了您奔波之苦，工作效率和安全性也大大提高。

<p>　　如果您还不是会员，请进入“<a href="register.jsp" target="_blank"><font color="#ff0000">会员注册</font></a>”栏目。</p>

<FORM METHOD="POST" ACTION="ProcessLogin.jsp"  onSubMit="return (ValidNull(USER,false) && ValidNull(PSWD,false));" >
<table width="80%" bgcolor="#F6F6F6" cellpadding="4" >        
	<tr> 
          <td> 　<font color="#ff0000">■</font>　请登录：</td>
        </tr>
        <tr> 
          <td>用户名： 

            <input type="text" name="USER" size="16" maxlength="16">*
          </td>
        </tr>
        <tr> 
          <td>密&nbsp;&nbsp;码：
            <input type="password" name="PSWD" size="16" maxlength="16">*
            <input type="submit" name="Submit2" value="提交">
          </td>
        </tr>
</table>     
            <input type="hidden" name="MENU_REF" value="<%=MenuRefStr%>">  
</form>
</td>
      </tr>
    </table>
      
 </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
