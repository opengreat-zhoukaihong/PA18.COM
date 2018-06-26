

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
<%@ include file="public/PublicPlyLeft.html" %>
    <td width="613" height="288" valign="top"> <br>
      <img src ="images/baodpg-b.gif" width="150" height="31" alt="保单批改">
<br>　　　　　　
 <table border="0" width="95%" cellpadding="4" >
   <tr> 
  <td width="5%">　</td>
  <td><table border="0" width="95%" cellpadding="4" ><tr><td>


<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="sb"  scope="request" class="beans.StaticInfoBean"/>
<jsp:setProperty name="sb" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="cb"  scope="request" class="beans.CustManagerBean"/>
<jsp:setProperty name="cb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>

<% //---------------------------------------------------------------
   Hashtable hashData = new Hashtable();
   hashData = ob.getHashData();
   //Enumeration e = hashData.keys();
   //String key= "";
   //String value="";
   /*while(e.hasMoreElements()){
      key = (String)e.nextElement();
	  value = (String)(hashData.get(key));
	  out.println("Key:"+key+",:"+value+"<p>");
   }*/
   String ClientType = sessionbuffer.getClientType(Locate); //登录客户类型
   String C_CREDIT_ID = Objects.getHt(hashData, "C_CREDIT_ID");

      

  
  // This is wait fro test 
  // pmb.plyEdrAppInfo.n_amt_var     = Objects.getHt(hashData, "N_AMT_VAR"); //?
  //pmb.plyEdrAppInfo.c_amt_cur         = Objects.getHt(hashData, "C_AMT_CUR");
  //pmb.plyEdrAppInfo.c_prm_cur         = Objects.getHt(hashData, "C_PRM_CUR");
  //pmb.plyEdrAppInfo.c_amt_cur_cnm     = Objects.getHt(hashData, "C_AMT_CUR_CNM");
  //pmb.plyEdrAppCrgoInfo.c_invc_amt_cur = Objects.getHt(hashData,"C_INVC_AMT_CUR");

   

  //*-----------
  System.out.println("PolicyOut.jsp :pmb.plyEdrAppInfo.c_edr_ctnt:"+pmb.plyEdrAppInfo.c_edr_ctnt);
   System.out.println(Objects.getHt(hashData,"C_EDR_RSN"));
  
   pmb.plyEdrAppInfo.n_prm_var     = Objects.getHt(hashData, "N_PRM_VAR");

   if(ClientType.equals(Const.CUST_AG)){
    pmb.plyEdrAppInfo.c_app_nme     = Objects.getHt(hashData, "C_APP_NME");
   }

   pmb.plyEdrAppInfo.c_insrnt_nme    = Objects.getHt(hashData, "C_INSRNT_NME");

   pmb.plyEdrAppInfo.t_insrnc_bgn_tm   = Objects.getHt(hashData, "t_insrnc_bgn_tm");
   

   pmb.plyEdrAppInfo.n_amt             = Objects.getHt(hashData, "N_AMT");

   pmb.plyEdrAppInfo.n_rate            = Objects.getHt(hashData, "N_RATE");

   System.out.println("PolicyOut.jsp pmb.plyEdrAppInfo.n_rate:"+pmb.plyEdrAppInfo.n_rate);

   pmb.plyEdrAppInfo.n_prm             = Objects.getHt(hashData, "N_PRM");  

   pmb.plyEdrAppInfo.c_remark          =  Objects.getHt(hashData,"C_REMARK");

   pmb.plyEdrAppCrgoInfo.c_crgo_cde = Objects.getHt(hashData, "C_CRGO_CDE");
 
   pmb.plyEdrAppCrgoInfo.c_crgo_cnm = "";//Objects.getHt(hashData, "C_CRGO_NAME");

   System.out.println("PolicyOut.jsp  Objects.getHt(hashData,C_CRGO_DESC):"+Objects.getHt(hashData,"C_CRGO_DESC"));
   pmb.plyEdrAppCrgoInfo.c_crgo_desc = Objects.getHt(hashData,"C_CRGO_DESC");

   pmb.plyEdrAppCrgoInfo.c_invc_no = Objects.getHt(hashData,"C_INVC_NO");
   
   pmb.plyEdrAppCrgoInfo.c_sail_no = Objects.getHt(hashData,"C_SAIL_NO");
   
   pmb.plyEdrAppCrgoInfo.c_from_prt = Objects.getHt(hashData,"C_FROM_PRT");
   
   pmb.plyEdrAppCrgoInfo.c_frm_prt_ara = Objects.getHt(hashData,"C_FRM_PRT_ARA");
   
   pmb.plyEdrAppCrgoInfo.c_to_prt = Objects.getHt(hashData,"C_TO_PRT");   

   pmb.plyEdrAppCrgoInfo.c_to_prt_ara = Objects.getHt(hashData,"C_TO_PRT_ARA");
   
   pmb.plyEdrAppCrgoInfo.c_pass_prt = Objects.getHt(hashData,"C_PASS_PRT");
   
   pmb.plyEdrAppCrgoInfo.c_undr_cndtn = Objects.getHt(hashData,"C_UNDR_CNDTN");
   
   pmb.plyEdrAppCrgoInfo.n_amt = Objects.getHt(hashData,"N_AMT");
   
   pmb.plyEdrAppCrgoInfo.n_rate = Objects.getHt(hashData,"N_RATE");

   System.out.println("PolicyOut.jsp pmb.plyEdrAppCrgoInfo.n_rate:"+pmb.plyEdrAppCrgoInfo.n_rate);
   
   pmb.plyEdrAppCrgoInfo.n_prm = Objects.getHt(hashData,"N_PRM");
   
   pmb.plyEdrAppCrgoInfo.c_receipt_no = Objects.getHt(hashData,"C_RECEIPT_NO");       

   pmb.plyEdrAppCrgoInfo.c_crgo_cls = Objects.getHt(hashData,"C_CRGO_CLS");

   pmb.plyEdrAppCrgoInfo.c_crgo_name = Objects.getHt(hashData, "C_CRGO_NAME");
   
   pmb.plyEdrAppCrgoInfo.c_amount = Objects.getHt(hashData,"C_AMOUNT");

   pmb.plyEdrAppCrgoInfo.c_mark = Objects.getHt(hashData,"C_MARK");
      
   pmb.plyEdrAppCrgoInfo.n_invc_amt = Objects.getHt(hashData,"N_INVC_AMT");   

   

   pmb.plyEdrAppCrgoInfo.c_no_repay = Objects.getHt(hashData,"C_NO_REPAY");
   
   pmb.plyEdrAppCrgoInfo.c_lost_desc = Objects.getHt(hashData,"C_LOST_DESC");  

   pmb.plyEdrAppCrgoInfo.c_container = Objects.getHt(hashData,"C_CONTAINER");
   
   pmb.plyEdrAppCrgoInfo.c_add_risk = Objects.getHt(hashData,"C_ADD_RISK");
   
   pmb.plyEdrAppCrgoInfo.c_pack_cnm = Objects.getHt(hashData,"C_PACK_CNM");
   


   if(!ClientType.equals(Const.CUST_AG)){
     
     pmb.plyPlyAppNetInfo.c_place = Objects.getHt(hashData,"C_PLACE");

	 System.out.println("PolicyOUT--------------C_PLACE:"+ pmb.plyPlyAppNetInfo.c_place);
   
     pmb.plyPlyAppNetInfo.c_contact_name  = Objects.getHt(hashData,"C_CONTACT_NAME");    

     pmb.plyPlyAppNetInfo.c_contact_phone  = Objects.getHt(hashData,"C_CONTACT_PHONE");    

     pmb.plyPlyAppNetInfo.c_contact_fax  =Objects.getHt(hashData,"C_CONTACT_FAX");    

     pmb.plyPlyAppNetInfo.c_contact_email  =Objects.getHt(hashData,"C_CONTACT_EMAIL"); 
     
	 pmb.plyPlyAppNetInfo.c_zip_cde  =Objects.getHt(hashData,"C_ZIP_CDE"); 


   }
   //-----------*/
   
   pmb.plyEdrAppInfo.c_edr_ctnt = Objects.getHt(hashData,"C_EDR_CTNT");

   System.out.println("pmb.plyEdrAppInfo.c_edr_ctnt:"+pmb.plyEdrAppInfo.c_edr_ctnt);
   String Credit = ob.getCredit();

   if(Credit.equals(Const.C_NOCREDIT_CDE)){
		   Vector v= new Vector(16);
		   String tempstr="";
		   for(int i=1 ;i<=4;i++){
			  tempstr = Objects.getHt(hashData,"C_MAIN_INSURANCE"+String.valueOf(i));
			  if(!tempstr.equals("")){
				  v.add(tempstr);
				}
		   }

		   for(int i=0 ;i<13;i++){
			  tempstr = Objects.getHt(hashData,"C_ADD_INSURANCE"+String.valueOf(i));
			  if(!tempstr.equals("")){
				  v.add(tempstr);
				}
		   }

		   if(pmb.plyEdrAppRdrInfo.edrapprdr.length>1){
			  String edrRdr[][] = new String[v.size()+1][pmb.plyEdrAppRdrInfo.edrapprdr[0].length];
			  for(int i=0 ;i< pmb.plyEdrAppRdrInfo.edrapprdr[0].length; i++){
				edrRdr[0][i]= pmb.plyEdrAppRdrInfo.edrapprdr[0][i]; 
			  }
			  int c_edr_app_no = Objects.getColNum("C_EDR_APP_NO",pmb.plyEdrAppRdrInfo.edrapprdr);
			  int c_rdr_cde = Objects.getColNum("C_RDR_CDE",pmb.plyEdrAppRdrInfo.edrapprdr);
			  int c_rdr_nme = Objects.getColNum("C_RDR_NME",pmb.plyEdrAppRdrInfo.edrapprdr);			  
			  int index = -1;
			  for(int i =1 ;i< edrRdr.length;i++){
			     for(int j=0; j< edrRdr[i].length;j++)edrRdr[i][j]=""; 
			     tempstr = (String)v.get(i-1);
				 index = tempstr.indexOf("&");
				 if(index>0){
			       edrRdr[i][c_edr_app_no]= pmb.plyEdrAppInfo.c_edr_app_no;
                   edrRdr[i][c_rdr_cde]= tempstr.substring(0,index);
				   edrRdr[i][c_rdr_nme]= tempstr.substring(index+1);

				   System.out.println("edrRdr[i][c_rdr_cde]:"+edrRdr[i][c_rdr_cde] +",edrRdr[i][c_rdr_nme]:"+edrRdr[i][c_rdr_nme]);
                 }
			  }
              pmb.plyEdrAppRdrInfo.edrapprdr = edrRdr;
			  /*for(int i= 0; i<pmb.plyEdrAppRdrInfo.edrapprdr.length;i++)
			    for(int j=0; j< pmb.plyEdrAppRdrInfo.edrapprdr[i].length;j++)
				  out.println(pmb.plyEdrAppRdrInfo.edrapprdr[i][j]+"<p>");*/
		   }
   }

//This para need added
     pmb.plyEdrAppCrgoInfo.c_prn_frm = Objects.getHt(hashData,"C_PRN_FRM");
    if(pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_EXPORT_CDE)){
	 pmb.plyEdrAppCrgoInfo.c_pay_addr = Objects.getHt(hashData,"C_PAY_ADDR");

	 pmb.plyEdrAppCrgoInfo.c_srvy_addr = Objects.getHt(hashData,"C_SRVY_ADDR");
    }

   String C_EDR_INFO = request.getParameter("C_EDR_INFO");
    if(C_EDR_INFO==null) C_EDR_INFO="";
	 
     pmb.plyEdrAppCrgoInfo.c_edr_info =  C_EDR_INFO;

	 pmb.plyEdrAppInfo.c_udr_mrk = "B";

   
  /* Object obj = (Object)pmb.plyEdrAppInfo;
   Class c = obj.getClass();
   Field[] publicFields =c.getFields();
   String fieldName =null;
   System.out.println("pmb.plyEdrAppInfo fields:");
   for (int i = 0; i < publicFields.length; i++) {
      try{
            fieldName = publicFields[i].getName();
            String fieldValue=(c.getField(fieldName).get(obj)).toString();
            System.out.print(i+":"+fieldName+":\t"+fieldValue+"\n");
         }catch(Exception e){
                    e.printStackTrace();
         }
     }
   */
   
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
	 ob.setTempTwo(Result);
	 int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result); 
	 int c_edr_app_no = Objects.getColNum("c_edr_app_no",Result);
	 int c_edr_no = Objects.getColNum("c_edr_no",Result);

	 
     /*for(int j=0 ;j< Result.length; j++)
	   for(int h= 0 ; h< Result[j].length; h++)
	     System.out.println(Result[j][h]);*/
  
     String forwardpage = "LocalPolicyView.jsp";
	  if (pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_IMPORT_CDE)){
       forwardpage="ImportPolicyView.jsp";
	  }else if(pmb.plyEdrAppInfo.c_insrnc_cde.equals(Const.C_EXPORT_CDE)){
       forwardpage="ExportPolicyView.jsp";
     }
	 System.out.println("forwardpage:"+forwardpage); 
	  
	   
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
		    System.out.println("YES ......................policyoout.jsp ---------withdraw--");		    
			pmb.setFieldValue(3,Result[1][c_edr_app_no]);			
		    pmb.setFormPara(4,edrAppInfos);
          }catch(NormalException e)
          {
 	         //if(NormalExceptionHandler.IsSevere(e))
 	         throw NormalExceptionHandler.Handle(e);
          }

          System.out.println("PolicyOut.jsp-----------pmb.plyEdrAppCrgoInfo.c_undr_cndtn :"+pmb.plyEdrAppCrgoInfo.c_undr_cndtn);

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
			//System.out.print(i+" plyEdrAppInfo:"+fieldName+":\t"+fieldValue+"\n");
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
				//System.out.print(i+" plyEdrAppCrgoInfo:"+fieldName+":\t"+fieldValue+"\n");
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
				//System.out.print(i+" plyPlyAppNetInfo:"+fieldName+":\t"+fieldValue+"\n");
				if(fieldName!=null && fieldValue!=null)valuesTable.put(fieldName, fieldValue);
			  }catch(Exception e){
				  throw NormalExceptionHandler.Handle(e);      
			 }
		  }
		  valuesTable.put("c_add_risk",hashData.get("C_ADD_RISK"));
		  String paras[][]= new String[2][valuesTable.size()+1];
		  Enumeration ee = valuesTable.keys();
		  i =0 ;
		  while(ee.hasMoreElements()){
			  String key = (String)ee.nextElement();
			  //System.out.println("Key:"+key+":"+(String)(valuesTable.get(key)));
			  paras[0][i] = key;
			  paras[1][i] = ((String)(valuesTable.get(key))).trim();
			  i++;
		  }
                 //ADD BY ZHANGJINQUAN 0815
		paras[0][i] = "N_PRM1";
		paras[1][i] = Objects.getHt(hashData,"N_PRM1");

		  try{
            System.out.println("try to set pmb data in PolicyOut.jsp");
            ob.setFormData(paras);
           }catch(NormalException e){
		     
	 	   if(NormalExceptionHandler.IsSevere(e))
	 	     throw NormalExceptionHandler.Handle(e);
	 	      else if(NormalExceptionHandler.IsWarning(e))
	 	      WarnMsg = e.getErrDesc();
			  e.printStackTrace();
	      }
		%>
		  <jsp:forward page="<%=forwardpage%>"/>
		<%
		
	   if(ClientType.equals(Const.CUST_AG)){
	      String desc="";
	      int c_undr_opn =  Objects.getColNum("c_undr_opn",Result);
		  if(c_undr_opn==-1)desc="";
		  else desc = Result[1][c_undr_opn];
          if(desc==null || desc.trim().length() == 0)desc="   ";
          int p = desc.indexOf(" ");
          p= desc.indexOf(" ",p+1);    
          desc =desc.substring(p);		  
	      %>您的投保业务,由于<%=(desc.trim())%> 批单未能自动生成，需要等待我公司的后台处理，我们将在一个工作日给您答复。
       <%}

	   out.println("你的批改申请号"+Result[1][c_edr_app_no]+".");
     }
     if(Result[1][c_rtrn_cde].equals("1")){
	    System.out.println("NNNNNNNNNNNNNNNNN");
	   out.println("你的批改申请已经通过系统自动核保,批单号："+Result[1][c_edr_no]+".");
	   }
	 
	}

 
%>
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