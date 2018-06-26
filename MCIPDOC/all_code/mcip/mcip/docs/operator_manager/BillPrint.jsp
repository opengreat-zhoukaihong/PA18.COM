<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="sb"  scope="session" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>
<%
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

String insrncResult[][]= null;
		try//获得业务险种列表
	{
		formPara = new String[1];
		formPara[0] = "";
		sb.setFieldValue(Const.GET_INSURANCEDEFINE,formPara[0]);
		insrncResult = sb.getRetValueArra();
	}
	catch(NormalException e)
	{
		insrncResult = null;
	}

%>
<script language="JavaScript" src="check.js">
</script>
<SCRIPT LANGUAGE="JavaScript" >
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
	if (!(ValidYear(f.fromYear) && ValidYear(f.toYear) && ValidMonth(f.fromMonth) &&
		ValidMonth(f.toMonth) && ValidDay(f.fromDay) && ValidDay(f.toDay) && ValidHour(f.fromHour) &&
		ValidHour(f.toHour) && ValidMinute(f.fromMinute) && ValidMinute(f.toMinute) && 
		ValidMinute(f.fromSecond) && ValidMinute(f.toSecond) && ValidDateRange()) )
			return false;
	if (!(ValidNull(f.fromInsuranceCode,false) && ValidNull(f.toInsuranceCode,false)))
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
	out.println("f.dptCde"+j+".checked = true;");
out.println("}\nfunction uncheckAll(){");
for (i=1,j=0;i<departList.length;i++,j++)
	out.println("f.dptCde"+j+".checked = false;");
out.println("}\n</script>\n");
%>
</head>

<body>
<div align="center"><font color="#0066CC" class="unnamed3">对帐清单</font></div>
<form name="f" action="BillOrg.jsp" method=post onSubmit="return (validSelect()) ;">
<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr class="unnamed2" bgcolor="#9DEEDE"> 
	<td height="25" colspan="4"> 请输入查询条件：</td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" colspan="4">交易时间范围：<br>
	  从 
		<input type="text" name="fromYear" size="4" maxlength="4" value="2001" >
		年 
		<input type="text" name="fromMonth" size="2" maxlength="2" value="01"  onBlur="fixZero(f.fromMonth);">
		月 
		<input type="text" name="fromDay" size="2" maxlength="2" value="01"  onBlur="fixZero(f.fromDay);">
		日 
		<input type="text" name="fromHour" size="2" maxlength="2" value="01"  onBlur="fixZero(f.fromHour);">
		: 
		<input type="text" name="fromMinute" size="2" maxlength="2" value="01"  onBlur="fixZero(f.fromMinute);">
		 
		<input type="hidden" name="fromSecond" size="2" maxlength="2" value="01"  onBlur="fixZero(f.fromSecond);">
	  <br>
	  到 
		<input type="text" name="toYear" size="4" maxlength="4" value="2001" >
		年 
		<input type="text" name="toMonth" size="2" maxlength="2" value="12"  onBlur="fixZero(f.toMonth);">
		月 
		<input type="text" name="toDay" size="2" maxlength="2" value="31"  onBlur="fixZero(f.toDay);">
		日 
		<input type="text" name="toHour" size="2" maxlength="2" value="01"  onBlur="fixZero(f.toHour);">
		: 
		<input type="text" name="toMinute" size="2" maxlength="2" value="01"  onBlur="fixZero(f.toMinute);">
		 
		<input type="hidden" name="toSecond" size="2" maxlength="2" value="01"  onBlur="fixZero(f.toSecond);">
	</td>
	</tr>
	<tr> 
	<td bgcolor="#DFF9F3" colspan="3">险种码：<br>
	  从:
	  <select name="fromInsuranceCode">
		  <%if (insrncResult != null && insrncResult.length > 1){
				int	indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",insrncResult);
				int	indexInsrncCls = Objects.getColNum("C_INSRNC_CLS",insrncResult);
				int	indexInsrncTyp = Objects.getColNum("C_INSRNC_TYP",insrncResult);
				int	indexInsrncCnm = Objects.getColNum("C_INSRNC_CNM",insrncResult);
				int	indexInsrncEnm = Objects.getColNum("C_INSRNC_ENM",insrncResult);
				int	indexInsrncAbr = Objects.getColNum("C_INSRNC_ABR",insrncResult);
				int	indexRate = Objects.getColNum("N_RATE",insrncResult);
				int	indexNclmPropAuth = Objects.getColNum("N_NCLM_PROP_AUTH",insrncResult);
				int	indexAppntPropAuth = Objects.getColNum("N_APPNT_PROP_AUTH",insrncResult);
				int	indexCmmRteAuth = Objects.getColNum("N_CMM_RTE_AUTH",insrncResult);
				int	indexBrkrRteAuth = Objects.getColNum("N_BRKR_RTE_AUTH",insrncResult);
				int	indexInsrncDfnTyp = Objects.getColNum("C_INSRNC_DFN_TYP",insrncResult);
				for (i=1;i<insrncResult.length;i++){
		  %>
			<option value="<%=insrncResult[i][indexInsrncCde]%>"><%=insrncResult[i][indexInsrncCnm]%>(<%=insrncResult[i][indexInsrncCde]%>)</option>
		  <%	}
		  }%>
        </select>
	  到: 
        <select name="toInsuranceCode">
		  <%if (insrncResult != null && insrncResult.length > 1){
				int	indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",insrncResult);
				int	indexInsrncCls = Objects.getColNum("C_INSRNC_CLS",insrncResult);
				int	indexInsrncTyp = Objects.getColNum("C_INSRNC_TYP",insrncResult);
				int	indexInsrncCnm = Objects.getColNum("C_INSRNC_CNM",insrncResult);
				int	indexInsrncEnm = Objects.getColNum("C_INSRNC_ENM",insrncResult);
				int	indexInsrncAbr = Objects.getColNum("C_INSRNC_ABR",insrncResult);
				int	indexRate = Objects.getColNum("N_RATE",insrncResult);
				int	indexNclmPropAuth = Objects.getColNum("N_NCLM_PROP_AUTH",insrncResult);
				int	indexAppntPropAuth = Objects.getColNum("N_APPNT_PROP_AUTH",insrncResult);
				int	indexCmmRteAuth = Objects.getColNum("N_CMM_RTE_AUTH",insrncResult);
				int	indexBrkrRteAuth = Objects.getColNum("N_BRKR_RTE_AUTH",insrncResult);
				int	indexInsrncDfnTyp = Objects.getColNum("_INSRNC_DFN_TYP",insrncResult);
				for (i=1;i<insrncResult.length;i++){
		  %>
			<option value="<%=insrncResult[i][indexInsrncCde]%>"><%=insrncResult[i][indexInsrncCnm]%>(<%=insrncResult[i][indexInsrncCde]%>)</option>
		  <%	}
		  }%>
        </select>
	</td>
	</tr>
</table>
                <table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bgcolor="#CBF5EC" bordercolorlight="#009999" bordercolordark="#FFFFFF">
                  <tr bgcolor="#9DEEDE"> 
                    <td colspan="4" height="25">选择查询机构：</td>
                  </tr>
                </table>

<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" bgcolor="#DFF9F3" class="td" bordercolorlight="#009999" bordercolordark="#FFFFFF">
<tr>
<td>
		<select name="dpt">
	  <%
	  if (departList!=null && departList.length>1)
	  {

		index_opr_cde=Objects.getColNum("C_OPR_CDE",departList);
		index_dpt_cde=Objects.getColNum("C_DPT_CDE",departList);
		index_dpt_cnm=Objects.getColNum("C_DPT_CNM",departList);
		index_dpt_enm=Objects.getColNum("C_DPT_ENM",departList);
		for (i=1,j=0;i<departList.length;i++,j++)
		{
	  %>
		  <option value="<%=departList[i][index_dpt_cde]%>&<%=departList[i][index_dpt_cnm]%>"><%=departList[i][index_dpt_cde]%>(<%=departList[i][index_dpt_cnm]%>)</option>
	  <%}
	  }
	  %>
	  </select>
	  </td>
	  </tr>
      </table>
      <div align="center"> 
	<input type="hidden" name="oprCde" value="<%=formPara[0]%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<input type="hidden" name="isInit" value="true">
    <input type="submit" value="查询" name="B12">
	</div>
</form>
<%@ include file="public/bottom.jsp"%>