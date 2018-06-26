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
String condStr = null;
String combinedSqlStr = request.getParameter("combinedSqlStr");
String errDesc = "";
if (combinedSqlStr != null){// means  sqlstring array is ready
	String tempStr = "";
	if (combinedSqlStr.length() == 0){
		return;
	}
	// parse the string into the condition
		try{
			out.println("On processing...");
			beans.PolicyPrintBean pb = new beans.PolicyPrintBean();
			condStr = pb.getPrintPolicy(combinedSqlStr);
			out.println("condStr Length:"+condStr.length());
		}catch(Exception e){
			out.println(e);
		}
		if (condStr == null){
			out.println("condStr:"+condStr);
			return;
		}
		%><form name="temp">
				<textarea name="tt" rows="5" cols="70"><%=condStr%></textarea>
			</form>
			<script language="JavaScript">
			//BuildPolicy();
			alert("OCX initialized");
			alert("iSqlNum:"+AXprint.iSqlNum+"condStr.length:"+<%=condStr.length()%>);
			AXprint.iRetCode = 0;
			AXprint.sRetValue = temp.tt.value;
			alert("textarea length:"+temp.tt.value.length);
			alert("condStr length:"+<%=condStr.length()%>);
			alert(AXprint.sRetValue);
			var r = AXprint.RetResult(AXprint.iSqlNum);
			alert("save result:"+r);
			AXprint.Preview();
			</script>
	<%}%>

<form name="PrintDocForm" action="" method="post">
<input type="button" name="b_down" value="download FMT" onclick="PolicyBuild();">
<input type="text" name="combinedSqlStr" value="">
</form>
</body>
</html>
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
	for (i = 0;i<resultNum;i++){
		AXprint.GetSqlStr(i);
		sqlStrSet +=AXprint.sSqlStr + "|";
	}
	PrintDocForm.combinedSqlStr.value= sqlStrSet;
	return true;
}

function PolicyBuild(){
	AXprint.BuildCondStr("0","1018600020101000028","zs2009_en","2001-09-14","B01","admin","C");
	alert(AXprint.iCondLen);
	alert(AXprint.sCondStr);
	PrintDocForm.combinedSqlStr.value= AXprint.sCondStr;
	PrintDocForm.submit();
	return true;
}

function saveFormat(){
	AXprint.iRetCode = 0;
	AXprint.sRetValue = "aaaaaaa";
	AXprint.RetDnResult(0);
}
</script>
