<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>
<%
String userId = StringTool.null2Blank(request.getParameter("userId"));
String type0 = StringTool.null2Blank(request.getParameter("type0"));
String type1 = StringTool.null2Blank(request.getParameter("type1"));
String type2 = StringTool.null2Blank(request.getParameter("type2"));
String type3 = StringTool.null2Blank(request.getParameter("type3"));
String type4 = StringTool.null2Blank(request.getParameter("type4"));
String type5 = StringTool.null2Blank(request.getParameter("type5"));
String year = request.getParameter("year");
String month = request.getParameter("month");
double currentAmtSum = 0;
double summaryAmtSum = 0;
double currentPrmSum = 0;
double summaryPrmSum = 0;
String formTable[][] = new String[3][6];
formTable[0][0] = userId;
formTable[1][0] = type0;
formTable[1][1] = type1;
formTable[1][2] = type2;
formTable[1][3] = type3;
formTable[1][4] = type4;
formTable[1][5] = type5;
for (int i=0;i<formTable[1].length;i++)
	if (formTable[1][i].length() == 0)
		formTable[1][i] = "ZZ";//unknown insurnace to match none
if (month.length() == 1)
	month = "0"+month;
formTable[2][0] = year+"-"+month;
String result[][] = null;
try{
	bb.setFormTable(BConst.GET_CUST_PLY_SUM,formTable);
	result = bb.getRetValueArra();
}catch(Exception e){
	result = null;
}
int indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",result);
int indexSummAmt = Objects.getColNum("SUMM_AMT",result);
int indexSummPrm = Objects.getColNum("SUMM_PRM",result);
int indexSummAvg = Objects.getColNum("SUMM_AVG",result);
int indexCurrAmt = Objects.getColNum("CURR_AMT",result);
int indexCurrPrm = Objects.getColNum("CURR_PRM",result);
int indexCurrAvg = Objects.getColNum("CURR_AVG",result);
%>

<SCRIPT LANGUAGE="JavaScript" SRC="../check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="../tool.js"></SCRIPT>
<br><p align="center">
   <font color="#0066CC" class="unnamed3">会员业务月统计结果 </font>
</p>
<table width="85%" border="1" cellspacing="0" cellpadding="0" class="td" bgcolor="#DFF9F3" align="center">
  <tr bgcolor="#9DEEDE"> 
    <td align="center" height="20" width="18%">业务类型</td>
    <td align="center" height="20" width="20%">本期保费</td>
    <td align="center" height="20" width="17%">累计保费</td>
    <td align="center" height="20" width="13%">本期保额</td>
    <td align="center" height="20" width="15%">累计保额</td>
    <td align="center" height="20" width="17%">平均费率</td>
  </tr>
  <%if (result != null && result.length>1){
			for(int i=1;i<result.length;i++){%>
			  <tr> 
				<td width="18%"><%=BConst.INSURANCE_CDE_CNM[1][Objects.getColNum(result[i][indexInsrncCde],BConst.INSURANCE_CDE_CNM)]%></td>
				<td width="20%"><%=new java.math.BigDecimal(result[i][indexCurrPrm]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%>(元)</td>
				<td width="17%"><%=new java.math.BigDecimal(result[i][indexSummPrm]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%>(元)</td>
				<td width="13%"><%=new java.math.BigDecimal(result[i][indexCurrAmt]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%>(元)</td>
				<td width="15%"><%=new java.math.BigDecimal(result[i][indexSummAmt]).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%>(元)</td>
				<td width="17%"><%=result[i][indexCurrAvg]%></td>
			  </tr>
  <%
			currentAmtSum += new Double(result[i][indexCurrPrm]).doubleValue();
			summaryAmtSum += new Double(result[i][indexSummPrm]).doubleValue();
			currentPrmSum += new Double(result[i][indexCurrAmt]).doubleValue();
			summaryPrmSum += new Double(result[i][indexSummAmt]).doubleValue();
			}
	}//if%>
</table>
<table width="85%" border="1" cellspacing="0" cellpadding="0" class="td" bgcolor="#DFF9F3" align="center">
  <tr> 
    <td width="18%" bgcolor="#9DEEDE"> 
      <div align="center">总计</div>
    </td>
    <td width="20%"><%=new java.math.BigDecimal(currentAmtSum).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%></td>
    <td width="17%"><%=new java.math.BigDecimal(summaryAmtSum).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%></td>
    <td width="13%"><%=new java.math.BigDecimal(currentPrmSum).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%></td>
    <td width="15%"><%=new java.math.BigDecimal(summaryPrmSum).setScale(2,java.math.BigDecimal.ROUND_HALF_UP)%></td>
    <td width="17%">&nbsp;</td>  </tr>
</table><%@ include file="public/bottom.jsp" %>



