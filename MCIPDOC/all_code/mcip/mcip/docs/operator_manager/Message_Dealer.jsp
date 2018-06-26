<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Message_Dealer.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Message_Dealer.jsp
*Previous Page : Rpt_FlwUp_List.jsp
*Next Page : none (can only back to the previous page)
*Author : Lawrence Kang
*Created Date : 2000/10/12
*Last Updated : 2000/10/12
*Status : submited for test
*Function : I.Validate the input
*			II.update the inputed data to the database
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
String dptCde= request.getParameter("dptCde");
String oprCde= request.getParameter("oprCde");
boolean bingo = false;
String formPara[] = new String[3];
String authorCde = "",reportNo = "",empCde = "",index = "";

index = request.getParameter("index");
reportNo = request.getParameter("rptNoList"+index);
empCde = request.getParameter("dealerCode");
authorCde=sessionuser.getuserId(Locate); 


formPara[0] = reportNo;
formPara[1] = empCde;
formPara[2] = authorCde;
try
{
	bb.setFormPara(BConst.ACCEPT_RPT_FLWUPEMP,formPara);
	bingo = bb.getRetValueBool();
}
catch(NormalException e)
{
//	if(NormalExceptionHandler.IsSevere(e))
//		throw NormalExceptionHandler.Handle(e);
	bingo = false;
}
%>
<div align="center"><font color="#0066CC" class="unnamed3">添加受理人结果</font></div><br>
<table width="75%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" height="140">
<%
if (!bingo){%>
    <tr bgcolor="#009999"> 
	<td align="center" colspan="2" width="100%">
		<font color="red">添加受理人失败！<br>请重试或联系系统管理员！</font>
	</td>
</tr>
<%}else{%>
<tr>
    <tr bgcolor="#009999"> 
	<td align="center" colspan="2" width="100%">
		受理人已成功添加！<br>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" align="left" width="15%">
		赔案号：
	</td>
	<td bgcolor="#DFF9F3" width="85%">
		<%=reportNo%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="15%">
		跟进人：
	</td>
	<td bgcolor="#DFF9F3" width="85%">
	<%=empCde%>
	</td>
</tr>
<%}%>
</table>
<div align="center">
	<form action="Rpt_FlwUp_List.jsp">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<input type="hidden" name="dptCde" value="<%=dptCde%>">
	<input type="hidden" name="oprCde" value="<%=oprCde%>">
	<input type="submit" value="返回">
	</form>
</div>
<%@ include file="public/bottom.jsp"%>