<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/> 

<%  //errorPage="ErrOut.jsp"
	int i=0;
   boolean IsAccept = false;
   String optype=null;
   String[] formpara=new String[3];

	//=======  begin process	=============
	for(i=0;i<3;i++)
		formpara[i]="";
	optype=request.getParameter("submit");
	formpara[0]=request.getParameter("C_FUNC_CDE");
	try{
	if(optype.equals("修改功能"))
	{
		formpara[1]=request.getParameter("C_FUNC_CNM");
		formpara[2]=request.getParameter("C_FUNC_ENM");
		obj.setFormPara(ZConst.UPDATE_SYSFUNC,formpara);
	}
	if(optype.equals("增加功能"))
	{
		formpara[1]=request.getParameter("C_FUNC_CNM");
		formpara[2]=request.getParameter("C_FUNC_ENM");
		obj.setFormPara(ZConst.ACCEPT_SYSFUNC,formpara);
	}
	if(optype.equals("删除功能"))
	{
		obj.setFormPara(ZConst.DELETE_SYSFUNC,formpara);
	}
	}catch(Exception e){
		out.println(e);
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
<a href="Add_Func.jsp"> _返回_ </a></p>	</font>	

<%@ include file="public/bottom.jsp" %>
