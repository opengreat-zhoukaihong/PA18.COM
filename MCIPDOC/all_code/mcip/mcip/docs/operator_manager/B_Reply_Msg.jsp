<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_Reply_Msg.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_Reply_Msg.jsp
*Previous Page : B_Reply_FAQ.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-24
*Last Updated : 
*Status : open
*Function : I.Update the t_faq table and display the operation result
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
	oprCde,
	faqNo = StringTool.null2Blank(request.getParameter("faqNo")),
	faqTitle = StringTool.null2Blank(request.getParameter("faqTitle")),
	faqEmail = StringTool.null2Blank(request.getParameter("faqEmail")),
	replyCont = StringTool.null2Blank(request.getParameter("replyCont")),
	formPara[];


boolean
	bingo;

	oprCde=sessionuser.getuserId(Locate); 

	try
	{
		formPara= new String[10];
		formPara[0] = faqNo;//c_faq_no
		formPara[1] = "";//c_faq_psn
		formPara[2] = "";//c_faq_email
		formPara[3] = "";//c_faq_title
		formPara[4] = "";//c_faq_content
		formPara[5] = "";//t_faq_tm
		formPara[6] = replyCont;//c_reply_cont
		formPara[7] = oprCde;//c_reply_emp
		formPara[8] = "";//t_reply_tm auto create
		formPara[9] = oprCde;//oprCde for log
		bb.setFormPara(BConst.REPLY_FAQ,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}

%>
<%@ include file="public/left.jsp"%>

 <table width="50%" border="1" cellspacing="0" cellpadding="0" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" align="center" bgcolor="#DFF9F3">
	<tr bgcolor="#9DEEDE"> 
		<td height="30" align="center" valign="center">回复客户咨询<td>
   </tr>
	<tr align="center">
	  <td height="50">
  		 <p>
			<%if (bingo){%>
			<font color="#006633">
				您已经成功的提交了客户咨询的回复信息。<br>
				您是否要将这信息通过电子邮件
			</font>
			<a href="mailto:<%=StringTool.mailtoEncode(faqEmail)%>?subject=回复:<%=StringTool.mailtoEncode(faqTitle)%>&body=<%=StringTool.mailtoEncode(replyCont)%>">
				回复客户
			</a><br>
			<%}else{%>
				<font color="red">回复提交不成功!</font>
			<%}%>
		 </p>
	  </td>
	</tr>
	<tr>
	  <td align="center" valign="center">
	    <form action="B_FAQ_List.jsp" method="post">
			<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
			<input type ="submit" value="返回">
		 </form>
	  </td>
	</tr>
</table>
<%@ include file="public/bottom.jsp"%>
