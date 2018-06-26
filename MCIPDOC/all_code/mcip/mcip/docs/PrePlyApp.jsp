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
<jsp:useBean id="pab"  scope="page" class="beans.PolicyAppBean"/>
<jsp:setProperty name="pab" property="*"/>
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>

<%  //for get login para and to bean

    String PlyInfo[] = null;
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
	System.out.println("***********************");
	System.out.println("PlyApp NO."+PlyAppNo);
	System.out.println("***********************");
    if(Credit == null || Credit.equals(""))
       Credit = Const.C_NOCREDIT_CDE;


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

    String ProvinceOld = Objects.getHt(ob.getHashData(),"C_PROVINCE");

    Servlets servlets = new Servlets(RemoteOperType,RemoteData);
	InsrInfo = servlets.PolicyServlet(request,TranType,Transit,TransitName);
	FormData = servlets.getFormData();

    if(Temp.equals(Const.REP))
    {
	    try
	    {


          // ADDED BY CLARK_RAO-----2/14/2001

            int index = Objects.getColNum ("N_RATE", FormData);
            String n_rate_str = FormData[1][index];
            double n_rate = Objects.ToDouble(n_rate_str);
            FormData[1][index] = n_rate/100+"";
            index = Objects.getColNum("C_INSRNT_NME",FormData);

          // End ADDED BY CLARK_RAO-----2/14/2001

          ob.setStep(Const.STEP_REP);
	        ob.setFormData(FormData);
	    }
	    catch(NormalException e)
	    {
	 	    if(NormalExceptionHandler.IsSevere(e))
	 	     throw NormalExceptionHandler.Handle(e);
	 	      else if(NormalExceptionHandler.IsWarning(e))
	 	      WarnMsg = e.getErrDesc();
	    }

      if(ClientType.equals(Const.CUST_AG))//agent//agent special
      {
                   String  C_Agt_Agr_NoTemp = request.getParameter("AGENCYNO");
                   String N_Sub_Co_NoTemp = request.getParameter("ADDAGENCYNO");
		               request.setAttribute("AGENCYNO",C_Agt_Agr_NoTemp);
		               request.setAttribute("ADDAGENCYNO",N_Sub_Co_NoTemp);
	     }
       String ChangFlag = "1";//cargocls
       if(ProvinceOld.equals(ProvinceNew) || ClientType.equals(Const.CUST_AG))
       ChangFlag = "0";//province
       request.setAttribute("CHANGFLAG",ChangFlag);
       %>
       <jsp:forward page="InputPolicy.jsp"/>
       <%
    }
    else if(Temp.equals(Const.SUB))
    {
            PlyInfo = servlets.getDelivery();


        if(PlyAppNo == null || PlyAppNo.equals(""))  //new policy
        {
              //ob.setStep(Const.STEP_SUB);
                OperType = Const.ACCEPT_POLICYAPP;
         }
         else//modify policy
        {
               //ob.setStep(Const.STEP_MOD);
                OperType = Const.UPDATE_POLICYAPP;
                PlyInfo[TabPly.C_PLY_APP_NO] = PlyAppNo;
                IsModify = true;
        }
            PlyInfo[TabPly.C_CREDIT_ID] = Credit;

         if(Credit.equals(Const.C_CREDIT_CDE))
         {
              InsrInfo = new String[1][1];
              InsrInfo[0][0]  = "";
         }

         if(ClientType.equals(Const.CUST_AG))//agent//agent special
            {

                String C_Agt_Agr_No = "";
                String N_Sub_Co_No = "";
                if(IsModify)
                {

                    C_Agt_Agr_No = Objects.getHt(ob.getHashData(),"C_AGT_AGR_NO");
                    N_Sub_Co_No = Objects.getHt(ob.getHashData(),"N_SUB_CO_NO");


                    if(C_Agt_Agr_No==null || C_Agt_Agr_No==""){
                       C_Agt_Agr_No = request.getParameter("AGENCYNO");
                       N_Sub_Co_No = request.getParameter("ADDAGENCYNO");
                    }
                    if(N_Sub_Co_No.equalsIgnoreCase("null"))
                    {
                       N_Sub_Co_No = "";
                    }
                }
                else
                {
                    C_Agt_Agr_No = request.getParameter("AGENCYNO");
                    N_Sub_Co_No = request.getParameter("ADDAGENCYNO");
                    if(N_Sub_Co_No.equalsIgnoreCase("null"))
                    {
                       C_Agt_Agr_No = "";
                       N_Sub_Co_No = "";
                    }
                }
                //out.println("C_Agt_Agr_No**N_Sub_Co_No::"+C_Agt_Agr_No+"***"+N_Sub_Co_No);
	              PlyInfo[TabPly.C_AGT_AGR_NO] = C_Agt_Agr_No;
	              PlyInfo[TabPly.N_SUB_CO_NO] = N_Sub_Co_No;
            	  PlyInfo[TabPly.C_CMPNY_AGT_CDE] = ClientId;
               //PlyInfo[TabPly.C_CMPNY_AGT_NME] = ClientName;
            	  PlyInfo[TabPly.C_BSNS_TYP] = "2";//resourse from business
            	 //special for address while agent
                 String NetAddPara[] = {ClientType,ClientId};
	              String NetAddInfo[][] = null;
	              try
	             {
   	               pb.setFormPara(Const.GET_PLYAPPNETADDRESS,NetAddPara);
	                 NetAddInfo = pb.getRetValueArra();
	              }
	              catch(NormalException e)
	              {
                  //if(NormalExceptionHandler.IsSevere(e))
	 	              // throw NormalExceptionHandler.Handle(e);
                  //	 	 else if(NormalExceptionHandler.IsWarning(e))
                  	 	    WarnMsg = e.getErrDesc();
                          //out.println("rhm case 1:" + WarnMsg);
	              }

	               ob.setFormData(NetAddInfo);

		           PlyInfo[TabPly.C_PROVINCE] = Objects.getHt(ob.getHashData(),"C_PROVINCE");
		           PlyInfo[TabPly.C_CITY] = Objects.getHt(ob.getHashData(),"C_CITY");
		           PlyInfo[TabPly.C_DPT_CDE] = Objects.getHt(ob.getHashData(),"C_DPT_CDE");
		           PlyInfo[TabPly.C_PLACE] = Objects.getHt(ob.getHashData(),"C_PLACE");
		           PlyInfo[TabPly.C_CONTACT_NAME] = Objects.getHt(ob.getHashData(),"C_CONTACT_NAME");
		           PlyInfo[TabPly.C_CONTACT_PHONE] = Objects.getHt(ob.getHashData(),"C_CONTACT_PHONE");
		           PlyInfo[TabPly.C_CONTACT_FAX] = Objects.getHt(ob.getHashData(),"C_CONTACT_FAX");
		           PlyInfo[TabPly.C_CONTACT_EMAIL] = Objects.getHt(ob.getHashData(),"C_CONTACT_EMAIL");

             }
              else
             {
              //out.println("case 1");
            	PlyInfo[TabPly.C_APP_CDE] = ClientId;//while agent no use
            	PlyInfo[TabPly.C_APP_NME] = ClientName;//while agent disposed in servlets
             }

             //dispose for site cde
	           if(RemoteOperType.equals(Const.REMOTE_PRP) || RemoteOperType.equals(Const.REMOTE_PLY))
	           {
	                PlyInfo[TabPly.C_SITE_CDE] = Const.HR_SITE_CDE;
	            }
	           else
	            {
	               PlyInfo[TabPly.C_SITE_CDE] = Const.PA_SITE_CDE;
	            }
             //especially for invc_no
	          if(TranType.equals(Const.C_HOME_CDE))
	          {
	             if(PlyInfo[TabPly.C_INVC_NO].equals("待补"))
	              PlyInfo[TabPly.C_INVC_NO] = "";
	            if(PlyInfo[TabPly.C_RECEIPT_NO].equals("待补"))
	              PlyInfo[TabPly.C_RECEIPT_NO] = "";
	          }
	         try
	         {

			  //	 PlyInfo[TabPly.C_MDFY_TM] = "2001-09-01 10:10:10";
			  System.out.println("****************************");
			  System.out.println("PlyInfo[TabPly.C_MDFY_TM]:"+PlyInfo[TabPly.C_MDFY_TM]);
			  System.out.println("Oper Type:"+OperType);
			  System.out.println("****************************");

 		         ob.setStep(Const.STEP_BEG);
	             ob.setFormData(FormData);
               //ob.setTempOne(Dept_Insrnc);
               pab.setFormParaPre(OperType,InsrInfo);
			   PlyInfo[TabPly.C_UDR_MRK] = "B"; //added by rao
			   ob.setPlyInfo(PlyInfo);
			   ob.setInsrInfo(InsrInfo);
	           pab.setFormPara(OperType,PlyInfo);
			   System.out.println("<---------------------------PlyApp submited info:B--------------------------->");
			   for ( i=0;i<PlyInfo.length;i++)
				   System.out.println("PlyInfo["+i+"]:"+PlyInfo[i]);
				System.out.println("<---------------------------PlyApp submited info:E--------------------------->");
	         }
	         catch(NormalException e)
	         {
             //Modified by rhm
	           	if(NormalExceptionHandler.IsSevere(e))
	 				throw NormalExceptionHandler.Handle(e);
	 	       else
					if(NormalExceptionHandler.IsWarning(e))
	 					WarnMsg = e.getErrDesc();
              //out.println("rhm case 2:"+ WarnMsg);
	           }
	          Result = pab.getRetValueArra();
	         String resultstr ="empty";
	        if (Result==null)
	         resultstr="null";
	         //out.println("complete invoke plyappimpletement and Result:"+resultstr);
	        //end testing
    }

if(!(Result==null))
{
    ob.setTempTwo(Result);
    request.setAttribute("OPER_TYPE","0");
	int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result);    //flag
    int c_doc_no = Objects.getColNum("c_doc_no",Result);
    int c_ply_app_no = Objects.getColNum("c_ply_app_no",Result);
	int c_ply_no = Objects.getColNum("c_ply_no",Result);
	String ret = Result[1][c_rtrn_cde];
	String forwardpage = "LocalPolicyView.jsp";
	if (TranType.equals(Const.C_IMPORT_CDE)){
     forwardpage="ImportPolicyView.jsp";
	}else if(TranType.equals(Const.C_EXPORT_CDE)){
     forwardpage="ExportPolicyView.jsp";
    }
	if(ret.equals("0"))
		{
		 String temp1 =  Result[1][c_ply_app_no];
		 String PlyInfos[][] = null;
		 try{
	            pb.setFieldValue(Const.GET_POLICYAPPINFO,temp1);
	            PlyInfos = pb.getRetValueArra();
	      }catch(NormalException e)
	      {
	 	          if(NormalExceptionHandler.IsSevere(e))
	 	             throw NormalExceptionHandler.Handle(e);
	 	          else if(NormalExceptionHandler.IsWarning(e))
	 	            WarnMsg = e.getErrDesc();
	      }
		  ob.setFormData(PlyInfos);
		  String language = request.getParameter("language");
		  request.setAttribute("language",language);
		  request.setAttribute("FromApp","PlyApp");
		%>
		  <jsp:forward page="<%=forwardpage%>"/>
		<%
	}

   }
   else
   {
	if (true)
    	throw NormalExceptionHandler.Handle("0001","投保单提交失败，请检查发票和提单号。");

    %>
    <p>投保单提交失败。<%=WarnMsg%>
    <%

    //  out.println("No data return from PolicyappmanagerImpl");
   }
   %>


<%String sessionid = Code.Encrypt(sessionId);%>
<input type="hidden" name="sessionid" value="<%=sessionid%>">
</body>
</html>

