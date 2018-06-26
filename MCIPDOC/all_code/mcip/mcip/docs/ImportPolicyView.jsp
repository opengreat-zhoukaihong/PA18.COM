<html>
<head>
<title>保单打印预览</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">


<%@ include file="public/Public.jsp" %>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/>
<jsp:setProperty name="pmb" property="*"/>
<%
			String language = (String)request.getAttribute("language");
		if(language == null || language.length() == 0)
		language = request.getParameter("language");
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
		Enumeration ep =hashData.keys();
			/*while(ep.hasMoreElements())
			{   String key =(String)(ep.nextElement());
				out.println(key+":"+(String)hashData.get(key));
			out.println("<p>");
		}*/
	//to be get insrnce info :main and addtion
			String InsrncName = "";
			String PlyAppRdrInfo[][] = null;

		boolean PolicyYes = false;
		if(!Objects.getHt(hashData,"C_PLY_NO").equals("")){
			PolicyYes = true;
		}

			String PlyNoDisp = Objects.getHt(hashData,"C_PLY_APP_NO");
			if(PlyNoDisp.equals(""))
				 PlyNoDisp = Objects.getHt(hashData,"C_PLY_NO");
			if(PlyNoDisp.equals(""))
				 PlyNoDisp = pmb.plyEdrAppInfo.c_edr_app_no;
			String ClientType = sessionbuffer.getClientType(Locate);

%>
<%@ include file="PublicPly_ViewXmlsend.jsp" %>
<%

		String FromApp=(String)(request.getAttribute("FromApp"));

	 if(FromApp != null && FromApp.equals("PlyEdrApp")){
		 PlyAppRdrInfo=  pmb.plyEdrAppRdrInfo.edrapprdr;
		 PolicyYes = false;
	 }else{
		try
		{
				pb.setFieldValue(Const.GET_PLYAPPRDRINFO,PlyNoDisp);
				PlyAppRdrInfo = pb.getRetValueArra();

		}
		catch(NormalException e)
		{
	//if(NormalExceptionHandler.IsSevere(e))
	 //   throw NormalExceptionHandler.Handle(e);
	//else if(NormalExceptionHandler.IsWarning(e))
		//  WarnMsg = e.getErrDesc();

		}
	}

	int c_rdr_nme =  Objects.getColNum("c_rdr_nme",PlyAppRdrInfo);
	int RdrLen = Servlets.getLen(PlyAppRdrInfo);
	if(RdrLen > 1)
	{
		for(int i = 1; i < RdrLen; i++)
		{
				InsrncName = InsrncName + ":" + PlyAppRdrInfo[i][c_rdr_nme];
		}
	}
%>
<%
			String TranType = Objects.getHt(hashData,"C_INSRNC_CDE");
			String Transit[] = new String[1];
			String TransitName = "";
System.out.println("in viewpolicy TranType:"+TranType);
			if(TranType.equals(Const.C_EXPORT_CDE))//outport
			{
					TranType = Const.C_EXPORT_CNM;
			}
			else if(TranType.equals(Const.C_IMPORT_CDE))//import
			{
					TranType = Const.C_IMPORT_CNM;
			}
			else
			{
					TransitName = Objects.getValue(1,TranType,Const.HOME_TRANSIT);
System.out.println("home TransitName:"+TransitName);
					FrmPrtName = "";
					ToPrtName = "";
					TranType = Const.C_HOME_CDE;
			}

			if(!TranType.equals(Const.C_HOME_CDE))
			{
System.out.println("is port transit");
				Transit = new String[Const.PORT_TRANSIT_LEN];
				Transit = Servlets.GetInsrncAddtion(PlyAppRdrInfo,Transit);
				for(int k=0;k<Const.PORT_TRANSIT_LEN;k++)
				{
					 if(!(Transit[k] == null || Transit[k].equals("")))
					 {
							 TransitName = TransitName + Objects.getValue(1,String.valueOf(k),Const.PORT_TRANSIT);
					 }
				}

			}

			if(!AmtCurName.equals(""))
				 AmtCurName = "("+AmtCurName+")";

			 String[][]TempArra = {{"AMT_CUR_NAME"},{AmtCurName}};
			 ob.setFormDataAdd(TempArra);

%>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
	<tr>
<%
if(MenuRef.equals("FindPly"))
{
%>
<%@ include file="public/PublicInquireLeft.jsp" %>
<%
}
else
{
%>
<%@ include file="public/PublicPlyLeft.html" %>

<%
}
%>
		<td width="613"  valign="top">
			<div align=right>
<%
	String insrncCde = Objects.getHt(hashData,"C_INSRNC_CDE");
	String printPage = "";
	//进出口
	if (insrncCde.equals(Const.C_IMPORT_CDE) || insrncCde.equals(Const.C_EXPORT_CDE)){
		printPage = "PolicyPrint.jsp";
	}
	//国内航空、水路、陆路
	if(insrncCde.equals(Const.C_ROAD_CDE) || insrncCde.equals(Const.C_WATER_CDE) || insrncCde.equals(Const.C_H_AVIATION_CDE)){
		printPage = "printPolicySLH.jsp";
	}
	//国内铁路
	if(insrncCde.equals(Const.C_RAILAGE_CDE)){
		printPage = "printPolicyT.jsp";
	}

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

%>
<%
String Preview = (String)request.getAttribute("Preview");
//directly forward to the print page(no preview)
if (Preview != null && Preview.equals("0")){
	//进出口
	if (insrncCde.equals(Const.C_IMPORT_CDE) || insrncCde.equals(Const.C_EXPORT_CDE)){%>
		<jsp:forward page="PolicyPrint.jsp"/>
	<%}
	//国内航空、水路、陆路
	if(insrncCde.equals(Const.C_ROAD_CDE) || insrncCde.equals(Const.C_WATER_CDE) || insrncCde.equals(Const.C_H_AVIATION_CDE)){%>
	<jsp:forward page="printPolicySLH.jsp"/>
	<%}
	//国内铁路
	if(insrncCde.equals(Const.C_RAILAGE_CDE)){%>
		<jsp:forward page="printPolicyT.jsp"/>
	<%}
}
%>
<form name="printaim" action="<%=printPage%>" method="post" target="_blank" >
		<input type="hidden" name="C_DOC_NO" value="<%=PlyNoDisp%>">
	<input type="hidden" name="language" value="<%=language%>">
<table border="0" width="760" cellspacing="0" cellpadding="0">
	<tr>
		<td width="11%" valign="top">
			<p align="right"><img border="0" src="images/palogo-01.gif" width="60" height="60"></td>
		<td width="61%">
			<p align="center"><b><font size="6" face="幼圆">中国平安保险股份有限公司</font><br>
			</b><font face="MS Sans Serif" size="3"><b>PING AN INSURANCE COMPANY OF CHINA, LTD.<br>
			</b></font><font face="楷体_GB2312" size="4">
			货&nbsp; 物&nbsp; 运&nbsp; 输&nbsp; 保&nbsp; 险&nbsp; 单<br>
			</font><b><br>
			CARGO TRANSPORTATION INSURANCE POLICY</b></td>
		<td width="28%" valign="top">
			<p align="left"><b><font face="宋体" size="2">总公司地址：</font></b><br>
			<font size="2">
			<font face="宋体">中国.深圳</font><br/>
			<font face="宋体">八卦岭八卦三路平安大厦</font><br>
			<font face="宋体">电话(Tel):0755-2262888</font><br>
			<font face="宋体">图文传真（Fax):0755-2431039</font><br>
			<font face="宋体">邮政编码（PostCode):518029</font><br>
			<font face="宋体">Address of Head Office:<br>
			Ping An
			Buiding,No.3 Ba Gua Road,<br>
			Ba Gua Ling,Shenzhen,China</font></font></td>
	</tr>
</table>
<!--Table for the insured name-->
<table border="0" width="760">
	<tr>
		<td width="9%"><font face="宋体" size="2">被保险人<br>Insured:</font></td>
		<td width="91%"><font face="宋体" size="2" color="blue"><%=Objects.getHt(hashData,"C_INSRNT_NME")%></font></td>
	</tr>
</table>
<!--Table for the claim-->
<table border="0" width="760">
	<tr>
		<td width="100%" valign="bottom"><font face="宋体" size="2">&nbsp;&nbsp;&nbsp;&nbsp;<b>中国平安保险股份有限公司</b>根据被保险人的要求及其所支付约定的保险费，按照本保险单背面所载条款与下列特款，承保下述货物运输保险，特立本保单。</font></td>
	</tr>
	<tr>
		<td width="100%"><font face="宋体" size="2">&nbsp;&nbsp;&nbsp;&nbsp; This Policy of
			Insurance witnesses that PING AN INSURANCE COMPANY OF CHINA,LTD., at the
			request of the Insured and in consideration of the agreed premium paid by
			the Insured, undertakes to insure the undermetioned goods in
			transportation subject to the conditions of Policy as per the clauses
			printed overleaf and other special clauses attached hereon.</font></td>
	</tr>
</table>
<div align="left">
	<table border="0" width="760" cellspacing="0" cellpadding="0" height="8">
		<tr>
			<td width="760" height="1" colspan="6">
			<hr size="1">
			</td>
		</tr>
		<tr>
			<td width="113" height="26"><font face="宋体" size="2">保单号</font><font face="宋体" size="1"><br>
			</font><font face="宋体" size="2">
			Policy No</font><font face="宋体" size="1">.</font></td>
			<td width="277" height="26" colspan="3"><font face="宋体" size="2" color="blue"><%if(PolicyYes){%><%=PlyNoDisp%><%}%></font></td>
			<td width="120" height="26"><font face="宋体" size="2">赔款偿付地点</font><font face="宋体" size="1"><br>
			</font><font face="宋体" size="2">
			Claim Payable at</font></td>
			<td width="260" height="66" rowspan="3" valign="top"><font face="宋体" size="2" color="blue"><%=Objects.getHt(hashData,"C_PAY_ADDR")%></font></td>
		</tr>
		<tr>
			<td width="390" height="1" colspan="4">
			<hr size="1" width="95%" align="left">
			</td>
			<td width="120" height="1">　</td>
		</tr>
		<tr>
			<td width="113" height="39"><font face="宋体" size="2">发票或提单号<br>
			Invoice No.or B/L.N</font><font face="宋体" size="1">o.</font></td>
			<td width="277" height="39" colspan="3"><font face="宋体" size="2" color="blue">
		<% if (Objects.getHt(hashData,"C_INVC_NO").trim().length() > 0)
				out.println(Objects.getHt(hashData,"C_INVC_NO"));
			else
				out.println(Objects.getHt(hashData,"C_RECEIPT_NO"));%></font></td>
			<td width="120" height="39">　</td>
		</tr>
		<tr>
			<td width="390" height="19" colspan="4">
			<hr size="1" width="95%" align="left">
			</td>
			<td width="402" height="19" colspan="2">
			<hr size="1" align="left">
			</td>
		</tr>
		<tr>
			<td width="113" height="39"><font face="宋体" size="2">运输工具<br>
			Per Conveyance S.S</font></td>
			<td width="277" height="39" colspan="3"><font face="宋体" size="2" color="blue"><%=Objects.getHt(hashData,"C_SAIL_NO")%></font></td>
			<td width="120" height="39"><font face="宋体" size="2">查勘代理人<br>
			Survey By</font></td>
			<td width="282" height="129" rowspan="5" valign="top"><font face="宋体" size="2" color="blue"><%=StringTool.nl2br(Objects.getHt(hashData,"C_SRVY_CNM"))%></font></td>
		</tr>
		<tr>
			<td width="390" height="19" colspan="4">
			<hr size="1" width="95%" align="left">
			</td>
			<td width="120" height="19">　</td>
		</tr>
		<tr>
			<td width="113" height="26"><font face="宋体" size="2">起运日期<br>
				Slg. On or abt.</font></td>
			<td width="105" height="26"><font face="宋体" size="2" color="blue">
		<%if (Objects.getHt(hashData,"C_PRN_FRM").trim().length() > 0)
			out.println(Objects.getHt(hashData,"C_PRN_FRM"));
		else
			out.println(StringTool.getDateString(Objects.getHt(hashData,"T_INSRNC_BGN_TM"),language));%>
</font></td>
			<td width="33" height="26"><font face="宋体" size="2">自<br>
			From</font></td>
			<td width="139" height="26"><font face="宋体" size="2" color="blue"><%=Objects.getHt(hashData,"C_FROM_PRT")%></font></td>
			<td width="120" height="26">　</td>
		</tr>
		<tr>
			<td width="390" height="19" colspan="4">
			<hr size="1" align="left" width="95%">
			</td>
			<td width="120" height="19">　</td>
		</tr>
		<tr>
			<td width="113" height="26">途经<br>Via</td>
			<td width="105" height="26"><font color="blue"><%=Objects.getHt(hashData,"C_PASS_PRT")%></font></td>
			<td width="33" height="26"><font face="宋体" size="2">至<br>
			To</font></td>
			<td width="139" height="26"><font face="宋体" size="2" color="blue"><%=Objects.getHt(hashData,"C_TO_PRT")%></font></td>
			<td width="120" height="26">　</td>
		</tr>
		<tr>
			<td width="390" height="19" colspan="4">
			<hr size="1" width="95%" align="left">
			</td>
			<td width="402" height="19" colspan="2">
			<hr size="1" width="95%" align="left">
			</td>
		</tr>
		<tr>
			<td width="113" height="26"><font face="宋体" size="2">保险金额<br>
			Amount Insured</font></td>
			<td width="679" height="26" colspan="5"><font face="宋体" size="2" color="blue">
		<% if (language.equals("CHN")){%>
			<%=currencyInfo[1][indexCurSbl]+fixedAmt+"("+currencyInfo[1][indexCurCnm]+formMoney.getChn(fixedAmt)+")"%>
		<%}else{%>
			<%=currencyInfo[1][indexCurSbl]+fixedAmt+"("+currencyInfo[1][indexCurEnm]+" "+formMoney.getEng(fixedAmt)+")"%>
		<%}%>

		</tr>
		<tr>
			<td width="792" height="1" colspan="6">
			<hr size="1" align="left">
			</td>
		</tr>
	</table>
</div>

<table border="0" width="760" height="311" cellspacing="0" cellpadding="0">
	<tr>
		<td width="50%" height="26"><font face="宋体" size="2">保险货物项目、标记、数量及包装<br>
			Description, Marks, Quantity &amp; Packing of Goods</font></td>
		<td width="50%" height="26"><font face="宋体" size="2">承保条件<br>
			Conditions</font></td>
	</tr>
	<tr>
		<td width="50%" height="273" valign="top"><br><font size="2" color="blue"><%=StringTool.nl2br(Objects.getHt(hashData,"C_CRGO_DESC"))%></font></td>
		<td width="50%" height="273" valign="top"><br><font size="2" color="blue"><%=StringTool.nl2br(Objects.getHt(hashData,"C_UNDR_CNDTN")+"<br>"+Objects.getHt(hashData,"C_NO_REPAY"))%></font></td>
	</tr>
</table>
<table width="778" border="0" cellspacing="0" cellpadding="0">
	<tr><td width="15%"><font face="宋体" size="2">&nbsp;&nbsp;&nbsp; 签单日期<br>
&nbsp;&nbsp;&nbsp; Date</font></td><td width="85%" align="left"><font color="blue"><%try{
		java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date today = dateFormat.parse(Objects.getHt(hashData,"T_INSRNC_BGN_TM"));
		Date yesterday = DateTools.shiftDay(today,1,DateTools.DECREASE);
		out.println(StringTool.getDateString(yesterday,language));
		}catch (Exception e){
		}%></font></td></tr>
</table>
<table width="778" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="20%">
			&nbsp;&nbsp;&nbsp; 地址及电话<br>
			&nbsp;&nbsp;&nbsp; Address&Tel
		</td>
		<td width="80%">
			<font color="blue">
			<%if(language.equals("ENG"))
					out.println(departInfo[1][Objects.getColNum("C_DPT_EADDR",departInfo)]+" "+Result[2]);
				else
					out.println(departInfo[1][Objects.getColNum("C_DPT_CADDR",departInfo)]+" "+Result[2]);
					%></font>
		</td>
	</tr>
</table>

	<p align="center">
		<input type="hidden" name="orgID" value="<%=orgID%>">
	<input type="hidden" name="ClientType" value="<%=ClientType%>">
		<%
		 if(FromApp!=null && (FromApp.equals("PlyApp")||FromApp.equals("PlyEdrApp"))){%>
		 <input type="hidden" name="FromApp" value="<%=FromApp%>">
		 <input type="button" value="同  意" name="button2" onClick="AcceptForm(this.form)">
		 <input type="button" value="修  改" name="button3" onClick="ModifyForm(this.form)">
		 <input type=hidden name="AGENCYNO", value="<%=Const.FIND%>">
		 <input type=hidden name="C_PLY_NO" value="<%=PlyNoDisp%>">
		 <input type="hidden" name="OPER" value="PLYAPPNEW">
	<%}%>
	<input type="hidden" name="insuranceID" value="<%=Objects.getHt(hashData,"C_INSRNC_CDE")%>">
	<%if(FromApp==null){%>  <input type="button" value="在线咨询" name="button1" onclick="OpenChat(this.form)"><%}%>
<% if((ClientType.equals(Const.CUST_AG) || ClientType.equals(Const.CUST_OC)) &&(FromApp==null)){
		 if(PolicyYes){
%>
	 <input type="submit" value="打 印" name="B88">
<%}}%>
 <%if(FromApp==null){%> <input type="button" value="前一页" name="B44" onclick='javascript:history.back();'><%}%>
</p>
	</form>

<% String clientName = sessionbuffer.getuserId(Locate); %>
<%@ include file="public/PublicBottom.html" %>

</body>
</html>
<script language=JavaScript>
function OpenChat(theForm){

	subject = theForm.C_DOC_NO.value ;
href = "meeting/ClientLogin.jsp?user=<%=clientName%>&sub="+subject+"&orgID=<%=orgID%>&insuranceID=<%=Objects.getHt(hashData,"C_INSRNC_CDE")%>";
	js_openClientSmallPage(href);
}
function ModifyForm(theForm){
	 if(theForm.FromApp.value== "PlyApp"){
		theForm.action = "InputPolicy.jsp";
	 }else if(theForm.FromApp.value== "PlyEdrApp"){
		 if("<%=Objects.getHt(hashData,"C_OPEN_COVER_NO")%>".length>0){
		 theForm.action = "Policy_OC.jsp";
		 }else{
		theForm.action = "PolicyC.jsp";
		 }
	 }
	 theForm.target ="";
	 theForm.submit();
}
function AcceptForm(theForm){
	if("<%=Objects.getHt(hashData,"C_OPEN_COVER_NO")%>".length>0){
		 if(theForm.FromApp.value== "PlyApp"){
			 theForm.action = "AcceptNotice.jsp";
			}else if(theForm.FromApp.value== "PlyEdrApp"){
				theForm.action = "AcceptPolicy.jsp";
			}
	}else{
	     if(theForm.FromApp.value== "PlyApp"){
		    if(theForm.ClientType.value=="<%=Const.CUST_AG%>"){
			 theForm.action = "AcceptPlyApp.jsp";
            }else{
			   theForm.action = "Proposal.jsp";
			}
		 }else if(theForm.FromApp.value== "PlyEdrApp"){
		     theForm.action = "AcceptPolicy.jsp";
		 }
	}
	/*else if(theForm.ClientType.value=="<%=Const.CUST_AG%>"){
		 if(theForm.FromApp.value== "PlyApp"){
			 theForm.action = "AcceptPlyApp.jsp";
		 }else if(theForm.FromApp.value== "PlyEdrApp"){
		    theForm.action = "AcceptPolicy.jsp";
		 }
	 }else{
		 if(theForm.FromApp.value== "PlyApp"){
			 theForm.action = "Proposal.jsp";
		 }else if(theForm.FromApp.value== "PlyEdrApp"){
		 theForm.action = "PlyEdrApp.jsp";
		 }
	}*/
	 theForm.target ="";
	 theForm.button2.disabled=true;
	 theForm.submit();

}

</script>

</body>

