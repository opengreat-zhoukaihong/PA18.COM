<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>


<% 
	int i=0;
	String[] formpara=new String[1];
	String[][] info=null;
	String temp="";
//	String func_cde="";
	String func_cnm="";
	String func_enm="";
		
	
	//========== begin process  ============
	String pgnostr=request.getParameter("pgno");
	int pgno=1;
if(pgnostr!=null)
{
	pgno=Integer.parseInt(pgnostr);
}else
{
	try
	{
		formpara[0]="";
		obj_user.setFormPara(ZConst.QUERY_PAGESLIST,formpara);
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  // end try,catch
}

	info=obj_user.getRetValueArra();

	
	int pglen=7;
	int totalpg=0;


%>

<font face="宋体" size="3"> 
<p align="center"> 系统页面维护</p>
</font>
<form method="POST" name="form2" action="Ed_Ad_Page.jsp">
   <table width="85%" align="center" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td">
     <tr bgcolor="#9DEEDE"> 
      <td align="center" width="15%">
        操作
      </td>
      <td align="center" width="29%"> 
        页面中文名
      </td>
      <td align="center" width="27%"> 
        页面文件名
      </td>
      <td align="center" width="29%"> 
        所属功能范围
      </td>
    </tr>
	<% if (info!=null)
	   {
			totalpg=(info.length-1+pglen-1)/pglen;
			int t1=(pgno-1)*pglen+1;
			int t2=(pgno)*pglen+1;
			if(t2>info.length)t2=info.length;
			for(i=t1;i<t2;i++)
			{    %>
    		  <tr>
			<td  width="15%"><a href="Ed_Ad_Page.jsp?submit=modify&select=<%=i%>">修改</a>
			   &nbsp;<a href="Ed_Ad_Page.jsp?submit=delete&select=<%=i%>">删除</a>
			</td>
      			<td width="29%"><%=Objects.getValue(i,"c_page_title",info)%></td>
      			<td width="27%"><%=Objects.getValue(i,"c_file_enm",info)%></td>
     			<td width="29%"><%=Objects.getValue(i,"c_func_cnm",info)%></td>
    		  </tr>
      	<%	}
      	  } %>
    <tr> 
      <td height="29" colspan="4" align="center"> 
          <input type="submit" value="增加/add" name="submit">
      </td>
    </tr>
  </table>
</form>
 <table width="90%" border="0" cellspacing="0" cellpadding="0" class="td">
	<tr>
		<td align="right" width="40%">
		<%if (pgno>1){%>
			<a href="Pages_List.jsp?pgno=<%=1%>">[首页]</a>&nbsp;&nbsp;
			<a href="Pages_List.jsp?pgno=<%=pgno-1%>">[上一页]</a>
		<%}else
		  { out.println("[首页]&nbsp;&nbsp;[上一页]");	}%>  
		</td>
		<td align="center" width="20%" valign="top">
			<p align=center>显示<%=pgno%>/<%=totalpg%></p>
		</td>
		<td align="right" width="40%">
		<%if (pgno < totalpg){%>
			<a href="Pages_List.jsp?pgno=<%=pgno+1%>">[下一页]</a>&nbsp;&nbsp;
			<a href="Pages_List.jsp?pgno=<%=totalpg%>">[尾页]</a>
		<%}else
		  { out.println("[下一页]&nbsp;&nbsp;[尾页]");	}%>  
		</td>
	</tr>
  </table>

<%@ include file="public/bottom.jsp" %>
