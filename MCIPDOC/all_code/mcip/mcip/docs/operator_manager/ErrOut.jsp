<%@ page language="java" isErrorPage="true" import="java.util.*,exceptions.*,utility.*" contentType= "text/html; charset=gb2312" %>
<%response.setContentType("text/html; charset=gb2312");%>
<html>
<head>
<title>平安货运险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style/backStyle.css">
</head>

<body bgcolor="FBFAF3" topmargin="0" leftmargin="0">
<table width="776" border="0" cellspacing="0" cellpadding="0">
  <tr bgcolor="#007B78"> 
    <td height="43" width="10%" bgcolor="019490">&nbsp;</td>
    <td height="43" width="90%" bgcolor="019490"><img src="images/di_r01_c2.jpg" width="247" height="41"></td>
  </tr>
</table>
<table width="776" border="0" cellspacing="0" cellpadding="0" height="3" bgcolor="#EEEEEE">
  <tr> 
    <td height="2"></td>
  </tr>
</table>
<table width="776" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="15%" height="25"><img src="images/di_r03_c1.jpg" width="137" height="31"></td>
    <td width="85%" background="images/di_r03_c3.jpg" height="25"> 
      <table border="0" cellspacing="0" cellpadding="0" class="unnamed2">
      </table>
    </td>
  </tr>
</table>


<table width="776" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="157" width="14%" valign="top" background="images/di_r05_c1.jpg"><img src="images/di_r04_c1.jpg" width="137" height="43"><br>
      <table width="100%" border="0" cellspacing="0" cellpadding="0" class="td">
        <tr> 
          <td height="6"></td>
        </tr>
		<tr>
			<td height="21"  background="images/di_r06_c1.jpg">
				<div align="center"> <a href="index.jsp">&nbsp;返回首页</a> </div>
			</td>
		</tr>
        <tr > 
          <td height="22"> 
            <div align="center"></div>
          </td>
        </tr>
        <tr> 
          <td height="22">&nbsp;</td>
        </tr>
      </table>
    </td>
    <td height="157" width="86%" valign="top"> <br>

错误信息提示:
<p></p>
<BR>
<% String ErrDesc = "";
   String ErrModu = "";
   String ErrCode = "";
   if(exception instanceof NormalException)
   {
      NormalException ne = (NormalException) exception; 
//      ErrDesc = Tools.ConvertCN(ne.getErrDesc());
      ErrDesc = ne.getErrDesc();
      ErrCode = ne.getErrCode();
      ErrModu = ne.getErrModu();

%>
错误描述:<%=ErrDesc%> <br>     
<% }
   else
   {
     String errText = new String(Tools.ConvertCN(exception.getMessage()));
      if(errText.indexOf("Cannot create bean of class ")>=0){
         errText  =" CORBA应用服务器没有启动！请稍等，或与管理员联系。";         
      }      

%>
错误描述：<%=errText%>,<%//=exception.toString()%>
<%
   }
%>
<p>
</p>
<p>
</p>
<p>
</p>

  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  
<%@ include file="public/bottom.jsp"%>