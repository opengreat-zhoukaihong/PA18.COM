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
<%@ include file="public/PublicMemLeft.jsp" %>
    <td width="613" height="288" valign="top"> <br>
      <img src="images/open_notice.gif" width="150" height="31" alt="起运通知书">
<br>　　　　　　
 <table border="0" width="95%" cellpadding="4" >
   <tr> 
<td width="5%">　</td>
   
<td>


<jsp:useBean id="pab"  scope="request" class="beans.PolicyAppBean"/> 
<jsp:setProperty name="pab" property="*"/>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="obn"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="obn" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>


<%  //for get login para and to bean
    String PlyInfo[] = null;
    String FormData[][] = null;
    String Result[][] = null;
    String InsrInfo[][] = null;            
    String ClientName = sessionbuffer.getClientName(Locate);        
    Hashtable hashData = new Hashtable();
    hashData = obn.getHashData();
    String IsModify = request.getParameter("MODIFY_FLAG");
    int OperType = Const.ACCEPT_POLICYAPP;


    Servlets servlets = new Servlets();
    servlets.NoticeServlet(request);
    PlyInfo = servlets.getDelivery();
    if(IsModify.equals("1"))
    {
       OperType = Const.UPDATE_POLICYAPP;
       PlyInfo[TabPly.C_PLY_APP_NO] = request.getParameter("C_PLY_APP_NO");
    }

	PlyInfo[TabPly.C_PROVINCE] = Objects.getHt(hashData,"C_PROVINCE").trim(); 
	PlyInfo[TabPly.C_CITY] = Objects.getHt(hashData,"C_CITY").trim();  
	PlyInfo[TabPly.C_PLACE] = Objects.getHt(hashData,"C_PLACE");  
	PlyInfo[TabPly.C_CONTACT_NAME] = Objects.getHt(hashData,"C_CONTACT_NAME"); 
	PlyInfo[TabPly.C_CONTACT_PHONE] = Objects.getHt(hashData,"C_CONTACT_PHONE");  
	PlyInfo[TabPly.C_CONTACT_FAX] = Objects.getHt(hashData,"C_CONTACT_FAX");  
	PlyInfo[TabPly.C_CONTACT_EMAIL] = Objects.getHt(hashData,"C_CONTACT_EMAIL");  
	PlyInfo[TabPly.N_RATE] = Objects.getHt(hashData,"N_RATE");  
	PlyInfo[TabPly.C_OPEN_COVER_NO] = Objects.getHt(hashData,"C_OPEN_COVER_NO");  

	PlyInfo[TabPly.C_DPT_CDE] = Objects.getHt(hashData,"C_DPT_CDE");  
	PlyInfo[TabPly.C_INSRNT_CDE] = Objects.getHt(hashData,"C_INSRNT_CDE");  
	PlyInfo[TabPly.C_APP_CDE] = Objects.getHt(hashData,"C_APP_CDE");  
	PlyInfo[TabPly.C_CRGO_CLS] = Objects.getHt(hashData,"C_CRGO_CLS");  			
	PlyInfo[TabPly.C_CRGO_CDE] = Objects.getHt(hashData,"C_CRGO_CDE");  			
	PlyInfo[TabPly.C_CRGO_DESC] = Objects.getHt(hashData,"C_CRGO_DESC");  			
	PlyInfo[TabPly.C_BSNS_TYP] = Objects.getHt(hashData,"C_BSNS_TYP");  			
	PlyInfo[TabPly.C_BSNS_TYP] = PlyInfo[TabPly.C_BSNS_TYP].trim();
	
	PlyInfo[TabPly.C_NO_REPAY] = Objects.getHt(hashData,"N_NO_REPAY_DESC");  			
	PlyInfo[TabPly.C_UNDR_CNDTN] = Objects.getHt(hashData,"C_UNDR_CNDTN");  			
	//PlyInfo[TabPly.C_PAY_ADDR] = Objects.getHt(hashData,"C_PAY_ADDR");  			
	PlyInfo[TabPly.C_SRVY_CNM] = Objects.getHt(hashData,"C_SRVY_CNM");  			
		
	if(PlyInfo[TabPly.C_INSRNT_NME].equals(""))
	   PlyInfo[TabPly.C_INSRNT_NME] = Objects.getHt(hashData,"C_INSRNT_NME");  

        PlyInfo[TabPly.C_APP_NME] = ClientName;	   
        PlyInfo[TabPly.C_CREDIT_ID] = Const.C_CREDIT_CDE;        
        
        PlyInfo[TabPly.C_SITE_CDE] = Const.PA_SITE_CDE;	    
System.out.println("PlyInfo[TabPly.C_INSRNT_NME]:"+PlyInfo[TabPly.C_INSRNT_NME]);
System.out.println("PlyInfo[TabPly.N_INVC_AMT]:"+PlyInfo[TabPly.N_INVC_AMT]);
	   
    try
    {
         InsrInfo = new String[1][1];
         InsrInfo[0][0]="";
		 PlyInfo[TabPly.C_UDR_MRK] = "B";
		 obn.setPlyInfo(PlyInfo);
		 obn.setInsrInfo(InsrInfo);
         pab.setFormParaPre(OperType,InsrInfo);	    
         pab.setFormPara(OperType,PlyInfo);
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }
System.out.println("8888888888888888");
    Result = pab.getRetValueArra();
    
if(!(Result == null))
{  
   
   int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result);    //flag
   int c_ply_app_no = Objects.getColNum("c_ply_app_no",Result);
   int c_ply_no = Objects.getColNum("c_ply_no",Result); 
   String ret = Result[1][c_rtrn_cde];
//   out.print(ret);
     if(ret.equals("0"))
   {
         
         String forwardpage = "LocalPolicyView.jsp";
         String TranType= PlyInfo[TabPly.C_INSRNC_CDE];
         if (TranType.equals(Const.C_IMPORT_CDE)){
            forwardpage="ImportPolicyView.jsp";
         }else if(TranType.equals(Const.C_EXPORT_CDE)){
            forwardpage="ExportPolicyView.jsp";
         }   
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
 
        <p>起运通知书提交成功,您的投保单号是：<%=Result[1][c_ply_app_no]%>
        <br>您的保额超出预约保险限额，请注意查收核保意见。
  
<%
   }
   else if(ret.equals("1"))       
   {    
%>
<p>起运通知书提交成功,您的保单号是：<%=Result[1][c_ply_no]%>
  <form action="Find_PlyView.jsp">
      <input type="hidden" name="C_PLY_NO" value="<%=Result[1][c_ply_no]%>">
      <input type="submit" name="submit1" value="保单打印">
			  <select name="language" size="1">
        <option value="CHN" selected>中</option>
		<option value="ENG">英</option>
</select>

     <br>
   </form>
<%
   }

}
else
{
%>
<p>起运通知书提交失败,请检查发票／提单号。
<%

//   out.println("you failure");
}	

%>

      
    </td>
  </tr>
</table>


 </td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
