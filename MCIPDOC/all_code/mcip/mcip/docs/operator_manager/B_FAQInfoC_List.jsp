<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/> 
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_FAQInfoC_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_FAQInfoC_List.jsp
*Previous Page : B_FAQInfoT_List.jsp
*Next Page : B_del_FAQInfo.jsp/B_add_FAQInfo.jsp/B_edit_FAQInfo.jsp/B_show_FAQInfo.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-25
*Last Updated : 
*Status : open
*Function : I.list all the items of the FAQInfo
*			II.provide the link to the next pages
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-26
*Time : 15:07:18
*Modify id : 0002
*Modifier : Lawrence
*Reason : Display records 10 lines per page
***********************************************************************************************
*/
%>
<%
String
	/*B0002+*/
	numStr = request.getParameter("numStr"),
	/*E0002+*/
	topicTitle = "",
	parentFaqNo = StringTool.null2Blank(request.getParameter("faqNo")),
	oprCde = null,
	formPara[] = null,
	result[][] = null;

int
	indexFaqNo,
	indexFaqTitle,
	indexFaqTm,
	indexTopicNo,
	indexFaqEmp;

/*B0002+*/
Integer pNo;
/*E0002+*/

	//GET PARAMETERS FROM THE LAST PAGE
	oprCde=sessionuser.getuserId(Locate); 

//Get the title which this page belong
	try
	{
		formPara = new String[2];
		formPara[0] = parentFaqNo;//empty string for all the titile
		formPara[1] = oprCde; //operator code for log
		bb.setFormPara(BConst.QUERY_CONSULT_INFO,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
	if (result != null && result.length>1)
	{
		topicTitle = result[1][Objects.getColNum("C_FAQ_TITLE",result)];
	}
	else
	{
		topicTitle="警告：没有找到标题信息！";
	}

/*B0002+*/
if (numStr == null) //first enter the page
{
/*E0002+*/
//Get the cosultant list of this topic
	try
	{
		formPara = new String[2];
		formPara[0] = parentFaqNo;//empty string for all the titile
		formPara[1] = oprCde; //operator code for log
		bb.setFormPara(BConst.QUERY_CONSULT_LIST,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
/*B0002+*/
	pm.setPageLength(10);
	pm.dumpIn(result);
	pNo = new Integer(0);
	result = pm.getPage(pNo.intValue());
}
else
{
	pNo = new Integer(numStr);
	result = pm.getPage(pNo.intValue());
}
/*E0002+*/
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr> 
		<td valign="top" colspan="2"> 
			<p align="center"><br>
				<font size="4">保险咨询</font>
			</p>
			&nbsp;&nbsp;所属类别:<FONT SIZE="3" color="#653DA7"><%=StringTool.htmlEncode(topicTitle)%></FONT>
			<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
				<tr bgcolor="#9DEEDE"> 
					<td align="left" height="26" width="47%">保险咨询</td>
					<td align="left" nowrap height="26" width="23%">填加时间</td>
					<td align="left" nowrap height="26" width="20%">咨询维护人</td>
					<td align="center" nowrap height="26" width="10%" colspan="2">操作</td>
				</tr>
			<% if (result != null && result.length>1){
					indexFaqNo = Objects.getColNum("C_FAQ_NO",result);
					indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",result);
					indexFaqTm = Objects.getColNum("T_FAQ_TM",result);
					indexTopicNo = Objects.getColNum("C_TOPIC_NO",result);
					indexFaqEmp = Objects.getColNum("C_FAQ_EMP",result);
				for (int i = 1; i < result.length; i++){
			%>
				<tr bgcolor="#DFF9F3"> 
					<td align="left" height="25" width="67%">
						<a href="B_show_FAQInfo.jsp?sessionId=<%=Code.Encrypt(sessionId)%>&faqNo=<%=result[i][indexFaqNo]%>">
							◆<%=StringTool.htmlEncode(result[i][indexFaqTitle])%>
						</a>
					</td>
					<td align="left" nowrap height="25" width="23%">
						<%=result[i][indexFaqTm]%>
					</td>
					<td align="left" nowrap height="25" width="20%">
						<%=result[i][indexFaqEmp]%>
					</td>
					<form action="B_edit_FAQInfo.jsp">
					<td align="left" nowrap height="25" width="5%">
						<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
						<input type="hidden" name="faqNo" value="<%=result[i][indexFaqNo]%>">
						<input type="hidden" name="parentFaqNo" value="<%=parentFaqNo%>">
						<input type="hidden" name="oprType" value="item">
						<input type="submit" value="修改" style="background-color:#009999">
					</td>
					</form>
					<form action="B_del_FAQInfo.jsp">
					<td align="left" nowrap height="25" width="5%">
						<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
						<input type="hidden" name="faqNo" value="<%=result[i][indexFaqNo]%>">
						<input type="hidden" name="parentFaqNo" value="<%=parentFaqNo%>">
						<input type="hidden" name="faqTitle" value="<%=StringTool.htmlEncode(result[i][indexFaqTitle])%>">
						<input type="hidden" name="faqTm" value="<%=result[i][indexFaqTm]%>">
						<input type="hidden" name="oprType" value="item">
						<input type="submit" value="删除" style="background-color:#009999">
					</td>
					</form>
				</tr>
			<%}
			}%>
			</table>
		</td>
	</tr>
	<tr> 
		<form action="B_add_FAQInfo.jsp">
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<input type="hidden" name="parentFaqNo" value="<%=parentFaqNo%>">
		<input type="hidden" name="oprType" value="item">
		<td align="center">
			<input type="submit" value="增加保险咨询" style="background-color:#009999">
		</td>
		</form>
		<form action="B_FAQInfoT_List.jsp">
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<td align="center">
			<input type="submit" value="返回上一级列表" style="background-color:#009999">
		</td>
		</form>
	</tr>
</table>
	<!--
	B0002+
	-->
	<table width="96%" border="0" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr>
		<td align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<form>
		<input type="hidden" name="numStr" value="<%=pNo.toString(pNo.intValue()-1)%>">
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<input type="hidden" name="faqNo" value="<%=parentFaqNo%>">
		<input type="submit" value="上一页" style="background-color:white">
		</form>
		<a href="B_FAQInfoC_List.jsp?faqNo=<%=parentFaqNo%>&numStr=<%=pNo.toString(0)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[首    页]</a>
		<a href="B_FAQInfoC_List.jsp?faqNo=<%=parentFaqNo%>&numStr=<%=pNo.intValue()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[上一页]</a>
		<%}
		else{
			out.println("[首    页]");
			out.println("[上一页]");
		}
		%>
		<td align="center" width="40%">
			共<%=pm.getTotalPage()%>页；第<%=pNo.toString(pNo.intValue()+1)%>页
		</td>
		</td>
		<td align="right" width="30%">
		<%if (pNo.intValue() < pm.getTotalPage()-1){%>
		<form>
		<input type="hidden" name="numStr" value="<%=pNo.toString(pNo.intValue()+1)%>">
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<input type="hidden" name="faqNo" value="<%=parentFaqNo%>">
		<input type="submit" value="下一页" style="background-color:white">
		</form>
		<a href="B_FAQInfoC_List.jsp?faqNo=<%=parentFaqNo%>&numStr=<%=pNo.toString(pNo.intValue()+1)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[下一页]</a>
		<a href="B_FAQInfoC_List.jsp?faqNo=<%=parentFaqNo%>&numStr=<%=pm.getTotalPage()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[末    页]</a>
		<%}
		else{
			out.println("[下一页]");
			out.println("[末    页]");
		}
		%>
		</td>
	</tr>
  </table>
  <!--
  E0002+
  -->
<%@ include file="public/bottom.jsp" %>