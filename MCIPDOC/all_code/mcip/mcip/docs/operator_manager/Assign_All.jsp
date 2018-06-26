<%/*
*****************************GENERAL INFORMATION***********************************************
*Program ID :Assign_All.jsp 
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Assign_All.jsp
*Previous Page : Assigned_List.jsp
*Next Page : Message_All.jsp
*Author : Lawrence Kang
*Created Date : 2000/10/07
*Last Updated : 2000/10/09
*Status : submited for test
*Function : I.Retrieve the selected line's policy no,prtTime,sendTime,feedBacktime
*			II.generate the sender list for select
*			III.submit updated time(s) to nextpage
*============================MODIFIED HISTORY==================================================
*Date : 2000年10月10日
*Time : 14:15
*Modify id : 0001
*Modifier : Kang Jin
*Reason : Validate Date field
*			sendTime<sendedTime<feedBackTime
***********************************************************************************************
*/
%>
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
//predefine
String selStr="",titleString="";
String formPara[] = new String[2];
String senderList[][] = null;
int i=0,j=0;

String sendTime="";
String sendedTime="";
String feedBackTime="";
String sendYear="";
String sendedYear="";
String feedBackYear="";
String sendMonth="";
String sendedMonth="";
String feedBackMonth="";
String sendDay="";
String sendedDay="";
String feedBackDay="";
String sendHour="";
String sendedHour="";
String feedBackHour="";
String sendMinute="";
String sendedMinute="";
String feedBackMinute="";
String sendSecond="";
String sendedSecond="";
String feedBackSecond="";
String dptCde="";
String oprCde="";
String defaultSender="";
int indexEmpCde=0;
int indexEmpCnm=0;
int indexDptCde=0;



////////////////////////////////
//get parameters
String index = request.getParameter("index");
String policyNo = request.getParameter("plyNoList"+index);
String numBack = request.getParameter("numBack");
titleString="送单调度";




sendTime = request.getParameter("sendTmList"+index);
if (sendTime != null && sendTime.length()>0)
{
	sendYear = sendTime.substring(0,4);
	sendMonth = sendTime.substring(5,7);
	sendDay =  sendTime.substring(8,10);
	sendHour = sendTime.substring(11,13);
	sendMinute = sendTime.substring(14,16);
	sendSecond = sendTime.substring(17,19);
}
sendedTime = request.getParameter("sendedTmList"+index);
if (sendedTime != null && sendedTime.length()>0)
{
	sendedYear = sendedTime.substring(0,4);
	sendedMonth = sendedTime.substring(5,7);
	sendedDay =  sendedTime.substring(8,10);
	sendedHour = sendedTime.substring(11,13);
	sendedMinute = sendedTime.substring(14,16);
	sendedSecond = sendedTime.substring(17,19);
}

feedBackTime = request.getParameter("backTmList"+index);
if (feedBackTime != null && feedBackTime.length()>0)
{
	feedBackYear = feedBackTime.substring(0,4);
	feedBackMonth = feedBackTime.substring(5,7);
	feedBackDay =  feedBackTime.substring(8,10);
	feedBackHour = feedBackTime.substring(11,13);
	feedBackMinute = feedBackTime.substring(14,16);
	feedBackSecond = feedBackTime.substring(17,19);
}

defaultSender = request.getParameter("sendEmpList"+index);
if (defaultSender == null)
	defaultSender = "";
		
//GET THE AVAILABLE SENDER LIST FOR SELECTING
dptCde = request.getParameter("dptCdeList"+index);
oprCde=sessionuser.getuserId(Locate); 
formPara[0] = dptCde;
formPara[1] = oprCde;
try
{
	bb.setFormPara(BConst.QUERY_SEND_EMP_LIST,formPara);
	senderList = bb.getRetValueArra();
}
catch(NormalException e)
{
	if(NormalExceptionHandler.IsSevere(e))
		throw NormalExceptionHandler.Handle(e);
}

%>
<script language="JavaScript" src="check.js">
</script>
<script language="JavaScript">
function isNull(field)
{
	if (field.value=="")
		return true;
	else
		return false;
}
function checkAll()
{
	var isOk=false;
	if (ValidNull(f.sendYear,false)&&ValidNull(f.sendMonth,false)&&ValidNull(f.sendDay,false)&&ValidNull(f.sendHour,false)&&ValidNull(f.sendMinute,false)&&ValidNull(f.sendSecond,false)&&
		ValidYear(f.sendYear)&&ValidMonth(f.sendMonth)&&ValidDay(f.sendDay)&&ValidHour(f.sendHour)&&ValidMinute(f.sendMinute)&&ValidMinute(f.sendSecond))
			isOk=true;

	if (!isOk)
		return false;

	isOk=false;
	if (isNull(f.sendedYear)&&isNull(f.sendedMonth)&&isNull(f.sendedDay)&&isNull(f.sendedHour)&&isNull(f.sendedMinute)&&isNull(f.sendedSecond))
		isOk=true;
	else
		if (ValidNull(f.sendedYear,false)&&ValidNull(f.sendedMonth,false)&&ValidNull(f.sendedDay,false)&&ValidNull(f.sendedHour,false)&&ValidNull(f.sendedMinute,false)&&ValidNull(f.sendedSecond,false)&&
		ValidYear(f.sendedYear)&&ValidMonth(f.sendedMonth)&&ValidDay(f.sendedDay)&&ValidHour(f.sendedHour)&&ValidMinute(f.sendedMinute)&&ValidMinute(f.sendedSecond))
			isOk=true;

	if (!isOk)
		return false;

	isOk=false;
	if (isNull(f.feedBackYear)&&isNull(f.feedBackMonth)&&isNull(f.feedBackDay)&&isNull(f.feedBackHour)&&isNull(f.feedBackMinute)&&isNull(f.feedBackSecond))
		isOk=true;
	else
		if (ValidNull(f.feedBackYear,false)&&ValidNull(f.feedBackMonth,false)&&ValidNull(f.feedBackDay,false)&&ValidNull(f.feedBackHour,false)&&ValidNull(f.feedBackMinute,false)&&ValidNull(f.feedBackSecond,false)&&
		ValidYear(f.feedBackYear)&&ValidMonth(f.feedBackMonth)&&ValidDay(f.feedBackDay)&&ValidHour(f.feedBackHour)&&ValidMinute(f.feedBackMinute)&&ValidMinute(f.feedBackSecond))
			isOk=true;

	return isOk;
}


/*B0001+*/
function ValidSendedTime()
{
	if (f.sendedYear.value<f.sendYear.value)
	{
		alert("送到时间不能小于送单时间");
		f.sendedYear.focus();
		return false;
	}
	else
		if(f.sendedYear.value>f.sendYear.value)
			return true;

	if (f.sendedMonth.value<f.sendMonth.value)
	{
		alert("送到时间不能小于送单时间");
		f.sendedMonth.focus();
		return false;
	}
	else
		if (f.sendedMonth.value>f.sendMonth.value)
			return true;

	if (f.sendedDay.value<f.sendDay.value)
	{
		alert("送到时间不能小于送单时间");
		f.sendedDay.focus();
		return false;
	}
	else
		if (f.sendedDay.value>f.sendDay.value)
			return true;

	if (f.sendedHour.value<f.sendHour.value)
	{
		alert("送到时间不能小于送单时间");
		f.sendedHour.focus();
		return false;
	}
	else
		if (f.sendedHour.value>f.sendHour.value)
			return true;

	if (f.sendedMinute.value<f.sendMinute.value)
	{
		alert("送到时间不能小于送单时间");
		f.sendedMinute.focus();
		return false;
	}
	else
		if (f.sendedMinute.value>f.sendMinute.value)
			return true;

	if (f.sendedSecond.value<f.sendSecond.value)
	{
		alert("送到时间不能小于送单时间");
		f.sendedSecond.focus();
		return false;
	}
	else
		if (f.sendedSecond.value>f.sendSecond.value)
			return true;

	return true;
}

function ValidFeedBackTime()
{
	if (f.feedBackYear.value<f.sendedYear.value)
	{
		alert("返回时间不能小于送到时间");
		f.feedBackYear.focus();
		return false;
	}
	else
		if(f.feedBackYear.value>f.sendedYear.value)
			return true;

	if (f.feedBackMonth.value<f.sendedMonth.value)
	{
		alert("返回时间不能小于送到时间");
		f.feedBackMonth.focus();
		return false;
	}
	else
		if (f.feedBackMonth.value>f.sendedMonth.value)
			return true;

	if (f.feedBackDay.value<f.sendedDay.value)
	{
		alert("返回时间不能小于送到时间");
		f.feedBackDay.focus();
		return false;
	}
	else
		if (f.feedBackDay.value>f.sendedDay.value)
			return true;

	if (f.feedBackHour.value<f.sendedHour.value)
	{
		alert("返回时间不能小于送到时间");
		f.feedBackHour.focus();
		return false;
	}
	else
		if (f.feedBackHour.value>f.sendedHour.value)
			return true;

	if (f.feedBackMinute.value<f.sendedMinute.value)
	{
		alert("返回时间不能小于送到时间");
		f.feedBackMinute.focus();
		return false;
	}
	else
		if (f.feedBackMinute.value>f.sendedMinute.value)
			return true;

	if (f.feedBackSecond.value<f.sendedSecond.value)
	{
		alert("返回时间不能小于送到时间");
		f.feedBackSecond.focus();
		return false;
	}
	else
		if (f.feedBackSecond.value>f.sendedSecond.value)
			return true;

	return true;
}
function ValidDateRange()
{
	if (!isNull(f.sendedYear))
	{
		if (!ValidSendedTime())
			return false;
	}
	if (!isNull(f.feedBackYear))
	{
		if (!ValidFeedBackTime())
			return false;
	}
	return true;
}

function fixZero(field){
	if (field.value.length == 1)
		field.value = "0"+field.value;
}
/*E0001+*/
</script>

<div align="center"><font color="#0066CC" class="unnamed3">送单调度</font></div>
<form name="f" method="POST" action="Message_All.jsp" onsubmit="return(checkAll()&&ValidDateRange());">
  <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr > 
      <td bgcolor="#9DEEDE">保单号：
	  </td>
	  <td bgcolor="#DFF9F3">
	  <%=policyNo%>
	  </td>
	  <input type="hidden" name="policyNo" value="<%=policyNo%>">
	  <input type="hidden" name="numBack" value="<%=numBack%>">
	  <input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	  </font></td>
    </tr>
    <tr> 
      <td bgcolor="#9DEEDE">送单人： </td>
	  <td bgcolor="#DFF9F3">
		<%if (senderList != null && senderList.length>1){ 
				indexEmpCde = Objects.getColNum("C_EMP_CDE",senderList);
				indexEmpCnm = Objects.getColNum("C_EMP_CNM",senderList);
				indexDptCde = Objects.getColNum("C_DPT_CDE",senderList);
		%>
        <select name="senderCode">
			<% for(i = 1;i < senderList.length;i++)
			{
				if (defaultSender.equals(senderList[i][indexEmpCde]))
					selStr = " selected ";
				else
					selStr = " ";
			%>
          <option <%=selStr%> value="<%=senderList[i][indexEmpCde]%>"><%=senderList[i][indexEmpCnm]%></option>
		  <%}%>
        </select>
		<%}
		else{
		%>
		<font color="red">错误：没有送单人可以选择！</font>
		<%}%>
        </td>
    </tr>
    <tr> 
      <td bgcolor="#9DEEDE">送单时间：</td>
	  <td bgcolor="#DFF9F3">
        <input type="text" name="sendYear" size="5" maxlength="4" value="<%=sendYear%>">
        年 
        <input type="text" name="sendMonth" size="3" maxlength="2" value="<%=sendMonth%>" onBlur="fixZero(f.sendMonth);">
        月 
        <input type="text" name="sendDay" size="3" maxlength="2" value="<%=sendDay%>" onBlur="fixZero(f.sendDay);">
        日 
        <input type="text" name="sendHour" size="3" maxlength="2" value="<%=sendHour%>" onBlur="fixZero(f.sendHour);">
        : 
        <input type="text" name="sendMinute" size="3" maxlength="2" value="<%=sendMinute%>" onBlur="fixZero(f.sendMinute);">
        : 
        <input type="text" name="sendSecond" size="3" maxlength="2" value="<%=sendSecond%>" onBlur="fixZero(f.sendSecond);">
        </font></td>
    </tr>
    <tr> 
      <td bgcolor="#9DEEDE">送到时间：</td>
	  <td bgcolor="#DFF9F3">
        <input type="text" name="sendedYear" size="5" maxlength="4" value="<%=sendedYear%>">
        年 
        <input type="text" name="sendedMonth" size="3" maxlength="2" value="<%=sendedMonth%>" onBlur="fixZero(f.sendedMonth);">
        月 
        <input type="text" name="sendedDay" size="3" maxlength="2" value="<%=sendedDay%>" onBlur="fixZero(f.sendedDay);">
        日 
        <input type="text" name="sendedHour" size="3" maxlength="2" value="<%=sendedHour%>" onBlur="fixZero(f.sendedHour);">
        : 
        <input type="text" name="sendedMinute" size="3" maxlength="2" value="<%=sendedMinute%>" onBlur="fixZero(f.sendedMinute);">
        : 
        <input type="text" name="sendedSecond" size="3" maxlength="2" value="<%=sendedSecond%>" onBlur="fixZero(f.sendedSecond);">
        </font></td>
    </tr>
    <tr> 
      <td bgcolor="#9DEEDE">返回时间； </td>
	  <td bgcolor="#DFF9F3">
        <input type="text" name="feedBackYear" size="5" maxlength="4" value="<%=feedBackYear%>">
        年 
        <input type="text" name="feedBackMonth" size="3" maxlength="2" value="<%=feedBackMonth%>" onBlur="fixZero(f.feedBackMonth);">
        月 
        <input type="text" name="feedBackDay" size="3" maxlength="2" value="<%=feedBackDay%>" onBlur="fixZero(f.feedBackDay);">
        日 
        <input type="text" name="feedBackHour" size="3" maxlength="2" value="<%=feedBackHour%>" onBlur="fixZero(f.feedBackHour);">
        : 
        <input type="text" name="feedBackMinute" size="3" maxlength="2" value="<%=feedBackMinute%>" onBlur="fixZero(f.feedBackMinute);">
        : 
        <input type="text" name="feedBackSecond" size="3" maxlength="2" value="<%=feedBackSecond%>" onBlur="fixZero(f.feedBackSecond);">
        </font></td>
    </tr>
	</table>
	<div align="center">
          <input type="submit" value="确定" name="B1">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
          <input type="reset" value="清除" name="B2">
	</div>
</form>
<%@ include file="public/bottom.jsp"%>