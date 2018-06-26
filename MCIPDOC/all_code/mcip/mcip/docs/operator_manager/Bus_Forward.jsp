<%@ page language="java" import="java.beans.Beans,java.math.*,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Bus_Forward.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Bus_Forward.jsp
*Previous Page : Bus_List.jsp
*Next Page : Bus_Plyapp_List.jsp, Bus_Proposal_List.jsp, Bus_Policy_List.jsp, Bus_Edr_List.jsp Bus_Claim_List.jsp, Bus_Cust_List.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-18 11:24:09
*Last Updated :
*Status : open
*Function : 根据用户在上一个页面所选择的条件,转到不同的页面.这个页面对于用户来说是透明的.
*============================MODIFIED HISTORY==================================================
*Date :
*Time :
*Modify id :
*Modifier :
*Reason :
***********************************************************************************************
*/
%>
<%
/////////////////////////////////////////////////////////////////////////////////////////////////
//GET PARAMETERS FROM LAST PAGE
String	sessionId=request.getParameter("sessionId");
String fromYear = request.getParameter("fromYear");//起始年
String fromMonth = request.getParameter("fromMonth");//起始月
String fromDay = request.getParameter("fromDay");//起始日
String toYear = request.getParameter("toYear");//结束年
String toMonth = request.getParameter("toMonth");//结束月
String toDay = request.getParameter("toDay");//结束日
String dpt = request.getParameter("dpt");//起始部门
String expand = StringTool.null2Blank(request.getParameter("expand"));//展开标志
String fromInsrncTyp = request.getParameter("fromInsrncTyp");//起始险种
String toInsrncTyp = request.getParameter("toInsrncTyp");//结束险种
String currency = request.getParameter("currency");//货币种类
String siteCde = request.getParameter("siteCde");//业务来源
String plyAppStat = request.getParameter("plyAppStat");//投保清单种类
String busType = request.getParameter("busType");//业务分类
request.setAttribute("sessionId",sessionId);
request.setAttribute("fromYear",fromYear);
request.setAttribute("fromMonth",fromMonth);
request.setAttribute("fromDay",fromDay);
request.setAttribute("toYear",toYear);
request.setAttribute("toMonth",toMonth);
request.setAttribute("toDay",toDay);
request.setAttribute("dpt",dpt);
request.setAttribute("expand",expand);
request.setAttribute("fromInsrncTyp",fromInsrncTyp);
request.setAttribute("toInsrncTyp",toInsrncTyp);
request.setAttribute("currency",currency);
request.setAttribute("siteCde",siteCde);
request.setAttribute("plyAppStat",plyAppStat);
request.setAttribute("busType",busType);
%>
<jsp:forward page="<%=busType%>" />
<!--
<html>
	<head>
	</head>
	<body>
fromYear:<%=fromYear%><br>
fromMonth:<%=fromMonth%><br>
fromDay:<%=fromDay%><br>
toYear:<%=toYear%><br>
toMonth:<%=toMonth%><br>
toDay:<%=toDay%><br>
dpt:<%=dpt%><br>
expand:<%=expand%><br>
fromInsrncTyp:<%=fromInsrncTyp%><br>
toInsrncTyp:<%=toInsrncTyp%><br>
currency:<%=currency%><br>
siteCde:<%=siteCde%><br>
plyAppStat:<%=plyAppStat%><br>
busType:<%=busType%><br>
	</body>
</html>
-->