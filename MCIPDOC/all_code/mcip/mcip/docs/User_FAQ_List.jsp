<%
/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 16:46:18
*Modify id : 0001
*Modifier : WuYan
*Reason : I.Modify Html Style(format、Color 、table) of page 
*		II. process logic of code
***********************************************************************************************
*/

/*
*============================MODIFIED HISTORY==================================================
*Date : 2000-11-02
*Time : 16:32:50
*Modify id : 0002
*Modifier : WuYan
*Reason : I.Modify Html Style 
***********************************************************************************************
*/

%>

<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=table.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">
<%@ include file="public/NoLoginPublic.html" %>

<%@ page language="java" import="java.lang.*,java.util.*,beans.*,exceptions.*,constant.*,utility.*" errorPage="ErrOut.jsp" contentType= "text/html; charset=gb2312"%>

<jsp:useBean id="obj"  scope="page" class="beans.Zbussbean"/>
<%
	String username=null;
//	String username = request.getParameter("username");
//	String Sessionid = request.getParameter("sessionid");
//	String username = sessionbuffer.getuserId(Locate); 
	if(username==null)username="Guest";	//for debug
	String[] formpara=new String[2];
	String[][] info=null;
	try
	{
		formpara[0]="";
		formpara[1]=username;
		obj.setFormPara(ZConst.QUERY_CONSULTLIST,formpara);
		info=obj.getRetValueArra();
	}
   catch(NormalException e)
   {
		out.println("for debug:NormalException err ocur in jsp");
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  // end try

	int i=0;
//debug

	if(info!=null)
	{
//		out.println("debug:infolen="+info.length);
//		out.println("faqno="+Objects.getValue(1,"c_faq_no",info));
//		out.println("topicno="+Objects.getColNum("c_topic_no",info));
//		out.println("[0[0]="+info[0][0]);
//		out.println("topicno6="+info[0][6]);
//		info[6][6]="new topic";
	}else
	{
		out.println("debug:info null");
	}

//enddebug
%>


<table border="0" cellpadding="0" cellspacing="0" width="100%">
   <tr>
	<%@ include file="public/PublicConsultLeft.html" %> 
	<td valign="top"> 
	  <p>
       <img src="images/consul_1.gif" width="150" height="31" alt="险种咨询">
	  </p>
	  <table border="0" cellpadding="0" cellspacing="0" width="90%">
	    <tr>
		  <td align="right">
	        <font color="#EFB281">■</font>
			  <font color="#0000ff">
				  <a href="Input_FAQ.jsp?username=<%=username%>">
				    我有疑问
			      </a>
				  
				  
                  
				 
		 	  </font>
  		  </td>
		</tr>
	  </table>	  
	  <BR>

<%
//errorPage="ErrOut.jsp"
	if(info!=null)
	{
		int j=0;
		String[][] info2=null;
//		String[][] data=new String [info.length][];
		for(i=1;i<info.length;i++)
		{
			info2 = null;
			try
			{
//				formpara[0]=Objects.getValue(i,"c_topic_no",info);
				formpara[0]=Objects.getValue(i,"c_faq_no",info);
				formpara[1]=username;
				obj.setFormPara(ZConst.QUERY_CONSULTLIST,formpara);
				info2=obj.getRetValueArra();
			}
			catch(NormalException e)
			{			
//				out.println("for debug:NormalException err ocur in jsp");
				if(NormalExceptionHandler.IsSevere(e))
 					throw NormalExceptionHandler.Handle(e);
			}  // end try
%>
			     <table width="90%" border="0" cellspacing="0">
			       <tr bgcolor="#7CA3E9" >
				  <td align="left" height="20">
				    <font color="#FFFFFF">
				      <%=Objects.getValue(i,"c_faq_title",info)%>
				    </font>
				  </td>
			       </tr>

<%				
			
//			out.println("debug:topicno="+Objects.getValue(i,"c_faq_no",info));
		  if(info2!=null)
		  {
			for(j=1;j<6;j++)
			{
%>
				<tr bgcolor="#F6F6F6"> 
				  <td align="left" height="20">
<%				if (j < info2.length) 
				  {
%>
				    &nbsp; <font color="#EFB281">◆</font>&nbsp;
				    <a href="Zfaqdetail.jsp?username=<%=username%>&no=<%=Objects.getValue(j,"c_faq_no",info2)%>"> 
				       <%=Objects.getValue(j,"c_faq_title",info2)%>
<%				  }
				     else
				      out.println("&nbsp;");
%>
				    </a>
				  </td>
				</tr>
<%
			}	// end for j
			if(info2.length > 5)
			{
%>
			<tr bgcolor="#F9F9FF"> 
			  <td align="right" bgcolor="#F6F6F6"> 
			     <i>
			       <font color="#CC3333">
			        <a href="Zfaqmore.jsp?username=<%=username%>&begin=<%=formpara[0]%>">
				  <B>更多...</B>
				</a>
			       </font>
			     </i>
			   </td>
			</tr>
<%
			}//endif info2.length > 5
%>
		     </table><BR>
<%
//			out.println("<p>&nbsp;</p>");
	    } //end info2!=null
	  } //end for i
	}	//end info!=null
%>
	 </td>
	</tr>
</table>
<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
