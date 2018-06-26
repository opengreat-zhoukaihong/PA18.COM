<%@ include file="public/up.jsp" %>
<%@ include file="public/left.jsp" %>

<jsp:useBean id="obj_user"  scope="page" class="beans.Zuserbean"/> 
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>

<% 
	int i=0;
	String info[] = new String[6];
	String radio;
	boolean IsAccept = false;
	String Para[]={"C_USER_ID","C_CLNT_CDE","C_CMPNY_AGT_CDE","C_VERIFY","C_VERIFY_DESC"};

	//begin process

	for(i=0;i<Para.length;i++)
	{
		info[i]=request.getParameter(Para[i]);
		if(info[i]!=null) info[i] = info[i].trim();
	}
	
	radio=request.getParameter("radio2");
	if(radio.equals("y"))
	{
		info[3]=request.getParameter("radio1");
	} else
	{
		info[3]=radio;//change "9" to radio on 11/30 2000
 	}
	for(i=0;i<5;i++)
	{
		if(info[i]==null)info[i]="";
	}
	info[5]=obj_data.getinfo1();//get opr_cde

    try
    {
        obj_user.setFormPara(ZConst.ACCEPT_USERVERIFY,info);
			IsAccept = obj_user.getRetValueBool();
    }
    catch(NormalException e)
    {
 		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
    }
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
