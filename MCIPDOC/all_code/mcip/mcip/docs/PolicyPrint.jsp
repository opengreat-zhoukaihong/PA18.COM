<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> 打印 </TITLE>
<style type="text/css">
<!--
table {font-family : "宋体"; font-size : 10.5pt }
body { font-family : "宋体";   font-size : 10.5pt }
-->
</style>
</HEAD>
<BODY BGCOLOR="#FFFFFF" >
<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="session" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>

<%
				if (!Init.isInit())
				{
						Init.initAll();
				}

		String sessionId = "";
		SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();    ;
		int Locate = 0;

 System.out.println("B666666666666666&&&&****");
		HttpSession https = request.getSession(true);
		String sessionIdCurr = https.getId();

		sessionId = sessionIdCurr;

		Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
		if (Locate < 0)
		{
						throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);
		}

		String language = request.getParameter("language");
		if (language == null ||language.length() == 0)
			language = (String)request.getAttribute("language");
		String Result[] = sessionbuffer.getClientAddInfo(Locate);
			String orgID = Result[4];
		String departInfo[][] = null;
		try{
			sb.setFieldValue(Const.GET_DEPARTMENT,orgID);
			departInfo = sb.getRetValueArra();
		}catch(Exception e){
			departInfo = null;
		}
			Hashtable hashData = new Hashtable();
			hashData = ob.getHashData();
			String PlyNoDisp = Objects.getHt(hashData,"C_PLY_APP_NO");
			String TranType = Objects.getHt(hashData,"C_INSRNC_CDE");
			if(PlyNoDisp.equals(""))
				 PlyNoDisp = Objects.getHt(hashData,"C_PLY_NO");
%>
<%
String currencyInfo[][] = null;
String formPara[] = new String[1];
formPara[0] = Objects.getHt(hashData,"C_AMT_CUR");
try{
	sb.setFormPara(Const.GET_CURRENCY_INFO,formPara);
	currencyInfo = sb.getRetValueArra();
}catch(Exception e){
	currencyInfo = null;
}
	int indexCurNo=0,indexCurCnm=0,indexCurUnt=0,indexCurEnm=0,indexCurSbl=0,indexCurTthUnt=0,indexCurHthUnt=0;
if (currencyInfo != null && currencyInfo.length>0){
	indexCurNo = Objects.getColNum("C_CUR_NO",currencyInfo);//币种代码
	indexCurCnm = Objects.getColNum("C_CUR_CNM",currencyInfo);//币种中文名
	indexCurUnt = Objects.getColNum("C_CUR_UNT",currencyInfo);//中文单位
	indexCurEnm = Objects.getColNum("C_CUR_ENM",currencyInfo);//币种英文名
	indexCurSbl = Objects.getColNum("C_CUR_SBL",currencyInfo);//币种符号
	indexCurTthUnt = Objects.getColNum("C_CUR_TTH_UNT",currencyInfo);//
	indexCurHthUnt = Objects.getColNum("C_CUR_HTH_UNT",currencyInfo);  //中文单位
}

String amtCurCnm = currencyInfo[1][Objects.getColNum("C_CUR_CNM",currencyInfo)];
/*
	Enumeration ele = hashData.keys();
	for (int i=0;i<hashData.size();i++){
		out.println((String)(ele.nextElement())+"<br>");
	}
	*/
	String fixedAmt = new java.math.BigDecimal(Objects.getHt(hashData,"N_AMT")).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).toString();
	String fixedPrm = new java.math.BigDecimal(Objects.getHt(hashData,"N_PRM")).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).toString();

%>
<table bordercolor=#999999 cellspacing="3" cellpadding="0" width="90%" border="0" height="10" align="center">
<tr><td>&nbsp;</td></tr>
</table>
<table bordercolor=#999999 cellspacing="3" cellpadding="0" width="90%" border="0" height="100" align="center">
<tr>
	<td width="4%">&nbsp</td>
	<td width="96%" valign="top"><%=Objects.getHt(hashData,"C_INSRNT_NME")%></td>
</tr>
</table>
				<table bordercolor=#999999 cellspacing="3" cellpadding="0" width="90%" border="0" height="198" align="center">

		<tr>
				<td width="50%" height="28">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=PlyNoDisp%>
				 </td>
				<td rowspan="2" colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%=Objects.getHt(hashData,"C_PAY_ADDR")%><%if (TranType.equals(Const.C_EXPORT_CDE)){%> IN <%=currencyInfo[1][indexCurSbl]%><%}%>
				 </td>

		</tr>
		<tr>
				 <td width="50%" height="28">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<% if (Objects.getHt(hashData,"C_INVC_NO").trim().length() > 0)
				out.println(Objects.getHt(hashData,"C_INVC_NO"));
			else
				out.println(Objects.getHt(hashData,"C_RECEIPT_NO"));%>
					<br>&nbsp;
				</td>
		</tr>

		<tr>
			<td width="50%" height="28">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Objects.getHt(hashData,"C_SAIL_NO")%>
		<br>&nbsp;
			</td>
		<td rowspan="3" width="10%">
		</td>
			<td rowspan="3" width="40%">
	<%=StringTool.nl2br(Objects.getHt(hashData,"C_SRVY_CNM"))%>
			 </td>
		</tr>
		<tr>
			<td width="50%" height="28">
		<table  border="0" cellspacing="0" cellpadding="0" width="100%">
		<tr>
			<td width="15%">&nbsp;</td>
			<td width="30%" align="left"><%if (Objects.getHt(hashData,"C_PRN_FRM").trim().length() > 0) out.println(Objects.getHt(hashData,"C_PRN_FRM")); else out.println(StringTool.getDateString(Objects.getHt(hashData,"T_INSRNC_BGN_TM"),language));%></td>
			<td width="10%">&nbsp;</td>
			<td width="45%" align="left"><%=Objects.getHt(hashData,"C_FROM_PRT")%></td>
		</tr>
		</table>
		</td>
		</tr>
		<tr>
			<td width="50%" height="28">
		<table  border="0" cellspacing="0" cellpadding="0" width="100%">
			<tr>
				<td width="15%">&nbsp;</td><td align="left" width="30%">Via   <%=Objects.getHt(hashData,"C_PASS_PRT")%></td>
				<td width="10%">&nbsp;</td><td align="left" width="45%"><%=Objects.getHt(hashData,"C_TO_PRT")%></td>
			</tr>
		</table>
		 </td>
		</tr>
		<tr>
			<td  colspan="3">
			<table width="100%">
				<tr>
				 <td width="10%">
					&nbsp;
				 </td>
				 <td width="90%">
		<% if (language.equals("CHN")){%>
			<%=currencyInfo[1][indexCurSbl]+fixedAmt+"("+currencyInfo[1][indexCurCnm]+formMoney.getChn(fixedAmt)+")"%>
		<%}else{%>
			<%=currencyInfo[1][indexCurSbl]+fixedAmt+"("+currencyInfo[1][indexCurEnm]+" "+formMoney.getEng(fixedAmt)+")"%>
		<%}%>
				</td>
			</tr>
		</table>

			 </td>
		</tr>
		<tr height="410">
			 <td width="50%" valign="top">
	<br>
	<br>
	<br>
		<br><%=StringTool.nl2br(Objects.getHt(hashData,"C_CRGO_DESC"))%>
	</td>
		 <td width="50%" valign="top" colspan="2">
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<br><br>
	<table border="0" width="100%">
		<tr>
			<td width="10%">&nbsp</td>
			<td width="80%"><%=StringTool.nl2br(Objects.getHt(hashData,"C_UNDR_CNDTN")+"<br>"+Objects.getHt(hashData,"C_NO_REPAY"))%></td>
			<td width="10%">&nbsp</td>
	</table>
		 </td>
		</tr>
	</table>
	<table  border="0" cellspacing="0" cellpadding="0" width="90%" align="center">
	<tr>
		<td width="6%"></td>
		<td width="94%">
		<br>
			<%try{
				java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
				Date today = dateFormat.parse(Objects.getHt(hashData,"T_INSRNC_BGN_TM"));
				Date yesterday = DateTools.shiftDay(today,1,DateTools.DECREASE);
				out.println(StringTool.getDateString(yesterday,language));
				}catch (Exception e){
				}%>
			</td>
		</tr>
	</table>
<table border="0" height="210" width="90%" align="center">
<tr valign="bottom">
	<td width="45%">&nbsp;</td>
	<td width="55%">			
	<br>
	<%if(language.equals("ENG"))
					out.println(departInfo[1][Objects.getColNum("C_DPT_EADDR",departInfo)]+" "+Result[2]);
				else
					out.println(departInfo[1][Objects.getColNum("C_DPT_CADDR",departInfo)]+" "+Result[2]);
					%></td></tr>
</table>

<!--  <form>
				<div align="center">

 <input type="submit" name="print" value="打  印" onclick="javascript:window.print()">
<input type="button" value="关  闭" onclick='javascript:window.close();' >

</div>
	 </form>
-->
</BODY>
</HTML>
