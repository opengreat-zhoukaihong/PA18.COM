
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
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> <%@ include file="public/PublicInquireLeft.jsp" %>      
<td>
<table border="0" width="70%" cellpadding="4" valign="top"><tr><td>


<%

   String formPara[] = new String[4];
   String ClientId =   sessionbuffer.getClientId(Locate);
   String policyapp_no = request.getParameter("C_DOC_NO");
   String C_USER_REMARK =  request.getParameter("C_USER_REMARK");
   formPara[0] = policyapp_no ;
   formPara[1] = ClientId ;
   formPara[2] = C_USER_REMARK ;
   String AgencyNo = request.getParameter("AGENCYNO");
   if(AgencyNo == null)AgencyNo = "";
   if(AgencyNo.equals(Const.EDRSMTAPP)){formPara[3] = "1"; }
   else{formPara[3] = "0";   }
   for(int i=0 ;i<3 ;i++)
     System.out.println("Add proposalNote out.jsp >>>>"+formPara[i]+":");
    try
    {
     	 pab.setFormPara(Const.ACCEPT_USERREMARK,formPara);

    }
    catch(NormalException e)
    {
 	    if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	     else if(NormalExceptionHandler.IsWarning(e))
 	     WarnMsg = e.getErrDesc();
 	     e.printStackTrace();
    }
    boolean bb = pab.getRetValueBool();
    if(bb){%>
       你的意见提交成功，我们尽快和你联系！
    <%}else{%>
     <%=WarnMsg%>
     
    <%}

%>
</td></tr>
</table>
</td></tr></table>



<%@ include file="public/PublicBottom.html" %>      
</body>
</html>
