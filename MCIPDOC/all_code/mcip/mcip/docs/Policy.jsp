


<html>
<body>


<%@ include file="public/Public.jsp" %>

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
      System.out.println("Policy.jsp start");
	  String rhm= "hello world121212345678910111235 ";

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
      int step = ob.getStep();
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


	  String C_PLY_NO = "";//保单号

	  String edrAppInfos[] =null ;

	  boolean UNDRAW = true;

      if(step == Const.STEP_BEG || step == Const.STEP_NEWMOD)
      {
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
		     AddAgencyNo = request.getParameter("ADDAGENCYNO");
           }

           if(!(PlyNo == null || PlyNo.equals("")))
           {
              String PlyInfo[][] = null;
	          String PlyAppRdrInfo[][] = null;

             // out.println("enter to get ply(App)info4  PlyNo:"+PlyNo);
             // out.println("OPER:"+Oper);
			 boolean hasModi = true;
	          try
	          {
	           
			    if(AgencyNo.equals(Const.CASE)){								  
				  String para[]={PlyNo};
				  pb.setFieldValue(Const.CHECK_EDRAPP,PlyNo);
				  hasModi = pb.getRetValueBool();
				  if(hasModi){
				     System.out.println("boolean hasModi .................................1");
				  }else{
				     System.out.println("boolean hasModi .................................2");
					 throw NormalExceptionHandler.Handle("400000027");
				  }
			      if(hasModi)pmb.setFormPara(0,para);
				  
				}else if(AgencyNo.equals(Const.EDRSMTAPP)){				   
				    try{				  
			          pmb.setFieldValue(3,PlyNo);
                     }catch(NormalException e){	                 			     
	 	               if(NormalExceptionHandler.IsSevere(e)){
					    UNDRAW = false;
				        System.out.println("CASE================ >>>>>Policy.jsp");	
						e.printStackTrace();					
	 	                  throw NormalExceptionHandler.Handle(e);
                       }else if(NormalExceptionHandler.IsWarning(e)){
				         System.out.println("CASE------------------>>>>>POLICY>JSP");
					     WarnMsg = e.getErrDesc();
                     }
                    }
					if(UNDRAW){
					  System.out.println("MY POINT2>>>>>>>>>>>>>>>POLICY>JSP"); 
				      pmb.setFormPara(4,edrAppInfos);
                    }else{
					   System.out.println("CANCEL FAILED POLICY>JSP");
					}
			   }
			}catch(NormalException e)
	         {   
			     System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYMMMMMMMMMMMMMM");
			     if(!hasModi){
				   System.out.println("prepre to throw eeeeeeeeeeeeeeeeeeeeeeee");
				    
					throw NormalExceptionHandler.Handle(new Exception("该保单已有批改申请单!"));
                 }
			     System.out.println("YESGFGFGFGFGHGHGHHJHJHJJKJKJKJKPOLICY>JSP");
	 	          if(NormalExceptionHandler.IsSevere(e)){
				     UNDRAW = false;
					 if(UNDRAW)System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
					 else System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
				     System.out.println("CASE!!!!!!!!!! >>>>>Policy.jsp");
					 e.printStackTrace();
	 	             throw NormalExceptionHandler.Handle(e);
                  }
	 	          else if(NormalExceptionHandler.IsWarning(e)){
				     System.out.println("CASE??????????????>>>>>POLICY>JSP");
					 WarnMsg = e.getErrDesc();
                  }
	         }
			 if(pmb.plyEdrAppRdrInfo==null)System.out.println("BBBBBBBBBBBBBBBBCCfffffffCC");
			 System.out.println("Start.........................44..................");	
			 PlyAppRdrInfo = pmb.plyEdrAppRdrInfo.edrapprdr;
              System.out.println("Start.........................22..................");	
              
               String C_insrnc = pmb.plyEdrAppInfo.c_insrnc_cde;
               String C_credit = pmb.plyEdrAppCrgoInfo.c_credit_id;
			   System.out.println("Start.........................33..................");	
			  // out.println("INSRNC_CDE:"+C_insrnc+","+C_credit);
				System.out.println("Start...........................................");	
               if(!(C_insrnc.equalsIgnoreCase(IMPORT) || C_insrnc.equalsIgnoreCase(EXPORT)))
               {
               	   HomeTransit[0] = C_insrnc;
               	   C_insrnc = HOME;
               }
               else if (C_insrnc.equalsIgnoreCase(EXPORT))
               {
                  	   if(C_credit == null || C_credit.equals(""))
                  	       C_credit = NOCREDIT;
               }
			   System.out.println("Start..........................................11.");
               ob.setHomeTransit(HomeTransit);
               ob.setTranType(C_insrnc);
     		   ob.setCredit(C_credit);

     			    
               if(PlyAppRdrInfo!=null && (C_insrnc.equalsIgnoreCase(IMPORT) || (C_insrnc.equalsIgnoreCase(EXPORT) & C_credit.equals(NOCREDIT))))
               {
			        System.out.println(PlyAppRdrInfo.length);
			        for(int p=0 ;p< PlyAppRdrInfo.length;p++)
					{
					  for(int q=0 ; q< PlyAppRdrInfo[0].length; q++){
					  System.out.println(" "+ p + ","+ q);
					  System.out.println(PlyAppRdrInfo[0][q]+":"+PlyAppRdrInfo[p][q]);}
					}  
		            PortTransit = Servlets.GetInsrncAddtion(PlyAppRdrInfo,PortTransit);
		            boolean IsPort = false;
		              for(int k=0;k<Const.PORT_TRANSIT_LEN;k++)
		              {
					     System.out.println(PortTransit[k]);
		                 if(!(PortTransit[k] == null || PortTransit[k].equals("")))
		                       IsPort = true;
		              }
	                  if(!IsPort)
		               {//temp tip for dataError,is to be throw exception
                       
                         out.println("没有取得与进/出口类型相匹配的险种数据。");
                       
		                  return;
		               }
          		       
		               ob.setPortTransit(PortTransit);
		            }//end if port              
	        }	       

		   
      }

	  System.out.println("Policy.jsp container1:"+ pmb.plyEdrAppCrgoInfo.c_container);

      Hashtable valuesTable = new Hashtable(100);
	  Object obj = (Object)pmb.plyEdrAppInfo;
      Class c = obj.getClass();
      Field[] fields =c.getFields();
      String fieldName ="";
	  String fieldValue="";
      System.out.println("pmb.plyEdrAppInfo fields:");
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

	  System.out.println("pmb.plyEdrAppCargoInfo fields:");
	  System.out.println("Policy.jsp container:"+ pmb.plyEdrAppCrgoInfo.c_container);
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


      if(!ClientType.equals(Const.CUST_AG)){
		  System.out.println("pmb.plyEdrAppNetInfo fields:");
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
        } 
    
	    
	    String N_PRM1 = pmb.plyEdrAppInfo.n_prm;

	    if(AgencyNo.equals(Const.EDRSMTAPP)){	
           System.out.println("Yes we will to get old prm in policy.jsp");
			String para[]={pmb.plyEdrAppInfo.c_ply_no};		
			try
			{   System.out.println("in get Old N_PRM to in POLICY>JSP ");
				pmb1.setFormPara(0,para);
			}
			catch(NormalException e)
			{
				System.out.println("Error in get Old N_PRM in Policy.jsp");		    
 				if(NormalExceptionHandler.IsSevere(e))
 				throw NormalExceptionHandler.Handle(e);
			}
						    N_PRM1 = pmb1.plyEdrAppCrgoInfo.n_prm;
		}else{
		   System.out.println("NO we will to get old prm in policy.jsp");
		}

		System.out.println("POLICY>JSP N_PRM1:"+N_PRM1);
		String paras[][]= new String[2][valuesTable.size()+1];
		Enumeration ee = valuesTable.keys();
		i =0 ;
		while(ee.hasMoreElements()){
		  String key = (String)ee.nextElement();
		 // System.out.println("Key:"+key+":"+(String)(valuesTable.get(key)));
		  paras[0][i] = key;
		  paras[1][i] = ((String)(valuesTable.get(key))).trim();
		  i++;
		}
		paras[0][i] = "N_PRM1";
		paras[1][i] = N_PRM1;

		try{
         System.out.println("try to set pmb data in Policy.jsp");
         ob.setFormData(paras);
        }catch(NormalException e){
	 	    if(NormalExceptionHandler.IsSevere(e))
	 	     throw NormalExceptionHandler.Handle(e);
	 	      else if(NormalExceptionHandler.IsWarning(e))
	 	      WarnMsg = e.getErrDesc();
	    }

%>
<jsp:forward page="PolicyC.jsp"/>
</body>
</html>