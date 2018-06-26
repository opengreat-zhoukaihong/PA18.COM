<%@ include file="public/up.jsp" %>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_del_guide.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_del_guide.jsp
*Previous Page : B_guide_list.jsp
*Next Page : B_delmessage_guide.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-21
*Last Updated : 
*Status : submit for test
*Function : I.confirm the delete operation 
*					II.prepare the delete parameter for nextpage
*============================MODIFIED HISTORY==================================================
*Date : 
*Time : 
*Modify id : 
*Modifier : 
*Reason : 
***********************************************************************************************
*/
%>
<%
String
infoNo = StringTool.null2Blank(request.getParameter("infoNo")),
titleNo = StringTool.null2Blank(request.getParameter("titleNo")),
titleCnm = StringTool.null2Blank(request.getParameter("titleCnm")),
titleEnm = StringTool.null2Blank(request.getParameter("titleEnm"));
%>
<%@ include file="public/left.jsp"%>
<form name="EntAnswerForm" method="post" action="B_delmessage_guide.jsp">
<input type="hidden" name="infoNo" value="<%=infoNo%>">
<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
   <tr> 
     <td align="center" colspan="2"> 
       <span class="unnamed3"><font color="#FF3333">你确定删除该项内容投保指南吗？</span></font>
     </td>
   </tr>
   <tr bgcolor="#DFF9F3"> 
     <td width="18%" height="24" bgcolor="#9DEEDE"> 
        <div align="right" class="unnamed2">显示序号: </div>
     </td>
     <td width="82%" height="24"> 
        <div class="unnamed2"><%=titleNo%></div>
     </td>
    </tr>
    <tr> 
      <td bgcolor="#9DEEDE" width="18%" height="22"> 
        <div align="right">中文标题: </div>
      </td>
      <td bgcolor="#DFF9F3" width="82%" height="22"><%=titleCnm%> </td>
    </tr>
    <tr> 
      <td bgcolor="#9DEEDE" width="18%" height="22"> 
        <div align="right">英文标题: </div>
      </td>
      <td bgcolor="#DFF9F3" width="82%" height="22"><%=titleEnm%></td>
    </tr>
</table>
<p align="center"> 
  <input type="submit" value="确定删除" name="delete">
  <input type="button" value="返回" name="B12" onclick="history.back()">
</p>
</form>
<%@ include file="public/bottom.jsp"%>
