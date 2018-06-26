<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/>
<jsp:setProperty name="pm" property="*"/>
<jsp:useBean id="util"  scope="session" class="utility.StringTool"/>
<jsp:setProperty name="util" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Bus_Claim_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Bus_Claim_List.jsp
*Previous Page : Bus_Forward.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-11-06
*Last Updated :
*Status : open
*Function : 列出陪案清单和小计供操作员查看
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
		dptSum[][],
		insrncSum[][],
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
		bb.setFormTable(BConst.GET_CASE_RPT_STATICS,formTable);
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
	<font color="#0066CC" class="unnamed3">报 案 清 单</font>
</div>
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="td" bgcolor="#DFF9F3" align="center">
	<tr bgcolor="#9DEEDE">
		<td align="center" height="33" width="8%">机构</td>
		<td align="center" height="33" width="6%">险种</td>
		<td align="center" height="33" width="12%">报案号</td>
		<td align="center" height="33" width="14%">保单号码</td>
		<td align="center" height="33" width="11%">报损金额</td>
		<td align="center" height="33" width="15%">出险时间</td>
		<td align="center" height="33" width="18%">损失情况</td>
		<td align="center" height="33" width="16%">报案日期</td>
	</tr>
	<% if (result != null && result.length>1){
			int indexRptNo = Objects.getColNum("C_RPT_NO",result);
			int indexPlyNo = Objects.getColNum("C_PLY_NO",result);
			int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
			int indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",result);
			int indexRptAmt = Objects.getColNum("N_RPT_AMT",result);
			int indexCurTyp = Objects.getColNum("C_CUR_TYP",result);
			int indexAccdntTm = Objects.getColNum("T_ACCDNT_TM",result);
			int indexLosDtl = Objects.getColNum("C_LOS_DTL",result);
			int indexRtpTm = Objects.getColNum("T_RTP_TM",result);
			int indexSiteCde = Objects.getColNum("C_SITE_CDE",result);
			int indexDptCnm = Objects.getColNum("C_DPT_CNM",result);
			int indexInsrncCnm = Objects.getColNum("C_INSRNC_CNM",result);
			int indexCurCnm = Objects.getColNum("C_CUR_CNM	",result);
			for (int i=1;i<result.length;i++){%>
	<tr>
		<td align="center" width="8%"><%=result[i][indexDptCnm]%>&nbsp;</td>
		<td align="center" width="6%"><%=result[i][indexInsrncCnm]%>(<%=result[i][indexDptCde]%>)&nbsp;</td>
		<td align="center" width="12%"><%=result[i][indexRptNo]%>&nbsp;</td>
		<td align="center" width="14%"><%=result[i][indexPlyNo]%>&nbsp;</td>
		<td align="center" width="11%"><%=util.fixedComma(result[i][indexRptAmt])%>(<%=result[i][indexCurCnm]%>)&nbsp;</td>
		<td align="center" width="15%"><%=result[i][indexAccdntTm]%>&nbsp;</td>
		<td align="center" width="18%"><%=result[i][indexLosDtl]%>&nbsp;</td>
		<td align="center" width="16%"><%=result[i][indexRtpTm]%>&nbsp;</td>
	</tr>
	<%	}
	}%>
</table>
	<!--
	B0002+
	-->
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="td" align="center">
	<tr>
		<td align="left" align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="Bus_Claim_List.jsp?numStr=<%=pNo.toString(0)%>">[首    页]</a>
		<a href="Bus_Claim_List.jsp?numStr=<%=pNo.toString(pNo.intValue()-1)%>">[上一页]</a>
		<%}
		else{
			out.println("[首    页]");
			out.println("[上一页]");
		}
		%>
		<td align="center" align="center" width="40%">
			共<%=pm.getTotalPage()%>页；第<%=pNo.toString(pNo.intValue()+1)%>页
		</td>
		</td>
		<td align="right" align="right" width="30%">
		<%if (pNo.intValue() < pm.getTotalPage()-1){%>
		<a href="Bus_Claim_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>">[下一页]</a>
		<a href="Bus_Claim_List.jsp?numStr=<%=pm.getTotalPage()-1%>">[末    页]</a>
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
<center>
<br>
<%
		Vector  dptCde = new Vector();//机构码
		Vector  dptName = new Vector();//机构名称
		Vector countD = new Vector();//业务数量（根据机构码排序）
		Vector AmtD = new Vector();//金额（根据机构码排序）

		Vector insrncCde = new Vector();
		Vector insrncName = new Vector();//险种
		Vector countI = new Vector();//业务数量（根据险种码排序）
		Vector AmtI = new Vector();//金额（根据险种码排序）

		//获得所有对人民币的汇率
			String exchangeList[][] = null;
			try{
				formPara = new String[2];
				formPara[0] = "";
				formPara[1] = "01";
				sb.setFormPara(Const.GET_EXCHANGERATE,formPara);
				exchangeList = sb.getRetValueArra();
			}
			catch (Exception e){
				exchangeList = null;
			}

		result = pm.dumpOut();
		if (result != null && result.length>1 ){
			int index = 0;
			int indexDpt=0,indexInsrnc=0;
			int indexRptNo = Objects.getColNum("C_RPT_NO",result);
			int indexPlyNo = Objects.getColNum("C_PLY_NO",result);
			int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
			int indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",result);
			int indexRptAmt = Objects.getColNum("N_RPT_AMT",result);
			int indexCurTyp = Objects.getColNum("C_CUR_TYP",result);
			int indexAccdntTm = Objects.getColNum("T_ACCDNT_TM",result);
			int indexLosDtl = Objects.getColNum("C_LOS_DTL",result);
			int indexRtpTm = Objects.getColNum("T_RTP_TM",result);
			int indexSiteCde = Objects.getColNum("C_SITE_CDE",result);
			int indexDptCnm = Objects.getColNum("C_DPT_CNM",result);
			int indexInsrncCnm = Objects.getColNum("C_INSRNC_CNM",result);
			int indexCurCnm = Objects.getColNum("C_CUR_CNM	",result);
			for (int i=1;i<result.length;i++){
				//get exchange rate for current policy
				BigDecimal exRate =new BigDecimal(1);
				if (exchangeList != null && exchangeList.length > 1){
					int indexCurNo1 = Objects.getColNum("C_CUR_NO_1",exchangeList);
					int indexCurNo2 = Objects.getColNum("C_CUR_NO_2",exchangeList);
					int indexEffcTm = Objects.getColNum("T_EFFC_TM",exchangeList);
					int indexChgRte = Objects.getColNum("N_CHG_RTE",exchangeList);
					for (int j=1;j<exchangeList.length;j++){
						if (exchangeList[j][indexCurNo1].equals(result[i][indexCurTyp])){
							exRate = new BigDecimal(exchangeList[j][indexChgRte]);
							break;
						}//endif
					}//endfor
				}//endif
				indexDpt = dptCde.indexOf(result[i][indexDptCde]);
				indexInsrnc = insrncCde.indexOf(result[i][indexInsrncCde]);
				//calculate the summary by department
				if (indexDpt == -1) {//find a new department
					dptCde.add(result[i][indexDptCde]);
					dptName.add(result[i][indexDptCnm]);
					countD.add( new Integer(1));
					AmtD.add( new BigDecimal(exRate.doubleValue()*(new BigDecimal(result[i][indexRptAmt]).doubleValue())));
				}
				else{//add the known department counter & amount
					Integer intConv = (Integer)countD.get(indexDpt);
					BigDecimal doubConv = (BigDecimal)AmtD.get(indexDpt);

					countD.set(indexDpt, new Integer(intConv.intValue()+1));
					AmtD.set(indexDpt, new BigDecimal(doubConv.doubleValue()+ exRate.doubleValue()*(new BigDecimal(result[i][indexRptAmt]).doubleValue())));
				}
				//calculate the summary by insruance type
				if (indexInsrnc == -1) {// find a new insurance type
					insrncCde.add(result[i][indexInsrncCde]);
					insrncName.add(result[i][indexInsrncCnm]);
					countI.add( new Integer(1));
					AmtI.add( new BigDecimal(exRate.doubleValue()*(new BigDecimal(result[i][indexRptAmt]).doubleValue())));
				}
				else{//add the known insurance counter & amount
					Integer intConv = (Integer)countI.get(indexInsrnc);
					BigDecimal doubConv = (BigDecimal)AmtI.get(indexInsrnc);
					countI.set(indexInsrnc, new Integer(intConv.intValue()+1));
					AmtI.set(indexInsrnc, new BigDecimal(doubConv.doubleValue()+ exRate.doubleValue()*(new BigDecimal(result[i][indexRptAmt]).doubleValue())));
				}

			}//endfor
}//endif
%>
	<span class="unnamed3"><font color="#0066CC">机 构 小 计</font></span>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td">
				<tr bgcolor="#9DEEDE">
			<td align="center" width="58%">机构码</td>
			<td align="center" width="19%">业务单数量（笔数）</td>
			<td align="center" width="23%">金额(人民币）</td>
		</tr>
		<%
		int sumCountD = 0;//counter subtotal
		BigDecimal sumAmtD = new BigDecimal(0);//amount subtotal
		for (int i=0;i<dptCde.size();i++){
				sumCountD += ((Integer)countD.get(i)).intValue();
				sumAmtD = sumAmtD.add((BigDecimal)AmtD.get(i));%>
		<tr>
			<td align="center" width="58%"><%=dptName.get(i)%>(<%=dptCde.get(i)%>)&nbsp;</td>
			<td align="center" width="19%"><%=countD.get(i)%>&nbsp;</td>
			<td align="center" width="23%">
			<!-- =((BigDecimal)AmtD.get(i)).setScale(2,BigDecimal.ROUND_HALF_UP)
			//以下是苏锋更改的内容	-->				
			<%=util.fixedComma(((BigDecimal)AmtD.get(i)).setScale(2,BigDecimal.ROUND_HALF_UP).toString())%>
			&nbsp;</td>
		</tr>
		<%}%>
		<tr bgcolor="#9DEEDE">
			<td align="center" width="58%">总计：</td>
			<td align="center" width="19%"><%=sumCountD%>&nbsp;</td>
			<td align="center" width="23%">
			<!--//=sumAmtD.setScale(2,BigDecimal.ROUND_HALF_UP)
			//以下是苏锋更改的内容-->
			<%=util.fixedComma(sumAmtD.setScale(2,BigDecimal.ROUND_HALF_UP).toString())			%>
			&nbsp;</td>
		</tr>
	</table>
	<font color="#0066CC"><span class="unnamed3"> 险 种 小 计</span></font>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td">
		<tr bgcolor="#9DEEDE">
			<td align="center" width="58%">险种码</td>
			<td align="center" width="19%">业务单数量（笔数）</td>
			<td align="center" width="23%">金额（人民币）</td>
		</tr>
		<%
		int sumCountI = 0;//counter subtotal
		BigDecimal sumAmtI = new BigDecimal(0);//amount subtotal
		for (int i=0;i<insrncCde.size();i++){
				sumCountI += ((Integer)countI.get(i)).intValue();
				sumAmtI = sumAmtI.add((BigDecimal)AmtI.get(i));%>
		<tr>
			<td align="center" width="58%"><%=insrncName.get(i)%>(<%=insrncCde.get(i)%>)&nbsp;</td>
			<td align="center" width="19%"><%=countI.get(i)%>&nbsp;</td>
			<td align="center" width="23%">
			<!--//=((BigDecimal)AmtI.get(i)).setScale(2,BigDecimal.ROUND_HALF_UP)
			//以下是苏锋更改的内容-->			<%=util.fixedComma(((BigDecimal)AmtI.get(i)).setScale(2,BigDecimal.ROUND_HALF_UP).toString())%>
			&nbsp;</td>
		</tr>
		<%}%>
		<tr bgcolor="#9DEEDE">
			<td align="center" width="58%">总计：</td>
			<td align="center" width="19%"><%=sumCountI%>&nbsp;</td>
			<td align="center" width="23%">
			<%=util.fixedComma(sumAmtD.setScale(2,BigDecimal.ROUND_HALF_UP).toString())
			%>
			&nbsp;</td>
		</tr>
	</table>
</center>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><center><a href="Bus_List.jsp?sessionId=<%=Code.Encrypt(sessionId)%>">返回 </a> </center></p>
<%@ include file="public/bottom.jsp"%>
