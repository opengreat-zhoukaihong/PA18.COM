<%@ page language="java" import="java.beans.Beans,java.lang.*,java.lang.reflect.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,com.jspsmart.upload.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
String nextUrl = "DocPrint.jsp";
String originalSqlStr = request.getParameter("combinedSqlStr");
if (originalSqlStr == null || originalSqlStr.length() == 0){
	out.println("Null Sql condtion!");
	return;
}
// parse the string into the condition
try{
StringTokenizer token = new StringTokenizer(originalSqlStr,"|");
int tokenLength = token.countTokens();
String[] condMatrix = new String[tokenLength];
for (int i=0;i<tokenLength;i++){
	StringTokenizer tempToken = new StringTokenizer(token.nextToken(),"#");
	tempToken.nextToken();// skip the first length field
	condMatrix[i] = tempToken.nextToken();
}

beans.PolicyPrintBean pb = new beans.PolicyPrintBean();
String condStr [] = pb.getPrintFormats(condMatrix);
request.setAttribute("condStr",condStr);
}catch(Exception e){
}
%>
<jsp:forward page="DocPrint.jsp"/>