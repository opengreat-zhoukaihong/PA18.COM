<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>

<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>
<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>

<% 
	int i=0;
	String[][] info=null;
	String[] formpara={""};
	String optype=null;
	String page_no="";
	String page_title="";
	String file_enm="";
	String func_cnm="00001";
	String functype="";
	
	// ============= begin process   =============================
	optype=request.getParameter("submit");
	if(optype.indexOf("modify") != -1||optype.indexOf("delete") != -1)
	{
		i=Integer.parseInt(request.getParameter("select"));
//		obj_user.setFormPara(ZConst.QUERY_PAGESLIST,formpara);
		info=obj_user.getRetValueArra();
		page_no=Objects.getValue(i,"c_page_no",info);
		page_title=Objects.getValue(i,"c_page_title",info);
		file_enm=Objects.getValue(i,"c_file_enm",info);
		func_cnm=Objects.getValue(i,"c_func_cde",info);
	}
	obj.setFormPara(ZConst.QUERY_SYSFUNCLIST,formpara);
	info=obj.getRetValueArra();

%>
<% 
if( optype.indexOf("delete") != -1 )
{	%>
<form method="POST" name="form55" action="subm_page.jsp">

    <input type="hidden" name="subm" value="<%=optype%>">
    <input type="hidden" name="C_PAGE_NO" value="<%=page_no%>">

  <table bgcolor="#DFF9F3"  border="1" width="100%" align="center">
     <tr bgcolor="#9DEEDE"> 
      <td height=20 width="268" align="center"> 
        页面信息
      </td>
      <td height=20 width="183" align="center"> 
        所属功能范围
      </td>
    </tr>
    <tr> 
      <td valign="top" width="268"> 
        <p align="left"> 页面中文名： <%=page_title%>
        </p>
        <p align="left"> 页面文件名： <%=file_enm%>
        </p>
      </td>
      <td valign="top" width="183"> 
      <%
        if(info!=null)
        {
        	for(i=1;i<info.length;i++)
        	{
	       		functype=Objects.getValue(i,"c_func_cde",info);
        		if(functype==null)functype="00001";
            if( functype.equals(func_cnm) )  
            {   %>
		<p><%=Objects.getValue(i,"c_func_cnm",info)%></p>
      <%    }
      	}
        }
      %>
      </td>
    </tr>
    <tr> 
      <td valign="top" height="4" colspan="2"> 
        <div align="center"> 
          <input type="submit" value="删除" name="submitname">
        </div>
      </td>
    </tr>
  </table>
</form>


<% } else   //=== modify and add operation  ===
{	%>
<form method="POST" name="form55" action="subm_page.jsp" onsubmit="return(
ValidNull(C_PAGE_TITLE,false) &&
ValidNull(C_FILE_ENM,false) 
);">

    <input type="hidden" name="subm" value="<%=optype%>">
    <input type="hidden" name="C_PAGE_NO" value="<%=page_no%>">

   <table border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td" align="center">
     <tr bgcolor="#9DEEDE"> 
      <td  height=20 width="268" align="center"> 
        页面信息
      </td>
      <td  height=20 width="183" align="center"> 
        所属功能范围
      </td>
    </tr>
    <tr> 
      <td valign="top" width="268"> 
        <p>&nbsp;</p>
        <p align="left"> 页面中文名： <br>
          <input type="text" name="C_PAGE_TITLE" value="<%=page_title%>" size="40" maxlength="50">
        </p>
        <p align="left"> 页面文件名：<br>
          <input maxlength="50" name="C_FILE_ENM" value="<%=file_enm%>" size="40">
        </p>
      </td>
      <td valign="top" width="183"> 
      <%
        if(info!=null)
        {
        	for(i=1;i<info.length;i++)
        	{
        		functype=Objects.getValue(i,"c_func_cde",info);
        		if(functype==null)functype="00001";
            if( functype.equals(func_cnm) )  
            {   %>
		<p><input type="radio" name="C_FUNC_CDE" value="<%=Objects.getValue(i,"c_func_cde",info)%>" checked> 
			<%=Objects.getValue(i,"c_func_cnm",info)%></p>
        	<%	} else { %>
       		<p><input type="radio" name="C_FUNC_CDE" value="<%=Objects.getValue(i,"c_func_cde",info)%>"> 
       			<%=Objects.getValue(i,"c_func_cnm",info)%></p>
      <%    }
      	}
        }
      %>
      </td>
    </tr>
    <tr> 
      <td valign="top" height="4" colspan="2" align="center"> 
          <input type="submit" value="提交" name="submitname">
      </td>
    </tr>
  </table>
</form>

<% } %>
<%@ include file="public/bottom.jsp" %>
