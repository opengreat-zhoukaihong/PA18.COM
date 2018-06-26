<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 

<%@ include file="public/PublicPlyLeft.html" %>

  <td width="613" height="288" valign="top"> <br>
	<table border="0"  width="80%" cellpadding="4">
	      <tr>
	<td width="5%">　　</td>
	<td>

<jsp:useBean id="pab"  scope="page" class="beans.PolicyAppBean"/> 
<jsp:setProperty name="pab" property="*"/>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>
     
<%
	/**add by kangjin for sending c_undr_prsn purpose 2001-09-13*/
	String c_undr_prsn = request.getParameter("c_undr_prsn");
	/*end of add*/
    String temp = request.getParameter("temp");
    String PrmCur = request.getParameter("PRM_CUR");    
    String PayType = request.getParameter("PAY_TYPE");        
	String nSumPrmValue = request.getParameter("n_sum_prm_value");
    String Result[][] = null;
    String ProposalArra[][] = ob.getTempTwo();   
    int c_doc_no_coln = Objects.getColNum("c_doc_no",ProposalArra);     
    String c_doc_no = ProposalArra[1][c_doc_no_coln];
    boolean ResultBool = false;
    int OperType = 0;
//    String[] FormPara = new String[3]; by Kangjin 2001-08-23  
    String[] FormPara = new String[4];  
    String PlyAppInfo[][] = null;
    String[] RMB = Const.RMB;

	
	String AgencyNo = request.getParameter("AGENCYNO");
	if(AgencyNo == null)AgencyNo = "";	
	String DispName = "保单";
	if(AgencyNo.equals(Const.EDRSMTAPP)){
	    System.out.println("Yes We can go into edrsmtapp--------------->>>>>");
		DispName  = "批单";
	}
      
      if(PrmCur == null)  
          PrmCur="";
      if(PayType == null)  
          PayType="";
      if(temp == null)    
        temp = (String)request.getAttribute("temp");

//get plyAppInfo
if(!AgencyNo.equals(Const.EDRSMTAPP)){

    System.out.println("!AgencyNo.equals(Const.EDRSMTAPP---------------------------->");
      try
      {
        pb.setFieldValue(Const.GET_POLICYAPPINFO,c_doc_no);
        PlyAppInfo = pb.getRetValueArra();
	ob.setFormData(PlyAppInfo);        
      }
      catch(NormalException e)
      {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
      }


     if(Servlets.getLen(PlyAppInfo) < 1)
     {
%>
    
<p>没有取得投保单数据。<%=WarnMsg%>

<%      
        return;
     }      
  
int C_CRGO_CDE = Objects.getColNum("C_CRGO_CDE",PlyAppInfo);   
System.out.println("C_CRGO_CDE:"+PlyAppInfo[1][C_CRGO_CDE]);

}//end if ! AgencyNo.equals(Const.EDRSMTAPP)



   
    System.out.println("in proposalMid temp:"+temp);
    if(!AgencyNo.equals(Const.EDRSMTAPP) && temp.equals(Const.AGR))//confirm
    {
      OperType = Const.CONFIRM_POLICYAPPPROPOSAL;
      int c_dpt_cde = Objects.getColNum("c_dpt_cde",PlyAppInfo);
      int c_insrnc_cde = Objects.getColNum("c_insrnc_cde",PlyAppInfo);
      FormPara[0] = c_doc_no;
      FormPara[1] = PlyAppInfo[1][c_dpt_cde];      
      FormPara[2] = PlyAppInfo[1][c_insrnc_cde];   
	  //following line added by kangjin in 2001-08-23
	  FormPara[3] = c_undr_prsn;
    }else if(temp.equals(Const.UNAGR)){
      /*<jsp:forward page="AddProposalNote.jsp"/>*/
      response.sendRedirect("AddProposalNote.jsp");
     }
    else if( temp.equals(Const.PRE))//goto pre page
    {
       //specail for para c_no_repay
       int c_no_repay = Objects.getColNum("c_no_repay",ProposalArra);
       String TempRepay = ProposalArra[1][c_no_repay];//request.getParameter("C_NO_REPAY");
       String[][]TempRepayArra = {{"C_NO_REPAY"},{TempRepay}};
       ob.setFormDataAdd(TempRepayArra);
%>    
     <jsp:forward page="ViewPolicy.jsp"/>
<%     
    }
    else if(!AgencyNo.equals(Const.EDRSMTAPP) && temp.equals(Const.MOD))//withdraw
    {
      OperType = Const.WITHDRAWAL_POLICYAPP;    
    }else if(!AgencyNo.equals(Const.EDRSMTAPP) && temp.equals(Const.UNDRAW)){
      OperType = Const.DELETE_POLICYAPP; 
    }
    
if(!AgencyNo.equals(Const.EDRSMTAPP)){
    try
    {
        if(temp.equals(Const.AGR))
        {

        	pab.setFormPara(OperType,FormPara);
        }
        else  if(temp.equals(Const.MOD))//withdraw
        {
        	pab.setFieldValue(OperType,c_doc_no);
        }else if(temp.equals(Const.UNDRAW)){ 
		    System.out.println("UNDRAW PROPOSAL______________________________________?");		       
            pab.setFieldValue(OperType,c_doc_no);
        }
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }
	Result = pab.getRetValueArra();
    ResultBool = pab.getRetValueBool();
}else{
     System.out.println("Yes We can go into edrsmtapp");
	 String edrAppInfos[] = ob.getTempOne();
	 System.out.println("Case1-----------------edrAppInfos[0]:"+edrAppInfos[0]);
     if(temp.equals(Const.AGR)){
	    try
       {
		 String OpenCoverNoArra[] = Servlets.DivideMultiStr(edrAppInfos[0],"&");
         edrAppInfos[0] = OpenCoverNoArra[0];
		 for(int p=0 ;p< edrAppInfos.length;p++)
		   System.out.println("edrAppInfos:"+edrAppInfos[p]);
         pmb.setFormPara(2,edrAppInfos);         
       }catch(NormalException e){
        ResultBool = false;
 	    if(NormalExceptionHandler.IsSevere(e))
 	       throw NormalExceptionHandler.Handle(e);
 	    else if(NormalExceptionHandler.IsWarning(e))
 	       WarnMsg = e.getErrDesc();
        }
	 }
	 if(temp.equals(Const.MOD)){
	     System.out.println("EDRAMTAPP MOD>>>>>>>>>>>>>>>>>ProposalMid.jsp");
		 System.out.println("edrAppInfos[0]:"+edrAppInfos[0]);
	    if(edrAppInfos[0]!=null && edrAppInfos[0].indexOf("&")>0){%>
		  <jsp:forward page="Policy_OC.jsp"/>
		<%} else{%>
		  <jsp:forward page="Policy.jsp"/>
		 <%}
	 }

	 if(temp.equals(Const.UNDRAW)){
	     System.out.println("Yes undraw this edrapp proposal..............in ProposalMid.jsp.");
		 System.out.println("c_doc_no:"+c_doc_no);
		  try{
		          pmb.setFieldValue(5,c_doc_no);
             }catch(NormalException e){	                 			     
	 	               if(NormalExceptionHandler.IsSevere(e)){
	 	                throw NormalExceptionHandler.Handle(e);
                       }else if(NormalExceptionHandler.IsWarning(e)){				        
					     WarnMsg = e.getErrDesc();
                       }
             }
	 }
	 
	 Result = pmb.getRetValueArra();
	 if(Result!=null){
	  for(int p= 0; p<Result[0].length;p++)
	   System.out.println(Result[0][p]+":"+Result[1][p]+"<p>");
	 }
	 ResultBool = pmb.getRetValueBool();
    
}//end if Const.EDRSMTAPP
   String appName = "投保单";
   if(AgencyNo.equals(Const.EDRSMTAPP))appName="批改申请单";  
    if(temp.equals(Const.UNDRAW)){// Added by Clark_Rao
        if(ResultBool){
		   System.out.println("undraw successful");
		%>
           <p><%=appName%>回撤成功。
        <%}else{
		   System.out.println("undraw failed");
		%>
           <p><%=appName%>回撤失败。
        <%}

    }
    else if(temp.equals(Const.MOD))
    {
       if(ResultBool)
       {
	   request.setAttribute("C_PLY_NO",c_doc_no);
	   request.setAttribute("OPER","PLYAPPMOD");
	   request.setAttribute("AGENCYNO",Const.FIND);
	   System.out.println("ProposalMid.jsp C_PLY_NO:>>>>>>>>>>>>>>>>>>>>>>"+ c_doc_no);
       ob.setStep(Const.STEP_BEG);
       System.out.println("read ty to  ponputpols6c......................");  
	     
%> 
     <jsp:forward page="InputPolicy.jsp"/> 
<%
       }
       else
       {
           // out.println("WithDraw  Policy failure");
%>
<p>投保单回撤失败。
<%
       }
    }
    else
    {
       int policy_no = Objects.getColNum("c_ply_no",Result);

       if(Result == null)
       {
            //out.println("confirm  Policy failure");
%>
<p>建议书确认失败。
<%
       }
       else
       {
	    String RemoteOperType = ob.getRemoteOperType();

	    if(RemoteOperType.equals(Const.REMOTE_PRP) || RemoteOperType.equals(Const.REMOTE_PLY))
            {
	          request.setAttribute("C_PLY_NO",Result[1][policy_no]);
%>
		<jsp:forward page="RemoteXMLSend.jsp"/>
<%
	    }
	    else
            {
%>
<p>&nbsp;&nbsp;&nbsp;&nbsp;建议书确认成功,你的<%=DispName%>号是：<%=Result[1][1]%>
<br>我们已就承保条件达成共识，我们将在最快的时间内将保险单送到您的手中,经您确认无误后收取保险费，保险单正式生效。
<%
            }
//get policyNo and display

       }            
    }
%>
<%      if(PrmCur.equals(RMB[0]) & PayType.equals("0"))//RMB and pay by internet
      {//is to be forward to payment page
		request.setAttribute("nSumPrmValue",nSumPrmValue);
		request.setAttribute("PlyNoDisp",Result[1][1]);
	  %>
        <jsp:forward page="Payment.jsp" />
      <%}%>

</p>
</td>
      </tr>
    </table>
</td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
