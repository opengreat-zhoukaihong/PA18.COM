<html>
<head>
<title>平安货运保险-保单清单打印</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.lang.reflect.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*,com.jspsmart.upload.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<%
String [][] result = ob.getSavedResult();

%>
<div align="center"><h3>保单清单</h3></div>
<table align="center" border="0" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
	<tr bgcolor="#99FFFF" align="right">
		<td>保单号</td>
		<td>发票号</td>
		<!--
		<td>启始港</td>
		<td>目的港</td>
		-->
		<td>保险金额</td>
		<td>保费</td>
		<td>费率</td>
	<tr>
	<%if (result != null){
		//RMB
	boolean isSummary = false;
	String [][] newRes = StatisticBean.filter(result,"01");
	for (int i=1;i<newRes.length;i++){
		 isSummary = i==(newRes.length-1);
			
		%>
	<tr align="right" <% if (isSummary) out.println("bgcolor=\"#3333FF\" "); else if (i%2 == 0) out.println("bgcolor=\"#EEEEEE\"");%>>
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=newRes[i][Objects.getColNum("C_PLY_NO",result)]%>&nbsp;&nbsp;</td>
		<td><% if (newRes[i][Objects.getColNum("C_INVC_NO",result)].trim().length() >0){%><%=newRes[i][Objects.getColNum("C_INVC_NO",result)]%><%}else{%><%=newRes[i][Objects.getColNum("C_RECEIPT_NO",result)]%><%}%>&nbsp;&nbsp;<%if (isSummary) out.println("</font></b>");%></td>
		<!--
		<td><%=newRes[i][Objects.getColNum("C_FROM_PRT",newRes)]%>&nbsp;&nbsp;</td>
		<td><%=newRes[i][Objects.getColNum("C_TO_PRT",newRes)]%>&nbsp;&nbsp;</td>
		-->
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=StringTool.fix(newRes[i][Objects.getColNum("N_TGT_AMT",result)])%><%="("+newRes[i][Objects.getColNum("C_CUR_SBL",result)]+")"%><%if (isSummary) out.println("</font></b>");%>&nbsp;&nbsp;</td>
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=StringTool.fix(newRes[i][Objects.getColNum("N_TGT_PRM",result)])%><%="("+StringTool.getCurrInfo(newRes[i][Objects.getColNum("C_PRM_CUR",result)])[0]+")"%><%if (isSummary) out.println("</font></b>");%>&nbsp;&nbsp;</td>
		<td><%=newRes[i][Objects.getColNum("N_RATE",result)]%>&nbsp;&nbsp;</td>
	</tr>
	<%}%>
<%
	isSummary = false;
    newRes = StatisticBean.filter(result,"02");
	for (int i=1;i<newRes.length;i++){
		isSummary = i==(newRes.length-1);
		%>
	<tr align="right" <% if (isSummary) out.println("bgcolor=\"#3333FF\" "); else if (i%2 == 0) out.println("bgcolor=\"#EEEEEE\"");%>>
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=newRes[i][Objects.getColNum("C_PLY_NO",result)]%>&nbsp;&nbsp;</td>
		<td><% if (newRes[i][Objects.getColNum("C_INVC_NO",result)].trim().length() >0){%><%=newRes[i][Objects.getColNum("C_INVC_NO",result)]%><%}else{%><%=newRes[i][Objects.getColNum("C_RECEIPT_NO",result)]%><%}%>&nbsp;&nbsp;<%if (isSummary) out.println("</font></b>");%></td>
		<!--
		<td><%=newRes[i][Objects.getColNum("C_FROM_PRT",newRes)]%>&nbsp;&nbsp;</td>
		<td><%=newRes[i][Objects.getColNum("C_TO_PRT",newRes)]%>&nbsp;&nbsp;</td>
		-->
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=StringTool.fix(newRes[i][Objects.getColNum("N_TGT_AMT",result)])%><%="("+newRes[i][Objects.getColNum("C_CUR_SBL",result)]+")"%><%if (isSummary) out.println("</font></b>");%>&nbsp;&nbsp;</td>
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=StringTool.fix(newRes[i][Objects.getColNum("N_TGT_PRM",result)])%><%="("+StringTool.getCurrInfo(newRes[i][Objects.getColNum("C_PRM_CUR",result)])[0]+")"%><%if (isSummary) out.println("</font></b>");%>&nbsp;&nbsp;</td>
		<td><%=newRes[i][Objects.getColNum("N_RATE",result)]%>&nbsp;&nbsp;</td>
	</tr>
<%}%>
<%
	isSummary = false;
    newRes = StatisticBean.filter(result,"03");
	for (int i=1;i<newRes.length;i++){
		isSummary = i==(newRes.length-1);%>
	<tr align="right" <% if (isSummary) out.println("bgcolor=\"#3333FF\" "); else if (i%2 == 0) out.println("bgcolor=\"#EEEEEE\"");%>>
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=newRes[i][Objects.getColNum("C_PLY_NO",result)]%>&nbsp;&nbsp;<%if (isSummary) out.println("</font></b>");%></td>
		<td><% if (newRes[i][Objects.getColNum("C_INVC_NO",result)].trim().length() >0){%><%=newRes[i][Objects.getColNum("C_INVC_NO",result)]%><%}else{%><%=newRes[i][Objects.getColNum("C_RECEIPT_NO",result)]%><%}%>&nbsp;&nbsp;</td>
		<!--
		<td><%=newRes[i][Objects.getColNum("C_FROM_PRT",newRes)]%>&nbsp;&nbsp;</td>
		<td><%=newRes[i][Objects.getColNum("C_TO_PRT",newRes)]%>&nbsp;&nbsp;</td>
		-->
		<td><%if (!isSummary) {%><%=StringTool.fix(newRes[i][Objects.getColNum("N_TGT_AMT",result)])%><%="("+newRes[i][Objects.getColNum("C_CUR_SBL",result)]+")"%><%}%>&nbsp;&nbsp;</td>
		<td><%if (isSummary) out.println("<font color=\"white\"><b>");%><%=StringTool.fix(newRes[i][Objects.getColNum("N_TGT_PRM",result)])%><%="("+StringTool.getCurrInfo(newRes[i][Objects.getColNum("C_PRM_CUR",result)])[0]+")"%><%if (isSummary) out.println("</font></b>");%>&nbsp;&nbsp;</td>
		<td><%=newRes[i][Objects.getColNum("N_RATE",result)]%>&nbsp;&nbsp;</td>
	</tr>
<%}
}%>

</table>
