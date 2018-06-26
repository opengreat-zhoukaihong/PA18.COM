
<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp"%>
<jsp:useBean id="cb"  scope="session" class="beans.UserManagerBean"/>
<SCRIPT LANGUAGE="JavaScript" SRC="check.js"></SCRIPT>
<jsp:setProperty name="cb" property="*"/>

<%  //for get login para and to bean

    SessionUser mySession = sessionuser;
   
    String fromOprCde = request.getParameter("FromOprCde");
    String toOprCde =  request.getParameter("ToOprCde");

      String operInfos[] = new String[2];
      operInfos[0] = fromOprCde;
      operInfos[1] = toOprCde; 
      boolean IsAccept = false;
     try
     {

        cb.setFormPara(ZConst.REPPLACEAUTHOPTR,operInfos);
        IsAccept = cb.getRetValueBool();
     }
     catch(NormalException e)
     {

 	    throw NormalExceptionHandler.Handle(e);
    }


    
    if(IsAccept)
    {
%>
<font color="#0066CC"><span class="unnamed3">授权转移成功</span></font>
<%
    }
    else
    {
%>
<font color="#0066CC">授权转移失败</span></font>
<%
     }

%>
<form >
<input type=button value="返回" onClick="javascript:window.history.back()">
</form>
<%@ include file="public/bottom.jsp"%>
