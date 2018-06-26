<%@ include file="public/Public.jsp" %>
<jsp:useBean id="xmlHandler" scope="page" class="beans.XMLDealerBean"/>
<%
String absolutePath = request.getRealPath("/");
String savedFileName = (String)request.getAttribute("savedFileName");
out.println(absolutePath);
xmlHandler.readXML(absolutePath+"upload/"+savedFileName);
%>
