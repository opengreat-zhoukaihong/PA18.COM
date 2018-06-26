<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>      
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pab"  scope="page" class="beans.PolicyAppBean"/> 
<jsp:setProperty name="pab" property="*"/>
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>

<% 
     String Result[][]=null;
	 String PlyInfo[] = ob.getPlyInfo();
	 if(PlyInfo[TabPly.C_OPEN_COVER_NO].length()>0){
	    System.out.println("Yes this is accept notice in AcceptPlyApp.jsp");
	 %>
	   <jsp:forward page="AcceptNotice.jsp"/>
	 <%}
	 try
	 {
 		 ob.setStep(Const.STEP_BEG);
	     //ob.setFormData(FormData);               	   
         pab.setFormParaPre(Const.UPDATE_POLICYAPP,ob.getInsrInfo());
         
		 PlyInfo[TabPly.C_UDR_MRK] = "A"; //added by rao 
		 PlyInfo[TabPly.C_PLY_APP_NO] = request.getParameter("C_PLY_NO");
	     pab.setFormPara(Const.UPDATE_POLICYAPP,PlyInfo);
        
	 }
	 catch(NormalException e)
	 {
     
	    if(NormalExceptionHandler.IsSevere(e))
	 		throw NormalExceptionHandler.Handle(e);
	   else 
			if(NormalExceptionHandler.IsWarning(e))
	 			WarnMsg = e.getErrDesc();
      
	   }

	  Result = pab.getRetValueArra();
	        
    

if(!(Result==null))
{
    
    ob.setTempTwo(Result);
    request.setAttribute("OPER_TYPE","0");	
		%>
		  <jsp:forward page="Proposal.jsp"/>
		<%
    
}else
   {

    //	throw NormalExceptionHandler.Handle("0001","投保单提交失败。");

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

