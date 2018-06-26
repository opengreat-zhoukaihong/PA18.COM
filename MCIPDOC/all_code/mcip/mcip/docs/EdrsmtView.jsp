<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<<%@ include file="public/Public.jsp" %>

<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
     
<%
	String language = request.getParameter("language");
    String PlyNoStr = request.getParameter("C_PLY_NO");
    String queryInfos[] = null ;//new String[3];
    queryInfos = Tools.DevideString(PlyNoStr ,",");
    String PlyNo = queryInfos[0];
    String PlyInfo[][] = null;
    out.println("PlyNo:"+PlyNo);     
//get plyInfo
      try
      {
        pb.setFieldValue(Const.GET_EDRSMTINFO,PlyNo);
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
      
          for(int j=0; j< PlyInfo[0].length;j++)
          System.out.println(PlyInfo[0][j]+":"+PlyInfo[1][j]);
          
      int c_insrnc_cde = Objects.getColNum ("C_INSRNC_CDE", PlyInfo);
	  String C_INSRNC_CDE = PlyInfo[1][c_insrnc_cde];
	  String forwardPage="LocalPolicyView.jsp";
	  if(C_INSRNC_CDE.equals(Const.C_EXPORT_CDE)){
	    forwardPage= "ExportPolicyView.jsp";	   
	  }else if(C_INSRNC_CDE.equals(Const.C_IMPORT_CDE)){
	    forwardPage= "ImportPolicyView.jsp";
	  }
	  request.setAttribute("language",language);

%>  
  <jsp:forward page="<%=forwardPage%>"/>   
 
</div>
</body>
</html>
