<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="bb"  scope="session" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/> 
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Assigned_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Assigned_List.jsp
*Previous Page : Find_Ply_Net.jsp
*Next Page : Assign_All.jsp|Assign_Send.jsp|Assign_Back.jsp
*Author : Lawrence Kang
*Created Date : 2000/10/09
*Last Updated : 2000/10/10
*Status : submited for test
*Function : I.Retrieve the all the report-Net list meet the condidtion
*			II.Submit to various page according to the various button pressed
*============================MODIFIED HISTORY==================================================
*Date : 00-10-11
*Time : 11:12
*Modify id :0001 
*Modifier : Lawrence Kang
*Reason : add validation check of date inputed
***********************************************************************************************
*Date : 2000-10-17
*Time : 15:28:41
*Modify id :0002
*Modifier : Lawrence Kang
*Reason : 分页处理
***********************************************************************************************

*/
%>

<%
//predefine
String selStr="";
String formPara[] = new String[2];
String formTable[][] = new String[10][1];
String result[][] = null;
String dealerList[][] = null;

int indexPlyNo = 0;
int indexRptNo = 0;
int indexRtpTm = 0;
int indexInsrntNme = 0;
int indexRptAmt = 0;
int indexCurTyp = 0;
int indexDptCde = 0;
int indexInsrncCde = 0;
int indexContactName = 0;
int indexDptCnm = 0;
int indexCurCnm = 0;
int indexInsrncCnm = 0;

int indexEmpCde = 0;
int indexEmpCnm = 0;
int indexDptCde1 = 0;

int i=0,j=0;
/*B0002+*/
Integer pNo;
/*E0002+*/

///////////////////////////////////////////////////////////////////////
//GET PARAMEETERS FROM THE LAST PAGE
String dealType = request.getParameter("dealType");
String isHandle = request.getParameter("isHandle");
String notHandle = request.getParameter("notHandle");
String isSent = request.getParameter("isSent");
String notSent = request.getParameter("notSent");
String isReport = request.getParameter("isReport");
String reportNo =  request.getParameter("reportNo");
String isPolicy = request.getParameter("isPolicy");
String policyNo =  request.getParameter("policyNo");
String isTimeTrack = request.getParameter("isTimeTrack");
String fromYear = request.getParameter("fromYear");
String fromMonth = request.getParameter("fromMonth");
String fromDay = request.getParameter("fromDay");
String fromHour = request.getParameter("fromHour");
String fromMinute = request.getParameter("fromMinute");
String fromSecond = request.getParameter("fromSecond");
String toYear = request.getParameter("toYear");
String toMonth = request.getParameter("toMonth");
String toDay = request.getParameter("toDay");
String toHour = request.getParameter("toHour");
String toMinute = request.getParameter("toMinute");
String toSecond = request.getParameter("toSecond");
String isInsuranceCode = request.getParameter("isInsuranceCode");
String fromInsuranceCode = request.getParameter("fromInsuranceCode");
String toInsuranceCode = request.getParameter("toInsuranceCode");
String dptCde = request.getParameter("dptCde");
String oprCde = request.getParameter("oprCde");
/*B0002+*/
String numStr = request.getParameter("numStr");
/*E0002+*/
String isInit = StringTool.null2Blank(request.getParameter("isInit"));
////////////////////////////////////////////////////////////////////////////////
/*B0002+*/
if (numStr == null) //first enter the page
{
/*E0002+*/
	if (isInit.equals("true")){
	//INITIALIZE THE FORMPARA LIST
	for (i=0;i<formTable.length;i++)
		formTable[i][0] = "";
	//prepare the parameters for query the report deal list
	formTable[0][0] = dealType;//dealtype

	if (dealType.equals("0")) //act_type
		formTable[1][0]="2";
	if (dealType.equals("1"))//act_type
	{
		if ((isHandle == null && notHandle == null) || (isHandle!=null && notHandle!=null))
			formTable[1][0] = "2";//all the action selected
		if (isHandle != null && notHandle == null)
			formTable[1][0] = "1"; // only isHandle selected
		if (isHandle == null && notHandle != null)
			formTable[1][0] = "0"; // only notHandle selected
	}
	if (dealType.equals("2"))//act_type
	{
		if ((isSent == null && notSent == null) || (isSent != null && notSent != null))
			formTable[1][0] = "2";//all the action selected
		if (isSent != null && notSent == null)
			formTable[1][0] = "1"; // only isSent selected
		if (isSent == null && notSent != null)
			formTable[1][0] = "0"; // only notSent selected
	}

	if (isPolicy != null && policyNo != null) //policy no
		formTable[2][0] = policyNo;

	if (isReport != null && reportNo != null) //report no
		formTable[3][0] = reportNo;


	if (	isTimeTrack!=null && //fromtime & totime
		fromYear!=null && fromMonth!=null && fromDay!=null && fromHour!=null && fromMinute!=null && fromSecond!=null &&
		toYear!=null && toMonth!=null && toDay!=null && toHour!=null && toMinute!=null && toSecond!=null)
	{
		formTable[4][0] = fromYear+"-"+fromMonth+"-"+fromDay+" "+fromHour+":"+fromMinute+":"+fromSecond;
		formTable[5][0] = toYear+"-"+toMonth+"-"+toDay+" "+toHour+":"+toMinute+":"+toSecond;
	}

	if (isInsuranceCode!=null && fromInsuranceCode != null && toInsuranceCode != null)//from & to insurance code
	{
		formTable[6][0] = fromInsuranceCode;
		formTable[7][0] = toInsuranceCode;
	}

	formTable[8][0] = dptCde; //depart code
	formTable[9][0] = oprCde; //operator code
	request.getSession(true).putValue("formTable",formTable);
	}else{//if (isInit.equals("true"))
	formTable = (String[][])request.getSession(false).getValue("formTable");
	}//end of if (isInit.equals("true"))

	
	try
	{
		bb.setFormTable(BConst.QUERY_RPT_FLWUPLIST,formTable);
		result = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
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

	
	if (dptCde != null){
		request.getSession().putValue("dptCde",dptCde);
	}else{
		dptCde = (String)request.getSession().getValue("dptCde");
	}
	if (oprCde != null){
		request.getSession().putValue("oprCde",dptCde);
	}else{
		oprCde = (String)request.getSession().getValue("oprCde");
	}
	formPara[0] = dptCde;
	formPara[1] = oprCde;
	try
	{
		bb.setFormPara(BConst.QUERY_SEND_EMP_LIST,formPara);
		dealerList = bb.getRetValueArra();
	}
	catch(NormalException e)
	{
	//	if(NormalExceptionHandler.IsSevere(e))
	//		throw NormalExceptionHandler.Handle(e);
		dealerList = null;
	}
%>
<form name="f" method="POST" action="Assign_All.jsp">
<div align="center"><font color="#0066CC" class="unnamed3">报案跟进列表</font></div><br>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" bordercolor="#009999" bordercolorlight="#FFFFFF" class="td">
    <tr bgcolor="#9DEEDE"> 
      <td width="5%">&nbsp;</td>
      <td width="10%" align="center" > 
        险种码
      </td>
      <td width="15%" align="center" > 
        保单号
      </td>
      <td width="15%" align="center" > 
        报案号
      </td>
      <td width="15%"  align="center" > 
        报案时间
      </td>
      <td width="15%"  align="center" >
		被保险人
		</td>
      <td width="15%"  align="center" > 
        估损金额
      </td>
      <td width="10%"  align="center" > 
        处理人
      </td>
    </tr>

    <%if (result != null && result.length>1)
	{
	indexPlyNo = Objects.getColNum("C_PLY_NO",result);
	indexRptNo = Objects.getColNum("C_RPT_NO",result);
	indexRtpTm = Objects.getColNum("T_RTP_TM",result);
	indexInsrntNme  = Objects.getColNum("C_INSRNT_NME",result);
	indexRptAmt = Objects.getColNum("N_RPT_AMT",result);
	indexCurTyp = Objects.getColNum("C_CUR_TYP",result); 
	indexDptCde = Objects.getColNum("C_DPT_CDE",result);
	indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",result);
	indexContactName = Objects.getColNum("C_CONTACT_NAME",result);
	indexCurCnm = Objects.getColNum("C_CUR_CNM",result);
%>
	<input type="hidden" name="lines" value="<%=result.length%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">
	<%	for (i=1;i<result.length;i++)
		{
			if (i == 1)
				selStr="checked";
			else
				selStr="";
			j=i-1;%>
		<tr> 
				<td width="5%" title="选择要操作的行"> 
	<input type="hidden" name="lines" value="<%=result.length%>">
	<input type="hidden" name="dptCde" value="<%=dptCde%>">
	<input type="hidden" name="oprCde" value="<%=oprCde%>">
	<input type="hidden" name="sessionId" value="<%=Code.Encrypt(sessionId)%>">

					<input <%=selStr%> type="radio" name="index" value="<%=j%>">
				</td>
				<td width="10%" title="险种码">
					<%=result[i][indexInsrncCde]%>
				</td>
				<td width="15%" title="保单号" >
					<%=result[i][indexPlyNo]%>&nbsp;
					<input type="hidden" name="plyNoList<%=j%>" value="<%=result[i][indexPlyNo]%>">
				</td>
				<td width="15%" title="报案号" >
					<%=result[i][indexRptNo]%>&nbsp;
					<input type="hidden" name="rptNoList<%=j%>" value="<%=result[i][indexRptNo]%>">
				</td>
				<td width="15%" title="报案时间" >
					<%=result[i][indexRtpTm]%>&nbsp;
				</td>
				<td width="15%" title="被保险人" >
					<%=result[i][indexInsrntNme]%>&nbsp;
				</td>
				<td width="15%" title="估损金额" >
					<%=result[i][indexRptAmt]%>(<%=result[i][indexCurCnm]%>)&nbsp;
				</td>
				<td width="10%" title="处理人" >
					<%=result[i][indexContactName]%>&nbsp;
				</td>
			</tr>
    <%		}%>
    <tr> 
      <td colspan="8" align="center" >
        <select name="dealerCode" title="选择要分配的受理人">
			<% 
			if (dealerList != null && dealerList.length>1)
			{
				for(i = 1;i < dealerList.length;i++)
				{
					indexEmpCde = Objects.getColNum("C_EMP_CDE",dealerList);
					indexEmpCnm = Objects.getColNum("C_EMP_CNM",dealerList);
					indexDptCde1 = Objects.getColNum("C_DPT_CDE",dealerList);
			%>
          <option value="<%=dealerList[i][indexEmpCnm]%>"><%=dealerList[i][indexEmpCnm]%></option>
		  <%	}
		  }%>
		  </select>
          <input type="submit" name="deal" value="分派受理人" onclick="f.action='Message_Dealer.jsp';" title="为选中的赔案分配受理人">
          <input type="submit" name="view" value="报案明细" onclick="f.action='View_RPT_Info.jsp';" title="查看选中赔案的详细信息">
		  <input type="submit" name="follow" value="报案跟进" onclick="f.action='Claim_Dgst_List.jsp';" title="处理报案跟进信息">
      </td>
    </tr>
    <%}
    else
    {%>
	<tr><td colspan="8"  align="center"><font color="red">没有查到报案信息！<br>请检查查询条件或扩大查询范围</font></td></tr>
    <%}%>
	</table>
	<!--
	B0002+
	-->
	<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
	<tr>
		<td align="left" colspan="4" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="Rpt_FlwUp_List.jsp?numStr=<%=pNo.toString(0)%>&dptCde=<%=dptCde%>&oprCde=<%=oprCde%>">[首    页]</a>
		<a href="Rpt_FlwUp_List.jsp?numStr=<%=pNo.toString(pNo.intValue()-1)%>&dptCde=<%=dptCde%>&oprCde=<%=oprCde%>">[上一页]</a>
		<%}
		else{
			out.println("[首    页]");
			out.println("[上一页]");
		}
		%>
		</td>
		<td align="center" colspan="4" width="40%">
			<p align=center>共<%=pm.getTotalPage()%>页；第<%=pNo.toString(pNo.intValue()+1)%>页</p>
		</td>
		<td align="right" colspan="4" width="30%">
		<%if (pNo.intValue() < pm.getTotalPage()-1){%>
		<a href="Rpt_FlwUp_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>&dptCde=<%=dptCde%>&oprCde=<%=oprCde%>">[下一页]</a>
		<a href="Rpt_FlwUp_List.jsp?numStr=<%=pm.getTotalPage()-1%>&dptCde=<%=dptCde%>&oprCde=<%=oprCde%>">[末    页]</a>
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
<%@ include file="public/bottom.jsp"%>
