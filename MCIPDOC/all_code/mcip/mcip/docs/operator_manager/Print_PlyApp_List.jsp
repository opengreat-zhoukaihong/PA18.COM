<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_buss"  scope="session" class="beans.Zbussbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>
<%-- obj_data:(use info2 for employeCode)(data for dptlist)--%>
<%
 	String info[][]=null;
	String formpara[]=new String[8];
	String choice0=null;
	String choice1=null;
	int i=0;

	for(i=0;i<8;i++)
		formpara[i]="";
	formpara[0]=request.getParameter("opr_cde");
	choice0=request.getParameter("checkchoice0");
	choice1=request.getParameter("checkchoice1");
	if(choice0!=null && choice1!=null)
	{
		formpara[1]="2";
	}else
	{
		if(choice0!=null)formpara[1]="0";
		if(choice1!=null)formpara[1]="1";
	}
	if(request.getParameter("checkplyno")!=null)formpara[2]=request.getParameter("c_ply_no");
	if(request.getParameter("checkdate")!=null)
	{
		formpara[3]=request.getParameter("from_year")+"-"+request.getParameter("from_month")+"-"+request.getParameter("from_day")
			+" "+request.getParameter("from_hour")+":"+request.getParameter("from_minute")+":"+request.getParameter("from_second");
		formpara[4]=request.getParameter("to_year")+"-"+request.getParameter("to_month")+"-"+request.getParameter("to_day")
			+" "+request.getParameter("to_hour")+":"+request.getParameter("to_minute")+":"+request.getParameter("to_second");
//		=from_time;
//		=to_time;
	}
	if(request.getParameter("checkno")!=null)
	{
		formpara[5]=request.getParameter("insrnum1");
		formpara[6]=request.getParameter("insrnum2");
	}
	String[] data=request.getParameterValues("checkorgn");
	if(data!=null)
	{
		obj_buss.setFormParaPre(1,data);
	}else
	{
		data=obj_data.getdata();
	}
//	out.println("debug:"+formpara[7]);
	try
	{
//debug
//	for(i=0;i<8;i++)
//		out.println("form"+i+"= "+formpara[i]);
		obj_buss.setFormParaPre(1,data);
		obj_buss.setFormPara(ZConst.QUERY_PLYNETLIST,formpara);
		info=obj_buss.getRetValueArra();
  	}
  	catch(NormalException e)
 	{
 		if(NormalExceptionHandler.IsSevere(e))
     		throw NormalExceptionHandler.Handle(e);
  	}
%>
<%
if(info!=null)
{
out.println("<script language=\"JavaScript\">\nfunction checkAll(){\n");
for (i=0;i<info.length-1;i++)
	out.println("form1.checkno["+i+"].checked = true;");
out.println("}\nfunction uncheckAll(){");
for (i=0;i<info.length-1;i++)
	out.println("form1.checkno["+i+"].checked = false;");
out.println("}\n</script>\n");
}
%>
 <div align="center"><font color="#0066CC" class="unnamed3">送单打印查询</font><br>
 <form name="form1" target='blank' method="POST" action="Print_View.jsp">
  <input type="hidden" name="c_opr_cde" value="<%=formpara[0]%>">
   <table  align="center" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td">
     <tr bgcolor="#9DEEDE"> 
    <td>
      <div align="center">请选择</div>
    </td>
      
    <td> 
      <div align="center">保单号</div>
      </td>
      <td> 
        <div align="center">打印人</div>
      </td>
      <td> 
        <div align="center">打印时间</div>
      </td>
	  <td align="center">
		付费情况
	  </td>
    </tr>
		<%	if (info==null)
			{	%>
         <tr> 
            <td valign="top" colspan="4" align="center"><font color=red>没有找到查询的记录！<font></td>
          </tr>
		<%	}else
			{
				for(i=1;i<info.length;i++)
				{    %>
    			  <tr>
        			<td><input type="checkbox" name="checkno" value="<%=i%>"></td>
      			<td><%=Objects.getValue(i,"C_PLY_NO",info)%> &nbsp;</td>
      			<td><%=Objects.getValue(i,"C_PRT_EMP_CNM",info)%> &nbsp;</td>
       			<td><%=Objects.getValue(i,"T_PRINT_TM",info)%> &nbsp;</td>
				<td><%if (Objects.getValue(i,"C_PAY_FLAG",info).equals("1")){%>
					<font color="red">保费已付&nbsp;</font>
					<%}else{%>
					保费未付
					<%}%>
					</td>
    			  </tr>
			<% } //for i<info.length 
				 %>
    <tr> 
	  <td colspan="3">
		<a href="javascript:checkAll()">全选</a> &nbsp;&nbsp;<a href="javascript:uncheckAll()">清空</a>
	  </td>
      <td colspan="2"> 
        <div align="center"><font face="宋体" size="4"> 
          <input type="submit" value="打印预览" name="B1">
          </font></div>
      </td>
    </tr>
 <% } //for info==null 
 %>
  </table>
</form>
<%@ include file="public/bottom.jsp" %>
<!--   onclick="form1.target='blank';return true;"-->