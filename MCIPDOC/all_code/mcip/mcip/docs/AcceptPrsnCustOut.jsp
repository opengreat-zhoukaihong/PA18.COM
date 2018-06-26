<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" href="style.css">

<title>个人客户资料录入</title>
<base target="main">
</head>
<body>

<%@ include file="public/PublicCust.jsp" %>      
<jsp:useBean id="cb"  scope="request" class="beans.CustManagerBean"/> 
<jsp:setProperty name="cb" property="*"/>

<%  //for get login para and to bean
    String CustPrsn[] = null;
    String CustEntity[] = null;
    boolean IsAccept = false;

    Servlets servlets = new Servlets();
    
    servlets.EntityServlet(request);
    CustEntity = servlets.getDelivery();
    
    servlets.PrsnCustServlet(request);
    CustPrsn = servlets.getDelivery();


/*    for(int i=0;i<CustEntity.length;i++)
    {
         System.out.println("CustEntity:"+CustEntity[i]);
    }
*/
    for(int i=0;i<Const.CUSTPRSN_LEN;i++)
    {
         System.out.println("CustPrsn:"+i+"&&&"+CustPrsn[i]+"  "+Const.CUSTPRSN_LEN);
    }
    
    //C_IMPT_CLNT_CDE
    try
    {
        //Is to be check custorgn fields
        cb.setFormParaPre(Const.ACCEPT_PRSNCUST,CustEntity);        
        cb.setFormPara(Const.ACCEPT_PRSNCUST,CustPrsn);
    }
    catch(NormalException e)
    {
 	if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
 	else if(NormalExceptionHandler.IsWarning(e))    
 	    WarnMsg = e.getErrDesc(); 
 	    
    }

    IsAccept = cb.getRetValueBool();
    String errText= new String("you failure");
    if(IsAccept)
    {
%>

<jsp:forward page="RegisterSucc.jsp"/> 

<--- 个人客户资料录入提交成功 --->
<h2>个人客户资料录入提交成功，请等待平安公司批核结果</h2>
<%    
    
//    out.println("<h2>个人客户资料录入提交成功，请等待平安公司批核结果</h2>");
    }   
    else
    {
%>
<---个人客户资料录入提交失败--->
<h2>个人客户资料录入提交失败，请与平安公司联系</h2>
<%    
//        throw new ServletException("<h2>个人客户资料录入提交失败，请与平安公司联系</h2>");          
     }   

%>
</body>
</html>
