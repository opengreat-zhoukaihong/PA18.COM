<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>


<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>
<%
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
%>

<form method="POST" name="form55" action="subm_addsupp.jsp" onsubmit="return(
ValidNull(emp_nme,false) &&
ValidNull(emp_email,false) &&
ValidEmail(emp_email) &&
IsCheckedBox4(check1,check2,check3,check4)
);">

    <input type="hidden" name="subm" value="增加/add">
        增加内勤人员：<br>
        <br>
    <table border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td" width="85%" align="center">
       <tr bgcolor="#9DEEDE"> 
          <td  height=20 width="60%" align="center"> 内勤人员信息 </td>
          <td  height=20 width="25%" align="center"> 内勤人员操作功能 </td>
	    </tr>
		 <tr> 
         <td valign="top" width="60%" height="155"> 
             <br>
				 <p align="left"> 姓&nbsp;&nbsp;&nbsp;&nbsp;名： 
					 <input type="text" name="emp_nme" value="" size="30" maxlength="60">
				</p>
            <p align="left"> 邮件地址：
					<input maxlength="60" name="emp_email" value="" size="30">
            </p>
            <p align="left">所属机构：
                <select name="dpt_cde">
						<% 
							for(i=1;i<info.length;i++)
							{	%>
        						<option  value="<%=Objects.getValue(i,"C_DPT_CDE",info)%>">
								<%=Objects.getValue(i,"C_DPT_CNM",info)%>
						<%	}
						%>
                </select>
            </p>
			</td>
         <td valign="top" width="25%" height="155"> 
              <br>
				  <p> 
                <input type="checkbox" name="check1" value="1">
                会员审批</p>
              <p> 
                <input type="checkbox" name="check2" value="1">
                审核保单 </p>
              <p> 
                <input type="checkbox" name="check3" value="1">
                送单调度 </p>
              <p> 
                <input type="checkbox" name="check4" value="1">
                报案处理 </p>
              <p>&nbsp; </p>
      
       	</td>
		</tr>
		<tr> 
			<td valign="top" height="4" colspan="2" align="center"> 
          <input type="submit" value="提交" name="submitname">
			</td>
		</tr>
	</table>
</form>

<%@ include file="public/bottom.jsp" %>
