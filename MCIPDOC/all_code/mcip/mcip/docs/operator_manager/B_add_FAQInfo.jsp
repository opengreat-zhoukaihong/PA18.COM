<%@ include file="public/up.jsp" %>
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
		selStr,
		oprType = StringTool.null2Blank(request.getParameter("oprType")),
		result[][] = null,
		formPara[] = null,
		faqTitle = StringTool.null2Blank(request.getParameter("faqTitle")),
		parentFaqNo = StringTool.null2Blank(request.getParameter("parentFaqNo")),
		faqCont = StringTool.null2Blank(request.getParameter("faqCont")),
		action = StringTool.null2Blank(request.getParameter("action")),
		oprCde = null;
	
int
	indexFaqNo,
	indexFaqTitle,
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
		formPara[0] = ""; //c_faq_no,empty for auto create
		formPara[1] = oprCde; //operator who add the title
		formPara[2] = faqTitle;  // faq title
		formPara[3] = faqCont;  //faq content
		formPara[4] = "";  //faq  added time,empty for curent type
		formPara[5] = parentFaqNo; //topic no,empty for title record
		formPara[6] = oprCde;  //operator code for log
		bb.setFormPara(BConst.ACCEPT_CONSULT_INFO,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
}
}
%>
<script language="JavaScript" src="check.js">
</script>
<%@ include file="public/left.jsp"%>
<p align="center">
	保险咨询维护
</p>
<form name="f" action="B_add_FAQInfo.jsp" method="POST" onsubmit="return (ValidNull(f.faqTitle,false));">
<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
<input type="hidden" name="action" value="yes">
<input type="hidden" name="oprType" value="<%=oprType%>">
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" bgcolor="#DFF9F3">
		<%if (action.equals("yes")){
				if (bingo){%>
					<tr bgcolor="#9DEEDE">
					   <td align="center" colspan="2">
						   <font size="4" color="#6600CC">保险咨询标题添加成功!</font>
					   </td>
					</tr>
					<%}else{%>
					<tr bgcolor="#9DEEDE">
					   <td align="center" colspan="2">
						   <font size="4" color="#6600CC">保险咨询标题添加失败!</font>
						</td>
					</tr>
					<%}
			}%>
		<tr bgcolor="#9DEEDE"> 
			<td height="30" colspan="2" align="center"> 
				<font size="3">
				  添加新的保险咨询<%if (oprType.equals("item")) out.println("内容"); else out.println("类别");%>
				</font>
			</td>
		</tr>
				<%if (oprType.equals("item")){%>
					<tr> 
					  <td height="30" bgcolor="#9DEEDE"> 
					    所属类别：
						</td>
						<td align="left" height="30"> 
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
				<td height="30" align="left"> 
					<input type="text" name="faqTitle" size="50" value="<%=StringTool.htmlEncode(faqTitle)%>">*
				</td>
			</tr>
				<%if (oprType.equals("item")){%>
			<tr> 
			  <td height="30" bgcolor="#9DEEDE"> 
 				  内容：
			  </td>
			  <td height="30" align="left"> 
					<textarea name="faqCont" cols="65" rows="4"><%=StringTool.htmlEncode(faqCont)%></textarea>
				</td>
			</tr>
				<%}%>
	</table><br>
	<table width="50%" border="0" align="center" class="td">
		<tr>
			<td align="center">
				<input type="submit" value="提交" name="B1">
			</td>
</form>
			<% if (action.equals("yes")){%>
			<form action="<%if (oprType.equals("item")) out.print("B_FAQInfoC_List.jsp"); else out.print("B_FAQInfoT_List.jsp");%>" method="post">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<input type="hidden" name="faqNo" value="<%=parentFaqNo%>">
			<td align="center">
				<input type="submit" value="返回保险咨询列表" name="B12">
			</td>
			</form>
			<%}%>
		</tr>
    </table>
<%@ include file="public/bottom.jsp"%>
