<%/*
*****************************GENERAL INFORMATION***********************************************
*Program ID :Assign_Back.jsp 
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Assign_Back.jsp
*Previous Page : Assigned_List.jsp
*Next Page : Message_Back.jsp
*Author : Lawrence Kang
*Created Date : 2000/10/07
*Last Updated : 2000/10/09
*Status : submited for test
*Function : I.Retrieve the selected line's policy no,,sendTime
*			III.submit updated time(s) to nextpage
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-10
*Time : 15:10
*Modify id : 0001
*Modifier : Lawrence Kang
*Reason : 
*		i.add the limit condition:when sended time not specified , can't input the feedBackTime
*		ii.add the limit condition:feedBackTime >=sendedTime (javascript)
*		iii.display the sendtime & sendedtime(always none) for user reference
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
/*E0001+*/

String feedBackTime="";
String feedBackYear="";
String feedBackMonth="";
String feedBackDay="";
String feedBackHour="";
String feedBackMinute="";
String feedBackSecond="";

/*B0001+*/
String errOutStr = "";
/*E0001+*/


////////////////////////////////
//get parameters
String numBack = request.getParameter("numBack");
String index = request.getParameter("index");
String policyNo = request.getParameter("plyNoList"+index);
titleString="添加返回时间";

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

/*E0001+*/

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
/*B0001+*/
 if (feedBackTime !=null || feedBackTime.length()>0)
	errOutStr = "返回时间已经输入，不能修改！";
 if ( sendedTime == null || sendedTime.length()==0 )
	errOutStr = "送到时间没有输入，不能输入返回时间！";
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

	if (ValidNull(f.feedBackYear,false)&&ValidNull(f.feedBackMonth,false)&&ValidNull(f.feedBackDay,false)&&ValidNull(f.feedBackHour,false)&&ValidNull(f.feedBackMinute,false)&&ValidNull(f.feedBackSecond,false)&&
		ValidYear(f.feedBackYear)&&ValidMonth(f.feedBackMonth)&&ValidDay(f.feedBackDay)&&ValidHour(f.feedBackHour)&&ValidMinute(f.feedBackMinute)&&ValidMinute(f.feedBackSecond))
			isOk=true;

	return isOk;
}

/*B0001+*/
function ValidDateRange()
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
/*E0001+*/
function fixZero(field){
	if (field.value.length == 1)
		field.value = "0"+field.value;
}

</script>


<form name="f" method="POST" action="Message_Back.jsp" onsubmit="return(checkAll() && ValidDateRange());">
  <div align="center"><font color="#0066CC" class="unnamed3">添加返回时间</font></div>	<!--/*B0001+*/-->
	<input type="hidden" name="sendYear" value="<%=sendYear%>">
	<input type="hidden" name="sendMonth" value="<%=sendMonth%>">
	<input type="hidden" name="sendDay" value="<%=sendDay%>">
	<input type="hidden" name="sendHour" value="<%=sendHour%>">
	<input type="hidden" name="sendMinute" value="<%=sendMinute%>">
	<input type="hidden" name="sendSecond" value="<%=sendSecond%>">

	<input type="hidden" name="sendedYear" value="<%=sendedYear%>">
	<input type="hidden" name="sendedMonth" value="<%=sendedMonth%>">
	<input type="hidden" name="sendedDay" value="<%=sendedDay%>">
	<input type="hidden" name="sendedHour" value="<%=sendedHour%>">
	<input type="hidden" name="sendedMinute" value="<%=sendedMinute%>">
	<input type="hidden" name="sendedSecond" value="<%=sendedSecond%>">
	<input type="hidden" name="numBack" value="<%=numBack%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<!--/*E0001+*/-->
<% if (sendedTime!=null && sendedTime.length()>0 && (feedBackTime==null || feedBackTime.length()==0)){%>
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr valign="middle"> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		保单号：
	  </td>
	  <td width="81%" bgcolor="#DFF9F3" height="24"> 
		<%=policyNo%>
		<input type="hidden" name="policyNo" value="<%=policyNo%>">
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
    <tr> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		送单时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
        <%=sendedYear%>
        年 
        <%=sendedMonth%>
        月 
        <%=sendedDay%>
        日 
        <%=sendedHour%>
        : 
        <%=sendedMinute%>
        : 
        <%=sendedSecond%>
        </td>
    </tr>
	<!--/*E0001+*/-->
    <tr> 
      <td bgcolor="#9DEEDE" width="19%" height="24"> 
		返回时间：
	</td>
	<td width="81%" bgcolor="#DFF9F3" height="24"> 
        <input type="text" name="feedBackYear" size="5" maxlength="4" value="<%=feedBackYear%>">
        年 
        <input type="text" name="feedBackMonth" size="3" maxlength="2" value="<%=feedBackMonth%>" onBlur="fixZero(f.feedBackMonth);">
        月 
        <input type="text" name="feedBackDay" name="feedBackMinute" size="3" maxlength="2" value="<%=feedBackMinute%>" onBlur="fixZero(f.feedBackDay);">
        : 
        <input type="text" name="feedBackHour" size="3" maxlength="2" value="<%=feedBackHour%>" onBlur="fixZero(f.feedBackHour);">
		:
		<input type="text" name="feedBackMinute" size="3" maxlength="2" value="<%=feedBackMinute%>" onBlur="fixZero(f.feedBackMinute);">
		:
		<input type="text" name="feedBackSecond" size="3" maxlength="2" value="<%=feedBackSecond%>" onBlur="fixZero(f.feedBackSecond);">
        </font></td>
    </tr>
    <tr> 
      <td align="center" colspan="2"> 
          <input type="submit" value="确定" name="B1">
          &nbsp;
          <input type="reset" value="清除" name="B2">
      </td>
    </tr>
  </table>
<%}else{%>
<div align="center">
<font face="宋体" size="3" color="red"><%=errOutStr%></font>
</div>
<%}%>
</form>
<%@ include file="public/bottom.jsp"%>
