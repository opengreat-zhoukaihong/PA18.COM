
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<form name="form1" action="delOperatorAction.jsp" onSubmit="return checkForm(this)">
<div align="center">
        <div align="center">
          <div align="center">
            <div align="center"><font color="#0066CC"><span class="titel"><span class="unnamed3">删除后台操作员</span></span></font><br>
              <br>
            </div>
            <table width="90%" border="0" cellspacing="0" cellpadding="0" align="center" class="td">
              <tr> 
                <td width="18%"> 
                  <div align="right">操作员帐号：</div>
                </td>
                <td width="82%"> 
                  <input type="text" name="C_OPR_CDE">
                  <font color="#FF3300">**</font>用户名长度为3至10位，只能由字母和数字组成 </td>
              </tr>
              <tr> 
                <td colspan="2" height="50"> 
                  <div align="center"> 
                    <input type="submit" name="Submit" value="确定">
                    <input type="submit" name="Submit2" value="取消">
                  </div>
                </td>
              </tr>
            </table>
          </div>
          </div>
        </div>
 <%@ include file="public/bottom.jsp" %>       

<script language=JavaScript>
function checkForm(theForm){
     if( !ValidNull(theForm.C_OPR_CDE,false) || !ValidInvaKey(theForm.C_OPR_CDE)){
        theForm.C_OPR_CDE.focus();
        return false;
     }
  return true;
}
</script>
