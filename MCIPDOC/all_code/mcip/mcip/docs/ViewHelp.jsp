


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL="STYLESHEET" TITLE="text" TYPE="text/css" href="index.css">
<title>帮助</title>

</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
        
	String Content=null;
	String FileContent=null;
	String FilePath=request.getParameter("path");
        FilePath = request.getRealPath("/helptxt/"+ FilePath) ;
        //out.println(FilePath);
	  try
	  {
	     FileContent = Servlets.GetFileContent(FilePath);
	  }
     catch(NormalException e)
	  {
	 	if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
		}
  
%>
<p><image src="images/art_topline.gif" width="380" height="36" border="0" alt="货运保险网">
<p><image src="images/inline-help1.gif" border=0>

   <%=FileContent%>
</P>

<form name="form1">
<p align="center">
  <input  type="button" value="关闭窗口" name="B44" onclick="javascript:window.close();">
</p>
</form>
<p align="center">
    <font color="00656a" >
       CopyRight&copy; 中国平安保险股份有限公司版权所有
    </font>
 </p>

</body>
</html>
