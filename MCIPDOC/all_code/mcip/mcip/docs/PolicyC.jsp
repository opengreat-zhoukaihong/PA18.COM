<!--
Modified:2001-11-5
By:L.K
Description:国内航空险的主险改为：(03)航空运输险、(04)航空运输一切险
ID:LK0001
*****
Modified:2001-11-16 15:12:11
By:L.K
Description:限制承保货物从协议中传入，不再重新刷新屏幕
ID:LK0002
-->
<html>
<head>
<title>平安货运保险保单批改</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="set.js"></SCRIPT>
<SCRIPT LANGUAGE="JavaScript" SRC="art_open.js"></SCRIPT>

<SCRIPT FOR=window EVENT=onload LANGUAGE="JavaScript">
   	nf.birth_year.focus();
</SCRIPT>


<%@ include file="public/Public.jsp" %>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
<%@ include file="public/PublicPlyLeft.html"%>

<td width="613" height="288" valign="top">

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>
<jsp:useBean id="pmb1"  scope="request" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb1" property="*"/>


<%
  //for get  para and to bean
     System.out.println("PolicyC.jsp start");
	  String rhm= "hello world12121234567891011123555796d ";

	  String ClientName = sessionbuffer.getClientName(Locate); //投保人 
      String ClientType = sessionbuffer.getClientType(Locate); //登录客户类型
      String ClientId =   sessionbuffer.getClientId(Locate);

      String TranType = "";
      String Credit = "";
      String[] HomeTransit = new String[Const.HOME_TRANSIT_LEN];
      String[] PortTransit = new String[Const.PORT_TRANSIT_LEN];
      String[] PortTransitName = new String[Const.PORT_TRANSIT_LEN];
      String Temp = "";
      int i = 0;
      String NameStr = "";
      String PlyNo = "";
      Hashtable hashData = new Hashtable();
	  hashData = ob.getHashData();
     
      int  step = ob.getStep();
      String DefaultCls = "";
      String DefaultProvince = "";
      
      String HOME = Const.C_HOME_CDE;//B03
      String EXPORT = Const.C_EXPORT_CDE;//B02
      String IMPORT = Const.C_IMPORT_CDE; //B01
      String NOCREDIT = Const.C_NOCREDIT_CDE;//0
      String HASCREDIT = Const.C_CREDIT_CDE;//1
      String RadioCheckValue = "";
      String RadioCheckHash = "";
      int OperType = 0;
      String PlyAppNo = "";
      String Oper = "";
      String PLYAPPMOD = "PLYAPPMOD";
      String AgencyNo = "";
      String AddAgencyNo ="";
      String AddInsrnc[] = null;
      boolean IsMainInsrncSelect = false;
      boolean IsNewPlyApp = false;
      String RemoteOperType    ="";
      String[] DefaultCur = null;
	/*LK0002+B*/
String _limitDesc = request.getParameter("LimitDesc");
/*LK0002+E*/


     

	  String C_PLY_NO = "";//保单号

	  String edrAppInfos[] =null ;

	  boolean UNDRAW = true;

      if(step == Const.STEP_BEG || step == Const.STEP_NEWMOD)
      {  
	       System.out.println("	Const.STEP_BEG policyC.jsp");
           PlyNo = request.getParameter("C_PLY_NO");
		   if(PlyNo==null){
		      System.out.println("THis is from proposal..............");
			  edrAppInfos =ob.getTempOne();
		   }else{
		     edrAppInfos = Tools.DevideString(PlyNo ,",");
           }
		   PlyNo = edrAppInfos[0];
           if(PlyNo == null)
           PlyNo = (String)request.getAttribute("C_PLY_NO");
           AgencyNo = request.getParameter("AGENCYNO");
           if(AgencyNo == null)
            AgencyNo = (String)request.getAttribute("AGENCYNO");         
		   System.out.println("AgencyNo:"+AgencyNo);
		   if(AgencyNo == null)
			 AgencyNo = "";		   

           if(ClientType.equals(Const.CUST_AG))
           {
		     AddAgencyNo = StringTool.null2Blank(request.getParameter("ADDAGENCYNO"));
           }

           if(!(PlyNo == null || PlyNo.equals("")))
           {
              AgencyNo = pmb.plyEdrAppInfo.c_agt_agr_no;
			  String[][] PlyAppRdrInfo = pmb.plyEdrAppRdrInfo.edrapprdr;
			  int c_rdr_cde =  Objects.getColNum("c_rdr_cde",PlyAppRdrInfo);
              int RdrLen = Servlets.getLen(PlyAppRdrInfo);
              AddInsrnc = new String[RdrLen - 1];
		      for(int j=1;j<RdrLen;j++)
		      { 
			   System.out.println("PolicyC.jsp  >>> "+  PlyAppRdrInfo[j][c_rdr_cde]);
			   AddInsrnc[j - 1 ] =  PlyAppRdrInfo[j][c_rdr_cde];}
			  
	       }	       

		   
      }else if(step == Const.STEP_REP)
      {	
	       System.out.println("	Const.STEP_REP policyC.jsp");
      	    String ChangFlag = (String)request.getAttribute("CHANGFLAG");
      	   
            String[] CurTemp = Servlets.DivideStr(Objects.getHt(hashData,"C_INVC_AMT_CUR_TEMP"),"&");
            if(!(CurTemp[0] == null || CurTemp[0].equals("")))
            	hashData.put("C_INVC_AMT_CUR_TEMP",CurTemp[0]);
            String[] CityTemp = Servlets.DivideStr(Objects.getHt(hashData,"C_CITY"),"&");
            if(!(CityTemp[0] == null || CityTemp[0].equals("")))
            	hashData.put("C_CITY",CityTemp[0]);
            if(ClientType.equals(Const.CUST_AG))
             {
               AgencyNo = (String)request.getAttribute("AGENCYNO");
   	           AddAgencyNo = StringTool.null2Blank(request.getParameter("ADDAGENCYNO"));
   	         }
             ob.setStep(Const.STEP_BEG);
      }
     //Added by Clarkrao 3/19/2001
      TranType = ob.getTranType();
      if(TranType.equals(EXPORT))//outport
      {
          Credit = ob.getCredit();
      }
      if(TranType.equals(HOME))//home
      {
           NameStr = Const.AREA; //Const.PROVINCE;
           HomeTransit = ob.getHomeTransit();
           DefaultCur = Const.RMB;
      }
      else//import or outport
      {
           NameStr = Const.AREA;
           PortTransit = ob.getPortTransit();
           DefaultCur = Const.USA;
      }

           

    

%>


<%@ include file="PublicPly.jsp" %>

<% 

 
 

    String C_LIMIT_DESC =""; 
    String birth_year="";  //plyEdrAppCrgoInfo.c_prn_frm开航年
    String birth_month=""; //开航月
    String birth_day=""; //开航年日 
	String t_insrnc_bgn_tm = Objects.getHt(hashData,"t_insrnc_bgn_tm"); 
      if( t_insrnc_bgn_tm != null){
            birth_year = t_insrnc_bgn_tm.substring(0,4);
            birth_month =  t_insrnc_bgn_tm.substring(5,7);
            birth_day  = t_insrnc_bgn_tm.substring(8,10);
      }

  String Currency_NAME = "";
  String OLD_PRM_CUR =""; //旧保费币种

  //String N_PRM1 ="";//原保费
  //String N_PRM_VAR ="";//保费变化
%>


<%
  //modify in 2000-11-06

  System.out.println("2001-03-29 Private :"+ Objects.getHt(hashData,"N_RATE"));
  double RateToConverted = (Objects.ToDouble(Objects.getHt(hashData,"N_RATE")))*100;
  String  RateConverted = Objects.getTrimZero(""+RateToConverted);
  System.out.println("Private RateConverted:"+RateConverted);
  String HelpRef1 = "<a href=\"ViewHelp.jsp?path=";
  String HelpRef2 = "\" onclick=\"return js_openSmallPage(this.href);\"><img src=\"images/inline-help1.gif\" border=0></a>";

%>

  <form name="nf" method="POST" action = "PolicyMid.jsp" >

        <table width="100%" border="0" cellspacing="0" cellpadding="0"  bordercolor="#F6F6F6">
          <tr>
            <td height="15"></td>
          </tr>
          <tr >
            <td ><img src ="images/baodpg-b.gif" width="150" height="31" alt="保单批改"></td>
          </tr>
          <tr align="right">
            <td height="15"><font color="#ff0000">打*的项目必须填写</font></td>
          </tr>
          <tr>
            <td height="15">投保人(Proposer) ：
		    <%if(!(ClientType.equals(Const.CUST_AG))){%>
			  <input type="text"  disabled  name="C_APP_NME" size="60" value="<%=ClientName%>">
			<%}else{%>
			   <input type="text" name="C_APP_NME" size="60" value="<%=Objects.getHt(hashData,"C_APP_NME")%>">
			<%}%>
              <br> 被保险人(Insured)：			  
    		  <input type="text" <%=Objects.getHt(hashData,"C_INSRNT_NME")%> name="C_INSRNT_NME" maxlength="100" size="60" value="<%=Objects.getHt(hashData,"C_INSRNT_NME")%>">*</td>
						</tr>

          <tr>
            <td height="15"></td>
          </tr>
        
            <td height="15">
              <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#3399FF" bordercolordark="#FFFFFF"  bordercolor="#F6F6F6">
                <tr>
                  <td width="7%" bgcolor="#EFEFEF">货物大类:
                  <%=HelpRef1%>category.txt<%=HelpRef2%>
                  <br>Classification</td>
                  <td width="32%">
      <select  name="C_CRGO_CLS" size="1" onChange="forward(nf,temp,C_CRGO_CLS,'0'); return true;">
                <option  value="">请选择</option>
           <%
	   if(CargoClsLen > 1)
	   {
	     for(i = 1 ;i< CargoClsLen;i++ )
	     {
	   %>
                <option  <%if(Objects.getHt(hashData,"C_CRGO_CLS").equals(CargoCls[i][c_crgo_cls])){%>selected<%}%>  value=<%=CargoCls[i][c_crgo_cls]%>><%=CargoCls[i][c_crgo_cnm]%></option>
	   <%
	      }
	    }
	   %>

      </select> *</td>
                 </tr>

                <tr>
                  <td width="7%" bgcolor="#EFEFEF">货物细类:<br>Sub Class</td>
                  <td width="32%">
     <%if(ClientType.equals(Const.CUST_AG)){%>
      <select name="C_CRGO_CDE" size="1">
     <%}else{%>
	   <select name="C_CRGO_CDE" size="1">
	 <%}%>
                <option  value="">请选择</option>
          <%
	   if(CargoTypeLen > 1)
	   {
	     int c_crgo_cde = Objects.getColNum("c_crgo_cde",CargoType);
	    // c_crgo_cnm = Objects.getColNum("c_crgo_cnm",CargoType);

	     for(i = 1 ;i< CargoTypeLen;i++ )
	     {
	   %>
                <option  <%if(Objects.getHt(hashData,"C_CRGO_CDE").equals(CargoType[i][c_crgo_cde])){%>selected<%}%>  value=<%=CargoType[i][c_crgo_cde]%>><%=CargoType[i][c_crgo_cnm]%></option>
	   <%
	      }
	    }
	   %>

      </select>
                 *</td>
                 </tr>



<% if(Objects.getHt(hashData,"C_CREDIT_ID").equals(HASCREDIT)){%> 
    <tr>
        <td width="7%" bgcolor="#EFEFEF">货物描述:
                  <br>Description</td>
                  <td width="37%">
	                <textarea rows="2" name="C_CRGO_DESC" onblur="LimitLength(C_CRGO_DESC,199);" cols="48"><%=Objects.getHt(hashData,"C_CRGO_DESC")%></textarea>*
                  </td>
                </tr>
     <%}else{%>
                <tr>
                  <td width="7%" bgcolor="#EFEFEF">货物名称:
                  <%=HelpRef1%>goods-descrip.txt<%=HelpRef2%>
                  <br>Description</td>
                  <td width="32%">
	     <textarea rows="2"  name="C_CRGO_NAME" onblur="LimitLength(C_CRGO_NAME,199);" cols="48"><%=Objects.getHt(hashData,"C_CRGO_NAME")%></textarea>
                    * </td>
                </tr>
                <tr>
                  <td width="7%" bgcolor="#EFEFEF">货物包装:
                  <%=HelpRef1%>packing-descrip.txt<%=HelpRef2%>
                  <br>Packing Desc</td>
                  <td width="32%">
      <input type="text"  name="C_PACK_CNM" size="60" maxlength="60" value="<%=Objects.getHt(hashData,"C_PACK_CNM")%>">
                    * </td>
                </tr>

                <tr>
                  <td width="7%" bgcolor="#EFEFEF">数量及单位:<br>Quantity</td>
                  <td width="38%">
        <input type="text"  name="C_AMOUNT" size="30" maxlength="200" value="<%=Objects.getHt(hashData,"C_AMOUNT")%>">
                    *</td>
                </tr>

                <tr>

                  <td width="7%" bgcolor="#EFEFEF">唛头:
                  <%=HelpRef1%>Marks.txt<%=HelpRef2%>
                  <br>Marks</td>
                  <td width="37%">
	    <textarea rows="2" name="C_MARK" cols="48"  onblur="LimitLength(nf.C_MARK,199);"><%=Objects.getHt(hashData,"C_MARK")%></textarea>
      <input type="hidden"  name="C_CRGO_DESC" value="<%=Objects.getHt(hashData,"C_CRGO_DESC")%>">
                  </td>
                </tr>
<%}%>                
              </table>
            </td>
          </tr>
          <tr> 
            <td height="15">&nbsp;</td>
          </tr>
          <tr> 
            <td height="15"> 
              <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#0099FF" bordercolordark="#FFFFFF"  bordercolor="#F6F6F6">
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">发票金额:
                  <%=HelpRef1%>invoice-amount.txt<%=HelpRef2%>
                  <br>Invoice Amount</td>
                  <td  colspan="3"> 
        <input type="text" name="N_INVC_AMT" maxlength="12" size="14" onblur="setPrm(N_INVC_AMT,N_AMT,TRAN_TYPE_TEMP);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM);setPrmChange(N_PRM,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;" value=<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_INVC_AMT"),2))%>>
        <input type="hidden" name="C_INVC_AMT_CUR"  size="12" value=<%=Objects.getHt(hashData,"C_INVC_AMT_CUR")%>>
        <select name="C_INVC_AMT_CUR_TEMP" size="1"  disabled onChange="setCur(C_INVC_AMT_CUR_TEMP,C_AMT_CUR,C_PRM_CUR,C_INVC_AMT_CUR,C_AMT_CUR_CNM,C_PRM_CUR_CNM);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM);setOldN_PRM(N_PRM1,N_PRM1_TEMP,C_INVC_AMT_CUR_TEMP,OLD_PRM_CUR);setPrmChange(N_PRM,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
          <%
	   if(CurrencyLen > 1)
	   {
	      boolean IsSelect = false;
	     for(i = 1 ;i< CurrencyLen;i++ ) 
	     {          
	   %>
                <option  <%if(Objects.getHt(hashData,"C_INVC_AMT_CUR").equals(Currency[i][c_cur_no])){IsSelect = true;%>selected<%}%>  value=<%=Currency[i][c_cur_no]+"&"+Currency[i][n_chg_rte]+"&"+Currency[i][c_cur_cnm]%>><%=Currency[i][c_cur_cnm]%></option>        	   
	   <%
	     }
	     if(!IsSelect & !IsNewPlyApp) 
	     {
	   %>
                <option selected value=""><%=Const.SELECT%></option>        	   
	   <%

	     }
	    }  
	   %> 
        </select>
                    *</td>
                </tr>

                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">发票号码:
                  <%=HelpRef1%>invoice-bill.txt<%=HelpRef2%>
                  <br>Invoice NO.</td>
                  <td width="32%"> 
        <input type="text" name="C_INVC_NO" maxlength="60" size="14" value="<%=Objects.getHt(hashData,"C_INVC_NO")%>">
                  </td>
                <tr> 

                  <td width="7%" bgcolor="#EFEFEF">提单/运单号
                  <%=HelpRef1%>invoice-bill.txt<%=HelpRef2%>
                  <br>B/L NO.</td>
                  <td width="33%"> 
        <input type="text" name="C_RECEIPT_NO" maxlength="50" size="14" value="<%=Objects.getHt(hashData,"C_RECEIPT_NO")%>">
                  </td>
                </tr>

                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">船名/车号/航班<br>Conveyance NO.</td>
                  <td colspan="3">
				  <% System.out.println("PolicyC.jsp Container:"+Objects.getHt(hashData,"C_CONTAINER")); 
				  %>
        <input type="text" name="C_SAIL_NO" maxlength="60" size="14" value="<%=Objects.getHt(hashData,"C_SAIL_NO")%>">*  	  		       
        <input type="radio" name="C_CONTAINER" <%if(Objects.getHt(hashData,"C_CONTAINER").equals("集装箱整箱")){%> checked <%}%> value="集装箱整箱">
        集装箱整箱(FCL)
        <input type="radio" name="C_CONTAINER" <%if(Objects.getHt(hashData,"C_CONTAINER").equals("集装箱拼箱")){%> checked <%}%> value="集装箱拼箱">
        集装箱拼箱(LCL)
        <input type="radio" name="C_CONTAINER" <%if(Objects.getHt(hashData,"C_CONTAINER").equals("非集装箱运输")){%> checked <%}%> value="非集装箱运输">
        非集装箱(NCL)
        </td>
                </tr>

                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">起运港<%=NameStr%>：<br>From</td>
                  <td colspan="3"> 
        <select name="C_FRM_PRT_ARA" size="1" >
          <%
	   if(TranType.equals(EXPORT) || TranType.equals(HOME))
           {
           %>
                          <option value=<%=Const.CHINA_CDE%>>China(<%=Const.CHINA_CNM%>) </option>
          <%      
           }
           else
           {
%>
                <option selected value="">请选择</option>
<%
		   if(AreaLen > 1)
		   {

		     for(i = 1 ;i< AreaLen;i++ ) 
		     {          
		        String AraCdeTemp = Area[i][c_ara_cde];
		        int PointTemp = AraCdeTemp.length() - 2;
		        String CdeLastTwo = AraCdeTemp.substring(PointTemp);  
		        if(!(CdeLastTwo.equals("00")))
		        {
		     
		   %>
	                <option  <%if(Objects.getHt(hashData,"C_FRM_PRT_ARA").equals(Area[i][c_ara_cde])){%>selected<%}%>  value=<%=Area[i][c_ara_cde]%>><%=Area[i][c_ara_enm]%>(<%=Area[i][c_ara_cnm]%>)</option>        	   
		   <%
		        }
		      }
		    }  
           }
		   %> 
          
        </select>
                    *</td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">起运港名称：
                  <br>Port</td>
                  <td colspan="3"> 
        <input type="text" <%=Objects.getHt(hashData,"C_FROM_PRT")%> name="C_FROM_PRT" maxlength="60" size="25" value="<%=Objects.getHt(hashData,"C_FROM_PRT")%>">
                    *</td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">目的港<%=NameStr%>
                          <%=HelpRef1%>destArea.txt<%=HelpRef2%>
                  <br>To</td>
                  <td colspan="3"> 
        <select name="C_TO_PRT_ARA" size="1" >
          <%
	   if(TranType.equals(IMPORT) || TranType.equals(HOME))
           {
           %>
                          <option value= <%=Const.CHINA_CDE%>>(China)<%=Const.CHINA_CNM%> </option>
          <%      
           }
           else
           {
%>
                <option selected value="">请选择</option>
<%

		   if(AreaLen > 1)
		   {

		     for(i = 1 ;i< AreaLen;i++ ) 
		     {          
		        String AraCdeTemp1 = Area[i][c_ara_cde];
		        int PointTemp = AraCdeTemp1.length() - 2;
		        String CdeLastTwo = AraCdeTemp1.substring(PointTemp);  
		        if(!(CdeLastTwo.equals("00")))
		        {
		     
		     
		   %>
	                <option  <%if(Objects.getHt(hashData,"C_TO_PRT_ARA").equals(Area[i][c_ara_cde])){%>selected<%}%>  value=<%=Area[i][c_ara_cde]%>><%=Area[i][c_ara_enm]%>(<%=Area[i][c_ara_cnm]%>)</option>        	   
		   <%
		        }
		      }
		    }  
           }
		   %> 
          
        </select>
                    *</td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">目的港名称:
                  <%=HelpRef1%>destination.txt<%=HelpRef2%>
                  <br>Port</td>
                  <td colspan="3"> 
        <input type="text" <%=Objects.getHt(hashData,"C_TO_PRT")%> name="C_TO_PRT" maxlength="60" size="25" value="<%=Objects.getHt(hashData,"C_TO_PRT")%>" <% if(TranType.equals(EXPORT)){%> onChange="ChangePay_Addr(C_TO_PRT,C_PAY_ADDR);ChangePay_Addr(C_TO_PRT,C_SRVY_ADDR);return true;" <%}%>>
                    *</td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">途径港名称：<br>Via</td>
                  <td colspan="3">
        <input type="text" name="C_PASS_PRT"  maxlength="40" size="25" value="<%=Objects.getHt(hashData,"C_PASS_PRT")%>">
                  </td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">起运日期：
                  <%=HelpRef1%>date.txt<%=HelpRef2%>
                  <br>Slg.on or abt.</td>
                  <td width="33%"> 
        <input type="text" name="birth_year" size="4"  maxlength="4" value=<%=birth_year%> onfocus="ChangeDate(birth_year,birth_month,birth_day,C_PRN_FRM)" onChange="change(birth_year,birth_month,birth_day,tempdate);return ValidDateNew(tempdate,birth_year)&&ChangeDate(birth_year,birth_month,birth_day,C_PRN_FRM)">
        年 
        <input type="text" name="birth_month" size="2" maxlength="2" value=<%=birth_month%> onChange="change(birth_year,birth_month,birth_day,tempdate);return ValidDateNew(tempdate,birth_year)&&ChangeDate(birth_year,birth_month,birth_day,C_PRN_FRM)">
        月 
        <input type="text" name="birth_day" size="2" maxlength="2" value=<%=birth_day%> onChange="change(birth_year,birth_month,birth_day,tempdate);return ValidDateNew(tempdate,birth_year)&&ChangeDate(birth_year,birth_month,birth_day,C_PRN_FRM)">
        日*
        </td>
        <input type="hidden" name="tempdate" value="2000-08-23">
    	</tr>

		<tr><td width="7%" bgcolor="#EFEFEF">打印格式：<br>Prn Form</td>
            <td colspan="3">
        
		<%
		   String yy = birth_year;
		   String mm = birth_month;
		   String dd = birth_day; 
		   String f1 = yy + "年" + mm +"月" + dd + "日" ;
		   System.out.println("yy:"+yy+",mm:"+mm+",dd:"+dd);
		   String f2 = StringTool.getDateString(yy+"-"+ mm + "-"+ dd,"ENG");
		   System.out.println("f2:"+f2);		   
		   f2= f2.toUpperCase();
		   //out.println(Objects.getHt(hashData,"C_PRN_FRM"));
		%>
		<select name="C_PRN_FRM">
		 <option value="<%=f2%>" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals(f2)){%> selected <%}%>><%=f2%>
		 <option value="<%=f1%>" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals(f1)){%> selected <%}%>><%=f1%>
		 
		 <option value="详见提单" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("详见提单")){%> selected <%}%>>详见提单
		 <option value="AS PER B/L" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("AS PER B/L")){%> selected <%}%>> AS PER B/L
		 <option value="TO BE ADVISED" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("TO BE ADVISED")){%> selected <%}%>> TO BE ADVISED
		 <option value="待告知" <% if(Objects.getHt(hashData,"C_PRN_FRM").equals("待告知")){%> selected <%}%>> 待告知 

		</select>
                  </td>
                </tr>
        <%if(TranType.equals(EXPORT)){%>
        <tr><td width="7%" bgcolor="#EFEFEF">查勘代理人地点:</td>
             <td colspan="3"><input type="text" name="C_SRVY_ADDR" value="<%=Objects.getHt(hashData,"C_SRVY_ADDR")%>">*</td></tr>
		 <tr><td width="7%" bgcolor="#EFEFEF">赔款偿付地点:</td>
			 <td colspan="3"><input type="text"  name="C_PAY_ADDR" value="<%=Objects.getHt(hashData,"C_PAY_ADDR")%>">*</td>    
        </tr>
		<%}%>
        <input type="hidden" name="C_PRM_CUR" size="12" value=<%=Objects.getHt(hashData,"C_PRM_CUR")%>>
        <input type="hidden" name="C_AMT_CUR" value=<%=Objects.getHt(hashData,"C_AMT_CUR")%>>

	     	<tr> 
                  <td width="7%" bgcolor="#EFEFEF">保险金额：
                  <%=HelpRef1%>amount-insured.txt<%=HelpRef2%>
                  <br>Amount Insured</td>
                  <td colspan="3"> 
        <input type="text" name="N_AMT" size="12" maxlength="19"  onblur="setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM); setPrmChange(N_PRM,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);prm();return true;" value=<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_AMT"),2))%>>
		<% 
		 Currency_NAME ="";
		 if(CurrencyLen > 1)
	     {
	      for(i = 1 ;i< CurrencyLen;i++ )
	      {
	              if(Objects.getHt(hashData,"C_AMT_CUR").equals(Currency[i][c_cur_no])){
				   Currency_NAME = Currency[i][c_cur_cnm];
				   break;
				  } 	   
	      }
	    }
	   %>
        <input type="text" disabled name="C_AMT_CUR_CNM" size="8" maxlength="20" value="<%=Currency_NAME%>">
       （<%if(!(TranType.equals(HOME))){%>如保险金额超过发票金额110%,请在备注栏说明原因<%}else{%>保险金额按货价或货价加运杂费确定<%}%>）
        </td>
                </tr>
           
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">费率：
                <%if(!ClientType.equals(Const.CUST_AG)){%>  <%=HelpRef1%>rate.txt<%=HelpRef2%><%}%>
                  <br>Rate</td>
                  <td width="32%">
        <% if(ClientType.equals(Const.CUST_AG)){%>
		   <input type="text" name="N_RATE_VAR" size="12" maxlength="20"  disabled  onblur="ValidRate(N_RATE);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM);return true;"  value="<%=RateConverted%>">%
		<%}else{%>
		   <input type="text" name="N_RATE" size="12" maxlength="20"  onblur="ValidRate(N_RATE);setAmt(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM);return true;"  value="<%=RateConverted%>">%
		<%}%>
        
		  </td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">保险费：<br>Premium</td>
                  <td width="33%"> 
        <input type="text" name="N_PRM_DISP" size="12" maxlength="19" disabled value="<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_PRM"),2))%>" onblur="SetRate(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM); setPrmChange(N_PRM,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
		<input type="hidden" name="N_PRM" size="12" maxlength="19" value="<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_PRM"),2))%>" onblur="SetRate(N_AMT,N_RATE,C_INVC_AMT_CUR_TEMP,N_PRM); setPrmChange(N_PRM,N_PRM1,N_PRM1_TEMP,N_PRM2,N_PRM_VAR,N_PRM_VAR_TEMP,N_PRM_CHANGE,N_PRM_CHANGE_TEMP);return true;">
		<% 
		 Currency_NAME ="";
		 if(CurrencyLen > 1)
	     {
	      for(i = 1 ;i< CurrencyLen;i++ )
	      {
	              if(Objects.getHt(hashData,"C_PRM_CUR").equals(Currency[i][c_cur_no])){
				   Currency_NAME = Currency[i][c_cur_cnm];
				   //need test 
				   if(step == Const.STEP_BEG){
				     OLD_PRM_CUR = Currency[i][c_cur_no]+"&"+Currency[i][n_chg_rte]+"&"+Currency[i][c_cur_cnm];
				   }
				   break;
				  } 	   
	      }
	    }
	   %>
        <input type="text" disabled name="C_PRM_CUR_CNM" size="8" maxlength="20" value=<%=Currency_NAME%>>
                  </td>
                </tr>
                <tr> 
                  <td width="7%" bgcolor="#EFEFEF">免赔： <br>Deductible</td>
                  <td colspan="3"> 
        <input type="text" name="C_NO_REPAY" size="65" maxlength="100" value="<%=Objects.getHt(hashData,"C_NO_REPAY")%>">
 		  </td>
                </tr>

<input type="hidden"  name="TRAN_TYPE_TEMP" size="12" value=<%=TranType%>>
    
<%

     if(!(TranType.equals(EXPORT) & Credit.equals(HASCREDIT)))
         {
      %>

    <tr>
         <td width="7%" bgcolor="#EFEFEF">主险：<br>Risks</td>
          <td colspan="3">		 
       <%
     if(!(TranType.equals(HOME)))
      {
        if((TranType.equals(IMPORT) || (TranType.equals(EXPORT) & Credit.equals(NOCREDIT) )) & PortTransit[Const.N_SEA_CDE].equals(Const.C_LANDWAY_CDE))
        {//海运
		RadioCheckHash = Objects.getHt(hashData,"C_MAIN_INSURANCE1");
	
		if(!RadioCheckHash.equals(""))
		    RadioCheckHash = RadioCheckHash.substring(0,2);
		IsMainInsrncSelect = false;    

        System.out.print("okokok IMPORT EXPORT SEA WAY main POlicy.jsp:");
		System.out.print(RadioCheckHash);           
		System.out.println("\n");


              for(i=0;i<6;i++)
              {
                 RadioCheckValue = Const.C_H_B0102_CDE[i]+"&"+Const.C_H_B0102_CNM[i];
                 Temp  = RadioCheckValue.substring(0,2);
           %>
			<input type="radio" name="C_MAIN_INSURANCE1" <%if(RadioCheckHash.equals(Temp) || ServTool.IsInArray(AddInsrnc,Temp) || (i == 5 & (!IsMainInsrncSelect))) {IsMainInsrncSelect = true; %>checked<%}%>
			value="<%=RadioCheckValue%>" > <%=Const.C_H_B0102_CNM[i]%>
           <%
              }
          }
         if((TranType.equals(IMPORT) || (TranType.equals(EXPORT) & Credit.equals(NOCREDIT) )) & PortTransit[Const.N_LANDWAY_CDE].equals(Const.C_LANDWAY_CDE))
         {
		RadioCheckHash = Objects.getHt(hashData,"C_MAIN_INSURANCE2");
		if(!RadioCheckHash.equals(""))
		    RadioCheckHash = RadioCheckHash.substring(0,2);
		IsMainInsrncSelect = false;     
		   System.out.print("okokok IMPORT EXPORT main LAND WAY POlicy.jsp:");
           
              for(i=6;i<8;i++)
              {
                 RadioCheckValue = Const.C_H_B0102_CDE[i]+"&"+Const.C_H_B0102_CNM[i];
                 Temp  = RadioCheckValue.substring(0,2);
              
           %>

			<input type="radio" name="C_MAIN_INSURANCE2" <%if(RadioCheckHash.equals(Temp)  || ServTool.IsInArray(AddInsrnc,Temp) || (i == 7 & (!IsMainInsrncSelect))) {IsMainInsrncSelect = true; %>checked<%}%>
			value="<%=RadioCheckValue%>"> <%=Const.C_H_B0102_CNM[i]%>
           <%
              }
          }
         if((TranType.equals(IMPORT) || (TranType.equals(EXPORT) & Credit.equals(NOCREDIT) )) & PortTransit[Const.N_AVIATION_CDE].equals(Const.C_LANDWAY_CDE))
         {
		RadioCheckHash = Objects.getHt(hashData,"C_MAIN_INSURANCE3");
		if(!RadioCheckHash.equals(""))
		    RadioCheckHash = RadioCheckHash.substring(0,2);
                IsMainInsrncSelect = false; 		    
               System.out.print("okokok IMPORT EXPORT main AIR WAY POlicy.jsp:");
           
              for(i=8;i< 10;i++)
              {
                 RadioCheckValue = Const.C_H_B0102_CDE[i]+"&"+Const.C_H_B0102_CNM[i];
                 Temp  = RadioCheckValue.substring(0,2);
              
           %>
			<input type="radio" name="C_MAIN_INSURANCE3" <%if(RadioCheckHash.equals(Temp) || ServTool.IsInArray(AddInsrnc,Temp) || (i == 9 & (!IsMainInsrncSelect))) {IsMainInsrncSelect = true; %>checked<%}%>
			value="<%=RadioCheckValue%>"> <%=Const.C_H_B0102_CNM[i]%>
           <%
              }
        }
          }
       
      
       if(TranType.equals(HOME))
       {
		RadioCheckHash = Objects.getHt(hashData,"C_MAIN_INSURANCE4");
		if(!RadioCheckHash.equals(""))
		    RadioCheckHash = RadioCheckHash.substring(0,2);
		
		IsMainInsrncSelect = false;     
			  /*LK0001+B*/
			  boolean isHomeAviation = false;
			  for (i=0;i<HomeTransit.length;i++){
				  if (HomeTransit[i] != null && HomeTransit[i].equals(Const.C_H_AVIATION_CDE))
				  {
						isHomeAviation = true;
						break;
				  }
				}
				//set the start index of the insruance code
				int indexStart = 0;//default value for home is 0
				if (isHomeAviation)//should be special handled  for home aviation
				{
					indexStart = 2;
				}
				  
			  /*LK0001+E*/
              for(i=indexStart;i<indexStart+2;i++)
              {
                 RadioCheckValue = Const.C_H_B03_CDE[i]+"&"+Const.C_H_B03_CNM[i];
                 Temp  = RadioCheckValue.substring(0,2);
              
           %>
			<input type="radio" name="C_MAIN_INSURANCE4" <%if(RadioCheckHash.equals(Temp) || ServTool.IsInArray(AddInsrnc,Temp) || (i == 1 & (!IsMainInsrncSelect))) {IsMainInsrncSelect = true; %>checked<%}%>
			value="<%=RadioCheckValue%>"> <%=Const.C_H_B03_CNM[i]%>
           <%
              }
           }
        %>
           </td>
        </tr>

      <%
         if(!((TranType.equals(EXPORT) & Credit.equals(HASCREDIT)) || TranType.equals(HOME)))
         {
      %>
    <tr>
         <td width="7%" bgcolor="#EFEFEF">附加险：<br>Add-Risks</td>
           <td colspan="3">
        
           <%
              String CheckboxName1 ="C_ADD_INSURANCE";
              String  CheckboxName = "";
              for(i=0;i<13;i++)
              {
              	CheckboxName = CheckboxName1 + String.valueOf(i);
		RadioCheckHash = Objects.getHt(hashData,CheckboxName);
		if(!(RadioCheckHash.equals("") || RadioCheckHash == null))
		    RadioCheckHash = RadioCheckHash.substring(0,2);
                 RadioCheckValue = Const.C_H_ADD_CDE[i]+"&"+Const.C_H_ADD_CNM[i];
                 Temp  = RadioCheckValue.substring(0,2);

                 if((i%5) == 0 && i>4)
                 {
           %>
        	  <br>
        <%
        	  }
         %>             
			<input type="checkbox" name="<%=CheckboxName%>" <%if(RadioCheckHash.equals(Temp) || ServTool.IsInArray(AddInsrnc,Temp)) {%>checked<%}%>
			value="<%=RadioCheckValue%>"> <%=Const.C_H_ADD_CNM[i]%>
        <%

               }
        %>
           </td>
        </tr>

	<tr>
          <td width="7%" bgcolor="#EFEFEF">其它附加险<br>Other Add-Risks</td>
          <td height="12" colspan="3"> 
      <textarea rows="3" name="C_ADD_RISK" cols="65" maxlength="500"><%=Objects.getHt(hashData,"C_ADD_RISK")%></textarea>
      </td>
    </tr>
    
        <%
           }
       }    
         if(TranType.equals(EXPORT) & Credit.equals(HASCREDIT))
         {

        %>
    <tr>
          <td width="7%" bgcolor="#EFEFEF">保险条件<br>Insurance Conditions</td>
          <td height="12" colspan="3"> 
       <textarea rows="3" name="C_UNDR_CNDTN" cols="60" maxlength="500"><%=Objects.getHt(hashData,"C_UNDR_CNDTN")%></textarea>
      *</td>
    </tr>
      <%
        }
      %>
              </table>
            </td>
          </tr>
          <tr> 
            <td height="15"></td>
          </tr>
          <tr> 
            <td height="15">以往损失记录(过去三年)(Loss Record)：</td>
          </tr>
          <tr align="left"> 
            <td height="15"> 
  <input type="text" name="C_LOST_DESC" size="81" maxlength="500" value="<%=Objects.getHt(hashData,"C_LOST_DESC")%>">
            </td>
          </tr>
          <tr> 
            <td height="15">备注(可填写多项货物及费率要求描述等)(Remarks)：
            <%=HelpRef1%>remark.txt<%=HelpRef2%>
            </td>
          </tr>
          <tr align="left"> 
            <td height="15"> 
   <textarea rows="2" name="C_REMARK" onblur="LimitLength(C_REMARK,2000);" cols="80" maxlength="500" <%if(RemoteOperType.equals(Const.REMOTE_PLY)){%> onkeydown="return false;" <%}%>><%=Objects.getHt(hashData,"C_REMARK")%></textarea> 
            </td>
          </tr>
          <tr> 
            <td height="15">&nbsp;</td>
          </tr>
 <% if(ClientType.equals(Const.CUST_AG)){
		    /* 代理不能成保条件*/
			if (_limitDesc == null){//LK0002++
				boolean disabled = false;
				String AgentInfo[][] = null;
				String agencyParas[]={pmb.plyEdrAppInfo.c_agt_agr_no,
		                pmb.plyEdrAppInfo.c_insrnc_cde,
						Objects.getHt(hashData,"C_CRGO_CLS"),
						Objects.getHt(hashData,"C_CRGO_CDE")};
				try{ 
 					pb.setFormPara(Const.GET_AGENCYINFO,agencyParas);
				}catch(NormalException e){
					disabled = true;
					if(NormalExceptionHandler.IsSevere(e))
 						throw NormalExceptionHandler.Handle(e);
 					else if(NormalExceptionHandler.IsWarning(e))    
 						WarnMsg = e.getErrDesc(); 
				}
				if(!disabled){
					AgentInfo = pb.getRetValueArra();
					int c_limit_desc = Objects.getColNum("C_LIMIT_DESC",AgentInfo);
					C_LIMIT_DESC =  (AgentInfo[1][c_limit_desc]).trim();
				}
			}else{//LK0002++
				C_LIMIT_DESC = _limitDesc;//LK0002++
			}//LK0002++
  %>
   <tr><td height="15">限制承保货物：</td>
          </tr>
   <tr align="left">
            <td height="15" >
	  <%/*LK0002+B*/%>
	  <input type="hidden" name="LimitDesc" value="<%=C_LIMIT_DESC%>">
	  <%/*LK0002+E*/%>
   <textarea rows="2" name="C_LIMIT_CARGO" cols="80" maxlength="500" disabled = true ><%=C_LIMIT_DESC%></textarea>
            </td>
          </tr>
   <tr><td height=15>&nbsp;</td></tr>
   
 <%}%>
<%if(!(ClientType.equals(Const.CUST_AG)))
  {    
%>    
          <tr> 
            <td height="15"> 
              <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolorlight="#6699FF" bordercolordark="#FFFFFF" bordercolor="#F6F6F6">
                <tr> 
                  <td width="11%" bgcolor="#EFEFEF">送单时间:</td>
                  <td width="30%">从发出承保通知开始一个工作日内</td>
                  <td width="11%" bgcolor="#EFEFEF">送单地点:</td>
                  <td width="39%"> 
          <select name="C_PROVINCE" size="1" disabled onChange="forward(nf,temp,C_PROVINCE,'1'); return true;">
          <%
               if(ProvinceLen > 1)
                   {
                      for(i = 1; i < ProvinceLen; i++)
                      {
          %>
                          <option <%if(Objects.getHt(hashData,"C_PROVINCE").equals(Province[i][c_city])){%>selected<%}%> value=<%=Province[i][c_city]%>> <%=Province[i][c_city_cnm]%> </option>
         <%       
                       }
                    }   
         %>           

          </select> 市/县/区: 
          <select name="C_CITY" size="1" disabled>
          <%
               if(CityLen > 1)
                   {
        	        c_city = Objects.getColNum("c_city",City);
  	                c_city_cnm = Objects.getColNum("c_city_cnm",City);
                        int c_dpt_cde =  Objects.getColNum("c_dpt_cde",City);
                        String value = "";
                      for(i = 1; i < CityLen; i++)
                      {
		   	value = City[i][c_city]+"&"+City[i][c_dpt_cde]+"&"+City[i][c_city_cnm];                      
          %>
          <option <%if(Objects.getHt(hashData,"C_CITY").equals(City[i][c_city])){%>selected<%}%> value=<%=value%>> <%=City[i][c_city_cnm]%> </option>
         <%       
                       }
                    }   
          %>          
          </select> *
	  </td>
    </tr>
                <tr> 
                  <td width="11%" height="26" bgcolor="#EFEFEF" nowrap>详细地址: 
                  <%=HelpRef1%>address.txt<%=HelpRef2%>
                  </td>
                  <td colspan="3" height="26"> 
        <input type="text" name="C_PLACE" size="65" maxlength="100" value="<%=Objects.getHt(hashData,"C_PLACE")%>">
         *</td>
    </tr>
                 <tr> 
                  <td width="11%" height="26" bgcolor="#EFEFEF">联系人:</td>
                  <td width="39%" height="26"> 
        <input type="text" <%=ob.getFieldProp("C_CONTACT_NAME")%> name="C_CONTACT_NAME" size="14"  maxlength="20" value="<%=Objects.getHt(hashData,"C_CONTACT_NAME")%>">
                    *</td>
                  <td width="11%" height="26" bgcolor="#EFEFEF">联系电话:</td>
                  <td width="39%" height="26">

        <input type="text" <%=ob.getFieldProp("C_CONTACT_PHONE")%> name="C_CONTACT_PHONE" size="15"  maxlength="20" value="<%=(Objects.getHt(hashData,"C_CONTACT_PHONE").trim())%>">
                    *</td>
                </tr>
                <tr> 
                  <td width="11%" bgcolor="#EFEFEF">传真:</td>
                  <td width="39%"> 
        <input type="text" <%=ob.getFieldProp("C_CONTACT_FAX")%>  name="C_CONTACT_FAX" size="14" maxlength="20" value="<%=(Objects.getHt(hashData,"C_CONTACT_FAX").trim())%>">
                  </td>
                  <td width="11%" bgcolor="#EFEFEF">E-mail:</td>
                  <td width="39%"> 
        <input type="text" <%=ob.getFieldProp("C_CONTACT_EMAIL")%> name="C_CONTACT_EMAIL" size="15" maxlength="60" value="<%=(Objects.getHt(hashData,"C_CONTACT_EMAIL").trim())%>">
                  *</td>
                </tr>
					<tr> 
                  <td width="11%" bgcolor="#EFEFEF">邮编:</td>
                  <td  colspan=3> 
        <input type="text" <%=ob.getFieldProp("C_ZIP_CDE")%>  name="C_ZIP_CDE" size="14" maxlength="6" value="<%=(Objects.getHt(hashData,"C_ZIP_CDE").trim())%>">*
                  </td>
                  
                </tr>
              </table>
            </td>
          </tr>
          
<%
   }//end if not agent
%>  

<%
    double N_PRM_CHANGE = 0;
	double n_prm = Objects.ToDouble(Objects.getHt(hashData,"N_PRM"));
	double old_prm = Objects.ToDouble(Objects.getHt(hashData,"N_PRM1"));
	double n_prm_var1 = n_prm - old_prm;
	String n_prm_var_str = Objects.getTrimZero(Objects.getScaleNumberZero(""+n_prm_var1,3));
	if(n_prm>old_prm){
	     N_PRM_CHANGE = (n_prm - old_prm)/old_prm;		   
	}else{
		  N_PRM_CHANGE = (old_prm - n_prm)/old_prm;
	}
	N_PRM_CHANGE = N_PRM_CHANGE*100;
	String  N_PRM_CHANGE_str = Objects.getTrimZero(Objects.getScaleNumberZero(""+N_PRM_CHANGE,3));
%>
        <tr><td><table  width=100% border="1" cellspacing="1" cellpadding="0" bordercolorlight="#0099FF" bordercolordark="#FFFFFF"  bordercolor="#F6F6F6">     
        <tr><td width=25%>原保费：<input type=text size=10  disabled name="N_PRM1_TEMP" value=<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_PRM1"),2))%>>
		                            <input type=hidden name="N_PRM1" value=<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_PRM1"),2))%>>  
		                            <input type=hidden name="OLD_PRM_CUR" value="<%=OLD_PRM_CUR%>">
		</td><td width=25%>最新保费：<input type=text size=10 disabled name="N_PRM2" value=<%=Objects.getTrimZero(Objects.getScaleNumber(Objects.getHt(hashData,"N_PRM"),2))%>>
		</td><td width=50%>保费变化：<input type=hidden  name="N_PRM_VAR" value= "<%=n_prm_var_str%>">
		    <input type=text size=8 disabled name="N_PRM_VAR_TEMP" value="<%=n_prm_var_str%>">
		    <input type=text size=5 disabled name="N_PRM_CHANGE_TEMP" value="<%=N_PRM_CHANGE_str%>">%
			<input type=hidden name="N_PRM_CHANGE" value="<%=N_PRM_CHANGE_str%>">
          </td>
        </tr>
        <tr>
	    <td  colspan=3>批改原因:*		
	    </td>
	    </tr>
        <tr><td colspan=3><textarea rows="2" name="C_EDR_CTNT" cols="78" onblur="LimitLength(C_EDR_CTNT,500)" ><%=Objects.getHt(hashData,"C_EDR_CTNT")%></textarea>
		 </td></tr>
       </table> 
       </td>
   </tr>
         
          <tr> 
            <td height="15">&nbsp;</td>
          </tr>
          <tr align="center"> 
            <td height="15">
               <select name="language" size="1">			   
		       <option value="ENG" selected>英</option>
			   <option value="CHN">中</option>
               </select>
               <input type="button" value="提  交" name="B1" onclick="sub(temp);change(this.form.birth_year,this.form.birth_month,this.form.birth_day,this.form.tempdate);CheckForm(this.form);return true;">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				
                <input type="reset" value="重  填" name="B2">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
		<input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>                  
            </td>
          </tr>
        </table>
      <%String sessionid = Code.Encrypt(sessionId);%>
    <input type="hidden" name="sessionid" value="<%=sessionid%>">
    <input type="hidden" name="temp" value="sub">
    <input type="hidden" name="C_PLY_APP_NO" value="<%=Objects.getHt(hashData,"C_PLY_APP_NO")%>">    
    <input type="hidden" name="AGENCYNO" value="<%=AgencyNo%>">
    <input type="hidden" name="ADDAGENCYNO" value="<%=AddAgencyNo%>">
        <input type="hidden" name="TEMPAMT" value="">
        <input type="hidden" name="TEMPAMT1" value=""> 
		<% if(ClientType.equals(Const.CUST_AG)){%>
		 <input type="hidden"  name="N_RATE" size="12" value="<%=RateConverted%>">               
        <%}%> 

      </form>



    </td>
  </tr>
</table>

     
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
<script language=JavaScript>
function CheckForm(theForm){
TrimForm(theForm);
if(ValidDateNew(theForm.tempdate,theForm.birth_year) &&
ValidDateBegin(theForm.tempdate,'<%=Sdate%>',theForm.birth_year,theForm.C_REMARK) &&
ValidNull(theForm.C_APP_NME,false) &&
ValidNull(theForm.C_INSRNT_NME,false) &&
ValidNull(theForm.C_EDR_CTNT,false) &&
<%if((ClientType.equals(Const.CUST_AG))){%>
AlertWin()&&
<%}%>
<%if(!(ClientType.equals(Const.CUST_AG)))
  {
%>
ValidNull(theForm.C_PLACE,false) &&
ValidNull(theForm.C_CONTACT_NAME,false) &&
ValidNull(theForm.C_CONTACT_PHONE,false) &&
ValidNull(theForm.C_CONTACT_EMAIL,false) &&
ValidNull(theForm.C_PROVINCE,false) &&
ValidNull(theForm.C_CITY,false) &&
ValidTel(theForm.C_CONTACT_PHONE) &&
ValidTel(theForm.C_CONTACT_FAX) &&
ValidEmail(theForm.C_CONTACT_EMAIL) &&
ValidNull(theForm.C_ZIP_CDE,false) &&
ValidZip(theForm.C_ZIP_CDE) &&
<%
   }//end if not agent N_INVC_AMT
  if(TranType.equals(EXPORT) & Credit.equals(HASCREDIT)){
	  out.println("ValidNull(theForm.C_UNDR_CNDTN,false)&&");
  }
   if(Objects.getHt(hashData,"C_CREDIT_ID").equals(HASCREDIT))
  {
%>
ValidNull(theForm.C_CRGO_DESC,false) &&
<%
   }else{
%>
ValidNull(theForm.C_PACK_CNM,false) &&
ValidNull(theForm.C_CRGO_NAME,false) &&
ValidNull(theForm.C_AMOUNT,false) &&
<%}%>
ValidNull(theForm.C_CRGO_CLS,false) &&
ValidNull(theForm.C_CRGO_CDE,false) &&
ValidNull(theForm.N_INVC_AMT,false) &&
ValidNull(theForm.C_INVC_AMT_CUR_TEMP,false) &&
ValidNull(theForm.C_SAIL_NO,false) &&
ValidNull(theForm.C_FRM_PRT_ARA,false) &&
ValidNull(theForm.C_TO_PRT_ARA,false) &&
ValidNull(theForm.C_FROM_PRT,false) &&
ValidNull(theForm.C_TO_PRT,false) &&
ValidNull(theForm.birth_year,false) &&
ValidNull(theForm.birth_month,false) &&
ValidNull(theForm.birth_day,false) &&
<%if(TranType.equals(EXPORT)){%>
ValidNull(theForm.C_SRVY_ADDR,false)&&
ValidNull(theForm.C_PAY_ADDR,false)&&
<%}%>
ValidSamePort(theForm.C_FROM_PRT,theForm.C_TO_PRT) &&
ValidNoOrReal(theForm.C_INVC_NO,theForm.C_RECEIPT_NO) &&
ValidRate(theForm.N_RATE)
){
  //alert("Success");
  theForm.B1.disabled=true;
  theForm.submit();
}else{
  //alert("false");
}
}

function AlertWin(){
	var isAlert = false;
	
	try{
		if (nf.C_REMARK.value.length > 0 )
			isAlert = true;
	}catch(e){
	}

	try{
		if(nf.C_ADD_RISK.value.length >0 )
			isAlert = true;
	}catch(e){
	}

	if (isAlert)
	return	confirm("由于“其它附加风险“或“备注“栏中有批注，将不能进行自动核保");

	return true;
}

function LimitLength(field,maxLength){
  /** verfy the max length of the field and warn */
   var extraLength;
	if (byteCount(field.value) >maxLength){
		extraLength = byteCount(field.value)  - maxLength;
		alert("该字段超长"+extraLength+"个字符");
		field.focus();
	}
}

function byteCount(s){
		var count = 0;
		var uniCode;
		for (i=0;i<s.length;i++){
			count++;
			uniCode = s.charCodeAt(i);
			if (uniCode >1000)
				count++;
		}
		return count;
	}

function prm(){
	nf.N_PRM_DISP.value = nf.N_PRM.value;
}
</script>


