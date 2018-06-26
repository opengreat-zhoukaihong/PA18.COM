<%/*
*****************************GENERAL INFORMATION***********************************************
*Program ID :Assign_Send.jsp 
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Assign_Send.jsp
*Previous Page : Assigned_List.jsp
*Next Page : Message_send.jsp
*Author : Lawrence Kang
*Created Date : 2000/10/07
*Last Updated : 2000/10/09
*Status : submited for test
*Function : I.Retrieve the selected line's policy no,,sendTime
*			III.submit updated time(s) to nextpage
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-10
*Time : 15:03
*Modify id : 0001
*Modifier : Lawrence Kang
*Reason : 
*		i.add the limit condition:when send time not specified , can't input the sendedTime
*		ii.add the limit condition:sendedTime >=sendTime
*		iii.display the sendtime & feedbacktime(always none) for user reference
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
int i=0,j=0;

/*B0001+*/
String sendTime="";
String sendYear="";
String sendMonth="";
String sendDay="";
String sendHour="";
String sendMinute="";
String sendSecond="";

String sendedTime="";
String sendedYear="";
String sendedMonth="";
String sendedDay="";
String sendedHour="";
String sendedMinute="";
String sendedSecond="";

String feedBackTime="";
String feedBackYear="";
String feedBackMonth="";
String feedBackDay="";
String feedBackHour="";
String feedBackMinute="";
String feedBackSecond="";

String errOutStr = "";
/*E0001+*/



////////////////////////////////
//get parameters
String index = request.getParameter("index");
String policyNo = request.getParameter("plyNoList"+index);
String numBack = request.getParameter("numBack");
titleString="添加送到时间";

/*B0001+*/
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
/*E0001+*/
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
/*B0001+*/
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

 if (sendedTime !=null || sendedTime.length()>0)
	errOutStr = "送到时间已经输入，不能修改！";
 if ( sendTime == null || sendTime.length()==0 )
	errOutStr = "送单时间没有输入，不能输入送到时间！";
/*E0001+*/
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

	if (ValidNull(f.sendedYear,false)&&ValidNull(f.sendedMonth,false)&&ValidNull(f.sendedDay,false)&&ValidNull(f.sendedHour,false)&&ValidNull(f.sendedMinute,false)&&ValidNull(f.sendedSecond,false)&&
		ValidYear(f.sendedYear)&&ValidMonth(f.sendedMonth)&&ValidDay(f.sendedDay)&&ValidHour(f.sendedHour)&&ValidMinute(f.sendedMinute)&&ValidMinute(f.sendedSecond))
			isOk=true;

	return isOk;
}
/*B0001+*/
function ValidDateRange()
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
}/*E0001+*/
function fixZero(field){
	if (field.value.length == 1)
		field.value = "0"+field.value;
}
</script>
<form name="f" method="POST" action="Message_Send.jsp" onsubmit="return(checkAll() && ValidDateRange());">
<div align="center"><font color="#0066CC" class="unnamed3">添加送到时间</font></div>
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<!--/*B0001+*/-->
	<input type="hidden" name="sendYear" value="<%=sendYear%>">
	<input type="hidden" name="sendMonth" value="<%=sendMonth%>">
	<input type="hidden" name="sendDay" value="<%=sendDay%>">
	<input type="hidden" name="sendHour" value="<%=sendHour%>">
	<input type="hidden" name="sendMinute" value="<%=sendMinute%>">
	<input type="hidden" name="sendSecond" value="<%=sendSecond%>">

	<input type="hidden" name="feedBackYear" value="<%=feedBackYear%>">
	<input type="hidden" name="feedBackMonth" value="<%=feedBackMonth%>">
	<input type="hidden" name="feedBackDay" value="<%=feedBackDay%>">
	<input type="hidden" name="feedBackHour" value="<%=feedBackHour%>">
	<input type="hidden" name="feedBackMinute" value="<%=feedBackMinute%>">
	<input type="hidden" name="feedBackSecond" value="<%=feedBackSecond%>">
	<input type="hidden" name="numBack" value="<%=numBack%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<!--/*E0001+*/-->

<% if ( sendTime!=null && sendTime.length()>0 && (sendedTime==null || sendedTime.length()==0) ){%>
    <tr valign="middle"> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		保单号：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
	  <%=policyNo%><input type="hidden" name="policyNo" value="<%=policyNo%>">
	</td>
   </tr>
	<!--/*B0001+*/-->
    <tr> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		送单时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
        <%=sendYear%>
        年 
        <%=sendMonth%>
        月 
        <%=sendDay%>
        日 
        <%=sendHour%>
        : 
        <%=sendMinute%>
        : 
        <%=sendSecond%>
        </td>
    </tr>
	<!--/*E0001+*/-->
    <tr> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		送到时间：
		</td>
		<td width="81%" bgcolor="#DFF9F3" height="24"> 
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
        </td>
    </tr>
	<!--/*B0001+*/-->
    <tr> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		返回时间：
		</td>
		<td width="81%" bgcolor="#DFF9F3" height="24"> 
	   尚未输入返回时间
        </td>
    </tr>
	<!--/*E0001+*/-->
	</table>
	<div align="center">
          <input type="submit" value="确定" name="B1">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
          <input type="reset" value="清除" name="B2">
	</div>
 <%}else{%>
	<div align="center">
      <font face="宋体" size="3" color="red"><%=errOutStr%></font>
	</div>
	</table>
<%}%>
</form>
<%@ include file="public/bottom.jsp"%>