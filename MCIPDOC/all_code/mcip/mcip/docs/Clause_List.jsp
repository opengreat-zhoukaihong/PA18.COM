<%
/*
*****************************GENERAL INFORMATION***********************************************
*Program ID : Clause_List.jsp
*Directory : /data1/pa18/nul/mcip/public_html/docs/
*URL : http://10.16.102.1:8800/Clause_List.jsp
*Previous Page : consult_List.jsp
*Next Page : ZView_Clause.jsp
*Author : Zhu Ling Xiang
*Created Date : 2000-10-26
*Last Updated : 
*Status : 
*Function : I.list all the title of the Clause
*			II.provide the link to the next pages
*============================MODIFIED HISTORY==================================================
*Date : 2000-10-28
*Time : 14:16:18
*Modify id : 0001
*Modifier : WuYan
*Reason : I.Modify Html Style of Clause list 
*		II. process logic of code
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
<jsp:useBean id="obj"  scope="page" class="beans.ZPolicyInfoBean"/>

<%
	//String username = request.getParameter("username");
	String username = "Guest";
	if(username==null)username = "1";
	String[] formpara=new String[3];
	String[][] info_1=null;
	try
	{
		formpara[0]="";
		formpara[1]="";
		formpara[2]=username;
		obj.setFormPara(ZConst.GET_CLAUSELIST,formpara);
		info_1=obj.getRetValueArra();
	}
   catch(NormalException e)
   {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
   }  // end try

	int i=0;
//debug
//	if(info_1!=null)out.println("infolen="+info_1.length);


%>

	<table border="0" cellpadding="0" cellspacing="0" width="100%">
	  <tr>
	     <%@ include file="public/PublicConsultLeft.html" %> 
	     <td  valign="top">
     	       <p>
                 <img src="images/con_art.gif" width="150" height="31" alt="保险条款">
	       </p>
		请点击选择你要查看<B>主险</B>条款的项目：<br>
		<table border="0"  width="95%" cellpadding="4">
	           <tr>
		     <td>
			<script language="javascript1.2" src="art_open.js"></script>
			<!--p>
			 　<font color="#EFB281">■</font>
			   <a href="ZView_Clause.jsp?path=dom_air_cargo.txt" onclick="return js_openpage(this.href);">
			      国内航空货物运输保险条款
			   </a>
			</p-->
			<p>
			 　<font color="#EFB281">■</font>
			   <a href="ZView_Clause.jsp?path=dom_water_land_cargo.txt" onclick="return js_openpage(this.href);">
			      国内水路、陆路货物运输保险条款
			   </a>
			</p>
			<p>
			  　<font color="#EFB281">■</font>
			    <a href="ZView_Clause.jsp?path=sea_cargo.txt" onclick="return js_openpage(this.href);">
			      海洋运输货物保险条款
			    </a>
			</p>
			<p>
			  　<font color="#EFB281">■</font>
			    <a href="ZView_Clause.jsp?path=air_cargo.txt" onclick="return js_openpage(this.href);">
			      航空货物运输保险条款
			    </a>
			</p>
			<p>
			  　<font color="#EFB281">■</font>
			    <a href="ZView_Clause.jsp?path=land_cargo.txt" onclick="return js_openpage(this.href);">
			      陆上货物运输保险条款（火车、汽车）
			    </a>
			 </p>
			</td>
		      </tr>
		</table> <br>
		请点击选择你要查看<B>附加险</B>条款的项目：<br>
		<table width="95%" border="0" cellpadding="4">
		  <tr><td bgcolor="#6633CC" colspan="3"></td></tr>
		  <tr>
		    <td height="30" width="25%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr18.html" onclick="return js_openpage(this.href);">
   		        罢工险条款
		      </a>
  		    </td>
		    <td height="30" width="35%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr20.html" onclick="return js_openpage(this.href);">
   		        战争险条款
		      </a>
		    </td>
		    <td height="30" width="40%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr24.html" onclick="return js_openclause(this.href);">
   		        碰损、破碎险条款
		      </a>
		    </td>
		  </tr>
		  <tr>
		    <td height="30" width="25%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr25.html" onclick="return js_openclause(this.href);">
	   	        渗漏险条款
		      </a>
		    </td>
		    <td height="30" width="35%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr33.html" onclick="return js_openclause(this.href);">
   		        钩损险条款
		      </a>
		    </td>
		    <td height="30" width="40%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr29.html" onclick="return js_openclause(this.href);">
   		        淡水、雨淋险条款
		      </a>
		    </td>
		  </tr>
		  <tr>
		    <td height="30" width="25%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr31.html" onclick="return js_openclause(this.href);">
			串味险条款
		      </a>
		    </td>
		    <td height="30" width="35%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr34.html" onclick="return js_openclause(this.href);">
	   	        锈损险条款
		      </a>
		    </td>
		    <td height="30" width="40%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr32.html" onclick="return js_openclause(this.href);">
   		        受潮、受热险条款
		      </a>
		    </td>
		  </tr>
		  <tr>
		    <td height="30" width="25%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr27.html" onclick="return js_openclause(this.href);">
   		        短量险条款
		      </a>
		    </td>
		    <td height="30" width="35%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr28.html" onclick="return js_openclause(this.href);">
   		        包装破裂险条款
		      </a>
		    </td>
		    <td height="30" width="40%">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr30.html" onclick="return js_openclause(this.href);">
   		        混杂、沾污险条款
		      </a>
		    </td>
		  </tr>
		  <tr>
		    <td height="30" colspan="3">
		      <font color="#EFB281">■</font>
		      <a href="clause/rdr23.html" onclick="return js_openclause(this.href);">
   		        偷窃、提货不着险条款
		      </a>
		    </td>
		  </tr>
		</table><br>
		请点击选择你要查看<B>英文协会货物运输</B>条款的项目：<br>
		<table width="95%" border="0" cellpadding="0">
			  <tr><td bgcolor="#6633CC" colspan="3"></td></tr>
			  <tr>
				<td height="30" align="left">
					<font color="#EFB281">■</font>
				   <a href="ZView_Clause.jsp?path=ICC-A.txt" onclick="return js_openpage(this.href);">INSTITUTE CARGO CLAUSES (A)</a>
				</td>
				<td height="30" align="left">
					<font color="#EFB281">■</font>
				   <a href="ZView_Clause.jsp?path=ICC-B.txt" onclick="return js_openpage(this.href);">INSTITUTE CARGO CLAUSES (B)</a>
				</td>
				<td height="30" align="left">
					<font color="#EFB281">■</font>
				   <a href="ZView_Clause.jsp?path=ICC-C.txt" onclick="return js_openpage(this.href);">INSTITUTE CARGO CLAUSES (C)</a>
				</td>
			  </tr>
		 </table>   
	    </td>
	  </tr>
 </table>   

<%@ include file="public/PublicBottom.html" %> 
</body>
</html>
