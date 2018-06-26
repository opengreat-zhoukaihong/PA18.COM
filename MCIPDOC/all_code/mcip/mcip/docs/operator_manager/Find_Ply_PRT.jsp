<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="Ztool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>

<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">

form1.checkplyno.focus();

form1.checkno.focus();

form1.checkdate.focus();

</SCRIPT>


<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>
<%-- obj_data:(use info2 for employeCode)(data for dptlist)--%>
<jsp:useBean id="obj_buss"  scope="session" class="beans.Zbussbean"/>
<jsp:useBean id="sb"  scope="session" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<%
//PREDEFINE
String insrncResult[][] = null;//list of inusrance type
String formPara[] = null;//list of parameters
int indexOprCde,indexDptCde,indexDptCnm,indexDptEnm;//index of depart table
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

 	String info[][]=null;
	String formpara[]=new String[2];
	int i=0;

	formpara[0]=sessionuser.getuserId(Locate);
	String info2=sessionuser.getemployeCode(Locate);
	obj_data.setinfo2(info2);	//save employeCode for future use
//	out.println("empno="+info2);

//	formpara[0]="test";
try
{
	obj.setFormPara(ZConst.QUERY_OPTRDPTLIST,formpara);
	info=obj.getRetValueArra();
}
catch(NormalException e)
{
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
}  	// end try

	if(info!=null)
	{
		int len=info.length;
		String[] data=new String[len-1];
		for(i=1;i<len;i++)
			data[i-1]=Objects.getValue(i,"c_dpt_cde",info);
		obj_data.setdata(data);//for next page
//		obj_buss.setFormParaPre(1,data);	//for next page
	}

	Calendar today=Calendar.getInstance();
	int year2=today.get(Calendar.YEAR);
	int month2=today.get(Calendar.MONTH)+1;
	int day2=today.get(Calendar.DATE);

	today.add(Calendar.DATE,-1);
	int year1=today.get(Calendar.YEAR);
	int month1=today.get(Calendar.MONTH)+1;
	int day1=today.get(Calendar.DATE);
%>
<%/*
out.println("<script language=\"JavaScript\">\nfunction checkAll(){\n");
if(info.length==2)
	out.println("form1.checkorgn.checked = true;");
else
  for (i=0;i<info.length-1;i++)
	out.println("form1.checkorgn["+i+"].checked = true;");
out.println("}\nfunction uncheckAll(){");
if(info.length==2)
	out.println("form1.checkorgn.checked = false;");
else
  for (i=0;i<info.length-1;i++)
	out.println("form1.checkorgn["+i+"].checked = false;");
out.println("}\n</script>\n");
*/%>

<div align="center"><font color="#0066CC" class="unnamed3">送单打印查询</font><br><br></div>
<form name="form1" action="Print_PlyApp_List.jsp" onsubmit="return(
   (IsChecked2(checkdate) ||
    ( ValidDateNew(tempdatefr,from_year)&&

   ValidDateNew(tempdateto,to_year) &&
	ValidHour(from_hour) &&
	ValidMinute(from_minute) &&
	ValidSecond(from_second) &&
	ValidHour(to_hour) &&
	ValidMinute(to_minute) &&
	ValidSecond(to_second)  )  )
	&&
	( IsCheckedBox(checkchoice0,checkchoice1) )
);">
 <input type="hidden" name="opr_cde" value="<%=formpara[0]%>">
 <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr class="unnamed2" bgcolor="#9DEEDE">
       <td height="25" colspan="4"> 请输入查询条件：</td>
    </tr>
 <tr>
   <td bgcolor="#DFF9F3" width="4%" height="15">
     <div align="center">
        <input type="checkbox" name="checkchoice1" value="1" checked>
     </div>
   </td>
   <td bgcolor="#DFF9F3" colspan="2" height="15">已打印保单 </td>
   <td bgcolor="#DFF9F3" width="54%" height="15">
        <input type="checkbox" name="checkchoice0" value="0">
     未打印保单</td>
 </tr>
 <tr>
  <td bgcolor="#DFF9F3" width="4%" height="17">
    <div align="center">
       <input type="checkbox" name="checkplyno" value="checkbox" onclick="PlyDisable(checkplyno,c_ply_no);" onfocus="PlyDisable(checkplyno,c_ply_no);">
    </div>
  </td>
  <td bgcolor="#DFF9F3" colspan="3" height="17">保 单 号：
      <input type="text" name="c_ply_no" size="25" maxlength="20">
  </td>
 </tr>
	<tr>
   <td bgcolor="#DFF9F3" width="4%">
     <div align="center">
        <input type="checkbox" name="checkdate" value="checkbox" onclick="DisableTwelve(checkdate,from_year,from_month,from_day,to_year,to_month,to_day,from_hour,from_minute,from_second,to_hour,to_minute,to_second);"
							 onfocus="DisableTwelve(checkdate,from_year,from_month,from_day,to_year,to_month,to_day,from_hour,from_minute,from_second,to_hour,to_minute,to_second);">
     </div>
   </td>
   <td bgcolor="#DFF9F3" colspan="3">时间范围：<br>
     从
        <input type="text" name="from_year" size="5" maxlength="4" value="<%=year1%>">
        年
        <input type="text" name="from_month" size="3" maxlength="2" value="<%=month1%>">
        月
        <input type="text" name="from_day" size="3" maxlength="2" value="<%=day1%>">
        日
        <input type="text" name="from_hour" size="3" maxlength="2" value="01">
        :
        <input type="text" name="from_minute" size="3" maxlength="2" value="01">

        <input type="hidden" name="from_second" size="3" maxlength="2" value="01">
	    <br>到
        <input type="text" name="to_year" size="5" maxlength="4" value="<%=year2%>">
        年
        <input type="text" name="to_month" size="3" maxlength="2" value="<%=month2%>">
        月
        <input type="text" name="to_day" size="3" maxlength="2" value="<%=day2%>">
        日
        <input type="text" name="to_hour" size="3" maxlength="2" value="01">
        :
        <input type="text" name="to_minute" size="3" maxlength="2" value="01">

        <input type="hidden" name="to_second" size="3" maxlength="2" value="01">
   </td>
	</tr>
   <tr>
     <td bgcolor="#DFF9F3" width="4%">
       <div align="center">
        <input type="checkbox" name="checkno" value="checkno" onclick="DisableTwo(checkno,insrnum1,insrnum2);"
				onfocus="DisableTwo(checkno,insrnum1,insrnum2);">
       </div>
     </td>
     <td bgcolor="#DFF9F3" colspan="3">险种码：<br>
       从:
	<select name="insrnum1">
					<option selected value="">请选择</option>
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
		<select name="insrnum2">
					<option selected value="">请选择</option>
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
     </td>
   </tr>
 </table>
  <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bgcolor="#CBF5EC" bordercolorlight="#009999" bordercolordark="#FFFFFF">
      <tr bgcolor="#9DEEDE">
         <td colspan="4" height="25">选择查询机构：</td>
      </tr>
  </table>
  <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center" bgcolor="#DFF9F3" class="td" bordercolorlight="#009999" bordercolordark="#FFFFFF">
		<%	if (info!=null)
			{
				for(i=1;i<info.length;i++)
				{    %>
        <tr>
            <td width="5%">
        		<input type="checkbox" name="checkorgn" value="<%=Objects.getValue(i,"C_DPT_CDE",info)%>"></td>
                  <td width="95%"><%=Objects.getValue(i,"C_DPT_CNM",info)%></td>
        </tr>
			<%	}
			}
		%>
       <tr>
            <td width="5%" height="18">&nbsp; </td>
            <td width="95%" height="18"><a href="javascript:SetChecked('checkorgn',1)">全选</a> <a href="javascript:SetChecked('checkorgn',0)">清空</a>
            </td>
      </tr>
      <tr>
        <td width="5%" height="18">&nbsp;</td>
        <td width="95%" height="18">
           <input type="hidden" name="tempdatefr" value="2000-08-28">

           <input type="hidden" name="tempdateto" value="2000-08-28">

          <div align="center">
            <input type="submit" name="Submit" value="查询"  onclick="change(from_year,from_month,from_day,tempdatefr);change(to_year,to_month,to_day,tempdateto);return true;">
          </div>
        </td>
     </tr>
  </table>
</form>
<%@ include file="public/bottom.jsp" %>
<script lanaguage=JavaScript>
function SetChecked(name ,val) {
    dml=document.form1;

    len = dml.elements.length;

    var i=0;

    for( i=0 ; i<len ; i++) {

    if (dml.elements[i].name==name) {

    dml.elements[i].checked=val;

    }

   }
 }
</script>
