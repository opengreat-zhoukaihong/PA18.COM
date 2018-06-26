<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Message_All.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Message_All.jsp
*Previous Page : Assign_All.jsp
*Next Page : none (can only back to the previous page)
*Author : Lawrence Kang
*Created Date : 2000/10/09
*Last Updated : 2000/10/09
*Status : submited for test
*Function : I.Validate the input
*			II.update the inputed data to the database
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
boolean bingo = false;
String formPara[] = new String[5];

String numBack = StringTool.null2Blank(request.getParameter("numBack"));
String policyNo = StringTool.null2Blank(request.getParameter("policyNo"));
String senderCode = StringTool.null2Blank(request.getParameter("senderCode"));
String sendYear = StringTool.null2Blank(request.getParameter("sendYear"));
String sendedYear = StringTool.null2Blank(request.getParameter("sendedYear"));
String feedBackYear = StringTool.null2Blank(request.getParameter("feedBackYear"));
String sendMonth = StringTool.null2Blank(request.getParameter("sendMonth"));
String sendedMonth = StringTool.null2Blank(request.getParameter("sendedMonth"));
String feedBackMonth = StringTool.null2Blank(request.getParameter("feedBackMonth"));
String sendDay = StringTool.null2Blank(request.getParameter("sendDay"));
String sendedDay = StringTool.null2Blank(request.getParameter("sendedDay"));
String feedBackDay = StringTool.null2Blank(request.getParameter("feedBackDay"));
String sendHour = StringTool.null2Blank(request.getParameter("sendHour"));
String sendedHour = StringTool.null2Blank(request.getParameter("sendedHour"));
String feedBackHour = StringTool.null2Blank(request.getParameter("feedBackHour"));
String sendMinute = StringTool.null2Blank(request.getParameter("sendMinute"));
String sendedMinute = StringTool.null2Blank(request.getParameter("sendedMinute"));
String feedBackMinute = StringTool.null2Blank(request.getParameter("feedBackMinute"));
String sendSecond = StringTool.null2Blank(request.getParameter("sendSecond"));
String sendedSecond = StringTool.null2Blank(request.getParameter("sendedSecond"));
String feedBackSecond = StringTool.null2Blank(request.getParameter("feedBackSecond"));
String sendTime = sendYear+"-"+sendMonth+"-"+sendDay+" "+sendHour+":"+sendMinute+":"+sendSecond;
if (sendTime.length()!=19)
	sendTime = "";
String sendedTime = sendedYear+"-"+sendedMonth+"-"+sendedDay+" "+sendedHour+":"+sendedMinute+":"+sendedSecond;
if (sendedTime.length()!=19)
	sendedTime = "";
String feedBackTime = feedBackYear+"-"+feedBackMonth+"-"+feedBackDay+" "+feedBackHour+":"+feedBackMinute+":"+feedBackSecond;
if (feedBackTime.length()!=19)
	feedBackTime = "";


formPara[0] = policyNo;
formPara[1] = senderCode;
formPara[2] = sendTime;
formPara[3] = sendedTime;
formPara[4] = feedBackTime;
try
{
	bb.setFormPara(BConst.ACCEPT_PLY_ASSIGN,formPara);
	bingo = bb.getRetValueBool();
}
catch(NormalException e)
{
//	if(NormalExceptionHandler.IsSevere(e))
//		throw NormalExceptionHandler.Handle(e);
	bingo = false;
}
%>
<div align="center"><font color="#0066CC" class="unnamed3">送单调度结果</font></div>
<%
if (!bingo){%>
		<div align="center"><font color="red" class="unnamed3">送单调度失败！<br>请检查送单调度时间或联系系统管理员！</font></div>
<%}else{%>
		<div align="center"><font color="red" class="unnamed3">送单调度数据已成功修改！<br></font></div>
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		保单号：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
		<%=policyNo%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		送单人：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
	<%=senderCode%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		送单时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
	<%=sendTime%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		送到时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
		<%=sendedTime%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		返回时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
		<%=feedBackTime%>
	</td>
</tr>
<%}%>
</table>
<div align="center">
<form>
	<a href="Assigned_List.jsp?numBack=<%=numBack%>&sessionId=<%=Code.Encrypt(sessionId)%>">返回</a>
</form>
</div>
<%@ include file="public/bottom.jsp"%>