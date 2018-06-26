<html>
<head>
<title>平安货运保险保单批改</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="set.js"></SCRIPT>
<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">

   	nf.C_PRN_FRM_YEAR.focus();

</SCRIPT>
<%@ include file="public/Public.jsp" %>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="obn"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="obn" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>

<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/>

<jsp:setProperty name="pmb" property="*"/>

<jsp:useBean id="pmb1"  scope="request" class="beans.PolicyManagerBean"/>

<jsp:setProperty name="pmb1" property="*"/>

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>

<jsp:setProperty name="ob" property="*"/>
<%
   String OpenCoverNo = request.getParameter("C_OC_NO");
   //out.println("OpenCoverNo:");
   //out.println(OpenCoverNo);
   String OpenCover[][] = null;
    String Currency[][] = null;
    String CargoType[][] = null;
    String Pack[][] = null;
    String[] OpenCoverNoArra = null;
    String IsModify = "0";
    String PlyAppNo = "";

	String AgencyNo = request.getParameter("AGENCYNO");
    Hashtable hashData = new Hashtable();
    int i =0;
    String[] DateBeg = null;



    String edrAppInfos[] = null ;//new String[3];

    String C_PLY_NO = "";

    boolean retValueBool ;
//System.out.println("now you are in notice.jsp**OpenCoverNo:"+OpenCoverNo+"***");


   /*String FromApp=request.getParameter("FromApp");

		if(FromApp.equals("PlyEdrApp")){

		  //from preview policy edr app

		}else{}*/
   if(OpenCoverNo == null || OpenCoverNo.equals(""))
   {
    	   IsModify = "1";
           PlyAppNo = request.getParameter("C_PLY_NO");

		   if(PlyAppNo==null || PlyAppNo.trim().length()==0)

		    PlyAppNo = (String)request.getAttribute("C_PLY_NO");



           if(PlyAppNo==null){

		      System.out.println("THis is from proposal..............");

			  edrAppInfos =ob.getTempOne();

		    }else{

			 System.out.println("NNNN__++++++++++++++++>>>>>>>>>>>>>______---------");

		     edrAppInfos = Tools.DevideString(PlyAppNo ,",");

            }







		   // edrAppInfos = Tools.DevideString(PlyAppNo ,",");


           OpenCoverNoArra = Servlets.DivideMultiStr(edrAppInfos[0],"&");



           edrAppInfos[0] = OpenCoverNoArra[0];


           PlyAppNo = OpenCoverNoArra[0]; // "7018600020101000001" ;//






   }
   else
   {
       OpenCoverNoArra = Servlets.DivideMultiStr(OpenCoverNo,"&");
       DateBeg = Servlets.DivideMultiStr(ServTool.getSysDate(0),"-");
   }
   boolean hasModi = true;
   try
      {


        sb.setFieldValue(Const.GET_CURRENCY,"");
        Currency = sb.getRetValueArra();

		String para[]={PlyAppNo};





		try

		{

		    if(AgencyNo.equals(Const.CASE)){

			  pb.setFieldValue(Const.CHECK_EDRAPP,PlyAppNo);

			  hasModi = pb.getRetValueBool();

			  if(hasModi)pmb.setFormPara(0,para);

			  else{ throw NormalExceptionHandler.Handle("400000027");}

            }else if(AgencyNo.equals(Const.EDRSMTAPP)){

			    pmb.setFieldValue(3,PlyAppNo);

                retValueBool = pmb.getRetValueBool();

				pmb.setFormPara(4,edrAppInfos);

			}



		}

		catch(NormalException e)

		{

		    if(!hasModi){

			        System.out.println("Yes ....该保单已有批改申请单 in policy_oc.jsp ..........");

					throw NormalExceptionHandler.Handle(new Exception("该保单已有批改申请单!"));

             }

		    //e.printStackTrace();

 			if(NormalExceptionHandler.IsSevere(e))

 			throw NormalExceptionHandler.Handle(e);

		}


        sb.setFieldValue(Const.GET_PACK,"");
        Pack = sb.getRetValueArra();

     }
      catch(NormalException e)
      {

	      if(!hasModi){

			        System.out.println("Yes ....该保单已有批改申请单 in policy_oc.jsp ..........");

					throw NormalExceptionHandler.Handle(new Exception("该保单已有批改申请单!"));

          }

 	      if(NormalExceptionHandler.IsSevere(e))
 	       throw NormalExceptionHandler.Handle(e);
 	      else if(NormalExceptionHandler.IsWarning(e))
 	       WarnMsg = e.getErrDesc();

      }



	 // following is new 15/03/2001

      String ClientName = sessionbuffer.getClientName(Locate); //投保人

      String ClientType = sessionbuffer.getClientType(Locate); //登录客户类型

      String ClientId =   sessionbuffer.getClientId(Locate);



      String C_INSRNT_CDE = pmb.plyEdrAppInfo.c_insrnt_cde; //被保人遍码

      String C_INSRNT_NME = pmb.plyEdrAppInfo.c_insrnt_nme ;//被保人姓名



      String C_PROVINCE_CDE=pmb.plyPlyAppNetInfo.c_province ;//送达省名

      String C_CITY_CDE = pmb.plyPlyAppNetInfo.c_city ;//送达市

      String C_PLACE = pmb.plyPlyAppNetInfo.c_place ;//送达祥细地址

      String C_CONTACT_NAME= pmb.plyPlyAppNetInfo.c_contact_name ;//联系人

      String C_CONTACT_PHONE = pmb.plyPlyAppNetInfo.c_contact_phone ;//联系电话

      String C_CONTACT_FAX = pmb.plyPlyAppNetInfo.c_contact_fax;//联系传真

      String C_CONTACT_EMAIL= pmb.plyPlyAppNetInfo.c_contact_email ;//

	  String CRGO_CLS = pmb.plyEdrAppCrgoInfo.c_crgo_cls; //货物大类

	  String C_CRGO_CDE = pmb.plyEdrAppCrgoInfo.c_crgo_cde;//货物编码

      String C_CRGO_NAME = pmb.plyEdrAppCrgoInfo.c_crgo_name;//货物名称

      String C_CRGO_DESC=pmb.plyEdrAppCrgoInfo.c_crgo_desc ;//品名描述

      String C_PACK_CNM=pmb.plyEdrAppCrgoInfo.c_pack_cnm ;//包装描述

      String C_AMOUNT=pmb.plyEdrAppCrgoInfo.c_amount ;//数量

      String C_MARK=pmb.plyEdrAppCrgoInfo.c_mark ;//唛头

      String N_INVC_AMT = pmb.plyEdrAppCrgoInfo.n_invc_amt;//发票金额

      String C_INVC_AMT_CUR  = pmb.plyEdrAppCrgoInfo.c_invc_amt_cur ;//发票币种

	  String C_AMT_CUR_CNM = pmb.plyEdrAppInfo.c_amt_cur_cnm;//保额币种名

	  String C_AMT_CUR = pmb.plyEdrAppInfo.c_amt_cur;//保额币种

	  String C_PRM_CUR =  pmb.plyEdrAppInfo.c_prm_cur;//保费币种

	  String N_RATE = pmb.plyEdrAppCrgoInfo.n_rate;//费率

	  String N_AMT = pmb.plyEdrAppCrgoInfo.n_amt;//保险金额

	  String N_PRM = pmb.plyEdrAppCrgoInfo.n_prm;//保费

      String C_INVC_NO =pmb.plyEdrAppCrgoInfo.c_invc_no ;//发票号码

      String C_RECEIPT_NO =pmb.plyEdrAppCrgoInfo.c_receipt_no;//提单号

      String C_FRM_PRT_ARA =pmb.plyEdrAppCrgoInfo.c_frm_prt_ara;//起运国

      if(pmb.plyEdrAppCrgoInfo ==null)out.println("NULL NULL NULL");

      String C_FRM_PRT=  pmb.plyEdrAppCrgoInfo.c_from_prt ; //起运港

      String C_PASS_PRT =pmb.plyEdrAppCrgoInfo.c_pass_prt;//途经港

      String C_TO_PRT_ARA = pmb.plyEdrAppCrgoInfo.c_to_prt_ara;//到达国

      String C_TO_PRT = pmb.plyEdrAppCrgoInfo.c_to_prt ;//到达港

      String C_SAIL_NO = pmb.plyEdrAppCrgoInfo.c_sail_no ;//航次

      String C_CONTAINER = pmb.plyEdrAppCrgoInfo.c_container ;//集装箱方氏

      String t_insrnc_bgn_tm = pmb.plyEdrAppInfo.t_insrnc_bgn_tm ;//起运日期

	  String C_PAY_ADDR = pmb.plyEdrAppCrgoInfo.c_pay_addr;//赔付地

	  String C_SRVY_ADDR = pmb.plyEdrAppCrgoInfo.c_srvy_addr;//查勘代理人地点

      String C_PRN_FRM = pmb.plyEdrAppCrgoInfo.c_prn_frm;//打印格式

      String birth_year="";  //plyEdrAppCrgoInfo.c_prn_frm开航年

      String birth_month=""; //开航月

      String birth_day=""; //开航年日



	  String OLD_PRM_CUR = "";//旧保费币种



	  System.out.println("Yes new Prm:"+N_PRM);

	  String OLD_PRM = N_PRM;



	  String Currency_NAME = "";



      // Get Year , Month, Day

      if( t_insrnc_bgn_tm != null){

            birth_year = t_insrnc_bgn_tm.substring(0,4);

            birth_month =  t_insrnc_bgn_tm.substring(5,7);

            birth_day  = t_insrnc_bgn_tm.substring(8,10);

      }

	  String C_INSRNC_CDE = pmb.plyEdrAppInfo.c_insrnc_cde;//险种

	  String EXPORT = Const.C_EXPORT_CDE;

	  String TranType = C_INSRNC_CDE;

      String C_UNDR_CNDTN = pmb.plyEdrAppCrgoInfo.c_undr_cndtn;//承保条件

	  String C_OPEN_COVER_NO  = pmb.plyEdrAppInfo.c_open_cover_no;//Open Cover 协议号

	  String C_EDR_RSN = pmb.plyEdrAppInfo.c_edr_ctnt ; //批改原因

	  String N_PRM_VAR = pmb.plyEdrAppInfo.n_prm_var;//保费变化







	  //ended add 15/03/2001





      int CurrencyLen = Servlets.getLen(Currency);
      int c_cur_cde = Objects.getColNum("c_cur_cde",Currency);
      int c_cur_cnm = Objects.getColNum("c_cur_cnm",Currency);
      int n_chg_rte = Objects.getColNum("n_chg_rte",Currency);

	  int c_cur_no = Objects.getColNum("c_cur_no",Currency);
      try{

	      sb.setFieldValue(Const.GET_SMALLCARGOTYPE,CRGO_CLS);

          CargoType = sb.getRetValueArra();

	  }catch(NormalException e)

      {



 	      if(NormalExceptionHandler.IsSevere(e))

 	       throw NormalExceptionHandler.Handle(e);

 	      else if(NormalExceptionHandler.IsWarning(e))

 	       WarnMsg = e.getErrDesc();



      }
      String CargoTypeName = Objects.getValueCnm(CargoType,"c_crgo_cde","c_crgo_cnm",C_CRGO_CDE);

      //SPECIAL for rate

      String RateValue = N_RATE;
      if(!(RateValue.equals("")))
      {
         double Irate = Double.parseDouble(RateValue);
         Irate = Irate*100 ;
         RateValue = String.valueOf(Irate);
         //delete by kangjin //RateValue = RateValue.substring(0,RateValue.indexOf(".")+3);
		 RateValue = new java.math.BigDecimal(new Double(RateValue).doubleValue()).setScale(4,java.math.BigDecimal.ROUND_HALF_UP).toString();
         N_RATE=RateValue;
      }



	  //Objects.getScaleNumber(N_INVC_AMT, 2);




%>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
<%@ include file="public/PublicInquireLeft.jsp" %>
    <td width="613" height="288" valign="top"> <br>
      <img src ="images/baodpg-b.gif" width="150" height="31" alt="保单批改">

<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

<font color="#ff0000">打*的项目必须填写</font>

 <table border="0" width="95%" cellpadding="4" >
   <tr>
<td width="5%">　</td>

<td>

<% C_PLY_NO = pmb.plyEdrAppInfo.c_ply_no;

   out.println("保单号:"+ pmb.plyEdrAppInfo.c_ply_no); %>

<form name="nf" METHOD="POST" action="PolicyMid_OC.jsp">

  <p>被保险人(Insured)： ：
    <input type="text" <%if(! C_INSRNT_NME.equals("")) {%> disabled <%}%> name="C_INSRNT_NME" size="26" value=<%=C_INSRNT_NME%>>*</p>
<table width="98%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#6699FF" bordercolordark="#FFFFFF" bordercolor="#9999FF">
    <tr>
      <td bgcolor="#EFEFEF" nowrap>
        货物细类：<br>Sub Class  </td>
        <td colspan="3">
          <textarea rows="1" disabled name="C_CRGO_NAME1" cols="58" ><%=CargoTypeName%></textarea>
      </td>
    </tr>
    <tr>

      <td bgcolor="#EFEFEF"nowrap>
        货物名称：<br>Description  </td>
        <td colspan="3">
          <input type="hidden" name="C_CRGO_DESC" cols="20" value="<%=C_CRGO_DESC%>">
        <textarea rows="1"  onblur="LimitLength(C_CRGO_NAME,199);" name="C_CRGO_NAME" cols="58"><%=C_CRGO_NAME%></textarea>*</td>
    </tr>

<td bgcolor="#EFEFEF" nowrap>
        货物包装：<br>Packing Desc</td><td colspan="3" nowrap>
          <textarea onblur="LimitLength(C_PACK_CNM,60);" rows="2"  name="C_PACK_CNM" cols="58" maxlength="20"><%=C_PACK_CNM%></textarea>* </td>
    </tr>
    <tr>
      <td bgcolor="#EFEFEF" nowrap> 数量及单位：<br>Quantity</td> <td>
        <input type="text" name="C_AMOUNT" size="20" maxlength="200"  value="<%=C_AMOUNT%>">*</td>
      <td bgcolor="#EFEFEF" nowrap> 唛头<br>Marks</td> <td>

        <textarea onblur="LimitLength(C_MARK,199);" rows="2"  name="C_MARK" cols="25" maxlength="20"><%=C_MARK%></textarea>

        </td>
    </tr>
  </table><br>
  <table width="98%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#6699FF" bordercolordark="#FFFFFF" bordercolor="#9999FF">
    <tr>
      <td bgcolor="#EFEFEF" nowrap> 发票金额:<br>Invoice Amount  </td><td colspan="3">
        <input type="hidden" name="C_INVC_AMT_CUR" value=<%=C_INVC_AMT_CUR%>>
        <input type="text" name="N_INVC_AMT" size="10" maxlength="20" value="<%=Objects.getTrimZero(Objects.getScaleNumber(N_INVC_AMT, 2))%>" onblur="setPrm(N_INVC_AMT,N_AMT,C_INSRNC_CDE);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);setPrmChange(N_PRM_DISP,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
        <select name="C_INVC_AMT_CUR_TEMP"  disabled size="1" onChange="setCur(C_INVC_AMT_CUR_TEMP,C_AMT_CUR,C_PRM_CUR,C_INVC_AMT_CUR,C_AMT_CUR_CNM,C_PRM_CUR_CNM);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);setOldN_PRM(N_PRM1,N_PRM1_TEMP,C_INVC_AMT_CUR_TEMP,OLD_PRM_CUR);setPrmChange(N_PRM_DISP,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
          <option selected value="">请选择</option>
          <%
	   if(CurrencyLen > 1)
	   {

	     for(i = 1 ;i< CurrencyLen;i++ )
	     {
	   %>
                <option <%if(C_INVC_AMT_CUR.equals(Currency[i][c_cur_cde])){Currency_NAME = Currency[i][c_cur_cnm] ;%>selected<%}%>  value=<%=Currency[i][c_cur_cde]+"&"+Currency[i][n_chg_rte]+"&"+Currency[i][c_cur_cnm]%>><%=Currency[i][c_cur_cnm]%></option>
	   <%
	      }
	    }
	   %>

        </select>*</td></tr>
<tr>
<td bgcolor="#EFEFEF" nowrap>发票号码: <br>Invoice NO. </td><td>
        <input type="text" name="C_INVC_NO" size="13" maxlength="50" value="<%=C_INVC_NO%>">
      </td>
      <td bgcolor="#EFEFEF" nowrap> 提单号/运单号:<br>B/L NO.  </td><td>
        <input type="text" name="C_RECEIPT_NO"  size="13" maxlength="50" value=<%=C_RECEIPT_NO%>>
      </td>
    </tr>
    <tr>
      <td td bgcolor="#EFEFEF">起运日期:<br>Slg.on or abt.</td><td>
        <input type="text" name="C_PRN_FRM_YEAR" size="4" maxlength="4" value="<%=birth_year%>"  onfocus="ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)"  onChange="change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,T_INSRNC_BGN_TM);return ValidDateNew(T_INSRNC_BGN_TM,C_PRN_FRM_YEAR)&&ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)">年

		<input type="text" name="C_PRN_FRM_MONTH" size="2" maxlength="2" value="<%=birth_month%>" onChange="change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,T_INSRNC_BGN_TM);return ValidDateNew(T_INSRNC_BGN_TM,C_PRN_FRM_YEAR)&&ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)">月

		<input type="text" name="C_PRN_FRM_DATE" size="2" maxlength="2" value="<%=birth_day%>" onChange="change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,T_INSRNC_BGN_TM);return ValidDateNew(T_INSRNC_BGN_TM,C_PRN_FRM_YEAR)&&ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)">日*

		<input type="hidden" name="T_INSRNC_BGN_TM" value="2000-08-23"></td>

      <%

		   String yy = birth_year;

		   String mm = birth_month;

		   String dd = birth_day;

		   String f1 = yy + "年" + mm +"月" + dd + "日" ;

		   String f2 = StringTool.getDateString(yy+"-"+ mm + "-"+ dd,"ENG");

		   f2= f2.toUpperCase();

		   //out.println(Objects.getHt(hashData,"C_PRN_FRM"));

		%>

      <td bgcolor="#EFEFEF" nowrap>打印格式：<br>Prn Form</td>

      <td><select name="C_PRN_FRM">



		 <option value="<%=f2%>" <% if(C_PRN_FRM.equals(f2)){%> selected <%}%>><%=f2%>

		 <option value="<%=f1%>" <% if(C_PRN_FRM.equals(f1)){%> selected <%}%>><%=f1%>

		 <option value="详见提单" <% if(C_PRN_FRM.equals("详见提单")){%> selected <%}%>>详见提单

		 <option value="AS PER B/L" <% if(C_PRN_FRM.equals("AS PER B/L")){%> selected <%}%>> AS PER B/L

		 <option value="TO BE ADVISED" <% if(C_PRN_FRM.equals("TO BE ADVISED")){%> selected <%}%>> TO BE ADVISED

		 <option value="待告知" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("待告知")){%> selected <%}%>> 待告知

		</select>

     </td>

	 </tr>

	 <tr>
      <td bgcolor="#EFEFEF" nowrap>船名/车号/航班:<br>Conveyance NO.</td><td>
        <input type="text" name="C_SAIL_NO" size="13" maxlength="50" value="<%=C_SAIL_NO%>">
      </td>
      <td bgcolor="#EFEFEF" nowrap>

        起运地:<br>Port  </td><td>
          <input type="text" name="C_FROM_PRT" size="19" maxlength="60" value="<%=C_FRM_PRT%>">*</td>

     </tr><tr>
      <td bgcolor="#EFEFEF" nowrap>途经:<br>Via</td><td>
        <input type="text" name="C_PASS_PRT" size="19" maxlength="40" value="<%=C_PASS_PRT%>">
      </td>
      <td bgcolor="#EFEFEF" nowrap >
        <p>目的地:<br>Port  </td><td>
          <input type="text" name="C_TO_PRT" size="19" maxlength="60" value="<%=C_TO_PRT%>" <% if(TranType.equals(EXPORT)){%> onChange="ChangePay_Addr(C_TO_PRT,C_PAY_ADDR);ChangePay_Addr(C_TO_PRT,C_SRVY_ADDR);return true;" <%}%> >*</td>

      </tr>

	  <%if(TranType.equals(EXPORT)){%>

	  <tr>

	   <td bgcolor="#EFEFEF" nowrap>查勘代理人地点:</td>

	   <td colspan="3"><input type="text" name="C_SRVY_ADDR" size="50" maxlength="100" value="<%=C_SRVY_ADDR%>">*</td>

	 </tr>

	 <tr>

	  <td bgcolor="#EFEFEF" nowrap> 赔款偿付地点:</td>

	  <td><input type="text"  name="C_PAY_ADDR" value="<%=C_PAY_ADDR%>">*</td>
      <td bgcolor="#EFEFEF" nowrap>费率:<br>Rate</td><td>
        <input type="text" disabled name="N_RATE" size="10" onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);ValidRate(N_RATE);return true" value="<%=Objects.getTrimZero(N_RATE)%>">%
      </td>

    </tr>

	<%}else{%>

	  <tr>

      <td bgcolor="#EFEFEF" nowrap>费率:<br>Rate</td><td colspan="3">

        <input type="text" disabled name="N_RATE" size="10" onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);ValidRate(N_RATE);return true" value="<%=Objects.getTrimZero(N_RATE)%>">%

      </td>



    </tr>

	<%}%>
    <tr>
      <td bgcolor="#EFEFEF" nowrap>保险金额：<br>Amount Insured</td>
       <td>
        <input type="text" name="N_AMT" size="10" maxlength="19" value="<%=Objects.getTrimZero(Objects.getScaleNumber(N_AMT, 2))%>" onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);setPrmChange(N_PRM_DISP,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
        <input type="hidden" name="C_AMT_CUR" value="<%=C_AMT_CUR%>">

		<%

		  Currency_NAME ="";

		 if(CurrencyLen > 1)

	     {

	      for(i = 1 ;i< CurrencyLen;i++ )

	      {

	              if(C_AMT_CUR.equals(Currency[i][c_cur_cde])){

				   Currency_NAME = Currency[i][c_cur_cnm];

				   break;

				  }

	      }

	    }

	   %>
        <input type="text" disabled name="C_AMT_CUR_CNM" size="5" maxlength="20" value=<%=Currency_NAME%>>
      </td>
      <td bgcolor="#EFEFEF" nowrap>保险费：<br>Premium</td><td>
	  	<!--康进2001-09-11
		1.将N_PRM字段名改为N_PRM_DISP并禁止修改
		2.增加一个名为N_PRM的隐藏字段
		3.使得N_PRM的值在提交的时候与N_PRM_DISP的值一致
		-->
        <input type="hidden" name="N_PRM"  size="10" maxlength="19" value=<%=Objects.getTrimZero(Objects.getScaleNumber(N_PRM,2))%> onblur="setPrmChange(N_PRM_DISP,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">		
        <input disabled type="text" name="N_PRM_DISP"  size="10" maxlength="19" value=<%=Objects.getTrimZero(Objects.getScaleNumber(N_PRM,2))%> onblur="setPrmChange(N_PRM_DISP,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
        <input type="hidden" name="C_PRM_CUR"  value=<%=C_PRM_CUR%>>

	    <%

		  Currency_NAME ="";

		 if(CurrencyLen > 1)

	     {

	      for(i = 1 ;i< CurrencyLen;i++ )

	      {

	              if(C_PRM_CUR.equals(Currency[i][c_cur_cde])){

				   Currency_NAME = Currency[i][c_cur_cnm];

				    OLD_PRM_CUR = Currency[i][c_cur_no]+"&"+Currency[i][n_chg_rte]+"&"+Currency[i][c_cur_cnm];

				   break;

				  }

	      }

	    }

	   %>
        <input type="text" disabled name="C_PRM_CUR_CNM" size="6" maxlength="20" value=<%=Currency_NAME%>>
      </td>
    </tr>

    <tr>
      <td bgcolor="#EFEFEF">承保条件：<br>Insurance Conditions</td>
      <td colspan="3" rows="2"><%=C_UNDR_CNDTN%>
      <br> &nbsp;
      </td>
    </tr>
   <%
    String Limit_desc =Objects.getHt(hashData,"c_limit_desc");

    if(Limit_desc==null || Limit_desc.equals("")){
     String AgentInfo[][] = null;
     boolean disabled = false;
     try
     {
        String paras[] = new String[3];
        System.out.println("Open Cover No:"+Objects.getHt(hashData,"C_OPEN_COVER_NO"));
        paras[0]= C_OPEN_COVER_NO;
        paras[1]= C_INSRNC_CDE;
        paras[2]= C_CRGO_CDE;
       // for(int q=0; q< paras.length; q++)
       //  out.println(paras[q]+";");
        pb.setFormPara(Const.GET_OCINFO,paras);
        AgentInfo = pb.getRetValueArra();
     }
     catch(NormalException e)
     {
      disabled = true;
 	    WarnMsg = e.getErrDesc();
 	    e.printStackTrace();
     }
     if(!disabled){
       //for(int q=0 ; q<AgentInfo[0].length;q++)
       //out.println(AgentInfo[0][q]);
       String textarea = "";
       if(!disabled){
         int c_limit_desc = Objects.getColNum("C_LIMIT_DESC",AgentInfo);
         Limit_desc =  (AgentInfo[1][c_limit_desc]).trim();
       }
     }
    }
    if(Limit_desc==null)Limit_desc="";
  %>
    <tr>
      <td bgcolor="#EFEFEF">限制承保货物：<br>Limit Cargo.</td>
      <td colspan="3" rows="2"><%=Limit_desc%>
      <br> &nbsp;
      </td>
    </tr>
    <tr>
        <input type="hidden" name="C_REMARK">
    </tr>

  </table>



  <table width="98%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#6699FF" bordercolordark="#FFFFFF" bordercolor="#9999FF">

    <% if(AgencyNo.equals(Const.EDRSMTAPP)){

	    String para[]={C_PLY_NO};

		try

		{  System.out.println("in get Old N_PRM");

			pmb1.setFormPara(0,para);

		}

		catch(NormalException e)

		{

		    System.out.println("Error in get Old N_PRM");

		    e.printStackTrace();

 			if(NormalExceptionHandler.IsSevere(e))

 			throw NormalExceptionHandler.Handle(e);

		}

        OLD_PRM = pmb1.plyEdrAppCrgoInfo.n_prm;

		System.out.println("to do OLD_PRM:"+OLD_PRM);

	   }

	   double N_PRM_CHANGE = 0;



	   double n_prm = Objects.ToDouble(N_PRM);



	   System.out.println("to do N_PRM:"+N_PRM);

	   double old_prm = Objects.ToDouble(OLD_PRM);

	   double n_prm_var1 = 0;

	   String n_prm_var_str = Objects.getTrimZero(Objects.getScaleNumberZero(""+n_prm_var1,3));

	   n_prm_var1 = n_prm - old_prm;

	   if(n_prm>old_prm){

	      N_PRM_CHANGE = (n_prm - old_prm)/old_prm;

		}else{

		  N_PRM_CHANGE = (old_prm - n_prm)/old_prm;

		}

		N_PRM_CHANGE = N_PRM_CHANGE*100;

	    String  N_PRM_CHANGE_str = Objects.getTrimZero(Objects.getScaleNumberZero(""+N_PRM_CHANGE,3));

	%>



    <tr>

      <td>原保费：<input type="hidden"  name="N_PRM1" value=<%=Objects.getTrimZero(Objects.getScaleNumber(OLD_PRM,2))%>>

	              <input type="text" size="10"  disabled name="N_PRM1_TEMP" value=<%=Objects.getTrimZero(Objects.getScaleNumber(OLD_PRM,2))%>>

	              <input type="hidden" name="OLD_PRM_CUR" value="<%=OLD_PRM_CUR%>">

	  </td>

	  <td>最新保费：<input type="text" size=10 disabled name="N_PRM2" value=<%=Objects.getTrimZero(Objects.getScaleNumber(N_PRM,2))%>></td>

	  <td>保费变化：<input type="hidden" name="N_PRM_VAR" value=<%=n_prm_var_str%>>

	                <input type="text" size=8 disabled name="N_PRM_VAR_TEMP" value=<%=n_prm_var_str%>>&nbsp;

					<input type="hidden" name="N_PRM_CHANGE" value=<%=N_PRM_CHANGE_str%>>

					<input type="text" size=5 disabled name="N_PRM_CHANGE_TEMP" value=<%=N_PRM_CHANGE_str%>>%</td>



    </tr>

    <tr>

	   <td colspan=3>批改原因:</td>

	   </tr>

    <tr><td colspan=3>

 	   <textarea rows="2" name="C_EDR_RSN" cols="65" maxlength="500" ><%=C_EDR_RSN%></textarea>*

	   </td>

	</tr>

</table>



<p align="center">
 <select name="language" size="1">

		       <option value="ENG" selected>英</option>

			   <option value="CHN" >中</option>

               </select>
<input type="button" value="提  交" name="B1" onclick="setNPrm();change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,T_INSRNC_BGN_TM);Trim(this.form);CheckForm(this.form);return true;">
  <input  type="reset" value="重  填" name="B2">
  <input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>
  </p>
  </center></div>

	  <input type="hidden" name="C_INSRNC_CDE" size="20" value=<%=C_INSRNC_CDE%>>
        <input type="hidden" name="TEMPAMT" value="">
        <input type="hidden" name="TEMPAMT1" value="">
        <input type="hidden" name="MODIFY_FLAG" value="<%=IsModify%>">
<input type="hidden" name="C_PLY_APP_NO" value="<%=PlyAppNo%>">

</form>
<br><br>
         </td>
    </tr>
  </table>


        </div>


    </td>
  </tr>
</table>


 </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>

</body>
</html>
<script language=JavaScript>
function CheckForm(theForm){

TrimForm(theForm);
if(ValidDateNew(theForm.T_INSRNC_BGN_TM,theForm.C_PRN_FRM_YEAR)&&
<%if(C_INSRNT_NME.equals("")) {%>
ValidNull(theForm.C_INSRNT_NME,false) &&
<%}%>
ValidNull(theForm.C_PACK_CNM,false) &&
ValidNull(theForm.C_AMOUNT,false) &&
ValidNull(theForm.C_FROM_PRT,false) &&
ValidNull(theForm.C_TO_PRT,false) &&

ValidNull(theForm.C_EDR_RSN,false) &&
ValidNull(theForm.C_INVC_AMT_CUR_TEMP,false) &&

ValidNull(theForm.N_INVC_AMT,false) &&

<%if(TranType.equals(EXPORT)){%>

ValidNull(theForm.C_SRVY_ADDR,false)&&

ValidNull(theForm.C_PAY_ADDR,false)&&

<%}%>
ValidRate(theForm.N_RATE) &&
ValidAmt(theForm.N_AMT) &&

ValidNoOrReal(theForm.C_INVC_NO,theForm.C_RECEIPT_NO) &&
ValidAmt(theForm.N_PRM)
){

	theForm.B1.disabled=true;
    theForm.submit();
 }else{
   return false;
 }
}

function Trim(theForm){

   //全部去除空格

}

function LimitLength(field,maxLength){
  /** verfy the max length of the field and warn */
   var extraLength;
	if (ActualLength(field) >maxLength){
		extraLength = ActualLength(field) - maxLength;
		alert("该字段超长"+extraLength+"个字符");
		field.focus();
	}
}  

/*count Chinese character as 2 digits*/
function ActualLength(field){
	var actualLength = field.value.length;
	for (i = 0 ;i<field.value.length;i++){
		if (field.value.charCodeAt(i) > 1000){
			actualLength ++;
		} 
	}
		return actualLength;
}
/*康进2001-09-11
bug report:客户可以随意修改保费
solution:将保费变为不可改变的字段
**/
function setNPrm(){
	nf.N_PRM.value = nf.N_PRM_DISP.value;	
}
</script>
