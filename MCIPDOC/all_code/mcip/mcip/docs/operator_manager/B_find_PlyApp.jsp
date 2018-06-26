<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
 <div align="center"><font color="#0066CC" class="unnamed3">查 询 会 员 投 保 业 
    务 清 单 </font><br>
</div>
<form name="form1" action="B_PlyApp_list.jsp" onsubmit="return(
ValidNull(username,false) 
);">
  <input type="hidden" name="opr_cde" value="admin">
        <table width="95%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
          <tr class="unnamed2" bgcolor="#9DEEDE"> 
            <td height="25" colspan="4"> 请输入查询条件：</td>
          </tr>
          <tr> 
            <td bgcolor="#DFF9F3" width="4%" height="19"> 
              <input type="radio" name="checkno" value="5" checked>
              最近五笔业务 
              <input type="radio" name="checkno" value="0">
              全部业务</td>
          </tr>
          <tr> 
            <td bgcolor="#DFF9F3" width="4%" height="16"> 
              用户名： 
              <input type="text" name="username" size="12" value="" maxlength="12">
            *</td>
          </tr>
        </table>
  <div align="center"> 

                <input type="submit" name="Submit" value="查询" onClick="">
              </div>
 </form>
<%@ include file="public/bottom.jsp" %>



