<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Find_Ply_Net.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Find_Ply_Net.jsp
*Previous Page : FuncList.jsp(by directly link)
*Next Page : AssignedList.jsp(by posted form)
*Author : Lawrence Kang
*Created Date : 2000/10/06
*Last Updated : 2000/10/08
*Status : submited for test
*Function : I.Create the department list for the logined user(a serial radio buttons)
*			II.Validate the user input (via javascript)
*			III.Submit the prepared field to the next page
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
/**VARIABLES PREDEFINE
*================================================================================================
*Name			Type			Description
*------------------------------------------------------------------------------------------------
*formPara		String			参数数组，存放提交给BusinessManagerBean的参数
*------------------------------------------------------------------------------------------------
*departList		String Array	store the result return by BusinessManagerBean.
*								It's a string table, the first line indicate the name
*								of the field
*------------------------------------------------------------------------------------------------
*i,j			int				loop counter
*------------------------------------------------------------------------------------------------
*index_opr_cde	int				column index,retrieved by method Object.getColNum()
*index_dpt_cde	int				so that we can access the result array by "name"
*index_dpt_cnm	int
*index_dpt_enm	int
*------------------------------------------------------------------------------------------------
*dptCde			String			operator's department code
*oprCde			String			operator's code
*------------------------------------------------------------------------------------------------
*selStr			String			the content of this string is "checked" or ""
*								used to generate a checked html object(check box,
*								radio button,etc.)
*================================================================================================
*/

	String formPara[] = new String[2];//bean's mehtod parameters list
	String[][] departList = null;
	int i=0,j=0;//loop counter
	int index_opr_cde=0,index_dpt_cde=0,index_dpt_cnm=0,index_dpt_enm=0;//column index of result table
	String dptCde="",oprCde="";
	String selStr="";

	oprCde=sessionuser.getuserId(Locate); 





	
	//GET DEPARTMENT LIST FOR CURRENT USER
	try
	{
		formPara[0] = oprCde;
		ub.setFormPara(ZConst.QUERY_OPTRDPTLIST,formPara);
		departList = ub.getRetValueArra();
	}
    catch(NormalException e)
	{
		if(NormalExceptionHandler.IsSevere(e))
			throw NormalExceptionHandler.Handle(e);
	}
	
%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>送单信息查询</title>
<script language="JavaScript" src="check.js">
</script>
<SCRIPT LANGUAGE="JavaScript" >
function filter(index)
{
	if (index == "0")//选择所有信息
	{
		f.isHandle.disabled = true;
		f.notHandle.disabled = true;
		f.isSent.disabled = true;
		f.notSent.disabled = true;
		f.isBack.disabled = true;
		f.notBack.disabled = true;
	}

	if (index == "1")//选择是否处理
	{
		f.isHandle.disabled = false;
		f.notHandle.disabled = false;
		f.isSent.disabled = true;
		f.notSent.disabled = true;
		f.isBack.disabled = true;
		f.notBack.disabled = true;
	}

	if (index == "2")//选择是否送到
	{
		f.isHandle.disabled = true;
		f.notHandle.disabled = true;
		f.isSent.disabled = false;
		f.notSent.disabled = false;
		f.isBack.disabled = true;
		f.notBack.disabled = true;
	}

	if (index == "3")//选择是否返回
	{
		f.isHandle.disabled = true;
		f.notHandle.disabled = true;
		f.isSent.disabled = true;
		f.notSent.disabled = true;
		f.isBack.disabled = false;
		f.notBack.disabled = false;
	}
	
	if (index == "4")//选择保单号
	{
		
			f.policyNo.disabled= !f.policyNo.disabled;

	}
	
	if (index == "5")//选择投保时间范围
	{
		f.fromYear.disabled = !f.fromYear.disabled;
		f.fromMonth.disabled = !f.fromMonth.disabled;
		f.fromDay.disabled = !f.fromDay.disabled;

		f.fromHour.disabled = !f.fromHour.disabled;
		f.fromMinute.disabled = !f.fromMinute.disabled;
		f.fromSecond.disabled = !f.fromSecond.disabled;

		f.toYear.disabled = !f.toYear.disabled;
		f.toMonth.disabled = !f.toMonth.disabled;
		f.toDay.disabled = !f.toDay.disabled;

		f.toHour.disabled = !f.toHour.disabled;
		f.toMinute.disabled = !f.toMinute.disabled;
		f.toSecond.disabled = !f.toSecond.disabled;

	}

	if (index == "6")//选择险种码
	{
		f.fromInsuranceCode.disabled = !f.fromInsuranceCode.disabled;
		f.toInsuranceCode.disabled = !f.toInsuranceCode.disabled;
	}

}

function ValidDateRange()
{
	if (f.fromYear.value<f.toYear.value)
		return true;
	if (f.fromYear.value>f.toYear.value)
	{
		alert("时间范围错误！")
		f.toYear.focus();
		return false;
	}
	
	if (f.fromMonth.value<f.toMonth.value)
		return true;
	if (f.fromMonth.value>f.toMonth.value)
	{
		alert("时间范围错误！")
		f.toMonth.focus();
		return false;
	}

	if (f.fromDay.value<f.toDay.value)
		return true;
	if (f.fromDay.value>f.toDay.value)
	{
		alert("时间范围错误！")
		f.toDay.focus();
		return false;
	}

	if (f.fromHour.value<f.toHour.value)
		return true;
	if (f.fromHour.value>f.toHour.value)
	{
		alert("时间范围错误！")
		f.toHour.focus();
		return false;
	}

	
	if (f.fromMinute.value<f.toMinute.value)
		return true;
	if (f.fromMinute.value>f.toMinute.value)
	{
		alert("时间范围错误！")
		f.toMinute.focus();
		return false;
	}

	if (f.fromSecond.value<f.toSecond.value)
		return true;
	if (f.fromSecond.value>f.toSecond.value)
	{
		alert("时间范围错误！")
		f.toSecond.focus();
		return false;
	}


	return true;

}

function validSelect()
{
	if (f.isPolicy.checked && !ValidNull(f.policyNo,false))
		return false;

	if (f.isTimeTrack.checked &&
		!(ValidYear(f.fromYear) && ValidYear(f.toYear) && ValidMonth(f.fromMonth) &&
		ValidMonth(f.toMonth) && ValidDay(f.fromDay) && ValidDay(f.toDay) && ValidHour(f.fromHour) &&
		ValidHour(f.toHour) && ValidMinute(f.fromMinute) && ValidMinute(f.toMinute) && 
		ValidMinute(f.fromSecond) && ValidMinute(f.toSecond) && ValidDateRange()) )
			return false;
	if (f.isInsuranceCode.checked &&
		!(ValidNull(f.fromInsuranceCode,false) && ValidNull(f.toInsuranceCode,false))
		)
			return false;
	return true;

}

function fixZero(field){
	if (field.value.length == 1)
		field.value = "0"+field.value;

}
</SCRIPT>
<%
out.println("<script language=\"JavaScript\">\nfunction checkAll(){\n");
for (i=1,j=0;i<departList.length;i++,j++)
	out.println("f.is"+j+".checked = true;");
out.println("}\nfunction uncheckAll(){");
for (i=1,j=0;i<departList.length;i++,j++)
	out.println("f.is"+j+".checked = false;");
out.println("}\n</script>\n");
%>
</head>

<body onload="f.isPolicy.checked=false;f.isTimeTrack.checked=false;f.isInsuranceCode.checked=false">
<div align="center"><font color="#0066CC" class="unnamed3">送单信息查询</font></div>
<form name="f" action="Assigned_List.jsp" method=post onSubmit="return (validSelect()) ;">
<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr class="unnamed2" bgcolor="#9DEEDE"> 
	<td height="25" colspan="4"> 请输入查询条件：</td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%" height="19"> 
	  <div align="center"> 
		<input type="radio" name="dealType" value="1" onclick="filter('1');return true">
	  </div>
	</td>
	<td bgcolor="#DFF9F3" colspan="3" height="19">是否受理（ 
	  <input type="checkbox" name="isHandle" value="on" disabled>
	  已处理 
	  <input type="checkbox" name="notHandle" value="on" disabled>
	  未处理） </td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%" height="17"> 
	  <div align="center"> 
		<input type="radio" name="dealType" value="2" onclick="filter('2');return true">
	  </div>
	</td>
	<td bgcolor="#DFF9F3" colspan="3" height="17">是否送到（ 
	  <input type="checkbox" name="isSent" value="on" disabled>
	  已送到 
	  <input type="checkbox" name="notSent" value="on" disabled>
	  未送到） </td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%" height="17"> 
	  <input type="radio" name="dealType" value="3" onclick="filter('3');return true">
	</td>
	<td bgcolor="#DFF9F3" colspan="3" height="17">是否返回（ 
	  <input type="checkbox" name="isBack" value="on" disabled>
	  已返回 
	  <input type="checkbox" name="notBack" value="on" disabled>
	  未返回） </td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%" height="17"> 
	  <input type="radio" name="dealType" value="0" onclick="filter('0');return true" checked>
	</td>
	<td bgcolor="#DFF9F3" colspan="3" height="17">查询所有信息</td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%" height="11"> 
	  <input type="checkbox" name="isPolicy" value="yes" onclick="filter('4');return true">
	</td>
	<td bgcolor="#DFF9F3" colspan="3" height="11">保 单 号: 
	  <input type="text" name="policyNo" size="25" maxlength="20" disabled>
	</td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%"> 
	  <div align="center"> 
		<input type="checkbox" name="isTimeTrack" value="yes" onclick="filter('5');return true">
	  </div>
	</td>
	<td bgcolor="#DFF9F3" colspan="3">投保时间范围：<br>
	  从 
		<input type="text" name="fromYear" size="4" maxlength="4" value="2001" disabled>
		年 
		<input type="text" name="fromMonth" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.fromMonth);">
		月 
		<input type="text" name="fromDay" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.fromDay);">
		日 
		<input type="text" name="fromHour" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.fromHour);">
		: 
		<input type="text" name="fromMinute" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.fromMinute);">
		 
		<input type="hidden" name="fromSecond" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.fromSecond);">
	  <br>
	  到 
		<input type="text" name="toYear" size="4" maxlength="4" value="2001" disabled>
		年 
		<input type="text" name="toMonth" size="2" maxlength="2" value="12" disabled onBlur="fixZero(f.toMonth);">
		月 
		<input type="text" name="toDay" size="2" maxlength="2" value="31" disabled onBlur="fixZero(f.toDay);">
		日 
		<input type="text" name="toHour" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.toHour);">
		: 
		<input type="text" name="toMinute" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.toMinute);">
		 
		<input type="hidden" name="toSecond" size="2" maxlength="2" value="01" disabled onBlur="fixZero(f.toSecond);">
	</td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" width="4%"> 
	  <div align="center"> 
		<input type="checkbox" name="isInsuranceCode" value="yes" onclick="filter('6');return true">
	  </div>
	</td>
	<td bgcolor="#DFF9F3" colspan="3">险种码：<br>
	  从: 
	  <input type="text" name="fromInsuranceCode" maxlength="3" size="5" disabled>
	  到: 
	  <input type="text" name="toInsuranceCode" maxlength="3" size="5" disabled>
	</td>
	</tr>
</table>
                <table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bgcolor="#CBF5EC" bordercolorlight="#009999" bordercolordark="#FFFFFF">
                  <tr bgcolor="#9DEEDE"> 
                    <td colspan="4" height="25">选择查询机构：</td>
                  </tr>
                </table>

<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" bgcolor="#DFF9F3" class="td" bordercolorlight="#009999" bordercolordark="#FFFFFF">

	  <%
	  if (departList!=null && departList.length>1)
	  {

		index_opr_cde=Objects.getColNum("C_OPR_CDE",departList);
		index_dpt_cde=Objects.getColNum("C_DPT_CDE",departList);
		index_dpt_cnm=Objects.getColNum("C_DPT_CNM",departList);
		index_dpt_enm=Objects.getColNum("C_DPT_ENM",departList);
		selStr="checked";
		for (i=1,j=0;i<departList.length;i++,j++)
		{
	  %>
        <tr> 
          <td width="4%"> 
            <input <%=selStr%> type="checkbox" name="is<%=j%>" value="true">
			<input type="hidden" name="dptCde<%=j%>" value="<%=departList[i][index_dpt_cde]%>">
          </td>
          <td width="96%"><%=departList[i][index_dpt_cnm]%></td>
        </tr>
	  <%}%>
		<input type="hidden" name="dptCount" value="<%=j%>">
	<%}
	  else
	  {
	  %>
	  <tr><td><font color="#FF0066">没有找到相应的机构！</font></td></tr>
	  <%
	  }
	  %>
	  <td width="4%">
	  &nbsp;
	  </td>
	  <td width="96%">
		<a href="javascript:checkAll()">全选</a> &nbsp;&nbsp;<a href="javascript:uncheckAll()">清空</a>
	  </td>
      </table>
      <div align="center"> 
	<input type="hidden" name="oprCde" value="<%=formPara[0]%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<input type="hidden" name="isInit" value="true">
    <input type="submit" value="查询" name="B12">
	</div>
</form>
<%@ include file="public/bottom.jsp"%>