<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/>
<jsp:setProperty name="pm" property="*"/>
<jsp:useBean id="util"  scope="session" class="utility.StringTool"/>
<jsp:setProperty name="util" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Bus_Proposal_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Bus_Proposal_List.jsp
*Previous Page : Bus_List.jsp
*Next Page : Bus_Forward.jsp(hidden page)
*Author : Lawrence Kang
*Created Date : 2000-10-30
*Last Updated :
*Status : submited for test
*Function : 列出建议书清单供操作员查看
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
	/*B0002+*/
	numStr = request.getParameter("numStr"),
	/*E0002+*/
		fromYear = StringTool.null2Blank((String)request.getAttribute("fromYear")),
		fromMonth = StringTool.null2Blank((String)request.getAttribute("fromMonth")),
		fromDay = StringTool.null2Blank((String)request.getAttribute("fromDay")),
		toYear = StringTool.null2Blank((String)request.getAttribute("toYear")),
		toMonth = StringTool.null2Blank((String)request.getAttribute("toMonth")),
		toDay = StringTool.null2Blank((String)request.getAttribute("toDay")),
		dpt = StringTool.null2Blank((String)request.getAttribute("dpt")),
		expand = StringTool.null2Blank((String)request.getAttribute("expand")),
		fromInsrncTyp = StringTool.null2Blank((String)request.getAttribute("fromInsrncTyp")),
		toInsrncTyp = StringTool.null2Blank((String)request.getAttribute("toInsrncTyp")),
		currency = StringTool.null2Blank((String)request.getAttribute("currency")),
		siteCde = StringTool.null2Blank((String)request.getAttribute("siteCde")),
		plyAppStat = StringTool.null2Blank((String)request.getAttribute("plyAppStat")),
		busType = StringTool.null2Blank((String)request.getAttribute("busType")),
		fromTime ,
		toTime,
		formTable[][],
		formPara[],
		result[][],
		dptResult[] = null,
		oprCde;

/*B0002+*/
Integer pNo;
/*E0002+*/

	oprCde=sessionuser.getuserId(Locate);
/*B0002+*/
if (numStr == null) //first enter the page
{
/*E0002+*/
	try//获得所辖机构列表
	{
		formPara = new String[1];
		formPara[0] = oprCde;
		ub.setFormPara(ZConst.QUERY_OPTRDPTLIST,formPara);
		result = ub.getRetValueArra();
	}
	catch(NormalException e)
	{
		result = null;
	}
	if (result != null && result.length>1){
		int indexOprCde = Objects.getColNum("C_OPR_CDE",result);
		int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
		int indexDptCnm = Objects.getColNum("C_DPT_CNM",result);
		int indexDptEnm = Objects.getColNum("C_DPT_ENM",result);
		dptResult = new String[result.length-1];
		for (int i=1, j=0;i<result.length;i++,j++){
			dptResult[j] = result[i][indexDptCde];
		}
	}

	try{
		formTable = new String[10][];//there are 10 parameters should be pass
		formTable[0] = new String[1];//from time
		formTable[1] = new String[1];// to time
		formTable[2] = new String[1];//departlist
		formTable[3] = new String[1];//from depart
		formTable[4] = new String[1];// to depart
		formTable[5] = new String[1];//from insurance code
		formTable[6] = new String[1];// to insurance code
		formTable[7] = new String[1];//currency code
		formTable[8] = new String[1];//site code
		formTable[9] = new String[1];//operator code
		formTable[0][0] = fromYear + "-" + fromMonth + "-" + fromDay;
		formTable[1][0] = toYear + "-" + toMonth + "-" + toDay;
		formTable[2] = dptResult;
		formTable[3][0] = dpt;
		formTable[4][0] = expand;
		formTable[5][0] = fromInsrncTyp;
		formTable[6][0] = toInsrncTyp;
		formTable[7][0] = currency;
		formTable[8][0] = siteCde;
		formTable[9][0] = oprCde;
		bb.setFormTable(BConst.GET_PROPOSAL_STATICS,formTable);
		result = bb.getRetValueArra();
	}
	catch (Exception e){
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
<%@ include file="public/left.jsp"%>
			<div align="center"><br>
				<font color="#0066CC" class="unnamed3">建 议 书 清 单 </font><br>
			</div>
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="td" bgcolor="#DFF9F3" align="center">
	<tr bgcolor="#9DEEDE">
		<td height="33" width="6%">机构</td>
		<td height="33" width="15%">险种</td>
		<td height="33" width="19%">投保单号</td>
		<td height="33" width="12%">保额</td>
		<td height="33" width="10%">费率</td>
		<td height="33" width="9%">保费</td>
		<td height="33" width="9%">核保人</td>
		<td height="33" width="20%">核保时间</td>
	</tr>
	<% if (result != null && result.length>1){
			int indexPlyAppNo = Objects.getColNum("C_PLY_APP_NO",result);
			int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
			int indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",result);
			int indexNAmt = Objects.getColNum("N_AMT",result);
			int indexAmtCur = Objects.getColNum("C_AMT_CUR",result);
			int indexNRate = Objects.getColNum("N_RATE",result);
			int indexNSumPrm = Objects.getColNum("N_SUM_PRM",result);
			int indexPrmCur = Objects.getColNum("C_PRM_CUR",result);
			int indexUndrPrsn = Objects.getColNum("C_UNDR_PRSN",result);
			//int indexSignTm = Objects.getColNum("T_SIGN_TM",result);
			int indexUpdTm = Objects.getColNum("T_UPD_TM",result);
			int indexSiteCde = Objects.getColNum("C_SITE_CDE",result);
			int indexDptCnm = Objects.getColNum("C_DPT_CNM",result);
			int indexInsrncCnm = Objects.getColNum("C_INSRNC_CNM",result);
			int indexAmtCurCnm = Objects.getColNum("C_AMT_CUR_CNM",result);
			int indexPrmCurCnm = Objects.getColNum("C_PRM_CUR_CNM",result);
			for (int i=1;i<result.length;i++){%>
	<tr>
		<td width="6%"><%=result[i][indexDptCnm]%>&nbsp;</td>
		<td width="15%"><%=result[i][indexInsrncCnm]%>(<%=result[i][indexDptCde]%>)&nbsp;</td>
		<td width="19%"><%=result[i][indexPlyAppNo]%>&nbsp;</td>
		<td width="12%"><%=util.fixedComma(result[i][indexNAmt])%><br>(<%=result[i][indexAmtCurCnm]%>)&nbsp;</td>
		<td width="10%"><%=result[i][indexNRate]%>&nbsp;</td>
		<td width="9%"><%=util.fixedComma(result[i][indexNSumPrm])%><br>(<%=result[i][indexPrmCurCnm]%>)&nbsp;</td>
		<td width="9%"><%=result[i][indexUndrPrsn]%>&nbsp;</td>
		<td width="20%"><%=result[i][indexUpdTm]%>&nbsp;</td>
	</tr>
<%		}
	}%>
</table>
	<!--
	B0002+
	-->
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="td" align="center">
	<tr>
		<td align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="Bus_Proposal_List.jsp?numStr=<%=pNo.toString(0)%>">[首    页]</a>
		<a href="Bus_Proposal_List.jsp?numStr=<%=pNo.toString(pNo.intValue()-1)%>">[上一页]</a>
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
		<a href="Bus_Proposal_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>">[下一页]</a>
		<a href="Bus_Proposal_List.jsp?numStr=<%=pm.getTotalPage()-1%>">[末    页]</a>
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
<p><center>
		<a href="Bus_List.jsp?sessionId=<%=Code.Encrypt(sessionId)%>">返回 </a>
	</center></p>
<%@ include file="public/bottom.jsp"%>

