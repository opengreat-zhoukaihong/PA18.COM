<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_user"  scope="page" class="beans.Zuserbean"/>

<%
	String formpara[]=new String[1];
	String[][] info=null;
	int i=0;
	
	formpara[0]=(String)request.getParameter("c_clnt_nme");

	try
	{
		obj_user.setFormPara(ZConst.QUERY_SAMECUSTLIST,formpara);
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  	// end try
   catch(Exception e)
	{
	}
   
   info=obj_user.getRetValueArra();

%>


<div align="center"><font color="#0066CC" class="unnamed3"> 同 名 会 员 清 单 <br></font> 
 <table width="98%" border="0" cellspacing="0" cellpadding="0" class="td">
   <tr>
     <td>同名客户的基本资料：</td>
   </tr>
 </table>
<table width="98%" border="1" cellspacing="0" cellpadding="0" bordercolor="#009966" bgcolor="#F4FFF4" bordercolorlight="#FFFFFF" class="td" height="120">
  <tr bgcolor="#E1FFE1"> 
    <td height="22" width="12%"> 
      <div align="center">客户编号</div>
    </td>
    <td height="22" width="22%"> 
      <div align="center">身份证号/工商登记号</div>
    </td>
    <td height="22" width="11%"> 
      <div align="center">电话号码</div>
    </td>
    <td height="22" width="11%"> 
      <div align="center">传真</div>
    </td>
    <td height="22" width="11%"> 
      <div align="center">E-Mail</div>
    </td>
    <td height="22" width="37%"> 
      <div align="center">客户地址</div>
    </td>
  </tr>
		<%	if (info==null)
			{
				out.println("没有找到查询的记录！");
			}else
			{
				for(i=1;i<info.length;i++)
				{    %>
    			  <tr>
      			<td><%=Objects.getValue(i,"C_CLNT_CDE",info)%>&nbsp;</td>
      			<td><%=Objects.getValue(i,"C_RGST_NO",info)%>&nbsp;</td>
       			<td><%=Objects.getValue(i,"C_TEL",info)%>&nbsp;</td>
       			<td><%=Objects.getValue(i,"C_FAX",info)%>&nbsp;</td>
       			<td><%=Objects.getValue(i,"C_EMAIL",info)%>&nbsp;</td>
       			<td><%=Objects.getValue(i,"C_PLACE",info)%></td>
    			  </tr>
      	<%	}
      	}
      %>
</table>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  
<%@ include file="public/bottom.jsp" %>
