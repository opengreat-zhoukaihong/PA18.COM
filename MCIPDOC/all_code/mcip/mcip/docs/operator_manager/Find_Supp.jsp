<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
form1.checkname.focus();
</SCRIPT>

<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>
<% //obj_data (.data used for dptlist)
 	String info[][]=null;
	String formpara[]=new String[1];
	int i=0;
	
  formpara[0]=sessionuser.getuserId(Locate); 

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
%>

<%
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
%>

<p>内勤人员查询</p>
<form name="form1" action="Supp_List.jsp" method=post onSubmit="">

<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
  <tr class="unnamed2" bgcolor="#9DEEDE"> 
    <td height="25" colspan="4"> 请输入查询条件：</td>
  </tr>
  <tr> 
    <td bgcolor="#DFF9F3" width="4%" height="19"> 
      <input type="radio" name="C_EMP_TYPE" value="1" checked>
      会员审批操作 
      <input type="radio" name="C_EMP_TYPE" value="2">
      保单审核操作 
      <input type="radio" name="C_EMP_TYPE" value="3">
      保单调度操作 
      <input type="radio" name="C_EMP_TYPE" value="4">
      报案处理操作 </td>
  </tr>
  <tr> 
    <td bgcolor="#DFF9F3" width="4%" height="16"> 
      <input type="checkbox" name="checkname" value="checkbox" onClick="PlyDisable(checkname,emp_nme);"
				onFocus="PlyDisable(checkname,emp_nme);">
      内 勤 人 姓 名： 
      <input type="text" name="emp_nme" size="40" value="" maxlength="60">
    </td>
  </tr>
</table>
<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bgcolor="#CBF5EC" bordercolorlight="#009999" bordercolordark="#FFFFFF">
  <tr bgcolor="#9DEEDE"> 
    <td colspan="4" height="25">选择查询机构：</td>
  </tr>
</table>
<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" bgcolor="#DFF9F3" class="td" bordercolorlight="#009999" bordercolordark="#FFFFFF">
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
		  <td width="4%">&nbsp; </td>
		  <td width="96%">
			<a href="javascript:checkAll()">全选</a> &nbsp;&nbsp;<a href="javascript:uncheckAll()">清空</a>
		  </td>
	  <tr> 
		 <td width="5%" height="30">&nbsp;</td>
	    <td width="95%"> 
		   <div align="center"> 
			  <input type="submit" name="Submit" value="查询" onClick="">
	      </div>
		 </td>
	  </tr>
  </table>
</Form>
<%@ include file="public/bottom.jsp" %>
