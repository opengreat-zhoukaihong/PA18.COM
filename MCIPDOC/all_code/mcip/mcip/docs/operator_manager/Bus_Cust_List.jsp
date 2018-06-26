<%@ include file="public/up.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/>
<jsp:setProperty name="bb" property="*"/>
<jsp:useBean id="sb"  scope="page" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pm"  scope="session" class="beans.PageManagerBean"/>
<jsp:setProperty name="pm" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Bus_Cust_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/Bus_Cust_List.jsp
*Previous Page : Bus_Forward.jsp
*Next Page : none
*Author : Lawrence Kang
*Created Date : 2000-11-06
*Last Updated :
*Status : open
*Function : 列出客户清单和小计供操作员查看
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
		formTable[5][0] = oprCde;
		bb.setFormTable(BConst.GET_CUST_STATICS,formTable);
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
	<font color="#0066CC" class="unnamed3">客 户 清 单</font>
</div>
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="td" bgcolor="#DFF9F3" align="center">
	<tr bgcolor="#9DEEDE">
		<td align="center" height="33" width="10%">所属机构</td>
		<td align="center" height="33" width="10%">客户名称</td>
		<td align="center" height="33" width="9%">客户号</td>
		<td align="center" height="33" width="12%">联系电话</td>
		<td align="center" height="33" width="12%">电子邮件</td>
		<td align="center" height="33" width="15%">证件号码</td>
		<td align="center" height="33" width="24%">客户地址</td>
		<td align="center" height="33" width="8%">状态</td>
	</tr>
	<% if (result != null && result.length>1){
			int indexClntCde = Objects.getColNum("C_CLNT_CDE",result);
			int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
			int indexClntNme = Objects.getColNum("C_CLNT_NME",result);
			int indexTel = Objects.getColNum("C_TEL",result);
			int indexEmail = Objects.getColNum("C_EMAIL",result);
			int indexRgstNo = Objects.getColNum("C_RGST_NO",result);
			int indexProvince = Objects.getColNum("C_PROVINCE",result);
			int indexCity = Objects.getColNum("C_CITY",result);
			int indexPlace = Objects.getColNum("C_PLACE",result);
			int indexVerfy = Objects.getColNum("C_VERIFY",result);
			int indexDptCnm = Objects.getColNum("C_DPT_CNM",result);
			int indexProvinceCnm = Objects.getColNum("C_PROVINCE_CNM",result);
			int indexCityCnm = Objects.getColNum("C_CITY_CNM",result);
			for (int i=1;i<result.length;i++){%>
	<tr>
		<td align="center" width="10%"><%=result[i][indexDptCnm]%>&nbsp;</td>
		<td align="center" width="10%"><%=result[i][indexClntNme]%>&nbsp;</td>
		<td align="center" width="9%"><%=result[i][indexClntCde]%>&nbsp;</td>
		<td align="center" width="12%"><%=result[i][indexTel]%>&nbsp;</td>
		<td align="center" width="12%"><%=result[i][indexEmail]%>&nbsp;</td>
		<td align="center" width="15%"><%=result[i][indexRgstNo]%>&nbsp;</td>
		<td align="center" width="24%"><%//=result[i][indexProvinceCnm]%><%//=result[i][indexCityCnm]%><%=result[i][indexPlace]%>&nbsp;</td>
		<td align="center" width="8%"><%=BConst.CUST_STATUS[1][Objects.getColNum(result[i][indexVerfy],BConst.CLAIM_STATUS)]%>&nbsp;</td>
	</tr>
	<%	}
	}%>
</table>
	<!--
	B0002+
	-->
	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="td" align="center">
	<tr>
		<td align="center" align="left" width="30%">
		<%if (pNo.intValue()>0){%>
		<a href="Bus_Cust_List.jsp?numStr=<%=pNo.toString(0)%>">[首    页]</a>
		<a href="Bus_Cust_List.jsp?numStr=<%=pNo.toString(pNo.intValue()-1)%>">[上一页]</a>
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
		<td align="center" align="right" width="30%">
		<%if (pNo.intValue() < pm.getTotalPage()-1){%>
		<a href="Bus_Cust_List.jsp?numStr=<%=pNo.toString(pNo.intValue()+1)%>">[下一页]</a>
		<a href="Bus_Cust_List.jsp?numStr=<%=pm.getTotalPage()-1%>">[末    页]</a>
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
	<%
		Vector  dptCde = new Vector();//机构码
		Vector  dptName = new Vector();//机构名称
		Vector countD = new Vector();//业务数量（根据机构码排序）
//		Vector AmtD = new Vector();//金额（根据机构码排序）

//		Vector insrncCde = new Vector();
//		Vector insrncName = new Vector();//险种
//		Vector countI = new Vector();//业务数量（根据险种码排序）
//		Vector AmtI = new Vector();//金额（根据险种码排序）

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
			int indexClntCde = Objects.getColNum("C_CLNT_CDE",result);
			int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
			int indexClntNme = Objects.getColNum("C_CLNT_NME",result);
			int indexTel = Objects.getColNum("C_TEL",result);
			int indexEmail = Objects.getColNum("C_EMAIL",result);
			int indexRgstNo = Objects.getColNum("C_RGST_NO",result);
			int indexProvince = Objects.getColNum("C_PROVINCE",result);
			int indexCity = Objects.getColNum("C_CITY",result);
			int indexPlace = Objects.getColNum("C_PLACE",result);
			int indexVerfy = Objects.getColNum("C_VERIFY",result);
			int indexDptCnm = Objects.getColNum("C_DPT_CNM",result);
			int indexProvinceCnm = Objects.getColNum("C_PROVINCE_CNM",result);
			int indexCityCnm = Objects.getColNum("C_CITY_CNM",result);
			for (int i=1;i<result.length;i++){
				/**
				//get exchange rate for current policy
				BigDecimal exRate =new BigDecimal(1);
				if (exchangeList != null && exchangeList.length > 1){
					int indexCurNo1 = Objects.getColNum("C_CUR_NO_1",exchangeList);
					int indexCurNo2 = Objects.getColNum("C_CUR_NO_2",exchangeList);
					int indexEffcTm = Objects.getColNum("T_EFFC_TM",exchangeList);
					int indexChgRte = Objects.getColNum("N_CHG_RTE",exchangeList);
					for (int j=1;j<exchangeList.length;j++){
						if (exchangeList[j][indexCurNo1].equals(result[i][indexPrmCur])){
							exRate = new BigDecimal(exchangeList[j][indexChgRte]);
							break;
						}//endif
					}//endfor
				}//endif
				*/
				indexDpt = dptCde.indexOf(result[i][indexDptCde]);
//				indexInsrnc = insrncCde.indexOf(result[i][indexInsrncCde]);
				//calculate the summary by department
				if (indexDpt == -1) {//find a new department
					dptCde.add(result[i][indexDptCde]);
					dptName.add(result[i][indexDptCnm]);
					countD.add( new Integer(1));
//					AmtD.add( new BigDecimal(exRate.doubleValue()*(new BigDecimal(result[i][indexNPrm]).doubleValue())));
				}
				else{//add the known department counter & amount
					Integer intConv = (Integer)countD.get(indexDpt);
//					BigDecimal doubConv = (BigDecimal)AmtD.get(indexDpt);

					countD.set(indexDpt, new Integer(intConv.intValue()+1));
	//				AmtD.set(indexDpt, new BigDecimal(doubConv.doubleValue()+ exRate.doubleValue()*(new BigDecimal(result[i][indexNPrm]).doubleValue())));
				}
				//calculate the summary by insruance type
				/**
				if (indexInsrnc == -1) {// find a new insurance type
					insrncCde.add(result[i][indexInsrncCde]);
					insrncName.add(result[i][indexInsrncCnm]);
					countI.add( new Integer(1));
					AmtI.add( new BigDecimal(exRate.doubleValue()*(new BigDecimal(result[i][indexNPrm]).doubleValue())));
				}
				else{//add the known insurance counter & amount
					Integer intConv = (Integer)countI.get(indexInsrnc);
					BigDecimal doubConv = (BigDecimal)AmtI.get(indexInsrnc);
					countI.set(indexInsrnc, new Integer(intConv.intValue()+1));
					AmtI.set(indexInsrnc, new BigDecimal(doubConv.doubleValue()+ exRate.doubleValue()*(new BigDecimal(result[i][indexNPrm]).doubleValue())));
				}
				*/
			}//endfor
}//endif
%>
	<span class="unnamed3"><font color="#0066CC">机 构 小 计</font></span>
	<table width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor="#DFF9F3" class="td">
				<tr bgcolor="#9DEEDE">
			<td align="center" width="21%">机构码</td>
			<td align="center" width="27%">客户数量</td>
		</tr>
		<%
		int sumCountD = 0;//counter subtotal
		BigDecimal sumAmtD = new BigDecimal(0);//amount subtotal
		for (int i=0;i<dptCde.size();i++){
				sumCountD += ((Integer)countD.get(i)).intValue();
//				sumAmtD = sumAmtD.add((BigDecimal)AmtD.get(i));%>
		<tr>
			<td align="center" width="21%"><%=dptName.get(i)%>(<%=dptCde.get(i)%>)&nbsp;</td>
			<td align="center" width="27%"><%=countD.get(i)%>&nbsp;</td>
		</tr>
		<%}%>
		<tr bgcolor="#9DEEDE">
			<td align="center" width="21%">总计：</td>
			<td align="center" width="27%"><%=sumCountD%>&nbsp;</td>
		</tr>
	</table>
</center>
<p>&nbsp;</p>
<p><center><a href="Bus_List.jsp">返回 </a></center></p>
<%@ include file="public/bottom.jsp"%>
