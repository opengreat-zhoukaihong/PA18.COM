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
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>
<%if (!Init.isInit())
        {
            Init.initAll();
        }

    String sessionId = "";
    SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();    ;    
    int Locate = 0;
    HttpSession https = request.getSession(true);
    String sessionIdCurr = https.getId();

    sessionId = sessionIdCurr;
    Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionId);
    if (Locate < 0)
    {
            throw NormalExceptionHandler.Handle(Const.SYS_LOGIN_ERR_CDE,Const.SYS_LOGIN_ERR);            
    }

    String WarnMsg = "";

	String ClientName = sessionbuffer.getClientName(Locate);


      Hashtable hashData = new Hashtable();
      hashData = ob.getHashData();      
      String PlyNoDisp = Objects.getHt(hashData,"C_PLY_APP_NO");
      if(PlyNoDisp.equals(""))
         PlyNoDisp = Objects.getHt(hashData,"C_PLY_NO");
		 
		String PlyRdrInfo[][] = null;
      try{
		pb.setFieldValue(Const.GET_PLYRDRINFO,PlyNoDisp);
		PlyRdrInfo = pb.getRetValueArra();
		}
		catch(NormalException e){
			PlyRdrInfo = null;
		}
		String rdrCde = "";
		if (PlyRdrInfo != null && PlyRdrInfo.length>0)
			rdrCde = PlyRdrInfo[1][Objects.getColNum("C_RDR_CDE",PlyRdrInfo)];
	String fixedAmt = new java.math.BigDecimal(Objects.getHt(hashData,"N_AMT")).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).toString();
	String fixedPrm = new java.math.BigDecimal(Objects.getHt(hashData,"N_PRM")).setScale(2,java.math.BigDecimal.ROUND_HALF_UP).toString();

	%>      
<BODY BGCOLOR="#FFFFFF" onload=open("printPolicySLH.jsp");>
<%
/*
Enumeration enm = hashData.keys();
for (int i=0;i<hashData.size();i++)
		out.println(enm.nextElement()+"<br>");*/%>
     <p>&nbsp;</p>
     <p>&nbsp;</p>
     
      
<p align="right">&nbsp; </p>
<table width="96%" border="0" cellspacing="6" cellpadding="0">
  <tr>
    <td width="82%" height="22"> 
      <div align="right"></div>
    </td>
    <td width="18%" height="22"><%=PlyNoDisp%></td>
  </tr>
</table>
     
<p>&nbsp;</p>
<table width="96%" border="0" cellspacing="0" height="21">
  <tr>
    <td width="9%">&nbsp;</td>
    <td width="48%"><%=Objects.getHt(hashData,"C_INSRNT_NME")%></td>
    <td width="8%">&nbsp;</td>
    <td width="35%"><%=Objects.getHt(hashData,"C_APP_NME")%>
</td>
  </tr>
</table>
<table width="96%" border="0" cellpadding="0" cellspacing="4" height="172">
  <tr> 
    <td width="13%" height="30"> 
      <div align="center"> </div>
    </td>
    <td colspan="3" height="30" align="center"><%=Objects.getHt(hashData,"C_FROM_PRT")%> <%if (Objects.getHt(hashData,"C_PRN_FRM").trim().length() > 0) out.println(Objects.getHt(hashData,"C_PRN_FRM")); else out.println(Objects.getHt(hashData,"T_INSRNC_BGN_TM"));%></td>
    <td width="13%" height="30"> 
      <div align="center"> </div>
    </td>
    <td colspan="3" height="30" align="center"><%=Objects.getHt(hashData,"C_SAIL_NO")%></td>
  </tr>
  <tr> 
    <td width="13%" rowspan="2"> 
      <div align="center"></div>
    </td>
    <td width="21%" rowspan="2"> 
      <div align="center"></div>
    </td>
    <td width="11%" rowspan="2"> 
      <div align="center"></div>
    </td>
    <td width="16%" rowspan="2"> 
      <div align="center"></div>
    </td>
    <td width="13%" rowspan="2"> 
      <div align="center"></div>
    </td>
    <td height="31" colspan="2"> 
      <div align="center"></div>
    </td>
    <td width="11%" rowspan="2"> 
      <div align="center"></div>
    </td>
  </tr>
  <tr> 
    <td width="8%" height="28"> 
      <div align="center"></div>
    </td>
    <td width="7%" height="28"> 
      <div align="center"></div>
    </td>
  </tr>
  <tr> 
    <td width="13%" height="75">
      <div align="left"><% if (Objects.getHt(hashData,"C_INVC_NO").trim().length() > 0) 
				out.println(Objects.getHt(hashData,"C_INVC_NO")); 
			else 
				out.println(Objects.getHt(hashData,"C_RECEIPT_NO"));%></div>
    </td>
    <td width="21%" height="75">
      <div align="left"><%=StringTool.nl2br(Objects.getHt(hashData,"C_CRGO_DESC"))%>
	  </div>
    </td>
    <td width="11%" height="75">
      <div align="left"><%=Objects.getHt(hashData,"C_AMOUNT")%></div>
    </td>
    <td width="16%" height="75">
      <div align="left"><%=Objects.getHt(hashData,"C_TO_PRT")%></div>
    </td>
    <td width="13%" height="75">
      <div align="left"><%=fixedAmt%>元</div>
    </td>
    <td height="75" width="8%">
      <div align="right">
	 <%
		if(rdrCde.equals(Const.C_H_B03_CDE[1]))
		out.println(Double.valueOf(Objects.getHt(hashData,"N_RATE")).floatValue()*100);
	%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </td>
    <td height="75" width="7%">
      <div align="right">
	  <%
	  if(rdrCde.equals(Const.C_H_B03_CDE[0])) 
			out.println(Double.valueOf(Objects.getHt(hashData,"N_RATE")).floatValue()*100);
		%>
	 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </td>
    <td width="11%" height="75"><%=fixedPrm%>元</td>
  </tr>
</table>
<%
String moneyInteger[] = {"零","零","零","零","零"};
String moneyDecimal[] = {"零","零"};
String integerString = formMoney.getInteger(Objects.getHt(hashData,"N_PRM"));
String decimalString = formMoney.getDecimal(Objects.getHt(hashData,"N_PRM"));
for ( int i=0,j=4;i<5 && i<integerString.length();i++,j--){
		moneyInteger[j] = formMoney.trans1(integerString.substring(integerString.length()-i-1,integerString.length()-i));
}
for ( int i=0,j=1;i<2 && i<decimalString.length();i++,j--){
		moneyDecimal[j] = formMoney.trans1(decimalString.substring(decimalString.length()-i-1,decimalString.length()-i));
}
%>
<table width="96%" border="0" cellspacing="6" cellpadding="0">
  <tr> 
    <td height="32" width="328"> 
      <div align="right"><%=moneyInteger[0]%></div>
    </td>
    <td height="32" width="65"> 
      <div align="right"><%=moneyInteger[1]%></div>
    </td>
    <td height="32" width="52"> 
      <div align="right"><%=moneyInteger[2]%></div>
    </td>
    <td height="32" width="59"> 
      <div align="right"><%=moneyInteger[3]%></div>
    </td>
    <td height="32" width="64"> 
      <div align="right"><%=moneyInteger[4]%></div>
    </td>
    <td height="32" width="57"> 
      <div align="right"><%=moneyDecimal[0]%></div>
    </td>
    <td height="32" width="60"> 
      <div align="right"><%=moneyDecimal[1]%></div>
    </td>
    <td height="32" width="48">&nbsp;</td>
  </tr>
</table>
<table width="96%" border="0" cellspacing="6" cellpadding="0">
	<tr>
		<td width="75%">&nbsp;</td>
		<td width="25%"><%=ClientName%></td>
	</tr>
</table>
<br>
</BODY>
</HTML>
