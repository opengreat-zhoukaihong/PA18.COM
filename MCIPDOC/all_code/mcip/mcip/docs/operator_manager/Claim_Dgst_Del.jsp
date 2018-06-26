<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Claim_Dgst_Del.jsp
*Directory : /data1/pa18/nul/mcip/public_html/
*URL : http://10.16.102.1:8800/Claim_Dgst_del.jsp
*Previous Page : Claim_Dgst_List.jsp
*Next Page : none (can only back to the previous page)
*Author : Lawrence Kang
*Created Date : 2000-11-09
*Last Updated : 2000-11-09
*Status : submited for test
*Function : I.Display the selected the claim's content
*					II.perform the delete action
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
	action  = StringTool.null2Blank(request.getParameter("action")),
	formPara[],
	policyNo = StringTool.null2Blank(request.getParameter("policyNo")),
	reportNo = StringTool.null2Blank(request.getParameter("reportNo")),
	infoNo = StringTool.null2Blank(request.getParameter("infoNo")),
	claimDgst = StringTool.null2Blank(request.getParameter("claimDgst")),
	claimContent = StringTool.null2Blank(request.getParameter("claimContent")),
	inputTm = StringTool.null2Blank(request.getParameter("inputTm")),
	oprCde;

boolean
	bingo = false;

	oprCde=sessionuser.getuserId(Locate); 
if (action.equals("del")){
	formPara = new String[4];
	formPara[0] = reportNo; //report No.
	formPara[1] = policyNo; //policy No.
	formPara[2] = infoNo; //degist info No.(empty for auto allocate
	formPara[3] = oprCde;//operator code for log
	try
	{		 
		bb.setFormPara(BConst.DELETE_CLMDGST,formPara);
		bingo=bb.getRetValueBool();
	}
	catch(Exception e)
	{
		bingo = false;
	}
}
%>
<%if (!action.equals("del")){%>
<div align="center"><font color="#0066CC" class="unnamed3">报案摘要信息修改</font></div>
<form name="f" method="POST" action="Claim_Dgst_Del.jsp">
<input type="hidden" name="action" value="del">
<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
<input type="hidden" name="policyNo" value="<%=policyNo%>">
<input type="hidden" name="reportNo" value="<%=reportNo%>">
<input type="hidden" name="infoNo" value="<%=infoNo%>">
<input type="hidden" name="claimDgst" value="<%=StringTool.htmlEncode(claimDgst)%>">
<input type="hidden" name="claimContent" value="<%=StringTool.htmlEncode(claimContent)%>">
<input type="hidden" name="inputTm" value="<%=inputTm%>">
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
              <div align="left">信息摘要</div>
            </td>
			<td bgcolor="#DFF9F3" width="81%">
				<%=StringTool.htmlEncode(claimDgst)%>
			</td>
		</tr>
		<tr>
            <td bgcolor="#9DEEDE" width="19%">
              <p align="left">信息记录时间</p>
            </td>            
			<td bgcolor="#DFF9F3" width="81%">
				<%=inputTm%>
			</td>
          </tr>
		<tr>
            <td bgcolor="#9DEEDE" width="19%">
              <p align="left">信息内容</p>
            </td>            
			<td bgcolor="#DFF9F3" width="81%">
				<pre><%=StringTool.htmlEncode(claimContent)%></pre>
			</td>
          </tr>
        </table>
              <div align="center"><font face="宋体" size="4"> 
                <input type=button name="back" value="返回" onclick=history.back()>
				<input type="submit"  value="删除">
                </font></div>
        </form>
<%}else{
		if (bingo){%>
		<table border ="0" width = "100%" valign="center" align = "center">
			<tr>
				<td align="center">赔案摘要信息删除成功！</td>
			</tr>
			<tr>
				<form action="Claim_Dgst_List.jsp">
				<input type="hidden" name="index" value="0">
				<input type="hidden" name="plyNoList0" value="<%=policyNo%>">
				<input type="hidden" name="rptNoList0" value="<%=reportNo%>">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<td align="center">
					<input type="submit" value="返回">
				</td>
				</form>
			</tr>
		</table>
		<%}else{%>
		<table border ="0" width = "100%" valign="center" align = "center">
			<tr>
				<td align="center" >赔案摘要信息删除失败！</td>
			</tr>
			<tr>
				<form action="Claim_Dgst_List.jsp">
				<input type="hidden" name="index" value="0">
				<input type="hidden" name="plyNoList0" value="<%=policyNo%>">
				<input type="hidden" name="rptNoList0" value="<%=reportNo%>">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<td align="center">
					<input type="submit" value="返回">
				</td>
				</form>
			</tr>
		</table>
<%	}
}%>
<%@ include file="public/bottom.jsp"%>