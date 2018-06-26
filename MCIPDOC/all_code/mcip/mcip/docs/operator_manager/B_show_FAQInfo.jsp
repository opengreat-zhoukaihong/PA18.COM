<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_show_FAQInfo.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_show_FAQInfo.jsp
*Previous Page : B_FAQInofC_List.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-25
*Last Updated : 
*Status : open
*Function : I.Show detail information of the FAQ
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
	result[][],
	faqNo = StringTool.null2Blank(request.getParameter("faqNo")),
	oprCde;

int
	indexFaqNo,
	indexFaqEmp,
	indexFaqTitle,
	indexFaqContent,
	indexFaqTm,
	indexTopicNo;

	oprCde=sessionuser.getuserId(Locate); 

	try
	{
		formPara = new String[2];
		formPara[0] = faqNo;//empty string for all the titile
		formPara[1] = oprCde; //operator code for log
		bb.setFormPara(BConst.QUERY_CONSULT_INFO,formPara);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
%>
<div align="center"><font color="#0066CC" class="unnamed3">显示保险咨询内容</font></div><br>
<% if (result != null && result.length>1){
		indexFaqNo = Objects.getColNum("C_FAQ_NO",result);
		indexFaqEmp = Objects.getColNum("C_FAQ_EMP",result);
		indexFaqTitle = Objects.getColNum("C_FAQ_TITLE",result);
		indexFaqContent = Objects.getColNum("C_FAQ_CONTENT",result);
		indexFaqTm = Objects.getColNum("T_FAQ_TM",result);
		indexTopicNo = Objects.getColNum("C_TOPIC_NO",result);

%>
<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" bordercolor="#009999" bordercolorlight="#FFFFFF" class="td">
	<tr> 
		<td bgcolor="#9DEEDE" width="19%" align="right"> 标题</td>
		<td width="81%" bgcolor="#DFF9F3"><%=StringTool.htmlEncode(result[1][indexFaqTitle])%></td>
	</tr>
	<tr> 
		<td bgcolor="#9DEEDE" width="19%" align="right">内容</td>
		<td width="81%" bgcolor="#DFF9F3"><%=StringTool.htmlEncode(result[1][indexFaqContent])%></td>
	</tr>
	<tr> 
		<td bgcolor="#9DEEDE" width="19%" align="right">咨询添加时间</td>
		<td width="81%" bgcolor="#DFF9F3"><%=result[1][indexFaqTm]%></td>
	</tr>
  </table>
  <%}else{%>
	<font color="red">没有找到保险咨询的详细信息！</font>
  <%}%>
			<div align="center">
			<input type="submit" name="Submit" value="返回" onclick="history.back()">
			</div>
			</form>
<%@ include file="public/bottom.jsp"%>