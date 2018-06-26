<%@ page language="java" import="java.beans.Beans,java.math.*,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,ctil.message.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title> New Document </title>
<META HTTP-EQUIV="REFRESH" CONTENT="10; URL=Monitor.jsp"> 
<meta name="Generator" content="EditPlus">
<meta name="Author" content="">
<meta name="Keywords" content="">
<meta name="Description" content="">
</head>
<body>
<table width="100%" align="center">
	<tr>
		<td align="center">
			<font color="red" >为避免系统资源耗用过多，如非监控必要，请勿访问此页面！<br>Due to the limited system resource ,please DO NOT access this page except on moniting!</font>
		</td>
	</tr>
</table>
<table width="780" border="1" align="center">
	<tr>
		<td width="20%">监控项目</td>
		<td width="10%">耗用时间</td>
		<td width="10%">状态</td>
		<td width="60%">错误描述</td>
	</tr>

<%
Properties result = null;
String statusStr = "";
String bgColor="";
try{
	beans.MonitorBean mb =new beans.MonitorBean();
	for (int i=0;i<mb.MAX_OPERATION;i++){
		bgColor="ffffff";
		result = (Properties)mb.test(i);
		if (result.getProperty("test_result").length() != 0){
			statusStr = "<font color=red>出错！</font>";
			bgColor="#FFFF66";
		}else{
			statusStr = "<font color=green>正常</font>";
		}
%>
	<tr bgcolor="<%=bgColor%>">
		<td width="20%"><%=result.getProperty("monitor_name")%>&nbsp</td>
		<td width="10%"><%=result.getProperty("resume_time")%>ms&nbsp</td>
		<td width="10%"><%=statusStr%>&nbsp</td>
		<td width="60%"><font color="red"><%=StringTool.nl2br(result.getProperty("test_result"))%>&nbsp</font></td>
	</tr>
<%
}}catch(Exception e){
		out.println(e);
	e.printStackTrace(new java.io.PrintWriter(out));
}
%>
	
</table>
