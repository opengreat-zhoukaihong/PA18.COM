<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Message_Back.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Message_Back.jsp
*Previous Page : Assign_Back.jsp
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
String feedBackYear = request.getParameter("feedBackYear");
String feedBackMonth = request.getParameter("feedBackMonth");
String feedBackDay = request.getParameter("feedBackDay");
String feedBackHour = request.getParameter("feedBackHour");
String feedBackMinute = request.getParameter("feedBackMinute");
String feedBackSecond = request.getParameter("feedBackSecond");
String feedBackTime = feedBackYear+"-"+feedBackMonth+"-"+feedBackDay+" "+feedBackHour+":"+feedBackMinute+":"+feedBackSecond;
if (feedBackTime.length()!=19)
	feedBackTime = "";

formPara[0] = policyNo;
formPara[1] = feedBackTime;
try
{
	bb.setFormPara(BConst.ACCEPT_PLY_FEEDBACK,formPara);
	bingo = bb.getRetValueBool();
}
catch(NormalException e)
{
//	if(NormalExceptionHandler.IsSevere(e))
//		throw NormalExceptionHandler.Handle(e);
	bingo = false;
}
%>

<div align="center"><font color="#0066CC" class="unnamed3">添加返回时间结果</font></div>
<%
if (!bingo){%>
		<div align="center"><font color="red">添加返回时间失败！<br>请检查返回时间或联系系统管理员！</font></div>
<%}else{%>
		<div align="center"><font color="red" class="unnamed3">返回时间已成功添加！<br></font></div>
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