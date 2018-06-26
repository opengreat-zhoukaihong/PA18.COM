<html>

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>

<%
	String[][] info=null;
		int i=Integer.parseInt(request.getParameter("radio"));

		info=obj_user.getRetValueArra();
	if(info==null)out.println("null!");

	String userid=Objects.getValue(i,"C_CLNT_CDE",info);
	/*add r20010924-9{*/
	String loginid = Objects.getValue(i,"C_USER_ID",info);
	request.setAttribute("loginid",loginid);
	/*}add r20010924-9*/
	String clientflag=(Objects.getValue(i,"C_CLNT_MRK",info)).trim();
	request.setAttribute("userid",userid);

 if (clientflag!=null)
 {
//	clientflag=clientflag.trim();
   if (clientflag.equals("1") )
	{	%>
		<jsp:forward page="edit_prsn_rear.jsp" />   
<%	}
   if ( clientflag.equals("0"))
   {	%>
		<jsp:forward page="edit_orgn_rear.jsp" />   
<% }
 }
 else
 {
	out.println("uesrmark null");
 }


 
%>

</html>

   