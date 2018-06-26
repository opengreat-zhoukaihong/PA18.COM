<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<%@ include file="public/Public.jsp" %>

<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicInquireLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/m_inq3.gif" width="150" height="31" alt="报案查询">

<jsp:useBean id="obj_policy"  scope="session" class="beans.ZPolicyInfoBean"/>
<% 
	int i=0;
	String userid=null;
	String CheckedField=null;
	String C_RPT_NO="";
	String from_tm="";
	String to_tm="";
	String info[][]=null;
	String[] formpara=new String[5];
//	String sessionid;
//	sessionid=request.getParameter("sessionid");
	
	
	//========== begin process  ============
	int pgno=1;
	String pgnostr=request.getParameter("pgno");
 if(pgnostr!=null)
 {
	pgno=Integer.parseInt(pgnostr);
	info=obj_policy.getRetValueArra();
 }else
 {
	for(i=0;i<4;i++)
		formpara[i]="";	
	formpara[0]=request.getParameter("userid");
	CheckedField = request.getParameter("checkno");       
   if(CheckedField != null)
   	formpara[1]=request.getParameter("C_RPT_NO");
	CheckedField = request.getParameter("checkdate");       
   if(CheckedField != null)
   {
		formpara[2]=request.getParameter("from_year")+"-"+
			request.getParameter("from_month")+"-"+request.getParameter("from_day");
		formpara[3]=request.getParameter("to_year")+"-"+
			request.getParameter("to_month")+"-"+request.getParameter("to_day");
	}
/*
	java.util.Date theDate = null;
   String dateFormat = "yyyy-MM-dd";// can add HH:mm:ss
   java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(dateFormat);
   theDate = formatter.parse(formpara[2]);
   formpara[2] = formatter.format(theDate);
   theDate = formatter.parse(formpara[3]);
   formpara[3] = formatter.format(theDate);
*/

   formpara[4] = sessionbuffer.getClientType(Locate);   
	
	// === call getCaseClmList =====
	try
	{
		obj_policy.setFormPara(ZConst.GET_CASERPTLIST,formpara); 
		info=obj_policy.getRetValueArra();

	}
  	catch(NormalException e)
 	{
 		if(NormalExceptionHandler.IsSevere(e))
     		throw NormalExceptionHandler.Handle(e);
  	}
 }

%>

    <table width="100%" border="1" cellspacing="1" cellpadding="0" bordercolor="#CCCCFF" bordercolorlight="#0099FF" bordercolordark="#FFFFFF">
      <tr bgcolor="#99FFFF" align="center"> 
           <td height="20" align="center" bgcolor="#C0C0C0" >
	      报案号 
				</td>
            <td height="20" align="center" bgcolor="#C0C0C0" >
	      报案时间
            </td>
            <td height="20" align="center" bgcolor="#C0C0C0" >
	      保单号
            </td>
            <td height="20" align="center" bgcolor="#C0C0C0">
	      被保险人
            </td>
            <td height="20" align="center" bgcolor="#C0C0C0">
	      报损金额
            </td>
            <td height="20" align="center" bgcolor="#C0C0C0">
	      标的
            </td>
          </tr>
		<%
			int pglen=7;
			int totalpg=0;
			int t1=0;
			int t2=0;
			if (info!=null)
			{
				totalpg=(info.length-1+pglen-1)/pglen;
				t1=(pgno-1)*pglen+1;
				t2=(pgno)*pglen+1;
				if(t2>info.length)t2=info.length;
				for(i=t1;i<t2;i++)
				{    %>
      <form name="form1" method="POST" action="view_rpt_info.jsp">
    		 <tr bgcolor="#FFFFFF">
      			<td width="13%" height="16"><a href="#Page" title="点击选择" onclick="selectNo(selectno,<%=i+t1-1%>);return true"><%=Objects.getValue(i,"C_RPT_NO",info)%></a>&nbsp;</td>
	     			<td width="13%" height="16"><%=Objects.getValue(i,"T_RTP_TM",info)%>&nbsp;</td>
       			<td width="13%" height="16"><%=Objects.getValue(i,"c_ply_no",info)%>&nbsp;</td>
      			<td width="23%" height="16"><%=Objects.getValue(i,"C_INSRNT_NME",info)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"N_RPT_AMT",info)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"C_CRGO_DESC",info)%>&nbsp;</td>
    			  </tr>
      	<%	}
			}else
		   {	%>
				<tr> 
				 <td valign="top" colspan="6" align="center"><font color=red>没有找到报案的记录！<font></td>
				</tr>
		<% } %>
          <tr> 
            <td valign="top" height="30" colspan="6"> 
              <div align="center"> 
	          <select name="selectno" size="1">
		    <option value="" selected>空报案号</option>
		<%	if (info!=null)
			{
				for(i=t1;i<t2;i++)
				{
					String aaa=Objects.getValue(i,"c_rpt_no",info)+"-"
						+Objects.getValue(i,"c_ply_no",info)+"-"+Objects.getValue(i,"C_INSRNT_NME",info);
		%>
				<option value=<%=aaa%>><%=Objects.getValue(i,"C_RPT_NO",info)%></option>
			<%	}
			}
		%>
	           </select>
				<%	if(request.getParameter("claim")!=null)
					{	%>
                 <input type="submit" value="查看理赔进度" name="submit"  onclick="ChgAction(form1,'User_Claim_List.jsp');return true;">
				<%	}else	
					{ %>
                 <input type="submit" value="查看报案内容" name="submit">
				<%	}	%>
                </div>
            </td>
          </tr>
        </form>
    </table>
 <table width="100%">
	<tr>
		<td align="right" width="40%">
		<%if (pgno>1){%>
			<a href="Zclm_rpt_list.jsp?pgno=<%=1%>">[首页]</a>&nbsp;&nbsp;
			<a href="Zclm_rpt_list.jsp?pgno=<%=pgno-1%>">[上一页]</a>
		<%}else
		  { out.println("[首页]&nbsp;&nbsp;[上一页]");	}%>  
		</td>
		<td align="center" width="20%" valign="top">
			<p align=center>显示<%=pgno%>/<%=totalpg%></p>
		</td>
		<td align="right" width="40%">
		<%if (pgno < totalpg){%>
			<a href="Zclm_rpt_list.jsp?pgno=<%=pgno+1%>">[下一页]</a>&nbsp;&nbsp;
			<a href="Zclm_rpt_list.jsp?pgno=<%=totalpg%>">[尾页]</a>
		<%}else
		  { out.println("[下一页]&nbsp;&nbsp;[尾页]");	}%>  
		</td>
	</tr>
  </table>

	</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   
</body>
</html>


