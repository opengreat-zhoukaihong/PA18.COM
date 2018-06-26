<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>
<jsp:useBean id="bb"  scope="page" class="beans.BusinessManagerBean"/> 
<jsp:setProperty name="bb" property="*"/>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>
<%
String userId =   sessionbuffer.getuserId(Locate);
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
double currCountSum = 0;
double summCountSum = 0;
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
int indexCurrCount = Objects.getColNum("CURR_COUNT",result);
int indexSummCount = Objects.getColNum("SUMM_COUNT",result);
%>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
	<%@ include file="public/PublicMemLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/Out_PlyTotal.gif" width="150" height="31" alt="业务统计结果">
<table width="96%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
  <tr bgcolor="#99FFFF" align="center"> 
    <td width="15%" bgcolor="#C0C0C0" align="center">业务类型</td>
    <td width="15%" bgcolor="#C0C0C0" align="center">本月保费(元)</td>
	<td width="15%" bgcolor="#C0C0C0" align="center">本月保额(元)</td>
	<td width="5%" bgcolor="#C0C0C0" align="center">本月笔数</td>
    <td width="15%" bgcolor="#C0C0C0" align="center">本年保费(元)</td>
    <td width="15%" bgcolor="#C0C0C0" align="center">本年保额(元)</td>
	<td width="5%" bgcolor="#C0C0C0" align="center">本年笔数</td>
    <td width="15%" bgcolor="#C0C0C0" align="center">平均费率</td>
  </tr>
  <%if (result != null && result.length>1){
			for(int i=1;i<result.length;i++){%>
			  <tr> 
				<td width="15%" align="right"><%=BConst.INSURANCE_CDE_CNM[1][Objects.getColNum(result[i][indexInsrncCde],BConst.INSURANCE_CDE_CNM)]%></td>
				<td width="15%" align="right"><%=StringTool.fixedComma(result[i][indexCurrPrm])%></td>
				<td width="15%" align="right"><%=StringTool.fixedComma(result[i][indexCurrAmt])%></td>
				<td width="5%" align="right"><%=result[i][indexCurrCount]%></td>
				<td width="15%" align="right"><%=StringTool.fixedComma(result[i][indexSummPrm])%></td>
				<td width="15%" align="right"><%=StringTool.fixedComma(result[i][indexSummAmt])%></td>
				<td width="5%" align="right"><%=result[i][indexSummCount]%></td>
				<td width="14%" align="right"><%=result[i][indexCurrAvg]%></td>
			  </tr>
  <%
			currentAmtSum += new Double(result[i][indexCurrPrm]).doubleValue();
			summaryAmtSum += new Double(result[i][indexSummPrm]).doubleValue();
			currentPrmSum += new Double(result[i][indexCurrAmt]).doubleValue();
			summaryPrmSum += new Double(result[i][indexSummAmt]).doubleValue();
			currCountSum += new Double(result[i][indexCurrCount]).doubleValue();
			summCountSum += new Double(result[i][indexSummCount]).doubleValue();
			}
	}//if%>
</table>
<table width="96%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
  <tr> 
    <td width="15%" bgcolor="#C0C0C0"> 
      <div align="center">总计</div>
    </td>
    <td width="15%" align="right"><%=StringTool.fixedComma(new Double(currentAmtSum).toString())%></td>
    <td width="15%" align="right"><%=StringTool.fixedComma(new Double(currentPrmSum).toString())%></td>
	<td width="5%" align="right"><%=StringTool.fixedComma(new Double(currCountSum).toString())%></td>
    <td width="15%" align="right"><%=StringTool.fixedComma(new Double(summaryAmtSum).toString())%></td>
    <td width="15%" align="right"><%=StringTool.fixedComma(new Double(summaryPrmSum).toString())%></td>
	<td width="5%" align="right"><%=StringTool.fixedComma(new Double(summCountSum).toString())%></td>
    <td width="15%" align="right">&nbsp;</td>
  </tr>
</table>
<p>
        <input type="button" value="前一页" name="B44" onClick='javascript:history.back();'>
      </p>
    </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   

</body>
</html>


