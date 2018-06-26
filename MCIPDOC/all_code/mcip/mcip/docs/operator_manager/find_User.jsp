<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
form1.checkdate1.focus();
form1.checkdate2.focus();
form1.checkname.focus();
form1.checkno.focus();
</SCRIPT>

<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>
<%	//obj_data (.info1 used for opr_cde)(.data used for dptlist)
 //

	String info[][]=null;
	String formpara[]=new String[2];
	boolean Isright = false;
	int i=0;

	formpara[0]=sessionuser.getuserId(Locate);

//	formpara[0]="test";
//	formpara[1]="00004";
//check operator right

try
{
	formpara[1]=request.getParameter("fCode");
	obj.setFormPara(ZConst.CHECK_OPTRAUTH,formpara);
	Isright=obj.getRetValueBool();
	if(Isright==false)
	{
		out.println("没有操作权限！");
		throw new NormalException("<h3>没有操作权限！</h3>");
	}
}
catch(NormalException e)
{
		if(NormalExceptionHandler.IsSevere(e))
			throw NormalExceptionHandler.Handle(e);
}  	// end try

//	formpara[0]="test";
	obj_data.setinfo1(formpara[0]);
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
		int leng=info.length;
		String[] data=new String[leng-1];
		for(i=1;i<leng;i++)
			data[i-1]=Objects.getValue(i,"c_dpt_cde",info);
		obj_data.setdata(data);
	}else
	{
		throw new NormalException(" 没有找到管辖机构！");
	}

	Calendar today=Calendar.getInstance();
	int year2=today.get(Calendar.YEAR);
	int month2=today.get(Calendar.MONTH)+1;
	int day2=today.get(Calendar.DATE);
/*
	out.println("today is "+today.get(Calendar.YEAR));
	out.println("today is "+today.get(Calendar.MONTH));
	out.println("today is "+today.get(Calendar.DATE));
*/
	today.add(Calendar.DATE,-1);
	int year1=today.get(Calendar.YEAR);
	int month1=today.get(Calendar.MONTH)+1;
	int day1=today.get(Calendar.DATE);



%>
<%
String adminFlag = sessionuser.getadminFlag(Locate);
int infoLength = 0;
if (info != null)
	if ( adminFlag.equals("1")){
		for (i=0;i<info.length;i++)
			if (Objects.getValue(i,"C_DPT_CDE",info).length() == 3){
				infoLength ++;
			}
	}
	else{
		infoLength = info.length;
	}

out.println("<script language=\"JavaScript\">\nfunction checkAll(){\n");
if(infoLength==2)
	out.println("form1.checkorgn.checked = true;");
else
	for (i=0;i<infoLength-1;i++)
	out.println("form1.checkorgn["+i+"].checked = true;");
out.println("}\nfunction uncheckAll(){");
if(infoLength==2)
	out.println("form1.checkorgn.checked = false;");
else
	for (i=0;i<infoLength-1;i++)
	out.println("form1.checkorgn["+i+"].checked = false;");
out.println("}\n</script>\n");
%>

<div align="center"><font color="#0066CC" class="unnamed3">查 询 会 员 基 本 资 料 </font><br><br></div>

<form name="form1" action="editUserinfolist.jsp" onsubmit="return(
	 (IsChecked2(checkdate1) ||
		( ValidDateNew(tempdatefr1,from_year1)&&
	 ValidDateNew(tempdateto1,to_year1)
		) )
	&&
	( IsChecked2(checkdate2) ||
		( ValidDateNew(tempdatefr2,from_year2)&&
	 ValidDateNew(tempdateto2,to_year2) )  )
	&&
	 ( IsChecked2(checkno) || ValidInt(lognum1)&&ValidInt(lognum2) )
);"
>
	<input type="hidden" name="opr_cde" value="<%=formpara[0]%>">
 <table width="100%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
		<tr class="unnamed2" bgcolor="#9DEEDE">
			 <td height="25" colspan="4"> 请输入查询条件：</td>
		</tr>
	 <tr>
		 <td bgcolor="#DFF9F3" width="4%" height="19">
					 <input type="radio" name="checkuser" value="2" checked>
						所有用户
						<input type="radio" name="checkuser" value="0">
						未核实用户
						<input type="radio" name="checkuser" value="1">
						已核实用户
		</td>
	</tr>
	<tr>
		 <td bgcolor="#DFF9F3" width="4%" height="16">
						<input type="checkbox" name="checkname" value="checkbox" onclick="PlyDisable(checkname,username);"
				onfocus="PlyDisable(checkname,username);">
						 用户名：
						<input type="text" name="username" size="16" value="" maxlength="16">
		</td>
	</tr>
	<tr>
		 <td bgcolor="#DFF9F3" width="4%" height="16">
				<input type="checkbox" name="checkdate1" value="checkbox" onclick="DateDisable(checkdate1,from_year1,from_month1,from_day1,to_year1,to_month1,to_day1);"
				onfocus="DateDisable(checkdate1,from_year1,from_month1,from_day1,to_year1,to_month1,to_day1);">
						注册时间从:
						<input type="text" name="from_year1" size="5" maxlength="4" value="<%=year1%>">
						年
						<input type="text" name="from_month1" size="3" maxlength="2" value="<%=month1%>">
						月
						<input type="text" name="from_day1" size="3" maxlength="2" value="<%=day1%>">
						日&nbsp;到:
						<input type="text" name="to_year1" size="5" maxlength="4" value="<%=year2%>">
						年
						<input type="text" name="to_month1" size="3" maxlength="2" value="<%=month2%>">
						月
						<input type="text" name="to_day1" size="3" maxlength="2" value="<%=day2%>">
						日 </font></div>
		</td>
	</tr>
	<tr>
		 <td bgcolor="#DFF9F3" width="4%" height="16">
						<input type="checkbox" name="checkdate2" value="checkbox"
				onclick="DateDisable(checkdate2,from_year2,from_month2,from_day2,to_year2,to_month2,to_day2);"
				onfocus="DateDisable(checkdate2,from_year2,from_month2,from_day2,to_year2,to_month2,to_day2);">
						核准时间从:
						<input type="text" name="from_year2" size="5" maxlength="4" value="<%=year1%>">
						年
						<input type="text" name="from_month2" size="3" maxlength="2" value="<%=month1%>">
						月
						<input type="text" name="from_day2" size="3" maxlength="2" value="<%=day1%>">
						日&nbsp;到:
						<input type="text" name="to_year2" size="5" maxlength="4" value="<%=year2%>">
						年
						<input type="text" name="to_month2" size="3" maxlength="2" value="<%=month2%>">
						月
						<input type="text" name="to_day2" size="3" maxlength="2" value="<%=day2%>">
						日</font></div>
		</td>
	</tr>
	<tr>
		 <td bgcolor="#DFF9F3" width="4%" height="16">
						<input type="checkbox" name="checkno" value="checkbox" onclick="DisableTwo(checkno,lognum1,lognum2);"
				onfocus="DisableTwo(checkno,lognum1,lognum2);">
						登录次数：从
						<input type="text" name="lognum1" size="5" value="1" maxlength="4">
						到
						<input type="text" name="lognum2" size="5" value="10" maxlength="4">
	</td></tr>
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
				{
					String dptCde = Objects.getValue(i,"C_DPT_CDE",info);
					if ( !adminFlag.equals("1") || dptCde.length() == 3){
					%>
				<tr>
						<td width="5%">
						<input type="checkbox" name="checkorgn" value="<%=Objects.getValue(i,"C_DPT_CDE",info)%>"></td>
									<td width="95%"><%=Objects.getValue(i,"C_DPT_CNM",info)%></td>
				</tr>
			<%	}
			}
			}
		%>
			 <tr><font color=red>
						<td width="5%" height="18">&nbsp; </td>
						<td width="95%" height="18"><a href="javascript:checkAll()"><font color=red>全选</a> <a href="javascript:uncheckAll()">清空</font></a>
						</td>
			</tr>
			<tr>
				<td width="5%" height="18">&nbsp;</td>
				<td width="95%" height="18">
					 <input type="hidden" name="tempdatefr1" value="2000-08-28">
					 <input type="hidden" name="tempdateto1" value="2000-08-28">
					 <input type="hidden" name="tempdatefr2" value="2000-08-28">
					 <input type="hidden" name="tempdateto2" value="2000-08-28">
					<div align="center">
						<input type="submit" name="Submit" value="查询"
				onclick="change(from_year1,from_month1,from_day1,tempdatefr1);change(to_year1,to_month1,to_day1,tempdateto1);
				change(from_year2,from_month2,from_day2,tempdatefr2);change(to_year2,to_month2,to_day2,tempdateto2);return true;">
					</div>
				</td>
		 </tr>
	</table>

 </form>
<%@ include file="public/bottom.jsp" %>


