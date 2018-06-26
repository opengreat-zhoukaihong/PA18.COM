<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_add_FAQInfo.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_add_FAQInfo.jsp
*Previous Page : B_FAQInfoT_List.jsp
*Next Page : itself
*Author : Lawrence Kang
*Created Date : 2000-10-25
*Last Updated : 
*Status : open
*Function : I.Accept the user input and validate the input
*			II.forward to the input result page
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
		infoList[][] = null,
		selStr,
		oprType = StringTool.null2Blank(request.getParameter("oprType")),
		result[][] = null,
		formPara[] = null,
		faqTitle = StringTool.null2Blank(request.getParameter("faqTitle")),
		parentFaqNo = StringTool.null2Blank(request.getParameter("parentFaqNo")),
		faqNo = StringTool.null2Blank(request.getParameter("faqNo")),
		faqCont = StringTool.null2Blank(request.getParameter("faqCont")),
		action = StringTool.null2Blank(request.getParameter("action")),
		oprCde = null;
	
int
indexFaqNo,
indexFaqEmp,
indexFaqTitle,
indexFaqContent,
indexFaqTm,
indexTopicNo;

boolean
	bingo = false;

	oprCde=sessionuser.getuserId(Locate); 

if (oprType.equals("item"))
{
	try
	{
		formPara = new String[2];
		formPara[0] = ""; //c_faq_no,empty for auto create
		formPara[1] = oprCde; //operator who add the title
		bb.setFormPara(BConst.QUERY_CONSULT_LIST,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
}


if (action.equals("yes"))
{
	try
	{
		formPara = new String[7];
		formPara[0] = faqNo; //c_faq_no,empty for auto create
		formPara[1] = oprCde; //operator who add the title
		formPara[2] = faqTitle;  // faq title
		formPara[3] = faqCont;  //faq content
		formPara[4] = "";  //faq  added time,empty for curent type
		formPara[5] = parentFaqNo; //topic no,empty for title record
		formPara[6] = oprCde;  //operator code for log
		bb.setFormPara(BConst.UPDATE_CONSULT_INFO,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}
}
else
{
	try
	{
		formPara = new String[2];
		formPara[0] = faqNo;
		formPara[1] = oprCde;
		bb.setFormPara(BConst.QUERY_CONSULT_INFO,formPara);
		infoList = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		infoList = null;
	}
	if (infoList != null && infoList.length>1)
	{
		indexFaqNo = Objects.getColNum("C_FAQ_NO",infoList);
		indexFaqEmp = Objects.getColNum("C_FAQ_EMP",infoList);
		indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",infoList);
		indexFaqContent = Objects.getColNum("C_FAQ_CONTENT",infoList);
		indexFaqTm = Objects.getColNum("T_FAQ_TM",infoList);
		indexTopicNo = Objects.getColNum("C_TOPIC_NO",infoList);
		parentFaqNo = infoList[1][indexTopicNo];
		faqTitle = infoList[1][indexFaqTitle];
		faqCont = infoList[1][indexFaqContent];
	}
}
%>
<script language="JavaScript" src="check.js">
</script>
<div align="center"><font color="#0066CC" class="unnamed3">修改保险咨询</font></div><br>
<form name="f" action="B_edit_FAQInfo.jsp" method="POST" onsubmit="return (ValidNull(f.faqTitle,false));">
<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
<input type="hidden" name="action" value="yes">
<input type="hidden" name="oprType" value="<%=oprType%>">
<input type="hidden" name="faqNo" value="<%=faqNo%>">
	<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" bordercolor="#009999" bordercolorlight="#FFFFFF" class="td">
		<%if (action.equals("yes")){
				if (bingo){%>
					<tr><td align="center" colspan="2"><font size="3" color="#336666">保险咨询标题修改成功!</font></td></tr>
					<%}else{%>
					<tr><td align="center" colspan="2"><font size="3" color="#FF6633">保险咨询标题修改失败!</font></td></tr>
					<%}
			}%>
			<%if (oprType.equals("item")){%>
		<tr> 
			<td height="30" bgcolor="#9DEEDE">
				所属类别：
			</td>
			<td height="30">
							<select name="parentFaqNo">
						<%if (result != null && result.length > 1){
							indexFaqNo = Objects.getColNum("C_FAQ_NO",result);
							indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",result);
							indexFaqTm = Objects.getColNum("T_FAQ_TM",result);
							indexTopicNo = Objects.getColNum("C_TOPIC_NO",result);
							for (int i =1;i<result.length;i++){
								if (result[i][indexFaqNo].equals(parentFaqNo))
									selStr = "selected";
								else
									selStr = "";
							%>
						<option <%=selStr%> value="<%=result[i][indexFaqNo]%>"><%=StringTool.htmlEncode(result[i][indexFaqTitle])%></option>
				<%		}
						}%>
					</select>
				</td>
				</tr>
					<%}%>
					<tr>
						<td height="30" bgcolor="#9DEEDE">
					保险咨询<%if (oprType.equals("item")) out.println("内容"); else out.println("类别");%>的标题： 
					</td>
					<td height="30">
					<input type="text" name="faqTitle" size="50" value="<%=StringTool.htmlEncode(faqTitle)%>">*
				</td>
				</tr>
				<%if (oprType.equals("item")){%>
				<tr>
					<td height="30" bgcolor="#9DEEDE">
				保险咨询内容：
					</td>
					<td height="30">
					<textarea name="faqCont" cols="65" rows="4"><%=StringTool.htmlEncode(faqCont)%></textarea>
				</td>
				<%}%>
	</table>
	<table border="0" width="100%">
		<tr>
			<td align="right">
			<input type="submit" value="提交" name="B1">
			</form>
			</td>
			<td align="left">
				<form action="<%if (oprType.equals("item")) out.print("B_FAQInfoC_List.jsp"); else out.print("B_FAQInfoT_List.jsp");%>" method="post">
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<input type="hidden" name="faqNo" value="<%=parentFaqNo%>">
					<input type="submit" value="返回" name="B12">
				</form>
			</td>
			</tr>
			</table>
<%@ include file="public/bottom.jsp"%>