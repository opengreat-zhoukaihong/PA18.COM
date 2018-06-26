<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>  

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="pab"  scope="page" class="beans.PolicyAppBean"/> 
<jsp:setProperty name="pab" property="*"/>
<jsp:useBean id="cb"  scope="request" class="beans.CustManagerBean"/>
<jsp:setProperty name="cb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>


<%  //for get login para and to bean
    System.out.println("PolicyMid.jsp start......................................");
    String PlyInfo[] = null ;
    String FormData[][] = null;    
    String InsrInfo[][] = null;        
    String Result[][] = null;
    String ClientName = sessionbuffer.getClientName(Locate);
    String CompanyId =  sessionbuffer.getCompanyId(Locate);
    String ClientId =   sessionbuffer.getClientId(Locate);
    String ClientType = sessionbuffer.getClientType(Locate);
    int i = 0;
    String Temp = "";
    Temp = request.getParameter("temp");
    String TranType = ob.getTranType();
    String[] PortTransit = ob.getPortTransit();
    String[] HomeTransit = ob.getHomeTransit();
    String[] PortTransitName = ob.getPortTransitName();
    String[] HomeTransitName = ob.getHomeTransitName();

	String DefaultCls = "";
    String DefaultProvince = "";
	boolean IsNewPlyApp = false;
	String[] DefaultCur = {"02"};

	String NOCREDIT = Const.C_NOCREDIT_CDE;//0
	String HASCREDIT = Const.C_CREDIT_CDE;//1
	String HOME = Const.C_HOME_CDE;//B03
	String EXPORT = Const.C_EXPORT_CDE;//B02
	String IMPORT = Const.C_IMPORT_CDE; //B01
	

    String Credit = ob.getCredit();
    String Transit[] = null;
    String TransitName[] = null;
    String Dept_Insrnc[] = null;
    int OperType = 0;
    int step = ob.getStep();
    String  PlyAppNo = request.getParameter("C_PLY_APP_NO");
    String ProvinceNew = request.getParameter("C_PROVINCE");
    String RemoteOperType = ob.getRemoteOperType();
    String RemoteData[][] = ob.getRemoteData();
    boolean IsModify = false;

	Hashtable hashData = new Hashtable();

    if(Credit == null || Credit.equals(""))
       Credit = Const.C_NOCREDIT_CDE;

    System.out.println("In PolicyMid.jsp Credit:TranType"+Credit+TranType);
    
    if(Credit.equals(Const.C_CREDIT_CDE) & TranType.equals(Const.C_EXPORT_CDE))
    {
     ;
    }
    else if(TranType.equals(Const.C_HOME_CDE))
    {
       Transit = HomeTransit;
       TransitName = HomeTransitName;
    }
    else
    {
       Transit = PortTransit;
       TransitName = PortTransitName;
    }

    

    Servlets servlets = new Servlets(RemoteOperType,RemoteData);
    //InsrInfo = servlets.PolicyServlet(request,TranType,Transit,TransitName);
    //FormData = servlets.getFormData();

	// OLD POSITION 
%>
<%@ include file="PublicPly.jsp" %> 
	  <%@ include file="EdrappPre.jsp" %>
<%
   

    if(Temp.equals(Const.REP))
    {
	    System.out.println("Const.REP policyMid.jsp");
	    ob.setStep(Const.STEP_REP);%>
		
       <% if(ClientType.equals(Const.CUST_AG))//agent//agent special
        {
                   String  C_Agt_Agr_NoTemp = request.getParameter("AGENCYNO");
                   String N_Sub_Co_NoTemp = request.getParameter("ADDAGENCYNO");
		           request.setAttribute("AGENCYNO",C_Agt_Agr_NoTemp);
		           request.setAttribute("ADDAGENCYNO",N_Sub_Co_NoTemp);
	     }
         String ChangFlag = "1";//cargocls
         request.setAttribute("CHANGFLAG",ChangFlag);
          %>
        <jsp:forward page="PolicyC.jsp"/>
       <%
    }
    else if(Temp.equals(Const.SUB))
    { %>
<%
if(Temp.equals(Const.SUB)){
    System.out.println("YUUIUIUIUIOIOIOIOO");
 %>
   
 <%
   
   String oldValue ="";
   String newValue ="";
	     
  

       System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
	   
       C_APP_NME  =  request.getParameter("C_APP_NME");
	   if(C_APP_NME!=null && !C_APP_NME.equals(pmb.plyEdrAppInfo.c_app_nme)){
		C_CTNT = C_CTNT + "投保人:["+ pmb.plyEdrAppInfo.c_app_nme + "],["
		            + C_APP_NME + "]";
	   }
      

	   C_INSRNT_NME = request.getParameter("C_INSRNT_NME");
	  if(!(C_INSRNT_NME.equals(pmb.plyEdrAppInfo.c_insrnt_nme))){
		C_CTNT = C_CTNT + "被保险人：["+  pmb.plyEdrAppInfo.c_insrnt_nme + "],["
		            + C_INSRNT_NME+ "]";        
      }

	  C_CRGO_CLS = request.getParameter("C_CRGO_CLS"); //货物大类
	  if(!(C_CRGO_CLS.equals(pmb.plyEdrAppCrgoInfo.c_crgo_cls))){
	     oldValue = "";
		 newValue = "";
         if(CargoClsLen > 1)
	    {
	      for(i = 1 ;i< CargoClsLen;i++ )
	      {
              if(C_CRGO_CLS.equals(CargoCls[i][c_crgo_cls])){
			    newValue =CargoCls[i][c_crgo_cnm];
              }
			  if((pmb.plyEdrAppCrgoInfo.c_crgo_cls).equals(CargoCls[i][c_crgo_cls])){
			    oldValue =CargoCls[i][c_crgo_cnm];
              }
	      }
	    }
		 C_CTNT = C_CTNT + "货物大类:["+oldValue + "],["
		             + newValue + "]";

	  }
	  
	  C_CRGO_CDE = request.getParameter("C_CRGO_CDE");//货物细类
	  if(!(C_CRGO_CDE.equals(pmb.plyEdrAppCrgoInfo.c_crgo_cde))){
	   oldValue ="";
	   newValue ="";
	   try
       {
        sb.setFieldValue(Const.GET_SMALLCARGOTYPE,C_CRGO_CLS);
        CargoType = sb.getRetValueArra();
       }
       catch(NormalException e)
       {
 	     if(NormalExceptionHandler.IsSevere(e)) throw NormalExceptionHandler.Handle(e);
 	     else if(NormalExceptionHandler.IsWarning(e))WarnMsg = e.getErrDesc(); 
 	    
       }
      CargoTypeLen = Servlets.getLen(CargoType);

	   if(CargoTypeLen > 1)
	   {
	     int c_crgo_cde = Objects.getColNum("c_crgo_cde",CargoType);
	     for(i = 1 ;i< CargoTypeLen;i++ )
	     {  if(C_CRGO_CDE.equals(CargoType[i][c_crgo_cde])){
			    newValue = CargoType[i][c_crgo_cnm] ;
             }
	     }
	   }
	   try
       {
        sb.setFieldValue(Const.GET_SMALLCARGOTYPE,pmb.plyEdrAppCrgoInfo.c_crgo_cls);
        CargoType = sb.getRetValueArra();
       }
       catch(NormalException e)
       {
 	     if(NormalExceptionHandler.IsSevere(e)) throw NormalExceptionHandler.Handle(e);
 	     else if(NormalExceptionHandler.IsWarning(e))WarnMsg = e.getErrDesc(); 
 	    
       }
      CargoTypeLen = Servlets.getLen(CargoType);

	  if(CargoTypeLen > 1)
	   {
	     int c_crgo_cde = Objects.getColNum("c_crgo_cde",CargoType);
	     for(i = 1 ;i< CargoTypeLen;i++ )
	     { 
			 if((pmb.plyEdrAppCrgoInfo.c_crgo_cde).equals(CargoType[i][c_crgo_cde])){
			    oldValue = CargoType[i][c_crgo_cnm] ;
             }
	   
	      }
	   }
	   
	    
		C_CTNT =C_CTNT + "货物细类:["+ oldValue +"],["
		            + newValue +"]";  
	    
	  }

	  if(!Credit.equals(Const.C_NOCREDIT_CDE)){
	      C_CRGO_DESC = request.getParameter("C_CRGO_DESC"); //品名描述 	     
		  if(!(C_CRGO_DESC.equals(pmb.plyEdrAppCrgoInfo.c_crgo_desc))){
			 C_CTNT = C_CTNT +"货物描述:["+ pmb.plyEdrAppCrgoInfo.c_crgo_desc+"],["
			             + C_CRGO_DESC +"]";             
		     
		  } 
	  }else{

	       C_CRGO_NAME = request.getParameter("C_CRGO_NAME");
		   if(!(C_CRGO_NAME.equals(pmb.plyEdrAppCrgoInfo.c_crgo_name))){
		       C_CTNT = C_CTNT + "货物名称:["+pmb.plyEdrAppCrgoInfo.c_crgo_name +"],["
			              + C_CRGO_NAME +"]";               
		       
            }

			C_PACK_CNM= request.getParameter("C_PACK_CNM") ;//包装描述
			if(!(C_PACK_CNM.equals(pmb.plyEdrAppCrgoInfo.c_pack_cnm))){
			    C_CTNT = C_CTNT + "包装描述:[" + pmb.plyEdrAppCrgoInfo.c_pack_cnm+"],["
				            + C_PACK_CNM +"]";
                 
			}

			C_AMOUNT= request.getParameter("C_AMOUNT") ;//数量及单位
            if(!(C_AMOUNT.equals(pmb.plyEdrAppCrgoInfo.c_amount))){
			   C_CTNT = C_CTNT +"数量及单位:["+pmb.plyEdrAppCrgoInfo.c_amount+"],["
			              + C_AMOUNT +"]"; 
               
			}

			C_MARK= request.getParameter("C_MARK");//唛头
			if(C_MARK!=null && !(C_MARK.equals(pmb.plyEdrAppCrgoInfo.c_mark))){
			   C_CTNT = C_CTNT +"唛头:["+ pmb.plyEdrAppCrgoInfo.c_mark +"],["
			                + C_MARK +"]";
			   
			}	       
	  }

	  C_INVC_AMT_CUR  = request.getParameter("C_INVC_AMT_CUR") ;//发票币种
	  
      
	  if(CurrencyLen > 1)
	     {
		  int c_cur_cde = Objects.getColNum("c_cur_cde",Currency); 
	      for(i = 1 ;i< CurrencyLen;i++ )
	      {
				if((pmb.plyEdrAppCrgoInfo.c_invc_amt_cur).equals(Currency[i][c_cur_cde])){
				   oldValue = Currency[i][c_cur_cnm];				  
				   tempstr1 = oldValue;
				   tempstr2 = oldValue;
				} 	    	   
	      }
	   }

	  if(!(C_INVC_AMT_CUR.equals(pmb.plyEdrAppCrgoInfo.c_invc_amt_cur))){	   
		newValue = "";		
        if(CurrencyLen > 1)
	     {
		  int c_cur_cde = Objects.getColNum("c_cur_cde",Currency); 
	      for(i = 1 ;i< CurrencyLen;i++ )
	      {
	            if(C_INVC_AMT_CUR.equals(Currency[i][c_cur_cde])){
				   newValue = Currency[i][c_cur_cnm];
				   tempstr2 = newValue;
				}
	      }
	     }

	      C_CTNT =  C_CTNT + "发票币种:["+ oldValue +"],[" 
		                + newValue +"]";
          
	  }

	  N_INVC_AMT = Objects.getScaleNumberZero(request.getParameter("N_INVC_AMT"),2);//发票金额
	  N_INVC_AMT = Objects.getTrimZero(N_INVC_AMT);
	  String OLD_N_INVC_AMT = Objects.getScaleNumberZero(pmb.plyEdrAppCrgoInfo.n_invc_amt,2);
      OLD_N_INVC_AMT = Objects.getTrimZero(OLD_N_INVC_AMT);
	  if(!(N_INVC_AMT.equals(OLD_N_INVC_AMT)) || !(tempstr1.equals(tempstr2))){
          C_CTNT =  C_CTNT +"发票金额:["+OLD_N_INVC_AMT +tempstr1+"],["
		               + N_INVC_AMT +tempstr2+"]";
          
	  }

	  

	  C_INVC_NO = request.getParameter("C_INVC_NO") ;//发票号码
	  if(C_INVC_NO!=null && !(C_INVC_NO.equals(pmb.plyEdrAppCrgoInfo.c_invc_no))){
	     C_CTNT =  C_CTNT + "发票号码:["+ pmb.plyEdrAppCrgoInfo.c_invc_no.trim() + "],["
		              + C_INVC_NO +"]";
         
	  }

	  C_RECEIPT_NO =  request.getParameter("C_RECEIPT_NO");//提单号
	  if(C_RECEIPT_NO!=null && !(C_RECEIPT_NO.equals(pmb.plyEdrAppCrgoInfo.c_receipt_no))){
	      C_CTNT =  C_CTNT + "提单/运单号:[" + pmb.plyEdrAppCrgoInfo.c_receipt_no.trim() +"],["
		                + C_RECEIPT_NO +"]";
         
	  }

	  C_SAIL_NO = request.getParameter("C_SAIL_NO");//航次
	  if(C_SAIL_NO!=null && !(C_SAIL_NO.equals(pmb.plyEdrAppCrgoInfo.c_sail_no))){
	       C_CTNT =  C_CTNT + "船名/车号/航班:["+ pmb.plyEdrAppCrgoInfo.c_sail_no.trim() + "],["
		                 + C_SAIL_NO +"]";
		 
	  }
	  

	  C_CONTAINER = request.getParameter("C_CONTAINER") ;//集装箱方氏
	  if(C_CONTAINER!=null){
	   if(!(C_CONTAINER.equals(pmb.plyEdrAppCrgoInfo.c_container))){
	      C_CTNT =  C_CTNT + "集装箱方式:["+pmb.plyEdrAppCrgoInfo.c_container +"],["
		               + C_CONTAINER +"]";
		 
	   }
      }

	  C_FRM_PRT_ARA = request.getParameter("C_FRM_PRT_ARA");//起运国      
	  if(!(C_FRM_PRT_ARA.equals(pmb.plyEdrAppCrgoInfo.c_frm_prt_ara))){
	      C_CTNT =  C_CTNT + "起运港国家:["+pmb.plyEdrAppCrgoInfo.c_frm_prt_ara.trim()+"],["
		                + C_FRM_PRT_ARA +"]";        
		 
	  }

	  C_FROM_PRT=  request.getParameter("C_FROM_PRT") ; //起运港
	  if(!(C_FROM_PRT.equals(pmb.plyEdrAppCrgoInfo.c_from_prt))){
	     C_CTNT =  C_CTNT + "起运港:["+pmb.plyEdrAppCrgoInfo.c_from_prt.trim() +"],["
		               +C_FROM_PRT +"]";
	     
	  }

	  C_PASS_PRT = request.getParameter("C_PASS_PRT");//途经港
	  if(C_PASS_PRT!=null && !(C_PASS_PRT.equals(pmb.plyEdrAppCrgoInfo.c_pass_prt))){
	    C_CTNT =  C_CTNT + "途经港:["+pmb.plyEdrAppCrgoInfo.c_pass_prt.trim() +"],["
		    + C_PASS_PRT +"]";
		
	  }

	  C_TO_PRT_ARA = request.getParameter("C_TO_PRT_ARA");//到达国
	  if(!(C_TO_PRT_ARA.equals(pmb.plyEdrAppCrgoInfo.c_to_prt_ara))){
	     C_CTNT =  C_CTNT + "目的港国家:["+ pmb.plyEdrAppCrgoInfo.c_to_prt_ara.trim() +"],["
		              +C_TO_PRT_ARA +"]";
		 
	  }
	  

	  C_TO_PRT = request.getParameter("C_TO_PRT");//到达港
	  if(!(C_TO_PRT.equals(pmb.plyEdrAppCrgoInfo.c_to_prt))){
	     C_CTNT =  C_CTNT + "目的港:["+pmb.plyEdrAppCrgoInfo.c_to_prt.trim()+"],["
		              +C_TO_PRT +"]";
		 
	  }
	 
	  if(!(t_insrnc_bgn_tm.equals((pmb.plyEdrAppInfo.t_insrnc_bgn_tm).substring(0,10)))){
	     C_CTNT =  C_CTNT + "起运日期:["+pmb.plyEdrAppInfo.t_insrnc_bgn_tm.substring(0,10) +"],["
		               + t_insrnc_bgn_tm +"]";
	     
	  }

	  if(!(pmb.plyEdrAppCrgoInfo.c_prn_frm.equals(Objects.getHt(hashData,"C_PRN_FRM")))){
	     C_CTNT =  C_CTNT+"打印格式:["+pmb.plyEdrAppCrgoInfo.c_prn_frm+"],["+Objects.getHt(hashData,"C_PRN_FRM")+"]";
	  }
     if(pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_EXPORT_CDE)){
		  if(!(pmb.plyEdrAppCrgoInfo.c_srvy_addr.equals(Objects.getHt(hashData,"C_SRVY_ADDR")))){
			 C_CTNT =  C_CTNT +"查勘代理人地点:["+pmb.plyEdrAppCrgoInfo.c_srvy_addr+"],["+Objects.getHt(hashData,"C_SRVY_ADDR")+"]";
		  }

		  if(!(pmb.plyEdrAppCrgoInfo.c_pay_addr.equals(Objects.getHt(hashData,"C_PAY_ADDR")))){
			 C_CTNT =  C_CTNT+"赔付地:["+pmb.plyEdrAppCrgoInfo.c_pay_addr+"],["+Objects.getHt(hashData,"C_PAY_ADDR")+"]";
		  }
      } 

	  N_AMT = Objects.getScaleNumberZero(request.getParameter("N_AMT"),2);//保险金额
	  N_AMT = Objects.getTrimZero(N_AMT);
	  String OLD_NAMT = pmb.plyEdrAppCrgoInfo.n_amt;
	  OLD_NAMT = Objects.getScaleNumberZero(OLD_NAMT,2);
	  OLD_NAMT = Objects.getTrimZero(OLD_NAMT);
	  if(!(N_AMT.equals(OLD_NAMT)) || !(tempstr1.equals(tempstr2))){
	     C_CTNT =  C_CTNT + "保险金额:["+OLD_NAMT+tempstr1+"],["
		               + N_AMT +tempstr2+"]";
		 
	  }
      if(!ClientType.equals(Const.CUST_AG)){
	    N_RATE = request.getParameter("N_RATE");//费率
		double newRate =0;
		double oldRate =0 ;
		String OLD_RATE ="";
		try{
		   System.out.println("1 n_rate :"+N_RATE);
		   newRate = Objects.ToDouble(N_RATE);
		   newRate = newRate/100;		   
		   N_RATE =  String.valueOf(newRate);
		   N_RATE =  Objects.getScaleNumber(N_RATE,7);
		   N_RATE =  Objects.getTrimZero(N_RATE);		  
		   OLD_RATE = Objects.getScaleNumber(pmb.plyEdrAppCrgoInfo.n_rate,7);
		   OLD_RATE = Objects.getTrimZero(OLD_RATE);
		   oldRate = Objects.ToDouble(OLD_RATE);
		}catch(NumberFormatException ex){
		   ex.printStackTrace();
		}
	    
	    if(N_RATE!=null && !N_RATE.equals("") &&  !(newRate==oldRate)){  
	       C_CTNT =  C_CTNT + "费率:["+OLD_RATE+"],["
		                +N_RATE +"]";          
	    }
      }

	 
      //if(ClientType.equals(Const.CUST_AG)){
		  if(!Objects.getScaleNumberZero(N_PRM_VAR,2).equals("0.00")){
			 i = OLD_PRM_CUR.indexOf("&");
			 i = OLD_PRM_CUR.indexOf("&",i+1);
			 tempstr1 = OLD_PRM_CUR.substring(i+1); 
			 C_CTNT =  C_CTNT + "保费:["+ N_PRM1 +tempstr1+"],["
						  + N_PRM +tempstr1+"]";
		  }
      /* }else if(!N_PRM.equals(pmb.plyEdrAppInfo.n_prm)){
	        C_CTNT =  C_CTNT + "保费:["+ pmb.plyEdrAppInfo.n_prm +tempstr1+"],["
						  + N_PRM +tempstr1+"]";
	   }*/

	 
       if(!(TranType.equals(EXPORT) & Credit.equals(HASCREDIT))){
		  //-----------------主险种-------------
		  oldValue = "";
		  newValue = "";

		  

		  for(i=1; i<=4; i++){
			tempstr1 = Objects.getHt(hashData,"C_MAIN_INSURANCE"+i);
			if(!tempstr1.equals("")) newValue = tempstr1;
		  }
		  newValue = newValue.substring(3);
		   String oldMain = "";

		  int c_rdr_cde = Objects.getColNum ("C_RDR_CDE", pmb.plyEdrAppRdrInfo.edrapprdr);
		  int c_rdr_nme = Objects.getColNum ("C_RDR_NME", pmb.plyEdrAppRdrInfo.edrapprdr);
		  System.out.println("c_rdr_nme:"+c_rdr_nme);

		  
		  for(int cc=1 ;cc< pmb.plyEdrAppRdrInfo.edrapprdr.length;cc++){
		       System.out.println("OLD RDR CDE:"+pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_cde]);
				if(MAINCODES.indexOf(pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_cde])>=0){
				    
				   oldMain  = pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_cde];
				   oldValue = pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_nme];
				   System.out.println("Old:"+ oldMain + ","+ oldValue );
				 }
		  }

		 
		  
		  if(!newValue.equals(oldValue)){
		    C_CTNT =  C_CTNT + "主险种:["+oldValue +"],["
		                +newValue +"]";       
		  }

		  
		  //-----------------附加险-------------
		  newValue = "";
		  oldValue = "";
			for(i=0; i<=12; i++){
			  tempstr1 = Objects.getHt(hashData,"C_ADD_INSURANCE"+i);
			  //System.out.println(" tempstr1:"+ tempstr1 +"\n");
			  if(!tempstr1.equals("")){
				 newValue = newValue+tempstr1.substring(3)+" ";//newValue+ NAMES[ServTool.getColNum(CODES, tempstr1.substring(0,2))] +" ";
			  }
			}
			

			for(int cc=1;cc< pmb.plyEdrAppRdrInfo.edrapprdr.length;cc++){
					   if(ServTool.getColNum(CODES,pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_cde])>0  &&
					!pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_cde].equals(oldMain)){
					 tempstr1 = pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_cde];
					 //oldValue = oldValue+ NAMES[ServTool.getColNum(CODES, tempstr1)] +" ";   
					 oldValue = oldValue+ pmb.plyEdrAppRdrInfo.edrapprdr[cc][c_rdr_nme]+" ";   
				}
			  
			}
			
		  if(!newValue.equals(oldValue)){
		    C_CTNT =  C_CTNT + "附加险:["+oldValue +"],["
		                +newValue +"]";       
		   } 


		  
		  //-----------------附加险-------------
     }else{
	     if(!pmb.plyEdrAppCrgoInfo.c_undr_cndtn.equals(C_UNDR_CNDTN)){
		     C_CTNT =  C_CTNT + "保险条件:["+pmb.plyEdrAppCrgoInfo.c_undr_cndtn +"],["
		                +C_UNDR_CNDTN +"]";       
		 }
	 }
     
	  C_NO_REPAY = request.getParameter("C_NO_REPAY");
	  System.out.println("request.getParameter(C_NO_REPAY):"+C_NO_REPAY);
	  if(C_NO_REPAY!=null && !C_NO_REPAY.equals(pmb.plyEdrAppCrgoInfo.c_no_repay)){
	      C_CTNT =  C_CTNT + "免赔:[" + pmb.plyEdrAppCrgoInfo.c_no_repay.trim() +"],["
		                + C_NO_REPAY + "]";
          

	  }

	  C_LOST_DESC = request.getParameter("C_LOST_DESC"); //赔付记录
	  if(C_LOST_DESC!=null && !C_LOST_DESC.equals(pmb.plyEdrAppCrgoInfo.c_lost_desc) && !C_LOST_DESC.equals(pmb.plyEdrAppCrgoInfo.c_lost_desc)){
	     C_CTNT =  C_CTNT + "以往损失记录(过去三年):["+pmb.plyEdrAppCrgoInfo.c_lost_desc.trim()+"],["
		               + C_LOST_DESC +"]";
	     
	  }

	  C_REMARK = request.getParameter("C_REMARK");//备注
	  if(C_REMARK!=null  && !C_REMARK.equals(pmb.plyEdrAppInfo.c_remark)){
	     C_CTNT =  C_CTNT + "备注:["+ pmb.plyEdrAppInfo.c_remark.trim() +"],["
		              + C_REMARK + "]";
         
	  }

	  if(!ClientType.equals(Const.CUST_AG)){
	     C_PLACE = request.getParameter("C_PLACE") ;//送达祥细地址
		 if(!C_PLACE.equals(pmb.plyPlyAppNetInfo.c_place.trim())){
		    C_CTNT =  C_CTNT + "详细地址:["+ pmb.plyPlyAppNetInfo.c_place.trim()+ "],["
			            + C_PLACE +"]";
            
		 }

		 C_CONTACT_NAME= request.getParameter("C_CONTACT_NAME");//联系人
		 if(!(C_CONTACT_NAME.equals(pmb.plyPlyAppNetInfo.c_contact_name.trim()))){
		    C_CTNT =  C_CTNT + "联系人:[" + pmb.plyPlyAppNetInfo.c_contact_name.trim() +"],["
			             + C_CONTACT_NAME +"]";
			
		 }

		 C_CONTACT_PHONE = request.getParameter("C_CONTACT_PHONE") ;//联系电话
		 if(!(C_CONTACT_PHONE.equals(pmb.plyPlyAppNetInfo.c_contact_phone.trim()))){
		    C_CTNT =  C_CTNT + "联系电话:["+pmb.plyPlyAppNetInfo.c_contact_phone.trim()+"],["
			              + C_CONTACT_PHONE +"]";
			
		 }

		 C_CONTACT_FAX = request.getParameter("C_CONTACT_FAX");//联系传真
		 if(!(C_CONTACT_FAX.equals(pmb.plyPlyAppNetInfo.c_contact_fax.trim()))){
		    C_CTNT =  C_CTNT +  "传真:["+pmb.plyPlyAppNetInfo.c_contact_fax.trim()+"],["
			              + C_CONTACT_FAX +"]";
			
		 }

		 C_CONTACT_EMAIL= request.getParameter("C_CONTACT_EMAIL") ;//E-mail
		 if(!(C_CONTACT_EMAIL.equals(pmb.plyPlyAppNetInfo.c_contact_email.trim()))){
		      C_CTNT =  C_CTNT + "E-mail:[" + pmb.plyPlyAppNetInfo.c_contact_email.trim()
			               +"],["+ C_CONTACT_EMAIL+ "]";
		     
		   
		 }
		 C_ZIP_CDE = request.getParameter("C_ZIP_CDE") ;
		 if(!(C_ZIP_CDE.equals(pmb.plyPlyAppNetInfo.c_zip_cde))){
		      C_CTNT =  C_CTNT + "邮编:[" + pmb.plyPlyAppNetInfo.c_zip_cde.trim()
			               +"],["+ C_ZIP_CDE+ "]";
		     
		   
		 }	     
	     
	  }
	  
	  
  
 }//else temp =sub
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



				 <table border="0" width="95%" cellpadding="4" >
				   <tr>
				<td width="5%">　</td>

				<td>

				<form name="nf" METHOD="POST" action="PolicyOut.jsp" onsubmit="nf.B1.disabled=true;">
				  <p>修改项目描述：
				  <p>
					 <textarea rows="10" name="C_EDR_CTNT" cols="75" readonly><%=C_CTNT%></textarea>
                     <input type="hidden" name="C_EDR_INFO" value="<%=C_CTNT%>">
  

				<p align="center">
                <input type="hidden" name="language" value=<%=request.getParameter("language")%>>
				<input type="submit" value="预  览" name="B1" > 
				<input type="button" value="前一页" name="B44" onclick='javascript:history.back();'>  
				</p>
				</center></div>
    
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


    <%}%>
	<%@ include file="public/PublicBottom.html" %>      
</body>
</html>


























