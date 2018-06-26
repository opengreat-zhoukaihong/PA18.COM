<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>


<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>

<form method="POST" name="form55" action="subm_page.jsp" onsubmit="return(
ValidNull(C_PAGE_TITLE,false) &&
ValidNull(C_FILE_ENM,false) 
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
					 <input type="text" name="C_PAGE_TITLE" value="" size="30" maxlength="60">
				</p>
            <p align="left"> 邮件地址：
					<input maxlength="60" name="C_FILE_ENM" value="" size="30">
            </p>
            <p align="left">所属机构：
                <select name="select">
                  <option selected>请选择</option>
                </select>
            </p>
			</td>
         <td valign="top" width="25%" height="155"> 
              <br>
				  <p> 
                <input type="checkbox" name="checkbox" value="checkbox">
                会员审批</p>
              <p> 
                <input type="checkbox" name="checkbox2" value="checkbox">
                审核保单 </p>
              <p> 
                <input type="checkbox" name="checkbox3" value="checkbox">
                送单调度 </p>
              <p> 
                <input type="checkbox" name="checkbox4" value="checkbox">
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
