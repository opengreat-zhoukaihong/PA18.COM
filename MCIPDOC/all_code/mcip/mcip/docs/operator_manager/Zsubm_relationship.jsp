<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_user"  scope="page" class="beans.Zuserbean"/> 

<% 
	int i=0;
	String formpara[] = new String[5];
	boolean IsAccept = false;
	String Para[]={"opr_cde","clnt_agt_flg","userid","clntcde"};

	//begin process
	for(i=0;i<Para.length;i++)
	{
		formpara[i]=request.getParameter(Para[i]);
	}
	if(formpara[4]==null)formpara[4]="0";
	
	for(i=0;i<5;i++)
	{
		if(formpara[i]==null)out.println("have null ! "+i);
	}

    try
    {
        obj_user.setFormPara(ZConst.ACCEPT_CLNTMAPINFO,formpara);
	    IsAccept = obj_user.getRetValueBool();
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
	catch(Exception e)
	{
//		out.println("debug:err excption occur when call :"+e);
	}	// end try
    if(IsAccept)  
    { %>
       <p> 操作成功   </p>
 <% }
    else {  %>
       <p> 操作失败 !   </p>
    <%   }    %>


  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.go(-2);'>  
<%@ include file="public/bottom.jsp" %>
