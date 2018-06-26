<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Claim_Dgst_Add.jsp
*Directory : /data1/pa18/nul/mcip/public_html/
*URL : http://10.16.102.1:8800/Claim_Dgst_Add.jsp
*Previous Page : Claim_Dgst_List.jsp
*Next Page : none (can only back to the previous page)
*Author : Lawrence Kang
*Created Date : 2000-11-09
*Last Updated : 2000-11-09
*Status : submited for test
*Function : I.add the new calim degist
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
	action = StringTool.null2Blank(request.getParameter("action")),
	claimDgst = StringTool.null2Blank(request.getParameter("claimDgst")),
	claimContent = StringTool.null2Blank(request.getParameter("claimContent")),
	reportNo = StringTool.null2Blank(request.getParameter("reportNo")),
	policyNo = StringTool.null2Blank(request.getParameter("policyNo")),
	oprCde;

boolean
	bingo = false;
	oprCde=sessionuser.getuserId(Locate); 
//process when submit pressed
if (action.equals("add")){
	//fill the parameter array
	formPara = new String[7];
	formPara[0] = policyNo; //policy No.
	formPara[1] = reportNo; //report No.
	formPara[2] = ""; //degist info No.(empty for auto allocate
	formPara[3] = claimDgst;//
	formPara[4] = claimContent;//
	formPara[5] ="";//input time (empty for current time)
	formPara[6] =oprCde;//operator code for log
	try
	{		 
		bb.setFormPara(BConst.ACCEPT_CLMDGST,formPara);
		bingo=bb.getRetValueBool();
	}
	catch(NormalException e)
	{
		bingo = false;
	}
}
%>
	<div align="center"><font color="#0066CC" class="unnamed3">报案摘要信息录入 </font></div>
	<% if (!action.equals("add")){%>
	<form name="f" method="POST" action="Claim_Dgst_Add.jsp">
		<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
		<input type="hidden" name="policyNo" value="<%=policyNo%>">
		<input type="hidden" name="reportNo" value="<%=reportNo%>">
		<input type="hidden" name="action" value="add">
		<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
			<tr> 
				<td bgcolor="#9DEEDE" width="19%"> 
					<div align="left">报案号</div>
				</td>
				<td bgcolor="#DFF9F3" width="81%">
					<%=reportNo%>
				</td>
			</tr>
			<tr> 
				<td bgcolor="#9DEEDE" width="19%"> 
					<div align="left">保单号</div>
				</td>
				<td bgcolor="#DFF9F3" width="81%">
					<%=policyNo%>
				</td>
			</tr>
				<td bgcolor="#9DEEDE" width="19%"> 
					<div align="left">信息摘要</div>
				</td>
				<td bgcolor="#DFF9F3" width="81%">
					<input type="text" name="claimDgst" size="50" maxlength="50">
				</td>
			</tr>
			<tr bgcolor="#FFFFFF">
				<td bgcolor="#9DEEDE" width="19%"> 
					摘要内容：
				</td>
				<td bgcolor="#DFF9F3" width="81%">
					<textarea name="claimContent" rows="7" cols="60"></textarea>
			</td>
		  </tr>
	</table>
	<div align="center">
		<input type="submit" value="提交">
		<input type=button name="back" value="返回" onclick=history.back()>
	</div>
</form>
<%}else{
		if (bingo){%>
		<table border ="0" width = "100%" valign="center" align = "center">
			<tr>
				<td align="center">赔案摘要信息添加成功！</td>
			</tr>
			<tr>
				<form action="Claim_Dgst_List.jsp">
				<input type="hidden" name="index" value="0">
				<input type="hidden" name="plyNoList0" value="<%=policyNo%>">
				<input type="hidden" name="rptNoList0" value="<%=reportNo%>">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<td align="center">
					<input type="submit" value="返回">
					<input type="button" value="继续添加" onclick="history.back()">
				</td>
				</form>
			</tr>
		</table>
<%	}else{%>
		<table border ="0" width = "100%" valign="center" align = "center">
			<tr>
				<td align="center" ><h1>赔案摘要信息添加失败！</h1></td>
			</tr>
			<tr>
				<form action="Claim_Dgst_List.jsp">
				<input type="hidden" name="index" value="0">
				<input type="hidden" name="plyNoList0" value="<%=policyNo%>">
				<input type="hidden" name="rptNoList0" value="<%=reportNo%>">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<td align="center">
					<input type="submit" value="返回">
					<input type="button" value="继续添加" onclick="history.back()">
				</td>
				</form>
			</tr>
		</table>
<%		}
	}
%>
<%@ include file="public/bottom.jsp"%>