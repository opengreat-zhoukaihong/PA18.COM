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

<%@ include file="public/Public.jsp" %>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="obn"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="obn" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>



<%
   String paraNames[]= { "C_CRGO_NAME",      "C_PACK_CNM",         "C_AMOUNT",
                         "C_MARK",           "N_INVC_AMT",         "C_INVC_AMT_CUR",
						 "C_INVC_NO" ,       "C_RECEIPT_NO",       "T_INSRNC_BGN_TM",
						 "C_SAIL_NO",        "C_FROM_PRT",         "C_PASS_PRT",
						 "C_TO_PRT",         "N_AMT",              "N_PRM",
						 "N_PRM_VAR",        "C_EDR_RSN",          "N_PRM1", 
						 "OLD_PRM_CUR" ,      "C_PRN_FRM",          "C_PAY_ADDR",
						 "C_SRVY_ADDR"           };
   

   String paras[][] = new String[2][22];
   String va;
   for(int i= 0 ;i< 22 ;i++){
      paras[0][i] = paraNames[i];
	  va = request.getParameter(paraNames[i]);
	  if(va==null)va = "";
	  va = va.trim();
	  paras[1][i] = va;
   }
   /*for(int j=0 ; j<22;j++)
     out.println(paras[0][j] +":" +paras[1][j]+","); */
	 
   obn.setFormData(paras);
   Hashtable hashData = obn.getHashData();

   String C_EDR_CTNT = "";

   String tempstr1 = "";
   String tempstr2 = "";
    

	 // following is new 15/03/2001
     if(!(pmb.plyEdrAppCrgoInfo.c_crgo_name.trim().equals(Objects.getHt(hashData,"C_CRGO_NAME")))){
	    C_EDR_CTNT = C_EDR_CTNT+"货物名称:["+pmb.plyEdrAppCrgoInfo.c_crgo_name.trim()+"],["+Objects.getHt(hashData,"C_CRGO_NAME")+"]";
     }
     
     if(!(pmb.plyEdrAppCrgoInfo.c_pack_cnm.trim().equals(Objects.getHt(hashData,"C_PACK_CNM")))){
	     C_EDR_CTNT = C_EDR_CTNT+"包装描述:["+pmb.plyEdrAppCrgoInfo.c_pack_cnm.trim()+"],["+ Objects.getHt(hashData,"C_PACK_CNM")+"]";
     } 
     if(!(pmb.plyEdrAppCrgoInfo.c_amount.trim().equals(Objects.getHt(hashData,"C_AMOUNT")))){
	      C_EDR_CTNT = C_EDR_CTNT+"数量:["+pmb.plyEdrAppCrgoInfo.c_amount.trim()+"],["+Objects.getHt(hashData,"C_AMOUNT")+"]";
     }
     if(!(pmb.plyEdrAppCrgoInfo.c_mark.trim().equals(Objects.getHt(hashData,"C_MARK")))){
	      C_EDR_CTNT = C_EDR_CTNT+"唛头:["+ pmb.plyEdrAppCrgoInfo.c_mark.trim() +"],["+Objects.getHt(hashData,"C_MARK")+"]";
     }
     
     String Currency[][]=null;	 
     try
        {
          sb.setFieldValue(Const.GET_CURRENCY,"");
          Currency = sb.getRetValueArra();
		}
		catch(NormalException e)
		{
		    e.printStackTrace();
 			if(NormalExceptionHandler.IsSevere(e))
 			throw NormalExceptionHandler.Handle(e);
		}        
	    
        
     int CurrencyLen = Servlets.getLen(Currency);
     int c_cur_cde = Objects.getColNum("c_cur_cde",Currency);
     int c_cur_cnm = Objects.getColNum("c_cur_cnm",Currency);
     int n_chg_rte = Objects.getColNum("n_chg_rte",Currency);     
	 String Currency_NAME ="";

	 if(CurrencyLen > 1)
	     {
	      for(int i = 1 ;i< CurrencyLen;i++ )
	      {
	              if(Objects.getHt(hashData,"C_INVC_AMT_CUR").equals(Currency[i][c_cur_cde])){
				   Currency_NAME = Currency[i][c_cur_cnm];
                   tempstr1 =  Currency_NAME;
				   tempstr2 =  Currency_NAME;
				   break;
				  } 	   
	      }
	     }
     if(!(pmb.plyEdrAppCrgoInfo.c_invc_amt_cur.equals(Objects.getHt(hashData,"C_INVC_AMT_CUR")))){
         
		 if(CurrencyLen > 1)
	     {
	      for(int i = 1 ;i< CurrencyLen;i++ )
	      {
	              if(pmb.plyEdrAppCrgoInfo.c_invc_amt_cur.equals(Currency[i][c_cur_cde])){
				   Currency_NAME = Currency[i][c_cur_cnm];
				   tempstr2 = Currency_NAME;
				   break;
				  } 	   
	      }
	     }

		 C_EDR_CTNT = C_EDR_CTNT+ "发票币种:["+tempstr2+"],[" + tempstr1 +"]";
     }

	  String N_INVC_AMT = Objects.getScaleNumberZero(request.getParameter("N_INVC_AMT"),2);//发票金额
	  N_INVC_AMT = Objects.getTrimZero(N_INVC_AMT);
	  String OLD_N_INVC_AMT = Objects.getScaleNumberZero(pmb.plyEdrAppCrgoInfo.n_invc_amt,2);
      OLD_N_INVC_AMT = Objects.getTrimZero(OLD_N_INVC_AMT);
	  if(!(N_INVC_AMT.equals(OLD_N_INVC_AMT)) || !(tempstr1.equals(tempstr2))){
          C_EDR_CTNT =  C_EDR_CTNT +"发票金额:["+OLD_N_INVC_AMT +tempstr1+"],["
		               + N_INVC_AMT +tempstr2+"]";
          
	  }

	 if(!(pmb.plyEdrAppCrgoInfo.c_invc_no.trim().equals(Objects.getHt(hashData,"C_INVC_NO")))){
	    C_EDR_CTNT = C_EDR_CTNT+ "发票号码:["+pmb.plyEdrAppCrgoInfo.c_invc_no.trim()+"],["+Objects.getHt(hashData,"C_INVC_NO")+"]";
      }
	 
	 String OLD_N_AMT = Objects.getScaleNumberZero(pmb.plyEdrAppCrgoInfo.n_amt,2);
	 OLD_N_AMT = Objects.getTrimZero(OLD_N_AMT);
	 String NEW_N_AMT = Objects.getHt(hashData,"N_AMT");
	 NEW_N_AMT =  Objects.getScaleNumberZero(NEW_N_AMT,2);
     NEW_N_AMT =  Objects.getTrimZero(NEW_N_AMT);
	 if(!(OLD_N_AMT.equals(NEW_N_AMT)) || !(tempstr1.equals(tempstr2))){
	   C_EDR_CTNT = C_EDR_CTNT+ "保险金额:["+OLD_N_AMT +tempstr2+"],["+ NEW_N_AMT+tempstr1+"]";
	 }
	 if(!Objects.getScaleNumberZero(Objects.getHt(hashData,"N_PRM_VAR"),2).equals("0.00")){
	    String OLD_PRM_CUR = Objects.getHt(hashData,"OLD_PRM_CUR");
		String N_PRM = Objects.getHt(hashData,"N_PRM");
		String N_PRM1 = Objects.getHt(hashData,"N_PRM1");
		int i = OLD_PRM_CUR.indexOf("&");
		i = OLD_PRM_CUR.indexOf("&",i+1);
		tempstr1 = OLD_PRM_CUR.substring(i+1); 
	    C_EDR_CTNT =  C_EDR_CTNT + "保费:["+ N_PRM1 +tempstr1+"],["
		              + N_PRM +tempstr1+"]";
	    
	 }
	 
     

      if(!(pmb.plyEdrAppCrgoInfo.c_receipt_no.trim().equals(Objects.getHt(hashData,"C_RECEIPT_NO")))){
	    C_EDR_CTNT = C_EDR_CTNT+ "提单号:["+ pmb.plyEdrAppCrgoInfo.c_receipt_no.trim()+"],["+Objects.getHt(hashData,"C_RECEIPT_NO")+"]";
      }
      if(!(pmb.plyEdrAppCrgoInfo.c_from_prt.trim().equals(Objects.getHt(hashData,"C_FROM_PRT")))){
	    C_EDR_CTNT = C_EDR_CTNT+ "起运港:["+pmb.plyEdrAppCrgoInfo.c_from_prt.trim()+"],["+Objects.getHt(hashData,"C_FROM_PRT")+"]";
	  }      
      if(!(pmb.plyEdrAppCrgoInfo.c_pass_prt.trim().equals(Objects.getHt(hashData,"C_PASS_PRT")))){
	    C_EDR_CTNT = C_EDR_CTNT+ "途经港:["+ pmb.plyEdrAppCrgoInfo.c_pass_prt.trim()+"],["+Objects.getHt(hashData,"C_PASS_PRT")+"]";
	  }
      if(!(pmb.plyEdrAppCrgoInfo.c_to_prt.trim().equals(Objects.getHt(hashData,"C_TO_PRT")))){
	     C_EDR_CTNT = C_EDR_CTNT+ "到达港:["+pmb.plyEdrAppCrgoInfo.c_to_prt.trim()+"],["+Objects.getHt(hashData,"C_TO_PRT")+"]";
	   }
      if(!(pmb.plyEdrAppCrgoInfo.c_sail_no.trim().equals(Objects.getHt(hashData,"C_SAIL_NO")))){
	     C_EDR_CTNT = C_EDR_CTNT+ "航次:["+pmb.plyEdrAppCrgoInfo.c_sail_no.trim()+"],["+Objects.getHt(hashData,"C_SAIL_NO")+"]";
      }
      
      if(!(pmb.plyEdrAppInfo.t_insrnc_bgn_tm.substring(0,10).equals(Objects.getHt(hashData,"T_INSRNC_BGN_TM")))){
	     C_EDR_CTNT = C_EDR_CTNT+"起运日期:["+pmb.plyEdrAppInfo.t_insrnc_bgn_tm.substring(0,10)+"],["+Objects.getHt(hashData,"T_INSRNC_BGN_TM")+"]";
	  }

	  if(!(pmb.plyEdrAppCrgoInfo.c_prn_frm.equals(Objects.getHt(hashData,"C_PRN_FRM")))){
	     C_EDR_CTNT = C_EDR_CTNT+"打印格式:["+pmb.plyEdrAppCrgoInfo.c_prn_frm+"],["+Objects.getHt(hashData,"C_PRN_FRM")+"]";
	  }
     if(pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_EXPORT_CDE)){
      if(!(pmb.plyEdrAppCrgoInfo.c_srvy_addr.equals(Objects.getHt(hashData,"C_SRVY_ADDR")))){
	     C_EDR_CTNT = C_EDR_CTNT+"查勘代理人地点:["+pmb.plyEdrAppCrgoInfo.c_srvy_addr+"],["+Objects.getHt(hashData,"C_SRVY_ADDR")+"]";
	  }

	  if(!(pmb.plyEdrAppCrgoInfo.c_pay_addr.equals(Objects.getHt(hashData,"C_PAY_ADDR")))){
	     C_EDR_CTNT = C_EDR_CTNT+"赔付地:["+pmb.plyEdrAppCrgoInfo.c_pay_addr+"],["+Objects.getHt(hashData,"C_PAY_ADDR")+"]";
	  }
	 }
      
      

	  //pmb.plyEdrAppInfo.c_remark = C_EDR_CTNT;

    
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

<form name="nf" METHOD="POST" action="PolicyOut_OC.jsp" onsubmit="nf.B1.disabled=true;">
  <p>修改项目描述：
  <p>
	 <textarea rows="10" name="C_EDR_CTNT" cols="75" readonly><%=C_EDR_CTNT%></textarea>
       <input type="hidden" name="C_EDR_INFO" value="<%=C_EDR_CTNT%>">   
  

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

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
<script language=JavaScript>

</script>
