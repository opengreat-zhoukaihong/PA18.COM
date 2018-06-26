<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>
<jsp:useBean id="obj"  scope="page" class="beans.Zuserbean"/> 
<% 
	int i=0;
   boolean IsAccept = false;
   String formpara[]=new String[6];

	//=======  begin process	=============
	for(i=0;i<5;i++)
		formpara[i]="";
	formpara[0]=request.getParameter("emp_cde");
	formpara[1]=request.getParameter("emp_nme");
	formpara[2]=request.getParameter("dpt_cde");
	formpara[4]=request.getParameter("emp_email");
	formpara[5]=request.getParameter("supp_no");
	
	String s1=request.getParameter("check1");
	String s2=request.getParameter("check2");
	String s3=request.getParameter("check3");
	String s4=request.getParameter("check4");
	if(s1==null)s1="0";
	if(s2==null)s2="0";
	if(s3==null)s3="0";
	if(s4==null)s4="0";
	formpara[3]=s1+s2+s3+s4+"000000";
	
	obj.setFormPara(ZConst.UPDATE_SUPPEMAIL,formpara);

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
<%@ include file="public/bottom.jsp" %>



