<html>
<head>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<body>

<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<%
System.out.println("now you are in ProcessLogin.jsp");   
%>

<jsp:useBean id="cb"  scope="page" class="beans.CustManagerBean"/> 
<jsp:setProperty name="cb" property="*"/>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>


<%
        if (!Init.isInit())
        {
            throw NormalExceptionHandler.Handle(Const.SYS_NOT_INIT_CDE,Const.SYS_NOT_INIT);
        }
%>
<%  //for get login para and to bean
    String[] FormPara = new String[2];
    String Result[][] = null;
    String sessionId = "";
    String RemoteOperType = "";
    FormPara[0] = request.getParameter("USER");
    FormPara[1] = request.getParameter("PSWD");
    String MenuRefStr = request.getParameter("MENU_REF");
    System.out.println("Login Process user:"+FormPara[0]);




    HttpSession https = request.getSession(true);
    String sessionIdNew = https.getId();
    

    System.out.println("Login Process sessionIdNew:"+sessionIdNew);
    try
    {
       System.out.println("Start Login YYYYYYY");
        cb.setFormPara(Const.CUSTOMER_LOGIN,FormPara);
        Result = cb.getRetValueArra();
        if(Result==null)System.out.println("SSSSSSSS");
        System.out.println("CORBA LOGIN OK:");
        sessionId = cb.ProcessLogin(Result,FormPara[0],sessionIdNew);
        RemoteOperType = ob.getRemoteOperType();
    }
    catch(NormalException e)
    {
         throw NormalExceptionHandler.Handle(e);
    }catch(Throwable eb){
      eb.printStackTrace();
    }

System.out.println("Login Process complete OK:");

//test begin
for(int i=0;i<Result[0].length;i++)
	System.out.println("Login corba return data:"+Result[1][i]);  
//test end    

System.out.println("processLogin.jsp    MenuRefStr:"+MenuRefStr);
%>

<%
	/*added by kangjin for auto login process2001-4-5*/
	String autoLogin = request.getParameter("autoLogin");
	if (autoLogin != null && autoLogin.equals("true")){%>
		<jsp:forward page="AcceptOrgnCustOut.jsp"/>
<%}
	/* end of added by kangjin for auto login process2001-4-5*/
  //check remoteopertype
    if(RemoteOperType.equals(Const.REMOTE_PLY))//policyapp
    {
%>
<jsp:forward page="OperationSelect.jsp"/>
<%    
    }
    else if(RemoteOperType.equals(Const.REMOTE_PRP))//proposal
    {
%>
   <jsp:forward page="ProposalFind.jsp"/>
    <%    
    }  
    else if(!(MenuRefStr == null || MenuRefStr.equals("")))
    {
      request.setAttribute("MENU_REF",MenuRefStr);
      String[] MenuRef = MenuMake.MenuRef;
      String UrlSucc[] = MenuMake.UrlSucc;
      int i = 0;
      for(i=0;i<MenuRef.length;i++)
      {
         if(MenuRefStr.equals(MenuRef[i]))
            break;
      }
        System.out.println("forware to login succUrlSucc[i]:"+UrlSucc[i]);

        //Added by Clarkrao 12-07-2000

        SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();    ;
	      int Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionIdNew);
        String clientVerifyFlag = sessionbuffer.getClientVerifyFlag(Locate);
	      String flag = "0";
	      String flag1 = "9";
	      if((clientVerifyFlag.equals(flag) || clientVerifyFlag.equals(flag1)) &
	       (MenuRefStr.equals("MENU_INSURANCE") || MenuRefStr.equals("MENU_REPORT")
	       || MenuRefStr.equals("MENU_INQUIRE")))
	       {
                 throw NormalExceptionHandler.Handle(Const.SYS_USER_ERR_CDE,Const.SYS_USER_ERR);
         }

        //end added  by Clarkrao

      %>
      <jsp:forward page="<%=UrlSucc[i]%>"/>
      <%
    }
    else
    {
	      SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();    ;
	      int Locate = sessionbuffer.ProcessSession(Const.SESSAUTH,sessionIdNew);
	      String ClientType = sessionbuffer.getClientType(Locate);
       	if(ClientType.equals(Const.CUST_AG))
	      {
         %>
          <jsp:forward page="OperationSelect.jsp"/>
        <%

	     }
	     else
	  {
%>
  <jsp:forward page="LoginSucc.jsp"/>
<%
  //<jsp:forward page="LoginSucc.jsp"/>
        }
    }    
%>
</body>
</html>


