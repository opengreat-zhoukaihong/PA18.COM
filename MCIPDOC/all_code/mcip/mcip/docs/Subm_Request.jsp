<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>

<jsp:useBean id="cb"  scope="page" class="beans.CustManagerBean"/>

<%  //for get login para and to bean
    String cust[] = new String[Const.CUSTENTITY_LEN];
    String conpass=null;
    String oldpw=null;
    boolean IsAccept = false;
    boolean Isright = true;
    int i = 0;

    for(i = 0; i < Const.CUSTENTITY_LEN; i++)
         cust[i] = "";
    i = 1;

    oldpw=request.getParameter("C_oldpw");
    conpass=request.getParameter("ConfirmPassword");
    cust[0] = request.getParameter("userid");
    cust[1] = cust[0];
    cust[2] = request.getParameter("C_newpw");
    cust[3] = "";
    cust[4] = "";
//    cust[3] = request.getParameter("C_PW_QUESTION");
//    cust[4] = request.getParameter("C_PW_RESULT");
	i=cust[2].length();
%>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicMemLeft.jsp" %>
    <td width="613" height="288" valign="top"> <br>
      <img src="images/xgmm.gif" width="150" height="31" alt="修改密码">

		<table border="0" width="489"  align="center" height="117">
		 <tr>
			<td  height=20>
 <%
     String[] FormPara = new String[2];
    String Result[][] = null;

    FormPara[0] = request.getParameter("userid");
    FormPara[1] = request.getParameter("C_oldpw");
    try
    {

        cb.setFormPara(Const.CUSTOMER_LOGIN,FormPara);
        Result = cb.getRetValueArra();
    }
    catch(NormalException e)
    {
        // throw NormalExceptionHandler.Handle(e);
        out.println("旧密码不符!");
	 	    Isright = false;
    }catch(Throwable eb){
      eb.printStackTrace();
    }


	/* if(!(oldpw.equals(request.getParameter("oldpw"))))
	 {
	 	out.println("旧密码不符!");
	 	Isright = false;
	 }*/
    if( Isright)
    {
      try
      {
        cb.setFormPara(Const.UPDATE_ENTTCUST,cust);
			IsAccept = cb.getRetValueBool();
      }
      catch(NormalException e)
      {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
      }

    }

    if(IsAccept)
    {  %>
		<font color="#FF0000">重设密码已成功!</font>
    <% }
    else {   %>
      <font color="#FF0000">提交没有成功!</font>
    <% } %>

			</td>
		 </tr> 
		</table>

	</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   

</body>
</html>


