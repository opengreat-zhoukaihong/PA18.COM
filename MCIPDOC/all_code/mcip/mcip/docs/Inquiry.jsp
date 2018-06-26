<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Inquiry.jsp
*Directory : /data1/pa18/nul/mcip/public_html/
*URL : http://10.16.102.1:8800/Inquiry.jsp
*Previous Page : OperationSelect1.jsp
*Next Page : Inquiry.jsp
*Author : Lawrence Kang
*Created Date : 2000/09/28
*Last Updated : 2000/10/10
*Status : submited for test
*Function : I.Generate the (detail cargo/currency/areacode)dynamic list
*			II.According to user's selection,calculate the policy rate
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-24
*Time : 17:43:47
*Modify id : 0001
*Modifier : Kang Jin
*Reason : calculate the insurance rate add conditon of RDR
***********************************************************************************************
*Date : 2000-10-24
*Time : 17:43:47
*Modify id : 0003
*Modifier : Kang Jin
*Reason : calculate the insurance rate add conditon of RDR
***********************************************************************************************
*Date : 2000-10-27
*Time : 9:08:16
*Modify id : 0002
*Modifier : Kang Jin
*Reason : 实际保费的费率+-15%后显示范围
*				保费显示成小数点后两位
*				战争险和罢工险不加费
***********************************************************************************************
*/
%>
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<SCRIPT LANGUAGE="JavaScript">
function forward(Form,field) 
{ 
  field.value="rep";
  Form.submit();
  return;
}
function sub(field) 
{ 
  field.value="sub";
  return;
}
function unsub(field)
{
	field.value="";
	return;
}
</SCRIPT>
<form name="nf" method="post" action="Inquiry.jsp" onsubmit="return(ValidNull(C_FRM_PRT,false)&&ValidNull(C_TO_PRT,false)&&ValidNull(N_TGT_AMT,false)&&ValidAmt(N_TGT_AMT));">
<%@ include file="public/Public.jsp" %>
<jsp:useBean id="ob"  scope="application" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/> 
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="cb"  scope="page" class="beans.CustManagerBean"/> 
<jsp:setProperty name="cb" property="*"/>
<%  
/*+B0002*/
	float
		upperRate=0,lowerRate=0,upperFinal=0,lowerFinal=0;
/*+E0002*/
//for get  para and to bean
	//isRDR
	String isRDR ="0";
	//Hashtable hashData = new Hashtable();

	String dt1=null;
	String dt2=null;
	String dt3=null;
	String dt4=null;

	String it6=null;
	String it7=null;
	String it8=null;
	int index=0;//Column index number;

	String selStr="";//selectd or checked tag phrase
	String c_dpt_cde="",c_clnt_id="";
	String c_clnt_info[][]=null;
	/*+B0003*/
	String clientAddInfo[] = null;
	/*+E0003*/

	Double Rate=new Double(1.0);//exchange rate initial value:1
	Double N_RATE = new Double(0);
	String C_NCLM_DESC = "";//Rate description
	float finalAmount=0;
	String currencyName="";

	String  isInit = request.getParameter("isInit");

	//for save input values
	String temp = request.getParameter("temp");
	if (temp==null){temp="";}//init for non null value

	String C_CARGO_CLS=request.getParameter("C_CARGO_CLS"); 
	String C_CARGO_CDE=request.getParameter("C_CARGO_CDE");


	String TranType =  request.getParameter("TranType");//货运类型
	String HomeType= request.getParameter("HomeType");//国内运输方式
	String PortType= request.getParameter("PortType");//国外运输方式

	String C_FRM_PRT_ARA = request.getParameter("C_FRM_PRT_ARA");//起运港所在国家
	String C_FRM_PRT = request.getParameter("C_FRM_PRT");//起运港名称
	if (C_FRM_PRT==null){C_FRM_PRT="";}

	String C_TO_PRT_ARA =request.getParameter("C_TO_PRT_ARA");//目的港所在国家
	String C_TO_PRT = request.getParameter("C_TO_PRT");//目的港名称
	if (C_TO_PRT==null) {C_TO_PRT="";}

	String N_TGT_AMT = request.getParameter("N_TGT_AMT");//保险金额
	String C_AMT_CUR = request.getParameter("C_AMT_CUR");//保币种险
	String C_PACK_CDE =  request.getParameter("C_PACK_CDE");//包装方式

	String C_MAIN_INSURANCE = request.getParameter("C_MAIN_INSURANCE");//主险
	if (C_MAIN_INSURANCE==null){C_MAIN_INSURANCE="";}//Init for non null value

	String boxName[]={"C_ADD_INSURANCE1","C_ADD_INSURANCE2","C_ADD_INSURANCE3",
			"C_ADD_INSURANCE4","C_ADD_INSURANCE5","C_ADD_INSURANCE6",
			"C_ADD_INSURANCE7","C_ADD_INSURANCE8","C_ADD_INSURANCE9",
			"C_ADD_INSURANCE10","C_ADD_INSURANCE11","C_ADD_INSURANCE12",
			"C_ADD_INSURANCE13","C_ADD_INSURANCE14","C_ADD_INSURANCE15",
			"C_ADD_INSURANCE16","C_ADD_INSURANCE17","C_ADD_INSURANCE18",
			"C_ADD_INSURANCE19","C_ADD_INSURANCE20","C_ADD_INSURANCE21"};

	String boxVal[]=new String[Const.C_H_ADD_CDE.length];
	boxVal[0]= request.getParameter("C_ADD_INSURANCE1");//附加险
	boxVal[1] = request.getParameter("C_ADD_INSURANCE2");//附加险
	boxVal[2] = request.getParameter("C_ADD_INSURANCE3");//附加险
	boxVal[3] = request.getParameter("C_ADD_INSURANCE4");//附加险
	boxVal[4] = request.getParameter("C_ADD_INSURANCE5");//附加险
	boxVal[5] = request.getParameter("C_ADD_INSURANCE6");//附加险
	boxVal[6] = request.getParameter("C_ADD_INSURANCE7");//附加险
	boxVal[7] = request.getParameter("C_ADD_INSURANCE8");//附加险
	boxVal[8] = request.getParameter("C_ADD_INSURANCE9");//附加险
	boxVal[9] = request.getParameter("C_ADD_INSURANCE10");//附加险
	boxVal[10] = request.getParameter("C_ADD_INSURANCE11");//附加险
	boxVal[11] = request.getParameter("C_ADD_INSURANCE12");//附加险
	boxVal[12] = request.getParameter("C_ADD_INSURANCE13");//附加险
//	boxVal[13] = request.getParameter("C_ADD_INSURANCE14");//附加险
//	boxVal[14] = request.getParameter("C_ADD_INSURANCE15");//附加险
	for (int i=0;i<Const.C_H_ADD_CDE.length;i++)
		if (boxVal[i]==null ) 
			{boxVal[i]="";}//init for non null value
		/*B0001+*/
		else
		{
			if (i >1)
				isRDR = "1";
		}
		/*E0001+*/

      //out.print("<p>The tran type:"+TranType);
	dt1=request.getParameter(Const.C_RAILAGE_CDE);//铁路 B13
	dt2=request.getParameter(Const.C_ROAD_CDE);//公路 B23
	dt3=request.getParameter(Const.C_WATER_CDE);//水路 B33
	dt4=request.getParameter(Const.C_H_AVIATION_CDE);//航空 B43

	it6=request.getParameter(Const.C_LANDWAY_CDE);//B01 陆路
	it7=request.getParameter(Const.C_SEA_CDE);//B31 海洋
	it8=request.getParameter(Const.C_AVIATION_CDE);//B21 航空

	String Currency[][] = null;//currency list
	String area[][]=null;//area list
	String pack[][]=null;//package way list
	String bCargoType[][]=null;//Big CargoType list
	String sCargoType[][]=null;//Small CargoType list
	String exchangeRate[][]=null;//exchangeRate list
	String formPara[] =new String[2];//parameters list

	formPara[0]="";
	if (TranType.equals(Const.C_HOME_CDE))
		formPara[1]=HomeType;
	else
		formPara[1]=TranType;

	try {
		sb.setFieldValue(Const.GET_CURRENCY,"");
	        Currency = sb.getRetValueArra();

		sb.setFieldValue(Const.GET_AREA,"");
	        area = sb.getRetValueArra();

		sb.setFieldValue(Const.GET_PACK,"");
		pack = sb.getRetValueArra();

		sb.setFormPara(Const.GET_BIGCARGOTYPE,formPara);
		bCargoType=sb.getRetValueArra();

		if (isInit!=null){ //获得细类列表
			sb.setFieldValue(Const.GET_SMALLCARGOTYPE,C_CARGO_CLS);
			sCargoType=sb.getRetValueArra();
		}
		else{
			if(bCargoType.length>1){
			sb.setFieldValue(Const.GET_SMALLCARGOTYPE,bCargoType[1][0]);
			sCargoType=sb.getRetValueArra();
			}
		}
	    }
	    catch(NormalException e){
// 		if(NormalExceptionHandler.IsSevere(e))
//	 	    throw NormalExceptionHandler.Handle(e);
	    }

	    int AreaLen = Servlets.getLen(area);
	    int CurrencyLen=Servlets.getLen(Currency);
	    int packLen = Servlets.getLen(pack);

	/*计算保费*/
	int len=0;
	String rateList[][]=null;
	String C_INSRC_CDE="",C_CARRIAGE_CDE="";
	if (temp.equals("sub"))
	{
		//获得部门代码
		c_clnt_id = sessionbuffer.getClientId(Locate);
		/*+B0003*/
		clientAddInfo = sessionbuffer.getClientAddInfo(Locate);
		c_dpt_cde = clientAddInfo[4];

		/*+E0003*/
		/*-E0003*/
		/**
		try
		{
			formPara[0]=c_clnt_id;
			cb.setFormPara(Const.QUERY_CUSTORGN,formPara);
			c_clnt_info=cb.getRetValueArra();
		}
		catch(NormalException e)
		{
// 			if(NormalExceptionHandler.IsSevere(e))
//				throw NormalExceptionHandler.Handle(e);
		}

		if (c_clnt_info!=null && c_clnt_info.length>1){
			index=Objects.getColNum("C_DPT_CDE",c_clnt_info);
			c_dpt_cde=c_clnt_info[1][index].substring(0,3);
		}*/
		/*-E0003*/

		//获得运输方式
		if (TranType.equals(Const.C_HOME_CDE))
		{ //Home trans
			C_INSRC_CDE=HomeType;
			index=Objects.getColNum(HomeType,BConst.CARRIAGE_LIST);
			C_CARRIAGE_CDE=BConst.CARRIAGE_LIST[1][index];
		}
		if (TranType.equals(Const.C_EXPORT_CDE) || TranType.equals(Const.C_IMPORT_CDE))
		{//Import&Export trans
			C_INSRC_CDE=TranType;
			index=Objects.getColNum(PortType,BConst.CARRIAGE_LIST);
			C_CARRIAGE_CDE=BConst.CARRIAGE_LIST[1][index];
		}

		//获得汇率转换
		String fromCurrency="",toCurrency="";
		if (!C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][0]) && !C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][1]) && !C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][2]))
		{
			formPara[0]=C_AMT_CUR;
			formPara[1]=BConst.BASE_CURRENCY[0][2];
			try
			{
				sb.setFormPara(Const.GET_EXCHANGERATE,formPara);
				exchangeRate=sb.getRetValueArra();
			}
			catch(NormalException e)
			{
//			 	if(NormalExceptionHandler.IsSevere(e))
//				throw NormalExceptionHandler.Handle(e);
			}

			if (exchangeRate!=null && exchangeRate.length>1)
			{
				index=Objects.getColNum("N_CHG_RTE",exchangeRate);
				//Rate = new Double(exchangeRate[(exchangeRate[index].length-1)][index]);
				Rate = new Double(exchangeRate[1][index]);
			}
		}

		//Following code should be save into bean 
		org.omg.CORBA.ORB orb = ORBManager.getORBForClient();
		com.mcip.nia.orb.PolicyInfoManager pmanager =
		com.mcip.nia.orb.PolicyInfoManagerHelper.bind(orb, "pmanager");


		com.mcip.nia.orb.QuotaCndtn quotacndtnobj=new com.mcip.nia.orb.QuotaCndtn();

		//set the quotation object's attributes
		quotacndtnobj.c_dpt_cde = c_dpt_cde;
		quotacndtnobj.c_insrnc_cde = C_INSRC_CDE;
		quotacndtnobj.c_rdr_cde = C_MAIN_INSURANCE;
		quotacndtnobj.c_crgo_cde = C_CARGO_CDE;
		quotacndtnobj.c_carriage_cde = C_CARRIAGE_CDE;
		quotacndtnobj.c_frm_prt_ara = C_FRM_PRT_ARA;
		quotacndtnobj.c_to_prt_ara = C_TO_PRT_ARA;
		quotacndtnobj.c_crgo_cls = "";
		quotacndtnobj.c_pack_cde = "";
		quotacndtnobj.n_rate = "";
		quotacndtnobj.c_nclm_desc = "";
		try
		{
			rateList = pmanager.getQuotation(quotacndtnobj,isRDR);
		}
		catch (Exception e){
			rateList = null;
		}
	   //the code should be save in the bean^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

		if (rateList!=null && rateList.length>1)
		{
			index=Objects.getColNum("N_RATE",rateList);
			N_RATE= new Double(rateList[1][index]);
			index=Objects.getColNum("C_NCLM_DESC",rateList);
			C_NCLM_DESC= rateList[1][index];
		}
	    
		Double N_AMT = new Double(N_TGT_AMT);
		/*+B0002*/
			upperRate = (float)(N_RATE.floatValue()*1.15*100);
			lowerRate = (float)(N_RATE.floatValue()*0.85*100);
		/*+E0002*/
		finalAmount= N_AMT.floatValue()*N_RATE.floatValue()*Rate.floatValue();
		/*+B0002*/
			upperFinal = (float)(finalAmount * 1.15);
			lowerFinal = (float)(finalAmount * 0.85);
		/*-B0002*/

		if (!C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][0]) && !C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][1]) && !C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][2]))
		{
			currencyName="("+BConst.BASE_CURRENCY[1][2]+")";
		}
		else
		{
			for (int i=0;i<3;i++){
				if (C_AMT_CUR.equals(BConst.BASE_CURRENCY[0][i])){
					currencyName="("+BConst.BASE_CURRENCY[1][i]+")";
					break;
				}
			}
		}
}
%>
<!--hidden field for save the current page's status-->
<input type=hidden name="sessionid" value="<%=Code.Encrypt(sessionId)%>"> 
<input type=hidden name="TranType" value="<%=TranType%>">
<input type=hidden name="HomeType" value="<%=HomeType%>">
<input type=hidden name="PortType" value="<%=PortType%>">

<input type=hidden name="Const.C_RAILAGE_CDE" value="<%=dt1%>">
<input type=hidden name="Const.C_ROAD_CDE" value="<%=dt2%>">
<input type=hidden name="Const.C_WATER_CDE" value="<%=dt3%>">
<input type=hidden name="Const.C_H_AVIATION_CDE" value="<%=dt4%>">

<input type=hidden name="Const.C_LANDWAY_CDE" value="<%=it6%>">
<input type=hidden name="Const.C_SEA_CDE" value="<%=it7%>">
<input type=hidden name="Const.C_AVIATION_CDE" value="<%=it8%>">

<input type=hidden name="isInit" value="yes">
   <table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
  <%@ include file="public/PublicConsultLeft.html" %>
    <td width="613" height="288" valign="top"> <br>
      <img src="images/con_cal.gif" width="150" height="31" alt="保费测算"> 
<!--new page start-->
    <%  if (temp.equals("sub")){%>
  <table border="1" width="100%" cellspacing="0" bordercolor="#CCCCCC">
    <tr bgcolor="#F5F5F5"> 
      <td height="14" width="46%">保 险 费： 
	<%//=finalAmount%>
	<%if (upperRate <100 && lowerRate > 0){%>
	<%=currencyName%><%=StringTool.fix(lowerFinal)%>～<%=StringTool.fix(upperFinal)%>
	<%}%>
      </td>
      <td height="14" width="54%">保险费率： 
	<%//=N_RATE.toString()%>
	<%if (upperRate <100 && lowerRate > 0){%>
	<%=new java.math.BigDecimal(new Double(lowerRate).doubleValue()).setScale(4,java.math.BigDecimal.ROUND_HALF_UP)%>%
		～<%=new java.math.BigDecimal(new Double(upperRate).doubleValue()).setScale(4,java.math.BigDecimal.ROUND_HALF_UP)%>%
	<%}%>
      </td>
    </tr>
    <tr bgcolor="#F5F5F5"> 
      <td height="14" colspan="2"> 
        <p>免赔描述：</p>
		<%if (temp.equals("sub") && rateList ==null){%>
			<p><font color="red" >没有查到相应的费率!</font></p>
		<%}else{%>
				<%if (upperRate <100 && lowerRate > 0){%>
						<p><%=C_NCLM_DESC%></p>
				<%}else{%>
						<p><font color="red">该费率有误，请联系系统管理员！</font></p>
				<%}%>
		<%}%>
      </td>
    </tr>
  </table>
  <table width="100%">
		<tr>
			<td align="center"><input type="button" value="返回" onclick="history.back()"></td>
		</tr>
  </table>
  <%}else{%>
  <br>
<div align="right"><font color="#ED7CC9">带 *的选项必须填写</font></div>
  <table border="1" width="100%" cellspacing="0" bordercolor="#F7F7F7">
    <tr> 
      <td width="15%" bgcolor="#EBEBEB" align="right">货物大类：</td>
      <td width="85%">
        <select name="C_CARGO_CLS" size="1" onChange="unsub(temp);nf.submit();">
		<%if (bCargoType!=null && bCargoType.length>1)
		  {
			selStr="";
			int c_crgo_cde = Objects.getColNum("C_CRGO_CDE",bCargoType);
			int c_crgo_cnm = Objects.getColNum("C_CRGO_CNM",bCargoType);
			for (int i=1;i<bCargoType.length;i++)
			{
				if (bCargoType[i][c_crgo_cde].equals(C_CARGO_CLS))
					selStr="selected ";
			else
				selStr="";
			%>
			<option <%=selStr%> value="<%=bCargoType[i][c_crgo_cde]%>"><%=bCargoType[i][c_crgo_cnm]%></option>
			<%}
		}
		%>
        </select>*
        </td>
	</tr>
	<tr>
      <td width="15%" bgcolor="#EBEBEB" align="right">货物细类：</td>
      <td width="85%">
        <select name="C_CARGO_CDE" size="1">
		<%if (sCargoType!=null && sCargoType.length>1)
		  {
			int c_scrgo_cde = Objects.getColNum("C_CRGO_CDE",bCargoType);
			int c_scrgo_cnm = Objects.getColNum("C_CRGO_CNM",bCargoType);
			for (int i=1;i<sCargoType.length;i++)
			{
				if (sCargoType[i][c_scrgo_cde].equals(C_CARGO_CDE))
					selStr="selected ";
				else
					selStr="";
			%>
			<option <%=selStr%> value="<%=sCargoType[i][c_scrgo_cde]%>"><%=sCargoType[i][c_scrgo_cnm]%></option>
			<%}
		}
		%>
        </select>*
	</td>
    </tr>
    <tr> 
      <td width="15%" bgcolor="#EBEBEB" align="right">起运港国家：</td>
      <td width="85%">
        <select name="C_FRM_PRT_ARA" size="1">
	<%
	if (TranType.equals(Const.C_HOME_CDE) || TranType.equals(Const.C_EXPORT_CDE))
	    out.print("<option selected value=\""+Const.CHINA_CDE+"\">China("+Const.CHINA_CNM+")</option>");
	else{
	   if(AreaLen > 1){
	       int c_ara_cde = Objects.getColNum("c_ara_cde",area);
	       int c_ara_cnm = Objects.getColNum("c_ara_cnm",area);
		   int c_ara_enm = Objects.getColNum("c_ara_enm",area);
	       for(int i = 1 ;i< AreaLen;i++ )
		if (area[i][c_ara_cde].equals(C_FRM_PRT_ARA))
		       	   out.print("<option selected value=\""+area[i][c_ara_cde]+"\">"+area[i][c_ara_enm]+"("+area[i][c_ara_cnm]+")</option>");
			else
		       	   out.print("<option value=\""+area[i][c_ara_cde]+"\">"+area[i][c_ara_enm]+"("+area[i][c_ara_cnm]+")</option>");
	   }
	}
	%> 
        </select>
        *</td>
		</tr>
		<tr>
      <td width="15%" bgcolor="#EBEBEB" align="right">起运港名称：</td>
      <td width="85%">
        <input type="text" name="C_FRM_PRT" value="<%=C_FRM_PRT%>" size="25">
        *</td>
    </tr>
    <tr> 
      <td width="15%" bgcolor="#EBEBEB" align="right">目的港国家：</td>
      <td width="85%">
        <select name="C_TO_PRT_ARA" size="1">
	<%
	if (TranType.equals(Const.C_IMPORT_CDE) || TranType.equals(Const.C_HOME_CDE))
	    out.print("<option selected value=\""+Const.CHINA_CDE+"\">China("+Const.CHINA_CNM+")</option>");
	else{
	   if(AreaLen > 1){
	       int c_ara_cde = Objects.getColNum("c_ara_cde",area);
	       int c_ara_cnm = Objects.getColNum("c_ara_cnm",area);
		   int c_ara_enm = Objects.getColNum("c_ara_enm",area);
	       for(int i = 1 ;i< AreaLen;i++ ){
			if (area[i][c_ara_cde].equals(C_TO_PRT_ARA))
				out.print("<option selected value=\""+area[i][c_ara_cde]+"\">"+area[i][c_ara_enm]+"("+area[i][c_ara_cnm]+")</option>");
			else
		       	   out.print("<option value=\""+area[i][c_ara_cde]+"\">"+area[i][c_ara_enm]+"("+area[i][c_ara_cnm]+")</option>");
		   }
	   }
	}
	%> 
        </select>
       *</td>
	   </tr>
	   <tr>
      <td width="15%" bgcolor="#EBEBEB" align="right">目的港名称：</td>
      <td width="85%"> 
      <% if (C_TO_PRT==null)
		C_TO_PRT="";
      %>
        <input type="text" name="C_TO_PRT" value="<%=C_TO_PRT%>" size="25">
        *</td>
    </tr>
    <tr> 
      <td width="15%" bgcolor="#EBEBEB" align="right">保险金额：</td>
      <td width="85%">
	<% if (N_TGT_AMT==null)
		N_TGT_AMT="";
	%>
        <input type="text" name="N_TGT_AMT" value="<%=N_TGT_AMT%>" size="12" maxlength="10">
        <select name="C_AMT_CUR" size="1">
			<%if (Currency!=null && Currency.length>1)
		{%>
		<%
	       int c_cur_no = Objects.getColNum("C_CUR_NO",Currency);
	       int c_cur_cnm = Objects.getColNum("C_CUR_CNM",Currency);
			for (int i=1;i<Currency.length;i++)
			{ if (Currency[i][c_cur_no].equals(C_AMT_CUR))
				selStr="selected";
			  else
				selStr="";

			%>
					
			<option <%=selStr%> value="<%=Currency[i][c_cur_no]%>"><%=Currency[i][c_cur_cnm]%></option>
			<%}
		}
		%>

<!--          <option selected value="人民币">人民币</option>-->
        </select>
        *</td>
		</tr>
		<tr>
      <td  width="15%" bgcolor="#EBEBEB" align="right">包装方式：</td>
      <td width="85%">
        <select name="C_PACK_CDE" size="1">
	<%
	   if(packLen > 1){
	       int c_pack_cde = Objects.getColNum("c_pack_cde",pack);
	       int c_pack_cnm = Objects.getColNum("c_pack_cnm",pack);
	       for(int i = 1 ;i< packLen;i++ )
			if (pack[i][c_pack_cde].equals(C_PACK_CDE))
				out.print("<option selected value=\""+pack[i][c_pack_cde]+"\">"+pack[i][c_pack_cnm]+"</option>");
			else
				   out.print("<option value=\""+pack[i][c_pack_cde]+"\">"+pack[i][c_pack_cnm]+"</option>");
	   }
	%> 
        </select>
        * </td>
    </tr>
  </table>
          <br>
          主险：
          <table border="1" width="100%" bordercolor="#F5F5F5" cellspacing="0">

	<!--进口/出口 &&海洋运输 条件下的险种选择-->	
	<%
	if ( ( TranType.equals(Const.C_EXPORT_CDE) || TranType.equals(Const.C_IMPORT_CDE)) && PortType.equals(Const.C_SEA_CDE) ){%>
            <tr align="center"> 
              <td height="16" width="10%" bgcolor="#EBEBEB" align="left">海洋运输</td>
	      <%
	      if (C_MAIN_INSURANCE.length()==0){C_MAIN_INSURANCE=Const.C_H_B0102_CDE[0];}
	      for (int i=0;i<6;i++){
			if (C_MAIN_INSURANCE.equals(Const.C_H_B0102_CDE[i]))
				selStr="checked";
			else
				selStr="";
	      %>
              <td height="16" width="15%" align="left">
		<input <%=selStr%> type="radio"  name="C_MAIN_INSURANCE" value="<%=Const.C_H_B0102_CDE[i]%>" >
                <%=Const.C_H_B0102_CNM[i]%></td>
	      <%}%>
            </tr>
	<%}%>

	<!--进口/出口 &&陆路运输 条件下的险种选择-->	
	<%if ( ( TranType.equals(Const.C_EXPORT_CDE) || TranType.equals(Const.C_IMPORT_CDE)) && PortType.equals(Const.C_LANDWAY_CDE) ){%>
            <tr align="center"> 
              <td height="16" width="13%" height="16" bgcolor="#EBEBEB" align="left">陆路运输</td>
	      <%
      	      if (C_MAIN_INSURANCE.length()==0){C_MAIN_INSURANCE=Const.C_H_B0102_CDE[6];}
	      for (int i=6;i<8;i++){
			if (C_MAIN_INSURANCE.equals(Const.C_H_B0102_CDE[i]))
				selStr="checked";
			else
				selStr="";
	      %>
              <td height="16" align="left">
                <input <%=selStr%> type="radio" name="C_MAIN_INSURANCE" value="<%=Const.C_H_B0102_CDE[i]%>">
                <%=Const.C_H_B0102_CNM[i]%></td>
		<%}%>
            </tr>
	    <%}%>

	<!--进口/出口 &&航空运输 条件下的险种选择-->	
	<%if ( ( TranType.equals(Const.C_EXPORT_CDE) || TranType.equals(Const.C_IMPORT_CDE)) && PortType.equals(Const.C_AVIATION_CDE) ){%>
            <tr align="center"> 
              <td width="13%" height="16" bgcolor="#EBEBEB" align="left">航空运输</td>
	      <%
      	      if (C_MAIN_INSURANCE.length()==0){C_MAIN_INSURANCE=Const.C_H_B0102_CDE[8];}
	      for (int i=8;i<10;i++){
			if (C_MAIN_INSURANCE.equals(Const.C_H_B0102_CDE[i]))
				selStr="checked";
			else
				selStr="";
	      %>
              <td height="16" align="left"> 
                <input <%=selStr%> type="radio" name="C_MAIN_INSURANCE" value="<%=Const.C_H_B0102_CDE[i]%>">
                <%=Const.C_H_B0102_CNM[i]%></td>
		<%}%>
            </tr>
		<%}%>

		<!--国内运输 条件下的险种选择-->	
	<%if ( TranType.equals(Const.C_HOME_CDE)){%>

            <tr> 
              <td width="12%" height="16" bgcolor="#EBEBEB" align="left">国内运输</td>
	      <%
      	      if (C_MAIN_INSURANCE.length()==0){C_MAIN_INSURANCE=Const.C_H_B03_CDE[0];}
	      for (int i=0;i<Const.C_H_B03_CDE.length-2;i++){
			if (C_MAIN_INSURANCE.equals(Const.C_H_B03_CDE[i]))
				selStr="checked";
			else
				selStr="";
	      %>
              <td width="44%" height="16" align="left"> 
                <input <%=selStr%> type="radio" name="C_MAIN_INSURANCE" value="<%=Const.C_H_B03_CDE[i]%>">
                <%=Const.C_H_B03_CNM[i]%></td>
		<%}%>
            </tr>
	  <%}%>

          </table>
          <br>
	<%if (TranType.equals(Const.C_IMPORT_CDE) || TranType.equals(Const.C_EXPORT_CDE)){%>
        附加险：
	<% int counter=0;
		int lines=Const.C_H_ADD_CDE.length/3;
		if (Const.C_H_ADD_CDE.length%3>0)
			lines++;
	for (int i=0;i<lines;i++){%>
        <table border="1" width="100%" cellpadding="0" cellspacing="0" bordercolor="#F6F6F6">
		<tr align="center">
		<%for (int j=0;j<3 && counter<Const.C_H_ADD_CDE.length;j++){
			if (boxVal[counter].equals(Const.C_H_ADD_CDE[counter]))
				selStr="checked";
			else
				selStr="";
		%>
			<td width="32%" align="left"><input <%=selStr%> type="checkbox" name="<%=boxName[counter]%>" value="<%=Const.C_H_ADD_CDE[counter]%>">
			<%=Const.C_H_ADD_CNM[counter]%>
			</td>
		<%counter++;}%>
		</tr>
	</table>
	<%}%>
  <br>
  <%}%>
  <table align="center">
	<tr>
		<td>
			<div align="center">
				<input type="hidden" value="test" name="temp">
				<INPUT TYPE="submit" value ="提  交" onclick="sub(temp)">
				<input type="reset" value="重  填" name="B2">
			</div>
</form>
</td>
<td>
<div align="center">
<form action="OperationSelect1.jsp" >
<input type=hidden name="sessionid" value="<%=Code.Encrypt(sessionId)%>"> 
<input type="submit" value="上一步" >
</form>
</div>
</td>
</tr>
</table>
<%}%>
</td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>
</body>
</html>