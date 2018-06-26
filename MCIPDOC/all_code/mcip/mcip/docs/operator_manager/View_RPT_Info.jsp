<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="pb"  scope="session" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : View_RPT_Info.jsp
*Directory : /data1/pa18/nul/mcip/public_html/operator_manager/
*URL : http://10.16.102.1:8800/operator_manager/View_RPT_Info.jsp
*Previous Page : Rpt_FlwUp_List.jsp
*Next Page : none (can only back to the previous page)
*Author : Lawrence Kang
*Created Date : 2000/10/12
*Last Updated : 2000/10/12
*Status : submited for test
*Function : I.Display the deatil information of selected report
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
String index = "";
String reportNo = "";
String result[][] = null;

int indexRptNo =0;
int indexAccdntTm =0;
int indexAccdntSpot =0;
int indexAccdntCaus =0;
int indexLosDtl =0;
int indexRptAmt =0;
int indexCurSbl =0;
int indexRptNme =0;
int indexRptAddrTel =0;

index = request.getParameter("index");
reportNo = request.getParameter("rptNoList"+index);

try
{
	pb.setFieldValue(Const.GET_CASERPTINFO,reportNo);
	result = pb.getRetValueArra();
}
catch(NormalException e)
{
//	if(NormalExceptionHandler.IsSevere(e))
//		throw NormalExceptionHandler.Handle(e);
	result = null;
}
%>

<div align="center"><font color="#0066CC" class="unnamed3">报案详细信息</font></div>
<table width="96%" border="1" cellspacing="0" cellpadding="0" align="center" class="td" bordercolor="#009999" bordercolorlight="#E6E6E6" height="140">

<%
if (result != null && result.length>1){
	indexRptNo = Objects.getColNum("C_RPT_NO",result);//赔案号
	indexAccdntTm = Objects.getColNum("T_ACCDNT_TM",result);//出险时间
	indexAccdntSpot = Objects.getColNum("C_ACCDNT_SPOT",result);//出险地点
	indexAccdntCaus = Objects.getColNum("C_ACCDNT_CAUS",result);//出险原因
	indexLosDtl = Objects.getColNum("C_LOS_DTL",result);//损失情况
	indexRptAmt = Objects.getColNum("N_RPT_AMT",result);//报损金额
	indexCurSbl = Objects.getColNum("C_CUR_SBL",result);//货币
	indexRptNme = Objects.getColNum("C_RPT_NME",result);//报案人
	indexRptAddrTel = Objects.getColNum("C_RPT_ADDR_TEL",result);//报案人地址电话
%>

<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		出险时间：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		</strong><%=result[1][indexAccdntTm]%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		出险地点：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		<%=result[1][indexAccdntSpot]%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		出险原因：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		<%=result[1][indexAccdntCaus]%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		损失情况：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		<%=result[1][indexLosDtl]%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		报险金额：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		<%=result[1][indexRptAmt]+"("+result[1][indexCurSbl]+")"%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		报案人：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		<%=result[1][indexRptNme]%>
	</td>
</tr>
<tr>
	<td bgcolor="#9DEEDE" width="19%"> 
		报案人地址电话：
	</td>
	<td bgcolor="#DFF9F3" width="81%">
		<%=result[1][indexRptAddrTel]%>
	</td>
</tr>
<%}else{%>
<tr>
	<td bgcolor="#9DEEDE" width="100%"> 
		<font color="red">没有查到报案的明细信息！</font>
	</td>
</tr>
<%}%>
</table>
	<div align="center">
	<form>
		<input type="button" value="返回" onclick="history.back()" title="返回上一页">
	</form>
	</div>
<%@ include file="public/bottom.jsp"%>