<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/> 
<% 
	int i=0;
   boolean IsAccept = false;
   String optype=null;
   String formpara[]=new String[5];

	//=======  begin process	=============
	for(i=0;i<5;i++)
		formpara[i]="";
	optype=request.getParameter("subm");
	formpara[0]=request.getParameter("C_PAGE_NO");
	if(optype.indexOf("modify") != -1)
	{
		formpara[1]=request.getParameter("C_PAGE_TITLE");
		formpara[2]=request.getParameter("C_FILE_ENM");
		formpara[3]=request.getParameter("C_FUNC_CDE");
		obj.setFormPara(ZConst.UPDATE_PAGESINFO,formpara);
	}
	if(optype.indexOf("add") != -1)
	{
		formpara[1]=request.getParameter("C_PAGE_TITLE");
		formpara[2]=request.getParameter("C_FILE_ENM");
		formpara[3]=request.getParameter("C_FUNC_CDE");
		obj.setFormPara(ZConst.ACCEPT_PAGESINFO,formpara);
	}
	if(optype.indexOf("delete") != -1)
	{
		obj.setFormPara(ZConst.DELETE_PAGESINFO,formpara);
	}

    IsAccept = obj.getRetValueBool();
    if(IsAccept)  
    { %>
       <p> 操 作 成 功   </p>
    <% }
    else
    {   %>
       <p> 操作失败    </p>
	 <%  }   %>


<p></p>
<p></p>
<font face="宋体" size="4"><p align="center">
<a href="Pages_List.jsp"> _返回_ </a></p>	</font>	
<%@ include file="public/bottom.jsp" %>



