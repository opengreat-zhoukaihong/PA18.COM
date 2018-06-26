<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_Reply_FAQ.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_Reply_FAQ.jsp
*Previous Page : B_FAQ_List.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-24
*Last Updated : 
*Status : open
*Function : I.Display the  FAQ detail
*					II.Accept the Reply by operator
*					III.forward to the reply message page
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

<p align="center">
	<font size="3">回复客户咨询</font> 
</p>
<form name="EntAnswerForm" method="POST" action="B_Reply_Msg.jsp">
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
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<input type="hidden" name="faqNo" value="<%=StringTool.htmlEncode(result[1][indexFaqNo])%>">
	<input type="hidden" name="faqTitle" value="<%=StringTool.htmlEncode(result[1][indexFaqTitle])%>">
	<input type="hidden" name="faqEmail" value="<%=StringTool.htmlEncode(result[1][indexFaqEmail])%>">

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
			<%=StringTool.htmlEncode(result[1][indexFaqContent])%>
			 </td>
        </tr>
        <tr> 
          <td bgcolor="#9DEEDE" width="16%" height="26" align="center">答复客户提问：</td>
          <td colspan="5"> 
            <textarea name="replyCont" cols="70" rows="8"><%=StringTool.htmlEncode(result[1][indexReplyCont])%></textarea>
          </td>
        </tr>
        <tr>
          <td bgcolor="#9DEEDE" width="16%" height="26" colspan="6">
				是否要
				<a href="B_add_FAQInfo.jsp?sessionId=<%=Code.Encrypt(sessionId)%>&oprType=item">
					<font color="#0000CC">填加</font>
				</a>
				到保险咨询栏目，作为典型的问题供其他客户参考？
          </td>
        </tr>
      </table>
	<div align="center"> 
		<input type="submit" value="提交" name="B1">
		 <input type="button" value="返回" name="B12" onclick="history.back()">
	</div>
	<%}else{%>
		<font size="3" color="red">没有找到客户咨询信息</font>
	<%}%>
	</form>

<%@ include file="public/bottom.jsp"%>
