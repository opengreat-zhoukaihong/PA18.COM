<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="pb"  scope="request" class="beans.PaymentManagerBean"/>

<jsp:setProperty name="pb" property="*"/>

<%
//get parameters to the previous page
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
String fromInsuranceCode = request.getParameter("fromInsuranceCode");
String toInsuranceCode = request.getParameter("toInsuranceCode");
String dpt = request.getParameter("dpt");
java.util.StringTokenizer token = new java.util.StringTokenizer(dpt,"&",true);
dpt = token.nextToken();
token.nextToken();
String dptName = token.nextToken();
String [] dptList = {dpt};

//prepare the parameters for the query of the payment info
	String[][]  result = null;
		java.lang.Object formParaObj[] = new java.lang.Object[6];
		String blankString = "";
		  formParaObj[0] = fromYear+"-"+fromMonth+"-"+fromDay;
		  formParaObj[1] = toYear+"-"+toMonth+"-"+toDay;
		  formParaObj[2] = dptList;
		  formParaObj[3] = fromInsuranceCode;
		  formParaObj[4] = toInsuranceCode;
		  formParaObj[5] = "";
			try{
				pb.setFormParaObj(constant.PConst.GET_DPT_PAY_LIST,formParaObj);
				result = pb.getRetValueArra();
			}catch(Exception e){
				result = null;
			}
int indexPlyNo = Objects.getColNum("C_PLY_NO",result);
int indexPlyAppNo = Objects.getColNum("C_PLY_APP_NO",result);
int indexDptCde = Objects.getColNum("C_DPT_CDE",result);
int indexInsrncCde = Objects.getColNum("C_INSRNC_CDE",result);
int indexPrm = Objects.getColNum("N_PRM",result);
int indexPrmCur = Objects.getColNum("C_PRM_CUR",result);
int indexInsrntNme = Objects.getColNum("C_INSRNT_NME",result);
int indexUndrTm = Objects.getColNum("T_UNDR_TM",result);
int indexInsrncCnm = Objects.getColNum("C_INSRNC_CNM",result);
int indexCurSbl = Objects.getColNum("C_CUR_SBL",result);
%>
<h1 align="center">机构对帐清单</h1>
<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">
		<tr>
		<td width="10%">机构名称:</td><td width="70%"><%=dptName%></td><td width="7%">险种:</td><td width="13%">从 <%=fromInsuranceCode%><br>至 <%=toInsuranceCode%></td>
	</tr>
	<tr>
		<td width="10%">出单日期:</td>
		<td width="70%"><%=fromMonth%>/<%=fromDay%>/<%=fromYear%> --<%=toMonth%>/<%=toDay%>/<%=toYear%></td>
		<td width="7%">页码:</td>
		<td width="13%">&nbsp;</td>
	</tr>
</table>
<table width="90%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">

	<tr bgcolor="#9DEEDE">
		<td>出单日期</td><td>险种</td><td>保单号</td><td>投保单号</td><td>实收保费</td><td>币种</td><td>被保险人</td>
	</tr>
	<%if (result != null && result.length>1){
			for(int i=1;i<result.length;i++){
	%>
	<tr>
		<td><%=result[i][indexUndrTm].substring(0,10)%></td>
		<td><%=result[i][indexInsrncCnm]%> </td>
		<td><%=result[i][indexPlyNo]%></td>
		<td><%=result[i][indexPlyAppNo]%></td>
		<td><%=result[i][indexPrm]%></td>
		<td><%=result[i][indexCurSbl]%></td>
		<td><%=result[i][indexInsrntNme]%></td>
	</tr>
	<%}//end for
		}//end if
	%>
</table>
<table width="90%" border="0" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6">

	<td width="25%">经理:</td>
	<td width="25%">复核:</td>
	<td width="25%">制表:</td>
	<td width="25%">制表日期:</td>
</table>
<%@ include file="public/bottom.jsp"%>