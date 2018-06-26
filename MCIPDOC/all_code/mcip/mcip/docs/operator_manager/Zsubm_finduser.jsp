<html>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>会 员 审 批</title>
<link rel="stylesheet" href="../style/style.css">
<link rel="stylesheet" href="../TableStyle_font_Small.css">
</head>

<body>

<div align="right">

<address style="border-bottom: 1px dotted">
  平安保险
</address>
</div>

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>
<jsp:useBean id="obj_user"  scope="session" class="beans.Zuserbean"/>
<jsp:useBean id="obj_data"  scope="session" class="beans.Zdatabean"/>
<% String sessionId=obj_data.getinfo2(); %>
<%@ include file="public_session.jsp" %>

<% 

	String info[][]=null;
	String formpara[]=new String[10];
	String from_time1="";
	String to_time1="";
	String from_time2="";
	String to_time2="";
	String choice0=null;
	String choice1=null;
	int i=0;

//  begin process

	for(i=0;i<10;i++)
		formpara[i]="";
	formpara[0]=request.getParameter("opr_cde");
	choice0=request.getParameter("checkuser0");
	choice1=request.getParameter("checkuser1");
	if(choice0!=null && choice1!=null)
	{
		formpara[1]="2";
	}else
	{
		if(choice0!=null)formpara[1]="0";
		if(choice1!=null)formpara[1]="1";
	}
	String[] formparaPre=null;
	if(request.getParameter("checkorgn")!=null)
	{
		formparaPre=request.getParameterValues("checkorgn");
	}else
	{
		formparaPre=obj_data.getdata();
	}
	if(request.getParameter("checkdate1")!=null)
	{
		from_time1=request.getParameter("from_year1")+"-"+request.getParameter("from_month1")+"-"+request.getParameter("from_day1");
		to_time1=request.getParameter("to_year1")+"-"+request.getParameter("to_month1")+"-"+request.getParameter("to_day1");
		formpara[3]=from_time1;
		formpara[4]=to_time1;
	}
	if(request.getParameter("checkdate2")!=null)
	{
		from_time2=request.getParameter("from_year2")+"-"+request.getParameter("from_month2")+"-"+request.getParameter("from_day2");
		to_time2=request.getParameter("to_year2")+"-"+request.getParameter("to_month2")+"-"+request.getParameter("to_day2");
		formpara[5]=from_time2;
		formpara[6]=to_time2;
	}
	if(request.getParameter("checkno")!=null)
	{
		formpara[7]=request.getParameter("lognum1");
		formpara[8]=request.getParameter("lognum2");
	}
	if(request.getParameter("checkname")!=null)
	{
		formpara[9]=(request.getParameter("username") ).trim();
	}

//	for(i=0;i<10;i++)
//		out.println("parapre="+formparaPre[0]);
	try
	{
		obj_user.setFormParaPre(ZConst.QUERY_CUSTENTTLIST,formparaPre);
		obj_user.setFormPara(ZConst.QUERY_CUSTENTTLIST,formpara);
		info=obj_user.getRetValueArra();
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   } 
//   catch(Exception e)
//   {
//		out.println("Non-NormalException occur:"+e);
//		throw NormalException("Non-NormalException occur:"+e);
//		if(NormalExceptionHandler.IsSevere(e))
// 	    throw NormalExceptionHandler.Handle(e);
//   }  	// end try

 if(info==null)
 {
	out.println("<p>&nbsp;</p>");
	out.println("<p>&nbsp;</p>");
	out.println("没有找到查询的记录！");
 }else
 {
	if(choice0!=null)
	{   %>
		<jsp:forward page="Verify_Userlist.jsp" />  
<%	} else
	{	%>
		<jsp:forward page="editUserinfolist.jsp" />  
<%	}
  }// end if info==null
%>

<p>&nbsp;</p>
<p>&nbsp;</p>
<font face="宋体" size="4"><p align="center">
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <input align="center" type="button" value="返  回" name="B44" onclick='javascript:history.back();'>  
</html>
