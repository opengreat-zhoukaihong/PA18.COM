<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<jsp:useBean id="xmlDocOperator" scope="page" class="ken.xmlDocOperator"/>
<%@ page contentType="text/html; charset=GB2312" %>
<html>
<head>
	<title>Test</title>
</head>

<body>
<%
java.util.Hashtable ht = null;
//String fileContent = 	(String)request.getAttribute("fileContent");
//out.println(fileContent);
String fileName = session.getValue("fileName").toString();
out.println("file name is "+fileName);
String absolutePath = request.getRealPath("/");
String url = absolutePath+"upload/"+fileName;
try{
  xmlDocOperator.setFileName(url);
  xmlDocOperator.parseFile();
  ht = xmlDocOperator.getPolicyHash();
}catch(Exception ex){
  ht = null;
  out.println("ex is "+ex+"<br>");
}
out.println("<br>ht is ");
out.println(ht);
/*if (fileContent != null && fileContent.trim().length()>0){
	try{
		xmlHandler.parseXML(new java.io.StringBufferInputStream(fileContent));
		ht = xmlHandler.getPolicyHash();
	}catch(Exception e){
		ht = null;
		e.printStackTrace(new java.io.PrintWriter(out));
		out.println(e+"<br>");
	}
	if (ht!= null && ht.size() == 0)
		ht = null;
}
out.println(ht);*/
%>

</body>
</html>
