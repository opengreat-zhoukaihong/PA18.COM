<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Message_Send.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Message_Send.jsp
*Previous Page : Assign_Send.jsp
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
String formPara[] = new String[2];

String policyNo = request.getParameter("policyNo");
String numBack = request.getParameter("numBack");

String sendedYear = request.getParameter("sendedYear");
String sendedMonth = request.getParameter("sendedMonth");
String sendedDay = request.getParameter("sendedDay");
String sendedHour = request.getParameter("sendedHour");
String sendedMinute = request.getParameter("sendedMinute");
String sendedSecond = request.getParameter("sendedSecond");
String sendedTime = sendedYear+"-"+sendedMonth+"-"+sendedDay+" "+sendedHour+":"+sendedMinute+":"+sendedSecond;
if (sendedTime.length()!=19)
	sendedTime = "";

formPara[0] = policyNo;
formPara[1] = sendedTime;
try
{
	bb.setFormPara(BConst.ACCEPT_PLY_SENDED,formPara);
	bingo = bb.getRetValueBool();
}
catch(NormalException e)
{
//	if(NormalExceptionHandler.IsSevere(e))
//		throw NormalExceptionHandler.Handle(e);
	bingo = false;
}
%>
<div align="center"><font color="#0066CC" class="unnamed3">添加送到时间结果</font></div>
<%
if (!bingo){%>
		<font color="red">添加送到时间失败！<br>请检查送到时间或同系统管理员联系！</font>
<%}else{%>
		<div align="center"><font color="red" class="unnamed3">送到时间已成功添加！<br></font></div>
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		保单号：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
	<%=policyNo%>
	</td>
<tr>
	<td bgcolor="#9DEEDE" width="19%" height="24"> 
		送到时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
		<%=sendedTime%>
	</td>
</tr>
<%}%>
</table>
<form>
	<div align="center">
	<a href="Assigned_List.jsp?numBack=<%=numBack%>&sessionId=<%=Code.Encrypt(sessionId)%>">返回</a>
	</div>
</form>
<%@ include file="public/bottom.jsp"%>