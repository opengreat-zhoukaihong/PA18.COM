<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>

<%
	String[] formpara=new String[2];
	String[][] info=null;
	int i=0;

	formpara[0]=obj_data.getinfo1();
	formpara[1]=request.getParameter("C_USER_ID");

	if(formpara[0]==null)formpara[0]="test";
//	String ssss=request.getParameter("radio1");
//	if(ssss==null)out.println("null radio!");
	if( (request.getParameter("radio1")).equals("2") )
//		out.println("nut permit!");
		throw new NormalException(" 选择了代理就不能做客户匹配！");
//	formpara[1]="11";

	try
	{
		obj.setFormPara(ZConst.QUERY_CLNTMAPLIST,formpara);
		info=obj.getRetValueArra();
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  
	catch(Exception e)
	{
//		out.println("debug:err excption occur when call QUERY_CLNTMAPLIST:"+e);
	}	// end try


%>

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>

<div align="center"><font color="#0066CC" class="unnamed3"> 客 户 匹 配 <br></font><br>
  <form action="Zsubm_relationship.jsp" onsubmit="return(
ValidNull(clntcde,false) );">
	 <input TYPE="hidden" NAME="opr_cde" VALUE="<%=formpara[0]%>">
	 <input TYPE="hidden" NAME="clnt_agt_flg" VALUE="1">
	 <input TYPE="hidden" NAME="userid" VALUE="<%=formpara[1]%>">

        <table border="1" cellspacing="0" cellpadding="0" bordercolor="#009966" bgcolor="#F4FFF4" bordercolorlight="#FFFFFF" class="td">
          <tr bgcolor="#E1FFE1"> 
              <td width="10%"> 
                <div align="center">操作</div>
              </td>
              <td width="40%"> 
                <div align="center">用户名</div>
              </td>
              <td width="39%"> 
                <div align="center">客户编码</div>
              </td>
            </tr>
		<%	if (info!=null)
			{
				for(i=1;i<info.length;i++)
				{  
/*					String mark=" ";
					if( (Objects.getValue(i,"c_main_flg",info)).equals("1"))
						mark="*";	*/
					%>
    			  <tr>
					<td><a href="Zdel_relation.jsp?opr_cde=<%=formpara[0]%>&userid=<%=formpara[1]%>&clntcde=<%=Objects.getValue(i,"C_CLNT_CDE",info)%>&clnt_agt_flg=1">删除</a></td>
					<td><%=Objects.getValue(i,"C_USER_ID",info)%> &nbsp;</td>
       			<td><%=Objects.getValue(i,"C_CLNT_CDE",info)%> &nbsp;</td>
    			  </tr>
      	<%	}
      	}
      %>
          </table><br>
        <table border="1" cellspacing="0" cellpadding="0" bordercolor="#009966" bgcolor="#F4FFF4" bordercolorlight="#FFFFFF" class="td">
          <tr bgcolor="#E1FFE1"> 
            <td width="22%" height="23"> 
              <div align="center">用户名:</div>
            </td>
            <td colspan="2" height="23" bgcolor="#E1FFE1" width="78%"><%=formpara[1]%>&nbsp; </td>
          </tr>
          <tr> 
            <td width="22%" height="26"> 
              <div align="center">客户编码:</div>
            </td>
            <td colspan="2" height="26" width="78%"><input type="text" name="clntcde" size="20" maxlength="12">
            </td>
          </tr>
        </table>
              
      <div align="center">
        <input type="submit" name="Submit3" value="增加">
      </div>
  </form>
<%@ include file="public/bottom.jsp" %>
