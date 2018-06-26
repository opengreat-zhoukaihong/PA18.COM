<%
/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 15:05:18
*Modify id : 0001
*Modifier : WuYan
*Reason : I.Modify Html Style(format、Color 、table) of page 
*		II. process logic of code
***********************************************************************************************
*/
%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>条款内容显示</title>
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">


<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
	//2001-4-17String Content=null;
	//2001-4-17String FileContent=null;
	String FilePath=request.getParameter("path");
	  /*2001-4-17try
	  {
	     FileContent = Servlets.GetFileContent(FilePath);
	  }
     catch(NormalException e)
	  {
	 	if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
		}2001-4-17*/
/*     catch(NormalException e)
	  {
	 	if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	 	else if(NormalExceptionHandler.IsWarning(e))    
	 	     String WarnMsg = e.getErrDesc(); 
	 	    
	  }
*/     /*2001-4-17catch(Exception e)
	  {
		out.println("err="+e);
	  }
	  if((FileContent == null) || (FileContent == ""))FileContent="没有条款内容!!";2001-4-17*/
%>
<img src="images/art_topline.gif" width="560" height="36" border="0" alt="货运保险网">
<table border="0" width="80%" bordercolordark="#006633" bordercolorlight="#339966" align="center">
  <tr> 
    <td width="89%" height="306"> 
        <div align="center">
	   <font color="#00656a">条款内容</font>
	</div>
	<br>
		<%if (FilePath.equals("dom_water_land_cargo.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/dom_water_land_cargo.txt"%></textarea>
		<%}%>
		<%if (FilePath.equals("sea_cargo.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/sea_cargo.txt"%></textarea>
		<%}%>
		<%if (FilePath.equals("air_cargo.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/air_cargo.txt"%></textarea>
		<%}%>
		<%if (FilePath.equals("land_cargo.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/land_cargo.txt"%></textarea>
		<%}%>
		<%if (FilePath.equals("ICC-A.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/ICC-A.txt"%></textarea>
		<%}%>
		<%if (FilePath.equals("ICC-B.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/ICC-B.txt"%></textarea>
		<%}%>
		<%if (FilePath.equals("ICC-C.txt")){%>
			<textarea name="T9" cols="75" rows="18" onkeydown="return false;"><%@ include file="clause/ICC-C.txt"%></textarea>
		<%}%>
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
