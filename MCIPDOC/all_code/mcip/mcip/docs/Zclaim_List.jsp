<html>
<head>
<title>平安货运保险</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link REL=STYLESHEET TITLE=text TYPE=text/css href=index.css>
</head>

<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0">

<%@ include file="public/Public.jsp" %>

<SCRIPT LANGUAGE="JavaScript" SRC="tool.js"></SCRIPT>
<table width="778" border="0" cellspacing="0" cellpadding="0" height="279">
  <tr>

<%@ include file="public/PublicMemLeft.jsp" %> 
    <td width="613" height="288" valign="top"> <br>
      <img src="images/m_inq4.gif" width="150" height="31" alt="报案查询">

<jsp:useBean id="obj"  scope="page" class="beans.ZPolicyInfoBean"/>
<% 
	int i=0;
	String userid=null;
	String checkcase=null;
	String checkclaim=null;
	String checkdate=null;
	String C_RPT_NO="";
	String from_tm="";
	String to_tm="";
	String[] formpara=new String[6];
	String[][] info0=null;
	String[][] info1=null;
	String aaa="";	//temp  string 
	
	
	//========== begin process  ============
	for(i=0;i<6;i++)
		formpara[i]="";
		
	if( (request.getParameter("submit")).equals("查询") )	//come from Zfind_Claim.jsp
	{
		formpara[0]=request.getParameter("userid");
		checkcase = request.getParameter("checkcase");       
   	if(checkcase != null)
   		formpara[1]=request.getParameter("C_RPT_NO");
		checkclaim = request.getParameter("checkclaim");       
   	if(checkclaim != null)
   		formpara[2]=request.getParameter("C_CLM_NO");
		checkdate = request.getParameter("checkdate");       
   	if(checkdate != null)
   	{
			formpara[3]=request.getParameter("from_year")+"-"+
				request.getParameter("from_month")+"-"+request.getParameter("from_day");
			formpara[4]=request.getParameter("to_year")+"-"+
				request.getParameter("to_month")+"-"+request.getParameter("to_day");
		}
		formpara[5]="0";

	  try
	  {
		obj.setFormPara(ZConst.GET_CLAIMLIST,formpara);
	  }
     catch(NormalException e)
     {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
     }  // end try
		info0=obj.getRetValueArra();

		formpara[5]="1";
	  try
	  {
		obj.setFormPara(ZConst.GET_CLAIMLIST,formpara);
	  }
     catch(NormalException e)
     {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
     }  // end try
		info1=obj.getRetValueArra();
	}
	else	//come from find_rpt
	{
		formpara[0]=request.getParameter("selectcase");
	  try
	  {
		formpara[1]="0";
		obj.setFormPara(ZConst.GET_CASECLMLIST,formpara);
		info0=obj.getRetValueArra();
	  }
     catch(NormalException e)
     {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
     }  // end try
	  try
	  {
		formpara[1]="1";
		obj.setFormPara(ZConst.GET_CASECLMLIST,formpara);
		info1=obj.getRetValueArra();
	  }
     catch(NormalException e)
     {
		if(NormalExceptionHandler.IsSevere(e))
 	    throw NormalExceptionHandler.Handle(e);
     }  // end try,catch
	}	//end if submit
%>



<form name="EntAnswerForm" method="POST" action="User_Claim_List.jsp">
 <div align="center"> </div>
  <p><font color="#F19CD1"><em><a name="Claiming">未决赔案列表</a></em></font> &nbsp;&nbsp;&nbsp;&nbsp;<a href="#Claimed">已决赔案列表</a></p>
  <p>&nbsp;</p>
  <table border="0" width="98%" bgcolor="#F7F7F7" align="center" height="158">
    <tr bgcolor="#F5F5F5"> 
      <td  bgcolor="#F5F5F5" height=20 width="136"> 
        <div align="center"><font size="2">赔案号</font></div>
      </td>
      <td   bgcolor="#F5F5F5" height=20 width="135"> 
        <div align="center"><font size="2">报案号</font></div>
      </td>
      <td  bgcolor="#F5F5F5" height=20 width="130"> 
        <div align="center"><font size="2">保单号</font></div>
      </td>
      <td  bgcolor="#F5F5F5" height=20 width="105"> 
        <div align="center"><font size="2">货物名称</font></div>
      </td>
      <td  bgcolor="#F5F5F5" height=20 width="86"> 
        <div align="center"><font size="2">报案时间</font></div>
      </td>
      <td  bgcolor="#F5F5F5" height=20 width="147"> 
        <p align="center"><font size="2">估损金额</font></p>
      </td>
    </tr>
		<%	if (info0!=null)
			{
				for(i=1;i<info0.length;i++)
				{    %>
    			  <tr bgcolor="#FFFFFF">
      			<td width="13%" height="16"><a href="#NextPage" title="点击选择" onclick="selectNo(selectno1,<%=i%>);return true"><%=Objects.getValue(i,"c_clm_no",info0)%></a>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"C_RPT_NO",info0)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"c_ply_no",info0)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"c_crgo_desc",info0)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"T_RTP_TM",info0)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"N_SUM_ESTMT_AMT",info0)%>
      			          <%=Objects.getValue(i,"C_CUR_CNM",info0)%>&nbsp;</td>
    			  </tr>
      	<%	}
      	} else
      	{
      %>
          <tr bgcolor="#FFFFFF"> 
            <td valign="top" colspan="6" align="center"><font color=red>没有未决赔案信息！<font></td>
          </tr>
      <% } %>
    <tr> 
      <td valign="top" height="41" colspan="6"> 
        <div align="center"><font face="宋体" size="4"> 
          <select name="selectno1">
            <option value="" selected>空赔案号</option>
		<%	if (info0!=null)
			{
				for(i=1;i<info0.length;i++)
				{    
					aaa=Objects.getValue(i,"c_rpt_no",info0)+"-"+Objects.getValue(i,"c_clm_no",info0)
							+"-"+Objects.getValue(i,"c_ply_no",info0);
					%>
				<option value=<%=aaa%>><%=Objects.getValue(i,"C_CLM_NO",info0)%></option>
			<%	}
			}
		%>
          </select>
          <input type="submit" value="查看赔案进度信息" name="B1">
          </font></div>
      </td>
    </tr>
  </table>
</form>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p>&nbsp;</p>
  <p align="left"><a href="#Claiming">未决赔案列表</a>&nbsp;&nbsp;&nbsp;&nbsp; <font color="#F19CD1"><em><a name="Claimed">已决赔案列表</a></em></font></p>
  <p align="left">&nbsp;</p>
<form name="EntAnswerForm2" method="POST" action="User_Claim_List.jsp">
  <table border="0" width="98%" bgcolor="#F7F7F7" align="center" height="158">
    <tr> 
      <td bgcolor="#F6F6F6" height=20 width="136"> 
        <div align="center"><font size="2">赔案号</font></div>
      </td>
      <td bgcolor="#F6F6F6" height=20 width="135"> 
        <div align="center"><font size="2">报案号</font></div>
      </td>
      <td bgcolor="#F6F6F6" height=20 width="130"> 
        <div align="center"><font size="2">保单号</font></div>
      </td>
      <td bgcolor="#F6F6F6" height=20 width="105"> 
        <div align="center"><font size="2">货物名称</font></div>
      </td>
      <td bgcolor="#F6F6F6" height=20 width="86"> 
        <div align="center"><font size="2">报案时间</font></div>
      </td>
      <td bgcolor="#F6F6F6" height=20 width="147"> 
        <p align="center"><font size="2">总赔付金额</font></p>
      </td>
    </tr>
		<%	if (info1!=null)
			{
				for(i=1;i<info1.length;i++)
				{    %>
    			  <tr bgcolor="#FFFFFF">
      			<td width="13%" height="16"><a href="#NextPage" title="点击选择" onclick="selectNo(selectno2,<%=i%>);return true"><%=Objects.getValue(i,"c_clm_no",info1)%></a>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"C_RPT_NO",info1)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"c_ply_no",info1)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"c_crgo_desc",info1)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"T_RTP_TM",info1)%>&nbsp;</td>
      			<td width="13%" height="16"><%=Objects.getValue(i,"N_SUM_ESTMT_AMT",info1)%>
      			          <%=Objects.getValue(i,"C_CUR_CNM",info1)%>&nbsp;</td>
    			  </tr>
      	<%	}
      	} else
      	{
      %>
          <tr bgcolor="#FFFFFF"> 
            <td valign="top" colspan="6" align="center"><font color=red>没有已决赔案信息！<font></td>
          </tr>
      <% } %>
    <tr> 
      <td valign="top" height="41" colspan="6"> 
        <div align="center"> <font face="宋体" size="4"> 
          <select name="selectno2">
            <option value="" selected>空赔案号</option>
		<%	if (info1!=null)
			{
				for(i=1;i<info1.length;i++)
				{    
					aaa=Objects.getValue(i,"c_rpt_no",info1)+"-"+Objects.getValue(i,"c_clm_no",info1)
							+"-"+Objects.getValue(i,"c_ply_no",info1);     %>
				<option value=<%=aaa%>><%=Objects.getValue(i,"C_CLM_NO",info1)%></option>
			<%	}
			}
		%>
          </select>
          <input type="submit" value="查看赔案进度信息" name="B12">
          </font></div>
      </td>
    </tr>
  </table>
  <p>&nbsp;</p>
</form>

	</td>
  </tr>
</table>

<%@ include file="public/PublicBottom.html" %>   
 </body>
</html>


