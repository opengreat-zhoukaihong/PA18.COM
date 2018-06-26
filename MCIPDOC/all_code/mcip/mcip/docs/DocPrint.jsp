<%@ page language="java"%>
<%@ page import="beans.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType= "text/html; charset=gb2312"%>
<html>
<body>
<OBJECT ID ="AXprint"  WIDTH=0 HEIGHT= 0 
    CLASSID ="CLSID:FF2426E6-7C68-11D5-8533-0000E84438A5"
    CODEBASE = "http://10.16.102.1:85/MDocPrinter.ocx">
</OBJECT>
<%
/**
**downloadStatus: describe the which step is downloading in 
**		the valid value is as follows:
**		0:sucessfully finished
**		1:not start yet
**		2:no error until now(not finished yet)
**		3: terminated with error
**		4: terminated without error
**/
String[] condStr = null;
String combinedSqlStr = request.getParameter("combinedSqlStr");
boolean onDownload = false;
String errDesc = "";
if (combinedSqlStr != null){// means  sqlstring array is ready
	onDownload = true;
	String tempStr = "";
	if (combinedSqlStr.length() == 0){
		return;
	}
	// parse the string into the condition
		try{
			StringTokenizer token = new StringTokenizer(combinedSqlStr,"|");
			int tokenLength = token.countTokens();
			String[] condMatrix = new String[tokenLength];
			for (int i=0;i<tokenLength;i++){
				condMatrix[i] = token.nextToken();
			}
			out.println("On processing...");
			out.println("condMatrix:"+condMatrix[0]);
			beans.PolicyPrintBean pb = new beans.PolicyPrintBean();
			condStr = pb.getPrintFormats(condMatrix);
			out.println("i:"+condStr+"<br>");
		}catch(Exception e){
			out.println(e);
		}
		if (condStr == null){
			out.println("condStr:"+condStr);
			return;
		}
		%>
			<script language="JavaScript">
				var resultNum;
				var sqlStrSet ="";
				var res = AXprint.SetDnDptCde('201');
				resultNum = AXprint.iSqlNum;
				alert("resultNum:"+resultNum+"\ncondStr.length:"+<%=condStr.length%>);
				<%for (int i=0;i<condStr.length;i++){
					if (condStr[i] == null)
						continue;
			%>
				alert("i:"+<%=i%>);
			AXprint.iRetCode = 0;
			AXprint.sRetValue = '<%=condStr[i]%>';
			AXprint.RetDnResult(<%=i%>);
		<%}%>
			</script>
	<%}%>

<form name="PrintDocForm" action="" method="post">
<input type="button" name="b_down" value="download FMT" onclick="download();">
<input type="text" size ="200" name="combinedSqlStr" value="">
</form>
</body>
</html>
<script language="JavaScript">
</script>
<script language="JavaScript">
function changeAction(url){
	PrintDocForm.action=url;
	return;
}
function download(){
	if (fmtBuild()){
		changeAction("DocPrint.jsp");
		PrintDocForm.submit();
	}
}
function fmtBuild(){
	var resultNum;
	var sqlStrSet ="";
	var res = AXprint.SetDnDptCde('201');
	if (res != 0){
		return false;
	}
	resultNum = AXprint.iSqlNum;
	alert("iSqlNum:"+AXprint.iSqlNum);
	for (i = 0;i<resultNum;i++){
		AXprint.GetSqlStr(i);
		sqlStrSet +=AXprint.sSqlStr + "|";
	}
	alert(sqlStrSet);
	PrintDocForm.combinedSqlStr.value= sqlStrSet;
	return true;
}

function saveFormat(){
	AXprint.iRetCode = 0;
	AXprint.sRetValue = "aaaaaaa";
	AXprint.RetDnResult(0);
}
</script>
