<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>
 <div align="center"><font color="#0066CC" class="unnamed3">网上会员业务月统计</font><br>
</div>
<form name="form2" action="B_Userplytotal.jsp" onsubmit="return(ValidNull(form2.userId,false) && ValidYear(form2.year) && ValidMonth(form2.month) );">
        
  <table width="85%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
    <tr class="unnamed2" bgcolor="#9DEEDE"> 
      <td height="25" colspan="4"> 请输入查询条件：</td>
    </tr>
    <tr> 
      <td bgcolor="#DFF9F3" width="4%" height="16"> 用户名： 
        <input type="text" name="userId" size="12" value="" maxlength="12">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#DFF9F3" width="4%" height="100"> 
        <p>统计的业务类型：</p>
        <blockquote> 
		<p> 
		  <input type="checkbox" name="type0" value="B01">
		  进口货运 
		  <input type="checkbox" name="type1" value="B02">
		  出口货运 </p>
		<p> 
        <input type="checkbox" name="type2" value="B23">
         国内铁路 
        <input type="checkbox" name="type3" value="B33">
         国内公路 
        <input type="checkbox" name="type4" value="B13">
         国内水路 
        <input type="checkbox" name="type5" value="B43">
			国内航空
		</p>
        </blockquote>
        </td>
    </tr>
    <tr>
      <td bgcolor="#DFF9F3" width="4%" height="28"> 
		<p> 统计的时间
		  <input type="text" name="year" size="4" maxlength="4" value="<%=new java.util.GregorianCalendar().get(java.util.GregorianCalendar.YEAR)%>">
		  年 
		  <input type="text" name="month" size="2" maxlength="2" value="<%= new java.util.GregorianCalendar().get(java.util.GregorianCalendar.MONTH)+1%>">
		  月 </p>
        </td>
    </tr>
  </table>
  <p align="center"> 
     <input type="submit" name="Submit" value="查询" onClick="">
  </p>
 </form>
<%@ include file="public/bottom.jsp" %>



