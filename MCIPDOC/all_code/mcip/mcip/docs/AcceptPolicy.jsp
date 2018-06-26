

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
<jsp:useBean id="pmb"  scope="session" class="beans.PolicyManagerBean"/> 
<jsp:setProperty name="pmb" property="*"/>

<% 
    String ClientType = sessionbuffer.getClientType(Locate);
    if(ClientType.equals(Const.CUST_CM)){
	  pmb.plyEdrAppInfo.c_udr_mrk = "B";
	}else if(ClientType.equals(Const.CUST_OC)){
	  if(pmb.plyEdrAppInfo.c_open_cover_no.length()>0){
	     pmb.plyEdrAppInfo.c_udr_mrk = "A";  
       }else{
	     pmb.plyEdrAppInfo.c_udr_mrk = "B";  
	   }
	 }else if(ClientType.equals(Const.CUST_AG)){
	    pmb.plyEdrAppInfo.c_udr_mrk = "A";  
     } 
    
  
   
    String[][] Result;
    try
    {
	     System.out.println("YES .... send A-----AcceptPolicy.jsp");
         pmb.setFormPara(1,null);
         Result = pmb.getRetValueArra();
    }
    catch(NormalException e)
    {
 	    //if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
	
	if(Result!=null){
	 for(int p=0; p< Result[0].length;p++)
	   System.out.println(Result[0][p]+" ---AcceptPolicy :"+Result[1][p]); 
	  ob.setTempTwo(Result);%>
	  <jsp:forward page="PlyEdrApp.jsp"/>
	<%}

 
%>
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
