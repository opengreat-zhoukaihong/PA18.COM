<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_del_FAQ.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_del_FAQ.jsp
*Previous Page : B_FAQ_List.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-24
*Last Updated : 
*Status : open
*Function : I.Display the  FAQ detail
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
	formPara[],
	oprCde,
	faqNo = StringTool.null2Blank(request.getParameter("faqNo")),
	result[][];

int 
	indexFaqNo,
	indexFaqPsn,
	indexFaqEmail,
	indexFaqTitle,
	indexFaqContent,
	indexFaqTm,
	indexReplyCont,
	indexReplyEmp,
	indexRplyTm;

	oprCde=sessionuser.getuserId(Locate); 

	try
	{
		formPara = new String[2];
		formPara[0] = faqNo; // faq number ,empty for all 
		formPara[1] = oprCde; //operator code
		bb.setFormPara(BConst.QUERY_FAQ_INFO,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
%>
<%@ include file="public/left.jsp"%>
<div align="center"><font color="#0066CC" class="unnamed3">删除客户咨询</font></div><br>
<form name="EntAnswerForm" method="POST" action="B_FAQ_DelMsg.jsp">
	<font color="#0000CC">你确定删除该项客户保险咨询吗？</font> <br>
<%if (result != null && result.length >1){
		indexFaqNo = Objects.getColNum("C_FAQ_NO",result);
		indexFaqPsn = Objects.getColNum("C_FAQ_PSN",result);
		indexFaqEmail = Objects.getColNum("C_FAQ_EMAIL",result);
		indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",result);
		indexFaqContent = Objects.getColNum("C_FAQ_CONTENT",result);
		indexFaqTm = Objects.getColNum("T_FAQ_TM",result);
		indexReplyCont = Objects.getColNum("C_REPLY_CONT",result);
		indexReplyEmp = Objects.getColNum("C_REPLY_EMP",result);
		indexRplyTm = Objects.getColNum("EPLY_TM",result);
%>
    <table width="96%" border="1" cellspacing="0" cellpadding="0" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" align="center" bgcolor="#DFF9F3">
        <tr height="27" align="center"> 
          <td width="16%" bgcolor="#9DEEDE">咨询人:</td>
          <td width="13%"> 
            <%=StringTool.htmlEncode(result[1][indexFaqPsn])%>
          </td>
          <td width="14%" bgcolor="#9DEEDE"> 咨询时间:</td>
          <td width="25%"> 
            <%=StringTool.htmlEncode(result[1][indexFaqTm])%>
          </td>
          <td width="14%" bgcolor="#9DEEDE">E-MAIL：</td>
          <td width="18%" height="27" bgcolor="#DFF9F3"> 
            <%=StringTool.htmlEncode(result[1][indexFaqEmail])%>
          </td>
        </tr>
        <tr> 
          <td bgcolor="#9DEEDE" width="16%" height="25" align="center">标 题:</td>
          <td colspan="5" height="25">
			     <%=StringTool.htmlEncode(result[1][indexFaqTitle])%>
			 </td>
        </tr>
        <tr> 
          <td bgcolor="#9DEEDE" width="16%" height="26" align="center">内 容:</td>
          <td colspan="5" height="26">
			    <pre><%=StringTool.htmlEncode(result[1][indexFaqContent])%></pre>
			 </td>
        </tr>
        <tr> 
          <td bgcolor="#9DEEDE" width="16%" height="26" align="center">答复客户提问：</td>
          <td colspan="5" height="26"> 
            <pre>
				  <%=StringTool.htmlEncode(result[1][indexReplyCont])%>
				</pre>
          </td>
        </tr>
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<input type="hidden" name="faqNo" value="<%=faqNo%>">
	</table>
<%}else{%>
		<font size="3" color="red">没有找到客户咨询信息</font>
<%}%>
	<div align="center">
	<input type="submit" value="确定删除" name="B1" >
	<input type="button" value="返回" name="B12" onclick="history.back()" >
	</div>
	</form>

<%@ include file="public/bottom.jsp"%>
