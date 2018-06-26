<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<%
       String c_opr_cde="";
       String c_emp_cde="";
       String info=  request.getParameter("C_OPR_CDE");
       if(info!=null){
         int i= info.indexOf(",");
         c_opr_cde  = info.substring(0,i);
         int j = info.indexOf("," , i+1);
         c_emp_cde  = info.substring(i+1,j);
       }  

    %>
<form name="form1" method ="post" action="editOperatorAction.jsp" onSubmit = "return (ValidNull(C_OPR_CDE,false) && ValidInvaKey(C_OPR_CDE) && ValidOprPsw(C_OPR_PW,false) && ValidNull(ConfirmPw ,false) && ValidSame(C_OPR_PW , ConfirmPw) && ValidNull(C_EMP_CDE ,false));" >
<div align="center">
        <div align="center">
          <div align="center"><font color="#0066CC"><span class="unnamed3">修改后台操作员密码</span></font><br>
            <br>
          </div>
          <table width="90%" border="0" cellspacing="0" cellpadding="0" align="center" class="td">
            <tr> 
              <td width="18%"> 
                <div align="right">操作员帐号：</div>
              </td>
              <td width="82%"> 
                <input type="text" name="C_OPR_CDE"  maxlength="10" value="<%=c_opr_cde%>">
                <font color="#FF3300">**</font>用户名长度为3至10位，只能由字母和数字组成 </td>
            </tr>
            <tr> 
              <td width="18%"> 
                <div align="right">操作员密码：</div>
              </td>
              <td width="82%"> 
                <input type="password" name="C_OPR_PW" maxlength="6">
                <font color="#FF3300">**</font> 长度只能为6位 </td>
            </tr>
            <tr>
              <td width="18%">
                <div align="right">确认密码：</div>
              </td>
              <td width="82%">
                <input type="password" name="ConfirmPw" maxlength="6">
                <font color="#FF3300">**</font> 由字母和数字组成。例如：abc123 </td>
            </tr>
            <tr> 
              <td width="18%"> 
                <div align="right">员工编码：</div>
              </td>
              <td width="82%"> 
                <input type="text" name="C_EMP_CDE"  maxlength="10" value="<%=c_emp_cde%>">
                <font color="#FF3300">**</font> 由字母和数字组成 </td>
            </tr>
            <tr> 
              <td width="18%" height="28">&nbsp;</td>
              <td width="82%" height="28" > 
                <div align="center"><font color="#FF9999">（注：带 <font color="#FF3300">**</font> 
                  的选项必须填写）</font></div>
              </td>
            </tr>
            <tr> 
              <td colspan="2" height="50"> 
                <div align="center">
                  <input type="submit" name="Submit" value="提交修改">
                  <input type="submit" name="Submit2" value="重新填写">
                </div>
              </td>
            </tr>
          </table>
        </div>
        </div>
 </form>
 <%@ include file="public/bottom.jsp" %>


