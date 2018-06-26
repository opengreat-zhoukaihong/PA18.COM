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
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>

<%
      Hashtable hashData = new Hashtable();

      hashData = ob.getHashData();

	String language = request.getParameter("language");
	String Preview = StringTool.null2Blank(request.getParameter("Preview"));
    String C_Ply_No = request.getParameter("C_PLY_NO");

	if(C_Ply_No!=null){

	 int index = C_Ply_No.indexOf("&");

	 if(index>0) C_Ply_No = C_Ply_No.substring(0,index);
     String PlyInfo[][] = null;
     //get plyInfo
      try
      {
        pb.setFieldValue(Const.GET_POLICYINFO_LATEST,C_Ply_No);
        PlyInfo = pb.getRetValueArra();
	    ob.setFormData(PlyInfo);
      }
      catch(NormalException e)
      {
 	  if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	  else if(NormalExceptionHandler.IsWarning(e))
 	    WarnMsg = e.getErrDesc();

      }

  }
	  //added by kangjin for new policy print request2001-4-6
	   String TranType = Objects.getHt(hashData,"C_INSRNC_CDE");

	  //end of added by kangjin for new policy print request2001-4-6
	  request.setAttribute("language",language);
	  request.setAttribute("Preview",Preview);
%>
<%//added by kangjin for new policy print request2001-4-6
if (TranType.equals(Const.C_IMPORT_CDE)){
//end of added by kangjin for new policy print request2001-4-6%>
<jsp:forward page="ImportPolicyView.jsp"/>
<%//added by kangjin for new policy print request2001-4-6
}
//end of added by kangjin for new policy print request2001-4-6%>

<%//added by kangjin for new policy print request2001-4-6
if (TranType.equals(Const.C_EXPORT_CDE)){
//end of added by kangjin for new policy print request2001-4-6%>
<jsp:forward page="ExportPolicyView.jsp"/>
<%//added by kangjin for new policy print request2001-4-6
}
//end of added by kangjin for new policy print request2001-4-6%>
<jsp:forward page="LocalPolicyView.jsp"/>
<jsp:forward page="ViewPolicy.jsp"/>
</div>
</body>
</html>
