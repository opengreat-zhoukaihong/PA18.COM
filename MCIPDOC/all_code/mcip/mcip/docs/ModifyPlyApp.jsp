
<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">


<%@ include file="public/Public.jsp" %>



<jsp:useBean id="pab"  scope="page" class="beans.PolicyAppBean"/> 
<jsp:setProperty name="pab" property="*"/>
<%
   //String OperType = Const.WITHDRAWAL_POLICYAPP; 
   String c_doc_no = request.getParameter("C_PLY_NO");
   
   try{
      pab.setFieldValue(Const.WITHDRAWAL_POLICYAPP,c_doc_no);
   }catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

    }
    boolean ResultBool = pab.getRetValueBool();
	if(ResultBool){
	  System.out.println("yes back up sucessful :"+c_doc_no);
	%>
	  <jsp:forward page="InputPolicy.jsp"/>
	<%}
%>

</body>
</html>