<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : B_FAQ_DelMsg.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/B_FAQ_DelMsg.jsp
*Previous Page : B_del_FAQ.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-10-24
*Last Updated : 
*Status : open
*Function : I.excute the delete operation and feedback the result
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
	faqNo = StringTool.null2Blank(request.getParameter("faqNo"));

boolean
	bingo;

	oprCde=sessionuser.getuserId(Locate); 

	try
	{
		formPara = new String[2];
		formPara[0] = faqNo; // faq number ,empty for all 
		formPara[1] = oprCde; //operator code
		bb.setFormPara(BConst.DELETE_FAQ,formPara);
		bingo = bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}
%>
<%@ include file="public/left.jsp"%>
<div align="center">
<%if (bingo){
%>
		<font size="3" color="green">É¾³ý¿Í»§×ÉÑ¯³É¹¦</font>
<%}else{%>
		<font size="3" color="red">É¾³ý¿Í»§×ÉÑ¯Ê§°Ü</font>
<%}%>
	
			<form action="B_FAQ_List.jsp" method="post">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<input type ="submit" value="·µ»Ø">
			</form>
	</div>

<%@ include file="public/bottom.jsp"%>
