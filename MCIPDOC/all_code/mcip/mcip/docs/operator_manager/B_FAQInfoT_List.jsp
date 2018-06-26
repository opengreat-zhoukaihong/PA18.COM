<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/> 
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_FAQInfoT_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_FAQInfoT_List.jsp
*Previous Page : BackManager.jsp
*Next Page : B_FAQInfoC_List.jsp/B_del_FAQInfo.jsp/B_add_FAQInfo.jsp/B_edit_FAQInfo.jsp
*Author : Lawrence Kang
*Created Date : 2000-10-25
*Last Updated : 
*Status : open/submited for test/closed
*Function : I.list all the title of the FAQInfo
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
oprCde=sessionuser.getuserId(Locate); 

/*B0002+*/
if (numStr == null) //first enter the page
{
/*E0002+*/
	try
	{
		formPara = new String[2];
		formPara[0] = "";//empty string for all the titile
		formPara[1] = oprCde; //operator code for log
		bb.setFormPara(BConst.QUERY_CONSULT_LIST,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
/*B0002+*/
	pm.setPageLength(8);
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
		<td valign="top">
			<p align="center"><br>
				<font size="3">保险咨询</font>
			</p>
		      <table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
					<tr bgcolor="#9DEEDE"> 
					  <td width="48%" height="27"> 
						<div align="center" class="unnamed2">保险咨询主题</div>
					  </td>
					  <td width="18%" height="27"> 
						<div align="center" class="unnamed2">添加时间 </div>
					  </td>
					  <td width="12%" height="27"> 
						<div align="center" class="unnamed2">咨询维护人</div>
					  </td>
					  <td width="10%" height="27" colspan="2"> 
						<div align="center">操作</div>
					  </td>
					</tr>
			<% if (result != null && result.length>1){
					indexFaqNo = Objects.getColNum("C_FAQ_NO",result);
					indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",result);
					indexFaqTm = Objects.getColNum("T_FAQ_TM",result);
					indexTopicNo = Objects.getColNum("C_TOPIC_NO",result);
					indexFaqEmp = Objects.getColNum("C_FAQ_EMP",result);
				for ( int i = 1; i < result.length; i++){
			%>
				<tr> 
					<td bgcolor="#DFF9F3" width="48%" height="21">
						<a href="B_FAQInfoC_List.jsp?sessionId=<%=Code.Encrypt(sessionId)%>&faqNo=<%=result[i][indexFaqNo]%>">
							<font color="#006666">◆</font><%=StringTool.htmlEncode(result[i][indexFaqTitle])%>
						</a>
					</td>
					<td bgcolor="#DFF9F3" width="18%" height="21" align="center"> 
						<%=result[i][indexFaqTm]%>
					</td>
					<td bgcolor="#DFF9F3" width="12%" height="21" align="center"> 
						<%=result[i][indexFaqEmp]%>
					</td>
					<form action="B_edit_FAQInfo.jsp" method="post">
					<td bgcolor="#DFF9F3" width="5%" height="21" align="right">
						<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
						<input type="hidden" name="faqNo" value="<%=result[i][indexFaqNo]%>">
						<input type="hidden" name="oprType" value="type">
						<input type="submit" value="修改"  style="background-color: #009999">
					</td>
					</form>
					<form action="B_del_FAQInfo.jsp" method="post">
						<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
						<input type="hidden" name="faqNo" value="<%=result[i][indexFaqNo]%>">
						<input type="hidden" name="faqTitle" value="<%=StringTool.htmlEncode(result[i][indexFaqTitle])%>">
						<input type="hidden" name="faqTm" value="<%=result[i][indexFaqTm]%>">
						<input type="hidden" name="oprType" value="type">
					<td bgcolor="#DFF9F3" align="right" nowrap height="25" width="5%">
						<input type="submit" value="删除" style="background-color: #009999">
					</td>
					</form>
				</tr>
			<%}
			}%>
			<tr bgcolor="#DFF9F3">
				<form action="B_add_FAQInfo.jsp" method="post">
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<td align="right" colspan="5">
						<input type="submit" value="增加主题" style="background-color: #009999">
					</td>
				</form>
			</tr>
			</table>
		</td>
	</tr>
</table>
	<!--
	B0002+
	-->
  <table width="96%" border="0" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr>
		<td align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="B_FAQInfoT_List.jsp?numStr=<%=pNo.toString(0)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[首    页]</a>
		<a href="B_FAQInfoT_List.jsp?numStr=<%=pNo.intValue()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[上一页]</a>
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
		<a href="B_FAQInfoT_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>&sessionId=<%=Code.Encrypt(sessionId)%>">[下一页]</a>
		<a href="B_FAQInfoT_List.jsp?numStr=<%=pm.getTotalPage()-1%>&sessionId=<%=Code.Encrypt(sessionId)%>">[末    页]</a>
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