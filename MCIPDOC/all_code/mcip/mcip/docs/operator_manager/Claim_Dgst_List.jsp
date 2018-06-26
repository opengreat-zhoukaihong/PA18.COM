<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Claim_Dgst_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Claim_Dgst_List.jsp
*Previous Page : RPT_FlwUp_List.jsp
*Next Page : Claim_Dgst_Add.jsp/Claim_Dgst_Del.jsp/Claim_Dgst_Edit.jsp
*Author : Lawrence Kang
*Created Date : 2000/09/16
*Last Updated : 2000/10/10
*Status : submited for test
*Function : I.Display the detail information of selected policy claim
*============================MODIFIED HISTORY==================================================
*Date : 
*Time : 
*Modify id : 
*Modifier : 
*Reason : 
***********************************************************************************************
*/
%>
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="sb"  scope="page" class="beans.ZPolicyInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>
<%
String selStr= "";
String formPara[]=new String[3];
String RetList[][]=null;
int rLen=0;
int i=0,j=0;
int index_rpt_no=0;
int index_digest=0;
int index_content=0;
int index_input_tm=0;
int index_info_no = 0;
String index = StringTool.null2Blank(request.getParameter("index"));
String reportNo = StringTool.null2Blank(request.getParameter("rptNoList"+index));
String policyNo = StringTool.null2Blank(request.getParameter("plyNoList"+index));
	//set Form Paremeters

	formPara[0]=reportNo;
	formPara[1]=policyNo;

	//get values to the table
	//Summary is 
	//C_RPT_NO		报案号
	//C_DIGEST		信息摘要
	//T_INPUT_TM	信息记录时间
	//C_CONTENT		详细内容
	try
	{		 
		sb.setFormPara(ZConst.GET_CLMDGSTLIST,formPara);
		RetList=sb.getRetValueArra();
	}
	catch(NormalException e)
	{
 		if(NormalExceptionHandler.IsSevere(e))
	 	    throw NormalExceptionHandler.Handle(e);
	}

	if (RetList!=null && RetList.length>1){
		rLen=RetList.length;
		//获得所需字段的所在列的索引
		 index_rpt_no = Objects.getColNum("C_RPT_NO",RetList);   // 报案号
		 index_digest = Objects.getColNum("C_DIGEST",RetList);   //信息摘要
		 index_input_tm   = Objects.getColNum("T_INPUT_TM",RetList);  //信息记录时间
		 index_content = Objects.getColNum("C_CONTENT",RetList);//详细内容
		 index_info_no = Objects.getColNum("C_INFO_NO",RetList);//摘要序号
	}
%>
<div align="center"><font color="#0066CC" class="unnamed3">赔案进度跟踪</font></div>
        <table width="96%" border="1" cellspacing="0" cellpadding="0" bordercolor="#009999" bordercolorlight="#FFFFFF" class="td">
          <tr bgcolor="#9DEEDE">
			<td height=20 width="20%">保单号</td> 
            <td height=20 width="20%"> 报案号</td>
            <td height=20 width="30%">信息摘要</td>
            <td height=20 width="20%"">信息记录时间</td>
            <td height=20 width="10%" colspan="2">操  作</td>
          </tr>
	  	  <%
	  if (RetList!=null && RetList.length >1)
	  {
		for (i=1;i<rLen;i++)
		{
			if (i==1)
				selStr=" checked ";
			else
				selStr=" ";
	  %>
	  <tr bgcolor="#DFF9F3"> 
		<td width="20%">
			<input type="hidden" name="<%="reportNo"+i%>" value="<%=RetList[i][index_rpt_no]%>">
			<input type="hidden" name="<%="claimDgst"+i%>" value="<%=StringTool.htmlEncode(RetList[i][index_digest])%>">
			<input type="hidden" name="<%="inputTime"+i%>" value="<%=RetList[i][index_input_tm]%>">
			<input type="hidden" name="<%="content"+i%>" value="<%=StringTool.htmlEncode(RetList[i][index_content])%>">
			<%=policyNo%>&nbsp;</td>
		<td width="20%"><%=RetList[i][index_rpt_no]%>&nbsp;</td>
		<td width="30%"><%=StringTool.htmlEncode(RetList[i][index_digest])%>&nbsp;</td>
		<td width="20%"><%=RetList[i][index_input_tm]%>&nbsp;</td>
		<form action="Claim_Dgst_Edit.jsp" method="post">
		<td width="5%">
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<input type="hidden" name="policyNo" value="<%=policyNo%>">
				<input type="hidden" name="reportNo" value="<%=RetList[i][index_rpt_no]%>">
				<input type="hidden" name="infoNo" value="<%=RetList[i][index_info_no]%>">
				<input type="hidden" name="claimDgst" value="<%=StringTool.htmlEncode(RetList[i][index_digest])%>">
				<input type="hidden" name="claimContent" value="<%=StringTool.htmlEncode(RetList[i][index_content])%>">
				<input type="hidden" name="inputTm" value="<%=RetList[i][index_input_tm]%>">
				<input type="submit" value="修改" style="background: #009999">
		</td>
		</form>
		<form action="Claim_Dgst_Del.jsp">
		<td>
				<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
				<input type="hidden" name="policyNo" value="<%=policyNo%>">
				<input type="hidden" name="reportNo" value="<%=RetList[i][index_rpt_no]%>">
				<input type="hidden" name="infoNo" value="<%=RetList[i][index_info_no]%>">
				<input type="hidden" name="claimDgst" value="<%=StringTool.htmlEncode(RetList[i][index_digest])%>">
				<input type="hidden" name="claimContent" value="<%=StringTool.htmlEncode(RetList[i][index_content])%>">
				<input type="hidden" name="inputTm" value="<%=RetList[i][index_input_tm]%>">
				<input type="submit" value="删除" style="background: #009999">
		</td>
		</form>
	  </tr>
	  <%
		}
	  }
	  %>
          <tr bgcolor="#DFF9F3">
		  <form action="Claim_Dgst_Add.jsp">
            <td align="right" colspan="6"> 
			  
					<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
					<input type="hidden" name="policyNo" value="<%=policyNo%>">
					<input type="hidden" name="reportNo" value="<%=reportNo%>">
					<input type="submit" name="add" value="添加摘要" style="background: #009999">
				
            </td>
			</form>
          </tr>
	</table>
		<div align="center">
			<form action="Rpt_FlwUp_List.jsp">
			<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
			<input type="submit" name="back" value="返    回">
			</form>
		</div>
<%@ include file="public/bottom.jsp"%>