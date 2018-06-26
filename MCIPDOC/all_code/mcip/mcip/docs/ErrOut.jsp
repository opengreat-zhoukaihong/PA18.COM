<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<!---link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css--->
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ page language="java" isErrorPage="true" import="java.util.*,beans.*,exceptions.*,utility.*" contentType= "text/html; charset=gb2312" %>

<%

   System.out.println("ERROUT.jsp page start -------------------------------"+exception.toString());



   String ErrDesc = "";
   String ErrModu = "";
   String ErrCode = "";


   if(exception instanceof NormalException)
   {
      NormalException ne = (NormalException) exception;
//      ErrDesc = Tools.ConvertCN(ne.getErrDesc());
      ErrDesc = ne.getErrDesc();
      ErrCode = ne.getErrCode();
      ErrModu = ne.getErrModu();
   }else if(exception instanceof ServletException){

      ErrDesc = new String(Tools.ConvertCN(exception.getMessage()));
      if(ErrDesc.indexOf("Cannot create bean of class ")>=0){
         ErrDesc  =" CORBA应用服务器没有启动！请稍等，或与管理员联系。";
      }

   }
   else
   {

     ErrDesc = new String(Tools.ConvertCN(exception.getMessage()));
     if(ErrDesc==null || ErrDesc.trim().length()==0){
       ErrDesc =   exception.toString();
     }



   }
%>
<%@ include file="public/NoLoginPublic.html" %>
<!--table width="778" border="0" cellspacing="0" cellpadding="0" height="64">
  <tr>
    <td width="167"><img src="images/topl.gif" width="238" height="64"></td>
    <td width="611">
      <table width="540" border="0" cellspacing="0" cellpadding="0" height="64">
        <tr bgcolor="315E99">
          <td height="44">
            <div align="right"><img src="images/toplogo.gif" width="148" height="46"></div>
          </td>
        </tr>
        <tr>
          <td><script language="JavaScript"><%out.println(MenuMake.TopMenu(""));%></script></td>
        </tr>
      </table>
    </td>
  </tr>
</table-->
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
    <td width="165" height="288" valign="top">

<br>　<a href="index.jsp"><img src="images/hback.gif" width="80" height="50" alt="返回首页" border="0"></a>
    </td>
    <td width="613"  valign="top">

<table border="0"
    width="80%" cellpadding="4">
      <tr>
<td width="5%">　　</td>
        <td><br><img src="images/sysinfo.gif" width="150" height="31" alt="系统信息"><p>　

<p>　　　　　<%=ErrDesc%><%//exception.printStackTrace(new java.io.PrintWriter(out));%></p>

</td>
      </tr>
    </table>
  <form>
  <div>
	<center><input type="button" value="前一页" name="B44" onclick='javascript:history.back();'></center>
  </div>
  </form>
 </td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>

</body>
</html>
