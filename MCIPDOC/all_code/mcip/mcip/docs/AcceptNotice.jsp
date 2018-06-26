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
<jsp:useBean id="obn"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="obn" property="*"/>
<jsp:useBean id="pb"  scope="request" class="beans.PolicyInfoBean"/>
<jsp:setProperty name="pb" property="*"/>


<%  
    
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<AcceptNotice.jsp<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	   
    try
    {
         String[][] InsrInfo = obn.getInsrInfo();        
		 String PlyInfo[]= obn.getPlyInfo();
		 PlyInfo[TabPly.C_UDR_MRK] = "A";
		 PlyInfo[TabPly.C_PLY_APP_NO] = request.getParameter("C_PLY_NO");
		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<2 <AcceptNotice.jsp<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
         pab.setFormParaPre(Const.UPDATE_POLICYAPP,InsrInfo);
		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<3 <AcceptNotice.jsp<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");	    
         pab.setFormPara(Const.UPDATE_POLICYAPP,PlyInfo);
		 System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<4 <AcceptNotice.jsp<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");	    
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }
System.out.println("8888888888888888");
   String  Result[][] = pab.getRetValueArra();
     
    
if(!(Result == null))
{  
   
   int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result);    //flag
   int c_ply_app_no = Objects.getColNum("c_ply_app_no",Result);
   int c_ply_no = Objects.getColNum("c_ply_no",Result); 
   String ret = Result[1][c_rtrn_cde];
//   out.print(ret);
     if(ret.equals("0"))
   {
     int c_undr_opn =  Objects.getColNum("c_undr_opn",Result);
     String desc = Result[1][c_undr_opn];
     if(desc==null || desc.trim().length() == 0)desc="   ";
     int p = desc.indexOf(" ");
     p= desc.indexOf(" ",p+1);    
     desc =desc.substring(p);
   %>   
 
        <p>&nbsp;&nbsp;&nbsp;&nbsp;起运通知书提交成功,您的投保单号是：<%=Result[1][c_ply_app_no]%>.
        <br>&nbsp;&nbsp;&nbsp;&nbsp;您的投保业务<%if(desc.trim().length()>0){%>由于<%=(desc.trim())%> <%}%>保单未能自动生成，需要等待我公司的后台处理，我们将在一个工作日给您答复。
  
   <%
   }
   else if(ret.equals("1"))       
   {    
%>
<p>起运通知书提交成功,您的保单号是：<%=Result[1][c_ply_no]%>
  <form action="Find_PlyView.jsp">
      <input type="hidden" name="C_PLY_NO" value="<%=Result[1][c_ply_no]%>">
	  <input type="hidden" name="Preview" value="0">
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
<p>起运通知书提交失败。
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
