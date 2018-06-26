<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_FAQ_Show.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_FAQ_Show.jsp
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
<div align="center"><font color="#0066CC" class="unnamed3">查看客户咨询</font></div><br>
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

<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" bordercolor="#009999" bordercolorlight="#FFFFFF" class="td">
	<tr> 
		<td bgcolor="#9DEEDE">
			咨询人: 
		</td>
		<td>
			<%=StringTool.htmlEncode(result[1][indexFaqPsn])%>
		</td>
		<td bgcolor="#9DEEDE">
			咨询时间: 
		</td>
		<td>
			<%=StringTool.htmlEncode(result[1][indexFaqTm])%>
		</td>
		<td bgcolor="#9DEEDE">
		E-MAIL：
		</td>
		<td>
			<%=StringTool.htmlEncode(result[1][indexFaqEmail])%>
		</td>
	</tr>
	<tr> 
		<td bgcolor="#9DEEDE">
			标题:
		</td>
		<td colspan="5">
			<%=StringTool.htmlEncode(result[1][indexFaqTitle])%>
		</td>
	</tr>
	<tr> 
		<td bgcolor="#9DEEDE">
			内容:
		</td>
		<td colspan="5">
			<%=StringTool.htmlEncode(result[1][indexFaqContent])%>
		</td>
	</tr>
	<tr> 
		<td bgcolor="#9DEEDE">
			回复内容:
		</td>
		<td colspan="5">
			<%=StringTool.htmlEncode(result[1][indexReplyCont])%>
		</td>
	</tr>
	<tr> 
		<td colspan="6"><a  color="green" href="mailto:<%=StringTool.mailtoEncode(result[1][indexFaqEmail])%>?subject=回复:<%=StringTool.mailtoEncode(result[1][indexFaqTitle])%>&body=<%=StringTool.mailtoEncode(result[1][indexReplyCont])%>">邮件回复给用户</a></td>
	</tr>
</table>
		<%}else{%>
			<font size="3" color="red">没有找到客户咨询信息</font>
		<%}%>
		<div align="center">	
            <input type="button" value="返回" name="B12" onclick="history.back()">
			</div>
<%@ include file="public/bottom.jsp"%>