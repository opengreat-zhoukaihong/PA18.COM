<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>


<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>

<%
	String info[][]=null;
	String formpara[]=new String[3];
	String choice0=null;
	String choice1=null;
	int i=0;

//  begin process
	String pgnostr=request.getParameter("pgno");
	int pgno=1;
if(pgnostr!=null)
{
	pgno=Integer.parseInt(pgnostr);
}else
{
	for(i=0;i<3;i++)
		formpara[i]="";

	if(request.getParameter("checkname")!=null)
	{
		formpara[0]=(request.getParameter("emp_nme") ).trim();
	}
	formpara[1]=request.getParameter("C_EMP_TYPE");

	String[] formparaPre=null;
	if(request.getParameter("checkorgn")!=null)
	{
		formparaPre=request.getParameterValues("checkorgn");
	}else
	{
		formparaPre=obj_data.getdata();
	}

	try
	{
		obj_user.setFormParaPre(ZConst.QUERY_SUPPEMAILLIST,formparaPre);
		obj_user.setFormPara(ZConst.QUERY_SUPPEMAILLIST,formpara);
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   } 
}	//end if pg!=null

	info=obj_user.getRetValueArra();

	
	int pglen=7;
	int totalpg=0;
	
%>

<p>内勤人员列表</p>
<table  align="center" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td" width="90%">
  <tr bgcolor="#9DEEDE"> 
    <td align="center" width="20%">姓名</td>
    <td align="center" width="30%"> 电子邮件地址</td>
    <td align="center" width="20%">所属机构</td>
    <td align="center" width="20%">操作</td>
  </tr>
		<%	if (info==null)
			{	%>
				<tr> 
				 <td valign="top" colspan="10" align="center"><font color=red>没有找到内勤人员记录！<font></td>
				</tr>
		<%	}else
			{
				totalpg=(info.length-1+pglen-1)/pglen;
				int t1=(pgno-1)*pglen+1;
				int t2=(pgno)*pglen+1;
				if(t2>info.length)t2=info.length;
				String status="";
				for(i=t1;i<t2;i++)
				{ 
					%>
    			  <tr>
        			<td><%=Objects.getValue(i,"c_emp_nme",info)%> &nbsp;</td>
        			<td><%=Objects.getValue(i,"c_emp_email",info)%> &nbsp;</td>
        			<td><%=Objects.getValue(i,"c_dpt_cnm",info)%> &nbsp;</td>
        			<td><a href="ed_supp.jsp?select=<%=i%>">修改</a>
						&nbsp;<a href="del_supp.jsp?select=<%=i%>">删除</a>
					</td>
    			  </tr>
      	<%	} %>
      <%	} //end for info==null
      %>
 </table>
 <table width="90%" border="0" cellspacing="0" cellpadding="0" class="td">
	<tr>
		<td align="right" width="40%">
		<%if (pgno>1){%>
			<a href="Supp_List.jsp?pgno=<%=1%>">[首页]</a>&nbsp;&nbsp;
			<a href="Supp_List.jsp?pgno=<%=pgno-1%>">[上一页]</a>
		<%}else
		  { out.println("[首页]&nbsp;&nbsp;[上一页]");	}%>  
		</td>
		<td align="center" width="20%" valign="top">
			<p align=center>显示<%=pgno%>/<%=totalpg%></p>
		</td>
		<td align="right" width="40%">
		<%if (pgno < totalpg){%>
			<a href="Supp_List.jsp?pgno=<%=pgno+1%>">[下一页]</a>&nbsp;&nbsp;
			<a href="Supp_List.jsp?pgno=<%=totalpg%>">[尾页]</a>
		<%}else
		  { out.println("[下一页]&nbsp;&nbsp;[尾页]");	}%>  
		</td>
	</tr>
  </table>

<%@ include file="public/bottom.jsp" %>
