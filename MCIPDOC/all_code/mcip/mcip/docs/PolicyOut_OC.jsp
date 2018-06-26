<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>      
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 
<%@ include file="public/PublicInquireLeft.jsp" %>
    <td width="613" height="288" valign="top"> <br>
      <img src ="images/baodpg-b.gif" width="150" height="31" alt="保单批改">
<table border="0" width="95%" cellpadding="4" >
   <tr> 
  <td width="5%">　</td>
  <td><table border="0" width="95%" cellpadding="4" ><tr><td>


<jsp:useBean id="pab"  scope="request" class="beans.PolicyAppBean"/> 
<jsp:setProperty name="pab" property="*"/>
<jsp:useBean id="obn"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="obn" property="*"/>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>


<%  
   String paraNames[]= { "C_CRGO_NAME",      "C_PACK_CNM",         "C_AMOUNT",
                         "C_MARK",           "N_INVC_AMT",         "C_INVC_AMT_CUR",
						 "C_INVC_NO" ,       "C_RECEIPT_NO",       "T_INSRNC_BGN_TM",
						 "C_SAIL_NO",        "C_FROM_PRT",         "C_PASS_PRT",
						 "C_TO_PRT",         "N_AMT",              "N_PRM",
						 "N_PRM_VAR",        "C_EDR_RSN"              };

   
     Hashtable hashData = obn.getHashData();   

     
	 pmb.plyEdrAppInfo.n_prm = Objects.getHt(hashData,"N_PRM");

	 pmb.plyEdrAppCrgoInfo.n_prm = Objects.getHt(hashData,"N_PRM");

	 System.out.println("pmb.plyEdrAppInfo.n_prm:"+ pmb.plyEdrAppInfo.n_prm);

	 pmb.plyEdrAppInfo.n_prm_var = Objects.getHt(hashData,"N_PRM_VAR");

	 System.out.println("pmb.plyEdrAppInfo.n_prm_var:"+ pmb.plyEdrAppInfo.n_prm_var);
	 
     pmb.plyEdrAppCrgoInfo.c_crgo_name = Objects.getHt(hashData,"C_CRGO_NAME");
     
     pmb.plyEdrAppCrgoInfo.c_pack_cnm = Objects.getHt(hashData,"C_PACK_CNM");

     pmb.plyEdrAppCrgoInfo.c_amount = Objects.getHt(hashData,"C_AMOUNT");

     pmb.plyEdrAppCrgoInfo.c_mark = Objects.getHt(hashData,"C_MARK");

     pmb.plyEdrAppCrgoInfo.n_invc_amt = Objects.getHt(hashData,"N_INVC_AMT");

     pmb.plyEdrAppCrgoInfo.c_invc_amt_cur = Objects.getHt(hashData,"C_INVC_AMT_CUR");
	 
	 pmb.plyEdrAppCrgoInfo.n_amt = Objects.getHt(hashData,"N_AMT");

	 pmb.plyEdrAppInfo.n_amt = Objects.getHt(hashData,"N_AMT");
	 
     pmb.plyEdrAppCrgoInfo.c_invc_no = Objects.getHt(hashData,"C_INVC_NO") ;

     pmb.plyEdrAppCrgoInfo.c_receipt_no = Objects.getHt(hashData,"C_RECEIPT_NO");
     
	 pmb.plyEdrAppCrgoInfo.c_from_prt = Objects.getHt(hashData,"C_FROM_PRT");

     pmb.plyEdrAppCrgoInfo.c_pass_prt = Objects.getHt(hashData,"C_PASS_PRT");

     pmb.plyEdrAppCrgoInfo.c_to_prt = Objects.getHt(hashData,"C_TO_PRT");
     
	 pmb.plyEdrAppCrgoInfo.c_sail_no = Objects.getHt(hashData,"C_SAIL_NO");

      
     pmb.plyEdrAppInfo.t_insrnc_bgn_tm = Objects.getHt(hashData,"T_INSRNC_BGN_TM");

	 pmb.plyEdrAppCrgoInfo.c_prn_frm = Objects.getHt(hashData,"C_PRN_FRM");

	 pmb.plyEdrAppCrgoInfo.c_pay_addr = Objects.getHt(hashData,"C_PAY_ADDR");

	 pmb.plyEdrAppCrgoInfo.c_srvy_addr = Objects.getHt(hashData,"C_SRVY_ADDR");

	 pmb.plyEdrAppInfo.c_edr_ctnt = Objects.getHt(hashData,"C_EDR_RSN");

     //out.println("<<<<<<<<");
	 //out.println(Objects.getHt(hashData,"C_EDR_RSN"));

     String C_EDR_INFO = request.getParameter("C_EDR_INFO");
     if(C_EDR_INFO==null) C_EDR_INFO="";
	 
     pmb.plyEdrAppCrgoInfo.c_edr_info =  C_EDR_INFO;

	 pmb.plyEdrAppInfo.c_udr_mrk = "B";

	 System.out.println("PolicyOut_OC.jsp-----------pmb.plyEdrAppCrgoInfo.c_edr_info:"+pmb.plyEdrAppCrgoInfo.c_edr_info);
    
    
    String[][] Result;
    try
    {
         pmb.setFormPara(1,null);
         Result = pmb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	    //if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
	/*if(Result!=null){
	   for(int i=0 ;i < Result.length; i++)
	    for(int j=0; j< Result[i].length; j++)
		  out.println(Result[i][j]+",");
	}*/
	if(Result!=null){

	 String forwardpage = "LocalPolicyView.jsp";
	  if (pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_IMPORT_CDE)){
       forwardpage="ImportPolicyView.jsp";
	  }else if(pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_EXPORT_CDE)){
       forwardpage="ExportPolicyView.jsp";
     }
	  
	 int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result); 
	 int c_edr_app_no = Objects.getColNum("c_edr_app_no",Result);
	 int c_edr_no = Objects.getColNum("c_edr_no",Result);

     

	 if(Result[1][c_rtrn_cde].equals("0")){
	      String language = request.getParameter("language");
		  System.out.println("language:"+language);
		  request.setAttribute("language",language); 
		  request.setAttribute("FromApp","PlyEdrApp"); 
		  String edrAppInfos[] = new String[3];
		  edrAppInfos[0]= Result[1][c_edr_app_no];
		  edrAppInfos[1]= pmb.plyEdrAppInfo.c_dpt_cde;
		  edrAppInfos[2]= pmb.plyEdrAppInfo.c_insrnc_cde;

		  try
		  {
		    pmb.setFieldValue(3,Result[1][c_edr_app_no]);
		    pmb.setFormPara(4,edrAppInfos);
          }catch(NormalException e)
          {
 	         //if(NormalExceptionHandler.IsSevere(e))
 	         throw NormalExceptionHandler.Handle(e);
          }

		  Hashtable valuesTable = new Hashtable(100);
	      Object obj = (Object)pmb.plyEdrAppInfo;
          Class c = obj.getClass();
          Field[] fields =c.getFields();
          String fieldName ="";
	      String fieldValue="";
		  int i =0 ;
          System.out.println("pmb.plyEdrAppInfo fields:");
          for ( i = 0; i < fields.length; i++) {
           try{
            fieldName = fields[i].getName();
            fieldValue=(c.getField(fieldName).get(obj)).toString();
			if(fieldName!=null && fieldValue!=null)valuesTable.put(fieldName, fieldValue);
            }catch(Exception e){
              throw NormalExceptionHandler.Handle(e);      
           }
          }

		  obj = (Object)pmb.plyEdrAppCrgoInfo;
          c = obj.getClass();
		  fields =c.getFields();

		  for ( i = 0; i < fields.length; i++) {
			try{
				fieldName = fields[i].getName();
				fieldValue=(c.getField(fieldName).get(obj)).toString();
				//System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
				if(fieldName!=null && fieldValue!=null)valuesTable.put(fieldName, fieldValue);
			  }catch(Exception e){
				  throw NormalExceptionHandler.Handle(e);      
			 }
		  }

		  obj = (Object)pmb.plyPlyAppNetInfo;
		  c = obj.getClass();
		  fields =c.getFields();      
		  for ( i = 0; i < fields.length; i++) {
			try{
				fieldName = fields[i].getName();
				fieldValue=(c.getField(fieldName).get(obj)).toString();
				//System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
				if(fieldName!=null && fieldValue!=null)valuesTable.put(fieldName, fieldValue);
			  }catch(Exception e){
				  throw NormalExceptionHandler.Handle(e);      
			 }
		  }
		  String paras[][]= new String[2][valuesTable.size()];
		  Enumeration ee = valuesTable.keys();
		  i =0 ;
		  while(ee.hasMoreElements()){
			  String key = (String)ee.nextElement();
			  System.out.println("Key:"+key+":"+(String)(valuesTable.get(key)));
			  paras[0][i] = key;
			  paras[1][i] = ((String)(valuesTable.get(key))).trim();
			  i++;
		  }

		  try{
            System.out.println("try to set pmb data in PolicyOut.jsp");
            ob.setFormData(paras);
           }catch(NormalException e){
		     
	 	   if(NormalExceptionHandler.IsSevere(e))
	 	     throw NormalExceptionHandler.Handle(e);
	 	      else if(NormalExceptionHandler.IsWarning(e))
	 	      WarnMsg = e.getErrDesc();
			  e.printStackTrace();
	      }%>

         <jsp:forward page="<%=forwardpage%>"/>

	   <%String desc="";
	   int c_undr_opn =  Objects.getColNum("c_undr_opn",Result);
	   if(c_undr_opn==-1)desc="";
	   else desc = Result[1][c_undr_opn];
       if(desc==null || desc.trim().length() == 0)desc="   ";
       int p = desc.indexOf(" ");
       p= desc.indexOf(" ",p+1);    
       desc =desc.substring(p);		  
	   %>您的投保业务,由于<%=(desc.trim())%> 批单未能自动生成，需要等待我公司的后台处理，我们将在一个工作日给您答复。
     <%
	   out.println("你的批改申请号"+Result[1][c_edr_app_no]);
     } 
     if(Result[1][c_rtrn_cde].equals("1")){
	   out.println("你的批改申请已经通过系统自动核保,批单号："+Result[1][c_edr_no]+".");
     }
	}

	
    

 
%></table>
    
       
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
