<html>
<head>
<title>平安货运保险</title>
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

	boolean fromPolicy = false;
//System.out.println("now you are in notice.jsp**OpenCoverNo:"+OpenCoverNo+"***");

   if(OpenCoverNo == null || OpenCoverNo.equals(""))
   {

          System.out.println("Case 1---------------vvvvvvvvvvvvvvvvvvvv-------------");
    	   IsModify = "1";
           PlyAppNo = request.getParameter("C_PLY_NO");
		   if(PlyAppNo==null || PlyAppNo.trim().length()==0)
		    PlyAppNo = (String)request.getAttribute("C_PLY_NO");



			System.out.println("-----------PlyAppNo:"+PlyAppNo);

			if(PlyAppNo.indexOf("&")<0){fromPolicy = true;

			  System.out.println("fromPolicy:"+fromPolicy);

			}

			String FromApp=request.getParameter("FromApp");

			if(FromApp!=null && FromApp.length()>0){

			  fromPolicy = false;//add by rao

			  System.out.println("Not fromPolicy:"+fromPolicy);

            }
            OpenCoverNoArra = Servlets.DivideMultiStr(PlyAppNo,"&");
            PlyAppNo = OpenCoverNoArra[0];


		   //out.println("Notice.jsp Ply No:"+PlyAppNo);
   }
   else
   {


       OpenCoverNoArra = Servlets.DivideMultiStr(OpenCoverNo,"&");
       DateBeg = Servlets.DivideMultiStr(ServTool.getSysDate(0),"-");
   }

      try
      {
        sb.setFieldValue(Const.GET_CURRENCY,"");
        Currency = sb.getRetValueArra();
        if(IsModify.equals("1"))
        {
            //out.println("Notice case 1");

			if(!fromPolicy)
        	 pb.setFieldValue(Const.GET_POLICYAPPINFO,PlyAppNo);
        }
        else
        {
          //out.println("Notice case 2");
        	pb.setFormPara(Const.GET_OCINFO,OpenCoverNoArra);
        }
        OpenCover = pb.getRetValueArra();


        //---only for debug
        //for(int p= 0 ; p< OpenCover[0].length;p++)
        // out.println(OpenCover[0][p]+":"+OpenCover[1][p]+"<p>");
        if(!fromPolicy)obn.setFormData(OpenCover);
        hashData = obn.getHashData();

        //if(!hashData.containsKey("C_PRM_CUR"))
        //{
        //  out.println("Yes con......");
        //}

        sb.setFieldValue(Const.GET_SMALLCARGOTYPE,Objects.getHt(hashData,"C_CRGO_CLS"));
        CargoType = sb.getRetValueArra();

        sb.setFieldValue(Const.GET_PACK,"");
        Pack = sb.getRetValueArra();

     }
      catch(NormalException e)
      {

 	      if(NormalExceptionHandler.IsSevere(e))
 	       throw NormalExceptionHandler.Handle(e);
 	      else if(NormalExceptionHandler.IsWarning(e))
 	       WarnMsg = e.getErrDesc();

      }

      int CurrencyLen = Servlets.getLen(Currency);
      int c_cur_cde = Objects.getColNum("c_cur_cde",Currency);
      int c_cur_cnm = Objects.getColNum("c_cur_cnm",Currency);
      int n_chg_rte = Objects.getColNum("n_chg_rte",Currency);

      String C_INSRNT_NME = Objects.getHt(hashData,"C_INSRNT_NME");
      String CargoTypeName = Objects.getValueCnm(CargoType,"c_crgo_cde","c_crgo_cnm",Objects.getHt(hashData,"C_CRGO_CDE"));

      //SPECIAL for rate

      String RateValue = Objects.getHt(hashData,"N_RATE");
      if(!(RateValue.equals("")))
      {
         double Irate = Double.parseDouble(RateValue);
         Irate = Irate*100 ;
         RateValue = String.valueOf(Irate);
         //delete by kangjin //RateValue = RateValue.substring(0,RateValue.indexOf(".")+3);
		 RateValue = new java.math.BigDecimal(new Double(RateValue).doubleValue()).setScale(4,java.math.BigDecimal.ROUND_HALF_UP).toString();
         hashData.put("N_RATE",RateValue);
      }
%>

<%
//is to data copy while modify notice
    if(IsModify.equals("1"))
    {


    System.out.println("Objects.getHt(hashData,T_INSRNC_BGN_TM):"+Objects.getHt(hashData,"T_INSRNC_BGN_TM"));
	DateBeg = Servlets.DivideMultiStr(Objects.getHt(hashData,"T_INSRNC_BGN_TM"),"-");
        if(DateBeg == null)
        {
           DateBeg = new String[3];
        }
      hashData.put("C_INVC_AMT_CUR_TEMP",Objects.getHt(hashData,"C_INVC_AMT_CUR"));
      hashData = Servlets.PutCnm(hashData,"C_AMT_CUR","C_AMT_CUR_CNM",Currency,"c_cur_no","c_cur_cnm");
      hashData = Servlets.PutCnm(hashData,"C_PRM_CUR","C_PRM_CUR_CNM",Currency,"c_cur_no","c_cur_cnm");

     }
%>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>
<%@ include file="public/PublicMemLeft.jsp" %>
    <td width="613" height="288" valign="top"> <br>
      <img src="images/open_notice.gif" width="150" height="31" alt="起运通知书">

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

<form name="nf" METHOD="POST" action="NoticeOut.jsp">

  <p>被保险人(Insured)：
    <input type="text" <%if(!C_INSRNT_NME.equals("")) {%> disabled <%}%> name="C_INSRNT_NME" size="26" value="<%=C_INSRNT_NME%>">*</p>
<table width="98%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#6699FF" bordercolordark="#FFFFFF" bordercolor="#9999FF">
    <tr>
      <td bgcolor="#EFEFEF" nowrap>
        货物细类：<br>Sub Class </td>
        <td colspan="3">
          <textarea rows="1" disabled name="C_CRGO_NAME1" cols="58" ><%=CargoTypeName%></textarea>
      </td>
    </tr>
    <tr>

      <td bgcolor="#EFEFEF"nowrap>
        货物名称：Description </td>
        <td colspan="3">
          <input type="hidden" name="C_CRGO_DESC" cols="20" value="<%=Objects.getHt(hashData,"C_CRGO_DESC")%>">
        <textarea onblur="LimitLength(C_CRGO_NAME,199);" rows="1"  name="C_CRGO_NAME" cols="58"><%=Objects.getHt(hashData,"C_CRGO_NAME")%></textarea>*</td>
    </tr>
<%
/*   wuyan delete 包装方式 2000-12-20

    <tr>
      <td bgcolor="#EFEFEF" nowrap>
      <input type="hidden" name="C_PACK_CDE" size="26" value=<%=Objects.getHt(hashData,"C_PACK_CDE")% >>
      包装方式：</td><td colspan="3">
      <select name="C_PACK_CDE" size="1">
          <%String PackCde = Objects.getHt(hashData,"C_PACK_CDE");
          int PackLen = Servlets.getLen(Pack);
	   if(PackLen > 1)
	   {
	     int c_pack_cde = Objects.getColNum("c_pack_cde",Pack);
	     int c_pack_cnm = Objects.getColNum("c_pack_cnm",Pack);
	     if(PackCde.equals("") || PackCde == null)
	     {
		     for(i = 1 ;i< PackLen;i++ )
		     {
		   % >
	                <option  <%if(PackCde.equals(Pack[i][c_pack_cde])){% >selected<%}% >  value=<%=Pack[i][c_pack_cde]% >><%=Pack[i][c_pack_cnm]% ></option>
		   <%
		      }

	      }
	      else
	      {
			String PackName = Objects.getValueCnm(Pack,"c_pack_cde","c_pack_cnm",PackCde);
		   % >
	                <option selected value=<%=PackCde% >><%=PackName% ></option>
		   <%

	      }
	    }
	   % >
      </select> *
      </td>
      </tr>
<tr>
*/
%>
<td bgcolor="#EFEFEF" nowrap>
        货物包装：<br>Packing Desc</td><td colspan="3" nowrap>
          <textarea onblur="LimitLength(C_PACK_CNM,60);" rows="2"  name="C_PACK_CNM" cols="58" maxlength="20"><%=Objects.getHt(hashData,"C_PACK_CNM")%></textarea>* </td>
    </tr>
    <tr>
      <td bgcolor="#EFEFEF" nowrap> 数量及单位：<br>Quantity</td> <td>
        <input type="text" name="C_AMOUNT" size="20" maxlength="200"  value="<%=Objects.getHt(hashData,"C_AMOUNT")%>">*</td>
      <td bgcolor="#EFEFEF" nowrap> 唛头<br>Marks</td> <td>
        <textarea onblur="LimitLength(C_MARK,199);" rows="2"  name="C_MARK" cols="25" maxlength="20"><%=Objects.getHt(hashData,"C_MARK")%></textarea>
        </td>
    </tr>
  </table><br>
  <table width="98%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#6699FF" bordercolordark="#FFFFFF" bordercolor="#9999FF">
    <tr>
      <td bgcolor="#EFEFEF" nowrap> 发票金额:<br>Invoice Amount </td><td colspan="3">
        <input type="hidden" name="C_INVC_AMT_CUR" value=<%=Objects.getHt(hashData,"C_INVC_AMT_CUR")%>>
        <input type="text" name="N_INVC_AMT" size="10" maxlength="12" value="<%=Objects.getTrimZero(Objects.getHt(hashData,"N_INVC_AMT"))%>" onblur="setPrm(N_INVC_AMT,N_AMT,C_INSRNC_CDE);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);return true;">
        <select name="C_INVC_AMT_CUR_TEMP" size="1" onChange="setCur(C_INVC_AMT_CUR_TEMP,C_AMT_CUR,C_PRM_CUR,C_INVC_AMT_CUR,C_AMT_CUR_CNM,C_PRM_CUR_CNM);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);return true;">
          <option selected value="">请选择</option>
          <%
	   if(CurrencyLen > 1)
	   {

	     for(i = 1 ;i< CurrencyLen;i++ )
	     {
	   %>
                <option <%if(Objects.getHt(hashData,"C_INVC_AMT_CUR_TEMP").equals(Currency[i][c_cur_cde])){%>selected<%}%>  value=<%=Currency[i][c_cur_cde]+"&"+Currency[i][n_chg_rte]+"&"+Currency[i][c_cur_cnm]%>><%=Currency[i][c_cur_cnm]%></option>
	   <%
	      }
	    }
	   %>

        </select>*</td></tr>
<tr>
<td bgcolor="#EFEFEF" nowrap>发票号码:<br>Invoice NO. </td><td>
        <input type="text" name="C_INVC_NO" size="13" maxlength="50" value="<%=Objects.getHt(hashData,"C_INVC_NO")%>">
      </td>
      <td bgcolor="#EFEFEF" nowrap> 提单号/运单号:<br>B/L NO. </td><td>
        <input type="text" name="C_RECEIPT_NO"  size="13" maxlength="50" value=<%=Objects.getHt(hashData,"C_RECEIPT_NO")%>>
      </td>
    </tr>
    <tr>
      <input type="hidden" name="C_CARRIAGE_CDE"  value=<%=Objects.getHt(hashData,"C_CARRIAGE_CDE")%>> <font size="1"></font></td>
      <td bgcolor="#EFEFEF" >起运日期:<br>Slg.on or abt.</td><td>
        <input type="text" name="C_PRN_FRM_YEAR" size="4" maxlength="4" value="<%=DateBeg[0]%>"   onfocus="ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)"  onChange="change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,tempdate);return ValidDateNew(tempdate,C_PRN_FRM_YEAR)&&ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)">
        年
        <input type="text" name="C_PRN_FRM_MONTH" size="2" maxlength="2" value="<%=DateBeg[1]%>"  onChange="change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,tempdate);return ValidDateNew(tempdate,C_PRN_FRM_YEAR)&&ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)">
        月
        <input type="text" name="C_PRN_FRM_DATE" size="2" maxlength="2" value="<%=DateBeg[2]%>"   onChange="change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,tempdate);return ValidDateNew(tempdate,C_PRN_FRM_YEAR)&&ChangeDate(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,C_PRN_FRM)">
        日
		<input type="hidden" name="tempdate" value="2000-08-23">*</td>

		<%

		   String yy = DateBeg[0];

		   String mm = DateBeg[1];

		   String dd = DateBeg[2];

		   String f1 = yy + "年" + mm +"月" + dd + "日" ;

		   String f2 = StringTool.getDateString(yy+"-"+ mm + "-"+ dd,"ENG");

		   f2= f2.toUpperCase();

		  // System.out.println("TEST NOTICE C_PRN_FRM:"+Objects.getHt(hashData,"C_PRN_FRM"));

		%>

      <td bgcolor="#EFEFEF" nowrap>打印格式：<br>Prn Form</td>

      <td><select name="C_PRN_FRM">

	     <option value="<%=f2%>" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals(f2)){%> selected <%}%>><%=f2%>

		 <option value="<%=f1%>" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals(f1)){%> selected <%}%>><%=f1%>

		 <option value="详见提单" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("详见提单")){%> selected <%}%>>详见提单

		 <option value="AS PER B/L" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("AS PER B/L")){%> selected <%}%>> AS PER B/L

		 <option value="TO BE ADVISED" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("TO BE ADVISED")){%> selected <%}%>> TO BE ADVISED

		 <option value="待告知" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("待告知")){%> selected <%}%>> 待告知



		</select>

     </td>

    </tr>

    <tr>
      <td bgcolor="#EFEFEF" nowrap>船名/车号/航班:<br>Conveyance NO.</td><td>
        <input type="text" name="C_SAIL_NO" size="13" maxlength="50" value="<%=Objects.getHt(hashData,"C_SAIL_NO")%>">*
      </td>
      <td bgcolor="#EFEFEF" nowrap>
        <input type="hidden" name="C_FRM_PRT_ARA"  value=<%=Objects.getHt(hashData,"C_FRM_PRT_ARA")%>>
        起运地:<br>Port </td><td>
          <input type="text" name="C_FROM_PRT" size="21" maxlength="60" value="<%=Objects.getHt(hashData,"C_FROM_PRT")%>">*</td>

     </tr>

	 <tr>
      <td bgcolor="#EFEFEF" nowrap>途经:<br>Via</td><td>
        <input type="text" name="C_PASS_PRT" size="21" maxlength="40" value="<%=Objects.getHt(hashData,"C_PASS_PRT")%>">
      </td>
      <td bgcolor="#EFEFEF" nowrap >
        <input type="hidden" name="C_TO_PRT_ARA" value=<%=Objects.getHt(hashData,"C_TO_PRT_ARA")%>>
        <p>目的地: <br>Port</td><td>
          <input type="text" name="C_TO_PRT" size="21" maxlength="60" value="<%=Objects.getHt(hashData,"C_TO_PRT")%>" <% if(Objects.getHt(hashData,"c_insrnc_cde").equals(Const.C_EXPORT_CDE)){%> onChange=ChangePay_Addr(C_TO_PRT,C_PAY_ADDR);ChangePay_Addr(C_TO_PRT,C_SRVY_ADDR);return true; <%}%>>*</td>

     </tr>

	 <%if(Objects.getHt(hashData,"c_insrnc_cde").equals(Const.C_EXPORT_CDE)){%>

	 <tr>

	   <td bgcolor="#EFEFEF" nowrap>查勘代理人地点:</td>

	   <td colspan="3"><input type="text" name="C_SRVY_ADDR"  value="<%=Objects.getHt(hashData,"C_SRVY_ADDR")%>">*</td>

	 </tr>

	 <%}%>

	 <tr>

	  <%if(Objects.getHt(hashData,"c_insrnc_cde").equals(Const.C_EXPORT_CDE)){%>

	   <td bgcolor="#EFEFEF" nowrap> 赔款偿付地点:</td>

	   <% if(Objects.getHt(hashData,"C_PAY_ADDR").equals("") && !Objects.getHt(hashData,"c_insrnc_cde").equals(Const.C_EXPORT_CDE)){

		   String Result[] = sessionbuffer.getClientAddInfo(Locate);%>

		   <td><input type="text"  name="C_PAY_ADDR" value="<%=Result[0]%>">*</td>

       <%}else{%>

	     <td><input type="text"  name="C_PAY_ADDR" value="<%=Objects.getHt(hashData,"C_PAY_ADDR")%>">*</td>

	   <%}%>
      <td bgcolor="#EFEFEF" nowrap>费率:<br>Rate</td><td>
        <input type="text" disabled name="N_RATE" size="10" onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);ValidRate(N_RATE);return true" value="<%=Objects.getTrimZero(Objects.getHt(hashData,"N_RATE"))%>">%
      </td>

	  <%}else{%>

	    <td bgcolor="#EFEFEF" nowrap>费率:<br>Rate</td><td colspan="3">

        <input type="text" disabled name="N_RATE" size="10" onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);ValidRate(N_RATE);return true" value="<%=Objects.getTrimZero(Objects.getHt(hashData,"N_RATE"))%>">%

      </td>

	  <%}%>

    </tr>
    <tr>
      <td bgcolor="#EFEFEF" nowrap>保险金额：<br>Amount Insured</td>
       <td>
        <input type="text" name="N_AMT" size="10" maxlength="19" value="<%=Objects.getTrimZero(Objects.getHt(hashData,"N_AMT"))%>" onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM_DISP);return true;">
        <input type="hidden" name="C_AMT_CUR" value=<%=Objects.getHt(hashData,"C_AMT_CUR")%>>
        <input type="text" disabled name="C_AMT_CUR_CNM" size="8" maxlength="20" value=<%=Objects.getHt(hashData,"C_AMT_CUR_CNM")%>>
      </td>
      <td bgcolor="#EFEFEF" nowrap>保险费：<br>Premium</td><td>
	  	<!--康进2001-09-11 
		1.将N_PRM字段名改为N_PRM_DISP并禁止修改
		2.增加一个名为N_PRM的隐藏字段
		3.使得N_PRM的值在提交的时候与N_PRM_DISP的值一致
		--> 
		<input type="hidden" name="N_PRM" size="10" maxlength="19" value=<%=Objects.getTrimZero(Objects.getHt(hashData,"N_PRM"))%>>		
        <input disabled type="text" name="N_PRM_DISP" size="10" maxlength="19" value=<%=Objects.getTrimZero(Objects.getHt(hashData,"N_PRM"))%>>
        <input type="hidden" name="C_PRM_CUR" size="12" value=<%=Objects.getHt(hashData,"C_PRM_CUR")%>>
        <input type="text" disabled name="C_PRM_CUR_CNM" size="8" maxlength="20" value=<%=Objects.getHt(hashData,"C_PRM_CUR_CNM")%>>
      </td>
    </tr>

    <tr>
      <td bgcolor="#EFEFEF">承保条件：<br>Insurance Conditions</td>
      <td colspan="3" rows="2"><%=Objects.getHt(hashData,"C_UNDR_CNDTN")%>
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
       // out.println("Open Cover No:"+Objects.getHt(hashData,"C_OPEN_COVER_NO"));
        paras[0]= Objects.getHt(hashData,"C_OPEN_COVER_NO");
        paras[1]= Objects.getHt(hashData,"C_INSRNC_CDE");
        paras[2]= Objects.getHt(hashData,"C_CRGO_CDE");
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

<p align="center">
<select name="language" size="1">

		       <option value="ENG" selected>英</option>

			   <option value="CHN" >中</option>

               </select>
<input type="button" value="预  览" name="B1" onclick="setNPrm();change(C_PRN_FRM_YEAR,C_PRN_FRM_MONTH,C_PRN_FRM_DATE,tempdate);CheckForm(this.form);return true;">
  <input  type="reset" value="重  填" name="B2">
  <input type="button" value="前一页" name="B44" onclick="changeAction();">
  </p>
  </center></div>

	  <input type="hidden" name="C_INSRNC_CDE" size="20" value=<%=Objects.getHt(hashData,"C_INSRNC_CDE")%>>
        <input type="hidden" name="TEMPAMT" value="">
        <input type="hidden" name="TEMPAMT1" value="">

		<% if(fromPolicy)IsModify= "0" ;%>
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
if(ValidDateNew(theForm.tempdate,theForm.C_PRN_FRM_YEAR)&&
<%if(C_INSRNT_NME.equals("")) {%>
ValidNull(theForm.C_INSRNT_NME,false) &&
<%}%>
ValidNull(theForm.C_PACK_CNM,false) &&
ValidNull(theForm.C_AMOUNT,false) &&
ValidNull(theForm.C_FROM_PRT,false) &&
ValidNull(theForm.C_TO_PRT,false) &&
ValidNull(theForm.C_INVC_AMT_CUR_TEMP,false) &&

ValidNull(theForm.C_SAIL_NO,false)&&

<%if(Objects.getHt(hashData,"c_insrnc_cde").equals(Const.C_EXPORT_CDE)){%>

ValidNull(theForm.C_SRVY_ADDR,false)&&

ValidNull(theForm.C_PAY_ADDR,false)&&

<%}%>
ValidRate(theForm.N_RATE) &&

ValidNull(theForm.N_INVC_AMT,false) &&
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

function changeAction(){
	nf.action="OpenCoverList.jsp";
	  nf.B1.disabled=true;
	nf.submit();
	return true;
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
