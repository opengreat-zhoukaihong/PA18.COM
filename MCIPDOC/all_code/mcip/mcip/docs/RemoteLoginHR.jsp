<%@ page language="java" import="java.beans.Beans,java.lang.*,java.io.*,java.util.*,exceptions.*,constant.*,utility.*,beans.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="cb"  scope="page" class="beans.CustManagerBean"/> 
<jsp:setProperty name="cb" property="*"/>
<jsp:useBean id="ob"  scope="session" class="beans.OperationBean"/> 
<jsp:setProperty name="ob" property="*"/>
<% 
      session.setMaxInactiveInterval(Const.TIMEOUT/1000);
%>
<%
        if (!Init.isInit())
        {
	       boolean isOk = false;
	       isOk = Init.initAll();
	       if(!isOk)
	            throw NormalExceptionHandler.Handle(ExceptionCode.SYS_INIT_FAILURE);       
        }

/*        SessionBuffer sessionbuffer = SessionBuffer.getSessionBuffer();
       if(sessionbuffer.getTotalSes() >= SessionBuffer.getMaxUsers()))
        {
        }
*/
%>
<%  //for get login para and to bean
    String[] RemotePara = null;
    String Result[][] = null;
    String RemoteOperType = request.getParameter(Const.REMOTE_OPERTYPE);
//    String UserName = request.getParameter(Const.REMOTE_USERNAME);    
    if(RemoteOperType == null)
         RemoteOperType = "";
System.out.println("Parameter:"+Const.REMOTE_OPERTYPE+":RemoteOperType:"+RemoteOperType);
    if(RemoteOperType.equals(Const.REMOTE_PLY))//policyapp
    {
       RemotePara = Const.REMOTE_PLY_PARA_HR;
    }
    else if(RemoteOperType.equals(Const.REMOTE_PRP))//proposal
    {
       RemotePara = Const.REMOTE_PRP_PARA_HR;    
    }
    else
    {
       throw new NormalException("Transaction type is error");
    }  
    
    try
    {
        Result = cb.ProcessRemotePara(request,RemotePara);
        //is to be check para valid
        ob.setRemoteData(Result);
        ob.setRemoteOperType(RemoteOperType);
    }
    catch(NormalException e)
    {
         throw NormalExceptionHandler.Handle(e);
    }
//    request.setAttribute(Const.REMOTE_USERNAME,UserName);
    request.setAttribute("REMOTE","1");
%>
<jsp:forward page="Login.jsp"/>
