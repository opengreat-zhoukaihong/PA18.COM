<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="xmlHandler" scope="page" class="beans.XMLDealerBean"/>
<jsp:setProperty name="xmlHandler" property="*"/>
<html>
<head>
	<title>Test</title>
</head>

<body>
<%
java.util.Hashtable ht = null;
String fileContent = 	(String)request.getAttribute("fileContent");
out.println(fileContent);
if (fileContent != null && fileContent.trim().length()>0){
	//String absolutePath = request.getRealPath("/");
	//absolutePath="/data1/pa18/nul/mcip/";
	//out.println("absolutepath:"+absolutePath+"upload/"+fileName+"<br>");
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
out.println(ht);
%>

</body>
</html>
