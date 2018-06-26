

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
<%@ include file="public/PublicPlyLeft.html" %>
    <td width="613" height="288" valign="top"> <br>
      <img src ="images/baodpg-b.gif" width="150" height="31" alt="保单批改">
<br>　　　　　　
 <table border="0" width="95%" cellpadding="4" >
   <tr> 
  <td width="5%">　</td>
  <td><table border="0" width="95%" cellpadding="4" ><tr><td>


<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/>
<jsp:setProperty name="ob" property="*"/>
<jsp:useBean id="pb"  scope="page" class="beans.PolicyInfoBean"/> 
<jsp:setProperty name="pb" property="*"/>
<form action="Find_PlyView.jsp">
<input type="hidden" name="Preview" value="0">


<%  String ClientType = sessionbuffer.getClientType(Locate);
    String Result[][] = ob.getTempTwo();
	String insuranceID = request.getParameter("insuranceID");
	//out.println("debug0.......... PlyEdrApp.jsp");
	if(Result!=null){
	 int c_rtrn_cde = Objects.getColNum("c_rtrn_cde",Result); 
	 int c_edr_app_no = Objects.getColNum("c_edr_app_no",Result);
	 int c_edr_no = Objects.getColNum("c_edr_no",Result);

	// out.println("Result[1][c_rtrn_cde]:"+Result[1][c_rtrn_cde]);
	 int c_undr_opn =  Objects.getColNum("c_undr_opn",Result);
	 //out.println("Result[1][c_undr_opn]:"+Result[1][c_undr_opn]);
	 
	 if(Result[1][c_rtrn_cde].equals("0")){	     
	   //out.println("debug1.......... PlyEdrApp.jsp");
		
	   if(ClientType.equals(Const.CUST_AG) || ClientType.equals(Const.CUST_OC)){
	      String desc="";
		  if(c_undr_opn==-1)desc="";
		  else desc = Result[1][c_undr_opn];
          if(desc==null || desc.trim().length() == 0)desc="   ";
          int p = desc.indexOf(" ");
          /**p= desc.indexOf(" ",p+1);    
          desc =desc.substring(p);*/
		  
		        StringTokenizer st = new StringTokenizer(desc," ");
        p=0;
      	while (st.hasMoreTokens()) {
      	          try	{
         		desc = st.nextToken();
                         p = p +1;
         		}
       			catch(NoSuchElementException e){}
       			if(p==2)break;
      	}
		  if(desc.trim().length()>0){		  
	      %>&nbsp;&nbsp;&nbsp;&nbsp;您的保单批改业务,由于<font color="red"><%=(desc)%> </font>批单未能自动生成，需要等待我公司的后台处理，我们将在一个工作日给您答复。
       <%}
	   }
       
	   %><br>&nbsp;&nbsp;&nbsp;&nbsp;你的批改申请号<%=Result[1][c_edr_app_no]%>.<%
     }
	 if(Result[1][c_rtrn_cde].equals("1")){
	   // out.println("debug2.......... PlyEdrApp.jsp");
	    String C_EDR_NO = Result[1][c_edr_no];
        String PlyInfo[][] = null;    

        try
       {
          pb.setFieldValue(Const.GET_EDRSMTINFO,C_EDR_NO);
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
	    System.out.println("NNNNNNNNNNNNNNNNN");
	    out.println("&nbsp;&nbsp;&nbsp;&nbsp;你的批改申请已经通过系统自动核保,批单号："+Result[1][c_edr_no]+".");%>
		<br>请点击进入<input type="submit" name="submit1" value="保单打印" onClick="ChangeAction(this.form)">
		  		  <select name="language" size="1">
        <option value="CHN" selected>中</option>
		<option value="ENG">英</option>
     </select>
	<% }
     
	 
	}

 
%>
<input type="hidden" name="insuranceID" value="<%=insuranceID%>">
</form>
 </table>
    
       
						</div>
   
      
					</td>
				  </tr>
				</table>


				 </td>
				  </tr>
				</table>
<%@ include file="public/PublicBottom.html" %>      

</body>
</html>
<script language=JavaScript>
function ChangeAction(theForm){  
  /*if(theForm.insuranceID.value=="<%=Const.C_IMPORT_CDE%>"){
    theForm.action = "ImportPolicyView.jsp";
  }else if (theForm.insuranceID.value=="<%=Const.C_EXPORT_CDE%>"){
    theForm.action ="ExportPolicyView.jsp";
  }else{
    theForm.action ="LocalPolicyView.jsp;"
  }*/
}
</script>
