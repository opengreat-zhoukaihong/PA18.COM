<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_user"  scope="page" class="beans.Zuserbean"/> 
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>

<% 
	int i=0;
	String formpara[] = obj_data.getdata();
	boolean IsAccept = false;

    try
    {
        obj_user.setFormPara(ZConst.DELETE_CLNTMAPINFO,formpara);
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
    IsAccept = obj_user.getRetValueBool();
    if(IsAccept)  
    { %>
       <p> 操作成功   </p>
 <% }
    else {  %>
       <p> 操作失败 !   </p>
    <%   }    %>


  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.go(-3);'>  

<%@ include file="public/bottom.jsp" %>
