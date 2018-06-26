<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>


<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>
<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/>
<%
 	String info[][]=null;
	String formpara[]=new String[1];
	int i=0;
	int no=Integer.parseInt(request.getParameter("select"));
 	String infosupp[][]=obj_user.getRetValueArra();
	
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

<form method="POST" name="form55" action="subm_edsupp.jsp" onsubmit="return(
ValidNull(emp_nme,false) &&
ValidNull(emp_email,false) &&
ValidEmail(emp_email) &&
IsCheckedBox4(check1,check2,check3,check4)
);">

    <input type="hidden" name="supp_no" value="<%=Objects.getValue(no,"c_supp_no",infosupp)%>">
    <input type="hidden" name="emp_cde" value="<%=Objects.getValue(no,"c_emp_cde",infosupp)%>">
        修改内勤人员：<br>
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
					 <input type="text" name="emp_nme" value="<%=Objects.getValue(no,"c_emp_nme",infosupp)%>" size="30" maxlength="60">
				</p>
            <p align="left"> 邮件地址：
					<input maxlength="60" name="emp_email" value="<%=Objects.getValue(no,"c_emp_email",infosupp)%>" size="30">
            </p>
            <p align="left">所属机构：
                <select name="dpt_cde">
						<% 
							String dpt=Objects.getValue(no,"c_dpt_cde",infosupp);
							for(i=1;i<info.length;i++)
							{	
								if(dpt.equals(Objects.getValue(i,"C_DPT_CDE",info) ))
								{	%>
        							<option  value="<%=Objects.getValue(i,"C_DPT_CDE",info)%>" selected>
									<%=Objects.getValue(i,"C_DPT_CNM",info)%>
						<%		}else
								{	%>
        							<option  value="<%=Objects.getValue(i,"C_DPT_CDE",info)%>">
									<%=Objects.getValue(i,"C_DPT_CNM",info)%>
						<%		}
							}
						%>
                </select>
            </p>
			</td>
         <td valign="top" width="25%" height="155"> 
              <br>
				<%	String type=Objects.getValue(no,"c_emp_type",infosupp);
					if( (type.substring(0,1)).equals("0") )
					{	%>
				    <p>
                <input type="checkbox" name="check1" value="1">
                会员审批</p>
				<%	}else
					{ %>
				    <p>
                <input type="checkbox" name="check1" value="1" checked>
                会员审批</p>
				<%	}

					if( (type.substring(1,2)).equals("0") )
					{	%>
					 <p> 
                <input type="checkbox" name="check2" value="1">
                 审核保单 </p>
				<%	}else
					{ %>
					 <p> 
                <input type="checkbox" name="check2" value="1" checked>
                 审核保单 </p>
				<%	}

					if( (type.substring(2,3)).equals("0") )
					{	%>
					 <p> 
                <input type="checkbox" name="check3" value="1">
                送单调度 </p>
				<%	}else
					{ %>
					 <p> 
                <input type="checkbox" name="check3" value="1" checked>
                送单调度 </p>
				<%	}

					if( (type.substring(3,4)).equals("0") )
					{	%>
				    <p> 
                <input type="checkbox" name="check4" value="1">
                报案处理 </p>
				<%	}else
					{ %>
 				    <p> 
                <input type="checkbox" name="check4" value="1" checked>
                报案处理 </p>
				<%	} %>
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
