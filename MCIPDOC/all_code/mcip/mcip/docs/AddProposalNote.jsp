<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>


<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>





<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicPlyLeft.html" %>

    <td width="613"  valign="top">
<br><br>

<%String AgencyNo = request.getParameter("AGENCYNO");
	if(AgencyNo == null)AgencyNo = "";
%>
<form method="POST" action="AddProposalNoteOut.jsp" onSubmit="return ValidNull(C_USER_REMARK,false);">
  <p> 建议书号：&nbsp;<input type="text" disabled name="C_DOC_NO_TEMP" size="20" value="<%=request.getParameter("C_DOC_NO")%>">
                      <input type="hidden"  name="C_DOC_NO" size="20" value="<%=request.getParameter("C_DOC_NO")%>">  
   <%
      String x = request.getParameter("n_sum_prm");      
   %>
  <% if(AgencyNo.equals(Const.EDRSMTAPP)){     
  %>
  <br>原保费   <input type="text" disabled  name="n_prm_old" size="12" value="<%=request.getParameter("n_prm_old_value")%>">

      最新保费 <input type="text" disabled  name="n_sum_prm" size="12" value="<%=request.getParameter("n_sum_prm_value")%>">
	  保费变化 <input type="text" disabled  name="n_prm_var" size="12" value="<%=request.getParameter("n_prm_var_value")%>"><%=request.getParameter("PrmCurName")%> 
  <br>原费率   <input type="text" disabled  name="n_rate_old" size="12" value="<%=request.getParameter("n_rate_old_value")%>">%
	  新费率   <input type="text" disabled  name="N_RATE" size="12" value="<%=request.getParameter("N_RATE_VALUE")%>">%
  <%}else{%>
    <br>保　费　：
    <input type="text" disabled  name="n_sum_prm" size="12" value="<%=request.getParameter("n_sum_prm_value")%>"><%=request.getParameter("PrmCurName")%>     
    <br>费　率　：
    <input type="text" disabled  name="N_RATE" size="12" value="<%=request.getParameter("N_RATE_VALUE")%>">%
  <%}%>
  
  <br>免赔描述：<br>
    <textarea  name="C_NO_REPAY" cols="70" rows="2" onkeydown="return false;" ><%=request.getParameter("C_NO_REPAY")%></textarea>
    
  <br>
  承保条件：<br>
    <textarea name="C_UNDR_CNDTN" cols="70" rows="5" onkeydown="return false;" ><%=request.getParameter("C_UNDR_CNDTN")%></textarea>
  <br>核保意见：<br>
    <textarea name="C_REMARK" cols="70" rows="2"  onkeydown="return false;"><%=request.getParameter("C_REMARK")%></textarea>
  <% if(request.getParameter("PAY_METHOD")!=null){%> 
  
  <br>
  选择付款方式：<input type="radio" name="PAY_TYPE" value="0">网上付款&nbsp;&nbsp;&nbsp;
                <input type="radio" checked name="PAY_TYPE" value="1">网下付款
  <%}%>
  <br>
  <div align="left">
    送单时间：从发出承保通知开始一个工作日内。<br>
  </div>
  <div align=left>
  我有意见:
  <br>
  <textarea name="C_USER_REMARK" rows=5 cols=70>
  </textarea>*
  </div>
   <input type="hidden" name="AGENCYNO" value="<%=AgencyNo%>">  
              <input type="submit" value=" 提 交 " name="B1" >             
              
		<input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>  	      
	    <input type="hidden" name="temp" value="agr">
  </p>    
</form>

    </td>
        </tr>
      </table>

</td>
  </tr>
</table>
 <% String clientName = sessionbuffer.getuserId(Locate); %> 
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>


