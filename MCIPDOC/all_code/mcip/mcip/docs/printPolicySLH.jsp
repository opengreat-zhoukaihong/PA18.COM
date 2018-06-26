<%
/**
Modified Date:2001-11-7 10:35:23
By:L.K
Ref:LK0001
Purpose:print format adjustment
*/
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>平安货运保险</TITLE>
<style type="text/css">
<!--
table { font-size : 11pt }
body { font-family : "宋体";   font-size : 11pt }
-->
</style>
</HEAD>
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


		String Result[] = sessionbuffer.getClientAddInfo(Locate);

		Hashtable hashData = new Hashtable();
			hashData = ob.getHashData();
			String PlyNoDisp = Objects.getHt(hashData,"C_PLY_APP_NO");
			if(PlyNoDisp.equals(""))
				 PlyNoDisp = Objects.getHt(hashData,"C_PLY_NO");

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
	String fixedAmt = new java.math.BigDecimal(Objects.getHt(hashData,"N_AMT")).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).toString();
	String fixedPrm = new java.math.BigDecimal(Objects.getHt(hashData,"N_PRM")).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).toString();
	String fixedRate = new java.math.BigDecimal(Double.parseDouble(Objects.getHt(hashData,"N_RATE"))*100).setScale(4,java.math.BigDecimal.ROUND_HALF_UP).toString();

	%>
<BODY BGCOLOR="#FFFFFF">
<%/*
Enumeration enm = hashData.keys();
for (int i=0;i<hashData.size();i++)
		out.println(enm.nextElement()+"<br>");*/%>
			<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Objects.getHt(hashData,"C_INSRNT_NME")%></p>
			<p>&nbsp;</p><br>
 <table bordercolor=#999999 cellspacing="3" cellpadding="0" width="96%" border="0" height="198" align="center">

		<tr>
				<td width="50%" height="28">
	&nbsp;&nbsp;&nbsp;&nbsp;<%=PlyNoDisp%>
				 </td>
				<td>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Objects.getHt(hashData,"C_PAY_ADDR")%>
				 </td>

		</tr>
		<tr>
				<td width="50%" height="28">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <% if (Objects.getHt(hashData,"C_INVC_NO").trim().length() > 0)
				out.println(Objects.getHt(hashData,"C_INVC_NO"));
			else
				out.println(Objects.getHt(hashData,"C_RECEIPT_NO"));%>
				</td>
			 <td rowspan="4">
	<%=StringTool.nl2br(Objects.getHt(hashData,"C_SRVY_CNM"))%>
			 </td>
		</tr>
		<tr>
			 <td width="50%" height="28">
	&nbsp;&nbsp;&nbsp;&nbsp; <%=Objects.getHt(hashData,"C_SAIL_NO")%>
				</td>
		</tr>
		<tr>
			<td width="50%" height="28">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%if (Objects.getHt(hashData,"C_PRN_FRM").trim().length() > 0) out.println(Objects.getHt(hashData,"C_PRN_FRM")); else out.println(StringTool.getDateString(Objects.getHt(hashData,"T_INSRNC_BGN_TM"),"CHN"));%>&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Objects.getHt(hashData,"C_FROM_PRT")%>
		 </td>
		</tr>
		<tr>
			<td width="50%" height="28"><table  border="0" cellspacing="0" cellpadding="0" width="100%"><tr><td align = "left" width="40%">
	&nbsp;&nbsp;&nbsp;&nbsp;Via   <%=Objects.getHt(hashData,"C_PASS_PRT")%></td><td align="left" width="60%"	>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Objects.getHt(hashData,"C_TO_PRT")%>
	</td></tr></table>
		 </td>
		</tr>
		<tr>
			<td  colspan="2" height="28"><br>
				<table border="0">
					<tr>
					<td width="16%">
					&nbsp;
					</td>
					<td width="84%">
					<%=currencyInfo[1][indexCurSbl]+fixedAmt+"("+currencyInfo[1][indexCurCnm]+formMoney.getChn(fixedAmt)+")"%>
					</td>
					</tr>
				</table>
			 </td>
		</tr>
		 <tr>
			<td  colspan="2" height="28"><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=fixedRate%>%
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	<%=currencyInfo[1][indexCurSbl]+fixedPrm+"("+currencyInfo[1][indexCurCnm]+formMoney.getChn(fixedPrm)+")"%>

			 </td>
		</tr>
		<tr>
			 <td width="50%" valign="top">
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<br><%=StringTool.nl2br(Objects.getHt(hashData,"C_CRGO_DESC"))%>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
				</td>
		 <td width="50%" valign="top">
		<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<br><br><%=StringTool.nl2br(Objects.getHt(hashData,"C_UNDR_CNDTN")+"<br>"+Objects.getHt(hashData,"C_NO_REPAY"))%>
				</td>
		</tr>
	</table>
	<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <%try{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date today = dateFormat.parse(Objects.getHt(hashData,"T_INSRNC_BGN_TM"));
		Date yesterday = DateTools.shiftDay(today,1,DateTools.DECREASE);
		out.println(StringTool.getDateString(yesterday,"CHN"));
		}catch (Exception e){
		}%>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<!--LK0001-B
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;LK0001-E-->
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Result[0]+" "+Result[2]%>
</BODY>
</HTML>
