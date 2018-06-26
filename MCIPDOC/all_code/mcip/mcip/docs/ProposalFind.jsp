<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>
   
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>

<%
    String PlyNo = request.getParameter("C_PLY_NO");
    String Result[][] = null;
    String RemoteOperType = ob.getRemoteOperType();


	String PlyNoStr = request.getParameter("C_PLY_NO");
    String edrAppInfos[] = null ;//new String[3];
    edrAppInfos = Tools.DevideString(PlyNoStr ,",");
	String[] tempOne = new String[3];
	for(int p=0 ;p< edrAppInfos.length;p++)
	  tempOne[p]= edrAppInfos[p];
	ob.setTempOne(tempOne);//add by rao 2001/4/15
	System.out.println("ProposalFind.jsp-----------edrAppInfos[0]:"+edrAppInfos[0]);
	//String OpenCoverNoArra[] = Servlets.DivideMultiStr(edrAppInfos[0],"&");
    //edrAppInfos[0] = OpenCoverNoArra[0];

    

      //especial for opencover
	   String AgencyNo = request.getParameter("AGENCYNO");
	   if(AgencyNo == null)AgencyNo = "";		 
	   if(AgencyNo.equals(Const.EDRSMTAPP)){
	     String[] tempParas = Tools.DevideString(PlyNo ,",");
		 PlyNo = tempParas[0];
	   }

      if(PlyNo.indexOf("&") > 0)
      {
         String PlyNoTemp[] = Servlets.DivideMultiStr(PlyNo,"&");
         PlyNo = PlyNoTemp[0];
      }
      try
      {
        pb.setFieldValue(Const.GET_PROPOSALINFO,PlyNo);
        Result = pb.getRetValueArra();

      }
      catch(NormalException e)
      {
// 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 //	else if(NormalExceptionHandler.IsWarning(e))    
 //	    WarnMsg = e.getErrDesc(); 
 	    
      }
   
if(!(Result==null))
{
   System.out.println("This is proposal in ProposalFind.jsp.......................");
   for(int p=0;p<Result[0].length;p++)
     System.out.println(Result[0][p]+":"+Result[1][p]);
System.out.println("PlyNo3 in proposao find:"+PlyNo);

    ob.setTempTwo(Result);
        request.setAttribute("OPER_TYPE","1");
		/**add by kangjin for sending c_undr_prsn purpose 2001-09-13*/
		request.setAttribute("c_undr_prsn",Result[1][Objects.getColNum("C_UNDR_PRSN",Result)]);
%>

<jsp:forward page="Proposal.jsp"/>
<%           
}
else
{
%>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr> 

<%@ include file="public/PublicPlyLeft.html" %>

    <td width="613" height="288" valign="top"> <br>
	<p>建议书查询失败,没有建议书数据返回。

<%
}  
%>

</td>
  </tr>
</table>
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>